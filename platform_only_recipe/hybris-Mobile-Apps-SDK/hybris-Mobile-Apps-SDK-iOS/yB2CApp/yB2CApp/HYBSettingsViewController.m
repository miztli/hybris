//
//  HYBSettingsViewController.m
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

#import "HYBSettingsViewController.h"
#import "HYBSettingsView.h"
#import "MYEnvironmentConfig.h"
#import "NSObject+HYBAdditionalMethods.h"
#import "MYEnvironmentConfig+HYBAdditionalMethods.h"

@interface HYBSettingsViewController ()

@property (nonatomic) HYBSettingsView *mainView;

@property (nonatomic) NSArray *defaultServers;
@property (nonatomic) NSArray *defaultCatalogs;

@end

@implementation HYBSettingsViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        self.view.backgroundColor = [UIColor whiteColor];
        
        _defaultServers = [NSArray arrayWithObjects:
                           
                           [NSDictionary dictionaryWithObjectsAndKeys:
                            @"",BACKENDHOST,
                            @"",BACKENDPORT,
                            nil],
                           
                           [NSDictionary dictionaryWithObjectsAndKeys:
                            @"",BACKENDHOST,
                            @"",BACKENDPORT,
                            nil],
                           
                           nil];
        
        _defaultCatalogs = [NSArray arrayWithObjects:
                          
                          [NSDictionary dictionaryWithObjectsAndKeys:
                           @"electronics",STOREID,
                           @"electronicsProductCatalog",CATALOGID,
                           @"1",ROOTCATEGORYID,
                           nil],
                          
                          [NSDictionary dictionaryWithObjectsAndKeys:
                           @"apparel-uk",STOREID,
                           @"apparelProductCatalog",CATALOGID,
                           @"categories",ROOTCATEGORYID,
                           nil],
                          
                          nil];
    }
    
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) {
        _mainView = [HYBSettingsView new];
        
        //feedback btn interaction
        [_mainView.feedbackBtn addTarget:self
                                  action:@selector(openFeedback)
                        forControlEvents:UIControlEventTouchUpInside];

        //close btn interaction
        [_mainView.closeBtn addTarget:self
                               action:@selector(dismiss)
                     forControlEvents:UIControlEventTouchUpInside];
        
        
        //server selector
        [_mainView.backendControl addTarget:self
                                     action:@selector(selectServer:)
                           forControlEvents:UIControlEventValueChanged];
        
        //catalog selector
        [_mainView.catalogControl addTarget:self
                                     action:@selector(selectCatalog:)
                           forControlEvents:UIControlEventValueChanged];
        
    }
    
    self.view = _mainView;
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    
    [self refresh];
}

- (void)dismiss {
    [self save];
    
    [self dismissViewControllerAnimated:YES completion:nil];
}

- (void)selectServer:(UISegmentedControl*)control {
    
    NSInteger selected = control.selectedSegmentIndex;
    
    NSDictionary *server = nil;
    
    if (selected < _defaultServers.count) {
        server = _defaultServers[selected];
        
        _mainView.backendHostField.text = server[BACKENDHOST];
        _mainView.backendPortField.text = server[BACKENDPORT];
        
        _mainView.backendHostField.enabled = NO;
        _mainView.backendPortField.enabled = NO;
        
        _mainView.backendHostField.alpha = .5;
        _mainView.backendPortField.alpha = .5;
    }
    
    else {
        //custom
        _mainView.backendHostField.enabled = YES;
        _mainView.backendPortField.enabled = YES;
        
        _mainView.backendHostField.alpha = 1;
        _mainView.backendPortField.alpha = 1;
    }
}

