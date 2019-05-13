//
//  HYBGeolocatorTools.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
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
@property (nonatomic) CLLocationManager *locationManager;
@property (nonatomic) BOOL isUpdating;
@property (nonatomic) CLLocation *userLocation;

/**
 *  
 * start tracking user location
 *
 */
- (void)startUpdate;

/**
 *
 * stop tracking user location
 *
 */
- (void)stopUpdate;

/**
 *  calculate distance between two locations
 *
 *  @param locA CLLocation
 *  @param locB CLLocation
 *
 *  @return CLLocationDistance distance
 */
+ (CLLocationDistance)distanceFrom:(CLLocation*)locA to:(CLLocation*)locB;

/**
 *  return YES if given longitude and latitude are valid numbers
 *
 *  @param latitude  double
 *  @param longitude double
 *
 *  @return BOOL isValid
 */
+ (BOOL)validateLatitude:(double)latitude andLongitude:(BOOL)longitude;

@end
