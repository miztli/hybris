//
//  HYBScanProtocol.h
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

/*
 
 -- "interpreter" to initiate the action as described by the protocol defined in the app
 --- the pattern used in protocol is customizable with each implementation (e.g., 
 
 products://234234
 products##234234
 234234-open
 
 To showcase this library we create standalone app with the following protocols:
 
 - scan product id to open product details page (e.g. products://324234/open)
 - scan product id and add to cart (e.g. products://324234/atc)
 - scan barcode and it executes search (e.g. search://pants)
 
 */

#import <Foundation/Foundation.h>

@interface HYBScanProtocol : NSObject

@property (nonatomic) NSString *name;

@property (nonatomic) NSArray *pattern;

@property (nonatomic) SEL action;
@property (nonatomic) id target;

/**
 * add a pattern component to the protocol
 *
 * @param component The component to add
 *
 */
- (void)addPatternComponent:(NSString *)component;

/**
 * remove a pattern component from the protocol
 *
 * @param component The component to remove
 *
 */
- (void)removePatternComponent:(NSString *)component;

/**
 * return readable pattern Description
 *
 * @return NSString the pattern Description
 *
 */
- (NSString*)patternDescription;

/**
 * trigger the protocol action on target
 *
 * @param params The params to use in the action selector (passing variable values)
 *
 */
- (void)triggerActionWithParams:(NSDictionary *)params;

@end
