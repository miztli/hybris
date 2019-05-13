//
//  AppDelegate.m
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


#import "AppDelegate.h"
#import "FakeData.h"
#import "HYBGeolocatorMasterController.h"
#import "HYBGeolocatorWaitingController.h"

@interface AppDelegate ()

@property (nonatomic) BOOL didCompleteSetup;


@end

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    
    _didCompleteSetup = NO;

    _geolocatorTools = [HYBGeolocatorTools new];
    _geolocatorTools.delegate = self;
    [_geolocatorTools startUpdate];
    
    HYBGeolocatorWaitingController *waitingController = [HYBGeolocatorWaitingController new];
    self.window.rootViewController = waitingController;
    
    self.window.backgroundColor = [UIColor whiteColor];
    [self.window makeKeyAndVisible];
    return YES;
}

- (void)completeSetup {
    _didCompleteSetup = YES;
    self.window.rootViewController = [HYBGeolocatorMasterController new];
}

- (void)didUpdateLocation {
    if (!_didCompleteSetup) {
        [self completeSetup];
    }    
}

@end
