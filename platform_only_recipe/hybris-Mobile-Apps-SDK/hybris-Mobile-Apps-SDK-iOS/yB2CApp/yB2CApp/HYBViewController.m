//
// HYBViewController.m
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


#import "HYBViewController.h"

@interface HYBViewController ()

@property (nonatomic) CGRect baseRect;

@end

@implementation HYBViewController


- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    if(self = [super init]) {
        _backendService = backendService;
        self.automaticallyAdjustsScrollViewInsets =  NO;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    _baseRect = self.view.frame;
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

