//
//  HYBBackendServiceOCC.m
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

#import "HYBBackendServiceOCC.h"

@implementation HYBBackendServiceOCC

#pragma mark init

- (instancetype)initWithParams:(NSDictionary*)params {
    
    if(self = [super initWithParams:params]) {
        
        [[NSNotificationCenter defaultCenter] addObserver:self
                                                 selector:@selector(refreshTheTokenFromNotification:)
                                                     name:@"refreshTheToken"
                                                           object:nil];
    }
    return self;
}

- (void)dealloc {
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}

- (NSString *)localizedMsgFromCartModification:(HYBCartModification*)cartModification {
    
    NSNumber *quantityAdded = cartModification.quantityAdded;
    NSString *statusMsg     = cartModification.statusMessage;
    NSString *statusCode    = cartModification.statusCode;
    
    NSString *localizedMsg;
    if ([statusCode isEqualToString:SUCCESS_TAG]) {
        if ([statusMsg hyb_isNotBlank]) {
            localizedMsg = statusMsg;
        } else {
            localizedMsg = [NSString stringWithFormat:@"%d item(s) added", [quantityAdded intValue]];
        }
    } else {
        if (statusMsg) {
            localizedMsg = [NSString stringWithFormat:@"%@ %d item(s) added", statusMsg, [quantityAdded intValue]];
        } else {
            DDLogError(@"Problems while retrieving the message for the add to cart action: The status message is missing.");
            localizedMsg = [NSString stringWithFormat:@"Problems while adding products to cart. Error was reported."];
        }
    }
    return localizedMsg;
}

#pragma mark error logging

- (void)logError:(NSError*)error {
    DDLogError(@"!!! HYBBackendServiceOCC Error !!!");
    DDLogError(@"%@",error.localizedFailureReason);
    DDLogError(@"%@",error.localizedDescription);
}

- (NSError *)createDefaultErrorWithMessage:(NSString *)errorMsg
                             failureReason:(NSString *)failureReason {
    NSError *error;
    
    NSMutableDictionary *userInfo = [[NSMutableDictionary alloc] init];
    
    [userInfo setObject:errorMsg forKey:NSLocalizedDescriptionKey];
    if (failureReason) {
        [userInfo setObject:failureReason forKey:NSLocalizedFailureReasonErrorKey];
    }
    error = [NSError errorWithDomain:HYBOCCErrorDomain code:HYB2B_ERROR_CODE_TECHNICAL userInfo:userInfo];
    
    return error;
}


#pragma mark authentication

- (void)applyAuthToken:(NSString*)token {
    if(self.restEngine) {
        NSString *authorizationHeader = [NSString stringWithFormat:@"Bearer %@", token];
        [self.restEngine injectAuthorizationHeader:authorizationHeader];
    } else {
        DDLogError(@"!!! RestEngine not set !!!");
    }
}

- (void)applyBasicAuth {
    if(self.restEngine) {
        NSString *authorizationHeader = [NSString stringWithFormat:@"Basic %@", BASIC_AUTH];
        [self.restEngine injectAuthorizationHeader:authorizationHeader];
    } else {
        DDLogError(@"!!! RestEngine not set !!!");
    }
}


- (void)authenticateUsername:(NSString *)username
                  andExecute:(void (^)(id, NSError *))block {
    
    [self authenticateUsername:[username lowercaseString]
                  withPassword:nil
                    andExecute:block];
}

- (void)authenticateUsername:(NSString*)username
                withPassword:(NSString *)password
                  andExecute:(void (^)(id, NSError *))block {
    
    @weakify(self);
    [self retrieveTokenForUsername:[username lowercaseString]
                      withPassword:password
                        andExecute:^(NSString *token, NSError *error) {
                            
                            @strongify(self);
                            if (error) {
                                DDLogError(@"Problems during the auth token retrieval, reason: %@", [error localizedDescription]);
                                block(NSLocalizedString(@"login_failed_wrong_credentials", nil), error);
                            } else {
                                
                                NSLog(@"Token retrieved.");
                                NSLog(@"Auth success");
                                
                                self.userId = [username lowercaseString];
                                [self applyAuthToken:token];
                                
                                //save username
                                [HYBStorage storeObject:[username lowercaseString] forKey:LAST_AUTHENTICATED_USER_KEY];
                                
                                block(NSLocalizedString(@"login_success", nil), nil);
                                
                            }
                        }] ;
}

- (void)makeGuestTrustedClientAndExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine discardAuthorizationHeader];
    
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            @"mobile_android", @"client_id",
                            @"secret", @"client_secret",
                            @"client_credentials",@"grant_type",
                            nil];
    @weakify(self);
    [self.restEngine POST:self.tokenURL
               withParams:params
                  success:^(AFHTTPRequestOperation *task, id responseObject) {
                      @strongify(self);
                      DDLogError(@"Token granted by server");
                      NSString *token = [(NSDictionary*)responseObject objectForKey:ACCESS_TOKEN_KEY];
                      
                      [self applyAuthToken:token];
                      
                      //store session
                      [self storeSession:responseObject forUsername:[self.userId lowercaseString]];
                      
                      block(token, nil);
                  }
                  failure:^(AFHTTPRequestOperation *task, NSError *error) {
                      DDLogError(@"Error during retrieval of the token: %@", error);
                      block(NSLocalizedString(@"make_client_failed", nil), error);
                  }];
    
}

- (void)makeUserTrustedClientAndExecute:(void (^)(id, NSError *))block {
    
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            @"mobile_android", @"client_id",
                            @"secret", @"client_secret",
                            @"client_credentials",@"grant_type",
                            nil];
     @weakify(self);
    [self.restEngine POST:self.tokenURL
               withParams:params
                  success:^(AFHTTPRequestOperation *task, id responseObject) {
                      @strongify(self);
                      DDLogError(@"Token granted by server");
                      NSString *token = [(NSDictionary*)responseObject objectForKey:ACCESS_TOKEN_KEY];
                      
                      [self applyAuthToken:token];
                      
                      //store session
                      [self storeSession:responseObject forUsername:[self.userId lowercaseString]];
                      
                      block(token, nil);
                  }
                  failure:^(AFHTTPRequestOperation *task, NSError *error) {
                      DDLogError(@"Error during retrieval of the token: %@", error);
                      block(NSLocalizedString(@"make_client_failed", nil), error);
                  }];

}

