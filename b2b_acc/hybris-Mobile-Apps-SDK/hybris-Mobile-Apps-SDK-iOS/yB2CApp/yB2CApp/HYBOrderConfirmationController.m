//
// HYBOrderConfirmationController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//


#import "HYBOrderConfirmationController.h"
#import "HYBOrderConfirmationView.h"
#import "HYBCart.h"
#import "HYBOrder.h"
#import "HYBCartItemCellView.h"
#import "HYBOrderEntry.h"
#import "HYBProduct.h"
#import "HYBAddress.h"
#import "HYBDeliveryMode.h"
#import "UIViewController+Navigation.h"

@interface HYBOrderConfirmationController ()
@property(nonatomic, strong) HYBOrderConfirmationView *mainView;
@property(nonatomic, strong) HYBOrder *order;
@property(nonatomic, strong) NSArray *cartItems;
@end


@implementation HYBOrderConfirmationController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService andOrder:(HYBOrder *)order {
    if (self = [super initWithBackEndService:backendService]) {
        self.order = order;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) _mainView = [HYBOrderConfirmationView new];

    self.view = _mainView;
    
    [self.navigationItem setHidesBackButton:YES];
    
    _currentCart = [self.backendService currentCartFromCache];
    _cartItems = self.currentCart.entries;
    
    //table setup
    
    _mainView.itemsTable.accessibilityIdentifier = @"ACCESS_CART_ITEMS";
    
    [_mainView.itemsTable registerClass:[HYBCartItemCellView class] forCellReuseIdentifier:SIMPLE_CART_ITEM_CELL_ID];
    
    _mainView.itemsTable.delegate = self;
    _mainView.itemsTable.dataSource = self;
    
    //buttons interactions
    [_mainView.continueShoppingButton addTarget:self action:@selector(continueShopping) forControlEvents:UIControlEventTouchUpInside];

    _mainView.continueShoppingButton.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_CONTINUE_BUTTON";
    
    [_mainView.orderNumberLinkLabel setText:self.order.code];

    _mainView.orderNumberLinkLabel.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_REVIEW_LINK";
    
    _mainView.orderNumberLinkLabel.userInteractionEnabled = YES;
    UITapGestureRecognizer *tapLinkRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(openOrderLink)];
    tapLinkRecognizer.numberOfTapsRequired = 1;
    [_mainView.orderNumberLinkLabel addGestureRecognizer:tapLinkRecognizer];

    [_mainView.emailDetailsLabel setText:[self currentEmailDetails]];
    _mainView.emailDetailsLabel.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_EMAIL_COPY_TEXT";


    [_mainView.deliveryAddressValue setText:self.order.deliveryAddress.formattedAddress];
    [_mainView.deliveryMethodValue  setText:self.order.deliveryMode.name];
    
    
    //order summary
    if(_mainView.orderSummaryView) {
        
        if ([_currentCart.entries hyb_isNotBlank]) {
            [_mainView.orderSummaryView.itemCount setText:NSLocalizedString(@"cart_label_your_cart_is_empty", nil)];
        } else {
            NSString *totalLabel = [NSString stringWithFormat:NSLocalizedString(@"xx_items", nil), self.currentCart.totalUnitCount];
            [_mainView.orderSummaryView.itemCount setText:totalLabel];
        }
        
        [_mainView.orderSummaryView.subtotalValue setText:_currentCart.subTotal.formattedValue];
        [_mainView.orderSummaryView.taxValue setText:_currentCart.totalTax.formattedValue];
        
        [_mainView.orderSummaryView.shippingValue setText:_order.deliveryMode.deliveryCost.formattedValue];
        
        [_mainView.orderSummaryView.orderTotalValue setText:_currentCart.totalPrice.formattedValue];
        
        if (_currentCart.orderDiscounts.value > 0) {
            [_mainView.orderSummaryView.savingsValue setText:_currentCart.orderDiscounts.formattedValue];
            
            HYBPromotionResult *promo = [[self.currentCart appliedOrderPromotions] firstObject];
            if([promo hyb_isNotBlank]) {
                _mainView.orderSummaryView.savingsRecapTitle.text = promo.descriptor;
            }
            
            [_mainView.orderSummaryView hideSavings:NO];
        } else {
            [_mainView.orderSummaryView hideSavings:YES];
        }
    }
    
    DDLogDebug(@"Cart total items in confirmation are %d", _order.totalItems.intValue);
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
}

