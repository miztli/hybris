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

#import "HYBGeolocatorMasterView.h"

@interface HYBGeolocatorMasterView ()
@property (nonatomic) BOOL isAdapting;
@property (nonatomic) CGFloat max;
@property (nonatomic) CGFloat min;

@end

@implementation HYBGeolocatorMasterView

- (instancetype)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        
        _max = frame.size.height;
        _min = frame.size.width;
        
        self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        self.autoresizesSubviews = YES;
        
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
        
        
        //store count
        _storeCountLabel = [UILabel new];
        
        [_foldView addSubview:_storeCountLabel];
        
    }
    return self;
}

- (void)layoutSubviews {
    [_storeCountLabel sizeToFit];
    _storeCountLabel.center = CGPointMake(_storeCountLabel.bounds.size.width/2+20.f, _foldView.handleHeight-10.f);
    [self adaptMapView];
}

- (void)dealloc {
    [_foldView removeObserver:self forKeyPath:@"isOpen"];
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
        
        _mapView.frame = CGRectMake(_mapView.frame.origin.x,
                                    _mapView.frame.origin.y,
                                    _mapView.frame.size.width,
                                    self.frame.size.height - (self.frame.size.height - _foldView.frame.origin.y) + _foldView.handleHeight/2
                                    );
    } else {
        _mapView.frame = self.frame;
    }
    
    _mapView.mapView.frame = _mapView.bounds;
    _mapView.centerOnUserButton.center = CGPointMake(_mapView.mapView.bounds.size.width  - _mapView.centerOnUserButton.bounds.size.width,
                                                     _mapView.mapView.bounds.size.height - _mapView.centerOnUserButton.bounds.size.height - 20.f);
}

- (void)adaptMapViewToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration {
    
    //landscape
    CGRect nextFrame = CGRectMake(0, 0, _max , _min);
    
    if(toInterfaceOrientation == UIInterfaceOrientationPortrait || toInterfaceOrientation == UIInterfaceOrientationPortraitUpsideDown) {
         nextFrame = CGRectMake(0, 0, _min , _max);
    }
    
    [UIView animateWithDuration:duration
                     animations:^() {
                         _mapView.frame = nextFrame;
                     }];
}

@end