- (void)selectCatalog:(UISegmentedControl*)control {
    
    NSInteger selected = control.selectedSegmentIndex;
    
    NSDictionary *catalog = nil;
    
    if (selected < _defaultCatalogs.count) {
        catalog = _defaultCatalogs[selected];
        
        _mainView.storeField.text = catalog[STOREID];
        _mainView.catalogIdField.text = catalog[CATALOGID];
        _mainView.rootIdField.text = catalog[ROOTCATEGORYID];
        
        _mainView.storeField.enabled = NO;
        _mainView.catalogIdField.enabled = NO;
        _mainView.rootIdField.enabled = NO;
        
        _mainView.storeField.alpha = .5;
        _mainView.catalogIdField.alpha = .5;
        _mainView.rootIdField.alpha = .5;
    }
    
    else {
        //custom
        _mainView.storeField.enabled = YES;
        _mainView.catalogIdField.enabled = YES;
        _mainView.rootIdField.enabled = YES;
        
        _mainView.storeField.alpha = 1;
        _mainView.catalogIdField.alpha = 1;
        _mainView.rootIdField.alpha = 1;
    }
    
    [[self.backendService userStorage] removeObjectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
    [[self.backendService userStorage] setObject:@"1" forKey:DID_CHANGE_SERVER];    
    [[self.backendService userStorage] synchronize];
    [self.backendService resetPagination];
    
    if ([self.presentingViewController isKindOfClass:[HYBDrawerController class]]) {
        
        id presenter = (HYBDrawerController*)self.presentingViewController;
        id leftCTrl = [presenter leftDrawerViewController];
        
        [leftCTrl popToRootViewControllerAnimated:NO];
    }
}

- (void)save {
    
    //url
    if([_mainView.backendHostField.text hyb_isNotBlank]) [self.backendService setBackEndHost:_mainView.backendHostField.text];
    if([_mainView.backendPortField.text hyb_isNotBlank]) [self.backendService setBackEndPort:_mainView.backendPortField.text];
    else [self.backendService setBackEndPort:@""];
    
    //catalog
    if([_mainView.storeField.text       hyb_isNotBlank])    [self.backendService setStoreId:_mainView.storeField.text];
    if([_mainView.catalogIdField.text   hyb_isNotBlank])    [self.backendService setCatalogId:_mainView.catalogIdField.text];
    if([_mainView.rootIdField.text      hyb_isNotBlank])    [self.backendService setRootCategoryId:_mainView.rootIdField.text];
    
    [self.backendService saveSettings];

}

- (void)refresh {
    
    //url
    _mainView.backendHostField.text = [self.backendService backEndHost];
    _mainView.backendPortField.text = [self.backendService backEndPort];
    
    BOOL isCustomServer = YES;
    
    NSInteger count = 0;
    for (NSDictionary *server in _defaultServers) {
        if ([server[BACKENDHOST] isEqualToString:[self.backendService backEndHost]]) {
            isCustomServer = NO;
            _mainView.backendControl.selectedSegmentIndex = count;
            break;
        }
        count++;
    }
    
    if (isCustomServer) {
        _mainView.backendControl.selectedSegmentIndex = [_defaultServers count];
    }

    [self selectServer:_mainView.backendControl];

    //catalog
    _mainView.storeField.text       = [self.backendService storeId];
    _mainView.catalogIdField.text   = [self.backendService catalogId];
    _mainView.rootIdField.text      = [self.backendService rootCategoryId];
    
    BOOL isCustomCatalog = YES;

    count = 0;
    for (NSDictionary *catalog in _defaultCatalogs) {
        if ([catalog[STOREID]           isEqualToString:[self.backendService storeId]] &&
            [catalog[CATALOGID]         isEqualToString:[self.backendService catalogId]] &&
            [catalog[ROOTCATEGORYID]    isEqualToString:[self.backendService rootCategoryId]]
            ) {
            isCustomCatalog = NO;
            _mainView.catalogControl.selectedSegmentIndex = count;
            break;
        }
        count++;
    }
    
    if (isCustomCatalog) {
        _mainView.catalogControl.selectedSegmentIndex = [_defaultCatalogs count];
    }
    
    [self selectCatalog:_mainView.catalogControl];

}


- (void)openFeedback {
    NSString *feedbackRecipient = [[MYEnvironmentConfig sharedConfig] feedbackRecipient];
    
    if (feedbackRecipient) {
        
        MFMailComposeViewController* mailer = [MFMailComposeViewController new];
        
        mailer.mailComposeDelegate = self;
        
        mailer.title = NSLocalizedString(@"mail_feedback", nil);
        
        mailer.toRecipients = [NSArray arrayWithObject:feedbackRecipient];
        
        NSString *subject = [NSString stringWithFormat:@"%@ %@",NSLocalizedString(@"feedback_from_app", nil),APP_NAME];
        mailer.subject = subject;
        
        [self presentViewController:mailer animated:YES completion:nil];
    }
}

//MFMailComposeViewControllerDelegate
- (void)mailComposeController:(MFMailComposeViewController *)controller
          didFinishWithResult:(MFMailComposeResult)result
                        error:(NSError *)error {
    
    [controller dismissViewControllerAnimated:YES completion:nil];
    
    
}


@end
