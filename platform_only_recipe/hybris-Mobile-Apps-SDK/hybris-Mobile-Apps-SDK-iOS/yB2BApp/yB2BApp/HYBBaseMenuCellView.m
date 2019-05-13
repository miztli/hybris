//
//  HYBBaseMenuCellView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBBaseMenuCellView.h"
#import "UIView+Utilities.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

@interface HYBBaseMenuCellView ()

@property (nonatomic) UIImageView   *menuIconView;
@property (nonatomic) UILabel       *menuLabel;

@end

@implementation HYBBaseMenuCellView

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];
}

- (void)basicSetup {
    self.backgroundColor = menu_background_default;
}


//cell styling
- (void)setupWithParams:(NSDictionary*)params {
    [self basicSetup];
    
    self.accessibilityIdentifier = params[MENU_ACCESSID];
    
    //clean up
    if(_menuIconView) {
        [_menuIconView removeFromSuperview];
        _menuIconView = nil;
    }
    
    if(_menuLabel) {
        [_menuLabel removeFromSuperview];
        _menuLabel = nil;
    }
    
    //redraw
    //icon
    NSString *imageName = params[MENU_ICON];
    if (imageName) {
        _menuIconView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:imageName]];
        _menuIconView.contentMode = UIViewContentModeScaleAspectFit;
        [self addSubview:_menuIconView];
    }
    
    //text
    NSString *text = params[MENU_TITLE];
    if (text) {
        _menuLabel  = [UILabel new];
        _menuLabel.accessibilityIdentifier = @"ACCESS_CATALOG_MENU_TITLE";
        _menuLabel.text = text;
        _menuLabel.font = font_medium;
        _menuLabel.textColor = menu_text_default;
        [self addSubview:_menuLabel];
    }
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margeIdx = .2;
    CGFloat marge = [self fH]*margeIdx;
    
    //icon
    if (_menuIconView) {
        CGSize size     = _menuIconView.image.size;
        CGFloat ratio   = size.height/size.width;
        CGFloat imgH    = [self fH]-2*marge;
        CGFloat imgW    = imgH*ratio;
        
        _menuIconView.frame = CGRectMake(marge,marge, imgH ,imgW);
    }
    
    //text
    if(_menuLabel) {
        [_menuLabel sizeToFit];
        CGFloat labelOffset = 0;
        
        if (_menuIconView) {
            labelOffset = [_menuIconView right];
        } else if (self.imageView.image) {
            labelOffset = [self.imageView right];
        }
        
        _menuLabel.center = CGPointMake([_menuLabel bW]/2 + marge + labelOffset, [self bH]/2);
    }
}

@end
