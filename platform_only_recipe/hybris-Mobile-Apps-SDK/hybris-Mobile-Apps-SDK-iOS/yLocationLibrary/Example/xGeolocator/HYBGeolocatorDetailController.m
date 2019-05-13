//
//  HYBGeolocatorDetailController.m
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


#import "HYBGeolocatorDetailController.h"

@interface HYBGeolocatorDetailController ()

@end

@implementation HYBGeolocatorDetailController

- (instancetype)init {
    if(self = [super init]) {
        if(!_mainView) _mainView = [HYBGeolocatorDetailView new];
        self.view = _mainView;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
}

@end
