//
// HYBOrderSummaryView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//

#import "HYBOrderSummaryView.h"

#import "stylesheet.h"
#import "UIColor+Expanded.h"

@implementation HYBOrderSummaryView

- (id)init {
    if(self = [super init]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.025;
    CGFloat lineHeight = 10.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 8.f;
    }

    //left
    
    _summaryPanel.frame = CGRectMake(margin,
                                     margin,
                                     [self bW]/5*2-margin*2,
                                     lineHeight);
    
    [_title sizeToFit];
    _title.center = CGPointMake([_title bW]/2 + margin,
                                [_title bH]/2 + margin);
    
    [_itemCount sizeToFit];
    _itemCount.center = CGPointMake([_itemCount bW]/2 + margin,
                                   [_title bottom] + [_itemCount bH]/2 + lineHeight);
    
    
    //right
    
    _detailsPanel.frame = CGRectMake([_summaryPanel right]+margin*2,
                                     margin,
                                     [self bW]/5*3-margin*2,
                                     lineHeight);
    
    [_subtotalTitle sizeToFit];
    _subtotalTitle.center = CGPointMake([_subtotalTitle bW]/2 + margin,
                                [_subtotalTitle bH]/2 + margin);
    
    [_subtotalValue sizeToFit];
    _subtotalValue.center = CGPointMake([_detailsPanel bW] - [_subtotalValue bW]/2 - margin,
                                    _subtotalTitle.center.y);
    
    [_savingsTitle sizeToFit];
    _savingsTitle.center = CGPointMake([_savingsTitle bW]/2 + margin,
                                       [_subtotalTitle bottom] + [_savingsTitle bH]/2 + lineHeight);
    
    [_savingsValue sizeToFit];
    _savingsValue.center = CGPointMake([_detailsPanel bW] - [_savingsValue bW]/2 - margin,
                                        _savingsTitle.center.y);
    
    [_taxTitle sizeToFit];
    _taxTitle.center = CGPointMake([_taxTitle bW]/2 + margin,
                                       [_savingsTitle bottom] + [_taxTitle bH]/2 + lineHeight);
    
    [_taxValue sizeToFit];
    _taxValue.center = CGPointMake([_detailsPanel bW] - [_taxValue bW]/2 - margin,
                                       _taxTitle.center.y);
    
    [_shippingTitle sizeToFit];
    _shippingTitle.center = CGPointMake([_shippingTitle bW]/2 + margin,
                                   [_taxTitle bottom] + [_shippingTitle bH]/2 + lineHeight);
    
    [_shippingValue sizeToFit];
    _shippingValue.center = CGPointMake([_detailsPanel bW] - [_shippingValue bW]/2 - margin,
                                   _shippingTitle.center.y);
    
    [_orderTotalTitle sizeToFit];
    _orderTotalTitle.center = CGPointMake([_orderTotalTitle bW]/2 + margin,
                                        [_shippingTitle bottom] + [_orderTotalTitle bH]/2 + lineHeight);
    
    [_orderTotalValue sizeToFit];
    _orderTotalValue.center = CGPointMake([_detailsPanel bW] - [_orderTotalValue bW]/2 - margin,
                                        _orderTotalTitle.center.y);
    
    [_savingsRecapTitle sizeToFit];
    _savingsRecapTitle.center = CGPointMake([_detailsPanel bW] - [_savingsRecapTitle bW]/2 - margin,
                                          [_orderTotalTitle bottom] + [_savingsRecapTitle bH]/2 + lineHeight);
    
    
    //resize containers
    
    _summaryPanel.frame = CGRectMake(margin,
                                     margin,
                                     [self bW]/5*2-margin*2,
                                     [_itemCount bottom] + lineHeight);

    
    _detailsPanel.frame = CGRectMake([_summaryPanel right]+margin*2,
                                     margin,
                                     [self bW]/5*3-margin*2,
                                     [_savingsRecapTitle bottom] + lineHeight);
    
    self.frame = CGRectMake([self fX],
                            [self fY],
                            [self bW],
                            [_detailsPanel bottom] + lineHeight + margin);
    
}

