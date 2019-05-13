//
//  HYBAddressesListViewController.h
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

#import "HYBViewController.h"

#define ADDRESS_SELECTION   @"ADDRESS_SELECTION"
#define PAYMENT_SELECTION   @"PAYMENT_SELECTION"

@interface HYBAddressesListViewController : HYBViewController <UITableViewDataSource, UITableViewDelegate>

@property (nonatomic) NSArray *array;
@property (nonatomic) id selectedItem;
@property (nonatomic) id defaultItem;

@property (nonatomic) NSString *selectionType;

@end
