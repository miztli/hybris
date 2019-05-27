//
//  HYBAddressesListViewController.m
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

#import "HYBAddressesListViewController.h"
#import "HYBAddressFormViewController.h"
#import "HYBAddressesListView.h"
#import "HYBAddressCellView.h"
#import "HYBCreditCardFormViewController.h"

#define ADDRESS_CELL_ID @"ADDRESS_CELL_ID"

@interface HYBAddressesListViewController ()

@property (nonatomic) HYBAddressesListView *mainView;
@property (nonatomic) NSInteger currentlyEditedPosition;

@end

@implementation HYBAddressesListViewController

- (instancetype)initWithBackEndService:(HYBB2CService*)backendService {
    
    if (self = [super initWithBackEndService:backendService]) {
        self.view.backgroundColor = [UIColor whiteColor];
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    if (!_mainView) {
        _mainView = [HYBAddressesListView new];
        
        [_mainView.tableView setDelegate:self];
        [_mainView.tableView setDataSource:self];
        
        [_mainView.tableView registerClass:[HYBAddressCellView class] forCellReuseIdentifier:ADDRESS_CELL_ID];
        
        _mainView.tableView.allowsSelection = NO;
        
        
    }
    
    self.view = _mainView;
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    
    //actions
    SEL addSelector = nil;
    
    if ([_selectionType isEqualToString:ADDRESS_SELECTION]) {
        addSelector = @selector(addAddress);
    }
    
    else if ([_selectionType isEqualToString:PAYMENT_SELECTION]) {
        addSelector = @selector(addPaymentDetails);
    }
    
    if (addSelector) {
        //Add interaction
        _mainView.addButton.userInteractionEnabled = YES;
        UITapGestureRecognizer *addTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:addSelector];
        [_mainView.addButton addGestureRecognizer:addTap];
    }
    
    _mainView.closeButton.userInteractionEnabled = YES;
    UITapGestureRecognizer *closeTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(back)];
    [_mainView.closeButton addGestureRecognizer:closeTap];
    
    //promises
    PMKPromise *promise = nil;
    
    if ([_selectionType isEqualToString:ADDRESS_SELECTION]) {
        
        promise = [self loadAddresses];
        
    }
    
    else if ([_selectionType isEqualToString:PAYMENT_SELECTION]) {
        
        promise = [self loadUserPaymentDetails];
        
    }
    
    if(promise) {
        promise.then(^(id responseObject){
            _array = (NSArray*)responseObject;
            
            return [self loadUser];
        })
        
        .then(^(id responseObject){
            HYBUser *user = (HYBUser*)responseObject;
            
            if ([_selectionType isEqualToString:ADDRESS_SELECTION]) {
                _defaultItem = user.defaultAddress;
            }
            
            [self refresh];
        })
        
        .catch(^(NSError *error) {
            DDLogDebug(@"Couldn't load addresses");
            DDLogDebug(@"%@", error.localizedDescription);
        });
    }
    
}

- (void)refresh {
    
    [_mainView.tableView reloadData];
    
}

#pragma mark - tableView delegate

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_array count];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 120.f;
}

- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    return YES;
}

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        _currentlyEditedPosition = indexPath.row;
        [self deleteCurrentlyEditedItem];
    }
}

- (UITableViewCell*)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    HYBAddressCellView *cell = [tableView dequeueReusableCellWithIdentifier:ADDRESS_CELL_ID];
    
    BOOL isSelected = NO;
    
    NSString *nameLabelText = @"";
    NSString *firstLineLabelText = @"";
    NSString *secondLineLabellText = @"";
    
    SEL editSelector = nil;
    SEL selectSelector = nil;
    
    if ([_selectionType isEqualToString:ADDRESS_SELECTION]) {
        
        HYBAddress *address = _array[indexPath.row];
        
        nameLabelText = [NSString stringWithFormat:@"%@ %@",address.firstName, address.lastName];
        firstLineLabelText = address.line1;
        secondLineLabellText = address.line2;
        
        editSelector    = @selector(editAddress:);
        selectSelector  = @selector(selectAddress:);
        
        isSelected = ([address.id isEqualToString:[(HYBAddress*)_defaultItem id]]);
    }
    
    else if ([_selectionType isEqualToString:PAYMENT_SELECTION]) {
        HYBPaymentDetails *paymentDetails = _array[indexPath.row];
        
        nameLabelText = paymentDetails.accountHolderName;
        firstLineLabelText = [NSString stringWithFormat:@"%@ %@",paymentDetails.cardType.name, paymentDetails.cardNumber];
        
        editSelector    = @selector(editPaymentDetails:);
        selectSelector  = @selector(selectPaymentDetails:);
        
        isSelected = ([paymentDetails.id isEqualToString:[(HYBPaymentDetails*)_defaultItem id]]);
        
        cell.selectView.hidden = YES;
    }
    
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    cell.chevronView.tag = indexPath.row;
    cell.selectView.tag  = indexPath.row;
    
    cell.nameLabel.text         = nameLabelText;
    cell.firstLineLabel.text    = firstLineLabelText;
    cell.secondLineLabel.text   = secondLineLabellText;
    
    if(![cell.chevronView.gestureRecognizers hyb_isNotBlank]) {
        cell.chevronView.userInteractionEnabled = YES;
        UITapGestureRecognizer *editTap = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                  action:editSelector];
        [cell.chevronView addGestureRecognizer:editTap];
    }
    
    if(![cell.selectView.gestureRecognizers hyb_isNotBlank]) {
        cell.selectView.userInteractionEnabled = YES;
        UITapGestureRecognizer *selectTap = [[UITapGestureRecognizer alloc] initWithTarget:self
                                                                                    action:selectSelector];
        [cell.selectView addGestureRecognizer:selectTap];
    }
    
    
    [cell doHilite:isSelected];
    
    return cell;
}

