//
// HYBCartController.m
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

#import <CocoaLumberjack/DDLog.h>
#import <MMDrawerController/MMDrawerController.h>
#import <MMDrawerController/UIViewController+MMDrawerController.h>
#import "HYBCartController.h"
#import "HYBCatalogController.h"
#import "HYBB2BService.h"
#import "HYBCartView.h"
#import "HYBCart.h"
#import "UIViewController+Navigation.h"
#import "HYBConstants.h"
#import "HYBCartItemCellView.h"
#import "HYBOrderEntry.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBActivityIndicator.h"

#define TAG_ONE_ITEM_DELETION   12239658
#define TAG_MANY_ITEMS_DELETION 12239659


@interface HYBCartController ()
@property(nonatomic, strong)  HYBCart      *currentCart;
@property(nonatomic, strong)  NSArray      *cartItems;
@property(nonatomic, strong)  NSArray      *deletingItems;
@property(nonatomic, strong)  HYBCartView  *mainView;

@property(nonatomic) NSInteger currentlyEditedCartItemPosition;
@end

@implementation HYBCartController



- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!self.mainView) {
        _mainView = [HYBCartView new];
        _mainView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    }
    
    self.view = _mainView;
    
    [self refreshCartFromServer];
    
    [self registerForCartChangeNotifications:@selector(loadCurrentCart)
                                senderObject:self.b2bService];
    
    [_mainView.continueShoppingButton addTarget:self
                                         action:@selector(continueShoppingButtonPressed)
                               forControlEvents:UIControlEventTouchUpInside];
    
    
    [_mainView.checkoutButton addTarget:self
                                 action:@selector(checkoutButtonPressed)
                       forControlEvents:UIControlEventTouchUpInside];
    
    
    _mainView.itemsTable.accessibilityIdentifier = @"ACCESS_CART_ITEMS";
    [_mainView.itemsTable registerClass:[HYBCartItemCellView class] forCellReuseIdentifier:SIMPLE_CART_ITEM_CELL_ID];
    
    _mainView.itemsTable.delegate = self;
    _mainView.itemsTable.dataSource = self;
    
    _mainView.itemsTable.allowsMultipleSelection = NO;
    
    //keyboard monitor
    NSNotificationCenter *center = [NSNotificationCenter defaultCenter];
    
    [center addObserver:self selector:@selector(keyboardDidShow:)
                   name:UIKeyboardDidShowNotification
                 object:nil];
    
    [center addObserver:self selector:@selector(keyboardDidHide:)
                   name:UIKeyboardWillHideNotification
                 object:nil];
    
    //batch delete interactions
    [self hideBatchDeletePanel];
    
    
    [_mainView.batchToggleButton addTarget:self
                                    action:@selector(toggleBatchDeletePanel)
                          forControlEvents:UIControlEventTouchUpInside];
    
    [_mainView.batchSelectButton addTarget:self
                                    action:@selector(toggleBatchSelect)
                          forControlEvents:UIControlEventTouchUpInside];
    [_mainView.batchDeleteButton addTarget:self
                                    action:@selector(batchDelete)
                          forControlEvents:UIControlEventTouchUpInside];
    
    
    [self refreshSelected];
    
    
    [_mainView hideCart:YES];
}

- (void)toggleBatchDeletePanel {
    if (self.isBatchDeleting) return;
    
    if (self.mainView.tableFooterView.hidden == YES) {
        [self showBatchDeletePanel];
    } else {
        [self hideBatchDeletePanel];
    }
}

- (void)toggleBatchSelect {
    if ([[self.mainView.itemsTable indexPathsForSelectedRows] count] == 0) {
        [self setAllRowsSelected:YES];
    } else {
        [self setAllRowsSelected:NO];
    }
}

- (void)setAllRowsSelected:(BOOL)selected {
    for (NSInteger s = 0; s < self.mainView.itemsTable.numberOfSections; s++) {
        for (NSInteger r = 0; r < [self.mainView.itemsTable numberOfRowsInSection:s]; r++) {
            NSIndexPath *indexPath = [NSIndexPath indexPathForRow:r inSection:s];
            if (selected) {
                [self.mainView.itemsTable selectRowAtIndexPath:indexPath
                                                      animated:NO
                                                scrollPosition:UITableViewScrollPositionNone];
            } else {
                [self.mainView.itemsTable deselectRowAtIndexPath:indexPath
                                                        animated:NO];
            }
        }
    }
    [self refreshSelected];
}

