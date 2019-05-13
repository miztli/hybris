//
// NSString+HYStringUtils.h
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

/**
* Category to add more methods to NSString.
*/
@interface NSString (HYStringUtils)
- (BOOL)contains:(NSString *)string;

- (NSString *)substringFrom:(NSInteger)from to:(NSInteger)to;

- (NSString *)stripWhiteSpace;

- (NSString*)URLEncode;


@end