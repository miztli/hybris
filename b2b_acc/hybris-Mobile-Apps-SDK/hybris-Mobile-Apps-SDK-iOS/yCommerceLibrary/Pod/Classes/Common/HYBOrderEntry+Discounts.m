//
//  HYBOrderEntry+Discounts.m
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

#import "HYBOrderEntry+Discounts.h"
#import <objc/runtime.h>

static char DISCOUNT_MESSAGE;

@implementation HYBOrderEntry (Discounts)

//Dynamic association
@dynamic discountMessage;


- (void)setDiscountMessage:(NSString *)discountMessage{
    objc_setAssociatedObject(self,
                             &DISCOUNT_MESSAGE,
                             discountMessage,
                             OBJC_ASSOCIATION_RETAIN_NONATOMIC);
}

- (NSString *)discountMessage {
    return objc_getAssociatedObject(self,
                                    &DISCOUNT_MESSAGE);
}

@end
