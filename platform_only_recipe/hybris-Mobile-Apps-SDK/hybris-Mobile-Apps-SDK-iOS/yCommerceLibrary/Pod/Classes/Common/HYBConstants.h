//
// HYBConstants.h
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
#import "DDLog.h"

/**
* Class to save all static constans that are used more than by one single class definition.
*/

#ifdef DEBUG
    static const int ddLogLevel = LOG_LEVEL_DEBUG;
#else
    static const int ddLogLevel = LOG_LEVEL_WARN;
#endif

#define defaultAnimationDuration 0.3
#define defaultTopMargin 80.f

#define FORMAT(format, ...) [NSString stringWithFormat:(format), ##__VA_ARGS__]

#define SIMPLE_CART_ITEM_CELL_ID    @"HYBEntryViewCellID"
#define HYBOCCErrorDomain           @"HYBOCCErrorDomain"
#define HYB2B_ERROR_CODE_TECHNICAL  -57

// BACKEND SERVICE

#define CURRENT_SETTINGS    @"CURRENT_SETTINGS"

#define USESSL              @"useSSL"

#define OCCVERSION          @"OCCVersion"

#define STOREID             @"storeId"
#define CATALOGID           @"catalogId"
#define CATALOGVERSIONID    @"catalogVersionId"
#define ROOTCATEGORYID      @"rootCategoryId"

#define GROUPID             @"groupId"
#define USERID              @"userId"

#define BACKENDHOST         @"backEndHost"
#define BACKENDPORT         @"backEndPort"

#define DID_CHANGE_SERVER   @"DID_CHANGE_SERVER"