- (void)selectPaymentDetails:(UITapGestureRecognizer*)sender {
    
}

- (void)selectAddress:(UITapGestureRecognizer*)sender {
    NSInteger index = sender.view.tag;
    HYBAddress *address = _array[index];
    _selectedItem = address;
    
    [self doBackendSelect];
}

- (void)editAddress:(UITapGestureRecognizer*)sender {
    NSInteger index = sender.view.tag;
    HYBAddress *address = _array[index];
    [self openFormWithAddress:address asDefault:[self isDefaultAddressAtIndex:index]];
}

- (void)addAddress {
    [self openFormWithAddress:nil asDefault:[self isDefaultAddressAtIndex:-1]];
}

- (void)addPaymentDetails {
    [self openFormWithPaymentDetails:nil];
}

- (void)editPaymentDetails:(UITapGestureRecognizer*)sender {
    NSInteger index = sender.view.tag;
    HYBPaymentDetails *paymentDetails = _array[index];
    [self openFormWithPaymentDetails:paymentDetails];
}

- (BOOL)isDefaultAddressAtIndex:(NSInteger)index {
    
    //used new button to create first ever address -> default address
    if (index < 0 && [_array count] <= 0) return YES;
    
    //edit address on the first line -> default
    if (index == 0) return YES;
    
    //other -> non default
    return NO;
}

- (void)back {
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)openFormWithPaymentDetails:(HYBPaymentDetails*)paymentDetails {
    
    HYBCreditCardFormViewController *creditCardFormViewController = [[HYBCreditCardFormViewController alloc] initWithBackEndService:self.backendService];
    
    if (paymentDetails) creditCardFormViewController.currentPaymentDetails = paymentDetails;
    
    [self.navigationController pushViewController:creditCardFormViewController animated:YES];
}

- (void)openFormWithAddress:(HYBAddress*)address asDefault:(BOOL)isDefaultAddress {
    
    HYBAddressFormViewController *addressFormViewController = [[HYBAddressFormViewController alloc] initWithBackEndService:self.backendService];
    
    if (address) addressFormViewController.currentAddress = address;
    addressFormViewController.isDefaultAddress = isDefaultAddress;
    
    [self.navigationController pushViewController:addressFormViewController animated:YES];
}

- (void)doBackendSelect {
    
    NSMutableDictionary *tmpDict = [NSMutableDictionary dictionary];
    
    //the way of the bourin (so depressing)
    
    [tmpDict setValue:@"true"   forKey:@"defaultAddress"];
    
    HYBAddress *_selectedAddress = (HYBAddress*)_selectedItem;
    
    if (_selectedAddress.firstName)         [tmpDict setValue:_selectedAddress.firstName        forKey:@"firstName"];
    if (_selectedAddress.lastName)          [tmpDict setValue:_selectedAddress.lastName         forKey:@"lastName"];
    if (_selectedAddress.country.isocode)   [tmpDict setValue:_selectedAddress.country.isocode  forKey:@"country.isocode"];
    if (_selectedAddress.town)              [tmpDict setValue:_selectedAddress.town             forKey:@"town"];
    if (_selectedAddress.postalCode)        [tmpDict setValue:_selectedAddress.postalCode       forKey:@"postalCode"];
    if (_selectedAddress.line1)             [tmpDict setValue:_selectedAddress.line1            forKey:@"line1"];
    if (_selectedAddress.line2)             [tmpDict setValue:_selectedAddress.line2            forKey:@"line2"];
    if (_selectedAddress.titleCode)         [tmpDict setValue:_selectedAddress.titleCode        forKey:@"titleCode"];
    if (_selectedAddress.region.isocode)    [tmpDict setValue:_selectedAddress.region.isocode   forKey:@"region.isocode"];
    
    [self updateCurrentAddress:[NSDictionary dictionaryWithDictionary:tmpDict]]
    
    .then(^(){
        return [self loadAddresses];
    })
    
    .then(^(id responseObject){
        _array = (NSArray*)responseObject;
        
        return [self loadUser];
    })
    
    .then(^(id responseObject){
        HYBUser *user = (HYBUser*)responseObject;
        _defaultItem = user.defaultAddress;
        
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't update address");
        DDLogDebug(@"%@", error.localizedDescription);
    });
}

