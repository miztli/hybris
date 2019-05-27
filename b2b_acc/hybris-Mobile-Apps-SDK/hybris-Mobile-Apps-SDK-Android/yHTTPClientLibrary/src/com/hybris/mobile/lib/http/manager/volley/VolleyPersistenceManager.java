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
package com.hybris.mobile.lib.http.manager.volley;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.ExecutorDelivery;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.JsonRequest;
import com.hybris.mobile.lib.http.PersistenceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.manager.PersistenceManager;
import com.hybris.mobile.lib.http.response.DataResponse;
import com.hybris.mobile.lib.http.response.DataResponseCallBack;
import com.hybris.mobile.lib.http.utils.HttpUtils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;


/**
 * Persistence manager implementation based on Volley library
 * (https://android.googlesource.com/platform/frameworks/volley/)
 */
public class VolleyPersistenceManager implements PersistenceManager {

    private static final String TAG = VolleyPersistenceManager.class.getCanonicalName();
    private static final String HEADER_DATE = "Date";
    private static final String HEADER_ETAG = "ETag";
    private static final int THREAD_POOL_SIZE = 4;
    protected RequestQueue mQueue;
    protected ImageLoader mImageLoader;

    public VolleyPersistenceManager(Context applicationContext) {
        this(applicationContext.getApplicationContext(), null, null);
    }

    public VolleyPersistenceManager(Context applicationContext, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {

        if (hostnameVerifier != null) {
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        }

        // One queue using background threads for callbacks
        this.mQueue = newRequestQueueBackgroundThread(applicationContext.getApplicationContext(), sslSocketFactory);

        // Image loader using regular queue from Volley
        this.mImageLoader = new ImageLoader(newRequestQueueBackgroundThread(applicationContext.getApplicationContext(), sslSocketFactory), new BitmapCache());
    }

    /**
     * This method create a new RequestQueue that returns the callbacks in a background thread and not the UI thread
     *
     * @param context          the android context
     * @param sslSocketFactory the SSL factory for the calls
     * @return the RequestQueue created
     */
    protected RequestQueue newRequestQueueBackgroundThread(Context context, SSLSocketFactory sslSocketFactory) {
        // This code comes from the official volley library
        File cacheDir = new File(context.getCacheDir(), "volley");

        String userAgent = "volley/0";
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            userAgent = packageName + "/" + info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, userAgent + " : " + e.getMessage());

        }

        Network network = new BasicNetwork(new HurlStack(null, sslSocketFactory));

        // This code allows the callback to be returned in a background thread and not the UI thread
        ResponseDelivery responseDelivery = new ExecutorDelivery(Executors.newFixedThreadPool(THREAD_POOL_SIZE));
        RequestQueue queue = new RequestQueue(new DiskBasedCache(cacheDir), network, THREAD_POOL_SIZE, responseDelivery);
        queue.start();

