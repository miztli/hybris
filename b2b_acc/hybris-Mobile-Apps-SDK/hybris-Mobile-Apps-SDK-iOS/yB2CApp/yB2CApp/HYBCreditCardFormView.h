//
//  HYBCreditCardFormView.h
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

#import <UIKit/UIKit.h>
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"
#import "HYBActionButton.h"
#import "HYBDropDownButton.h"

@interface HYBCreditCardFormView : UIView

@property (nonatomic) HYBDropDownButton *cardTypeSelector;

@property (nonatomic) UITextField *accountNameField;
@property (nonatomic) UITextField *cardNumberField;
@property (nonatomic) UITextField *expMonthField;
@property (nonatomic) UITextField *expYearField;
@property (nonatomic) UITextField *cvvField;

@end
