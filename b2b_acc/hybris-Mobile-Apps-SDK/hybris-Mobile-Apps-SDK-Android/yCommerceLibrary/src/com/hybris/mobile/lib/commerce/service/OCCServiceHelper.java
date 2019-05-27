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

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.Config;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hybris.mobile.lib.commerce.BuildConfig;
import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.Constants;
import com.hybris.mobile.lib.commerce.R;
import com.hybris.mobile.lib.commerce.data.Count;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.UserInformation;
import com.hybris.mobile.lib.commerce.data.catalog.Catalog;
import com.hybris.mobile.lib.commerce.data.catalog.CatalogList;
import com.hybris.mobile.lib.commerce.data.catalog.CatalogVersion;
import com.hybris.mobile.lib.commerce.data.catalog.CategoryHierarchy;
import com.hybris.mobile.lib.commerce.data.error.Error;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
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
import com.hybris.mobile.lib.commerce.helper.SecurityHelper;
import com.hybris.mobile.lib.commerce.helper.UrlHelper;
import com.hybris.mobile.lib.commerce.provider.CatalogContract;
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
import com.hybris.mobile.lib.commerce.utils.JsonUtils;
import com.hybris.mobile.lib.commerce.utils.MapUtils;
import com.hybris.mobile.lib.http.PersistenceHelper;
import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.converter.JsonDataConverter;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.manager.PersistenceManager;
import com.hybris.mobile.lib.http.manager.volley.VolleyPersistenceManager;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.response.ResponseCallback;
import com.hybris.mobile.lib.http.utils.HttpUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;


/**
 * OCC Implementation to retrieve the application data
 */
public class OCCServiceHelper implements ContentServiceHelper {
    private static final String TAG = OCCServiceHelper.class.getCanonicalName();
    private static final Config CONFIG_IMAGES_QUALITY = Config.ALPHA_8;
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_AUTHORIZATION_BEARER = "Bearer";
    private static final String TOKEN_REFRESH = "TOKEN_REFRESH";
    private static final String USER_ID = "USER_ID";
    private static final String CATALOG_LAST_SYNC_DATE = "CATALOG_LAST_SYNC_DATE";

    protected UserInformation mUserInformation;
    protected PersistenceHelper mPersistenceHelper;
    protected DataConverter mDataConverter;
    protected Context mContext;
    protected Configuration mConfiguration;

    /**
     * Default constructor
     *
     * @param context            the android context
     * @param configuration      the configuration objects containing informations for the backend to use
     * @param persistenceManager the persistence manager to use for the HTTP calls
     * @param dataConverter      the data converter to use for the persistence manager to convert raw data results to java beans
     * @param uiRelated          flag to optimize performances in case the work is not UI related. Must be true if used on UI screens, false for only background jobs (sync job, etc.)
     */
    public OCCServiceHelper(Context context, Configuration configuration, PersistenceManager persistenceManager,
                            DataConverter dataConverter, boolean uiRelated) {
        if (context == null || configuration == null || persistenceManager == null || dataConverter == null) {
            throw new IllegalArgumentException("Some parameters are missing with your request, please check the documentation");
        }

        this.mContext = context;
        this.mConfiguration = configuration;
        this.mDataConverter = dataConverter;
        this.mPersistenceHelper = new PersistenceHelper(context, persistenceManager, dataConverter, uiRelated);

        // We initiate the user's information with the date previously saved if any
        this.mUserInformation = new UserInformation(SecurityHelper.getStringFromSecureSharedPreferences(getSharedPreferences(),
                USER_ID, ""), SecurityHelper.getStringFromSecureSharedPreferences(getSharedPreferences(), TOKEN_REFRESH, ""));

        // Anonymous usage
        if (StringUtils.isBlank(mUserInformation.getUserId())) {
            mUserInformation.setUserId(SpecificUser.UserId.ANONYMOUS.getValue());
        }
    }

    /**
     * Constructor using volley as the persistence manager and json for conversion
     *
     * @param context          the android context
     * @param configuration    the configuration objects containing informations for the backend to use
     * @param sslSocketFactory SSL factory to use for the secure calls
     * @param hostnameVerifier Hostname verifier to use for the secure calls
     * @param uiRelated        flag to optimize performances in case the work is not UI related. Must be true if used on UI screens, false for only background jobs (sync job, etc.)
     */
    public OCCServiceHelper(Context context, Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, boolean uiRelated) {
        this(context, configuration, new VolleyPersistenceManager(context, sslSocketFactory, hostnameVerifier), new JsonDataConverter() {

            @Override
            public String createErrorMessage(String errorMessage, String errorType) {
                return JsonUtils.createErrorMessageFromOCC(errorMessage, errorType);
            }

        }, uiRelated);
    }

    /**
     * Constructor using volley as the persistence manager and json for conversion
     *
     * @param context       the android context
     * @param configuration the configuration objects containing informations for the backend to use
     * @param uiRelated     flag to optimize performances in case the work is not UI related. Must be true if used on UI screens, false for only background jobs (sync job, etc.)
     */
    public OCCServiceHelper(Context context, Configuration configuration, boolean uiRelated) {
        this(context, configuration, new VolleyPersistenceManager(context, null, null), new JsonDataConverter() {

            @Override
            public String createErrorMessage(String errorMessage, String errorType) {
                return JsonUtils.createErrorMessageFromOCC(errorMessage, errorType);
            }

        }, uiRelated);
    }

