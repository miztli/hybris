//
//  HYBSettingsView.m
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

#import "HYBSettingsView.h"

@implementation HYBSettingsView

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
    
    CGFloat fieldH = lineHeight*2.25;
    CGFloat fieldW = [_contentView bW] - margin*2;
    
    CGFloat colTwo = [self bW] /2 - margin/2;
    
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    
    if (orientation == UIDeviceOrientationLandscapeLeft ||
        orientation == UIDeviceOrientationLandscapeRight) {
        lineHeight = 15.f;
    }
    
    //content frame
    _contentView.frame = CGRectMake([self bX], [self bY] + defaultTopMargin/2 , [self bW], [self bH] - defaultTopMargin);
    
    [_pageTitle sizeToFit];
    _pageTitle.center = CGPointMake([_pageTitle bW]/2 + margin,
                                    [_pageTitle bH]/2 + margin);
    
    
    
    
    [_feedbackBtn sizeToFit];
    _feedbackBtn.frame = CGRectInset(_feedbackBtn.frame, -10, 0);
    
    _feedbackBtn.center = CGPointMake([self bW]- margin - [_feedbackBtn bW]/2,
                                   [_pageTitle top] - margin/2);
    _feedbackBtn.accessibilityIdentifier = @"SETTINGS_FEEDBACK_BTN";

    
    [_backendTitle sizeToFit];
    _backendTitle.center = CGPointMake([_backendTitle bW]/2 + margin,
                                    [_pageTitle bottom] + [_backendTitle bH]/2 + lineHeight*1.5);
    _backendTitle.accessibilityIdentifier = @"SETTINGS_BACKEND_TITLE";
    
    _backendControl.center = CGPointMake([_backendControl bW]/2 + margin,
                                        [_backendTitle bottom] + [_backendControl bH]/2 + lineHeight*1.5);
    
     _backendControl.accessibilityIdentifier = @"SETTINGS_BACKEND_CONTROL";
    
    [_backendHostTitle sizeToFit];
    _backendHostTitle.center = CGPointMake([_backendHostTitle bW]/2 + margin,
                                       [_backendControl bottom] + [_backendHostTitle bH]/2 + lineHeight);
    _backendHostTitle.accessibilityIdentifier = @"SETTINGS_BACKEND_HOST_TITLE";


    _backendHostField.frame = CGRectMake([_backendHostTitle left],
                                       [_backendHostTitle bottom] + lineHeight,
                                       fieldW/2-margin/2,
                                       fieldH);
    
    _backendHostField.accessibilityIdentifier = @"SETTINGS_BACKEND_HOST_FIELD";
    
    
    [_backendPortTitle sizeToFit];
    _backendPortTitle.center = CGPointMake([_backendPortTitle bW]/2 + margin,
                                           [_backendHostField bottom] + [_backendPortTitle bH]/2 + lineHeight);
    _backendPortTitle.accessibilityIdentifier = @"SETTINGS_BACKEND_PORT_TITLE";
    
    
    _backendPortField.frame = CGRectMake([_backendPortTitle left],
                                         [_backendPortTitle bottom] + lineHeight,
                                         fieldW/2-margin/2,
                                         fieldH);
    
    _backendPortField.accessibilityIdentifier = @"SETTINGS_BACKEND_PORT_FIELD";
    
    
    
    [_catalogTitle sizeToFit];
    _catalogTitle.center = CGPointMake([_catalogTitle bW]/2 + margin + colTwo,
                                       [_pageTitle bottom] + [_catalogTitle bH]/2 + lineHeight*1.5);
    _catalogTitle.accessibilityIdentifier = @"SETTINGS_BACKEND_TITLE";
    
    _catalogControl.center = CGPointMake([_catalogControl bW]/2 + margin + colTwo,
                                         [_catalogTitle bottom] + [_catalogControl bH]/2 + lineHeight*1.5);
    
    _catalogControl.accessibilityIdentifier = @"SETTINGS_BACKEND_CONTROL";

    //
    
    [_storeTitle sizeToFit];
    _storeTitle.center = CGPointMake([_storeTitle bW]/2 + margin +colTwo,
                                           [_catalogControl bottom] + [_storeTitle bH]/2 + lineHeight);
    _storeTitle.accessibilityIdentifier = @"SETTINGS_STORE_TITLE";
    
    
    _storeField.frame = CGRectMake([_storeTitle left],
                                         [_storeTitle bottom] + lineHeight,
                                         fieldW/2-margin/2,
                                         fieldH);
    
    _storeField.accessibilityIdentifier = @"SETTINGS_STORE_FIELD";

    
    //
    
    [_catalogIdTitle sizeToFit];
    _catalogIdTitle.center = CGPointMake([_catalogIdTitle bW]/2 + margin + colTwo,
                                           [_storeField bottom] + [_catalogIdTitle bH]/2 + lineHeight);
    _catalogIdTitle.accessibilityIdentifier = @"SETTINGS_CATALOG_ID_TITLE";
    
    
    _catalogIdField.frame = CGRectMake([_catalogIdTitle left],
                                         [_catalogIdTitle bottom] + lineHeight,
                                         fieldW/2-margin/2,
                                         fieldH);
    
    _catalogIdField.accessibilityIdentifier = @"SETTINGS_CATALOG_ID_FIELD";

    
    //
    
    [_rootIdTitle sizeToFit];
    _rootIdTitle.center = CGPointMake([_rootIdTitle bW]/2 + margin + colTwo,
                                           [_catalogIdField bottom] + [_rootIdTitle bH]/2 + lineHeight);
    _rootIdTitle.accessibilityIdentifier = @"SETTINGS_CATALOG_ROOT_TITLE";
    
    
    _rootIdField.frame = CGRectMake([_rootIdTitle left],
                                         [_rootIdTitle bottom] + lineHeight,
                                         fieldW/2-margin/2,
                                         fieldH);
    
    _rootIdField.accessibilityIdentifier = @"SETTINGS_CATALOG_ROOT_FIELD";

    
    [_closeBtn sizeToFit];
    _closeBtn.frame = CGRectInset(_closeBtn.frame, -20, -10);
    _closeBtn.center = CGPointMake([self bW]/2,
                                      [_rootIdField bottom] + [_closeBtn bH]/2 + lineHeight*4);
    _closeBtn.accessibilityIdentifier = @"SETTINGS_CLOSE_BTN";
}

