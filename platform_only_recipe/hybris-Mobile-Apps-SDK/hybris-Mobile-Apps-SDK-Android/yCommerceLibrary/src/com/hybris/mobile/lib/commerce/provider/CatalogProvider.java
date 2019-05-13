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

package com.hybris.mobile.lib.commerce.provider;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.hybris.mobile.lib.commerce.R;
import com.hybris.mobile.lib.commerce.provider.CatalogContract.SyncStatus;
import com.hybris.mobile.lib.commerce.sync.CatalogAuthenticatorService;
import com.hybris.mobile.lib.commerce.sync.CatalogSyncConstants;

import org.apache.commons.lang3.StringUtils;


/**
 * Content provider for the catalog
 */
public class CatalogProvider extends ContentProvider {
    private static final String TAG = CatalogProvider.class.getCanonicalName();

    private UriMatcher URI_MATCHER;
    private CatalogDatabaseHelper mDatabaseHelper;
    private String authority;
    private Account account;

    @Override
    public boolean onCreate() {
        authority = getContext().getString(R.string.sync_default_authority);
        String dbName = getContext().getString(R.string.sync_default_db_name);
        int dbVersion = getContext().getResources().getInteger(R.integer.sync_default_db_version);

        try {
            ComponentName componentName = new ComponentName(getContext(), this.getClass());

            // Authority name from the manifest file
            String tmpAuthority = getContext().getPackageManager().getProviderInfo(componentName, PackageManager.GET_META_DATA).authority;

            if (StringUtils.isNotBlank(tmpAuthority)) {
                authority = tmpAuthority;
            }

            // Database configuration from manifest file
            Bundle bundle = getContext().getPackageManager().getProviderInfo(componentName, PackageManager.GET_META_DATA).metaData;

            if (bundle != null) {
                String dbNameTmp = bundle.getString(getContext().getString(R.string.sync_db_name));
                int dbVersionTmp = bundle.getInt(getContext().getString(R.string.sync_db_version));

                if (StringUtils.isNotBlank(dbNameTmp)) {
                    dbName = dbNameTmp;
                }

                if (dbVersion != 0) {
                    dbVersion = dbVersionTmp;
                }
            }

            // Account name and type
            componentName = new ComponentName(getContext(), CatalogAuthenticatorService.class);
            bundle = getContext().getPackageManager().getServiceInfo(componentName, PackageManager.GET_META_DATA).metaData;

            String accountName = bundle.getString(getContext().getString(R.string.sync_account_name));
            String accountType = bundle.getString(getContext().getString(R.string.sync_account_type));

            if (StringUtils.isBlank(accountName) || StringUtils.isBlank(accountType)) {
                throw new IllegalArgumentException("You must provide the metadata "
                        + getContext().getString(R.string.sync_account_name) + ", "
                        + getContext().getString(R.string.sync_account_type) + " for " + this.getClass());
            }

            account = new Account(accountType, accountName);

        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Package name not found. Details:" + e.getLocalizedMessage());
            throw new IllegalArgumentException("Error getting the information from the metadata of " + this.getClass());
        }
        // Unit test case - the mock context does not have any package manager or provider info
        catch (UnsupportedOperationException e) {
            Log.e(TAG, "Unsupported operation:" + e.getLocalizedMessage());
        }

        mDatabaseHelper = new CatalogDatabaseHelper(getContext(), dbName, dbVersion);

        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_GROUP, CatalogContract.Provider.CODE_GROUP);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_GROUP + "/*", CatalogContract.Provider.CODE_GROUP_ID);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_DATA, CatalogContract.Provider.CODE_DATA);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_DATA + "/*", CatalogContract.Provider.CODE_DATA_ID);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_DATA_DETAILS, CatalogContract.Provider.CODE_DATA_DETAILS);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_DATA_DETAILS + "/*",
                CatalogContract.Provider.CODE_DATA_DETAILS_ID);
        URI_MATCHER.addURI(authority, CatalogContract.Provider.SEGMENT_SYNC_GROUP + "/*", CatalogContract.Provider.CODE_SYNC_GROUP);

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase sqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        String tableName;
        String where;
        String order = "";
        Bundle bundleSyncAdapter = new Bundle();
        String lastPathSegment = uri.getLastPathSegment();

        if (StringUtils.isNotBlank(sortOrder)) {
            order = " ORDER BY " + sortOrder;
        }

        switch (URI_MATCHER.match(uri)) {

            // Getting the content for a group (list of simple data)
            case CatalogContract.Provider.CODE_GROUP_ID:
                tableName = CatalogContract.DataBaseDataSimple.TABLE_NAME;
                where = CatalogContract.DataBaseDataLinkGroup.TABLE_NAME + "." + CatalogContract.DataBaseDataLinkGroup.ATT_GROUP_ID
                        + "='" + lastPathSegment + "'";

                // Limit for the query on the sync adapter
                String currentPage = uri.getQueryParameter(CatalogContract.Provider.QUERY_PARAM_CURRENT_PAGE);
                String pageSize = uri.getQueryParameter(CatalogContract.Provider.QUERY_PARAM_PAGE_SIZE);

                // Bundle information for the syncing part
                bundleSyncAdapter.putString(CatalogSyncConstants.SYNC_PARAM_GROUP_ID, lastPathSegment);

                if (StringUtils.isNotBlank(currentPage) && StringUtils.isNotBlank(pageSize)) {
                    bundleSyncAdapter.putInt(CatalogSyncConstants.SYNC_PARAM_CURRENT_PAGE, Integer.valueOf(currentPage));
                    bundleSyncAdapter.putInt(CatalogSyncConstants.SYNC_PARAM_PAGE_SIZE, Integer.valueOf(pageSize));
                }

                break;

            // Getting a specific data detail
            case CatalogContract.Provider.CODE_DATA_ID:
            case CatalogContract.Provider.CODE_DATA_DETAILS_ID:
                tableName = CatalogContract.DataBaseDataDetails.TABLE_NAME;
                where = CatalogContract.DataBaseDataDetails.TABLE_NAME + "." + CatalogContract.DataBaseDataDetails.ATT_DATA_ID + "='"
                        + lastPathSegment + "'";

                // Bundle information for the syncing part
                bundleSyncAdapter.putString(CatalogSyncConstants.SYNC_PARAM_DATA_ID, lastPathSegment);

                // We don't load the variants for a specific data
                bundleSyncAdapter.putBoolean(CatalogSyncConstants.SYNC_PARAM_LOAD_VARIANTS, false);
                break;

            default:
                Log.e(TAG, "URI not recognized" + uri.toString());
                throw new IllegalArgumentException("URI not recognized" + uri.toString());

        }

        // We do the query by joining the data to the group
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + tableName + " INNER JOIN "
                + CatalogContract.DataBaseDataLinkGroup.TABLE_NAME + " ON " + tableName + "."
                + CatalogContract.DataBaseData.ATT_DATA_ID + "=" + CatalogContract.DataBaseDataLinkGroup.TABLE_NAME + "."
                + CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID + " WHERE " + where + order, null);

        // Register the cursor to watch the uri for changes
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        // Existing data
        if (cursor.getCount() > 0) {
            // TODO - For now we check if one the items is out-of-sync and we sync all of them if this is the case
            // Future - Check every out-of-date items and sync them
            cursor.moveToLast();
            int status = cursor.getInt(cursor.getColumnIndex(CatalogContract.DataBaseData.ATT_STATUS));
            cursor.moveToFirst();

            // Data expired, we request a sync
            if (status == CatalogContract.SyncStatus.OUTOFDATE.getValue()) {
                Log.i(TAG, "Data for " + uri.toString() + " is out-of-date, requesting a sync");
                requestSync(bundleSyncAdapter);

                // TODO - the uptodate/outofdate should be done in the sync adapter
                // We up-to-date all the data in case the sync does not return any results (we base our out of sync on the last item of the cursor)
                if (URI_MATCHER.match(uri) == CatalogContract.Provider.CODE_GROUP_ID) {
                    updateInternalDataSyncStatus(cursor, tableName, SyncStatus.UPTODATE);
                }
            }
            // Data updated, we invalidate the data
            else {
                Log.i(TAG, "Data for " + uri.toString() + " is up-of-date, invalidating it");
                updateInternalDataSyncStatus(cursor, tableName, SyncStatus.OUTOFDATE);
            }

        }
        // No data found, we request a sync if it's not already up-to-date
        else {
            boolean triggerSyncAdapter;

            switch (URI_MATCHER.match(uri)) {

                // Saving the sync info for the group
                case CatalogContract.Provider.CODE_GROUP_ID:
                    triggerSyncAdapter = updateTrackSyncStatus(CatalogContract.Provider.getUriSyncGroup(authority),
                            CatalogContract.DataBaseSyncStatusGroup.ATT_GROUP_ID, CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME,
                            lastPathSegment);

                    break;

                // Saving the sync info for the data
                case CatalogContract.Provider.CODE_DATA_ID:
                    triggerSyncAdapter = updateTrackSyncStatus(CatalogContract.Provider.getUriData(authority),
                            CatalogContract.DataBaseData.ATT_DATA_ID, CatalogContract.DataBaseDataSimple.TABLE_NAME, lastPathSegment);
                    break;

                // Saving the sync info for the data details
                case CatalogContract.Provider.CODE_DATA_DETAILS_ID:
                    triggerSyncAdapter = updateTrackSyncStatus(CatalogContract.Provider.getUriDataDetails(authority),
                            CatalogContract.DataBaseData.ATT_DATA_ID, CatalogContract.DataBaseDataDetails.TABLE_NAME, lastPathSegment);
                    break;

                default:
                    Log.e(TAG, "URI not recognized" + uri.toString());
                    throw new IllegalArgumentException("URI not recognized" + uri.toString());

            }

            // Trigger the sync adapter
            if (triggerSyncAdapter) {
                Log.i(TAG, "No data found for " + uri.toString() + " and data out-of-date, requesting a sync");
                requestSync(bundleSyncAdapter);
            } else {
                Log.i(TAG, "No data found for " + uri.toString() + " and data up-to-date");
            }

        }

        return cursor;
    }

    /**
     * Insert/Update the out-of-date sync status for an element (data or group) and return true if the sync adapter needs
     * to be triggered
     *
     * @param uriElement String of characters used to identify a name of a resource
     * @param idName     Unique name string
     * @param tableName  an element (data or group)
     * @param idElement  Unique element Identifier
     * @return true if the sync adapter needs to be triggered
     */
    private boolean updateTrackSyncStatus(Uri uriElement, String idName, String tableName, String idElement) {

        boolean triggerSyncAdapter = true;

        ContentValues contentValues = new ContentValues();
        contentValues.put(idName, idElement);
        contentValues.put(CatalogContract.DataBaseSyncStatusGroup.ATT_STATUS, SyncStatus.OUTOFDATE.getValue());

        // Cursor to check if we need to trigger the sync adapter (data out-of-date)
        Cursor cursorCheckUpToDate = mDatabaseHelper.getReadableDatabase().query(tableName, new String[]
                {CatalogContract.DataBaseData.ATT_STATUS}, idName + "=?", new String[]
                {idElement}, null, null, null);

        // Checking if we need to trigger the sync adapter
        if (cursorCheckUpToDate != null && cursorCheckUpToDate.getCount() > 0) {
            cursorCheckUpToDate.moveToFirst();

            // Sync status flag to out-of-date
            triggerSyncAdapter = (cursorCheckUpToDate.getInt(0) == SyncStatus.OUTOFDATE.getValue());

            cursorCheckUpToDate.close();
        }

        // Insert (or update) the row for the sync status out-to-date:
        // Case 1: we need to trigger the sync adapter
        // Case 2: the value is up-to-date, we invalidate the sync status for the next calls to the provider
        insert(Uri.withAppendedPath(uriElement, idElement), contentValues);

        return triggerSyncAdapter;
    }

    /**
     * Validate/Invalidate the data on the cursor
     *
     * @param cursor     random read-write access to the result set returned by a database query
     * @param syncStatus True if synced else false
     */
    private void updateInternalDataSyncStatus(Cursor cursor, String tableName, SyncStatus syncStatus) {

        if (cursor != null) {
            // We move to the first item and loop until the end
            cursor.moveToFirst();

            do {
                ContentValues contentValues = new ContentValues();
                contentValues.put(CatalogContract.DataBaseData.ATT_STATUS, syncStatus.getValue());

                mDatabaseHelper.getWritableDatabase().update(tableName, contentValues,
                        CatalogContract.DataBaseData.ATT_DATA_ID + "=?", new String[]
                                {cursor.getString(cursor.getColumnIndex(CatalogContract.DataBaseData.ATT_DATA_ID))});
            }
            while (cursor.moveToNext());

            cursor.moveToFirst();

        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        switch (URI_MATCHER.match(uri)) {

            // Insert a group link
            case CatalogContract.Provider.CODE_GROUP_ID:
                Log.i(TAG,
                        "Saving the information for the item " + values.getAsString(CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID));
                try {
                    mDatabaseHelper.getWritableDatabase()
                            .insertOrThrow(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME, null, values);
                } catch (SQLiteConstraintException e) {
                    Log.i(TAG,
                            "Item " + values.getAsString(CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID) + "|"
                                    + values.getAsString(CatalogContract.DataBaseDataLinkGroup.ATT_GROUP_ID)
                                    + " already exists, nothing to do");
                }

                break;

            // Insert or update for the rest
            case CatalogContract.Provider.CODE_DATA_ID:
            case CatalogContract.Provider.CODE_DATA_DETAILS_ID:
            case CatalogContract.Provider.CODE_SYNC_GROUP:
                insertOrUpdate(uri, values);
                break;

            default:
                Log.e(TAG, "URI not recognized" + uri.toString());
                throw new IllegalArgumentException("URI not recognized" + uri.toString());

        }

        Log.i(TAG, "Notify changes for " + uri);

        // Notify watchers of the change
        getContext().getContentResolver().notifyChange(uri, null);

        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int nbRowsDeleted;

        switch (URI_MATCHER.match(uri)) {
            // Delete all group-data links
            case CatalogContract.Provider.CODE_GROUP:

                // group
                nbRowsDeleted = mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME, null,
                        null);

                // data
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataSimple.TABLE_NAME, null,
                        null);

                // details
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataDetails.TABLE_NAME, null,
                        null);

                break;

            // Delete a particular group-data link
            case CatalogContract.Provider.CODE_GROUP_ID:
                nbRowsDeleted = mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME,
                        CatalogContract.DataBaseDataLinkGroup.ATT_GROUP_ID + "=?", new String[]
                                {uri.getLastPathSegment()});

                break;

            // Delete all data
            case CatalogContract.Provider.CODE_DATA:
                nbRowsDeleted = mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataSimple.TABLE_NAME, null,
                        null);
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME, null,
                        null);
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME,
                        null, null);

                break;

            // Delete all data details
            case CatalogContract.Provider.CODE_DATA_DETAILS:
                nbRowsDeleted = mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataDetails.TABLE_NAME, null,
                        null);
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME, null,
                        null);
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME,
                        null, null);

                break;

            // Delete a data
            case CatalogContract.Provider.CODE_DATA_ID:

                // data
                nbRowsDeleted = mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataSimple.TABLE_NAME,
                        CatalogContract.DataBaseData.ATT_DATA_ID + "=?", new String[]
                                {uri.getLastPathSegment()});

                // group link
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME,
                        CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID + "=?", new String[]
                                {uri.getLastPathSegment()});

                break;

            // Delete a data
            case CatalogContract.Provider.CODE_DATA_DETAILS_ID:

                // data
                nbRowsDeleted = mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataDetails.TABLE_NAME,
                        CatalogContract.DataBaseData.ATT_DATA_ID + "=?", new String[]
                                {uri.getLastPathSegment()});

                // group link
                nbRowsDeleted += mDatabaseHelper.getWritableDatabase().delete(CatalogContract.DataBaseDataLinkGroup.TABLE_NAME,
                        CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID + "=?", new String[]
                                {uri.getLastPathSegment()});

                break;

            default:
                Log.e(TAG, "URI not recognized" + uri.toString());
                throw new IllegalArgumentException("URI not recognized" + uri.toString());

        }

        Log.i(TAG, "Notify changes for " + uri);

        // Notify watchers of the change
        getContext().getContentResolver().notifyChange(uri, null);

        return nbRowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int nbRowsUpdated;

        switch (URI_MATCHER.match(uri)) {

            // Update a data
            case CatalogContract.Provider.CODE_DATA_ID:
                if (selection != null && selectionArgs != null) {
                    nbRowsUpdated = mDatabaseHelper.getWritableDatabase().update(CatalogContract.DataBaseDataSimple.TABLE_NAME,
                            values, selection, selectionArgs);
                } else {
                    nbRowsUpdated = mDatabaseHelper.getWritableDatabase().update(CatalogContract.DataBaseDataSimple.TABLE_NAME,
                            values, CatalogContract.DataBaseData.ATT_DATA_ID + "=?", new String[]
                                    {uri.getLastPathSegment()});
                }
                break;

            // Update a data details
            case CatalogContract.Provider.CODE_DATA_DETAILS_ID:
                if (selection != null && selectionArgs != null) {
                    nbRowsUpdated = mDatabaseHelper.getWritableDatabase().update(CatalogContract.DataBaseDataDetails.TABLE_NAME,
                            values, selection, selectionArgs);
                } else {
                    nbRowsUpdated = mDatabaseHelper.getWritableDatabase().update(CatalogContract.DataBaseDataDetails.TABLE_NAME,
                            values, CatalogContract.DataBaseData.ATT_DATA_ID + "=?", new String[]
                                    {uri.getLastPathSegment()});
                }
                break;

            // Update a group sync status
            case CatalogContract.Provider.CODE_SYNC_GROUP:

                if (selection != null && selectionArgs != null) {
                    nbRowsUpdated = mDatabaseHelper.getWritableDatabase().update(CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME,
                            values, selection, selectionArgs);
                } else {
                    nbRowsUpdated = mDatabaseHelper.getWritableDatabase().update(CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME,
                            values, CatalogContract.DataBaseDataLinkGroup.ATT_GROUP_ID + "=?", new String[]
                                    {uri.getLastPathSegment()});
                }

                break;

            default:
                Log.e(TAG, "URI not recognized" + uri.toString());
                throw new IllegalArgumentException("URI not recognized" + uri.toString());

        }

        Log.i(TAG, "Notify changes for " + uri);

        // Notify watchers of the change
        getContext().getContentResolver().notifyChange(uri, null);

        return nbRowsUpdated;
    }

    /**
     * Insert the new item or update it if already in database
     *
     * @param uri    String of characters used to identify a name of a resource
     * @param values Set of content values
     */
    private void insertOrUpdate(Uri uri, ContentValues values) {

        switch (URI_MATCHER.match(uri)) {
            // Insert or Update a data
            case CatalogContract.Provider.CODE_DATA_ID:
                insertOrUpdateGeneric(uri, values, CatalogContract.DataBaseData.ATT_DATA_ID,
                        CatalogContract.DataBaseDataSimple.TABLE_NAME);
                break;

            // Insert or Update a data details
            case CatalogContract.Provider.CODE_DATA_DETAILS_ID:
                insertOrUpdateGeneric(uri, values, CatalogContract.DataBaseData.ATT_DATA_ID,
                        CatalogContract.DataBaseDataDetails.TABLE_NAME);
                break;

            // Insert or Update a group sync status
            case CatalogContract.Provider.CODE_SYNC_GROUP:
                insertOrUpdateGeneric(uri, values, CatalogContract.DataBaseSyncStatusGroup.ATT_GROUP_ID,
                        CatalogContract.DataBaseSyncStatusGroup.TABLE_NAME);
                break;

            default:
                Log.e(TAG, "URI not recognized" + uri.toString());
                throw new IllegalArgumentException("URI not recognized" + uri.toString());
        }

    }

    /**
     * Insert the new item or update it if already in database
     *
     * @param uri       String of characters used to identify a name of a resource
     * @param values    Set of content values
     * @param idName    Unique name string
     * @param tableName an element (data or group)
     */
    private void insertOrUpdateGeneric(Uri uri, ContentValues values, String idName, String tableName) {
        try {
            Log.d(TAG, "Inserting the information for the item " + values.getAsString(idName));
            mDatabaseHelper.getWritableDatabase().insertOrThrow(tableName, null, values);
        } catch (SQLiteConstraintException e) {
            Log.d(TAG, "Item " + values.getAsString(idName) + " already exists, updating it");

            update(uri, values, idName + "=?", new String[]
                    {values.getAsString(idName)});
        }
    }

    @Override
    public String getType(Uri uri) {
        String type;

        switch (URI_MATCHER.match(uri)) {
            case CatalogContract.Provider.CODE_GROUP:
                type = CatalogContract.Provider.getTypeGroupAll(authority);
                break;

            case CatalogContract.Provider.CODE_GROUP_ID:
                type = CatalogContract.Provider.getTypeGroup(authority);
                break;

            case CatalogContract.Provider.CODE_DATA_ID:
                type = CatalogContract.Provider.getTypeData(authority);
                break;

            case CatalogContract.Provider.CODE_DATA_DETAILS_ID:
                type = CatalogContract.Provider.getTypeDataDetails(authority);
                break;

            case CatalogContract.Provider.CODE_SYNC_GROUP:
                type = CatalogContract.Provider.getTypeSyncGroup(authority);
                break;

            default:
                Log.e(TAG, "URI not recognized: " + uri.toString());
                throw new IllegalArgumentException("URI not recognized" + uri.toString());
        }

        return type;
    }

    /**
     * Request a sync (we force it)
     *
     * @param bundle extras parameters for the sync
     */
    private void requestSync(Bundle bundle) {

        if (bundle == null) {
            bundle = new Bundle();
        }

        Log.i(TAG, "Requesting a sync with bundle: " + bundle.toString());

        // Parameters to force the sync without any delay
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        ContentResolver.requestSync(account, authority, bundle);
    }

}
