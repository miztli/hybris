//
//  UIViewController+Navigation.h
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
#import <MMDrawerController/MMDrawerController.h>
#import "OLGhostAlertView.h"

#define  TAG_MASK_VIEW             9999999
#define  TAG_LOCATION_ALERT        9911199

@class HYBDrawerController;
@class HYBAppDelegate;
@class HYBOrder;
@class HYBProduct;
@class HYBCategoryHierarchy;

@interface UIViewController (Navigation) <UIAlertViewDelegate>

//setup
- (void)setupDrawers;

- (HYBDrawerController *)createDrawerWithCenter:(UINavigationController *)centerNavigationController
                                     leftDrawer:(UINavigationController *)leftSideViewController
                                    rigthDrawer:(UIViewController *)rightSideViewController;


//navigation
- (void)pushMenuController:(id)controller;
- (void)popMenuController;
- (void)popMenuControllerToRoot;

- (void)doLogout;

- (void)openDashboard;
- (void)openOrders;
- (void)openCatalogWithCompletion:(void (^)(id))completion;
- (void)openCatalog;
- (void)openAccount;
- (void)checkOpenStoreLocator;
- (void)openStoreLocator;
- (void)openLogin;
- (void)openCheckout;
- (void)openOrderConfirmationWithOrder:(HYBOrder *)order;
- (void)openScanner;

- (void)pushDetailControllerWithProduct:(HYBProduct *)product toggleDrawer:(BOOL)toggleDrawer;
- (void)pushOrSwapTopCenterViewControllerTo:(id)viewController animated:(BOOL)animated;

- (void)openCategoryInCatalog:(HYBCategoryHierarchy *)category;

//utilities
- (id)backEndService;

- (HYBAppDelegate *)getDelegate;

- (void)registerForCartChangeNotifications:(SEL)methodToCall senderObject:(id)senderObject;

- (CGFloat)maxWidthLeftDrawer;
- (CGFloat)maxWidthRightDrawer;

- (id)currentCenterController;
- (id)currentLeftController;
- (id)currentRightController;

//animation
- (void)toggleRightDrawer;
- (void)toggleRightDrawerAnimated:(BOOL)animated;

- (void)toggleLeftDrawer;
- (void)toggleLeftDrawerAnimated:(BOOL)animated;

//toast message
- (void)showAlertMessage:(NSString *)message withTitle:(NSString *)title cancelButtonText:(NSString *)cancelButtonText;
- (void)showNotifyMessage:(NSString *)msg;

//keyboard monitor
- (void)keyboardDidShow:(NSNotification *)notification;
- (void)keyboardDidHide:(NSNotification *)notification;

@end
