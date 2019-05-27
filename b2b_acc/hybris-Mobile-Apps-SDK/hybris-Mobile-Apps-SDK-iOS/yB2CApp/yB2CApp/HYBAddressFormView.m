//
//  HYBAddressFormView.m
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

#import "HYBAddressFormView.h"

@interface HYBAddressFormView ()

@property(nonatomic) UIView *contentView;

@end

@implementation HYBAddressFormView

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
    
    //header
    _headerPanel.frame = CGRectMake(0,0, [self bW], defaultTopMargin);
    
    //close
    [_closeButton sizeToFit];
    _closeButton.frame = CGRectInset(_closeButton.frame, -10, -10);
    _closeButton.center = CGPointMake([_closeButton bW]/2 + margin/2, [_headerPanel bH]/2);
    
    //save
    [_saveButton sizeToFit];
    _saveButton.frame = CGRectInset(_saveButton.frame, -10, -10);
    _saveButton.center = CGPointMake([_headerPanel bW] - [_saveButton bW]/2 - margin/2, [_headerPanel bH]/2);
    
    //fields
    [_titleLabel sizeToFit];
    _titleLabel.center = CGPointMake([_headerPanel bW]/2, [_headerPanel bH]/2);
    
    
    
    
    [_legendLabel sizeToFit];
    _legendLabel.center = CGPointMake([_legendLabel bW]/2,
                                      margin);
    
    CGFloat fieldH = lineHeight*2.25;
    CGFloat fieldW = [_contentView bW] - margin*2;
    CGFloat fieldInter = margin*.7;
    
    _titleSelector.frame = CGRectMake(0,
                                      [_legendLabel bottom] + lineHeight,
                                      90.f,
                                      fieldH);

    
    _firstNameField.frame = CGRectMake(0,
                                       [_titleSelector bottom] + fieldInter,
                                       fieldW/2-margin/2,
                                       fieldH);
    
    _lastNameField.frame = CGRectMake([_firstNameField right]+margin,
                                      [_titleSelector bottom] + fieldInter,
                                      fieldW/2-margin/2,
                                      fieldH);
    
    
    _addressLineOneField.frame = CGRectMake(0,
                                            [_lastNameField bottom] + fieldInter,
                                            fieldW,
                                            fieldH);
    
    _addressLineTwoField.frame = CGRectMake(0,
                                            [_addressLineOneField bottom] + fieldInter,
                                            fieldW,
                                            fieldH);
    
    _cityField.frame = CGRectMake(0,
                                  [_addressLineTwoField bottom] + fieldInter,
                                  fieldW,
                                  fieldH);
    
    _zipCodeField.frame = CGRectMake(0,
                                     [_cityField bottom] + fieldInter,
                                     fieldW/2-margin/2,
                                     fieldH);
    
    _countrySelector.frame = CGRectMake([_zipCodeField right] + margin,
                                      [_cityField bottom] + fieldInter,
                                      fieldW/2-margin/2,
                                      fieldH);
    
    _formPanel.frame = CGRectMake(margin,
                                  [_headerPanel bottom]/2 + margin,
                                  [_contentView bW] - margin*2,
                                  [_countrySelector bottom]);
    
}

- (void)setup {
    
    //content view
    _contentView = [UIView new];
    _contentView.backgroundColor = address_form_title;
    
    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    //header
    _headerPanel  = [UIView new];
    _headerPanel.backgroundColor = hybris_white;
    
    _closeButton = [HYBActionButton new];
    [_closeButton setTitle:NSLocalizedString(@"backKey", nil) forState:UIControlStateNormal];
    [_closeButton setBackgroundColor:hybris_gray forState:UIControlStateNormal];
    
    _saveButton = [HYBActionButton new];
    [_saveButton setTitle:NSLocalizedString(@"saveKey", nil) forState:UIControlStateNormal];
    [_saveButton setBackgroundColor:hybris_yellow forState:UIControlStateNormal];
    
    _titleLabel = [UILabel new];
    _titleLabel.font = font_address_form_title;
    _titleLabel.textColor = address_form_title;
    
    //legend
    _legendLabel = [UILabel new];
    _legendLabel.text = NSLocalizedString(@"all_fields_required", nil);
    _legendLabel.font = font_address_form_Legend;
    _legendLabel.textColor = address_form_legend;
    
    //fields
    _formPanel = [UIView new];
    
    _titleSelector = [HYBDropDownButton new];
    _titleSelector.text = @"";
    _titleSelector.userInteractionEnabled = YES;
    
    _firstNameField = [self defaultTextField];
    _firstNameField.placeholder = NSLocalizedString(@"firstNameKey", nil);
    _firstNameField.returnKeyType = UIReturnKeyNext;
    
    _lastNameField  = [self defaultTextField];
    _lastNameField.placeholder = NSLocalizedString(@"lastNameKey", nil);
    _lastNameField.returnKeyType = UIReturnKeyNext;

    _addressLineOneField = [self defaultTextField];
    _addressLineOneField.placeholder = NSLocalizedString(@"addressLineOneKey", nil);
    _addressLineOneField.returnKeyType = UIReturnKeyNext;

    _addressLineTwoField = [self defaultTextField];
    _addressLineTwoField.placeholder = NSLocalizedString(@"addressLineTwoKey", nil);
    _addressLineTwoField.returnKeyType = UIReturnKeyNext;
    
    _cityField      = [self defaultTextField];
    _cityField.placeholder = NSLocalizedString(@"cityKey", nil);
    _cityField.returnKeyType = UIReturnKeyNext;

    _zipCodeField   = [self defaultTextField];
    _zipCodeField.placeholder = NSLocalizedString(@"zipCodeKey", nil);
    _zipCodeField.returnKeyType = UIReturnKeyNext;

    _countrySelector = [HYBDropDownButton new];
    _countrySelector.text = @"";
    _countrySelector.userInteractionEnabled = YES;

    //mask
    _maskView = [UIView new];
    _maskView.backgroundColor = checkout_mask;
    _maskView.alpha = 0;
    _maskView.hidden = YES;
    
    //pile up
    [_headerPanel addSubview:_closeButton];
    [_headerPanel addSubview:_saveButton];
    [_headerPanel addSubview:_titleLabel];
    
    [_contentView addSubview:_headerPanel];
    
    [_formPanel addSubview:_legendLabel];
    
    [_formPanel addSubview:_titleSelector];
    [_formPanel addSubview:_firstNameField];
    [_formPanel addSubview:_lastNameField];
    
    [_formPanel addSubview:_addressLineOneField];
    [_formPanel addSubview:_addressLineTwoField];
    
    [_formPanel addSubview:_cityField];
    [_formPanel addSubview:_zipCodeField];
    [_formPanel addSubview:_countrySelector];
    
    [_contentView addSubview:_formPanel];
    
    [self addSubview:_contentView];
    
}

- (UITextField*)defaultTextField {
    
    UITextField *defaultField = [UITextField new];
    defaultField.font = font_address_form_default_label;
    defaultField.textColor = address_form_default_label;
    defaultField.textAlignment = NSTextAlignmentLeft;
    defaultField.layer.borderColor = address_form_cell_border.CGColor;
    defaultField.layer.borderWidth = 1.f;
    
    UIView *paddingView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 20, 0)];
    defaultField.leftView = paddingView;
    defaultField.leftViewMode = UITextFieldViewModeAlways;
    
    return defaultField;
}

@end
