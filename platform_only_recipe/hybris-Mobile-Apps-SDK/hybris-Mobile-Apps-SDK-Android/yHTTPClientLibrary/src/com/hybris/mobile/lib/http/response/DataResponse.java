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
package com.hybris.mobile.lib.http.response;


/**
 * Raw data response object
 */
public class DataResponse {

    private final boolean sync;
    private final String data;

    private DataResponse(String data, boolean sync) {
        this.sync = sync;
        this.data = data;
    }

    public static DataResponse createSuccessResponse(String data, boolean sync) {
        return new DataResponse(data, sync);
    }

    public static DataResponse createErrorResponse(String data, boolean sync) {
        return new DataResponse(data, sync);
    }

    public boolean isSync() {
        return sync;
    }

    public String getData() {
        return data;
    }

}
