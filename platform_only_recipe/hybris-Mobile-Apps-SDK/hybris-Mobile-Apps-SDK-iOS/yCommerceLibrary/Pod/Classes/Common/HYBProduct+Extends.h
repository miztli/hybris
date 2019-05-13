//
//  HYBProduct+Extends.h
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
#import "HYBProduct.h"

#define GALLERY @"GALLERY"
#define PRIMARY @"PRIMARY"

#define THUMB @"THUMB"
#define IMAGE @"IMAGE"
#define DATA @"DATA"

@interface HYBProduct (Images)

@property (nonatomic) NSString *thumbnailURL;
@property (nonatomic) NSString *imageURL;
@property (nonatomic) NSArray *galleryImagesData;


- (NSString*)formattedPrice;
- (int)variantDimensionsNumber;
- (id)extractImages:(NSString*)returnType;
- (NSString *)pricingValueForItemAtIndex:(int)index;
- (NSString *)quantityValueForItemAtIndex:(int)index;
- (BOOL)lowStock;
- (BOOL)isInStock;


@end
