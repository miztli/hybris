//
// HYBOrderConfirmationController.h
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

#import <UIKit/UIKit.h>
#import "HYBViewController.h"

@class HYBB2BService;
@class HYBCheckoutView;
@class HYBCart;
@class HYBOrder;

@interface HYBOrderConfirmationController : HYBViewController <UITableViewDelegate, UITableViewDataSource>

@property(nonatomic, strong) HYBCart *currentCart;

- (instancetype)initWithBackEndService:(HYBB2BService*)backEndService andOrder:(HYBOrder *)order;


@end
