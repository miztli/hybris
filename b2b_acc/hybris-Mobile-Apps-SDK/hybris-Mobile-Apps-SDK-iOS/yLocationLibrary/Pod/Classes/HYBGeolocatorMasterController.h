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

@class HYBGeolocatorMasterView;
@class HYBGeolocatorMapController;
@class HYBGeolocatorListController;

@interface HYBGeolocatorMasterController : UIViewController

@property (nonatomic) NSArray *geoDataArray;

@property (nonatomic) HYBGeolocatorMasterView       *masterView;
@property (nonatomic) HYBGeolocatorMapController    *mapController;
@property (nonatomic) HYBGeolocatorListController   *listController;

@property (nonatomic) UINavigationController *listNavigationController;

/**
 *
 *  reload map and list content
 *
 */
- (void)refresh;

/**
 *
 *  hide/show results count
 *
 */
- (void)setResultsLabelHidden:(BOOL)hidden;

@end
