//
// HYBBaseMenuView.m
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


#import "HYBBaseMenuView.h"
#import "HYBToolbar.h"
#import "HYBConstants.h"


@implementation HYBBaseMenuView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setupView];
    }
    return self;
}

- (void)setupView {
    CGRect frame = CGRectMake(0, defaultTopMargin, [self bW], [self bH] - defaultTopMargin);
    _menuTableView = [[UITableView alloc] initWithFrame:frame style:UITableViewStylePlain];
    _menuTableView.backgroundColor = menu_background_default;
    [self addSubview:_menuTableView];
}

- (void)setFooterView:(UIView *)footerView {
    if (_footerView) {
        [_footerView removeFromSuperview];
        _footerView = nil;
    }
    
    _footerView = footerView;
    [self addSubview:_footerView];
}

- (void)setHeaderView:(UIView *)headerView {
    if (_headerView) {
        [_headerView removeFromSuperview];
        _headerView = nil;
    }
    
    _headerView = headerView;
    [self addSubview:_headerView];
}

- (void)layoutSubviews {
        
    [super layoutSubviews];
    
    CGFloat modY = -20.f;
    CGFloat modH = 0.f;
    
    //keep header at top
    if(_headerView) {
        modY = [_headerView bH];
        _headerView.frame = CGRectMake(0, defaultTopMargin, [self fW], modY);
    }
    
    //keep footer at bottom
    if(_footerView) {
        modH = [_footerView bH];
        _footerView.frame = CGRectMake(0, defaultTopMargin + [self bH] - defaultTopMargin - modH, [self fW], modH);
    }
    
    //resize tableview in between
    _menuTableView.frame = CGRectMake(0, defaultTopMargin + modY, [self fW], [self bH] - defaultTopMargin - modY - modH);
}

@end