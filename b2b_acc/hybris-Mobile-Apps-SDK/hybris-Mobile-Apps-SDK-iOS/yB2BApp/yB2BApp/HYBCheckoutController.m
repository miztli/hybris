//
// HYBCheckoutController.m
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

#import "HYBCheckoutController.h"
#import "HYBCheckoutView.h"
#import "HYBCart.h"
#import "HYBWebviewController.h"
#import "HYBCostCenter.h"
#import "HYBAddress.h"
#import "HYBDeliveryMode.h"
#import "UIColor+Expanded.h"
#import "HYBOrder.h"
#import "HYBActivityIndicator.h"
#import "HYBConstants.h"

#import "stylesheet.h"

@interface HYBCheckoutController ()



@property(nonatomic) NSArray         *costCenters;
@property(nonatomic) NSArray         *deliveryAddresses;
@property(nonatomic) NSArray         *deliveryModes;

@property(nonatomic) HYBCart         *currentCart;
@property(nonatomic) HYBCostCenter   *selectedCostCenter;

@property(nonatomic) HYBDeliveryMode *mode;

@property(nonatomic) UILabel         *cancelPickerLabel;
@property(nonatomic) BOOL            cartSelectionsLoaded;

@end

@implementation HYBCheckoutController

@synthesize optionsArray, mainPickerView;

- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService {
    
    if (self = [super initWithBackEndService:b2bService]) {
        self.costCenters        = [NSArray array];
        self.deliveryAddresses  = [NSArray array];
        self.deliveryModes      = [NSArray array];
    }
    return self;
}

#pragma mark - General UI Buildup

- (void)viewDidLoad {
    [super viewDidLoad];
    
    [self setOptionsArray:[NSArray array]];
    
    if (!_mainView) _mainView = [HYBCheckoutView new];
    self.view = _mainView;
    
    // observe cart changes to react in own view
    [self registerForCartChangeNotifications:@selector(loadCurrentCart) senderObject:self.b2bService];
    
    //buttons interactions
    
    [_mainView.paymentAccount addTarget:self action:@selector(checkoutPaymentAccountTap)];
    
    _mainView.paymentAccount.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_ACCOUNT";
    
    _mainView.paymentPONumberField.delegate = self;
    
    _mainView.paymentPONumberField.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_PO_NUMBER_FIELD";
    _mainView.paymentPONumberField.accessibilityLabel = NSLocalizedString(@"payment_po_number_optional", nil);
    
    [_mainView.paymentQuestionMarkButton addTarget:self
                                                action:@selector(checkoutPaymentQuestionMarkTap)
                                      forControlEvents:UIControlEventTouchUpInside];
    
    _mainView.paymentQuestionMarkButton.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_QUESTION_BUTTON";
    
    [_mainView.costCenterButton addTarget:self
                                       action:@selector(checkoutCostCenterTap)];
    
    _mainView.costCenterButton.accessibilityIdentifier = @"ACCESS_CHECKOUT_COST_CENTER";
    
    [_mainView.deliveryAddressButton addTarget:self
                                            action:@selector(checkoutDeliveryAddressTap)];
    
    _mainView.deliveryAddressButton.accessibilityIdentifier = @"ACCESS_CHECKOUT_DELIVERY_ADDRESS";
    
    [_mainView.deliveryMethodButton addTarget:self
                                           action:@selector(checkoutDeliveryMethodTap)];
    
    _mainView.deliveryMethodButton.accessibilityIdentifier = @"ACCESS_CHECKOUT_DELIVERY_METHOD";
    
    //checkbox
    [_mainView.agreementButton setBackgroundColor:[UIColor lightGrayColor]];
    termsAndConditionsAccepted = NO;
    
    [_mainView.agreementButton addTarget:self
                                      action:@selector(checkoutAgreementCheckboxTap)
                            forControlEvents:UIControlEventTouchUpInside];
    
    
    _mainView.agreementButton.accessibilityIdentifier = @"ACCESS_CHECKOUT_AGREEMENT_CHECKBOX";
    
    [_mainView.agreementIntroLabel setUserInteractionEnabled:YES];
    
    UITapGestureRecognizer *tapIntroRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(checkoutAgreementCheckboxTap)];
    tapIntroRecognizer.numberOfTapsRequired = 1;
    tapIntroRecognizer.delegate = self;
    [_mainView.agreementIntroLabel addGestureRecognizer:tapIntroRecognizer];
    
    _mainView.agreementIntroLabel.accessibilityIdentifier = @"ACCESS_CHECKOUT_AGREEMENT_INTRO_LABEL";
    
    [_mainView.agreementLinkLabel setUserInteractionEnabled:YES];
    
    _mainView.agreementLinkLabel.accessibilityIdentifier = @"ACCESS_CHECKOUT_AGREEMENT_LINK_LABEL";
    
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(checkoutAgreementTCTap)];
    tapRecognizer.numberOfTapsRequired = 1;
    tapRecognizer.delegate = self;
    [_mainView.agreementLinkLabel addGestureRecognizer:tapRecognizer];
    
    [_mainView.orderButton
     addTarget:self
     action:@selector(orderButtonTap)
     forControlEvents:UIControlEventTouchUpInside];
    
    _mainView.orderButton.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_BUTTON";
    [_mainView.orderButton setEnabled:YES];
  
    [self loadCurrentCart];
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
    
    //prepare picker
    [self setMainPickerView:[UIPickerView new]];
    [mainPickerView setDataSource:self];
    [mainPickerView setDelegate:self];
    
    CGFloat margin = 20.f;
    
    CGRect pickerFrame = CGRectMake([mainPickerView fX], [mainPickerView fY], [_mainView bW] - margin*2, [mainPickerView bH]);
    mainPickerView.frame = pickerFrame;
    
    UITapGestureRecognizer *pickerTapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(pickerTapped)];
    [mainPickerView addGestureRecognizer:pickerTapRecognizer];
    pickerTapRecognizer.delegate = self;
    
    //mask tap dismiss pickers
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(hidePicker)];
    [_mainView.maskView addGestureRecognizer:tapRecognizer];
    
    //tap invite
    [self setCancelPickerLabel:[[UILabel alloc] init]];
    [self.cancelPickerLabel setText:NSLocalizedString(@"cancel", @"")];
    [self.cancelPickerLabel setTextAlignment:NSTextAlignmentCenter];
    [self.cancelPickerLabel sizeToFit];
    [self.cancelPickerLabel setFrame:CGRectInset(self.cancelPickerLabel.frame, -20, -10)];
    [self.cancelPickerLabel setBackgroundColor:[UIColor colorWithHexString:@"#fad712"]];
}

