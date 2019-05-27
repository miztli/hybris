//
//  HYBAddressCellView.m
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

#import "HYBAddressCellView.h"
#import "stylesheet.h"
#import "UIView+Utilities.h"
#import "UIColor+Expanded.h"

@interface HYBAddressCellView ()

@property (nonatomic) UIImageView *selectImageView;
@property (nonatomic) UIImageView *chevronImageView;

@end

@implementation HYBAddressCellView

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {
    
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
        
        self.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        self.autoresizesSubviews = YES;
        
        _selectView = [UIView new];
        
        _selectImageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"star_03"]
                                             highlightedImage:[UIImage imageNamed:@"star_01"]];
        
        _selectImageView.clipsToBounds = YES;
        _selectImageView.contentMode = UIViewContentModeScaleAspectFit;
        _selectImageView.accessibilityIdentifier = @"ACCESS_ADDRESS_SELECT";
        
        _nameLabel                      = [UILabel new];
        _nameLabel.font                 = [UIFont fontWithName:@"HelveticaNeue" size:18.f];
        _nameLabel.textColor            = hybris_black;
        _nameLabel.textAlignment        = NSTextAlignmentLeft;
        _nameLabel.accessibilityIdentifier = @"ACCESS_ADDRESS_NAME";
        
        _firstLineLabel               = [UILabel new];
        _firstLineLabel.font          = [UIFont fontWithName:@"HelveticaNeue" size:14.f];
        _firstLineLabel.textColor     = hybris_black;
        _firstLineLabel.textAlignment = NSTextAlignmentLeft;
        _firstLineLabel.accessibilityIdentifier = @"ACCESS_ADDRESS_FIRST_LINE";
        
        _secondLineLabel                  = [UILabel new];
        _secondLineLabel.font             = [UIFont fontWithName:@"HelveticaNeue" size:16.f];
        _secondLineLabel.textColor        = hybris_black;
        _secondLineLabel.textAlignment    = NSTextAlignmentLeft;
        _secondLineLabel.accessibilityIdentifier = @"ACCESS_ADDRESS_SECOND_LINE";
             
        _chevronImageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"defaultChevron.png"]];
        _chevronImageView.clipsToBounds = YES;
        _chevronImageView.contentMode = UIViewContentModeScaleAspectFit;
        _chevronImageView.accessibilityIdentifier = @"ACCESS_ADDRESS_CHEVRON";
        
        _chevronView = [UIView new];
        
        //pile up
        
        [self.contentView addSubview:_selectView];
        [_selectView addSubview:_selectImageView];

        [self.contentView addSubview:_nameLabel];
        [self.contentView addSubview:_firstLineLabel];
        [self.contentView addSubview:_secondLineLabel];

        [self.contentView addSubview:_chevronView];
        [_chevronView addSubview:_chevronImageView];
        
    }
 
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    [_nameLabel         sizeToFit];
    [_firstLineLabel    sizeToFit];
    [_secondLineLabel   sizeToFit];
    
    CGFloat margin = 90.f;
    
    _nameLabel.center       = CGPointMake([_nameLabel bW]/2     + margin,   [self bH]/6 +15);
    _firstLineLabel.center  = CGPointMake([_firstLineLabel bW]/2+margin,    [self bH]/2);
    _secondLineLabel.center = CGPointMake([_secondLineLabel bW]/2+margin,   [self bH]/6*5 -15);
    
    _chevronView.frame = CGRectInset(_chevronImageView.frame, -30, -30);
    _selectView.frame  = CGRectInset(_selectImageView.frame, -20, -30);
    
    _chevronView.center = CGPointMake( [self bW] - [_chevronView bW] , _firstLineLabel.center.y);
    _chevronImageView.center = CGPointMake( [_chevronView bW]/2, [_chevronView bH]/2);
        
    _selectView.center = CGPointMake( [_selectView bW]/2, _firstLineLabel.center.y);
    _selectImageView.center = CGPointMake( [_selectView bW]/2, [_selectView bH]/2);
}

- (UIEdgeInsets)layoutMargins {
    return UIEdgeInsetsZero;
}

- (void)doHilite:(BOOL)hilite {
    _selectImageView.highlighted = hilite;
    if (hilite) {
        self.contentView.backgroundColor = hybris_light_gray;
    } else {
         self.contentView.backgroundColor = hybris_white;
    }
}


@end
