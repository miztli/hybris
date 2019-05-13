//
//  HYBGeolocatorMasterController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorMapController.h"
#import "HYBGeolocatorObject.h"
#import "HYBGeolocatorListController.h"
#import "HYBBaseMapAnnotation.h"



@interface HYBGeolocatorMapController ()

@property (nonatomic) NSArray *annotationsArray;

@end

@implementation HYBGeolocatorMapController

- (instancetype)init {
    if(self = [super init]) {
        
        if(!_mainView) _mainView = [HYBGeolocatorMapView new];
        self.view = _mainView;
        
        _customAnnotationClassName = nil;
        
        _mainView.centerOnUserButton.userInteractionEnabled = YES;
        UITapGestureRecognizer *tapCenterOnUser = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(centerMapOnUserAnimated:)];
        [_mainView.centerOnUserButton addGestureRecognizer:tapCenterOnUser];
        
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
    int index = 0;
    
    for (HYBGeolocatorObject *geoObject in _geoDataArray) {
        double latitude  = geoObject.latitude ;
        double longitude = geoObject.longitude;
        
        if(_customAnnotationClassName) {
            id <MKAnnotation> annotation = [[NSClassFromString(_customAnnotationClassName) alloc] init];
            
            if([annotation respondsToSelector:@selector(setIndex:)]) {
                [(HYBBaseMapAnnotation*)annotation setIndex:index];
                [(HYBBaseMapAnnotation*)annotation setCoordinate:CLLocationCoordinate2DMake(latitude,longitude)];
                [(HYBBaseMapAnnotation*)annotation setTitle:[NSString stringWithFormat:@"%d. %@",index+1, geoObject.options[HYBGEONAME]]];
                [(HYBBaseMapAnnotation*)annotation setSubtitle:geoObject.options[HYBGEODESCRIPTION]];
            }
            
            [tmpArray addObject:annotation];
        } else {
            MKPointAnnotation *defaultAnnotation = [[MKPointAnnotation alloc] init];
            defaultAnnotation.coordinate = CLLocationCoordinate2DMake(latitude,longitude);
            defaultAnnotation.title = [NSString stringWithFormat:@"%d. %@",index+1, geoObject.options[HYBGEONAME]];
            defaultAnnotation.subtitle = geoObject.options[HYBGEODESCRIPTION];
            
            [tmpArray addObject:defaultAnnotation];
        }
        
        index++;
    }
    
    _annotationsArray = [NSArray arrayWithArray:tmpArray];
    
    [_mainView.mapView addAnnotations:_annotationsArray];
}

- (void)clearMap {
    [_mainView.mapView removeAnnotations:[_mainView.mapView annotations]];
}

- (void)centerMapOnUserAndClosest:(BOOL)animated {
    
    CLLocation *userLocation        = _mainView.mapView.userLocation.location;
    CLLocation *closestGeoObject    = [_geoDataArray firstObject];
    
    if(userLocation && closestGeoObject) {
        [self centerMapBetweenCoordinate:userLocation.coordinate
                           andCoordinate:closestGeoObject.coordinate
                                animated:animated];
    }
    
    else if (userLocation) {
        [self centerMapOnUserAnimated:animated];
    }
    
    else if (closestGeoObject) {
        [self centerMapOnFirstResultAnimated:animated];
    }
    
}

- (void)centerMapOnUserAnimated:(BOOL)animated {
    [self centerMapOnCoordinate:_mainView.mapView.userLocation.location.coordinate withRadius:defaultRadius animated:animated];
}

- (void)centerMapOnFirstResultAnimated:(BOOL)animated {
    
    HYBGeolocatorObject *geoObject = [_geoDataArray firstObject];
    
    if (geoObject) {
        [self centerMapOnCoordinate:[geoObject coordinate] withRadius:defaultRadius animated:animated];
    }
}

- (void)centerMapBetweenCoordinate:(CLLocationCoordinate2D)coordinateOne andCoordinate:(CLLocationCoordinate2D)coordinateTwo animated:(BOOL)animated {
    
        MKMapPoint mp1 = MKMapPointForCoordinate(coordinateOne);
        MKMapPoint mp2 = MKMapPointForCoordinate(coordinateTwo);
        
        MKMapRect zoomRect = MKMapRectMake (fmin(mp1.x, mp2.x),
                                            fmin(mp1.y, mp2.y),
                                            fabs(mp1.x - mp2.x),
                                            fabs(mp1.y - mp2.y));
        
        double inset = -zoomRect.size.width * 0.6;
        
        [_mainView.mapView setVisibleMapRect:MKMapRectInset(zoomRect, inset, inset) animated:animated];
    
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
