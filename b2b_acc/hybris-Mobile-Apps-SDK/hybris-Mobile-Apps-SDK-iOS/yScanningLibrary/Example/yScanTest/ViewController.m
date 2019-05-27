//
//  ViewController.m
//  yScanTest
//
//  Created by Yann Bouschet on 05/05/2015.
//  Copyright (c) 2015 Yann Bouschet. All rights reserved.
//

#import "ViewController.h"
#import <AVFoundation/AVFoundation.h>

#import "HYBScan.h"

@interface ViewController () <HYBScanReaderInterfaceDelegate>

@property (nonatomic) HYBScanReaderInterface *scanInterface;
@property (nonatomic) HYBScanInterpreter *scanInterpreter;
@property (nonatomic) UIButton *scanButton;
@property (nonatomic) UIView *highlightView;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    //core setup
    [self setupInterpreter];
    [self setupReader];

    //ui setup
    _scanButton = [UIButton buttonWithType:UIButtonTypeCustom];
    [_scanButton setTitle:@"Scan"         forState:UIControlStateNormal];
    [_scanButton setTitle:@"Scanning ..." forState:UIControlStateHighlighted];
    
    [_scanButton addTarget:self action:@selector(toggleScan) forControlEvents:UIControlEventTouchUpInside];
    
    [self.view addSubview:_scanButton];
    
    [self refreshButton];
    
    _highlightView = [[UIView alloc] init];
    _highlightView.autoresizingMask = UIViewAutoresizingFlexibleTopMargin|UIViewAutoresizingFlexibleLeftMargin|UIViewAutoresizingFlexibleRightMargin|UIViewAutoresizingFlexibleBottomMargin;
    _highlightView.layer.borderColor = [UIColor greenColor].CGColor;
    _highlightView.layer.borderWidth = 3;
    [self.view addSubview:_highlightView];
    
    [self.view bringSubviewToFront:_highlightView];
}

#pragma mark define protocols to search for

- (void)setupInterpreter {
    
    //NSLog(@"setupInterpreter");
    
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
    
    /*
    protocolName = @"viewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"products"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"/"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"open"];
    
    protocolName = @"simpleViewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"products"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    */
    
    protocolName = @"ultraBasicViewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    
    /*
    
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
    */
    
}

#pragma mark setup image reader

- (void)setupReader {
    //create scanInterface
    _scanInterface = [HYBScanReaderInterface new];
    _scanInterface.delegate = self;
    
    //select default reader
    HYBScanDefaultReader *defaultReader = [[HYBScanDefaultReader alloc] initWithFrame:self.view.bounds];
    _scanInterface.reader = defaultReader;
    
    //Set allowed code types
    _scanInterface.allowedBarcodeTypes = @[AVMetadataObjectTypeDataMatrixCode,
                                           AVMetadataObjectTypeAztecCode,
                                           AVMetadataObjectTypeQRCode,
                                           AVMetadataObjectTypePDF417Code,
                                           AVMetadataObjectTypeCode39Code,
                                           AVMetadataObjectTypeCode39Mod43Code,
                                           AVMetadataObjectTypeCode128Code,
                                           AVMetadataObjectTypeITF14Code,
                                           AVMetadataObjectTypeCode93Code,
                                           AVMetadataObjectTypeEAN13Code,
                                           AVMetadataObjectTypeEAN8Code,
                                           AVMetadataObjectTypeInterleaved2of5Code,
                                           ];
    
     //NSLog(@"%@",_scanInterface.allowedBarcodeTypes.description);
   
    /*
    "org.iso.DataMatrix",
    "org.iso.Aztec",
    "org.iso.QRCode",
    "org.iso.PDF417",
    "org.iso.Code39",
    "org.iso.Code39Mod43",
    "org.iso.Code128",
    "org.gs1.ITF14",
    "com.intermec.Code93",
    "org.gs1.EAN-13",
    "org.gs1.EAN-8",
    "org.ansi.Interleaved2of5"
    */
    
    [self.view addSubview:_scanInterface.view];
    
    [_scanInterface startScanning];
}

#pragma mark reader delegate

- (void)readerDidUpdateWithString:(NSString*)detectedString {
    
    _highlightView.frame = [_scanInterface barcodeRect];
    
    if(detectedString) {
        NSLog(@"detectedString: %@", detectedString);
        if ([_scanInterpreter processString:detectedString]) {
            [_scanInterface stopScanning];
            [self refreshButton];
        }
    }
};

#pragma App UI and interactions 

- (void)toggleScan {
    
    if(_scanInterface.isScanning) {
        [_scanInterface stopScanning];
    }    else {
        [_scanInterface startScanning];
        _highlightView.frame = CGRectZero;
    }
    
    [self refreshButton];
}

- (void)refreshButton {
    _scanButton.highlighted = _scanInterface.isScanning;
    [_scanButton sizeToFit];
    _scanButton.center = CGPointMake(self.view.bounds.size.width/2,self.view.bounds.size.height/10*9.5);
}

- (void)alertWithTitle:(NSString*)title andParams:(NSDictionary*)params {
    
    NSString *message = [params description];
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:title
                                                    message:message
                                                   delegate:self
                                          cancelButtonTitle:@"Ok" otherButtonTitles:nil];
    
    [alert show];
    
}

- (void)openStore:(id)params {
    NSLog(@"openStore %@", [params description]);
    [self alertWithTitle:@"Open Store" andParams:params];
}

- (void)viewInCatalogAction:(id)params {
    NSLog(@"viewInCatalogAction %@", [params description]);
    [self alertWithTitle:@"View In Catalog" andParams:params];
}

- (void)addToCartAction:(id)params {
    NSLog(@"addToCartAction %@", [params description]);
    [self alertWithTitle:@"Add One To Cart" andParams:params];
}

- (void)addToCartMultipleUnitsAction:(id)params {
    NSLog(@"addToCartMultipleUnitsAction %@", [params description]);
    [self alertWithTitle:@"Add Multiple To Cart" andParams:params];
}




@end
