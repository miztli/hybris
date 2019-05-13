//
//  HYBScanProtocol.m
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
#import "HYBScanProtocol.h"
#import "NSArray+modify.h"

@implementation HYBScanProtocol

- (instancetype)init {
    if(self = [super init]) {
        _pattern = [NSArray array];
    }
    
    return self;
}

#pragma mark components

- (void)addPatternComponent:(NSString *)component {
   _pattern = [_pattern addElement:component];
}

- (void)removePatternComponent:(NSString *)component {
   _pattern = [_pattern removeElement:component];
}

- (NSString*)patternDescription {
    
    NSMutableString *tmpString = [NSMutableString string];
        
    for (NSString *component in _pattern) {
        [tmpString appendString:component];
    }
    
    return [NSString stringWithString:tmpString];
}

- (void)triggerActionWithParams:(NSDictionary *)params {
        
    if (!_target || !_action) {
        NSLog(@"no receiver or no action, bail out");
        return;
    }
    
     void (*imp)(id, SEL, id) = (void(*)(id,SEL,id))[_target methodForSelector:_action];
     if( imp ) imp(_target, _action, params);

}

@end
