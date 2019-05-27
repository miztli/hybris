//
//  HYBSignUpViewController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBSignUpViewController.h"
#import "HYBSignUpView.h"

@interface HYBSignUpViewController ()

@property (nonatomic) HYBSignUpView *mainView;

@property (nonatomic) NSArray *titles;

//picker
@property (nonatomic) NSArray         *optionsArray;
@property (nonatomic) UIPickerView    *mainPickerView;
@property (nonatomic) int selectedPicker;
@property (nonatomic) NSInteger selectUserTitle;
@property (nonatomic) CGPoint actionCenter;
@property (nonatomic) UILabel         *cancelPickerLabel;


@end

enum selectedPickerType {titlePicker};

@implementation HYBSignUpViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    if (!_mainView) {
        _mainView = [HYBSignUpView new];
        
        _mainView.firstNameField.delegate       = self;
        _mainView.lastNameField.delegate        = self;
        _mainView.loginField.delegate           = self;
        _mainView.passwordField.delegate        = self;
        _mainView.verifyPasswordField.delegate  = self;
        
        //selectors
        [_mainView.titleCodeDrop addTarget:self
                                    action:@selector(titleSelectorTap)];
        _mainView.titleCodeDrop.accessibilityIdentifier = @"ACCESS_ACCOUNT_TITLE";
        
        
        
        _mainView.closeButton.userInteractionEnabled = YES;
        UITapGestureRecognizer *closeTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(back)];
        [_mainView.closeButton addGestureRecognizer:closeTap];
     
        _mainView.saveButton.userInteractionEnabled = YES;
        UITapGestureRecognizer *saveTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(processForm)];
        [_mainView.saveButton addGestureRecognizer:saveTap];
        
    }
    
    self.view = _mainView;
    
}

- (void)back {
    [self dismissViewControllerAnimated:YES
                             completion:^{
                                 
                             }];
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
    
    [self preparePicker];
    
    //load data
   [self loadTitles]
    
    .then(^(id responseObject){
          _titles = [NSArray arrayWithArray:(NSArray*)responseObject];
        _selectUserTitle = 0;
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't load account infos : %@", error.localizedDescription);
    });
    
}

- (void)refresh {
     _mainView.titleCodeDrop.text = [_titles[_selectUserTitle] name];
}

- (void)resizePicker {
    CGFloat margin = 20.f;
    
    CGRect pickerFrame = CGRectMake([_mainPickerView bX], [_mainPickerView fY], [_mainView bW] - margin*2, [_mainPickerView bH]);
    _mainPickerView.frame = pickerFrame;
    
    _cancelPickerLabel.frame = CGRectInset(self.cancelPickerLabel.frame, -20, -10);
}

- (void)preparePicker {
    //prepare picker
    [self setMainPickerView:[UIPickerView new]];
    [_mainPickerView setDataSource:self];
    [_mainPickerView setDelegate:self];
    
    UITapGestureRecognizer *pickerTapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                          action:@selector(pickerTapped)];
    [_mainPickerView addGestureRecognizer:pickerTapRecognizer];
    pickerTapRecognizer.delegate = self;
    
    //mask tap dismiss pickers
    UITapGestureRecognizer *tapRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                    action:@selector(hidePicker)];
    [_mainView.maskView addGestureRecognizer:tapRecognizer];
    
    //tap invite
    _cancelPickerLabel = [UILabel new];
    _cancelPickerLabel.text = NSLocalizedString(@"cancel", @"");
    _cancelPickerLabel.textAlignment = NSTextAlignmentCenter;
    [self.cancelPickerLabel sizeToFit];
    
    _cancelPickerLabel.backgroundColor = [UIColor colorWithHexString:@"#fad712"];
    
    [self resizePicker];
    
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

#pragma mark alert

- (void)saveProblemAlert:(NSString*)message {
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"account_warning", nil)
                                                        message:NSLocalizedString(message, nil)
                                                       delegate:self
                                              cancelButtonTitle:NSLocalizedString(@"okayKey", nil)
                                              otherButtonTitles:nil];
    
    [alertView show];
}

