//
//  HYBGeolocatorWaitingController.m
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

#import "HYBGeolocatorWaitingController.h"
#import "HYBGeolocatorPinView.h"

@interface HYBGeolocatorWaitingController ()

@end

@implementation HYBGeolocatorWaitingController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    UILabel *waitingLabel = [UILabel new];
    waitingLabel.text = @"Finding user location...";
    [waitingLabel sizeToFit];
    waitingLabel.center = self.view.center;
    [self.view addSubview:waitingLabel];    
    
    HYBGeolocatorPinView *pinView = [HYBGeolocatorPinView pinWithColor:[UIColor redColor] forIndex:1];
    pinView.center = CGPointMake(self.view.bounds.size.width/2, self.view.bounds.size.height/3);
    [self.view addSubview:pinView];
}

@end
