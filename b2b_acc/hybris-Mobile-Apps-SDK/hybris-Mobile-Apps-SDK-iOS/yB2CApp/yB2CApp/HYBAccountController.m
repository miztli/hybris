//
// HYBAccountController.m
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


#import "HYBAccountController.h"
#import "HYBAccountView.h"
#import "HYBB2CService.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBActivityIndicator.h"
#import "HYBAppDelegate.h"
#import "HYBAddressesListViewController.h"
#import "HYBCreditCardFormViewController.h"

#import <PromiseKit/PromiseKit.h>

#define CELL_ID @"CELL_ID"

enum selectedPickerType {titlePicker, languagePicker, paymentPicker};

@interface HYBAccountController ()

@property (nonatomic) HYBAccountView *mainView;

@property (nonatomic) HYBPaymentDetails *selectedPaymentDetails;

@property (nonatomic) NSArray *titles;
@property (nonatomic) NSArray *languages;
@property (nonatomic) NSArray *addresses;
@property (nonatomic) NSArray *paymentDetails;

@property (nonatomic) HYBUser *user;

@property (nonatomic) NSMutableDictionary *fieldsToChange;

@property (nonatomic) NSString *safeValue;

//picker
@property (nonatomic) NSArray         *optionsArray;
@property (nonatomic) UIPickerView    *mainPickerView;
@property (nonatomic) int selectedPicker;
@property (nonatomic) CGPoint actionCenter;
@property (nonatomic) UILabel         *cancelPickerLabel;

@property (nonatomic) BOOL didShowLogin;

@end

@implementation HYBAccountController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        self.view.backgroundColor = [UIColor whiteColor];
        _fieldsToChange = [NSMutableDictionary  dictionary];
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    if (!_mainView) {
        _didShowLogin = NO;
        
        _mainView = [HYBAccountView new];
        
        _mainView.firstNameField.delegate = self;
        _mainView.lastNameField.delegate = self;
        
        //selectors
        [_mainView.titleSelector addTarget:self
                                    action:@selector(titleSelectorTap)];
        _mainView.titleSelector.accessibilityIdentifier = @"ACCESS_ACCOUNT_TITLE_SELECTOR";
        
        [_mainView.languageSelector addTarget:self
                                       action:@selector(languageSelectorTap)];
        _mainView.languageSelector.accessibilityIdentifier = @"ACCESS_ACCOUNT_LANGUAGE_SELECTOR";
        
        //payment
        
        UITapGestureRecognizer *paymentDetailsTap = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                             action:@selector(openPaymentDetailsList)];
        
        _mainView.defaultPaymentDetails.userInteractionEnabled = YES;
        [_mainView.defaultPaymentDetails addGestureRecognizer:paymentDetailsTap];
        
        
        //addresses
        UITapGestureRecognizer *addressesTap = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                             action:@selector(openAddressesList)];
        
        _mainView.defaultShippingAddress.userInteractionEnabled = YES;
        [_mainView.defaultShippingAddress addGestureRecognizer:addressesTap];
        
        
    }
    
    self.view = _mainView;
    
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    
    if([self.backendService isUserLoggedIn]) {
        _didShowLogin = NO;
        [super viewWillAppear:animated];
        [self topToolbar].searchDelegate = self;
        
        [self preparePicker];
        
        //load data
        [PMKPromise when:@[[self loadTitles], [self loadLanguages], [self loadUser], ]].then(^(NSArray *results){
            
            for (id object in results) {
                if([object isKindOfClass:[NSArray class]]) {
                    if([[object firstObject] isKindOfClass:[HYBTitle class]]) {
                        _titles = [NSArray arrayWithArray:(NSArray*)object];
                    }
                    
                    else if([[object firstObject] isKindOfClass:[HYBLanguage class]]) {
                        _languages = [NSArray arrayWithArray:(NSArray*)object];
                    }
                }
                
                else  if([object isKindOfClass:[HYBUser class]]) {
                    _user = (HYBUser*)object;
                }
            }
            
            
        })
        
        .then(^{
            return [self loadUserAddresses];
        })
        
        .then(^(id responseObject){
            _addresses = (NSArray*)responseObject;
            
            return [self loadUserPaymentDetails];
        })
        
        .then(^(id responseObject){
            _paymentDetails = (NSArray*)responseObject;
            
            [self refresh];
        })
        
        .catch(^(NSError *error) {
            DDLogDebug(@"Couldn't load account infos : %@", error.localizedDescription);
        });
    }
    else {        
        if (_didShowLogin) {
            [self openDashboard];
        } else {
            [self openLogin];
            _didShowLogin = YES;
        }
    }
}