- (void)showBatchDeletePanel {
    [self.mainView.itemsTable setEditing:NO animated:NO];
    _mainView.itemsTable.allowsMultipleSelectionDuringEditing = YES;
    self.allRowsSelected = NO;
    _mainView.batchDeleteButton.hidden = YES;
    _mainView.tableFooterView.hidden = NO;
    _mainView.tableFooterView.alpha = 0.f;
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _mainView.tableFooterView.alpha = 1.f;
                     }];
    
    [_mainView.batchToggleButton setTitle:NSLocalizedString(@"batch_toggle_button_cancel", nil)
                                 forState:UIControlStateNormal];
    
    [self.mainView.itemsTable setEditing:YES animated:YES];
}

- (void)hideBatchDeletePanel {
    self.allRowsSelected = NO;
    [self refreshSelected];
    _mainView.itemsTable.allowsMultipleSelectionDuringEditing = NO;
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _mainView.tableFooterView.alpha = 0.f;
                     }
                     completion:^(BOOL done) {
                         [self.mainView.tableFooterView setHidden:YES];
                     }
     ];
    
    [_mainView.batchToggleButton setTitle:NSLocalizedString(@"batch_toggle_button_edit", nil)
                                 forState:UIControlStateNormal];
    
    [self.mainView.itemsTable setEditing:NO animated:YES];
}

- (void)refreshSelected {
    
    if([[self.mainView.itemsTable indexPathsForSelectedRows] count] == 0) {
        _mainView.batchDeleteButton.hidden = YES;
        [_mainView.batchSelectButton setTitle:NSLocalizedString(@"batch_select_all_button", nil)
                                     forState:UIControlStateNormal];
    } else {
        _mainView.batchDeleteButton.hidden = NO;
        [_mainView.batchSelectButton setTitle:NSLocalizedString(@"batch_deselect_all_button", nil)
                                     forState:UIControlStateNormal];
    }
}

#pragma mark batch deletion loop
- (void)checkForBatchDeleteEnd {
    NSMutableArray *tempArray = [NSMutableArray arrayWithArray:self.deletingItems];
    [tempArray removeLastObject];
    
    if([tempArray count] > 0) {
        //continue delete loop
        [self setDeletingItems:[NSArray arrayWithArray:tempArray]];
        [self deleteNextItem];
    } else {
        //no more item to delete, end loop
        [self setDeletingItems:[NSArray array]];
        [self batchDeleteDidEnd];
    }
}

- (void)deleteNextItem {
    [self deleteItemAtIndex:[self.deletingItems lastObject]];
}

- (void)batchDeleteDidEnd {
    [HYBActivityIndicator hide];
    
    [self showNotifyMessage:NSLocalizedString(@"cart_item_removal_items_removed", @"Items Removed!")];
    [self refreshCartFromServer];
    
    self.isBatchDeleting = NO;
}

- (void)deleteItemAtIndex:(NSIndexPath*)indexPath {
    [self.b2bService updateProductOnCurrentCartAmount:[NSString stringWithFormat:@"%ld", (long)indexPath.row]
                                                mount:@0
                                           andExecute:^(HYBCart *cart, NSError *error) {
                                               
                                               [self checkForBatchDeleteEnd];
                                               
                                           }];
}

- (void)startBatchDeleteLoop {
    self.isBatchDeleting = YES;
    
    [HYBActivityIndicator show];
    
    NSSortDescriptor *rowDescriptor = [[NSSortDescriptor alloc] initWithKey:@"row" ascending:YES];
    NSArray *sortedRows = [self.deletingItems sortedArrayUsingDescriptors:@[rowDescriptor]];
    [self setDeletingItems:[NSArray arrayWithArray:sortedRows]];
    
    self.currentlyEditedCartItemPosition = -1;
    [self deleteNextItem];
}

