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

package com.hybris.mobile.lib.commerce.loader;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.provider.CatalogContract;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.Constants;
import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.converter.DataConverter.Helper;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;


/**
 * Generic content loader
 *
 * @param <T>
 */
public abstract class ContentLoader<T> implements LoaderCallbacks<Cursor> {
    private static final String TAG = ContentLoader.class.getCanonicalName();
    protected final ContentServiceHelper mContentServiceHelper;
    private final OnRequestListener mOnRequestListener;
    private final ResponseReceiver<T> mResponseReceiver;
    private final Helper<T, ErrorList> mDataConverterHelper;
    protected final Context mContext;

    public ContentLoader(Context context, ContentServiceHelper contentServiceHelper, ResponseReceiver<T> responseReceiver,
                         DataConverter.Helper<T, ErrorList> dataConverterHelper, OnRequestListener onRequestListener) {
        mContext = context;
        mContentServiceHelper = contentServiceHelper;
        mResponseReceiver = responseReceiver;
        mDataConverterHelper = dataConverterHelper;
        mOnRequestListener = onRequestListener;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Before doing the request
        if (mOnRequestListener != null) {
            mOnRequestListener.beforeRequest();
        }

        return new CursorLoader(mContext, getUri(), null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.i(TAG, "Loader finished to load " + data.getCount() + " result(s)");

        if (mOnRequestListener != null) {
            mOnRequestListener.afterRequestBeforeResponse();
        }

        boolean isDataSynced;

        // Return the response
        if (mResponseReceiver != null && data.getCount() > 0) {

            isDataSynced = data.getInt(data.getColumnIndex(
                    CatalogContract.DataBaseData.ATT_STATUS)) == CatalogContract.SyncStatus.UPTODATE.getValue();

            // Response callback
            try {
                mResponseReceiver.onResponse(Response.createResponse(
                        mContentServiceHelper.getDataConverter().convertFrom(mDataConverterHelper.getClassName(),
                                data.getString(data.getColumnIndex(CatalogContract.DataBaseData.ATT_DATA))), null, isDataSynced));
            }
            // Conversion error, we return the response with the error message
            catch (DataConverterException e) {
                try {

                    mResponseReceiver.onError(Response.createResponse(
                            mContentServiceHelper.getDataConverter().convertFrom(
                                    mDataConverterHelper.getErrorClassName(),
                                    mContentServiceHelper.getDataConverter().createErrorMessage(
                                            data.getString(data.getColumnIndex(CatalogContract.DataBaseData.ATT_DATA)),
                                            Constants.ERROR_TYPE_UNKNOWN)), null, isDataSynced));
                } catch (DataConverterException e1) {

                    // After doing the request
                    if (mOnRequestListener != null) {
                        mOnRequestListener.afterRequest(isDataSynced);
                    }

                    throw new IllegalArgumentException(e1.getLocalizedMessage());
                }
            }

        } else {
            isDataSynced = true;
        }

        // After doing the request
        if (mOnRequestListener != null) {
            mOnRequestListener.afterRequest(isDataSynced);
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /**
     * Return the URI of the content provider
     *
     * @return String of characters used to identify a name of a resource
     */
    protected abstract Uri getUri();

}
