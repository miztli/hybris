//
//  HYBGeolocatorTools.h
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

#import <Foundation/Foundation.h>
#import <CoreLocation/CoreLocation.h>

@protocol HYBGeolocatorToolsDelegate <NSObject>

@optional
- (void)didUpdateLocation;

@end

@interface HYBGeolocatorTools : NSObject <CLLocationManagerDelegate>

@property (nonatomic, assign) id <HYBGeolocatorToolsDelegate> delegate;

@property (nonatomic) BOOL isUpdating;
@property (nonatomic) CLLocation *userLocation;

- (void)startUpdate;
- (void)stopUpdate;

+(CLLocationDistance)distanceFrom:(CLLocation*)locA to:(CLLocation*)locB;

@end
