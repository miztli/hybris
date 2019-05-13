//
//  HYBB2CService.m
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

#import "HYBB2CService.h"
#import "MYEnvironmentConfig.h"
#import "NSObject+HYBAdditionalMethods.h"

@implementation HYBB2CService

- (instancetype)initWithDefaults {
    
    NSDictionary *config = [[MYEnvironmentConfig sharedConfig] configValues];
    
    NSMutableDictionary *tmpParams = [NSMutableDictionary dictionary];
    
    [tmpParams setObject:[NSNumber numberWithBool:YES] forKey:USESSL];
    [tmpParams setObject:@"v2" forKey:OCCVERSION];
    
    if(config[@"CURRENT_CATALOG_ATTRIBUTE_KEY"])        [tmpParams setObject:config[@"CURRENT_CATALOG_ATTRIBUTE_KEY"]           forKey:CATALOGID];
    if(config[@"CURRENT_CATALOG_VERSION_ATTRIBUTE_KEY"])[tmpParams setObject:config[@"CURRENT_CATALOG_VERSION_ATTRIBUTE_KEY"]   forKey:CATALOGVERSIONID];
    if(config[@"CURRENT_ROOT_CATEGORY_KEY"])        [tmpParams setObject:config[@"CURRENT_ROOT_CATEGORY_KEY"]           forKey:ROOTCATEGORYID];
    
    if(config[@"HOST_ATTRIBUTE_KEY"])                   [tmpParams setObject:config[@"HOST_ATTRIBUTE_KEY"]                      forKey:BACKENDHOST];
    if(config[@"PORT_ATTRIBUTE_KEY"])                   [tmpParams setObject:config[@"PORT_ATTRIBUTE_KEY"]                      forKey:BACKENDPORT];
    if(config[@"CURRENT_STORE_ATTRIBUTE_KEY"])          [tmpParams setObject:config[@"CURRENT_STORE_ATTRIBUTE_KEY"]             forKey:STOREID];
    if(config[@"defaultTestUser"])                      [tmpParams setObject:config[@"defaultTestUser"]                         forKey:USERID];
    
    NSDictionary *params = [NSDictionary dictionaryWithDictionary:tmpParams];
    
    if(self = [super initWithParams:params]) {
        
    }
    
    return self;
}

- (BOOL)isUserLoggedIn {
    return !([self.userId isEqualToString:GUEST_USER]);
}


- (void)loadImageByUrl:(NSString *)url
                 andExecute:(void (^)(UIImage *, NSError *))block {
        
    //DDLogDebug(@"Loading full image for url %@", url);
    
    if ([url hyb_isNotBlank]) {
        
        NSString *fullURLstring = [self.baseURLNoRest stringByAppendingString:url];
        
        [self.restEngine GETIMAGE:fullURLstring
                          success:^(AFHTTPRequestOperation *operation, id responseObject) {
                              block((UIImage *)responseObject, nil);
                          }
         
                          failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                              if ([error hyb_isNotBlank]) { // && [error isConnectionOfflineError]) {
                                  DDLogWarn(@"image retrieval failed, since device is disconnected, images will be taken from the cache: %@",
                                            [error localizedDescription]);
                              } else {
                                  DDLogError(@"image retrieval failed, a dummy will be created, reason: %@", [error localizedDescription]);
                                  UIImage *dummy = [UIImage imageNamed:@"placeholder.png"];
                                  block(dummy, error);
                              }
                          }];
        
        
    } else {
        NSString *msg = @"image retrieval failed, given url is blank, a dummy will be created.";
        UIImage *generatedImage = [UIImage imageNamed:@"placeholder.png"];
        block(generatedImage, [self createDefaultErrorWithMessage:msg failureReason:nil]);
    }
    
}

- (NSDictionary*)paginationParams {
    return @{@"pageSize"    : [NSString stringWithFormat:@"%d", [self pageSize]],
             @"currentPage" : [NSString stringWithFormat:@"%d", [self pageOffset]]};
}

#pragma mark products

