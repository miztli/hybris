//
// HYBFileToJsonConverter.h
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

@class HYBCategory;
@class HYBCart;
@class HYBProduct;
@class HYBOrder;
@class HYBPointOfService;

@interface HYBFileToJsonConverter : NSObject
- (NSArray *)       sampleProductList;
- (NSArray *)       sampleOrderList;
- (NSArray *)       sampleStores;

- (HYBPointOfService *)      sampleStore;
- (HYBCategory *)   sampleCategoryTree;
- (HYBCart *)       sampleCart;
- (HYBProduct *)    sampleProduct;
- (HYBOrder *)      sampleOrder;


@end