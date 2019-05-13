//
// NSObject+HYBAdditionalMethods.m
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

#import "NSObject+HYBAdditionalMethods.h"


@implementation NSObject (HYBAdditionalMethods)


- (BOOL)hyb_isNotBlank {

    BOOL isSelfNil = self == nil;

    if(isSelfNil){
        return false;
    } else {
        BOOL isNSNull = [self isKindOfClass:[NSNull class]];

        BOOL isNSDataAndEmpty = [self respondsToSelector:@selector(length)]
                && [(NSData *) self length] == 0;

        BOOL isNSDictionaryAndEmpty = [self respondsToSelector:@selector(allKeys)]
                && [(NSDictionary *) self allKeys].count == 0;

        BOOL isNSStringAndEmpty = [self respondsToSelector:@selector(length)]
                && [(NSString *) self length] == 0;

        BOOL isArrayAndEmpty = [self respondsToSelector:@selector(count)]
                && [(NSArray *) self count] == 0;

        return !(isNSNull || isNSDataAndEmpty || isArrayAndEmpty || isNSStringAndEmpty || isNSDictionaryAndEmpty);
    }
}

@end