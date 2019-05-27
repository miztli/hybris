//
//  HYBBackendService+OCCURL.m
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

#import "HYBBackendService+OCCURL.h"
#import "HYBConstants.h"
#import "NSString+HYStringUtils.h"
#import "NSObject+HYBAdditionalMethods.h"


@implementation HYBBackendService (OCCURL)

#pragma mark authentication

- (NSString*)tokenURL {
      return [self.baseURLNoRest stringByAppendingString:@"/authorizationserver/oauth/token"];
    
   // return [self.baseURL stringByAppendingString:@"/oauth/token"];
}

#pragma mark cardtypes

- (NSString*)cardtypesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/cardtypes")];
}

#pragma mark catalogs

- (NSString*)catalogsURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/catalogs")];
}

- (NSString*)catalogIdURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/catalogs/%@",self.catalogId)];
}

- (NSString*)catalogVersionIdURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/catalogs/%@/%@",self.catalogId,self.catalogVersionId)];
}

- (NSString*)catalogCategoriesURLForCategoryId:(NSString*)categoryId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/catalogs/%@/%@/categories/%@",self.catalogId,self.catalogVersionId,categoryId)];
}

#pragma mark currencies

- (NSString*)currenciesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/currencies")];
}

#pragma mark customergroups

- (NSString*)customergroupsURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/customergroups")];
}

- (NSString*)customergroupIdURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/customergroups/%@",self.groupId)];
}

- (NSString*)customergroupMembersURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/customergroups/%@/members",self.groupId)];
}

- (NSString*)customergroupUserIdURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/customergroups/%@/members/%@",self.groupId,self.userId)];
}

#pragma mark deliverycountries

- (NSString*)deliverycountriesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/deliverycountries")];
}

#pragma mark export

- (NSString*)exportURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/export/products")];
}

#pragma mark feeds

- (NSString*)feedsURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/feeds/orders/statusfeed")];
}

#pragma mark forgottenpasswordtokens

- (NSString*)forgottenpasswordtokens {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/forgottenpasswordtokens")];
}

#pragma mark languages

- (NSString*)languagesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/languages")];
}

#pragma mark orders

- (NSString*)ordersURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/orders")];
}

- (NSString*)orderURLForCode:(NSString*)code {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/orders/%@", code)];
}

#pragma mark products

- (NSString*)productsExpressupdateURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/expressupdate")];
}

- (NSString*)productsSearchURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/search")];
}

- (NSString*)productsSuggestionsURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/suggestions")];
}

- (NSString*)productURLForCode:(NSString*)code  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/%@",code)];
}

 - (NSString*)productReferencesURLForCode:(NSString*)code  {
 return [self.restPrefix stringByAppendingString:FORMAT(@"/products/%@/references", code)];
 }

- (NSString*)productReviewsURLForCode:(NSString*)code  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/%@/reviews", code)];
}

- (NSString*)productStockURLForCode:(NSString*)code  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/%@/stock", code)];
}

- (NSString*)productStockURLForCode:(NSString*)code forStorename:(NSString*)storename {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/products/%@/stock/%@", code, [storename URLEncode])];
}

#pragma mark promotions

- (NSString*)promotionsURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/promotions")];
}

- (NSString*)promotionURLForCode:(NSString*)code  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/promotions/%@", code)];
}

#pragma mark stores

- (NSString*)storesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/stores")];
}

- (NSString*)storeURLForStoreId:(NSString*)storeId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/stores/%@", [storeId URLEncode])];
}

#pragma mark titles

- (NSString*)titlesURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/titles")];
}

#pragma mark users

- (NSString*)usersURL {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users")];
}

- (NSString*)userProfileURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@", userId)];
}

//addresses

- (NSString*)userAddressesURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/addresses", userId)];
}

- (NSString*)userAddressVerificationURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/addresses/verification", userId)];
}

- (NSString*)userAddressURLForUserId:(NSString*)userId andAddressId:(NSString*)addressId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/addresses/%@", userId, addressId)];
}

//carts

- (NSString*)userCartsURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts", userId)];
}

- (NSString*)userCartsURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@", userId, cartId)];
}

- (NSString*)userCartDeliveryAddressURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/addresses/delivery", userId, cartId)];
}

- (NSString*)userCloneSavedCartURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/clonesavedcart", userId, cartId)];
}

- (NSString*)userCartDeliverymodeURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/deliverymode", userId, cartId)];
}

- (NSString*)userCartDeliverymodesURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/deliverymodes", userId, cartId)];
}

- (NSString*)userCartEmailURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/email", userId, cartId)];
}

- (NSString*)userCartEntriesURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/entries", userId, cartId)];
}

- (NSString*)userCartEntryURLForUserId:(NSString*)userId andCartId:(NSString*)cartId andEntryNumber:(NSString*)entryNumber {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/entries/%@", userId, cartId, entryNumber)];
}

- (NSString*)userCartFlagForDeletionURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/flagForDeletion", userId, cartId)];
}

- (NSString*)userCartPaymentdetailsURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/paymentdetails", userId, cartId)];
}

- (NSString*)userCartPromotionsURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/promotions", userId, cartId)];
}

- (NSString*)userCartPromotionURLForUserId:(NSString*)userId andCartId:(NSString*)cartId andPromotionId:(NSString*)promotionId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/promotions/%@", userId, cartId, promotionId)];
}

- (NSString*)userCartRestoresavedcartURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/restoresavedcart", userId, cartId)];
}

- (NSString*)userCartSaveURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/save", userId, cartId)];
}

- (NSString*)userCartSavedcartURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/savedcart", userId, cartId)];
}

- (NSString*)userCartVouchersURLForUserId:(NSString*)userId andCartId:(NSString*)cartId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/vouchers", userId, cartId)];
}

- (NSString*)userCartVoucherURLForUserId:(NSString*)userId andCartId:(NSString*)cartId andVoucherId:(NSString*)voucherId {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/carts/%@/vouchers/%@", userId, cartId, voucherId)];
}

//profile

- (NSString*)userCustomergroupsURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/customergroups", userId)];
}

- (NSString*)userLoginURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/login", userId)];
}

- (NSString*)userOrdersURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/orders", userId)];
}

- (NSString*)userOrderURLForUserId:(NSString*)userId andOrderCode:(NSString*)code {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/orders/%@", userId, code)];
}

- (NSString*)userPasswordURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/password", userId)];
}

- (NSString*)userPaymentdetailsListURLForUserId:(NSString*)userId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/paymentdetails", userId)];
}

- (NSString*)userPaymentdetailsURLForUserId:(NSString*)userId andPaymentdetailsId:(NSString*)paymentdetailsId  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/users/%@/paymentdetails/%@", userId, paymentdetailsId)];
}

//vouchers

- (NSString*)vouchersURLForVoucherCode:(NSString*)code  {
    return [self.restPrefix stringByAppendingString:FORMAT(@"/vouchers/%@", code)];
}

@end
