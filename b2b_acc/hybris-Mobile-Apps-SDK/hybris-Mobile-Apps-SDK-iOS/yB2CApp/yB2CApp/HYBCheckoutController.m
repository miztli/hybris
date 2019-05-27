//
// HYBCheckoutController.m
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

#import "HYBCheckoutController.h"
#import "HYBCheckoutView.h"
#import "HYBCart.h"
#import "HYBWebviewController.h"
#import "HYBAddress.h"
#import "HYBDeliveryMode.h"
#import "UIColor+Expanded.h"
#import "HYBOrder.h"
#import "HYBActivityIndicator.h"
#import "HYBConstants.h"

#import "HYBCreditCardFormViewController.h"
#import "HYBAddressFormViewController.h"

#import "stylesheet.h"

@interface HYBCheckoutController ()

@property (nonatomic) BOOL didShowLogin;

@property (nonatomic) NSArray         *paymentDetailsList;
@property (nonatomic) NSArray         *deliveryAddresses;
@property (nonatomic) NSArray         *deliveryModes;

@property (nonatomic) HYBCart           *currentCart;
@property (nonatomic) HYBUser           *user;

@property (nonatomic) HYBPaymentDetails   *selectedPaymentDetails;
@property (nonatomic) HYBAddress          *selectAddress;
@property (nonatomic) HYBDeliveryMode     *selectedDeliveryMode;

@property (nonatomic) UILabel         *cancelPickerLabel;
@property (nonatomic) BOOL            cartSelectionsLoaded;

@end

@implementation HYBCheckoutController

@synthesize optionsArray, mainPickerView;

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        _paymentDetailsList = [NSArray array];
        _deliveryAddresses  = [NSArray array];
        _deliveryModes      = [NSArray array];
        _didShowLogin = NO;
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
    [self registerForCartChangeNotifications:@selector(loadCurrentCart) senderObject:self.backendService];
    
    //buttons interactions
    
    [_mainView.paymentAccount addTarget:self action:@selector(checkoutPaymentAccountTap)];
    
    _mainView.paymentAccount.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_ACCOUNT";

    _mainView.createPayment.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_NEW_CARD";
    
    [_mainView.createPayment addTarget:self
                                  action:@selector(createPaymentDetails)
                        forControlEvents:UIControlEventTouchUpInside];
    
     _mainView.createAddress.accessibilityIdentifier = @"ACCESS_CHECKOUT_DELIVERY_NEW_ADDRESS";
    
    [_mainView.createAddress addTarget:self
                                action:@selector(createAddress)
                      forControlEvents:UIControlEventTouchUpInside];
    
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
    
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    
    if([self.backendService isUserLoggedIn]) {
        
        
        [super viewWillAppear:animated];
        [self topToolbar].searchDelegate = self;
        
        _cartSelectionsLoaded = NO;
        
        [self loadCurrentCart];
        
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
        
    } else {
        if(!_didShowLogin) {
            _didShowLogin =YES;
            [self openLogin];
        } else {
            [self openCatalog];
        }
    }
}

