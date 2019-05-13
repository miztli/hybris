//
//  HYBAddressFormViewController.m
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

#import "HYBAddressFormViewController.h"
#import "HYBAddressFormView.h"

@interface HYBAddressFormViewController ()

@property (nonatomic) HYBAddressFormView *mainView;
@property (nonatomic) NSInteger activeTextfield;
@property (nonatomic) NSArray *textfields;

@property (nonatomic) NSArray *titles;
@property (nonatomic) NSArray *countries;

@property (nonatomic) NSInteger selectedTitle;
@property (nonatomic) NSInteger selectedCountry;

//picker
@property (nonatomic) NSArray         *optionsArray;
@property (nonatomic) UIPickerView    *mainPickerView;
@property (nonatomic) int selectedPicker;
@property (nonatomic) CGPoint actionCenter;
@property (nonatomic) UILabel         *cancelPickerLabel;

@end

enum selectedPickerType {titlePicker, countryPicker};

@implementation HYBAddressFormViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        self.view.backgroundColor = [UIColor whiteColor];
        
        _selectedTitle = 0;
        _selectedCountry = -1;
        
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) {
        _mainView = [HYBAddressFormView new];
        
        //save interaction
        _mainView.saveButton.userInteractionEnabled = YES;
        UITapGestureRecognizer *saveTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(save)];
        [_mainView.saveButton addGestureRecognizer:saveTap];
        
        //close interaction
        _mainView.closeButton.userInteractionEnabled = YES;
        UITapGestureRecognizer *closeTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismiss)];
        [_mainView.closeButton addGestureRecognizer:closeTap];
        
        //selectors
        [_mainView.titleSelector addTarget:self
                                    action:@selector(titleSelectorTap)];
        _mainView.titleSelector.accessibilityIdentifier = @"ACCESS_ADDRESS_TITLE_SELECTOR";
        
        [_mainView.countrySelector addTarget:self
                                       action:@selector(countrySelectorTap)];
        _mainView.countrySelector.accessibilityIdentifier = @"ACCESS_ADDRESS_COUNTRY_SELECTOR";
        
        //gather fields
        _activeTextfield = -1;
        
        _textfields = [NSArray arrayWithObjects:
                       _mainView.firstNameField,
                       _mainView.lastNameField,
                       _mainView.addressLineOneField,
                       _mainView.addressLineTwoField,
                       _mainView.cityField,
                       _mainView.zipCodeField,
                       nil];
        
        //link delegates
        for (UITextField *textfield in _textfields) {
            textfield.delegate = self;
        }
        
    }
    
    self.view = _mainView;
}

- (NSInteger)findCanada {
    for (HYBCountry *country in _countries) {
        if([country.isocode isEqualToString:@"CA"]) {
            return [_countries indexOfObject:country];
        }
    }
    
    return 0;
}

- (void)loadData {
    
    //load data
    [PMKPromise when:@[[self loadTitles], [self loadCountries]]].then(^(NSArray *results){
        
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
            }
        }
        
    })
    
    .then(^(){
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't load account infos : %@", error.localizedDescription);
    });

}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    
    [self preparePicker];
    
    [self loadData];
}

- (void)setCurrentAddress:(HYBAddress *)currentAddress {
    _currentAddress = currentAddress;
    
    _mainView.titleLabel.text = NSLocalizedString(@"editAddressKey", nil);
    
    _mainView.firstNameField.text       = _currentAddress.firstName;
    _mainView.lastNameField.text        = _currentAddress.lastName;
    _mainView.addressLineOneField.text  = _currentAddress.line1;
    _mainView.addressLineTwoField.text  = _currentAddress.line2;
    _mainView.cityField.text            = _currentAddress.town;
    _mainView.zipCodeField.text         = _currentAddress.postalCode;
    
}

- (void)refresh {
    if (![_currentAddress hyb_isNotBlank]) {
        _mainView.titleLabel.text = NSLocalizedString(@"newAddressKey", nil);
    }
    
    [self preSelectedTitle];
    [self preSelectedCountry];
    
    if([_titles hyb_isNotBlank])    _mainView.titleSelector.text    = [_titles[_selectedTitle] name];
    if([_countries hyb_isNotBlank]) _mainView.countrySelector.text  = [_countries[_selectedCountry] name];
}

- (BOOL)isAddressComplete {
    
    if(![_mainView.firstNameField.text hyb_isNotBlank])     return NO;
    if(![_mainView.lastNameField.text hyb_isNotBlank])      return NO;
    if(![_mainView.addressLineOneField.text hyb_isNotBlank])return NO;
    if(![_mainView.cityField.text hyb_isNotBlank])          return NO;
    if(![_mainView.zipCodeField.text hyb_isNotBlank])       return NO;
    
    return YES;
    
}

