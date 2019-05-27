//
//  HYBBaseMenuCellView.h
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <UIKit/UIKit.h>

#define MENU_CELL_ID    @"MENU_CELL_ID"

#define MENU_TITLE      @"MENU_TITLE"
#define MENU_ICON       @"MENU_ICON"
#define MENU_ACCESSID   @"MENU_ACCESSID"
#define MENU_ACTION_TAG @"MENU_ACTION_TAG"

@interface HYBBaseMenuCellView : UITableViewCell

- (void)basicSetup;
- (void)setupWithParams:(NSDictionary*)params;


@end