        return queue;
    }

    @Override
    public void execute(final DataResponseCallBack dataResponseCallBack, final String requestId, String method, String url,
                        final Map<String, Object> parameters, final Map<String, String> headers, boolean shouldCache) {

        int intMethod = 0;

        if (StringUtils.equals(method, HttpUtils.HTTP_METHOD_GET)) {
            intMethod = Method.GET;
        } else if (StringUtils.equals(method, HttpUtils.HTTP_METHOD_HEAD)) {
            intMethod = Method.HEAD;
        } else if (StringUtils.equals(method, HttpUtils.HTTP_METHOD_POST)) {
            intMethod = Method.POST;
        } else if (StringUtils.equals(method, HttpUtils.HTTP_METHOD_PUT)) {
            intMethod = Method.PUT;
        } else if (StringUtils.equals(method, HttpUtils.HTTP_METHOD_PATCH)) {
            intMethod = Method.PATCH;
        } else if (StringUtils.equals(method, HttpUtils.HTTP_METHOD_DELETE)) {
            intMethod = Method.DELETE;
        }

        // Adding the request to the queue
        addToQueue(buildJsonObjectRequest(dataResponseCallBack, requestId, intMethod, url, parameters, headers),
                requestId,
                shouldCache);
    }

    @Override
    public void setImageFromUrl(final String url, final String requestId, final ImageView imageView,
                                final OnRequestListener onRequestListener,
                                final boolean forceImageTagToMatchRequestId) {

        if (onRequestListener != null) {
            onRequestListener.beforeRequest();
        }

        mImageLoader.get(url, new ImageListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error loading the image for url \"" + url + "\". " + error.getLocalizedMessage());

                if (onRequestListener != null) {
                    onRequestListener.afterRequest(false);
                }
            }

            @Override
            public void onResponse(ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null && imageView != null) {
                    boolean loadImage = true;

                    if (forceImageTagToMatchRequestId && imageView.getTag() != null
                            && !StringUtils.equals(requestId, imageView.getTag().toString())) {
                        loadImage = false;
                    }

                    if (loadImage) {
                        imageView.setImageBitmap(response.getBitmap());
                    }

                    if (onRequestListener != null) {
                        onRequestListener.afterRequest(true);
                    }
                }
            }
        });

    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#getCache(java.lang.String, java.util.Map)
     */
    @Override
    public String getCache(String key) {
        if (mQueue.getCache() != null && mQueue.getCache().get(key) != null) {
            // Get the cache
            byte[] responseBytes = mQueue.getCache().get(key).data;

            return responseBytes != null ? new String(responseBytes) : "";
        }

        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#removeCache(java.lang.String, java.util.Map)
     */
    @Override
    public void removeCache(String key) {
        if (mQueue.getCache() != null && mQueue.getCache().get(key) != null) {
            // Invalidate the cache
            mQueue.getCache().remove(key);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#removeAllCache()
     */
    @Override
    public void removeAllCache() {
        if (mQueue.getCache() != null) {
            mQueue.getCache().clear();
        }
    }

    /**
     * Add a request object to the Volley queue and set the cache parameter
     *
     * @param request     REST call at a given URL
     * @param requestId   Unique request identifier
     * @param shouldCache true will cache request else no cache is set
     */
    protected void addToQueue(JsonRequest request, String requestId, boolean shouldCache) {
        // Cache or not
        request.setShouldCache(shouldCache);

        // Tag
        if (requestId != null) {
            request.setTag(requestId);
        }

        mQueue.add(request);
    }

    /**
     * Build a request for a JsonObjectRequest
     *
     * @param dataResponseCallBack Interface for receiving a Response callback result
     * @param requestId            Unique request identifier
     * @param method               HTTP Methods : GET, PUT, POST, DELETE, UPDATE, PATCH
     * @param url                  Path of the REST
     * @param parameters           Arguments to provide a given request
     * @param headers              Key and Value to send
     * @return A request for retrieving a T type response body at a given URL that also optionally sends along a JSON body in the request specified.
     */
    protected JsonRequest buildJsonObjectRequest(final DataResponseCallBack dataResponseCallBack, final String requestId,
                                                 int method, String url, final Map<String, Object> parameters, final Map<String, String> headers) {

        JSONObject parametersJsonObject = null;
        final String urlFinal;

        if (parameters != null) {

            switch (method) {
                // For Get calls we put the parameters in the URL
                case Method.GET:

                    // Some parameters already there
                    if (url.contains(HttpUtils.URL_QUESTION_MARK)) {
                        url += HttpUtils.URL_AMPERSTAND + HttpUtils.parametersToUrl(parameters);
                    } else {
                        url += HttpUtils.URL_QUESTION_MARK + HttpUtils.parametersToUrl(parameters);
                    }

                    break;

                default:
                    parametersJsonObject = new JSONObject(parameters);
                    break;
            }

        }

        urlFinal = url;

        // Doing the request
        return new VolleyJsonRequest(method, urlFinal, parametersJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {
                Log.i(TAG, "Success with the Volley request " + urlFinal);

                if (dataResponseCallBack != null) {
                    dataResponseCallBack.onResponse(DataResponse.createSuccessResponse(response.toString(), true));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMsg = error.getLocalizedMessage();

                if (error.networkResponse != null && error.networkResponse.data != null) {
                    errorMsg = new String(error.networkResponse.data);
                }

                if (StringUtils.isBlank(errorMsg)) {
                    errorMsg = error.toString();
                }

                final String errorMsgFinal = errorMsg;

                Log.e(TAG, "Error with the Volley request " + requestId + ": " + errorMsg);
                if (dataResponseCallBack != null) {
                    dataResponseCallBack.onError(DataResponse.createErrorResponse(errorMsgFinal, true));
                }

            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers != null) {
                    return new HashMap<>(headers);
                } else {
                    return Collections.emptyMap();
                }
            }

            @Override
            public byte[] getBody() {
                String returnParams = HttpUtils.parametersToUrl(parameters);

                if (StringUtils.isNotBlank(returnParams)) {
                    return returnParams.getBytes();
                } else {
                    return new byte[0];
                }
            }

            @Override
            public String getBodyContentType() {
                return HttpUtils.CONTENT_TYPE_URLENC;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    String jsonString = new String(response.data, HttpUtils.ENCODING_UTF8);
                    JSONObject jsonObject = new JSONObject();

                    if (StringUtils.isNotBlank(jsonString)) {
                        jsonObject = new JSONObject(jsonString);
                    }

                    jsonObject.put("xTotalCount", response.headers.get("X-Total-Count"));

                    return Response.success(jsonObject, ignoreCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException je) {
                    return Response.error(new ParseError(je));
                }
            }

        };

    }

    /**
     * Ignore cache headers on Webservice response
     *
     * @param response Data and Headers
     * @return Data and metadata for entry returned by the cache
     */
    protected Cache.Entry ignoreCacheHeaders(NetworkResponse response) {
        long now = System.currentTimeMillis();

        // In PersistenceHelper.CACHE_EXPIRE_IN_DAY cache will be refreshed on
        // background
        long cacheHitButRefreshed = PersistenceHelper.CACHE_EXPIRE_IN_DAYS * 60 * 60 * 60 * 1000;

        // In PersistenceHelper.CACHE_EXPIRE_IN_DAY cache will expire completely
        long cacheExpired = PersistenceHelper.CACHE_EXPIRE_IN_DAYS * 60 * 60 * 60 * 1000;

        Map<String, String> headers = response.headers;

        long serverDate = 0;
        String serverEtag;
        String headerValue;

        headerValue = headers.get(HEADER_DATE);
        if (headerValue != null) {
            try {
                // Parse date in RFC1123 format if this header contains one
                serverDate = org.apache.commons.lang3.time.DateUtils.parseDate(headerValue, "EEE, dd MMM yyyy HH:mm:ss zzz").getTime();
            } catch (ParseException e) {
                Log.e(TAG, "Error parsing date. Details: " + e.getLocalizedMessage());
                // Date in invalid format, fallback to 0
                serverDate = 0;
            }
        }

        serverEtag = headers.get(HEADER_ETAG);

        long softExpire = now + cacheHitButRefreshed;
        long ttl = now + cacheExpired;

        Cache.Entry entry = new Cache.Entry();
        entry.data = response.data;
        entry.etag = serverEtag;
        entry.softTtl = softExpire;
        entry.ttl = ttl;
        entry.serverDate = serverDate;
        entry.responseHeaders = headers;

        return entry;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#cancel(java.lang.String)
     */
    @Override
    public void cancel(String requestId) {
        mQueue.cancelAll(requestId);
    }

    @Override
    public void cancelAll() {
        mQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#pause()
     */
    @Override
    public void pause() {
        mQueue.stop();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#start()
     */
    @Override
    public void start() {
        mQueue.start();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hybris.mobile.lib.http.manager.PersistenceManager#updateCache()
     */
    @Override
    public void updateCache() {
        this.mQueue.getCache().initialize();
    }

}