- (void)save {
    
    if ([self isAddressComplete]) {
        
        NSMutableDictionary *tmpDict = [NSMutableDictionary dictionary];

        //static for now, too much UI to do for a sample app
        NSString *tmpTitleCode      = @"mr";
        NSString *tmpCountryCode    = @"CA";
        
        if([_titles hyb_isNotBlank]) tmpTitleCode = [(HYBTitle*)_titles[_selectedTitle] code];
        [tmpDict setValue:tmpTitleCode forKey:@"titleCode"];
        
        if([_countries hyb_isNotBlank]) tmpCountryCode = [(HYBCountry*)_countries[_selectedCountry] isocode];
        [tmpDict setValue:tmpCountryCode forKey:@"country.isocode"];
        
        //fuck up of the OCC team around regions...
        if ([tmpCountryCode isEqualToString:@"CA"]) {
            [tmpDict setValue:@"CA-QC" forKey:@"region.isocode"];
        }
        
        if(_isDefaultAddress) [tmpDict setValue:@"true"   forKey:@"defaultAddress"];
        
        [tmpDict setValue:_mainView.firstNameField.text         forKey:@"firstName"];
        [tmpDict setValue:_mainView.lastNameField.text          forKey:@"lastName"];
        [tmpDict setValue:_mainView.addressLineOneField.text    forKey:@"line1"];
        if([_mainView.addressLineTwoField.text hyb_isNotBlank]) [tmpDict setValue:_mainView.addressLineTwoField.text    forKey:@"line2"];
        [tmpDict setValue:_mainView.cityField.text              forKey:@"town"];
        [tmpDict setValue:_mainView.zipCodeField.text           forKey:@"postalCode"];
        
        NSDictionary *params = [NSDictionary dictionaryWithDictionary:tmpDict];
        
       //save new or update
        if([_currentAddress hyb_isNotBlank]) {
            [self updateCurrentAddress:params];
        } else {
            [self saveNewAddress:params];
        }
        
    } else {
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"warningKey", nil)
                                                        message:NSLocalizedString(@"please_complete_form", nil)
                                                       delegate:nil
                                              cancelButtonTitle:NSLocalizedString(@"okayKey", nil) otherButtonTitles:nil];
        
        [alert show];
    }
}

- (void)saveNewAddress:(NSDictionary*)params {
    
    [self.backendService createUserAddressForUserId:self.backendService.userId
                                    withParams:params
                                    andExecute:^(id response, NSError *error ) {
                                        if (error) {
                                            DDLogDebug(@"Couldn't save new address");
                                            DDLogDebug(@"%@", error.localizedDescription);
                                        } else {
                                            [self dismiss];
                                        }
                                    }];
    
}




- (void)updateCurrentAddress:(NSDictionary*)params {
    
    [self.backendService replaceUserAddressForUserId:self.backendService.userId
                                andAddressId:_currentAddress.id
                                  withParams:params
                                  andExecute:^(id response, NSError *error ) {
                                      if (error) {
                                          DDLogDebug(@"Couldn't update new address");
                                          DDLogDebug(@"%@", error.localizedDescription);
                                      } else {
                                          [self dismiss];
                                      }
                                  }];
    
}


- (void)dismiss {
    [self.navigationController popViewControllerAnimated:YES];
}

#pragma mark textfield delegate

- (void)textFieldDidBeginEditing:(UITextField *)textField {
    _activeTextfield = [_textfields indexOfObject:textField];
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    
    if (_activeTextfield < _textfields.count-1) {
        [_textfields[++_activeTextfield] becomeFirstResponder];
    } else {
        _activeTextfield = -1;
        [textField resignFirstResponder];
    }
    
    return NO;
}

#pragma mark dropdown actions

- (void)resignAllResponder {
    [_mainView.firstNameField resignFirstResponder];
    [_mainView.lastNameField  resignFirstResponder];
}

- (void)titleSelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(_mainView.center.x, _mainView.formPanel.frame.origin.y + _mainView.titleSelector.center.y + [_mainPickerView bH]/2 - 28 );
    
    _optionsArray = _titles;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_TITLE";
    
    if ([_titles count] > 1) {
        [self showPicker:titlePicker];
    }
}

- (void)countrySelectorTap {
    
    [self resignAllResponder];
    
    _actionCenter = CGPointMake(_mainView.center.x, _mainView.formPanel.frame.origin.y + _mainView.countrySelector.center.y + [_mainPickerView bH]/2 - 28 );
    
    _optionsArray = _countries;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_COUNTRY";
    
    if ([_countries count] > 1) {
        [self showPicker:countryPicker];
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

#pragma mark pickerview management

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

- (NSInteger)preSelectedRowForPickerType:(int)pickerType {
    
    NSInteger preSelect = 0;
    
    switch (pickerType) {
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
                         
                         [self refresh];
                     }];
}

- (void)processPickerSelection:(NSInteger)row {
    
    if (_optionsArray == _titles) {
        _selectedTitle = row;
        if ([_currentAddress hyb_isNotBlank]) {
            _currentAddress.titleCode   = [(HYBTitle*)_titles[_selectedTitle] code];
            _currentAddress.title       = [(HYBTitle*)_titles[_selectedTitle] name];
        }
    }
    
    else if (_optionsArray == _countries) {
        _selectedCountry = row;
        if ([_currentAddress hyb_isNotBlank]) {
            _currentAddress.country = (HYBCountry*)_countries[_selectedCountry];
        }
    }
    
    [self hidePicker];
}

- (void)pickerTapped {
    [self hidePicker];
}


#pragma mark promises

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

@end
