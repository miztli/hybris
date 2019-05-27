//
// HYBOrderSummaryView.h
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

@interface HYBOrderSummaryView : UIView

@property (nonatomic) UIView  *summaryPanel;

@property (nonatomic) UILabel *title;
@property (nonatomic) UILabel *itemCount;

@property (nonatomic) UIView  *detailsPanel;

@property (nonatomic) UILabel *subtotalTitle;
@property (nonatomic) UILabel *subtotalValue;

@property (nonatomic) UILabel *savingsTitle;
@property (nonatomic) UILabel *savingsValue;

@property (nonatomic) UILabel *taxTitle;
@property (nonatomic) UILabel *taxValue;

@property (nonatomic) UILabel *shippingTitle;
@property (nonatomic) UILabel *shippingValue;

@property (nonatomic) UILabel *orderTotalTitle;
@property (nonatomic) UILabel *orderTotalValue;

@property (nonatomic) UILabel *savingsRecapTitle;

- (void)hideSavings:(BOOL)hidden;

@end
