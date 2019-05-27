//
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


#import "MYEnvironmentConfig+HYBAdditionalMethods.h"
#import "MYEnvironmentConfig.h"
#import "NSObject+HYBAdditionalMethods.h"

#define xstr(s) str(s)
#define str(s) #s

@implementation MYEnvironmentConfig (HYBAdditionalMethods)

/**
* Dynamic buildUserId property to retrieve from the build.
* Define the property as a preprocessed macro and pass it either in xcode with a default value
* or from the console if you execute the build.
*/
- (NSString *)buildUserId {
    
    NSString *buildUserIdKey = [NSString stringWithFormat:@"%s", xstr(BUILD_USER_ID)];
    NSString *buildUser = [self configValueForKey:buildUserIdKey];

    if (![buildUser hyb_isNotBlank]) {
        buildUser = [self configValueForKey:DEFAULT_BUILD_USER_KEY];
        if (![buildUser hyb_isNotBlank]) {
            [NSException raise:@"Expected config value not present" format:@"Your configuration file seems not to contain the value for the key %@", DEFAULT_BUILD_USER_KEY];
        }
    }
    return buildUser;
}

- (NSString*)feedbackRecipient {
    NSString *email = nil;
    
    NSString *feedbackMail =  [self configValueForKey:DEFAULT_FEEDBACK_KEY];
    if ([feedbackMail hyb_isNotBlank]) email = feedbackMail;
    
    return email;
}

@end