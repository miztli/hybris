//
//  HYBFoldView.h
//  xGeolocator
// [y] hybris Platform
//
// Copyright (c) 2000-2014 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.


#import <UIKit/UIKit.h>

#define foldAnimationDuration .4

@interface HYBFoldView : UIView

@property (nonatomic) UIImageView *handleImageView;
@property (nonatomic) UIView *contentView;
@property (nonatomic) NSNumber *isOpen;

+ (instancetype)foldViewWithFrame:(CGRect)frame;

- (void)toggle;
- (CGFloat)handleHeight;

@end
