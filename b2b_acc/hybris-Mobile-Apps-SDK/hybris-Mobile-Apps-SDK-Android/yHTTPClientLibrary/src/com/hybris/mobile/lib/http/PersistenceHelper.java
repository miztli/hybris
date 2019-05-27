/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.lib.http;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.manager.PersistenceManager;
import com.hybris.mobile.lib.http.response.DataResponse;
import com.hybris.mobile.lib.http.response.DataResponseCallBack;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.response.ResponseCallback;
import com.hybris.mobile.lib.http.utils.ConnectionUtils;
import com.hybris.mobile.lib.http.utils.HttpUtils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * Helper to access the persistence manager
 */
public class PersistenceHelper {

    private static final String TAG = PersistenceHelper.class.getCanonicalName();
    public final static int CACHE_EXPIRE_IN_DAYS = 360;
    private boolean mUiRelated = true;
    private Context mContext;
    private PersistenceManager mPersistenceManager;
    private DataConverter mDataConverter;

    /**
     * @param context            the android context
     * @param persistenceManager the persistence manager to use for the HTTP calls
     * @param dataConverter      the data converter to use for the persistence manager to convert raw data results to java beans
     * @param uiRelated          flag to optimize performances in case the work is not UI related. Must be true if used on UI screens, false for only background jobs (sync job, etc.)
     */
    public PersistenceHelper(Context context, PersistenceManager persistenceManager, DataConverter dataConverter,
                             boolean uiRelated) {
        if (persistenceManager == null || context == null || dataConverter == null) {
            throw new IllegalArgumentException();
        }

        this.mPersistenceManager = persistenceManager;
        this.mDataConverter = dataConverter;
        this.mContext = context;
        this.mUiRelated = uiRelated;
    }

    /**
     * Execute a request for a URL
     *
     * @param responseReceiver Response callback result
     * @param getCachedResult  Whether or not we should get the cached result first. Determine also if we cache the result from the
     *                         call.
     * @param requestId        Identifier for the call
     * @param url              Http Address to the WebService
     * @param params           Map (name, value) of parameters to pass with the request
     * @param headers          Map (name, value) of headers to pass with the request
     * @param httpMethod       Method to use for the HTTP call
     * @return true If no error in the process of executing this method. Note that this does not mean whether or not the
     * request was a success.
     */
    private boolean executeRequest(DataResponseCallBack responseReceiver, boolean getCachedResult, final String requestId,
                                   String url, Map<String, Object> params, Map<String, String> headers, String httpMethod) {

        boolean isConnectedToInternet = ConnectionUtils.isConnectedToInternet(this.mContext);

        // Return the cached response if not connected
        if (!isConnectedToInternet) {
            boolean responseReturned = false;

            if (getCachedResult) {
                // Getting the cache
                if (StringUtils.isNotBlank(mPersistenceManager.getCache(HttpUtils.generateCacheKey(url,
                        HttpUtils.parametersToUrl(params))))) {
                    Log.d(TAG, "Cache for request " + url + " available.");
                    responseReceiver.onResponse(DataResponse.createSuccessResponse(
                            mPersistenceManager.getCache(HttpUtils.generateCacheKey(url, HttpUtils.parametersToUrl(params))), false));
                    responseReturned = true;
                } else {
                    Log.d(TAG, "Cache for request " + url + " empty.");
                }
            }

            // Return a no connection error message if no cache was returned
            if (!responseReturned) {
                responseReceiver.onError(DataResponse.createErrorResponse(mDataConverter.createErrorMessage(
                        mContext.getString(R.string.error_no_connection), Constants.ERROR_TYPE_NO_CONNECTION), false));
            }

        }
        //Else execute the call
        else {
            // Remove the cache first
            if (getCachedResult) {
                mPersistenceManager.removeCache(HttpUtils.generateCacheKey(url, HttpUtils.parametersToUrl(params)));
            }

            mPersistenceManager.execute(responseReceiver, requestId, httpMethod, url, params, headers, getCachedResult);
        }

        return true;

    }

