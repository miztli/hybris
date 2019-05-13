//
// HYBServiceSpec.m
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

#import <Foundation/Foundation.h>

#import <Specta/Specta.h>
#import <Expecta/Expecta.h>
#import "HYBAppDelegate.h"
#import "HYBB2BService.h"
#import "NSObject+HYBAdditionalMethods.h"
#import <MyEnvironmentConfig/MYEnvironmentConfig.h>
#import "MYEnvironmentConfig+HYBAdditionalMethods.h"


NSString *TEST_USER_NAME = @"axel.krause@rustic-hw.com";
NSString *TEST_PASSWORD = @"12341234";

NSString *TEST_PRODUCT_CODE = @"1979039";

NSString *TEST_SEARCH_TERM = @"shoe";
NSString *TEST_SEARCH_RESULT_SUGGESTED_TERM = @"sheet";

NSString *TEST_ORDER_CODE = @"00002098";
NSString *TEST_STORE_NAME = @"Hybris Powertools Tacoma";

int TEST_PAGE_SIZE_NUMBER = 5;
int TEST_EXPECTED_SEARCH_RESULT_NUMBER = 17;

SpecBegin(HYBService)

describe(@"Products Retrieval", ^{
    __block HYBB2BService *b2bService;
    __block NSString *buildUserId;
    
    beforeAll(^{
        NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
        [NSBundle bundleWithPath:bundlePath];
        
        [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        
        buildUserId = [[MYEnvironmentConfig sharedConfig] buildUserId];
        NSLog(@"Build user id: %@", buildUserId);
        
        
    });
    beforeEach(
               ^{
                   b2bService = [[HYBB2BService alloc] initWithDefaults];
               }
               );
    it(@"should retrieve the products", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getProductsAndExecute:^(NSArray *products, NSError *error) {
                expect([products count] > 0).to.beTruthy();
                expect(error).to.beFalsy();
                done();
            }];
        });
    });
    
    // TODO data dependency present on product containing the search term
    
    it(@"should search for the products by query and show a spelling suggestion", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getProductsByQuery:TEST_SEARCH_TERM andExecute:^(NSArray *products, NSString *spellingSuggestion, NSError *error) {
                expect([products count] > 0).to.beTruthy();
                expect(spellingSuggestion).to.equal(TEST_SEARCH_RESULT_SUGGESTED_TERM);
                expect(error).to.beFalsy();
                done();
            }];
        });
    });
    // TODO data dependency present on product  and the number of this products in the system
    it(@"should search for the products by query and save the pagination results", ^ {
        waitUntil(^(DoneCallback done) {
            b2bService.pageSize = TEST_PAGE_SIZE_NUMBER;
            
            [b2bService getProductsByQuery:TEST_SEARCH_TERM andExecute:^(NSArray *products, NSString *spellingSuggestion, NSError *error) {
                expect([products count]).to.equal(b2bService.pageSize);
                int totalSearchResults = b2bService.totalSearchResults;
                expect(totalSearchResults).to.equal(TEST_EXPECTED_SEARCH_RESULT_NUMBER);
                expect(error).to.beFalsy();
                done();
            }];
        });
    });
    it(@"should retrieve the products in category one", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService resetPagination];
            [b2bService getCategoriesAndExecute:^(NSArray *foundCategories, NSError *error) {
                expect([foundCategories hyb_isNotBlank]).to.beTruthy();
                expect(error).to.beFalsy();
                
                HYBCategoryHierarchy *rootNode = [foundCategories firstObject];
                HYBCategoryHierarchy *childOfRoot = [[rootNode subcategories] lastObject];
                
                [b2bService findProductsByCategoryId:childOfRoot.id andExecute:^(NSArray *products, NSError *error) {
                    expect([products hyb_isNotBlank]).to.beTruthy();
                    done();
                }];
            }];
        });
    });
    it(@"should retrieve a product by id", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getProductsAndExecute:^(NSArray *products, NSError *error) {
                HYBProduct *prod = [products firstObject];
                [b2bService getProductForCode:prod.code andExecute:^(HYBProduct *foundProduct, NSError *error) {
                    expect(foundProduct).to.beTruthy();
                    expect(foundProduct.code).to.equal(prod.code);
                    done();
                }];
            }];
        });
    });
    it(@"should retrieve necessary product attributes", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getProductsAndExecute:^(NSArray *products, NSError *error) {
                HYBProduct *prod = [products firstObject];
                [b2bService getProductForCode:prod.code andExecute:^(HYBProduct *foundProduct, NSError *error) {
                    expect(foundProduct).to.beTruthy();
                    expect(foundProduct.descriptor).to.beTruthy();
                    expect(foundProduct.summary).to.beTruthy();
                    expect(foundProduct.price).to.beTruthy();
                    done();
                }];
            }];
        });
    });
    
    it(@"should create a mock image for an empty given product url", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService loadImageByUrl:nil andExecute:^(UIImage *image, NSError *error) {
                expect(image).to.beTruthy();
                expect(image.size.height).to.beGreaterThan(0);
                expect(error).to.beTruthy();
                done();
            }];
        });
    });
    
    it(@"should load gallery product images", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getProductsAndExecute:^(NSArray *products, NSError *error) {
                HYBProduct *prod = [products firstObject];
                [b2bService getProductForCode:prod.code andExecute:^(HYBProduct *foundProduct, NSError *error) {
                    expect(foundProduct).to.beTruthy();
                    //second step
                    if(foundProduct) {
                        [b2bService loadImagesForProduct:foundProduct andExecute:^(NSArray *images, NSError *error) {
                            DDLogDebug(@"Images count is %lu", (unsigned long)[images count]);
                            expect(images).to.beTruthy();
                            expect(error == nil);
                            done();
                        }];
                    } else {
                        done();
                    }
                }];
            }];
        });
    });
    
    it(@"should retrieve the products in category two", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService resetPagination];
            [b2bService getCategoriesAndExecute:^(NSArray *foundCategories, NSError *error) {
                expect([foundCategories hyb_isNotBlank]).to.beTruthy();
                expect(error).to.beFalsy();
                HYBCategoryHierarchy *root = [foundCategories firstObject];
                expect(root).to.beTruthy;
                expect([root isRoot]).to.beTruthy();
                done();
            }];
        });
    });
});


