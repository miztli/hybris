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

package com.hybris.mobile.lib.commerce.provider;

import android.content.Context;
import android.database.AbstractCursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;


/**
 * Helper for the catalog database
 */
public class CatalogDatabaseHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_TABLE_DATA = "CREATE TABLE " + CatalogContract.DataBaseDataSimple.TABLE_NAME + "  (" +
            CatalogContract.DataBaseDataSimple._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CatalogContract.DataBaseDataSimple.ATT_DATA_ID
            + " TEXT, " + CatalogContract.DataBaseDataSimple.ATT_DATA + " TEXT, " + CatalogContract.DataBaseDataSimple.ATT_STATUS + " " +
            "INTEGER, UNIQUE(" + CatalogContract.DataBaseDataSimple.ATT_DATA_ID + "))";

    private static final String SQL_CREATE_TABLE_DATA_DETAILS = "CREATE TABLE " + CatalogContract.DataBaseDataDetails.TABLE_NAME + "  (" +
            CatalogContract.DataBaseDataDetails._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CatalogContract.DataBaseDataDetails.ATT_DATA_ID
            + " TEXT, " + CatalogContract.DataBaseDataDetails.ATT_DATA + " TEXT, " + CatalogContract.DataBaseDataDetails.ATT_STATUS + " " +
            "INTEGER, UNIQUE(" + CatalogContract.DataBaseDataDetails.ATT_DATA_ID + "))";

    private static final String SQL_CREATE_TABLE_DATA_LINK_GROUP = "CREATE TABLE " + CatalogContract.DataBaseDataLinkGroup
            .TABLE_NAME + "  (" + CatalogContract.DataBaseDataLinkGroup._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID + " TEXT, " + CatalogContract.DataBaseDataLinkGroup
            .ATT_GROUP_ID + " TEXT, UNIQUE(" + CatalogContract.DataBaseDataLinkGroup.ATT_GROUP_ID + ", " +
            "" + CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID + "))";

    private static final String SQL_CREATE_TABLE_SYNC_STATUS_GROUP = "CREATE TABLE " + CatalogContract.DataBaseSyncStatusGroup
            .TABLE_NAME + "  (" + CatalogContract.DataBaseSyncStatusGroup._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + CatalogContract.DataBaseSyncStatusGroup.ATT_GROUP_ID + " TEXT, " + CatalogContract.DataBaseSyncStatusGroup
            .ATT_STATUS + " TEXT, UNIQUE(" + CatalogContract.DataBaseSyncStatusGroup.ATT_GROUP_ID + "))";

    public CatalogDatabaseHelper(Context context, String dbName, int dbVersion) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_DATA);
        db.execSQL(SQL_CREATE_TABLE_DATA_DETAILS);
        db.execSQL(SQL_CREATE_TABLE_DATA_LINK_GROUP);
        db.execSQL(SQL_CREATE_TABLE_SYNC_STATUS_GROUP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CatalogContract.DataBaseDataSimple.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CatalogContract.DataBaseDataDetails.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CatalogContract.DataBaseDataLinkGroup.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME);
        onCreate(db);
    }

    /**
     * Create a cursor based on the data
     *
     * @param dataList the data to inject in the cursor with
     * @return Read-write access to the result set returned by a database query
     */
    public static AbstractCursor createCursor(List<CatalogContract.DataBaseDataSimple> dataList) {
        if (dataList != null) {
            MatrixCursor cursorProduct = new MatrixCursor(
                    new String[]{CatalogContract.DataBaseDataSimple._ID, CatalogContract.DataBaseDataSimple.ATT_DATA_ID,
                            CatalogContract.DataBaseDataSimple.ATT_DATA, CatalogContract.DataBaseDataSimple.ATT_STATUS});

            for (CatalogContract.DataBaseDataSimple data : dataList) {
                // the _ID is not important on this case
                cursorProduct.addRow(new Object[]{1, data.getId(), data.getData(), data.getStatus().getValue()});
            }

            return cursorProduct;
        }

        return null;
    }
}
