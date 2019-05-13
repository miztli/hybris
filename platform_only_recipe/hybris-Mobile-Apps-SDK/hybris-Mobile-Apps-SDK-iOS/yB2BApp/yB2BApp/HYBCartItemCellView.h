//
// HYBCartItemCellView.h
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

#import <UIKit/UIKit.h>
#import "HYBB2BService.h"

/**
* Class representing the items in the cart on the UI level.
*/
@interface HYBCartItemCellView : UITableViewCell

@property(nonatomic,  strong)  UITextField  *itemsInputTextfield;
@property(nonatomic,  strong)  UIView       *productDetailsTapArea;
@property(nonatomic,  strong)  NSString     *cartItemPosition;
@property(nonatomic,  strong)  NSString     *productCode;
@property(nonatomic,  strong)  UILabel      *productNameLabel;
@property(nonatomic,  strong)  UILabel      *productPriceLabel;
@property(nonatomic,  strong)  UILabel      *productPromoLabel;
@property(nonatomic,  strong)  UILabel      *totalPriceLabel;
@property(nonatomic,  strong)  UIImageView  *productImage;

- (void)loadWithItem:(HYBOrderEntry *)item withProductImage:(UIImage *)itemImage;

@end
