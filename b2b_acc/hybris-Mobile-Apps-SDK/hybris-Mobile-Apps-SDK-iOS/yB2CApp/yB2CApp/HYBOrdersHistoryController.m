//
// HYBOrdersHistoryController.m
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


#import "HYBOrdersHistoryController.h"
#import "HYBOrdersHistoryView.h"
#import "HYBOrdersHistoryCell.h"
#import "HYBOrder.h"
#import "HYBOrdersDetailsController.h"

#define  HYBOrdersHistoryCellID @"HYBOrdersHistoryCellID"

@interface HYBOrdersHistoryController ()

@property (nonatomic) HYBOrdersHistoryView *mainView;

@property (nonatomic) NSArray *orders;
@property (nonatomic) BOOL loading;
@property (nonatomic) BOOL allOrdersLoaded;
@property (nonatomic) BOOL cancelDetailsPage;

@property (nonatomic) BOOL didShowLogin;

@end

@implementation HYBOrdersHistoryController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        self.view.backgroundColor = [UIColor whiteColor];
        _orders = [NSArray array];
        _didShowLogin = NO;
    }
    return self;
}

- (void)scrollViewDidScroll:(UIScrollView *)scrollView {
    
    // UITableView only moves in one direction, y axis
    CGFloat currentOffset = scrollView.contentOffset.y;
    CGFloat maximumOffset = scrollView.contentSize.height - scrollView.frame.size.height;
    
    // Change 10.0 to adjust the distance from bottom
    if (maximumOffset - currentOffset <= 10.0) {
        if (!_allOrdersLoaded) [self loadOrders];
    }
}

- (void)loadOrders {
    if (!_loading) {
        [HYBActivityIndicator show];
        
        _loading = YES;
        [self refresh];
        
        //small delay to allow ui to display loading indicator
        
        [self performSelector:@selector(doLoad) withObject:nil afterDelay:.2];
    }
}

- (void)doLoad {
    NSDictionary *sortDict = [NSDictionary dictionaryWithObjectsAndKeys:
                              @"byDate",@"sort",
                              nil];
    
    [self.backendService retrieveOrdersForUser:self.backendService.userId
                                    withParams:sortDict
                                    andExecute:^(NSArray *orders, NSError *error) {
                                        [HYBActivityIndicator hide];
                                        [self processNewOrders:orders];
                                    }];
}

- (void)processNewOrders:(NSArray *)newOrders {
    
    _loading = NO;
    BOOL forceReload = NO;
    
    if (!newOrders || [newOrders count] == 0) {
        _allOrdersLoaded = YES;
        
        if ([self.backendService currentPage] == 0 && [_orders count] == 0) {
            DDLogDebug(@"empty category");
            NSString *msg = NSLocalizedString(@"orders_history_no_orders_found", nil);
            [self showNotifyMessage:msg];
            
            forceReload = YES;
        }
    } else {
        if ([newOrders count] < [self.backendService pageSize]) {
            _allOrdersLoaded = YES;
        }
        
        if ([newOrders count] > 0 && [_orders count] == 0) {
            DDLogDebug(@"new Orders added");
            forceReload = YES;
        }
    }
    
    if (forceReload) {
        _orders = [NSArray arrayWithArray:newOrders];
        [self.backendService nextPage];
    } else {
        
        //debounce products (prevent adding same product coming from cache and server)
        
        //1- keep only products to add in an array
        NSMutableArray *tempArray = [NSMutableArray arrayWithArray:_orders];
        
        BOOL add = YES;
        
        for (HYBOrderHistory *newOrder in newOrders) {
            add = YES;
            for (HYBOrderHistory *oldOrder in _orders) {
                if ([newOrder.code isEqualToString:oldOrder.code]) {
                    add = NO;
                    break;
                }
            }
            
            if (add) {
                [tempArray addObject:newOrder];
            }
        }
        
        //if we have any new result to add
        if ([tempArray count] > 0) {
            _orders = [NSArray arrayWithArray:tempArray];
            
            [self.backendService nextPage];
        }
    }
    
    [self refresh];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) {
        _mainView = [[HYBOrdersHistoryView alloc] initWithFrame:self.view.frame];
    }
    
    self.view = _mainView;
    
    _allOrdersLoaded = NO;
    [self.backendService resetPagination];
    
    //table view
    _mainView.ordersTable.delegate = self;
    _mainView.ordersTable.dataSource = self;
    [_mainView.ordersTable registerClass:[HYBOrdersHistoryCell class] forCellReuseIdentifier:HYBOrdersHistoryCellID];
    
    _mainView.ordersTable.separatorStyle = UITableViewCellSeparatorStyleNone;
    
    
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    
    if([self.backendService isUserLoggedIn]) {
        _didShowLogin = NO;
        [self topToolbar].searchDelegate = self;
        _cancelDetailsPage = YES;
        [self loadOrders];
    }
    else {
        if (_didShowLogin) {
            [self openDashboard];
        } else {
            [self openLogin];
            _didShowLogin = YES;
        }
    }
    
}

