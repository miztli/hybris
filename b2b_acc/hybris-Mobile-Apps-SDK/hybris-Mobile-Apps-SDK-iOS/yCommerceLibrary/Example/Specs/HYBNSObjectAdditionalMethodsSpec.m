//
// HYBNSObjectAdditionalMethodsSpec.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//
#import <Specta/Specta.h>
#define EXP_SHORTHAND
#import <Expecta/Expecta.h>
#import "NSObject+HYBAdditionalMethods.h"

SpecBegin(HYBNSObjectAdditionalMethodsSpec)
     describe(@"not nil method for all types", ^{
         it(@"handle common types for nil", ^{
             id nilId = nil;
             NSNull *nullObject = [[NSNull alloc] init];
             NSArray *emptyArray = [[NSArray alloc] init];
             NSDictionary *emptyDict = [[NSDictionary alloc] init];
             NSString *emptyString = @"";

             expect([nilId hyb_isNotBlank]).to.beFalsy();
             expect([nullObject hyb_isNotBlank]).to.beFalsy();
             expect([emptyArray hyb_isNotBlank]).to.beFalsy();
             expect([emptyDict hyb_isNotBlank]).to.beFalsy();
             expect([emptyString hyb_isNotBlank]).to.beFalsy();
         });
         it(@"handle common types for not nil", ^{
             id nilId = [[NSObject alloc] init];
             NSArray *emptyArray = @[@"some"];
             NSDictionary *emptyDict = @{@"key":@"value"};
             NSString *emptyString = @"not empty string";

             expect([nilId hyb_isNotBlank]).to.beTruthy();
             expect([emptyArray hyb_isNotBlank]).to.beTruthy();
             expect([emptyDict hyb_isNotBlank]).to.beTruthy();
             expect([emptyString hyb_isNotBlank]).to.beTruthy();
         });
     });
SpecEnd




