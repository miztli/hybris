//
//  HYBFoldView.m
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


#import "HYBFoldView.h"

@interface HYBFoldView ()

@property (nonatomic) UIView *backgroundView;

@property (nonatomic) CGPoint openCenter;
@property (nonatomic) CGPoint closeCenter;

@property (nonatomic) BOOL locked;

@end


@implementation HYBFoldView

+ (instancetype)foldViewWithFrame:(CGRect)frame {
    return [[HYBFoldView alloc] initWithFrame:frame];
}

- (CGFloat)handleHeight {
    return _handleImageView.bounds.size.height;
}

- (instancetype)initWithFrame:(CGRect)frame {
    
    if (self = [super initWithFrame:frame]) {
        [self setup];
    }
    
    return self;
}

- (void)setup {
    
    _isOpen = [NSNumber numberWithBool:YES];
    _locked = NO;
    
    //handle
    _handleImageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"defaultHandle.png"]];
    _handleImageView.userInteractionEnabled = YES;
    
    UITapGestureRecognizer *tapToggle = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(toggle)];
    [_handleImageView addGestureRecognizer:tapToggle];
    
    //background
    _backgroundView = [UIView new];
    _backgroundView.backgroundColor = [UIColor whiteColor];
    
    //content
    _contentView = [UIView new];
    
    //shadow
    self.layer.shadowColor = [UIColor blackColor].CGColor;
    self.layer.shadowOffset = CGSizeMake(0, -5.f);
    self.layer.shadowRadius = 10.f;
    self.layer.shadowOpacity = .35;
    
    //pile up
    [self addSubview:_backgroundView];
    [self addSubview:_contentView];
    [self addSubview:_handleImageView];
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    //handle
    CGFloat handleSize = _handleImageView.bounds.size.height;
    _handleImageView.center = CGPointMake(self.bounds.size.width/2, handleSize/2);
    
    //background
    _backgroundView.frame = CGRectMake(0, handleSize/2, self.bounds.size.width, self.bounds.size.height - handleSize/2);
    
    //content
    _contentView.frame = CGRectMake(0, handleSize, self.bounds.size.width, self.bounds.size.height - handleSize);

    //centers
    _openCenter  = CGPointMake(self.bounds.size.width/2,[self superview].bounds.size.height - self.bounds.size.height/2);
    _closeCenter = CGPointMake(self.bounds.size.width/2,[self superview].bounds.size.height + self.bounds.size.height/2 - handleSize);
}

- (void)setFrame:(CGRect)frame {
    [super setFrame:frame];
    [self layoutSubviews];
}

#pragma mark show off

- (void)toggle {
    _locked = YES;
    
    [self willChangeValueForKey:@"isOpen"]; //needed for kvo to work on bool
    
    if ([_isOpen boolValue]) {
        [self hide];
        _isOpen = [NSNumber numberWithBool:NO];
    } else {
        [self show];
        _isOpen = [NSNumber numberWithBool:YES];
    }
    
    [self didChangeValueForKey:@"isOpen"]; //needed for kvo to work on bool
}

- (void)show {
    [UIView animateWithDuration:foldAnimationDuration
                     animations:^() {
                         self.center = _openCenter;
                     }
                     completion:^(BOOL done) {
                         _locked = NO;
                     }];
}

- (void)hide {
    [UIView animateWithDuration:foldAnimationDuration
                     animations:^() {
                         self.center = _closeCenter;
                     }
                     completion:^(BOOL done) {
                         _locked = NO;
                     }];
}

@end
