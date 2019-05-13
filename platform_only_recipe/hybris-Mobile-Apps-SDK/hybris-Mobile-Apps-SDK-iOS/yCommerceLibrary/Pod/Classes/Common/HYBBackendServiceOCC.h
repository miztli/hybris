//
//  HYBBackendServiceOCC.h
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

#import "HYBBackendService.h"
#import "HYBBackendService+OCCURL.h"
#import "NSDictionary+FULLFields.h"

#define BASIC_AUTH @"bW9iaWxlX2FuZHJvaWQ6c2VjcmV0"

#define LAST_AUTHENTICATED_USER_KEY         @"LAST_AUTHENTICATED_USER_KEY"
#define INVALID_TOKEN_KEY                   @"INVALID_TOKEN_KEY"

#define ACCESS_TOKEN_KEY        @"access_token"
#define REFRESH_TOKEN_KEY       @"refresh_token"
#define EXPIRE_VALUE_KEY        @"expires_in"
#define EXPIRATION_TIME_KEY     @"issued_on"

#define SUCCESS_TAG     @"success"
#define GUEST_USER      @"anonymous"
#define CURRENT_USER    @"current"
#define CURRENT_CART    @"current"

@interface HYBBackendServiceOCC : HYBBackendService

#pragma mark init

- (instancetype)initWithParams:(NSDictionary*)params;

- (void)logError:(NSError*)error;

- (NSError *)createDefaultErrorWithMessage:(NSString *)errorMsg
                             failureReason:(NSString *)failureReason;

#pragma mark authentication

- (void)authenticateUsername:(NSString *)username
                  andExecute:(void (^)(id, NSError *))block;

- (void)authenticateUsername:(NSString*)username
                withPassword:(NSString *)password
                  andExecute:(void (^)(id, NSError *))block;

/*
 - (void)authenticateAsTrustedClientUsername:(NSString*)username
                withPassword:(NSString *)password
                  andExecute:(void (^)(id, NSError *))block;
 */

//setTrustedClientRoleForUser
- (void)makeUserTrustedClientAndExecute:(void (^)(id, NSError *))block;

//setTrustedClientRoleForGuest
- (void)makeGuestTrustedClientAndExecute:(void (^)(id, NSError *))block;

- (void)retrieveTokenForUsername:(NSString *)username
                    withPassword:(NSString *)password
                      andExecute:(void (^)(id, NSError *))block;

- (void)refreshTokenWithDetails:(NSDictionary *)tokenDetails
                    forUsername:(NSString *)username
                     andExecute:(void (^)(id, NSError *))block;

- (BOOL)isSessionExpired:(NSDictionary *)session;

- (NSString *)localizedMsgFromCartModification:(HYBCartModification*)cartModification;

#pragma mark cardtypes

/**
 *  Lists supported payment card types.
 *
 *  @param block results callback
 */
- (void)getCardtypesAndExecute:(void (^)(id, NSError *))block;

#pragma mark catalogs

/**
 *  Returns all catalogs with versions defined for the base store.
 *
 *  @param block block description
 */
- (void)getCatalogsAndExecute:(void (^)(id, NSError *))block;

/**
 *  Returns a information about a catalog based on its ID, along with versions defined for the current base store.
 *
 *  @param block results callback
 */
- (void)getCatalogAndExecute:(void (^)(id, NSError *))block;

/**
 *  Returns information about catalog version that exists for the current base store.

 *
 *  @param block results callback
 */
- (void)getCatalogVersionAndExecute:(void (^)(id, NSError *))block;

/**
 *  Returns information about category that exists in a catalog version available for the current base store.

 *
 *  @param categoryId category Id
 *  @param params     Query Parameters optionnal Dict = pageSize:(string), currentPage:(string)
 *  @param block      results callback
 */

- (void)getCatalogCategoryForCategoryId:(NSString*)categoryId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block;

#pragma mark currencies

/**
 *  Lists all available currencies (all usable currencies for the current store).
 *  If the list of currencies for stores is empty, a list of all currencies available in the system is returned.
 *
 *  @param block results callback
 */
- (void)getCurrenciesAndExecute:(void (^)(id, NSError *))block;

#pragma mark customergroups

/**
 *  Returns all customer groups that are direct subgroups of a customergroup.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getCustomergroupsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block;

/**
 *  Creates a new customer group that is a direct subgroup of a customergroup.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)createCustomergroupsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns a customer group with a specific groupId.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getCustomergroupWithParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Sets members for a user group. The list of existing members is overwritten with a new one.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)setCustomergroupMembersWithParams:(NSDictionary*)params
                               andExecute:(void (^)(id, NSError *))block;

/**
 *  Assigns user(s) to a customer group.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateCustomergroupMembersWithParams:(NSDictionary*)params
                                  andExecute:(void (^)(id, NSError *))block;

/**
 *  Removes user from a customer group.
 *
 *  @param block  results callback
 */
