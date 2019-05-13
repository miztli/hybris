//
//  HYBStoreCustomDetailView.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <UIKit/UIKit.h>

#import "HYBGeolocatorPinView.h"

@class HYBPointOfService;

@interface HYBStoreCustomDetailView : UIView

@property (nonatomic) HYBGeolocatorPinView *pinView;
@property (nonatomic) UIView  *callView;
@property (nonatomic) UIView  *directionsView;
@property (nonatomic) UILabel *storeDistanceLabel;
@property (nonatomic) UILabel *backButtonLabel;

- (void)setupWithStore:(HYBPointOfService*)store;

@end
