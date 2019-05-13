//
//  NSDictionary+FULLFields.m
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


#import "NSDictionary+FULLFields.h"

@implementation NSDictionary (FULLFields)

+ (NSDictionary*)FULLFields {
    return [NSDictionary dictionaryWithObject:@"FULL" forKey:@"fields"];
}

+ (NSDictionary*)FULLFields:(NSDictionary*)params {
    
    NSMutableDictionary *tmpDict = nil;
    
    if (params) {
        tmpDict = [NSMutableDictionary dictionaryWithDictionary:params];
    } else {
        tmpDict = [NSMutableDictionary dictionary];
    }

    [tmpDict setObject:@"FULL" forKey:@"fields"];

    return [NSDictionary dictionaryWithDictionary:tmpDict];
}

@end
