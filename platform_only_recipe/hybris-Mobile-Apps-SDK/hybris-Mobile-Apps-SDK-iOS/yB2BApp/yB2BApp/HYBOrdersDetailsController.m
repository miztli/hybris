//
// HYBOrdersDetailsController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//


#import "HYBOrdersDetailsController.h"
#import "HYBOrdersDetailsView.h"
#import "HYBCart.h"
#import "HYBOrder.h"
#import "HYBCartItemCellView.h"
#import "HYBOrderEntry.h"
#import "HYBProduct.h"
#import "HYBAddress.h"
#import "HYBDeliveryMode.h"
#import "UIViewController+Navigation.h"

@interface HYBOrdersDetailsController ()

@property (nonatomic) HYBOrdersDetailsView *mainView;
@property (nonatomic) HYBOrder *order;

@end


@implementation HYBOrdersDetailsController

- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService andOrder:(HYBOrder *)order {
    if (self = [super initWithBackEndService:b2bService]) {
        _order = order;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) _mainView = [HYBOrdersDetailsView new];
    self.view = _mainView;
    
    [self.navigationItem setHidesBackButton:YES];
    
    
    //table setup
    
    _mainView.itemsTable.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_CART_ITEMS";
    [_mainView.itemsTable registerClass:[HYBCartItemCellView class] forCellReuseIdentifier:SIMPLE_CART_ITEM_CELL_ID];
    
    _mainView.itemsTable.delegate = self;
    _mainView.itemsTable.dataSource = self;
    
    [_mainView.backButton addTarget:self action:@selector(backToOrdersList) forControlEvents:UIControlEventTouchUpInside];
    
    _mainView.orderNumberLabel.text = [NSString stringWithFormat:NSLocalizedString(@"orders_details_number_format", nil), _order.code];
    
    NSString *baseDate = _order.created;
    
    NSString *shortDate = [[baseDate componentsSeparatedByString:@"T"] firstObject];
    _mainView.dateLabel.text = [NSString stringWithFormat:NSLocalizedString(@"orders_details_date_format", nil), shortDate];
    
    _mainView.orderStatusLabel.text = [NSString stringWithFormat:NSLocalizedString(@"orders_details_status_format", nil), _order.statusDisplay];
    
    _mainView.deliveryAddressValue.text = _order.deliveryAddress.formattedAddress;
    _mainView.deliveryMethodValue.text = _order.deliveryMode.name;
    
    _mainView.trackingValue.text = @"dunmmyTrackingNumber";
    
    //order summary
    if(_mainView.orderSummaryView) {
        
        //calculate total unit count on order (present in carts but not on orders records...)
        int totalCount = 0;
        
        if ([_order.entries hyb_isNotBlank]) {
            for (HYBOrderEntry *entry in _order.entries) {
                totalCount += [entry.quantity intValue];
            }
        }
        
        NSString *totalCountString = [NSString stringWithFormat:@"%d",totalCount];
        NSString *totalUnitCount = [NSString stringWithFormat:NSLocalizedString(@"xx_items", nil), totalCountString];
        _mainView.orderSummaryView.itemCount.text = totalUnitCount;
        
        _mainView.orderSummaryView.subtotalValue.text   = _order.subTotal.formattedValue;
        _mainView.orderSummaryView.taxValue.text        = _order.totalTax.formattedValue;
        _mainView.orderSummaryView.shippingValue.text   = _order.deliveryMode.deliveryCost.formattedValue;
        _mainView.orderSummaryView.orderTotalValue.text = _order.totalPrice.formattedValue;
        
        if (_order.orderDiscounts.value > 0) {
            _mainView.orderSummaryView.savingsValue.text = _order.orderDiscounts.formattedValue;
            
            HYBPromotionResult *promo = [_order.appliedOrderPromotions firstObject];
            if([promo hyb_isNotBlank]) {
                _mainView.orderSummaryView.savingsRecapTitle.text = promo.descriptor;
            }
            
            [_mainView.orderSummaryView hideSavings:NO];
        } else {
            [_mainView.orderSummaryView hideSavings:YES];
        }
    }
    
    [_mainView.itemsTable reloadData];
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
}

- (void)backToOrdersList {
    [[(HYBViewController *)[self currentCenterController] navigationController] popViewControllerAnimated:YES];
}

#pragma mark Cart Items Table

- (NSInteger)numberOfSectionsInTableView:(UITableView *)theTableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)theTableView numberOfRowsInSection:(NSInteger)section {
    return [_order.entries count];
}