- (void)continueShopping {
    DDLogInfo(@"Continue Shopping");
    [self openCatalog];
}

- (void)openOrderLink {
    DDLogDebug(@"openOrderLink");
}

#pragma mark utilities
- (NSString *)currentEmailDetails {
    return [NSString stringWithFormat:NSLocalizedString(@"postcheckout_email_details", nil), [[self backendService] currentUserEmail]];
}

#pragma mark Cart Items Table

- (NSInteger)numberOfSectionsInTableView:(UITableView *)theTableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)theTableView numberOfRowsInSection:(NSInteger)section {
    return self.cartItems.count;
}

- (UITableViewCell *)tableView:(UITableView *)table cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSInteger currentRow = [indexPath row];
    
    __block HYBOrderEntry *item = [self.cartItems objectAtIndex:currentRow];
    HYBCartItemCellView *cell = (HYBCartItemCellView *) [table dequeueReusableCellWithIdentifier:SIMPLE_CART_ITEM_CELL_ID];
    
    cell.accessibilityIdentifier = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_CART_ITEM_CELL", (long)currentRow];
    
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    if (item) {
        
        NSString *imageUrl = item.product.thumbnailURL;
        [self.backendService loadImageByUrl:imageUrl andExecute:^(UIImage *fetchedImage, NSError *error) {
            if (error) {
                DDLogError(@"Can not retrieve image for url: %@ reason: %@", imageUrl, [error localizedDescription]);
            } else {
                [cell loadWithItem:item withProductImage:fetchedImage];
               
                cell.itemsInputTextfield.userInteractionEnabled = NO;
                cell.itemsInputTextfield.borderStyle = UITextBorderStyleNone;
                
                [cell setNeedsLayout];
                
                //access tags
                cell.productNameLabel.accessibilityIdentifier    = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_TITLE_%ld", (long)currentRow];
                cell.productPriceLabel.accessibilityIdentifier   = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_PRICE_%ld", (long)currentRow];
                cell.productPromoLabel.accessibilityIdentifier   = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_PROMO_%ld", (long)currentRow];
                cell.totalPriceLabel.accessibilityIdentifier     = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_TOTAL_PRICE_%ld", (long)currentRow];
                cell.itemsInputTextfield.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_QTY_%ld", (long)currentRow];
                cell.productImage.accessibilityIdentifier        = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_IMAGE_%ld", (long)currentRow];
            }
        }];
        
    }
    return cell;
}

- (void)tableView:(UITableView *)theTableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBOrderEntry *item = [self.cartItems objectAtIndex:indexPath.row];
    
    [self.backendService getProductForCode:item.product.code
                           andExecute:^(HYBProduct *product, NSError *error) {
                               [self pushDetailControllerWithProduct:product toggleDrawer:NO];
                           }];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBOrderEntry *item = (HYBOrderEntry*)[self.cartItems objectAtIndex:indexPath.row];
    if (item.discountMessage) return 100;

    return 75.0;
}

#pragma mark search delegate

- (void)performSearchForString:(NSString *)searchString {
    [super performSearchForString:searchString];
}
/*
 - (void)searchbar:(HYBSearchbar*)searchbar didUpdateSearchBarFrameAnimated:(BOOL)animated {
 [super searchbar:searchbar didUpdateSearchBarFrameAnimated:YES];
 }
 
 - (void)searchbar:(HYBSearchbar*)searchbar didTapDidYouMeanWithQuery:(NSString*)query {
 [super searchbar:searchbar didTapDidYouMeanWithQuery:query];
 }
 */
@end
