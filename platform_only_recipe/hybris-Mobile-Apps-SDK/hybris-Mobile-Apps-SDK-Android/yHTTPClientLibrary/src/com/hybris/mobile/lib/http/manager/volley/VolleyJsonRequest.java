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

package com.hybris.mobile.lib.http.manager.volley;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hybris.mobile.lib.http.utils.HttpUtils;

import org.json.JSONObject;


/**
 * Extension of the JsonObjectRequest changing the way we get the cache key
 */
class VolleyJsonRequest extends JsonObjectRequest {

    public VolleyJsonRequest(int method, String url, JSONObject jsonRequest, Listener<JSONObject> listener,
                             ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    public String getCacheKey() {
        String parameters = new String(getBody());
        return HttpUtils.generateCacheKey(super.getCacheKey(), parameters);
    }

}
