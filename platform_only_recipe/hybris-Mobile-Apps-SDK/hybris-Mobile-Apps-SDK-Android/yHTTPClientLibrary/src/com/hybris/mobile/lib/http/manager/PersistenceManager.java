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
package com.hybris.mobile.lib.http.manager;

import android.widget.ImageView;

import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.DataResponseCallBack;

import java.util.Map;


/**
 * Interface to make the HTTP calls
 */
public interface PersistenceManager {

    /**
     * Make an asynchronous call and call ResponseReceiver.onReceiveResponse after result
     *
     * @param dataResponseCallBack Response callback result
     * @param requestId            Identifier for the call
     * @param method               Http Method
     * @param url                  Http Address
     * @param parameters           Map (name, value) of parameters to pass with the request
     * @param headers              Map (name, value) of headers to pass with the request
     * @param shouldCache          Indicator whether to get the results from the cache (if available)
     */
    void execute(final DataResponseCallBack dataResponseCallBack, final String requestId, String method, String url,
                 final Map<String, Object> parameters, final Map<String, String> headers, boolean shouldCache);

    /**
     * Get and set the image from the url to the imageView
     * @param url                           Http Address for Image
     * @param requestId                     Identifier for the call
     * @param imageView                     ImageView to be updated
     * @param onRequestListener             if no error in the process of executing this method. Note that this does not mean whether or not the
     *                                      request was a success.
     * @param forceImageTagToMatchRequestId if set to true, the imageView will set its tag with the requestId value and will verify after getting
     *                                      the image content from the url, that the tag is still equals to the requestId. If yes, the imageView is
     */
    void setImageFromUrl(String url, String requestId, final ImageView imageView,
                         OnRequestListener onRequestListener, boolean forceImageTagToMatchRequestId);

    /**
     * Get a cached object according to the key parameter
     *
     * @param key Unique code to get cached object
     * @return Cached object according to the key parameter
     */
    String getCache(String key);

    /**
     * Remove cache for a specific key
     *
     * @param key Unique code to removed cached object
     */
    void removeCache(String key);

    /**
     * Remove all items in the cache
     */
    void removeAllCache();

    /**
     * Cancel the requests associated with the id
     *
     * @param requestId Unique Request Identifier
     */
    void cancel(String requestId);

    /**
     * Cancel all the requests
     */
    void cancelAll();

    /**
     * Pause any current request
     */
    void pause();

    /**
     * Start or restart any pending request
     */
    void start();

    /**
     * Update the cache
     */
    void updateCache();


}
