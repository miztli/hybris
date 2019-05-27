//
//  HYBStorage.h
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

@interface HYBStorage : NSObject

/**
 *  store object on the device with given key (currently using NSUserDefaults)
 *
 *  @param object object
 *  @param key    key
 */
+ (void)storeObject:(id)object forKey:(NSString*)key;

/**
 *  retrieve saved object for given key
 *
 *  @param key key
 *
 *  @return object
 */
+ (id)objectForKey:(NSString*)key;

/**
 *  delete stored object for given key
 *
 *  @param key key
 */
+ (void)deleteObjectForKey:(NSString*)key;

/**
 *  batch delete of stored objects for given keys
 *
 *  @param key key
 */
+ (void)deleteObjectsForKeys:(NSArray*)keys;


@end