- (void)preparePicker {
    //prepare picker
    [self setMainPickerView:[UIPickerView new]];
    [_mainPickerView setDataSource:self];
    [_mainPickerView setDelegate:self];
    
    CGFloat margin = 20.f;
    
    CGRect pickerFrame = CGRectMake([_mainPickerView fX], [_mainPickerView fY], [_mainView bW] - margin*2, [_mainPickerView bH]);
    _mainPickerView.frame = pickerFrame;
    
    UITapGestureRecognizer *pickerTapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(pickerTapped)];
    [_mainPickerView addGestureRecognizer:pickerTapRecognizer];
    pickerTapRecognizer.delegate = self;
    
    //mask tap dismiss pickers
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(hidePicker)];
    [_mainView.maskView addGestureRecognizer:tapRecognizer];
    
    //tap invite
    _cancelPickerLabel = [UILabel new];
    _cancelPickerLabel.text = NSLocalizedString(@"cancel", @"");
    _cancelPickerLabel.textAlignment = NSTextAlignmentCenter;
    [self.cancelPickerLabel sizeToFit];
    _cancelPickerLabel.frame = CGRectInset(self.cancelPickerLabel.frame, -20, -10);
    _cancelPickerLabel.backgroundColor = [UIColor colorWithHexString:@"#fad712"];
    
}

- (PMKPromise *)loadTitles {
    
    NSLog(@"PMKPromise loadTitles");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getTitlesAndExecute:^(id responseObject, NSError* error) {
            if (error) {
                reject(error);
            } else {
                fulfill(responseObject);
            }
        }];
    }];
}

