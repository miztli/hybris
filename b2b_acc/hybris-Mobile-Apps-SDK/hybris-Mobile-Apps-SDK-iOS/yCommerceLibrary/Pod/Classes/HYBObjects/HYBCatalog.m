//
// HYBCatalog.m
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

#import "HYBCatalog.h"
#import "NSValueTransformer+MTLPredefinedTransformerAdditions.h"

#import "HYBCatalogVersion.h"


@implementation HYBCatalog

+ (instancetype)catalogWithParams:(NSDictionary*)params {

NSError *error = nil;
HYBCatalog *object = [MTLJSONAdapter modelOfClass:[HYBCatalog class] fromJSONDictionary:params error:&error];

if (error) {
    NSLog(@"Couldn't convert JSON to model HYBCatalog");
    return nil;
}

return object;
}

+ (NSDictionary *)JSONKeyPathsByPropertyKey {
   return @{
@"catalogVersions" : @"catalogVersions"
};
}

+ (NSValueTransformer *)catalogVersionsJSONTransformer {
return [NSValueTransformer mtl_JSONArrayTransformerWithModelClass:[HYBCatalogVersion class]];
}






@end