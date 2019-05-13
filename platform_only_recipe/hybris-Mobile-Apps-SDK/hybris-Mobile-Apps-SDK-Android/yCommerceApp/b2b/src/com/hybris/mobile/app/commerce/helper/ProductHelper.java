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
package com.hybris.mobile.app.commerce.helper;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;

import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.ProductDetailActivity;
import com.hybris.mobile.app.commerce.adapter.VariantAdapter;
import com.hybris.mobile.lib.b2b.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.Category;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;


/**
 * Helper for products
 */
public class ProductHelper {
    public static final String TAG = ProductHelper.class.getCanonicalName();

    /**
     * Redirect to the product details page
     *
     * @param context
     * @param productCode
     */
    public static void redirectToProductDetail(Context context, String productCode) {
        if (StringUtils.isNotBlank(productCode)) {
            Intent intentProductDetail = new Intent(context, ProductDetailActivity.class);
            intentProductDetail.putExtra(IntentConstants.PRODUCT_CODE, productCode);
            context.startActivity(intentProductDetail);
        }
    }

    /**
     * populate the spinner with variants otherwise hide Maximum supported Spinner is 3
     */
    public static int populateVariant(Context context, List<Spinner> spinners, Product product) {
        int nbLevels = 0;

        if (product != null) {
            if (product.getVariantMatrix() != null && !product.getVariantMatrix().isEmpty()) {

                // Get the variant position
                int position = findVariantPosition(product.getCategories(), product.getVariantMatrix());
                populateSpinner(context, spinners.get(0), product.getVariantMatrix(), position);

                nbLevels = 1;

                if (product.getVariantMatrix() != null && product.getVariantMatrix().size() > position) {
                    // Get the childs at the variant position
                    com.hybris.mobile.lib.b2b.data.product.VariantMatrixElement variant1 = product.getVariantMatrix().get(position);

                    if (variant1.getElements() != null && !variant1.getElements().isEmpty()) {
                        nbLevels = 2;

                        // Get the variant position
                        position = findVariantPosition(product.getCategories(), variant1.getElements());
                        populateSpinner(context, spinners.get(1), variant1.getElements(),
                                findVariantPosition(product.getCategories(), variant1.getElements()));

                        if (variant1.getElements() != null && variant1.getElements().size() > position) {
                            // Get the childs at the variant position
                            com.hybris.mobile.lib.b2b.data.product.VariantMatrixElement variant2 = variant1.getElements().get(position);

                            if (variant2.getElements() != null && !variant2.getElements().isEmpty()) {
                                nbLevels = 3;

                                populateSpinner(context, spinners.get(2), variant2.getElements(),
                                        findVariantPosition(product.getCategories(), variant2.getElements()));
                            }

                        }

                    }
                }

            }
        }

        return nbLevels;

    }

    /**
     * Fill Spinner list with arraylist of variantMatrixElement
     *
     * @param context
     * @param spinner
     * @param variants
     * @param position
     */
    public static void populateSpinner(Context context, Spinner spinner, List<com.hybris.mobile.lib.b2b.data.product.VariantMatrixElement> variants, int position) {
        if (spinner != null && variants != null && !variants.isEmpty()) {
            VariantAdapter mVariantAdapter = new VariantAdapter(context, R.layout.item_product_variant, variants);
            spinner.setAdapter(mVariantAdapter);
            spinner.setPrompt(context.getString(R.string.choose_variant, variants.get(0).getParentVariantCategory().getName()));
            spinner.setVisibility(View.VISIBLE);
            spinner.setSelection(position);
        }
    }

    /**
     * Use variantValueCategory code to find the default variant value with the category code
     *
     * @return default variant position
     */
    public static int findVariantPosition(Collection<Category> categories, List<com.hybris.mobile.lib.b2b.data.product.VariantMatrixElement> variants) {
        if (categories != null && variants != null) {
            for (Category category : categories) {
                int position = 0;
                for (com.hybris.mobile.lib.b2b.data.product.VariantMatrixElement variant : variants) {
                    if (StringUtils.equals(category.getCode(), variant.getVariantValueCategory().getCode())) {
                        return position;
                    }
                    position++;
                }
            }
        }
        return 0;
    }
}
