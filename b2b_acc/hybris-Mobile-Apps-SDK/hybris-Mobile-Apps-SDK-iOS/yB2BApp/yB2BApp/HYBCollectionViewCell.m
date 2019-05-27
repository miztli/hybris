//
// HYBCollectionViewCell.m
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

#import "HYBCollectionViewCell.h"
#import "UIColor+Expanded.h"
#import "stylesheet.h"

@implementation HYBCollectionViewCell

- (id)initWithFrame:(CGRect)frame {

    if (self = [super initWithFrame:frame]) {
        
        self.backgroundColor = catalog_grid_cell_background;
        
        CGFloat cellWidth = frame.size.width;
        CGFloat cellHeight = frame.size.height;
        CGFloat marge = cellWidth * .1;
        CGFloat imageBorder = frame.size.width - marge;
        CGFloat infoPanelHeight = cellHeight - imageBorder - marge / 2;

        //product image
        _productImageView = [[UIImageView alloc] initWithFrame:CGRectMake(marge, marge, imageBorder - marge * 2, imageBorder - marge * 2)];
        _productImageView.contentMode = UIViewContentModeScaleAspectFit;

        //info panel
        _productInfoPanel = [[UIImageView alloc] initWithFrame:CGRectMake(marge / 2, marge / 2 + imageBorder, imageBorder, infoPanelHeight)];
        _productInfoPanel.backgroundColor = catalog_grid_cell_background;

        //product name
        _productNameLabel = [[UILabel alloc] initWithFrame:CGRectMake(marge / 4, marge / 4, imageBorder - marge / 2, infoPanelHeight / 3)];
        _productNameLabel.font = font_small;
        _productNameLabel.text = @"product name";

        //product code
        _productCodeLabel = [[UILabel alloc] initWithFrame:CGRectMake(marge / 4, marge / 6 + infoPanelHeight / 3, imageBorder - marge / 2, infoPanelHeight / 3)];
        _productCodeLabel.font = font_light_extra_small;
        _productCodeLabel.text = @"product code";

        //product price
        _productPriceLabel = [[UILabel alloc] initWithFrame:CGRectMake(marge / 4, infoPanelHeight / 2 + marge / 4, imageBorder - marge / 2, infoPanelHeight / 3)];
        _productPriceLabel.font = font_light_small;
        _productPriceLabel.text = @"product price";
        _productPriceLabel.textAlignment = NSTextAlignmentRight;

        //pile up
        [self addSubview:_productImageView];
        [self addSubview:_productInfoPanel];

        [self.productInfoPanel addSubview:_productNameLabel];
        [self.productInfoPanel addSubview:_productCodeLabel];
        [self.productInfoPanel addSubview:_productPriceLabel];
    }

    return self;
}

@end
