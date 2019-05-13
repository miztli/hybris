//
//  HYBScanViewController.m
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
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
#import "HYBOrdersDetailsController.h"

@interface HYBScanViewController ()  <HYBScanReaderInterfaceDelegate>

@property (nonatomic) HYBScanReaderInterface *scanInterface;
@property (nonatomic) HYBScanInterpreter *scanInterpreter;

@property (nonatomic) UIView *highlightView;

@property (nonatomic) NSString *lookupId;
@property (nonatomic) NSString *processedString;

@end

@implementation HYBScanViewController

- (instancetype)initWithBackEndService:(HYBB2BService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        //core setup
        [self setupInterpreter];
        [self setupReader];
        
        _lookupId = nil;
        
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
    
    NSString *protocolName = @"simpleViewInCatalog";
    
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
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(addToCartMultipleUnitsAction:)];
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
    
    protocolName = @"viewOrder";
    
    [_scanInterpreter createProtocolNamed:protocolName];
    [_scanInterpreter protocolNamed:protocolName setAction:@selector(viewOrder:)];
    [_scanInterpreter protocolNamed:protocolName setTarget:self];
    
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"orders"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"://"];
    [_scanInterpreter protocolNamed:protocolName addPatternComponent:@"$(order_id)"];
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


- (void)viewInCatalogAction:(id)params {
    NSLog(@"viewInCatalogAction %@", [params description]);
    
    NSString *tmpId = params[@"product_id"];
    
    if (tmpId && (!_lookupId || ![tmpId isEqualToString:_lookupId])) {
        _lookupId = [NSString stringWithString:tmpId];
        
        @weakify(self);
        [self.backEndService getProductForCode:_lookupId
                                    andExecute:^(HYBProduct *product, NSError *error) {
                                        
                                        @strongify(self);
                                        
                                        //pause scan
                                        [self.scanInterface stopScanning];
                                        
                                        if(error) {
                                            
                                            //alert
                                            [self alertWithTitle:NSLocalizedString(@"warning_scanned_product_not_found", nil)
                                                      andMessage:NSLocalizedString(@"scanned_code_not_matching_product_id", nil)];
                                            
                                        } else {
                                            
                                            if([product hyb_isNotBlank]) {
                                                [self pushDetailControllerWithProduct:product toggleDrawer:NO];
                                                [self performSelector:@selector(resetProcess) withObject:nil afterDelay:2];
                                            }
                                            
                                            else {
                                                //alert
                                                [self alertWithTitle:NSLocalizedString(@"warning_scanned_product_found", nil)
                                                          andMessage:NSLocalizedString(@"scanned_code_empty_product", nil)];
                                            }
                                        }
                                        
                                        
                                        
                                    }];
    }
    
}

- (void)viewOrder:(id)params {
    NSLog(@"viewOrder %@", [params description]);
    
    NSString *tmpId = params[@"order_id"];
    
    if (tmpId && (!_lookupId || ![tmpId isEqualToString:_lookupId])) {
        _lookupId = [NSString stringWithString:tmpId];
        
        @weakify(self);
        [self.backEndService getOrderForUserId:[self.backEndService currentUserId]
                                  andOrderCode:_lookupId
                                    andExecute:^(HYBOrder *order, NSError *error) {
                                        
                                        @strongify(self);
                                        
                                        //pause scan
                                        [self.scanInterface stopScanning];
                                        
                                        if(error) {
                                            
                                            //alert
                                            [self alertWithTitle:NSLocalizedString(@"warning_scanned_order_not_found", nil)
                                                      andMessage:NSLocalizedString(@"scanned_code_not_matching_order_id", nil)];
                                            
                                        } else {
                                            
                                            
                                            if([order hyb_isNotBlank]) {
                                                
                                                //open new controller
                                                HYBOrdersDetailsController *ordersDetailsController = [[HYBOrdersDetailsController alloc] initWithBackEndService:self.b2bService andOrder:order];
                                                
                                                //push only one detailcontroller
                                                [self pushOrSwapTopCenterViewControllerTo:ordersDetailsController animated:YES];
                                                
                                                [self performSelector:@selector(resetProcess) withObject:nil afterDelay:2];
                                            }  else {
                                                //alert
                                                [self alertWithTitle:NSLocalizedString(@"warning_scanned_order_found", nil)
                                                          andMessage:NSLocalizedString(@"scanned_code_empty_order", nil)];
                                            }
                                        }
                                        
                                    }];
    }
    
}

- (void)addToCartMultipleUnitsAction:(id)params {
    NSLog(@"addToCartMultipleUnitsAction %@", [params description]);
    
    NSString *tmpId = params[@"product_id"];
    NSString *quantity = params[@"quantity"];
    if (!quantity) quantity = @"1";
    
    if (tmpId && (!_lookupId || ![tmpId isEqualToString:_lookupId])) {
        _lookupId = [NSString stringWithString:tmpId];
        
        @weakify(self);
        [self.backEndService addProductToCurrentCart:_lookupId
                                              amount:[NSNumber numberWithInt:[quantity intValue]]
                                          andExecute:^(HYBCart *cart, NSError *error) {
                                              
                                              @strongify(self);
                                              
                                              if(error) {
                                                  
                                                  if(error.code == -1011) {
                                                      //pause scan
                                                      [self.scanInterface stopScanning];
                                                      
                                                      //alert
                                                      [self alertWithTitle:NSLocalizedString(@"warning_scanned_product_not_found", nil)
                                                                andMessage:NSLocalizedString(@"scanned_code_not_matching_product_id", nil)];
                                                      
                                                  } else {
                                                      [self performSelector:@selector(resetProcess) withObject:nil afterDelay:4];
                                                      [self showNotifyMessage:error.localizedDescription];
                                                  }
                                                  
                                              } else {
                                                  if (cart == nil) {
                                                      DDLogError(@"Product %@ not added to cart.", _lookupId);
                                                  }
                                                  
                                                  [self performSelector:@selector(resetProcess) withObject:nil afterDelay:4];
                                                  [self showNotifyMessage:error.localizedDescription];
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
    _lookupId = nil;
}




@end
