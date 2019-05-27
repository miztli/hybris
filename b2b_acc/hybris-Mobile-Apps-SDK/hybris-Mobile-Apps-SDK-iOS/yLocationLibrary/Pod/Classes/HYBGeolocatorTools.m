//
//  HYBGeolocatorTools.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorTools.h"

@interface HYBGeolocatorTools ()



@end

@implementation HYBGeolocatorTools

- (id)init {
    if ((self = [super init])) {
        _locationManager = [CLLocationManager new];        
        _locationManager.delegate = self;
        _locationManager.distanceFilter = kCLDistanceFilterNone;
        _locationManager.desiredAccuracy = kCLLocationAccuracyBest;
        
        _userLocation = nil;
    }
    
    return self;
}

-(void)startUpdate {
    if(!_isUpdating) {
        _isUpdating = YES;
        [_locationManager startUpdatingLocation];
    }
}

-(void)stopUpdate {
    if(!_isUpdating) {
        _isUpdating = NO;
        [_locationManager stopUpdatingLocation];
    }
}

- (CLLocation*)userLocation {    
    if (!_userLocation) {
        [self startUpdate];
    }
    
    return _userLocation;
}

#pragma mark utilities

+ (CLLocationDistance)distanceFrom:(CLLocation*)locA to:(CLLocation*)locB {
    return [locA distanceFromLocation:locB];
}

+ (BOOL)validateLatitude:(double)latitude andLongitude:(BOOL)longitude {
    //if lon/lat are incorrect don't take the object into account
    
    if(latitude < -90.0 || latitude > 90.0)       return NO;
    if(longitude < -180.0 || longitude > 180.0  ) return NO;
    
    return YES;
}

#pragma mark CoreLocation delegate

- (void)locationManager:(CLLocationManager *)manager didUpdateLocations:(NSArray *)locations {
    _userLocation = [locations lastObject];
    
    if (_delegate && [_delegate respondsToSelector:@selector(didUpdateLocation)]) {
        [_delegate didUpdateLocation];
    }
}

@end
