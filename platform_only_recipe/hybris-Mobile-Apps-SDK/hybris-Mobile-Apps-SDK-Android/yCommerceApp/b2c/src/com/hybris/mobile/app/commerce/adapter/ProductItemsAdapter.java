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
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.ProductDetailActivity;
import com.hybris.mobile.app.commerce.utils.ProductUtils;
import com.hybris.mobile.lib.commerce.adapter.CatalogCursorAdapter;
import com.hybris.mobile.lib.commerce.data.product.Price;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;

import org.apache.commons.lang3.StringUtils;


/**
 * B2C adapter for catalog content
 */
public abstract class ProductItemsAdapter extends CatalogCursorAdapter<Product> {

    public ProductItemsAdapter(Context context, Cursor c, int flags, ContentServiceHelper contentServiceHelper) {
        super(context, c, flags, Product.class, contentServiceHelper);
    }

    public String getFirstVariantCode(ProductBase product) {
        return product.getCode();
    }

}
