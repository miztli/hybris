//
//  HYBGeolocatorMasterController.h
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

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>
#import <CoreLocation/CoreLocation.h>
#import "HYBGeolocatorMapView.h"

@class HYBGeolocatorListController;

@interface HYBGeolocatorMapController : UIViewController <MKMapViewDelegate>

@property (nonatomic) HYBGeolocatorListController *listController;
@property (nonatomic) HYBGeolocatorMapView *mainView;
@property (nonatomic) NSArray *geoDataArray;

- (void)refresh;
- (void)clearMap;

- (void)centerMapOnUserAnimated:(BOOL)animated;
- (void)centerMapOnCoordinate:(CLLocationCoordinate2D)coordinate withRadius:(CGFloat)radius animated:(BOOL)animated;

- (void)openAnnotationAtIndex:(NSInteger)index;

@end
