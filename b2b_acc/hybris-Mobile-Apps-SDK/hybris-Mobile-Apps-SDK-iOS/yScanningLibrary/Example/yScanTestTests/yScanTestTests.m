//
//  yScanTestTests.m
//  yScanTestTests
//
//  Created by Yann Bouschet on 05/05/2015.
//  Copyright (c) 2015 Yann Bouschet. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <XCTest/XCTest.h>

#import "HYBScan.h"

@interface yScanTestTests : XCTestCase
    @property (nonatomic) HYBScanInterpreter *scanInterpreter;
@end

@implementation yScanTestTests

- (void)setUp {
    [super setUp];
    
    _scanInterpreter = [HYBScanInterpreter new];
    
    
    NSString *protocolName = @"openStore";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(openStore:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"store"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(store_name)"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"/"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"open"];
    
    
    protocolName = @"viewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"products"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"/"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"open"];
    
    protocolName = @"basicViewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"products"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    
    protocolName = @"ultraBasicViewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    
    
    protocolName = @"addToCart";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(addToCartAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"products"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"/"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"addToCart"];
    
    
    protocolName = @"addToCartMultipleUnits";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(addToCartMultipleUnitsAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"products"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"/"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"addToCart"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"/"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(quantity)"];
    
    
}

- (void)tearDown {
    [super tearDown];
}

- (void)testInterpreterProtocolsCount {
   
    XCTAssertEqual(_scanInterpreter.protocols.count, 6);
}

- (void)testFirstProtocolName {
    HYBScanProtocol *protocolFirst = _scanInterpreter.protocols[0];
    
    XCTAssertEqual(protocolFirst.name, @"openStore");
    
}

- (void)testFirstProtocolPattern {
    HYBScanProtocol *protocolFirst = _scanInterpreter.protocols[0];
    
    XCTAssertEqual(protocolFirst.pattern.count, 5);
    XCTAssertTrue([[protocolFirst patternDescription] isEqualToString:@"store://$(store_name)/open"],
                  @"Strings are not equal %@ %@", @"store://$(store_name)/open", [protocolFirst patternDescription]);
    
}

- (void)testProtocol1 {
    XCTAssertTrue([_scanInterpreter processString:@"324234"   withProtocolNamed:@"ultraBasicViewInCatalog"]);
}
- (void)testProtocol2 {
    XCTAssertFalse([_scanInterpreter processString:@"products://324234"                withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol3 {
    XCTAssertFalse([_scanInterpreter processString:@"products://324234/addToCart"      withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol4 {
    XCTAssertTrue([_scanInterpreter processString:@"products://324234/addToCart/100"  withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol5 {
    XCTAssertTrue([_scanInterpreter processString:@"store://Store Name/open"                  withProtocolNamed:@"openStore"]);
}
- (void)testProtocol6 {
    XCTAssertFalse([_scanInterpreter processString:@"store://Store Name/call/1-888-888-8888"   withProtocolNamed:@"openStore"]);
}
- (void)testProtocol7 {
    XCTAssertFalse([_scanInterpreter processString:@"store://Store Name/call/1-888-888-8888"   withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol8 {
    XCTAssertFalse([_scanInterpreter processString:@"produts://324234/addToCart/100"  withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol9 {
    XCTAssertTrue([_scanInterpreter processString:@"products://324234"  withProtocolNamed:@"basicViewInCatalog"]);
}
- (void)testProtocol10 {
    XCTAssertFalse([_scanInterpreter processString:@"produts://324234"  withProtocolNamed:@"basicViewInCatalog"]);
}
- (void)testProtocol11 {
    XCTAssertFalse([_scanInterpreter processString:@"produts://"  withProtocolNamed:@"basicViewInCatalog"]);
}
- (void)testProtocol12 {
    XCTAssertFalse([_scanInterpreter processString:@"produts://324234//addToCart/100"  withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol13 {
    XCTAssertFalse([_scanInterpreter processString:@"produts://324234#addToCart/100"  withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol14 {
    XCTAssertFalse([_scanInterpreter processString:@"produts://324234/adToCart/100"  withProtocolNamed:@"addToCartMultipleUnits"]);
}
- (void)testProtocol15 {
    XCTAssertFalse([_scanInterpreter processString:@"products://"  withProtocolNamed:@"basicViewInCatalog"]);
}

//triggers

- (void)openStore:(id)sender {
    NSLog(@"openStore %@", [sender description]);
}

- (void)viewInCatalogAction:(id)sender {
    NSLog(@"viewInCatalogAction %@", [sender description]);
}

- (void)addToCartAction:(id)sender {
    NSLog(@"addToCartAction %@", [sender description]);
}

- (void)addToCartMultipleUnitsAction:(id)sender {
    NSLog(@"addToCartMultipleUnitsAction %@", [sender description]);
}

@end
