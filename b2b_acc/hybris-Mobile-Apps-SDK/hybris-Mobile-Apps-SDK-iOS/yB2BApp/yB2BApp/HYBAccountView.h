//
//  HYBAccountView.h
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

#import <UIKit/UIKit.h>
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"
#import "HYBActionButton.h"
#import "HYBDropDownButton.h"

@interface HYBAccountView : UIView

@property(nonatomic) UIView     *contentView;

@property(nonatomic) UILabel    *pageTitle;
@property(nonatomic) UILabel    *userEmail;

@property (nonatomic) UIView         *maskView;

@property(nonatomic) UILabel    *profileHeader;
@property (nonatomic) HYBDropDownButton  *titleSelector;
@property (nonatomic) UIView         *firstNamePanel;
@property (nonatomic) UITextField    *firstNameField;
@property (nonatomic) UIView         *lastNamePanel;
@property (nonatomic) UITextField    *lastNameField;

@property (nonatomic) UILabel    *languageHeader;
@property (nonatomic) HYBDropDownButton  *languageSelector;

@property (nonatomic) UILabel    *paymentDetailsHeader;
@property (nonatomic) UILabel    *costCenterLegend;
@property (nonatomic) HYBDropDownButton  *costCenterSelector;

@property (nonatomic) UILabel    *deliveryAddressesLegend;
@property (nonatomic) UITableView *addressTableView;

@end
