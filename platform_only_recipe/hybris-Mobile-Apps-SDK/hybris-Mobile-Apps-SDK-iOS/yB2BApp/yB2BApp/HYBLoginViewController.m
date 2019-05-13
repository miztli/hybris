//
// HYBLoginViewController.m
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


#import "UIViewController+Navigation.h"

#import "HYBLoginViewController.h"
#import "HYBLoginView.h"

#import "NSError+HYErrorUtils.h"
#import "HYBB2BService.h"
#import "HYBCart.h"
#import "HYBActivityIndicator.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBAppDelegate.h"
#import "UIView+Utilities.h"

#import "HYBSettingsViewController.h"

@interface HYBLoginViewController ()
@property(nonatomic) HYBLoginView *mainView;
@end

BOOL isKeyboardUp;

@implementation HYBLoginViewController

- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService {
    if (self = [super init]) {
        NSAssert(b2bService != nil, @"Service must be present.");
        _b2bService = b2bService;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) {
        _mainView = [HYBLoginView new];
        _mainView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        
        //access settings
        UILongPressGestureRecognizer *longPress = [[UILongPressGestureRecognizer alloc] initWithTarget:self action:@selector(handleLongPress:)];
        longPress.minimumPressDuration = .5; //seconds
        longPress.delaysTouchesBegan = YES;
        [_mainView addGestureRecognizer:longPress];
        
        //username field actions
        _mainView.usernameField.delegate = self;
        [_mainView.usernameField addTarget:self
                                    action:@selector(updateButtonState)
                          forControlEvents:UIControlEventEditingChanged];
        
        //valid pass field actions
        _mainView.passwordField.delegate = self;
        [_mainView.passwordField addTarget:self
                                    action:@selector(updateButtonState)
                          forControlEvents:UIControlEventEditingChanged];
        
        //login button action
        [[_mainView loginButton] addTarget:self
                                    action:@selector(loginButtonPressed)
                          forControlEvents:UIControlEventTouchUpInside];
        
        //keyboard monitor
        NSNotificationCenter *center = [NSNotificationCenter defaultCenter];
        
        [center addObserver:self selector:@selector(keyboardDidShow:)
                       name:UIKeyboardDidShowNotification
                     object:nil];
        
        [center addObserver:self selector:@selector(keyboardWillHide:)
                       name:UIKeyboardWillHideNotification
                     object:nil];
    }
    
    self.view = _mainView;
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}


-  (void)handleLongPress:(UILongPressGestureRecognizer*)sender {
    if (sender.state == UIGestureRecognizerStateBegan) {
        [self showSettings];
    }
}

