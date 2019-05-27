//
//  HYBStoreCustomListCell.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorDefaultCell.h"

@class HYBPointOfService;

@interface HYBStoreCustomListCell : HYBGeolocatorDefaultCell

@property (nonatomic) UIView  *callView;
@property (nonatomic) UIView  *directionsView;
@property (nonatomic) UILabel *directionsLabel;
@property (nonatomic) UILabel *phoneLabel;
@property (nonatomic) HYBPointOfService *currentStore;

@end
