//
//  HYBCreditCardFormViewController.m
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

#import "HYBCreditCardFormViewController.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"
#import "HYBActionButton.h"
#import "HYBDropDownButton.h"

enum selectedPickerType {cardTypePicker, titlePicker, countryPicker};

@interface HYBCreditCardFormViewController ()

@property (nonatomic) HYBAddress *currentAddress;

@property (nonatomic) UILabel *useShippingAddressLabel;

@property (nonatomic) HYBUser   *user;
@property (nonatomic) NSArray   *cardTypes;
@property (nonatomic) HYBCardType *selectedCardType;

@property (nonatomic) NSArray *titles;
@property (nonatomic) NSArray *countries;

@property (nonatomic) NSInteger selectedTitle;
@property (nonatomic) NSInteger selectedCountry;

@property (nonatomic) NSString *safeValue;
@property (nonatomic) NSInteger activeTextfield;
@property (nonatomic) NSArray *textfields;


@property (nonatomic) CGFloat   controlPanelOrigin;
@property (nonatomic) CGFloat   controlPanelOpen;
@property (nonatomic) CGRect    addressFormOpenFrame;
@property (nonatomic) CGRect    addressFormClosedFrame;

@property (nonatomic) BOOL isAddressFormVisible;

@property (nonatomic) UIView         *maskView;

@property (nonatomic) BOOL isScreenUp;

//picker
@property (nonatomic) NSArray         *optionsArray;
@property (nonatomic) UIPickerView    *mainPickerView;
@property (nonatomic) int selectedPicker;
@property (nonatomic) CGPoint actionCenter;
@property (nonatomic) UILabel         *cancelPickerLabel;

//keyboard follow
@property (nonatomic) CGPoint resetPoint;
@property (nonatomic) CGPoint openPoint;

@end



@implementation HYBCreditCardFormViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        self.view.backgroundColor = [UIColor whiteColor];
        
        _selectedTitle = 0;
        _selectedCountry = -1;
        
        _isScreenUp = NO;
    }
    return self;
}

- (void)keyboardWillHide:(NSNotification *)notification {
    
    [self moveDown];
}

- (NSInteger)findCanada {
    for (HYBCountry *country in _countries) {
        if([country.isocode isEqualToString:@"CA"]) {
            return [_countries indexOfObject:country];
        }
    }
    
    return 0;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    //keyboard monitor
    NSNotificationCenter *center = [NSNotificationCenter defaultCenter];
    
    [center addObserver:self selector:@selector(keyboardWillHide:)
                   name:UIKeyboardWillHideNotification
                 object:nil];
    
    _resetPoint = self.view.center;
    _openPoint  = CGPointMake(_resetPoint.x, _resetPoint.y - 275);
    
    //load
    
    
    [PMKPromise when:@[[self loadUser], [self loadTitles], [self loadCountries], [self loadCardTypes]]].then(^(NSArray *results){
        
        for (id object in results) {
            if([object isKindOfClass:[NSArray class]]) {
                if([[object firstObject] isKindOfClass:[HYBTitle class]]) {
                    _titles = [NSArray arrayWithArray:(NSArray*)object];
                }
                
                else if([[object firstObject] isKindOfClass:[HYBCountry class]]) {
                    _countries = [NSArray arrayWithArray:(NSArray*)object];
                    if (_selectedCountry < 0) {
                        _selectedCountry = [self findCanada];
                    }
                }
                
                else if([[object firstObject] isKindOfClass:[HYBCardType class]]) {
                    _cardTypes = [NSArray arrayWithArray:(NSArray*)object];
                }
            }
            
            else  if([object isKindOfClass:[HYBUser class]]) {
                _user = (HYBUser*)object;
            }
        }
        
    })
    
    .then(^(){
        [self setup];
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't load account infos : %@", error.localizedDescription);
    });
}

- (void)moveUp {
    
    if (!_isScreenUp) {
        
        [UIView animateWithDuration:defaultAnimationDuration/2
                         animations:^() {
                             self.view.center = _openPoint;
                         }
                         completion:^(BOOL finished) {
                             _isScreenUp = YES;
                         }];
    }
}

- (void)moveDown {
    
    if (_isScreenUp) {
        [UIView animateWithDuration:defaultAnimationDuration/2
                         animations:^() {
                             self.view.center = _resetPoint;
                         }
                         completion:^(BOOL finished) {
                             _isScreenUp = NO;
                         }];
    }
}

