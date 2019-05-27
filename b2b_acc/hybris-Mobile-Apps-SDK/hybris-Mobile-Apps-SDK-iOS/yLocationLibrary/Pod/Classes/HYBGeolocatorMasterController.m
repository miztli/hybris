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

#import "HYBGeolocatorMasterController.h"
#import "HYBGeolocatorMasterView.h"
#import "HYBGeolocatorMapController.h"
#import "HYBGeolocatorListController.h"

#import "HYBGeolocatorTools.h"
#import "HYBGeolocatorObject.h"

#define movedEnoughThreshold 100.f //in meters


@interface HYBGeolocatorMasterController ()
@property (nonatomic) NSArray *geoDataSortedArray;
@property (nonatomic) CLLocation *oldUserLocation;
@property (nonatomic) CLLocation *userLocation;
@end

@implementation HYBGeolocatorMasterController

- (instancetype)init {
    if(self = [super init]) {
        _oldUserLocation = nil;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if(!_masterView) _masterView = [[HYBGeolocatorMasterView alloc] initWithFrame:self.view.frame];
    self.view = _masterView;
        
    //mapController
    _mapController = [HYBGeolocatorMapController new];
    _mapController.mainView.frame = self.view.frame;
    [self addChildViewController:_mapController];
    
    //listController
    _listController = [HYBGeolocatorListController new];
    
    //list navigation
    _listNavigationController = [[UINavigationController alloc] initWithRootViewController:_listController];
    _listNavigationController.navigationBarHidden = YES;
    
    [self addChildViewController:_listNavigationController];
    
    //linking views
    _masterView.mapView  = _mapController.mainView;
    _masterView.listView = (HYBGeolocatorListView*)_listNavigationController.view;
    _masterView.listView.frame = _masterView.foldView.contentView.bounds;
    
    //track user location
    [_mapController.mainView.mapView.userLocation addObserver:self
                                     forKeyPath:@"location"
                                        options:(NSKeyValueObservingOptionInitial | NSKeyValueObservingOptionNew|NSKeyValueObservingOptionOld)
                                        context:nil];

    //setup interactions
    [self setupInteractions];
    
    //refresh UI
    [self refresh];
    
}

- (void)dealloc {
    [_mapController  removeFromParentViewController];
    [_listNavigationController  removeFromParentViewController];
    [_mapController.mainView.mapView.userLocation removeObserver:self forKeyPath:@"location"];
}

- (void)setGeoDataArray:(NSArray *)geoDataArray {
    _geoDataArray = geoDataArray;
    if (_geoDataArray && [_geoDataArray count] > 0) [self sortArray];
}

- (void)refresh {
    
    _masterView.storeCountLabel.text = [NSString stringWithFormat:@"Results: %lu stores found",(unsigned long)[_geoDataSortedArray count]];
    _masterView.storeCountLabel.accessibilityIdentifier = @"ACCESS_STORE_RESULTS_COUNT";
    [_masterView.storeCountLabel sizeToFit];
    
    [_mapController  refresh];
    [_listController refresh];
    
    [_masterView adaptMapView];
}

- (void)setResultsLabelHidden:(BOOL)hidden {
    _masterView.storeCountLabel.hidden = hidden;
}

- (void)setupInteractions {
    _mapController.listController = _listController;
    _listController.mapController = _mapController;
}

#pragma mark refresh on user location utilities

- (void)observeValueForKeyPath:(NSString *)keyPath
                      ofObject:(id)object
                        change:(NSDictionary *)change
                       context:(void *)context {
    
    _userLocation = _mapController.mainView.mapView.userLocation.location;
    _listController.userLocation = _userLocation;
    
    if([self userHasMovedEnough]) {
        [self sortArray];
    }
}

- (BOOL)userHasMovedEnough {

    BOOL triggerSort = NO;
    
    if (_oldUserLocation) {
        double distanceFromOldUserLocation = [HYBGeolocatorTools distanceFrom:_oldUserLocation to:_userLocation];
        if(distanceFromOldUserLocation >= movedEnoughThreshold) {
            triggerSort = YES;
        }
    } else {
        triggerSort = YES;
    }
    
    if(triggerSort) _oldUserLocation = [_userLocation copy];
    
    return triggerSort;
}

- (void)sortArray {
    if(_userLocation) {
        
        @synchronized(_geoDataSortedArray) {
            _geoDataSortedArray = [NSArray arrayWithArray:[_geoDataArray sortedArrayUsingComparator:^(HYBGeolocatorObject *object1, HYBGeolocatorObject *object2) {
                
                NSNumber *dist1 = [self distanceFromUserForObject:object1];
                NSNumber *dist2 = [self distanceFromUserForObject:object2];
                
                return (NSComparisonResult) [dist1 compare:dist2];
            }]];
        }
    } else {
        _geoDataSortedArray = [NSArray arrayWithArray:_geoDataArray];
    }
    
    _mapController.geoDataArray     = _geoDataSortedArray;
    _listController.geoDataArray    = _geoDataSortedArray;
        
    if(_userLocation) {
        [_mapController centerMapOnUserAndClosest:YES];
    } else {
        [_mapController centerMapOnFirstResultAnimated:YES];
    }
    
    [self refresh];
}

- (NSNumber*)distanceFromUserForObject:(HYBGeolocatorObject*)object {
    return [NSNumber numberWithDouble:[HYBGeolocatorTools distanceFrom:_userLocation to:[object location]]/1000];
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation {
    [super didRotateFromInterfaceOrientation:fromInterfaceOrientation];
    
}

- (void)willAnimateRotationToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration {
    [_masterView adaptMapViewToInterfaceOrientation:toInterfaceOrientation duration:duration];
}



@end