- (void)getProductsAndExecute:(void (^)(NSArray *, NSError *))block {
    
    [self getProductsWithParams:[NSDictionary FULLFields:[self paginationParams]]
                           andExecute:^(NSDictionary *results, NSError *error) {
                               
                               NSArray *products = [results objectForKey:@"products"];
                               
                               block(products, error);
                           }];
}


- (void)getCategoriesAndExecute:(void (^)(NSArray *, NSError *))block {
    
    NSLog(@"getCategoriesAndExecute");
    
    [self getCatalogCategoryForCategoryId:[self rootCategoryId]
                          withParams:[NSDictionary FULLFields:[self paginationParams]]
                          andExecute:block];
    
}

- (void)getProductsByQuery:(NSString *)query
                       andExecute:(void (^)(NSArray *foundProducts, NSString *spellingSuggestion, NSError *error))block {
    
    
    NSMutableDictionary *mutableParams = [NSMutableDictionary dictionaryWithDictionary:[self paginationParams]];
    [mutableParams setValue:query forKey:@"query"];
    
    [self getProductsWithParams:[NSDictionary FULLFields:[NSDictionary dictionaryWithDictionary:mutableParams]]
                           andExecute:^(NSDictionary *results, NSError *error) {
                               
                               NSArray *products = [results objectForKey:@"products"];
                               NSString *suggestion = [results objectForKey:@"spellingSuggestion"];
                               
                               block(products, suggestion, error);
                           }];
    
}


- (void)loadImagesForProduct:(HYBProduct *)product
                       andExecute:(void (^)(NSArray *images, NSError *error))block {
    
    NSAssert([product hyb_isNotBlank], @"Product must be not nil");
    
    NSMutableArray *galleryImages = [NSMutableArray arrayWithArray:[product images]];
    DDLogDebug(@"Loading %lu gallery images for product %@", (unsigned long) galleryImages.count, product.code);
    
    __block NSMutableArray *images = [NSMutableArray array];
    __block int expectedImageCount = (int)[galleryImages count];
    
    for (HYBImage *image in galleryImages) {
        
        [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            
            //add product to cart
            [self loadImageByUrl:image.url
                           andExecute:^(id responseObject, NSError* error) {
                               if (error) {
                                   reject(error);
                               } else {
                                   fulfill(responseObject);
                               }
                           }];
        }]
        
        .then(^(UIImage *image) {
            if (!image) {
                expectedImageCount--;
            } else {
                
                //NSLog(@"Adding loaded image %@", image);
                @synchronized(images) {
                    [images addObject:image];
                    
                    if ((int)[images count] == expectedImageCount) {
                        DDLogDebug(@"Image download ready with %lu results.", (unsigned long) [images count]);
                        block([NSArray arrayWithArray:images], nil);
                    }
                }
                
            }
        })
        
        .catch(^(NSError *error) {
            block(nil, error);
        });
        
    }
}


- (void)addProductToCurrentCart:(NSString *)productCode
                         amount:(NSNumber *)amount
                          andExecute:(void (^)(HYBCart *cart, id msg))block {
    
    NSDictionary *params = @{@"code" : productCode,
                             @"qty" : [amount stringValue]};
    
    HYBCart *cart = [self currentCartFromCache];
    
    NSString *cartCode = cart.code;
    
    if ([self.userId isEqualToString:GUEST_USER]) {
        cartCode = cart.guid;
    }
    
    [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        //add product to cart
        [self addCartEntryForUserId:self.userId
                            andCartId:cartCode
                           withParams:[NSDictionary FULLFields:params]
                           andExecute:^(id responseObject, NSError* error) {
                               if (error) {
                                   reject(error);
                               } else {
                                   fulfill(responseObject);
                               }
                           }];
    }]
    
    .then(^(HYBCartModification *cartModification) {
        
        [self feedbackForCartModification:cartModification
                               andExecute:block];
        
    })
    
    .catch(^(NSError *error) {
        block(nil, error);
    });
    
}