describe(@"Store Locator", ^{
    __block HYBB2BService *b2bService;
    __block NSString *buildUserId;
    
    beforeAll(^{
        NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
        [NSBundle bundleWithPath:bundlePath];
        
        [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        buildUserId = [[MYEnvironmentConfig sharedConfig] buildUserId];
    });
    beforeEach(^{
        b2bService = [[HYBB2BService alloc] initWithDefaults];
        //b2bService.userDefaults = [[NSUserDefaults alloc] init];
    });
    it(@"should retrieve a list of stores", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getStoresWithParams:nil andExecute:^(NSArray *stores, NSError *error) {
                for(HYBPointOfService *store in stores) {
                    expect(store.name).to.beTruthy();
                    expect(store.geoPoint.longitude).to.beTruthy();
                    expect(store.geoPoint.latitude).to.beTruthy();
                    expect(store.address.formattedAddress).to.beTruthy();
                    done();
                }
            }];
        });
    });
    it(@"should retrieve the details of a store", ^ {
        waitUntil(^(DoneCallback done) {
            [b2bService getStoreDetailWithStoreName:TEST_STORE_NAME andParams:nil andExecute:^(HYBPointOfService *store, NSError *error) {
                expect(store.name).to.beTruthy();
                expect(store.geoPoint.longitude).to.beTruthy();
                expect(store.geoPoint.latitude).to.beTruthy();
                expect(store.address.formattedAddress).to.beTruthy();
                expect(store.address.phone).to.beTruthy();
                expect(store.openingHours).to.beTruthy();
                done();
            }];
        });
    });
});

