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

package com.hybris.mobile.lib.commerce.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.widget.CursorAdapter;

import com.hybris.mobile.lib.commerce.provider.CatalogContract;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;


/**
 * Catalog cursor adapter for raw data
 *
 * @param <T>
 */
public abstract class CatalogCursorAdapter<T> extends CursorAdapter {

    private final Class<T> mClassName;
    private final Context mContext;
    private final ContentServiceHelper mContentServiceHelper;

    public CatalogCursorAdapter(Context context, Cursor c, int flags, Class<T> className, ContentServiceHelper contentServiceHelper) {
        super(context, c, flags);
        mClassName = className;
        mContext = context;
        mContentServiceHelper = contentServiceHelper;
    }

    protected T getData() {
        try {
            return mContentServiceHelper.getDataConverter().convertFrom(mClassName,
                    getCursor().getString(getCursor().getColumnIndex(CatalogContract.DataBaseDataSimple.ATT_DATA)));
        } catch (DataConverterException e1) {
            throw new IllegalArgumentException(e1.getLocalizedMessage());
        }
    }

    protected Activity getContext() {
        return (Activity) mContext;
    }
}
