//
// HYBListViewCell.h
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
#import <UIKit/UIKit.h>

@interface HYBListViewCell : UITableViewCell

@property(nonatomic,strong)  UILabel      *productNameLabel;
@property(nonatomic,strong)  UILabel      *productCodeLabel;
@property(nonatomic,strong)  UILabel      *priceLabel;
@property(nonatomic,strong)  UILabel      *stockLabel;
@property(nonatomic,strong)  UILabel      *totalItemPrice;
@property(nonatomic,strong)  UIImageView  *productIcon;
@property(nonatomic,strong)  UITextField  *quantityInputField;
@property(nonatomic,strong)  UIButton     *addToCartButton;
@property(nonatomic,strong)  UIView       *tapArea;
@end