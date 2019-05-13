//
// HYBCostCenterSpec.m
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
#import "HYBFileToJsonConverter.h"

SpecBegin(HYBCostCenterSpec)
        describe(@"Cost Center", ^{
        __block HYBCostCenter *costCenter;
        beforeAll(^{
            HYBFileToJsonConverter *conv = [[HYBFileToJsonConverter alloc] init];
            NSArray *costCenters = [conv sampleCostCenters];
            costCenter = [costCenters firstObject];
            expect(costCenter).to.beTruthy();
        });
        it(@"should create new costCenter from json", ^{
            expect(costCenter.name).to.beTruthy();
            expect(costCenter.name).to.equal(@"Custom Retail");
            expect(costCenter.code).to.beTruthy();
            expect(costCenter.code).to.equal(@"Custom Retail");
        });
        it(@"should retrieve the delivery addresses on the cost center", ^{
            expect(costCenter.addresses).to.beTruthy();
            HYBAddress *address = costCenter.addresses.firstObject;
            expect(address).to.beTruthy();
            expect(address.email).to.beTruthy();
            expect(address.formattedAddress).to.beTruthy();
            expect(address.country.isocode).to.beTruthy();
            expect(address.country.name).to.beTruthy();
        });
        it(@"should save the cost center to cache and retrieve it.", ^{
            NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
            
             NSData *encodedObject = [NSKeyedArchiver archivedDataWithRootObject:@[costCenter]];
            [defaults setObject:encodedObject forKey:CURRENT_COST_CENTERS_KEY];
            [defaults synchronize];
            
            NSData *loadedObject = [defaults objectForKey:CURRENT_COST_CENTERS_KEY];
            NSArray *centers = [NSKeyedUnarchiver unarchiveObjectWithData:loadedObject];
            
            HYBCostCenter *center = centers.firstObject;
            expect(center.name).to.beTruthy();
            
            [defaults removeObjectForKey:CURRENT_COST_CENTERS_KEY];
        });
    });
SpecEnd
