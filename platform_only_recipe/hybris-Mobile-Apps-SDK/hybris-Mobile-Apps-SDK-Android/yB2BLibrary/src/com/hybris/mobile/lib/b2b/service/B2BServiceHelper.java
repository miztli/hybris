package com.hybris.mobile.lib.b2b.service;

import android.content.Context;
import android.view.View;

import com.hybris.mobile.lib.b2b.R;
import com.hybris.mobile.lib.b2b.data.costcenter.CostCenters;
import com.hybris.mobile.lib.b2b.data.search.facetdata.ProductSearchPage;
import com.hybris.mobile.lib.b2b.query.QueryCartAddEntry;
import com.hybris.mobile.lib.b2b.query.QueryCartUpdateEntry;
import com.hybris.mobile.lib.b2b.query.QueryCostCenter;
import com.hybris.mobile.lib.b2b.query.QueryPaymentType;
import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.helper.UrlHelper;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.query.SpecificCart;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.OCCServiceHelper;
import com.hybris.mobile.lib.commerce.utils.MapUtils;
import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.manager.PersistenceManager;
import com.hybris.mobile.lib.http.utils.HttpUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/**
 * B2B extension to retrieve the application data
 */
public class B2BServiceHelper extends OCCServiceHelper implements B2BContentServiceHelper {

    public B2BServiceHelper(Context context, Configuration configuration, PersistenceManager persistenceManager, DataConverter dataConverter, boolean uiRelated) {
        super(context, configuration, persistenceManager, dataConverter, uiRelated);
    }

    public B2BServiceHelper(Context context, Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, boolean uiRelated) {
        super(context, configuration, sslSocketFactory, hostnameVerifier, uiRelated);
    }

    public B2BServiceHelper(Context context, Configuration configuration, boolean uiRelated) {
        super(context, configuration, uiRelated);
    }

    @Override
    public boolean getCostCenters(ResponseReceiver<CostCenters> responseReceiver, String requestId, boolean shouldUseCache,
                                  List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(CostCenters.class, ErrorList.class),
                shouldUseCache, requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration,
                        R.string.path_cost_center),
                null, null, true, HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean getProducts(ResponseReceiver<ProductSearchPage> responseReceiver, String requestId, QueryProducts queryProducts,
                               boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener)
            throws IllegalArgumentException {

        if (queryProducts != null) {
            // Getting the facets from the query object
            StringBuilder query = new StringBuilder();

            // Free text
            if (StringUtils.isNotBlank(queryProducts.getQuery())) {
                query.append(queryProducts.getQuery());
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

        return execute(responseReceiver, DataConverter.Helper.build(ProductSearchPage.class, ErrorList.class, null), shouldUseCache,
                requestId, UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, com.hybris.mobile.lib.b2b.R.string.path_products,
                        StringUtils.isBlank(queryProducts.getIdCategory()) ? mConfiguration.getCatalogIdMainCategory() : queryProducts.getIdCategory()), MapUtils.toMap(queryProducts), null,
                false,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCartCostCenter(ResponseReceiver<Cart> responseReceiver, String requestId, QueryCostCenter queryCostCenter,
                                        SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Cart.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_cost_center,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryCostCenter), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCartPaymentType(ResponseReceiver<Cart> responseReceiver, String requestId, QueryPaymentType queryPaymentType,
                                         SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return execute(responseReceiver, DataConverter.Helper.build(Cart.class, ErrorList.class, null), shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, R.string.path_cart_payment_type,
                        getDefaultUserId(specificCart), getDefaultCartId(specificCart)), MapUtils.toMap(queryPaymentType), null, true,
                HttpUtils.HTTP_METHOD_PUT, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean addCartEntry(final ResponseReceiver<CartModification> responseReceiver, final String requestId,
                                final QueryCartAddEntry queryCartEntry, SpecificCart specificCart, final boolean shouldUseCache, final List<View> viewsToDisable,
                                final OnRequestListener onRequestListener) throws IllegalArgumentException {
        return addUpdateDeleteProductToCart(CartActionEnum.ADD, responseReceiver, requestId, queryCartEntry, specificCart, shouldUseCache,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean replaceCartEntry(final ResponseReceiver<CartModification> responseReceiver, final String requestId,
                                    final QueryCartUpdateEntry queryCartUpdateEntry, SpecificCart specificCart, final boolean shouldUseCache, final List<View> viewsToDisable,
                                    final OnRequestListener onRequestListener) throws IllegalArgumentException {
        return addUpdateDeleteProductToCart(CartActionEnum.UPDATE, responseReceiver, requestId, queryCartUpdateEntry, specificCart, shouldUseCache,
                viewsToDisable, onRequestListener);
    }

}
