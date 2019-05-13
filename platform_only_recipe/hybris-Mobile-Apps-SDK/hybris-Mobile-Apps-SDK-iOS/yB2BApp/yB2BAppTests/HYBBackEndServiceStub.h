//
// HYBBackEndServiceStub.h
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

#import "HYBB2BService.h"


@interface HYBBackEndServiceStub : HYBB2BService

@property(nonatomic) NSUserDefaults *userDefaults;
@property(nonatomic) int pageOffset;
@property(nonatomic) int pageSize;

@property(nonatomic, strong) id costCenters;
@property(nonatomic, strong) id deliveryModes;

@end