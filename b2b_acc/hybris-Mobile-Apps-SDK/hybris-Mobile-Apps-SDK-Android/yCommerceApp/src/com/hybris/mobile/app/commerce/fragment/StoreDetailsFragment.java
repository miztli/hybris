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

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.Constants;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;
import com.hybris.mobile.lib.commerce.data.store.WeekdayOpeningDay;
import com.hybris.mobile.lib.commerce.query.QueryStore;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.location.LocationUtils;
import com.hybris.mobile.lib.location.map.data.MapItem;
import com.hybris.mobile.lib.location.map.fragment.MapFragment;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Fragment for the store details page
 */
public class StoreDetailsFragment extends Fragment implements ResponseReceiver<PointOfService> {

    private static final String TAG = StoreDetailsFragment.class.getCanonicalName();

    private String mRequestId = RequestUtils.generateUniqueRequestId();

    private PointOfService mStore;

    private TextView mStoreName;
    private TextView mStoreAddress;
    private TextView mStoreDistance;
    private TextView mStoreTel;
    private TextView mStoreDirections;
    private TextView mStoreHoursMon;
    private TextView mStoreHoursTue;
    private TextView mStoreHoursWed;
    private TextView mStoreHoursThu;
    private TextView mStoreHoursFri;
    private TextView mStoreHoursSat;
    private TextView mStoreHoursSun;
    private MapFragment mMapFragment;
    private Location mLocation;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Store name needed for this fragment
        if (StringUtils.isBlank(getActivity().getIntent().getStringExtra(IntentConstants.STORE_NAME))) {
            throw new IllegalArgumentException();
        }

        // Getting the map fragment
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mMapFragment = ((MapFragment) (getChildFragmentManager()
                    .findFragmentById(R.id.store_details_map)));
        }

        if (mMapFragment == null) {
            mMapFragment = ((MapFragment) (getFragmentManager()
                    .findFragmentById(R.id.store_details_map)));
        }

        mStoreAddress = (TextView) getView().findViewById(R.id.store_details_address);
        mStoreName = (TextView) getView().findViewById(R.id.store_details_name);
        mStoreDistance = (TextView) getView().findViewById(R.id.store_details_distance);
        mStoreTel = (TextView) getView().findViewById(R.id.store_details_tel);
        mStoreDirections = (TextView) getView().findViewById(R.id.store_details_directions);

        mStoreTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.isNotBlank(mStoreTel.getText())) {
                    try {
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mStoreTel.getText().toString().replaceAll("[^\\d.]", ""))));
                    } catch (ActivityNotFoundException e) {
                        Log.e(TAG, e.getLocalizedMessage());
                    }
                }
            }
        });

        mStoreHoursMon = (TextView) getView().findViewById(R.id.store_details_monday);
        mStoreHoursTue = (TextView) getView().findViewById(R.id.store_details_tuesday);
        mStoreHoursWed = (TextView) getView().findViewById(R.id.store_details_wednesday);
        mStoreHoursThu = (TextView) getView().findViewById(R.id.store_details_thursday);
        mStoreHoursFri = (TextView) getView().findViewById(R.id.store_details_friday);
        mStoreHoursSat = (TextView) getView().findViewById(R.id.store_details_saturday);
        mStoreHoursSun = (TextView) getView().findViewById(R.id.store_details_sunday);

        // Store query
        QueryStore queryStore = new QueryStore();
        queryStore.setStoreName(getActivity().getIntent().getStringExtra(IntentConstants.STORE_NAME));

        CommerceApplication.getContentServiceHelper().getStore(this, mRequestId, queryStore, false, null, new OnRequestListener() {
            @Override
            public void beforeRequest() {
                UIUtils.showLoadingActionBar(getActivity(), true);
                getView().findViewById(R.id.store_details_loading).setVisibility(View.VISIBLE);
                getView().findViewById(R.id.store_details_bloc).setVisibility(View.GONE);
            }

            @Override
            public void afterRequestBeforeResponse() {

            }

            @Override
            public void afterRequest(boolean isDataSynced) {
                UIUtils.showLoadingActionBar(getActivity(), false);
                getView().findViewById(R.id.store_details_loading).setVisibility(View.GONE);
                getView().findViewById(R.id.store_details_bloc).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onResponse(Response<PointOfService> response) {

        mStore = response.getData();

        if (mStore != null) {

            // Updating the map
            if (mMapFragment != null) {

                // Constructing the map item for the map component
                MapItem mapItem = new MapItem(mStore.getName(), new LatLng(mStore.getGeoPoint().getLatitude(), mStore.getGeoPoint().getLongitude()));

                if (mStore.getAddress() != null) {
                    mapItem.setDescription(mStore.getAddress().getFormattedAddress());
                }

                mapItem.setName(mStore.getName());

                List<MapItem> listStore = new ArrayList<>();
                listStore.add(mapItem);

                mMapFragment.updateMap(listStore);
            }

            mStoreName.setText(mStore.getName());
            mStoreAddress.setText(mStore.getAddress().getFormattedAddress());
            mStoreDistance.setText(mStore.getFormattedDistance());

            // Hours of operation
            if (mStore.getOpeningHours() != null && mStore.getOpeningHours().getWeekDayOpeningList() != null && !mStore.getOpeningHours().getWeekDayOpeningList().isEmpty()) {

                for (WeekdayOpeningDay days : mStore.getOpeningHours().getWeekDayOpeningList()) {

                    TextView dayToUpdate = null;

                    if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_MON)) {
                        dayToUpdate = mStoreHoursMon;
                    } else if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_TUE)) {
                        dayToUpdate = mStoreHoursTue;
                    } else if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_WED)) {
                        dayToUpdate = mStoreHoursWed;
                    } else if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_THU)) {
                        dayToUpdate = mStoreHoursThu;
                    } else if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_FRI)) {
                        dayToUpdate = mStoreHoursFri;
                    } else if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_SAT)) {
                        dayToUpdate = mStoreHoursSat;
                    } else if (StringUtils.equals(days.getWeekDay(), Constants.STORE_DAY_SUN)) {
                        dayToUpdate = mStoreHoursSun;
                    }

                    if (dayToUpdate != null) {

                        if (!days.getClosed()) {

                            if (days.getOpeningTime() != null && days.getClosingTime() != null) {
                                dayToUpdate.setText(getString(R.string.stores_hours_details, days.getOpeningTime().getFormattedHour(), days.getClosingTime().getFormattedHour()));
                            }

                        }
                        // Display closed
                        else {
                            dayToUpdate.setText(getString(R.string.stores_hours_closed));
                        }

                    }

                }

            }

            mStoreTel.setText(mStore.getAddress().getPhone());

            // Distance intent
            mStoreDirections.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLocation != null) {
                        LocationUtils.sendDirectionsIntent(getActivity(), new LatLng(mLocation.getLatitude(), mLocation.getLongitude()), new LatLng(mStore.getGeoPoint().getLatitude(), mStore.getGeoPoint().getLongitude()));
                    } else {
                        LocationUtils.sendDirectionsIntent(getActivity(), null, new LatLng(mStore.getGeoPoint().getLatitude(), mStore.getGeoPoint().getLongitude()));
                    }
                }
            });

        }
    }

    /**
     * Set the device location
     *
     * @param deviceLocation
     */
    public void setLocation(Location deviceLocation) {
        mLocation = deviceLocation;
    }

    @Override
    public void onError(Response<ErrorList> response) {
        Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mRequestId);
    }

}
