//
//  HYBDrawerController.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "MMDrawerController.h"
#import "HYBTopToolbar.h"

@interface HYBDrawerController : MMDrawerController

@property (nonatomic) HYBTopToolbar *topToolbar;

- (void)setTopToolbar:(HYBTopToolbar *)topToolbar;

- (void)closeDrawersIfNeeded;
- (void)closeDrawersIfNeededWithCompletionBlock:(void (^)(BOOL finished))completion;
- (void)refreshLayout;
- (void)resignActiveResponder;
- (void)checkPageDismiss;

@end
