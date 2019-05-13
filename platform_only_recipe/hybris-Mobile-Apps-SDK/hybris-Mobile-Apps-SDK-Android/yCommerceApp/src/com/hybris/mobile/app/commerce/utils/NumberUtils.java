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

/**
 * Utils for numbers
 */
public class NumberUtils {

    /**
     * Convert a String to a int
     *
     * @param number
     * @return
     */
    public static int convertToInt(String number) {

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    /**
     * Convert a String to a double
     *
     * @param number
     * @return
     */
    public static double convertToDouble(String number) {

        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return -1;
        }

    }

}
