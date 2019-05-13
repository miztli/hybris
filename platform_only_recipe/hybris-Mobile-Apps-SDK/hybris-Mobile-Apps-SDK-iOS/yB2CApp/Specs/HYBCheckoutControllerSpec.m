//
// HYBCheckoutControllerSpec.m
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

#import <Specta/Specta.h>

#define EXP_SHORTHAND

#import <Expecta/Expecta.h>
#import "HYBB2CService.h"
#import "HYBCart.h"
#import "HYBCheckoutController.h"
#import "HYBBackEndServiceStub.h"
#import "HYBCheckoutView.h"

SpecBegin(HYBCheckoutController)
        describe(@"HYBCheckoutController", ^{
            __block HYBCheckoutController *controller;
            __block HYBB2CService *backEndServiceStub;

            beforeAll(^{
                backEndServiceStub = [[HYBBackEndServiceStub alloc] init];
                controller = [[HYBCheckoutController alloc] initWithBackEndService:backEndServiceStub];
                expect(controller).to.beTruthy();
            });

            
        });
SpecEnd
