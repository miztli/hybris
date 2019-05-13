//
// HYBAppDelegate.h
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
#import "HYBMasterNavigationController.h"

@class HYBB2BService;

@interface HYBAppDelegate : UIResponder <UIApplicationDelegate>

@property(nonatomic) UIWindow *window;
@property(nonatomic) HYBMasterNavigationController *masterNavigationController;
@property(nonatomic, readonly) HYBB2BService* backEndService;

- (void)passLoginWindow;

@end
