//
//  HYBStoreContactTools.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBStoreContactTools.h"
#import "HYBPointOfService.h"
#import "HYBAddress.h"
#import "HYBGeoPoint.h"
#import <MapKit/MapKit.h>

@implementation HYBStoreContactTools


+ (void)callStore:(HYBPointOfService*)store  {
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Calling store:"
                                                    message:store.address.phone
                                                   delegate:nil
                                          cancelButtonTitle:@"Cancel" otherButtonTitles:@"Ok", nil];
    
    [alert show];
}


+ (void)directionsToStore:(HYBPointOfService*)store {
    CLLocationCoordinate2D coordinate = CLLocationCoordinate2DMake([store.geoPoint.latitude doubleValue], [store.geoPoint.longitude doubleValue]);
    
    MKPlacemark* place = [[MKPlacemark alloc] initWithCoordinate:coordinate addressDictionary: nil];
    MKMapItem* destination = [[MKMapItem alloc] initWithPlacemark: place];
    destination.name = store.displayName;
    
    NSArray* items = [[NSArray alloc] initWithObjects: destination, nil];
    
    NSDictionary* options = [[NSDictionary alloc] initWithObjectsAndKeys:
                             MKLaunchOptionsDirectionsModeDriving,
                             MKLaunchOptionsDirectionsModeKey, nil];
    
    [MKMapItem openMapsWithItems:items launchOptions: options];
}



@end
