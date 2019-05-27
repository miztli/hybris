//
// HYBCartView.m
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

#import "HYBCartView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"


@implementation HYBCartView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.05;
    CGFloat lineHeight = 40.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 30.f;
    }
    
    //content frame
    _contentView.frame = CGRectMake([self bX], [self bY] + defaultTopMargin , [self bW], [self bH] - defaultTopMargin);
    
    //buttons
    _continueShoppingButton.frame = CGRectMake(0, 0, [self bW]/2, lineHeight*2);
    _continueShoppingButton.center  = CGPointMake([_contentView bW]/4,
                                                  [_continueShoppingButton bH]/2);
    
    _checkoutButton.frame =  CGRectMake(0, 0, [self bW]/2, lineHeight*2);
    _checkoutButton.center          = CGPointMake([_contentView bW]/4*3,
                                                  [_checkoutButton bH]/2);
    
    //title
    [_titleLabel sizeToFit];
    _titleLabel.center = CGPointMake([_titleLabel bW]/2 + margin,
                                     [_continueShoppingButton bottom] + lineHeight);
    
    //right labels
    [_subtotalTitleLabel sizeToFit];
    _subtotalTitleLabel.center = CGPointMake([_subtotalTitleLabel bW]/2 + margin,
                                             [_titleLabel bottom] + lineHeight);
    
    [_savingsLabel sizeToFit];
    _savingsLabel.center = CGPointMake([_savingsLabel bW]/2 + margin,
                                       [_subtotalTitleLabel bottom] + lineHeight/2);
    
    [_taxTitleLabel sizeToFit];
    _taxTitleLabel.center = CGPointMake([_taxTitleLabel bW]/2 + margin,
                                        [_savingsLabel bottom] + lineHeight/2);
    
    [_shippingLabel sizeToFit];
    _shippingLabel.center = CGPointMake([_shippingLabel bW]/2 + margin,
                                        [_taxTitleLabel bottom] + lineHeight/2);
    
    [_cartTotalTitleLabel sizeToFit];
    _cartTotalTitleLabel.center = CGPointMake([_cartTotalTitleLabel bW]/2 + margin,
                                              [_shippingLabel bottom] + lineHeight/2);
    
    
    //left labels
    [_subTotalNumber sizeToFit];
    _subTotalNumber.center = CGPointMake([_contentView bW] - [_subTotalNumber bW]/2 - margin,
                                         _subtotalTitleLabel.center.y);
    
    [_savingsNumber sizeToFit];
    _savingsNumber.center = CGPointMake([_contentView bW] - [_savingsNumber bW]/2 - margin,
                                        _savingsLabel.center.y);
    
    [_taxNumber sizeToFit];
    _taxNumber.center = CGPointMake([_contentView bW] - [_taxNumber bW]/2 - margin,
                                    _taxTitleLabel.center.y);
    
    [_shippingNumber sizeToFit];
    _shippingNumber.center = CGPointMake([_contentView bW] - [_shippingNumber bW]/2 - margin,
                                         _shippingLabel.center.y);
    
    [_cartTotalNumber sizeToFit];
    _cartTotalNumber.center = CGPointMake([_contentView bW] - [_cartTotalNumber bW]/2 - margin,
                                          _cartTotalTitleLabel.center.y);
    
    //discount line
    
    [_discountsMessage sizeToFit];
    _discountsMessage.center = CGPointMake([_contentView bW] - [_discountsMessage bW]/2 - margin,
                                           [_cartTotalNumber bottom] + lineHeight/2);
    
    //table area
    
    //header
    _tableHeaderView.frame = CGRectMake(0, [_discountsMessage bottom] + lineHeight/2, [_contentView bW], lineHeight);
    
    [_headerItemsLabel sizeToFit];
    _headerItemsLabel.center = CGPointMake([_headerItemsLabel bW]/2 + margin,
                                           [_tableHeaderView bH]/2);
    
    [_headerQtyLabel sizeToFit];
    _headerQtyLabel.center = CGPointMake( [_tableHeaderView bW]/7*5 - [_headerQtyLabel bW]/2,
                                         [_tableHeaderView bH]/2);
    
    [_headerTotalLabel sizeToFit];
    _headerTotalLabel.center = CGPointMake([_tableHeaderView bW]- [_headerTotalLabel bW]/2 - margin*1.5,
                                           [_tableHeaderView bH]/2);
    
    //actions
    _tableActionView.frame = CGRectMake(0, [_tableHeaderView bottom], [_contentView bW], lineHeight);
    
    
    _batchToggleButton.frame    = CGRectMake(0, 0, [self bW]/4, [_tableActionView bH]);
    _batchToggleButton.center   = CGPointMake([_tableActionView bW] - [_batchToggleButton bW]/2,
                                              [_tableActionView bH]/2);
    
    //footer
    _tableFooterView.frame = CGRectMake(0, [_contentView bH]-lineHeight, [_contentView bW], lineHeight);
    _tableFooterView.hidden = YES;
    
    _batchSelectButton.frame    = CGRectMake(0, 0, [self bW]/4,  [_tableFooterView bH]);
    _batchSelectButton.center   = CGPointMake([_batchSelectButton bW]/2,
                                              [_tableFooterView bH]/2);

    
    _batchDeleteButton.frame    = CGRectMake(0, 0, [self bW]/4,  [_tableFooterView bH]);
    _batchDeleteButton.center   = CGPointMake([_tableFooterView bW] - [_batchDeleteButton bW]/2,
                                              [_tableFooterView bH]/2);
    
    //table
    _itemsTable.frame = CGRectMake(0, [_tableActionView bottom], [_contentView bW], [_contentView bH] - [_tableActionView bottom] - [_tableFooterView bH]);

}

