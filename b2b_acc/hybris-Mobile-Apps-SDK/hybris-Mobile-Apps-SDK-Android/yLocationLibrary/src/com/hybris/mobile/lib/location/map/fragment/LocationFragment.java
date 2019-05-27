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

package com.hybris.mobile.lib.location.map.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.hybris.mobile.lib.location.LocationUtils;


/**
 * Base Fragment for fragments that needs user location and google play services
 */
public abstract class LocationFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final String TAG = LocationFragment.class.getCanonicalName();
    private static final String TAG_DIALOG_FRAGMENT_ERROR_GOOGLE_PLAY_SERVICES = "TAG_DIALOG_FRAGMENT_ERROR_GOOGLE_PLAY_SERVICES";
    private static final String TAG_DIALOG_FRAGMENT_ERROR_LOCATION = "TAG_DIALOG_FRAGMENT_ERROR_LOCATION";
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mDeviceLocation;
    private boolean mIsDeviceLocation = false;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CONNECTION_FAILURE_RESOLUTION_REQUEST:

                switch (resultCode) {
                    case Activity.RESULT_OK:
                        onResume();
                        break;
                }
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // For the fused location provider in case we want the last known location
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();

        if (mIsDeviceLocation) {
            // Location updates to get device location
            mLocationRequest = new LocationRequest();
            mLocationRequest.setInterval(5000);
            mLocationRequest.setFastestInterval(10000);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        checkLocationConfiguration();
    }

    /**
     * Check the location configuration: presence of Google Play Services on the device and device location services
     */
    private void checkLocationConfiguration() {
        // Check if Google Play services is available
        if (!LocationUtils.isGooglePlayServicesConnected(getActivity())) {
            // Get the error dialog from Google Play services
            final Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(
                    GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()), getActivity(),
                    CONNECTION_FAILURE_RESOLUTION_REQUEST);

            if (errorDialog != null) {
                DialogFragment errorFragment = new DialogFragment() {
                    @Override
                    public Dialog onCreateDialog(Bundle savedInstanceState) {
                        return errorDialog;
                    }
                };

                // Show the error dialog
                errorFragment.show(getFragmentManager(), TAG_DIALOG_FRAGMENT_ERROR_GOOGLE_PLAY_SERVICES);
            }
        } else {
            // Check if the user location services is activated
            if (mIsDeviceLocation && !LocationUtils.isLocationActivated(getActivity())) {
                LocationUtils.showDialogEnableLocationServices(getActivity());
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mDeviceLocation = location;

        // Once we get the location we stop looking for it
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }

    @Override
    public void onPause() {
        super.onPause();

        // Stop the location updates
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(
                    mGoogleApiClient, this);
        }
    }


    @Override
    public void onConnected(Bundle arg0) {

        if (mIsDeviceLocation) {
            // Try to get the last known location with the fused location provider
            mDeviceLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);

            // If no device location, we launch the location client looking for the device location
            if (mDeviceLocation == null) {
                LocationServices.FusedLocationApi.requestLocationUpdates(
                        mGoogleApiClient, mLocationRequest, this);

            }
        }

        // We call the abstract method
        onConnected();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // Trying to find a resolution if google play services fails to connect
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(getActivity(), connectionResult.getErrorCode());
            } catch (IntentSender.SendIntentException e) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        } else {
            Log.e(TAG, "Unknown error with Google Play Services");
        }
    }

    Location getDeviceLocation() {
        return mDeviceLocation;
    }

    void registerForDeviceLocation(boolean isDeviceLocation) {
        mIsDeviceLocation = isDeviceLocation;
    }

    /**
     * Called when the services are connected
     */
    protected abstract void onConnected();
}
