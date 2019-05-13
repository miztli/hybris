//
// HYBProductDetailsControllerSpec.m
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

#import <Specta/Specta.h>
#import <Expecta/Expecta.h>
#import "HYBB2BService.h"
#import "DDASLLogger.h"
#import "DDTTYLogger.h"
#import "HYBConstants.h"
#import "HYBProductDetailsController.h"
#import "HYBAppDelegate.h"
#import "HYBFileToJsonConverter.h"
#import "HYBBackEndServiceStub.h"

SpecBegin(HYBProductDetailsController)
describe(@"HYBProductDetailsController", ^{

     __block HYBProductDetailsController *controller;
     __block HYBProduct *product;

     beforeAll(^{
         HYBFileToJsonConverter *jsonConverter = [[HYBFileToJsonConverter alloc] init];
         product = [jsonConverter sampleProduct];

         HYBBackEndServiceStub *stub = [[HYBBackEndServiceStub alloc] init];
         controller = [[HYBProductDetailsController alloc] initWithBackEndService:stub productId:product.code];
        
     });
 });
SpecEnd
