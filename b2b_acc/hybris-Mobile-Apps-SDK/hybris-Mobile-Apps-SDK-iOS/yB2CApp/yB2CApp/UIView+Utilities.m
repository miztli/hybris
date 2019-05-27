//
// UIView+Utilities.m
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

#import "UIView+Utilities.h"

@implementation UIView (Utilities)

- (void)removeSubviews {
    for (UIView *subView in self.subviews) {
        [subView removeFromSuperview];
    }
}

- (UIView*)findFirstResponder {
    if (self.isFirstResponder) return self;
    
    for (UIView *subView in self.subviews) {
        UIView *responder = [subView findFirstResponder];
        if (responder) return responder;
    }
    
    return nil;
}

//geometry shorcuts

//ratio
- (CGFloat)ratio {
    return [self bW]/[self bH];
}

//bounds
- (CGFloat)boundsX {
    return self.bounds.origin.x;
}

- (CGFloat)boundsY {
    return self.bounds.origin.y;
}

- (CGFloat)boundsWidth {
    return self.bounds.size.width;
}

- (CGFloat)boundsHeight {
    return self.bounds.size.height;
}

//super short
- (CGFloat)bX {
    return [self boundsX];
}

- (CGFloat)bY {
    return [self boundsY];
}

- (CGFloat)bW {
    return [self boundsWidth];
}

- (CGFloat)bH {
    return [self boundsHeight];
}

//frame

- (CGFloat)frameX {
    return self.frame.origin.x;
}

- (CGFloat)frameY {
    return self.frame.origin.y;
}

- (CGFloat)frameWidth {
    return self.frame.size.width;
}

- (CGFloat)frameHeight {
    return self.frame.size.height;
}

//super short
- (CGFloat)fX {
    return [self frameX];
}

- (CGFloat)fY {
    return [self frameY];
}

- (CGFloat)fW {
    return [self frameWidth];
}

- (CGFloat)fH {
    return [self frameHeight];
}


//relative

- (CGFloat)top {
    return [self frameY];
}

- (CGFloat)bottom {
    return [self frameY] + [self frameHeight];
}

- (CGFloat)left {
    return [self frameX];
}

- (CGFloat)right {
    return [self frameX] + [self frameWidth];
}

@end