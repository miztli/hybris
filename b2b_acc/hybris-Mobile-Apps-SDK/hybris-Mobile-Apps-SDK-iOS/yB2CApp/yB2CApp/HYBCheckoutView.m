//
// HYBCheckoutView.m
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
#import "HYBCheckoutView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"


@implementation HYBCheckoutView

- (id)initWithFrame:(CGRect)frame {    
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    CGFloat margin = [self bW]*.025;
    CGFloat lineHeight = 18.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 14.f;
    }
    
    _contentView.frame = CGRectMake(0, defaultTopMargin , [self bW], [self bH] - defaultTopMargin);
    
    _maskView.frame = _contentView.frame;
    
    [_checkoutTitle sizeToFit];
    _checkoutTitle.center = CGPointMake([_checkoutTitle bW]/2 + margin,
                                        [_checkoutTitle bH]/2 + margin);
    
    [_paymentTitle sizeToFit];
    _paymentTitle.center = CGPointMake([_paymentTitle bW]/2 + margin,
                                       [_checkoutTitle bottom] + [_paymentTitle bH]/2 + lineHeight);
    _paymentTitle.accessibilityIdentifier = @"ACCESS_CHECKOUT_PAYMENT_TITLE";
    
    
    
    [_createPayment sizeToFit];
    _createPayment.frame = CGRectInset(_createPayment.frame, -10, -10);
    
    _paymentAccount.frame = CGRectMake(margin,
                                       [_paymentTitle bottom] + lineHeight,
                                       [_contentView bW] - margin*3 - [_createPayment bW],
                                       lineHeight*2);
    
    _createPayment.center = CGPointMake([_contentView bW] - [_createPayment bW]/2 - margin , _paymentAccount.center.y);
    
    
    [_deliveryDetailsTitle sizeToFit];
    _deliveryDetailsTitle.center = CGPointMake([_deliveryDetailsTitle bW]/2 + margin,
                                          [_paymentAccount bottom] + [_deliveryDetailsTitle bH]/2 + lineHeight);
    _deliveryDetailsTitle.accessibilityIdentifier = @"ACCESS_CHECKOUT_DELIVERY_DETAILS_TITLE";
 
    [_deliveryAddressTitle sizeToFit];
    _deliveryAddressTitle.center = CGPointMake([_deliveryAddressTitle bW]/2 + margin,
                                               [_deliveryDetailsTitle bottom] + [_deliveryAddressTitle bH]/2 + lineHeight);
    
    
    [_createAddress sizeToFit];
    _createAddress.frame = CGRectInset(_createAddress.frame, -10, -10);
    
    _deliveryAddressButton.frame = CGRectMake(margin,
                                              [_deliveryAddressTitle bottom] + lineHeight,
                                              [_contentView bW] - margin*3 - [_createAddress bW],
                                              lineHeight*2);
    
    _createAddress.center = CGPointMake([_contentView bW] - [_createPayment bW]/2 - margin , _deliveryAddressButton.center.y);
    
    
    
    [_deliveryMethodTitle sizeToFit];
    _deliveryMethodTitle.center = CGPointMake([_deliveryMethodTitle bW]/2 + margin,
                                              [_deliveryAddressButton bottom] + [_deliveryMethodTitle bH]/2 + lineHeight);
    
    _deliveryMethodButton.frame = CGRectMake(margin,
                                             [_deliveryMethodTitle bottom] + lineHeight,
                                             [_contentView bW] - margin*2,
                                             lineHeight*2);

    _agreementPanel.frame = CGRectMake(margin,
                                       [_deliveryMethodButton bottom] + lineHeight,
                                       [_contentView bW] - margin*2,
                                       lineHeight*2);
    
    _agreementButton.frame = CGRectMake(margin,
                                        [_agreementPanel bH]*.2,
                                        [_agreementPanel bH]*.6,
                                        [_agreementPanel bH]*.6);
    
    [_agreementIntroLabel sizeToFit];
    _agreementIntroLabel.center = CGPointMake([_agreementButton right] +[_agreementIntroLabel bW]/2 + margin,
                                              [_agreementPanel bH]/2);
    
    [_agreementLinkLabel sizeToFit];
    _agreementLinkLabel.center = CGPointMake([_agreementIntroLabel right] + [_agreementLinkLabel bW]/2 + 4.f,
                                              [_agreementPanel bH]/2);
    
    [_agreementConfirmationLabel sizeToFit];
    _agreementConfirmationLabel.center = CGPointMake([_agreementConfirmationLabel bW]/2 + margin,
                                                     [_agreementPanel bottom] + [_agreementConfirmationLabel bH]/2 + lineHeight);
    
    _orderButton.frame = CGRectMake(margin,
                              [_agreementConfirmationLabel bottom] + lineHeight,
                              [_contentView bW] - margin*2,
                              lineHeight*3);

    _orderSummaryView.frame = CGRectMake(0,
                                         [_orderButton bottom] + lineHeight*2,
                                         [_contentView bW],
                                         [_contentView bH] - [_orderButton bottom] - lineHeight*2);
    
    [_orderSummaryView layoutSubviews];

    _contentView.contentSize = CGSizeMake([_contentView bW], [_orderSummaryView bottom]);
}

