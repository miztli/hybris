//
// HYBCategoriesControllerSpec.m
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


#define EXP_SHORTHAND

#import <Specta/Specta.h>
#import <Expecta/Expecta.h>
#import "HYBCatalogMenuController.h"
#import "HYBB2CService.h"
#import "HYBBackEndServiceStub.h"
#import "NSObject+HYBAdditionalMethods.h"


SpecBegin(HYBCatalogMenuController)
        describe(@"HYBCatalogMenuController", ^{

            __block HYBCatalogMenuController *controller;
            __block HYBBackEndServiceStub *backEndStub;

            beforeAll(^{
                backEndStub = [[HYBBackEndServiceStub alloc] init];
                controller = [[HYBCatalogMenuController alloc] initWithBackEndService:backEndStub];
            });

            it(@"should load the products", ^{
                [controller viewDidLoad];
                expect(controller.categories).to.beTruthy();
            });
        });
SpecEnd
