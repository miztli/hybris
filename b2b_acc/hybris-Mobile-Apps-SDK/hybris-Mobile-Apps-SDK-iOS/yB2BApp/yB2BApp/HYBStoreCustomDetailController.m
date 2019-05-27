//
//  HYBStoreCustomDetailController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <MapKit/MapKit.h>
#import "HYBStoreCustomDetailController.h"
#import "HYBStoreCustomDetailView.h"
#import "HYBStoreContactTools.h"
#import "HYBB2BService.h"
#import "HYBPointOfService.h"

@interface HYBStoreCustomDetailController ()
@property (nonatomic) HYBStoreCustomDetailView *mainView;
@property (nonatomic) HYBPointOfService *currentStore;
@property (nonatomic, readonly) HYBB2BService *backEndService;

@end

@implementation HYBStoreCustomDetailController

- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService {
    if (self = [super init]) {
        _backEndService = b2bService;
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) _mainView = [HYBStoreCustomDetailView new];
    self.view = _mainView;
    
    self.navigationController.navigationBar.translucent = NO;
    
    if ([self respondsToSelector:@selector(edgesForExtendedLayout)])
        self.edgesForExtendedLayout = UIRectEdgeNone;   // iOS 7 specific
    
 
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self getFullStore];
}

- (void)getFullStore {
    if([self.geoObject hasOptions]) {
        NSString *storeName = self.geoObject.options[HYBGEONAME];
        
        [self.backEndService getStoreDetailWithStoreName:storeName andParams:nil andExecute:^(HYBPointOfService *store, NSError *error) {
            if(error) {
                DDLogError(@"Can't find stores. Backend error is %@", error.localizedDescription);
                [self.navigationController popViewControllerAnimated:NO];
            } else {
                _currentStore = store;
                [self finishSetupWithStore:store];
            }
        }];
    }
}

- (void)finishSetupWithStore:(HYBPointOfService*)store {
    self.title = store.displayName;
    [_mainView setupWithStore:store];
    
    //call button action
    _mainView.callView.userInteractionEnabled = YES;
    UITapGestureRecognizer *tapCall = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                              action:@selector(callCurrentStore)];
    [_mainView.callView addGestureRecognizer:tapCall];
    
    //directions button action
    _mainView.directionsView.userInteractionEnabled = YES;
    UITapGestureRecognizer *tapDirections = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                    action:@selector(directionsToCurrentStore)];
    [_mainView.directionsView addGestureRecognizer:tapDirections];
    
    //back button action
    _mainView.backButtonLabel.userInteractionEnabled = YES;
    UITapGestureRecognizer *tapBack = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                    action:@selector(popDetailPage)];
    [_mainView.backButtonLabel addGestureRecognizer:tapBack];
    
    //update distance (reuse, don't recalculate)
    NSString *distance =  [NSString stringWithFormat:@"%.2f km",[self.controllerOptions[@"distance"] doubleValue]];
    _mainView.storeDistanceLabel.text = distance;
}

- (void)popDetailPage {
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)callCurrentStore {
    [HYBStoreContactTools callStore:_currentStore];
}

- (void)directionsToCurrentStore {
    [HYBStoreContactTools directionsToStore:_currentStore];
}

@end
