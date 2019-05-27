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
package com.hybris.mobile.lib.location.geofencing.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.location.Geofence;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Object for geofencing
 */
public class GeofenceObject {
    private static final long DEFAULT_EXPIRATION_DURATION = Geofence.NEVER_EXPIRE;
    private static final float DEFAULT_RADIUS = 100;
    private static final int DEFAULT_TRANSITION_TYPE = Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT;

    private String id;
    private double latitude;
    private double longitude;
    private float radius;
    private long expirationDuration;
    private int transitionType;
    private Map<Integer, Notification> notificationByTransition;

    private GeofenceObject(Builder builder) {
        id = builder.id;
        latitude = builder.latitude;
        longitude = builder.longitude;
        radius = builder.radius;
        expirationDuration = builder.expirationDuration;
        transitionType = builder.transitionType;
        notificationByTransition = builder.notificationByTransition;
    }

    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public float getRadius() {
        return radius;
    }

    public long getExpirationDuration() {
        return expirationDuration;
    }

    public int getTransitionType() {
        return transitionType;
    }

    public Map<Integer, Notification> getNotificationByTransition() {
        return notificationByTransition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeofenceObject that = (GeofenceObject) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (Float.compare(that.radius, radius) != 0) return false;
        if (expirationDuration != that.expirationDuration) return false;
        if (transitionType != that.transitionType) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(notificationByTransition != null ? !notificationByTransition.equals(that.notificationByTransition) : that.notificationByTransition != null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (radius != +0.0f ? Float.floatToIntBits(radius) : 0);
        result = 31 * result + (int) (expirationDuration ^ (expirationDuration >>> 32));
        result = 31 * result + transitionType;
        result = 31 * result + (notificationByTransition != null ? notificationByTransition.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private String id;
        private double latitude;
        private double longitude;
        private float radius;
        private long expirationDuration;
        private int transitionType;
        private Map<Integer, Notification> notificationByTransition;

        public Builder(String id, double latitude, double longitude, Map<Integer, Notification> notificationByTransition) {
            this.id = id;
            this.latitude = latitude;
            this.longitude = longitude;
            this.notificationByTransition = notificationByTransition;
            this.radius = DEFAULT_RADIUS;
            this.expirationDuration = DEFAULT_EXPIRATION_DURATION;
            this.transitionType = DEFAULT_TRANSITION_TYPE;
            this.notificationByTransition = notificationByTransition;
        }

        public Builder setRadius(float radius) {
            this.radius = radius;
            return this;
        }

        public Builder setExpirationDuration(long expirationDuration) {
            this.expirationDuration = expirationDuration;
            return this;
        }

        public Builder setTransitionType(int transitionType) {
            this.transitionType = transitionType;
            return this;
        }

        public GeofenceObject build() {
            return new GeofenceObject(this);
        }
    }

    public static class Notification implements Parcelable {
        private String intentClassDestination;
        private IntentBundle intentBundle;
        private int notificationIconResId;
        private String notificationTitle;
        private String notificationText;

        private Notification(Notification.Builder builder) {
            this.intentClassDestination = builder.intentClassDestination;
            this.intentBundle = builder.intentBundle;
            this.notificationIconResId = builder.notificationIconResId;
            this.notificationTitle = builder.notificationTitle;
            this.notificationText = builder.notificationText;
        }

        private Notification(Parcel source) {
            intentClassDestination = source.readString();
            intentBundle = source.readParcelable(this.getClass().getClassLoader());
            notificationIconResId = source.readInt();
            notificationTitle = source.readString();
            notificationText = source.readString();
        }

        public String getIntentClassDestination() {
            return intentClassDestination;
        }

        public IntentBundle getIntentBundle() {
            return intentBundle;
        }

        public int getNotificationIconResId() {
            return notificationIconResId;
        }

        public String getNotificationTitle() {
            return notificationTitle;
        }

        public String getNotificationText() {
            return notificationText;
        }

        public static final Parcelable.Creator<Notification> CREATOR = new Parcelable.Creator<Notification>() {
            @Override
            public Notification createFromParcel(Parcel source) {
                return new Notification(source);
            }

            @Override
            public Notification[] newArray(int size) {
                return new Notification[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(intentClassDestination);
            dest.writeParcelable(intentBundle, flags);
            dest.writeInt(notificationIconResId);
            dest.writeString(notificationTitle);
            dest.writeString(notificationText);
        }

        public static class Builder {
            private String intentClassDestination;
            private IntentBundle intentBundle;
            private int notificationIconResId;
            private String notificationTitle;
            private String notificationText;

            public Builder(String notificationTitle, String notificationText) {
                this.notificationTitle = notificationTitle;
                this.notificationText = notificationText;
            }

            public Notification.Builder setIntentClassDestination(String intentClassDestination) {
                this.intentClassDestination = intentClassDestination;
                return this;
            }

            public Notification.Builder setIntentBundle(IntentBundle intentBundle) {
                this.intentBundle = intentBundle;
                return this;
            }

            public Notification.Builder setNotificationIconResId(int notificationIconResId) {
                this.notificationIconResId = notificationIconResId;
                return this;
            }

            public Notification build() {
                return new Notification(this);
            }
        }

        @Override
        public String toString() {
            return "Notification{" +
                    "intentClassDestination='" + intentClassDestination + '\'' +
                    ", intentBundle=" + intentBundle +
                    ", notificationIconResId=" + notificationIconResId +
                    ", notificationTitle='" + notificationTitle + '\'' +
                    ", notificationText='" + notificationText + '\'' +
                    '}';
        }
    }

    public static class IntentBundle implements Parcelable {

        private Bundle bundle;
        private String keyName;

        public IntentBundle(Bundle bundle, String keyName) {

            if (bundle == null || StringUtils.isBlank(keyName)) {
                throw new IllegalArgumentException("You must provide a bundle and a key name for it.");
            }

            this.bundle = bundle;
            this.keyName = keyName;
        }

        private IntentBundle(Parcel source) {
            bundle = source.readBundle();
            keyName = source.readString();
        }

        public Bundle getBundle() {
            return bundle;
        }

        public String getKeyName() {
            return keyName;
        }

        public static final Parcelable.Creator<IntentBundle> CREATOR = new Parcelable.Creator<IntentBundle>() {
            @Override
            public IntentBundle createFromParcel(Parcel source) {
                return new IntentBundle(source);
            }

            @Override
            public IntentBundle[] newArray(int size) {
                return new IntentBundle[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBundle(bundle);
            dest.writeString(keyName);
        }

        @Override
        public String toString() {
            return "IntentBundle{" +
                    "bundle=" + bundle +
                    ", keyName='" + keyName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GeofenceObject{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                ", expirationDuration=" + expirationDuration +
                ", transitionType=" + transitionType +
                ", notificationByTransition=" + notificationByTransition +
                '}';
    }
}