- (void)showSettings {
    HYBSettingsViewController *settingsVC = [[HYBSettingsViewController alloc] initWithBackEndService:[self backEndService]];
    [self presentViewController:settingsVC animated:YES completion:nil];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    
    [_b2bService loadSettings];

    [_b2bService resetPagination];
    [[NSUserDefaults standardUserDefaults] removeObjectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
    [[NSUserDefaults standardUserDefaults] synchronize];
    
    NSString *currentUserId = [[_b2bService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
    
    if (currentUserId) {
        DDLogDebug(@"An authenticated user from last time exist, skipping login.");
        
        [_b2bService authenticateUsername:currentUserId
                               andExecute:^(NSString *errorMsgOrToken, NSError *error){
            if(error) {
                [self prefillLoginWithUser:currentUserId];
                [_b2bService clearTokensForUser:currentUserId];
            } else {
                [self passLogin];
            }
        }];
        
    } else {
        DDLogDebug(@"Login window will be rendered.");
        [self prefillLoginWithUser:nil];
    }
}

- (void)prefillLoginWithUser:(NSString*)user {
    
    NSString *username = [[_b2bService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
    if (username) {
        DDLogDebug(@"Found previous user data, prefilling the login.");
        _mainView.usernameField.text = username;
        _mainView.passwordField.text = @"";
        [_mainView.passwordField becomeFirstResponder];
    } else {
        [_mainView.usernameField becomeFirstResponder];
    }
}

#pragma mark TextField delegate

-(void)textFieldDidBeginEditing:(UITextField *)textField {
    [self updateButtonState];
}

-(BOOL)textFieldShouldReturn:(UITextField *)textField {
    if (textField == _mainView.usernameField) {
        [_mainView.passwordField becomeFirstResponder];
    } else if (textField == _mainView.passwordField) {
        [self loginButtonPressed];
    }
    
    return NO;
}

-(BOOL)textFieldShouldClear:(UITextField *)textField {
    textField.text = @"";
    [self updateButtonState];
    return NO;
}

-(void)updateButtonState {
    if ([self canUseLoginButton]) {
        _mainView.loginButton.enabled = YES;
    } else {
        _mainView.loginButton.enabled = NO;
    }
}

#pragma mark Login Actions

- (void)loginButtonPressed {
    
    NSString *username = [[[self mainView] usernameField] text];
    NSString *pass = [[[self mainView] passwordField] text];
    
    DDLogDebug(@"Login button pressed ...");
    
    if([self canUseLoginButton]) [self loginWithUser:username pass:pass];
}

- (BOOL)canUseLoginButton {
    NSString *username  = _mainView.usernameField.text;
    NSString *password  = _mainView.passwordField.text;
    
    if(username && (username.length > 0 || ![username isEqualToString:@""]) &&
       password && (password.length > 0 || ![password isEqualToString:@""])) {
        return YES;
    }
    
    return NO;
}

- (void)loginWithUser:(NSString *)user pass:(NSString *)pass {
    
    [HYBActivityIndicator show];
    
    [self.b2bService authenticateUsername:user
                             withPassword:pass
                               andExecute:^(NSString *errorMsgOrToken, NSError *error) {
                                    
                                    [HYBActivityIndicator hide];
                                    
                                    if (error) {
                                        DDLogDebug(@"Error retrieved ...");
                                        [[self mainView] passwordField].text = @"";
                                        [self updateButtonState];
                                        if ([error isConnectionOfflineError]) {
                                            if ([self isPreviouslyAuthenticatedUser:user]) {
                                                DDLogError(@"Offline error found but the user was authenticated before, "
                                                           "cache is used: %@", [error localizedDescription]);
                                            } else {
                                                [self showAlertMessage:NSLocalizedString(@"login_first_time_not_connected", nil)
                                                             withTitle:NSLocalizedString(@"login_alert_failed", nil)
                                                      cancelButtonText:NSLocalizedString(@"OK", @"OK")];
                                            }
                                        } else {
                                            if ([self isValidEmail:user]) {
                                                [self showAlertMessage:errorMsgOrToken
                                                             withTitle:NSLocalizedString(@"login_alert_failed", nil)
                                                      cancelButtonText:NSLocalizedString(@"OK", @"OK")];
                                            } else {
                                                [self showAlertMessage:NSLocalizedString(@"login_invalid_email", @"Explain the user the provided "
                                                                                         "email is not a valid email format.")
                                                             withTitle:NSLocalizedString(@"login_alert_failed", nil)
                                                      cancelButtonText:NSLocalizedString(@"OK", @"OK")];
                                            }
                                        }
                                    } else {
                                        [self.b2bService retrieveCartByUserIdFromCurrentCartsCreateIfNothingPresent:user
                                                                                                         andExecute:^(HYBCart *cart, NSError *error) {
                                                                                                             if (cart) {
                                                                                                                 DDLogDebug(@"Cart for user retrieved after login");
                                                                                                             } else {
                                                                                                                 DDLogError(@"Cart for user not retrieved after login, this is an error, verify backend functionality. "
                                                                                                                            "It is assumed that a cart will exist at this point. Backend error is %@", error.localizedDescription);
                                                                                                             }
                                                                                                         }];
                                        
                                        [_b2bService resetPagination];
                                        
                                        [[NSUserDefaults standardUserDefaults] removeObjectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
                                        [[NSUserDefaults standardUserDefaults] synchronize];
                                        
                                        [self passLogin];
                                        
                                    }
                                }];
}

- (UIInterfaceOrientation)orientation {
    return [UIApplication sharedApplication].statusBarOrientation;
}

#pragma mark keyboard management

- (void)keyboardDidShow:(NSNotification *)notification {
    
    if([self orientation] == UIInterfaceOrientationLandscapeRight || [self orientation] == UIInterfaceOrientationLandscapeLeft) {
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             _mainView.center = CGPointMake([_mainView bW]/2, [_mainView bH]/2-200);
                         }];
    }
}

- (void)keyboardWillHide:(NSNotification *)notification {
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _mainView.center = CGPointMake([_mainView bW]/2, [_mainView bH]/2);
                     }];
}

#pragma mark utilities

- (void)passLogin {
    [(HYBAppDelegate *)[[UIApplication sharedApplication] delegate] passLoginWindow];
}

- (BOOL)isPreviouslyAuthenticatedUser:(NSString *)username {
    NSString *authenticatedUserName = [[_b2bService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
    if (authenticatedUserName) {
        return [authenticatedUserName isEqualToString:username];
    } else {
        return NO;
    }
}

- (BOOL)isValidEmail:(NSString *)email {
    NSString *emailRegex = @"[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
    NSPredicate *emailTest = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", emailRegex];
    return [emailTest evaluateWithObject:email];
}

@end
