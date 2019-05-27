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

import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Contract for the database and provider for the catalog
 */
public final class CatalogContract {

    private CatalogContract() {
    }

    public enum SyncStatus {
        UPTODATE(1), OUTOFDATE(0);

        private final int value;

        SyncStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Provider constants
     */
    public static abstract class Provider {

        public static final int CODE_GROUP = 1;
        public static final int CODE_GROUP_ID = 2;
        public static final int CODE_DATA = 3;
        public static final int CODE_DATA_ID = 4;
        public static final int CODE_DATA_DETAILS = 5;
        public static final int CODE_DATA_DETAILS_ID = 6;
        public static final int CODE_SYNC_GROUP = 7;

        public static final String SEGMENT_GROUP = "group";
        public static final String SEGMENT_DATA = "data";
        public static final String SEGMENT_DATA_DETAILS = "dataDetails";
        public static final String SEGMENT_SYNC_GROUP = "syncGroup";

        public static final String QUERY_PARAM_PAGE_SIZE = "BUNDLE_PAGE_SIZE";
        public static final String QUERY_PARAM_CURRENT_PAGE = "BUNDLE_CURRENT_PAGE";

        public static Uri getUriGroup(String authority) {
            return Uri.parse("content://" + authority + "/" + SEGMENT_GROUP);
        }

        public static Uri getUriData(String authority) {
            return Uri.parse("content://" + authority + "/" + SEGMENT_DATA);
        }

        public static Uri getUriDataDetails(String authority) {
            return Uri.parse("content://" + authority + "/" + SEGMENT_DATA_DETAILS);
        }

        public static Uri getUriSyncGroup(String authority) {
            return Uri.parse("content://" + authority + "/" + SEGMENT_SYNC_GROUP);
        }

        public static String getTypeGroupAll(String authority) {
            return "vnd.android.cursor.dir/vnd." + authority + "." + SEGMENT_GROUP;
        }

        public static String getTypeGroup(String authority) {
            return "vnd.android.cursor.item/vnd." + authority + "." + SEGMENT_GROUP;
        }

        public static String getTypeData(String authority) {
            return "vnd.android.cursor.item/vnd." + authority + "." + SEGMENT_DATA;
        }

        public static String getTypeDataDetails(String authority) {
            return "vnd.android.cursor.item/vnd." + authority + "." + SEGMENT_DATA_DETAILS;
        }

        public static String getTypeSyncGroup(String authority) {
            return "vnd.android.cursor.item/vnd." + authority + "." + SEGMENT_SYNC_GROUP;
        }
    }

    public static class DataBaseDataSimple extends DataBaseData implements BaseColumns {
        public static final String TABLE_NAME = "DATA";

        private String mId;
        private String mData;
        private SyncStatus mStatus;

        public DataBaseDataSimple(String id, String data, SyncStatus status) {
            this.mId = id;
            this.mData = data;
            this.mStatus = status;
        }

        public String getId() {
            return mId;
        }

        public void setId(String mId) {
            this.mId = mId;
        }

        public String getData() {
            return mData;
        }

        public void setData(String mData) {
            this.mData = mData;
        }

        public SyncStatus getStatus() {
            return mStatus;
        }

        public void setStatus(SyncStatus mStatus) {
            this.mStatus = mStatus;
        }
    }

    public static class DataBaseDataDetails extends DataBaseData implements BaseColumns {
        public static final String TABLE_NAME = "DATA_DETAILS";
    }

    public static abstract class DataBaseData implements BaseColumns {
        public static final String ATT_DATA_ID = "DATA_ID";
        public static final String ATT_DATA = "DATA";
        public static final String ATT_STATUS = "STATUS";
    }

    public static class DataBaseDataLinkGroup implements BaseColumns {
        public static final String TABLE_NAME = "DATA_LINK";
        public static final String ATT_DATA_ID = "DATA_ID";
        public static final String ATT_GROUP_ID = "GROUP_ID";
    }

    public static class DataBaseSyncStatusGroup implements BaseColumns {
        public static final String TABLE_NAME = "SYNC_STATUS_GROUP";
        public static final String ATT_GROUP_ID = "GROUP_ID";
        public static final String ATT_STATUS = "STATUS";
    }

}
