package com.hybris.mobile.lib.location.geofencing.data;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/**
 * Interface for geofencing callbacks
 */
public interface GeofencingResultCallBack {
    /**
     * After adding a geofence
     *
     * @param result the result
     */
    void onAddGeofence(Result result);

    /**
     * On connection failed with google play services
     *
     * @param connectionResult the result
     */
    void onConnectionFailed(ConnectionResult connectionResult);

    /**
     * After disabling/deleting a geofence
     *
     * @param status the status
     */
    void onStopGeofence(Status status);
}
