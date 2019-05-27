//
// HYBActivityIndicator.m
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


#import "HYBActivityIndicator.h"
#import "HYBConstants.h"

@interface HYBActivityIndicator ()
@property (nonatomic, strong) UIView *containerView;
@property (nonatomic, strong) UIView *backgroundView;
@property (nonatomic, strong) UIActivityIndicatorView *spinnerView;
@property (nonatomic) BOOL hidden;
@end

@implementation HYBActivityIndicator

static HYBActivityIndicator *activityIndicator = nil;

+(id)sharedInstance {
    if(!activityIndicator) {
        activityIndicator = [[HYBActivityIndicator alloc] init];
    }
        
    return activityIndicator;
}

-(id)init {
    if(self = [super init]) {
        CGRect baseFrame = CGRectMake(0, 0, 125, 125);
        
        _hidden = YES;
        
        //container
        [self setContainerView:[[UIView alloc]  initWithFrame:baseFrame]];
        [_containerView.layer setCornerRadius:8];
        [_containerView setClipsToBounds:YES];
        
        _containerView.accessibilityIdentifier = @"ACCESS_ACTIVITY_INDICATOR";
        
        //background
        [self setBackgroundView:[[UIView alloc] initWithFrame:baseFrame]];
        [_backgroundView setBackgroundColor:[UIColor blackColor]];
        [_backgroundView setAlpha:.7];
        
        //spinner
        [self setSpinnerView:[[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleWhiteLarge]];
        [_spinnerView setCenter:CGPointMake(baseFrame.size.width/2, baseFrame.size.height/2)];
        
        //pile up
        [_containerView addSubview:_backgroundView];
        [_containerView addSubview:_spinnerView];
        
    }
    
    return self;
}

+(void)show {
    [[HYBActivityIndicator sharedInstance] show];
}

+(void)hide {
    [[HYBActivityIndicator sharedInstance] hide];
}

-(void)show {
    if (_hidden) {
        _hidden = NO;
        
        [_containerView setAlpha:0.f];
        
        UIWindow *mainWindow = [[[UIApplication sharedApplication] delegate] window];
        [_containerView setCenter:mainWindow.center];
        
        [mainWindow addSubview:_containerView];
        
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             [_containerView setAlpha:1.f];
                             
                         } completion:^(BOOL done) {
                             [_spinnerView startAnimating];
                         }];
    }
}

-(void)hide {
    if (!_hidden) {
        [_spinnerView stopAnimating];
        
        [UIView animateWithDuration:defaultAnimationDuration
                         animations:^() {
                             [_containerView setAlpha:0.f];
                         }
                         completion:^(BOOL done){
                             _hidden = YES;
                             [_containerView removeFromSuperview];                             
                         }];
    }
}


@end
