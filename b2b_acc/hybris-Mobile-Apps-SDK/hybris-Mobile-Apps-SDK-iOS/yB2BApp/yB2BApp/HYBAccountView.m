//
//  HYBAccountView.m
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

#import "HYBAccountView.h"

@implementation HYBAccountView


- (id)initWithFrame:(CGRect)frame {
    if(self = [super initWithFrame:frame]) {
        [self setup];
    }
    return self;
}

- (void)layoutSubviews {
    [super layoutSubviews];
    
    CGFloat margin = [self bW]*.05;
    CGFloat lineHeight = 20.f;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 15.f;
    }
    
    //content frame
    _contentView.frame = CGRectMake([self bX], [self bY] + defaultTopMargin , [self bW], [self bH] - defaultTopMargin);
    
    _maskView.frame = _contentView.frame;
    
    [_pageTitle sizeToFit];
    _pageTitle.center = CGPointMake([_pageTitle bW]/2 + margin,
                                    [_pageTitle bH]/2 + margin);
    _pageTitle.accessibilityIdentifier = @"ACCESS_ACCOUNT_PAGE_TITLE";
    
    
    [_userEmail sizeToFit];
    _userEmail.center = CGPointMake([_pageTitle right] + [_userEmail bW]/2 + margin/2,
                                    [_pageTitle bottom] - [_userEmail bH]/2);
    _userEmail.accessibilityIdentifier = @"ACCESS_ACCOUNT_EMAIL_TITLE";
    
    [_profileHeader sizeToFit];
    _profileHeader.center = CGPointMake([_profileHeader bW]/2 + margin,
                                        [_userEmail bottom] + [_profileHeader bH]/2 + lineHeight*1.5);
    _profileHeader.accessibilityIdentifier = @"ACCESS_ACCOUNT_PROFILE_HEADER";
    
    _titleSelector.frame = CGRectMake(margin,
                                      [_profileHeader bottom] + lineHeight,
                                      [_contentView bW] - margin*2,
                                      lineHeight*2);
    _titleSelector.accessibilityIdentifier = @"ACCESS_ACCOUNT_TITLE_SELECTOR";
    
    _firstNamePanel.frame = CGRectMake(margin,
                                       [_titleSelector bottom] + lineHeight,
                                       [_contentView bW] - margin*2,
                                       lineHeight*2);
    
    
    _firstNameField.frame = CGRectInset(_firstNamePanel.bounds, lineHeight/2, lineHeight/2);
    _firstNameField.accessibilityIdentifier = @"ACCESS_ACCOUNT_FIRSTNAME_FIELD";
    
    
    _lastNamePanel.frame = CGRectMake(margin,
                                      [_firstNamePanel bottom] + lineHeight,
                                      [_contentView bW] - margin*2,
                                      lineHeight*2);
    
    _lastNameField.frame = CGRectInset(_lastNamePanel.bounds, lineHeight/2, lineHeight/2);
    _lastNameField.accessibilityIdentifier = @"ACCESS_ACCOUNT_LASTNAME_FIELD";
    
    
    [_languageHeader sizeToFit];
    _languageHeader.center = CGPointMake([_languageHeader bW]/2 + margin,
                                         [_lastNamePanel bottom] + [_languageHeader bH]/2 + lineHeight*1.5);
    _languageHeader.accessibilityIdentifier = @"ACCESS_ACCOUNT_LANGUAGE_HEADER";
    
    
    _languageSelector.frame = CGRectMake(margin,
                                         [_languageHeader bottom] + lineHeight,
                                         [_contentView bW] - margin*2,
                                         lineHeight*2);
    _languageSelector.accessibilityIdentifier = @"ACCESS_ACCOUNT_LANGUAGE_SELECTOR";
    
    
    [_paymentDetailsHeader sizeToFit];
    _paymentDetailsHeader.center = CGPointMake([_paymentDetailsHeader bW]/2 + margin,
                                               [_languageSelector bottom] + [_paymentDetailsHeader bH]/2 + lineHeight*1.5);
    _paymentDetailsHeader.accessibilityIdentifier = @"ACCESS_ACCOUNT_DELIVERY_HEADER";
    
    
    [_costCenterLegend sizeToFit];
    _costCenterLegend.center = CGPointMake([_costCenterLegend bW]/2 + margin,
                                           [_paymentDetailsHeader bottom] + [_costCenterLegend bH]/2 + lineHeight);
    _costCenterLegend.accessibilityIdentifier = @"ACCESS_ACCOUNT_COST_CENTER";
    
    
    _costCenterSelector.frame = CGRectMake(margin,
                                           [_costCenterLegend bottom] + lineHeight,
                                           [_contentView bW] - margin*2,
                                           lineHeight*2);
    _costCenterSelector.accessibilityIdentifier = @"ACCESS_ACCOUNT_COST_CENTER_SELECTOR";
    
    
    
    
    [_deliveryAddressesLegend sizeToFit];
    _deliveryAddressesLegend.center = CGPointMake([_deliveryAddressesLegend bW]/2 + margin,
                                           [_costCenterSelector bottom] + [_deliveryAddressesLegend bH]/2 + lineHeight);
    _deliveryAddressesLegend.accessibilityIdentifier = @"ACCESS_ACCOUNT_DELIVERY_ADDRESS";
    
    
    _addressTableView.frame = CGRectMake(margin,
                                         [_deliveryAddressesLegend bottom] + lineHeight,
                                         [_contentView bW] - margin*2,
                                         [_contentView bH]-[_deliveryAddressesLegend bottom] + lineHeight - margin);
    _addressTableView.accessibilityIdentifier = @"ACCESS_ACCOUNT_ADDRESS_TABLEVIEW";
    
    
}

