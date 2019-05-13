//
//  HYBTopToolbar.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBToolbar.h"

@class HYBDrawerController;

@protocol HYBSearchDelegate <NSObject>

@optional
- (void)performSearchForString:(NSString*)searchString;
- (void)cancelSearch;
@end

@interface HYBTopToolbar : HYBToolbar <UITextFieldDelegate>

@property (nonatomic) id <HYBSearchDelegate> searchDelegate;

@property (nonatomic) NSString *searchString;
@property (nonatomic) UITextField *searchField;

- (void)clearSearch;
- (void)removeSearchResults;

@end