- (void)setup {
    
    //content view
    _contentView = [UIView new];
    _contentView.backgroundColor = cart_background;
    
    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    //top buttons
    
    //continue shopping
    _continueShoppingButton = [HYBActionButton new];
    [_continueShoppingButton setTitle:NSLocalizedString(@"cart_button_continueshopping", nil) forState:UIControlStateNormal];
    _continueShoppingButton.accessibilityIdentifier = @"ACCESS_CART_BUTTON_CONTINUE_SHOP";
    [_continueShoppingButton setBackgroundColor:hybris_gray forState:UIControlStateNormal];
    
    //checkout button
    _checkoutButton = [HYBActionButton new];
    [_checkoutButton setTitle:NSLocalizedString(@"cart_button_checkout", nil) forState:UIControlStateNormal];
    _checkoutButton.accessibilityIdentifier = @"ACCESS_CART_BUTTON_CHECKOUT";
    _checkoutButton.enabled = NO;
    
    //title Label
    _titleLabel = [UILabel new];
    _titleLabel.text = NSLocalizedString(@"cart_label_title", nil);
    _titleLabel.font = font_title;
    _titleLabel.textColor = cart_title;
    _titleLabel.accessibilityIdentifier = @"ACCESS_CART_TITLE";
    
    // left side labels
    
    _subtotalTitleLabel = [UILabel new];
    _subtotalTitleLabel.text = NSLocalizedString(@"Subtotal:",nil);
    _subtotalTitleLabel.font = font_medium;
    _subtotalTitleLabel.textColor = cart_default_label;
    _subtotalTitleLabel.accessibilityIdentifier = @"ACCESS_CART_SUBTOTAL_TITLE";
    
    _savingsLabel = [UILabel new];
    _savingsLabel.text = NSLocalizedString(@"Savings:",nil);
    _savingsLabel.font = font_medium;
    _savingsLabel.textColor = cart_savings_label;
    _savingsLabel.accessibilityIdentifier = @"ACCESS_CART_SAVINGS_TITLE";
    
    _taxTitleLabel = [UILabel new];
    _taxTitleLabel.text = NSLocalizedString(@"Tax:",nil);
    _taxTitleLabel.font = font_medium;
    _taxTitleLabel.textColor = cart_default_label;
    _taxTitleLabel.accessibilityIdentifier = @"ACCESS_CART_TAX_TITLE";
    
    _shippingLabel = [UILabel new];
    _shippingLabel.text = NSLocalizedString(@"Shipping:",nil);
    _shippingLabel.font = font_medium;
    _shippingLabel.textColor = cart_default_label;
    _shippingLabel.accessibilityIdentifier = @"ACCESS_CART_SHIPPING_TITLE";
    
    _cartTotalTitleLabel = [UILabel new];
    _cartTotalTitleLabel.font = font_medium_bold;
    _cartTotalTitleLabel.textColor = cart_default_label;
    _cartTotalTitleLabel.text = NSLocalizedString(@"cart_label_total",nil);
    _cartTotalTitleLabel.accessibilityIdentifier = @"ACCESS_CART_TOTAL_TITLE";
    
    
    // right side labels
    
    _subTotalNumber = [UILabel new];
    _subTotalNumber.font = font_medium;
    _subTotalNumber.textColor = cart_default_label;
    _subTotalNumber.accessibilityIdentifier = @"ACCESS_CART_SUBTOTAL_AMT";
    _subTotalNumber.textAlignment = NSTextAlignmentRight;
    
    _savingsNumber = [UILabel new];
    _savingsNumber.font = font_medium;
    _savingsNumber.textColor = cart_savings_label;
    _savingsNumber.accessibilityIdentifier = @"ACCESS_CART_SAVINGS_AMT";
    _savingsNumber.textAlignment = NSTextAlignmentRight;
    
    _taxNumber = [UILabel new];
    _taxNumber.font = font_medium;
    _taxNumber.textColor = cart_default_label;
    _taxNumber.accessibilityIdentifier = @"ACCESS_CART_TAX_AMT";
    _taxNumber.textAlignment = NSTextAlignmentRight;
    
    _shippingNumber = [UILabel new];
    _shippingNumber.font = font_medium;
    _shippingNumber.textColor = cart_default_label;
    _shippingNumber.accessibilityIdentifier = @"ACCESS_CART_SHIPPING_AMT";
    _shippingNumber.textAlignment = NSTextAlignmentRight;
    
    _cartTotalNumber = [UILabel new];
    _cartTotalNumber.font = font_medium_bold;
    _cartTotalNumber.textColor = cart_default_label;
    _cartTotalNumber.accessibilityIdentifier = @"ACCESS_CART_TOTAL_AMT";
    _cartTotalNumber.textAlignment = NSTextAlignmentRight;
    
    //summary bottom
    _discountsMessage = [UILabel new];
    _discountsMessage.font = font_small_italic;
    _discountsMessage.textColor = cart_savings_label;
    _discountsMessage.accessibilityIdentifier = @"ACCESS_CART_DISCOUNT_RECAP";
    
    //table area
    
    //table header
    _tableHeaderView = [UIView new];
    _tableHeaderView.backgroundColor = cart_table_header_background;
    
    _headerItemsLabel = [UILabel new];
    _headerItemsLabel.font = font_medium;
    _headerItemsLabel.textColor = cart_default_label;
    _headerItemsLabel.text = NSLocalizedString(@"ITEMS", nil);
    _headerItemsLabel.accessibilityIdentifier = @"ACCESS_CART_HEADER_ITEMS_TITLE";

    _headerQtyLabel = [UILabel new];
    _headerQtyLabel.font = font_medium;
    _headerQtyLabel.textColor = cart_default_label;
    _headerQtyLabel.text = NSLocalizedString(@"QTY", nil);
    _headerQtyLabel.accessibilityIdentifier = @"ACCESS_CART_HEADER_QTY_TITLE";
    
    _headerTotalLabel = [UILabel new];
    _headerTotalLabel.font = font_medium;
    _headerTotalLabel.textColor = cart_default_label;
    _headerTotalLabel.text = NSLocalizedString(@"TOTAL", nil);
    _headerTotalLabel.accessibilityIdentifier = @"ACCESS_CART_HEADER_TOTAL_TITLE";
    
    //table action
    _tableActionView = [UIView new];
    _tableActionView.backgroundColor = cart_table_action_background;
    
    //batch toggle button
    _batchToggleButton = [HYBActionButton new];
    [_batchToggleButton setTitle:NSLocalizedString(@"batch_toggle_button_edit", nil) forState:UIControlStateNormal];
    _batchToggleButton.accessibilityIdentifier = @"ACCESS_CART_BUTTON_BATCH_REMOVE";
    
    //table
    _itemsTable = [UITableView new];
    _itemsTable.backgroundColor = cart_table_background;
    
    //table footer
    _tableFooterView = [UIView new];
    _tableFooterView.backgroundColor = cart_table_footer_background;
    
    //select button
    _batchSelectButton = [HYBActionButton new];
    [_batchSelectButton setTitle:NSLocalizedString(@"batch_select_all_button", nil) forState:UIControlStateNormal];
    _batchSelectButton.accessibilityIdentifier = @"ACCESS_CART_BUTTON_BATCH_SELECT_ALL";
   
    //delete button
    _batchDeleteButton = [HYBActionButton new];
    [_batchDeleteButton setTitle:NSLocalizedString(@"batch_delete_button", nil) forState:UIControlStateNormal];
    _batchDeleteButton.accessibilityIdentifier = @"ACCESS_CART_BUTTON_BATCH_DELETE";
    
    
    //pile up
    [_contentView addSubview:_continueShoppingButton];
    [_contentView addSubview:_checkoutButton];
    
    [_contentView addSubview:_titleLabel];
    
    [_contentView addSubview:_subTotalNumber];
    [_contentView addSubview:_savingsNumber];
    [_contentView addSubview:_taxTitleLabel];
    [_contentView addSubview:_shippingLabel];
    [_contentView addSubview:_cartTotalTitleLabel];    
    
    [_contentView addSubview:_subtotalTitleLabel];
    [_contentView addSubview:_savingsLabel];
    [_contentView addSubview:_taxNumber];
    [_contentView addSubview:_shippingNumber];
    [_contentView addSubview:_cartTotalNumber];
    
    [_contentView addSubview:_discountsMessage];
    
    [_contentView addSubview:_tableHeaderView];
    [_tableHeaderView addSubview:_headerItemsLabel];
    [_tableHeaderView addSubview:_headerQtyLabel];
    [_tableHeaderView addSubview:_headerTotalLabel];
    
    [_contentView addSubview:_tableActionView];
    [_tableActionView addSubview:_batchToggleButton];
    
    [_contentView addSubview:_itemsTable];
    
    [_tableFooterView addSubview:_batchSelectButton];
    [_tableFooterView addSubview:_batchDeleteButton];
    [_contentView addSubview:_tableFooterView];
    
    [self addSubview:_contentView];
}

