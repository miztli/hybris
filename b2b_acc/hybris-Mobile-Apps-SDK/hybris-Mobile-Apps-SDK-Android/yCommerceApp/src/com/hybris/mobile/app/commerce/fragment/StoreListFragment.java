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

package com.hybris.mobile.app.commerce.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.StoreListAdapter;
import com.hybris.mobile.app.commerce.listener.DeviceLocation;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment for the store list
 */
public class StoreListFragment extends ListFragment implements DeviceLocation {

    private static final String TAG = StoreListFragment.class.getCanonicalName();

    private Location mDeviceLocation;
    private StoreListAdapter mStoreListAdapter;
    private View mFooterView;
    private MapActions mMapActions;

    /**
     * Interface for activity communication
     */
    public interface MapActions {
        /**
         * Method for callback
         */
        void centerMap(LatLng latLng);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Make sure that the activity implements the callback interface
        try {
            mMapActions = (MapActions) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Adding the loading spinner to the list
        mFooterView = getActivity().getLayoutInflater().inflate(R.layout.loading_spinner, getListView(), false);
        getListView().addFooterView(mFooterView);

        // Setting the adapter
        mStoreListAdapter = new StoreListAdapter(getActivity(), this, mMapActions, new ArrayList<PointOfService>());
        setListAdapter(mStoreListAdapter);

        // Divider color and size
        getListView().setDivider(new ColorDrawable(getResources().getColor(R.color.store_details_separator)));
        getListView().setDividerHeight(2);
    }

    /**
     * Update the list with stores
     *
     * @param stores
     */
    public void updateStoreList(List<PointOfService> stores) {
        mStoreListAdapter.clear();
        mStoreListAdapter.addAll(stores);
        mStoreListAdapter.notifyDataSetChanged();

        // Remove the loading footer
        getListView().removeFooterView(mFooterView);
    }

    public void setDeviceLocation(Location deviceLocation) {
        mDeviceLocation = deviceLocation;
    }

    @Override
    public Location getDeviceLocation() {
        return mDeviceLocation;
    }
}
