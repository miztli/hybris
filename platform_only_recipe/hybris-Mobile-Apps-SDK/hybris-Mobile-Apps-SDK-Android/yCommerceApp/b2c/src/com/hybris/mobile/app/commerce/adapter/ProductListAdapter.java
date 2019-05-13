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
import android.widget.Spinner;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.helper.ProductHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.data.product.VariantOption;
import com.hybris.mobile.lib.commerce.loader.ContentLoader;
import com.hybris.mobile.lib.commerce.loader.ProductLoader;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import java.util.List;


/**
 * Adapter for the products of the catalog in a listview
 */
public class ProductListAdapter extends ProductListAdapterBase {
    public static final String TAG = ProductListAdapter.class.getCanonicalName();

    public ProductListAdapter(Context context, Cursor c, int flags, ContentServiceHelper contentServiceHelper) {
        super(context, c, flags, contentServiceHelper);
    }

    @Override
    protected void onItemSpinnerSelected(Spinner selectedSpinner, Object matrixElement) {
        VariantOption selectedVariant = (VariantOption) matrixElement;
        selectVariant(selectedVariant.getCode());
//        ProductHelper.populateSpinner(getmContext(), selectedSpinner, selectedVariant, 0);
    }

    @Override
    protected int populateVariants(List<Spinner> spinners, ProductBase product) {
        return ProductHelper.populateVariant(getContext(), spinners,
                product, false);
    }

    @Override
    protected ContentLoader getProductLoaderExpandView(ProductBase product, Context context, ContentServiceHelper contentServiceHelper, OnRequestListener onRequestListener, final OnProductLoaded onProductLoaded) {

        final Product productBase = (Product) product;

        QueryProduct queryProduct = new QueryProduct();
//        queryProduct.setCode(StringUtils.isNotBlank(productBase.getFirstVariantCode()) ?
//                productBase.getFirstVariantCode()
//                : (productBase.getVariantMatrix() != null && productBase.getVariantMatrix().get(0).getVariantOption() != null) ?
//                productBase.getVariantMatrix().get(0).getVariantOption().getCode() :
//                product.getCode());   //Get the first variant by default if first variant is not available

        return new ProductLoader(context, contentServiceHelper, new ResponseReceiver<Product>() {

            @Override
            public void onResponse(Response<Product> response) {

                Product product = response.getData();

                String productCodeFirstVariant = null;
                VariantOption firstVariant = (VariantOption) mCurrentSelectedViewHolder.productItemVariantSpinner1.getItemAtPosition(0);

                if (firstVariant != null) {
                    productCodeFirstVariant = firstVariant.getCode();
                }

                onProductLoaded.onProductLoaded(product, productCodeFirstVariant);

            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getContext());
            }

        }, queryProduct, onRequestListener);
    }

    @Override
    protected ContentLoader getProductLoaderSelectVariant(String productCode, Context context, ContentServiceHelper contentServiceHelper, OnRequestListener onRequestListener, final OnProductLoaded onProductLoaded) {
        QueryProduct queryProduct = new QueryProduct();
        queryProduct.setCode(productCode);

        return new ProductLoader(getContext(), CommerceApplication.getContentServiceHelper(), new ResponseReceiver<Product>() {

            @Override
            public void onResponse(Response<Product> response) {
                Product product = response.getData();
                onProductLoaded.onProductLoaded(product, null);
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getContext());
            }
        }, queryProduct, onRequestListener);
    }
}
