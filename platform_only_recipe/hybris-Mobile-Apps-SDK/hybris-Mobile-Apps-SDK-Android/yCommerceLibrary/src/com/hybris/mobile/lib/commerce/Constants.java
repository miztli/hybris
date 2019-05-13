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
package com.hybris.mobile.lib.commerce;

public class Constants {
    public static final String ERROR_TYPE_INVALIDTOKENERROR = "InvalidTokenError";
    public static final String ERROR_TYPE_UNAUTHORIZEDERROR = "UnauthorizedError";
    public static final String ERROR_REASON_CART_NOT_FOUND = "notFound";
    public static final String ERROR_TYPE_CART_ERROR = "CartError";

    public static final int CATALOG_MAX_PAGE_SIZE = 100;

    public static final String STORE_DAY_MON = "Mon";
    public static final String STORE_DAY_TUE = "Tue";
    public static final String STORE_DAY_WED = "Wed";
    public static final String STORE_DAY_THU = "Thu";
    public static final String STORE_DAY_FRI = "Fri";
    public static final String STORE_DAY_SAT = "Sat";
    public static final String STORE_DAY_SUN = "Sun";

    public static class Login {

        public static final String PARAM_REFRESH_TOKEN = "refresh_token";
        public static final String PARAM_GRANT_TYPE = "grant_type";
        public static final String PARAM_CLIENT_SECRET = "client_secret";
        public static final String PARAM_CLIENT_ID = "client_id";
        public static final String PARAM_HEADER_AUTHORIZATION = "Authorization";
        public static final String AUTHORIZATION = "mobile_android:secret";
        public static final String GRANT_TYPE_LOGIN = "password";
        public static final String GRANT_TYPE_ROLE_CLIENT = "client_credentials";
        public static final String GRANT_TYPE_TOKEN = "refresh_token";
        public static final String CLIENT_ID = "mobile_android";
        public static final String CLIENT_SECRET = "secret";

    }
}