- (PMKPromise *)loadLanguages {
    
    NSLog(@"PMKPromise loadLanguages");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getLanguagesAndExecute:^(id responseObject, NSError* error) {
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

- (void)refresh {
    
    [self refreshUserTitle];
    [self refreshUserName];
    [self refreshUserLanguage];
    [self refreshPaymentDetails];
    [self refreshAddresses];
    
    [_mainView setNeedsLayout];
}

- (void)refreshUserName {
    _mainView.firstNameField.text = _user.firstName;
    _mainView.lastNameField.text = _user.lastName;
    _mainView.userEmail.text = [self.backEndService currentUserEmail];
}

- (void)refreshUserTitle {
    if ([_user.titleCode hyb_isNotBlank] && [_titles hyb_isNotBlank]) {
        for (HYBTitle *title in _titles) {
            if([title.code isEqualToString:_user.titleCode]) {
                _mainView.titleSelector.text = title.name;
                break;
            }
        }
    } else {
        _mainView.titleSelector.text = [[_titles firstObject] name];
    }
}

- (void)refreshUserLanguage {
    if ([_user.language.isocode hyb_isNotBlank] && [_languages hyb_isNotBlank]) {
        for (HYBLanguage *language in _languages) {
            if([language.isocode isEqualToString:_user.language.isocode]) {
                _mainView.languageSelector.text = language.name;
                break;
            }
        }
    } else {
        _mainView.languageSelector.text = [[_languages firstObject] name];
    }
}

- (NSString*)formatPayment:(HYBPaymentDetails*)payment {
    //empty
    if(![payment hyb_isNotBlank]) return NSLocalizedString(@"noCreditCardRegisteredYet",nil);
    
    //not empty
    return [NSString stringWithFormat:@"%@, %@ (%@)", payment.accountHolderName, payment.cardType.name, payment.cardNumber];
}

- (void)refreshPaymentDetails {
    
    if([_paymentDetails hyb_isNotBlank]) {
        _selectedPaymentDetails = [_paymentDetails firstObject];
    } else {
        _selectedPaymentDetails = nil;
    }
    
    [_mainView.defaultPaymentDetails setPaymentDetails:_selectedPaymentDetails];
    [_mainView.defaultPaymentDetails layoutSubviews];
}

- (void)refreshAddresses {
    
    HYBAddress *selectedAddress = _user.defaultAddress;
    
    if(!selectedAddress && [_addresses hyb_isNotBlank]) {
        selectedAddress = [_addresses firstObject];
    }
    
    [_mainView.defaultShippingAddress setAddress:selectedAddress];
    [_mainView.defaultShippingAddress layoutSubviews];
    
}

#pragma mark tableView delegate

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    return [_addresses count];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 100.f;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CELL_ID];
    
    if(cell == nil) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle
                                      reuseIdentifier:CELL_ID];
    }
    
    HYBAddress *address = _addresses[indexPath.row];
    
    cell.textLabel.text = [NSString stringWithFormat:@"%@ %@ %@",address.title, address.firstName, address.lastName];
    cell.detailTextLabel.text = address.formattedAddress;
    
    return cell;
}


#pragma mark apply selection

- (void)selectUserTitle:(NSInteger)row {
    
    NSString *value = [(HYBTitle*)_optionsArray[row] code];
    
    if ([self didChangeValue:value]) {
        [_fieldsToChange setValue:value forKey:@"titleCode"];
        
        [self saveChanges];
        
        [self refreshUserTitle];
    }
}

- (void)selectUserLanguage:(NSInteger)row {
    
    NSString *value = [(HYBLanguage*)_optionsArray[row] isocode];
    
    if ([self didChangeValue:value]) {
        
        [_fieldsToChange setValue:value forKey:@"language"];
        
        [self saveChanges];
        
        [self refreshUserLanguage];
    }
}

- (BOOL)didChangeValue:(NSString*)value {
    
    if ([value hyb_isNotBlank] && [_safeValue hyb_isNotBlank] && ![_safeValue isEqualToString:value]) {
        return YES;
    }
    
    return NO;
}


#pragma mark save update

- (PMKPromise *)saveChangesPromise {
    
    NSLog(@"PMKPromise saveChangesPromise");
    
    @synchronized(_fieldsToChange) {
        
        NSDictionary *params = [NSDictionary dictionaryWithDictionary:_fieldsToChange];
        
        [_fieldsToChange removeAllObjects];
        _safeValue = nil;
        
        return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            
            [self.backEndService  updateUserProfileForUserId:[self.backEndService currentUserId]
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
}

- (void)saveChanges {
    
    if([_fieldsToChange hyb_isNotBlank]) {
        
        [self saveChangesPromise]
        
        .then(^(id responseObject) {
            return [self loadUser];
        })
        
        .then(^(id responseObject) {
            self.user = (HYBUser*)responseObject;
            [self refresh];
        })
        
        .catch(^(NSError *error) {
            DDLogError(@"Can't update User Profile %@", error.localizedDescription);
            [self saveProblemAlert];
        });
        
    }
    
}

#pragma mark alert

- (void)saveProblemAlert {
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"account_warning", nil)
                                                        message:NSLocalizedString(@"account_save_problem", nil)
                                                       delegate:self
                                              cancelButtonTitle:NSLocalizedString(@"okayKey", nil)
                                              otherButtonTitles:nil];
    
    [alertView show];
}

#pragma mark textfield delegate

