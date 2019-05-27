#import "HYBCart.h"//
// HYBCartControllerSpec.m
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
#import "HYBCategory.h"
#import "HYBCatalogMenuController.h"
#import "HYBB2BService.h"
#import "DDASLLogger.h"
#import "DDTTYLogger.h"
#import "HYBConstants.h"
#import "HYBCartController.h"
#import "HYBCart.h"
#import "HYBCartView.h"
#import "HYBCartItemCellView.h"
#import "HYBB2BService.h"
#import "HYBBackEndServiceStub.h"
#import "Specta.h"

SpecBegin(HYBCartController)
        describe(@"HYBCartController", ^{
            __block HYBCart *cart;
            __block HYBCartController *controller;
            __block HYBB2BService *backEndServiceStub;

            beforeAll(^{
                backEndServiceStub = [[HYBB2BService alloc] init];
                cart = backEndServiceStub.currentCartFromCache;
            });
            beforeEach(^{
                controller = [[HYBCartController alloc] initWithBackEndService:backEndServiceStub];
                expect(controller).to.beTruthy();
            });
            it(@"should load a cart and render it in the view", ^{
                [controller viewDidLoad];

                HYBCartView *view = (HYBCartView*)controller.view;
                expect(view).to.beTruthy();

                expect(view.cartTotalNumber).to.beTruthy();
                //expect(view.cartTotalNumber.text).to.equal(cart.totalPriceFormatted);
            });
        });
SpecEnd
