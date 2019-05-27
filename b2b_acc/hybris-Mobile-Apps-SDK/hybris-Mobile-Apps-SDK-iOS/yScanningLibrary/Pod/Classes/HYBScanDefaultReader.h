//
//  HYBScanDefaultReader.h
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

#import "HYBScanReader.h"

@interface HYBScanDefaultReader : HYBScanReader

/**
 * default iOS reader using AVFoundation
 *
 * @param frame frame of the view and of the preview Layer of AVFoundation
 *
 */
- (instancetype)initWithFrame:(CGRect)frame;

@end
