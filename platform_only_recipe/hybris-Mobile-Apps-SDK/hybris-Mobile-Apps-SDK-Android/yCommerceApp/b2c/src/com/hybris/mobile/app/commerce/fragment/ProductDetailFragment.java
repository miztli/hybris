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
package com.hybris.mobile.app.commerce.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.ProductHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.VariantOption;
import com.hybris.mobile.lib.commerce.loader.ContentLoader;
import com.hybris.mobile.lib.commerce.loader.ProductLoader;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import org.apache.commons.lang3.StringUtils;


/**
 * Container that handle_anchor the details information for a specific product
 */
public class ProductDetailFragment extends ProductDetailFragmentBase {

    @Override
    protected ContentLoader getProductLoader(Context context, ContentServiceHelper contentServiceHelper, QueryProduct queryProduct, OnRequestListener onRequestListener) {
        return new ProductLoader(context, contentServiceHelper, new ResponseReceiver<Product>() {

            @Override
            public void onResponse(Response<Product> response) {
                mProduct = response.getData();

                populateProduct(mProduct);
                if (!mVariantPopulated) {
                    mNbVariantLevels = ProductHelper.populateVariant(getActivity(), mSpinnersVariants, mProduct, false);
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

                switch (parent.getId()) {
                    case R.id.product_detail_variant_spinner_1:
                        if (mVariantPopulated && position < mProductDetailVariantSpinner1.getAdapter().getCount() && !StringUtils.equals(((VariantOption) mProductDetailVariantSpinner1.getSelectedItem()).getCode(), mProduct.getCode())) {
                            mVariantPopulated = false;
                            mNbVariantLevelsInstantiated= 0;
                            selectVariant(((VariantOption) mProductDetailVariantSpinner1.getSelectedItem()).getCode());
                        }
                        break;

                    case R.id.product_detail_variant_spinner_2:
                        if (mVariantPopulated && position < mProductDetailVariantSpinner2.getAdapter().getCount() && !StringUtils.equals(((VariantOption) mProductDetailVariantSpinner2.getSelectedItem()).getCode(), mProduct.getCode())) {
                            mVariantPopulated = false;
                            mNbVariantLevelsInstantiated= 0;
                            selectVariant(((VariantOption) mProductDetailVariantSpinner2.getSelectedItem()).getCode());
                        }
                        break;
                }
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
