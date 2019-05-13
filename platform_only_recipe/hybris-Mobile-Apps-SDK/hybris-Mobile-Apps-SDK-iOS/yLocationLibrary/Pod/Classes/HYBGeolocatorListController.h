//
//  HYBGeolocatorListController.h
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
#import "HYBGeolocatorListView.h"
#import <CoreLocation/CoreLocation.h>

@class HYBGeolocatorMapController;
@class HYBGeolocatorObject;

@interface HYBGeolocatorListController : UIViewController <UITableViewDataSource, UITableViewDelegate>

@property (nonatomic) HYBGeolocatorMapController *mapController;
@property (nonatomic) HYBGeolocatorListView *mainView;
@property (nonatomic) NSArray *geoDataArray;
@property (nonatomic) CLLocation *userLocation;
@property (nonatomic) id customDetailController;
@property (nonatomic) NSString *customListCellClassName;

/**
 *
 *  reload tableview content
 *
 */
- (void)refresh;


/**
 *
 *  hide/show results count
 *
 */
- (void)updateResultsCountHidden:(BOOL)hidden;

/**
 *  calculate distance between user an a GeoObject
 *
 *  @param object HYBGeolocatorObject
 *
 *  @return NSNumber distance
 */
- (NSNumber*)distanceFromUserForObject:(HYBGeolocatorObject*)object;

@end
