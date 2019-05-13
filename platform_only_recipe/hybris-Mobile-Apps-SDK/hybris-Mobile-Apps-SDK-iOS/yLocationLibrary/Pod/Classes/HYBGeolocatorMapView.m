//
//  HYBGeolocatorMasterView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
#import "HYBGeolocatorMapView.h"
#import "HYBFoldView.h"

@interface HYBGeolocatorMapView ()
@end

@implementation HYBGeolocatorMapView

+ (instancetype)mapViewWithFrame:(CGRect)frame {
    return [[HYBGeolocatorMapView alloc] initWithFrame:frame];
}

- (instancetype)initWithFrame:(CGRect)frame {
    if (self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)setup {
    
   // self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
   // self.autoresizesSubviews = YES;
    
    //map
    _mapView = [[MKMapView alloc] initWithFrame:self.bounds];
    _mapView.userInteractionEnabled = YES;
    _mapView.showsUserLocation = YES;
    [self addSubview:_mapView];
    
    //centerOnUserButton    
    NSString *bundlePath = [[NSBundle mainBundle] pathForResource:@"yLocationLibrary" ofType:@"bundle"];
    NSBundle *bundle = [NSBundle bundleWithPath:bundlePath];
    UIImage *image = [UIImage imageWithContentsOfFile:[bundle pathForResource:@"centerOnUserIcon" ofType:@"png"]];
    
    _centerOnUserButton = [[UIImageView alloc] initWithImage:image];
    [self addSubview:_centerOnUserButton];
    _centerOnUserButton.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_LOCATE_USER_BUTTON" ;
    
}

- (void)setFrame:(CGRect)frame {
    [super setFrame:frame];
    _mapView.frame = self.frame;
    _centerOnUserButton.center = CGPointMake(_mapView.bounds.size.width  - _centerOnUserButton.bounds.size.width,
                                             _mapView.bounds.size.height - _centerOnUserButton.bounds.size.height - 20.f);
}



@end
