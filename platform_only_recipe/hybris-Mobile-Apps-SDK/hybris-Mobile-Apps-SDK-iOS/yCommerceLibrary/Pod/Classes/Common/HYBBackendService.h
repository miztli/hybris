//
//  HYBBackendService.h
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
#import "extobjc.h"
#import "PromiseKit.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "HYBConstants.h"
#import "HYBRestManager.h"
#import "HYBStorage.h"
#import "HYBObjects.h"
#import "HYBCategoryHierarchy+Tree.h"
#import "HYBOrderEntry+Discounts.h"
#import "HYBCart+Promotions.h"
#import "HYBProduct+Extends.h"

@interface HYBBackendService : NSObject;

@property (nonatomic) BOOL useSSL;

@property (nonatomic) NSString *OCCVersion;

@property (nonatomic) NSString *storeId;
@property (nonatomic) NSString *catalogId;
@property (nonatomic) NSString *catalogVersionId;
@property (nonatomic) NSString *rootCategoryId;

@property (nonatomic) NSString *groupId;
@property (nonatomic) NSString *userId;

@property (nonatomic) NSString *backEndPort;
@property (nonatomic) NSString *backEndHost;

@property(nonatomic) int pageOffset;
@property(nonatomic) int pageSize;
@property(nonatomic) int currentPage;
@property(nonatomic) int totalSearchResults;

@property (nonatomic) HYBRestManager *restEngine;

- (instancetype)initWithParams:(NSDictionary*)params;

- (NSString *)baseURL;
- (NSString *)baseURLNoRest;
- (NSString *)restPrefix;

- (void)resetPagination;
- (void)nextPage;

- (void)saveSettings;
- (void)loadSettings;

@end
