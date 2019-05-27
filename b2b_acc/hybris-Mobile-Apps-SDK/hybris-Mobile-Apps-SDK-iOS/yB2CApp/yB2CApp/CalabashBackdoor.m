//
//  CalabashBackdoor.m
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

#import "CalabashBackdoor.h"
#import "HYBConstants.h"
#import "HYBAppDelegate.h"
#import "HYBDrawerController.h"
#import "UIViewController+Navigation.h"
#import "HYBB2CService.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "PromiseKit.h"

static CalabashBackdoor *calabashBackdoor = nil;

@implementation CalabashBackdoor

//singleton

+(id)sharedInstance {
    if(!calabashBackdoor) calabashBackdoor = [CalabashBackdoor new];
    return calabashBackdoor;
}

#pragma mark utilities
//utilities
- (NSArray*)explodeParams:(NSString*)params {
    return [params componentsSeparatedByString:@";"];
}

- (HYBAppDelegate*)getDelegate {
    return (HYBAppDelegate*)[[UIApplication sharedApplication] delegate];
}

- (HYBDrawerController*)drawerController {
    return (HYBDrawerController*)[self getDelegate].window.rootViewController;
}

- (UIViewController*)centerController {
    return [[self drawerController] centerViewController];
}

- (id)backEndService {
    return [[self getDelegate] backEndService];
}

#pragma mark core methods


//backdoorLogin

- (NSString *)backdoorLogin:(NSString *)paramsAsString {
    
    NSString *resultString = nil;
    NSArray *params = [self explodeParams:paramsAsString];
    
    if(params) {
        NSString *commands = (NSString *)params[0];
        NSString *username = (NSString *)params[1];
        NSString *password = (NSString *)params[2];
        
        
        //go
        [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            [[self backEndService] authenticateUsername:username
                                           withPassword:password
                                             andExecute:^(id responseObject, NSError* error) {
                                                 if (error) {
                                                     reject(error);
                                                 } else {
                                                     fulfill(responseObject);
                                                 }
                                             }];
        }]
        
        .then(^(id responseObject) {
            return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
                
                return [[self backEndService] getCartsForUserId:[[self backEndService] userId]
                                                     withParams:nil
                                                     andExecute:^(id responseObject, NSError* error) {
                                                         if (error) {
                                                             reject(error);
                                                         } else {
                                                             fulfill(responseObject);
                                                         }
                                                     }];
            }];;
        })
        
        .then(^(id responseObject) {
            HYBCart *anonymousCart = [[self backEndService] currentCartFromCache];
            
            NSArray *carts = (NSArray*)responseObject;
            
            if ([carts hyb_isNotBlank]) {
                //merge current anonymous cart
                
                HYBCart *firstCart = (HYBCart*)[carts firstObject];
                
                if([anonymousCart.guid isEqualToString:firstCart.guid]) {
                    return firstCart;
                } else {
                    return (HYBCart*)[PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
                        
                        [[self backEndService] mergeAnonymouCartWithGuid:anonymousCart.guid
                                                          toCartWithGuid:firstCart.guid
                                                                toUserId:[[self backEndService] userId]
                                                              andExecute:^(id responseObject, NSError* error) {
                                                                  if (error) {
                                                                      reject(error);
                                                                  } else {
                                                                      fulfill(responseObject);
                                                                  }
                                                              }];
                    }];
                    
                }
            } else {
                //assign anonymous to user
                
                return (HYBCart*)[PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
                    
                    [[self backEndService] assignAnonymouCartWithGuid:anonymousCart.guid
                                                             toUserId:[[self backEndService] userId]
                                                           andExecute:^(id responseObject, NSError* error) {
                                                               if (error) {
                                                                   reject(error);
                                                               } else {
                                                                   fulfill(responseObject);
                                                               }
                                                           }];
                }];
            }
        })
        
        .then(^(HYBCart *cart) {
            [[self backEndService] saveCartInCacheNotifyObservers:cart];
            [self performSelectorOnMainThread:@selector(backdoorNavigateTo:) withObject:commands waitUntilDone:YES];
            
        })
        
        .catch(^(NSError *error) {
            DDLogDebug(@"Error retrieved ...");
            
        });
        
        
        
        
        resultString =  @"Logged In";
    } else {
        resultString = @"backdoorLogin : Params MISSING";
    }
    
    return resultString;
    
}


//backdoorNavigateTo

- (NSString *)backdoorNavigateTo:(NSString *)paramsAsString {
    
    [[self drawerController] dismissModalIfNeeded];
    
    [[self drawerController] closeDrawersIfNeeded];
    
    
    
    NSString *resultString = nil;
    
    if(paramsAsString) {
        NSString *destination = [NSString stringWithString:paramsAsString];
        if ([destination isEqualToString:@"DashboardVC"]) {
            //open dashboard page
            [[self centerController] openDashboard];
            resultString = @"DashboardVC";
        }
        
        else if ([destination isEqualToString:@"OrdersVC"]) {
            //open orders page
            [[self centerController] openOrders];
            resultString = @"OrdersVC";
        }
        
        else if ([destination isEqualToString:@"AccountVC"]) {
            //open account page
            [[self centerController] openAccount];
            resultString = @"AccountVC";
        }
        
        else if ([destination isEqualToString:@"CatalogVC"]) {
            //open catalog page
            resultString = @"CatalogVC";
            [[NSUserDefaults standardUserDefaults] removeObjectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
            [[NSUserDefaults standardUserDefaults] synchronize];
            [[self centerController] openCatalog];
        }
        
        else if ([destination isEqualToString:@"CheckoutVC"]) {
            //open checkout page
            resultString = @"CheckoutVC";
            [[self centerController] openCheckout];
        }
        
        else if ([destination isEqualToString:@"CartVC"]) {
            //open checkout page
            resultString = @"CartVC";
            [[self centerController] toggleRightDrawer];
        }
        
        else {
            resultString = @"backdoorNavigateTo : Params UNKNOWN";
        }
    } else {
        resultString = @"backdoorNavigateTo : Params MISSING";
    }
    
    return resultString;
}


//backdoorGoProductdetail

- (NSString *)backdoorGoProductdetail:(NSString *)paramsAsString {
    
    [[self drawerController] closeDrawersIfNeeded];
    
    NSString *resultString = nil;
    
    if(paramsAsString) {
        //load product for given product id
        NSString *productId = [NSString stringWithString:paramsAsString];
        
        [[self backEndService] getProductForCode:productId
                                     andExecute:^(HYBProduct *product, NSError *error) {
                                         if (error) {
                                             DDLogError(@"Error while retrieving product with code %@, reason:", [error localizedDescription]);
                                         } else {
                                             //open product detail page
                                             [[self centerController] pushDetailControllerWithProduct:product toggleDrawer:NO];
                                         }
                                     }];
        
        resultString = @"ProductDetailVC: loading product";
    } else {
        resultString = @"backdoorGoProductdetail : Params MISSING";
    }
    
    return resultString;
}


@end