#pragma mark textfield delegate

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    
    if (textField == _mainView.firstNameField) {
        [_mainView.lastNameField becomeFirstResponder];
    }
    
    else  if (textField == _mainView.lastNameField) {
        [_mainView.loginField becomeFirstResponder];
    }
    
    else  if (textField == _mainView.loginField) {
        [_mainView.passwordField becomeFirstResponder];
    }
    
    else  if (textField == _mainView.passwordField) {
        [_mainView.verifyPasswordField becomeFirstResponder];
    }
    
    else  if (textField == _mainView.verifyPasswordField) {
        [_mainView.verifyPasswordField resignFirstResponder];
        [self processForm];
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
    
    _actionCenter = CGPointMake(_mainView.bW/2, _mainView.titleCodeDrop.center.y + [_mainPickerView bH]/2 - 28 );
    
    _optionsArray = _titles;
    
    _mainPickerView.accessibilityIdentifier = @"ACCESS_PICKER_TITLE";
    
    if ([_titles count] > 1) {
        [self showPicker:titlePicker];
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


- (void)showPicker:(int)pickerType {
    
    if (!_optionsArray || [_optionsArray count] <= 0) return; //no data to display : bail out
    
    [self resizePicker];
    
    [_mainView addSubview:_mainView.maskView];
    _mainView.maskView.hidden = NO;
    _mainView.maskView.alpha = 0;
    
    _selectedPicker = pickerType;
    
    [_mainPickerView reloadAllComponents];
    [_mainPickerView selectRow:_selectUserTitle inComponent:0 animated:NO];
    
    [_mainView addSubview:_mainPickerView];
    
    [_mainView addSubview:self.cancelPickerLabel];
    
    _mainPickerView.center = _actionCenter;
    
    CGPoint labelCenter = CGPointMake(_mainPickerView.center.x,
                                      _mainPickerView.center.y+_mainPickerView.bounds.size.height/3*2);
    _cancelPickerLabel.center = labelCenter;
    
    _mainPickerView.alpha = 0.0;
    _cancelPickerLabel.alpha = 0.0;
    
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
        _selectUserTitle = row;
        [self refresh];
    }
    
    [self hidePicker];
}

- (void)pickerTapped {
    [self hidePicker];
}

#pragma mark processForm

- (BOOL)hasMissingField {
    if (![_mainView.firstNameField.text hyb_isNotBlank])    return YES;
    if (![_mainView.lastNameField.text hyb_isNotBlank])     return YES;
    if (![_mainView.loginField.text hyb_isNotBlank])        return YES;
    if (![_mainView.passwordField.text hyb_isNotBlank])         return YES;
    if (![_mainView.verifyPasswordField.text hyb_isNotBlank])   return YES;
    
    return NO;
}

- (void)processForm {
    
    if ([self hasMissingField]) {
        [self saveProblemAlert:NSLocalizedString(@"all_fields_required", nil)];
    }
    
    else if (![_mainView.passwordField.text isEqualToString:_mainView.verifyPasswordField.text]) {
        [self saveProblemAlert:NSLocalizedString(@"singup_password_missmatch", nil)];
    }
    
    else {
        
        NSString *currentGuid = nil;
        
        NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                                _mainView.firstNameField.text,@"firstName",
                                _mainView.lastNameField.text, @"lastName",
                                _mainView.passwordField.text,@"password",
                                _mainView.loginField.text,@"login",
                                [(HYBTitle*)_titles[_selectUserTitle] code],@"titleCode",
                                currentGuid,@"guid",
                                nil];
        
        [self registerUserWithParams:params];
        
    }
}

- (void)registerUserWithParams:(NSDictionary *)params {
    
    [self getTrustedClientStatus]
    
    .then(^(id responseObject){
        return [self promiseRegisterUserWithParams:params];
    })
    
    .then(^(id responseObject){
        if(_loginViewController) {
            [_loginViewController loginWithUser:params[@"login"] pass:params[@"password"]];
        }
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't register user : %@", error.localizedDescription);
        [self saveProblemAlert:error.localizedDescription];
    });
    
}

- (PMKPromise *)getTrustedClientStatus {
    NSLog(@"PMKPromise getTrustedClientStatus");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService makeGuestTrustedClientAndExecute:^(id responseObject, NSError* error) {
                                             if (error) {
                                                 reject(error);
                                             } else {
                                                 fulfill(responseObject);
                                             }
                                         }];
    }];
}

- (PMKPromise *)promiseRegisterUserWithParams:(NSDictionary *)params {
    
    NSLog(@"PMKPromise promiseRegisterUserWithParams");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService registerUserWithParams:params
                                         andExecute:^(id responseObject, NSError* error) {
            if (error) {
                reject(error);
            } else {
                fulfill(responseObject);
            }
        }];
    }];
}

@end