- (void)reloadChildDropdowns {
    
    int selectedIndex = pickersSelections[selectedPicker];
    
    switch (selectedPicker) {
        case costCenterPicker:
            [self selectCostCenterAtIndex:selectedIndex cart:self.currentCart];
            break;
            
        case deliveryAddressPicker:
            [self selectDeliveryAddressAtIndex:selectedIndex cart:self.currentCart];
            break;
            
        case deliveryMethodPicker:
            [self selectDeliveryModeAtIndex:selectedIndex cart:self.currentCart];
            break;
            
        default:
            break;
    }
    
}


#pragma mark alertview delegate

-(void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
    if (alertView.cancelButtonIndex != buttonIndex) {
        HYBWebviewController *webviewController = [[HYBWebviewController alloc] initWithLink:@"http://www.storefront.com"];
        
        self.navigationItem.backBarButtonItem.accessibilityLabel = @"ACCESS_TOPNAV_BUTTON_BACK";
        
        [self.navigationController pushViewController:webviewController animated:YES];
    }
}

#pragma mark buttons actions

- (void)checkoutPaymentAccountTap {
    DDLogDebug(@"checkoutAccountPaymentTap");
}

- (void)checkoutPaymentQuestionMarkTap {
    DDLogDebug(@"checkoutPaymentQuestionMarkTap");
    
    NSString *tip = [NSString stringWithFormat:NSLocalizedString(@"payment_account_tip", nil), @"www.storefront.com"];
    
    NSString *cancelButtonTitle = NSLocalizedString(@"payment_account_tip_cancel", nil);
    NSString *openButtonTitle = NSLocalizedString(@"payment_account_tip_open_url", nil);
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"payment_tip", nil)
                                                    message:tip
                                                   delegate:self
                                          cancelButtonTitle:cancelButtonTitle
                                          otherButtonTitles:openButtonTitle,nil];
    
    alert.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_QUESTION_DIALOG";
    
    [alert show];
    
    
    
}



//hardcoded until new ui is validated
- (void)checkoutCostCenterTap {
    
    actionCenter = CGPointMake(_mainView.center.x, _mainView.costCenterButton.center.y + [mainPickerView bH]/2 - 28 );
    
    [self setOptionsArray:[self selectCostCenterArray]];
    mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_COST_CENTER";
    [self showPicker:costCenterPicker];
}