    @Override
    public boolean authenticate(final ResponseReceiverEmpty responseReceiver, final String requestId, final QueryLogin queryLogin,
                                final boolean shouldUseCache, final List<View> viewsToDisable, final OnRequestListener onRequestListener) {

        if (queryLogin == null || StringUtils.isBlank(queryLogin.getUsername())) {
            throw new IllegalArgumentException("The username parameter is missing from the query");
        }

        Map<String, Object> parameters = buildLoginParameters(queryLogin, Constants.Login.CLIENT_ID, Constants.Login.GRANT_TYPE_LOGIN);

        // Constructing the headers map
        Map<String, String> headers = new HashMap<>();
        String authValue = "Basic " + Base64.encodeToString(Constants.Login.AUTHORIZATION.getBytes(), Base64.NO_WRAP);
        headers.put(Constants.Login.PARAM_HEADER_AUTHORIZATION, authValue);

        // We want to save the user information before sending back the result
        ResponseReceiver<UserInformation> responseReceiverBeforeCallback = new ResponseReceiver<UserInformation>() {

            @Override
            public void onResponse(Response<UserInformation> response) {
                // Saving the user information for future authorized requests
                saveUserInformation(response.getData(), queryLogin.getUsername());

                responseReceiver.onResponse(Response.createResponse(new EmptyResponse(), requestId, true));
            }

            @Override
            public void onError(Response<ErrorList> response) {
                responseReceiver.onError(response);
            }
        };

        return execute(responseReceiverBeforeCallback, DataConverter.Helper.build(UserInformation.class, ErrorList.class, null),
                shouldUseCache, requestId, UrlHelper.getWebserviceTokenUrl(mContext, mConfiguration), parameters, headers, false,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean setClientRoleForGuest(final ResponseReceiverEmpty responseReceiver, final String requestId, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        if (!mUserInformation.isAnonymous()) {
            throw new IllegalStateException("A user is currently logged in, please log out or use the associated method for logged in user setTrustedClientRoleForUser(...).");
        }

        Map<String, Object> parameters = buildLoginParameters(null, Constants.Login.CLIENT_ID, Constants.Login.GRANT_TYPE_ROLE_CLIENT);

        // We want to save the token before returning the response
        ResponseReceiver<UserInformation> responseReceiverBeforeCallback = new ResponseReceiver<UserInformation>() {
            @Override
            public void onResponse(Response<UserInformation> response) {
                saveUserInformation(response.getData(), mUserInformation.getUserId());

                responseReceiver.onResponse(Response.createResponse(new EmptyResponse(), requestId, true));
            }

            @Override
            public void onError(Response<ErrorList> response) {
                responseReceiver.onError(response);
            }
        };

        return execute(responseReceiverBeforeCallback, DataConverter.Helper.build(UserInformation.class, ErrorList.class, null),
                shouldUseCache, requestId, UrlHelper.getWebserviceTokenUrl(mContext, mConfiguration), parameters, null, false,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);

    }

    @Override
    public boolean logout() {
        Log.i(TAG, "Logging out");
        deleteUserInformation();
        deleteCatalogData();
        cancelAll();
        return true;
    }

    @Override
    public boolean getCardTypes(ResponseReceiver<CardTypeList> responseReceiver, String requestId, boolean shouldUseCache,
                                List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(CardTypeList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_card_types), null, null, false,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCatalogs(ResponseReceiver<CatalogList> responseReceiver, String requestId, boolean shouldUseCache,
                               List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(CatalogList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_catalogs), null, null, false,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCatalog(ResponseReceiver<Catalog> responseReceiver, String requestId, QueryCatalog queryCatalog,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        if (queryCatalog == null || StringUtils.isBlank(queryCatalog.getCatalogId())) {
            throw new IllegalArgumentException("The catalog id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Catalog.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_catalog, queryCatalog.getCatalogId()), null, null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);

    }

    @Override
    public boolean getCatalogVersion(ResponseReceiver<CatalogVersion> responseReceiver, String requestId, QueryCatalog queryCatalog,
                                     boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        if (queryCatalog == null || StringUtils.isBlank(queryCatalog.getCatalogId()) || StringUtils.isBlank(queryCatalog.getCatalogVersionId())) {
            throw new IllegalArgumentException("The catalog id and/or catalog version parameter(s) is/are missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(CatalogVersion.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_catalog_version,
                        queryCatalog.getCatalogId(), queryCatalog.getCatalogVersionId()), null, null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);

    }

    @Override
    public boolean getCatalogCategory(ResponseReceiver<CategoryHierarchy> responseReceiver, String requestId,
                                      QueryCatalog queryCatalog,
                                      boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryCatalog == null || StringUtils.isBlank(queryCatalog.getCatalogId()) || StringUtils
                .isBlank(queryCatalog.getCatalogVersionId()) || StringUtils.isBlank(queryCatalog.getCatalogCategoryId())) {
            throw new IllegalArgumentException("The catalog id and/or catalog version and/or category id parameter(s) is/are missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(CategoryHierarchy.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_catalog_category,
                        queryCatalog.getCatalogId(), queryCatalog.getCatalogVersionId(), queryCatalog.getCatalogCategoryId()), null,
                null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }


    @Override
    public boolean getCurrencies(ResponseReceiver<CurrencyList> responseReceiver, String requestId, boolean shouldUseCache,
                                 List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(CurrencyList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_currencies), null, null, false,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCustomerGroups(ResponseReceiver<UserGroupList> responseReceiver, String requestId, boolean shouldUseCache,
                                     List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(UserGroupList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_customers_groups), null, null,
                true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean createCustomerGroup(ResponseReceiverEmpty responseReceiver, String requestId,
                                       QueryCustomerGroup queryCustomerGroup, boolean shouldUseCache, List<View> viewsToDisable,
                                       OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_customers_groups),
                MapUtils.toMap(queryCustomerGroup), null, true, HttpUtils.HTTP_METHOD_POST,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCustomerGroup(ResponseReceiver<UserGroup> responseReceiver, String requestId,
                                    QueryCustomerGroup queryCustomerGroup, boolean shouldUseCache, List<View> viewsToDisable,
                                    OnRequestListener onRequestListener) {

        if (queryCustomerGroup == null || StringUtils.isBlank(queryCustomerGroup.getGroupId())) {
            throw new IllegalArgumentException("The group id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(UserGroup.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper
                        .getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_customers_group, queryCustomerGroup.getGroupId()),
                null, null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean setCustomerGroupMembers(ResponseReceiverEmpty responseReceiver, String requestId,
                                           QueryCustomerGroup queryCustomerGroup, boolean shouldUseCache, List<View> viewsToDisable,
                                           OnRequestListener onRequestListener) {
        if (queryCustomerGroup == null || StringUtils.isBlank(queryCustomerGroup.getGroupId())) {
            throw new IllegalArgumentException("The group id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_customers_group_members,
                        queryCustomerGroup.getGroupId()), buildCustomerGroupsParameter(queryCustomerGroup), null, true, HttpUtils.HTTP_METHOD_PUT,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCustomerGroupMembers(ResponseReceiverEmpty responseReceiver, String requestId,
                                              QueryCustomerGroup queryCustomerGroup, boolean shouldUseCache, List<View> viewsToDisable,
                                              OnRequestListener onRequestListener) {
        if (queryCustomerGroup == null || StringUtils.isBlank(queryCustomerGroup.getGroupId())) {
            throw new IllegalArgumentException("The group id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_customers_group_members,
                        queryCustomerGroup.getGroupId()), buildCustomerGroupsParameter(queryCustomerGroup), null, true, HttpUtils.HTTP_METHOD_PATCH,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteCustomerGroupMembers(ResponseReceiverEmpty responseReceiver, String requestId,
                                              QueryCustomerGroup queryCustomerGroup, boolean shouldUseCache, List<View> viewsToDisable,
                                              OnRequestListener onRequestListener) {
        if (queryCustomerGroup == null || StringUtils.isBlank(queryCustomerGroup.getGroupId()) || StringUtils
                .isBlank(queryCustomerGroup.getUserId())) {
            throw new IllegalArgumentException("The group id and/or user id parameter(s) is/are missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_customers_group_members_user,
                        queryCustomerGroup.getGroupId(), queryCustomerGroup.getUserId()), null, null, true, HttpUtils.HTTP_METHOD_DELETE,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getDeliveryCountries(ResponseReceiver<CountryList> responseReceiver, String requestId, boolean shouldUseCache,
                                        List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(CountryList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_delivery_countries), null, null,
                false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getExportProducts(ResponseReceiver<ProductList> responseReceiver, String requestId,
                                     QueryExportProducts queryExportProducts, boolean shouldUseCache, List<View> viewsToDisable,
                                     OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(ProductList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_export_products),
                MapUtils.toMap(queryExportProducts), null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getOrdersFeeds(ResponseReceiver<OrderStatusUpdateElementList> responseReceiver, String requestId,
                                  QueryOrdersFeeds queryOrdersFeeds, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(OrderStatusUpdateElementList.class, ErrorList.class, null),
                shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_feeds_orders),
                MapUtils.toMap(queryOrdersFeeds), null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean generateForgottenPasswordTokens(ResponseReceiverEmpty responseReceiver, String requestId,
                                                   QueryForgottenPassword queryForgottenPassword, boolean shouldUseCache, List<View> viewsToDisable,
                                                   OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_forgotten_password_tokens),
                MapUtils.toMap(queryForgottenPassword), null, true, HttpUtils.HTTP_METHOD_POST,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getLanguages(ResponseReceiver<LanguageList> responseReceiver, String requestId, boolean shouldUseCache,
                                List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(LanguageList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_languages), null, null, false,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProductsExpressUpdate(ResponseReceiver<ProductExpressUpdateElementList> responseReceiver, String requestId,
                                            QueryExportProducts queryExportProducts, boolean shouldUseCache, List<View> viewsToDisable,
                                            OnRequestListener onRequestListener) {
        if (queryExportProducts != null && StringUtils.isNotBlank(queryExportProducts.getCatalog()) && StringUtils
                .isNotBlank(queryExportProducts.getVersion())) {
            // Catalog format: catalogId:catalogVersion
            queryExportProducts.setCatalog(queryExportProducts.getCatalog() + ":" + queryExportProducts.getVersion());
        }

        return execute(responseReceiver, DataConverter.Helper.build(ProductExpressUpdateElementList.class, ErrorList.class, null),
                shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_products_express_update),
                MapUtils.toMap(queryExportProducts), null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean countProducts(ResponseReceiver<Count> responseReceiver, String requestId, QueryProducts queryProducts,
                                 boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        // Getting the facets from the query object
        StringBuilder query = new StringBuilder();

        if (queryProducts != null) {
            // Free text
            if (StringUtils.isNotBlank(queryProducts.getQuery())) {
                query.append(queryProducts.getQuery());
            }
            // Category
            else if (StringUtils.isNotBlank(queryProducts.getIdCategory())) {
                query.append(queryProducts.getIdCategory());
            }

            // Sort
            if (StringUtils.isNotBlank(queryProducts.getSort())) {
                query.append(":").append(queryProducts.getSort());
            }

            // Facets
            if (queryProducts.getQueryFacets() != null) {
                for (QueryProducts.QueryFacet queryFacet : queryProducts.getQueryFacets()) {
                    query.append(":").append(queryFacet.getName()).append(":").append(queryFacet.getValue());
                }
            }

            queryProducts.setQuery(query.toString());
        } else {
            queryProducts = new QueryProducts();
        }

        return execute(responseReceiver, DataConverter.Helper.build(Count.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_products),
                MapUtils.toMap(queryProducts), null, false, HttpUtils.HTTP_METHOD_HEAD,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProductsSuggestions(ResponseReceiver<SuggestionList> responseReceiver, String requestId,
                                          QueryProductSuggestions queryProductSuggestions, boolean shouldUseCache, List<View> viewsToDisable,
                                          OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(SuggestionList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_products_suggestions),
                MapUtils.toMap(queryProductSuggestions), null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProduct(ResponseReceiver<Product> responseReceiver, String requestId,
                              QueryProduct queryProduct, boolean shouldUseCache, List<View> viewsToDisable,
                              OnRequestListener onRequestListener) {

        if (queryProduct == null || StringUtils.isBlank(queryProduct.getCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Product.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product,
                        queryProduct.getCode()), null, null, false, HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProductReferences(ResponseReceiver<ProductReferenceList> responseReceiver, String requestId,
                                        QueryProductReference queryProductReference, boolean shouldUseCache, List<View> viewsToDisable,
                                        OnRequestListener onRequestListener) {
        if (queryProductReference == null || StringUtils.isBlank(queryProductReference.getProductCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(ProductReferenceList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product_references,
                        queryProductReference.getProductCode()), MapUtils.toMap(queryProductReference), null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProductReviews(ResponseReceiver<ReviewList> responseReceiver, String requestId, QueryProduct queryProduct,
                                     boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryProduct == null || StringUtils.isBlank(queryProduct.getCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(ReviewList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product_reviews, queryProduct.getCode()),
                null, null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean setProductReview(ResponseReceiver<Review> responseReceiver, String requestId,
                                    QueryProductReview queryProductReview, boolean shouldUseCache, List<View> viewsToDisable,
                                    OnRequestListener onRequestListener) {
        if (queryProductReview == null || StringUtils.isBlank(queryProductReview.getProductCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Review.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product_reviews,
                        queryProductReview.getProductCode()), MapUtils.toMap(queryProductReview), null, false, HttpUtils.HTTP_METHOD_POST,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean countProductStock(ResponseReceiver<Count> responseReceiver, String requestId,
                                     QueryProductStock queryProductStock, boolean shouldUseCache, List<View> viewsToDisable,
                                     OnRequestListener onRequestListener) {
        if (queryProductStock == null || StringUtils.isBlank(queryProductStock.getProductCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Count.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper
                        .getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product_stock, queryProductStock.getProductCode()),
                MapUtils.toMap(queryProductStock), null, false, HttpUtils.HTTP_METHOD_HEAD,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProductStock(ResponseReceiver<StoreFinderStockSearchPage> responseReceiver, String requestId,
                                   QueryProductStock queryProductStock, boolean shouldUseCache, List<View> viewsToDisable,
                                   OnRequestListener onRequestListener) {
        if (queryProductStock == null || StringUtils.isBlank(queryProductStock.getProductCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(StoreFinderStockSearchPage.class, ErrorList.class, null),
                shouldUseCache,
                requestId, UrlHelper
                        .getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product_stock, queryProductStock.getProductCode()),
                MapUtils.toMap(queryProductStock), null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProductStoreStock(ResponseReceiver<Stock> responseReceiver, String requestId,
                                        QueryProductStock queryProductStock, boolean shouldUseCache, List<View> viewsToDisable,
                                        OnRequestListener onRequestListener) {
        if (queryProductStock == null || StringUtils.isBlank(queryProductStock.getProductCode())) {
            throw new IllegalArgumentException("The product code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Stock.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper
                        .getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_product_stock, queryProductStock.getProductCode()),
                MapUtils.toMap(queryProductStock), null, false, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean countStores(ResponseReceiver<Count> responseReceiver, String requestId, QueryStores queryStores,
                               boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Count.class, ErrorList.class), shouldUseCache, requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_stores), buildStoresParameter(queryStores),
                null, false,
                HttpUtils.HTTP_METHOD_HEAD, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getPromotions(ResponseReceiver<PromotionList> responseReceiver, String requestId,
                                 QueryPromotions queryPromotions, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(PromotionList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_promotions),
                MapUtils.toMap(queryPromotions), null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getPromotion(ResponseReceiver<Promotion> responseReceiver, String requestId, QueryPromotion queryPromotion,
                                boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPromotion == null || StringUtils.isBlank(queryPromotion.getPromotionId())) {
            throw new IllegalArgumentException("The promotion id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Promotion.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_promotion, queryPromotion.getPromotionId()),
                null, null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getStores(ResponseReceiver<StoreFinderSearchPage> responseReceiver, String requestId, QueryStores queryStores,
                             boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(StoreFinderSearchPage.class, ErrorList.class), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_stores), buildStoresParameter(queryStores),
                null, false,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getStore(ResponseReceiver<PointOfService> responseReceiver, String requestId,
                            QueryStore queryStore, boolean shouldUseCache, List<View> viewsToDisable,
                            OnRequestListener onRequestListener) {

        if (queryStore == null || StringUtils.isBlank(queryStore.getStoreName())) {
            throw new IllegalArgumentException("The store name parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(PointOfService.class, ErrorList.class), shouldUseCache, requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_store, HttpUtils.encode(
                        queryStore.getStoreName())), null, null, false, HttpUtils.HTTP_METHOD_GET, viewsToDisable,
                onRequestListener);
    }

    @Override
    public boolean getTitles(ResponseReceiver<TitleList> responseReceiver, String requestId, boolean shouldUseCache,
                             List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(TitleList.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_titles), null, null, false,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean registerUser(ResponseReceiverEmpty responseReceiver, String requestId, QueryCreateUser queryCreateUser,
                                boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_users),
                MapUtils.toMap(queryCreateUser), null, true, HttpUtils.HTTP_METHOD_POST,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getUserProfile(final ResponseReceiver<User> responseReceiver, final String requestId,
                                  SpecificUser specificUser, final boolean shouldUseCache, final List<View> viewsToDisable, final OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(User.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user,
                        getDefaultUserId(specificUser)), null, null, true, HttpUtils.HTTP_METHOD_GET, viewsToDisable,
                onRequestListener);
    }

    @Override
    public boolean replaceUserProfile(ResponseReceiverEmpty responseReceiver, String requestId, QueryUser queryUser,
                                      SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user,
                        getDefaultUserId(specificUser)), MapUtils.toMap(queryUser), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateUserProfile(ResponseReceiverEmpty responseReceiver, String requestId, QueryUser queryUser,
                                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user,
                        getDefaultUserId(specificUser)), MapUtils.toMap(queryUser), null, true,
                HttpUtils.HTTP_METHOD_PATCH, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteUserProfile(ResponseReceiverEmpty responseReceiver, String requestId, SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user, getDefaultUserId(specificUser)),
                null, null, true, HttpUtils.HTTP_METHOD_DELETE,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getUserAddresses(ResponseReceiver<AddressList> responseReceiver, String requestId, SpecificUser specificUser,
                                    boolean shouldUseCache,
                                    List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(AddressList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_addresses,
                        getDefaultUserId(specificUser)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean createUserAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress,
                                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Address.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper
                        .getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_addresses, getDefaultUserId(specificUser)),
                buildAddressesParameter(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean verifyUserAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress,
                                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Address.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper
                        .getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_addresses, getDefaultUserId(specificUser)),
                buildAddressesParameter(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getUserAddress(ResponseReceiver<Address> responseReceiver, String requestId, QueryAddress queryAddress,
                                  SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        if (queryAddress == null || StringUtils.isBlank(queryAddress.getAddressId())) {
            throw new IllegalArgumentException("The address id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Address.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_address, getDefaultUserId(specificUser),
                        queryAddress.getAddressId()), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean replaceUserAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                                      SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryAddress == null || StringUtils.isBlank(queryAddress.getAddressId())) {
            throw new IllegalArgumentException("The address id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_address,
                        getDefaultUserId(specificUser), queryAddress.getAddressId()), buildAddressesParameter(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateUserAddress(ResponseReceiverEmpty responseReceiver, String requestId,
                                     QueryAddress queryAddress, SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryAddress == null || StringUtils.isBlank(queryAddress.getAddressId())) {
            throw new IllegalArgumentException("The address id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_address,
                        getDefaultUserId(specificUser), queryAddress.getAddressId()), buildAddressesParameter(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_PATCH, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteUserAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                                     SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryAddress == null || StringUtils.isBlank(queryAddress.getAddressId())) {
            throw new IllegalArgumentException("The address id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_address,
                        getDefaultUserId(specificUser), queryAddress.getAddressId()), MapUtils.toMap(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCarts(ResponseReceiver<CartList> responseReceiver, String requestId, QueryCarts queryCarts,
                            SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(CartList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_carts, getDefaultUserId(specificUser)),
                MapUtils.toMap(queryCarts), null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean createCart(ResponseReceiver<Cart> responseReceiver, String requestId, QueryCartCreate queryCartCreate, SpecificUser specificUser, boolean shouldUseCache,
                              List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Cart.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_carts, getDefaultUserId(specificUser)),
                MapUtils.toMap(queryCartCreate), null, true, HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCart(final ResponseReceiver<Cart> responseReceiver, final String requestId, final SpecificCart specificCart, final boolean shouldUseCache, final List<View> viewsToDisable, final OnRequestListener onRequestListener) {

        // If a specific cart is specified, we retrieve it
        if (specificCart != null && StringUtils.isNotBlank(specificCart.getCartId())) {
            return execute(responseReceiver, DataConverter.Helper.build(Cart.class, ErrorList.class, null),
                    shouldUseCache,
                    requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart,
                            getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                    HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);

        }
        // If a cart already exists for the user, we retrieve it
        else if (StringUtils.isNotBlank(getDefaultCartId(specificCart))) {
            ResponseReceiver<Cart> responseReceiverGetCart = new ResponseReceiver<Cart>() {

                @Override
                public void onResponse(Response<Cart> response) {
                    responseReceiver.onResponse(response);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    // Error with the cart, we delete the reference and we re-call the method to get an updated cart
                    mUserInformation.setCartId(null);

                    // Re-calling the method to get an updated cart
                    getCart(responseReceiver, requestId, null, shouldUseCache, viewsToDisable, onRequestListener);
                }
            };

            // Getting the cart saved on the user information
            return execute(responseReceiverGetCart, DataConverter.Helper.build(Cart.class, ErrorList.class, null),
                    shouldUseCache,
                    requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart,
                            getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                    HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
        }
        // No saved cart, we get the user's current cart if any or we create a default one
        else {

            ResponseReceiver<Cart> responseReceiverGetCurrentCart = new ResponseReceiver<Cart>() {

                @Override
                public void onResponse(Response<Cart> response) {
                    // Saving the cart information and re-calling the method to get the cart from the user information
                    if (mUserInformation.isAnonymous()) {
                        mUserInformation.setCartId(response.getData().getGuid());
                    } else {
                        mUserInformation.setCartId(response.getData().getCode());
                    }

                    getCart(responseReceiver, requestId, null, shouldUseCache, viewsToDisable, onRequestListener);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    ResponseReceiver<Cart> responseReceiverCreateCart = new ResponseReceiver<Cart>() {

                        @Override
                        public void onResponse(Response<Cart> response) {
                            // Saving the cart information and re-calling the method to get the cart from the user information
                            if (mUserInformation.isAnonymous()) {
                                mUserInformation.setCartId(response.getData().getGuid());
                            } else {
                                mUserInformation.setCartId(response.getData().getCode());
                            }

                            getCart(responseReceiver, requestId, null, shouldUseCache, viewsToDisable, onRequestListener);
                        }

                        @Override
                        public void onError(Response<ErrorList> response) {
                            responseReceiver.onError(response);
                        }
                    };

                    createCart(responseReceiverCreateCart, requestId, null, null, shouldUseCache, viewsToDisable, onRequestListener);
                }
            };

            // We retrieve the user's current cart
            return getCartDefault(responseReceiverGetCurrentCart, specificCart, shouldUseCache);
        }

    }

    @Override
    public boolean deleteCart(ResponseReceiverEmpty responseReceiver, String requestId, SpecificCart specificCart,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart, getDefaultUserId(specificCart),
                        getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean createCartDeliveryAddress(ResponseReceiver<Address> responseReceiver, String requestId,
                                             QueryAddress queryAddress, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Address.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_address,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), buildAddressesParameter(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCartDeliveryAddress(ResponseReceiverEmpty responseReceiver, String requestId, QueryAddress queryAddress,
                                             SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_address,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryAddress), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteCartDeliveryAddress(ResponseReceiverEmpty responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache,
                                             List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_address,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean cloneSavedCart(ResponseReceiverEmpty responseReceiver, String requestId, QueryCartClone queryCartClone,
                                  SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_clone,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryCartClone), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartDeliveryMode(ResponseReceiver<DeliveryMode> responseReceiver, String requestId,
                                       SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(DeliveryMode.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_mode,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCartDeliveryMode(ResponseReceiverEmpty responseReceiver, String requestId,
                                          QueryDeliveryMode queryDeliveryMode,
                                          SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_mode,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryDeliveryMode), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteCartDeliveryMode(ResponseReceiverEmpty responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache,
                                          List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_mode,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartDeliveryModes(ResponseReceiver<DeliveryModeList> responseReceiver, String requestId,
                                        SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(DeliveryModeList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_delivery_modes,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean setCartEmail(ResponseReceiverEmpty responseReceiver, String requestId, QueryCartEmail queryCartEmail,
                                SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_email,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryCartEmail), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartEntries(ResponseReceiver<OrderEntryList> responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache,
                                  List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(OrderEntryList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_entries,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartEntry(ResponseReceiver<OrderEntry> responseReceiver, String requestId,
                                QueryCartEntry queryCartEntry, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        if (queryCartEntry == null || StringUtils.isBlank(queryCartEntry.getEntryNumber())) {
            throw new IllegalArgumentException("The entry number parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(OrderEntry.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_entry,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart), queryCartEntry.getEntryNumber()), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteCartEntry(final ResponseReceiver<CartModification> responseReceiver, final String requestId,
                                   final QueryCartEntry queryCartEntry, SpecificCart specificCart, final boolean shouldUseCache, final List<View> viewsToDisable,
                                   final OnRequestListener onRequestListener) {
        return addUpdateDeleteProductToCart(CartActionEnum.DELETE, responseReceiver, requestId, queryCartEntry, specificCart, shouldUseCache,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean flagCartForDeletion(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, SpecificCart specificCart,
                                       boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(SaveCartResult.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_flag_deletion,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_PATCH, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean createCartPayment(ResponseReceiver<PaymentDetails> responseReceiver, String requestId,
                                     QueryPayment queryPayment, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(PaymentDetails.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_payment,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), buildPaymentsParameter(queryPayment), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCartPayment(ResponseReceiverEmpty responseReceiver, String requestId,
                                     QueryPayment queryPayment, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_payment,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), buildPaymentsParameter(queryPayment), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartPromotions(ResponseReceiver<PromotionResultList> responseReceiver, String requestId,
                                     SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(PromotionResultList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_promotions,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean setCartPromotion(ResponseReceiverEmpty responseReceiver, String requestId, QueryPromotion queryPromotion,
                                    SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_promotions,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryPromotion), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartPromotion(ResponseReceiver<PromotionResult> responseReceiver, String requestId,
                                    QueryPromotion queryPromotion, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPromotion == null || StringUtils.isBlank(queryPromotion.getPromotionId())) {
            throw new IllegalArgumentException("The promotion id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(PromotionResult.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_promotion,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart), queryPromotion.getPromotionId()), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteCartPromotion(ResponseReceiverEmpty responseReceiver, String requestId, QueryPromotion queryPromotion,
                                       SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPromotion == null || StringUtils.isBlank(queryPromotion.getPromotionId())) {
            throw new IllegalArgumentException("The promotion id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_promotion,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart), queryPromotion.getPromotionId()), null, null, true,
                HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean restoreSavedCart(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, SpecificCart specificCart,
                                    boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(SaveCartResult.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_restore_saved_cart,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_PATCH, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean saveCart(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, QuerySaveCart querySaveCart,
                            SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(SaveCartResult.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_save,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(querySaveCart), null, true,
                HttpUtils.HTTP_METHOD_PATCH, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getSavedCart(ResponseReceiver<SaveCartResult> responseReceiver, String requestId, SpecificCart specificCart,
                                boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(SaveCartResult.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_saved_cart,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getCartVouchers(ResponseReceiver<VoucherList> responseReceiver, String requestId, SpecificCart specificCart, boolean shouldUseCache,
                                   List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(VoucherList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_vouchers,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean setCartVoucher(ResponseReceiverEmpty responseReceiver, String requestId, QueryVoucher queryVoucher,
                                  SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_vouchers,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryVoucher), null, true,
                HttpUtils.HTTP_METHOD_POST, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteCartVoucher(ResponseReceiverEmpty responseReceiver, String requestId, QueryVoucher queryVoucher,
                                     SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_vouchers,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryVoucher), null, true,
                HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getUserCustomerGroups(ResponseReceiver<UserGroupList> responseReceiver, String requestId,
                                         SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(UserGroupList.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_customer_groups,
                        getDefaultUserId(specificUser)), null, null, true,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateUserLogin(ResponseReceiverEmpty responseReceiver, String requestId, QueryNewLogin queryNewLogin,
                                   SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_user_login,
                        getDefaultUserId(specificUser)), MapUtils.toMap(queryNewLogin), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean countOrders(ResponseReceiver<Count> responseReceiver, String requestId, QueryOrders queryOrders,
                               SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Count.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_orders,
                        getDefaultUserId(specificUser)), MapUtils.toMap(queryOrders), null, true,
                HttpUtils.HTTP_METHOD_HEAD, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean placeOrder(final ResponseReceiver<Order> responseReceiver, String requestId, QueryPlaceOrder queryPlaceOrder,
                              SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        Map<String, Object> parameters = new HashMap<>();

        if (queryPlaceOrder != null) {
            parameters = MapUtils.toMap(queryPlaceOrder);
        }

        parameters.put("cartId", getDefaultCartId(specificCart));

        //  We want to remove the  current cart reference before sending back the result
        ResponseReceiver<Order> responseReceiverPlaceOrder = new ResponseReceiver<Order>() {

            @Override
            public void onResponse(Response<Order> response) {
                mUserInformation.setCartId(null);
                responseReceiver.onResponse(response);
            }

            @Override
            public void onError(Response<ErrorList> response) {
                responseReceiver.onError(response);
            }
        };

        return execute(responseReceiverPlaceOrder, DataConverter.Helper.build(Order.class, ErrorList.class, null),
                shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_orders,
                        getDefaultUserId(specificCart)), parameters, null, true, HttpUtils.HTTP_METHOD_POST, viewsToDisable,
                onRequestListener);
    }

    @Override
    public boolean getOrder(ResponseReceiver<Order> responseReceiver, String requestId, QueryOrder queryOrder,
                            SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        if (queryOrder == null || StringUtils.isBlank(queryOrder.getCode())) {
            throw new IllegalArgumentException("The code parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Order.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_order,
                        getDefaultUserId(specificUser), queryOrder.getCode()), null, null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getOrders(ResponseReceiver<OrderHistoryList> responseReceiver, String requestId,
                             QueryOrders queryOrders, SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable,
                             OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(OrderHistoryList.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_orders, getDefaultUserId(specificUser)), MapUtils.toMap(queryOrders), null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateUserPassword(ResponseReceiverEmpty responseReceiver, String requestId, QueryNewPassword queryNewPassword,
                                      SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {

        Map<String, Object> parameters = MapUtils.toMap(queryNewPassword);

        if (queryNewPassword != null) {
            parameters.put("new", queryNewPassword.getNewPassword());
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_user_password, getDefaultUserId(specificUser)), parameters, null, true, HttpUtils.HTTP_METHOD_PUT,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getUserPaymentDetailsList(ResponseReceiver<PaymentDetailsList> responseReceiver, String requestId,
                                             QueryPayments queryPayments, SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(PaymentDetailsList.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_user_payments, getDefaultUserId(specificUser)), MapUtils.toMap(queryPayments), null, true,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getUserPaymentDetails(ResponseReceiver<PaymentDetails> responseReceiver, String requestId, QueryPayment queryPayment,
                                         SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPayment == null || StringUtils.isBlank(queryPayment.getPaymentDetailsId())) {
            throw new IllegalArgumentException("The payment details id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(PaymentDetails.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_user_payment, getDefaultUserId(specificUser), queryPayment.getPaymentDetailsId()), null, null, true,
                HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean replaceUserPaymentDetails(ResponseReceiverEmpty responseReceiver, String requestId, QueryPayment queryPayment,
                                             SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPayment == null || StringUtils.isBlank(queryPayment.getPaymentDetailsId())) {
            throw new IllegalArgumentException("The payment details id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_user_payment, getDefaultUserId(specificUser), queryPayment.getPaymentDetailsId()),
                buildPaymentsParameter(queryPayment), null, true, HttpUtils.HTTP_METHOD_PUT,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateUserPaymentDetails(ResponseReceiverEmpty responseReceiver, String requestId,
                                            QueryPayment queryPayment, SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPayment == null || StringUtils.isBlank(queryPayment.getPaymentDetailsId())) {
            throw new IllegalArgumentException("The payment details id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_user_payment, getDefaultUserId(specificUser), queryPayment.getPaymentDetailsId()),
                buildPaymentsParameter(queryPayment), null, true, HttpUtils.HTTP_METHOD_PATCH,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean deleteUserPaymentDetails(ResponseReceiverEmpty responseReceiver, String requestId, QueryPayment queryPayment,
                                            SpecificUser specificUser, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryPayment == null || StringUtils.isBlank(queryPayment.getPaymentDetailsId())) {
            throw new IllegalArgumentException("The payment details id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(EmptyResponse.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_user_payment, getDefaultUserId(specificUser), queryPayment.getPaymentDetailsId()), null, null, true,
                HttpUtils.HTTP_METHOD_DELETE,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getVoucher(ResponseReceiver<Voucher> responseReceiver, String requestId, QueryVoucher queryVoucher,
                              boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryVoucher == null || StringUtils.isBlank(queryVoucher.getVoucherId())) {
            throw new IllegalArgumentException("The voucher id parameter is missing from the query");
        }

        return execute(responseReceiver, DataConverter.Helper.build(Voucher.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_voucher, queryVoucher.getVoucherId()), null,
                null, true, HttpUtils.HTTP_METHOD_GET,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean loadImage(String url, String requestId, ImageView imageView, int width, int height, boolean shouldUseCache,
                             OnRequestListener onRequestListener, boolean forceImageTagToMatchRequestId) {

        if (StringUtils.isBlank(url) || imageView == null) {
            throw new IllegalArgumentException("The url and/or imageView parameter(s) is/are missing from the query");
        }

        // We set the image tag if we want the request id to match the tag before loading the image within the image view
        if (forceImageTagToMatchRequestId) {
            imageView.setTag(requestId);
        }

        return mPersistenceHelper.setImageFromUrl(UrlHelper.getImageUrl(mConfiguration, url), requestId, imageView,
                width, height, CONFIG_IMAGES_QUALITY, shouldUseCache, onRequestListener, forceImageTagToMatchRequestId);
    }

    @Override
    public void cancel(String requestId) {
        mPersistenceHelper.cancel(requestId);
    }

    @Override
    public void cancelAll() {
        mPersistenceHelper.cancelAll();
    }

    @Override
    public void pause() {
        mPersistenceHelper.pause();
    }

    @Override
    public void start() {
        mPersistenceHelper.start();
    }

    @Override
    public DataConverter getDataConverter() {
        return mDataConverter;
    }

    @Override
    public Configuration getConfiguration() {
        return mConfiguration;
    }

    @Override
    public void updateCache() {
        mPersistenceHelper.updateCache();
    }

    @Override
    public long getCatalogLastSyncDate() {
        return getSharedPreferences().getLong(CATALOG_LAST_SYNC_DATE, 0);
    }

    @Override
    public void saveCatalogLastSyncDate(long timeInMillis) {
        Editor editorSharedPreferences = getSharedPreferences().edit();
        editorSharedPreferences.putLong(CATALOG_LAST_SYNC_DATE, timeInMillis);
        editorSharedPreferences.apply();
    }

    @Override
    public void updateConfiguration(String url, String catalog, String catalogId, String catalogVersionId, String catalogMainCategoryId) {
        this.mConfiguration.setBackendUrl(url);
        this.mConfiguration.setCatalog(catalog);
        this.mConfiguration.setCatalogId(catalogId);
        this.mConfiguration.setCatalogVersionId(catalogVersionId);
        this.mConfiguration.setCatalogIdMainCategory(catalogMainCategoryId);
    }

    /**
     * Delete all the catalog data of the content provider
     */
    protected void deleteCatalogData() {
        try {
            mContext.getContentResolver().delete(CatalogContract.Provider.getUriData(mConfiguration.getCatalogAuthority()), null, null);
            mContext.getContentResolver()
                    .delete(CatalogContract.Provider.getUriDataDetails(mConfiguration.getCatalogAuthority()), null, null);
        } catch (IllegalArgumentException e) {
            Log.i(TAG, "Unable to delete catalog data. Details: " + e.getLocalizedMessage());
        }
    }

    /**
     * Refresh the user token
     *
     * @param responseReceiver Response callback result
     * @param refreshToken     Token to use to refresh the token
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    protected boolean refreshToken(ResponseReceiver<UserInformation> responseReceiver, String refreshToken) {
        if ((mUserInformation == null || mUserInformation.isTokenExpired() || mUserInformation.isTokenInvalid()) && StringUtils.isNotBlank(refreshToken)) {

            Map<String, Object> parameters = buildLoginParameters(null, Constants.Login.CLIENT_ID, Constants.Login.GRANT_TYPE_TOKEN);
            parameters.put(Constants.Login.PARAM_REFRESH_TOKEN, refreshToken);

            return execute(responseReceiver, DataConverter.Helper.build(UserInformation.class, ErrorList.class, null), false,
                    null, UrlHelper.getWebserviceTokenUrl(mContext, mConfiguration), parameters, null, false,
                    HttpUtils.HTTP_METHOD_POST, null, null);
        } else if (responseReceiver != null) {
            responseReceiver.onResponse(Response.createResponse(mUserInformation, null, true));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Send a broadcast message for logout
     */
    protected void sendLogoutBroadcast() {
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(new Intent(mContext.getString(R.string.intent_action_logout)));
    }

    /**
     * Add, Update, or Delete a product
     *
     * @param cartActionEnum    The action: ADD, UPDATE, DELETE
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartEntry    Parameters needed for the request
     * @param specificCart      specific cart to use
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent    @return true if no error in the process of executing this method. Note that this does not mean whether or not the
     *                          request was a success.
     * @throws IllegalArgumentException
     */
    protected boolean addUpdateDeleteProductToCart(final CartActionEnum cartActionEnum,
                                                   final ResponseReceiver<CartModification> responseReceiver, final String requestId, final QueryCartEntry queryCartEntry,
                                                   final SpecificCart specificCart, final boolean shouldUseCache, final List<View> viewsToDisable, final OnRequestListener onRequestListener) {

        if (!cartActionEnum.equals(CartActionEnum.ADD) && StringUtils.isBlank(queryCartEntry.getEntryNumber())) {
            throw new IllegalArgumentException("The entry number parameter is missing from the query");
        }

        // We get the user's cart first if it was not already pulled
        if (StringUtils.isBlank(getDefaultCartId(specificCart))) {

            ResponseReceiver<Cart> responseReceiverGetCart = new ResponseReceiver<Cart>() {

                @Override
                public void onResponse(Response<Cart> response) {
                    addUpdateDeleteProductToCart(cartActionEnum, responseReceiver, requestId, queryCartEntry, specificCart, shouldUseCache,
                            viewsToDisable, onRequestListener);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    responseReceiver.onError(response);
                }
            };

            return getCart(responseReceiverGetCart, requestId, null, shouldUseCache, viewsToDisable, onRequestListener);
        } else {

            // Intermediate receiver to handle errors
            ResponseReceiver<CartModification> responseReceiverCheckErrors = new ResponseReceiver<CartModification>() {

                @Override
                public void onResponse(Response<CartModification> response) {
                    responseReceiver.onResponse(response);
                }

                @Override
                public void onError(Response<ErrorList> response) {

                    Error firstError = response.getData().getErrors() != null && !response.getData().getErrors().isEmpty() ? response.getData().getErrors().get(0) : null;

                    // Cart not found error, probably because the cart had been checked out from another endpoint
                    if (firstError != null && StringUtils.equals(firstError.getReason(),
                            Constants.ERROR_REASON_CART_NOT_FOUND) && StringUtils.equals(
                            firstError.getType(), Constants.ERROR_TYPE_CART_ERROR)) {
                        // We reset the cart and re-call the method
                        mUserInformation.setCartId(null);
                        addUpdateDeleteProductToCart(cartActionEnum, responseReceiver, requestId, queryCartEntry, specificCart, shouldUseCache,
                                viewsToDisable, onRequestListener);
                    } else {
                        responseReceiver.onError(response);
                    }
                }
            };

            boolean returnResult = true;

            // Constructing the parameters map
            final Map<String, Object> parameters = MapUtils.toMap(queryCartEntry);

            switch (cartActionEnum) {
                case ADD:

                    returnResult = execute(responseReceiverCheckErrors, DataConverter.Helper.build(CartModification.class,
                            ErrorList.class, null), shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl
                                    (mContext,
                                            mConfiguration, R.string.path_cart_entries, getDefaultUserId(specificCart),
                                            getDefaultCartId(specificCart)), parameters, null, true, HttpUtils.HTTP_METHOD_POST,
                            viewsToDisable, onRequestListener);
                    break;

                case UPDATE:

                    returnResult = execute(responseReceiverCheckErrors, DataConverter.Helper.build(CartModification.class,
                            ErrorList.class, null), shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl
                                    (mContext,
                                            mConfiguration, R.string.path_cart_entry, getDefaultUserId(specificCart),
                                            getDefaultCartId(specificCart), queryCartEntry.getEntryNumber()), parameters, null, true,
                            HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
                    break;

                case UPDATE_ONLY_ATTRIBUTES:

                    returnResult = execute(responseReceiverCheckErrors, DataConverter.Helper.build(CartModification.class,
                            ErrorList.class, null), shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl
                                    (mContext,
                                            mConfiguration, R.string.path_cart_entry, getDefaultUserId(specificCart),
                                            getDefaultCartId(specificCart), queryCartEntry.getEntryNumber()), parameters, null, true,
                            HttpUtils.HTTP_METHOD_PATCH, viewsToDisable, onRequestListener);
                    break;

                case DELETE:
                    returnResult = execute(responseReceiverCheckErrors, DataConverter.Helper.build(CartModification.class,
                            ErrorList.class, null), shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl
                                    (mContext,
                                            mConfiguration, R.string.path_cart_entry, getDefaultUserId(specificCart),
                                            getDefaultCartId(specificCart), queryCartEntry.getEntryNumber()), null, null, true,
                            HttpUtils.HTTP_METHOD_DELETE, viewsToDisable, onRequestListener);
                    break;

                default:
                    break;
            }

            return returnResult;
        }
    }

    /**
     * Get the user's current cart or create a new one for anonymous user
     *
     * @param responseReceiver Response callback result
     * @param specificCart     overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache   Indicator to use cache or not  @return true if request is executed else false
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    protected boolean getCartDefault(ResponseReceiver<Cart> responseReceiver, SpecificCart specificCart, boolean shouldUseCache) {

        if (mUserInformation.isAnonymous()) {
            return createCart(responseReceiver, null, null, null, shouldUseCache, null, null);
        } else {
            return execute(responseReceiver, DataConverter.Helper.build(Cart.class, ErrorList.class, null), shouldUseCache, null,
                    UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart,
                            getDefaultUserId(specificCart), SpecificCart.CartId.CURRENT.getValue()), null, null, true, HttpUtils.HTTP_METHOD_GET, null, null);
        }
    }

    /**
     * Convert the query object to a parameter of map
     *
     * @param queryStores the query
     * @return the map parameters
     */
    protected Map<String, Object> buildStoresParameter(QueryStores queryStores) {
        Map<String, Object> parameters = new HashMap<>();

        if (queryStores != null) {

            parameters = MapUtils.toMap(queryStores);

            // Free text search
            if (StringUtils.isNotBlank(queryStores.getSearchText())) {
                parameters.put("query", queryStores.getSearchText());
            }
        }

        return parameters;
    }

    /**
     * Convert the query object to a parameter of map
     *
     * @param queryAddress the query
     * @return the map parameters
     */
    protected Map<String, Object> buildAddressesParameter(QueryAddress queryAddress) {
        Map<String, Object> parameters = new HashMap<>();

        if (queryAddress != null) {

            parameters = MapUtils.toMap(queryAddress);
            parameters.put("country.isocode", queryAddress.getCountry().getIsocode());

            if (queryAddress.getRegion() != null && StringUtils.isNotBlank(queryAddress.getRegion().getIsocode())) {
                parameters.put("region.isocode", queryAddress.getRegion().getIsocode());
            }
        }

        return parameters;
    }

    /**
     * Convert the query object to a parameter of map
     *
     * @param queryCustomerGroup the query
     * @return the map parameters
     */
    protected Map<String, Object> buildCustomerGroupsParameter(QueryCustomerGroup queryCustomerGroup) {
        Map<String, Object> parameters = new HashMap<>();

        if (queryCustomerGroup != null) {
            parameters.put("members", queryCustomerGroup.getMembers().get(0));
        }

        return parameters;
    }

    /**
     * Convert the query object to a parameter of map
     *
     * @param queryPayment the query
     * @return the map parameters
     */
    protected Map<String, Object> buildPaymentsParameter(QueryPayment queryPayment) {
        Map<String, Object> parameters = new HashMap<>();

        if (queryPayment != null) {

            parameters = MapUtils.toMap(queryPayment);

            Address billingAddress = queryPayment.getBillingAddress();

            if (billingAddress != null) {
                parameters.put("billingAddress.country.isocode", billingAddress.getCountry().getIsocode());

                if (billingAddress.getRegion() != null && StringUtils.isNotBlank(billingAddress.getRegion().getIsocode())) {
                    parameters.put("region.isocode", billingAddress.getRegion().getIsocode());
                }

                parameters.put("billingAddress.companyName", billingAddress.getCompanyName());
                parameters.put("billingAddress.email", billingAddress.getEmail());
                parameters.put("billingAddress.firstName", billingAddress.getFirstName());
                parameters.put("billingAddress.formattedAddress", billingAddress.getFormattedAddress());
                parameters.put("billingAddress.id", billingAddress.getId());
                parameters.put("billingAddress.lastName", billingAddress.getLastName());
                parameters.put("billingAddress.line1", billingAddress.getLine1());
                parameters.put("billingAddress.line2", billingAddress.getLine2());
                parameters.put("billingAddress.phone", billingAddress.getPhone());
                parameters.put("billingAddress.postalCode", billingAddress.getPostalCode());
                parameters.put("billingAddress.shippingAddress", billingAddress.getShippingAddress());
                parameters.put("billingAddress.title", billingAddress.getTitle());
                parameters.put("billingAddress.titleCode", billingAddress.getTitleCode());
                parameters.put("billingAddress.town", billingAddress.getTown());
                parameters.put("billingAddress.visibleInAddressBook", billingAddress.getVisibleInAddressBook());

            }

        }

        return parameters;
    }

    /**
     * Convert the query object to a parameter of map
     *
     * @param queryLogin the query
     * @return the map parameters
     */
    protected Map<String, Object> buildLoginParameters(QueryLogin queryLogin, String clientId, String grantType) {

        Map<String, Object> params = new HashMap<>();

        if (queryLogin != null) {
            params = MapUtils.toMap(queryLogin);
        }

        params.put(Constants.Login.PARAM_CLIENT_ID, clientId);
        params.put(Constants.Login.PARAM_CLIENT_SECRET, Constants.Login.CLIENT_SECRET);
        params.put(Constants.Login.PARAM_GRANT_TYPE, grantType);

        return params;
    }

    /**
     * Execute the request for a generic T response
     *
     * @param responseReceiver    Response callback result
     * @param dataConverterHelper Helper to convert the result into a POJO
     * @param getCachedResult     Indicator to use cache or not
     * @param requestId           Identifier for the call
     * @param url                 Url to call
     * @param parameters          Call parameters
     * @param headers             Call parameters headers
     * @param isAuthorizedRequest Flag for calls that need the user token
     * @param httpMethod          Http method: GET, POST, PUT, DELETE
     * @param viewsToDisable      List of views to disable/enable before/after the call
     * @param onRequestListener   Request listener for before/after call actions
     * @return true if request is executed else false
     */
    protected <T, Z> boolean execute(final ResponseCallback<T, Z> responseReceiver,
                                     final DataConverter.Helper<T, Z> dataConverterHelper, boolean getCachedResult, final String requestId, String url,
                                     Map parameters, Map<String, String> headers, boolean isAuthorizedRequest, String httpMethod,
                                     List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return executeRequest(responseReceiver, dataConverterHelper, getCachedResult, requestId, url, parameters, headers,
                isAuthorizedRequest, httpMethod, viewsToDisable, onRequestListener);
    }

    /**
     * Execute a request
     *
     * @param responseReceiver    Response callback result
     * @param dataConverterHelper Helper to convert the result into a POJO
     * @param getCachedResult     Indicator to use cache or not
     * @param requestId           Identifier for the call
     * @param url                 Url to call
     * @param parameters          Call parameters
     * @param headers             Call parameters headers
     * @param isAuthorizedRequest Flag for calls that need the user token
     * @param httpMethod          Http method: GET, POST, PUT, DELETE
     * @param viewsToDisable      List of views to disable/enable before/after the call
     * @param onRequestListener   Request listener for before/after call actions
     * @return true if request is executed else false
     */
    protected <T, Z> boolean executeRequest(final ResponseCallback<T, Z> responseReceiver,
                                            final DataConverter.Helper<T, Z> dataConverterHelper,
                                            final boolean getCachedResult, final String requestId, final String url, final Map parameters,
                                            final Map<String, String> headers, final boolean isAuthorizedRequest, final String httpMethod,
                                            final List<View> viewsToDisable, final OnRequestListener onRequestListener) {

        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Executing request for " + url);
        }

        boolean refreshTokenNeeded = false;
        final Map<String, String> finalHeader = new HashMap<>();

        // We initialize the header Map
        if (headers != null) {
            finalHeader.putAll(headers);
        }

        // Disabling the views before the call
        if (viewsToDisable != null && !viewsToDisable.isEmpty()) {

            Log.d(TAG, "Disabling views before the request");

            for (View view : viewsToDisable) {
                view.setEnabled(false);
                view.setActivated(false);
            }
        }

        // We pass the access token for authorized requests
        if (isAuthorizedRequest) {

            // The token is expired, we refresh it (only for logged in user)
            if (!mUserInformation.isAnonymous() && (mUserInformation.isTokenExpired() || mUserInformation.isTokenInvalid())) {

                refreshTokenNeeded = true;

                // No refresh token, we send a logout message
                if (StringUtils.isBlank(mUserInformation.getSecureRefreshToken())) {
                    Log.d(TAG, "Refresh token empty");
                    sendLogoutBroadcast();
                }
                // We refresh the token
                else {
                    Log.d(TAG, "Sending the request to refresh the token");

                    refreshToken(new ResponseReceiver<UserInformation>() {

                        @Override
                        public void onResponse(Response<UserInformation> response) {

                            String savedCartId = mUserInformation.getCartId();
                            saveUserInformation(response.getData(), mUserInformation.getUserId());
                            mUserInformation.setCartId(savedCartId);

                            executeRequest(responseReceiver, dataConverterHelper, getCachedResult,
                                    requestId, url, parameters, finalHeader, isAuthorizedRequest, httpMethod, viewsToDisable,
                                    onRequestListener);
                        }

                        @Override
                        public void onError(Response<ErrorList> response) {
                            Error firstError = response.getData().getErrors() != null && !response.getData().getErrors().isEmpty() ? response.getData().getErrors().get(0) : null;

                            Log.e(TAG, "Error refreshing the user token. Details:" + firstError != null ? firstError.getMessage() : "");
                            sendLogoutBroadcast();
                        }
                    }, mUserInformation.getSecureRefreshToken());
                }
            } else if (!mUserInformation.isTokenInvalid()) {
                finalHeader.put(HEADER_AUTHORIZATION,
                        HEADER_AUTHORIZATION_BEARER + " " + mUserInformation.getSecureAccessToken());
            }
        }

        if (!refreshTokenNeeded) {

            // Before doing the request
            if (onRequestListener != null) {
                onRequestListener.beforeRequest();
            }

            ResponseCallback<T, Z> responseReceiverActionsBeforeCallback = new ResponseCallback<T, Z>() {

                @Override
                public void onResponse(Response<T> dataResponse) {
                    afterRequestActions(responseReceiver, dataResponse, null,
                            dataConverterHelper,
                            getCachedResult, requestId, url, parameters, finalHeader, isAuthorizedRequest, httpMethod,
                            viewsToDisable, onRequestListener);
                }

                @Override
                public void onError(Response<Z> response) {
                    afterRequestActions(responseReceiver, null, response, dataConverterHelper,
                            getCachedResult, requestId, url, parameters, finalHeader, isAuthorizedRequest, httpMethod,
                            viewsToDisable, onRequestListener);
                }
            };

            return mPersistenceHelper.execute(responseReceiverActionsBeforeCallback, dataConverterHelper, getCachedResult,
                    requestId, url, parameters, finalHeader, httpMethod);

        } else {
            return false;
        }
    }

    /**
     * Actions for after request
     *
     * @param responseReceiver    Response callback result
     * @param dataResponse        The response to return
     * @param dataConverterHelper Helper to convert the result into a POJO
     * @param getCachedResult     Indicator to use cache or not
     * @param requestId           Identifier for the call
     * @param url                 Url to call
     * @param parameters          Call parameters
     * @param headers             Call parameters headers
     * @param isAuthorizedRequest Flag for calls that need the user token
     * @param httpMethod          Http method: GET, POST, PUT, DELETE
     * @param viewsToDisable      List of views to disable/enable before/after the call
     * @param onRequestListener   Request listener for before/after call actions
     */
    protected <T, Z> void afterRequestActions(final ResponseCallback<T, Z> responseReceiver,
                                              Response<T> dataResponse,
                                              Response<Z> dataResponseError, final DataConverter.Helper<T, Z> dataConverterHelper, final boolean getCachedResult,
                                              final String requestId, final String url, final Map<String, Object> parameters, final Map<String, String> headers,
                                              final boolean isAuthorizedRequest, final String httpMethod, final List<View> viewsToDisable,
                                              final OnRequestListener onRequestListener) {
        boolean refreshTokenNeeded = false;

        // Checking if some error occured
        if (dataResponseError != null && dataResponseError.getData() != null && dataResponseError.getData() instanceof ErrorList) {
            Error error = ((ErrorList) dataResponseError.getData()).getErrors() != null && !((ErrorList) dataResponseError.getData()).getErrors().isEmpty() ? ((ErrorList) dataResponseError.getData()).getErrors().get(0) : null;

            // Token needs to be refreshed (only for logged in user)
            refreshTokenNeeded = error != null && !mUserInformation.isAnonymous() && (StringUtils.equals(error.getType(),
                    Constants.ERROR_TYPE_INVALIDTOKENERROR) || (StringUtils.equals(error.getType(),
                    Constants.ERROR_TYPE_UNAUTHORIZEDERROR)));
        }

        // We need to refresh the token so we re-send the request by invalidating the token for the user
        if (refreshTokenNeeded) {
            Log.d(TAG, Constants.ERROR_TYPE_INVALIDTOKENERROR + " or " + Constants.ERROR_TYPE_UNAUTHORIZEDERROR + " occured, re-sending the request with token refresh flag.");

            // Specific case when the app has already logged out the user and the response comes,
            // mUserInformation is null and we don't do anything
            mUserInformation.setTokenInvalid(true);
            executeRequest(responseReceiver, dataConverterHelper, getCachedResult, requestId, url,
                    parameters, headers, isAuthorizedRequest, httpMethod, viewsToDisable, onRequestListener);
        } else {
            if (viewsToDisable != null && !viewsToDisable.isEmpty()) {

                Log.d(TAG, "Re-enabling views after the request");

                for (View view : viewsToDisable) {
                    view.setEnabled(true);
                    view.setActivated(true);
                }
            }

            // After request listener
            if (onRequestListener != null) {
                onRequestListener.afterRequestBeforeResponse();
            }

            boolean isDataSynced;

            // Response returned through the callback object
            if (dataResponseError != null) {
                responseReceiver.onError(dataResponseError);
                isDataSynced = dataResponseError.isSync();
            } else {
                responseReceiver.onResponse(dataResponse);
                isDataSynced = dataResponse.isSync();
            }

            // After request listener
            if (onRequestListener != null) {
                onRequestListener.afterRequest(isDataSynced);
            }
        }
    }

    /**
     * Update the UserAuthorization object used by authenticated requests
     *
     * @param userInformation contain user session token
     * @param userId          user unique identifier e.i email
     */
    protected void saveUserInformation(UserInformation userInformation, String userId) {
        userInformation.setIssuedOn(Calendar.getInstance().getTimeInMillis());
        this.mUserInformation = userInformation;
        this.mUserInformation.setUserId(userId);

        // Save needed user information in the shared preferences in case the app is restarted
        if (StringUtils.isNotBlank(userInformation.getSecureRefreshToken())) {
            SecurityHelper.setStringToSecureSharedPreferences(getSharedPreferences(), TOKEN_REFRESH,
                    userInformation.getSecureRefreshToken());
        }

        SecurityHelper.setStringToSecureSharedPreferences(getSharedPreferences(), USER_ID, userId);
    }

    /**
     * Delete the user information
     */
    protected void deleteUserInformation() {
        mUserInformation.reset();
        Editor editor = getSharedPreferences().edit();
        editor.remove(TOKEN_REFRESH);
        editor.remove(USER_ID);
        editor.apply();
    }

    /**
     * Get the shared preferences
     *
     * @return sharedPreferences from the context
     */
    protected SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    /**
     * Return the default user id to use for a authenticated request. If no specific user is provided, get the one authenticated.
     *
     * @param specificUser specific user information
     * @return the user id used
     */
    protected String getDefaultUserId(SpecificUser specificUser) {
        if (specificUser != null && StringUtils.isNotBlank(specificUser.getUserId())) {
            return specificUser.getUserId();
        } else {
            return mUserInformation.getUserId();
        }
    }

    /**
     * Return the default cart id to use for a cart request. If no specific cart is provided, get the default one from the authenticated user.
     *
     * @param specificCart specific user information
     * @return the cart id used
     */
    protected String getDefaultCartId(SpecificCart specificCart) {
        if (specificCart != null && StringUtils.isNotBlank(specificCart.getCartId())) {
            return specificCart.getCartId();
        } else {
            return mUserInformation.getCartId();
        }
    }

    protected enum CartActionEnum {
        ADD, UPDATE, UPDATE_ONLY_ATTRIBUTES, DELETE
    }

}
