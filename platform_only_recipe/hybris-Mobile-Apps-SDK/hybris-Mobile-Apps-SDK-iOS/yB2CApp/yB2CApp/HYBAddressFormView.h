//
//  HYBAddressFormView.h
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

@interface HYBAddressFormView : UIView

@property (nonatomic) UIView         *maskView;

@property (nonatomic) UIView *headerPanel;
@property (nonatomic) UILabel *titleLabel;
@property (nonatomic) UILabel *legendLabel;

@property (nonatomic) HYBActionButton *closeButton;
@property (nonatomic) HYBActionButton *saveButton;

@property (nonatomic) UIView *formPanel;

@property (nonatomic) HYBDropDownButton *titleSelector;

@property (nonatomic) UITextField *firstNameField;
@property (nonatomic) UITextField *lastNameField;

@property (nonatomic) UITextField *addressLineOneField;
@property (nonatomic) UITextField *addressLineTwoField;

@property (nonatomic) UITextField *cityField;
@property (nonatomic) UITextField *zipCodeField;

@property (nonatomic) HYBDropDownButton *countrySelector;

@end
