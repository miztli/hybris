//
//  UIViewController+Navigation.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "UIViewController+Navigation.h"
#import "UIView+Utilities.h"
#import "HYBDrawerController.h"
#import "HYBAppDelegate.h"
#import "HYBB2CService.h"
#import "HYBCategoryHierarchy.h"
#import "HYBProduct.h"
#import "HYBMainMenuController.h"
#import "HYBCatalogMenuController.h"
#import "HYBOrdersHistoryController.h"
#import "HYBOrdersDetailsController.h"
#import "HYBAccountController.h"
#import "HYBDashboardController.h"
#import "HYBCatalogController.h"
#import "HYBProductDetailsController.h"
#import "HYBCartController.h"
#import "HYBCheckoutController.h"
#import "HYBOrderConfirmationController.h"
#import "HYBStoreLocatorController.h"
#import "HYBAddressesListViewController.h"
#import "HYBScanViewController.h"
#import "HYBAuthHubController.h"
#import "HYBAddressesListViewController.h"
#import "HYBAddressFormViewController.h"
#import "HYBCreditCardFormViewController.h"


@implementation UIViewController (Navigation)

- (HYBDrawerController *)createDrawerWithCenter:(UINavigationController *)centerNavigationController
                                     leftDrawer:(UINavigationController *)leftSideViewController
                                    rigthDrawer:(UIViewController *)rightSideViewController {
    
    DDLogDebug(@"create a L|C|R drawer controller");
    
    //create drawer controller
    HYBDrawerController *drawerController = [[HYBDrawerController alloc] initWithCenterViewController:centerNavigationController
                                                                             leftDrawerViewController:leftSideViewController
                                                                            rightDrawerViewController:rightSideViewController];
    
    //setup cosmetic & constraints
    [drawerController setShowsShadow:NO];
    [drawerController setShouldStretchDrawer:NO];
    [drawerController setMaximumRightDrawerWidth:[self maxWidthRightDrawer]];
    [drawerController setMaximumLeftDrawerWidth: [self maxWidthLeftDrawer]];
    
    [drawerController setGestureCompletionBlock:^(MMDrawerController * drawerController, UIGestureRecognizer * gesture) {
        if(drawerController.openSide != MMDrawerSideNone) {
            [(HYBDrawerController*)drawerController closeSearchbarIfNeeded];
        }
    }];
    
    //setup gesture mask
    [drawerController setCenterHiddenInteractionMode:MMDrawerOpenCenterInteractionModeNone];
    
    [drawerController setOpenDrawerGestureModeMask:MMOpenDrawerGestureModeBezelPanningCenterView];
    [drawerController setCloseDrawerGestureModeMask:(MMCloseDrawerGestureModePanningCenterView | MMCloseDrawerGestureModeTapCenterView | MMCloseDrawerGestureModeTapNavigationBar)];
    
    return drawerController;
}

- (void)closeSearchbarIfNeeded {
    //close Searchbar If Needed
}

- (void)setupDrawers {
    
    DDLogDebug(@"setup initial drawers system");
    
    id backEndService = [self backEndService];
    
    //create base view controllers
    HYBMainMenuController   *left    = [[HYBMainMenuController alloc]    initWithBackEndService:backEndService];
    HYBDashboardController  *center  = [[HYBDashboardController alloc]   initWithBackEndService:backEndService];
    HYBCartController       *right   = [[HYBCartController alloc]        initWithBackEndService:backEndService];
    
    //create navigation stacks for center view and left drawer (menus)
    UINavigationController *centerNav   = [[UINavigationController alloc] initWithRootViewController:center];
    UINavigationController *leftNav     = [[UINavigationController alloc] initWithRootViewController:left];
    
    //hide iOS nav bar system
    leftNav.navigationBarHidden = YES;
    centerNav.navigationBarHidden = YES;
    
    
    //bundle view controllers in a drawer controller system
    
    HYBDrawerController *baseDrawerController = [self createDrawerWithCenter:centerNav
                                                              leftDrawer:leftNav
                                                             rigthDrawer:right];
    
    //toolbar
    [baseDrawerController setTopToolbar:[[HYBTopToolbar alloc] initWithFrame:self.view.frame]];
    
    //open left side at startup
    [baseDrawerController openDrawerSide:MMDrawerSideLeft animated:NO completion:nil];
    
    //set drawer controller as navigation root
    [[self getDelegate].window setRootViewController:baseDrawerController];
}

