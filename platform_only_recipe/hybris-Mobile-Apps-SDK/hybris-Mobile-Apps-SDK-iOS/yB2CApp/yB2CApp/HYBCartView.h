//
// HYBCartView.h
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

#import <Foundation/Foundation.h>
#import "UIView+Utilities.h"
#import "HYBActionButton.h"

@interface HYBCartView : UIView

@property(nonatomic) UIView     *contentView;

@property(nonatomic) HYBActionButton *checkoutButton;
@property(nonatomic) HYBActionButton *continueShoppingButton;


@property(nonatomic) UILabel    *titleLabel;

@property(nonatomic) UILabel    *subtotalTitleLabel;
@property(nonatomic) UILabel    *subTotalNumber;

@property(nonatomic) UILabel    *savingsLabel;
@property(nonatomic) UILabel    *savingsNumber;

@property(nonatomic) UILabel    *taxTitleLabel;
@property(nonatomic) UILabel    *taxNumber;

@property(nonatomic) UILabel    *shippingLabel;
@property(nonatomic) UILabel    *shippingNumber;

@property(nonatomic) UILabel    *cartTotalTitleLabel;
@property(nonatomic) UILabel    *cartTotalNumber;

@property(nonatomic) UILabel    *discountsMessage;

@property(nonatomic) UIView     *tableHeaderView;
@property(nonatomic) UILabel    *headerItemsLabel;
@property(nonatomic) UILabel    *headerQtyLabel;
@property(nonatomic) UILabel    *headerTotalLabel;

@property(nonatomic) UIView     *tableActionView;
@property(nonatomic) HYBActionButton  *batchToggleButton;

@property(nonatomic) UITableView    *itemsTable;

@property(nonatomic) UIView     *tableFooterView;

@property(nonatomic) HYBActionButton  *batchSelectButton;
@property(nonatomic) HYBActionButton  *batchDeleteButton;

- (void)setCartToEmpty;
- (void)setCartToNotEmpty;

- (void)hideCart:(BOOL)hide;

@end