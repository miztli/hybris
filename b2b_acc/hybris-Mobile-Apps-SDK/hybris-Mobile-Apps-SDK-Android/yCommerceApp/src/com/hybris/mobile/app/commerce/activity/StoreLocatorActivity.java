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

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.StoreListFragment;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;
import com.hybris.mobile.lib.commerce.data.store.StoreFinderSearchPage;
import com.hybris.mobile.lib.commerce.query.QueryLocation;
import com.hybris.mobile.lib.commerce.query.QueryStores;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.location.map.MapConfiguration;
import com.hybris.mobile.lib.location.map.data.MapItem;
import com.hybris.mobile.lib.location.map.fragment.MapFragment;
import com.hybris.mobile.lib.location.map.listener.MapDataLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity for the store locator
 */
public class StoreLocatorActivity extends MainActivity implements MapDataLoader, ResponseReceiver<StoreFinderSearchPage>, StoreListFragment.MapActions {
    private String mStoreLocatorRequestId = RequestUtils.generateUniqueRequestId();
    private MapFragment mMapFragment;
    private StoreListFragment mListFragment;
    private MapConfiguration mMapConfiguration;
    private TextView mNbResults;
    private boolean mFirstCall = false;

    @Override
    public void centerMap(LatLng latLng) {
        if (mMapFragment != null) {
            mMapFragment.centerMap(latLng);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_store_locator);
        super.onCreate(savedInstanceState);

        mListFragment = (StoreListFragment) getFragmentManager().findFragmentById(R.id.store_locator_list);
        mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.store_locator_map);
        mNbResults = (TextView) findViewById(R.id.store_locator_list_nb_results);

        mMapConfiguration = MapConfiguration.build().setDeviceLocation(true).setPadding(100).setAnimationSpeed(250).setCameraPosition(MapConfiguration.CameraPosition.FITS_DEVICE_LOCATION_NEAREST_ITEM).setZoomLevel(5);

        // 0 results by default
        mNbResults.setText(getString(R.string.stores_nb_results, 0));
    }

    @Override
    public void onResponse(Response<StoreFinderSearchPage> response) {

        if (response.getData() != null && response.getData().getStores() != null) {
            List<MapItem> items = new ArrayList<>();

            for (PointOfService store : response.getData().getStores()) {
                MapItem mapItem = new MapItem(store.getName(), new LatLng(store.getGeoPoint().getLatitude(), store.getGeoPoint().getLongitude()));

                mapItem.setDescription(store.getAddress().getFormattedAddress());
                mapItem.setName(store.getName());

                items.add(mapItem);
            }

            // Displaying the stores on the map and list
            mMapFragment.updateMap(items);
            mListFragment.updateStoreList(response.getData().getStores());

            mNbResults.setText(getString(R.string.stores_nb_results, response.getData().getStores().size()));
        }

    }

    @Override
    public void onError(Response<ErrorList> response) {

    }


    @Override
    public MapConfiguration getMapConfiguration() {
        return mMapConfiguration;
    }

    @Override
    public void onMapItemClick(MapItem item) {
        Intent intent = new Intent(this, StoreDetailsActivity.class);
        intent.putExtra(IntentConstants.STORE_NAME, item.getId());

        startActivity(intent);
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

        // Getting the stores
        QueryStores queryStores = new QueryStores();

        // Based on the device location
        if (deviceLocation != null) {
            mListFragment.setDeviceLocation(deviceLocation);

            QueryLocation location = new QueryLocation();
            location.setLatitude(deviceLocation.getLatitude());
            location.setLongitude(deviceLocation.getLongitude());
            location.setRadius(getResources().getInteger(R.integer.default_store_locator_radius));

            queryStores.setLocation(location);

            mMapConfiguration.setCameraPosition(MapConfiguration.CameraPosition.FITS_DEVICE_LOCATION_NEAREST_ITEM);
        } else {
            mMapConfiguration.setCameraPosition(MapConfiguration.CameraPosition.CENTER_FIRST_ITEM);
        }

        // onConnected is called by the location library multiple times according to the user location
        // If we already called this method and we still don' have the location, we don't need to call it twice
        if (!mFirstCall || deviceLocation != null) {
            CommerceApplication.getContentServiceHelper()
                    .getStores(this, mStoreLocatorRequestId, queryStores, false, null, new OnRequestListener() {
                        @Override
                        public void beforeRequest() {
                            UIUtils.showLoadingActionBar(StoreLocatorActivity.this, true);
                        }

                        @Override
                        public void afterRequestBeforeResponse() {

                        }

                        @Override
                        public void afterRequest(boolean isDataSynced) {
                            UIUtils.showLoadingActionBar(StoreLocatorActivity.this, false);
                        }
                    });
        }


        mFirstCall = true;

    }

    @Override
    protected void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mStoreLocatorRequestId);
    }

}
