//
// HYBAppDelegateSpec.m
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
#import <Expecta/Expecta.h>
#import "MYEnvironmentConfig.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBAppDelegate.h"
#import "HYBB2CService.h"
#import "Specta.h"

SpecBegin(HYBAppDelegate)
    describe(@"HYBAppDelegate", ^{
        __block HYBAppDelegate *delegate;

        beforeAll(^{
            delegate = [[HYBAppDelegate alloc] init];
            
            //init env config
            [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        });
        it(@"should create app delegate", ^{
            expect(delegate).to.beTruthy();
        });
        it(@"should confgure app from environment settgins", ^{
            NSDictionary *config = [[MYEnvironmentConfig sharedConfig] configValues];
         
            expect([config[@"CURRENT_CATALOG_ATTRIBUTE_KEY"] hyb_isNotBlank]).to.beTruthy();
            expect([config[@"CURRENT_CATALOG_VERSION_ATTRIBUTE_KEY"] hyb_isNotBlank]).to.beTruthy();
            expect([config[@"HOST_ATTRIBUTE_KEY"] hyb_isNotBlank]).to.beTruthy();
            expect([config[@"PORT_ATTRIBUTE_KEY"] hyb_isNotBlank]).to.beTruthy();
            expect([config[@"CURRENT_STORE_ATTRIBUTE_KEY"] hyb_isNotBlank]).to.beTruthy();
            expect([config[@"defaultTestUser"] hyb_isNotBlank]).to.beTruthy();
        });
    });
SpecEnd