- (void)batchDelete {
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"cart_items_batch_removal_title", @"")
                                                    message:NSLocalizedString(@"cart_items_batch_removal_message", @"")
                                                   delegate:self
                                          cancelButtonTitle:NSLocalizedString(@"No", @"No")
                                          otherButtonTitles:NSLocalizedString(@"cart_item_removal_popup_yes", @"Yes, I am sure"), nil];
    [alert setTag:TAG_MANY_ITEMS_DELETION];
    [alert show];
}

- (void)doBatchDelete {
    //save items to delete in another array, selected items array is wiped when the UI exits multi selection mode
    [self setDeletingItems:[NSArray arrayWithArray:[self.mainView.itemsTable indexPathsForSelectedRows]]];
    
    [self startBatchDeleteLoop];
    
    //Exit editing mode after the deletion.
    [self hideBatchDeletePanel];
}

#pragma mark vc life

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    
    //Exit editing mode
    [self hideBatchDeletePanel];
}

- (void)viewWillDisappear:(BOOL)animated {
    [super viewWillDisappear:animated];
    if (self.view.findFirstResponder) [self.view.findFirstResponder resignFirstResponder];
}

- (void)checkoutButtonPressed {
    [self openCheckout];
}

- (void)continueShoppingButtonPressed {
    [self openCatalogWithCompletion:^(id controller) {
        NSString *lastShownCatId = [[self.b2bService userStorage] objectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
        if(lastShownCatId) {
            [(HYBCatalogController*)controller loadBaseProductsByCategoryId:lastShownCatId];
        }
        [self toggleRightDrawerAnimated:YES];
    }];
}

- (void)refreshCartFromServer {
    [self.b2bService retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
        [self setCurrentCart:cart];
        [self loadCurrentCart];
    }];
}

- (void)loadCurrentCart {
    
    HYBCart *cart = [self.b2bService currentCartFromCache];
    
    if (cart) {
        
        _cartItems = cart.entries;
        
        [_mainView.itemsTable reloadData];
        
        if ([_cartItems count] <= 0) {
            [_mainView setCartToEmpty];
            [_mainView hideCart:YES];
        } else {
            
            NSString *totalLabel = [NSString stringWithFormat:NSLocalizedString(@"cart_label_total_items", nil), cart.totalUnitCount];
            [self.mainView.cartTotalNumber setText:totalLabel];
            
            [self.mainView.subTotalNumber setText:cart.subTotal.formattedValue];
            [self.mainView.taxNumber setText:cart.totalTax.formattedValue];
            
            [_mainView setCartToNotEmpty];
            [_mainView hideCart:NO];
            
            if([cart.deliveryCost hyb_isNotBlank]) {
                [self.mainView.shippingLabel setHidden:NO];
                [self.mainView.shippingNumber setHidden:NO];
                [self.mainView.shippingNumber setText:cart.deliveryCost.formattedValue];
            } else {
                [self.mainView.shippingLabel setHidden:YES];
                [self.mainView.shippingNumber setHidden:YES];
            }
            
            [self.mainView.cartTotalNumber setText:cart.totalPrice.formattedValue];
            
            if (cart.orderDiscounts.value > 0) {
                [self.mainView.savingsNumber setText:cart.orderDiscounts.formattedValue];
                
                [self.mainView.discountsMessage setHidden:NO];
                
                HYBPromotionResult *promo = [cart.appliedOrderPromotions firstObject];
                if([promo hyb_isNotBlank]) {
                    NSString *orderDiscountsMessage = [promo descriptor];
                    [self.mainView.discountsMessage setText:orderDiscountsMessage];
                }
                
                [self.mainView.savingsNumber setHidden:NO];
                [self.mainView.savingsLabel setHidden:NO];
            } else {
                [self.mainView.discountsMessage setHidden:YES];
                [self.mainView.savingsLabel setHidden:YES];
                [self.mainView.savingsNumber setHidden:YES];
            }
            
            [_mainView layoutSubviews];
        }
    } else {
        DDLogDebug(@"No cart is present in the user cache, a cart should have been created at the login.");
    }
}



- (CGFloat)calculateDrawerWidth {
    return [[UIScreen mainScreen] bounds].size.width * 0.8;
}

#pragma mark Cart Items Table

- (NSInteger)numberOfSectionsInTableView:(UITableView *)theTableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)theTableView numberOfRowsInSection:(NSInteger)section {
    return self.cartItems.count;
}

