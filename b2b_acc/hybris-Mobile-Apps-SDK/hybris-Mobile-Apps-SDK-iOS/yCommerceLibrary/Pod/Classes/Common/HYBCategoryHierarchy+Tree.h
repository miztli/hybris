//
//  HYBCategoryHierarchy+Tree.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//

#import "HYBCategoryHierarchy.h"

@interface HYBCategoryHierarchy (Tree)

@property (nonatomic) HYBCategoryHierarchy *parent;

/**
 *  recursively add parent category to HYBCategoryHierarchy
 *
 */
- (void)assignParent;

/**
 *  returns BOOL YES if category has subcategories
 *
 *  @return BOOL hasSubcategories
 */
- (BOOL)hasSubcategories;

/**
 *  returns category's parent category
 *
 *  @return HYBCategoryHierarchy parentCategory
 */
- (HYBCategoryHierarchy *)parentCategory;

/**
 *  check if a category id part of current catgory's children
 *
 *  @param categoryId NSString
 *
 *  @return BOOL category's subcategories contains given category id
 */
- (BOOL)hasChildId:(NSString *)categoryId;

/**
 *  check if category is root
 *
 *  @return BOOL is root category
 */
- (BOOL)isRoot;

/**
 *  check if category is leaf of subcategories tree
 *
 *  @return BOOL is leaf (ie. has no subcategories)
 */
- (BOOL)isLeaf;

/**
 *  returns an array with parent category at index 0 and subcategories following
 *
 *  @return NSArray of categories
 */
- (NSArray *)listItSelfIncludingChildren;

/**
 *  returns a category given its category id
 *
 *  @param categoryId NSString
 *
 *  @return HYBCategory category
 */
- (HYBCategoryHierarchy *)findCategoryByIdInsideTree:(NSString *)categoryId;

@end
