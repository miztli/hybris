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
import android.renderscript.Byte2;
import android.view.View;
import android.widget.Spinner;

import com.hybris.mobile.app.commerce.B2CConstants;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.ProductDetailActivity;
import com.hybris.mobile.app.commerce.adapter.VariantAdapter;
import com.hybris.mobile.lib.commerce.data.product.BaseOption;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.data.product.VariantOption;
import com.hybris.mobile.lib.commerce.data.product.VariantOptionQualifier;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
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
    public static int populateVariant(Context context, List<Spinner> spinners, ProductBase product, boolean resetChildSpinner) {

        if (product.getBaseOptions() != null && !product.getBaseOptions().isEmpty()) {
            if (product.getVariantOptions() != null && product.getBaseOptions().size() == 1) {
                BaseOption newVariant = new BaseOption();
                newVariant.setVariantType(product.getVariantType());
                newVariant.setOptions(product.getVariantOptions());
                product.getBaseOptions().add(newVariant);

            }

            for (BaseOption productOption : product.getBaseOptions()) {
                if (productOption.getOptions() != null) {
                    if (StringUtils.equals(productOption.getVariantType(), B2CConstants.APPAREL_STYLE_VARIANT_PRODUCT)) {
                        populateSpinner(context, spinners.get(0), productOption.getOptions(), findVariantPosition(productOption.getOptions(), productOption.getSelected()));
                    }


                    if (StringUtils.equals(productOption.getVariantType(), B2CConstants.APPAREL_SIZE_VARIANT_PRODUCT)) {
                        for (VariantOption options : productOption.getOptions()) {

                            if (options.getVariantOptionQualifiers() != null && !options.getVariantOptionQualifiers().isEmpty()) {
                                for (VariantOptionQualifier qualifier : options.getVariantOptionQualifiers()) {
                                     if(qualifier != null) {
                                         if(StringUtils.equals(qualifier.getQualifier(), B2CConstants.VARIANT_SIZE)){
                                            VariantOptionQualifier newOptionQualifier = new VariantOptionQualifier();
                                             newOptionQualifier.setImage(qualifier.getImage());
                                             newOptionQualifier.setName(qualifier.getName());
                                             newOptionQualifier.setQualifier(qualifier.getQualifier());
                                             newOptionQualifier.setValue(qualifier.getValue());
                                             List<VariantOptionQualifier> newListQualifiers = new ArrayList<>();
                                             newListQualifiers.add(newOptionQualifier);
                                             options.setVariantOptionQualifiers(newListQualifiers);

                                         }
                                     }
                                }
                            }
                        }


                        VariantOption mSelectedVariantOption = new VariantOption();

                        //Select the current vairant selection
                        mSelectedVariantOption.setCode(product.getCode());

                        ProductHelper.populateSpinner(context, spinners.get(1),  productOption.getOptions(), resetChildSpinner ? 0 : ProductHelper.findVariantPosition( productOption.getOptions(), mSelectedVariantOption));
                    }
                }
            }

            return product.getBaseOptions().size();
        } else {
            return 0;
        }

    }





    /**
     * Fill Spinner list with arraylist of variantMatrixElement
     *
     * @param context
     * @param spinner
     * @param variants
     * @param position
     */
    public static void populateSpinner(Context context, Spinner spinner, List<VariantOption> variants, int position) {
        if (spinner != null && variants != null && !variants.isEmpty()) {
            VariantAdapter mVariantAdapter = new VariantAdapter(context, R.layout.item_product_variant, variants);
            spinner.setAdapter(mVariantAdapter);
            spinner.setPrompt(context.getString(R.string.choose_variant,
                    ((List<VariantOptionQualifier>) variants.get(0).getVariantOptionQualifiers()).get(0).getName()));
            spinner.setVisibility(View.VISIBLE);
            spinner.setSelection(position < variants.size() ? position : 0);
        }
    }

    /**
     * Use variantValueCategory code to find the default variant value with the category code
     *
     * @return default variant position
     */
    public static int findVariantPosition(List<VariantOption> options, VariantOption selected) {
        int position = 0;
        if (options != null && !options.isEmpty() && selected != null) {
            for (VariantOption variantOption : options) {
                if (StringUtils.equals(variantOption.getCode(), selected.getCode())) {
                    return position;
                }
                position++;
            }
        }
        return position;
    }

}
