/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.app.commerce.utils;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Utils for regex
 */
public class RegexUtils {

    private static final Pattern ORDER_CODE_PATTERN = Pattern.compile(CommerceApplication.getContext().getString(
            R.string.regex_order_code_scan));
    private static final Pattern ADD_TO_CART_PATTERN = Pattern.compile(CommerceApplication.getContext().getString(
            R.string.regex_add_to_cart));

    /**
     * Try to identify and return a product code from the value and according to the different regex
     *
     * @param value
     * @return
     */
    public static String getProductCode(String value) {
        String productCode = "";

        // Getting the hybris product code regex patterns
        String[] listRegexProducts = CommerceApplication.getContext().getResources().getStringArray(R.array.regex_products);

        if (listRegexProducts != null) {

            boolean isProductMatching = false;
            int i = 0;

            // We continue while we have no match for the value
            while (!isProductMatching && i < listRegexProducts.length) {

                Pattern productPattern = Pattern.compile(listRegexProducts[i]);

                productCode = applyPattern(productPattern, value, 1).get(0);

                isProductMatching = StringUtils.isNotEmpty(productCode);

                i++;
            }

        }

        return productCode;

    }

    /**
     * Return a order code from the value according to the regex "regex_hybris_order_code_scan_pattern" in regex.xml
     *
     * @param value
     * @return
     */
    public static String getOrderCode(String value) {
        return applyPattern(ORDER_CODE_PATTERN, value, 1).get(0);
    }

    public static List<String> getAddToCart(String value) {
        List<String> productAndQty = applyPattern(ADD_TO_CART_PATTERN, value, 2);

        if (productAndQty != null) {
            if (productAndQty.size() == 1 && StringUtils.isBlank(productAndQty.get(0))) {
                productAndQty = null;
            } else if (productAndQty.size() == 2 && StringUtils.isNotBlank(productAndQty.get(1))) {
                // First character is a /
                productAndQty.set(1, productAndQty.get(1).substring(1));
            }
        }

        return productAndQty;
    }

    /**
     * Return true if the value is valid according to the regex
     *
     * @param value
     * @param regex
     * @return
     */
    public static boolean isValid(String value, String regex) {
        return Pattern.compile(regex).matcher(value).matches();
    }

    /**
     * Apply a regex pattern on a value and return the match
     *
     * @param pattern
     * @param value
     * @return
     */
    private static List<String> applyPattern(Pattern pattern, String value, int numberOfElementToMatch) {

        List<String> returnValues = new ArrayList<>();

        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {

            if (matcher.groupCount() == numberOfElementToMatch) {
                for (int i = 1; i <= numberOfElementToMatch; i++) {
                    returnValues.add(matcher.group(i));
                }
            }

        }

        if (returnValues.isEmpty()) {
            returnValues.add("");
        }

        return returnValues;

    }
}