- (void)retrieveTokenForUsername:(NSString *)username
                    withPassword:(NSString *)password
                      andExecute:(void (^)(id, NSError *))block {
    
    NSDictionary *presentTokenDetails = [HYBStorage objectForKey:[username lowercaseString]];
        
    if (password || !presentTokenDetails || ![presentTokenDetails objectForKey:ACCESS_TOKEN_KEY]) {
        
        NSLog(@"Retrieving a first time token for the user %@", [username lowercaseString]);
        
        NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                                @"mobile_android", @"client_id",
                                @"secret", @"client_secret",
                                @"password",@"grant_type",
                                [username lowercaseString],@"username",
                                password, @"password",
                                nil];
        
        [self applyBasicAuth];
        
        [self.restEngine POST:self.tokenURL
                   withParams:params
                      success:^(AFHTTPRequestOperation *task, id responseObject) {
                          
                          DDLogError(@"Token granted by server");
                          NSString *token = [(NSDictionary*)responseObject objectForKey:ACCESS_TOKEN_KEY];
                          
                          [self applyAuthToken:token];

                          //store session
                          [self storeSession:responseObject forUsername:[username lowercaseString]];
                          
                          block(token, nil);
                      }
                      failure:^(AFHTTPRequestOperation *task, NSError *error) {
                          DDLogError(@"Error during retrieval of the token: %@", error);
                          block(NSLocalizedString(@"login_failed_checkcredentials_or_user_rights", nil), error);
                      }];
    } else {
        
        NSLog(@"Token found for the username %@", [username lowercaseString]);
        [self refreshTokenWithDetails:presentTokenDetails
                          forUsername:[username lowercaseString]
                           andExecute:block];
        
    }
}

- (void)refreshTheTokenFromNotification:(NSNotification*)notification {
    
    NSLog(@"refreshTheTokenFromNotification %@", [notification description]);
  
    NSDictionary *originalCall = [notification.userInfo copy];
    
    //mark local access token as invalid
    [HYBStorage storeObject:INVALID_TOKEN_KEY forKey:INVALID_TOKEN_KEY];
    
    if(self.userId && originalCall) {
        
        NSDictionary *presentTokenDetails = [HYBStorage objectForKey:[self.userId lowercaseString]];
   
        [self refreshTokenWithDetails:presentTokenDetails
                          forUsername:[self.userId lowercaseString]
                           andExecute:^(id response, NSError *error){
                               
                               if(error) {
                                   DDLogError(@"Error during refreshing the token, this is either a web service "
                                              "issue or a connectivity problem.: %@", error);
                                   
                               } else {
                                   
                                   NSString *HTTP       = originalCall[@"HTTP"];
                                   NSString *url        = originalCall[@"url"];
                                   NSDictionary *params = originalCall[@"params"];
                                   id succes  = originalCall[@"success"];
                                   id failure = originalCall[@"failure"];
                                   
                                   [self.restEngine HTTP:HTTP
                                                     url:url
                                              withParams:params
                                                 success:succes
                                                 failure:failure];
                               }
                               
                           }];
       
    } else {
       DDLogError(@"could not refreshTheTokenFromNotification : login out");
    }
}

- (void)refreshTokenWithDetails:(NSDictionary *)tokenDetails
                    forUsername:(NSString *)username
                     andExecute:(void (^)(id, NSError *))block {
    
    //check if present token is expired
    NSString *presentToken = [tokenDetails objectForKey:ACCESS_TOKEN_KEY];
    
    if ([self isSessionExpired:tokenDetails]) {
        NSLog(@"Token for the user %@ will be refreshed.", [username lowercaseString]);
        NSString *refreshToken = [tokenDetails objectForKey:REFRESH_TOKEN_KEY];
        
        NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                                @"refresh_token",@"grant_type",
                                @"mobile_android", @"client_id",
                                @"secret", @"client_secret",
                                refreshToken, @"refresh_token",
                                nil];
        
        [self applyBasicAuth];
        
        [self.restEngine POST:self.tokenURL
                   withParams:params
                      success:^(AFHTTPRequestOperation *task, id responseObject) {
                          
                          DDLogError(@"Token refreshed from server");
                          NSString *token = [(NSDictionary*)responseObject objectForKey:ACCESS_TOKEN_KEY];
                          
                          [self applyAuthToken:token];
                          
                          //store session
                          [self storeSession:responseObject forUsername:[username lowercaseString]];
                          
                          block(token, nil);
                      }
                      failure:^(AFHTTPRequestOperation *task, NSError *error) {
                          //delete old session
                          [HYBStorage deleteObjectForKey:[username lowercaseString]];
                          
                          DDLogError(@"Error during refreshing the token, this is either a web service "
                                     "issue or a connectivity problem.: %@", error);
                          block(NSLocalizedString(@"login_failed_checkcredentials_or_user_rights", nil), error);
                      }];
    } else {
        NSLog(@"Token for the user %@ is STILL VALID and will be reused.", [username lowercaseString]);
        block(presentToken, nil);
    }
}

- (BOOL)isSessionExpired:(NSDictionary *)session {
    
    //force refesh token
    NSString *isTokenInvalid = [HYBStorage objectForKey:INVALID_TOKEN_KEY];
    if(isTokenInvalid) return YES;
    
    NSDate *expirationTime = [session objectForKey:EXPIRATION_TIME_KEY];
    NSTimeInterval remainingMillisecondsToExpiration = [expirationTime timeIntervalSinceNow];
    BOOL isSomeRemainingMills = remainingMillisecondsToExpiration > 1;
    return !isSomeRemainingMills;
}

- (void)storeSession:(NSDictionary*)session forUsername:(NSString*)username {
    
    //clean up invalid mark
    [HYBStorage deleteObjectForKey:INVALID_TOKEN_KEY];
    
    //calculate and add issue_on date
    NSMutableDictionary *tmpDict = [NSMutableDictionary dictionaryWithDictionary:session];
    NSNumber *millisecondsToExpire = [session objectForKey:EXPIRE_VALUE_KEY];
    double secondsToExpire = millisecondsToExpire.doubleValue / 1000;
    NSDate *expirationTime = [[NSDate alloc] initWithTimeIntervalSinceNow:secondsToExpire];
    tmpDict[EXPIRATION_TIME_KEY] = expirationTime;
    
    [HYBStorage storeObject:[NSDictionary dictionaryWithDictionary:tmpDict] forKey:[username lowercaseString]];
}

