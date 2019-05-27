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

package com.hybris.mobile.app.commerce.activity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.StoreDetailsFragment;
import com.hybris.mobile.lib.location.map.MapConfiguration;
import com.hybris.mobile.lib.location.map.data.MapItem;
import com.hybris.mobile.lib.location.map.listener.MapDataLoader;

/**
 *
 */
public class StoreDetailsActivity extends MainActivity implements MapDataLoader {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_store_details);
        super.onCreate(savedInstanceState);
    }

    @Override
    public MapConfiguration getMapConfiguration() {
        return MapConfiguration.build().setDeviceLocation(true).setPadding(100).setAnimationSpeed(250).setCameraPosition(MapConfiguration.CameraPosition.FITS_DEVICE_LOCATION_NEAREST_ITEM).setZoomLevel(15);
    }

    @Override
    public void onMapItemClick(MapItem item) {

    }

    @Override
    public View getMapItemViewContent(MapItem item) {
        return null;
    }

    @Override
    public View getMapItemViewWindow(MapItem item) {
        return null;
    }

    @Override
    public void onMapLoaded() {

    }

    @Override
    public void onMapCameraChange() {

    }

    @Override
    public void onConnected(Location deviceLocation) {

        if (getFragmentManager().findFragmentById(R.id.store_details_fragment) instanceof StoreDetailsFragment) {
            StoreDetailsFragment storeDetailsFragment = (StoreDetailsFragment) getFragmentManager().findFragmentById(R.id.store_details_fragment);
            storeDetailsFragment.setLocation(deviceLocation);
        }
    }
}