- (void)setup {
    CGFloat margin = defaultToolbarHeight/2;
    
    [self preparePicker];
    
    //mask
    _maskView = [UIView new];
    _maskView.backgroundColor = checkout_mask;
    _maskView.alpha = 0;
    _maskView.hidden = YES;
    _maskView.frame = self.view.frame;
    
    //close
    _cancelButton = [HYBActionButton new];
    [_cancelButton setTitle:NSLocalizedString(@"backKey", nil) forState:UIControlStateNormal];
    [_cancelButton setBackgroundColor:hybris_gray forState:UIControlStateNormal];
    
    [_cancelButton sizeToFit];
    _cancelButton.frame = CGRectInset(_cancelButton.frame, -10, -10);
    _cancelButton.center = CGPointMake([_cancelButton bW]/2 + margin/2, defaultToolbarHeight+margin);
    
    //close interaction
    _cancelButton.userInteractionEnabled = YES;
    UITapGestureRecognizer *closeTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismiss)];
    [_cancelButton addGestureRecognizer:closeTap];
    
    
    //save
    _saveButton = [HYBActionButton new];
    [_saveButton setTitle:NSLocalizedString(@"saveKey", nil) forState:UIControlStateNormal];
    [_saveButton setBackgroundColor:hybris_yellow forState:UIControlStateNormal];
    
    [_saveButton sizeToFit];
    _saveButton.frame = CGRectInset(_saveButton.frame, -10, -10);
    _saveButton.center = CGPointMake([self.view bW] - [_saveButton bW]/2-margin/2, defaultToolbarHeight+margin);
    
    //save interaction
    _saveButton.userInteractionEnabled = YES;
    UITapGestureRecognizer *saveTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(saveOrUpdate)];
    [_saveButton addGestureRecognizer:saveTap];
    
    //credit card info
    CGRect ccFrame = CGRectMake(margin,
                                [_saveButton bottom] + margin,
                                [self.view bW] - margin*2,
                                [self.view bH]/4);
    
    
    _ccFormView = [[HYBCreditCardFormView alloc] initWithFrame:ccFrame];
    
    //ccForm interactions
    [_ccFormView.cardTypeSelector addTarget:self
                                     action:@selector(cardTypeSelectorTap)];
    _ccFormView.cardTypeSelector.accessibilityIdentifier = @"ACCESS_CARDTYPE_SELECTOR";
    
    _ccFormView.accountNameField.delegate = self;
    _ccFormView.cardNumberField.delegate = self;
    _ccFormView.expMonthField.delegate = self;
    _ccFormView.expYearField.delegate = self;
    _ccFormView.cvvField.delegate = self;
    
    //useShippingAddressButton
    _useShippingAddressButton = [HYBActionButton new];
    _useShippingAddressButton.type = checkbox;
    [_useShippingAddressButton setBackgroundColor:checkout_agreement_button_normal   forState:UIControlStateNormal];
    [_useShippingAddressButton setBackgroundColor:checkout_agreement_button_selected forState:UIControlStateSelected];
    
    _useShippingAddressButton.layer.cornerRadius = 4.f;
    _useShippingAddressButton.layer.masksToBounds = YES;
    _useShippingAddressButton.selected = YES;
    
    CGFloat btnSize = 20.f;
    
    _useShippingAddressButton.frame = CGRectMake(margin*2,
                                                 [_ccFormView bottom] + margin,
                                                 btnSize,
                                                 btnSize);
    
    
    [_useShippingAddressButton addTarget:self
                                  action:@selector(toggleUseShippingAddress)
                        forControlEvents:UIControlEventTouchUpInside];
    
    _useShippingAddressLabel = [UILabel new];
    _useShippingAddressLabel.text = NSLocalizedString(@"useDefaultShippingAddress", nil);
    [_useShippingAddressLabel sizeToFit];
    _useShippingAddressLabel.center = CGPointMake([_useShippingAddressButton right] + [_useShippingAddressLabel bW]/2+ margin/2, _useShippingAddressButton.center.y);
    
    //billing address info
    _addressFormContainer = [UIView new];
    _addressFormContainer.clipsToBounds = YES;
    
    _addressFormOpenFrame =  CGRectMake(margin,
                                        [_useShippingAddressButton bottom] + margin/2,
                                        [self.view bW] - 2*margin,
                                        [self.view bH] - [_useShippingAddressButton bottom] - margin*2);
    
    _addressFormClosedFrame =  CGRectMake(margin,
                                          [_useShippingAddressButton bottom] + margin/2,
                                          [self.view bW] - 2*margin,
                                          0);
    
    _addressFormContainer.frame = _addressFormOpenFrame;
    
    CGRect addressFrame = _addressFormContainer.bounds;
    
    //size subview as opened
    _addressFormView = [[HYBAddressFormView alloc] initWithFrame:addressFrame];
    [_addressFormView layoutSubviews];
    
    _addressFormView.formPanel.center = CGPointMake(_addressFormView.formPanel.center.x,
                                                    _addressFormView.formPanel.center.y - defaultToolbarHeight*1.5);
    
    
    //gather fields
    
    _textfields = [NSArray arrayWithObjects:
                   _addressFormView.firstNameField,
                   _addressFormView.lastNameField,
                   _addressFormView.addressLineOneField,
                   _addressFormView.addressLineTwoField,
                   _addressFormView.cityField,
                   _addressFormView.zipCodeField,
                   nil];
    
    //link delegates
    for (UITextField *textfield in _textfields) {
        textfield.delegate = self;
    }
    
    //close container if user have a default address
    
    if([_user.defaultAddress hyb_isNotBlank]) {
        _addressFormContainer.frame = _addressFormClosedFrame;
        _useShippingAddressButton.hidden = NO;
        _useShippingAddressLabel.hidden = NO;

    } else {
        _useShippingAddressButton.selected = NO;
        _useShippingAddressButton.hidden = YES;
        _useShippingAddressLabel.hidden = YES;
    }
    
    //selectors
    [_addressFormView.titleSelector addTarget:self
                                action:@selector(titleSelectorTap)];
    _addressFormView.titleSelector.accessibilityIdentifier = @"ACCESS_ADDRESS_TITLE_SELECTOR";
    
    [_addressFormView.countrySelector addTarget:self
                                  action:@selector(countrySelectorTap)];
    _addressFormView.countrySelector.accessibilityIdentifier = @"ACCESS_ADDRESS_COUNTRY_SELECTOR";
        
    //control Panel
    
    _controlPanel = [UIView new];
    _controlPanel.frame = CGRectMake(margin,
                                     [_useShippingAddressButton bottom] + margin,
                                     [self.view bW] - margin*2,
                                     margin*1.5);
    
    _controlPanelOrigin = _controlPanel.center.y;
    _controlPanelOpen   = [self.view bH] - [_controlPanel bH];
    
    if(![_user.defaultAddress hyb_isNotBlank]) {
        _controlPanel.center = CGPointMake(_controlPanel.center.x, _controlPanelOpen);
    }
    
    //delete button    
    _deleteButton  = [HYBActionButton new];
    [_deleteButton setTitle:NSLocalizedString(@"deleteCardKey", nil) forState:UIControlStateNormal];
    [_deleteButton setBackgroundColor:hybris_red forState:UIControlStateNormal];
    [_deleteButton setTitleColor:hybris_white forState:UIControlStateNormal];
    
    [_deleteButton sizeToFit];
    _deleteButton.frame = CGRectInset(_deleteButton.frame, -10, -10);
    _deleteButton.center = CGPointMake([_ccFormView right] - [_deleteButton bW]/2 , [_ccFormView bottom] + margin/2 + [_deleteButton bH]/2);
    _deleteButton.hidden = YES;
    
    _deleteButton.userInteractionEnabled = YES;
    UITapGestureRecognizer *deleteTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(deleteCard)];
    [_deleteButton addGestureRecognizer:deleteTap];
    
    
    
    //pile up
    
    [self.view  addSubview:_cancelButton];
    [self.view  addSubview:_saveButton];
    
    [self.view addSubview:_ccFormView];
    [self.view addSubview:_deleteButton];
    
    [self.view addSubview:_useShippingAddressButton];
    [self.view addSubview:_useShippingAddressLabel];
    
    [_addressFormContainer addSubview:_addressFormView.formPanel];
    [self.view addSubview:_addressFormContainer];
    
    
    [self.view addSubview:_controlPanel];
    
}

