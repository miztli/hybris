//
//  HYBGeolocatorObject.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorObject.h"


@implementation HYBGeolocatorObject

//init

- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude andOptions:(NSDictionary*)options {
    if(self = [super init]) {
        _longitude  = longitude;
        _latitude   = latitude;
        _options    = options;
    }
    return self;
}

//methods
- (NSString*)description {
    NSString *finalString = nil;
    NSString *tmpString = [NSString stringWithFormat:@"lat:%.6f - long:%.6f",_latitude,_longitude];
    
    if([self hasOptions]) {
        finalString = [tmpString stringByAppendingString:[NSString stringWithFormat:@" - opt count:%lu - opt: %@",(unsigned long)[[_options allKeys] count],[_options description]]];
    } else {
        finalString = [tmpString stringByAppendingString:@" - no options"];
    }
    
    return finalString;
}

- (BOOL)hasOptions {
    return (_options && [_options count] > 0);
}

- (NSInteger)optionsCount {
    if([self hasOptions]) return [[_options allKeys] count];
    return 0;
}

- (NSArray*)optionsAllKeys {
    if([self hasOptions]) return [_options allKeys];
    return nil;
}

- (NSArray*)optionsAllValues {
    if([self hasOptions]) return [_options allValues];
    return nil;
}

- (CLLocationCoordinate2D)coordinate {
    return CLLocationCoordinate2DMake(_latitude,_longitude);
}

- (CLLocation*)location {
    return [[CLLocation alloc] initWithLatitude:_latitude longitude:_longitude];
}

@end
