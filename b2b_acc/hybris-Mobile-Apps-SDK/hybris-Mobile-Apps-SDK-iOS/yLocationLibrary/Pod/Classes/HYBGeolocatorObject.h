//
//  HYBGeolocatorObject.h
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

#define HYBGEOLATITUDE  @"HYBGEOLATITUDE"
#define HYBGEOLONGITUDE @"HYBGEOLONGITUDE"
#define HYBGEODATA      @"HYBGEODATA"

#define HYBGEOTYPE          @"HYBGEOTYPE"
#define HYBGEONAME          @"HYBGEONAME"
#define HYBGEODESCRIPTION   @"HYBGEODESCRIPTION"

@interface HYBGeolocatorObject : NSObject

@property (nonatomic) double longitude;
@property (nonatomic) double latitude;
@property (nonatomic) NSDictionary *options;

- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude andOptions:(NSDictionary*)options;

//methods

/**
 *  return description of the object
 *
 *  @return NSString description
 */
- (NSString*)description;

/**
 *  return yes if object has options in its dictionnary
 *
 *  @return BOOL hasOptions
 */
- (BOOL)hasOptions;

/**
 *  return the number of options in the dictionnary
 *
 *  @return NSInteger optionsCount
 */
- (NSInteger)optionsCount;

/**
 *  return array of keys from the dictionnary
 *
 *  @return NSArray optionsAllKeys
 */
- (NSArray*)optionsAllKeys;

/**
 *  return array of values from the dictionnary
 *
 *  @return NSArray optionsAllKeys
 */
- (NSArray*)optionsAllValues;

//CoreLocation methods

/**
 *  return CoreLocation coordinate of the object
 *
 *  @return CLLocationCoordinate2D coordinate
 */
- (CLLocationCoordinate2D)coordinate;

/**
 *  return CoreLocation location of the object
 *
 *  @return CLLocation location
 */
- (CLLocation*)location;

@end
