//
//  HYBToolbar.h
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
#import "UIView+Utilities.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "HYBConstants.h"

#define defaultToolbarHeight   defaultTopMargin

#define toolbarMarge    8.f

@interface HYBToolbar : UIView

@property (nonatomic) CGRect originalFrame;

@property (nonatomic) CGFloat statusbarMod;

@property (nonatomic) NSArray *leftItems;
@property (nonatomic) NSArray *centerItems;
@property (nonatomic) NSArray *rightItems;

+ (id)toolbarWithFrame:(CGRect)frame;
- (CGFloat)contentViewHeight;

- (void)setToolbarHeight:(CGFloat)toolbarHeight;
- (CGFloat)toolbarHeight;

- (void)setRightItemsViewHidden:(BOOL)hidden    completion:(void (^)())completion;
- (void)setLeftItemsViewHidden:(BOOL)hidden     completion:(void (^)())completion;
- (void)setCenterItemsViewHidden:(BOOL)hidden   completion:(void (^)())completion;

@end
