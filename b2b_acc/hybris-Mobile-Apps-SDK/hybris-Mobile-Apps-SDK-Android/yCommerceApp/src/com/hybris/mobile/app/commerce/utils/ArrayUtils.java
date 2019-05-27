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

import org.apache.commons.lang3.StringUtils;

/**
 * Utils for arrays
 */
public class ArrayUtils {

    /**
     * Return the index of the value in the tab, tab.length if value not found
     *
     * @param tabToSearch
     * @param valueToSearch
     * @return
     */
    public static int indexOf(String[] tabToSearch, String valueToSearch) {
        int indexKey = 0;
        boolean keyFound = false;

        // Looking for the value index in the value tab
        while (!keyFound && indexKey < tabToSearch.length) {

            if (StringUtils.equals(tabToSearch[indexKey], valueToSearch)) {
                keyFound = true;
            } else {
                indexKey++;
            }

        }

        if (!keyFound) {
            indexKey--;
        }

        return indexKey;
    }
}