- (void)deleteCustomergroupUserAndExecute:(void (^)(id, NSError *))block;

#pragma mark deliverycountries

/**
 *  Lists all supported delivery countries for the current store. The list is sorted alphabetically.
 *
 *  @param block  results callback
 */
- (void)getDeliverycountriesAndExecute:(void (^)(id, NSError *))block;

#pragma mark export

/**
 *  Used for product export. Depending on the timestamp parameter,
 *  it can return all products or only products modified after the given time.
 *
 *  @param params Query Parameters
 *  - timestamp:  (string) When this parameter is set, only products modified after given time will be returned.This parameter should be in RFC-8601 format.
 *  - pageSize: (string)
 *  - currentPage: (string)
 *  - catalog: (string) required
 *  - version: (string) required
 *
 *  @param block  results callback
 */
- (void)getExportProductsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block;

#pragma mark feeds

/**
 *  Returns the orders the status has changed for.
 *  Returns only the elements from the current baseSite, updated after the provided timestamp.

 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getOrdersFeedsWithParams:(NSDictionary*)params
                andExecute:(void (^)(id, NSError *))block;

#pragma mark forgottenpasswordtokens

/**
 *  Generates a token to restore customer's forgotten password.
 *
 *  @param block  results callback
 */
- (void)generateForgottenpasswordtokensAndExecute:(void (^)(id, NSError *))block;

#pragma mark languages

/**
 *  Lists all available languages (all languages used for a particular store).
 *  If the list of languages for a base store is empty, a list of all languages available in the system will be returned.
 *
 *  @param block  results callback
 */
- (void)getLanguagesAndExecute:(void (^)(id, NSError *))block;

#pragma mark products

/**
 *  Returns products added to the express update feed.
 *  Returns only elements updated after the provided timestamp.The queue is cleared using a defined cronjob.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getProductsExpressupdateWithParams:(NSDictionary*)params
                                andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns a list of products and additional data such as: available facets,
 *  available sorting and pagination options.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */

//refactor to use only one call for categoryId on query
- (void)getProductsWithParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns X-Total-Count header with total number of products satisfying a query.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)countProductsWithParams:(NSDictionary*)params
                           andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns a list of all available suggestions related to a given term and limits the results to a specific value of the max parameter.
 *
 *  @param params Query Parameters
 *  - max: required (string)
 *  - term: required (string)
 *  @param block  results callback
 */
- (void)getProductsSuggestionsWithParams:(NSDictionary*)params
                              andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns details of a single product according to a product code.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getProductForCode:(NSString*)code
               andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns references for a product with a given product code. Reference type specifies which references to return.
 *
 *  @param code   product code
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getProductReferencesForCode:(NSString*)code
                         withParams:(NSDictionary*)params
                         andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns the reviews for a product with a given product code.
 *
 *  @param code   product code
 *  @param block  results callback
 */
- (void)getProductReviewsForCode:(NSString*)code
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Creates a new customer review as an anonymous user.
 *
 *  @param code   product code
 *  @param params Query Parameters
 *  - headline: (string) required.
 *  - alias: (string)
 *  - rating: (string) required. Value needs to be between 1 and 5.
 *  - comment: (string) required.
 *  @param block  results callback
 */
- (void)setProductReviewForCode:(NSString*)code
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns product's stock levels sorted by distance from specific location passed by free-text parameter
 *  or longitude and latitude parameters.
 *  The following two sets of parameters are available:
 *  - location (required), currentPage (optional), pageSize (optional) or
 *  - longitude (required), latitude (required), currentPage (optional), pageSize(optional).
 *
 *  @param code   product code
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getProductStockForCode:(NSString*)code
                    withParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns X-Total-Count header with a total number of product's stock levels.
 *  The following two sets of parameters are available:
 *  - location (required) or
 *  - longitude (required), latitude (required).
 *
 *  @param code   product code
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)countProductStockForCode:(NSString*)code
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns product's stock level for a particular store (POS).
 *
 *  @param code   product code
 *  @param storename Store identifier
 *  @param block  results callback
 */
- (void)getProductStockForCode:(NSString*)code
                  forStorename:(NSString*)storename
                    andExecute:(void (^)(id, NSError *))block;

#pragma mark promotions

/**
 *  Returns promotions defined for a current base site.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getPromotionsWithParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns details of a single promotion specified by a promotion code.
 *
 *  @param code  promotion code
 *  @param block  results callback
 */
