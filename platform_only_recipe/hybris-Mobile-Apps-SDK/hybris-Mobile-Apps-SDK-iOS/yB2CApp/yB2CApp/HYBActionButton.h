//
//  HYBActionButton.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <UIKit/UIKit.h>

@interface HYBActionButton : UIButton

typedef NS_ENUM (NSInteger, HYBActionButtonType) {none, checkbox};

@property (nonatomic) HYBActionButtonType type;

- (void)setBackgroundColor:(UIColor *)backgroundColor forState:(UIControlState)state;
- (UIColor*)backgroundColorForState:(UIControlState)state;

- (BOOL)toggle;

@end