- (PMKPromise *)updateCurrentAddress:(NSDictionary*)params {
    
    NSLog(@"PMKPromise updateCurrentAddress");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        
        [self.backendService replaceUserAddressForUserId:self.backendService.userId
                                            andAddressId:[(HYBAddress*)_selectedItem id]
                                              withParams:params
                                              andExecute:^(id responseObject, NSError *error ) {
                                                  if (error) {
                                                      reject(error);
                                                  } else {
                                                      fulfill(responseObject);
                                                  }
                                              }];
        
    }];
}

- (PMKPromise *)deleteAddressId:(NSString*)addressId  {
    
    NSLog(@"PMKPromise deleteAddressId");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService deleteUserAddressForUserId:self.backendService.userId
                                           andAddressId:addressId
                                             andExecute:^(id responseObject, NSError* error) {
                                                 if (error) {
                                                     reject(error);
                                                 } else {
                                                     fulfill(responseObject);
                                                 }
                                             }];
    }];
}

- (PMKPromise *)deletePaymentdetailsId:(NSString*)paymentDetailsId {
    
    NSLog(@"PMKPromise deletePaymentdetails");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backendService deleteUserPaymentdetailsForUserId:self.backendService.userId
                                           andPaymentdetailsId:paymentDetailsId
                                                    andExecute:^(id responseObject, NSError* error) {
                                                        if (error) {
                                                            reject(error);
                                                        } else {
                                                            fulfill(responseObject);
                                                        }
                                                    }];
    }];
}

- (PMKPromise *)loadAddresses  {
    
    NSLog(@"PMKPromise loadAddresses");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getUserAddressesForUserId:[self.backEndService currentUserId]
                                            andExecute:^(id responseObject, NSError* error) {
                                                if (error) {
                                                    reject(error);
                                                } else {
                                                    fulfill(responseObject);
                                                }
                                            }];
    }];
}

- (PMKPromise *)loadUserPaymentDetails {
    
    NSLog(@"PMKPromise loadUserPaymentDetails");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getPaymentdetailsListForUserId:[self.backEndService currentUserId]
                                                 withParams:[NSDictionary FULLFields]
                                                 andExecute:^(id responseObject, NSError* error) {
                                                     if (error) {
                                                         reject(error);
                                                     } else {
                                                         fulfill(responseObject);
                                                     }
                                                 }];
    }];
}

- (PMKPromise *)loadUser {
    
    NSLog(@"PMKPromise loadUser");
    
    return [PMKPromise new:^(PMKPromiseFulfiller fulfill, PMKPromiseRejecter reject) {
        
        [self.backEndService getUserProfileForUserId:[self.backEndService currentUserId]
                                          andExecute:^(id responseObject, NSError* error) {
                                              if (error) {
                                                  reject(error);
                                              } else {
                                                  fulfill(responseObject);
                                              }
                                          }];
    }];
}

- (void)deleteCurrentlyEditedItem {
    
    if (_currentlyEditedPosition >= 0) {
        
        NSString *currentId = [_array[_currentlyEditedPosition] id];
        
        
        if ([_selectionType isEqualToString:ADDRESS_SELECTION]) {
            [self doDeleteAddressId:currentId];
        }
        
        else if ([_selectionType isEqualToString:PAYMENT_SELECTION]) {
            [self doDeletePaymentDetailsId:currentId];
            
        }
        
        
    }
}

- (void)doDeletePaymentDetailsId:(NSString*)paymentDetailsId {
    
    NSLog(@"delete paymentDetails id : %@", paymentDetailsId);
    
    [self deletePaymentdetailsId:paymentDetailsId]
    
    .then(^(){
        return [self loadUserPaymentDetails];
    })
    
    .then(^(id responseObject){
        _array = (NSArray*)responseObject;
        
        [self refresh];
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't delete / reload address(es)");
        DDLogDebug(@"%@", error.localizedDescription);
    });
}


- (void)doDeleteAddressId:(NSString*)addressId {
    
    NSLog(@"delete address id : %@", addressId);
    
    [self deleteAddressId:addressId]
    
    .then(^(){
        return [self loadAddresses];
    })
    
    .then(^(id responseObject){
        _array = (NSArray*)responseObject;
        
        return [self loadUser];
    })
    
    .then(^(id responseObject){
        HYBUser *user = (HYBUser*)responseObject;
        _defaultItem = user.defaultAddress;
        
        if ([_array hyb_isNotBlank] && _defaultItem == nil) {
            HYBAddress *address = [_array firstObject];
            _selectedItem = address;
            
            [self doBackendSelect];
            
        } else {
            [self refresh];
        }
    })
    
    .catch(^(NSError *error) {
        DDLogDebug(@"Couldn't delete / reload address(es)");
        DDLogDebug(@"%@", error.localizedDescription);
    });
}

@end