- (void)toggleUseShippingAddress {
    
    BOOL status = [_useShippingAddressButton toggle];
    
    if (!_isAddressFormVisible && !status) {
        [self showAddressFormView];
    }
    
    else if (_isAddressFormVisible && status) {
        [self hideAddressFormView];
    }
}

- (void)showAddressFormViewIfNeeded {
    if(!_isAddressFormVisible) {
        _useShippingAddressButton.hidden = YES;
        _useShippingAddressLabel.hidden = YES;
        
        _controlPanel.center = CGPointMake(_controlPanel.center.x, _controlPanelOpen);
        _addressFormContainer.frame = _addressFormOpenFrame;
        
        _deleteButton.hidden = NO;
    } else {
        _useShippingAddressButton.hidden = NO;
        _useShippingAddressLabel.hidden = NO;
    }
}

- (void)showAddressFormView {
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _controlPanel.center = CGPointMake(_controlPanel.center.x, _controlPanelOpen);
                         _addressFormContainer.frame = _addressFormOpenFrame;
                     }
     
                     completion:^(BOOL finished) {
                         _isAddressFormVisible = YES;
                     }];
}

- (void)hideAddressFormView {
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _controlPanel.center = CGPointMake(_controlPanel.center.x, _controlPanelOrigin);
                         _addressFormContainer.frame = _addressFormClosedFrame;
                     }
     
                     completion:^(BOOL finished) {
                         _isAddressFormVisible = NO;
                     }];
}

