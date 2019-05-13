//
//  HYBDrawerController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import "HYBDrawerController.h"
#import "UIView+Utilities.h"
#import "UIViewController+MMDrawerController.h"
#import "UIViewController+Navigation.h"

#import "HYBCatalogController.h"
#import "HYBProductDetailsController.h"
#import "HYBOrdersHistoryController.h"
#import "HYBOrderConfirmationController.h"

@interface HYBDrawerController ()
@property (nonatomic) BOOL locked;
@end

@implementation HYBDrawerController

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
}

- (void)setTopToolbar:(HYBTopToolbar *)topToolbar {
    
    _locked = NO;
    
    if (_topToolbar) {
        [_topToolbar removeFromSuperview];
        _topToolbar = nil;
    }
    
    _topToolbar = topToolbar;
    
    [self.view addSubview:_topToolbar];    
}

- (void)closeDrawersIfNeeded {
    [self closeDrawersIfNeededWithCompletionBlock:nil];
}

- (void)closeDrawersIfNeededWithCompletionBlock:(void (^)(BOOL finished))completion {
     if([self openSide] != MMDrawerSideNone) [self toggleDrawerSide:[self openSide] animated:YES completion:completion];
}

- (void)refreshLayout {
     //if we have a HYBCatalogController of top of navigation stack, reload it to trigger layout modification
    id probe = [[(UINavigationController*)self.centerViewController viewControllers] lastObject];
    
    if (probe && [probe isKindOfClass:[HYBCatalogController class]]) {
        [probe forceReload];
    } else {
        //else bring the catalog to the center view first
        [self checkPageDismiss];
    }
}

- (void)resignActiveResponder {
    //close keyboard if needed
    if (self.view.findFirstResponder) [self.view.findFirstResponder resignFirstResponder];
}

- (void)checkPageDismiss {
    //if we have a HYBProductDetailsController of top of navigation stack, pop it
    id probe = [[(UINavigationController*)self.centerViewController viewControllers] lastObject];
    
    BOOL dismissProbe = NO;
    
    //product detail page
    if (probe && [probe isKindOfClass:[HYBProductDetailsController class]]) {
        dismissProbe = YES;
    }
    
    //dismiss is needed
    if (dismissProbe) {
        [[probe navigationController] popViewControllerAnimated:YES];
    }
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation {
    [super didRotateFromInterfaceOrientation:fromInterfaceOrientation];
    
    [self.view      layoutSubviews];
    [_topToolbar    layoutSubviews];
}


@end
