//
//  HYBBackendService.m
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

#import "HYBBackendService.h"

@interface HYBBackendService ()

@property (nonatomic) NSString *baseURL;
@property (nonatomic) NSString *restPrefix;

@end

@implementation HYBBackendService

- (instancetype)initWithParams:(NSDictionary*)params {

    if (self = [super init]) {
        
        _useSSL     = [params[USESSL] boolValue];
        
        _OCCVersion = params[OCCVERSION];
        
        _storeId    = params[STOREID];
        _catalogId  = params[CATALOGID];
        _catalogVersionId = params[CATALOGVERSIONID];
        _rootCategoryId = params[ROOTCATEGORYID];
        
        _groupId    = params[GROUPID];
        _userId     = params[USERID];
        
        _backEndHost = params[BACKENDHOST];
        _backEndPort = params[BACKENDPORT];
        
        _restEngine = [HYBRestManager new];
        
        _pageOffset = 0;
        _pageSize = 20;
        _currentPage = 0;
        _totalSearchResults = 0;
    }
    
    return self;
}

#pragma mark - Pagination Utilities

- (void)resetPagination {
    _pageOffset = 0;
}

- (void)nextPage {
    _pageOffset++;
}

#pragma mark - description

- (NSString*)description {
    
    return FORMAT(@"_useSSL: %d\n, _OCCVersion: %@\n, _storeId: %@\n, _catalogId: %@\n, _catalogVersionId: %@\n, _rootCategoryId: %@\n, _groupId: %@\n, _userId: %@\n, _backEndHost: %@\n, _backEndPort: %@\n,",
    _useSSL, _OCCVersion, _storeId, _catalogId, _catalogVersionId, _rootCategoryId, _groupId, _userId, _backEndHost, _backEndPort);
}

#pragma mark base url + rest prefix

- (NSString *)baseURL {
    
    if (!_baseURL) {
        NSString *protocol          = @"http://";
        if (self.useSSL) protocol   = @"https://";
        
        NSString *host = self.backEndHost;
        NSString *port = self.backEndPort;
        
        NSString *result = nil;
        
        if([port hyb_isNotBlank]){
            result = FORMAT(@"%@%@:%@/rest", protocol, host, port);
        } else {
            result = FORMAT(@"%@%@/rest", protocol, host);
        }
        
        _baseURL = [NSString stringWithString:result];
    }
    
    return _baseURL;
}

- (NSString *)baseURLNoRest {
    return [self.baseURL substringToIndex:self.baseURL.length-5];
}

- (NSString*)restPrefix {
    if (!_restPrefix) {
        _restPrefix = [self.baseURL stringByAppendingString:FORMAT(@"/%@/%@",self.OCCVersion, self.storeId)];
    }
    return _restPrefix;
}

- (void)saveSettings {
    
    NSDictionary *currentSettings = [NSDictionary dictionaryWithObjectsAndKeys:
                                     _storeId,STOREID,
                                     _catalogId,CATALOGID,
                                     _catalogVersionId,CATALOGVERSIONID,
                                     _rootCategoryId,ROOTCATEGORYID,
                                     _backEndHost,BACKENDHOST,
                                     _backEndPort,BACKENDPORT,
                                     nil];
    
    [HYBStorage storeObject:currentSettings forKey:CURRENT_SETTINGS];
    
    _restPrefix = nil;
    _baseURL    = nil;
}

- (void)loadSettings {
    
    NSDictionary *currentSettings = [HYBStorage objectForKey:CURRENT_SETTINGS];
    
    if([currentSettings hyb_isNotBlank]) {
        _storeId            = currentSettings[STOREID];
        _catalogId          = currentSettings[CATALOGID];
        _catalogVersionId   = currentSettings[CATALOGVERSIONID];
        _rootCategoryId     = currentSettings[ROOTCATEGORYID];
        _backEndHost        = currentSettings[BACKENDHOST];
        _backEndPort        = currentSettings[BACKENDPORT];
        
        _restPrefix = nil;
        _baseURL    = nil;
    }
    
}

@end
