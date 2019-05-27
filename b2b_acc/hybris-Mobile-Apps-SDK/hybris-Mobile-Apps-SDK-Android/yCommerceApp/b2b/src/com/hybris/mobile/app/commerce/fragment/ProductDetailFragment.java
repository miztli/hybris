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
package com.hybris.mobile.app.commerce.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.ProductHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.b2b.data.product.Product;
import com.hybris.mobile.lib.b2b.data.product.VariantMatrixElement;
import com.hybris.mobile.lib.b2b.loader.ProductLoader;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.loader.ContentLoader;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;


/**
 * Container that handle_anchor the details information for a specific product
 */
public class ProductDetailFragment extends ProductDetailFragmentBase {

    @Override
    protected ContentLoader getProductLoader(Context context, ContentServiceHelper contentServiceHelper, QueryProduct queryProduct, OnRequestListener onRequestListener) {
        return new ProductLoader(context, contentServiceHelper, new ResponseReceiver<Product>() {

            @Override
            public void onResponse(Response<Product> response) {
                Product product = response.getData();

                /**
                 * Cases:
                 * 1 - Product with variants
                 * 2 - Product without any variants
                 */
                populateProduct(product);

                // First call for the base product, we populate the variants and select the first one to reload the product on the first variant
                if (!mVariantPopulated) {
                    mNbVariantLevels = ProductHelper.populateVariant(getActivity(), mSpinnersVariants, product);
                }
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, queryProduct, onRequestListener);
    }

    @Override
    protected OnItemSelectedListener getVariantSpinnerListener() {

        return new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position) != null && mVariantPopulated) {
                    VariantMatrixElement selectedVariant = (VariantMatrixElement) parent.getItemAtPosition(position);
                    selectVariant(selectedVariant.getVariantOption().getCode());

                    Spinner spinnerToUpdate = null;

                    switch (parent.getId()) {
                        case R.id.product_detail_variant_spinner_1:
                            spinnerToUpdate = mProductDetailVariantSpinner2;
                            break;

                        case R.id.product_detail_variant_spinner_2:
                            spinnerToUpdate = mProductDetailVariantSpinner3;
                            break;

                        default:
                            break;
                    }

                    ProductHelper.populateSpinner(getActivity(), spinnerToUpdate, selectedVariant.getElements(), 0);
                }

                // Workaround to activate the onchange listener only after having instantiated all the  spinners
                mNbVariantLevelsInstantiated++;
                if (mNbVariantLevelsInstantiated == mNbVariantLevels) {
                    mVariantPopulated = true;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    }

}
