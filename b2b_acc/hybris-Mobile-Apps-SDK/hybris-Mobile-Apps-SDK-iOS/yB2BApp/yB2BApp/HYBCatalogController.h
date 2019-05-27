//
// HYBCatalogController.h
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
#import "HYBViewController.h"
#import "UIViewController+Navigation.h"
#import "HYBB2BService.h"

@class HYBCategoryHierarchy;
@class OLGhostAlertView;

@interface HYBCatalogController : HYBViewController <
UICollectionViewDataSource,
UICollectionViewDelegateFlowLayout,
UIGestureRecognizerDelegate,
UITextFieldDelegate,
UITableViewDelegate,
UITableViewDataSource>

@property(nonatomic, strong) NSArray  *products;
@property(nonatomic, strong) NSString *currentCategoryId;

@property(nonatomic) BOOL blockScroll;
@property(nonatomic) BOOL loading;
@property(nonatomic) BOOL allItemsLoaded;

@property (nonatomic) NSString *firstResponderOriginalValue;

@property(nonatomic) int prevPage;
- (void)loadProducts;
- (void)loadAllProducts;
- (void)loadBaseProductsByCategoryId:(NSString *)categoryId;
- (void)loadProductsByCategoryId:(NSString *)categoryId;

- (void)forceReload;

@end