- (void)reloadChildDropdowns {
    
    int selectedIndex = pickersSelections[selectedPicker];
    
    switch (selectedPicker) {
            
        case paymentDetailsPicker:
            [self selectPaymentDetailsAtIndex:selectedIndex cart:_currentCart];
            break;
            
        case deliveryAddressPicker:
            [self selectDeliveryAddressAtIndex:selectedIndex cart:_currentCart];
            break;
            
        case deliveryMethodPicker:
            [self selectDeliveryModeAtIndex:selectedIndex cart:_currentCart];
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
    
    if ([_paymentDetailsList hyb_isNotBlank]) {
        
        actionCenter = CGPointMake(_mainView.center.x, _mainView.paymentAccount.center.y + [mainPickerView bH]/2  - 28 );
        
        [self setOptionsArray:[self selectPaymentDetailsArray]];
        
        mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_PAYMENT_DETAILS";
        [self showPicker:paymentDetailsPicker];
        
    } else {
        
        [self createPaymentDetails];
    }
}

//hardcoded until new ui is validated
- (void)checkoutDeliveryAddressTap {
    
    if([_deliveryAddresses hyb_isNotBlank]) {
        actionCenter = CGPointMake(_mainView.center.x, _mainView.deliveryAddressButton.center.y + [mainPickerView bH]/2  - 28 );
        
        [self setOptionsArray:[self selectDeliveryAddressArray]];
        
        mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_DELIVERY_ADDRESS";
        [self showPicker:deliveryAddressPicker];
    } else {
        
        [self createAddress];
    }
}

- (void)checkoutDeliveryMethodTap {
    NSLog(@"checkoutDeliveryMethodTap");
    
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
        
        [self.backendService placeOrderWithCart:self.currentCart
                                     andExecute:^(HYBOrder *order, NSError *error) {
                                         
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
    [self.backendService retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
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

- (NSArray *)selectPaymentDetailsArray {
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (HYBPaymentDetails *paymentDetails in self.paymentDetailsList) {
        [tempArray addObject:[self formatPayment:paymentDetails]];
    }
    
    return [NSArray arrayWithArray:tempArray];
}

- (NSArray *)selectDeliveryAddressArray {
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (HYBAddress *address in _deliveryAddresses) {
        NSString *formattedAddress = address.formattedAddress;
        if(![formattedAddress hyb_isNotBlank]) formattedAddress = [self formatAddress:address];
        [tempArray addObject:formattedAddress];
    }
    
    return [NSArray arrayWithArray:tempArray];
}

- (NSArray *)selectDeliveryMethodArray {
    
    NSMutableArray *tempArray = [NSMutableArray array];
    
    for (HYBDeliveryMode *deliveryMode in _deliveryModes) {
        [tempArray addObject:deliveryMode.name];
    }
    
    return [NSArray arrayWithArray:tempArray];
}


- (int)preSelectedDeliveryMethod {
    
    NSString *currentDeliveryMode = self.currentCart.deliveryMode.code;
    
    if(currentDeliveryMode) {
        for (HYBDeliveryMode *deliveryMode in self.deliveryModes) {
            if([currentDeliveryMode isEqualToString:deliveryMode.code]) {
                _selectedDeliveryMode = deliveryMode;
                return (int)[_deliveryModes indexOfObject:_selectedDeliveryMode];
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
    
    pickerLabel.text = optionsArray[row];
    
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
    
    HYBCart *loadCart = [self.backendService currentCartFromCache];
    
    if (loadCart) {
        [self setCurrentCart:loadCart];
        
        if (!self.cartSelectionsLoaded) {
            [self preloadCartSelections:_currentCart];
            self.cartSelectionsLoaded = YES;
        }
        
        //order summary
        if ([self.currentCart.entries hyb_isNotBlank]) {
            [_mainView.orderSummaryView.itemCount setText:NSLocalizedString(@"cart_label_your_cart_is_empty", nil)];
        } else {
            NSString *totalLabel = [NSString stringWithFormat:NSLocalizedString(@"xx_items", nil), self.currentCart.totalUnitCount];
            [_mainView.orderSummaryView.itemCount setText:totalLabel];
        }
        
        _mainView.orderSummaryView.subtotalValue.text = _currentCart.subTotal.formattedValue;
        _mainView.orderSummaryView.taxValue.text = _currentCart.totalTax.formattedValue;
        _mainView.orderSummaryView.shippingValue.text = _selectedDeliveryMode.deliveryCost.formattedValue;
        _mainView.orderSummaryView.orderTotalValue.text = _currentCart.totalPrice.formattedValue;
        
        if (self.currentCart.orderDiscounts.value > 0) {
            _mainView.orderSummaryView.savingsValue.text = _currentCart.orderDiscounts.formattedValue;
            
            HYBPromotionResult *promo = [[_currentCart appliedOrderPromotions] firstObject];
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


- (NSString*)formatAddress:(HYBAddress*)address {
    return [NSString stringWithFormat:@"%@ %@, %@, %@",address.firstName, address.lastName, address.line1, address.town];
}

- (void)preloadCartSelections:(HYBCart *)currentCart {
    selectedPicker = -1;
    
    //load data
    [PMKPromise when:@[[self loadUser], [self loadUserAddresses], [self loadUserPaymentDetails]]]
    
    .then(^(NSArray *results){
        
        for (id object in results) {
            if([object isKindOfClass:[NSArray class]]) {
                if([[object firstObject] isKindOfClass:[HYBAddress class]]) {
                    _deliveryAddresses = [NSArray arrayWithArray:(NSArray*)object];
                }
                
                else if([[object firstObject] isKindOfClass:[HYBPaymentDetails class]]) {
                    _paymentDetailsList = [NSArray arrayWithArray:(NSArray*)object];
                }
            }
            
            else  if([object isKindOfClass:[HYBUser class]]) {
                _user = (HYBUser*)object;
            }
        }
    })
    
    .then(^(id responseObject){
        [self loadCurrentCart];
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't load account infos : %@", error.localizedDescription);
    });
    
}

#pragma mark refresh

- (NSString*)formatPayment:(HYBPaymentDetails*)payment {
    //empty
    if(![payment hyb_isNotBlank]) return NSLocalizedString(@"noCreditCardRegisteredYet",nil);
    
    //not empty
    return [NSString stringWithFormat:@"%@, %@ (%@)", payment.accountHolderName, payment.cardType.name, payment.cardNumber];
}

- (void)refresh {
    [self refreshPaymentDetails];
    [self refreshAddresses];
    [self refreshDeliveryMode];
}

- (void)refreshPaymentDetails {
    
    //load from cart
    _selectedPaymentDetails = _currentCart.paymentInfo;
    
    //if no infos from cart
    //load from user's credit cards list
    if(![_selectedPaymentDetails hyb_isNotBlank] && [_paymentDetailsList hyb_isNotBlank]) {
        
        //select user's default credit card
        for (HYBPaymentDetails* payment in _paymentDetailsList) {
            if (payment.defaultPayment) {
                _selectedPaymentDetails = payment;
            }
        }
        
        //no user's default card, assign the first from the list
        if (![_selectedPaymentDetails hyb_isNotBlank]) {
            _selectedPaymentDetails = [_paymentDetailsList firstObject];
        }
        
        [self selectPaymentDetailsForCart:_currentCart];
    }
    
    //display or create new one
    if([_selectedPaymentDetails hyb_isNotBlank]) {
        self.mainView.paymentAccount.text = [self formatPayment:_selectedPaymentDetails];
    } else {
        self.mainView.paymentAccount.text = NSLocalizedString(@"create_new_credit_card", nil);
    }
}

- (void)refreshAddresses {
    //load from cart
    _selectAddress = _currentCart.deliveryAddress;
    
    //if no infos from cart
    //select user's default address
    if (![_selectAddress hyb_isNotBlank] && [_deliveryAddresses hyb_isNotBlank]) {
        
        _selectAddress = _user.defaultAddress;
        
        //no user's default address, assign the first from the user's addresses
        if (![_selectAddress hyb_isNotBlank]) {
            _selectAddress = [_deliveryAddresses firstObject];
        }
        
        [self selectDeliveryAddressForCart:_currentCart];
    }
    
    //display or create new one
    if([_selectAddress hyb_isNotBlank]) {
        
        NSString *address = _selectAddress.formattedAddress;
        if(![address hyb_isNotBlank]) address = [self formatAddress:_selectAddress];
        
        self.mainView.deliveryAddressButton.text = address;
    } else {
        self.mainView.deliveryAddressButton.text = NSLocalizedString(@"create_new_address", nil);
    }
}

- (void)refreshDeliveryMode {
    
    if([_deliveryModes hyb_isNotBlank]) {
        _selectedDeliveryMode = _currentCart.deliveryMode;
        
        if (![_selectedDeliveryMode hyb_isNotBlank] && [_deliveryModes hyb_isNotBlank]) {
            //load from store modes
            _selectedDeliveryMode = [_deliveryModes firstObject];
        }
        
        //display or create new one
        if([_selectedDeliveryMode hyb_isNotBlank]) {
            self.mainView.deliveryMethodButton.text = _selectedDeliveryMode.name;
            if(_selectedDeliveryMode != _currentCart.deliveryMode) {
                [self selectDeliveryModeForCart:_currentCart];
            }
        }
    } else if([_selectAddress hyb_isNotBlank]) {
        
        [self loadDeliveryModes]
        
        .then(^(id responseObject) {
            _deliveryModes = (NSArray*)responseObject;
            [self refreshDeliveryMode];
        })
        
        .catch(^(NSError *error){
            DDLogDebug(@"Couldn't load delivery modes : %@", error.localizedDescription);
        });
        
    }
}

#pragma mark selections from pickers

- (void)selectPaymentDetailsAtIndex:(int)index
                               cart:(HYBCart *)cart {
    
    _selectedPaymentDetails = [self.paymentDetailsList objectAtIndex:index];
    pickersSelections[paymentDetailsPicker] = index;
    
    [self selectPaymentDetailsForCart:cart];
}

- (void)selectPaymentDetailsForCart:(HYBCart *)cart {
    
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            _selectedPaymentDetails.id,@"paymentDetailsId",
                            nil];
    
    [self updatePaymentDetailsForCart:cart withParams:params]
    
    .then(^(id responseObject){
        return [self reloadCart];
    })
    
    .then(^(id responseObject){
        _currentCart = (HYBCart *)responseObject;
        return [self refreshPaymentDetails];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"selectPaymentDetailsForCart : error retrieving cart, can't set delivery address");
        DDLogDebug(@"%@", error.localizedDescription);
    });
}

- (void)selectDeliveryAddressAtIndex:(int)index
                                cart:(HYBCart *)cart {
    
    _selectAddress = [self.deliveryAddresses objectAtIndex:index];
    pickersSelections[deliveryAddressPicker] = index;
    
    [self selectDeliveryAddressForCart:cart];
}

- (void)selectDeliveryAddressForCart:(HYBCart *)cart {
    
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            _selectAddress.id,@"addressId",
                            nil];
    
    [self updateDeliveryAddressForCart:cart withParams:params]
    
    .then(^(id responseObject){
        return [self reloadCart];
    })
    
    .then(^(id responseObject) {
        _currentCart = (HYBCart *)responseObject;
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"selectDeliveryAddressForCart : error retrieving cart, can't set delivery address");
        DDLogDebug(@"%@", error.localizedDescription);
    });
    
}

- (void)selectDeliveryModeAtIndex:(int)deliveryModeIndex cart:(HYBCart *)cart {
    _selectedDeliveryMode = [_deliveryModes objectAtIndex:deliveryModeIndex];
    pickersSelections[deliveryMethodPicker] = deliveryModeIndex;
    
    [self selectDeliveryModeForCart:cart];
}

- (void)selectDeliveryModeForCart:(HYBCart *)cart {
    
    NSDictionary *params =  @{@"deliveryModeId" : _selectedDeliveryMode.code};
    
    [self updateDeliveryModeForCart:cart withParams:params]
    
    .then(^(id responseObject){
        return [self reloadCart];
    })
    
    .then(^(id responseObject){
        _currentCart = (HYBCart *)responseObject;
        [self refreshDeliveryMode];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"selectDeliveryModeForCart : error retrieving cart, can't set delivery address");
        DDLogDebug(@"%@", error.localizedDescription);
    });
}

#pragma mark create missing infos

- (void)createPaymentDetails {
    NSLog(@"create new card");
    
    HYBCreditCardFormViewController *ccFormViewController = [[HYBCreditCardFormViewController alloc] initWithBackEndService:self.backendService];
    
    [self.navigationController pushViewController:ccFormViewController animated:YES];
    
}

- (void)createAddress {
    NSLog(@"create new address");
    
    HYBAddressFormViewController *addressFormViewController = [[HYBAddressFormViewController alloc] initWithBackEndService:self.backendService];
    
    [self.navigationController pushViewController:addressFormViewController animated:YES];
    
}

#pragma mark promises

- (PMKPromise *)loadUserAddresses {
    
    NSLog(@"PMKPromise loadUserAddresses");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getUserAddressesForUserId:[self.backEndService currentUserId]
                                        andExecute:^(id responseObject, NSError* error) {
                                            if (error) {
                                                reject(error);
                                            } else {
                                                fulfill(responseObject);
                                            }
                                        }];
    }];
}

- (PMKPromise *)loadUserPaymentDetails {
    
    NSLog(@"PMKPromise loadUserPaymentDetails");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getPaymentdetailsListForUserId:[self.backEndService currentUserId]
                                                 withParams:[NSDictionary FULLFields]
                                                 andExecute:^(id responseObject, NSError* error) {
                                                     if (error) {
                                                         reject(error);
                                                     } else {
                                                         fulfill(responseObject);
                                                     }
                                                 }];
    }];
}

