//
//  HYBAddressButtonView.m
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


#import "HYBAddressButtonView.h"
#import "HYBConstants.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"
#import "UIView+Utilities.h"

@implementation HYBAddressButtonView

- (instancetype)init {
    if(self = [super init]) {
        [self setup];
    }
    
    return self;
}

- (void)setPaymentDetails:(HYBPaymentDetails *)paymentDetails {
    if(paymentDetails) {
        _paymentDetails = paymentDetails;
        
        _nameLabel.text = [NSString stringWithFormat:@"%@",_paymentDetails.accountHolderName];
        
        _lineOneLabel.text = [NSString stringWithFormat:@"%@ %@", _paymentDetails.cardType.name, _paymentDetails.cardNumber];
        _lineOneLabel.accessibilityIdentifier = @"ACCESS_ACCOUNT_PAYMENT_DETAILS_TYPE_NUMBER";
        
        _editBtn.hidden = YES;
        
    } else {
        
        [_editBtn setTitle:NSLocalizedString(@"createNewKey", nil) forState:UIControlStateNormal];
        _editBtn.hidden = NO;
        
        _nameLabel.text = @"";
        _lineOneLabel.text = @"";
    }
    
    _nameLabel.accessibilityIdentifier = @"ACCESS_ACCOUNT_PAYMENT_DETAILS_NAME";
    _lineOneLabel.accessibilityIdentifier = @"ACCESS_ACCOUNT_PAYMENT_DETAILS_TYPE_NUMBER";
    _lineTwoLabel.text =  @"";
}

- (void)setAddress:(HYBAddress *)address {
    if(address) {
        _address = address;
        
        _nameLabel.text = [NSString stringWithFormat:@"%@ %@",_address.firstName, _address.lastName];
        _nameLabel.accessibilityIdentifier = @"ACCESS_ACCOUNT_ADDRESS_NAME";
        
        if(_address.line2) {
            _lineOneLabel.text = [NSString stringWithFormat:@"%@ %@",_address.line1, _address.line2];
        } else {
             _lineOneLabel.text = [NSString stringWithFormat:@"%@",_address.line1];
        }
        
        _lineTwoLabel.text = [NSString stringWithFormat:@"%@ %@",_address.town, _address.postalCode];
        
        _editBtn.hidden = YES;
        
    } else {
        
        [_editBtn setTitle:NSLocalizedString(@"createNewKey", nil) forState:UIControlStateNormal];
        _editBtn.hidden = NO;
        
        _nameLabel.text = @"";
        _lineOneLabel.text = @"";
        _lineTwoLabel.text =  @"";
    }
    _lineOneLabel.accessibilityIdentifier = @"ACCESS_ACCOUNT_ADDRESS_ONE";
    _lineTwoLabel.accessibilityIdentifier =  @"ACCESS_ACCOUNT_ADDRESS_TWO";
}

- (void)setup {
    
    _legend = [UILabel new];
    _legend.font = font_address_form_default_label_small;
    _legend.textColor = address_form_legend;
    
    _nameLabel = [UILabel new];
    _nameLabel.font = font_address_form_default_label;
    _nameLabel.textColor = address_form_legend;
    
    _lineOneLabel = [UILabel new];
    _lineOneLabel.font = font_address_form_default_label;
    _lineOneLabel.textColor = address_form_legend;
    
    _lineTwoLabel = [UILabel new];
    _lineTwoLabel.font = font_address_form_default_label;
    _lineTwoLabel.textColor = address_form_legend;
    
    _editBtn = [HYBActionButton new];
    [_editBtn setTitle:NSLocalizedString(@"createNewKey", nil) forState:UIControlStateNormal];
    [_editBtn setBackgroundColor:hybris_light_gray    forState:UIControlStateDisabled];
    [_editBtn setTitleColor:address_form_legend       forState:UIControlStateDisabled];
    
    //pile up
    [self addSubview:_legend];
    [self addSubview:_nameLabel];
    [self addSubview:_lineOneLabel];
    [self addSubview:_lineTwoLabel];
    [self addSubview:_editBtn];
}

- (void)layoutSubviews {
    CGFloat nudge = 12.f;
    
    [_legend sizeToFit];
    _legend.center = CGPointMake([_legend bW]/2+nudge,
                                 [self bH]/6);
   
    [_nameLabel sizeToFit];
    _nameLabel.center = CGPointMake([_nameLabel bW]/2+nudge,
                                 [self bH]/3);
    
    [_lineOneLabel sizeToFit];
    _lineOneLabel.center = CGPointMake([_lineOneLabel bW]/2+nudge,
                                 [self bH]/2);
    
    [_lineTwoLabel sizeToFit];
    _lineTwoLabel.center = CGPointMake([_lineTwoLabel bW]/2+nudge,
                                         [self bH]/6*4);
    
    [_editBtn sizeToFit];
    _editBtn.frame = CGRectInset(_editBtn.frame, -10, -10);
    _editBtn.center = CGPointMake([_editBtn bW]/2+nudge,
                                 [self bH]/2+nudge);
    
}

@end
