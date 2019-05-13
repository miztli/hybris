//
//  HYBAddressesListView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//

#import "HYBAddressesListView.h"

@interface HYBAddressesListView ()

@property(nonatomic) UIView     *contentView;
@end

@implementation HYBAddressesListView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.05;    
    
    //content frame
    _contentView.frame = CGRectMake([self bX], [self bY] + defaultTopMargin , [self bW], [self bH] - defaultTopMargin);
    
    //header
    _headerPanel.frame = CGRectMake(0,0, [self bW], defaultTopMargin);
    
    //table
    _tableView.frame = CGRectMake(0, [_headerPanel bottom], [self bW], [_contentView bH] - [_headerPanel bottom]);
    
    [_addButton sizeToFit];
    _addButton.frame = CGRectInset(_addButton.frame, -10, -10);
    _addButton.center = CGPointMake([_headerPanel bW] - [_addButton bW]/2 - margin/2, [_headerPanel bH]/2);
    
    //close
    [_closeButton sizeToFit];
    _closeButton.frame = CGRectInset(_closeButton.frame, -10, -10);
    _closeButton.center = CGPointMake([_closeButton bW]/2 + margin/2, [_headerPanel bH]/2);
}

- (void)setup {
    
    //content view
    _contentView = [UIView new];
    _contentView.backgroundColor = account_background;
    
    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    //
    _headerPanel  = [UIView new];
    _headerPanel.backgroundColor = hybris_white;
    
    _closeButton = [HYBActionButton new];
    [_closeButton setTitle:NSLocalizedString(@"backKey", nil) forState:UIControlStateNormal];
    [_closeButton setBackgroundColor:hybris_gray forState:UIControlStateNormal];
    
    _addButton = [HYBActionButton new];
    [_addButton setTitle:NSLocalizedString(@"createNewKey", nil) forState:UIControlStateNormal];
    [_addButton setBackgroundColor:hybris_yellow forState:UIControlStateNormal];
    
    //
    _tableView = [UITableView new];
    
    //pile up
    
    [_headerPanel addSubview:_closeButton];
    [_headerPanel addSubview:_addButton];
    
    
    [_contentView addSubview:_headerPanel];
    
    [_contentView addSubview:_tableView];
    
    [self addSubview:_contentView];
    
    
}

@end