#pragma mark --> cellForRowAtIndexPath

- (UITableViewCell *)tableView:(UITableView *)table cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSInteger currentRow = [indexPath row];
    
    __block HYBOrderEntry *item = [self.cartItems objectAtIndex:currentRow];
    HYBCartItemCellView *cell = (HYBCartItemCellView *) [table dequeueReusableCellWithIdentifier:SIMPLE_CART_ITEM_CELL_ID];
    
    cell.accessibilityIdentifier = [NSString stringWithFormat:@"%@_%ld", @"ACCESS_CART_ITEM_CELL", (long)currentRow];
    
    if (item) {
        
        NSString *imageUrl = item.product.thumbnailURL;
        [self.b2bService loadImageByUrl:imageUrl andExecute:^(UIImage *fetchedImage, NSError *error) {
            if (error) {
                DDLogError(@"Can not retrieve image for url: %@ reason: %@", imageUrl, [error localizedDescription]);
            }
                        
            [cell loadWithItem:item withProductImage:fetchedImage];
            
            if (!table.editing) {
                [cell.itemsInputTextfield setDelegate:self];
                cell.itemsInputTextfield.tag = currentRow;
                
                UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                                action:@selector(productCellTapped:)];
                tapRecognizer.numberOfTapsRequired = 1;
                [cell.productDetailsTapArea addGestureRecognizer:tapRecognizer];
                cell.productDetailsTapArea.tag = currentRow;
            }
            
            [cell setNeedsLayout];
            
            //access tags
            cell.productNameLabel.accessibilityIdentifier    = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_TITLE_%ld", (long)currentRow];
            cell.productPriceLabel.accessibilityIdentifier   = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_PRICE_%ld", (long)currentRow];
            cell.productPromoLabel.accessibilityIdentifier   = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_PROMO_%ld", (long)currentRow];
            cell.totalPriceLabel.accessibilityIdentifier     = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_TOTAL_PRICE_%ld", (long)currentRow];
            cell.itemsInputTextfield.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_QTY_%ld", (long)currentRow];
            cell.productImage.accessibilityIdentifier        = [NSString stringWithFormat:@"ACCESS_CART_ITEM_PRODUCT_IMAGE_%ld", (long)currentRow];
            
        }];
    }
    
    return cell;
}

- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    if (self.isBatchDeleting) return NO;
    return YES;
}

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        self.currentlyEditedCartItemPosition = indexPath.row;
        [self deleteCurrentlyEditedItem];
    }
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBOrderEntry *item = (HYBOrderEntry*)[self.cartItems objectAtIndex:indexPath.row];
    if (item.discountMessage) return 100;
    
    return 75.0;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (self.mainView.itemsTable.editing) {
        [self refreshSelected];
    }
    
}

- (void)tableView:(UITableView *)tableView didDeselectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (self.mainView.itemsTable.editing) {
        [self refreshSelected];
    }
}

#pragma mark multiple selection helpers

- (void)productCellTapped:(UITapGestureRecognizer *)tapRecognizer {
    
    NSInteger taggedRow = tapRecognizer.view.tag;
    
    if (!self.mainView.itemsTable.editing) {
        HYBCartItemCellView *cell =  (HYBCartItemCellView *)[self.mainView.itemsTable cellForRowAtIndexPath:[NSIndexPath indexPathForRow:taggedRow inSection:0]];
        
        NSAssert([cell hyb_isNotBlank], @"Cell was not found, it seems like the sender for this IBAction is not having a proper superview");
        
        [self.b2bService getProductForCode:cell.productCode andExecute:^(HYBProduct *product, NSError *error) {
            [self pushDetailControllerWithProduct:product toggleDrawer:YES];
        }];
    }
}

