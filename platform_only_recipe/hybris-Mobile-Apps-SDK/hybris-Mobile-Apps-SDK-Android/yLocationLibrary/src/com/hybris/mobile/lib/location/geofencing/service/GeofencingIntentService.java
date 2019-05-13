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
package com.hybris.mobile.lib.location.geofencing.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.hybris.mobile.lib.location.R;
import com.hybris.mobile.lib.location.geofencing.GeofencingConstants;
import com.hybris.mobile.lib.location.geofencing.data.GeofenceObject;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * Intent service when a geofence is triggered
 */
public class GeofencingIntentService extends IntentService {
    private static final String TAG = GeofencingIntentService.class.getCanonicalName();

    public GeofencingIntentService() {
        super("GeofencingIntentService");
    }

    /**
     * Handles incoming intents
     *
     * @param intent The Intent sent by Location Services. This Intent is provided to Location Services (inside a
     *               PendingIntent) when you call addGeofences()
     */
    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "Geofencing event received");

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        // Check for errors
        if (geofencingEvent.hasError()) {
            Log.e(TAG, "Error with geofencing. Error Code: " + geofencingEvent.getErrorCode());
        } else {
            // Get the type of transition (entry or leaving_geofence)
            int geofenceTransition = geofencingEvent.getGeofenceTransition();

            Log.i(TAG, "Geofence transition type: " + geofenceTransition);

            // Test that a valid transition was reported
            if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER ||
                    geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT) {

                // Post a notification
                List<Geofence> geofences = geofencingEvent.getTriggeringGeofences();

                if (geofences != null && !geofences.isEmpty()) {
                    for (Geofence geofence : geofences) {

                        Log.d(TAG, "Intent information: ");

                        Bundle intentBundle = intent.getBundleExtra(GeofencingConstants.PREFIX_INTENT_BUNDLE + geofence.getRequestId());

                        if (intentBundle != null) {

                            Log.d(TAG, "Bundle information: ");
                            for (String key : intentBundle.keySet()) {
                                Log.d(TAG, "Key: " + key + ". Value: " + intentBundle.get(key));
                            }

                            sendNotification(geofence, (GeofenceObject.Notification) intentBundle.getParcelable(GeofencingConstants.PREFIX_INTENT_NOTIFICATION_TRANSITION + geofenceTransition), geofenceTransition);
                        } else {
                            Log.e(TAG, "No bundle found for geofence id " + geofence.getRequestId());
                        }

                    }
                } else {
                    Log.e(TAG, "No associated geofences found for transition " + geofenceTransition);
                }

            } else {
                // Log the error.
                Log.e(TAG, "Geofence transition not supported by the library. Details: " + geofenceTransition);
            }
        }
    }

    /**
     * Send a notification when a geofence is triggered
     *
     * @param geofence           the geofence triggered
     * @param notification       the notification object
     * @param geofenceTransition the geofence transition type
     */
    protected void sendNotification(Geofence geofence, GeofenceObject.Notification notification, int geofenceTransition) {

        if (notification != null) {

            // Notification
            String notificationContentTitle = notification.getNotificationTitle();
            String notificationContentText = notification.getNotificationText();
            int notificationIconResId = notification.getNotificationIconResId();

            Notification.Builder builder = new Notification.Builder(this);

            builder.setContentTitle(notificationContentTitle)
                    .setContentText(notificationContentText);

            if (notificationIconResId > 0) {
                builder.setSmallIcon(notificationIconResId);
            }

            try {
                // Intent on click on the notification
                if (StringUtils.isNotBlank(notification.getIntentClassDestination())) {
                    Class<?> intentClassDestination = Class.forName(notification.getIntentClassDestination());

                    // Create an explicit content Intent that starts the Activity defined in intentClassDestination
                    Intent notificationIntent = new Intent(this, intentClassDestination);

                    // Geofence Id to pass to the activity in order to retrieve the object
                    if (notification.getIntentBundle() != null) {
                        GeofenceObject.IntentBundle intentBundle = notification.getIntentBundle();
                        notificationIntent.putExtra(intentBundle.getKeyName(), intentBundle.getBundle());

                        // Easter egg :)
                        if (intentBundle.getBundle().getBoolean(GeofencingConstants.EXTRA_PLAY_SOUND)) {
                            MediaPlayer mediaPlayer;
                            if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER) {
                                Log.d(TAG, "Playing entering geofence sound");
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.entering_geofence);
                            } else {
                                Log.d(TAG, "Playing exiting geofence sound");
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.leaving_geofence);
                            }

                            mediaPlayer.start();
                        }
                    }

                    PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, geofence.getRequestId().hashCode(),
                            notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    builder.setContentIntent(notificationPendingIntent);
                }


            } catch (ClassNotFoundException e) {
                Log.e(TAG,
                        "Unable to find class " + notification.getIntentClassDestination() + "."
                                + e.getLocalizedMessage());
            }

            // Constructing the Notification and setting the flag to auto remove the notification when the user click on it
            Notification notificationView;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                notificationView = builder.build();
            } else {
                notificationView = builder.getNotification();
            }

            notificationView.flags = Notification.FLAG_AUTO_CANCEL;
            notificationView.defaults = Notification.DEFAULT_ALL;

            // Get an instance of the Notification manager
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // Issue the notification
            mNotificationManager.notify(UUID.randomUUID().toString().hashCode(), notificationView);
        } else {
            Log.e(TAG, "Notification empty for Geofence " + geofence);
        }

    }

}