- (void)getPromotionForCode:(NSString*)code
                 andExecute:(void (^)(id, NSError *))block;

#pragma mark stores

/**
 *  Lists all store locations that are near the location specified in a query or based on latitude and longitude.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getStoresWithParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns X-Total-Count header with the number of all store locations that are near the location specified in a query,
 *  or based on latitude and longitude.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)countStoresWithParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns store location based on its unique name.
 *
 *  @param storeId Store identifier
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getStoreForStoreId:(NSString*)storeId
                withParams:(NSDictionary*)params
                andExecute:(void (^)(id, NSError *))block;

#pragma mark titles

/**
 *  Lists all localized titles.
 *
 *  @param block  results callback
 */
- (void)getTitlesAndExecute:(void (^)(id, NSError *))block;

#pragma mark users

/**
 *  Registers a customer. The following two sets of parameters are available:
 *  - First set is used to register a customer. In this case the required parameters are: login, password, firstName, lastName, titleCode.
 *  - Second set is used to convert a guest to a customer. In this case the required parameters are: guid, password.
 *
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)registerUserWithParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns customer profile.
 *
 *  @param userId user id
 *  @param block  results callback
 */
- (void)getUserProfileForUserId:(NSString*)userId
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates customer profile. Attributes not provided in the request body will be defined again (set to null or default).
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)replaceUserProfileForUserId:(NSString*)userId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates customer profile. Only attributes provided in the request body will be changed.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateUserProfileForUserId:(NSString*)userId
                    withParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block;

/**
 *  Removes customer profile.
 *
 *  @param userId user id
 *  @param block  results callback
 */
- (void)deleteUserProfileForUserId:(NSString*)userId
                        andExecute:(void (^)(id, NSError *))block;

//addresses

/**
 *  Returns customer's addresses.
 *
 *  @param userId user id
 *  @param block  results callback
 */
- (void)getUserAddressesForUserId:(NSString*)userId
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Created a new address.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)createUserAddressForUserId:(NSString*)userId
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Verifies address
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)verifyUserAddressForUserId:(NSString*)userId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns detailed information about address with a given id.
 *
 *  @param userId user id
 *  @param addressId address id
 *  @param block  results callback
 */
- (void)getUserAddressForUserId:(NSString*)userId
               andAddressId:(NSString*)addressId
                 andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates the address. Attributes not provided in the request will be defined again (set to null or default).
 *
 *  @param userId user id
 *  @param addressId address id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)replaceUserAddressForUserId:(NSString*)userId
               andAddressId:(NSString*)addressId
                 withParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates the address. Only attributes provided in the request body will be changed.
 *
 *  @param userId user id
 *  @param addressId address id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateUserAddressForUserId:(NSString*)userId
                  andAddressId:(NSString*)addressId
                    withParams:(NSDictionary*)params
                    andExecute:(void (^)(id, NSError *))block;

/**
 *  Removes customer's address.
 *
 *  @param userId user id
 *  @param addressId address id
 *  @param block  results callback
 */
- (void)deleteUserAddressForUserId:(NSString*)userId
                  andAddressId:(NSString*)addressId
                    andExecute:(void (^)(id, NSError *))block;

//carts

