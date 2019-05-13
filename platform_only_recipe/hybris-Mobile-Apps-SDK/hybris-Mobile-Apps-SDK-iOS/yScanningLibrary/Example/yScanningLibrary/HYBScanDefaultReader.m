//
//  HYBScanDefaultReader.m
//  Pods
//
//  Created by Yann Bouschet on 05/05/2015.
//
//

#import "HYBScanDefaultReader.h"
#import <AVFoundation/AVFoundation.h>

@interface HYBScanDefaultReader () <AVCaptureMetadataOutputObjectsDelegate>

@property (nonatomic) AVCaptureSession              *session;
@property (nonatomic) AVCaptureDevice               *device;
@property (nonatomic) AVCaptureDeviceInput          *input;
@property (nonatomic) AVCaptureMetadataOutput       *output;
@property (nonatomic) AVCaptureVideoPreviewLayer    *prevLayer;

@end

@implementation HYBScanDefaultReader

- (instancetype)init {
    if (self = [super init]) {
        
    }
    
    return self;
}

- (void)startSession {
    
    _session    = [[AVCaptureSession alloc] init];
    _device     = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
    
    NSError *error = nil;
    
    _input = [AVCaptureDeviceInput deviceInputWithDevice:_device error:&error];
    
    if (_input) [_session addInput:_input];
    else NSLog(@"Error: %@", error);
    
    _output = [[AVCaptureMetadataOutput alloc] init];
    [_output setMetadataObjectsDelegate:self queue:dispatch_get_main_queue()];
    [_session addOutput:_output];
    
    _output.metadataObjectTypes = [_output availableMetadataObjectTypes];
    
    _prevLayer = [AVCaptureVideoPreviewLayer layerWithSession:_session];
    //_prevLayer.frame = self.view.bounds;
    _prevLayer.videoGravity = AVLayerVideoGravityResizeAspectFill;
    //[self.view.layer addSublayer:_prevLayer];
    
    [_session startRunning];
}

- (void)stopSession {
    [_session stopRunning];
}

- (void)captureOutput:(AVCaptureOutput *)captureOutput
didOutputMetadataObjects:(NSArray *)metadataObjects
       fromConnection:(AVCaptureConnection *)connection {
    
    CGRect highlightViewRect = CGRectZero;
    
    AVMetadataMachineReadableCodeObject *barCodeObject;
    
    NSString *detectionString = nil;
    
    NSArray *barCodeTypes = @[AVMetadataObjectTypeUPCECode,
                              AVMetadataObjectTypeCode39Code,
                              AVMetadataObjectTypeCode39Mod43Code,
                              AVMetadataObjectTypeEAN13Code,
                              AVMetadataObjectTypeEAN8Code,
                              AVMetadataObjectTypeCode93Code,
                              AVMetadataObjectTypeCode128Code,
                              AVMetadataObjectTypePDF417Code,
                              AVMetadataObjectTypeQRCode,
                              AVMetadataObjectTypeAztecCode];
    
    for (AVMetadataObject *metadata in metadataObjects) {
        for (NSString *type in barCodeTypes) {
            if ([metadata.type isEqualToString:type])
            {
                barCodeObject = (AVMetadataMachineReadableCodeObject *)[_prevLayer transformedMetadataObjectForMetadataObject:(AVMetadataMachineReadableCodeObject *)metadata];
                highlightViewRect = barCodeObject.bounds;
                detectionString = [(AVMetadataMachineReadableCodeObject *)metadata stringValue];
                break;
            }
        }
        
        if (detectionString != nil) {
            break;
        }
    }
}

@end