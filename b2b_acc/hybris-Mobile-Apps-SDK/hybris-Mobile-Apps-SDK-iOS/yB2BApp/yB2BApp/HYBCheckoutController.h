//
// HYBCheckoutController.h
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
#import "HYBViewController.h"

@class HYBB2BService;
@class HYBCheckoutView;
@class HYBCart;

enum selectedPickerType {costCenterPicker, deliveryAddressPicker, deliveryMethodPicker};

@interface HYBCheckoutController : HYBViewController <UIPickerViewDataSource, UIPickerViewDelegate, UIGestureRecognizerDelegate,UITextFieldDelegate, UIAlertViewDelegate> {
    int selectedPicker;
    int pickersSelections[3];       
    CGPoint actionCenter;
    BOOL orderFirstTry;
    BOOL termsAndConditionsAccepted;
}

@property(nonatomic) NSArray         *optionsArray;
@property(nonatomic) UIPickerView    *mainPickerView;
@property(nonatomic) HYBCheckoutView *mainView;

@end