- (void)setup {
    
    //contentView
    
    _contentView = [UIScrollView new];
    _contentView.backgroundColor = checkout_background;
    
    //checkout title
    _checkoutTitle = [UILabel new];
    _checkoutTitle.text = NSLocalizedString(@"checkout_label_title", nil);
    _checkoutTitle.font = font_checkout_title;
    _checkoutTitle.textColor = checkout_title;
    
    //payment area
    _paymentTitle = [UILabel new];
    _paymentTitle.text = NSLocalizedString(@"payment_label_title", nil);
    _paymentTitle.font = font_checkout_default_label;
    _paymentTitle.textColor = checkout_default_label;
    
    _paymentAccount = [HYBDropDownButton new];
    [_paymentAccount setText:@"test"];
    
    _createPayment = [HYBActionButton new];
    [_createPayment setTitle:NSLocalizedString(@"createNewKey", nil) forState:UIControlStateNormal];
    [_createPayment setBackgroundColor:hybris_light_gray    forState:UIControlStateNormal];
    [_createPayment setTitleColor:address_form_legend       forState:UIControlStateNormal];
    
    //delivery details panel
    
    _deliveryDetailsTitle = [UILabel new];
    _deliveryDetailsTitle.text = NSLocalizedString(@"deliveryDetails_label_title", nil);
    _deliveryDetailsTitle.font = font_checkout_default_label;
    _deliveryDetailsTitle.textColor = checkout_default_label;
    
    _deliveryAddressTitle = [UILabel new];
    _deliveryAddressTitle.text = NSLocalizedString(@"deliveryAddress_label_title", nil);
    _deliveryAddressTitle.font = font_checkout_default_label_small;
    _deliveryAddressTitle.textColor = checkout_default_label;
    
    _deliveryAddressButton = [HYBDropDownButton new];
    _deliveryAddressButton.text = NSLocalizedString(@"delivery_address_selection", nil);
    
    _createAddress = [HYBActionButton new];
    [_createAddress setTitle:NSLocalizedString(@"createNewKey", nil) forState:UIControlStateNormal];
    [_createAddress setBackgroundColor:hybris_light_gray    forState:UIControlStateNormal];
    [_createAddress setTitleColor:address_form_legend       forState:UIControlStateNormal];
    
    _deliveryMethodTitle = [UILabel new];
    _deliveryMethodTitle.text = NSLocalizedString(@"deliveryMethod_label_title", nil);
    _deliveryMethodTitle.font = font_checkout_default_label_small;
    _deliveryMethodTitle.textColor = checkout_default_label;
    
    _deliveryMethodButton = [HYBDropDownButton new];
    _deliveryMethodButton.text = NSLocalizedString(@"deliveryMethod_label_title", nil);
    
     //agreement panel
    
    _agreementPanel = [UIView new];
    _agreementPanel.backgroundColor = checkout_agreement_panel_background;
    
    _agreementButton = [HYBActionButton new];
    _agreementButton.type = checkbox;
    [_agreementButton setBackgroundColor:checkout_agreement_button_normal   forState:UIControlStateNormal];
    [_agreementButton setBackgroundColor:checkout_agreement_button_selected forState:UIControlStateSelected];
    
    _agreementButton.layer.cornerRadius = 4.f;
    _agreementButton.layer.masksToBounds = YES;
    
    _agreementIntroLabel = [UILabel new];
    _agreementIntroLabel.textColor = checkout_agreement_intro;
    _agreementIntroLabel.font = font_checkout_default_label_small;
    _agreementIntroLabel.text = NSLocalizedString(@"agreement_label_intro", nil);
    
    _agreementLinkLabel = [UILabel new];
    _agreementLinkLabel.textColor = checkout_agreement_link;
    _agreementLinkLabel.font = font_checkout_default_label_small;
    _agreementLinkLabel.text= NSLocalizedString(@"agreement_label_link", nil);
    
    _agreementConfirmationLabel = [UILabel new];
    _agreementConfirmationLabel.text = NSLocalizedString(@"agreement_label_confirmation", nil);
    _agreementConfirmationLabel.font = font_checkout_default_label_small;
    _agreementConfirmationLabel.textColor = checkout_agreement_confirmation;
    _agreementConfirmationLabel.accessibilityIdentifier = @"ACCESS_CHECKOUT_AGREEMENT_ERROR";
    _agreementConfirmationLabel.hidden = YES;
    
    
    //order button
    _orderButton = [HYBActionButton new];
    [_orderButton setTitle:NSLocalizedString(@"order_button_checkout", nil) forState:UIControlStateNormal];
    _orderButton.enabled = NO;
    
    //order summary panel
    _orderSummaryView = [HYBOrderSummaryView new];
    _orderSummaryView.backgroundColor = checkout_order_summary_background;
    
    //mask
    
    _maskView = [UIView new];
    _maskView.backgroundColor = checkout_mask;
    _maskView.alpha = 0;
    _maskView.hidden = YES;
    
    //pile up
    
    [_contentView addSubview:_checkoutTitle];
    
    [_contentView addSubview:_paymentTitle];
    [_contentView addSubview:_paymentAccount];
    [_contentView addSubview:_createPayment];
    
    [_contentView addSubview:_deliveryDetailsTitle];
    [_contentView addSubview:_deliveryAddressTitle];
    [_contentView addSubview:_deliveryAddressButton];
    [_contentView addSubview:_createAddress];
    [_contentView addSubview:_deliveryMethodTitle];
    [_contentView addSubview:_deliveryMethodButton];
    
    [_agreementPanel addSubview:_agreementButton];
    [_agreementPanel addSubview:_agreementIntroLabel];
    [_agreementPanel addSubview:_agreementLinkLabel];
    [_contentView addSubview:_agreementPanel];
    
    [_contentView addSubview:_agreementConfirmationLabel];
    
    [_contentView addSubview:_orderButton];
    
    [_contentView addSubview:_orderSummaryView];
    
    [self addSubview:_contentView];

}



@end