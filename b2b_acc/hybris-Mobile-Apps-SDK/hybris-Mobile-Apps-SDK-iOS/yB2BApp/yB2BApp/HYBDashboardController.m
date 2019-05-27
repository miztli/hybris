//
// HYBDashboardController.m
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


#import "HYBDashboardController.h"

@interface HYBDashboardController ()

@end

@implementation HYBDashboardController

- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService {

    if (self = [super initWithBackEndService:b2bService]) {
        self.view.backgroundColor = [UIColor whiteColor];
        
        UIImageView *dummy = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"dashboard"]];
        dummy.frame =  CGRectInset(dummy.frame, 30, 30);
        dummy.center = self.view.center;
                
        [self.view addSubview:dummy];
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
}

@end
