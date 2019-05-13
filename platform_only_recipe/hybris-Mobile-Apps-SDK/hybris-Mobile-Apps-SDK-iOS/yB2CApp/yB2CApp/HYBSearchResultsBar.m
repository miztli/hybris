//
//  HYBSearchResultsBar.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBSearchResultsBar.h"
#import "HYBAppDelegate.h"
#import "HYBDrawerController.h"
#import "HYBToolbar.h"

@interface HYBSearchResultsBar ()

@property (nonatomic) CGRect originalFrame;
@property (nonatomic) CGRect openFrame;
@property (nonatomic) CGRect currentFrame;

@property (nonatomic) UIView    *searchResultPanel;
@property (nonatomic) UILabel   *searchResultStringLabel;
@property (nonatomic) UILabel   *searchResultCountLabel;


@end

@implementation HYBSearchResultsBar

+ (id)searchResultsBarWithFrame:(CGRect)frame {
    return [[HYBSearchResultsBar alloc] initWithFrame:frame];
}

- (id)initWithFrame:(CGRect)frame {
    CGRect tmpFrame = CGRectMake(frame.origin.x, frame.origin.y, frame.size.width, searchResultsBarHeight);
    
    if(self = [super initWithFrame:tmpFrame]) {
        self.accessibilityIdentifier = @"ACCESS_SEARCHBAR";
        self.backgroundColor = searchbar_background_color;
        self.clipsToBounds = YES;
        self.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        self.autoresizesSubviews = YES;
        
        _originalFrame  = tmpFrame;
        _openFrame      = CGRectMake(frame.origin.x, frame.origin.y, [self fW] , [self fH]);
        _currentFrame   = _openFrame;
        
        // search result panel
        _searchResultPanel = [UIView  new];
        _searchResultPanel.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_RESULTS_HEADER";
        _searchResultPanel.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        _searchResultPanel.autoresizesSubviews = YES;
        
        _searchResultStringLabel = [UILabel new];
        _searchResultStringLabel.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_RESULTS_HEADER_LEFT";
        _searchResultStringLabel.font = font_large;
        _searchResultStringLabel.textColor = searchbar_results_color;
        
        _searchResultCountLabel = [UILabel new];
        _searchResultCountLabel.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_RESULTS_HEADER_RIGHT";
        _searchResultCountLabel.font = font_medium;
        _searchResultCountLabel.textColor = searchbar_results_color;
        _searchResultCountLabel.autoresizingMask = UIViewAutoresizingFlexibleRightMargin;
        
        [_searchResultPanel addSubview:self.searchResultStringLabel];
        [_searchResultPanel addSubview:self.searchResultCountLabel];
        [self addSubview:self.searchResultPanel];
        
        // did you mean panel
        _searchDidYouMeanPanel = [UIView  new];
        _searchDidYouMeanPanel.accessibilityIdentifier = @"ACCESS_CONTENT_CATALOG_SEARCH_DID_YOU_MEAN";
        _searchDidYouMeanPanel.backgroundColor = searchbar_dym_background;
        _searchDidYouMeanPanel.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        _searchDidYouMeanPanel.autoresizesSubviews = YES;
        
        _searchDidYouMeanLabel = [UILabel new];
        [_searchDidYouMeanPanel addSubview:_searchDidYouMeanLabel];
        
        [self addSubview:_searchDidYouMeanPanel];
        
    }
    
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    //strange bug on iPad resolution switching from 1024 to 1280 for no reason
    CGFloat bW = [self bW];
    if (bW > 1024) bW = 1024;
    
    _originalFrame  = CGRectMake(0, _originalFrame.origin.y, bW, _originalFrame.size.height);
    _openFrame      = CGRectMake(0, _openFrame.origin.y,     bW, _openFrame.size.height);
    _currentFrame   = CGRectMake(0, _currentFrame.origin.y,  bW, _currentFrame.size.height);
    
    _searchResultCountLabel.center = CGPointMake([_searchResultPanel bW] - [_searchResultCountLabel bW]/2 - toolbarMarge,
                                                 _searchResultStringLabel.center.y);
    
}


