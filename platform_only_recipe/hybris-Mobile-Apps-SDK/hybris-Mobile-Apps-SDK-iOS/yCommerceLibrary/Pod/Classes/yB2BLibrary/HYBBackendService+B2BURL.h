//
//  HYBBackendService+B2BURL.h
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

#import <Foundation/Foundation.h>
#import "HYBBackendService.h"

@interface HYBBackendService (B2BURL)

#pragma mark categories

- (NSString*)categoriesURL; //GET
- (NSString*)categoryURLForCategoryId:(NSString*)categoryId; //GET
- (NSString*)productsURLForCategoryId:(NSString*)categoryId; //GET

#pragma mark costcenters

- (NSString*)costcentersURL; //GET
- (NSString*)costcenterURLForCostcenterId:(NSString*)costcenterId; //GET

#pragma mark payementtypes

- (NSString*)payementtypesURL; //GET

#pragma mark products

- (NSString*)productsURL; //GET
- (NSString*)productURLForProductCode:(NSString*)productCode; //GET

#pragma mark carts add on

- (NSString*)userCartCostcenterURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //PUT
- (NSString*)userCartPayementURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //PUT
@end