- (void)itemsQuantityChanged:(UITextField*)sender {
    
    NSInteger taggedRow = sender.tag;
    HYBCartItemCellView *cell =  (HYBCartItemCellView *)[self.mainView.itemsTable cellForRowAtIndexPath:[NSIndexPath indexPathForRow:taggedRow inSection:0]];
    
    NSAssert([cell hyb_isNotBlank], @"Cell was not found, it seems like the sender for this IBAction is not having a proper superview");
    
    self.currentlyEditedCartItemPosition = [cell.cartItemPosition integerValue];
    
    NSNumber *amount = [[[NSNumberFormatter alloc] init] numberFromString:cell.itemsInputTextfield.text];
    if (amount.intValue == 0) {
        // starting the dialog for deletion, take a look at the UIAlertViewDelegate methods
        [self showAlertViewForItemDeletion];
    } else {
        if (amount) {
            [self.b2bService updateProductOnCurrentCartAmount:[NSString stringWithFormat:@"%ld", (long) self.currentlyEditedCartItemPosition] mount:amount andExecute:^(HYBCart *cart, NSError *error) {
                DDLogDebug(@"Product on cart was updated.");
                self.currentlyEditedCartItemPosition = -1;
            }];
        }
    }
}

#pragma mark alert for item deletion and its delegate

- (void)showAlertViewForItemDeletion {
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"cart_item_removal_popup_title", @"Item Removal")
                                                    message:NSLocalizedString(@"cart_item_removal_popup_message", @"Are you sure you would like to remove this item from the cart?")
                                                   delegate:self
                                          cancelButtonTitle:NSLocalizedString(@"No", @"No")
                                          otherButtonTitles:NSLocalizedString(@"cart_item_removal_popup_yes", @"Yes, I am sure"), nil];
    [alert setTag:TAG_ONE_ITEM_DELETION];
    [alert show];
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex {
    
    if ([alertView tag] == TAG_ONE_ITEM_DELETION) {
        if (buttonIndex == 0) {
            DDLogDebug(@"Item Deletion Cancelled");
            HYBOrderEntry *item = [self.cartItems objectAtIndex:self.currentlyEditedCartItemPosition];
            NSIndexPath *path = [NSIndexPath indexPathForRow:self.currentlyEditedCartItemPosition inSection:0];
            HYBCartItemCellView *cell = (HYBCartItemCellView *) [self.mainView.itemsTable cellForRowAtIndexPath:path];
            [cell.itemsInputTextfield setText:[item.quantity stringValue]];
        } else {
            DDLogDebug(@"Item Deletion Confirmed");
            [self deleteCurrentlyEditedItem];
        }
    } else if ([alertView tag] == TAG_MANY_ITEMS_DELETION) {
        if (buttonIndex != [alertView cancelButtonIndex]) {
            [self doBatchDelete];
        }
    }
}

- (void)deleteCurrentlyEditedItem {
    [self.b2bService updateProductOnCurrentCartAmount:[NSString stringWithFormat:@"%ld", (long) self.currentlyEditedCartItemPosition] mount:@0 andExecute:^(HYBCart *cart,  NSError *error) {
        DDLogDebug(@"Product on cart was updated.");
        self.currentlyEditedCartItemPosition = -1;
        [self showNotifyMessage:NSLocalizedString(@"cart_item_removal_item_removed", @"Item Removed!")];
        [self setCurrentCart:cart];
        [self loadCurrentCart];
    }];
}

- (void)alertViewCancel:(UIAlertView *)alertView {
    DDLogDebug(@"Item Deletion Cancelled");
    HYBOrderEntry *item = [self.cartItems objectAtIndex:self.currentlyEditedCartItemPosition];
    HYBCartItemCellView *cell = (HYBCartItemCellView *) [self.mainView.itemsTable cellForRowAtIndexPath:[NSIndexPath indexPathForRow:self.currentlyEditedCartItemPosition inSection:0]];
    [cell.itemsInputTextfield setText:[item.quantity stringValue]];
}


#pragma mark textfield delegate

- (BOOL)textFieldShouldBeginEditing:(UITextField *)textField {
    if (self.mainView.itemsTable.editing) return NO;
    if (self.isBatchDeleting) return NO;
    
    self.validAmount = NO;
    
    _firstResponderOriginalValue = textField.text;
    
    return YES;
}

- (void)textFieldDidEndEditing:(UITextField *)textField {
    if (self.validAmount) [self itemsQuantityChanged:textField];
    else textField.text = _firstResponderOriginalValue;
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    self.validAmount = YES;
    [textField resignFirstResponder];
    return NO;
}

#pragma search delegate

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