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
import android.widget.CursorAdapter;

import com.hybris.mobile.lib.commerce.provider.CatalogContract;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;

import org.apache.commons.lang3.StringUtils;


/**
 * Generic content loader with adapter
 */
public abstract class ContentAdapterLoader implements LoaderCallbacks<Cursor> {
    private static final String TAG = ContentAdapterLoader.class.getCanonicalName();
    protected final ContentServiceHelper mContentServiceHelper;
    protected final Context mContext;
    private final OnRequestListener mOnRequestListener;
    private CursorAdapter mCursorAdapter;
    private String mOrderBy;
    private int mLimitFrom = -1;
    private int mLimitTo = -1;

    public ContentAdapterLoader(Context context, ContentServiceHelper contentServiceHelper, CursorAdapter cursorAdapter, OnRequestListener onRequestListener) {
        mContext = context;
        mContentServiceHelper = contentServiceHelper;
        mOnRequestListener = onRequestListener;
        mCursorAdapter = cursorAdapter;
    }

    public void setCursorAdapter(CursorAdapter mCursorAdapter) {
        this.mCursorAdapter = mCursorAdapter;
    }

    public void setOrderBy(String mOrderBy) {
        this.mOrderBy = mOrderBy;
    }

    public void setLimitFrom(int mLimitFrom) {
        this.mLimitFrom = mLimitFrom;
    }

    public void setLimitTo(int mLimitTo) {
        this.mLimitTo = mLimitTo;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Before doing the request
        if (mOnRequestListener != null) {
            mOnRequestListener.beforeRequest();
        }

        // Order by and Limit
        String orderBy = CatalogContract.DataBaseDataSimple._ID;

        if (StringUtils.isNotBlank(mOrderBy)) {
            orderBy = mOrderBy;
        }

        if (mLimitFrom != -1 && mLimitTo != -1) {
            orderBy += " LIMIT " + mLimitFrom + ", " + mLimitTo;
        }

        return new CursorLoader(mContext, getUri(), null, null, null, orderBy);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if (mOnRequestListener != null) {
            mOnRequestListener.afterRequestBeforeResponse();
        }

        boolean isDataSynced = false;

        if (data != null) {
            Log.i(TAG, "Loader finished to load " + data.getCount() + " result(s)");

            mCursorAdapter.swapCursor(data);

            if (data.getCount() > 0) {
                isDataSynced = data.getInt(data.getColumnIndex(
                        CatalogContract.DataBaseDataSimple.ATT_STATUS)) == CatalogContract.SyncStatus.UPTODATE.getValue();
            }

        } else {
            isDataSynced = true;
        }

        if (mOnRequestListener != null) {
            mOnRequestListener.afterRequest(isDataSynced);
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }

    /**
     * Return the URI of the content provider
     *
     * @return String of characters used to identify a name of a resource
     */
    protected abstract Uri getUri();

}
