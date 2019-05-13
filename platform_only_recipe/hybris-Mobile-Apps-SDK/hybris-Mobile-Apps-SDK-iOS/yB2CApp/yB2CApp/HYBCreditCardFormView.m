//
//  HYBCreditCardFormView.m
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

#import "HYBCreditCardFormView.h"

@implementation HYBCreditCardFormView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
        
        self.layer.borderColor = hybris_gray.CGColor;
        self.layer.borderWidth = 1.f;
        self.layer.cornerRadius = 20.f;
    }
    return self;
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
    
    CGFloat fieldH = lineHeight*2.25;
    CGFloat fieldInter = margin*.7;
    
    _cardTypeSelector.frame = CGRectMake(margin,
                                         margin,
                                         180.f,
                                         fieldH);
    
    _accountNameField.frame = CGRectMake([_cardTypeSelector right] + margin,
                                         margin,
                                         [self bW] - margin*3 - [_cardTypeSelector bW],
                                         fieldH);
    
    _cardNumberField.frame = CGRectMake(margin,
                                        [_cardTypeSelector bottom] + fieldInter,
                                        [self bW] - margin*2,
                                        fieldH);
    
    _expMonthField.frame = CGRectMake(margin,
                                      [_cardNumberField bottom] + fieldInter,
                                      90.f,
                                      fieldH);
    
    _expYearField.frame = CGRectMake([_expMonthField right] + margin/3,
                                     [_cardNumberField bottom] + fieldInter,
                                     90.f,
                                     fieldH);
    
    _cvvField.frame = CGRectMake([_expYearField right] + margin,
                                 [_cardNumberField bottom] + fieldInter,
                                 90.f,
                                 fieldH);
}

- (void)setup {
    
    _cardTypeSelector = [HYBDropDownButton new];
    _cardTypeSelector.text = NSLocalizedString(@"creditCardType", nil);
    
    _accountNameField = [self defaultTextField];
    _accountNameField.placeholder = NSLocalizedString(@"accountHolderNameKey", nil);
    _accountNameField.returnKeyType = UIReturnKeyNext;
    
    _cardNumberField = [self defaultTextField];
    _cardNumberField.placeholder = NSLocalizedString(@"creditCardNumberKey", nil);
    _cardNumberField.returnKeyType = UIReturnKeyNext;
    _cardNumberField.keyboardType = UIKeyboardTypeNumberPad;
    
    _expMonthField = [self defaultTextField];
    _expMonthField.placeholder = NSLocalizedString(@"creditCardExpiryMonthKey", nil);
    _expMonthField.returnKeyType = UIReturnKeyNext;
    _expMonthField.keyboardType = UIKeyboardTypeNumberPad;
    
    _expYearField = [self defaultTextField];
    _expYearField.placeholder = NSLocalizedString(@"creditCardExpiryYearKey", nil);
    _expYearField.returnKeyType = UIReturnKeyNext;
    _expYearField.keyboardType = UIKeyboardTypeNumberPad;
    
    _cvvField = [self defaultTextField];
    _cvvField.placeholder = NSLocalizedString(@"cvvKey", nil);
    _cvvField.returnKeyType = UIReturnKeyNext;
    _cvvField.keyboardType = UIKeyboardTypeNumberPad;
    
    //pile up
    
    [self addSubview:_cardTypeSelector];
    
    [self addSubview:_accountNameField];
    [self addSubview:_cardNumberField];
    [self addSubview:_expMonthField];
    [self addSubview:_expYearField];
    [self addSubview:_cvvField];
}

- (UITextField*)defaultTextField {
    
    UITextField *defaultField = [UITextField new];
    defaultField.font = font_address_form_default_label;
    defaultField.textColor = address_form_default_label;
    defaultField.textAlignment = NSTextAlignmentLeft;
    defaultField.layer.borderColor = address_form_cell_border.CGColor;
    defaultField.layer.borderWidth = 1.f;
    
    UIView *paddingView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 20, 0)];
    defaultField.leftView = paddingView;
    defaultField.leftViewMode = UITextFieldViewModeAlways;
    
    return defaultField;
}

@end
