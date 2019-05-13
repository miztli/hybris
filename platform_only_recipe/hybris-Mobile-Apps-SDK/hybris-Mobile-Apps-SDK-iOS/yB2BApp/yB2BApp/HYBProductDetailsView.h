//
//  HYBProductDetailsView.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.

#import <UIKit/UIKit.h>
#import "UIView+Utilities.h"
#import "HYBActionButton.h"
#import "HYBDropDownButton.h"
#import "HYBB2BService.h"

@interface HYBProductDetailsView : UIView <
UITextFieldDelegate,
UITableViewDataSource,
UITableViewDelegate,
UIPickerViewDataSource,
UIPickerViewDelegate>


@property (nonatomic) UIScrollView *contentView;

@property (nonatomic) UIImageView *closeIcon;
@property (nonatomic) UILabel *productNameLabel;
@property (nonatomic) UILabel *productCodeLabel;

@property (nonatomic) UIScrollView  *imagesScrollView;
@property (nonatomic) UIPageControl *imagesScrollControl;

@property (nonatomic) UITextView *summaryTextView;

@property (nonatomic) HYBDropDownButton *volumePricingButton;

@property (nonatomic) UIView *priceMatrix;

@property (nonatomic) UILabel *productPriceLabel;
@property (nonatomic) UIView *quantityPanel;

@property (nonatomic) UIView *variantButtonsPanel;
@property(nonatomic)  NSString *selectedVariantCode;

@property (nonatomic) UILabel *availabilityLabel;
@property (nonatomic) UILabel *quantityLabel;
@property (nonatomic) UITextField *quantityInputField;
@property (nonatomic) UILabel *totalItemPrice;

@property (nonatomic) HYBActionButton *addToCartButton;

@property (nonatomic) HYBActionButton *variantSelectionDoneButton;
@property (nonatomic) HYBActionButton *variantSelectionCancelButton;

@property (nonatomic) UIView         *maskView;

- (void)refreshWithProduct:(HYBProduct*)product;
- (void)displayProductsImages:(NSArray*)images;

- (NSNumber*)quantity;
- (void)setQuantity:(NSString *)quantity;

- (void)hideVariantPicker;

- (void)toggleVolumePricing;
- (void)calculateTotalPrice;

- (void)showMaskView;
- (void)hideMaskView;

@end