- (void)setup {
    
    //content view
    _contentView = [UIView new];
    _contentView.backgroundColor = account_background;
    
    _contentView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    _contentView.autoresizesSubviews = YES;
    
    //page title
    _pageTitle = [UILabel new];
    _pageTitle.text = NSLocalizedString(@"settings_title", nil);
    _pageTitle.font = font_settings_title;
    _pageTitle.textColor = settings_title;
    
    //_backendTitle
    _backendTitle = [UILabel new];
    _backendTitle.text = NSLocalizedString(@"settings_backend_title", nil);
    _backendTitle.font = font_settings_default_label;
    _backendTitle.textColor = settings_default_label;
    
    //control
    _backendControl = [[UISegmentedControl alloc] initWithItems:[NSArray arrayWithObjects:@"Dev",@"Prod",@"Custom", nil]];
    
    //backendHostTitle
    _backendHostTitle = [UILabel new];
    _backendHostTitle.text = NSLocalizedString(@"settings_backend_host_title", nil);
    _backendHostTitle.font = font_settings_default_label;
    _backendHostTitle.textColor = settings_default_label;

    //backendHostField
    _backendHostField = [self defaultTextField];
    _backendHostField.placeholder = NSLocalizedString(@"settings_backend_host", nil);
    _backendHostField.keyboardType = UIKeyboardTypeURL;
    
    //backendPortTitle
    _backendPortTitle = [UILabel new];
    _backendPortTitle.text = NSLocalizedString(@"settings_backend_port_title", nil);
    _backendPortTitle.font = font_settings_default_label;
    _backendPortTitle.textColor = settings_default_label;

    //backendPortField
    _backendPortField = [self defaultTextField];
    _backendPortField.placeholder = NSLocalizedString(@"settings_backend_port", nil);
    _backendPortField.keyboardType = UIKeyboardTypeNumberPad;
    
    
    //catalogTitle
    _catalogTitle = [UILabel new];
    _catalogTitle.text = NSLocalizedString(@"settings_catalog_title", nil);
    _catalogTitle.font = font_settings_default_label;
    _catalogTitle.textColor = settings_default_label;
    
    //control
    _catalogControl = [[UISegmentedControl alloc] initWithItems:[NSArray arrayWithObjects:@"Powertools",@"Custom", nil]];

    
    //storeTitle
    _storeTitle = [UILabel new];
    _storeTitle.text = NSLocalizedString(@"settings_store_title", nil);
    _storeTitle.font = font_settings_default_label;
    _storeTitle.textColor = settings_default_label;
    
    //storeField
    _storeField = [self defaultTextField];
    _storeField.placeholder = NSLocalizedString(@"settings_store", nil);

    //catalogIdTitle
    _catalogIdTitle = [UILabel new];
    _catalogIdTitle.text = NSLocalizedString(@"settings_catalog_id_title", nil);
    _catalogIdTitle.font = font_settings_default_label;
    _catalogIdTitle.textColor = settings_default_label;
    
    //catalogIdField
    _catalogIdField = [self defaultTextField];
    _catalogIdField.placeholder = NSLocalizedString(@"settings_catalog_id", nil);
    
    
    //rootIdTitle
    _rootIdTitle = [UILabel new];
    _rootIdTitle.text = NSLocalizedString(@"settings_catalog_root_title", nil);
    _rootIdTitle.font = font_settings_default_label;
    _rootIdTitle.textColor = settings_default_label;
    
    //rootIdField
    _rootIdField = [self defaultTextField];
    _rootIdField.placeholder = NSLocalizedString(@"settings_root", nil);
    
    
    _closeBtn = [HYBActionButton new];
    [_closeBtn setTitle:NSLocalizedString(@"closeKey", nil) forState:UIControlStateNormal];

    
    _feedbackBtn = [HYBActionButton new];
    [_feedbackBtn setTitle:NSLocalizedString(@"mail_feedback", nil) forState:UIControlStateNormal];

    
    //pile up
    [_contentView addSubview:_pageTitle];
    
    [_contentView addSubview:_feedbackBtn];
     
    [_contentView addSubview:_backendTitle];
    [_contentView addSubview:_backendControl];
    
    [_contentView addSubview:_backendHostTitle];
    [_contentView addSubview:_backendHostField];
    [_contentView addSubview:_backendPortTitle];
    [_contentView addSubview:_backendPortField];
    
    [_contentView addSubview:_catalogTitle];
    [_contentView addSubview:_catalogControl];
    
    [_contentView addSubview:_storeTitle];
    [_contentView addSubview:_storeField];
    [_contentView addSubview:_catalogIdTitle];
    [_contentView addSubview:_catalogIdField];
    [_contentView addSubview:_rootIdTitle];
    [_contentView addSubview:_rootIdField];
    
    [_contentView addSubview:_closeBtn];
    
    [self addSubview:_contentView];
    
}

- (UITextField*)defaultTextField {
    
    UITextField *defaultField = [UITextField new];
    defaultField.font = font_address_form_default_label;
    defaultField.textColor = address_form_default_label;
    defaultField.textAlignment = NSTextAlignmentLeft;
    defaultField.layer.borderColor = address_form_cell_border.CGColor;
    defaultField.layer.borderWidth = 1.f;
    defaultField.clearButtonMode = UITextFieldViewModeWhileEditing;
    defaultField.clearsOnBeginEditing = NO;
    defaultField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    defaultField.autocorrectionType = UITextAutocorrectionTypeNo;
    
    UIView *paddingView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 20, 0)];
    defaultField.leftView = paddingView;
    defaultField.leftViewMode = UITextFieldViewModeAlways;
    
    return defaultField;
}

@end
