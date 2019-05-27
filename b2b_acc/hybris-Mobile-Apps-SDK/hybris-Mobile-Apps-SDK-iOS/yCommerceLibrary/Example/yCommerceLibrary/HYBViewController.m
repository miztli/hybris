//
// HYBViewController.m
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

#import "HYBViewController.h"
#import "HYBB2CService.h"
#import "MYEnvironmentConfig.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "MYEnvironmentConfig+HYBAdditionalMethods.h"
#import "PromiseKit.h"
#import "HYBCache.h"

@interface HYBViewController ()

@property (nonatomic) HYBB2CService *backendService;
@property (nonatomic) HYBCart *tmpCart;
@end

@implementation HYBViewController

BOOL verbose = YES;

- (void)viewDidLoad {
    
    [super viewDidLoad];
    
    [self setup];
    
    [self loginAsGuest]
    
    /*
    .then(^(id responseObject) {
        if(verbose) NSLog(@"%@",[responseObject description]);
        return [self getCart];
    })
    */
    
    .then(^(id responseObject) {
        if(verbose) NSLog(@"%@",[responseObject description]);
        _tmpCart = (HYBCart*)responseObject;
        return [self makeGuestTrustedClientAndExecute];
    })
    
    .then(^(id responseObject) {
        if(verbose) NSLog(@"%@",[responseObject description]);
        return [self registerUser];
    })
    
    .then(^(id responseObject) {
        if(verbose) NSLog(@"%@",[responseObject description]);
        //NSArray *products = (NSArray*)responseObject;
    })
    
    .catch(^(NSError *error) {
        NSLog(@"error %@", error.localizedDescription);
    });
    
    
    
}

- (PMKPromise *)registerUser {
    
    NSLog(@"PMKPromise registerUser");
    
    NSDictionary *params = @{
                             @"firstName" : @"Alison",
                             @"lastName" : @"Blaire",
                             @"password" : @"Ab12341234-",
                             //@"guid" : _tmpCart.guid,
                             @"login" : @"dazzler@playm.com",
                             @"titleCode" : @"mr"
                             };
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [_backendService registerUserWithParams:params
                                      andExecute:^(id responseObject, NSError* error) {
                                          if (error) {
                                              reject(error);
                                          } else {
                                              fulfill(responseObject);
                                          }
                                      }];
    }];
}

- (PMKPromise *)getCart {
    
    NSLog(@"PMKPromise getCart");
    
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [_backendService retrieveCartByUserIdFromCurrentCartsCreateIfNothingPresent:GUEST_USER
                                     andExecute:^(id responseObject, NSError* error) {
                                         if (error) {
                                             reject(error);
                                         } else {
                                             fulfill(responseObject);
                                         }
                                     }];
    }];
}

- (void)setup {
    
    NSDictionary *config = [[MYEnvironmentConfig sharedConfig] configValues];
    
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            [NSNumber numberWithBool:YES],USESSL,
                            @"v2",OCCVERSION,
                            //config[@"CURRENT_CATALOG_ATTRIBUTE_KEY"],CATALOGID,
                            @"electronicsProductCatalog",CATALOGID,
                            config[@"CURRENT_CATALOG_VERSION_ATTRIBUTE_KEY"],CATALOGVERSIONID,
                            @"dev-b2bmobile-1.yrdrt.fra.hybris.com",BACKENDHOST,
                            //config[@"HOST_ATTRIBUTE_KEY"],BACKENDHOST,
                            config[@"PORT_ATTRIBUTE_KEY"],BACKENDPORT,
                            //config[@"CURRENT_STORE_ATTRIBUTE_KEY"],STOREID,
                            @"electronics",STOREID,
                            config[@"defaultTestUser"],USERID,
                            nil];
    
    _backendService = [[HYBB2CService alloc] initWithParams:params];
    
    NSLog(@"%@",[_backendService description]);
    
}

- (PMKPromise *)login {
    
    NSLog(@"PMKPromise login");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [_backendService authenticateUsername:@"deadpool@playm.com"
                                 withPassword:@"12341234"
                                   andExecute:^(id responseObject, NSError* error) {
                                       if (error) {
                                           reject(error);
                                       } else {
                                           fulfill(responseObject);
                                       }
                                   }];
    }];
    
}

- (PMKPromise *)loginAsGuest {
    
    NSLog(@"PMKPromise loginAsGuest");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        _backendService.userId = GUEST_USER;
        fulfill(_backendService.userId);
    }];
    
}

- (PMKPromise *)makeUserTrusted {
    
    NSLog(@"PMKPromise makeUserTrusted");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [_backendService makeUserTrustedClientAndExecute:^(id responseObject, NSError* error) {
                                       if (error) {
                                           reject(error);
                                       } else {
                                           fulfill(responseObject);
                                       }
                                   }];
    }];
    
}

- (PMKPromise *)makeGuestTrustedClientAndExecute {
    
    NSLog(@"PMKPromise makeGuestTrustedClientAndExecute");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [_backendService makeGuestTrustedClientAndExecute:^(id responseObject, NSError* error) {
            if (error) {
                reject(error);
            } else {
                fulfill(responseObject);
            }
        }];
    }];
    
}



@end