- (void)feedbackForCartModification:(HYBCartModification *)cartModification
                         andExecute:(void (^)(HYBCart *, NSError *))toExecute {
    
    NSString *localizedMsg = [self localizedMsgFromCartModification:cartModification];
    
    //reload cart if needed
    if ([cartModification.statusCode isEqualToString:SUCCESS_TAG]) {
        [self retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError *error) {
            if (error) {
                toExecute(nil, error);
            } else {
                NSDictionary* details = [NSDictionary dictionaryWithObject:localizedMsg
                                                                    forKey:NSLocalizedDescriptionKey];
                
                NSError *error = [NSError errorWithDomain:@"didAddToCart"
                                                     code:996
                                                 userInfo:details];
                toExecute(cart, error);
            }
        }];
    } else {
        NSDictionary* details = [NSDictionary dictionaryWithObject:localizedMsg
                                                            forKey:NSLocalizedDescriptionKey];
        
        NSError *error = [NSError errorWithDomain:@"addToCartError"
                                             code:999
                                         userInfo:details];
        
        toExecute(nil, error);
    }
}

- (void)retrieveCurrentCartAndExecute:(void (^)(HYBCart *, NSError *))toExecute {
    
    [self retrieveCartByUserIdFromCurrentCartsCreateIfNothingPresent:self.currentUserId
                                                          andExecute:^(HYBCart *cart, NSError * error) {
                                                              //keep cart in cache
                                                              [self saveCartInCacheNotifyObservers:cart];
                                                              toExecute(cart,error);
                                                          }];
    
}

- (void)retrieveCartByUserIdFromCurrentCartsCreateIfNothingPresent:(NSString *)username
                                                        andExecute:(void (^)(HYBCart *, NSError *))block {
    
    if ([username isEqualToString:GUEST_USER]) {
        
        HYBCart *cart = [self currentCartFromCache];
        
        if ([cart hyb_isNotBlank]) {
            
            //try to get anonymous cart
            [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
                
                [self getCartForUserId:GUEST_USER
                             andCartId:cart.guid
                            andExecute:^(id responseObject, NSError* error) {
                                if (error) {
                                    reject(error);
                                } else {
                                    fulfill(responseObject);
                                }
                            }];
                
            }]
            
            .then(^(HYBCart *cart) {
                
                //if we have a cart return it
                if ([cart hyb_isNotBlank]) {
                    //keep cart in cache
                    [self saveCartInCacheNotifyObservers:cart];
                    block(cart,nil);
                } else {
                    //else create a new one
                    [self createCartForUser:username
                                 andExecute:block];
                }
            })
            
            .catch(^(NSError *error) {
                block(nil, error);
            });
            
            
        } else {
            //no cart yet, create one
            [self createCartForUser:username
                         andExecute:block];
        }
        
        
        
    } else {
        //try to get all carts
        [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            
            [self getCartsForUserId:username
                         withParams:nil
                         andExecute:^(id responseObject, NSError* error) {
                             if (error) {
                                 reject(error);
                             } else {
                                 fulfill(responseObject);
                             }
                         }];
        }]
        
        .then(^(NSArray *carts) {
            HYBCart *firstCart = [carts firstObject];
            
            //if we have a cart return it
            if ([firstCart hyb_isNotBlank]) {
                //keep cart in cache
                [self saveCartInCacheNotifyObservers:firstCart];
                block(firstCart,nil);
            } else {
                //else create a new one
                [self createCartForUser:username
                             andExecute:block];
            }
        })
        
        .catch(^(NSError *error) {
            block(nil, error);
        });
    }
}

- (void)createCartForUser:(NSString *)userId
               andExecute:(void (^)(HYBCart *, NSError *))block {
    
    [self createCartForUserId:self.userId
                   withParams:[NSDictionary FULLFields]
                   andExecute:^(HYBCart *cart, NSError * error) {
                       //keep cart in cache
                       [self saveCartInCacheNotifyObservers:cart];
                       
                       block(cart,error);
                   }];
    
}

- (void)assignAnonymouCartWithGuid:(NSString*)guid
                          toUserId:(NSString*)userId
                        andExecute:(void (^)(HYBCart *, NSError *))block {
    
    NSDictionary *params =  @{@"oldCartId" : guid};
    
    [self createCartForUserId:self.userId
                   withParams:[NSDictionary FULLFields:params]
                   andExecute:^(HYBCart *cart, NSError * error) {
                       //keep cart in cache
                       [self saveCartInCacheNotifyObservers:cart];
                       
                       block(cart,error);
                   }];
    
}

