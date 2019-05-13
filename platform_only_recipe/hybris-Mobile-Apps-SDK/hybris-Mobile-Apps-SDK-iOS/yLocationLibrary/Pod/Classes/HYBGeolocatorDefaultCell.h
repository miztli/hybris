//
//  HYBGeolocatorDefaultCell.h
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
#import "HYBGeolocatorObject.h"

@interface HYBGeolocatorDefaultCell : UITableViewCell

@property (nonatomic) UILabel *indexLabel;
@property (nonatomic) UILabel *nameLabel;
@property (nonatomic) UILabel *descriptionLabel;
@property (nonatomic) UILabel *distanceLabel;

@property (nonatomic) UIView *chevronView;

/**
 *  used in subclasses to modifiy the content of custom cells
 *
 *  @param geoObject HYBGeolocatorObject
 *
 */

- (void)setupWithGeoObject:(HYBGeolocatorObject*)geoObject;

@end
