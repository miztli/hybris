//
// HYBOrderConfirmationView.m
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

#import "HYBOrderConfirmationView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

@implementation HYBOrderConfirmationView

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
    
    _contentView.frame = CGRectMake([self bX],
                                    [self bY] + defaultTopMargin ,
                                    [self bW],
                                    [self bH] - defaultTopMargin);
    
    _continueShoppingButton.frame = CGRectMake(margin,
                                               margin,
                                               [_contentView bW] - margin*2,
                                               lineHeight*3);
    
    [_thanksLabel sizeToFit];
    _thanksLabel.center = CGPointMake([_thanksLabel bW]/2+ margin,
                                    [_continueShoppingButton bottom] + [_thanksLabel bH]/2+ lineHeight);
    
    [_orderNumberIntroLabel sizeToFit];
    _orderNumberIntroLabel.center = CGPointMake([_orderNumberIntroLabel bW]/2+ margin,
                                      [_thanksLabel bottom] + [_orderNumberIntroLabel bH]/2+ lineHeight);
    
    [_orderNumberLinkLabel sizeToFit];
    _orderNumberLinkLabel.center = CGPointMake([_orderNumberIntroLabel right] + [_orderNumberLinkLabel bW]/2 + 4.f,
                                      _orderNumberIntroLabel.center.y);
    
    [_emailDetailsLabel sizeToFit];
    _emailDetailsLabel.center = CGPointMake([_emailDetailsLabel bW]/2+ margin,
                                                [_orderNumberIntroLabel bottom] + [_emailDetailsLabel bH]/2+ lineHeight);
    
    [_deliveryAddressTitle sizeToFit];
    _deliveryAddressTitle.center = CGPointMake([_deliveryAddressTitle bW]/2+ margin,
                                            [_emailDetailsLabel bottom] + [_deliveryAddressTitle bH]/2+ lineHeight);
    
    
    [_deliveryAddressValue sizeToFit];
    _deliveryAddressValue.center = CGPointMake([_deliveryAddressValue bW]/2 + margin,
                                               [_deliveryAddressTitle bottom] + [_deliveryAddressValue bH]/2+ lineHeight);
    
    [_deliveryMethodTitle sizeToFit];
    _deliveryMethodTitle.center = CGPointMake([_contentView bW]/2 + [_deliveryMethodTitle bW]/2 + margin/2,
                                              _deliveryAddressTitle.center.y);
    
    
    [_deliveryMethodValue sizeToFit];
    _deliveryMethodValue.center = CGPointMake([_contentView bW]/2 + [_deliveryMethodValue bW]/2 + margin/2,
                                              [_deliveryMethodTitle bottom] + [_deliveryMethodValue bH]/2+ lineHeight);
        
    CGFloat max = MAX([_deliveryAddressValue bottom], [_deliveryMethodValue bottom]);
    
    _orderSummaryView.frame = CGRectMake(0,
                                         max + lineHeight*2,
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
    
    _contentView = [UIScrollView new];
    _contentView.backgroundColor = order_confirmation_background;
    
    //checkout button
    
    _continueShoppingButton = [HYBActionButton new];
    [_continueShoppingButton setTitle:NSLocalizedString(@"postcheckout_continue_shopping", nil) forState:UIControlStateNormal];
    [_continueShoppingButton setBackgroundColor:order_confirmation_continue_button_background forState:UIControlStateNormal];
    _continueShoppingButton.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_CONTINUE";
    
    //thanks label
    
    _thanksLabel = [UILabel new];
    _thanksLabel.text = NSLocalizedString(@"postcheckout_thansk_label", nil);
    _thanksLabel.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_THANK_YOU";
    _thanksLabel.textColor = order_confirmation_thanks;
    _thanksLabel.font = order_confirmation_font_thanks;
    
    //order number
    
    _orderNumberIntroLabel = [UILabel new];
    _orderNumberIntroLabel.text = NSLocalizedString(@"postcheckout_order_number_intro", nil);
    _orderNumberIntroLabel.textColor = order_confirmation_default;
    _orderNumberIntroLabel.font = order_confirmation_font_default;
    
    _orderNumberLinkLabel = [UILabel new];
    _orderNumberLinkLabel.text = NSLocalizedString(@"postcheckout_order_number_link", nil);
    _orderNumberLinkLabel.textColor = order_confirmation_link;
    _orderNumberLinkLabel.font = order_confirmation_font_default;
    
    //e-mail
    
    _emailDetailsLabel = [UILabel new];
    _emailDetailsLabel.textColor = order_confirmation_default;
    _emailDetailsLabel.font = order_confirmation_font_default;
    
    //delivery address
    
    _deliveryAddressTitle = [UILabel new];
    _deliveryAddressTitle.text = NSLocalizedString(@"deliveryAddress_label_title", nil);
    _deliveryAddressTitle.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_DELIVERY_ADDRESS_TITLE";
    _deliveryAddressTitle.textColor = order_confirmation_title;
    _deliveryAddressTitle.font = order_confirmation_font_title;
    
    _deliveryAddressValue = [UILabel new];
    _deliveryAddressValue.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_DELIVERY_ADDRESS";
    _deliveryAddressValue.numberOfLines = 0;
    _deliveryAddressValue.textColor = order_confirmation_default;
    _deliveryAddressValue.font = order_confirmation_font_default;
    
    //delivery method
    
    _deliveryMethodTitle = [UILabel new];
    _deliveryMethodTitle.text = NSLocalizedString(@"deliveryMethod_label_title", nil);
    _deliveryMethodTitle.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_DELIVERY_METHOD_TITLE";
    _deliveryMethodTitle.textColor = order_confirmation_title;
    _deliveryMethodTitle.font = order_confirmation_font_title;
    
    _deliveryMethodValue = [UILabel new];
    _deliveryMethodValue.accessibilityIdentifier = @"ACCESS_ORDER_CONFIRMATION_DELIVERY_METHOD";
    _deliveryMethodValue.numberOfLines = 0;
    _deliveryMethodValue.textColor = order_confirmation_default;
    _deliveryMethodValue.font = order_confirmation_font_default;
    
    //order summary
    _orderSummaryView = [HYBOrderSummaryView new];
    _orderSummaryView.backgroundColor = order_confirmation_summary_background;
    
    //products table
    _itemsTable = [UITableView new];
    _itemsTable.backgroundColor = order_confirmation_table_background;
    
    //pile up
    
    [_contentView addSubview:_continueShoppingButton];
    [_contentView addSubview:_thanksLabel];
    [_contentView addSubview:_orderNumberIntroLabel];
    [_contentView addSubview:_orderNumberLinkLabel];
    [_contentView addSubview:_emailDetailsLabel];
    [_contentView addSubview:_deliveryAddressTitle];
    [_contentView addSubview:_deliveryAddressValue];
    [_contentView addSubview:_deliveryMethodTitle];
    [_contentView addSubview:_deliveryMethodValue];
    [_contentView addSubview:_orderSummaryView];
    [_contentView addSubview:_itemsTable];
    
    [self addSubview:_contentView];
    
}



@end
