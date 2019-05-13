//
// HYBOrdersDetailsView.m
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

#import "HYBOrdersDetailsView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

CGFloat toolbarHeight = 60.f;

@implementation HYBOrdersDetailsView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.025;
    CGFloat lineHeight = 18.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 14.f;
    }
    
    _backButton.frame = CGRectMake(0,
                                   defaultTopMargin,
                                   [self bW]/8,
                                   toolbarHeight);
    
    
    _contentView.frame = CGRectMake([self bX],
                                    [self bY] + defaultTopMargin + toolbarHeight ,
                                    [self bW],
                                    [self bH] - defaultTopMargin - toolbarHeight);
    
    [_titleLabel sizeToFit];
    _titleLabel.center = CGPointMake([_titleLabel bW]/2 + margin*2,
                                     [_titleLabel bH]/2 + margin*2);
    
    [_orderNumberLabel sizeToFit];
    _orderNumberLabel.center = CGPointMake([_contentView bW] - [_orderNumberLabel bW]/2 - margin*2,
                                      _titleLabel.center.y);
    
    [_dateLabel sizeToFit];
    _dateLabel.center = CGPointMake([_contentView bW] - [_dateLabel bW]/2 - margin*2,
                                       [_orderNumberLabel bottom] + [_dateLabel bH]/2+ lineHeight/2);
    
    [_orderStatusLabel sizeToFit];
    _orderStatusLabel.center = CGPointMake([_contentView bW] - [_orderStatusLabel bW]/2 - margin*2,
                                           [_dateLabel bottom] + [_orderStatusLabel bH]/2+ lineHeight/2);
    
    [_deliveryAddressTitle sizeToFit];
    _deliveryAddressTitle.center = CGPointMake([_deliveryAddressTitle bW]/2+ margin*2,
                                            [_dateLabel bottom] + [_deliveryAddressTitle bH]/2+ lineHeight +margin*2);
    
    
    [_deliveryAddressValue sizeToFit];
    _deliveryAddressValue.center = CGPointMake([_deliveryAddressValue bW]/2 + margin*2,
                                               [_deliveryAddressTitle bottom] + [_deliveryAddressValue bH]/2+ lineHeight);
    
    [_deliveryMethodTitle sizeToFit];
    _deliveryMethodTitle.center = CGPointMake([_contentView bW]/2 + [_deliveryMethodTitle bW]/2 + margin/2,
                                              _deliveryAddressTitle.center.y);
    
    
    [_deliveryMethodValue sizeToFit];
    _deliveryMethodValue.center = CGPointMake([_contentView bW]/2 + [_deliveryMethodValue bW]/2 + margin/2,
                                              [_deliveryMethodTitle bottom] + [_deliveryMethodValue bH]/2+ lineHeight);
        
    CGFloat max = MAX([_deliveryAddressValue bottom], [_deliveryMethodValue bottom]);
    
    
    [_trackingValue sizeToFit];
    _trackingValue.center = CGPointMake([_contentView bW] - [_trackingValue bW]/2 - margin*2,
                                        max + lineHeight + [_trackingValue bH]/2);
    
    
    [_trackingTitle sizeToFit];
    _trackingTitle.center = CGPointMake([_trackingValue left] - [_trackingTitle bW]/2 + 4.f,
                                        _trackingValue.center.y);
    
    _orderSummaryView.frame = CGRectMake(0,
                                         [_trackingValue bottom] + lineHeight,
                                         [_contentView bW],
                                         lineHeight);
    
    [_orderSummaryView layoutSubviews];
    
    _itemsTable.frame = CGRectMake(0,
                                   [_orderSummaryView bottom] + lineHeight*2,
                                   [_contentView bW],
                                   [_contentView bH] - [_orderSummaryView bottom] - lineHeight*2);
    
    _contentView.contentSize = CGSizeMake([_contentView bW], [_itemsTable bottom]);
}

