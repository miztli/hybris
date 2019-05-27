//
//  HYBOrderHistoryView.h
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
#import "UIView+Utilities.h"
#import "HYBActionButton.h"

@interface HYBOrdersHistoryView : UIView

@property (nonatomic) UILabel *titleLabel;
@property (nonatomic) UITableView *ordersTable;
@property (nonatomic) HYBActionButton *filterButton;


@end
