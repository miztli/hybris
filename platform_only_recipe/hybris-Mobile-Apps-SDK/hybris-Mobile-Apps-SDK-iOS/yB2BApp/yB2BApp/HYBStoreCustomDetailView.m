//
//  HYBStoreCustomDetailView.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBStoreCustomDetailView.h"
#import "HYBB2BService.h"
#import "HYBGeolocatorObject.h"
#import "HYBGeolocatorTools.h"
#import "UIView+Utilities.h"
#import "UIColor+Expanded.h"
#import "HYBConstants.h"
#import "stylesheet.h"

@interface HYBStoreCustomDetailView ()

@property (nonatomic) HYBPointOfService *store;
@property (nonatomic) UILabel *storeNameLabel;
@property (nonatomic) UILabel *storeAddressL1Label;
@property (nonatomic) UILabel *storeAddressL2Label;
@property (nonatomic) UILabel *storeHoursTitleLabel;
@property (nonatomic) UIView  *storeHoursPanel;
@property (nonatomic) UILabel *directionsLabel;
@property (nonatomic) UILabel *phoneLabel;

@property (nonatomic) UILabel *storeCountLabel;


@end


CGFloat localMarge = 30.f;
CGFloat maxHoursHeight = 0.f;

@implementation HYBStoreCustomDetailView

- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];

    [_storeNameLabel sizeToFit];
    _storeNameLabel.center = CGPointMake([self bW]/2,
                                         [_storeNameLabel bH]/2+ localMarge/2);

    _backButtonLabel.center = CGPointMake([_backButtonLabel bW]/2+ localMarge,
                                          [_backButtonLabel bH]/2);
    
    _pinView.center = CGPointMake([_pinView bW]/2+ localMarge*2,
                                  [_storeNameLabel bottom] + localMarge*1.5);
    
    [_storeAddressL1Label sizeToFit];
    _storeAddressL1Label.center = CGPointMake([_pinView right]  + [_storeAddressL1Label bW]/2 + localMarge/2,
                                              [_pinView bottom] - [_storeAddressL1Label bH]/2 * 4);
    
    [_storeAddressL2Label sizeToFit];
    _storeAddressL2Label.center = CGPointMake([_pinView right]  + [_storeAddressL2Label bW]/2 + localMarge/2,
                                              [_pinView bottom] - [_storeAddressL2Label bH]);
    
    [_storeDistanceLabel sizeToFit];
    _storeDistanceLabel.center = CGPointMake([self bW] - [_storeDistanceLabel bW]/2 - localMarge*3,
                                             _pinView.center.y);
    
    _storeHoursTitleLabel.center = CGPointMake([_storeHoursTitleLabel bW]/2+ localMarge*2,
                                               [_storeAddressL2Label bottom] + localMarge*2);
    
    _storeHoursPanel.frame = CGRectMake(localMarge*2,
                                        [_storeHoursTitleLabel bottom],
                                        [self bW]-localMarge*4,
                                        maxHoursHeight);
    
    _callView.center = CGPointMake([self bW]/3,
                                   [_storeHoursPanel bottom]+localMarge*2);
    
    _directionsView.center = CGPointMake([self bW]/3*2,
                                         [_storeHoursPanel bottom]+localMarge*2);
    

    _phoneLabel.center =  CGPointMake([_callView bW]/2,
                                      [_callView bH]-[_phoneLabel bH]/2);

    _directionsLabel.center =  CGPointMake([_directionsView bW]/2,
                                      [_directionsView bH]-[_directionsLabel bH]/2);
}

