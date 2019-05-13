//
// UIView+Utilities.h
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

@interface UIView (Utilities)

- (void)removeSubviews;

- (UIView*)findFirstResponder;

//geometry shorcuts

//ratio
- (CGFloat)ratio;

//bounds
- (CGFloat)boundsX;
- (CGFloat)boundsY;
- (CGFloat)boundsWidth;
- (CGFloat)boundsHeight;

- (CGFloat)bX;
- (CGFloat)bY;
- (CGFloat)bW;
- (CGFloat)bH;

//frame

- (CGFloat)frameX;
- (CGFloat)frameY;
- (CGFloat)frameWidth;
- (CGFloat)frameHeight;

- (CGFloat)fX;
- (CGFloat)fY;
- (CGFloat)fW;
- (CGFloat)fH;

//relative

- (CGFloat)top;
- (CGFloat)bottom;
- (CGFloat)left;
- (CGFloat)right;

@end