- (void)setup {
    
    self.backgroundColor = orders_details_toolbar_background;
    
    self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    self.autoresizesSubviews = YES;
    
    //scroll view
    _contentView = [UIScrollView new];
    _contentView.backgroundColor = orders_details_background;
    
    //back button
    
    _backButton = [HYBActionButton new];
    [_backButton setTitle:NSLocalizedString(@"orders_details_back_button", nil) forState:UIControlStateNormal];
    [_backButton setBackgroundColor:order_details_back_button_background forState:UIControlStateNormal];
    _backButton.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_BACK_BUTTON";
    
    //title
    
    _titleLabel = [UILabel new];
    _titleLabel.text = NSLocalizedString(@"orders_details_title", nil);
    _titleLabel.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_TITLE";
    _titleLabel.textColor = orders_details_title;
    _titleLabel.font = orders_details_title_font;
    
    //order number
    
    _orderNumberLabel = [UILabel new];
    _orderNumberLabel.textColor = orders_details_number;
    _orderNumberLabel.font = orders_details_number_font;
    _orderNumberLabel.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_ORDER_NUMBER";
    
    //date
    
    _dateLabel = [UILabel new];
    _dateLabel.textColor = orders_details_date;
    _dateLabel.font = orders_details_date_font;
    _dateLabel.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_DATE";
    
    //status
    
    _orderStatusLabel = [UILabel new];
    _orderStatusLabel.textColor = orders_details_status;
    _orderStatusLabel.font = orders_details_status_font;
    _orderStatusLabel.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_STATUS";
    
    //delivery address
    
    _deliveryAddressTitle = [UILabel new];
    _deliveryAddressTitle.text = NSLocalizedString(@"deliveryAddress_label_title", nil);
    _deliveryAddressTitle.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_DELIVERY_ADDRESS_TITLE";
    _deliveryAddressTitle.textColor = order_confirmation_title;
    _deliveryAddressTitle.font = order_confirmation_font_title;
    
    _deliveryAddressValue = [UILabel new];
    _deliveryAddressValue.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_DELIVERY_ADDRESS";
    _deliveryAddressValue.numberOfLines = 0;
    _deliveryAddressValue.textColor = order_confirmation_default;
    _deliveryAddressValue.font = order_confirmation_font_default;
    
    //delivery method
    
    _deliveryMethodTitle = [UILabel new];
    _deliveryMethodTitle.text = NSLocalizedString(@"deliveryMethod_label_title", nil);
    _deliveryMethodTitle.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_DELIVERY_METHOD_TITLE";
    _deliveryMethodTitle.textColor = order_confirmation_title;
    _deliveryMethodTitle.font = order_confirmation_font_title;
    
    _deliveryMethodValue = [UILabel new];
    _deliveryMethodValue.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_DELIVERY_METHOD";
    _deliveryMethodValue.numberOfLines = 0;
    _deliveryMethodValue.textColor = order_confirmation_default;
    _deliveryMethodValue.font = order_confirmation_font_default;
    
    //tracking number
    
    _trackingTitle = [UILabel new];
    _trackingTitle.text = NSLocalizedString(@"trackingNumber_label_title", nil);
    _trackingTitle.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_TRACKING_NUMBER_TITLE";
    _trackingTitle.textColor = orders_details_tracking_title;
    _trackingTitle.font = orders_details_tracking_title_font;
    
    _trackingValue = [UILabel new];
    _trackingValue.accessibilityIdentifier = @"ACCESS_ORDER_DETAILS_TRACKING_NUMBER_VALUE";
    _trackingValue.textColor = orders_details_tracking_value;
    _trackingValue.font = orders_details_tracking_value_font;
    
    //order summary
    _orderSummaryView = [HYBOrderSummaryView new];
    _orderSummaryView.backgroundColor = order_confirmation_summary_background;
    
    //products table
    _itemsTable = [UITableView new];
    _itemsTable.backgroundColor = order_confirmation_table_background;
    
    //pile up        
    
    [self addSubview:_backButton];
    
    [_contentView addSubview:_titleLabel];
    [_contentView addSubview:_orderNumberLabel];
    [_contentView addSubview:_dateLabel];
    [_contentView addSubview:_orderStatusLabel];
    [_contentView addSubview:_deliveryAddressTitle];
    [_contentView addSubview:_deliveryAddressValue];
    [_contentView addSubview:_deliveryMethodTitle];
    [_contentView addSubview:_deliveryMethodValue];
    [_contentView addSubview:_trackingTitle];
    [_contentView addSubview:_trackingValue];
    [_contentView addSubview:_orderSummaryView];
    [_contentView addSubview:_itemsTable];
    
    [self addSubview:_contentView];
    
}



@end