- (void)setup {
    self.backgroundColor = store_locator_detail_background;
    
    self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    self.autoresizesSubviews = YES;
    
    
    _storeNameLabel = [UILabel new];
    _storeNameLabel.font = store_locator_detail_name_font;
    _storeNameLabel.textColor = store_locator_detail_name;
    _storeNameLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_NAME";
    
    _backButtonLabel = [UILabel new];
    _backButtonLabel.text = NSLocalizedString(@"store_details_back", nil);
    _backButtonLabel.font = store_locator_detail_back_font;
    _backButtonLabel.textColor = store_locator_detail_back;
    _backButtonLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_BACK_BUTTON";
    [_backButtonLabel sizeToFit];
    
    _pinView = [[HYBGeolocatorPinView alloc] initWithColor:store_locator_detail_pin_color forIndex:nil];
    _pinView.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_PIN_VIEW";
    
    _storeAddressL1Label = [UILabel new];
    _storeAddressL1Label.font = store_locator_detail_address_font;
    _storeAddressL1Label.textColor = store_locator_address;
    _storeAddressL1Label.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_STORE_ADDRESS_1";
    
    _storeAddressL2Label = [UILabel new];
    _storeAddressL2Label.font = store_locator_detail_address_font;
    _storeAddressL2Label.textColor = store_locator_address;
    _storeAddressL2Label.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_STORE_ADDRESS_2";
    
    _storeDistanceLabel   = [UILabel new];
    _storeDistanceLabel.font = store_locator_detail_distance_font;
    _storeDistanceLabel.textColor = store_locator_distance;
    _storeDistanceLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_DISTANCE";
    
    _storeHoursTitleLabel = [UILabel new];
    _storeHoursTitleLabel.text = NSLocalizedString(@"store_details_hours_title", nil);
    _storeHoursTitleLabel.font = store_locator_detail_hours_title_font;
    _storeHoursTitleLabel.textColor = store_locator_detail_hours_title;
    _storeHoursTitleLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_HOURS_TITLE";
    [_storeHoursTitleLabel sizeToFit];
    
    _storeHoursPanel = [UIView new];
    
    _callView       = [self buttonViewForIconName:@"call_icon.png"];
    _callView.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_CALL_BUTTON";
    _directionsView = [self buttonViewForIconName:@"directions_icon.png"];
    _directionsView.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_DIRECTIONS_BUTTON";
    
    _phoneLabel         = [UILabel new];
    _phoneLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_PHONE";
    _directionsLabel    = [UILabel new];
    _directionsLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_DIRECTIONS";
    
    //pile up
    [self addSubview:_backButtonLabel];
    [self addSubview:_storeNameLabel];
    [self addSubview:_pinView];
    [self addSubview:_storeAddressL1Label];
    [self addSubview:_storeAddressL2Label];
    [self addSubview:_storeDistanceLabel];
    [self addSubview:_storeHoursTitleLabel];
    [self addSubview:_storeHoursPanel];
    [_callView addSubview:_phoneLabel];
    [self addSubview:_callView];
    [_directionsView addSubview:_directionsLabel];
    [self addSubview:_directionsView];
}

- (UIView*)buttonViewForIconName:(NSString*)iconName {
    UIView *container = [UIView new];
    
    UIImageView *iconView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:iconName]];
    
    container.frame = CGRectInset(iconView.frame, -20.f, -20.f);
    
    iconView.center = CGPointMake([container bW]/2, [container bH]/2-10);
    [container addSubview:iconView];
    
    return container;
}

- (void)setupWithStore:(HYBPointOfService *)store {

    if(_store) _store = nil;
    
    _store = store;
    
    _storeNameLabel.text = _store.displayName;
    [_storeNameLabel sizeToFit];
                            
    _storeAddressL1Label.text = [NSString stringWithFormat:@"%@, %@", _store.address.line1, _store.address.line2 ];
    
    _storeAddressL2Label.text = [NSString stringWithFormat:@"%@, %@", _store.address.town, _store.address.postalCode];
    
    _phoneLabel.text = _store.address.phone;
    _phoneLabel.font = store_locator_detail_button_font;
    _phoneLabel.textColor = store_locator_detail_button;
    [_phoneLabel sizeToFit];

    _directionsLabel.text = NSLocalizedString(@"store_directions", nil);
    _directionsLabel.font = store_locator_detail_button_font;
    _directionsLabel.textColor = store_locator_detail_button;
    [_directionsLabel sizeToFit];
    
    [self setupHours];
    
    [self setNeedsLayout];
}

