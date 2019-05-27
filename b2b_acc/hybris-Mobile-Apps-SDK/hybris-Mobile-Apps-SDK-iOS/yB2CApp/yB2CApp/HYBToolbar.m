//
//  HYBToolbar.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBToolbar.h"

@interface HYBToolbar ()

@property (nonatomic) UIView* leftItemsView;
@property (nonatomic) UIView* centerItemsView;
@property (nonatomic) UIView* rightItemsView;

@property (nonatomic) CGFloat currentToolbarHeight;

@end

@implementation HYBToolbar

+ (id)toolbarWithFrame:(CGRect)frame {
    return [[HYBToolbar alloc] initWithFrame:frame];
}

- (id)initWithFrame:(CGRect)frame {
    
    _originalFrame = CGRectMake(frame.origin.x, frame.origin.y, frame.size.width, defaultToolbarHeight);
    
    if(self = [super initWithFrame:_originalFrame]) {
        self.accessibilityIdentifier = @"ACCESS_TOOLBAR";
        self.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        self.clipsToBounds = YES;
        
        if(![UIApplication sharedApplication].statusBarHidden) _statusbarMod = 20.f;
        
        _currentToolbarHeight = defaultToolbarHeight;
    }
    
    return self;
}

- (void)setToolbarHeight:(CGFloat)toolbarHeight {
    _currentToolbarHeight = toolbarHeight;
    self.frame = CGRectMake([self fX], [self fY], [self fW], _currentToolbarHeight);
    _originalFrame = self.frame;
    [self layoutSubviews];
}

- (CGFloat)toolbarHeight {
    return _currentToolbarHeight;
}

- (void)layoutSubviews {
    
    [super layoutSubviews];
    
    if (_leftItems && _leftItems.count > 0) {
        if(!_leftItemsView) {
            _leftItemsView = [UIView new];
            [self addSubview:_leftItemsView];
        }
        [self spreadItems:_leftItems inView:_leftItemsView];
        _leftItemsView.center = CGPointMake([_leftItemsView bW]/2+toolbarMarge, _statusbarMod+[self contentViewHeight]/2);
    }
    
    if (_centerItems && _centerItems.count > 0) {
        if(!_centerItemsView) {
            _centerItemsView = [UIView new];
            [self addSubview:_centerItemsView];
        }
        [self spreadItems:_centerItems inView:_centerItemsView];
        _centerItemsView.center = CGPointMake([self bW]/2, _statusbarMod+[self contentViewHeight]/2);
    }
    
    if (_rightItems && _rightItems.count > 0) {
        if(!_rightItemsView) {
            _rightItemsView = [UIView new];
            [self addSubview:_rightItemsView];
        }
        [self spreadItems:_rightItems inView:_rightItemsView];
        
        // strange bug on iPad resolution switching from 1024 to 1280 for no reason
        CGFloat bW = [self bW];
        if (bW > 1024) bW = 1024;
        
        CGPoint center = CGPointMake(bW - [_rightItemsView bW]/2, _statusbarMod+[self contentViewHeight]/2);
        _rightItemsView.center = center;
    }
}

- (CGFloat)contentViewHeight {
    return [self toolbarHeight]-_statusbarMod*2;
}

- (void)spreadItems:(NSArray*)items inView:(UIView*)view {    
    CGFloat width = 0;
    
    //cleanup
    [view removeSubviews];
    
    //add
    for (UIView *itemView in items) {
        
        //resize item to fit toolbar height
        CGFloat itemRatio = [itemView ratio];
        CGRect viewResizedFrame = CGRectMake(0, 0, [self contentViewHeight]*itemRatio, [self contentViewHeight]);
        itemView.frame = viewResizedFrame;
        
        //spread
        CGFloat itemWidth  = [itemView bW];
        
        width = width + itemWidth;
        
        itemView.center = CGPointMake(width-itemWidth/2, ([self toolbarHeight]-_statusbarMod)/2);
        
        [view addSubview:itemView];
        
        width = width + toolbarMarge;
    }
    
    //resize
    view.frame = CGRectMake(0, 0, width, [self contentViewHeight]);
}

//loading
- (void)setRightItems:(NSArray *)rightItems {
    if (_rightItemsView) {
        [_rightItemsView removeFromSuperview];
        _rightItemsView = nil;
    }
    
    _rightItems = rightItems;
    
    [self setNeedsLayout];
}

- (void)setLeftItems:(NSArray *)leftItems {
    if (_leftItemsView) {
        [_leftItemsView removeFromSuperview];
        _leftItemsView = nil;
    }
    
    _leftItems = leftItems;
    
    [self setNeedsLayout];
}

- (void)setCenterItems:(NSArray *)centerItems {
    if (_centerItemsView) {
        [_centerItemsView removeFromSuperview];
        _centerItemsView = nil;
    }
    
    _centerItems = centerItems;
    
    [self setNeedsLayout];
}

#pragma mark animation

- (void)setRightItemsViewHidden:(BOOL)hidden completion:(void (^)())completion {
    [self setItemsView:_rightItemsView hidden:hidden completion:completion];
}

- (void)setLeftItemsViewHidden:(BOOL)hidden completion:(void (^)())completion {
    [self setItemsView:_leftItemsView hidden:hidden completion:completion];
}

- (void)setCenterItemsViewHidden:(BOOL)hidden completion:(void (^)())completion {
    [self setItemsView:_centerItemsView hidden:hidden completion:completion];
}

- (void)setItemsView:(UIView*)itemView hidden:(BOOL)hidden completion:(void (^)())completion {
    
    CGFloat targetAlpha = 0.f;
    if (!hidden) targetAlpha = 1.f;
    
    [UIView animateWithDuration:defaultAnimationDuration/3*2
                     animations:^() {
                         itemView.alpha = targetAlpha;
                     }
                     completion:^(BOOL done) {
                        if(completion) completion();
                     }];
    
}

@end