#pragma mark base navigation

- (void)pushMenuController:(id)controller {
    DDLogDebug(@"pushMenuController %@",[controller description]);
    [[self currentLeftController] pushViewController:controller animated:YES];
}

- (void)popMenuController {
    DDLogDebug(@"popMenuController");
    [[self currentLeftController] popViewControllerAnimated:YES];
}

- (void)setMenuController:(id)controller {
    //replace top of menu controller stack by given controller
    
    [[self currentLeftController] popViewControllerAnimated:NO];
    [[self currentLeftController] pushViewController:controller animated:NO];
}

- (void)popMenuControllerToRoot {
    DDLogDebug(@"popMenuControllerToRoot");
    [[self currentLeftController] popToRootViewControllerAnimated:YES];
}

- (void)setCenterController:(id)controller {
    DDLogDebug(@"setCenterController %@",[controller description]);
    
    if([controller isKindOfClass:[[self currentCenterController] class]]) {
        DDLogDebug(@"already open, skip");
        
        if ([[self currentCenterController] respondsToSelector:@selector(forceReload)]) {
            [[self currentCenterController] forceReload];
        }
        
    } else {
        DDLogDebug(@"do open");
        
        UINavigationController *navigationController = [[UINavigationController alloc] initWithRootViewController:controller];
        [self.mm_drawerController setCenterViewController:navigationController];
        
    }
}

- (void)openDashboard {
    
    DDLogDebug(@"Navigating to dashboard controller ...");
    HYBDashboardController *controller = [[HYBDashboardController alloc] initWithBackEndService:[self backEndService]];
    [self clearSearch];
    [self setCenterController:controller];
    
}

- (void)openOrders {
    DDLogDebug(@"Navigating to orders controller ...");
    HYBOrdersHistoryController *controller = [[HYBOrdersHistoryController alloc] initWithBackEndService:[self backEndService]];
    [self clearSearch];
    [self setCenterController:controller];
}

- (void)openCatalog {
    [self openCatalogWithCompletion:nil];
}

- (void)openCatalogWithCompletion:(void (^)(id))completion {

    DDLogDebug(@"Navigating to catalog controller ...");
    
    //set center
    HYBCatalogController *controller = [[HYBCatalogController alloc] initWithBackEndService:[self backEndService]];
    [self setCenterController:controller];
    
    //set menu nav
    HYBCatalogMenuController *menu = [[HYBCatalogMenuController alloc] initWithBackEndService:[self backEndService]];
    [self setMenuController:menu];
    
    if(completion) {
        completion(controller);
    }
}

- (void)openAccount {
    DDLogDebug(@"Navigating to account controller ...");
    HYBAccountController *controller = [[HYBAccountController alloc] initWithBackEndService:[self backEndService]];
    [self clearSearch];
    [self setCenterController:controller];
}

- (void)openScanner {
    DDLogDebug(@"Navigating to scanner controller ...");
    HYBScanViewController *controller = [[HYBScanViewController alloc] initWithBackEndService:[self backEndService]];
    [self clearSearch];
    [self setCenterController:controller];
}


- (void)checkOpenStoreLocator {
    CLAuthorizationStatus status = [CLLocationManager authorizationStatus];
    
    if([CLLocationManager locationServicesEnabled] && (status == kCLAuthorizationStatusAuthorizedWhenInUse || status == kCLAuthorizationStatusAuthorizedAlways)) {
        [self openStoreLocator];
    }
    else {
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"location_service_off_title", @"")
                                                        message:NSLocalizedString(@"location_service_off_message", @"")
                                                       delegate:self
                                              cancelButtonTitle:NSLocalizedString(@"Ok", @"Ok")
                                              otherButtonTitles:nil];
        alert.tag = TAG_LOCATION_ALERT;
        [alert show];
    }
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
    
    if (alertView.tag == TAG_LOCATION_ALERT) {
        [self openStoreLocator];
    }
}

- (void)openStoreLocator {
    DDLogDebug(@"Navigating to Store Locator controller ...");
    
    HYBStoreLocatorController *controller = [[HYBStoreLocatorController alloc] initWithBackEndService:[self backEndService]];
    [self clearSearch];
    [self setCenterController:controller];
  
}

