/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.lib.commerce.service;

import android.view.View;
import android.widget.ImageView;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.data.Count;
import com.hybris.mobile.lib.commerce.data.catalog.Catalog;
import com.hybris.mobile.lib.commerce.data.catalog.CatalogList;
import com.hybris.mobile.lib.commerce.data.catalog.CatalogVersion;
import com.hybris.mobile.lib.commerce.data.catalog.CategoryHierarchy;
import com.hybris.mobile.lib.commerce.data.order.CardTypeList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.order.CartList;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.data.order.DeliveryMode;
import com.hybris.mobile.lib.commerce.data.order.DeliveryModeList;
import com.hybris.mobile.lib.commerce.data.order.Order;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import com.hybris.mobile.lib.commerce.data.order.OrderEntryList;
import com.hybris.mobile.lib.commerce.data.order.OrderHistoryList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetailsList;
import com.hybris.mobile.lib.commerce.data.order.SaveCartResult;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.ProductList;
import com.hybris.mobile.lib.commerce.data.product.ProductReferenceList;
import com.hybris.mobile.lib.commerce.data.product.Promotion;
import com.hybris.mobile.lib.commerce.data.product.PromotionList;
import com.hybris.mobile.lib.commerce.data.product.PromotionResult;
import com.hybris.mobile.lib.commerce.data.product.PromotionResultList;
import com.hybris.mobile.lib.commerce.data.product.Review;
import com.hybris.mobile.lib.commerce.data.product.ReviewList;
import com.hybris.mobile.lib.commerce.data.product.Stock;
import com.hybris.mobile.lib.commerce.data.product.SuggestionList;
import com.hybris.mobile.lib.commerce.data.queues.OrderStatusUpdateElementList;
import com.hybris.mobile.lib.commerce.data.queues.ProductExpressUpdateElementList;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;
import com.hybris.mobile.lib.commerce.data.store.StoreFinderSearchPage;
import com.hybris.mobile.lib.commerce.data.store.StoreFinderStockSearchPage;
import com.hybris.mobile.lib.commerce.data.storesession.CurrencyList;
import com.hybris.mobile.lib.commerce.data.storesession.LanguageList;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.AddressList;
import com.hybris.mobile.lib.commerce.data.user.CountryList;
import com.hybris.mobile.lib.commerce.data.user.TitleList;
import com.hybris.mobile.lib.commerce.data.user.User;
import com.hybris.mobile.lib.commerce.data.user.UserGroup;
import com.hybris.mobile.lib.commerce.data.user.UserGroupList;
import com.hybris.mobile.lib.commerce.data.voucher.Voucher;
import com.hybris.mobile.lib.commerce.data.voucher.VoucherList;
import com.hybris.mobile.lib.commerce.query.QueryAddress;
import com.hybris.mobile.lib.commerce.query.QueryCartClone;
import com.hybris.mobile.lib.commerce.query.QueryCartCreate;
import com.hybris.mobile.lib.commerce.query.QueryCartEmail;
import com.hybris.mobile.lib.commerce.query.QueryCartEntry;
import com.hybris.mobile.lib.commerce.query.QueryCarts;
import com.hybris.mobile.lib.commerce.query.QueryCatalog;
import com.hybris.mobile.lib.commerce.query.QueryCreateUser;
import com.hybris.mobile.lib.commerce.query.QueryCustomerGroup;
import com.hybris.mobile.lib.commerce.query.QueryDeliveryMode;
import com.hybris.mobile.lib.commerce.query.QueryExportProducts;
import com.hybris.mobile.lib.commerce.query.QueryForgottenPassword;
import com.hybris.mobile.lib.commerce.query.QueryLogin;
import com.hybris.mobile.lib.commerce.query.QueryNewLogin;
import com.hybris.mobile.lib.commerce.query.QueryNewPassword;
import com.hybris.mobile.lib.commerce.query.QueryOrder;
import com.hybris.mobile.lib.commerce.query.QueryOrders;
import com.hybris.mobile.lib.commerce.query.QueryOrdersFeeds;
import com.hybris.mobile.lib.commerce.query.QueryPayment;
import com.hybris.mobile.lib.commerce.query.QueryPayments;
import com.hybris.mobile.lib.commerce.query.QueryPlaceOrder;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.query.QueryProductReference;
import com.hybris.mobile.lib.commerce.query.QueryProductReview;
import com.hybris.mobile.lib.commerce.query.QueryProductStock;
import com.hybris.mobile.lib.commerce.query.QueryProductSuggestions;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.query.QueryPromotion;
import com.hybris.mobile.lib.commerce.query.QueryPromotions;
import com.hybris.mobile.lib.commerce.query.QuerySaveCart;
import com.hybris.mobile.lib.commerce.query.QueryStore;
import com.hybris.mobile.lib.commerce.query.QueryStores;
import com.hybris.mobile.lib.commerce.query.QueryUser;
import com.hybris.mobile.lib.commerce.query.QueryVoucher;
import com.hybris.mobile.lib.commerce.query.SpecificCart;
import com.hybris.mobile.lib.commerce.query.SpecificUser;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.listener.OnRequestListener;