- (void)dismiss {
    [self.navigationController popViewControllerAnimated:YES];
}

- (BOOL)validateParams:(NSDictionary *)params {
    
    NSArray *requiredKeys = [NSArray arrayWithObjects:
                             @"accountHolderName",
                             @"billingAddress.country.isocode",
                             @"billingAddress.firstName",
                             @"billingAddress.lastName",
                             @"billingAddress.line1",
                             @"billingAddress.postalCode",
                             @"billingAddress.titleCode",
                             @"billingAddress.town",
                             @"cardNumber",
                             @"cardType",
                             @"expiryMonth",
                             @"expiryYear",
                             nil];
    
    for (NSString *key in requiredKeys) {
        //if any of these key doesn't have value the system can't register a new card
        if (![params[key] hyb_isNotBlank]) {
            [self missingInfoAlert:key];
            return NO;
        }
    }
    
    return YES;
}

- (void)missingInfoAlert:(NSString*)missingKey {
    
    NSString *fieldKey = NSLocalizedString(missingKey, nil);
    
    NSString *msg = [NSString stringWithFormat:@"%@: %@", NSLocalizedString(@"missingKey", nil), fieldKey ];
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"warningMissingKey", @"")
                                                    message: msg
                                                   delegate:self
                                          cancelButtonTitle:NSLocalizedString(@"Ok", @"Ok")
                                          otherButtonTitles:nil];
    [alert show];
}

- (void)saveOrUpdate {
    
    if([_currentPaymentDetails hyb_isNotBlank]) {
        [self update];
    } else {
        [self save];
    }
}

- (void)update {
    
    NSDictionary *params = [NSDictionary FULLFields:[self packageCardParams]];
    
    if([self validateParams:params]) {
        
        [self updatePaymentdetailsWithParams:params]
        
        .then(^(id responseObject) {
            
            [self dismiss];
        })
        
        .catch(^(NSError *error){
            DDLogDebug(@"Couldn't update card");
            DDLogDebug(@"%@",error.localizedDescription);
        });
    }
}

- (void)save {
    
    NSDictionary *params = [NSDictionary FULLFields:[self packageCardParams]];
    
    if([self validateParams:params]) {
        
        [self createPaymentdetailsWithParams:params]
        
        .then(^(id responseObject) {
            
            [self dismiss];
        })
        
        .catch(^(NSError *error){
            DDLogDebug(@"Couldn't save new card");
            DDLogDebug(@"%@",error.localizedDescription);
        });
    }
}

- (void)deleteCard {
    
    [self deletePaymentdetails]
    
    .then(^(id responseObject) {
        
        [self dismiss];
    })
    
    .catch(^(NSError *error){
        DDLogDebug(@"Couldn't delete card");
        DDLogDebug(@"%@",error.localizedDescription);
    });
    
}