- (void)doLogout {
     DDLogDebug(@"Logout user...");
    
    //logout from backend
    [[self backEndService] logoutCurrentUser];
    
    BOOL needExit = NO;
    
    id centerVC = self.mm_drawerController.centerViewController ;
    
    if ([centerVC isKindOfClass:[UINavigationController class]]) {
        id topViewController =  [(UINavigationController*)centerVC topViewController];
        
        if (
            [topViewController isKindOfClass:[HYBAccountController class]]
            || [topViewController isKindOfClass:[HYBOrdersHistoryController class]]
            || [topViewController isKindOfClass:[HYBOrdersDetailsController class]]
            || [topViewController isKindOfClass:[HYBAddressesListViewController class]]
            || [topViewController isKindOfClass:[HYBAddressFormViewController class]]
            || [topViewController isKindOfClass:[HYBCreditCardFormViewController class]]
            ) {
            needExit = YES;
        }
    }
    
    if (needExit) {
        id leftVC = [self currentLeftController];
        if ([leftVC isKindOfClass:[UINavigationController class]]) {
            id topViewController =  [(UINavigationController*)leftVC topViewController];
            
            if ([topViewController isKindOfClass:[HYBMainMenuController class]]) {
                [topViewController refreshTable];
            }
        }
        
        [self openDashboard];
    }
}

- (void)openLogin {
    DDLogDebug(@"Navigating to login controller ...");
    
    //display new login controller
    HYBAuthHubController *loginController = [[HYBAuthHubController alloc] initWithBackEndService:[self backEndService]];
    
    [[self getDelegate].window.rootViewController presentViewController:loginController
                                                               animated:YES
                                                             completion:^() {
                                                                  [self clearSearch];
                                                             }];
    
}

- (void)openCheckout {
    DDLogDebug(@"Navigating to checkout controller ...");
    HYBCheckoutController *controller = [[HYBCheckoutController alloc] initWithBackEndService:[self backEndService]];
    [self clearSearch];
    [self setCenterController:controller];
    [self toggleRightDrawer];
}

- (void)openOrderConfirmationWithOrder:(HYBOrder *)order {
    DDLogDebug(@"Navigating to order confirmation controller ...");
    HYBOrderConfirmationController *controller = [[HYBOrderConfirmationController alloc] initWithBackEndService:[self backEndService] andOrder:order];
    [self clearSearch];
    [self setCenterController:controller];
}

- (void)pushDetailControllerWithProduct:(HYBProduct *)product toggleDrawer:(BOOL)toggleDrawer {
    DDLogDebug(@"Display detail controller for product: %@",product.name);
    
    //new detail viewcontroller
    HYBProductDetailsController *detailViewController = [[HYBProductDetailsController alloc] initWithBackEndService:[self backEndService] productId:product.code];

    //shut drawer is required
    if (toggleDrawer) [self toggleRightDrawer];
    
    //display product
    [self pushOrSwapTopCenterViewControllerTo:detailViewController animated:NO];
}

- (void)pushOrSwapTopCenterViewControllerTo:(id)viewController animated:(BOOL)animated {
    
    //if the new viewcontroller is the same type as the viewcontroller on top of navigation stack
    
    if ([[self currentCenterController] isKindOfClass:[viewController class]]) {
        
        //replace top viewcontroller with new one
        DDLogDebug(@"swap top of stack");
        
        NSMutableArray *vcs = [[(UINavigationController *) self.mm_drawerController.centerViewController viewControllers] mutableCopy];
        
        [vcs removeObject:[vcs lastObject]];
        [vcs addObject:viewController];
        
        [(UINavigationController *) self.mm_drawerController.centerViewController setViewControllers:vcs animated:NO];
    } else {
        //push new viewcontroller on top of the navigation stack
        DDLogDebug(@"push on stack");
        [(UINavigationController *)self.mm_drawerController.centerViewController pushViewController:viewController animated:animated];
    }
}

