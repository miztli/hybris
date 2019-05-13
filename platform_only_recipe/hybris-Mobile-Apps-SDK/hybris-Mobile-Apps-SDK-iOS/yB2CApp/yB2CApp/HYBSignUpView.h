//
//  HYBSignUpView.h
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
#import "HYBActionButton.h"
#import "HYBDropDownButton.h"

@interface HYBSignUpView : UIView

@property(nonatomic) UIView     *contentView;
@property (nonatomic) UIView         *maskView;

@property (nonatomic) HYBDropDownButton *titleCodeDrop;

@property (nonatomic) UITextField *firstNameField;
@property (nonatomic) UITextField *lastNameField;

@property (nonatomic) UITextField *loginField;
@property (nonatomic) UITextField *passwordField;
@property (nonatomic) UITextField *verifyPasswordField;

@property (nonatomic) HYBActionButton *closeButton;
@property (nonatomic) HYBActionButton *saveButton;

@end
