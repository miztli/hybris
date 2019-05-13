//
// HYBMainMenuController.m
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


#import "HYBMainMenuController.h"
#import "HYBB2CService.h"
#import "HYBBaseMenuCellView.h"
#import "stylesheet.h"
#import "UIColor+Expanded.h"

typedef enum {
    NAVIGATE_TO_DASHBOARD,
    NAVIGATE_TO_ORDERS,
    NAVIGATE_TO_CATALOG,
    NAVIGATE_TO_ACCOUNT,
    NAVIGATE_TO_STORES,
    NAVIGATE_TO_LOGOUT
} navigation_tag;

@interface HYBMainMenuController ()

@property (nonatomic) HYBBaseMenuView *mainView;
@property (nonatomic) CGFloat menuHeight;
@property (nonatomic) NSDictionary *footerDict;
@property (nonatomic) BOOL closed;

@end

@implementation HYBMainMenuController

- (id)initWithBackEndService:(HYBB2CService*)backEndService {
    if(self = [super initWithBackEndService:backEndService]) {
        
        self.automaticallyAdjustsScrollViewInsets = YES;
        self.ignoreSearchFrame = YES;
        
        [self setupPayload];
    }
    
    return self;
}

- (void)refreshTable {
    [_mainView.menuTableView reloadData];
}

- (void)setupPayload {
    
    _closed = NO;
    
    _menuOptions = [NSArray arrayWithObjects:
                    
                    [NSDictionary dictionaryWithObjectsAndKeys:
                     NSLocalizedString(@"sidebar_dashboard", nil),MENU_TITLE,
                     @"B2BIcon_dashboard.png",MENU_ICON,
                     @"ACCESS_MAIN_MENU_ITEM_DASHBOARD",MENU_ACCESSID,
                     [NSNumber numberWithInt:NAVIGATE_TO_DASHBOARD],MENU_ACTION_TAG,
                     nil],
                    
                    
                    [NSDictionary dictionaryWithObjectsAndKeys:
                     NSLocalizedString(@"sidebar_orders", nil),MENU_TITLE,
                     @"B2BIcon_orders.png",MENU_ICON,
                     @"ACCESS_MAIN_MENU_ITEM_ORDERS",MENU_ACCESSID,
                     [NSNumber numberWithInt:NAVIGATE_TO_ORDERS],MENU_ACTION_TAG,
                     nil],
                    
                    [NSDictionary dictionaryWithObjectsAndKeys:
                     NSLocalizedString(@"sidebar_catalog", nil),MENU_TITLE,
                     @"B2BIcon_catalog.png",MENU_ICON,
                     @"ACCESS_MAIN_MENU_ITEM_CATALOG",MENU_ACCESSID,
                     [NSNumber numberWithInt:NAVIGATE_TO_CATALOG],MENU_ACTION_TAG,
                     nil],
                    
                    [NSDictionary dictionaryWithObjectsAndKeys:
                     NSLocalizedString(@"sidebar_account", nil),MENU_TITLE,
                     @"B2BIcon_account.png",MENU_ICON,
                     @"ACCESS_MAIN_MENU_ITEM_ACCOUNT",MENU_ACCESSID,
                     [NSNumber numberWithInt:NAVIGATE_TO_ACCOUNT],MENU_ACTION_TAG,
                     nil],
                    
                    [NSDictionary dictionaryWithObjectsAndKeys:
                     NSLocalizedString(@"sidebar_stores", nil),MENU_TITLE,
                     @"B2BIcon_stores.png",MENU_ICON,
                     @"ACCESS_MAIN_MENU_ITEM_STORES",MENU_ACCESSID,
                     [NSNumber numberWithInt:NAVIGATE_TO_STORES],MENU_ACTION_TAG,
                     nil],
                    
                    nil];
    
    
    [self refreshFooterView];
    
    
    _menuHeight = 80;
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    [self topToolbar].searchDelegate = self;
    
    //table view
    if (!_mainView) {
        _mainView = [[HYBBaseMenuView alloc] initWithFrame:self.view.frame];
        _mainView.accessibilityIdentifier = @"ACCESS_MAIN_MENU";
    }
    
    _mainView.menuTableView.delegate    = self;
    _mainView.menuTableView.dataSource  = self;
    
    [_mainView.menuTableView registerClass:[HYBBaseMenuCellView class] forCellReuseIdentifier:MENU_CELL_ID];
    
    //assign
    self.view = _mainView;
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    //footer
    [self refreshFooterView];
}

- (void)refreshFooterView {
    
    NSString *baseString = @"sidebar_login";
    
    if([self.backendService isUserLoggedIn]) baseString = @"sidebar_logout";
    
    NSString *footerString = [NSLocalizedString(baseString, nil) uppercaseString];
    
    _footerDict = [NSDictionary dictionaryWithObjectsAndKeys:
                   footerString,MENU_TITLE,
                   @"B2BIcon_logout.png",MENU_ICON,
                   @"ACCESS_MAIN_MENU_ITEM_LOGOUT",MENU_ACCESSID,
                   [NSNumber numberWithInt:NAVIGATE_TO_LOGOUT],MENU_ACTION_TAG,
                   nil];
    
    _mainView.footerView = [self footerViewWithParams:_footerDict
                                              inFrame:CGRectMake(0, 0, self.maxWidthLeftDrawer, _menuHeight)];
    [_mainView setNeedsLayout];
}

