//
//  HYBCreditCardFormViewController.h
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
#import "HYBCreditCardFormView.h"
#import "HYBAddressFormView.h"

@interface HYBCreditCardFormViewController : HYBViewController <UITextFieldDelegate, UIPickerViewDataSource, UIPickerViewDelegate, UIGestureRecognizerDelegate>

@property (nonatomic) HYBPaymentDetails *currentPaymentDetails;

@property (nonatomic) HYBCreditCardFormView *ccFormView;

@property (nonatomic) HYBActionButton *useShippingAddressButton;

@property (nonatomic) UIView *addressFormContainer;
@property (nonatomic) HYBAddressFormView    *addressFormView;

@property (nonatomic) UIView *controlPanel;
@property (nonatomic) HYBActionButton *cancelButton;
@property (nonatomic) HYBActionButton *saveButton;
@property (nonatomic) HYBActionButton *deleteButton;

@end
