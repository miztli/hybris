//
//  HYBStoreCustomListCell.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBStoreCustomListCell.h"
#import "UIView+Utilities.h"
#import "UIColor+Expanded.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "HYBPointOfService.h"
#import "HYBAddress.h"
#import "HYBStoreContactTools.h"

@implementation HYBStoreCustomListCell


- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier {
    
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier]) {
        _callView       = [self buttonViewForIconName:@"call_icon.png"];
        _callView.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_CALL_BUTTON";
        
        _directionsView = [self buttonViewForIconName:@"directions_icon.png"];
        _directionsView.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_DIRECTIONS_BUTTON";
        
        _phoneLabel         = [UILabel new];
        _phoneLabel.text = @"8-888-888-8888";
        _phoneLabel.lineBreakMode = NSLineBreakByWordWrapping;
        _phoneLabel.textAlignment = NSTextAlignmentCenter;
        _phoneLabel.font = store_locator_detail_button_font;
        _phoneLabel.textColor = store_locator_detail_button;
        [_phoneLabel sizeToFit];
        _phoneLabel.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_PHONE";
        
        _directionsLabel    = [UILabel new];
        _directionsLabel.text = NSLocalizedString(@"store_directions", nil);
        _directionsLabel.font = store_locator_detail_button_font;
        _directionsLabel.textColor = store_locator_detail_button;
        [_directionsLabel sizeToFit];
        _directionsLabel.accessibilityIdentifier = @"ACCESS_STORE_LOCATOR_DIRECTIONS";
        
        
        [_callView addSubview:_phoneLabel];
        [self addSubview:_callView];
        [_directionsView addSubview:_directionsLabel];
        [self addSubview:_directionsView];
     
        //call button action
        _callView.userInteractionEnabled = YES;
        UITapGestureRecognizer *tapCall = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                  action:@selector(callCurrentStore)];
        [_callView addGestureRecognizer:tapCall];
        
        //directions button action
        _directionsView.userInteractionEnabled = YES;
        UITapGestureRecognizer *tapDirections = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                        action:@selector(directionsToCurrentStore)];
        [_directionsView addGestureRecognizer:tapDirections];

    }
    return self;
    
}

- (UIEdgeInsets)layoutMargins {
    return UIEdgeInsetsZero;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    _directionsView.center = CGPointMake([self bW]/3*2+10.f,
                                         [self bH]/2);
    
    _callView.center = CGPointMake([_directionsView left] - [_callView bW],
                                   [self bH]/2);
    
    _phoneLabel.center =  CGPointMake([_callView bW]/2,
                                      [_callView bH]-[_phoneLabel bH]/2);
    
    _directionsLabel.center =  CGPointMake([_directionsView bW]/2,
                                           [_directionsView bH]-[_directionsLabel bH]/2);
}

- (UIView*)buttonViewForIconName:(NSString*)iconName {
    UIView *container = [UIView new];
    
    UIImageView *iconView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:iconName]];
    
    container.frame = CGRectInset(iconView.frame, -20.f, -20.f);
    
    iconView.center = CGPointMake([container bW]/2, [container bH]/2-10);
    [container addSubview:iconView];
    
    return container;
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];
}

- (void)setupWithGeoObject:(HYBGeolocatorObject*)geoObject {
    [super setupWithGeoObject:geoObject];
    
    HYBPointOfService *store = (HYBPointOfService*)geoObject.options[@"fullHYBStore"];
    
   if (store.address && [store.address respondsToSelector:@selector(phone)]) {
        _currentStore = [store copy];
        
        if (store.address.phone && [store.address.phone length] > 0) {
            _phoneLabel.text = store.address.phone;
            _callView.hidden = NO;
        } else {
            _callView.hidden = YES;
        }
    }
}

- (void)callCurrentStore {
    [HYBStoreContactTools callStore:_currentStore];
}

- (void)directionsToCurrentStore {
    [HYBStoreContactTools directionsToStore:_currentStore];
}

@end
