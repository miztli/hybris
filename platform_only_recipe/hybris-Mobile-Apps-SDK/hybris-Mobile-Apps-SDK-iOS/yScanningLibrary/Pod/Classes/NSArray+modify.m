//
//  NSArray+modify.m
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
#import "NSArray+modify.h"

@implementation NSArray (modify)


- (BOOL)containsString:(NSString *)string {
    
    if(!string) return NO;
    
    for(NSString *obj in self) {
        if ([string isEqualToString:obj]) {
            return YES;
        }
    }
    
    return NO;
}

- (NSArray*)addElement:(NSString *)element {
    
    if (element) {
        
        NSMutableArray *tmpArray = [NSMutableArray arrayWithArray:self];
        
        [tmpArray addObject:element];
        
        return [NSArray arrayWithArray:tmpArray];
    }
    
    return self;
}

- (NSArray*)removeElement:(NSString *)element {
    
    if(element) {
        NSMutableArray *tmpArray = [NSMutableArray arrayWithArray:self];
        BOOL didChange = NO;
        
        for(NSString *obj in tmpArray) {
            if ([element isEqualToString:obj]) {
                [tmpArray removeObject:obj];
                didChange = YES;
                break;
            }
        }
        
        if(didChange) return [NSArray arrayWithArray:tmpArray];
        
    }
    
    return self;
}


- (NSArray*)addObject:(id)object {
    
    if (object && ![self containsObject:object]) {
        NSMutableArray *tmpArray = [NSMutableArray arrayWithArray:self];
        [tmpArray addObject:object];
        return [NSArray arrayWithArray:tmpArray];
    }
    
    return self;
}

- (NSArray*)removeObject:(id)object; {
    
    if(object) {
        NSMutableArray *tmpArray = [NSMutableArray arrayWithArray:self];
        [tmpArray removeObject:object];
        return [NSArray arrayWithArray:tmpArray];
        
    }
    
    return self;
}
@end
