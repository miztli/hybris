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

package com.hybris.mobile.lib.location;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.LatLng;


/**
 * Utilities for location
 */
public class LocationUtils {

    /**
     * Return true if the device has location services activated
     *
     * @param context Application-specific resources
     * @return true if the device has location services activated
     */
    public static boolean isLocationActivated(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        return isGps || isNetwork;
    }

    /**
     * Show a dialog notifying that the location services are disabled, and offering the choice to the user to jump into
     * the location settings
     *
     * @param context Application-specific resources
     */
    public static void showDialogEnableLocationServices(final Activity context) {
        final Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(context.getString(R.string.hybris_map_location_services_not_enabled_title_dialog));
        dialog.setMessage(context.getString(R.string.hybris_map_location_services_not_enabled_msg_dialog));
        dialog.setPositiveButton(R.string.hybris_map_location_services_not_enabled_msg_button_enable,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                });

        dialog.setNegativeButton(R.string.hybris_map_location_services_not_enabled_msg_button_cancel,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });

        DialogFragment errorFragment = new DialogFragment() {
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                // Prevent the dialog to be killed on config changes
                setRetainInstance(true);
            }

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                return dialog.create();
            }
        };

        // Show the error dialog
        errorFragment.show(context.getFragmentManager(), context.getString(
                R.string.hybris_map_location_services_not_enabled_title_dialog));
    }

    /**
     * Check whether or not Google Play services is available on the device
     *
     * @param context Application-specific resources
     * @return True Google Play services is available on the device else false
     */
    public static boolean isGooglePlayServicesConnected(Context context) {
        return ConnectionResult.SUCCESS == GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
    }

    /**
     * Send an intent for the directions from point A to B
     *
     * @param context Application-specific resources
     * @param from    Source coordinate
     * @param to      Destination coordinate
     */
    public static void sendDirectionsIntent(Context context, LatLng from, LatLng to) {
        if (context != null && to != null) {
            if (from != null) {
                context.startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(context.getString(
                        R.string.maps_direction_url, from.latitude + "", from.longitude + "", to.latitude + "",
                        to.longitude + ""))));
            } else {
                context.startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(context.getString(
                        R.string.maps_direction_url, "", "", to.latitude + "", to.longitude + ""))));
            }
        }
    }
}
