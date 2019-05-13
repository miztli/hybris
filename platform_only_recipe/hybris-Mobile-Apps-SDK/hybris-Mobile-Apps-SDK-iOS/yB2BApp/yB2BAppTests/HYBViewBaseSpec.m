//
// HYBViewBaseSpec.m
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


#define EXP_SHORTHAND

#import <Expecta/Expecta.h>
#import <CocoaLumberjack/DDTTYLogger.h>
#import <CocoaLumberjack/DDASLLogger.h>
#import <UIKit/UIKit.h>
#import "Specta.h"

SpecBegin(HYBViewBaseSpec)
   describe(@"HYBViewBaseSpec", ^{
       __block UIView *view;
       beforeEach(^{
           view = [[UIView alloc] init];
       });
   });

SpecEnd
