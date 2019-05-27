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
package com.hybris.mobile.app.commerce.utils;

import android.util.Log;

import com.hybris.mobile.app.commerce.Constants;
import com.hybris.mobile.lib.commerce.data.product.Price;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Utils for UI
 */
public class ProductUtils {

    public static final String TAG = ProductUtils.class.getCanonicalName();

    /**
     * Sum up quantities to get total value price and round off to 2 digit
     *
     * @param quantity     : item quantity added
     * @param productPrice : price for single item
     * @return
     */
    public static String calculateQuantityPrice(String quantity, Price productPrice) {
        String total = "00.00";

        try {
            if (StringUtils.isNotBlank(quantity) && Integer.parseInt(quantity) > 0 && productPrice != null) {
                total = String.valueOf(Constants.PRICE_SMALL.format((Integer.parseInt(quantity) * productPrice
                        .getValue().doubleValue())));
            }
        } catch (NumberFormatException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

        return total;
    }

    /**
     * Find the real price for volume pricing product
     *
     * @param quantity
     * @param volumePrices
     * @return
     */
    public static Price findVolumePrice(String quantity, List<Price> volumePrices) {

        Price realPrice = null;

        if (volumePrices != null && StringUtils.isNotBlank(quantity)) {
            for (Price price : volumePrices) {

                if (price.getMinQuantity() <= Integer.parseInt(quantity)) {
                    realPrice = price;
                }
            }
        }

        return realPrice;

    }
}
