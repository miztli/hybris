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

import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.data.search.facetdata.ProductSearchPage;
import com.hybris.mobile.lib.commerce.query.QueryCartAddEntry;
import com.hybris.mobile.lib.commerce.query.QueryCartUpdateEntry;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.query.SpecificCart;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.listener.OnRequestListener;

import java.util.List;


/**
 * Interface for the service used to get the application data for Commerce
 */
public interface CommerceContentServiceHelper extends ContentServiceHelper {

    /**
     * Returns a list of products and additional data such as: available facets, available sorting and pagination options. It can include spelling suggestions.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryProducts     Parameters needed for the request
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean getProducts(ResponseReceiver<ProductSearchPage> responseReceiver, String requestId, QueryProducts queryProducts,
                        boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Adds a product to the cart.
     *
     * @param responseReceiver  Response callback result
     * @param requestId         Identifier for the call
     * @param queryCartAddEntry Parameters needed for the request
     * @param specificCart      overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache    Indicator to use cache or not
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     * @throws IllegalArgumentException
     */
    boolean addCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId, QueryCartAddEntry queryCartAddEntry,
                         SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

    /**
     * Updates the quantity of a single cart entry and details of the store where the cart entry will be picked. Attributes not provided in request will be defined again (set to null or default)
     *
     * @param responseReceiver     Response callback result
     * @param requestId            Identifier for the call
     * @param queryCartUpdateEntry Parameters needed for the request
     * @param specificCart         overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache       Indicator to use cache or not
     * @param viewsToDisable       Views to disable/enable before/after the request
     * @param onRequestListener    Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean replaceCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId,
                             QueryCartUpdateEntry queryCartUpdateEntry, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable,
                             OnRequestListener onRequestListener);

    /**
     * Updates the quantity of a single cart entry and details of the store where the cart entry will be picked.
     *
     * @param responseReceiver     Response callback result
     * @param requestId            Identifier for the call
     * @param queryCartUpdateEntry Parameters needed for the request
     * @param specificCart         overrides the cart and/or user or guest with the specified cart and/or user
     * @param shouldUseCache       Indicator to use cache or not
     * @param viewsToDisable       Views to disable/enable before/after the request
     * @param onRequestListener    Its methods will be called when the request is sent
     * @return true if no error in the process of executing this method. Note that this does not mean whether or not the request was a success.
     */
    boolean updateCartEntry(ResponseReceiver<CartModification> responseReceiver, String requestId,
                            QueryCartUpdateEntry queryCartUpdateEntry, SpecificCart specificCart, boolean shouldUseCache, List<View> viewsToDisable, OnRequestListener onRequestListener);

}
