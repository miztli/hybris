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
package com.hybris.mobile.lib.http.utils;

import java.util.UUID;


/**
 * Utilities for request related
 */
public class RequestUtils {

    /**
     * Generate a unique identifier for your request
     *
     * @return Unique String of character identifying the request
     */
    public static String generateUniqueRequestId() {
        return UUID.randomUUID().toString();
    }

}
