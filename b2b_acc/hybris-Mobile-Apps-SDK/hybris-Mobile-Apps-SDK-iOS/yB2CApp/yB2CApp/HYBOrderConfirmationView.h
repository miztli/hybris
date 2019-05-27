//
// HYBOrderConfirmationView.h
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
#import "UIView+Utilities.h"
#import "HYBActionButton.h"
#import "HYBOrderSummaryView.h"

@interface HYBOrderConfirmationView : UIView

@property (nonatomic) UIScrollView *contentView;

@property (nonatomic) HYBActionButton *continueShoppingButton;
@property (nonatomic) UILabel *thanksLabel;

@property (nonatomic) UILabel *orderNumberIntroLabel;
@property (nonatomic) UILabel *orderNumberLinkLabel;
@property (nonatomic) UILabel *emailDetailsLabel;

@property (nonatomic) UILabel *deliveryAddressTitle;
@property (nonatomic) UILabel *deliveryAddressValue;

@property (nonatomic) UILabel *deliveryMethodTitle;
@property (nonatomic) UILabel *deliveryMethodValue;

@property (nonatomic) UITableView *itemsTable;

@property (nonatomic) HYBOrderSummaryView *orderSummaryView;

@end
