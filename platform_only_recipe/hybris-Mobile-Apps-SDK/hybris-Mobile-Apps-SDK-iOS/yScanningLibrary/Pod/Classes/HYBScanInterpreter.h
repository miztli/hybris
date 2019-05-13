//
//  HYBScanInterpreter.h
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
#import <AVFoundation/AVFoundation.h>
#import "HYBScanProtocol.h"

@interface HYBScanInterpreter : NSObject

@property (nonatomic) NSArray *protocols;

/**
 * Create an interpratation protocol
 *
 * @param name The name to give to the new protocol
 *
 * @return HYBScanProtocol, a new empty protocol
 */
- (HYBScanProtocol*)createProtocolNamed:(NSString*)name;

/**
 * retrieve an interpratation protocol
 *
 * @param protocolName The name of the protocol to retrieve
 *
 * @return HYBScanProtocol, the protocol
 */
- (HYBScanProtocol*)protocolNamed:(NSString*)protocolName;

/**
 * set the selector the protocol should use
 *
 * @param protocolName name of the protocol to update
 * @param selector selector to link to the protocol
 *
 */
- (void)protocolNamed:(NSString*)protocolName setAction:(SEL)selector;

/**
 * set the target the protocol should use
 *
 * @param protocolName name of the protocol to update
 * @param id target to link to the protocol
 *
 */
- (void)protocolNamed:(NSString*)protocolName setTarget:(id)target;

/**
 * add an element of a pattern the protocol should recognize
 *
 * @param protocolName name of the protocol to update
 * @param component the element to add to the pattern : a string or a variable with the syntax : $(variable_name)
 *
 */
- (void)protocolNamed:(NSString*)protocolName addPatternComponent:(NSString*)component;

/**
 * add a protocol to the interpreter
 *
 * @param protocol the protocol to add
 *
 */
- (void)addProtocol:(HYBScanProtocol *)protocol;

/**
 * remove a protocol from the interpreter
 *
 * @param protocol the protocol to remove
 *
 */
- (void)removeProtocol:(HYBScanProtocol *)protocol;

/**
 * run the given string against all the protocols stored in the interpreter
 *
 * @param string string to process
 *
 */
- (BOOL)processString:(NSString*)string;

/**
 * run the given string against a protocol, given the protocol name
 *
 * @param string string to process
 * @param protocolName name of the protocol to use
 *
 */
- (BOOL)processString:(NSString*)string withProtocolNamed:(NSString*)protocolName;

/**
 * run the given string against the passed protocol
 *
 * @param string string to process
 * @param protocol the protocol to use
 *
 */
- (BOOL)processString:(NSString*)string withProtocol:(HYBScanProtocol*)protocol;

@end
