//
//  HYBStoreLocatorController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBStoreLocatorController.h"
#import "HYBGeolocatorMasterController.h"
#import "HYBGeolocatorMapController.h"
#import "HYBGeolocatorListController.h"
#import "HYBGeolocatorMapView.h"
#import "HYBGeolocatorObject.h"
#import "HYBGeolocatorTools.h"

#import "MapPinAnnotation.h"
#import "MapPinAnnotationView.h"
#import "MapCalloutAnnotation.h"
#import "MapCalloutAnnotationView.h"

#import "HYBStoreCustomListCell.h"
#import "HYBStoreCustomDetailController.h"
#import "HYBB2BService.h"
#import "HYBAppDelegate.h"

#import "HYBPointOfService.h"

#define ANNOTATION_PIN_ID       @"ANNOTATION_PIN_ID"
#define ANNOTATION_CALLOUT_ID   @"ANNOTATION_CALLOUT_ID"

@interface HYBStoreLocatorController ()
@property (nonatomic) NSArray *rawStores;
@property (nonatomic) NSArray *geoLocatedStores;
@property (nonatomic) HYBGeolocatorMasterController *geolocatorMasterController;
@property (nonatomic) CLLocationManager *locationManager;
@end

BOOL didGetLocation = NO;

@implementation HYBStoreLocatorController


- (void)viewDidLoad {
    [super viewDidLoad];
    
    didGetLocation = NO;
    
    // ** Don't forget to add NSLocationWhenInUseUsageDescription in MyApp-Info.plist and give it a string
    _locationManager = [CLLocationManager new];
    _locationManager.delegate = self;
    _locationManager.desiredAccuracy = kCLLocationAccuracyBest;
    
    // Check for iOS 8. Without this guard the code will crash with "unknown selector" on iOS 7.
    if ([_locationManager respondsToSelector:@selector(requestWhenInUseAuthorization)]) {
        [_locationManager requestWhenInUseAuthorization];
    }
    
    [_locationManager startUpdatingLocation];
    
    [self enter];
    
}

// Location Manager Delegate Methods
- (void)locationManager:(CLLocationManager *)manager didUpdateLocations:(NSArray *)locations {
    DDLogDebug(@"didUpdateLocations: %d", (int)[locations count]);
    if (!didGetLocation) {
        DDLogDebug(@"didGetLocation");
        didGetLocation = YES;
        [_locationManager stopUpdatingLocation];
        _locationManager.delegate = nil;
        _locationManager = nil;
    }
}

- (void)locationManager:(CLLocationManager *)manager didChangeAuthorizationStatus:(CLAuthorizationStatus)status {
    DDLogDebug(@"didChangeAuthorizationStatus: %d", status);
    if(status != kCLAuthorizationStatusRestricted && status != kCLAuthorizationStatusDenied) {
        [_locationManager startUpdatingLocation];
    }
}

