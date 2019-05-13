//
//  HYBBackendService+OCCURL.h
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

#import <Foundation/Foundation.h>
#import "HYBBackendService.h"

@interface HYBBackendService (OCCURL)

#pragma mark authentication


- (NSString*)tokenURL;

#pragma mark cardtypes

- (NSString*)cardtypesURL; //GET

#pragma mark catalogs

- (NSString*)catalogsURL; //GET
- (NSString*)catalogIdURL; //GET
- (NSString*)catalogVersionIdURL; //GET
- (NSString*)catalogCategoriesURLForCategoryId:(NSString*)categoryId; //GET

#pragma mark currencies

- (NSString*)currenciesURL; //GET

#pragma mark customergroups

- (NSString*)customergroupsURL ; //GET - POST
- (NSString*)customergroupIdURL; //GET
- (NSString*)customergroupMembersURL; //PUT - PATCH
- (NSString*)customergroupUserIdURL; //DELETE

#pragma mark deliverycountries

- (NSString*)deliverycountriesURL; //GET

#pragma mark export

- (NSString*)exportURL ; //GET

#pragma mark feeds

- (NSString*)feedsURL; //GET

#pragma mark forgottenpasswordtokens

- (NSString*)forgottenpasswordtokens; //POST

#pragma mark languages

- (NSString*)languagesURL; //GET

#pragma mark orders

- (NSString*)ordersURL; //GET
- (NSString*)orderURLForCode:(NSString*)code; //GET

#pragma mark products

- (NSString*)productsExpressupdateURL; //GET
- (NSString*)productsSearchURL; //HEAD - GET
- (NSString*)productsSuggestionsURL; //GET
- (NSString*)productURLForCode:(NSString*)code; //GET
- (NSString*)productReferencesURLForCode:(NSString*)code; //GET
- (NSString*)productReviewsURLForCode:(NSString*)code; //GET - POST
- (NSString*)productStockURLForCode:(NSString*)code; //HEAD - GET
- (NSString*)productStockURLForCode:(NSString*)code forStorename:(NSString*)storename; //GET

#pragma mark promotions

- (NSString*)promotionsURL; //GET
- (NSString*)promotionURLForCode:(NSString*)code; //GET

#pragma mark stores

- (NSString*)storesURL; //HEAD - GET
- (NSString*)storeURLForStoreId:(NSString*)storeId; //GET

#pragma mark titles

- (NSString*)titlesURL; //GET

#pragma mark users

- (NSString*)usersURL; //POST
- (NSString*)userProfileURLForUserId:(NSString*)userId; //GET - PUT - PATCH - DELETE

//addresses

- (NSString*)userAddressesURLForUserId:(NSString*)userId; //GET - POST
- (NSString*)userAddressVerificationURLForUserId:(NSString*)userId; //POST
- (NSString*)userAddressURLForUserId:(NSString*)userId andAddressId:(NSString*)addressId; //GET - PUT - PATCH - DELETE

//carts

- (NSString*)userCartsURLForUserId:(NSString*)userId; //GET - POST
- (NSString*)userCartsURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET - DELETE
- (NSString*)userCartDeliveryAddressURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //POST - PUT - DELETE
- (NSString*)userCloneSavedCartURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //POST
- (NSString*)userCartDeliverymodeURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET - PUT - DELETE
- (NSString*)userCartDeliverymodesURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET
- (NSString*)userCartEmailURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //PUT
- (NSString*)userCartEntriesURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET - POST
- (NSString*)userCartEntryURLForUserId:(NSString*)userId andCartId:(NSString*)cartId andEntryNumber:(NSString*)entryNumber; //GET - PUT - PATCH - DELETE
- (NSString*)userCartFlagForDeletionURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //PATCH
- (NSString*)userCartPaymentdetailsURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //POST - PUT
- (NSString*)userCartPromotionsURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET - POST
- (NSString*)userCartPromotionURLForUserId:(NSString*)userId andCartId:(NSString*)cartId andPromotionId:(NSString*)promotionId; //GET - DELETE
- (NSString*)userCartRestoresavedcartURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //PATCH
- (NSString*)userCartSaveURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //PATCH
- (NSString*)userCartSavedcartURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET
- (NSString*)userCartVouchersURLForUserId:(NSString*)userId andCartId:(NSString*)cartId; //GET - POST
- (NSString*)userCartVoucherURLForUserId:(NSString*)userId andCartId:(NSString*)cartId andVoucherId:(NSString*)voucherId; //DELETE

//profile

- (NSString*)userCustomergroupsURLForUserId:(NSString*)userId; //GET
- (NSString*)userLoginURLForUserId:(NSString*)userId; //PUT
- (NSString*)userOrdersURLForUserId:(NSString*)userId; //HEAD - GET - POST
- (NSString*)userOrderURLForUserId:(NSString*)userId andOrderCode:(NSString*)code; //GET
- (NSString*)userPasswordURLForUserId:(NSString*)userId; //PUT
- (NSString*)userPaymentdetailsListURLForUserId:(NSString*)userId; //GET
- (NSString*)userPaymentdetailsURLForUserId:(NSString*)userId andPaymentdetailsId:(NSString*)paymentdetailsId; //GET - PUT - PATCH - DELETE

//vouchers

- (NSString*)vouchersURLForVoucherCode:(NSString*)code; //GET

@end