- (void)checkoutDeliveryAddressTap {
    actionCenter = CGPointMake(_mainView.center.x, _mainView.deliveryAddressButton.center.y + [mainPickerView bH]/2  - 28 );
    
    [self setOptionsArray:[self selectDeliveryAddressArray]];
    mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_DELIVERY_ADDRESS";
    [self showPicker:deliveryAddressPicker];
}

- (void)checkoutDeliveryMethodTap {
    actionCenter = CGPointMake(_mainView.center.x, _mainView.deliveryMethodButton.center.y + [mainPickerView bH]/2  - 28 );
    
    [self setOptionsArray:[self selectDeliveryMethodArray]];
    mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_DELIVERY_METHOD";
    [self showPicker:deliveryMethodPicker];
}

- (void)checkoutAgreementCheckboxTap {
    
    BOOL status = [_mainView.agreementButton toggle];
    
    termsAndConditionsAccepted = status;
    [self agreementPanelHilight:!status];
    
    [_mainView.agreementPanel setNeedsDisplay];
}

- (void)checkoutAgreementTCTap {
    HYBWebviewController *webviewController = [[HYBWebviewController alloc] initWithLink:@"http://www.hybris.com"];
    
    self.navigationItem.backBarButtonItem.accessibilityLabel = @"ACCESS_TOPNAV_BUTTON_BACK";
    
    [self.navigationController pushViewController:webviewController animated:YES];
}

- (void)orderButtonTap {
    DDLogDebug(@"Starting order placement ...");
    
    
    if (self.currentCart && termsAndConditionsAccepted) {
        
        [HYBActivityIndicator show];
        
        _mainView.orderButton.enabled = NO;
        
        [self.b2bService placeOrderWithCart:self.currentCart andExecute:^(HYBOrder *order, NSError *error) {
            
            [HYBActivityIndicator hide];
            
            _mainView.orderButton.enabled = YES;
            
            if (error) {
                [self showNotifyMessage:[NSString stringWithFormat:@"Error during order placement, reason: %@", [error localizedDescription]]];
            } else {
                [self refreshCartFromServer];
                [self openOrderConfirmationWithOrder:order];
            }
        }];
    } else {
        [self agreementPanelHilight:YES];
    }
}

- (void)refreshCartFromServer {
    [self.b2bService retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
        [self loadCurrentCart];
    }];
}

#pragma mark checkbox management

- (void)agreementPanelHilight:(BOOL)hilite {
    if (hilite) {
        _mainView.agreementConfirmationLabel.hidden = NO;
        _mainView.agreementPanel.layer.borderWidth = 2.f;
        _mainView.agreementPanel.layer.borderColor = [checkout_agreement_confirmation CGColor];
    } else {
        _mainView.agreementConfirmationLabel.hidden = YES;
        _mainView.agreementPanel.layer.borderWidth = 0.f;
        _mainView.agreementPanel.layer.borderColor = nil;
        
    }
}

#pragma mark pickerview management

- (NSArray *)selectCostCenterArray {
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (HYBCostCenter *costCenter in self.costCenters) {
        [tempArray addObject:costCenter.name];
    }
    
    return [NSArray arrayWithArray:tempArray];
}

- (NSArray *)selectDeliveryAddressArray {
    
    int currentCostCenterIdx = pickersSelections[costCenterPicker];
    
    HYBCostCenter *costCenter = self.costCenters[currentCostCenterIdx];
    if (!costCenter) return nil;
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (HYBAddress *address in costCenter.addresses) {
        [tempArray addObject:address.formattedAddress];
    }
    
    return [NSArray arrayWithArray:tempArray];
}

- (NSArray *)selectDeliveryMethodArray {
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (HYBDeliveryMode *deliveryMode in self.deliveryModes) {
        [tempArray addObject:deliveryMode.name];
    }
    
    return [NSArray arrayWithArray:tempArray];
}

- (int)preSelectedDeliveryMethod {
    
    NSString *currentDeliveryMode = self.currentCart.deliveryMode.code;
    
    if(currentDeliveryMode) {
        for (HYBDeliveryMode *deliveryMode in self.deliveryModes) {
            if([currentDeliveryMode isEqualToString:deliveryMode.code]) {
                self.mode = deliveryMode;
                return (int)[self.deliveryModes indexOfObject:self.mode];
                break;
            }
        }
    }
    
    return 0;
}

