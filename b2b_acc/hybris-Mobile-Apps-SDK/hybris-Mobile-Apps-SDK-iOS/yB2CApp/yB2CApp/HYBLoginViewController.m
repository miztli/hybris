//
// HYBLoginViewController.m
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


#import "UIViewController+Navigation.h"

#import "HYBLoginViewController.h"
#import "HYBLoginView.h"

#import "NSError+HYErrorUtils.h"
#import "HYBB2CService.h"
#import "HYBCart.h"
#import "HYBActivityIndicator.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBAppDelegate.h"
#import "UIView+Utilities.h"

#import "HYBSignUpViewController.h"
#import "HYBSettingsViewController.h"

@interface HYBLoginViewController ()

@property(nonatomic) HYBLoginView *mainView;

@end

@implementation HYBLoginViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    if (self = [super init]) {
        NSAssert(backendService != nil, @"Service must be present.");
        _backendService = backendService;
    }
    return self;
}

- (void)dismiss {
    [self dismissViewControllerAnimated:YES
                             completion:nil];
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
        
        //pass field actions
        _mainView.passwordField.delegate = self;
        [_mainView.passwordField addTarget:self
                                    action:@selector(updateButtonState)
                          forControlEvents:UIControlEventEditingChanged];
        
        //login button action
        [[_mainView loginButton] addTarget:self
                                    action:@selector(loginButtonPressed)
                          forControlEvents:UIControlEventTouchUpInside];
        
        //login button action
        [[_mainView cancelButton] addTarget:self
                                     action:@selector(dismiss)
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
    
    [_backendService loadSettings];

    NSString *currentUserId = [[_backendService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
    
    [self prefillLoginWithUser:currentUserId];
    
}

- (void)prefillLoginWithUser:(NSString*)user {
    
    NSString *username = [[_backendService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
    if (username) {
        DDLogDebug(@"Found previous user data, prefilling the login.");
        _mainView.usernameField.text = username;
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
    
    if (self.backendService.userId) {
        [self.backendService logoutCurrentUser];
    }
    
    //go
    [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        [self.backendService authenticateUsername:user
                                     withPassword:pass
                                        andExecute:^(id responseObject, NSError* error) {
                                            if (error) {
                                                reject(error);
                                            } else {
                                                fulfill(responseObject);
                                            }
                                        }];
    }]
    
    .then(^(id responseObject) {
        return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            
            return [self.backendService getCartsForUserId:self.backendService.userId
                                               withParams:nil
                                               andExecute:^(id responseObject, NSError* error) {
                                                   if (error) {
                                                       reject(error);
                                                   } else {
                                                       fulfill(responseObject);
                                                   }
                                               }];
        }];
    })
    
    .then(^(id responseObject) {
        HYBCart *anonymousCart = [self.backendService currentCartFromCache];
        
        NSArray *carts = (NSArray*)responseObject;
        
        if ([carts hyb_isNotBlank]) {
            //merge current anonymous cart
            
            HYBCart *firstCart = (HYBCart*)[carts firstObject];
            
            if([anonymousCart.guid isEqualToString:firstCart.guid]) {
                return firstCart;
            } else {
                return (HYBCart*)[PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
                    
                    [self.backendService mergeAnonymouCartWithGuid:anonymousCart.guid
                                                    toCartWithGuid:firstCart.guid
                                                          toUserId:self.backendService.userId
                                                        andExecute:^(id responseObject, NSError* error) {
                                                            if (error) {
                                                                reject(error);
                                                            } else {
                                                                fulfill(responseObject);
                                                            }
                                                        }];
                }];
                
            }
        } else {
            //assign anonymous to user
            
            return (HYBCart*)[PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
                
                [self.backendService assignAnonymouCartWithGuid:anonymousCart.guid
                                                       toUserId:self.backendService.userId
                                                     andExecute:^(id responseObject, NSError* error) {
                                                         if (error) {
                                                             reject(error);
                                                         } else {
                                                             fulfill(responseObject);
                                                         }
                                                     }];
            }];
        }
    })
    
    .then(^(HYBCart *cart) {
        [HYBActivityIndicator hide];
        [self.backendService saveCartInCacheNotifyObservers:cart];
        [self dismiss];
    })
    
    .catch(^(NSError *error) {
        [HYBActivityIndicator hide];
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
                [self showAlertMessage:error.localizedDescription
                             withTitle:NSLocalizedString(@"login_alert_failed", nil)
                      cancelButtonText:NSLocalizedString(@"OK", @"OK")];
            } else {
                [self showAlertMessage:NSLocalizedString(@"login_invalid_email", @"Explain the user the provided "
                                                         "email is not a valid email format.")
                             withTitle:NSLocalizedString(@"login_alert_failed", nil)
                      cancelButtonText:NSLocalizedString(@"OK", @"OK")];
            }
        }
        
    });
    
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

- (BOOL)isPreviouslyAuthenticatedUser:(NSString *)username {
    NSString *authenticatedUserName = [[_backendService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
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
