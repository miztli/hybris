//
//  HYBGeolocatorMasterView.m
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


#import "HYBGeolocatorMasterView.h"

@interface HYBGeolocatorMasterView ()
@property (nonatomic) BOOL isAdapting;
@end

@implementation HYBGeolocatorMasterView

- (instancetype)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        
        _isAdapting = NO;
        
        //foldView
        _foldView = [HYBFoldView foldViewWithFrame:CGRectMake(self.frame.origin.x,
                                                              self.frame.size.height/2,
                                                              self.frame.size.width,
                                                              self.frame.size.height/2)];
                
        [_foldView layoutSubviews];
        [self addSubview:_foldView];
        
        //kvo
        [_foldView addObserver:self
                    forKeyPath:@"isOpen"
                       options:(NSKeyValueObservingOptionInitial | NSKeyValueObservingOptionNew|NSKeyValueObservingOptionOld)
                       context:NULL];
        
        self.backgroundColor = [UIColor redColor];
    }
    return self;
}

- (void)setListView:(HYBGeolocatorListView *)listView {
    if(!_listView) [_foldView.contentView addSubview:listView];
    _listView = listView;
}

- (void)setMapView:(HYBGeolocatorMapView *)mapView {
    if(!_mapView) {
        [self addSubview:mapView];
        [self bringSubviewToFront:_foldView];
    }
        [self adaptMapView];
    _mapView = mapView;
}

#pragma mark map kvo

- (void)observeValueForKeyPath:(NSString *)keyPath
                      ofObject:(id)object
                        change:(NSDictionary *)change
                       context:(void *)context {
    
    if(_mapView) [self adaptMapViewAnimated:YES];
}

- (void)adaptMapViewAnimated:(BOOL)animated {
    if (animated) {
        if (!_isAdapting) {
            _isAdapting = YES;
            [UIView animateWithDuration:foldAnimationDuration
                             animations:^() {
                                 [self adaptMapView];
                             }
                             completion:^(BOOL done) {
                                 _isAdapting = NO;
                             }
             ];
        } else {
            [self adaptMapView];
        }
    }
}

- (void)adaptMapView {
    if([_foldView.isOpen boolValue]) {
        _mapView.mapView.center = CGPointMake(_mapView.center.x, _mapView.center.y - (_foldView.frame.origin.y + [_foldView handleHeight]/2) /2);
    } else {
        _mapView.mapView.center = _mapView.center;
    }
}


@end