describe(@"Order History", ^{
    __block HYBB2BService *b2bService;
    __block NSString *buildUserId;
    
    beforeAll(^{
        NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
        [NSBundle bundleWithPath:bundlePath];
        
        [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        buildUserId = [[MYEnvironmentConfig sharedConfig] buildUserId];
        
    });
    beforeEach(^{
        b2bService = [[HYBB2BService alloc] initWithDefaults];
    });
    it(@"should retrieve a list of orders", ^ {
        waitUntil(^(DoneCallback done) {
            
            [b2bService logoutCurrentUser];
            
            [b2bService authenticateUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *msg, NSError *error) {
                
                expect(msg).to.equal(NSLocalizedString(@"login_success", nil));
                expect(error).to.beFalsy();
                
                [b2bService retrieveOrdersForUser:buildUserId withParams:[NSDictionary dictionary] andExecute:^(NSArray *orders, NSError *error) {
                    for(HYBOrderHistory *order in orders) {
                        expect(order.code).to.beTruthy;
                        expect(order.placed).to.beTruthy;
                        expect(order.statusDisplay).to.beTruthy;
                        expect(order.total.formattedValue).to.beTruthy;
                        expect(order.total.value).to.beTruthy;
                    }
                }];
                done();
            }];
        });
    });
    it(@"should retrieve an order by id", ^ {
        waitUntil(^(DoneCallback done) {
            
            [b2bService authenticateUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *msg, NSError *error) {
                
                expect(msg).to.equal(NSLocalizedString(@"login_success", nil));
                expect(error).to.beFalsy();
                
                [b2bService findOrderByCode:TEST_ORDER_CODE andExecute:^(HYBOrder *order, NSError *error) {
                    expect(order.code).to.beTruthy;
                    expect(order.created).to.beTruthy;
                    expect(order.statusDisplay).to.beTruthy;
                    expect(order.totalPrice.formattedValue).to.beTruthy;
                    expect(order.totalPrice.value).to.beTruthy;
                    expect(order.totalTax.value).to.beTruthy;
                }];
                done();
            }];
        });
    });
});

describe(@"Authentication", ^{
    __block NSString *buildUserId;
    
    beforeAll(^{
        NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
        [NSBundle bundleWithPath:bundlePath];
        
        [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        buildUserId = [[MYEnvironmentConfig sharedConfig] buildUserId];
    });
    // TODO data dependency present on specific user
    it(@"should authenticate the user successfully", ^ {
        waitUntil(^(DoneCallback done) {
            HYBB2BService *b2bService = [[HYBB2BService alloc] initWithDefaults];
            
            [b2bService authenticateUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *msg, NSError *error) {
                expect(msg).to.equal(NSLocalizedString(@"login_success", nil));
                expect(error).to.beFalsy();
                done();
            }];
        });
    });
    it(@"should not authenticate the user at failure", ^ {
        waitUntil(^(DoneCallback done) {
            HYBB2BService *b2bService = [[HYBB2BService alloc] initWithDefaults];
            [b2bService logoutCurrentUser];
            
            [b2bService authenticateUsername:buildUserId withPassword:@"wrongPasswordForAuth" andExecute:^(NSString *msg, NSError *error) {
                
                expect(msg).to.equal(NSLocalizedString(@"login_failed_wrong_credentials", nil));
                expect(error).to.beTruthy();
                done();
            }];
        });
    });
    it(@"should obtain the token for user failure", ^ {
        waitUntil(^(DoneCallback done) {
            HYBB2BService *b2bService = [[HYBB2BService alloc] initWithDefaults];
            [b2bService logoutCurrentUser];
            
            [b2bService retrieveTokenForUsername:buildUserId
                                    withPassword:@"wrongPasswordForTokenRetrieval"
                                      andExecute:^(NSString *messageOrToken, NSError *error) {
                                          NSString *expected = NSLocalizedString(@"login_failed_checkcredentials_or_user_rights", nil);
                                          expect(messageOrToken).to.equal(expected);
                                          done();
                                      }];
        });
    });
    it(@"should recognize not expired token", ^ {
        waitUntil(^(DoneCallback done) {
            HYBB2BService *b2bService = [[HYBB2BService alloc] initWithDefaults];
            
            NSNumber *millisecondsToExpire = @10000;
            double secondsToExpire = millisecondsToExpire.doubleValue / 1000;
            NSDate *expirationTime = [[NSDate alloc] initWithTimeIntervalSinceNow:secondsToExpire];
            NSDictionary *resposeValues = @{EXPIRATION_TIME_KEY : expirationTime};
            
            BOOL result = [b2bService isSessionExpired:resposeValues];
            expect(result).to.beFalsy();
            [b2bService logoutCurrentUser];
            done();
        });
    });
    // TODO data dependency present on specific user
    it(@"should obtain the token for user success and save it to properties", ^ {
        waitUntil(^(DoneCallback done) {
            NSUserDefaults *userDefaults = [[NSUserDefaults alloc] init];
            HYBB2BService *b2bService = [[HYBB2BService alloc] initWithDefaults];
            //b2bService.userDefaults = userDefaults;
            
            NSDate *now = [[NSDate alloc] initWithTimeIntervalSinceNow:0];
            
            [b2bService retrieveTokenForUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *messageOrToken, NSError *error) {
                expect(messageOrToken).to.beTruthy();
                expect(error).to.beFalsy();
                
                NSDictionary *tokenData = [userDefaults objectForKey:buildUserId];
                expect(tokenData).to.beTruthy();
                expect([tokenData objectForKey:EXPIRATION_TIME_KEY]).to.beTruthy();
                
                // reconfigure the expiration time to be much shorter, for the next test
                NSMutableDictionary *newTokenData = [[NSMutableDictionary alloc] initWithDictionary:tokenData];
                [newTokenData setObject:now forKey:EXPIRATION_TIME_KEY];
                [userDefaults setObject:newTokenData forKey:buildUserId];
                
                // now reuse the previously saved token doing a refresh
                [b2bService retrieveTokenForUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *messageOrToken, NSError *error) {
                    expect(error).to.beFalsy();
                    expect(messageOrToken).to.beTruthy();
                    
                    NSDictionary *tokenData = [userDefaults objectForKey:buildUserId];
                    expect(tokenData).to.beTruthy();
                    expect([tokenData objectForKey:EXPIRATION_TIME_KEY] != now).to.beTruthy();
                    
                    [b2bService logoutCurrentUser];
                    
                    done();
                }];
            }];
        });
    });
    
    //trusted client
    
    it(@"should successfully authenticate the user as a trusted client", ^ {
        waitUntil(^(DoneCallback done) {
            HYBB2BService *b2bService = [[HYBB2BService alloc] initWithDefaults];
            
            [b2bService makeUserTrustedClientAndExecute:^(NSString *msg, NSError *error) {
                expect(msg).to.beTruthy();
                expect(error).to.beFalsy();
                done();
            }];
        });
    });
});

