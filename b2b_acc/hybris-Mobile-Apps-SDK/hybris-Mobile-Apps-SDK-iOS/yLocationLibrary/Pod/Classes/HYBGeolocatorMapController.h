//
//  HYBGeolocatorMasterController.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
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

#define defaultRadius 500.f

@class HYBGeolocatorListController;

@interface HYBGeolocatorMapController : UIViewController <MKMapViewDelegate>

@property (nonatomic) HYBGeolocatorListController *listController;
@property (nonatomic) HYBGeolocatorMapView *mainView;
@property (nonatomic) NSArray *geoDataArray;
@property (nonatomic) NSString *customAnnotationClassName;

/**
 *
 *  reload map content
 *
 */
- (void)refresh;

/**
 *
 *  remove all annotations from map
 *
 */
- (void)clearMap;

/**
 *
 *  center map around user location and closest annotation
 *
 *  @param animated BOOL
 *
 */
- (void)centerMapOnUserAndClosest:(BOOL)animated;

/**
 *
 *  center map around user location
 *
 *  @param animated BOOL
 *
 */
- (void)centerMapOnUserAnimated:(BOOL)animated;

/**
 *
 *  center map on first object in the location array
 *
 *  @param animated BOOL
 *
 */
- (void)centerMapOnFirstResultAnimated:(BOOL)animated;

/**
 *
 *  center map on given coordinates
 *
 *  @param coordinate CLLocationCoordinate2D
 *  @param radius CGFloat
 *  @param animated BOOL
 *
 */
- (void)centerMapOnCoordinate:(CLLocationCoordinate2D)coordinate withRadius:(CGFloat)radius animated:(BOOL)animated;

/**
 *
 *  center map on given index in annotationsArray then select this annotation to trigger action
 *
 *  @param index NSInteger
 *
 */
- (void)openAnnotationAtIndex:(NSInteger)index;

@end
