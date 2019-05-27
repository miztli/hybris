//
//  HYBGeolocatorObject.h
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

//utility
+ (NSDictionary*)dictWithLatitude:(double)latitude longitude:(double)longitude andOptions:(NSDictionary*)array;

//shortcut init
+ (instancetype)objectWithParams:(NSDictionary*)params;
+ (instancetype)objectWithLatitude:(double)latitude longitude:(double)longitude;
+ (instancetype)objectWithLatitude:(double)latitude longitude:(double)longitude andOptions:(NSDictionary*)array;

//init
- (instancetype)initWithParams:(NSDictionary*)params;
- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude;
- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude andOptions:(NSDictionary*)array;

//methods
- (NSString*)description;
- (BOOL)hasOptions;
- (NSInteger)optionsCount;
- (NSArray*)optionsAllKeys;
- (NSArray*)optionsAllValues;

//CoreLocation methods
- (CLLocationCoordinate2D)coordinate;
- (CLLocation*)location;
@end
