//
// HYBViewController.m
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


#import "HYBViewController.h"

@interface HYBViewController ()

@property (nonatomic) CGRect baseRect;
@property (nonatomic) UIView *screenCacheMaskView;

@end

@implementation HYBViewController


- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService {
    if(self = [super init]) {
        _b2bService = b2bService;
        self.automaticallyAdjustsScrollViewInsets =  NO;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    _baseRect = self.view.frame;
    
    _screenCacheMaskView = [[UIView alloc] initWithFrame:[UIApplication sharedApplication].keyWindow.frame];
    _screenCacheMaskView.opaque = YES;
    _screenCacheMaskView.backgroundColor = hybris_blue;
    _screenCacheMaskView.hidden = YES;
    [[UIApplication sharedApplication].keyWindow addSubview:_screenCacheMaskView];

    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(appWillResignActive:)
                                                 name:UIApplicationWillResignActiveNotification
                                               object:nil];
    
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(appDidBecomeActive:)
                                                 name:UIApplicationDidBecomeActiveNotification
                                               object:nil];
}

- (void)appWillResignActive:(NSNotification *) notification {
    _screenCacheMaskView.hidden = NO;
}

- (void)appDidBecomeActive:(NSNotification *) notification {
    _screenCacheMaskView.hidden = YES;
}


- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
}

- (HYBTopToolbar*)topToolbar {
    return [(HYBDrawerController*)self.mm_drawerController topToolbar];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation {
    [super didRotateFromInterfaceOrientation:fromInterfaceOrientation];
    
    [self.view layoutSubviews];
}


#pragma mark search + searchbar delegate

- (void)performSearchForString:(NSString *)searchString {
    DDLogDebug(@"Default performSearchForString:%@",searchString);
    [self openCatalogWithCompletion:^(id controller){
        [controller performSearchForString:searchString];
    }];
}

@end

