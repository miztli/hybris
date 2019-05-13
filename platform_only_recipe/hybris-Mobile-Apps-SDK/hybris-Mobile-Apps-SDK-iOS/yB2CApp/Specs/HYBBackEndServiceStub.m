//
// HYBBackEndServiceStub.m
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

#import "HYBBackEndServiceStub.h"
#import "HYBCategory.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBCart.h"
#import "HYBFileToJsonConverter.h"
#import "HYBDeliveryMode.h"

@implementation HYBBackEndServiceStub {
    HYBFileToJsonConverter *converter;

    HYBCategory *catRoot;
    HYBCart *cart;
    HYBProduct *product;
    HYBOrder *order;
    HYBPointOfService *store;
    
    NSArray *stores;
    NSArray *orders;
    NSArray *products;
    NSArray *productImages;
    NSArray *deliveryModes;

    int pageOffset;
    int pageSize;
}

@synthesize pageOffset;

@synthesize pageSize;

@synthesize deliveryModes;

- (id)init {
    
    if(self = [super initWithDefaults]) {
        self.userDefaults = [NSUserDefaults standardUserDefaults];
        
        pageOffset = 0;
        pageSize = 20;
        
        converter   = [[HYBFileToJsonConverter alloc] init];
        
        catRoot     = [converter sampleCategoryTree];
        cart        = [converter sampleCart];
        
        products    = [converter sampleProductList];
        product     = [converter sampleProduct];
        
        orders      = [converter sampleOrderList];
        order       = [converter sampleOrder];
        
        stores      = [converter sampleStores];
        store       = [converter sampleStore];
        
        productImages = @[[UIImage imageNamed:HYB2BImageDummy],
                          [UIImage imageNamed:HYB2BImageDummy],
                          [UIImage imageNamed:HYB2BImageDummy],
                          [UIImage imageNamed:HYB2BImageDummy]];
        
        HYBDeliveryMode *mode = [[HYBDeliveryMode alloc] init];
        deliveryModes = @[mode];
    }
    return self;
}

- (void)findCategoriesWithBlock:(void (^)(NSArray *, NSError *))block {
    block(@[catRoot], nil);
}

- (void)findProductsByCategoryId:(NSString *)categoryId withBlock:(void (^)(NSArray *foundCategories, NSError *error))block {
    block(products, nil);
}

- (void)findOrderByCode:(NSString *)code andExecute:(void (^)(HYBOrder *, NSError *))block {
    block(order,nil);
}

- (void)retrieveOrdersForUser:(NSString *)userId withParams:(NSDictionary*)params andExecute:(void (^)(NSArray *, NSError *))block {
    block(orders, nil);
}

- (void)getStoreDetailWithStoreName:(NSString*)rawStoreName andParams:(NSDictionary*)params andExecute:(void (^)(HYBPointOfService *, NSError *))block {
    block(store, nil);
}

- (void)getStoresWithParams:(NSDictionary *)params andExecute:(void (^)(NSArray *, NSError *))block {
    block(stores, nil);
}

- (void)retrieveCurrentCartAndExecute:(void (^)(HYBCart *, NSError *))block {
    block(cart, nil);
}

- (NSUserDefaults *)userStorage {
    return self.userDefaults;
}

- (HYBCart *)currentCartFromCache {
    return cart;
}

- (void)loadImageByUrl:(NSString *)url andExecute:(void (^)(UIImage *, NSError *))block {
    block([UIImage imageNamed:HYB2BImageDummy], nil);
}

- (void)getProductsAndExecute:(void (^)(NSArray *, NSError *))block {
    block(products, nil);
}

- (void)getProductForCode:(NSString *)productId andExecute:(void (^)(id, NSError *))block {
    block(product, nil);
}

- (void)loadImagesForProduct:(HYBProduct *)product1 block:(void (^)(NSArray *images, NSError *error))block {
    block(productImages, nil);
}

- (void)resetPagination {
    pageOffset = 0;
}

- (void)nextPage {
    pageOffset++;
}

- (void)setPaymentType:(NSString *)paymentType onCartWithCode:(NSString *)code execute:(void (^)(HYBCart *, NSError *))block {
    block(cart, nil);
}

- (void)updateCartCostCenterWithCode:(NSString *)costCenterCode onCartWithCode:(NSString *)cartCode andExecute:(void (^)(HYBCart *, NSError *))block {
    block(cart, nil);
}

- (void)setDeliveryAddressWithCode:(NSString *)addressId onCartWithCode:(NSString *)cartCode andExecute:(void (^)(HYBCart *, NSError *))block {
    block(cart, nil);
}

- (void)getDeliveryModesForCart:(NSString *)cartCode andExecute:(void (^)(NSArray *, NSError *))block {
   block(deliveryModes, nil);
}

- (void)setDeliveryModeWithCode:(NSString *)modeCode onCartWithCode:(NSString *)cartCode andExecute:(void (^)(HYBCart *, NSError *))block {
    block(cart, nil);
}


@end