- (NSDictionary*)packageCardParams {
    NSMutableDictionary *tmpDict = [NSMutableDictionary dictionary];
    
    HYBAddress *tmpAddress = nil;
    
    if ([_user.defaultAddress hyb_isNotBlank] && _useShippingAddressButton.selected && !_useShippingAddressButton.hidden) {
        tmpAddress = _user.defaultAddress;
    } else {
        tmpAddress = [HYBAddress new];
        
        NSString *tmpTitleCode      = @"mr";
        NSString *tmpCountryCode    = @"CA";
        
        if([_titles hyb_isNotBlank]) {
            tmpTitleCode = [(HYBTitle*)_titles[_selectedTitle] code];
        }
        
        if([_countries hyb_isNotBlank]) {
            tmpCountryCode = [(HYBCountry*)_countries[_selectedCountry] isocode];
        }
        
        tmpAddress.titleCode    = tmpTitleCode;
        tmpAddress.firstName    = _addressFormView.firstNameField.text;
        tmpAddress.lastName     = _addressFormView.lastNameField.text;
        tmpAddress.line1        = _addressFormView.addressLineOneField.text;
        tmpAddress.line2        = _addressFormView.addressLineTwoField.text;
        tmpAddress.town         = _addressFormView.cityField.text;
        
        HYBRegion *region = [HYBRegion new];
        region.isocode   = @"CA-QC";
        tmpAddress.region   = region;
        
        tmpAddress.postalCode   = _addressFormView.zipCodeField.text;
        
        HYBCountry  *country = [HYBCountry new];
        country.isocode  = tmpCountryCode;
        tmpAddress.country = country;
    }
    
    if([tmpAddress.titleCode hyb_isNotBlank])   tmpDict[@"billingAddress.titleCode"]    = tmpAddress.titleCode;
    else  tmpDict[@"billingAddress.titleCode"]    = @"mr";
    
    if([tmpAddress.firstName hyb_isNotBlank])   tmpDict[@"billingAddress.firstName"]    = tmpAddress.firstName;
    if([tmpAddress.lastName hyb_isNotBlank])    tmpDict[@"billingAddress.lastName"]     = tmpAddress.lastName;
    if([tmpAddress.line1 hyb_isNotBlank])       tmpDict[@"billingAddress.line1"]        = tmpAddress.line1;
    if([tmpAddress.line2 hyb_isNotBlank])       tmpDict[@"billingAddress.line2"]        = tmpAddress.line2;
    if([tmpAddress.town hyb_isNotBlank])        tmpDict[@"billingAddress.town"]                 = tmpAddress.town;
    if([tmpAddress.region.isocode hyb_isNotBlank])  tmpDict[@"billingAddress.region.isocode"]   = tmpAddress.region.isocode;
    if([tmpAddress.postalCode hyb_isNotBlank])      tmpDict[@"billingAddress.postalCode"]       = tmpAddress.postalCode;
    if([tmpAddress.country.isocode hyb_isNotBlank]) tmpDict[@"billingAddress.country.isocode"]  = tmpAddress.country.isocode;
    
    if([_ccFormView.cardNumberField.text hyb_isNotBlank])   tmpDict[@"cardNumber"]          = _ccFormView.cardNumberField.text;
    if([_selectedCardType.code hyb_isNotBlank])             tmpDict[@"cardType"]            = _selectedCardType.code;
    if([_ccFormView.accountNameField.text hyb_isNotBlank])  tmpDict[@"accountHolderName"]   = _ccFormView.accountNameField.text;
    
    if([_ccFormView.expMonthField.text hyb_isNotBlank])     tmpDict[@"expiryMonth"] = _ccFormView.expMonthField.text;
    if([_ccFormView.expYearField.text hyb_isNotBlank])      tmpDict[@"expiryYear"]  = _ccFormView.expYearField.text;
    if([_ccFormView.cvvField.text hyb_isNotBlank])      tmpDict[@"issueNumber"]  = _ccFormView.cvvField.text;
    
    return [NSDictionary dictionaryWithDictionary:tmpDict];
}

#pragma mark picker

