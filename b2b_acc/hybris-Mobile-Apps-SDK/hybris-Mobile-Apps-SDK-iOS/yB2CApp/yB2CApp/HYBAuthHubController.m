//
//  HYBAuthHubController.m
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

#import "HYBAuthHubController.h"
#import "HYBLoginViewController.h"
#import "HYBSignUpViewController.h"
#import "HYBLoginView.h"
#import "HYBSignUpView.h"

@interface HYBAuthHubController ()


@property(nonatomic)  UIView          *gradientView;
@property (nonatomic) CAGradientLayer *gradientLayer;
@property (nonatomic) UIScrollView *mainScrollView;

@property (nonatomic) HYBLoginViewController    *loginViewController;
@property (nonatomic) HYBSignUpViewController   *signUpViewController;
@property (nonatomic) HYBLoginView  *loginView;
@property (nonatomic) HYBSignUpView *signUpView;

@end

@implementation HYBAuthHubController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    if (self = [super init]) {
        NSAssert(backendService != nil, @"Service must be present.");
        _backendService = backendService;
    }
    return self;
}

- (void)dismiss {
    [self dismissViewControllerAnimated:YES
                             completion:nil];
}

- (void)addGradient {
    
    //gradient background
    _gradientView = [UIView new];
    _gradientView.frame     = self.view.bounds;
    _gradientLayer.frame    = _gradientView.frame;
    _gradientView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _gradientView.autoresizesSubviews = YES;
    
    UIColor *topColor       = background_gradient_start;
    UIColor *bottomColor    = background_gradient_end;
    
    NSArray *gradientColors = [NSArray arrayWithObjects:(id)topColor.CGColor, (id)bottomColor.CGColor, nil];
    NSArray *gradientLocations = [NSArray arrayWithObjects:[NSNumber numberWithInt:0.0],[NSNumber numberWithInt:1.0], nil];
    
    _gradientLayer = [CAGradientLayer layer];
    _gradientLayer.colors = gradientColors;
    _gradientLayer.locations = gradientLocations;
    _gradientLayer.frame = _gradientView.frame;
    
    [_gradientView.layer insertSublayer:_gradientLayer atIndex:0];

    [self.view addSubview:_gradientView];

}

- (void)viewDidLoad {
    [super viewDidLoad];
   
    [self addGradient];
    
    _loginViewController    = [[HYBLoginViewController alloc]   initWithBackEndService:self.backEndService];
    _loginView = (HYBLoginView*)_loginViewController.view;
    _loginView.frame = self.view.frame;
    
    _signUpViewController   = [[HYBSignUpViewController alloc]  initWithBackEndService:self.backEndService];
    _signUpViewController.loginViewController = _loginViewController;
    _signUpView = (HYBSignUpView*)_signUpViewController.view;
    _signUpView.frame = self.view.frame;
    [_signUpViewController resizePicker];
    
    [self addChildViewController:_loginViewController];
    [self addChildViewController:_signUpViewController];
    
    _mainScrollView = [UIScrollView new];
    _mainScrollView.frame = self.view.frame;
    _mainScrollView.pagingEnabled = YES;
    _mainScrollView.showsHorizontalScrollIndicator = NO;
    _mainScrollView.contentSize = CGSizeMake(self.view.bounds.size.width*2, self.view.bounds.size.height);
    _mainScrollView.scrollEnabled = NO;
    
    _loginView.center   = CGPointMake(self.view.bounds.size.width*.5,   self.view.bounds.size.height*.5);
    _signUpView.center  = CGPointMake(self.view.bounds.size.width*1.5,  self.view.bounds.size.height*.5);
    
    [_mainScrollView addSubview:_loginView];
    [_mainScrollView addSubview:_signUpView];
    
    [self setCommonInteractions];
    
    [self.view addSubview:_mainScrollView];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [_loginViewController   viewWillAppear:animated];
    [_signUpViewController  viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
    [_loginViewController   viewDidAppear:animated];
    [_signUpViewController  viewDidAppear:animated];
}


- (void)setCommonInteractions {
    
    //sign up button action
    [_loginView.signUpButton addTarget:self
                                 action:@selector(signUpButtonPressed)
                       forControlEvents:UIControlEventTouchUpInside];

}

- (void)signUpButtonPressed {
    DDLogDebug(@"Sign Up button pressed ...");
    
 
    [_mainScrollView scrollRectToVisible:_signUpView.frame animated:YES];
}


@end
