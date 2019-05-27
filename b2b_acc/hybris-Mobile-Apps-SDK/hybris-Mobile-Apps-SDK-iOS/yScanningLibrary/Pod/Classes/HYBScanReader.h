//
//  HYBScanReader.h
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

#import <UIKit/UIKit.h>
#import "HYBScanReaderInterface.h"

@interface HYBScanReader : NSObject

@property (nonatomic) UIView *view;
@property (nonatomic) NSArray *allowedBarcodeTypes;
@property (nonatomic) id <HYBScanReaderInterfaceDelegate> delegate;

/**
 * start Scanning process of the reader
 *
 */
- (void)startScanning;

/**
 * stop Scanning process of the reader
 *
 */
- (void)stopScanning;

/**
 * remove a pattern component from the protocol
 *
 * @return CGRect the rect of a detected barcode
 *
 */
- (CGRect)barcodeRect;

@end
