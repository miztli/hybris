//
//  HYBBackendService+B2BURL.m
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

#import "HYBBackendService+B2BURL.h"

@implementation HYBBackendService (B2BURL)

#pragma mark categories

- (NSString*)categoriesURL {
      return [self.restPrefix stringByAppendingString:FORMAT(@"/categories")];
}

- (NSString*)categoryURLForCategoryId:(NSString*)categoryId {
      return [self.restPrefix stringByAppendingString:FORMAT(@"/categories/%@",categoryId)];
}

- (NSString*)productsURLForCategoryId:(NSString*)categoryId {
      return [self.restPrefix stringByAppendingString:FORMAT(@"/categories/%@/products",categoryId)];
}

#pragma mark costcenters

- (NSString*)costcentersURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/costcenters")];
}

- (NSString*)costcenterURLForCostcenterId:(NSString*)costcenterId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/costcenters/%@",costcenterId)];
}

#pragma mark payementtypes

- (NSString*)payementtypesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/payementtypes")];
}

#pragma mark products

- (NSString*)productsURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products")];
}

- (NSString*)productURLForProductCode:(NSString*)productCode {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/%@",productCode)];
}

#pragma mark carts add on

- (NSString*)userCartCostcenterURLForUserId:(NSString*)userId andCartId:(NSString*)cartId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/costcenter", userId, cartId)];
}

- (NSString*)userCartPayementURLForUserId:(NSString*)userId andCartId:(NSString*)cartId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/paymenttype", userId, cartId)];
}


@end
