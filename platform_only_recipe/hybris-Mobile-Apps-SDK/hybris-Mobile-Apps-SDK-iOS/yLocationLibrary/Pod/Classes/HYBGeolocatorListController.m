//
//  HYBGeolocatorListController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorListController.h"
#import "HYBGeolocatorMasterController.h"
#import "HYBGeolocatorMapController.h"
#import "HYBGeolocatorDetailController.h"
#import "HYBGeolocatorDefaultCell.h"
#import "HYBGeolocatorObject.h"
#import "HYBGeolocatorTools.h"

#define GEOCELL_ID @"GEOCELL_ID"

@interface HYBGeolocatorListController ()
@end

@implementation HYBGeolocatorListController

- (instancetype)init {
    if(self = [super init]) {
        if(!_mainView) _mainView = [HYBGeolocatorListView new];
        self.view = _mainView;
        
        
    }
    return self;
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [self updateResultsCountHidden:NO];
    
    
    _mainView.tableView.delegate = self;
    _mainView.tableView.dataSource = self;
    
    if(_customListCellClassName) {
        [_mainView.tableView registerClass:NSClassFromString(_customListCellClassName) forCellReuseIdentifier:GEOCELL_ID];
    } else {
        [_mainView.tableView registerClass:[HYBGeolocatorDefaultCell class] forCellReuseIdentifier:GEOCELL_ID];
    }
}

- (void)refresh {
    [_mainView.tableView reloadData];
}

- (void)setDataArray:(NSArray *)dataArray {
    _geoDataArray = dataArray;
    
}
#pragma mark tableView delegate

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_geoDataArray count];
}

- (HYBGeolocatorDefaultCell*)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBGeolocatorDefaultCell* cell = [tableView dequeueReusableCellWithIdentifier:GEOCELL_ID];
    
    HYBGeolocatorObject *geoObject = (HYBGeolocatorObject*)_geoDataArray[indexPath.row];
    
    cell.indexLabel.text = [NSString stringWithFormat:@"%d.",(int)(indexPath.row+1)];
    cell.nameLabel.text  = geoObject.options[HYBGEONAME];
    cell.descriptionLabel.text = geoObject.options[HYBGEODESCRIPTION];
    cell.distanceLabel.text = [NSString stringWithFormat:@"%.2f km",[[self distanceFromUserForObject:geoObject] doubleValue]];
    
    [cell setupWithGeoObject:geoObject];

    cell.chevronView.userInteractionEnabled = YES;
    cell.chevronView.tag = indexPath.row;
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(openDetails:)];
    [cell.chevronView addGestureRecognizer:tapGesture];
    
    cell.chevronView.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_CHEVRON_VIEW_%ld",(long)indexPath.row];
    
    return cell;
}

- (NSNumber*)distanceFromUserForObject:(HYBGeolocatorObject*)object {
    if(_userLocation) return [NSNumber numberWithDouble:[HYBGeolocatorTools distanceFrom:_userLocation to:[object location]]/1000];
    return [NSNumber numberWithDouble:0.f];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 120.f;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (_mapController) {
        [_mapController openAnnotationAtIndex:indexPath.row];
    }
}

- (void)openDetails:(UITapGestureRecognizer*)sender {
    [self openDetailsAtIndex:sender.view.tag];
}

- (void)openDetailsAtIndex:(NSInteger)index {
    
    HYBGeolocatorObject *geoObject = self.geoDataArray[index];
    
    if(geoObject) {
        if (self.mapController) [self.mapController centerMapOnCoordinate:geoObject.coordinate withRadius:defaultRadius animated:YES];
        
        [self updateResultsCountHidden:YES];
        
        if(_customDetailController) {
            [(HYBGeolocatorDetailController*)_customDetailController setGeoObject:geoObject];
            [(HYBGeolocatorDetailController*)_customDetailController setControllerOptions:[NSDictionary dictionaryWithObject:[self distanceFromUserForObject:geoObject] forKey:@"distance"]];
            [self.navigationController pushViewController:_customDetailController animated:YES];
        }
    }
}

- (void)updateResultsCountHidden:(BOOL)hidden {
    if(self.parentViewController.parentViewController && [self.parentViewController.parentViewController isKindOfClass:[HYBGeolocatorMasterController class]]) {
        HYBGeolocatorMasterController *masterController = (HYBGeolocatorMasterController*)self.parentViewController.parentViewController;
        [masterController setResultsLabelHidden:hidden];
    }
}

@end
