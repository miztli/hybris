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

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Utilities for http related
 */
public class HttpUtils {
    private static final String TAG = HttpUtils.class.getCanonicalName();

    public final static String HTTP_METHOD_GET = "GET";
    public final static String HTTP_METHOD_HEAD = "HEAD";
    public final static String HTTP_METHOD_POST = "POST";
    public final static String HTTP_METHOD_PUT = "PUT";
    public final static String HTTP_METHOD_PATCH = "PATCH";
    public final static String HTTP_METHOD_DELETE = "DELETE";

    public final static String ENCODING_UTF8 = "UTF-8";

    public final static String URL_AMPERSTAND = "&";
    private final static String URL_PARAMETERS_EQUALS = "=";
    public final static String URL_QUESTION_MARK = "?";

    public final static String CONTENT_TYPE_URLENC = "application/x-www-form-urlencoded; charset=utf-8";

    private HttpUtils() {
    }

    /**
     * Encode the parameter to be valid within an url
     *
     * @param parameter String of character to be encoded
     * @return Encoded String of character
     */
    public static String encode(String parameter) {
        return parameter.replaceAll(" ", "%20");
//        try {
//            return URLEncoder.encode(parameter, ENCODING_UTF8);
//        } catch (UnsupportedEncodingException e) {
//            Log.e(TAG, "Error encoding string \"" + parameter + "\". Details:" + e.getLocalizedMessage());
//            return parameter;
//        }
    }

    /**
     * Construct the parameters for a URL based on a Map of parameters
     *
     * @param parameters Key Value argument to be append
     * @return Structure String of character in URL
     */
    public static String parametersToUrl(Map<String, Object> parameters) {
        if (parameters != null) {

            StringBuilder sb = new StringBuilder();

            for (Entry<String, Object> entry : parameters.entrySet()) {
                if (entry.getValue() != null) {

                    try {
                        sb.append(URLEncoder.encode(entry.getKey(), ENCODING_UTF8));
                        sb.append(URL_PARAMETERS_EQUALS);
                        sb.append(URLEncoder.encode(entry.getValue().toString(), ENCODING_UTF8));
                    } catch (UnsupportedEncodingException e) {
                        Log.e(TAG, "Error encoding parameters in " + ENCODING_UTF8 + ". Details: " + e.getLocalizedMessage());
                    }

                    sb.append(URL_AMPERSTAND);

                }
            }

            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * Generate a cache key
     *
     * @param key        String of character to be cache
     * @param parameters Arguments
     * @return Generated cache key
     */
    public static String generateCacheKey(String key, String parameters) {
        return key + parameters;
    }
}