- (void)setCartToEmpty {
    
    _titleLabel.textAlignment = NSTextAlignmentCenter;
    _titleLabel.text = NSLocalizedString(@"cart_label_your_cart_is_empty", nil);
    _checkoutButton.enabled = NO;
    _tableActionView.hidden = YES;
    _tableHeaderView.hidden = YES;
    _tableFooterView.hidden = YES;
    _itemsTable.hidden = YES;
}

- (void)setCartToNotEmpty {
    
    _titleLabel.textAlignment = NSTextAlignmentLeft;
    _titleLabel.text = NSLocalizedString(@"cart_label_title", nil);
    _checkoutButton.enabled = YES;
    _tableActionView.hidden = NO;
    _tableHeaderView.hidden = NO;
    _tableFooterView.hidden = NO;
    _itemsTable.hidden = NO;
}

-(void)hideCart:(BOOL)hide {
    
    _cartTotalTitleLabel.hidden = hide;
    
    _subtotalTitleLabel.hidden = hide;
    _subTotalNumber.hidden = hide;
    
    _savingsLabel.hidden = hide;
    _savingsNumber.hidden = hide;
    
    _taxTitleLabel.hidden = hide;
    _taxNumber.hidden = hide;
    
    _shippingLabel.hidden = hide;
    _shippingNumber.hidden = hide;
    
    _cartTotalTitleLabel.hidden = hide;
    _cartTotalNumber.hidden = hide;
    
    _discountsMessage.hidden = hide;
    
    
    [self layoutSubviews];
    
}


@end