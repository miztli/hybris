//
//  MapCalloutAnnotationView.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <MapKit/MapKit.h>

@interface MapCalloutAnnotationView : MKAnnotationView

@property (nonatomic) NSNumber *index;

@property (nonatomic) UIImageView *bubblePoint;

@property (nonatomic) UIView *containerView;
@property (nonatomic) UIView *roundedBackgroundView;

@property (nonatomic) NSString *title;
@property (nonatomic) NSString *subtitle;

@property (nonatomic) UILabel *titleLabel;
@property (nonatomic) UILabel *subtitleLabel;

@property (nonatomic) UIView *leftCalloutAccessoryView;
@property (nonatomic) UIView *rightCalloutAccessoryView;

@property (nonatomic) UIView *leftCalloutAccessoryPlaceholder;
@property (nonatomic) UIView *rightCalloutAccessoryPlaceholder;

- (id)initWithAnnotation:(id <MKAnnotation>)annotation reuseIdentifier:(NSString *)reuseIdentifier;

@end