- (void)showPicker:(int)pickerType {
    
    if (!optionsArray || [optionsArray count] <= 0) return; //no data to display : bail out
    
    [_mainView addSubview:_mainView.maskView];
    _mainView.maskView.hidden = NO;
    _mainView.maskView.alpha = 0;
    
    selectedPicker = pickerType;
    int preselectedRow = pickersSelections[selectedPicker];
    
    [mainPickerView reloadAllComponents];
    [mainPickerView selectRow:preselectedRow inComponent:0 animated:NO];
    
    [_mainView addSubview:mainPickerView];
    
    [_mainView addSubview:self.cancelPickerLabel];
    
    [mainPickerView setCenter:actionCenter];
    [self.cancelPickerLabel setCenter:CGPointMake(mainPickerView.center.x, mainPickerView.center.y+mainPickerView.bounds.size.height/3*2)];
    
    mainPickerView.alpha = 0.0;
    self.cancelPickerLabel.alpha = 0.0;
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         _mainView.maskView.alpha = .8;
                         mainPickerView.alpha = 1.0;
                         self.cancelPickerLabel.alpha = 1.0;
                     }];
    
}

- (void)hidePicker {
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         mainPickerView.alpha = 0.0;
                         _mainView.maskView.alpha = 0.0;
                         self.cancelPickerLabel.alpha = 0.0;
                     }
                     completion:^(BOOL done) {
                         [_mainView.maskView removeFromSuperview];
                         [mainPickerView removeFromSuperview];
                         [self.cancelPickerLabel removeFromSuperview];
                     }];
}

- (void)processPickerSelection:(NSInteger)row {
    
    if (selectedPicker >= 0) {
        pickersSelections[selectedPicker] = (int)row;
    }
    
    [self reloadChildDropdowns];
    
    [self hidePicker];
}

- (void)pickerTapped {
    [self hidePicker];
}

#pragma mark gesture Recognizer delegate

- (BOOL)gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer shouldRecognizeSimultaneouslyWithGestureRecognizer:(UIGestureRecognizer *)otherGestureRecognizer {
    // return
    return true;
}

#pragma mark pickerview delegate


- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView {
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component {
    return [optionsArray count];
}

- (UIView *)pickerView:(UIPickerView *)pickerView viewForRow:(NSInteger)row forComponent:(NSInteger)component reusingView:(UIView *)view {
    
    UILabel *pickerLabel = (UILabel *)view;
    
    if (pickerLabel == nil) {
        pickerLabel = [UILabel new];
        pickerLabel.textAlignment = NSTextAlignmentCenter;
    }
    
    pickerLabel.text = [optionsArray objectAtIndex:row];
    
    [pickerLabel sizeToFit];
    
    pickerLabel.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_PICKER_ROW_%ld",(long)row];
    
    return pickerLabel;
    
}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component {
    [self processPickerSelection:row];
}

#pragma mark textfield delegate

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    [textField resignFirstResponder];
    return NO;
}

- (BOOL)textFieldShouldClear:(UITextField *)textField {
    return YES;
}

- (void)loadCurrentCart {
    
    HYBCart *loadCart = [self.b2bService currentCartFromCache];
    if (loadCart) {
        [self setCurrentCart:loadCart];
        
        if (!self.cartSelectionsLoaded) {
            [self preloadCartSelections:self.currentCart];
            self.cartSelectionsLoaded = YES;
        }
        
        //order summary
        if ([self.currentCart.entries hyb_isNotBlank]) {
            [_mainView.orderSummaryView.itemCount setText:NSLocalizedString(@"cart_label_your_cart_is_empty", nil)];
        } else {
            NSString *totalLabel = [NSString stringWithFormat:NSLocalizedString(@"xx_items", nil), self.currentCart.totalUnitCount];
            [_mainView.orderSummaryView.itemCount setText:totalLabel];
        }
        
        _mainView.orderSummaryView.subtotalValue.text = self.currentCart.subTotal.formattedValue;
        _mainView.orderSummaryView.taxValue.text = self.currentCart.totalTax.formattedValue;
        _mainView.orderSummaryView.shippingValue.text = self.mode.deliveryCost.formattedValue;
        _mainView.orderSummaryView.orderTotalValue.text = self.currentCart.totalPrice.formattedValue;
        
        if (self.currentCart.orderDiscounts.value > 0) {
            _mainView.orderSummaryView.savingsValue.text = self.currentCart.orderDiscounts.formattedValue;
            
            HYBPromotionResult *promo = [[self.currentCart appliedOrderPromotions] firstObject];
            if([promo hyb_isNotBlank]) {
                _mainView.orderSummaryView.savingsRecapTitle.text = promo.descriptor;
            }
            
            [_mainView.orderSummaryView hideSavings:NO];
        } else {
            [_mainView.orderSummaryView hideSavings:YES];
        }
        
        [_mainView layoutSubviews];
    }
    else {
        DDLogDebug(@"No cart is present in the user cache, a cart should have been created at the login.");
    }
}

