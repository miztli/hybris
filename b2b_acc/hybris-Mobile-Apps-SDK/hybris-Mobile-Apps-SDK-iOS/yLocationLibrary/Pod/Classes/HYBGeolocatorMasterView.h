//
//  HYBGeolocatorMasterView.h
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
#import "HYBFoldView.h"
#import "HYBGeolocatorMapView.h"
#import "HYBGeolocatorListView.h"

@interface HYBGeolocatorMasterView : UIView

@property (nonatomic) HYBFoldView *foldView;
@property (nonatomic) HYBGeolocatorMapView  *mapView;
@property (nonatomic) HYBGeolocatorListView *listView;

@property (nonatomic) UILabel *storeCountLabel;

/**
 *  adapt map size according to foldview state
 *
 */
- (void)adaptMapView;

/**
 *  adapt map size after rotation - should not be used directly
 *
 */
- (void)adaptMapViewToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;

@end
