//
// HYBLoginView.m
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


#import "HYBLoginView.h"

#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"

@interface HYBLoginView ()

@property(nonatomic)  UIView          *gradientView;
@property (nonatomic) CAGradientLayer *gradientLayer;

@end

@implementation HYBLoginView

CGFloat defaultHeight = 64.f;
CGFloat margin = 0;

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)setup {
    
    margin = defaultHeight/3.f;
    
    //gradient background
    _gradientView = [UIView new];
    _gradientView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _gradientView.autoresizesSubviews = YES;
    
    UIColor *topColor       = background_gradient_start;
    UIColor *bottomColor    = background_gradient_end;
    
    NSArray *gradientColors = [NSArray arrayWithObjects:(id)topColor.CGColor, (id)bottomColor.CGColor, nil];
    NSArray *gradientLocations = [NSArray arrayWithObjects:[NSNumber numberWithInt:0.0],[NSNumber numberWithInt:1.0], nil];
    
    _gradientLayer = [CAGradientLayer layer];
    _gradientLayer.colors = gradientColors;
    _gradientLayer.locations = gradientLocations;
    _gradientLayer.frame = _gradientView.frame;
    
    [_gradientView.layer insertSublayer:_gradientLayer atIndex:0];
    
    //logo view
    
    _logoView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:login_logo_imagename]];
    _logoView.contentMode = UIViewContentModeScaleAspectFit;
    
    //username field
    
    _usernameField = [[UITextField alloc] init];
    _usernameField.borderStyle = UITextBorderStyleRoundedRect;
    _usernameField.placeholder = NSLocalizedString(@"login_view_username_placeholder", nil);
    _usernameField.contentVerticalAlignment = UIControlContentVerticalAlignmentCenter;
    _usernameField.accessibilityIdentifier = @"ACCESS_LOGIN_TEXTFIELD_USER";
    _usernameField.clearButtonMode = UITextFieldViewModeWhileEditing;
    _usernameField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _usernameField.autocorrectionType = UITextAutocorrectionTypeNo;
    _usernameField.keyboardType = UIKeyboardTypeEmailAddress;
    _usernameField.returnKeyType = UIReturnKeyNext;
    
    _usernameField.backgroundColor  = login_field_background;
    _usernameField.textColor        = login_field_text;
    _usernameField.tintColor        = login_field_text;
    
    //pass field
    
    _passwordField = [[UITextField alloc] init];
    _passwordField.borderStyle = UITextBorderStyleRoundedRect;
    _passwordField.placeholder = NSLocalizedString(@"login_view_password_placeholder", nil);
    _passwordField.contentVerticalAlignment = UIControlContentVerticalAlignmentCenter;
    _passwordField.secureTextEntry = YES;
    _passwordField.clearButtonMode = UITextFieldViewModeWhileEditing;
    _passwordField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _passwordField.autocorrectionType = UITextAutocorrectionTypeNo;
    _passwordField.returnKeyType = UIReturnKeyGo;
    _passwordField.accessibilityIdentifier = @"ACCESS_LOGIN_TEXTFIELD_PASSWORD";

    _passwordField.backgroundColor  = login_field_background;
    _passwordField.textColor        = login_field_text;
    _passwordField.tintColor        = login_field_text;
    
    //login button
    
    _loginButton = [HYBActionButton new];
    [_loginButton setTitle:NSLocalizedString(@"login_view_sign_in", nil) forState:UIControlStateNormal];
    
    _loginButton.accessibilityIdentifier = @"ACCESS_LOGIN_BUTTON_LOGIN";
    _loginButton.enabled = NO;

    //pile up
    
    [self addSubview:_gradientView];
    [self addSubview:_logoView];
    [self addSubview:_usernameField];
    [self addSubview:_passwordField];
    [self addSubview:_loginButton];
}

- (void)sizing {
    
    CGFloat fixedWidth = 768;
    CGFloat centerX = fixedWidth/2;
    
    _logoView.frame         = CGRectMake(0, 0, centerX, fixedWidth/2*(1/_logoView.ratio));
    _usernameField.frame    = CGRectMake(0, 0, centerX, defaultHeight);
    _passwordField.frame    = CGRectMake(0, 0, centerX, defaultHeight);
    _loginButton.frame      = CGRectMake(0, 0, centerX, defaultHeight);
    _gradientView.frame     = self.bounds;
    _gradientLayer.frame    = _gradientView.frame;

}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    if (CGRectEqualToRect(_usernameField.frame, CGRectZero)) [self sizing];
    
    CGFloat centerX = [self bW]/2;
    
    _logoView.center        = CGPointMake(centerX, [self bH]/2 - [_logoView bH]/2 - defaultHeight);
    _usernameField.center   = CGPointMake(centerX, [self bH]/2 );
    _passwordField.center   = CGPointMake(centerX, [self bH]/2 + (margin + defaultHeight));
    _loginButton.center     = CGPointMake(centerX, [self bH]/2 + (margin + defaultHeight)*2);
    
}

@end