- (void)hideSavings:(BOOL)hidden {
    _savingsRecapTitle.hidden = hidden;
    _savingsTitle.hidden = hidden;
    _savingsValue.hidden = hidden;
}

- (void)setup {
    
    //left or top panel
    _summaryPanel = [UIView new];
    
    _title = [UILabel new];
    _title.text = NSLocalizedString(@"order_summary", nil);
    _title.font = order_summary_font_title;
    _title.textColor = order_summary_title;
    
    _itemCount = [UILabel new];
    _itemCount.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_ITEM_COUNT";
    _itemCount.font = order_summary_font_count;
    _itemCount.textColor = order_summary_count;

    //right or bottom panel
    _detailsPanel = [UIView new];

    _subtotalTitle = [UILabel new];
    _subtotalTitle.text = NSLocalizedString(@"order_summary_subtotal", nil);
    _subtotalTitle.font = order_summary_font_default;
    _subtotalTitle.textColor = order_summary_default;

    _subtotalValue = [UILabel new];
    _subtotalValue.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_SUBTOTAL";
    _subtotalValue.font = order_summary_font_default;
    _subtotalValue.textColor = order_summary_default;

    _savingsTitle = [UILabel new];
    _savingsTitle.text = NSLocalizedString(@"order_summary_savings", nil);
    _savingsTitle.font = order_summary_font_default;
    _savingsTitle.textColor = order_summary_savings;
    
    _savingsValue = [UILabel new];
    _savingsValue.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_SAVINGS";
    _savingsValue.font = order_summary_font_default;
    _savingsValue.textColor = order_summary_savings;

    _taxTitle = [UILabel new];
    _taxTitle.text = NSLocalizedString(@"order_summary_tax", nil);
    _taxTitle.font = order_summary_font_default;
    _taxTitle.textColor = order_summary_default;
    
    _taxValue = [UILabel new];
    _taxValue.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_TAX";
    _taxValue.font = order_summary_font_default;
    _taxValue.textColor = order_summary_default;

    _shippingTitle = [UILabel new];
    _shippingTitle.text = NSLocalizedString(@"order_summary_shipping", nil);
    _shippingTitle.font = order_summary_font_default;
    _shippingTitle.textColor = order_summary_default;
    
    _shippingValue = [UILabel new];
    _shippingValue.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_SHIPPING";
    _shippingValue.font = order_summary_font_default;
    _shippingValue.textColor = order_summary_total;
   
    _orderTotalTitle = [UILabel new];
    _orderTotalTitle.text = NSLocalizedString(@"order_summary_total", nil);
    _orderTotalTitle.font = order_summary_font_total;
    _orderTotalTitle.textColor = order_summary_total;
    
    _orderTotalValue = [UILabel new];
    _orderTotalValue.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_TOTAL";
    _orderTotalValue.font = order_summary_font_total;
    _orderTotalValue.textColor = order_summary_default;
 
    _savingsRecapTitle = [UILabel new];
    _savingsRecapTitle.accessibilityIdentifier = @"ACCESS_CHECKOUT_ORDER_SUMMARY_SAVINGS_RECAP";
    _savingsRecapTitle.font = order_summary_font_savings_recap;
    _savingsRecapTitle.textColor = order_summary_savings;

    
    //pile up
    
    [_summaryPanel addSubview:_title];
    [_summaryPanel addSubview:_itemCount];
    
    [self addSubview:_summaryPanel];
    
    [_detailsPanel addSubview:_subtotalTitle];
    [_detailsPanel addSubview:_subtotalValue];
    
    [_detailsPanel addSubview:_savingsTitle];
    [_detailsPanel addSubview:_savingsValue];
    
    [_detailsPanel addSubview:_taxTitle];
    [_detailsPanel addSubview:_taxValue];
    
    [_detailsPanel addSubview:_shippingTitle];
    [_detailsPanel addSubview:_shippingValue];
    
    [_detailsPanel addSubview:_orderTotalTitle];
    [_detailsPanel addSubview:_orderTotalValue];
    
    [_detailsPanel addSubview:_savingsRecapTitle];
    
    [self addSubview:_detailsPanel];
   
}


@end