describe(@"Cart Management", ^{
    __block HYBB2BService *backEndService;
    __block NSString *buildUserId;
    
    NSLog(@"Cart Management");
    
    beforeAll(^{
        NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
        [NSBundle bundleWithPath:bundlePath];
        
        backEndService = [[HYBB2BService alloc] initWithDefaults];
        //backEndService.userDefaults = [[NSUserDefaults alloc] init];
        
        [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        buildUserId = [[MYEnvironmentConfig sharedConfig] buildUserId];
    });
    // TODO data dependency present, expected are cost centers, payment types and address setup
    it(@"full checkout workflow", ^ {
        waitUntil(^(DoneCallback done) {
            
            NSLog(@"authenticateUser");
            
            [backEndService authenticateUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *msg, NSError *error) {
                
                expect(msg).to.equal(NSLocalizedString(@"login_success", nil));
                expect(error).to.beFalsy();
                
                NSLog(@"retrieveCurrentCartAndExecute");
                
                [backEndService retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
                    expect(cart).to.beTruthy();
                    
                    NSLog(@"addProductToCurrentCart");
                    
                    [backEndService addProductToCurrentCart:TEST_PRODUCT_CODE amount:@5 andExecute:^(HYBCart *cart, id successMsg) {
                        expect(cart).to.beTruthy();
                        
                        NSLog(@"updateProductOnCurrentCartAmount");
                        
                        [backEndService updateProductOnCurrentCartAmount:@"0" mount:@3 andExecute:^(HYBCart *cart, NSError *error) {
                            expect(cart).to.beTruthy();
                            
                            NSLog(@"setPaymentType");
                            
                            [backEndService setPaymentType:CART_PAYMENTTYPE_ACCOUNT onCartWithCode:cart.code andExecute:^(HYBCart *cart, NSError *successMsg) {
                                
                                NSLog(@"costCentersForCurrentStoreAndExecute");
                                
                                [backEndService getCostcentersAndExecute:^(NSArray *costCenter, NSError *err) {
                                    expect(costCenter.count > 0).to.beTruthy();
                                    
                                    HYBCostCenter *center = costCenter.firstObject;
                                    expect(center).to.beTruthy();
                                    
                                    NSLog(@"setCostCenterWithCode");
                                    
                                    [backEndService updateCartCostCenterWithCode:center.code onCartWithCode:cart.code andExecute:^(HYBCart *cart, NSError *error) {
                                        expect(error).to.beFalsy();
                                        expect(cart.code).to.beTruthy();
                                        
                                        HYBAddress *addr = center.addresses.firstObject;
                                        expect(addr).to.beTruthy();
                                        
                                        NSLog(@"setDeliveryAddressWithCode");
                                        
                                        [backEndService setDeliveryAddressWithCode:addr.id onCartWithCode:cart.code andExecute:^(HYBCart *cart, NSError *error) {
                                            expect(error).to.beFalsy();
                                            expect(cart).to.beTruthy();
                                            expect(cart.code).to.beTruthy();
                                            
                                            NSLog(@"getDeliveryModesForCart");
                                            
                                            [backEndService getDeliveryModesForCart:cart.code andExecute:^(NSArray *modes, NSError *error) {
                                                expect(cart).to.beTruthy();
                                                expect(cart.code).to.beTruthy();
                                                expect(error).to.beFalsy();
                                                expect(modes.count > 0).to.beTruthy();
                                                HYBDeliveryMode *mode = modes.firstObject;
                                                
                                                NSLog(@"setDeliveryModeWithCode");
                                                
                                                [backEndService setDeliveryModeWithCode:mode.code onCartWithCode:cart.code andExecute:^(HYBCart *cart, NSError *error) {
                                                    expect(error).to.beFalsy();
                                                    expect(cart).to.beTruthy();
                                                    expect(cart.code).to.beTruthy();
                                                    
                                                    NSLog(@"placeOrderWithCart");
                                                    
                                                    [backEndService placeOrderWithCart:cart andExecute:^(HYBOrder *order, NSError *error) {
                                                        expect(error).to.beFalsy();
                                                        expect(order.code).to.beTruthy();
                                                        
                                                        NSLog(@"findOrderByCode");
                                                        
                                                        [backEndService findOrderByCode:order.code andExecute:^(HYBOrder *order, NSError *error) {
                                                            HYBAddress *deliveryAddr = order.deliveryAddress;
                                                            HYBDeliveryMode *mode = order.deliveryMode;
                                                            
                                                            expect(deliveryAddr.formattedAddress).to.beTruthy();
                                                            expect(mode.name).to.beTruthy();
                                                            
                                                            done();
                                                        }];
                                                    }];
                                                }];
                                            }];
                                        }];
                                    }];
                                }];
                            }];
                        }];
                    }];
                }];
            }];
        });
    });
});

