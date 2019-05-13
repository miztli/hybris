//
//  HYBOrdersHistoryCell.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBOrdersHistoryCell.h"
#import "stylesheet.h"
#import "UIView+Utilities.h"
#import "UIColor+Expanded.h"

@implementation HYBOrdersHistoryCell

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {
    
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
        
        self.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        self.autoresizesSubviews = YES;
        
        _orderIdLabel   = [self defaultLabel];
        _dateLabel      = [self defaultLabel];
        _statusLabel    = [self defaultLabel];
        _totalLabel     = [self defaultLabel];
        
        //cell ids
        _orderIdLabel.accessibilityIdentifier = @"ACCESS_ORDERS_CODE";
        _dateLabel.accessibilityIdentifier = @"ACCESS_ORDERS_DATE";
        _statusLabel.accessibilityIdentifier= @"ACCESS_ORDERS_STATUS";
        _totalLabel.accessibilityIdentifier = @"ACCESS_ORDERS_TOTAL";
        
        [self addSubview:_orderIdLabel];
        [self addSubview:_dateLabel];
        [self addSubview:_statusLabel];
        [self addSubview:_totalLabel];

    }
    
    return self;
}

- (UILabel*)defaultLabel {
    
   UILabel *defaultLabel = [UILabel new];
    defaultLabel.font = orders_history_cell_font_text;
    defaultLabel.textColor = orders_history_cell_text;
    defaultLabel.textAlignment = NSTextAlignmentCenter;
    defaultLabel.layer.borderColor = orders_history_cell_border.CGColor;
    defaultLabel.layer.borderWidth = 1.f;
    
    return defaultLabel;
}

- (void)setEven:(BOOL)even {
    _isEven = even;
    
    if (_isEven) self.backgroundColor = orders_history_cell_background_even;
    else self.backgroundColor = orders_history_cell_background_odd;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGRect baseFrame = CGRectMake(0, 0, [self bW]/4, [self bH]);
    
    _orderIdLabel.frame = baseFrame;
    _dateLabel.frame    = baseFrame;
    _statusLabel.frame  = baseFrame;
    _totalLabel.frame   = baseFrame;
    
    _orderIdLabel.center    = CGPointMake([self bW]/8,  [self bH]/2);
    _dateLabel.center       = CGPointMake([self bW]/8*3,  [self bH]/2);
    _statusLabel.center     = CGPointMake([self bW]/8*5,[self bH]/2);
    _totalLabel.center      = CGPointMake([self bW]/8*7,[self bH]/2);
}

- (UIEdgeInsets)layoutMargins {
    return UIEdgeInsetsZero;
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];
}

@end
