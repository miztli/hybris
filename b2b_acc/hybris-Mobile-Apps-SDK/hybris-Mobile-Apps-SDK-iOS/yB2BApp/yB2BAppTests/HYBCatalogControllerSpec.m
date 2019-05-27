//
// HYBCatalogControllerSpec.m
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
#import "HYBCatalogMenuController.h"
#import "DDASLLogger.h"
#import "DDTTYLogger.h"
#import "HYBConstants.h"
#import "HYBCatalogController.h"
#import "HYBBackEndServiceStub.h"
#import "NSObject+HYBAdditionalMethods.h"

SpecBegin(HYBCatalogController)
        describe(@"HYBCatalogController", ^{
            /*
  
            __block HYBCatalogController   *controller;
            __block HYBBackEndServiceStub *backEndStub  = [[HYBBackEndServiceStub alloc] init];

            //init env config
            
           
            it(@"should load the products", ^{
                controller = [[HYBCatalogController alloc] initWithBackEndService:backEndStub];
                [controller loadProducts];
                
                NSArray *products = [controller products];
                expect(products).to.beTruthy();
            });
             
             */
        });
SpecEnd