- (void)preparePicker {
    //prepare picker
    [self setMainPickerView:[UIPickerView new]];
    [_mainPickerView setDataSource:self];
    [_mainPickerView setDelegate:self];
    
    CGFloat margin = 20.f;
    
    CGRect pickerFrame = CGRectMake([_mainPickerView fX], [_mainPickerView fY], [self.view bW] - margin*2, [_mainPickerView bH]);
    _mainPickerView.frame = pickerFrame;
    
    UITapGestureRecognizer *pickerTapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(pickerTapped)];
    [_mainPickerView addGestureRecognizer:pickerTapRecognizer];
    pickerTapRecognizer.delegate = self;
    
    //mask tap dismiss pickers
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(hidePicker)];
    [self.maskView addGestureRecognizer:tapRecognizer];
    
    //tap invite
    _cancelPickerLabel = [UILabel new];
    _cancelPickerLabel.text = NSLocalizedString(@"cancel", @"");
    _cancelPickerLabel.textAlignment = NSTextAlignmentCenter;
    [self.cancelPickerLabel sizeToFit];
    _cancelPickerLabel.frame = CGRectInset(self.cancelPickerLabel.frame, -20, -10);
    _cancelPickerLabel.backgroundColor = [UIColor colorWithHexString:@"#fad712"];
    
}

- (NSInteger)preSelectedRowForPickerType:(int)pickerType {
    
    NSInteger preSelect = 0;
    
    switch (pickerType) {
        case cardTypePicker:
            preSelect = [self preSelectedCard];
            break;
            
        case titlePicker:
            preSelect = [self preSelectedTitle];
            break;
            
        case countryPicker:
            preSelect = [self preSelectedCountry];
            break;
            
        default:
            break;
    }
    
    
    
    return preSelect;
}

- (NSInteger)preSelectedCard {
    
    NSInteger count = 0;
    BOOL didFind = NO;
    
    for (HYBCardType *obj in _cardTypes) {
        if([obj.code isEqualToString:_selectedCardType.code]) {
            didFind = YES;
            break;
        } else {
            count++;
        }
    }
    
    if(!didFind) count = 0;
    
    return count;
}

- (NSInteger)preSelectedTitle {
    NSInteger count = 0;
    BOOL didFind = NO;
    
    if([_currentAddress hyb_isNotBlank]) {
        for (HYBTitle *obj in _titles) {
            if([obj.code isEqualToString:_currentAddress.titleCode]) {
                didFind = YES;
                break;
            } else {
                count++;
            }
        }
        
        if(!didFind) count = 0;
        
        _selectedTitle = count;
    } else {
        count = _selectedTitle;
    }
    return count;
}

- (NSInteger)preSelectedCountry {
    NSInteger count = 0;
    BOOL didFind = NO;
    
    if([_currentAddress hyb_isNotBlank]) {
        for (HYBCountry *obj in _countries) {
            if([obj.isocode isEqualToString:_currentAddress.country.isocode]) {
                didFind = YES;
                break;
            } else {
                count++;
            }
        }
        
        if(!didFind) count = 0;
        
        _selectedCountry = count;
    } else {
        count = _selectedCountry;
    }
    return count;
}

- (void)showPicker:(int)pickerType {
    
    if (!_optionsArray || [_optionsArray count] <= 0) return; //no data to display : bail out
    
    [self.view addSubview:self.maskView];
    self.maskView.hidden = NO;
    self.maskView.alpha = 0;
    
    _selectedPicker = pickerType;
    
    [_mainPickerView reloadAllComponents];
    [_mainPickerView selectRow:[self preSelectedRowForPickerType:pickerType] inComponent:0 animated:NO];
    
    [self.view addSubview:_mainPickerView];
    
    [self.view addSubview:self.cancelPickerLabel];
    
    _mainPickerView.center = _actionCenter;
    [self.cancelPickerLabel setCenter:CGPointMake(_mainPickerView.center.x,
                                                  _mainPickerView.center.y+_mainPickerView.bounds.size.height/3*2)];
    
    _mainPickerView.alpha = 0.0;
    self.cancelPickerLabel.alpha = 0.0;
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         self.maskView.alpha = .8;
                         _mainPickerView.alpha = 1.0;
                         _cancelPickerLabel.alpha = 1.0;
                     }];
    
}

- (void)hidePicker {
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^{
                         _mainPickerView.alpha = 0.0;
                         self.maskView.alpha = 0.0;
                         _cancelPickerLabel.alpha = 0.0;
                     }
                     completion:^(BOOL done) {
                         [self.maskView removeFromSuperview];
                         [_mainPickerView removeFromSuperview];
                         [_cancelPickerLabel removeFromSuperview];
                         
                         [self refresh];
                     }];
}

