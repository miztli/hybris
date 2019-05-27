//
//  HYBScanInterpreter.m
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

#import "HYBScanInterpreter.h"
#import "NSArray+modify.h"

@implementation HYBScanInterpreter

- (instancetype)init {
    if(self = [super init]) {
        _protocols = [NSArray array];
    }
    
    return self;
}

- (HYBScanProtocol*)createProtocolNamed:(NSString*)name {
    
    HYBScanProtocol *protocol = [HYBScanProtocol new];
    protocol.name = name;
    
    [self addProtocol:protocol];
    
    return protocol;
}

- (void)protocolNamed:(NSString*)protocolName setAction:(SEL)action {
    [self protocolNamed:protocolName].action = action;
}

- (void)protocolNamed:(NSString*)protocolName setTarget:(id)target {
    [self protocolNamed:protocolName].target = target;
}

- (void)protocolNamed:(NSString*)protocolName addPatternComponent:(NSString*)component {
    [[self protocolNamed:protocolName] addPatternComponent:component];
}

- (void)addProtocol:(HYBScanProtocol *)protocol {
    _protocols = [_protocols addObject:protocol];
}

- (void)removeProtocol:(HYBScanProtocol *)protocol {
    _protocols = [_protocols removeObject:protocol];
}

- (HYBScanProtocol*)protocolNamed:(NSString*)protocolName {
    for (HYBScanProtocol *protocol in _protocols) {
        if([protocol.name isEqualToString:protocolName]) {
            return protocol;
        }
    }
    return nil;
}

- (BOOL)processString:(NSString*)string {
    BOOL didFoundSomething = NO;
    
    for (HYBScanProtocol *protocol in _protocols) {
        if([self processString:string withProtocol:protocol]) {
            didFoundSomething = YES;
        }
    }
    
    return didFoundSomething;
}

//  check that received string conforms to a pattern
//  ex :
//
//  products://324234/addToCart/100
//
//  conforms to
//
//  products://$(product_id)/addToCart/$(quantity)
//
//  then trigger according action

- (BOOL)processString:(NSString*)string
    withProtocolNamed:(NSString*)protocolName {
    return [self processString:string withProtocol:[self protocolNamed:protocolName]];
}

- (BOOL)processString:(NSString*)string
         withProtocol:(HYBScanProtocol*)protocol {
    
    /*
     NSLog(@"----------------------------");
     NSLog(@"ProcessString %@", string);
     NSLog(@"With protocol %@", protocol.patternDescription);
     NSLog(@"----------------------------");
    */
    
    NSUInteger maxStringLength = [string length];
    
    NSRange rangeToSearch = NSMakeRange(0, maxStringLength);
    
    NSString *tmpString = nil;
    
    NSMutableDictionary *tmpDict = [NSMutableDictionary dictionary];
    
    BOOL endOfLine = NO;
    BOOL mismatch = NO;
    
    //for (int i = (int)protocol.pattern.count - 1; i >=0 ; i--) {
    for (int i = 0 ; i <  (int)protocol.pattern.count; i++) {
        
        NSString *component = [NSString stringWithString:protocol.pattern[i]];
        
        NSLog(@"look for '%@' component in range %@", component, NSStringFromRange(rangeToSearch));
        
        if([self checkVariableForComponent:component]) {
            
            //special case, protocol is a single var
            if (protocol.pattern.count == 1) {
                
                endOfLine = YES;
                
                NSCharacterSet *digits = [NSCharacterSet decimalDigitCharacterSet];
                BOOL valid = [[[NSString stringWithString:string] stringByTrimmingCharactersInSet:digits] isEqualToString:@""];
                
                if (valid) {
                    [tmpDict setValue:string forKey:[self trimVarComponent:component]];
                } else {
                    mismatch = YES;
                }

                break;

            }
            
            else {
                
                NSLog(@"component '%@' should be a variable", component);
                tmpString = [string substringWithRange:rangeToSearch];
                NSLog(@"in %@",tmpString);
                
                if(i+1 <= (int)protocol.pattern.count) {
                    
                    if (i == protocol.pattern.count - 1) {
                        
                        NSLog(@"tmpString '%@'",tmpString);
                        
                        NSCharacterSet *digits = [NSCharacterSet decimalDigitCharacterSet];
                        BOOL valid = [[[NSString stringWithString:tmpString] stringByTrimmingCharactersInSet:digits] isEqualToString:@""];
                        
                        if (valid && tmpString.length>0) {
                            endOfLine = YES;
                            [tmpDict setValue:tmpString forKey:[self trimVarComponent:component]];
                        } else {
                            mismatch = YES;
                        }
                        
                        break;

                    } else {
                        NSString * nextComp = [NSString stringWithString:protocol.pattern[i+1]];
                        NSLog(@"look for nextComp '%@'",nextComp);
                        
                        NSRange rangeOfNextComponent = [string rangeOfString:nextComp
                                                                     options:0
                                                                       range:rangeToSearch];
                        
                        if(rangeOfNextComponent.location == NSNotFound) {
                            mismatch = YES;
                            break;
                        } else {
                            NSLog(@"%@ at %@",nextComp,NSStringFromRange(rangeOfNextComponent));
                            NSString *value = [string substringWithRange:NSMakeRange(rangeToSearch.location,rangeOfNextComponent.location-rangeToSearch.location)];
                            NSLog(@"value '%@'",value);
                            
                            rangeToSearch = NSMakeRange(rangeToSearch.location+value.length, maxStringLength-(rangeToSearch.location+value.length));
                            
                            [tmpDict setValue:value forKey:[self trimVarComponent:component]];
                        }
                        
                        
                    }
                }
                
                else {
                    mismatch = YES;
                    break;
                }
            }
        } else {
            
            NSRange rangeOfComponent = [string rangeOfString:component
                                                     options:0
                                                       range:rangeToSearch];
            
            if (rangeOfComponent.location == NSNotFound) {
                mismatch = YES;
                break;
            } else {
                NSLog(@"%@ at %@",component,NSStringFromRange(rangeOfComponent));
                
                rangeToSearch = NSMakeRange(rangeOfComponent.location+rangeOfComponent.length, maxStringLength-(rangeOfComponent.location+rangeOfComponent.length));
                
            }
        }
    }
    
    //used material in the original string
    if (!endOfLine && (!mismatch && rangeToSearch.length > 0)) {
        mismatch = YES;
    }
    
    if(mismatch) {
        NSLog(@"pattern - NOT - matching");
        return NO;
    }
    
    NSLog(@"-+- a hit! -+-");
    NSLog(@"vars %@", [tmpDict description]);
    
    NSDictionary *params = nil;
    if([[tmpDict allKeys] count] > 0) params = [NSDictionary dictionaryWithDictionary:tmpDict];
    if(!params) params = [NSDictionary dictionary];
    
    [protocol triggerActionWithParams:params];
    
    return YES;
}

- (NSString*)trimVarComponent:(NSString*)component {
    return [component substringWithRange:NSMakeRange(2, component.length-3)];
}

- (BOOL)checkVariableForComponent:(NSString*)component {
    if (NSEqualRanges([component rangeOfString:@"$("],NSMakeRange(0, 2)) ||
        NSEqualRanges([component rangeOfString:@")"],NSMakeRange(component.length-1, 1))) {
        return YES;
    }
    return NO;
}

@end