#pragma mark Table Delegate Implementation

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_menuOptions count];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return _menuHeight;
}

- (id)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBBaseMenuCellView *cell = [tableView dequeueReusableCellWithIdentifier:MENU_CELL_ID];
    
    cell.imageView.image = nil;
    cell.accessoryView = nil;
    
    [cell setupWithParams:_menuOptions[indexPath.row]];
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSDictionary *menu = _menuOptions[indexPath.row];
    [self performActionForTag:[menu[MENU_ACTION_TAG] intValue]];
}

- (void)performActionForTag:(int)tag {
    
    switch (tag) {
        case NAVIGATE_TO_DASHBOARD:
        {
            _closed = YES;
            [self openDashboard];
        }
            break;
            
        case NAVIGATE_TO_ORDERS:
        {
            
            _closed = YES;
            [self openOrders];
        }
            break;
            
        case NAVIGATE_TO_CATALOG:
        {
            _closed = NO;
            
            [[NSUserDefaults standardUserDefaults] removeObjectForKey:STORAGE_CURRENTLY_SHOWN_CATEGORY_KEY];
            [[NSUserDefaults standardUserDefaults] synchronize];
            [self openCatalog];
        }
            break;
            
        case NAVIGATE_TO_ACCOUNT:
        {
            [self openAccount];
        }
            break;
            
        case NAVIGATE_TO_STORES:
        {
            _closed = NO;
            [self checkOpenStoreLocator];
        }
            break;
            
        case NAVIGATE_TO_LOGOUT:
        {
            if([self.backendService isUserLoggedIn]) {
                [self doLogout];
                [self refreshFooterView];
            } else {
                _closed = YES;
                [self openLogin];
            }
            
        }
            break;
            
        default:
            break;
    }
}

- (BOOL)isClosedMenu {
    return _closed;
}

//cell styling
- (UIView*)footerViewWithParams:(NSDictionary*)params inFrame:(CGRect)frame {
    
    UIView *container = [[UIView alloc] initWithFrame:frame];
    UIImageView *menuIconView = nil;
    UILabel *menuLabel  = nil;
    
    container.accessibilityIdentifier = params[MENU_ACCESSID];
    
    CGFloat totalWidth = 0.f;
    
    //icon
    NSString *imageName = params[MENU_ICON];
    if (imageName) {
        menuIconView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:imageName]];
        menuIconView.contentMode = UIViewContentModeScaleAspectFit;
        [container addSubview:menuIconView];
    }
    
    //text
    NSString *text = params[MENU_TITLE];
    if (text) {
        menuLabel = [UILabel new];
        menuLabel.text = text;
        menuLabel.textColor = menu_text_default;
        menuLabel.font = font_medium_bold;
        [container addSubview:menuLabel];
    }
    
    CGFloat baseHeight = [container fH];
    CGFloat margeIdx = .2;
    CGFloat marge = baseHeight*margeIdx;
    
    //sizing
    
    //icon
    if (menuIconView) {
        CGSize size     = menuIconView.image.size;
        CGFloat ratio   = size.height/size.width;
        CGFloat imgH    = baseHeight-2*marge;
        CGFloat imgW    = imgH*ratio;
        
        menuIconView.frame = CGRectMake(marge,marge, imgH ,imgW);
        
        totalWidth = [menuIconView bW];
    }
    
    //text
    if(menuLabel) {
        [menuLabel sizeToFit];
        CGFloat labelOffset = 0;
        if (menuIconView) labelOffset = [menuIconView right];
        
        menuLabel.center = CGPointMake([menuLabel bW]/2 + marge + labelOffset, baseHeight/2);
        
        totalWidth = totalWidth + marge + [menuLabel bW];
    }
    
    //interaction
    if(params[MENU_ACTION_TAG]) {
        container.userInteractionEnabled = YES;
        UITapGestureRecognizer *tapMenu = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                  action:@selector(performActionForSender:)];
        [container addGestureRecognizer:tapMenu];
        container.tag = [params[MENU_ACTION_TAG] intValue];
    }
    
    //centering
    CGFloat nudge = (container.bounds.size.width - totalWidth)/2;
    
    if (menuIconView)   menuIconView.center = CGPointMake(menuIconView.center.x-nudge,menuIconView.center.y);
    if (menuLabel)      menuLabel.center    = CGPointMake(menuLabel.center.x-nudge,menuLabel.center.y);
    
    return container;
}

- (void)performActionForSender:(UITapGestureRecognizer*)sender {
    int tag = (int)sender.view.tag;
    [self performActionForTag:tag];
}

@end
