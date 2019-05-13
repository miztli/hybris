//
// HYBCategoryHierarchySpec.m
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
#import <Specta/Specta.h>
#import "HYBB2BService.h"

SpecBegin(HYBCategoryHierarchy)
    describe(@"HYBCategoryHierarchy", ^{
        __block NSDictionary *json;
        __block HYBCategoryHierarchy *category;

        beforeAll(^{
            NSString *filePath = [[NSBundle bundleForClass:[self class]] pathForResource:@"categoriesSampleResponse" ofType:@"json"];
            NSData *data = [NSData dataWithContentsOfFile:filePath];
            json = (NSDictionary *)[NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
            
            category = [HYBCategoryHierarchy categoryHierarchyWithParams:json];
            if (category) [category assignParent];
            
            expect(category).to.beTruthy();
            expect([category hasSubcategories]).to.beTruthy();
            
        });
       
        it(@"should create a category tree from json", ^{
            NSDictionary *attr = [[json objectForKey:@"subcategories"] firstObject];

            HYBCategoryHierarchy *secondCategory = [HYBCategoryHierarchy categoryHierarchyWithParams:attr];
            if (secondCategory) [secondCategory assignParent];
            
            expect(secondCategory.name).to.beTruthy();
            expect(secondCategory.id).to.beTruthy();
            expect(secondCategory.url).to.beTruthy();
        });
        
        it(@"should create and recognize the root category", ^{
            expect(category.name).to.equal([json objectForKey:@"name"]);
            expect(category.id).to.equal([json objectForKey:@"id"]);
            expect([category.subcategories count] > 0).to.beTruthy();
            expect([category isRoot]).to.beTruthy();
            expect([category isLeaf]).to.beFalsy();
        });
        
        it(@"should create subcategories", ^{
            HYBCategoryHierarchy *firstSubCat  = [category.subcategories firstObject];
            HYBCategoryHierarchy *lastSubCat   = [category.subcategories lastObject];

            expect(firstSubCat).to.beTruthy();
            expect([firstSubCat isLeaf]).to.beFalsy();
            expect(lastSubCat).to.beTruthy();
            expect([lastSubCat isLeaf]).to.beFalsy();
        });
        
        it(@"should find a category in tree by id", ^{
            HYBCategoryHierarchy *firstSubCat = [category.subcategories firstObject];
            HYBCategoryHierarchy *firstChildSubcat = [firstSubCat.subcategories firstObject];
            expect(firstChildSubcat).to.beTruthy();
            HYBCategoryHierarchy *foundCat = [category findCategoryByIdInsideTree:firstChildSubcat.id];
            expect(foundCat).to.equal(firstChildSubcat);
        });

        it(@"should link any category to its parent", ^{
            
            HYBCategoryHierarchy *firstSubCat = [category.subcategories firstObject];
            HYBCategoryHierarchy *firstChildSubcat = [firstSubCat.subcategories firstObject];
            
            expect([firstChildSubcat parentCategory]).to.equal(firstSubCat);
            
            expect([firstSubCat parentCategory]).to.equal(category);
        });
        
    });
SpecEnd
