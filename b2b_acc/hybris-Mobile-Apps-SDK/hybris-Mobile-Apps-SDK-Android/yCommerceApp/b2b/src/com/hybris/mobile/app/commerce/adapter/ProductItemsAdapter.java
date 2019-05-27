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
package com.hybris.mobile.app.commerce.adapter;

import android.content.Context;
import android.database.Cursor;

import com.hybris.mobile.lib.b2b.data.product.Product;
import com.hybris.mobile.lib.commerce.adapter.CatalogCursorAdapter;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;


/**
 * B2B adapter for catalog content
 */
public abstract class ProductItemsAdapter extends CatalogCursorAdapter<com.hybris.mobile.lib.b2b.data.product.Product> {

    public ProductItemsAdapter(Context context, Cursor c, int flags, ContentServiceHelper contentServiceHelper) {
        super(context, c, flags, com.hybris.mobile.lib.b2b.data.product.Product.class, contentServiceHelper);
    }

    public String getFirstVariantCode(ProductBase product) {
        return ((Product) product).getFirstVariantCode();
    }
}
