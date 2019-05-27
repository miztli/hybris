package com.hybris.mobile.lib.commerce.service;

import android.content.Context;
import android.view.View;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.data.search.facetdata.ProductSearchPage;
import com.hybris.mobile.lib.commerce.helper.UrlHelper;
import com.hybris.mobile.lib.commerce.query.QueryCartAddEntry;
import com.hybris.mobile.lib.commerce.query.QueryCartUpdateEntry;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.query.SpecificCart;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
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
 * Commerce extension to retrieve the application data
 */
public class CommerceServiceHelper extends OCCServiceHelper implements CommerceContentServiceHelper {

    public CommerceServiceHelper(Context context, Configuration configuration, PersistenceManager persistenceManager, DataConverter dataConverter, boolean uiRelated) {
        super(context, configuration, persistenceManager, dataConverter, uiRelated);
    }

    public CommerceServiceHelper(Context context, Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, boolean uiRelated) {
        super(context, configuration, sslSocketFactory, hostnameVerifier, uiRelated);
    }

    public CommerceServiceHelper(Context context, Configuration configuration, boolean uiRelated) {
        super(context, configuration, uiRelated);
    }

    @Override
    public boolean getProducts(ResponseReceiver<ProductSearchPage> responseReceiver, String requestId, QueryProducts queryProducts, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        if (queryProducts != null) {
            // Getting the facets from the query object
            StringBuilder query = new StringBuilder();

            // Free text
            if (StringUtils.isNotBlank(queryProducts.getQuery())) {
                query.append(queryProducts.getQuery());
            }

            query.append(":");

            // Sort
            if (StringUtils.isNotBlank(queryProducts.getSort())) {
                query.append(queryProducts.getSort());
            }

            // Category
            if (StringUtils.isNotBlank(queryProducts.getIdCategory())) {
                query.append(":category:").append(queryProducts.getIdCategory());
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

        return execute(responseReceiver,
                DataConverter.Helper.build(ProductSearchPage.class, ErrorList.class, null),
                shouldUseCache,
                requestId,
                UrlHelper.getWebserviceCatalogUrl(mContext, mConfiguration, com.hybris.mobile.lib.commerce.R.string.path_products,
                        StringUtils.isBlank(queryProducts.getIdCategory()) ?
                                mConfiguration.getCatalogIdMainCategory() :
                                queryProducts.getIdCategory()), MapUtils.toMap(queryProducts), null,
                false,
                HttpUtils.HTTP_METHOD_GET, viewsToDisable, onRequestListener);
    }

    @Override
    public boolean addCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId, QueryCartAddEntry queryCartAddEntry, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) throws IllegalArgumentException {
        return addUpdateDeleteProductToCart(CartActionEnum.ADD, responseReceiver, requestId, queryCartAddEntry, specificCart, shouldUseCache,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean replaceCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId, QueryCartUpdateEntry queryCartUpdateEntry, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return addUpdateDeleteProductToCart(CartActionEnum.UPDATE, responseReceiver, requestId, queryCartUpdateEntry, specificCart, shouldUseCache,
                viewsToDisable, onRequestListener);
    }

    @Override
    public boolean updateCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId, QueryCartUpdateEntry queryCartUpdateEntry, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        return addUpdateDeleteProductToCart(CartActionEnum.UPDATE_ONLY_ATTRIBUTES, responseReceiver, requestId, queryCartUpdateEntry,
                specificCart, shouldUseCache,
                viewsToDisable, onRequestListener);
    }

}