/**
 *  Lists all customer carts. Allowed only for non-anonymous users.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getCartsForUserId:(NSString*)userId
               withParams:(NSDictionary*)params
               andExecute:(void (^)(id, NSError *))block;

/**
 *  Creates a new cart or restores an anonymous cart as a user's cart (if an old Cart Id is given in the request)
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)createCartForUserId:(NSString*)userId
                 withParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns the cart with a given identifier.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getCartForUserId:(NSString*)userId
               andCartId:(NSString*)cartId
              andExecute:(void (^)(id, NSError *))block;

/**
 *  Deletes a cart with a given cart id.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)deleteCartForUserId:(NSString*)userId
                  andCartId:(NSString*)cartId
                 andExecute:(void (^)(id, NSError *))block;

/**
 *  Creates an address and assigns it to the cart as the delivery address.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)createCartDeliveryAddressForUserId:(NSString*)userId
                                 andCartId:(NSString*)cartId
                                withParams:(NSDictionary*)params
                                andExecute:(void (^)(id, NSError *))block;
/**
 *  Sets a delivery address for the cart. The address country must be placed among the delivery countries of the current base store.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateCartDeliveryAddressForUserId:(NSString*)userId
                                 andCartId:(NSString*)cartId
                                withParams:(NSDictionary*)params
                                andExecute:(void (^)(id, NSError *))block;
/**
 *  Removes the delivery address from the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)deleteCartDeliveryAddressForUserId:(NSString*)userId
                                 andCartId:(NSString*)cartId
                                andExecute:(void (^)(id, NSError *))block;

/**
 *  Explicitly clones a cart
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)cloneSavedCartForUserId:(NSString*)userId
                      andCartId:(NSString*)cartId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns the delivery mode selected for the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getCartDeliverymodeForUserId:(NSString*)userId
                           andCartId:(NSString*)cartId
                          andExecute:(void (^)(id, NSError *))block;

/**
 *  Sets the delivery mode with a given identifier for the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateCartDeliverymodeForUserId:(NSString*)userId
                              andCartId:(NSString*)cartId
                             withParams:(NSDictionary*)params
                             andExecute:(void (^)(id, NSError *))block;

/**
 *  Removes the delivery mode from the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)deleteCartDeliverymodeForUserId:(NSString*)userId
                              andCartId:(NSString*)cartId
                             andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns all delivery modes supported for the current base store and cart delivery address.
 *  A delivery address must be set for the cart, otherwise an empty list will be returned.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getCartDeliverymodesForUserId:(NSString*)userId
                            andCartId:(NSString*)cartId
                           andExecute:(void (^)(id, NSError *))block;

/**
 *  Assigns an email to the cart. This step is required to make a guest checkout.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)setCartEmailForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns cart entries.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getCartEntriesForUserId:(NSString*)userId
                      andCartId:(NSString*)cartId
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Adds a product to the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)addCartEntryForUserId:(NSString*)userId
                      andCartId:(NSString*)cartId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns the details of the cart entries.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param entryNumber entry number
 *  @param block  results callback
 */
- (void)getCartEntryForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
               andEntryNumber:(NSString*)entryNumber
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates the quantity of a single cart entry and details of the store where the cart entry will be picked.
 *  Attributes not provided in request will be defined again (set to null or default)
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param entryNumber entry number
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)replaceCartEntryForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
               andEntryNumber:(NSString*)entryNumber
                   withParams:(NSDictionary*)params
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates the quantity of a single cart entry and details of the store where the cart entry will be picked.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param entryNumber entry number
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateCartEntryForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                  andEntryNumber:(NSString*)entryNumber
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Deletes cart entry.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param entryNumber entry number
 *  @param block  results callback
 */
- (void)deleteCartEntryForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                  andEntryNumber:(NSString*)entryNumber
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Flags a cart for deletion (the cart doesn't have corresponding save cart attributes anymore).
 *  The cart is not actually deleted from the database. But with the removal of the saved cart attributes,
 *  this cart will be taken care of by the cart removal job just like any other cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)flagCartForDeletionForUserId:(NSString*)userId
                           andCartId:(NSString*)cartId
                          andExecute:(void (^)(id, NSError *))block;

/**
 *  Defines details of a new credit card payment details and assigns the payment to the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)createCartPaymentdetailsForUserId:(NSString*)userId
                                andCartId:(NSString*)cartId
                               withParams:(NSDictionary*)params
                               andExecute:(void (^)(id, NSError *))block;

/**
 *  Sets credit card payment details for the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateCartPaymentdetailsForUserId:(NSString*)userId
                             andCartId:(NSString*)cartId
                            withParams:(NSDictionary*)params
                            andExecute:(void (^)(id, NSError *))block;

/**
 *  Return information about promotions applied on cart
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getCartPromotionsForUserId:(NSString*)userId
                         andCartId:(NSString*)cartId
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Enables the promotion for the order based on the promotionId defined for the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)setCartPromotionForUserId:(NSString*)userId
                         andCartId:(NSString*)cartId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Return information about promotion with given id, applied on cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getCartPromotionForUserId:(NSString*)userId
                        andCartId:(NSString*)cartId
                   andPromotionId:(NSString*)promotionId
                       andExecute:(void (^)(id, NSError *))block;
/**
 *  Disables the promotion for the order based on the promotionId defined for the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param promotionId promotion id
 *  @param block  results callback
 */
- (void)deleteCartPromotionForUserId:(NSString*)userId
                           andCartId:(NSString*)cartId
                      andPromotionId:(NSString*)promotionId
                          andExecute:(void (^)(id, NSError *))block;

/**
 *  restore Saved cart (no doc provided by OCC)
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)restoreSavedcartForUserId:(NSString*)userId
                        andCartId:(NSString*)cartId
                       andExecute:(void (^)(id, NSError *))block;

/**
 *  Explicitly saves a cart
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)saveCartForUserId:(NSString*)userId
                andCartId:(NSString*)cartId
               withParams:(NSDictionary*)params
               andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns saved cart by it id for authenticated user
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getSavedcartForUserId:(NSString*)userId
                    andCartId:(NSString*)cartId
                   andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns list of vouchers applied to the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param block  results callback
 */