- (void)processPickerSelection:(NSInteger)row {
    
    if (_optionsArray == _cardTypes) {
        [self selectCardType:row];
    }
    
    else  if (_optionsArray == _titles) {
        _selectedTitle = row;
        if ([_currentAddress hyb_isNotBlank]) {
            _currentAddress.titleCode   = [(HYBTitle*)_titles[_selectedTitle] code];
            _currentAddress.title       = [(HYBTitle*)_titles[_selectedTitle] name];
        }
        
        if (_currentPaymentDetails) {
            _currentPaymentDetails.billingAddress = _currentAddress;
        }
    }
    
    else if (_optionsArray == _countries) {
        _selectedCountry = row;
        if ([_currentAddress hyb_isNotBlank]) {
            _currentAddress.country = (HYBCountry*)_countries[_selectedCountry];
        }
        
        if (_currentPaymentDetails) {
            _currentPaymentDetails.billingAddress = _currentAddress;
        }
    }
    
    [self hidePicker];
}

- (void)pickerTapped {
    [self hidePicker];
}

- (void)setCurrentAddress:(HYBAddress *)currentAddress {
    _currentAddress = currentAddress;
    
    [self refresh];
}

- (void)refresh {
    
    if (_currentPaymentDetails) {
        
        _selectedCardType = _currentPaymentDetails.cardType;
        
        _currentAddress = _currentPaymentDetails.billingAddress;
        
        _ccFormView.cardTypeSelector.text   = _selectedCardType.name;
        _ccFormView.accountNameField.text   = _currentPaymentDetails.accountHolderName;
        _ccFormView.cardNumberField.text    = _currentPaymentDetails.cardNumber;
        _ccFormView.expMonthField.text      = _currentPaymentDetails.expiryMonth;
        _ccFormView.expYearField.text       = _currentPaymentDetails.expiryYear;
        _ccFormView.cvvField.text           = _currentPaymentDetails.issueNumber;

        [self showAddressFormViewIfNeeded];
    }
    
    if ([_currentAddress hyb_isNotBlank]) {
        _addressFormView.titleLabel.text = NSLocalizedString(@"editAddressKey", nil);
        
        _addressFormView.firstNameField.text       = _currentAddress.firstName;
        _addressFormView.lastNameField.text        = _currentAddress.lastName;
        _addressFormView.addressLineOneField.text  = _currentAddress.line1;
        _addressFormView.addressLineTwoField.text  = _currentAddress.line2;
        _addressFormView.cityField.text            = _currentAddress.town;
        _addressFormView.zipCodeField.text         = _currentAddress.postalCode;
        
    } else {
        _addressFormView.titleLabel.text = NSLocalizedString(@"newAddressKey", nil);
    }
    
    [self preSelectedTitle];
    [self preSelectedCountry];
    
    if([_titles hyb_isNotBlank])    _addressFormView.titleSelector.text    = [_titles[_selectedTitle] name];
    if([_countries hyb_isNotBlank]) _addressFormView.countrySelector.text  = [_countries[_selectedCountry] name];
}

#pragma mark apply selection

- (void)selectCardType:(NSInteger)row {
    
    _selectedCardType = (HYBCardType*)_optionsArray[row];
    _ccFormView.cardTypeSelector.text = _selectedCardType.name;
    
     if (_currentPaymentDetails) {
         _currentPaymentDetails.cardType = _selectedCardType;
     }
}

#pragma mark dropdown actions

- (void)resignAllResponder {
    [[_ccFormView findFirstResponder] resignFirstResponder];
    [[_addressFormView.formPanel findFirstResponder] resignFirstResponder];
}

- (void)cardTypeSelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(self.view.center.x, _ccFormView.cardTypeSelector.center.y + [_mainPickerView bH]/2 );
    
    _optionsArray = _cardTypes;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_CARDTYPES";
    
    if ([_cardTypes count] > 1) {
        [self showPicker:cardTypePicker];
    }
    
}

- (void)titleSelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(self.view.center.x, _addressFormContainer.frame.origin.y + _addressFormView.titleSelector.center.y + [_mainPickerView bH]/2 - 114 );
    
    _optionsArray = _titles;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_TITLE";
    
    if ([_titles count] > 1) {
        [self showPicker:titlePicker];
    }
}