describe(@"Multiple add products", ^{
    __block HYBB2BService *backEndService;
    __block NSString *buildUserId;
    
    NSLog(@"Multiple add products");
    
    beforeAll(^{
        NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
        [NSBundle bundleWithPath:bundlePath];
        
        backEndService = [[HYBB2BService alloc] initWithDefaults];
        //backEndService.userDefaults = [[NSUserDefaults alloc] init];
        
        [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
        buildUserId = [[MYEnvironmentConfig sharedConfig] buildUserId];
        
    });
    
    it(@"rapidly add the same product multiple time", ^ {
        waitUntil(^(DoneCallback done) {
            
            NSLog(@"authenticateUser");
            [backEndService logoutCurrentUser];
            
            [backEndService authenticateUsername:buildUserId withPassword:TEST_PASSWORD andExecute:^(NSString *msg, NSError *error) {
                
                expect(msg).to.equal(NSLocalizedString(@"login_success", nil));
                expect(error).to.beFalsy();
                
                double delayInSeconds = 1.0;
                dispatch_queue_t testQueue = dispatch_queue_create("testQueue", nil);
                dispatch_time_t popTime = dispatch_time(DISPATCH_TIME_NOW, delayInSeconds * NSEC_PER_SEC);
                dispatch_after(popTime, testQueue, ^(void) {
                    
                    NSLog(@"retrieveCurrentCartAndExecute");
                    
                    [backEndService retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
                        expect(cart).to.beTruthy();
                        
                        int initialCount = [cart.totalUnitCount intValue];
                        NSLog(@"+++ initialCount: %d +++",initialCount);

                        __block int count = 0;
                        __block int maxCount = 5;
                        
                        __block NSTimer *timer = [NSTimer scheduledTimerWithTimeInterval:0.3
                                                                                  target:[NSBlockOperation blockOperationWithBlock:^{
                            
                            if (++count > maxCount) {
                                [timer invalidate];
                                timer = nil;
                                
                                NSLog(@"delayed verification ");
                                
                                //delayed verification (wait for late callbacks)
                                double verificationDelayInSeconds = 2.0;
                                dispatch_queue_t doneQueue = dispatch_queue_create("doneQueue", nil);
                                dispatch_time_t secondPopTime = dispatch_time(DISPATCH_TIME_NOW, verificationDelayInSeconds * NSEC_PER_SEC);
                                
                                dispatch_after(secondPopTime, doneQueue, ^(void) {
                                    [backEndService retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
                                        expect(cart).to.beTruthy();
                                        NSLog(@"delayed verification DONE");
                                        int finalCount = [cart.totalUnitCount intValue];
                                        NSLog(@"+++ finalCount: %d +++",finalCount);
                                        expect(maxCount+initialCount).to.equal(finalCount);
                                        done();
                                    }];
                                });
                                
                            } else {
                                NSLog(@"addProductToCurrentCart");
                                
                                [backEndService addProductToCurrentCart:TEST_PRODUCT_CODE amount:@1 andExecute:^(HYBCart *cart, id successMsg) {
                                    expect(error).to.beFalsy();
                                }];
                            }
                            
                        }]
                                                                                selector:@selector(main)
                                                                                userInfo:nil
                                                                                 repeats:YES];
                        
                    }];
                });
            }];
        });
    });
});

