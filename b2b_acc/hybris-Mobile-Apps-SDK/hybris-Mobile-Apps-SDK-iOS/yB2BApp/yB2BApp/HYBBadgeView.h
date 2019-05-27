//
//  HYBBadgeView.h
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

@interface HYBBadgeView : UIView

@property (nonatomic) NSString  *value;

@property (nonatomic) CGPoint   badgeOffset;
@property (nonatomic) UIColor   *badgeBackgroundColor;
@property (nonatomic) UIColor   *badgeTextColor;
@property (nonatomic) UIFont    *badgeFont;

@property (nonatomic) CGFloat   badgePadding;

@property (nonatomic) BOOL hideZeroValue;
@property (nonatomic) BOOL animateValueChange;


+ (id)badgeViewWithBackgroundImageNamed:(NSString*)imageName;
+ (id)badgeViewWithBackgroundImage:(UIImage*)image;

- (id)initWithBackgroundImageNamed:(NSString*)imageName;
- (id)initWithBackgroundImage:(UIImage*)image;

@end
