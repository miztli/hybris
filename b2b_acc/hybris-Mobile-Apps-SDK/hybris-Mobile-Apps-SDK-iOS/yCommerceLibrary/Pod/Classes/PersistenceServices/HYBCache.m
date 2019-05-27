//
//  HYBCache.m
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

#import "HYBCache.h"


static HYBCache *cache = nil;

@interface HYBCache ()

@property (nonatomic) NSMutableDictionary *mainCache;

@end

@implementation HYBCache

+ (instancetype)shared {
    if (!cache) {
        cache = [HYBCache new];
    }
    return cache;
}

- (instancetype)init {
    if (self = [super init]) {
        _mainCache = [HYBStorage objectForKey:MAIN_CACHE];
        if (!_mainCache) {
            _mainCache = [NSMutableDictionary dictionary];
        }
    }
    
    return self;
}

+ (void)load {
    [HYBCache shared].mainCache = [HYBStorage objectForKey:MAIN_CACHE];
    if (![HYBCache shared].mainCache) {
        [HYBCache shared].mainCache = [NSMutableDictionary dictionary];
    }
}

+ (void)save {
    [HYBStorage storeObject:[HYBCache shared].mainCache forKey:MAIN_CACHE];
}

+ (void)clear {
    [HYBCache shared].mainCache = nil;
    [HYBCache shared].mainCache = [NSMutableDictionary dictionary];
    [HYBStorage deleteObjectForKey:MAIN_CACHE];
}

+ (void)cacheObject:(id)object forKey:(NSString*)key {
    
    NSMutableDictionary *tmpDict = [HYBCache shared].mainCache;
    
    @synchronized(tmpDict) {
        [tmpDict setObject:object forKey:key];
    }
    
}

+ (id)cachedObjectForKey:(NSString*)key {
    return [HYBCache shared].mainCache[key];
}

+ (void)uncacheObjectForKey:(NSString*)key {
    [[HYBCache shared].mainCache removeObjectForKey:key];
}

+ (NSArray*)allKeys {
    return [[HYBCache shared].mainCache allKeys];
}

+ (NSUInteger)count {
    return [[[HYBCache shared].mainCache allKeys] count];
}

@end
