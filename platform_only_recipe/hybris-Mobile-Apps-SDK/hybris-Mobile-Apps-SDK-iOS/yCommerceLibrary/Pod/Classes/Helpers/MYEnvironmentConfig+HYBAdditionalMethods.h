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

#import <Foundation/Foundation.h>
#import "MYEnvironmentConfig.h"

#define DEFAULT_BUILD_USER_KEY  @"defaultTestUser" //@"YULM00574455A" 
#define DEFAULT_FEEDBACK_KEY    @"feedbackRecipient"

@interface MYEnvironmentConfig (HYBAdditionalMethods)
- (NSString *)buildUserId;
- (NSString*)feedbackRecipient;

@end