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

package com.hybris.mobile.lib.location.map.data;

import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;
import com.hybris.mobile.lib.location.map.MapIconConfiguration;


/**
 * Map item data
 */
public class MapItem {
    private LatLng mLocation;
    private Drawable mImage;
    private MapIconConfiguration mMapIconConfiguration;
    private String mId;
    private String mName;
    private String mDescription;

    public MapItem(String id, LatLng location) {
        this.mLocation = location;
        this.mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public LatLng getLocation() {
        return mLocation;
    }

    public void setLocation(LatLng mLocation) {
        this.mLocation = mLocation;
    }

    public Drawable getImage() {
        return mImage;
    }

    public void setImage(Drawable image) {
        this.mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public MapIconConfiguration getMapIconConfiguration() {
        return mMapIconConfiguration;
    }

    public void setMapIconConfiguration(MapIconConfiguration mapIconConfiguration) {
        mMapIconConfiguration = mapIconConfiguration;
    }

}
