/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.lib.location.geofencing;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.hybris.mobile.lib.location.geofencing.data.GeofenceObject;
import com.hybris.mobile.lib.location.geofencing.data.GeofencingResultCallBack;
import com.hybris.mobile.lib.location.geofencing.service.GeofencingIntentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Helper for geofencing
 */
public class GeofencingHelper implements ResultCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = GeofencingHelper.class.getCanonicalName();
    private static final int PENDING_INTENT_REQUEST_ID = UUID.randomUUID().hashCode();
    private static final int DEFAULT_INITIAL_TRIGGER = GeofencingRequest.INITIAL_TRIGGER_ENTER;
    protected GoogleApiClient mGoogleApiClient;
    protected Context mContext;
    protected GeofencingResultCallBack mGeofencingResultCallBack;
    protected Intent mIntent;
    protected int mInitialTrigger;

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location services connected.");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended.");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e(TAG, "Location services failed to connect. Details: " + connectionResult.toString());

        if (mGeofencingResultCallBack != null) {
            mGeofencingResultCallBack.onConnectionFailed(connectionResult);
        }
    }

    public GeofencingHelper(Context context) {
        this(context, DEFAULT_INITIAL_TRIGGER, null);
    }

    public GeofencingHelper(Context context, int initialTrigger) {
        this(context, initialTrigger, null);
    }

    public GeofencingHelper(Context context, int initialTrigger, GeofencingResultCallBack geofencingResultCallBack) {
        mContext = context;

        mInitialTrigger = initialTrigger;

        mGeofencingResultCallBack = geofencingResultCallBack;

        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();

        mIntent = new Intent(mContext, GeofencingIntentService.class);
    }

    /**
     * Monitor a geofence object
     *
     * @param geofenceObject the geofence object to monitor
     */
    public boolean monitorGeofence(GeofenceObject geofenceObject) {
        return monitorGeofences(Collections.singletonList(geofenceObject));
    }

    /**
     * Monitor a list of geofence object
     *
     * @param geofenceObjects the list of geofence objects to monitor
     */
    public boolean monitorGeofences(List<GeofenceObject> geofenceObjects) {
        return addGeofences(geofenceObjects);
    }

    /**
     * Removes a geofence previously added
     *
     * @param geofenceId the geofence id  of the geofence object to remove
     */
    public boolean removeGeofence(String geofenceId) {

        if (mGoogleApiClient.isConnected()) {

            // Remove first the extra from the general intent
            removeExtraFromIntent(geofenceId);

            LocationServices.GeofencingApi.removeGeofences(
                    mGoogleApiClient,
                    Collections.singletonList(geofenceId)
            ).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(Status status) {
                    if (mGeofencingResultCallBack != null) {
                        mGeofencingResultCallBack.onStopGeofence(status);
                    }
                }
            });

            return true;
        } else {
            return false;
        }

    }

    /**
     * Add a list of geofences objects to monitor
     *
     * @param geofenceObjects the list of geofence objects to monitor
     */
    protected boolean addGeofences(List<GeofenceObject> geofenceObjects) {

        if (geofenceObjects != null && !geofenceObjects.isEmpty() && mGoogleApiClient.isConnected()) {

            // Creating the list of geofence
            List<Geofence> listGeofences = new ArrayList<>();

            for (GeofenceObject geofenceObject : geofenceObjects) {

                Geofence geofence = new Geofence.Builder().setRequestId(geofenceObject.getId()).setTransitionTypes(geofenceObject.getTransitionType())
                        .setCircularRegion(geofenceObject.getLatitude(), geofenceObject.getLongitude(), geofenceObject.getRadius()).setExpirationDuration(geofenceObject.getExpirationDuration()).build();

                // Geofence object added to the geofence list for the pending intent
                listGeofences.add(geofence);

                // Creating the extras for the intent
                Bundle bundle = new Bundle();

                if (geofenceObject.getNotificationByTransition() != null) {
                    for (Map.Entry<Integer, GeofenceObject.Notification> notification : geofenceObject.getNotificationByTransition().entrySet()) {
                        bundle.putParcelable(GeofencingConstants.PREFIX_INTENT_NOTIFICATION_TRANSITION + notification.getKey(), notification.getValue());
                    }
                }

                addExtraToIntent(geofence.getRequestId(), bundle);

            }

            GeofencingRequest.Builder geofencingRequestBuilder = new GeofencingRequest.Builder();
            geofencingRequestBuilder.setInitialTrigger(mInitialTrigger);
            geofencingRequestBuilder.addGeofences(listGeofences);

            PendingIntent pendingIntent = PendingIntent.getService(mContext, PENDING_INTENT_REQUEST_ID, mIntent, PendingIntent.
                    FLAG_UPDATE_CURRENT);

            LocationServices.GeofencingApi.addGeofences(
                    mGoogleApiClient,
                    geofencingRequestBuilder.build(),
                    pendingIntent
            ).setResultCallback(this);

            return true;
        } else {
            return false;
        }

    }

    protected void addExtraToIntent(String geofenceId, Bundle bundle) {
        mIntent.putExtra(GeofencingConstants.PREFIX_INTENT_BUNDLE + geofenceId, bundle);
    }

    protected void removeExtraFromIntent(String geofenceId) {
        mIntent.removeExtra(GeofencingConstants.PREFIX_INTENT_BUNDLE + geofenceId);
    }

    @Override
    public void onResult(Result result) {
        Log.i(TAG, "Information for result received: " + result.toString());

        if (mGeofencingResultCallBack != null) {
            mGeofencingResultCallBack.onAddGeofence(result);
        }
    }


}
