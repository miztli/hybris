//
// HYBCheckoutView.h
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

#import <Foundation/Foundation.h>
#import "UIView+Utilities.h"
#import "HYBActionButton.h"
#import "HYBDropDownButton.h"
#import "HYBOrderSummaryView.h"

@interface HYBCheckoutView : UIView

@property (nonatomic) UIScrollView   *contentView;
@property (nonatomic) UILabel        *checkoutTitle;

@property (nonatomic) UIView         *paymentPanel;
@property (nonatomic) UILabel        *paymentTitle;
@property (nonatomic) UIView         *paymentAccountPanel;
@property (nonatomic) HYBDropDownButton  *paymentAccount;
@property (nonatomic) HYBActionButton *createPayment;

@property (nonatomic) UIView         *deliveryPanel;
@property (nonatomic) UILabel        *deliveryDetailsTitle;
@property (nonatomic) UILabel        *deliveryAddressTitle;
@property (nonatomic) HYBDropDownButton  *deliveryAddressButton;
@property (nonatomic) HYBActionButton *createAddress;

@property (nonatomic) UILabel        *deliveryMethodTitle;
@property (nonatomic) HYBDropDownButton  *deliveryMethodButton;

@property (nonatomic) UIView          *agreementPanel;
@property (nonatomic) HYBActionButton *agreementButton;
@property (nonatomic) UILabel        *agreementIntroLabel;
@property (nonatomic) UILabel        *agreementLinkLabel;

@property (nonatomic) UILabel        *agreementConfirmationLabel;

@property (nonatomic) HYBActionButton      *orderButton;

@property (nonatomic) UIView         *maskView;

@property(nonatomic, strong) HYBOrderSummaryView *orderSummaryView;

@end