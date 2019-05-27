//
// HYBCostCenter.m
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

#import "HYBCostCenter.h"
#import "HYBAddress.h"
#import "NSValueTransformer+MTLPredefinedTransformerAdditions.h"


@implementation HYBCostCenter

+ (instancetype)costCenterWithParams:(NSDictionary*)params {
    NSError *error = nil;
    HYBCostCenter *object = [MTLJSONAdapter modelOfClass:[HYBCostCenter class] fromJSONDictionary:params error:&error];
    
    if (error) {
        NSLog(@"Couldn't convert JSON to model HYBCostCenter");
        return nil;
    }
    
    return object;
}

+ (NSDictionary *)JSONKeyPathsByPropertyKey {
    return @{
            @"code"      : @"code",
            @"name"      : @"name",
            @"addresses" : @"unit.addresses",
    };
}

+ (NSValueTransformer *)addressesJSONTransformer {
    return [NSValueTransformer mtl_JSONArrayTransformerWithModelClass:[HYBAddress class]];
}

@end