- (void)mergeAnonymouCartWithGuid:(NSString*)oldCartId
                   toCartWithGuid:(NSString*)toMergeCartGuid
                         toUserId:(NSString*)userId
                       andExecute:(void (^)(HYBCart *, NSError *))block {
    
    NSDictionary *params =  @{
                              @"oldCartId" : oldCartId,
                              @"toMergeCartGuid" : toMergeCartGuid,
                              };
    
    [self createCartForUserId:self.userId
                   withParams:[NSDictionary FULLFields:params]
                   andExecute:^(HYBCart *cart, NSError * error) {
                       //keep cart in cache
                       [self saveCartInCacheNotifyObservers:cart];
                       
                       block(cart,error);
                   }];
    
}

- (void)saveCartInCacheNotifyObservers:(HYBCart *)cart {
    if([cart hyb_isNotBlank]) {
        [HYBCache cacheObject:cart forKey:CURRENT_CART_KEY];
        [[NSNotificationCenter defaultCenter] postNotificationName:NOTIFICATION_CART_UPDATED object:self];
    }
}



- (void)setDeliveryAddressWithCode:(NSString *)addressId
                    onCartWithCode:(NSString *)cartCode
                        andExecute:(void (^)(HYBCart *, NSError *))block {
    
    if (cartCode && addressId) {
        
        NSDictionary *params =  @{@"addressId" : addressId};
        
        [self updateCartDeliveryAddressForUserId:self.userId
                                       andCartId:cartCode
                                      withParams:params
                                      andExecute:block];
        
    } else {
        block(nil, nil);
    }
}


- (void)setDeliveryModeWithCode:(NSString *)modeCode
                 onCartWithCode:(NSString *)cartCode
                     andExecute:(void (^)(HYBCart *, NSError *))execute {
    
    if (cartCode && modeCode) {
        
        [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            NSDictionary *params =  @{@"deliveryModeId" : modeCode};
            
            [self updateCartDeliverymodeForUserId:self.userId
                                        andCartId:cartCode
                                       withParams:params
                                       andExecute:^(id responseObject, NSError* error) {
                                           if (error) {
                                               reject(error);
                                           } else {
                                               fulfill(responseObject);
                                           }
                                       }];
        }]
        
        .then(^(NSString *statusCode) {
            
            //reload cart if needed
            if ([statusCode isEqualToString:SUCCESS_TAG]) {
                [self retrieveCurrentCartAndExecute:execute];
            } else {
                execute(nil, nil);
            }
        })
        
        .catch(^(NSError *error) {
            execute(nil, error);
        });
        
    }  else {
        execute(nil, nil);
    }
    
}


- (void)placeOrderWithCart:(HYBCart *)cart
                andExecute:(void (^)(HYBOrder *, NSError *))execute {
    
    if (cart) {
        NSDictionary *params = @{@"termsChecked" : @"true",
                                 @"cartId" : cart.code};
        
        [self placeOrderForUserId:self.userId
                       withParams:params
                       andExecute:execute];
    } else {
        execute(nil, nil);
    }
}


- (void)findOrderByCode:(NSString *)code
             andExecute:(void (^)(HYBOrder *, NSError *))block {
    
    if (code) {
        [self getOrderForUserId:self.userId
                   andOrderCode:code
                     andExecute:block];
    } else {
        block(nil, nil);
    }
    
}


- (void)retrieveOrdersForUser:(NSString *)userId
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(NSArray *, NSError *))block {
    
    if (userId) {
        [self getOrdersForUserId:self.userId
                      withParams:params
                      andExecute:block];
    } else {
        block(nil, nil);
    }
}


- (void)getStoresWithParams:(NSDictionary*)params
                 andExecute:(void (^)(NSArray *, NSError *))block {
    
    [super getStoresWithParams:params
                    andExecute:block];
}


- (void)getStoreDetailWithStoreName:(NSString*)rawStoreName
                          andParams:(NSDictionary*)params
                         andExecute:(void (^)(HYBPointOfService *, NSError *))block {
    
    if (rawStoreName) {
        [self getStoreForStoreId:rawStoreName
                      withParams:params
                      andExecute:block];
    } else {
        block(nil, nil);
    }
}

