//
//  HYBGeolocatorMasterView.m
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


#import "HYBGeolocatorMapView.h"
#import "HYBFoldView.h"

@interface HYBGeolocatorMapView ()

@end

@implementation HYBGeolocatorMapView

+ (instancetype)mapViewWithFrame:(CGRect)frame {
    return [[HYBGeolocatorMapView alloc] initWithFrame:frame];
}

- (instancetype)initWithFrame:(CGRect)frame {
    if (self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)setup {
    //map
    _mapView = [[MKMapView alloc] initWithFrame:self.frame];
    _mapView.userInteractionEnabled = YES;
    _mapView.showsUserLocation = YES;
     [self addSubview:_mapView];
}

- (void)layoutSubviews {
    [super layoutSubviews];
    _mapView.frame = self.frame;
}

@end
