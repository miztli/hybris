//
// HYBAppDelegate.m
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

#import "NSObject+HYBAdditionalMethods.h"
#import "HYBAppDelegate.h"
#import "HYBMasterNavigationController.h"
#import "UIViewController+Navigation.h"

#import "DDTTYLogger.h"
#import "DDASLLogger.h"
#import "HYBB2CService.h"
#import "HYBStorage.h"

//Used for testing purpose
#import "CalabashBackdoor.h"


#import "MYEnvironmentConfig.h"
#import "MYEnvironmentConfig+HYBAdditionalMethods.h"

@implementation HYBAppDelegate {
    UIImageView *snapshotSecurityBlocker;
}

//Used for testing purpose
//calabash backdoor methods
- (NSString *)backdoorLogin:(NSString *)paramsAsString {
    NSString *result = [[CalabashBackdoor sharedInstance] backdoorLogin:paramsAsString];
    DDLogDebug(@"backdoorLogin result:%@", result);
    return result;
}

- (NSString *)backdoorNavigateTo:(NSString *)paramsAsString {
    NSString *result = [[CalabashBackdoor sharedInstance] backdoorNavigateTo:paramsAsString];
    DDLogDebug(@"backdoorNavigateTo result:%@", result);
    return result;
}

- (NSString *)backdoorGoProductdetail:(NSString *)paramsAsString {
    NSString *result = [[CalabashBackdoor sharedInstance] backdoorGoProductdetail:paramsAsString];
    DDLogDebug(@"backdoorGoProductdetail result:%@", result);
    return result;
}

//app life cycle

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    //initialize Logging
    [DDLog addLogger:[DDASLLogger sharedInstance]];
    [DDLog addLogger:[DDTTYLogger sharedInstance]];
    
    //initi env config
    [MYEnvironmentConfig initSharedConfigWithPList:@"Environments.plist"];
    
    DDLogDebug(@"Configured buildUserId: %@", [[MYEnvironmentConfig sharedConfig] buildUserId]);
    
    //set b2c backend
    _backEndService = [[HYBB2CService alloc] initWithDefaults];
    [_backEndService loadSettings];
    
    
    
   
    //check if old user is still logged in
    
    NSString *currentUserId = [[_backEndService userStorage] objectForKey:LAST_AUTHENTICATED_USER_KEY];
    
    id user = nil;
    
    if (currentUserId) {
         user = [HYBStorage objectForKey:currentUserId];
    }
    
    if ([currentUserId hyb_isNotBlank] && [user hyb_isNotBlank]) {
         DDLogDebug(@"Last user Id Logged : %@", currentUserId);
        
        [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
            
            [_backEndService authenticateUsername:currentUserId
                                       andExecute:^(id responseObject, NSError* error) {
                               if (error) {
                                   reject(error);
                               } else {
                                   fulfill(responseObject);
                               }
                           }];
        }]
        
        .then(^(id responseObject) {
           [_backEndService retrieveCartByUserIdFromCurrentCartsCreateIfNothingPresent:currentUserId
                                                                            andExecute:^(HYBCart *cart, NSError * error) {
                                                                                if (error) {
                                                                                     DDLogDebug(@"Couldn't retrieve cart: %@", error.localizedDescription);
                                                                                }
                                                                            }];
        })
        
        .catch(^(NSError *error) {
           DDLogDebug(@"Couldn't auto-log UserId: %@", currentUserId);
        });

        
        
    } else {
        
        _backEndService.userId = GUEST_USER;
        [_backEndService createCartForUser:GUEST_USER andExecute:^(HYBCart *cart, NSError *error) {
            
            if(!error && [cart hyb_isNotBlank]) {
                [HYBCache cacheObject:cart forKey:CURRENT_CART_KEY];
                [[NSNotificationCenter defaultCenter] postNotificationName:NOTIFICATION_CART_UPDATED object:_backEndService];
                
            }
        }];
    }
    [[NSUserDefaults standardUserDefaults] removeObjectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
    [[NSUserDefaults standardUserDefaults] synchronize];
  
    
    //setup main window
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    self.window.backgroundColor = [UIColor whiteColor];

    //main navigation controller
    self.masterNavigationController = [HYBMasterNavigationController new];
    
    self.masterNavigationController.navigationBarHidden = YES;

    self.window.rootViewController = self.masterNavigationController;
    
    [self.window.rootViewController setupDrawers];
    [self.window makeKeyAndVisible];

    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application {
    //good for her
}

- (UIImageView *)createLogoView {
    UIImageView *imageHolder = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"Logo.png"]];
    imageHolder.contentMode = UIViewContentModeScaleAspectFit;
    return imageHolder;
}

- (void)applicationDidEnterBackground:(UIApplication *)application {
    snapshotSecurityBlocker = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"Background.png"]];
    snapshotSecurityBlocker.frame = self.window.frame;
    snapshotSecurityBlocker.contentMode = UIViewContentModeCenter;

    UIView *logo = [self createLogoView];
    logo.center = snapshotSecurityBlocker.center;
    [snapshotSecurityBlocker addSubview:logo];

    [self.window addSubview:snapshotSecurityBlocker];
}

- (void)applicationDidBecomeActive:(UIApplication *)application{
    if(snapshotSecurityBlocker){
        [snapshotSecurityBlocker removeFromSuperview];
        snapshotSecurityBlocker = nil;
    }
}

@end
