//
//  HYBOrdersHistoryCell.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <UIKit/UIKit.h>

@interface HYBOrdersHistoryCell : UITableViewCell

@property (nonatomic) UILabel *orderIdLabel;
@property (nonatomic) UILabel *dateLabel;
@property (nonatomic) UILabel *statusLabel;
@property (nonatomic) UILabel *totalLabel;

@property (nonatomic, setter=setEven:) BOOL isEven;

@end
