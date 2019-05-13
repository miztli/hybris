//
// HYBCartItemCellView.m
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

#import "HYBCartItemCellView.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"

@implementation HYBCartItemCellView

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {

    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
        
        self.backgroundColor = cart_table_cell_background;
        
        _productDetailsTapArea       = [UIView new];
        
        _productImage                = [UIImageView new];
        _productImage.clipsToBounds = YES;
        _productImage.contentMode = UIViewContentModeScaleAspectFit;
        
        _productNameLabel            = [UILabel new];
        _productNameLabel.font  = cart_cell_product_name_font;
        
        _productPriceLabel           = [UILabel new];
        _productPriceLabel.font      = cart_cell_price_font;
        
        _productPromoLabel           = [UILabel new];
        _productPromoLabel.font      = cart_cell_promotion_font;
        _productPromoLabel.textColor = cart_cell_promotion_text;
        
        _itemsInputTextfield         = [UITextField new];
        
        _itemsInputTextfield.textAlignment = NSTextAlignmentRight;
        _itemsInputTextfield.keyboardType  = UIKeyboardTypeNumberPad;
        _itemsInputTextfield.borderStyle   = UITextBorderStyleRoundedRect;
        
        _totalPriceLabel      = [UILabel new];
        _totalPriceLabel.font = cart_cell_total_price_font;
        _totalPriceLabel.textAlignment = NSTextAlignmentRight;
        
        //pile up
        [self.contentView addSubview:_productDetailsTapArea];
        
        [self.contentView addSubview:_productImage];
        
        [self.contentView addSubview:_productNameLabel];
        [self.contentView addSubview:_productPriceLabel];
        [self.contentView addSubview:_productPromoLabel];
        
        [self.contentView addSubview:_itemsInputTextfield];
        
        [self.contentView addSubview:_totalPriceLabel];
    }
    
    return self;
}

- (UIEdgeInsets)layoutMargins {
    return UIEdgeInsetsZero;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat centerZoneWidth  = [self bW]/2.2;
    CGFloat centerZoneOrigin = [self bW]/5.6;
    CGFloat lineHeight       = 20.f;
    
    _productDetailsTapArea.frame = CGRectMake(0, 0, centerZoneWidth, [self bH]);

    _productImage.frame = CGRectMake(lineHeight, 2.5, lineHeight*3.5, lineHeight*3.5);
    
    _productNameLabel.frame = CGRectMake(centerZoneOrigin, 15, centerZoneWidth, lineHeight);
    
    _productPriceLabel.frame = CGRectMake(centerZoneOrigin, lineHeight*2, centerZoneWidth, lineHeight);
    
    _productPromoLabel.frame = CGRectMake(centerZoneOrigin, lineHeight*3.5, centerZoneWidth*2, lineHeight);
    
    _itemsInputTextfield.frame = CGRectMake([self bW]/7*5 - lineHeight*2.25, lineHeight, lineHeight*2.5, lineHeight*1.5);
    
    _totalPriceLabel.frame = CGRectMake([self bW]/7*5.25, lineHeight+5, 100, lineHeight);
}

- (void)loadWithItem:(HYBOrderEntry *)item withProductImage:(UIImage *)itemImage {
    
    _productCode                = item.product.code;
    _productNameLabel.text      = item.product.name;
    
    NSString *promoline = item.discountMessage;
    if (promoline) _productPromoLabel.text = promoline;
    else _productPromoLabel.text = @"";

    _productPriceLabel.text = item.basePrice.formattedValue;
    _totalPriceLabel.text   = item.totalPrice.formattedValue;
    
    _itemsInputTextfield.text = [item.quantity stringValue];
    _cartItemPosition = [item.entryNumber stringValue];

    if (itemImage) {
        _productImage.image = itemImage;
    }
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    if (selected && !self.isEditing ) return;

    [super setSelected:selected animated:animated];
    [self setNeedsDisplay];
}


- (void)setHighlighted:(BOOL)highlighted animated:(BOOL)animated {
    
    // Make an empty UIView with the boundaries of myself
    UIView *highlight = [[UIView alloc] initWithFrame:self.frame];
    
    // Set the background color
    highlight.backgroundColor = [UIColor clearColor];
    
    // Set the UIView as my backgroundview when selected
    self.selectedBackgroundView = highlight;
}

- (void)setEditing:(BOOL)editing animated:(BOOL)animated {
    [super setEditing:editing animated:animated];
}

@end
