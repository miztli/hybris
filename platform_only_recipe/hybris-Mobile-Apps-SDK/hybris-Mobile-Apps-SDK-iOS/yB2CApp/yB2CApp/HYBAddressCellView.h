//
//  HYBAddressCellView.h
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

#import <UIKit/UIKit.h>

@interface HYBAddressCellView : UITableViewCell

@property (nonatomic) UILabel *nameLabel;
@property (nonatomic) UILabel *firstLineLabel;
@property (nonatomic) UILabel *secondLineLabel;

@property (nonatomic) UIView *chevronView;
@property (nonatomic) UIView *selectView;

- (void)doHilite:(BOOL)hilite;

@end
