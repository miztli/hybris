//
//  HYBScanViewController.m
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

#import "HYBScanViewController.h"
#import "HYBScan.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

@interface HYBScanViewController ()  <HYBScanReaderInterfaceDelegate>

@property (nonatomic) HYBScanReaderInterface *scanInterface;
@property (nonatomic) HYBScanInterpreter *scanInterpreter;

@property (nonatomic) UIView *highlightView;

@property (nonatomic) NSString *lookupProductId;
@property (nonatomic) NSString *processedString;

@end

@implementation HYBScanViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        //core setup
        [self setupInterpreter];
        [self setupReader];
        
        _lookupProductId = nil;
        
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    if(_scanInterface) {
        [self.scanInterface startScanning];
    }
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark define protocols to search for

- (void)setupInterpreter {
    
    //NSLog(@"setupInterpreter");
    
    _scanInterpreter = [HYBScanInterpreter new];
    
    NSString *protocolName = @"openInCatalog";
    
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
    
    
    protocolName = @"ultraBasicViewInCatalog";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewInCatalogAction:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(product_id)"];
    
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
                                           AVMetadataObjectTypeCode93Code
                                           ];
    
    [self.view addSubview:_scanInterface.view];
    
    
    _highlightView = [[UIView alloc] init];
    _highlightView.autoresizingMask = UIViewAutoresizingFlexibleTopMargin|UIViewAutoresizingFlexibleLeftMargin|UIViewAutoresizingFlexibleRightMargin|UIViewAutoresizingFlexibleBottomMargin;
    _highlightView.layer.borderColor = [UIColor greenColor].CGColor;
    _highlightView.layer.borderWidth = 3;
    
    [self.view addSubview:_highlightView];
    
    [self.view bringSubviewToFront:_highlightView];
}

#pragma mark reader delegate

- (void)readerDidUpdateWithString:(NSString*)detectedString {
    _highlightView.frame = [_scanInterface barcodeRect];
    
    //debounce result
    if(detectedString && (!_processedString || ![_processedString isEqualToString:detectedString])) {
        NSLog(@"process detected string: %@", detectedString);
        
        _processedString = [NSString stringWithString:detectedString];
        
        if(![_scanInterpreter processString:detectedString]) {
            
            //pause scan
            [_scanInterface stopScanning];
            
            //alert
            [self alertWithTitle:NSLocalizedString(@"warning_scanned_invalid", nil)
                      andMessage:NSLocalizedString(@"scanned_code_not_parsed", nil)];
        }
    }
};

#pragma App UI and interactions

- (void)viewInCatalogAction:(NSDictionary*)params {
    NSLog(@"viewInCatalogAction %@", [params description]);
    
    NSString *tmpProductId = params[@"product_id"];
    
    if (tmpProductId && (!_lookupProductId || ![tmpProductId isEqualToString:_lookupProductId])) {
        
        _lookupProductId = [NSString stringWithString:tmpProductId];
        
        @weakify(self);
        [self.backendService getProductForCode:_lookupProductId
                                    andExecute:^(HYBProduct *product, NSError *error) {
                                        
                                        @strongify(self);
                                        
                                        //pause scan
                                        [self.scanInterface stopScanning];
                                        
                                        if(error) {
                                            
                                            //alert
                                            [self alertWithTitle:NSLocalizedString(@"warning_scanned_product_not_found", nil)
                                                      andMessage:NSLocalizedString(@"scanned_code_not_matching_product_id", nil)];
                                            
                                        } else {
                                            
                                            //act
                                            if([product hyb_isNotBlank]) {
                                                [self pushDetailControllerWithProduct:product toggleDrawer:NO];
                                                [self performSelector:@selector(resetProcess) withObject:nil afterDelay:2];
                                            } else {
                                                //alert
                                                [self alertWithTitle:NSLocalizedString(@"warning_scanned_product_found", nil)
                                                          andMessage:NSLocalizedString(@"scanned_code_empty_product", nil)];
                                            }
                                        }
                                        
                                    }];
    }
}

- (void)alertWithTitle:(NSString*)title andMessage:(NSString*)message {
    
    self.highlightView.frame = CGRectZero;
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:title
                                                    message:message
                                                   delegate:self
                                          cancelButtonTitle:@"Ok" otherButtonTitles:nil];
    
    [alert show];
    
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
    [self resetProcess];
    [_scanInterface startScanning];
}

- (void)resetProcess {
    _processedString = nil;
    _lookupProductId = nil;
}


@end
