//
//  HYBGeolocatorListController.m
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

#import "HYBGeolocatorListController.h"
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
        
        _mainView.tableView.delegate = self;
        _mainView.tableView.dataSource = self;
        [_mainView.tableView registerClass:[HYBGeolocatorDefaultCell class] forCellReuseIdentifier:GEOCELL_ID];
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
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
    
    cell.indexLabel.text = [NSString stringWithFormat:@"%d.",indexPath.row+1];
    cell.nameLabel.text  = geoObject.options[HYBGEONAME];
    cell.descriptionLabel.text = geoObject.options[HYBGEODESCRIPTION];
    cell.distanceLabel.text = [NSString stringWithFormat:@"%.2f km",[[self distanceFromUserForObject:geoObject] doubleValue]];
    
    cell.chevronImageView.userInteractionEnabled = YES;
    cell.chevronImageView.tag = indexPath.row;
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(openDetails:)];
    [cell.chevronImageView addGestureRecognizer:tapGesture];
    
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
    HYBGeolocatorDetailController *storeDetailController = [HYBGeolocatorDetailController new];
    storeDetailController.geoObject = _geoDataArray[index];
    
    [self.navigationController pushViewController:storeDetailController animated:YES];
}

@end
