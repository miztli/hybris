//
//  HYBSignUpView.m
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

#import "HYBSignUpView.h"

#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"


@interface HYBSignUpView ()

@end

@implementation HYBSignUpView


- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)setup {
    
    //content view
    _contentView = [UIView new];
    _contentView.backgroundColor = hybris_clear;
    
    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    _titleCodeDrop = [HYBDropDownButton new];
    _titleCodeDrop.text = @"";
    
    _firstNameField = [self defaultTextField];
    _firstNameField.placeholder = NSLocalizedString(@"firstNameKey", nil);
    _firstNameField.returnKeyType = UIReturnKeyNext;
    _firstNameField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _firstNameField.autocorrectionType = UITextAutocorrectionTypeNo;
    _firstNameField.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_FIRSTNAME";
    
    _lastNameField  = [self defaultTextField];
    _lastNameField.placeholder = NSLocalizedString(@"lastNameKey", nil);
    _lastNameField.returnKeyType = UIReturnKeyNext;
    _lastNameField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _lastNameField.autocorrectionType = UITextAutocorrectionTypeNo;
    _lastNameField.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_LASTNAME";

    _loginField = [self defaultTextField];
    _loginField.placeholder = NSLocalizedString(@"loginKey", nil);
    _loginField.keyboardType = UIKeyboardTypeEmailAddress;
    _loginField.returnKeyType = UIReturnKeyNext;
    _loginField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _loginField.autocorrectionType = UITextAutocorrectionTypeNo;
    _loginField.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_EMAIL";
    
    _passwordField  = [self defaultTextField];
     _passwordField.placeholder = NSLocalizedString(@"passwordKey", nil);
    _passwordField.returnKeyType = UIReturnKeyNext;
    _passwordField.secureTextEntry = YES;
    _passwordField.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_PASSWORD";
    
    _verifyPasswordField  = [self defaultTextField];
    _verifyPasswordField.placeholder = NSLocalizedString(@"confirmPasswordKey", nil);
    _verifyPasswordField.returnKeyType = UIReturnKeySend;
    _verifyPasswordField.secureTextEntry = YES;
    _verifyPasswordField.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_PASSWORD_VERIFY";
  
    _closeButton = [HYBActionButton new];
    [_closeButton setTitle:NSLocalizedString(@"cancelKey", nil) forState:UIControlStateNormal];
    [_closeButton setBackgroundColor:hybris_gray forState:UIControlStateNormal];
    _closeButton.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_BUTTON_CANCEL";
    
    _saveButton = [HYBActionButton new];
    [_saveButton setTitle:NSLocalizedString(@"saveKey", nil) forState:UIControlStateNormal];
    [_saveButton setBackgroundColor:hybris_yellow forState:UIControlStateNormal];
    _saveButton.accessibilityIdentifier = @"ACCESS_LOGIN_SIGNUP_BUTTON_SAVE";

    //mask
    _maskView = [UIView new];
    _maskView.backgroundColor = checkout_mask;
    _maskView.alpha = 0;
    _maskView.hidden = YES;
    
    [_contentView addSubview:_titleCodeDrop];
    [_contentView addSubview:_firstNameField];
    [_contentView addSubview:_lastNameField];
    [_contentView addSubview:_loginField];
    [_contentView addSubview:_passwordField];
    [_contentView addSubview:_verifyPasswordField];
    
    [_contentView addSubview:_closeButton];
    [_contentView addSubview:_saveButton];
    
    [self addSubview:_contentView];
    
}

- (UITextField*)defaultTextField {
    
    UITextField *defaultField = [UITextField new];
    defaultField.font = font_address_form_default_label;
    defaultField.textColor = address_form_default_label;
    defaultField.backgroundColor = hybris_white;
    defaultField.textAlignment = NSTextAlignmentLeft;
    defaultField.layer.borderColor = address_form_cell_border.CGColor;
    defaultField.layer.borderWidth = 1.f;
    
    UIView *paddingView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 20, 0)];
    defaultField.leftView = paddingView;
    defaultField.leftViewMode = UITextFieldViewModeAlways;
    
    return defaultField;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.05;
    CGFloat lineHeight = 20.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 15.f;
    }
    
    //content frame
    _contentView.frame = CGRectMake([self bX], [self bY] + defaultTopMargin , [self bW], [self bH] - defaultTopMargin);
    
    _maskView.frame = _contentView.bounds;
    
    _titleCodeDrop.frame = CGRectMake(margin,
                                         lineHeight,
                                         150,
                                         lineHeight*2);
    
  
    _firstNameField.frame = CGRectMake(margin,
                                       [_titleCodeDrop bottom] + lineHeight,
                                       [_contentView bW] - margin*2,
                                       lineHeight*2);
    
    _lastNameField.frame = CGRectMake(margin,
                                      [_firstNameField bottom] + lineHeight,
                                      [_contentView bW] - margin*2,
                                      lineHeight*2);

    _loginField.frame = CGRectMake(margin,
                                       [_lastNameField bottom] + lineHeight,
                                       [_contentView bW] - margin*2,
                                       lineHeight*2);
    
    _passwordField.frame = CGRectMake(margin,
                                      [_loginField bottom] + lineHeight,
                                      [_contentView bW] - margin*2,
                                      lineHeight*2);
    
    _verifyPasswordField.frame = CGRectMake(margin,
                                       [_passwordField bottom] + lineHeight,
                                       [_contentView bW] - margin*2,
                                       lineHeight*2);
    
    

    
    [_closeButton sizeToFit];
    _closeButton.frame = CGRectInset(_closeButton.frame, -10, -10);
    _closeButton.center = CGPointMake([_closeButton bW]/2 + margin, [_verifyPasswordField bottom] + [_closeButton bH]);
    
    //save
    [_saveButton sizeToFit];
    _saveButton.frame = CGRectInset(_saveButton.frame, -10, -10);
    _saveButton.center = CGPointMake([self bW] - [_saveButton bW]/2 - margin, [_verifyPasswordField bottom] + [_saveButton bH]);
    
}

@end