    /**
     * Execute the request then convert the results into the generic T response
     *
     * @param responseReceiver    Response callback result
     * @param dataConverterHelper Helper to convert the result into a POJO
     * @param getCachedResult     Indicator to use cache or not * @param requestId Identifier for the call
     * @param url                 Url to call
     * @param parameters          Call parameters
     * @param headers             Call parameters headers
     * @param httpMethod          Http method: GET, POST, PUT, DELETE
     * @return Generic Type response
     */
    public <T, Z> boolean execute(final ResponseCallback<T, Z> responseReceiver,
                                  final DataConverter.Helper<T, Z> dataConverterHelper, boolean getCachedResult, final String requestId, String url,
                                  Map<String, Object> parameters, Map<String, String> headers, String httpMethod) {

        DataResponseCallBack dataResponseCallBack = new DataResponseCallBack() {

            @Override
            public void onResponse(DataResponse dataResponse) {

                try {
                    final Response<T> response;

                    // Conversion with the DataConverter
                    if (StringUtils.isBlank(dataConverterHelper.getPropertyName())) {
                        response = Response.createResponse(
                                mDataConverter.convertFrom(dataConverterHelper.getClassName(), dataResponse.getData()), requestId,
                                dataResponse.isSync());
                    } else {
                        response = Response.createResponse(mDataConverter.convertFrom(dataConverterHelper.getClassName(),
                                dataResponse.getData(), dataConverterHelper.getPropertyName()), requestId, dataResponse.isSync());
                    }

                    if (mUiRelated) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                responseReceiver.onResponse(response);
                            }
                        });
                    } else {
                        responseReceiver.onResponse(response);
                    }

                }
                // Conversion error, we return the response with the error message
                catch (DataConverterException e) {
                    handleGenericError(responseReceiver, dataResponse, dataConverterHelper, requestId);
                }
            }

            @Override
            public void onError(final DataResponse dataResponse) {

                try {
                    final Response<Z> response = Response.createResponse(
                            mDataConverter.convertFrom(dataConverterHelper.getErrorClassName(), dataResponse.getData()), requestId,
                            dataResponse.isSync());

                    if (mUiRelated) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                responseReceiver.onError(response);
                            }
                        });
                    } else {
                        responseReceiver.onError(response);
                    }

                }
                // Conversion error, we return the response with the error message
                catch (DataConverterException e) {
                    handleGenericError(responseReceiver, dataResponse, dataConverterHelper, requestId);
                }

            }
        };

        return executeRequest(dataResponseCallBack, getCachedResult, requestId, url, parameters, headers, httpMethod);

    }

    /**
     * Create a proper json error and send the response through the ResponseCallBack
     *
     * @param responseReceiver    Data returned after REST Call
     * @param dataResponse        ResponseCallBack
     * @param dataConverterHelper Transform Data from JSON into a POJO
     * @param requestId           Unique Request Identifier
     */
    private <Z, T> void handleGenericError(final ResponseCallback<T, Z> responseReceiver, DataResponse dataResponse, DataConverter.Helper<T, Z> dataConverterHelper,
                                           String requestId) {
        String errorMsg = dataResponse.getData();

        // Unknown error if no message coming from the http layer
        if (StringUtils.isBlank(errorMsg)) {
            errorMsg = mContext.getString(R.string.error_unknown);
        }

        errorMsg = StringEscapeUtils.escapeEcmaScript(errorMsg);

        try {
            final Response<Z> response = Response.createResponse(
                    mDataConverter.convertFrom(dataConverterHelper.getErrorClassName(),
                            mDataConverter.createErrorMessage(errorMsg, Constants.ERROR_TYPE_UNKNOWN)), requestId,
                    dataResponse.isSync());

            if (mUiRelated) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        responseReceiver.onError(response);
                    }
                });
            } else {
                responseReceiver.onError(response);
            }

        } catch (DataConverterException e1) {
            throw new IllegalArgumentException(e1.getLocalizedMessage());
        }

    }

    /**
     * Get and set the image from the url to the imageView
     *
     * @param url                           Http Address for Image
     * @param requestId                     Identifier for the call
     * @param imageView                     ImageView to be updated
     * @param width                         Horizontal size in pixels (or 0 for automatic)
     * @param height                        Vertical size in pixels (or 0 for automatic)
     * @param config                        Bitmap configurations to apply on the image
     * @param getCachedResult               Whether or not we should set the image with the cached result first. Determine also if we cache the
     *                                      image from the call.
     * @param onRequestListener             Its methods will be called when the request is sent
     * @param forceImageTagToMatchRequestId If set to true, the imageView will set its tag with the requestId value and will verify after getting
     *                                      the image content from the url, that the tag is still equals to the requestId. If yes, the imageView is
     *                                      updated with the content just pulled.
     * @return True when Method is called
     */
    public boolean setImageFromUrl(String url, String requestId, ImageView imageView, int width, int height, Config config,
                                   boolean getCachedResult, OnRequestListener onRequestListener, boolean forceImageTagToMatchRequestId) {
        mPersistenceManager.setImageFromUrl(url, requestId, imageView, onRequestListener,
                forceImageTagToMatchRequestId);

        return true;
    }

    /**
     * Cancel all the request associated with the id
     *
     * @param requestId Identifier for the call
     */
    public void cancel(String requestId) {
        mPersistenceManager.cancel(requestId);
    }

    /**
     * Cancel all the request
     */
    public void cancelAll() {
        mPersistenceManager.cancelAll();
    }

    /**
     * Pause any current work
     */
    public void pause() {
        mPersistenceManager.pause();
    }

    /**
     * Start or restart any pending work
     */
    public void start() {
        mPersistenceManager.start();
    }

    /**
     * Update the cache
     */
    public void updateCache() {
        mPersistenceManager.updateCache();
    }

}