/*
 describe(@"Basic Rest-WS Features", ^{
 
 NSLog(@"Basic Rest-WS Features");
 
 __block HYBB2BService *b2bService;
 
 beforeAll(^{
 NSString *bundlePath = [[NSBundle bundleForClass:[self class]] resourcePath];
 [NSBundle bundleWithPath:bundlePath];
 
 [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
 });
 
 beforeEach(^{
 b2bService = [[HYBB2BService alloc] initWithDefaults];
 b2bService.userDefaults = [[NSUserDefaults alloc] init];
 
 });
 it(@"should the proper error message from the web service response in error case", ^AsyncBlock {
 
 NSString *url = [[NSString alloc] initWithFormat:@"%@/%@/catalogs/%@/%@/categories/%@", [b2bService restUrlPrefix],
 [b2bService currentStoreId], [b2bService currentCatalogId], [b2bService currentCatalogVersion], [b2bService rootCategoryId]];
 
 [b2bService callHTTPMethod:@"GET"
 url:url
 params:nil
 headers:nil
 success:^(AFHTTPRequestOperation *operation, id responseObject) {
 
 NSLog(@"Basic Rest-WS Features GET result success");
 
 expect(responseObject).to.beTruthy();
 responseObject = (NSDictionary*)responseObject;
 expect(responseObject[@"pageSize"]).to.beTruthy();
 expect(responseObject[@"id"]).to.beTruthy();
 expect(responseObject[@"numberOfPages"]).to.beTruthy();
 expect(responseObject[@"subcategories"]).to.beTruthy();
 expect(responseObject[@"totalNumber"]).to.beTruthy();
 expect(responseObject[@"type"]).to.beTruthy();
 expect(responseObject[@"name"]).to.beTruthy();
 expect(responseObject[@"url"]).to.beTruthy();
 done();
 }
 
 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
 
 NSLog(@"Basic Rest-WS Features GET result failure");
 
 expect(error).to.beTruthy();
 done();
 }];
 
 });
 it(@"should support urls with port", ^{
 
 NSLog(@"should support urls with port");
 
 NSDictionary *config = [[MYEnvironmentConfig sharedConfig] configValues];
 NSString *host = [config objectForKey:HOST_ATTRIBUTE_KEY];
 NSString *port = [config objectForKey:PORT_ATTRIBUTE_KEY];
 
 expect(b2bService.baseStoreUrl).to.contain(host);
 if (port) expect(b2bService.baseStoreUrl).to.contain(port);
 
 });
 });
 */

SpecEnd