- (void)setup {
    
    //content view
    _contentView = [UIView new];
    _contentView.backgroundColor = account_background;
    
    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    //page title
    _pageTitle = [UILabel new];
    _pageTitle.text = NSLocalizedString(@"account_label_title", nil);
    _pageTitle.font = font_account_title;
    _pageTitle.textColor = account_title;
    
    //email
    _userEmail = [UILabel new];
    _userEmail.text = NSLocalizedString(@"user_email", nil);
    _userEmail.font = font_account_default_label;
    _userEmail.textColor = account_default_label;

    //profile
    _profileHeader = [UILabel new];
    _profileHeader.text = [NSLocalizedString(@"account_profile_title", nil) uppercaseString];
    _profileHeader.font = font_account_default_label;
    _profileHeader.textColor = account_default_label;
    
    _titleSelector = [HYBDropDownButton new];
    _titleSelector.text = @"";
    
    _firstNameField = [UITextField new];
    _firstNameField.placeholder = NSLocalizedString(@"account_firstname", nil);
    _firstNameField.font = font_account_default_label;
    _firstNameField.clearButtonMode = UITextFieldViewModeWhileEditing;
    _firstNameField.clearsOnBeginEditing = NO;
    _firstNameField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _firstNameField.autocorrectionType = UITextAutocorrectionTypeNo;
    
    _firstNamePanel = [UIView new];
    _firstNamePanel.layer.borderWidth = 1.0f;
    _firstNamePanel.layer.borderColor = [hybris_gray CGColor];
    
    _lastNameField = [UITextField new];
    _lastNameField.placeholder = NSLocalizedString(@"account_lastname", nil);
    _lastNameField.font = font_account_default_label;
    _lastNameField.clearButtonMode = UITextFieldViewModeWhileEditing;
    _lastNameField.clearsOnBeginEditing = NO;
    _lastNameField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    _lastNameField.autocorrectionType = UITextAutocorrectionTypeNo;

    _lastNamePanel = [UIView new];
    _lastNamePanel.layer.borderWidth = 1.0f;
    _lastNamePanel.layer.borderColor = [hybris_gray CGColor];
    
    //language
    _languageHeader = [UILabel new];
    _languageHeader.text = [NSLocalizedString(@"language_label_title", nil) uppercaseString];
    _languageHeader.font = font_account_default_label;
    _languageHeader.textColor = account_default_label;
    
    _languageSelector = [HYBDropDownButton new];
    _languageSelector.text = @"";
    
    //payment details
    _paymentDetailsHeader = [UILabel new];
    _paymentDetailsHeader.text = [NSLocalizedString(@"payment_label_title", nil) uppercaseString];
    _paymentDetailsHeader.font = font_account_default_label;
    _paymentDetailsHeader.textColor = account_default_label;
    
    _costCenterLegend = [UILabel new];
    _costCenterLegend.text = [NSLocalizedString(@"costcenter_label_title", nil) uppercaseString];
    _costCenterLegend.font = font_account_default_label_small;
    _costCenterLegend.textColor = account_default_label;
    
    _costCenterSelector = [HYBDropDownButton new];
    _costCenterSelector.text = @"";
    
    _deliveryAddressesLegend = [UILabel new];
    _deliveryAddressesLegend.text = [NSLocalizedString(@"deliverydetails_label_title", nil) uppercaseString];
    _deliveryAddressesLegend.font = font_account_default_label_small;
    _deliveryAddressesLegend.textColor = account_default_label;
    
    _addressTableView = [UITableView new];
    
    //mask    
    _maskView = [UIView new];
    _maskView.backgroundColor = checkout_mask;
    _maskView.alpha = 0;
    _maskView.hidden = YES;
    
    //pile up
    [_contentView addSubview:_pageTitle];
    
    [_contentView addSubview:_userEmail];
    
    [_contentView addSubview:_profileHeader];
    [_contentView addSubview:_titleSelector];
    
    [_firstNamePanel addSubview:_firstNameField];
    [_contentView addSubview:_firstNamePanel];
    
    [_lastNamePanel addSubview:_lastNameField];
    [_contentView addSubview:_lastNamePanel];
    
    [_contentView addSubview:_languageHeader];
    [_contentView addSubview:_languageSelector];
    
    [_contentView addSubview:_paymentDetailsHeader];
    [_contentView addSubview:_costCenterLegend];
    [_contentView addSubview:_costCenterSelector];
    [_contentView addSubview:_deliveryAddressesLegend];
    [_contentView addSubview:_addressTableView];
    
    [self addSubview:_contentView];
}

@end
