//
//  HYBSearchResultsBar.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <UIKit/UIKit.h>
#import "stylesheet.h"
#import "UIView+Utilities.h"
#import "UIColor+Expanded.h"

#define searchResultsBarHeight 40.f

#define SEARCH_RESULT   @"SEARCH_RESULT"
#define SEARCH_COUNT    @"SEARCH_COUNT"
#define SEARCH_DYM      @"SEARCH_DYM"

@interface HYBSearchResultsBar : UIView

@property (nonatomic) NSString *searchString;
@property (nonatomic) NSString *searchResultString;
@property (nonatomic) NSString *searchResultCountString;
@property (nonatomic) NSString *searchDidYouMeanString;

@property (nonatomic) UIView    *searchDidYouMeanPanel;
@property (nonatomic) UILabel   *searchDidYouMeanLabel;

@property (nonatomic) CGRect nextRect;

+ (id)searchResultsBarWithFrame:(CGRect)frame;
- (void)updateSearchResultWithParams:(NSDictionary*)dict animated:(BOOL)animated;
- (void)collapse;

@end
