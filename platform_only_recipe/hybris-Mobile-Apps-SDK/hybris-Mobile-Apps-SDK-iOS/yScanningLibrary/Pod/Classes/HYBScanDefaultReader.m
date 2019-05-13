//
//  HYBScanDefaultReader.m
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

#import "HYBScanDefaultReader.h"
#import <AVFoundation/AVFoundation.h>

@interface HYBScanDefaultReader () <AVCaptureMetadataOutputObjectsDelegate>

@property (nonatomic) AVCaptureSession              *session;
@property (nonatomic) AVCaptureDevice               *device;
@property (nonatomic) AVCaptureDeviceInput          *input;
@property (nonatomic) AVCaptureMetadataOutput       *output;
@property (nonatomic) AVCaptureVideoPreviewLayer    *previewLayer;

@property (nonatomic) CGRect highlightViewRect;

@end

@implementation HYBScanDefaultReader

- (instancetype)initWithFrame:(CGRect)frame {
    
    if (self = [super init]) {
        self.view       = [[UIView alloc] initWithFrame:frame];
        _session    = [[AVCaptureSession alloc] init];
        _device     = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
        
        NSError *error = nil;
        
        _input = [AVCaptureDeviceInput deviceInputWithDevice:_device error:&error];
        
        if (_input) [_session addInput:_input];
        else NSLog(@"Error: %@", error);
        
        _output = [[AVCaptureMetadataOutput alloc] init];
        [_output setMetadataObjectsDelegate:self
                                      queue:dispatch_get_main_queue()];
        [_session addOutput:_output];
        
        _output.metadataObjectTypes = [_output availableMetadataObjectTypes];
        
        _previewLayer = [AVCaptureVideoPreviewLayer layerWithSession:_session];
        _previewLayer.frame = self.view.bounds;
        _previewLayer.videoGravity = AVLayerVideoGravityResizeAspectFill;
        [self.view.layer addSublayer:_previewLayer];
    }
    
    return self;
}

- (void)startScanning {
    [_session startRunning];
}

- (void)stopScanning {
    [_session stopRunning];
}

- (CGRect)barcodeRect {
    return _highlightViewRect;
}

- (void)captureOutput:(AVCaptureOutput *)captureOutput
didOutputMetadataObjects:(NSArray *)metadataObjects
       fromConnection:(AVCaptureConnection *)connection {
    
    AVMetadataMachineReadableCodeObject *barCodeObject = nil;
    NSString *detectedString = nil;
    
    
    for (AVMetadataObject *metadata in metadataObjects) {
        for (NSString *type in self.allowedBarcodeTypes) {
            if ([metadata.type isEqualToString:type]) {
                barCodeObject = (AVMetadataMachineReadableCodeObject *)[_previewLayer transformedMetadataObjectForMetadataObject:(AVMetadataMachineReadableCodeObject *)metadata];
                detectedString = [(AVMetadataMachineReadableCodeObject *)metadata stringValue];
                _highlightViewRect = barCodeObject.bounds;
                break;
            }
        }
        
        if (detectedString != nil) {            
            if([self.delegate respondsToSelector:@selector(readerDidUpdateWithString:)]) {
                [self.delegate readerDidUpdateWithString:detectedString];
            }
            break;
        }
    }
}

@end