- (void)countrySelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(self.view.center.x, _addressFormContainer.frame.origin.y +  _addressFormView.countrySelector.center.y + [_mainPickerView bH]/2 - 170 );
    
    _optionsArray = _countries;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_COUNTRY";
    
    if ([_countries count] > 1) {
        [self showPicker:countryPicker];
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
    
    if(_optionsArray == _cardTypes) {
        label = [(HYBCardType*)object name];
    }
    
    else if(_optionsArray == _titles) {
        label = [(HYBTitle*)object name];
    }
    
    else if(_optionsArray == _countries) {
        label = [(HYBCountry*)object name];
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

#pragma mark textfield delegate


- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    
    //card fields
    if (textField == _ccFormView.accountNameField) {
        [_ccFormView.cardNumberField becomeFirstResponder];
    } else if (textField == _ccFormView.cardNumberField) {
        [_ccFormView.expMonthField becomeFirstResponder];
    } else if (textField == _ccFormView.expMonthField) {
        [_ccFormView.expYearField becomeFirstResponder];
    } else if (textField == _ccFormView.expYearField) {
        [_ccFormView.cvvField becomeFirstResponder];
    } else {
        
        //address fields
        if (_activeTextfield < _textfields.count-1) {
            [_textfields[++_activeTextfield] becomeFirstResponder];
        } else {
            _activeTextfield = -1;
            [textField resignFirstResponder];
        }
    }
    
    return NO;
}

- (void)textFieldDidBeginEditing:(UITextField *)textField {
    
    if([_textfields containsObject:textField]) {
        _activeTextfield = [_textfields indexOfObject:textField];
        [self moveUp];
    } else {
        _activeTextfield = -1;
    }
}

- (void)textFieldDidEndEditing:(UITextField *)textField {
    
    if (_currentPaymentDetails) {
        if (textField == _ccFormView.accountNameField) {
            _currentPaymentDetails.accountHolderName = _ccFormView.accountNameField.text;
        }
        
        else if (textField == _ccFormView.cardNumberField) {
            _currentPaymentDetails.cardNumber = _ccFormView.cardNumberField.text;
        }
        
        else if (textField == _ccFormView.expMonthField) {
            _currentPaymentDetails.expiryMonth = _ccFormView.expMonthField.text;
        }
        
        else if (textField == _ccFormView.expYearField) {
            _currentPaymentDetails.expiryYear = _ccFormView.expYearField.text;
        }
        
        else if (textField == _ccFormView.cvvField) {
            _currentPaymentDetails.issueNumber = _ccFormView.cvvField.text;
        }
    }
}

#pragma mark promises



- (PMKPromise *)deletePaymentdetails {
    
    NSLog(@"PMKPromise deletePaymentdetails");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService deleteUserPaymentdetailsForUserId:self.backendService.userId
                                       andPaymentdetailsId:_currentPaymentDetails.id
                                                andExecute:^(id responseObject, NSError* error) {
                                                        if (error) {
                                                            reject(error);
                                                        } else {
                                                            fulfill(responseObject);
                                                        }
                                                    }];
    }];
}

- (PMKPromise *)updatePaymentdetailsWithParams:(NSDictionary*)params {
    
    NSLog(@"PMKPromise updatePaymentdetailsWithParams");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService updateUserPaymentdetailsForUserId:self.backendService.userId
                                       andPaymentdetailsId:_currentPaymentDetails.id
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

- (PMKPromise *)createPaymentdetailsWithParams:(NSDictionary*)params {
    
    NSLog(@"PMKPromise createPaymentdetails");
    
    HYBCart *cart = [self.backendService currentCartFromCache];
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService createCartPaymentdetailsForUserId:self.backendService.userId
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

- (PMKPromise *)loadCountries {
    
    NSLog(@"PMKPromise loadCountries");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getDeliverycountriesAndExecute:^(id responseObject, NSError* error) {
            if (error) {
                reject(error);
            } else {
                fulfill(responseObject);
            }
        }];
    }];
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

- (PMKPromise *)loadCardTypes {
    
    NSLog(@"PMKPromise loadCardTypes");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getCardtypesAndExecute:^(id responseObject, NSError* error) {
            if (error) {
                reject(error);
            } else {
                fulfill(responseObject);
            }
        }];
    }];
}

@end
