//
//  HYBScanReaderInterface.m
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

#import "HYBScanReaderInterface.h"
#import "HYBScanReader.h"

@interface HYBScanReaderInterface ()

@property (nonatomic) id reader;


@end

@implementation HYBScanReaderInterface

- (instancetype)init {
    if(self = [super init]) {
        _reader = nil;
        _delegate = nil;
        _isScanning = NO;
    }
    return self;
}

- (void)setReader:(id)reader {
    _reader = reader;
    if (_delegate) {
        [(HYBScanReader*)_reader setDelegate:_delegate];
    }
}

- (UIView*)view {
    if ([self checkReader]) {
        return [(HYBScanReader*)_reader view];
    }
    return nil;
}

- (CGRect)barcodeRect {
    if ([self checkReader]) {
        return [(HYBScanReader*)_reader barcodeRect];
    }
    return CGRectZero;
}

- (void)startScanning {
    if ([self checkReader]) {
        _isScanning = YES;
        [_reader startScanning];
    }
}

- (void)stopScanning {
    if ([self checkReader]) {
        _isScanning = NO;
        [_reader stopScanning];
    }
}

- (void)setAllowedBarcodeTypes:(NSArray *)allowedBarcodeTypes {
    if ([self checkReader]) {
        [(HYBScanReader*)_reader setAllowedBarcodeTypes:allowedBarcodeTypes];
    }
}

- (NSArray*)allowedBarcodeTypes {
    if ([self checkReader]) {
        return [(HYBScanReader*)_reader allowedBarcodeTypes];
    }
    return nil;
}

- (void)setDelegate:(id<HYBScanReaderInterfaceDelegate>)delegate {
    _delegate = delegate;
    if ([self checkReader]) {
        [(HYBScanReader*)_reader setDelegate:_delegate];
    }
}

- (BOOL)checkReader {
    if (!_reader) {
        NSLog(@"reader not set");
        return NO;
    }
    return YES;
}

@end
