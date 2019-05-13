//
// HYBCollectionViewCell.h
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

@interface HYBCollectionViewCell : UICollectionViewCell

@property(nonatomic, strong) UIImageView *productImageView;
@property(nonatomic, strong) UIView      *productInfoPanel;
@property(nonatomic, strong) UILabel     *productNameLabel;
@property(nonatomic, strong) UILabel     *productCodeLabel;
@property(nonatomic, strong) UILabel     *productPriceLabel;

@end
