//
// HYBStoreSpec.m
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
#import <BlocksKit.h>
#import <Expecta/Expecta.h>
#import <CocoaLumberjack/DDTTYLogger.h>
#import <CocoaLumberjack/DDASLLogger.h>
#import <RMMapper/NSUserDefaults+RMSaveCustomObject.h>
#import "HYBStore.h"
#import "HYB2BService.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBFileToJsonConverter.h"

SpecBegin(HYBStoreSpec)
describe(@"Stores", ^{
   
    __block NSArray *stores;
    __block HYBStore *store;
    
    beforeAll(^{
        HYBFileToJsonConverter *conv = [[HYBFileToJsonConverter alloc] init];
        stores  = [conv sampleStoreList];
        store   = [conv sampleStore];
        expect(stores).to.beTruthy();
        expect(store).to.beTruthy();
    });
    it(@"should have a full details store", ^{
        expect(store.name).to.beTruthy();
        expect(store.name).to.equal(@"Hybris Powertools Tacoma");
        expect(store.longitude).to.beTruthy();
        expect(store.longitude).to.equal(74.0059);
        expect(store.latitude).to.beTruthy();
        expect(store.latitude).to.equal(40.7127);
        expect(store.formattedAddress).to.beTruthy();
        expect(store.formattedAddress).to.equal(@"6TH AVE, 5401, Washington, Tacoma, 98406");
        expect(store.phone).to.beTruthy();
        expect(store.phone).to.equal(@"(253) 777-5555");
        expect(store.openingHours).to.beTruthy();
    });
    it(@"should have a list of geolocated stores", ^{
        [stores bk_each:^(HYBStore *store) {
            expect(store.name).to.beTruthy();
            expect(store.longitude).to.beTruthy();
            expect(store.latitude).to.beTruthy();
            expect(store.formattedAddress).to.beTruthy();
        }];
    });
    
});
SpecEnd