- (void)textFieldDidBeginEditing:(UITextField *)textField {
    
    NSString *fieldValue = textField.text;
    
    if ([fieldValue hyb_isNotBlank]) {
        _safeValue = [NSString stringWithString:fieldValue];
    }
}

- (void)textFieldDidEndEditing:(UITextField *)textField {
    
    NSString *fieldValue = textField.text;
    
    if ([fieldValue hyb_isNotBlank] && [_safeValue hyb_isNotBlank] && ![_safeValue isEqualToString:fieldValue]) {
        
        if(textField == _mainView.firstNameField) {
            [_fieldsToChange setValue:fieldValue forKey:@"firstName"];
        }
        
        else if(textField == _mainView.lastNameField) {
            [_fieldsToChange setValue:fieldValue forKey:@"lastName"];
        }
        
        [self saveChanges];
    }
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    [textField resignFirstResponder];
    
    if (textField == _mainView.firstNameField) {
        [_mainView.lastNameField becomeFirstResponder];
    }
    
    return NO;
}

- (BOOL)textFieldShouldClear:(UITextField *)textField {
    return YES;
}

#pragma mark dropdown actions

- (void)resignAllResponder {
    [_mainView.firstNameField resignFirstResponder];
    [_mainView.lastNameField  resignFirstResponder];
}

- (void)titleSelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(_mainView.center.x, _mainView.titleSelector.center.y + [_mainPickerView bH]/2 - 28 );
    
    _optionsArray = _titles;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_TITLE";
    
    if ([_titles count] > 1) {
        [self showPicker:titlePicker];
    }
    
}

- (void)languageSelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(_mainView.center.x, _mainView.languageSelector.center.y + [_mainPickerView bH]/2  - 28 );
    
    _optionsArray = _languages;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_LANGUAGE";
    
    if ([_languages count] > 1) {
        [self showPicker:languagePicker];
    }
    
}


#pragma mark pickerview delegate


- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView {
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component {
    return [_optionsArray count];
}

- (UIView *)pickerView:(UIPickerView *)pickerView
            viewForRow:(NSInteger)row
          forComponent:(NSInteger)component
           reusingView:(UIView *)view {
    
    UILabel *pickerLabel = (UILabel *)view;
    
    if (pickerLabel == nil) {
        pickerLabel = [UILabel new];
        pickerLabel.textAlignment = NSTextAlignmentCenter;
    }
    
    id object = _optionsArray[row];
    
    NSString *label = @"N/A";
    
    if(_optionsArray == _titles) {
        label = [(HYBTitle*)object name];
    }
    
    else if(_optionsArray == _languages) {
        label = [(HYBLanguage*)object name];
    }
    
    else  if(_optionsArray == _paymentDetails) {
        label = [self formatPayment:object];
    }
    
    pickerLabel.text = label;
    
    [pickerLabel sizeToFit];
    
    pickerLabel.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_PICKER_ROW_%ld",(long)row];
    
    return pickerLabel;
    
}

- (void)pickerView:(UIPickerView *)pickerView
      didSelectRow:(NSInteger)row
       inComponent:(NSInteger)component {
    
    [self processPickerSelection:row];
}

#pragma mark pickerview management


- (int)preSelectedTitle {
    
    int count = 0;
    BOOL didFind = NO;
    
    for (HYBTitle *obj in _titles) {
        if([obj.code isEqualToString:_user.titleCode]) {
            _safeValue = [NSString stringWithString:obj.code];
            didFind = YES;
            break;
        } else {
            count++;
        }
    }
    
    if(!didFind) count = 0;
    
    return count;
}

- (int)preSelectedLanguage {
    
    int count = 0;
    BOOL didFind = NO;
    
    for (HYBLanguage *obj in _languages) {
        if([obj.isocode isEqualToString:_user.language.isocode]) {
            _safeValue = [NSString stringWithString:obj.isocode];
            didFind = YES;
            break;
        } else {
            count++;
        }
    }
    
    if(!didFind) count = 0;
    
    return count;
}

- (int)preSelectedPayment {
    
    int count = 0;
    BOOL didFind = NO;
    
    for (HYBPaymentDetails *obj in _paymentDetails) {
        if(obj.defaultPayment) {
            _safeValue = [NSString stringWithString:obj.id];
            didFind = YES;
            break;
        } else {
            count++;
        }
    }
    
    if(!didFind) count = 0;
    
    return count;
}

- (int)preSelectedRowForPickerType:(int)pickerType {
    
    int preSelect = 0;
    
    switch (pickerType) {
        case titlePicker:
            preSelect = [self preSelectedTitle];
            break;
            
        case languagePicker:
            preSelect = [self preSelectedLanguage];
            break;
            
        case paymentPicker:
            preSelect = [self preSelectedPayment];
            break;
            
        default:
            break;
    }
    
    
    
    return preSelect;
}

- (void)showPicker:(int)pickerType {
    
    if (!_optionsArray || [_optionsArray count] <= 0) return; //no data to display : bail out
    
    [_mainView addSubview:_mainView.maskView];
    _mainView.maskView.hidden = NO;
    _mainView.maskView.alpha = 0;
    
    _selectedPicker = pickerType;
    
    [_mainPickerView reloadAllComponents];
    [_mainPickerView selectRow:[self preSelectedRowForPickerType:pickerType] inComponent:0 animated:NO];
    
    [_mainView addSubview:_mainPickerView];
    
    [_mainView addSubview:self.cancelPickerLabel];
    
    _mainPickerView.center = _actionCenter;
    [self.cancelPickerLabel setCenter:CGPointMake(_mainPickerView.center.x,
                                                  _mainPickerView.center.y+_mainPickerView.bounds.size.height/3*2)];
    
    _mainPickerView.alpha = 0.0;
    self.cancelPickerLabel.alpha = 0.0;
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         _mainView.maskView.alpha = .8;
                         _mainPickerView.alpha = 1.0;
                         _cancelPickerLabel.alpha = 1.0;
                     }];
    
}

- (void)hidePicker {
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         _mainPickerView.alpha = 0.0;
                         _mainView.maskView.alpha = 0.0;
                         _cancelPickerLabel.alpha = 0.0;
                     }
                     completion:^(BOOL done) {
                         [_mainView.maskView removeFromSuperview];
                         [_mainPickerView removeFromSuperview];
                         [_cancelPickerLabel removeFromSuperview];
                     }];
}

- (void)processPickerSelection:(NSInteger)row {
    
    if (_optionsArray == _titles) {
        [self selectUserTitle:row];
    }
    
    else if (_optionsArray == _languages) {
        [self selectUserLanguage:row];
    }
    
    [self hidePicker];
}

- (void)pickerTapped {
    [self hidePicker];
}

#pragma mark addresses

- (void)openAddressesList {
    
    HYBAddressesListViewController *listController = [[HYBAddressesListViewController alloc] initWithBackEndService:self.backendService];
    listController.array = _addresses;
    listController.selectionType = ADDRESS_SELECTION;
    
    if(_mainView.defaultShippingAddress.address) {
        listController.selectedItem = _mainView.defaultShippingAddress.address;
    }
    
    [self.navigationController pushViewController:listController animated:YES];
    
}

- (void)openPaymentDetailsList {
    
    HYBAddressesListViewController *listController = [[HYBAddressesListViewController alloc] initWithBackEndService:self.backendService];
    listController.array = _paymentDetails;
    listController.selectionType = PAYMENT_SELECTION;
    
    if(_mainView.defaultPaymentDetails.paymentDetails) {
        listController.selectedItem = _mainView.defaultPaymentDetails.paymentDetails;
    }
    
    [self.navigationController pushViewController:listController animated:YES];
    
}


@end
