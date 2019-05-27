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
package com.hybris.mobile.lib.http.converter.exception;

/**
 * Exception related to data conversion
 */
public class DataConverterException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataConverterException() {
        super();
    }

    public DataConverterException(String message) {
        super(message);
    }

    public DataConverterException(String message, Throwable e) {
        super(message, e);
    }
}