- (void)setSearchResultString:(NSString *)searchResultString {
    _searchResultString = searchResultString;
    _searchResultStringLabel.text = [NSString stringWithFormat:@"Searched '%@'", _searchResultString];
    [_searchResultStringLabel sizeToFit];
    
    _searchResultPanel.frame = CGRectMake(0,
                                          toolbarMarge,
                                          [self bW],
                                          [_searchResultStringLabel bH]+ toolbarMarge*2);
    
    _searchResultStringLabel.center = CGPointMake([_searchResultStringLabel bW]/2 + toolbarMarge,
                                                  [_searchResultStringLabel bH]/2 + toolbarMarge);
}

- (void)setSearchResultCountString:(NSString *)searchResultCountString {
    _searchResultCountString = searchResultCountString;
    _searchResultCountLabel.text = [NSString stringWithFormat:@"%@ Results", _searchResultCountString];
    [_searchResultCountLabel sizeToFit];
    
    _searchResultCountLabel.center = CGPointMake([_searchResultPanel bW] - [_searchResultCountLabel bW]/2 - toolbarMarge,
                                                 _searchResultStringLabel.center.y);
}

- (void)setSearchDidYouMeanString:(NSString *)searchDidYouMeanString {
    _searchDidYouMeanString = searchDidYouMeanString;
    _searchDidYouMeanLabel.text = [NSString stringWithFormat:@"Did you mean '%@' ?", _searchDidYouMeanString];
    [_searchDidYouMeanLabel sizeToFit];
    
    _searchDidYouMeanPanel.frame = CGRectMake(toolbarMarge,
                                              [_searchResultPanel bottom]+ toolbarMarge,
                                              [self bW]-toolbarMarge*2,
                                              [_searchDidYouMeanLabel bH]+toolbarMarge*2);
    
    _searchDidYouMeanLabel.center = CGPointMake([_searchDidYouMeanLabel bW]/2 + toolbarMarge,
                                                [_searchDidYouMeanLabel bH]/2 + toolbarMarge);
}

- (void)updateSearchResultWithParams:(NSDictionary*)dict animated:(BOOL)animated {
    
    NSString *tmpSearchResultString             = dict[SEARCH_RESULT];
    NSString *tmpSearchResultCountString        = dict[SEARCH_COUNT];
    NSString *tmpSearchResultDidYouMeanString   = dict[SEARCH_DYM];
    
    int frameState = 0;
    
    if(tmpSearchResultString) {
        [self setSearchResultString:tmpSearchResultString];
        _searchResultStringLabel.hidden = NO;
        frameState = 1;
    } else {
        _searchResultStringLabel.hidden = YES;
    }
    
    if(tmpSearchResultCountString) {
        [self setSearchResultCountString:tmpSearchResultCountString];
        _searchResultCountLabel.hidden = NO;
        frameState = 1;
    } else {
        _searchResultCountLabel.hidden = YES;
    }
    
    if(tmpSearchResultDidYouMeanString) {
        [self setSearchDidYouMeanString:tmpSearchResultDidYouMeanString];
        _searchDidYouMeanLabel.hidden = NO;
        frameState = 2;
    } else {
        _searchDidYouMeanLabel.hidden = YES;
    }
    
    switch (frameState) {
        case 0:
            _currentFrame = _originalFrame;
            break;
            
        case 1:
            _currentFrame = CGRectMake([self fX], [self fY], [self fW], CGRectGetHeight(_originalFrame) + [_searchResultStringLabel fH] + toolbarMarge*1.5);
            break;
            
        case 2:
            _currentFrame = CGRectMake([self fX], [self fY], [self fW], CGRectGetHeight(_originalFrame) + [_searchResultStringLabel fH] + [_searchDidYouMeanPanel fH]);;
            break;
            
        default:
            break;
    }
    
    [self showResultPanelAnimated:animated];
}

- (void)showResultPanelAnimated:(BOOL)animated {
    
    _nextRect = _currentFrame;
    
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         self.frame = _nextRect;
                     }
     ];
}

- (void)collapse {
    _currentFrame = CGRectMake([self fX], [self fY], [self fW], 0);
    _nextRect = _currentFrame;
}

@end