- (UITableViewCell *)tableView:(UITableView *)table cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSInteger currentRow = [indexPath row];
    
    HYBCartItemCellView *cell = (HYBCartItemCellView *) [table dequeueReusableCellWithIdentifier:SIMPLE_CART_ITEM_CELL_ID];
    
    cell.accessibilityIdentifier = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_ORDER_DETAILS_ITEM_CELL", (long)currentRow];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    __block HYBOrderEntry *item = _order.entries[currentRow];
    
    if (item) {
        
        NSString *imageUrl = item.product.thumbnailURL;
        
        [self.b2bService loadImageByUrl:imageUrl andExecute:^(UIImage *fetchedImage, NSError *error) {
            if (error) {
                DDLogError(@"Can not retrieve image for url: %@ reason: %@", imageUrl, [error localizedDescription]);
                fetchedImage = nil;
            }
            
            [cell loadWithItem:item withProductImage:fetchedImage];
            
            cell.itemsInputTextfield.userInteractionEnabled = NO;
            cell.itemsInputTextfield.borderStyle = UITextBorderStyleNone;
            
            [cell setNeedsLayout];
            
            //access tags
            cell.productNameLabel.accessibilityIdentifier    = [NSString stringWithFormat:@"ACCESS_ORDER_DETAILS_PRODUCT_TITLE_%ld",        (long)currentRow];
            cell.productPriceLabel.accessibilityIdentifier   = [NSString stringWithFormat:@"ACCESS_ORDER_DETAILS_PRODUCT_PRICE_%ld",        (long)currentRow];
            cell.productPromoLabel.accessibilityIdentifier   = [NSString stringWithFormat:@"ACCESS_ORDER_DETAILS_PRODUCT_PROMO_%ld",        (long)currentRow];
            cell.totalPriceLabel.accessibilityIdentifier     = [NSString stringWithFormat:@"ACCESS_ORDER_DETAILS_PRODUCT_TOTAL_PRICE_%ld",  (long)currentRow];
            cell.itemsInputTextfield.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_ORDER_DETAILS_PRODUCT_QTY_%ld",          (long)currentRow];
            cell.productImage.accessibilityIdentifier        = [NSString stringWithFormat:@"ACCESS_ORDER_DETAILS_PRODUCT_IMAGE_%ld",        (long)currentRow];
        }];
        
    }
    
    return cell;
}

- (void)tableView:(UITableView *)theTableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    HYBOrderEntry *item = (HYBOrderEntry*)_order.entries[indexPath.row];
    
    //OCC bug here, not returning correct product code, solution : grab it from url component
    NSString *productCode = [item.product.url lastPathComponent];
    if(!productCode) productCode = item.product.code;
    
    [self.b2bService getProductForCode:productCode
                           andExecute:^(HYBProduct *product, NSError *error) {
                               [self pushDetailControllerWithProduct:product toggleDrawer:NO];
                           }];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBOrderEntry *item = (HYBOrderEntry*)_order.entries[indexPath.row];
    if (item.discountMessage) return 100;
    
    return 75.0;
}


#pragma mark search + searchbar delegate

- (void)performSearchForString:(NSString *)searchString {
    DDLogDebug(@"search %@ in Store Locator controller",searchString);
    
    if (searchString && searchString.length > 0) {
        if(self) {
            self.currentSearchQuery = [searchString copy];
        }
        
        [self doPerformSearch];
    }
}


- (void)doPerformSearch {
    DDLogDebug(@"Searching for order numbers %@ ...", self.currentSearchQuery);
    
    [HYBActivityIndicator show];
    
    [self.b2bService findOrderByCode:self.currentSearchQuery andExecute:^(HYBOrder *order, NSError *error) {
        
        [HYBActivityIndicator hide];
        
        if (error) {
            DDLogError(@"Problems during the retrieval of the order from the web service: %@", [error localizedDescription]);
            
            DDLogError(@"no order found");
            [self alertNotFound];
            
        } else {
            
            if (order) {
                [self openOrderAndDebounce:order];
            } else {
                DDLogError(@"no order found");
                [self alertNotFound];
                
            }
        }
    }];
}

- (void)alertNotFound {
    
    dispatch_async(dispatch_get_main_queue(), ^() {
        
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"order_not_found_title", @"")
                                                        message:NSLocalizedString(@"order_not_found_message", @"")
                                                       delegate:self
                                              cancelButtonTitle:NSLocalizedString(@"Ok", @"Ok")
                                              otherButtonTitles:nil];
        [alert show];
    });
}

- (void)openOrderAndDebounce:(HYBOrder *)order {
    
    //open new controller
    HYBOrdersDetailsController *ordersDetailsController = [[HYBOrdersDetailsController alloc] initWithBackEndService:self.b2bService andOrder:order];
    
    //debounce info comming from cache
    //push only one detailcontroller
    [self pushOrSwapTopCenterViewControllerTo:ordersDetailsController animated:YES];
    
}

@end
