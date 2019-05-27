//
// HYBWebviewController.m
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


#import "HYBWebviewController.h"
#import "UIView+Utilities.h"
#import "HYBActionButton.h"

@interface HYBWebviewController ()

@property (nonatomic) UIWebView *webview;
@property (nonatomic) HYBActionButton *backButton;

@end

@implementation HYBWebviewController

- (id)initWithLink:(NSString *)link {
    return [self initWithURL:[NSURL URLWithString:link]];
}

- (id)initWithURL:(NSURL *)url {
    
    if (self = [super init]) {
        
        self.view.backgroundColor = [UIColor whiteColor];
        
        self.automaticallyAdjustsScrollViewInsets = NO;
        
        self.view.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        self.view.autoresizesSubviews = YES;
        
        
        _backButton = [HYBActionButton new];
        _backButton.frame = CGRectMake(0,
                                       defaultTopMargin,
                                       [self.view bW]/7,
                                       defaultTopMargin/3*2);
        
        _backButton.accessibilityIdentifier = @"ACCESS_WEBVIEW_BACK_BUTTON";
        [_backButton addTarget:self action:@selector(dismiss) forControlEvents:UIControlEventTouchUpInside];
        
        [_backButton setTitle:NSLocalizedString(@"Back", nil) forState:UIControlStateNormal];
        
        CGRect frame = CGRectMake(0,
                                  [_backButton bottom],
                                  [self.view bW],
                                  [self.view bH]-[_backButton bottom]);
        
        _webview = [[UIWebView alloc] initWithFrame:frame];
        _webview.accessibilityIdentifier = @"ACCESS_WEBVIEW";
        [_webview loadRequest:[NSURLRequest requestWithURL:url]];
        
        
        [self.view addSubview:_backButton];
        [self.view addSubview:_webview];
    }

    return self;
}

- (void)dismiss {
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation {
    [UIView animateWithDuration:defaultAnimationDuration
                     animations:^() {
                         _webview.frame = CGRectMake(0,
                                                         defaultTopMargin/3*2,
                                                         [self.view bW],
                                                         [self.view bH]-defaultTopMargin/3*2);
                     }];
}


@end