#pragma mark cardtypes

- (void)getCardtypesAndExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cardtypes %@", self.cardtypesURL);
    
    [self.restEngine GET:self.cardtypesURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"cardTypes"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBCardType *cardType = [HYBCardType cardTypeWithParams:(NSDictionary*)object];
                             [tmpArray addObject:cardType];
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

#pragma mark catalogs

- (void)getCatalogsAndExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Catalogs %@", self.catalogsURL);
    
    [self.restEngine GET:self.catalogsURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"catalogs"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBCatalog *catalog = [HYBCatalog catalogWithParams:(NSDictionary*)object];
                             [tmpArray addObject:catalog];
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

- (void)getCatalogAndExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Catalogs %@", self.catalogIdURL);
    
    [self.restEngine GET:self.catalogIdURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBCatalog *catalog = nil;
                     if([responseObject hyb_isNotBlank]) {
                         catalog = [HYBCatalog catalogWithParams:(NSDictionary*)responseObject];
                     }
                     block(catalog,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)getCatalogVersionAndExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get CatalogVersion %@", self.catalogVersionIdURL);
    
    [self.restEngine GET:self.catalogVersionIdURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBCatalogVersion *catalogVersion = nil;
                     if([responseObject hyb_isNotBlank]) {
                         catalogVersion = [HYBCatalogVersion catalogVersionWithParams:(NSDictionary*)responseObject];
                     }
                     block(catalogVersion,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

// Returns information about category that exists in a catalog version available for the current base store.

- (void)getCatalogCategoryForCategoryId:(NSString*)categoryId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Category Hierarchy For Category Id %@", [self catalogCategoriesURLForCategoryId:categoryId]);
    
    [self.restEngine GET:[self catalogCategoriesURLForCategoryId:categoryId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBCategoryHierarchy *category = nil;
                     if([responseObject hyb_isNotBlank]) {
                         category = [HYBCategoryHierarchy categoryHierarchyWithParams:(NSDictionary*)responseObject];
                         if (category) [category assignParent];
                     }
                     if([category hyb_isNotBlank]) {
                         block([NSArray arrayWithObject:category],nil);
                     } else {
                         block(nil,nil);
                     }
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

#pragma mark currencies

- (void)getCurrenciesAndExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Currencies %@", self.currenciesURL);
    
    [self.restEngine GET:self.currenciesURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"currencies"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBCurrency *currency = [HYBCurrency currencyWithParams:(NSDictionary*)object];
                             [tmpArray addObject:currency];
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

#pragma mark customergroups

//need ROLE_CUSTOMERMANAGERGROUP
- (void)getCustomergroupsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Customergroups %@", self.customergroupsURL);
    
    [self.restEngine GET:self.customergroupsURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"userGroups"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBUserGroup *group = [HYBUserGroup userGroupWithParams:(NSDictionary*)object];
                             [tmpArray addObject:group];
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

- (void)createCustomergroupsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine POST:self.customergroupsURL
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      block(SUCCESS_TAG,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      
                      //error anchor
                      [self logError:error];
                      
                  }];
}

- (void)getCustomergroupWithParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:self.customergroupIdURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBUserGroup *userGroup = nil;
                     if([responseObject hyb_isNotBlank]) {
                         userGroup = [HYBUserGroup userGroupWithParams:(NSDictionary*)responseObject];
                     }
                     block(userGroup,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)setCustomergroupMembersWithParams:(NSDictionary*)params
                               andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine PUT:self.customergroupMembersURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)updateCustomergroupMembersWithParams:(NSDictionary*)params
                                  andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine PATCH:self.customergroupMembersURL
                withParams:params
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       
                       //error anchor
                       [self logError:error];
                       
                   }];
}

- (void)deleteCustomergroupUserAndExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine DELETE:self.customergroupUserIdURL
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        
                        //error anchor
                        [self logError:error];
                        
                    }];
}

#pragma mark deliverycountries