- (void)getCartVouchersForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Applies a voucher based on the voucherId defined for the cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)setCartVoucherForUserId:(NSString*)userId
                       andCartId:(NSString*)cartId
                      withParams:(NSDictionary*)params
                      andExecute:(void (^)(id, NSError *))block;

/**
 *  Removes a voucher based on the voucherId defined for the current cart.
 *
 *  @param userId user id
 *  @param cartId cart id
 *  @param voucherId voucher id
 *  @param block  results callback
 */
- (void)deleteCartVoucherForUserId:(NSString*)userId
                         andCartId:(NSString*)cartId
                      andVoucherId:(NSString*)voucherId
                        andExecute:(void (^)(id, NSError *))block;

//profile

/**
 *  Returns all customer groups of a customer.
 *
 *  @param userId user id
 *  @param block  results callback
 */
- (void)getUserCustomergroupsForUserId:(NSString*)userId
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Changes customer's login.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateUserLoginForUserId:(NSString*)userId
               withParams:(NSDictionary*)params
               andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns X-Total-Count header with a total number of results
 *  (orders history for all orders placed by the specific user for the specific base store).
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)countOrdersForUserId:(NSString*)userId
                  withParams:(NSDictionary*)params
                  andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns order history data for all orders placed by the specific user for the specific base store.
 *  Response contains orders search result displayed in several pages if needed.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getOrdersForUserId:(NSString*)userId
                withParams:(NSDictionary*)params
                andExecute:(void (^)(id, NSError *))block;

/**
 *  Authorizes cart and places the order. Response contains the new order data.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)placeOrderForUserId:(NSString*)userId
                 withParams:(NSDictionary*)params
                 andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns specific order details based on a specific order code. The response contains detailed order information.
 *
 *  @param userId user id
 *  @param code   order code or guid
 *  @param block  results callback
 */
- (void)getOrderForUserId:(NSString*)userId
             andOrderCode:(NSString*)code
               andExecute:(void (^)(id, NSError *))block;

/**
 *  Changes customer's password.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateUserPasswordForUserId:(NSString*)userId
                     withParams:(NSDictionary*)params
                     andExecute:(void (^)(id, NSError *))block;

/**
 *  Return customer's credit card payment details list.
 *
 *  @param userId user id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)getPaymentdetailsListForUserId:(NSString*)userId
                            withParams:(NSDictionary*)params
                            andExecute:(void (^)(id, NSError *))block;

/**
 *  Returns customer's credit card payment details for a given id.
 *
 *  @param userId user id
 *  @param paymentdetailsId payment details Id
 *  @param block  results callback
 */
- (void)getUserPaymentdetailsForUserId:(NSString*)userId
               andPaymentdetailsId:(NSString*)paymentdetailsId
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates existing customer's credit card payment info based on the payment info ID.
 *  Attributes not given in request will be defined again (set to null or default).
 *
 *  @param userId user id
 *  @param paymentdetailsId payment details Id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)replaceUserPaymentdetailsForUserId:(NSString*)userId
               andPaymentdetailsId:(NSString*)paymentdetailsId
                        withParams:(NSDictionary*)params
                        andExecute:(void (^)(id, NSError *))block;

/**
 *  Updates existing customer's credit card payment details based on its ID. Only attributes given in request will be changed.
 *
 *  @param userId user id
 *  @param paymentdetailsId payment details Id
 *  @param params Query Parameters
 *  @param block  results callback
 */
- (void)updateUserPaymentdetailsForUserId:(NSString*)userId
                  andPaymentdetailsId:(NSString*)paymentdetailsId
                           withParams:(NSDictionary*)params
                           andExecute:(void (^)(id, NSError *))block;

/**
 *  Removes customer's credit card payment details based on its ID.
 *
 *  @param userId user id
 *  @param paymentdetailsId payment details Id
 *  @param block  results callback
 */
- (void)deleteUserPaymentdetailsForUserId:(NSString*)userId
                  andPaymentdetailsId:(NSString*)paymentdetailsId
                           andExecute:(void (^)(id, NSError *))block;
//vouchers

/**
 *  Returns details of a single voucher according to a voucher code.
 *
 *  @param code  voucher code
 *  @param block  results callback
 */
- (void)getVoucherForVoucherCode:(NSString*)code
                    andExecute:(void (^)(id, NSError *))block;

@end
