//
//  MapPinAnnotationView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
#import "MapPinAnnotationView.h"

@implementation MapPinAnnotationView


- (id)initWithAnnotation:(id <MKAnnotation>)annotation reuseIdentifier:(NSString *)reuseIdentifier {
    if (self = [super initWithAnnotation:annotation reuseIdentifier:reuseIdentifier]) {
        _pinView = [[HYBGeolocatorPinView alloc] initWithColor:[UIColor redColor] forIndex:nil];
        self.frame = _pinView.frame;
        [self addSubview:_pinView];
    }
    return self;
}

@end