- (PMKPromise *)updatePaymentDetailsForCart:(HYBCart*)cart withParams:(NSDictionary*)params {
    
    NSLog(@"PMKPromise updatePaymentDetailsForCart");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService updateCartPaymentdetailsForUserId:self.backendService.userId
                                                  andCartId:cart.code
                                                 withParams:params
                                                 andExecute:^(id responseObject, NSError* error) {
                                                     if (error) {
                                                         reject(error);
                                                     } else {
                                                         fulfill(responseObject);
                                                     }
                                                 }];
    }];
}



- (PMKPromise *)updateDeliveryModeForCart:(HYBCart*)cart withParams:(NSDictionary*)params {
    
    NSLog(@"PMKPromise updateDeliveryModeForCart");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService updateCartDeliverymodeForUserId:self.backendService.userId
                                                   andCartId:cart.code
                                                  withParams:params
                                                  andExecute:^(id responseObject, NSError* error) {
                                                      if (error) {
                                                          reject(error);
                                                      } else {
                                                          fulfill(responseObject);
                                                      }
                                                  }];
    }];
}


- (PMKPromise *)updateDeliveryAddressForCart:(HYBCart*)cart withParams:(NSDictionary*)params {
    
    NSLog(@"PMKPromise updateCartDeliveryAddress");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService updateCartDeliveryAddressForUserId:self.backendService.userId
                                                      andCartId:cart.code
                                                     withParams:params
                                                     andExecute:^(id responseObject, NSError* error) {
                                                         if (error) {
                                                             reject(error);
                                                         } else {
                                                             fulfill(responseObject);
                                                         }
                                                     }];
    }];
}

- (PMKPromise *)reloadCart {
    
    NSLog(@"PMKPromise reloadCart");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService retrieveCurrentCartAndExecute:^(id responseObject, NSError* error) {
            if (error) {
                reject(error);
            } else {
                fulfill(responseObject);
            }
        }];
    }];
}

- (PMKPromise *)loadDeliveryModes {
    
    NSLog(@"PMKPromise loadDeliveryModes");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService getCartDeliverymodesForUserId:self.backendService.userId
                                                 andCartId:self.currentCart.code
                                                andExecute:^(id responseObject, NSError* error) {
                                                    if (error) {
                                                        reject(error);
                                                    } else {
                                                        fulfill(responseObject);
                                                    }
                                                }];
    }];
}

- (PMKPromise *)loadUser {
    
    NSLog(@"PMKPromise loadUser");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getUserProfileForUserId:[self.backEndService currentUserId]
                                          andExecute:^(id responseObject, NSError* error) {
                                              if (error) {
                                                  reject(error);
                                              } else {
                                                  fulfill(responseObject);
                                              }
                                          }];
    }];
}




#pragma mark search delegate

- (void)performSearchForString:(NSString *)searchString {
    [super performSearchForString:searchString];
}


@end