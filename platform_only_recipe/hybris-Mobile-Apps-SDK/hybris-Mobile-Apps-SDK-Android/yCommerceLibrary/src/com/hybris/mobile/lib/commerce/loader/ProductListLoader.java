/*******************************************************************************
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 ******************************************************************************/

package com.hybris.mobile.lib.commerce.loader;

import android.content.Context;
import android.net.Uri;
import android.widget.CursorAdapter;

import com.hybris.mobile.lib.commerce.provider.CatalogContract;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;


/**
 * Loader for product list
 */
public class ProductListLoader extends ContentAdapterLoader {

    private QueryProducts mQueryProducts;

    public ProductListLoader(Context context, ContentServiceHelper contentServiceHelper, CursorAdapter cursorAdapter, QueryProducts queryProducts,
                             OnRequestListener onRequestListener) {
        super(context, contentServiceHelper, cursorAdapter, onRequestListener);

        if (queryProducts == null) {
            throw new IllegalArgumentException();
        }

        updateQuery(queryProducts);
    }

    public void updateQuery(QueryProducts queryProducts) {
        mQueryProducts = queryProducts;
    }

    @Override
    public Uri getUri() {
        return Uri.withAppendedPath(CatalogContract.Provider.getUriGroup(mContentServiceHelper.getConfiguration().getCatalogAuthority()), mQueryProducts.getIdCategory()).buildUpon()
                .appendQueryParameter(CatalogContract.Provider.QUERY_PARAM_CURRENT_PAGE, mQueryProducts.getCurrentPage() + "")
                .appendQueryParameter(CatalogContract.Provider.QUERY_PARAM_PAGE_SIZE, mQueryProducts.getPageSize() + "").build();
    }

}