- (void)openCategoryInCatalog:(HYBCategoryHierarchy *)category {
    
    NSAssert(category != nil, @"Category must be present");
    DDLogDebug(@"Opening the category %@ inside the content area.", category);
    
    HYBCatalogController *center = nil;
    
    if ([[self currentCenterController] isKindOfClass:[HYBCatalogController class]]) {
        DDLogDebug(@"Prensent catalog controller was found and will be reused.");
        center = (HYBCatalogController *)[self currentCenterController];
    } else {
        center = [[HYBCatalogController alloc] initWithBackEndService:[self backEndService]];
        [self setCenterController:center];
    }
    
    [center loadBaseProductsByCategoryId:[category id]];
}

#pragma mark Utilities

- (id)backEndService {
    return [[self getDelegate] backEndService];
}

- (HYBAppDelegate *)getDelegate {
    return (HYBAppDelegate *)[[UIApplication sharedApplication] delegate];
}

- (void)registerForCartChangeNotifications:(SEL)methodToCall senderObject:(id)senderObject {
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:methodToCall
                                                 name:NOTIFICATION_CART_UPDATED
                                               object:senderObject];
}

- (void)clearSearch {
   //clear search
    
}

//columns width
- (CGFloat)maxWidthLeftDrawer {
    return MIN([self.view bW], [self.view bH]) * .3f;
}

- (CGFloat)maxWidthRightDrawer {
    return MIN([self.view bW], [self.view bH]) * .8f;
}

- (id)currentCenterController {
    //select center viewcontroller
    id center = [self.mm_drawerController centerViewController];
    
    //if center viewcontroller is a uinavigation stack
    //return the top viewcontroller
    if ([center respondsToSelector:@selector(viewControllers)]) {
       return [[center viewControllers] lastObject];
    }
    
    //else return the plain center viewcontroller already selected
    return center;
}

- (id)currentLeftController {
    return [self.mm_drawerController leftDrawerViewController];
}

- (id)currentRightController {
    return [self.mm_drawerController rightDrawerViewController];
}

//animation
- (void)toggleRightDrawer {
    [self toggleRightDrawerAnimated:YES];
}

- (void)toggleRightDrawerAnimated:(BOOL)animated {
    [self.mm_drawerController toggleDrawerSide:MMDrawerSideRight animated:animated completion:nil];
}

- (void)toggleLeftDrawer {
    [self toggleLeftDrawerAnimated:YES];
}

- (void)toggleLeftDrawerAnimated:(BOOL)animated {
    [self.mm_drawerController toggleDrawerSide:MMDrawerSideLeft animated:animated completion:nil];
}

#pragma keyboard monitor

- (void)keyboardDidShow:(NSNotification *)notification {
    UIButton *button = [[UIButton alloc] init];
    
    CGRect rect = self.view.bounds;
    
    button.frame = rect;
    button.backgroundColor = [UIColor clearColor];
    button.tag = TAG_MASK_VIEW;
    UIView *currentResponer = [self.view findFirstResponder];
    [button addTarget:currentResponer action:@selector(resignFirstResponder) forControlEvents:UIControlEventTouchUpInside];
    
    [self.view insertSubview:button belowSubview:currentResponer];
}

- (void)keyboardDidHide:(NSNotification *)notification {
    [[self.view viewWithTag:TAG_MASK_VIEW] removeFromSuperview];
}

//toast message
#pragma mark User Notifications and Alerts

- (OLGhostAlertView *)createUserNotifier {
    OLGhostAlertView *notifier = [[OLGhostAlertView alloc] init];
    notifier.timeout = 1.5;
    notifier.style = OLGhostAlertViewStyleDark;
    notifier.position = OLGhostAlertViewPositionCenter;
    notifier.dismissible = YES;
    
    int count = 0;
    
    for (UIView *view in [notifier subviews]) {
        view.accessibilityIdentifier = [NSString stringWithFormat:@"ACCESS_NOTIFIER_%d", count++];
    }
    
    return notifier;
}

- (void)showAlertMessage:(NSString *)message withTitle:(NSString *)title cancelButtonText:(NSString *)cancelButtonText {
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:title
                                                    message:message
                                                   delegate:nil
                                          cancelButtonTitle:cancelButtonText
                                          otherButtonTitles:nil];
    
    alert.accessibilityIdentifier = @"MESSAGE_POPUP_WINDOW";
    
    [alert show];
}

- (void)showNotifyMessage:(NSString *)msg {
    OLGhostAlertView *notifier = [self createUserNotifier];
    notifier.title = msg;
    [notifier show];
}

@end
