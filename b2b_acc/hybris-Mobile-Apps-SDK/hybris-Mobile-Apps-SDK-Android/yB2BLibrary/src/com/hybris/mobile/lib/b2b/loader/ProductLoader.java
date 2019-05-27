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

package com.hybris.mobile.lib.b2b.loader;

import android.content.Context;
import android.net.Uri;

import com.hybris.mobile.lib.b2b.data.product.Product;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.loader.ContentLoader;
import com.hybris.mobile.lib.commerce.loader.ProductLoaderBase;
import com.hybris.mobile.lib.commerce.provider.CatalogContract;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.listener.OnRequestListener;

import org.apache.commons.lang3.StringUtils;


/**
 * Loader for product
 */
public class ProductLoader extends ContentLoader<Product> implements ProductLoaderBase {

    private QueryProduct mQueryProduct;

    public ProductLoader(Context context, ContentServiceHelper contentServiceHelper, ResponseReceiver<Product> responseReceiver,
                         QueryProduct queryProduct, OnRequestListener onRequestListener) {
        super(context, contentServiceHelper, responseReceiver, DataConverter.Helper.build(Product.class, ErrorList.class, null),
                onRequestListener);

        if (queryProduct == null || StringUtils.isBlank(queryProduct.getCode())) {
            throw new IllegalArgumentException();
        }

        setQuery(queryProduct);
    }

    @Override
    public void setQuery(QueryProduct queryProduct) {
        mQueryProduct = queryProduct;
    }

    @Override
    public Uri getUri() {
        return Uri.withAppendedPath(CatalogContract.Provider.getUriDataDetails(mContentServiceHelper.getConfiguration().getCatalogAuthority()), mQueryProduct.getCode());
    }

}