- (void)locationManager:(CLLocationManager *)manager didFailWithError:(NSError *)error {
    DDLogDebug(@"didFailWithError: %@", error);
    UIAlertView *errorAlert = [[UIAlertView alloc]
            initWithTitle:NSLocalizedString(@"problems_retrieving_location", @"Problem retrieving location") message:NSLocalizedString(@"technical_error_while_retrieving_your_location", @"Technical error occured while retrieving your location") delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
    [errorAlert show];
}

- (void)enter {
    
    _geolocatorMasterController = [HYBGeolocatorMasterController new];
    _geolocatorMasterController.view.frame = self.view.frame;
    [self addChildViewController:_geolocatorMasterController];
    
    [self.view addSubview:_geolocatorMasterController.view];
    
    //set custom list cell for listcontroller
    
    _geolocatorMasterController.listController.customListCellClassName = @"HYBStoreCustomListCell";
    
    //set custom pin class for map
    _geolocatorMasterController.mapController.customAnnotationClassName = @"MapPinAnnotation";
    _geolocatorMasterController.mapController.mainView.mapView.delegate = self;
    
    //set custom detail controller for list
    _geolocatorMasterController.listController.customDetailController = [[HYBStoreCustomDetailController alloc] initWithBackEndService:self.b2bService];
    
    [self.backEndService resetPagination];
    [self.backEndService getStoresWithParams:[NSDictionary dictionary] andExecute:^(NSArray* foundStores, NSError *error) {
        if(error) {
            DDLogError(@"Can't find stores. Backend error is %@", error.localizedDescription);
        } else {
            [self bridgeGeoObjectsAndStores:foundStores];
        }
    }];
}

- (void)dealloc {
    [_geolocatorMasterController removeFromParentViewController];
    _geolocatorMasterController.mapController.mainView.mapView.delegate = nil;
}

- (void)bridgeGeoObjectsAndStores:(NSArray*)rawStores {
    
    NSMutableArray *tmpArray = [NSMutableArray array];
    
    
    //transpose HYBStores to GeoObjects
    for (HYBPointOfService *store in rawStores) {
        
        double latitude  = [store.geoPoint.latitude  doubleValue];
        double longitude = [store.geoPoint.longitude doubleValue];
        
        if([HYBGeolocatorTools validateLatitude:latitude andLongitude:longitude]) {
            
            NSDictionary *options = [NSDictionary dictionaryWithObjectsAndKeys:
                                     store.name,HYBGEONAME,
                                     store.address.formattedAddress,HYBGEODESCRIPTION,
                                     store, @"fullHYBStore",
                                     nil];
            
            HYBGeolocatorObject *geoObject = [[HYBGeolocatorObject alloc] initWithLatitude:latitude
                                                                                 longitude:longitude
                                                                                andOptions:options];
            
            [tmpArray addObject:geoObject];
        }
    }
    
    _geoLocatedStores = [NSArray arrayWithArray:tmpArray];
    
    DDLogDebug(@"_geoLocatedStores %lu", (unsigned long)[_geoLocatedStores count]);
    
    _geolocatorMasterController.geoDataArray = _geoLocatedStores;
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self topToolbar].searchDelegate = self;
}

#pragma mark map delegate

- (id)mapView:(MKMapView *)mapView viewForAnnotation:(id <MKAnnotation>)annotation {
    
    NSString *reuseId = nil;
    
    if ([annotation isKindOfClass:[MapPinAnnotation class]]) {
        //we recreate the view each time to updatade the index number displayed
        
        MapPinAnnotationView *annotationView = [[MapPinAnnotationView alloc]
                          initWithAnnotation:annotation
                          reuseIdentifier:reuseId];
        
        annotationView.pinView.pinIndex = [NSNumber numberWithInteger:([(HYBBaseMapAnnotation*)annotation index]+1)];
        annotationView.pinView.pinColor = store_locator_pin_background;
        
        [annotationView.pinView setNeedsDisplay];
        
        return annotationView;
        
    }  else if ([annotation isKindOfClass:[MapCalloutAnnotation class]]) {
        
        // Callout annotation.
        reuseId = ANNOTATION_CALLOUT_ID;
        
        MapCalloutAnnotationView *annotationView = (MapCalloutAnnotationView *)[mapView dequeueReusableAnnotationViewWithIdentifier:reuseId];
        
        if (annotationView == nil) {
            annotationView = [[MapCalloutAnnotationView alloc] initWithAnnotation:annotation reuseIdentifier:reuseId];
        }
        
        MapCalloutAnnotation *calloutAnnotation = (MapCalloutAnnotation *)annotation;
        
        annotationView.centerOffset = CGPointMake(0, -95.f);
        
        ((MapCalloutAnnotationView *)annotationView).title      = calloutAnnotation.title;
        ((MapCalloutAnnotationView *)annotationView).subtitle   = calloutAnnotation.subtitle;
        
        annotationView.tag = [(HYBBaseMapAnnotation*)annotation index];
        
        //allows callout
        annotationView.canShowCallout = YES;
        
        UITapGestureRecognizer *tapCallout = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(openDetails:)];
        annotationView.userInteractionEnabled = YES;
        [annotationView addGestureRecognizer:tapCallout];
        
        return annotationView;
    }
    
    return nil;
    
}

