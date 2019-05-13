//
// HYBOrdesHistoryControllerSpec.m
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
#import "HYBB2BService.h"
#import "DDASLLogger.h"
#import "DDTTYLogger.h"
#import "HYBConstants.h"
#import "HYBOrdersHistoryController.h"
#import "HYBOrdersHistoryView.h"
#import "HYBBackEndServiceStub.h"
#import "NSObject+HYBAdditionalMethods.h"

SpecBegin(HYBOrdersHistoryController)
describe(@"HYBOrdersHistoryController", ^{
    
    __block HYBOrdersHistoryController *controller;
    __block HYBBackEndServiceStub *backEndStub;
    
    beforeAll(^{
        backEndStub = [[HYBBackEndServiceStub alloc] init];
    });
    
    it(@"should load the orders", ^{
        controller = [[HYBOrdersHistoryController alloc] initWithBackEndService:backEndStub];
        expect(controller).to.beTruthy();
    });
});
SpecEnd
