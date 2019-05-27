//
//  HYBBadgeView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBBadgeView.h"
#import "HYBConstants.h"

@interface HYBBadgeView ()

@property (nonatomic) UIImageView   *imageView;
@property (nonatomic) UILabel       *textLabel;

@end

@implementation HYBBadgeView

+ (id)badgeViewWithBackgroundImageNamed:(NSString*)imageName {
    return [[HYBBadgeView alloc] initWithBackgroundImage:[UIImage imageNamed:imageName]];
}

+ (id)badgeViewWithBackgroundImage:(UIImage*)image {
    return [[HYBBadgeView alloc] initWithBackgroundImage:image];
}

- (id)initWithBackgroundImageNamed:(NSString*)imageName {
    return [self initWithBackgroundImage:[UIImage imageNamed:imageName]];
}

- (id)initWithBackgroundImage:(UIImage*)image {
    
    CGFloat size = image.size.width;
    
    CGRect frame = CGRectMake(0, 0, size ,size);
    
    if (self = [super initWithFrame:frame]) {
        _imageView = [[UIImageView alloc] initWithImage:image];
        
        _badgePadding           = 18.f;
        
        _badgeBackgroundColor   = [UIColor yellowColor];
        _badgeTextColor         = [UIColor blackColor];
        _badgeFont              = [UIFont systemFontOfSize:14.f];
        
        _badgeOffset            = CGPointMake(0, 0);
        
        _hideZeroValue = YES;
        _animateValueChange = YES;
        
        
        //pile up
        [self addSubview:_imageView];
    }
    
    return self;
}

- (void)setFrame:(CGRect)frame {
    [super setFrame:frame];
    
    _imageView.frame = frame;
    
    [self updateBadgeFrame];
}

- (void)updateBadgeFrame {
    
    UILabel *frameLabel = [[UILabel alloc] initWithFrame:_textLabel.frame];
    frameLabel.text = _textLabel.text;
    frameLabel.font = _badgeFont;
    [frameLabel sizeToFit];
    
    CGSize expectedLabelSize = frameLabel.frame.size;
    
    // Make sure that for small value, the badge will be big enough
    CGFloat limit = .75;
    CGFloat minHeight = expectedLabelSize.height*limit;
    CGFloat minWidth  = expectedLabelSize.width*limit;
    CGFloat padding = self.badgePadding;
    
    minWidth = (minWidth < minHeight) ? minHeight : expectedLabelSize.width;
    
    CGFloat width   = minWidth  + padding;
    CGFloat height  = minHeight + padding;
    
    CGSize size = self.bounds.size;
    CGFloat ratio = .90;
    
    CGFloat originX = (size.width  - width)/2   + _badgeOffset.x;
    CGFloat originY = (size.height - height)/2  + _badgeOffset.y;
    
    CGRect frame = CGRectMake(originX, originY, width* ratio, height* ratio);
    
    _textLabel.frame = frame;
    _textLabel.accessibilityIdentifier = @"ACCESS_TOPNAV_BUTTON_CART_TOTAL"; //@"ACCESS_BADGE_VALUE";
    
    _textLabel.layer.cornerRadius = (minHeight + padding) / 2;
    _textLabel.layer.masksToBounds = YES;
}

- (void)updateBadge {
    //refresh styling
    [self refreshBadge];
    
    //set new value
    _textLabel.text = _value;
    
    //animate value change if required
    if (_animateValueChange) {
        CABasicAnimation * animation = [CABasicAnimation animationWithKeyPath:@"transform.scale"];
        [animation setFromValue:[NSNumber numberWithFloat:1.5]];
        [animation setToValue:[NSNumber numberWithFloat:1]];
        [animation setDuration:defaultAnimationDuration/2];
        [animation setTimingFunction:[CAMediaTimingFunction functionWithControlPoints:.4 :1.3 :1 :1]];
        [_textLabel.layer addAnimation:animation forKey:@"bounceAnimation"];

        [UIView animateWithDuration:defaultAnimationDuration/2 animations:^{
            [self updateBadgeFrame];
        }];
    } else {
        [self updateBadgeFrame];
    }
}

- (void)refreshBadge {
    if (self.textLabel) {
        _textLabel.textColor        = _badgeTextColor;
        _textLabel.backgroundColor  = _badgeBackgroundColor;
        _textLabel.font             = _badgeFont;
    }
}

- (void)removeBadge {
    if(_animateValueChange) {
        [UIView animateWithDuration:defaultAnimationDuration/2
                         animations:^{
                             _textLabel.transform = CGAffineTransformMakeScale(0, 0);
                         }
                         completion:^(BOOL finished) {
                             [_textLabel removeFromSuperview];
                             _textLabel = nil;
                         }];
    } else {
        [_textLabel removeFromSuperview];
        _textLabel = nil;
    }
}

- (void)setValue:(NSString *)value {
    
    _value = value;
    
    if (!_value || [_value isEqualToString:@""] || ([_value isEqualToString:@"0"] && self.hideZeroValue)) {
        [self removeBadge];
    } else if (!_textLabel) {
        _textLabel                  = [UILabel new];
        _textLabel.textAlignment    = NSTextAlignmentCenter;
        _textLabel.center           = CGPointMake(self.bounds.size.width/2, self.bounds.size.height/2);
        
        [self addSubview:_textLabel];
    }
    
    [self updateBadge];
}

- (void)setBagdeBackgroundColor:(UIColor *)color {
    _badgeBackgroundColor = color;
    [self refreshBadge];
}

- (void)setBadgeTextColor:(UIColor *)color {
    _badgeTextColor = color;
    [self refreshBadge];
}

- (void)setBadgeFont:(UIFont *)font {
    _badgeFont = font;
    [self refreshBadge];
}

- (void)setBadgePadding:(CGFloat)padding {
    _badgePadding = padding;
    [self refreshBadge];
}

- (void)setBadgeOffset:(CGPoint)badgeOffset {
    _badgeOffset = badgeOffset;
    [self refreshBadge];
}

@end
