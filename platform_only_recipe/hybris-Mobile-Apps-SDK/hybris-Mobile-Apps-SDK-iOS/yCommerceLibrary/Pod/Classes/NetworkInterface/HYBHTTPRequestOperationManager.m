//
// HYBHTTPRequestOperationManager.m
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

#import "HYBHTTPRequestOperationManager.h"
#import "HYBConstants.h"
#import "DDLog.h"

@interface HYBHTTPRequestOperationManager()

@end

@implementation HYBHTTPRequestOperationManager

#pragma mark REST shortcuts

- (void (^)(AFHTTPRequestOperation *operation, NSError *error))failureForCall:(NSString*)HTTP url:(NSString*)url
                                                                   withParams:(NSDictionary*)params
                                                                      success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
                                                                      failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    
    void (^failure)(AFHTTPRequestOperation *operation, NSError *error) = ^void(AFHTTPRequestOperation *operation, NSError *error) {
        
        if(operation && operation.responseObject) {
            
            if(operation.responseObject[@"error"]) {
                DDLogDebug(@"-+- error -+-");
                DDLogDebug(operation.responseObject[@"error"]);
                DDLogDebug(operation.responseObject[@"error_description"]);

                originalFailure(operation,error);
            } else {
                NSArray *errors = operation.responseObject[@"errors"];
                if(errors && errors.count > 0) {
                    
                    BOOL tokenExpired = NO;
                    
                    for (NSDictionary *hit in errors) {
                        NSString *type      = hit[@"type"];
                        
                        if ([type isEqualToString:@"InvalidTokenError"]) {
                            
                            tokenExpired = YES;
                            
                            break;
                        }
                    }
                    
                    if (tokenExpired) {
                        DDLogDebug(@"-+- InvalidTokenError -+-");
                        
                        NSMutableDictionary *tmpOriginalCall = [NSMutableDictionary dictionary];
                        
                        if(HTTP) {
                            [tmpOriginalCall setObject:HTTP forKey:@"HTTP"];
                        }
                        
                        if(url) {
                            [tmpOriginalCall setObject:url forKey:@"url"];
                        }
                        
                        if(params) {
                            [tmpOriginalCall setObject:params forKey:@"params"];
                        }
                        
                        if(success) {
                            [tmpOriginalCall setObject:success forKey:@"success"];
                        }
                        
                        if(originalFailure) {
                            [tmpOriginalCall setObject:originalFailure forKey:@"failure"];
                        }
                        
                        if(HTTP) {
                            [tmpOriginalCall setObject:HTTP forKey:@"HTTP"];
                        }
                        
                        NSDictionary *originalCall = [NSDictionary dictionaryWithDictionary:tmpOriginalCall];
                        
                        if(originalCall) {
                            NSLog(@"%@",[originalCall description]);
                            
                            [[NSNotificationCenter defaultCenter] postNotificationName:@"refreshTheToken"
                                                                                object:nil
                                                                              userInfo:originalCall];
                        }
                        
                    }  else {
                        originalFailure(operation,error);
                    }
                }
                
            }
        }
    };
    
    return failure;
}

- (void)GET:(NSString*)url withParams:(NSDictionary*)params
    success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
    failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self GET:url
   parameters:params
      success:success
      failure:[self failureForCall:@"GET" url:url withParams:params success:success failure:originalFailure]];
}

- (void)GETIMAGE:(NSString*)url withParams:(NSDictionary*)params
         success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
         failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self GET:url
   parameters:params
      success:success
      failure:[self failureForCall:@"GETIMAGE" url:url withParams:params success:success failure:originalFailure]];
}

- (void)POST:(NSString*)url withParams:(NSDictionary*)params
     success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
     failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self POST:url
    parameters:params
       success:success
       failure:[self failureForCall:@"POST" url:url withParams:params success:success failure:originalFailure]];
}

- (void)DELETE:(NSString*)url withParams:(NSDictionary*)params
       success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
       failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self DELETE:url
      parameters:params
         success:success
         failure:[self failureForCall:@"DELETE" url:url withParams:params success:success failure:originalFailure]];
}

- (void)PATCH:(NSString*)url withParams:(NSDictionary*)params
      success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
      failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self PATCH:url
     parameters:params
        success:success
        failure:[self failureForCall:@"PATCH" url:url withParams:params success:success failure:originalFailure]];
}

- (void)PUT:(NSString*)url withParams:(NSDictionary*)params
    success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
    failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self PUT:url
   parameters:params
      success:success
      failure:[self failureForCall:@"PUT" url:url withParams:params success:success failure:originalFailure]];
}

- (void)HEAD:(NSString*)url withParams:(NSDictionary*)params
     success:(void (^)(AFHTTPRequestOperation *operation, id responseObject))success
     failure:(void (^)(AFHTTPRequestOperation *operation, NSError *error))originalFailure {
    
    [self HEAD:url
    parameters:params
       success:^(AFHTTPRequestOperation *operation) {
           success(operation, operation.responseObject);
       }
       failure:[self failureForCall:@"HEAD" url:url withParams:params success:success failure:originalFailure]];
}

@end
