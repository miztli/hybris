//
//  HYBGeolocatorMasterController.m
//  xGeolocator
// [y] hybris Platform
//
// Copyright (c) 2000-2014 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorMapController.h"
#import "HYBGeolocatorObject.h"
#import "HYBGeolocatorListController.h"

CGFloat defaultRadius = 500.f;

@interface HYBGeolocatorMapController ()

@property (nonatomic) NSArray *annotationsArray;

@end

@implementation HYBGeolocatorMapController

- (instancetype)init {
    if(self = [super init]) {
        
        if(!_mainView) _mainView = [HYBGeolocatorMapView new];
        self.view = _mainView;
        
        _mainView.mapView.delegate = self;
    }
    return self;
}

- (void)refresh {
    
    if(_annotationsArray) {
        [self clearMap];
        _annotationsArray = nil;
    }
    
    NSMutableArray * tmpArray = [NSMutableArray array];
    
    //drop pins
    int index = 1;
    
    for (HYBGeolocatorObject *geoObject in _geoDataArray) {
        double latitude  = geoObject.latitude ;
        double longitude = geoObject.longitude;
        
        MKPointAnnotation *annotation = [MKPointAnnotation new];
        annotation.coordinate = CLLocationCoordinate2DMake(latitude,longitude);
        annotation.title = [NSString stringWithFormat:@"%d. %@",index++, geoObject.options[HYBGEONAME]];
        annotation.subtitle = geoObject.options[HYBGEODESCRIPTION];
        
        [tmpArray addObject:annotation];
        
        [_mainView.mapView addAnnotation:annotation];
    }
    
    _annotationsArray = [NSArray arrayWithArray:tmpArray];

}

- (void)clearMap {
    [_mainView.mapView removeAnnotations:[_mainView.mapView annotations]];
}

- (void)centerMapOnUserAnimated:(BOOL)animated {
    [self centerMapOnCoordinate:_mainView.mapView.userLocation.location.coordinate withRadius:defaultRadius animated:animated];
}

- (void)centerMapOnCoordinate:(CLLocationCoordinate2D)coordinate withRadius:(CGFloat)radius animated:(BOOL)animated {
    MKCoordinateRegion region =  MKCoordinateRegionMakeWithDistance (coordinate, radius, radius);
    [_mainView.mapView setRegion:region animated:animated];
}

- (void)openAnnotationAtIndex:(NSInteger)index {
    MKPointAnnotation *annotation = _annotationsArray[index];
    [_mainView.mapView selectAnnotation:annotation animated:YES];
    [self centerMapOnCoordinate:annotation.coordinate withRadius:defaultRadius animated:YES];
}

@end
