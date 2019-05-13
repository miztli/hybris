//
//  HYBSettingsView.h
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

@interface HYBSettingsView : UIView

@property(nonatomic) UIView     *contentView;

@property (nonatomic) UILabel *pageTitle;

@property (nonatomic) UILabel *backendTitle;
@property (nonatomic) UISegmentedControl *backendControl;

@property (nonatomic) UILabel *backendHostTitle;
@property (nonatomic) UITextField *backendHostField;

@property (nonatomic) UILabel *backendPortTitle;
@property (nonatomic) UITextField *backendPortField;


@property (nonatomic) UILabel *catalogTitle;
@property (nonatomic) UISegmentedControl *catalogControl;


@property (nonatomic) UILabel *storeTitle;
@property (nonatomic) UITextField *storeField;

@property (nonatomic) UILabel *catalogIdTitle;
@property (nonatomic) UITextField *catalogIdField;

@property (nonatomic) UILabel *rootIdTitle;
@property (nonatomic) UITextField *rootIdField;

@property (nonatomic) HYBActionButton *closeBtn;

@property (nonatomic) HYBActionButton *feedbackBtn;

@end
