//
// HYBPromotionResultList.m
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
// Warning:This file was auto-generated by OCC2Ojbc.
//

#import "HYBPromotionResultList.h"
#import "NSValueTransformer+MTLPredefinedTransformerAdditions.h"

#import "HYBPromotionResult.h"


@implementation HYBPromotionResultList

+ (instancetype)promotionResultListWithParams:(NSDictionary*)params {

NSError *error = nil;
HYBPromotionResultList *object = [MTLJSONAdapter modelOfClass:[HYBPromotionResultList class] fromJSONDictionary:params error:&error];

if (error) {
    NSLog(@"Couldn't convert JSON to model HYBPromotionResultList");
    return nil;
}

return object;
}

+ (NSDictionary *)JSONKeyPathsByPropertyKey {
   return @{
@"promotions" : @"promotions"
};
}

+ (NSValueTransformer *)promotionsJSONTransformer {
return [NSValueTransformer mtl_JSONArrayTransformerWithModelClass:[HYBPromotionResult class]];
}






@end