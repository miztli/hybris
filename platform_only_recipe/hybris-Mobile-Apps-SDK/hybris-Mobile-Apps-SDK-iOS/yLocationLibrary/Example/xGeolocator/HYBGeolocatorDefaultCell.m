//
//  HYBGeolocatorDefaultCell.m
//  xGeolocator
// [y] hybris Platform
//
// Copyright (c) 2000-2014 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBGeolocatorDefaultCell.h"

@interface HYBGeolocatorDefaultCell ()



@end

@implementation HYBGeolocatorDefaultCell

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {
    
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
               
        _indexLabel                     = [UILabel new];
        _indexLabel.font                = [UIFont fontWithName:@"HelveticaNeue" size:18.f];
        _indexLabel.textColor           = [UIColor blackColor];
        _indexLabel.textAlignment       = NSTextAlignmentLeft;
        
        _nameLabel                      = [UILabel new];
        _nameLabel.font                 = [UIFont fontWithName:@"HelveticaNeue" size:18.f];
        _nameLabel.textColor            = [UIColor blackColor];
        _nameLabel.textAlignment        = NSTextAlignmentLeft;
        
        _descriptionLabel               = [UILabel new];
        _descriptionLabel.font          = [UIFont fontWithName:@"HelveticaNeue" size:14.f];
        _descriptionLabel.textColor     = [UIColor blackColor];
        _descriptionLabel.textAlignment = NSTextAlignmentLeft;
        _descriptionLabel.lineBreakMode = NSLineBreakByWordWrapping;
        _descriptionLabel.numberOfLines = 0;
        
        _distanceLabel                  = [UILabel new];
        _distanceLabel.font             = [UIFont fontWithName:@"HelveticaNeue" size:16.f];
        _distanceLabel.textColor        = [UIColor blackColor];
        _distanceLabel.textAlignment    = NSTextAlignmentRight;
        
        _chevronImageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"defaultChevron.png"]];
        _chevronImageView.clipsToBounds = YES;
        _chevronImageView.contentMode = UIViewContentModeScaleAspectFit;
        
        //pile up
        [self.contentView addSubview:_indexLabel];
        [self.contentView addSubview:_nameLabel];
        [self.contentView addSubview:_descriptionLabel];
        [self.contentView addSubview:_distanceLabel];
        [self.contentView addSubview:_chevronImageView];
        
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
    
    _chevronImageView.center = CGPointMake(self.bounds.size.width - _chevronImageView.bounds.size.width/2 - padding*2 , self.bounds.size.height/2);
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];
}

@end