- (void)setupHours {
    
    _storeHoursPanel.frame = CGRectMake(localMarge*2, [_storeHoursTitleLabel bottom]+localMarge/2, [self bW]-localMarge*4, localMarge);
    
    [_storeHoursPanel removeSubviews];
    
    int count = 0;
    int col = 0;
    
    for (HYBWeekdayOpeningDay *day in _store.openingHours.weekDayOpeningList) {
        UIView *viewForDay = [self viewForDay:day];
        [_storeHoursPanel addSubview:viewForDay];
        
        if(count > 3) {
            count = 0;
            col++;
        }
        
        ++count;
        
        CGFloat cX = col*[viewForDay bW] + [viewForDay bW]/2;
        CGFloat cY = [viewForDay bH]*count;
        
        viewForDay.center = CGPointMake(cX, cY);
        
        if(maxHoursHeight < [viewForDay bH]*count) maxHoursHeight = [viewForDay bH]*(count+1.5);
    }
    
    
}

- (UIView*)viewForDay:(HYBWeekdayOpeningDay*)day {
   
    CGFloat width = [_storeHoursPanel bW]/2;
    CGFloat height = 0.f;
    CGFloat nudge = 10.f;
    
    UILabel *dayNameLabel   = [UILabel new];
    dayNameLabel.text = NSLocalizedString(day.weekDay,nil);
    dayNameLabel.font = store_locator_detail_hours_font;
    dayNameLabel.textColor = store_locator_detail_hours;
    dayNameLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_DAY";
    [dayNameLabel sizeToFit];
    
    height = [dayNameLabel bH]*1.33;
    UIView *container = [[UIView alloc] initWithFrame:CGRectMake(0, 0, width, height)];
    
    dayNameLabel.center = CGPointMake([dayNameLabel bW]/2, height/2);
    [container addSubview:dayNameLabel];
    
    BOOL isClosed = day.closed;
    
    if(isClosed) {
        UILabel *closedLabel  = [UILabel new];
        closedLabel.text = NSLocalizedString(@"store_closed", nil);
        closedLabel.font = store_locator_detail_hours_font;
        closedLabel.textColor = store_locator_detail_hours;
        [closedLabel sizeToFit];
        closedLabel.center = CGPointMake(width/5*2, height/2);
        [container addSubview:closedLabel];
    } else {
        
        UILabel *dayOpenLabel   = [UILabel new];
        UILabel *dayToLabel     = [UILabel new];
        UILabel *dayCloseLabel  = [UILabel new];
        
        HYBTime *openTime = day.openingTime;
        NSString *openFormattedString = openTime.formattedHour;
        
        HYBTime *closeTime = day.closingTime;
        NSString *closeFormattedString = closeTime.formattedHour;
        
        dayOpenLabel.text = NSLocalizedString(openFormattedString,nil);
        dayOpenLabel.font = store_locator_detail_hours_font;
        dayOpenLabel.textColor = store_locator_detail_hours;
        dayOpenLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_DAY_OPEN";
        [dayOpenLabel sizeToFit];
        
        dayToLabel.text = NSLocalizedString(@"to_key",nil);
        dayToLabel.font = store_locator_detail_hours_font;
        dayToLabel.textColor = store_locator_detail_hours;
        [dayToLabel sizeToFit];
        
        dayCloseLabel.text = NSLocalizedString(closeFormattedString,nil);
        dayCloseLabel.font = store_locator_detail_hours_font;
        dayCloseLabel.textColor = store_locator_detail_hours;
        dayCloseLabel.accessibilityIdentifier = @"ACCESS_STORE_DETAILS_DAY_CLOSE";
        [dayCloseLabel sizeToFit];
        
        [container addSubview:dayOpenLabel];
        [container addSubview:dayToLabel];
        [container addSubview:dayCloseLabel];
        
        dayOpenLabel.center     = CGPointMake(width/5*2+nudge, height/2);
        dayToLabel.center       = CGPointMake(width/5*3, height/2);
        dayCloseLabel.center    = CGPointMake(width/5*4-nudge, height/2);
        
    }
    
    return container;
}



@end