import java.util.List;


/**
 * Interface for the service used to get the application data
 */
public interface ContentServiceHelper {

    /**
     * Login a user
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryLogin        Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean authenticate(ResponseReceiverEmpty responseReceiver, String requestId, QueryLogin queryLogin, boolean shouldUseCache,
                         List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Set the trusted client role to the current anonymous user
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean setClientRoleForGuest(ResponseReceiverEmpty responseReceiver, String requestId, boolean shouldUseCache,
                                  List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Logout the current logged in user associated with the content service helper. Please note that this method is not
     * asynchronous as we are doing any http call.
     *
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean logout();

    /**
     * Lists supported payment card types.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCardTypes(ResponseReceiver<CardTypeList> responseReceiver, String requestId,
                         boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns all catalogs with versions defined for the base store.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCatalogs(ResponseReceiver<CatalogList> responseReceiver, String requestId,
                        boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns a information about a catalog based on its ID
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCatalog      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCatalog(ResponseReceiver<Catalog> responseReceiver, String requestId, QueryCatalog queryCatalog,
                       boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns information about category that exists in a catalog version available for the current base store.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCatalog      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCatalogVersion(ResponseReceiver<CatalogVersion> responseReceiver, String requestId, QueryCatalog queryCatalog,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns information about category that exists in a catalog version available for the current base store.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCatalog      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCatalogCategory(ResponseReceiver<CategoryHierarchy> responseReceiver, String requestId, QueryCatalog queryCatalog,
                               boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Lists all available currencies (all usable currencies for the current store). If the list of currencies for stores is empty, a list of all currencies available in the system is returned.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCurrencies(ResponseReceiver<CurrencyList> responseReceiver, String requestId,
                          boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns all customer groups that are direct subgroups of a customergroup.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCustomerGroups(ResponseReceiver<UserGroupList> responseReceiver, String requestId,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Creates a new customer group that is a direct subgroup of a customergroup.
     *
     * @param responseReceiver   Response callback result
     * @param requestId          Identifier for the call
     * @param queryCustomerGroup Parameters needed for the request
     * @param shouldUseCache     Indicator to use cache or not
     * @param viewsToDisable     Views to disable/enable before/after the request
     * @param onRequestListener  Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean createCustomerGroup(ResponseReceiverEmpty responseReceiver, String requestId, QueryCustomerGroup queryCustomerGroup,
                                boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns a customer group
     *
     * @param responseReceiver   Response callback result
     * @param requestId          Identifier for the call
     * @param queryCustomerGroup Parameters needed for the request
     * @param shouldUseCache     Indicator to use cache or not
     * @param viewsToDisable     Views to disable/enable before/after the request
     * @param onRequestListener  Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCustomerGroup(ResponseReceiver<UserGroup> responseReceiver, String requestId, QueryCustomerGroup queryCustomerGroup,
                             boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Sets members for a user group. The list of existing members is overwritten with a new one.
     *
     * @param responseReceiver   Response callback result
     * @param requestId          Identifier for the call
     * @param queryCustomerGroup Parameters needed for the request
     * @param shouldUseCache     Indicator to use cache or not
     * @param viewsToDisable     Views to disable/enable before/after the request
     * @param onRequestListener  Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean setCustomerGroupMembers(ResponseReceiverEmpty responseReceiver, String requestId, QueryCustomerGroup queryCustomerGroup,
                                    boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Assigns user(s) to a customer group.
     *
     * @param responseReceiver   Response callback result
     * @param requestId          Identifier for the call
     * @param queryCustomerGroup Parameters needed for the request
     * @param shouldUseCache     Indicator to use cache or not
     * @param viewsToDisable     Views to disable/enable before/after the request
     * @param onRequestListener  Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateCustomerGroupMembers(ResponseReceiverEmpty responseReceiver, String requestId, QueryCustomerGroup queryCustomerGroup,
                                       boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes user from a customer group.
     *
     * @param responseReceiver   Response callback result
     * @param requestId          Identifier for the call
     * @param queryCustomerGroup Parameters needed for the request
     * @param shouldUseCache     Indicator to use cache or not
     * @param viewsToDisable     Views to disable/enable before/after the request
     * @param onRequestListener  Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCustomerGroupMembers(ResponseReceiverEmpty responseReceiver, String requestId, QueryCustomerGroup queryCustomerGroup,
                                       boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Lists all supported delivery countries for the current store. The list is sorted alphabetically.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getDeliveryCountries(ResponseReceiver<CountryList> responseReceiver, String requestId,
                                 boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Used for product export. Depending on the timestamp parameter, it can return all products or only products modified after the given time.
     *
     * @param responseReceiver    Response callback result
     * @param requestId           Identifier for the call
     * @param queryExportProducts Parameters needed for the request
     * @param shouldUseCache      Indicator to use cache or not
     * @param viewsToDisable      Views to disable/enable before/after the request
     * @param onRequestListener   Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getExportProducts(ResponseReceiver<ProductList> responseReceiver, String requestId, QueryExportProducts queryExportProducts,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns the orders the status has changed for. Returns only the elements from the current baseSite, updated after the provided timestamp.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryOrdersFeeds  Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getOrdersFeeds(ResponseReceiver<OrderStatusUpdateElementList> responseReceiver, String requestId, QueryOrdersFeeds queryOrdersFeeds,
                           boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Generates a token to restore customer's forgotten password.
     *
     * @param responseReceiver       Response callback result
     * @param requestId              Identifier for the call
     * @param queryForgottenPassword Parameters needed for the request
     * @param shouldUseCache         Indicator to use cache or not
     * @param viewsToDisable         Views to disable/enable before/after the request
     * @param onRequestListener      Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean generateForgottenPasswordTokens(ResponseReceiverEmpty responseReceiver, String requestId, QueryForgottenPassword queryForgottenPassword,
                                            boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Lists all available languages (all languages used for a particular store). If the list of languages for a base store is empty, a list of all languages available in the system will be returned.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getLanguages(ResponseReceiver<LanguageList> responseReceiver, String requestId,
                         boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns products added to the express update feed. Returns only elements updated after the provided timestamp.The queue is cleared using a defined cronjob.
     *
     * @param responseReceiver    Response callback result
     * @param requestId           Identifier for the call
     * @param queryExportProducts Parameters needed for the request
     * @param shouldUseCache      Indicator to use cache or not
     * @param viewsToDisable      Views to disable/enable before/after the request
     * @param onRequestListener   Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProductsExpressUpdate(ResponseReceiver<ProductExpressUpdateElementList> responseReceiver, String requestId, QueryExportProducts queryExportProducts,
                                     boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns total number of products satisfying a query
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProducts     Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean countProducts(ResponseReceiver<Count> responseReceiver, String requestId, QueryProducts queryProducts,
                          boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns a list of all available suggestions related to a given term and limits the results to a specific value of the max parameter.
     *
     * @param responseReceiver        Response callback result
     * @param requestId               Identifier for the call
     * @param queryProductSuggestions Parameters needed for the request
     * @param shouldUseCache          Indicator to use cache or not
     * @param viewsToDisable          Views to disable/enable before/after the request
     * @param onRequestListener       Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProductsSuggestions(ResponseReceiver<SuggestionList> responseReceiver, String requestId, QueryProductSuggestions queryProductSuggestions,
                                   boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns details of a single product according to a product code.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProduct      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProduct(ResponseReceiver<Product> responseReceiver, String requestId,
                       QueryProduct queryProduct, boolean shouldUseCache, List<View> viewsToDisable,
                       OnRequestListener onRequestListener);

    /**
     * Returns references for a product with a given product code. Reference type specifies which references to return.
     *
     * @param responseReceiver      Response callback result
     * @param requestId             Identifier for the call
     * @param queryProductReference Parameters needed for the request
     * @param shouldUseCache        Indicator to use cache or not
     * @param viewsToDisable        Views to disable/enable before/after the request
     * @param onRequestListener     Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProductReferences(ResponseReceiver<ProductReferenceList> responseReceiver, String requestId, QueryProductReference queryProductReference,
                                 boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns the reviews for a product with a given product code.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProduct      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProductReviews(ResponseReceiver<ReviewList> responseReceiver, String requestId, QueryProduct queryProduct,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Creates a new customer review as an anonymous user.
     *
     * @param responseReceiver   Response callback result
     * @param requestId          Identifier for the call
     * @param queryProductReview Parameters needed for the request
     * @param shouldUseCache     Indicator to use cache or not
     * @param viewsToDisable     Views to disable/enable before/after the request
     * @param onRequestListener  Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean setProductReview(ResponseReceiver<Review> responseReceiver, String requestId, QueryProductReview queryProductReview,
                             boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns total number of product's stock levels.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProductStock Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean countProductStock(ResponseReceiver<Count> responseReceiver, String requestId, QueryProductStock queryProductStock,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns product's stock levels sorted by distance from specific location passed by free-text parameter or longitude and latitude parameters
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProductStock Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProductStock(ResponseReceiver<StoreFinderStockSearchPage> responseReceiver, String requestId, QueryProductStock queryProductStock,
                            boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns product's stock level for a particular store (POS).
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProductStock Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProductStoreStock(ResponseReceiver<Stock> responseReceiver, String requestId, QueryProductStock queryProductStock,
                                 boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns promotions defined for a current base site.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPromotions   Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getPromotions(ResponseReceiver<PromotionList> responseReceiver, String requestId, QueryPromotions queryPromotions,
                          boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns details of a single promotion specified by a promotion code.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPromotion    Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getPromotion(ResponseReceiver<Promotion> responseReceiver, String requestId, QueryPromotion queryPromotion,
                         boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns the number of all store locations that are near the location specified in a query, or based on latitude and longitude.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryStores       Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean countStores(ResponseReceiver<Count> responseReceiver, String requestId, QueryStores queryStores,
                        boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Lists all store locations that are near the location specified in a query or based on latitude and longitude.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryStores       Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getStores(ResponseReceiver<StoreFinderSearchPage> responseReceiver, String requestId, QueryStores queryStores,
                      boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns store location based on its unique name.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryStore        Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getStore(ResponseReceiver<PointOfService> responseReceiver, String requestId, QueryStore queryStore,
                     boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Lists all localized titles.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getTitles(ResponseReceiver<TitleList> responseReceiver, String requestId,
                      boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Registers a customer.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCreateUser   Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean registerUser(ResponseReceiverEmpty responseReceiver, String requestId, QueryCreateUser queryCreateUser,
                         boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns customer profile.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificUser      overrides the user or guest with the specified user      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getUserProfile(ResponseReceiver<User> responseReceiver, String requestId, SpecificUser specificUser, boolean shouldUseCache,
                           List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates customer profile. Attributes not provided in the request body will be defined again (set to null or default).
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryUser         Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean replaceUserProfile(ResponseReceiverEmpty responseReceiver, String requestId, QueryUser queryUser,
                               SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates customer profile. Only attributes provided in the request body will be changed.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryUser         Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateUserProfile(ResponseReceiverEmpty responseReceiver, String requestId, QueryUser queryUser,
                              SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes customer profile.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificUser      overrides the user or guest with the specified user      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteUserProfile(ResponseReceiverEmpty responseReceiver, String requestId, SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns customer's addresses.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificUser      overrides the user or guest with the specified user      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getUserAddresses(ResponseReceiver<AddressList> responseReceiver, String requestId, SpecificUser specificUser,
                             boolean shouldUseCache,
                             List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Create a new address.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean createUserAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress,
                              SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Verifies address
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean verifyUserAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress, SpecificUser specificUser, boolean shouldUseCache,
                              List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns detailed information about address with a given id.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getUserAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress, SpecificUser specificUser, boolean shouldUseCache,
                           List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates the address. Attributes not provided in the request will be defined again (set to null or default).
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean replaceUserAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                               SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates the address. Only attributes provided in the request body will be changed.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateUserAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                              SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes customer's address.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteUserAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                              SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Lists all customer carts. Allowed only for non-anonymous users.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCarts        Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCarts(ResponseReceiver<CartList> responseReceiver, String requestId, QueryCarts queryCarts, SpecificUser specificUser, boolean shouldUseCache,
                     List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Creates a new cart or restores an anonymous cart as a user's cart (if an old Cart Id is given in the request)
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartCreate   Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean createCart(ResponseReceiver<Cart> responseReceiver, String requestId, QueryCartCreate queryCartCreate, SpecificUser specificUser, boolean shouldUseCache,
                       List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns the last created cart, or create one if none is found
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCart(ResponseReceiver<Cart> responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache,
                    List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Deletes a cart with a given cart id.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCart(ResponseReceiverEmpty responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache,
                       List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Creates an address and assigns it to the cart as the delivery address.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean createCartDeliveryAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress,
                                      SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Sets a delivery address for the cart. The address country must be placed among the delivery countries of the current base store.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryAddress      Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateCartDeliveryAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                                      SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes the delivery address from the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCartDeliveryAddress(ResponseReceiverEmpty responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Explicitly clones a cart
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartClone    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean cloneSavedCart(ResponseReceiverEmpty responseReceiver, String requestId, QueryCartClone queryCartClone, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns the delivery mode selected for the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartDeliveryMode(ResponseReceiver<DeliveryMode> responseReceiver, String requestId,
                                SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Sets the delivery mode with a given identifier for the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryDeliveryMode Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateCartDeliveryMode(ResponseReceiverEmpty responseReceiver, String requestId, QueryDeliveryMode queryDeliveryMode,
                                   SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes the delivery mode from the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCartDeliveryMode(ResponseReceiverEmpty responseReceiver, String requestId,
                                   SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns all delivery modes supported for the current base store and cart delivery address. A delivery address must be set for the cart, otherwise an empty list will be returned.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartDeliveryModes(ResponseReceiver<DeliveryModeList> responseReceiver, String requestId,
                                 SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Assigns an email to the cart. This step is required to make a guest checkout.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartEmail    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean setCartEmail(ResponseReceiverEmpty responseReceiver, String requestId, QueryCartEmail queryCartEmail,
                         SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns cart entries.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartEntries(ResponseReceiver<OrderEntryList> responseReceiver, String requestId,
                           SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns the details of a cart entry.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartEntry    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartEntry(ResponseReceiver<OrderEntry> responseReceiver, String requestId, QueryCartEntry queryCartEntry,
                         SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Deletes cart entry.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartEntry    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId, QueryCartEntry queryCartEntry,
                            SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Flags a cart for deletion (the cart doesn't have corresponding save cart attributes anymore). The cart is not actually deleted from the database. But with the removal of the saved cart attributes, this cart will be taken care of by the cart removal job just like any other cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean flagCartForDeletion(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, SpecificCart specificCart,
                                boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Defines details of a new credit card payment details and assigns the payment to the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayment      Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean createCartPayment(ResponseReceiver<PaymentDetails> responseReceiver, String requestId, QueryPayment queryPayment,
                              SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Sets credit card payment details for the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayment      Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateCartPayment(ResponseReceiverEmpty responseReceiver, String requestId, QueryPayment queryPayment,
                              SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Return information about promotions applied on cart
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartPromotions(ResponseReceiver<PromotionResultList> responseReceiver, String requestId,
                              SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Enables the promotion for the order based on the promotionId defined for the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPromotion    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean setCartPromotion(ResponseReceiverEmpty responseReceiver, String requestId, QueryPromotion queryPromotion,
                             SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Return information about promotion with given id, applied on cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPromotion    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartPromotion(ResponseReceiver<PromotionResult> responseReceiver, String requestId, QueryPromotion queryPromotion,
                             SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Disables the promotion for the order based on the promotionId defined for the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPromotion    Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCartPromotion(ResponseReceiverEmpty responseReceiver, String requestId, QueryPromotion queryPromotion,
                                SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Restore a saved cart
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean restoreSavedCart(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, SpecificCart specificCart,
                             boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Explicitly saves a cart
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param querySaveCart     Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean saveCart(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, QuerySaveCart querySaveCart,
                     SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns saved cart by it id for authenticated user
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getSavedCart(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, SpecificCart specificCart,
                         boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns list of vouchers applied to the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getCartVouchers(ResponseReceiver<VoucherList> responseReceiver, String requestId,
                            SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Applies a voucher based on the voucherId defined for the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryVoucher      Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean setCartVoucher(ResponseReceiverEmpty responseReceiver, String requestId, QueryVoucher queryVoucher,
                           SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes a voucher based on the voucherId defined for the current cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryVoucher      Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteCartVoucher(ResponseReceiverEmpty responseReceiver, String requestId, QueryVoucher queryVoucher,
                              SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns all customer groups of a customer.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getUserCustomerGroups(ResponseReceiver<UserGroupList> responseReceiver, String requestId,
                                  SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Changes customer's authenticate.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryNewLogin     Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateUserLogin(ResponseReceiverEmpty responseReceiver, String requestId, QueryNewLogin queryNewLogin,
                            SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns total number of results (orders history for all orders placed by the specific user for the specific base store).
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryOrders       Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean countOrders(ResponseReceiver<Count> responseReceiver, String requestId, QueryOrders queryOrders,
                        SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns order history data for all orders placed by the specific user for the specific base store. Response contains orders search result displayed in several pages if needed.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryOrders       Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getOrders(ResponseReceiver<OrderHistoryList> responseReceiver, String requestId, QueryOrders queryOrders,
                      SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Authorizes cart and places the order. Response contains the new order data.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPlaceOrder     Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean placeOrder(ResponseReceiver<Order> responseReceiver, String requestId, QueryPlaceOrder queryPlaceOrder,
                       SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns specific order details based on a specific order code. The response contains detailed order information.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryOrder        Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getOrder(ResponseReceiver<Order> responseReceiver, String requestId, QueryOrder queryOrder,
                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Changes customer's password.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryNewPassword  Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateUserPassword(ResponseReceiverEmpty responseReceiver, String requestId, QueryNewPassword queryNewPassword,
                               SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Return customer's credit card payment details list.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayments     Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getUserPaymentDetailsList(ResponseReceiver<PaymentDetailsList> responseReceiver, String requestId, QueryPayments queryPayments,
                                      SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns customer's credit card payment details for a given id.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayment      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getUserPaymentDetails(ResponseReceiver<PaymentDetails> responseReceiver, String requestId, QueryPayment queryPayment,
                                  SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates existing customer's credit card payment info based on the payment info ID. Attributes not given in request will be defined again (set to null or default).
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayment      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean replaceUserPaymentDetails(ResponseReceiverEmpty responseReceiver, String requestId, QueryPayment queryPayment,
                                      SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates existing customer's credit card payment details based on its ID. Only attributes given in request will be changed.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayment      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateUserPaymentDetails(ResponseReceiverEmpty responseReceiver, String requestId, QueryPayment queryPayment,
                                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Removes customer's credit card payment details based on its ID.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryPayment      Parameters needed for the request
     * @param specificUser      overrides the user or guest with the specified user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean deleteUserPaymentDetails(ResponseReceiverEmpty responseReceiver, String requestId, QueryPayment queryPayment,
                                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Returns details of a single voucher according to a voucher code.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryVoucher      Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getVoucher(ResponseReceiver<Voucher> responseReceiver, String requestId, QueryVoucher queryVoucher,
                       boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Load an image into an ImageView
     *
     * @param url                           HTTP Address
     * @param requestId                     Identifier for the call                     Identifier for the call
     * @param imageView                     ImageView to be updated
     * @param width                         Horizontal size in pixels (or 0 for automatic)
     * @param height                        Vertical size in pixels (or 0 for automatic)
     * @param shouldUseCache                Indicator to use cache or not                Indicator to use cache or not
     * @param onRequestListener             Its methods will be called when the request is sent             Its methods will be called when the request is sent
     * @param forceImageTagToMatchRequestId if set to true, the imageView will set its tag with the requestId value and will verify after getting
     *                                      the image content from the url, that the tag is still equals to the requestId. If yes, the imageView is
     *                                      updated with the content just pulled.
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean loadImage(String url, String requestId, ImageView imageView, int width, int height, boolean shouldUseCache,
                      OnRequestListener onRequestListener, boolean forceImageTagToMatchRequestId);

    /**
     * Return the data converter
     *
     * @return the data converter
     */
    DataConverter getDataConverter();

    /**
     * Get the configuration
     *
     * @return the configuration used by the content service helper
     */
    Configuration getConfiguration();

    /**
     * Return the catalog last sync date
     *
     * @return the time in millis
     */
    long getCatalogLastSyncDate();

    /**
     * Save the catalog last sync date
     *
     * @param timeInMillis the time in millis
     */
    void saveCatalogLastSyncDate(long timeInMillis);

    /**
     * Cancel the requests associated with the id
     */
    void cancel(String requestId);

    /**
     * Cancel all the ongoing requests
     */
    void cancelAll();

    /**
     * Pause all the ongoing requests
     */
    void pause();

    /**
     * (Re)Start all the (pending) requests
     */
    void start();

    /**
     * Update the cache used by the persistence manager.
     */
    void updateCache();

    /**
     * Update the configuration
     *
     * @param url                   the new url
     * @param catalog               the catalog
     * @param catalogId             the catalog id
     * @param catalogVersionId      the catalog version id
     * @param catalogMainCategoryId the main category id of the catalo
     */
    void updateConfiguration(String url, String catalog, String catalogId, String catalogVersionId, String catalogMainCategoryId);

}
