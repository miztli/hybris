//
// HYBListViewCell.m
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

#import "HYBListViewCell.h"
#import "stylesheet.h"
#import "UIView+Utilities.h"
#import "UIColor+Expanded.h"

@interface HYBListViewCell ()

@property (nonatomic) UIView *bottomBorder;

@end

@implementation HYBListViewCell

CGFloat marge = 10.f;

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {

    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {

        self.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        self.autoresizesSubviews = YES;
        
        _tapArea = [UIView new];
        _productIcon = [UIImageView new];
        _productNameLabel = [UILabel new];
        _productNameLabel.font = [UIFont fontWithName:@"HelveticaNeue" size:18.f];

        _productCodeLabel = [UILabel new];
        _productCodeLabel.font = [UIFont fontWithName:@"HelveticaNeue" size:14.f];

        _priceLabel = [UILabel new];
        _priceLabel.font = [UIFont fontWithName:@"HelveticaNeue" size:18.f];

        _stockLabel = [UILabel new];
        _stockLabel.textAlignment = NSTextAlignmentRight;
        _stockLabel.font = [UIFont fontWithName:@"HelveticaNeue" size:14.f];

        _quantityInputField = [[UITextField alloc] initWithFrame:CGRectMake(0, 0, 80, 30)];
        _quantityInputField.borderStyle = UITextBorderStyleLine;
        _quantityInputField.textAlignment = NSTextAlignmentCenter;
        _quantityInputField.keyboardType = UIKeyboardTypeNumberPad;
        _quantityInputField.spellCheckingType = UITextSpellCheckingTypeNo;
        _quantityInputField.autocorrectionType = UITextAutocorrectionTypeNo;

        _totalItemPrice = [UILabel new];
        _totalItemPrice.font = [UIFont fontWithName:@"HelveticaNeue" size:18.f];

        _addToCartButton = [[UIButton alloc] initWithFrame:CGRectMake(0, 0, 50, 50)];
        [_addToCartButton setImage:[UIImage imageNamed:@"cart_icon_blueplus.png"] forState:UIControlStateNormal];

        _bottomBorder = [[UIView alloc] initWithFrame:CGRectMake(0, [self bH]-1, [self bW], 1)];
        _bottomBorder.backgroundColor = catalog_table_separator;
        
        //pile up
        [_tapArea addSubview:_productIcon];

        [_tapArea addSubview:_productNameLabel];
        [_tapArea addSubview:_productCodeLabel];
        [_tapArea addSubview:_priceLabel];

        [self addSubview:_tapArea];
        [self addSubview:_stockLabel];
        [self addSubview:_quantityInputField];
        [self addSubview:_totalItemPrice];

        [self addSubview:_addToCartButton];
        
        [self addSubview:_bottomBorder];

    }

    return self;
}

- (void)layoutSubviews {
    CGFloat productIconSide = self.bounds.size.height - marge * 2;

    _tapArea.frame = CGRectMake(0, 0, self.bounds.size.width / 3 * 2, self.bounds.size.height);
    _productIcon.frame = CGRectMake(marge * 2, marge, productIconSide, productIconSide);

    CGFloat labelOrigin = _productIcon.frame.size.width + marge * 4;
    CGFloat labelLength = _tapArea.frame.size.width - labelOrigin;

    _productNameLabel.frame = CGRectMake(labelOrigin, marge * 1.5, labelLength, marge * 2);
    _productCodeLabel.frame = CGRectMake(labelOrigin, self.bounds.size.height / 2 - marge, labelLength, marge * 2);
    _priceLabel.frame = CGRectMake(labelOrigin, self.bounds.size.height - marge * 3.5, labelLength, marge * 2);

    [_stockLabel sizeToFit];
    _stockLabel.center = CGPointMake(_tapArea.frame.size.width - _stockLabel.bounds.size.width / 2, self.bounds.size.height / 2);

    _quantityInputField.center = CGPointMake(_tapArea.bounds.size.width + _quantityInputField.bounds.size.width / 2 + marge, self.bounds.size.height / 2);

    [_totalItemPrice sizeToFit];
    _totalItemPrice.center = CGPointMake(_quantityInputField.bounds.size.width + _quantityInputField.frame.origin.x + marge + _totalItemPrice.bounds.size.width / 2, self.bounds.size.height / 2);

    _addToCartButton.center = CGPointMake(self.bounds.size.width - _addToCartButton.bounds.size.width / 2 - marge * 2, self.bounds.size.height / 2);

     _bottomBorder.frame = CGRectMake(0, [self bH]-1, [self bW], 1);
}

- (UIEdgeInsets)layoutMargins {
    return UIEdgeInsetsZero;
}

@end