- (void)preloadCartSelections:(HYBCart *)currentCart {
    selectedPicker = -1;
    
    @weakify(self);
    [self.b2bService setPaymentType:CART_PAYMENTTYPE_ACCOUNT
                     onCartWithCode:currentCart.code
                            andExecute:^(HYBCart *cart, NSError *msg) {
                                
                                @strongify(self);
                                
                                //TODO: adapt category for cart.paymentDisplayName and use promiseKit
                                [self.mainView.paymentAccount setText:@"ACCOUNT PAYMENT"];
                                
                                [self.b2bService getCostcentersAndExecute:^(NSArray *costCenters, NSError *error) {
                                    self.costCenters = costCenters;
                                    [self selectCostCenterAtIndex:0 cart:cart];
                                }];
                            }];
}

- (void)selectCostCenterAtIndex:(int)costcenterIndex cart:(HYBCart *)cart {
    
    self.selectedCostCenter = [self.costCenters objectAtIndex:costcenterIndex];
    pickersSelections[costCenterPicker] = costcenterIndex;
    
    @weakify(self);
    [self.b2bService updateCartCostCenterWithCode:self.selectedCostCenter.code
                            onCartWithCode:cart.code
                                andExecute:^(HYBCart *cart, NSError *error) {
                                    @strongify(self);
                                    [self.mainView.costCenterButton setText:self.selectedCostCenter.name];
                                    self.deliveryAddresses = self.selectedCostCenter.addresses;
                                    [self selectDeliveryAddressAtIndex:0 cart:cart];
                                }];
}

- (void)selectDeliveryAddressAtIndex:(int)deliveryAddressIndex cart:(HYBCart *)cart {
    HYBAddress *selectedAddress = [self.deliveryAddresses objectAtIndex:deliveryAddressIndex];
    pickersSelections[deliveryAddressPicker] = deliveryAddressIndex;
    
    @weakify(self);
    [self.b2bService setDeliveryAddressWithCode:selectedAddress.id
                                 onCartWithCode:cart.code
                                     andExecute:^(HYBCart *cart, NSError *error) {
                                         
                                         @strongify(self);
                                         
                                         if (cart) {
                                             [self.mainView.deliveryAddressButton setText:selectedAddress.formattedAddress];
                                             
                                             //TODO:use promiseKit
                                             [self.b2bService getDeliveryModesForCart:cart.code andExecute:^(NSArray *modes, NSError *error) {
                                                 
                                                 self.deliveryModes = modes;
                                                 
                                                 int deliveryModeIndex = [self preSelectedDeliveryMethod];
                                                 
                                                 [self selectDeliveryModeAtIndex:deliveryModeIndex cart:cart];
                                             }];
                                         } else {
                                             DDLogDebug(@"error retrieving cart, can't set delivery address");
                                         }
                                     }];
}

- (void)selectDeliveryModeAtIndex:(int)deliveryModeIndex cart:(HYBCart *)cart {
    self.mode = [self.deliveryModes objectAtIndex:deliveryModeIndex];
    pickersSelections[deliveryMethodPicker] = deliveryModeIndex;
    
    @weakify(self);
    [self.b2bService setDeliveryModeWithCode:self.mode.code
                              onCartWithCode:cart.code
                                  andExecute:^(HYBCart *cart, NSError *error) {
                                      
                                      @strongify(self);
                                      if(cart) {
                                          NSString *fullInfo = [NSString stringWithFormat:@"%@ - %@",self.mode.name,self.mode.deliveryCost.formattedValue];
                                          [self.mainView.deliveryMethodButton setText:fullInfo];
                                          [self.mainView.orderSummaryView.shippingValue setText:self.mode.deliveryCost.formattedValue];
                                          
                                          [self refreshCartFromServer];
                                      } else {
                                          DDLogDebug(@"error retrieving cart, can't set delivery mode");
                                      }
                                  }];
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