- (void)openDetails:(UITapGestureRecognizer*)sender {
    [self openDetailsAtIndex:sender.view.tag];
}

- (void)openDetailsAtIndex:(NSInteger)index {
    
    if(_geolocatorMasterController.listController) {
        HYBGeolocatorListController *listController = _geolocatorMasterController.listController;
        
        HYBGeolocatorObject *geoObject = listController.geoDataArray[index];
        
        if(geoObject) {
            if (_geolocatorMasterController.mapController) [_geolocatorMasterController.mapController centerMapOnCoordinate:geoObject.coordinate withRadius:defaultRadius animated:YES];
            
            [listController updateResultsCountHidden:YES];
            
            if(listController.customDetailController) {
                
                [listController.customDetailController setGeoObject:geoObject];
                [listController.customDetailController setControllerOptions:[NSDictionary dictionaryWithObject:[listController distanceFromUserForObject:geoObject] forKey:@"distance"]];
                
                if([listController.navigationController.topViewController isKindOfClass:[HYBGeolocatorDetailController class]]) {
                    [listController.customDetailController getFullStore];
                } else {
                    [listController.navigationController pushViewController:listController.customDetailController animated:YES];
                }
            }
        }
    }
}

- (void)mapView:(MKMapView *)mapView didSelectAnnotationView:(MKAnnotationView *)view {
    
    if ([view.annotation isKindOfClass:[MapPinAnnotation class]]) {
        
        // Selected the pin annotation.
        MapCalloutAnnotation *calloutAnnotation = [[MapCalloutAnnotation alloc] init];
        
        MapPinAnnotation *pinAnnotation = ((MapPinAnnotation *)view.annotation);
        calloutAnnotation.title      = pinAnnotation.title;
        calloutAnnotation.subtitle   = pinAnnotation.subtitle;
        calloutAnnotation.coordinate = pinAnnotation.coordinate;
        calloutAnnotation.index      = pinAnnotation.index;
        
        pinAnnotation.calloutAnnotation = calloutAnnotation;
        
        [mapView addAnnotation:calloutAnnotation];
        
        [_geolocatorMasterController.mapController centerMapOnCoordinate:calloutAnnotation.coordinate withRadius:defaultRadius animated:YES];
    }
}

- (void)mapView:(MKMapView *)mapView didDeselectAnnotationView:(MKAnnotationView *)view {
    
    if ([view.annotation isKindOfClass:[MapPinAnnotation class]]) {
        // Deselected the pin annotation.
        MapPinAnnotation *pinAnnotation = ((MapPinAnnotation *)view.annotation);
        
        [mapView removeAnnotation:pinAnnotation.calloutAnnotation];
        
        pinAnnotation.calloutAnnotation = nil;
    }
}

#pragma mark search + searchbar delegate


- (void)performSearchForString:(NSString *)searchString {
    DDLogDebug(@"search %@ in Store Locator controller",searchString);
    
    if (searchString && searchString.length > 0) {
        if(self) {
            self.currentSearchQuery = [searchString copy];
            _rawStores = [NSArray array];
        }
        
        [self.b2bService resetPagination];
        [self doPerformSearch];
    }
}

//bridgeGeoObjectsAndStores

- (void)doPerformSearch {
    DDLogDebug(@"Searching for products by query %@ ...", self.currentSearchQuery);
    
    [HYBActivityIndicator show];
    
    [self.b2bService findStoreBySearchQuery:self.currentSearchQuery
                                 andExecute:^(NSArray *stores, NSError *error) {
                                     
                                     [HYBActivityIndicator hide];
                                     
                                     if (error) {
                                         DDLogError(@"Problems during the retrieval of the stores from the web service: %@", [error localizedDescription]);
                                     } else {
                                         
                                         
                                     }
                                 }];
}

@end
