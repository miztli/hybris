//
//  HYBOrderHistoryView.m
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

#import "HYBOrdersHistoryView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"


@interface HYBOrdersHistoryView ()
@property (nonatomic) HYBActionButton *codeSortButton;
@property (nonatomic) HYBActionButton *dateSortButton;
@property (nonatomic) HYBActionButton *statusSortButton;
@property (nonatomic) HYBActionButton *totalSortButton;
@end

@implementation HYBOrdersHistoryView


- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)setup {
    
    //title Label
    _titleLabel = [UILabel new];
    _titleLabel.text = NSLocalizedString(@"orders_label_title", nil);
    _titleLabel.font = font_title;
    _titleLabel.textColor = orders_history_title;
    _titleLabel.accessibilityIdentifier = @"ACCESS_ORDERS_TITLE";
    
    
    _filterButton = [HYBActionButton new];

    _filterButton.titleLabel.font = orders_history_cell_font_buttons;
    [_filterButton setTitle:NSLocalizedString(@"orders_filters_button", nil) forState:UIControlStateNormal];
    [_filterButton setTitleColor:orders_history_filter_button forState:UIControlStateNormal];
    [_filterButton setTitleColor:orders_history_filter_button_hilighted forState:UIControlStateHighlighted];
    [_filterButton setBackgroundColor:orders_history_filter_button_background forState:UIControlStateNormal];
    _filterButton.accessibilityIdentifier = @"ACCESS_ORDERS_BUTTON_FILTERS";
    
    
    _codeSortButton = [self baseButtonWithTitle:NSLocalizedString(@"orders_sort_button_code", nil)];
    _codeSortButton.accessibilityIdentifier = @"ACCESS_ORDERS_BUTTON_CODE";
    
    _dateSortButton = [self baseButtonWithTitle:NSLocalizedString(@"orders_sort_button_date", nil)];
    _dateSortButton.accessibilityIdentifier = @"ACCESS_ORDERS_BUTTON_DATE";
    
    _statusSortButton = [self baseButtonWithTitle:NSLocalizedString(@"orders_sort_button_status", nil)];
    _statusSortButton.accessibilityIdentifier = @"ACCESS_ORDERS_BUTTON_STATUS";
    
    _totalSortButton = [self baseButtonWithTitle:NSLocalizedString(@"orders_sort_button_total", nil)];
    _totalSortButton.accessibilityIdentifier = @"ACCESS_ORDERS_BUTTON_TOTAL";

    
    //table
    _ordersTable = [UITableView new];
    
    //pile up
    [self addSubview:_titleLabel];
    //[self addSubview:_filterButton];
    
    [self addSubview:_codeSortButton];
    [self addSubview:_dateSortButton];
    [self addSubview:_statusSortButton];
    [self addSubview:_totalSortButton];
    
    [self addSubview:_ordersTable];
}

- (HYBActionButton*)baseButtonWithTitle:(NSString*)title {
    
    HYBActionButton *baseButton = [HYBActionButton new];
    baseButton.titleLabel.font = orders_history_cell_font_buttons;
    [baseButton setTitle:[title uppercaseString] forState:UIControlStateNormal];
    [baseButton setTitleColor:orders_history_buttons forState:UIControlStateDisabled];
    [baseButton setBackgroundColor:orders_history_buttons_background forState:UIControlStateDisabled];
    baseButton.layer.borderColor = orders_history_cell_border.CGColor;
    baseButton.layer.borderWidth = 1.f;
    baseButton.enabled = NO;
    
    return baseButton;
}

- (void)layoutSubviews {
    [super layoutSubviews];

    CGFloat margin = [self bW]*.05;
    CGFloat lineHeight = 60.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 40.f;
    }
    
    //title
    [_titleLabel sizeToFit];
    _titleLabel.center = CGPointMake([_titleLabel bW]/2 + margin,
                                     [_titleLabel bH]/2 + lineHeight + defaultTopMargin);
    
   
    //filters
    _filterButton.frame = CGRectMake(0, 0, [self bW]/6, lineHeight);
    _filterButton.center = CGPointMake([self bW] - [_filterButton bW]/2, [_filterButton bH]/2 + lineHeight + defaultTopMargin);

    //buttons
    CGRect baseFrame = CGRectMake(0, 0, [self bW]/4, lineHeight);
    
    _codeSortButton.frame   = baseFrame;
    _dateSortButton.frame   = baseFrame;
    _statusSortButton.frame = baseFrame;
    _totalSortButton.frame  = baseFrame;
    
    CGFloat buttonsY = [_titleLabel bottom] + margin + lineHeight/2;
    
    _codeSortButton.center    = CGPointMake([self bW]/8,  buttonsY);
    _dateSortButton.center    = CGPointMake([self bW]/8*3,buttonsY);
    _statusSortButton.center  = CGPointMake([self bW]/8*5,buttonsY);
    _totalSortButton.center   = CGPointMake([self bW]/8*7,buttonsY);
    
    //table
    _ordersTable.frame = CGRectMake(0, [_codeSortButton bottom], [self bW], [self bH] - [_codeSortButton bottom]);
    
}

@end
