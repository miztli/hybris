//
// HYBViewController.h
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
#import <UIKit/UIKit.h>

#import "UIView+Utilities.h"
#import "HYBSearchResultsBar.h"

#import <MMDrawerController/MMDrawerController.h>
#import "MMDrawerBarButtonItem.h"
#import "HYBDrawerController.h"
#import "UIViewController+MMDrawerController.h"
#import "UIViewController+Navigation.h"
#import "HYBActivityIndicator.h"
#import "HYBSearchResultsBar.h"

#import "HYBB2BService.h"

@class MMDrawerController;



/**
* Base class for all controllers to add centralized utility methods in one super class.
* All controllers in the app are extending from it.
*/
@interface HYBViewController : UIViewController <HYBSearchDelegate>

@property (nonatomic) HYBSearchResultsBar *searchResultsBar;

@property (nonatomic, copy) NSString *didYoumeanQuery;
@property (nonatomic) NSString *currentSearchQuery;
@property (nonatomic) BOOL ignoreSearchFrame;

@property (nonatomic, readonly) HYBB2BService* b2bService;

/**
 *  Constructor to create the controller, all needed methods will be performed in the constructor, so after the init the object is in the working state.
 *
 *  @param b2bService service representing the back end, it is expected that the implementation of the back end facade will be passed in.
 *
 *  @return the ready initialized controller
 */
- (instancetype)initWithBackEndService:(HYBB2BService*)b2bService;

- (HYBTopToolbar*)topToolbar;


@end