- (void)findStoreBySearchQuery:(NSString*)queryString
                    andExecute:(void (^)(NSArray *, NSError *))block {
    
    if([queryString hyb_isNotBlank]) {
        NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                                queryString, @"query",
                                nil];
        
        [self getStoresWithParams:params
                       andExecute:block];
    } else {
        block(nil, nil);
    }
}

- (void)updateProductOnCurrentCartAmount:(NSString *)entryNumber
                                   mount:(NSNumber *)amountToAdd
                              andExecute:(void (^)(HYBCart *, NSError *))block {
    
    NSDictionary *params = @{@"qty" : amountToAdd.stringValue};
    
    HYBCart *cart = [self currentCartFromCache];
    
    NSString *cartCode = cart.code;
    
    if ([self.userId isEqualToString:GUEST_USER]) {
        cartCode = cart.guid;
    }
    
    [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        //add product to cart
        [self replaceCartEntryForUserId:self.userId
                          andCartId:cartCode
                     andEntryNumber:entryNumber
                         withParams:[NSDictionary FULLFields:params]
                         andExecute:^(id responseObject, NSError* error) {
                             if (error) {
                                 reject(error);
                             } else {
                                 fulfill(responseObject);
                             }
                         }];
    }]
    
    .then(^(HYBCartModification *cartModification) {
        
        [self feedbackForCartModification:cartModification
                               andExecute:block];
        
    })
    
    .catch(^(NSError *error) {
        block(nil, error);
    });
    
}

- (void)logoutCurrentUser {
       
    NSString *currentUserId = self.userId;
    
    if (currentUserId) {
        [self clearTokensForUser:currentUserId];
    }
    
    
    NSHTTPCookieStorage *storage = [NSHTTPCookieStorage sharedHTTPCookieStorage];
    
    for (NSHTTPCookie *cookie in [storage cookies]) {
        DDLogDebug(@"Deleting present cookie %@", [cookie description]);
        [storage deleteCookie:cookie];
    }
    
    [self.userStorage synchronize];
    
    //wipe user and create empty cart is user in not anonymous
    
    if (currentUserId && ![currentUserId isEqualToString:GUEST_USER]) {
        self.userId = GUEST_USER;
        
        [HYBCache uncacheObjectForKey:CURRENT_CART_KEY];
        
        [self retrieveCurrentCartAndExecute:^(HYBCart *cart, NSError * error) {
            
        }];
    }
}

- (void)clearTokensForUser:(NSString *)user {
    
    [HYBStorage deleteObjectsForKeys:[NSArray arrayWithObjects:user,
                                      nil]];
}

- (NSUserDefaults *)userStorage {
    return [NSUserDefaults standardUserDefaults];
}

- (HYBCart *)currentCartFromCache {
    return [HYBCache cachedObjectForKey:CURRENT_CART_KEY];
}

- (NSString *)currentUserEmail {
    return self.userId;
}

- (NSString *)currentUserId {
    return self.userId;
}

- (NSString *)currentCatalogId {
    return self.catalogId;
}

- (void)setCurrentCatalogId:(NSString*)catalogId {
    self.catalogId = catalogId;
}

- (void)findProductsByCategoryId:(NSString *)categoryId
                       andExecute:(void (^)(NSArray *foundCategories, NSError *error))block {
    
    NSLog(@"findProductsByCategoryId");
    
    NSString *url = [NSString stringWithFormat:@"%@?query=::category:%@",[self productsSearchURL],categoryId];
    
    [self.restEngine GET:url
              withParams:[NSDictionary FULLFields:[self paginationParams]]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     //products
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"products"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBProduct *product = [HYBProduct productWithParams:(NSDictionary*)object];
                             [tmpArray addObject:product];
                         }
                     }
                     
                     NSArray *finalArray = nil;
                     
                     if([tmpArray hyb_isNotBlank]) {
                         finalArray = [NSArray arrayWithArray:tmpArray];
                     }
                     
                     block(finalArray,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}



@end
