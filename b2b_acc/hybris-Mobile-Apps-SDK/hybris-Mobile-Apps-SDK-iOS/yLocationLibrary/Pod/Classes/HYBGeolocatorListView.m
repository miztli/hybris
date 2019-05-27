//
//  HYBGeolocatorListView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorListView.h"

@implementation HYBGeolocatorListView

- (instancetype)initWithFrame:(CGRect)frame {
    
    if (self = [super initWithFrame:frame]) {
        [self setup];
    }
    
    return self;
}

- (void)setup {
    
    self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    self.autoresizesSubviews = YES;
    
    //table
    _tableView = [[UITableView alloc] initWithFrame:self.bounds];
    
    //pile up
   [self addSubview:_tableView];
}

- (void)setFrame:(CGRect)frame {
    [super setFrame:frame];
    _tableView.frame = frame;
}

@end
