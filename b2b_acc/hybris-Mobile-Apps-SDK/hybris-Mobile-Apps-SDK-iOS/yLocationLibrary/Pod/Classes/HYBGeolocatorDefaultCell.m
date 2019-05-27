//
//  HYBGeolocatorDefaultCell.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorDefaultCell.h"

@interface HYBGeolocatorDefaultCell ()

@property (nonatomic) UIImageView *chevronImageView;


@end

@implementation HYBGeolocatorDefaultCell

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {
    
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
               
        _indexLabel                     = [UILabel new];
        _indexLabel.font                = [UIFont fontWithName:@"HelveticaNeue" size:18.f];
        _indexLabel.textColor           = [UIColor blackColor];
        _indexLabel.textAlignment       = NSTextAlignmentLeft;
        _indexLabel.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_STORE_NUMBER";
        
        _nameLabel                      = [UILabel new];
        _nameLabel.font                 = [UIFont fontWithName:@"HelveticaNeue" size:18.f];
        _nameLabel.textColor            = [UIColor blackColor];
        _nameLabel.textAlignment        = NSTextAlignmentLeft;
        _nameLabel.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_STORE_NAME";
        
        _descriptionLabel               = [UILabel new];
        _descriptionLabel.font          = [UIFont fontWithName:@"HelveticaNeue" size:14.f];
        _descriptionLabel.textColor     = [UIColor blackColor];
        _descriptionLabel.textAlignment = NSTextAlignmentLeft;
        _descriptionLabel.lineBreakMode = NSLineBreakByWordWrapping;
        _descriptionLabel.numberOfLines = 0;
        _descriptionLabel.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_STORE_DESC";
        
        _distanceLabel                  = [UILabel new];
        _distanceLabel.font             = [UIFont fontWithName:@"HelveticaNeue" size:16.f];
        _distanceLabel.textColor        = [UIColor blackColor];
        _distanceLabel.textAlignment    = NSTextAlignmentRight;
        _distanceLabel.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_STORE_DISTANCE";
        
        NSString *bundlePath = [[NSBundle mainBundle] pathForResource:@"yLocationLibrary" ofType:@"bundle"];
        NSBundle *bundle = [NSBundle bundleWithPath:bundlePath];
        UIImage *image = [UIImage imageWithContentsOfFile:[bundle pathForResource:@"defaultChevron" ofType:@"png"]];
        
        _chevronImageView = [[UIImageView alloc] initWithImage:image];
        _chevronImageView.clipsToBounds = YES;
        _chevronImageView.contentMode = UIViewContentModeScaleAspectFit;
        _chevronImageView.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_STORE_CHEVRON    ";
        
        _chevronView = [UIView new];
        
        //pile up
        [self.contentView addSubview:_indexLabel];
        [self.contentView addSubview:_nameLabel];
        [self.contentView addSubview:_descriptionLabel];
        [self.contentView addSubview:_distanceLabel];
        [self.contentView addSubview:_chevronView];
        [_chevronView addSubview:_chevronImageView];
        
    }
    return self;
    
}

- (UIEdgeInsets)layoutMargins {
    return UIEdgeInsetsZero;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat padding = 20.f;
    
    [_indexLabel sizeToFit];
    _indexLabel.center = CGPointMake(_indexLabel.bounds.size.width/2 + padding*1.5, _indexLabel.bounds.size.height/2 + padding);
    
    [_nameLabel sizeToFit];
    _nameLabel.center = CGPointMake(_indexLabel.frame.origin.x + _indexLabel.frame.size.width + padding/2 + _nameLabel.bounds.size.width/2, _indexLabel.center.y);
    
    _descriptionLabel.frame = CGRectMake(_nameLabel.frame.origin.x, _nameLabel.frame.origin.y + _nameLabel.frame.size.height, self.bounds.size.width/3, self.bounds.size.height/2);
    
    [_distanceLabel sizeToFit];
    _distanceLabel.center = CGPointMake(self.bounds.size.width - _distanceLabel.bounds.size.width/2 - padding*5 , self.bounds.size.height/2);
    
    _chevronView.frame = CGRectMake(0, 0, self.bounds.size.height/2, self.bounds.size.height);
    
    _chevronView.center = CGPointMake(self.bounds.size.width - _chevronView.bounds.size.width/2, self.bounds.size.height/2);
    
    _chevronImageView.center = CGPointMake(_chevronView.bounds.size.width/2 , _chevronView.bounds.size.height/2);
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];
}

- (void)setupWithGeoObject:(HYBGeolocatorObject*)geoObject {    
   //implemented in custom cells
}

@end
