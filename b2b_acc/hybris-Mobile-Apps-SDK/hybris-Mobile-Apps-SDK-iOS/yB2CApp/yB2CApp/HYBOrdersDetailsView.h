//
// HYBOrdersDetailsView.h
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
#import "HYBToolbar.h"

@interface HYBOrdersDetailsView : UIView

@property (nonatomic) UIScrollView *contentView;

@property (nonatomic) HYBActionButton *backButton;

@property (nonatomic) UILabel *titleLabel;

@property (nonatomic) UILabel *orderNumberLabel;
@property (nonatomic) UILabel *dateLabel;

@property (nonatomic) UILabel *orderStatusLabel;

@property (nonatomic) UILabel *deliveryAddressTitle;
@property (nonatomic) UILabel *deliveryAddressValue;

@property (nonatomic) UILabel *deliveryMethodTitle;
@property (nonatomic) UILabel *deliveryMethodValue;

@property (nonatomic) UILabel *trackingTitle;
@property (nonatomic) UILabel *trackingValue;

@property (nonatomic) UITableView *itemsTable;

@property (nonatomic) HYBOrderSummaryView *orderSummaryView;

@end