- (void)refresh {
    [_mainView.ordersTable reloadData];
}

- (NSString*)formattedDate:(NSString*)date {
    
    //change display format
    //from  yyyy-MM-dd'T'HH:mm:ss-zzzz
    //ou    yyyy-MM-dd'T'HH:mm:ss+zzzz
    
    //to    MM-dd-yyyy HH:mm
    
    NSString *dateFormat = @"yyyy-MM-dd'T'HH:mm:ss-zzzz";
    
    if ([date rangeOfString:@"+"].location != NSNotFound) {
        dateFormat = @"yyyy-MM-dd'T'HH:mm:ss+zzzz";
    }
    
    NSDateFormatter *inDateFormatter = [NSDateFormatter new];
    [inDateFormatter setDateFormat:dateFormat]; //iso 8601 format
    NSDate *output = [inDateFormatter dateFromString:date];
    
    NSDateFormatter *outDateFormatter = [NSDateFormatter new];
    [outDateFormatter setDateFormat:@"MM-dd-yyyy HH:mm"];
    
    return [outDateFormatter stringFromDate:output];
}

#pragma mark tableView delegate

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_orders count];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 100.f;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBOrdersHistoryCell *cell = [tableView dequeueReusableCellWithIdentifier:HYBOrdersHistoryCellID forIndexPath:indexPath];
    
    HYBOrderHistory *order = _orders[indexPath.row];
    
    [cell setEven:(indexPath.row % 2)];
    
    cell.orderIdLabel.text  = order.code;
    cell.dateLabel.text     = [self formattedDate:[order placed]];
    cell.statusLabel.text   = order.statusDisplay;
    cell.totalLabel.text    = order.total.formattedValue;
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    [tableView deselectRowAtIndexPath:indexPath animated:YES];
    
    HYBOrder *selectedOrder = _orders[indexPath.row];
    
    //get full order open it in detail page
    
    _cancelDetailsPage = NO;
    
    [HYBActivityIndicator show];
    
    [self.backendService findOrderByCode:selectedOrder.code andExecute:^(HYBOrder *order, NSError *error) {
        
        [HYBActivityIndicator hide];
        
        if(error) {
            DDLogError(@"Can't find order. Backend error is %@", error.localizedDescription);
        } else {
            if (!_cancelDetailsPage) [self openOrderAndDebounce:order];
        }
    }];
}

- (void)openOrderAndDebounce:(HYBOrder *)order {
    
    //open new controller
    HYBOrdersDetailsController *ordersDetailsController = [[HYBOrdersDetailsController alloc] initWithBackEndService:self.backendService andOrder:order];
    
    //debounce info comming from cache
    //push only one detailcontroller
    [self pushOrSwapTopCenterViewControllerTo:ordersDetailsController animated:YES];
    
}


#pragma mark search + searchbar delegate

- (void)performSearchForString:(NSString *)searchString {
    DDLogDebug(@"search %@ in Store Locator controller",searchString);
    
    if (searchString && searchString.length > 0) {
        if(self) {
            self.currentSearchQuery = [searchString copy];
        }
        
        [self doPerformSearch];
    }
}


- (void)doPerformSearch {
    DDLogDebug(@"Searching for order numbers %@ ...", self.currentSearchQuery);
    
    [HYBActivityIndicator show];
    
    [self.backendService findOrderByCode:self.currentSearchQuery andExecute:^(HYBOrder *order, NSError *error) {
        
        [HYBActivityIndicator hide];
        
        if (error) {
            DDLogError(@"Problems during the retrieval of the order from the web service: %@", [error localizedDescription]);
            
            DDLogError(@"no order found");
            [self alertNotFound];
            
        } else {
            
            if (order) {
                [self openOrderAndDebounce:order];
            } else {
                DDLogError(@"no order found");
                [self alertNotFound];
                
            }
        }
    }];
}

- (void)alertNotFound {
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:NSLocalizedString(@"order_not_found_title", @"")
                                                    message:NSLocalizedString(@"order_not_found_message", @"")
                                                   delegate:self
                                          cancelButtonTitle:NSLocalizedString(@"Ok", @"Ok")
                                          otherButtonTitles:nil];
    [alert show];
    
}

@end
