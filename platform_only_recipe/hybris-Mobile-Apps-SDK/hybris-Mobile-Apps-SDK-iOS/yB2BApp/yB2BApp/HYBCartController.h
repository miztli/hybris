//
// HYBCartController.h
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
#import <Foundation/Foundation.h>
#import "HYBSideDrawer.h"
#import "HYBViewController.h"
#import "HYBB2BService.h"

@class HYBCartView;

@interface HYBCartController : HYBViewController <HYBSideDrawer, UITableViewDelegate, UITableViewDataSource, UITextFieldDelegate, UIAlertViewDelegate>

@property (nonatomic) BOOL isBatchDeleting;
@property (nonatomic) BOOL validAmount;

@property (nonatomic) NSString *firstResponderOriginalValue;

- (NSInteger)numberOfSectionsInTableView:(UITableView *)theTableView;

- (NSInteger)tableView:(UITableView *)theTableView numberOfRowsInSection:(NSInteger)section;

- (UITableViewCell *)tableView:(UITableView *)table cellForRowAtIndexPath:(NSIndexPath *)indexPath;

@end