- (void)getDeliverycountriesAndExecute:(void (^)(id, NSError *))block {
    
    
    NSLog(@"get Deliverycountries %@", self.deliverycountriesURL);
    
    [self.restEngine GET:self.deliverycountriesURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"countries"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBCountry *country = [HYBCountry countryWithParams:(NSDictionary*)object];
                             [tmpArray addObject:country];
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

#pragma mark export

- (void)getExportProductsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Export Products %@", self.exportURL);
    
    [self.restEngine GET:self.exportURL
              withParams:params
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

#pragma mark feeds

- (void)getOrdersFeedsWithParams:(NSDictionary*)params
                andExecute:(void (^)(id, NSError *))block {
    
    //timestamp=1977-04-22T06:00:00Z
    
    [self.restEngine GET:self.feedsURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"orderStatusUpdateElements"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBOrderStatusUpdateElement *element = [HYBOrderStatusUpdateElement orderStatusUpdateElementWithParams:(NSDictionary*)object];
                             [tmpArray addObject:element];
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

#pragma mark forgottenpasswordtokens

- (void)generateForgottenpasswordtokensAndExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine POST:self.forgottenpasswordtokens
               withParams:[NSDictionary dictionaryWithObject:self.userId forKey:@"userId"]
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       block(SUCCESS_TAG,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

#pragma mark languages

- (void)getLanguagesAndExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:self.languagesURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"languages"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBLanguage *language = [HYBLanguage languageWithParams:(NSDictionary*)object];
                             [tmpArray addObject:language];
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

#pragma mark products

- (void)getProductsExpressupdateWithParams:(NSDictionary*)params
                                andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:self.productsExpressupdateURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"productExpressUpdateElements"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBProductExpressUpdateElement *element = [HYBProductExpressUpdateElement productExpressUpdateElementWithParams:(NSDictionary*)object];
                             [tmpArray addObject:element];
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

- (void)countProductsWithParams:(NSDictionary*)params
                           andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"count Products Search %@", self.productsSearchURL);
    
    [self.restEngine HEAD:self.productsSearchURL
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      
                      NSString *object = [operation.response.allHeaderFields objectForKey:@"X-Total-Count"];
                      block(object,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getProductsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Products Search %@", self.productsSearchURL);
    
    @weakify(self);
    [self.restEngine GET:self.productsSearchURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     @strongify(self);
                     //metas
                     NSString *spellingSuggestion = [responseObject valueForKeyPath:@"spellingSuggestion.suggestion"];
                     
                     NSNumber *totalResults =       [responseObject valueForKeyPath:@"pagination.totalResults"];
                     self.totalSearchResults = totalResults.intValue;
                     self.currentPage       = [[responseObject valueForKeyPath:@"pagination.currentPage"] intValue];
                     self.pageSize          = [[responseObject valueForKeyPath:@"pagination.pageSize"] intValue];
                     
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
                     
                     //tupled results
                     NSMutableDictionary *tmpResults = [NSMutableDictionary dictionary];
                     
                     if([finalArray hyb_isNotBlank]) [tmpResults setValue:finalArray forKey:@"products"];
                     if([spellingSuggestion hyb_isNotBlank]) [tmpResults setValue:spellingSuggestion forKey:@"spellingSuggestion"];
                     
                     block([NSDictionary dictionaryWithDictionary:tmpResults], nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)getProductsSuggestionsWithParams:(NSDictionary*)params
                              andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Products Suggestions %@", self.productsSearchURL);
    
    [self.restEngine GET:self.productsSuggestionsURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"suggestions"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (NSDictionary *object in objects) {
                             NSString *suggestion = object[@"value"];
                             [tmpArray addObject:suggestion];
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

- (void)getProductForCode:(NSString*)code
               andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Product For Code %@", [self productURLForCode:code]);
    
    [self.restEngine GET:[self productURLForCode:code]
              withParams:[NSDictionary FULLFields]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBProduct *product = nil;
                     if ([responseObject hyb_isNotBlank]) {
                         product = [HYBProduct productWithParams:(NSDictionary*)responseObject];
                     }
                     block(product,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)getProductReferencesForCode:(NSString*)code
                         withParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block {
    
    
    
    [self.restEngine GET:[self productReferencesURLForCode:code]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     //products
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"references"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBProductReference *product = [HYBProductReference productReferenceWithParams:(NSDictionary*)object];
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


- (void)getProductReviewsForCode:(NSString*)code
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Product Reviews For Code %@", [self productReviewsURLForCode:code]);
    
    [self.restEngine GET:[self productReviewsURLForCode:code]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"reviews"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (NSDictionary *object in objects) {
                             HYBReview *productReview = [HYBReview reviewWithParams:(NSDictionary*)object];
                             [tmpArray addObject:productReview];
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

- (void)setProductReviewForCode:(NSString*)code
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Product Reviews For Code %@", [self productReviewsURLForCode:code]);
    
    [self.restEngine POST:[self productReviewsURLForCode:code]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      
                      HYBReview *productReview = nil;
                      
                      if([responseObject hyb_isNotBlank]) {
                          productReview = [HYBReview reviewWithParams:(NSDictionary*)responseObject];
                      }
                      
                      block(productReview,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getProductStockForCode:(NSString*)code
                    withParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Product Stock For Code %@", [self productStockURLForCode:code]);
    
    [self.restEngine GET:[self productStockURLForCode:code]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBStoreFinderStockSearchPage *productStockInfo = nil;
                     if([responseObject hyb_isNotBlank]) {
                         productStockInfo = [HYBStoreFinderStockSearchPage storeFinderStockSearchPageWithParams:(NSDictionary*)responseObject];
                     }
                     block(productStockInfo,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)countProductStockForCode:(NSString*)code
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"count Product Stock For Code %@", [self productStockURLForCode:code]);
    
    [self.restEngine HEAD:[self productStockURLForCode:code]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      NSString *object = [operation.response.allHeaderFields objectForKey:@"X-Total-Count"];
                      block(object,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}


- (void)getProductStockForCode:(NSString*)code
                  forStorename:(NSString*)storename
                    andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Product Stock For Code For Storename %@", [self productStockURLForCode:code forStorename:storename]);
    
    [self.restEngine GET:[self productStockURLForCode:code forStorename:storename]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBStock *stock = nil;
                     if([responseObject hyb_isNotBlank]) {
                         stock = [HYBStock stockWithParams:(NSDictionary*)responseObject];
                     }
                     block(stock,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

#pragma mark promotions

- (void)getPromotionsWithParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:self.promotionsURL
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"promotions"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBPromotion *promotion = [HYBPromotion promotionWithParams:(NSDictionary*)object];
                             [tmpArray addObject:promotion];
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

- (void)getPromotionForCode:(NSString*)code
                 andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:[self promotionURLForCode:code]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     HYBPromotion *promotion = nil;
                     if([responseObject hyb_isNotBlank]) {
                         promotion = [HYBPromotion promotionWithParams:(NSDictionary*)responseObject];
                     }
                     
                     block(promotion,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

#pragma mark stores


- (void)getStoresWithParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Stores %@", self.storesURL);
    
    [self.restEngine GET:self.storesURL
              withParams:[NSDictionary FULLFields:params]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"stores"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBPointOfService *pointOfService = [HYBPointOfService pointOfServiceWithParams:(NSDictionary*)object];
                             [tmpArray addObject:pointOfService];
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

- (void)countStoresWithParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"count Stores %@", self.storesURL);
    
    [self.restEngine HEAD:self.storesURL
               withParams:[NSDictionary FULLFields:params]
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      NSString *object = [operation.response.allHeaderFields objectForKey:@"X-Total-Count"];
                      block(object,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getStoreForStoreId:(NSString*)storeId
                withParams:(NSDictionary *)params
                andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:[self storeURLForStoreId:storeId]
              withParams:[NSDictionary FULLFields:params]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBPointOfService *pointOfService = nil;
                     if([responseObject hyb_isNotBlank]) {
                         pointOfService = [HYBPointOfService pointOfServiceWithParams:(NSDictionary*)responseObject];
                     }
                     block(pointOfService,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

#pragma mark titles

- (void)getTitlesAndExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Titles %@", self.titlesURL);
    
    [self.restEngine GET:self.titlesURL
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"titles"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBTitle *title = [HYBTitle titleWithParams:(NSDictionary*)object];
                             [tmpArray addObject:title];
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

#pragma mark users

//needs ROLE_CLIENT, ROLE_CUSTOMERMANAGERGROUP
- (void)registerUserWithParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine POST:self.usersURL
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      block(SUCCESS_TAG,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      
                      NSError *customError = nil;
                      
                      if ([operation.responseObject[@"errors"] hyb_isNotBlank]) {
                          
                          NSMutableString *tmpString = [NSMutableString string];
                          
                          for (NSDictionary *dict in operation.responseObject[@"errors"]) {
                              if ([dict[@"type"] isEqualToString:@"DuplicateUidError"]) {
                                  [tmpString appendFormat:@"Already registered user\n"];
                              }
                              [tmpString appendFormat:@"%@\n",dict[@"message"] ];
                          }
                          
                          if([tmpString hyb_isNotBlank]) {
                              NSString *msg = [NSString stringWithString:tmpString];
                              
                              customError = [self createDefaultErrorWithMessage:msg failureReason:nil];
                          }
                      }
                      
                      if (customError) {
                          error = customError;
                      }
                      
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getUserProfileForUserId:(NSString*)userId
                     andExecute:(void (^)(id, NSError *))block {
    
    
    NSLog(@"get User Profile For User Id %@", [self userProfileURLForUserId:userId]);
    
    [self.restEngine GET:[self userProfileURLForUserId:userId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     HYBUser *user = nil;
                     
                     if([responseObject hyb_isNotBlank]) {
                         user = [HYBUser userWithParams:(NSDictionary*)responseObject];
                     }
                     block(user,nil);
                     
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)replaceUserProfileForUserId:(NSString*)userId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set User Profile For User Id %@", [self userProfileURLForUserId:userId]);
    
    [self.restEngine PUT:[self userProfileURLForUserId:userId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)updateUserProfileForUserId:(NSString*)userId
                    withParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update User Profile For User Id %@", [self userProfileURLForUserId:userId]);
    
    [self.restEngine PATCH:[self userProfileURLForUserId:userId]
                withParams:params
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       block(SUCCESS_TAG,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
}

- (void)deleteUserProfileForUserId:(NSString*)userId
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete User Profile For User Id %@", [self userProfileURLForUserId:userId]);
    
    [self.restEngine DELETE:[self userProfileURLForUserId:userId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

#pragma mark user addresses


- (void)getUserAddressesForUserId:(NSString*)userId
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Addresses For User Id %@", [self userAddressesURLForUserId:userId]);
    
    [self.restEngine GET:[self userAddressesURLForUserId:userId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"addresses"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBAddress *address = [HYBAddress addressWithParams:(NSDictionary*)object];
                             [tmpArray addObject:address];
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

- (void)createUserAddressForUserId:(NSString*)userId
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Address For User Id %@", [self userAddressesURLForUserId:userId]);
    
    [self.restEngine POST:[self userAddressesURLForUserId:userId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      
                      HYBAddress *address = nil;
                      
                      if([responseObject hyb_isNotBlank]) {
                          address = [HYBAddress addressWithParams:(NSDictionary*)responseObject];
                      }
                      block(address,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}


- (void)verifyUserAddressForUserId:(NSString*)userId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"verify User Address For User Id %@", [self userAddressVerificationURLForUserId:userId]);
    
    [self.restEngine POST:[self userAddressVerificationURLForUserId:userId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      block(responseObject,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}


- (void)getUserAddressForUserId:(NSString*)userId
               andAddressId:(NSString*)addressId
                 andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Address For User Id and Address Id %@", [self userAddressURLForUserId:userId andAddressId:addressId]);
    
    [self.restEngine GET:[self userAddressURLForUserId:userId andAddressId:addressId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     HYBAddress *address = nil;
                     
                     if([responseObject hyb_isNotBlank]) {
                         address = [HYBAddress addressWithParams:(NSDictionary*)responseObject];
                     }
                     block(address,nil);
                     
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)replaceUserAddressForUserId:(NSString*)userId
               andAddressId:(NSString*)addressId
                 withParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Address For User Id and Address Id %@", [self userAddressURLForUserId:userId andAddressId:addressId]);
    
    [self.restEngine PUT:[self userAddressURLForUserId:userId andAddressId:addressId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)updateUserAddressForUserId:(NSString*)userId
                  andAddressId:(NSString*)addressId
                    withParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update Address For User Id and Address Id %@", [self userAddressURLForUserId:userId andAddressId:addressId]);
    
    [self.restEngine PATCH:[self userAddressURLForUserId:userId andAddressId:addressId]
                withParams:params
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       block(SUCCESS_TAG,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
}


- (void)deleteUserAddressForUserId:(NSString*)userId
                  andAddressId:(NSString*)addressId
                    andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Address For User Id and Address Id %@", [self userAddressURLForUserId:userId andAddressId:addressId]);
    
    [self.restEngine DELETE:[self userAddressURLForUserId:userId andAddressId:addressId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(responseObject,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

#pragma mark user carts


- (void)getCartsForUserId:(NSString*)userId
               withParams:(NSDictionary*)params
               andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Carts For User Id %@", [self userCartsURLForUserId:userId]);
    
    [self.restEngine GET:[self userCartsURLForUserId:userId]
              withParams:[NSDictionary FULLFields:params]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"carts"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBCart *cart = [HYBCart cartWithParams:(NSDictionary*)object];
                             [cart assignPromotions];
                             [tmpArray addObject:cart];
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


- (void)createCartForUserId:(NSString*)userId
                 withParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"create Cart For User Id %@", [self userCartsURLForUserId:userId]);
    
    [self.restEngine POST:[self userCartsURLForUserId:userId]
               withParams:[NSDictionary FULLFields:params]
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      HYBCart *cart = nil;
                      if([responseObject hyb_isNotBlank]) {
                          cart = [HYBCart cartWithParams:(NSDictionary*)responseObject];
                          [cart assignPromotions];
                      }
                      block(cart,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getCartForUserId:(NSString*)userId
               andCartId:(NSString*)cartId
              andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart For User Id And Cart Id %@", [self userCartsURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartsURLForUserId:userId andCartId:cartId]
              withParams:[NSDictionary FULLFields]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBCart *cart = nil;
                     if([responseObject hyb_isNotBlank]) {
                         cart = [HYBCart cartWithParams:(NSDictionary*)responseObject];
                         [cart assignPromotions];
                     }
                     block(cart,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)deleteCartForUserId:(NSString*)userId
                  andCartId:(NSString*)cartId
                 andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Cart For User Id And Cart Id %@", [self userCartsURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine DELETE:[self userCartsURLForUserId:userId andCartId:cartId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

- (void)createCartDeliveryAddressForUserId:(NSString*)userId
                                 andCartId:(NSString*)cartId
                                withParams:(NSDictionary*)params
                                andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"create Cart Delivery Address For User Id And Cart Id %@", [self userCartDeliveryAddressURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine POST:[self userCartDeliveryAddressURLForUserId:userId andCartId:cartId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      HYBAddress *address = nil;
                      if([responseObject hyb_isNotBlank]) {
                          address = [HYBAddress addressWithParams:(NSDictionary*)responseObject];
                      }
                      block(address,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)updateCartDeliveryAddressForUserId:(NSString*)userId
                                 andCartId:(NSString*)cartId
                                withParams:(NSDictionary*)params
                                andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update Cart Delivery Address For User Id And Cart Id %@", [self userCartDeliveryAddressURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PUT:[self userCartDeliveryAddressURLForUserId:userId andCartId:cartId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)deleteCartDeliveryAddressForUserId:(NSString*)userId
                                 andCartId:(NSString*)cartId
                                andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Cart Delivery Address For User Id And Cart Id %@", [self userCartDeliveryAddressURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine DELETE:[self userCartDeliveryAddressURLForUserId:userId andCartId:cartId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

- (void)cloneSavedCartForUserId:(NSString*)userId
                      andCartId:(NSString*)cartId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"clone Saved Cart For User Id And Cart Id %@", [self userCloneSavedCartURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine POST:[self userCloneSavedCartURLForUserId:userId andCartId:cartId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      HYBCart *cart = nil;
                      if([responseObject hyb_isNotBlank]) {
                          NSDictionary *savedCartData = responseObject[@"savedCartData"];
                          if([savedCartData hyb_isNotBlank]) {
                              cart = [HYBCart cartWithParams:savedCartData];
                              [cart assignPromotions];
                          }
                      }
                      block(cart,nil);
                  } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      
                      //error anchor
                      [self logError:error];
                      
                  }];
}

- (void)getCartDeliverymodeForUserId:(NSString*)userId
                           andCartId:(NSString*)cartId
                          andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart Delivery Mode For User Id And Cart Id %@", [self userCartDeliverymodeURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartDeliverymodeURLForUserId:userId andCartId:cartId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBDeliveryMode *deliveryMode = nil;
                     if([responseObject hyb_isNotBlank]) {
                         deliveryMode = [HYBDeliveryMode deliveryModeWithParams:(NSDictionary*)responseObject];
                     }
                     block(deliveryMode,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)updateCartDeliverymodeForUserId:(NSString*)userId
                              andCartId:(NSString*)cartId
                             withParams:(NSDictionary*)params
                             andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update Cart Delivery Mode For User Id And Cart Id %@", [self userCartDeliverymodeURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PUT:[self userCartDeliverymodeURLForUserId:userId andCartId:cartId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)deleteCartDeliverymodeForUserId:(NSString*)userId
                              andCartId:(NSString*)cartId
                             andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Cart Delivery Mode For User Id And Cart Id %@", [self userCartDeliverymodeURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine DELETE:[self userCartDeliverymodeURLForUserId:userId andCartId:cartId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}


- (void)getCartDeliverymodesForUserId:(NSString*)userId
                            andCartId:(NSString*)cartId
                           andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart Delivery Modes For User Id And Cart Id %@", [self userCartDeliverymodesURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartDeliverymodesURLForUserId:userId andCartId:cartId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"deliveryModes"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBDeliveryMode *deliveryMode = [HYBDeliveryMode deliveryModeWithParams:(NSDictionary*)object];
                             [tmpArray addObject:deliveryMode];
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


- (void)setCartEmailForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Email For User Id And Cart Id %@", [self userCartEmailURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PUT:[self userCartEmailURLForUserId:userId andCartId:cartId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)getCartEntriesForUserId:(NSString*)userId
                      andCartId:(NSString*)cartId
                     andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart Entries For User Id And Cart Id %@", [self userCartEntriesURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartEntriesURLForUserId:userId andCartId:cartId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"entries"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBOrderEntry *entry = [HYBOrderEntry orderEntryWithParams:(NSDictionary*)object];
                             [tmpArray addObject:entry];
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

- (void)addCartEntryForUserId:(NSString*)userId
                      andCartId:(NSString*)cartId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Entries For User Id And Cart Id %@", [self userCartEntriesURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine POST:[self userCartEntriesURLForUserId:userId andCartId:cartId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      HYBCartModification *cartModification = nil;
                      if([responseObject hyb_isNotBlank]) {
                          cartModification = [HYBCartModification cartModificationWithParams:(NSDictionary*)responseObject];
                      }
                      block(cartModification,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getCartEntryForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
               andEntryNumber:(NSString*)entryNumber
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart Entry For User Id And Cart Id  and Entry Number%@", [self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]);
    
    [self.restEngine GET:[self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBOrderEntry *entry = nil;
                     if([responseObject hyb_isNotBlank]) {
                         entry = [HYBOrderEntry orderEntryWithParams:(NSDictionary*)responseObject];
                     }
                     block(entry,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)replaceCartEntryForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
               andEntryNumber:(NSString*)entryNumber
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Entry For User Id And Cart Id  and Entry Number%@", [self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]);
    
    [self.restEngine PUT:[self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBCartModification *cartModification = nil;
                     if([responseObject hyb_isNotBlank]) {
                         cartModification = [HYBCartModification cartModificationWithParams:(NSDictionary*)responseObject];
                     }
                     block(cartModification,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)updateCartEntryForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                  andEntryNumber:(NSString*)entryNumber
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update Cart Entry For User Id And Cart Id  and Entry Number %@", [self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]);
    
    [self.restEngine PATCH:[self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]
                withParams:params
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       HYBCartModification *cartModification = nil;
                       if([responseObject hyb_isNotBlank]) {
                           cartModification = [HYBCartModification cartModificationWithParams:(NSDictionary*)responseObject];
                       }
                       block(cartModification,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
}


- (void)deleteCartEntryForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                  andEntryNumber:(NSString*)entryNumber
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Cart Entry For User Id And Cart Id  and Entry Number%@", [self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]);
    
    [self.restEngine DELETE:[self userCartEntryURLForUserId:userId andCartId:cartId andEntryNumber:entryNumber]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

- (void)flagCartForDeletionForUserId:(NSString*)userId
                           andCartId:(NSString*)cartId
                          andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"flag Cart For Deletion For User Id And Cart Id  and Entry Number%@", [self userCartFlagForDeletionURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PATCH:[self userCartFlagForDeletionURLForUserId:userId andCartId:cartId]
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       HYBSaveCartResult *saveCartResult = nil;
                       if([responseObject hyb_isNotBlank]) {
                           saveCartResult = [HYBSaveCartResult saveCartResultWithParams:(NSDictionary*)responseObject];
                       }
                       block(saveCartResult,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
}

- (void)createCartPaymentdetailsForUserId:(NSString*)userId
                                andCartId:(NSString*)cartId
                               withParams:(NSDictionary*)params
                               andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"create Cart Paymentdetails For User Id and Cart Id%@",[self userCartPaymentdetailsURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine POST:[self userCartPaymentdetailsURLForUserId:userId andCartId:cartId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      HYBPaymentDetails *paymentDetails = nil;
                      if([responseObject hyb_isNotBlank]) {
                          paymentDetails = [HYBPaymentDetails paymentDetailsWithParams:(NSDictionary*)responseObject];
                      }
                      block(paymentDetails,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)updateCartPaymentdetailsForUserId:(NSString*)userId
                             andCartId:(NSString*)cartId
                            withParams:(NSDictionary*)params
                            andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Paymentdetails For User Id and Cart Id%@",[self userCartPaymentdetailsURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PUT:[self userCartPaymentdetailsURLForUserId:userId andCartId:cartId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}


- (void)getCartPromotionsForUserId:(NSString*)userId
                         andCartId:(NSString*)cartId
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart Promotions For User Id and Cart Id%@",[self userCartPromotionsURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartPromotionsURLForUserId:userId andCartId:cartId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"promotions"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBPromotion *promotion = [HYBPromotion promotionWithParams:(NSDictionary*)object];
                             [tmpArray addObject:promotion];
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

- (void)setCartPromotionForUserId:(NSString*)userId
                         andCartId:(NSString*)cartId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Promotions For User Id and Cart Id%@",[self userCartPromotionsURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine POST:[self userCartPromotionsURLForUserId:userId andCartId:cartId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      block(SUCCESS_TAG,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getCartPromotionForUserId:(NSString*)userId
                        andCartId:(NSString*)cartId
                   andPromotionId:(NSString*)promotionId
                       andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Promotion For User Id and Cart Id and Promotion Id %@",[self userCartPromotionURLForUserId:userId andCartId:cartId andPromotionId:promotionId]);
    
    [self.restEngine GET:[self userCartPromotionURLForUserId:userId andCartId:cartId andPromotionId:promotionId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBPromotion *promotion = nil;
                     if([responseObject hyb_isNotBlank]) {
                         promotion = [HYBPromotion promotionWithParams:(NSDictionary*)responseObject];
                     }
                     block(promotion,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)deleteCartPromotionForUserId:(NSString*)userId
                           andCartId:(NSString*)cartId
                      andPromotionId:(NSString*)promotionId
                          andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Cart Promotion For User Id and Cart Id and Promotion Id %@",[self userCartPromotionURLForUserId:userId andCartId:cartId andPromotionId:promotionId]);
    
    [self.restEngine DELETE:[self userCartPromotionURLForUserId:userId andCartId:cartId andPromotionId:promotionId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

- (void)restoreSavedcartForUserId:(NSString*)userId
                        andCartId:(NSString*)cartId
                       andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"restore Saved Cart For User Id and Cart Id %@",[self userCartRestoresavedcartURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PATCH:[self userCartRestoresavedcartURLForUserId:userId andCartId:cartId]
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       HYBCart *cart = nil;
                       if([responseObject hyb_isNotBlank]) {
                           NSDictionary *savedCartData = responseObject[@"savedCartData"];
                           if([savedCartData hyb_isNotBlank]) {
                               cart = [HYBCart cartWithParams:savedCartData];
                               [cart assignPromotions];
                           }
                       }
                       block(cart,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
}

- (void)saveCartForUserId:(NSString*)userId
                andCartId:(NSString*)cartId
               withParams:(NSDictionary*)params
               andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"saved Cart For User Id and Cart Id %@",[self userCartSaveURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine PATCH:[self userCartSaveURLForUserId:userId andCartId:cartId]
                withParams:params
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       HYBCart *cart = nil;
                       if([responseObject hyb_isNotBlank]) {
                           NSDictionary *savedCartData = responseObject[@"savedCartData"];
                           if([savedCartData hyb_isNotBlank]) {
                               cart = [HYBCart cartWithParams:savedCartData];
                               [cart assignPromotions];
                           }
                       }
                       block(cart,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
}

- (void)getSavedcartForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
                   andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Saved Cart For User Id and Cart Id %@",[self userCartSavedcartURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartSavedcartURLForUserId:userId andCartId:cartId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBCart *cart = nil;
                     if([responseObject hyb_isNotBlank]) {
                         NSDictionary *savedCartData = responseObject[@"savedCartData"];
                         if([savedCartData hyb_isNotBlank]) {
                             cart = [HYBCart cartWithParams:savedCartData];
                             [cart assignPromotions];
                         }
                     }
                     block(cart,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)getCartVouchersForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Cart Vouchers For User Id and Cart Id %@",[self userCartVouchersURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartVouchersURLForUserId:userId andCartId:cartId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"vouchers"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBVoucher *voucher = [HYBVoucher voucherWithParams:(NSDictionary*)object];
                             [tmpArray addObject:voucher];
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

- (void)setCartVoucherForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Cart Vouchers For User Id and Cart Id %@",[self userCartVouchersURLForUserId:userId andCartId:cartId]);
    
    [self.restEngine GET:[self userCartVouchersURLForUserId:userId andCartId:cartId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
    
}

- (void)deleteCartVoucherForUserId:(NSString*)userId
                         andCartId:(NSString*)cartId
                      andVoucherId:(NSString*)voucherId
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Cart Voucher For User Id and Cart Id and Voucher Id %@",[self userCartVoucherURLForUserId:userId andCartId:cartId andVoucherId:voucherId]);
    
    [self.restEngine DELETE:[self userCartVoucherURLForUserId:userId andCartId:cartId andVoucherId:voucherId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
}

#pragma mark user profile

- (void)getUserCustomergroupsForUserId:(NSString*)userId
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Customergroups User Id %@",[self userCustomergroupsURLForUserId:userId]);
    
    [self.restEngine GET:[self userCustomergroupsURLForUserId:userId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"userGroups"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBUserGroup *group = [HYBUserGroup userGroupWithParams:(NSDictionary*)object];
                             [tmpArray addObject:group];
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

- (void)updateUserLoginForUserId:(NSString*)userId
               withParams:(NSDictionary*)params
               andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Login For User Id %@",[self userCustomergroupsURLForUserId:userId]);
    
    [self.restEngine PUT:[self userLoginURLForUserId:userId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

#pragma mark orders

- (void)countOrdersForUserId:(NSString*)userId
                  withParams:(NSDictionary*)params
                  andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"count Orders For User Id %@",[self userOrdersURLForUserId:userId]);
    
    [self.restEngine HEAD:[self userOrdersURLForUserId:userId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      NSString *object = [operation.response.allHeaderFields objectForKey:@"X-Total-Count"];
                      block(object,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
    
}


- (void)getOrdersForUserId:(NSString*)userId
                withParams:(NSDictionary*)params
                andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Orders For User Id %@",[self userOrdersURLForUserId:userId]);
    
    [self.restEngine GET:[self userOrdersURLForUserId:userId]
              withParams:[NSDictionary FULLFields:params]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"orders"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBOrderHistory *order = [HYBOrderHistory orderHistoryWithParams:(NSDictionary*)object];
                             [tmpArray addObject:order];
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


- (void)placeOrderForUserId:(NSString*)userId
                 withParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"place Order For User Id %@",[self userOrdersURLForUserId:userId]);
    
    [self.restEngine POST:[self userOrdersURLForUserId:userId]
               withParams:params
                  success:^(AFHTTPRequestOperation *operation, id responseObject) {
                      HYBOrder *order = nil;
                      if([responseObject hyb_isNotBlank]) {
                          order =  [HYBOrder orderWithParams:(NSDictionary*)responseObject];
                      }
                      block(order,nil);
                  }
     
                  failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                      //error anchor
                      [self logError:error];
                      block(nil,error);
                  }];
}

- (void)getOrderForUserId:(NSString*)userId
             andOrderCode:(NSString*)code
               andExecute:(void (^)(id, NSError *))block  {
    
    NSLog(@"get Order For User Id and Order Code %@",[self userOrderURLForUserId:userId andOrderCode:code]);
    
    [self.restEngine GET:[self userOrderURLForUserId:userId andOrderCode:code]
              withParams:[NSDictionary FULLFields]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBOrder *order = nil;
                     if([responseObject hyb_isNotBlank]) {
                         order =  [HYBOrder orderWithParams:(NSDictionary*)responseObject];
                     }
                     block(order,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)updateUserPasswordForUserId:(NSString*)userId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update Password For User Id %@", [self userPasswordURLForUserId:userId]);
    
    [self.restEngine PUT:[self userPasswordURLForUserId:userId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
}

- (void)getPaymentdetailsListForUserId:(NSString*)userId
                            withParams:(NSDictionary*)params
                            andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Paymentdetails List For User Id %@", [self userPaymentdetailsListURLForUserId:userId]);
    
    [self.restEngine GET:[self userPaymentdetailsListURLForUserId:userId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     
                     NSArray *objects = (NSArray*)[responseObject objectForKey:@"payments"];
                     NSMutableArray *tmpArray = nil;
                     
                     if([objects hyb_isNotBlank]) {
                         tmpArray = [NSMutableArray array];
                         for (id object in objects) {
                             HYBPaymentDetails *paymentDetails = [HYBPaymentDetails paymentDetailsWithParams:(NSDictionary*)object];
                             [tmpArray addObject:paymentDetails];
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

- (void)getUserPaymentdetailsForUserId:(NSString*)userId
               andPaymentdetailsId:(NSString*)paymentdetailsId
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"get Paymentdetails For User Id and Paymentdetails Id %@", [self userPaymentdetailsListURLForUserId:userId]);
    
    [self.restEngine GET:[self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBPaymentDetails *paymentDetails = nil;
                     if([responseObject hyb_isNotBlank]) {
                         paymentDetails = [HYBPaymentDetails paymentDetailsWithParams:(NSDictionary*)responseObject];
                     }
                     block(paymentDetails,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
    
}

- (void)replaceUserPaymentdetailsForUserId:(NSString*)userId
               andPaymentdetailsId:(NSString*)paymentdetailsId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"set Paymentdetails For User Id and Paymentdetails Id %@", [self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]);
    
    [self.restEngine PUT:[self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]
              withParams:params
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     block(SUCCESS_TAG,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
    
}

- (void)updateUserPaymentdetailsForUserId:(NSString*)userId
                  andPaymentdetailsId:(NSString*)paymentdetailsId
                           withParams:(NSDictionary*)params
                           andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"update Paymentdetails For User Id and Paymentdetails Id %@", [self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]);
    
    [self.restEngine PATCH:[self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]
                withParams:params
                   success:^(AFHTTPRequestOperation *operation, id responseObject) {
                       block(SUCCESS_TAG,nil);
                   }
     
                   failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                       //error anchor
                       [self logError:error];
                       block(nil,error);
                   }];
    
}

- (void)deleteUserPaymentdetailsForUserId:(NSString*)userId
                  andPaymentdetailsId:(NSString*)paymentdetailsId
                           andExecute:(void (^)(id, NSError *))block {
    
    NSLog(@"delete Paymentdetails For User Id and Paymentdetails Id %@", [self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]);
    
    [self.restEngine DELETE:[self userPaymentdetailsURLForUserId:userId andPaymentdetailsId:paymentdetailsId]
                    success:^(AFHTTPRequestOperation *operation, id responseObject) {
                        block(SUCCESS_TAG,nil);
                    }
     
                    failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                        //error anchor
                        [self logError:error];
                        block(nil,error);
                    }];
    
}

#pragma mark vouchers

- (void)getVoucherForVoucherCode:(NSString*)code
                      andExecute:(void (^)(id, NSError *))block {
    
    [self.restEngine GET:[self vouchersURLForVoucherCode:code]
                 success:^(AFHTTPRequestOperation *operation, id responseObject) {
                     HYBVoucher *voucher = nil;
                     if([responseObject hyb_isNotBlank]) {
                         voucher = [HYBVoucher voucherWithParams:(NSDictionary*)responseObject];
                     }
                     block(voucher,nil);
                 }
     
                 failure:^(AFHTTPRequestOperation *operation, NSError *error) {
                     //error anchor
                     [self logError:error];
                     block(nil,error);
                 }];
    
}


@end
