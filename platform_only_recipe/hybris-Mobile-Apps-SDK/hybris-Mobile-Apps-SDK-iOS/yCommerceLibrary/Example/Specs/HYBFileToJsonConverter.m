//
// HYBFileToJsonConverter.m
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

#import "HYBFileToJsonConverter.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBB2BService.h"

NSString *sampleURL = @"http://random.com";

@implementation HYBFileToJsonConverter

- (NSArray *) sampleOrders {
    return [self createOrdersFromJsonFile:@"getOrdersSampleResponse"];
}

- (HYBOrder *)sampleOrder {
    NSDictionary *fullJSON = [self jsonAsDictionary:@"getOrderByIdAllFieldsSampleResponse"];
    HYBOrder *order = [MTLJSONAdapter modelOfClass:[HYBOrder class] fromJSONDictionary:fullJSON error:nil];
    return order;
}

- (NSArray *)createOrdersFromJsonFile:(NSString *)jsonFileName {
    NSDictionary *fullJSON = [self jsonAsDictionary:jsonFileName];
    NSArray *ordersAsJSON = [fullJSON valueForKeyPath:@"orders"];
    NSMutableArray *result = [NSMutableArray array];
    for(NSDictionary *obj in ordersAsJSON) {
        HYBOrder *order = [MTLJSONAdapter modelOfClass:[HYBOrder class] fromJSONDictionary:obj error:nil];
        [result addObject:order];
    }
    NSAssert([result hyb_isNotBlank], @"Orders must exist.");
    HYBOrder *o = [result firstObject];
    NSAssert([o hyb_isNotBlank], @"Each order must exist.");
    NSAssert([[o code] hyb_isNotBlank], @"Each product must exist.");
    return result;
}

- (HYBPointOfService *)sampleStore {
    NSDictionary *json = [self jsonAsDictionary:@"getStoreDetailsSampleResponse"];
    return [MTLJSONAdapter modelOfClass:[HYBPointOfService class] fromJSONDictionary:json error:nil];
}

- (NSArray *)sampleStoreList {
    NSDictionary *fullJSON = [self jsonAsDictionary:@"getStoresSampleResponse"];
    NSArray *productsAsJSON = [fullJSON valueForKeyPath:@"stores"];
    NSMutableArray *result = [[NSMutableArray alloc] initWithCapacity:[productsAsJSON count]];
    for(NSDictionary *json in productsAsJSON) {
        HYBPointOfService *store = [MTLJSONAdapter modelOfClass:[HYBPointOfService class] fromJSONDictionary:json error:nil];
        [result addObject:store];
    }
    NSAssert([result hyb_isNotBlank], @"Stores must exist.");
    HYBPointOfService *s = [result firstObject];
    NSAssert([s hyb_isNotBlank], @"Each HYBPointOfService must exist.");
    NSAssert([[s name] hyb_isNotBlank], @"Each HYBPointOfService name must exist.");
    return result;
}

- (NSArray *)sampleProductList{
    return [self createProductsFromJsonFile:@"productListSampleResponse"];
}

- (HYBCategoryHierarchy *)sampleCategoryTree {
    return [self createCategoryTreeFromJsonFile:@"categoriesSampleResponse"];
}

- (HYBCart *)sampleCart {
    return [self createCartFromJsonFile:@"presentCartSampleResponse"];
}

- (HYBProduct *)sampleProduct {
    NSDictionary *json = [self jsonAsDictionary:@"productByIdSampleResponse"];
    HYBProduct *result = [HYBProduct productWithParams:json];
    NSAssert([result hyb_isNotBlank], @"Product must be present.");
    return result;
}

- (NSArray *)createProductsFromJsonFile:(NSString *)jsonFileName {
    NSDictionary *fullJSON = [self jsonAsDictionary:jsonFileName];
    NSArray *productsAsJSON = [fullJSON valueForKeyPath:@"products"];
    NSMutableArray *result = [[NSMutableArray alloc] initWithCapacity:[productsAsJSON count]];
    for(NSDictionary *obj in productsAsJSON) {
        HYBProduct *product = [HYBProduct productWithParams:obj];
        [result addObject:product];
    }
    NSAssert([result hyb_isNotBlank], @"Products must exist.");
    HYBProduct *p = [result firstObject];
    NSAssert([p hyb_isNotBlank], @"Each product must exist.");
    NSAssert([[p code] hyb_isNotBlank], @"Each product must exist.");
    return result;
}

- (HYBCategoryHierarchy *)createCategoryTreeFromJsonFile:(NSString *)jsonFileName {
    HYBCategoryHierarchy *result  = [HYBCategoryHierarchy categoryHierarchyWithParams:[self jsonAsDictionary:jsonFileName]];
    if (result) [result assignParent];
    NSAssert([result hyb_isNotBlank], @"Categories root must be present in stub");
    NSAssert([[result subcategories] hyb_isNotBlank], @"Subcategories must be present in stub");
    return result;
}

- (HYBCart *)createCartFromJsonFile:(NSString *)jsonFileName {
    HYBCart *result = [HYBCart cartWithParams:[self jsonAsDictionary:jsonFileName]];
    [result assignPromotions];
    NSAssert([jsonFileName hyb_isNotBlank], @"Cart must exist");
    return result;
}

#pragma mark
- (NSDictionary *)jsonAsDictionary:(NSString *)fileName {
    NSData *jsonData = [self dataFromJson:fileName];
    NSDictionary *jsonDict = [NSJSONSerialization JSONObjectWithData:jsonData options:kNilOptions error:nil];
    return jsonDict;
}

- (NSData *)dataFromJson:(NSString *)jsonFileName {
    NSString *fullFilePath = [[NSBundle bundleForClass:[self class]] pathForResource:jsonFileName ofType:@"json"];
    NSData *jsonData = [NSData dataWithContentsOfFile:fullFilePath];
    return jsonData;
}

- (NSArray *)sampleCostCenters {
    NSDictionary *json = [self jsonAsDictionary:@"costCentersSampleResponse"];
    NSDictionary *params = [[json objectForKey:@"costCenters"] firstObject];
    return @[[MTLJSONAdapter modelOfClass:[HYBCostCenter class] fromJSONDictionary:params error:nil]];
}
@end