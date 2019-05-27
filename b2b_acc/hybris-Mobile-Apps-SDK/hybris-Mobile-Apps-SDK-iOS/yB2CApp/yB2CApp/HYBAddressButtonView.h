//
//  HYBAddressButtonView.h
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
#import "HYBObjects.h"
#import "HYBActionButton.h"

@interface HYBAddressButtonView : UIView

@property (nonatomic) HYBAddress *address;
@property (nonatomic) HYBPaymentDetails *paymentDetails;

@property (nonatomic) UILabel *legend;
@property (nonatomic) UILabel *nameLabel;
@property (nonatomic) UILabel *lineOneLabel;
@property (nonatomic) UILabel *lineTwoLabel;
@property (nonatomic) HYBActionButton *editBtn;




@end
