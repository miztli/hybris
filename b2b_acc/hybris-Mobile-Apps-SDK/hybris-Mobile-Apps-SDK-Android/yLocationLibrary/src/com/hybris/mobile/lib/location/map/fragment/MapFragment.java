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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback;
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hybris.mobile.lib.location.R;
import com.hybris.mobile.lib.location.map.MapConfiguration;
import com.hybris.mobile.lib.location.map.data.MapItem;
import com.hybris.mobile.lib.location.map.listener.MapDataCallbacks;
import com.hybris.mobile.lib.location.map.listener.MapDataLoader;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Fragment to display a map
 */
public class MapFragment extends LocationFragment {
    private static final String TAG = MapFragment.class.getCanonicalName();
    private GoogleMap mMap;
    private MapDataLoader mMapDataLoader;
    private MapConfiguration mMapConfiguration;
    private LatLngBounds mBoundsToFitMap;
    private boolean mIsMapLoaded = false;
    private boolean mIsMapStatic = false;
    private Map<String, MapItem> mMarkerIdMapItem;
    private Map<String, Marker> mMapItemIdMarker;

    // Needed for static maps, we need to wait the end of the camera animation to take the snapshot
    private CancelableCallback mCameraAnimationCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mMapDataLoader = (MapDataLoader) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException(activity.getClass().getCanonicalName()
                    + " must implement the MapDataLoader interface. Details: " + e.getLocalizedMessage());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // Map configuration
        mMapConfiguration = mMapDataLoader.getMapConfiguration();

        if (mMapConfiguration == null) {
            mMapConfiguration = MapConfiguration.build();
        }

        // Register for geolocation
        registerForDeviceLocation(mMapConfiguration.isDeviceLocation());

        mMarkerIdMapItem = new LinkedHashMap<>();
        mMapItemIdMarker = new HashMap<>();

        initMapIfNeeded();

        super.onActivityCreated(savedInstanceState);
    }

    public void centerMap(LatLng latLng) {
        if (!mIsMapStatic && mMap != null && latLng != null) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, mMapConfiguration.getZoomLevel()), mMapConfiguration.getAnimationSpeed(), mCameraAnimationCallback);
        }
    }

    /**
     * Update the map with the list of items
     *
     * @param items List of Map Data
     */
    public void updateMap(List<MapItem> items) {
        if (!mIsMapStatic && mMap != null && items != null) {

            mBoundsToFitMap = null;

            for (MapItem mapItem : items) {

                Marker marker = mMap.addMarker(new MarkerOptions().position(mapItem.getLocation()).title(mapItem.getName())
                        .snippet(mapItem.getDescription()));

                // Saving the marker
                mMarkerIdMapItem.put(marker.getId(), mapItem);

                // Icon configuration
                if (mapItem.getMapIconConfiguration() != null) {

                    if (mapItem.getMapIconConfiguration().getIcon() != null) {
                        marker.setIcon(BitmapDescriptorFactory.fromBitmap(mapItem.getMapIconConfiguration().getIcon()));
                    } else if (mapItem.getMapIconConfiguration().getIconResId() != -1) {
                        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(mapItem.getMapIconConfiguration()
                                .getIconResId());

                        try {
                            // TODO - BAD CATCH - Check why we have a nullpointer exception if we reference an icon from the google-play-services lib
                            marker.setIcon(bitmapDescriptor);
                        } catch (Exception e) {
                            Log.e(TAG, "");
                        }
                    } else if (mapItem.getMapIconConfiguration().getHueColor() != -1) {
                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(mapItem.getMapIconConfiguration().getHueColor()));
                    }

                    if (mapItem.getMapIconConfiguration().getOpacity() != -1) {
                        marker.setAlpha(mapItem.getMapIconConfiguration().getOpacity());
                    }

                }

                mMapItemIdMarker.put(mapItem.getId(), marker);
            }

            // We construct the list of bounds
            if (!mMapItemIdMarker.isEmpty()) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();

                // We construct the bounds
                for (Marker marker : mMapItemIdMarker.values()) {
                    builder.include(marker.getPosition());
                }

                mBoundsToFitMap = builder.build();
            }

            // Update the position of the camera
            updateCameraPosition();

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        onConnected();
    }

    /**
     * Configure the map
     */
    @SuppressLint("NewApi")
    protected void initMapIfNeeded() {
        if (mMap == null) {
            com.google.android.gms.maps.MapFragment mapFragment = null;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                mapFragment = ((com.google.android.gms.maps.MapFragment) (getChildFragmentManager()
                        .findFragmentById(R.id.hybris_map)));
            }

            if (mapFragment == null) {
                mapFragment = ((com.google.android.gms.maps.MapFragment) (getFragmentManager()
                        .findFragmentById(R.id.hybris_map)));
            }

            if (mapFragment != null) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        mMap = googleMap;
                        configureMap();
                    }
                });
            }

        }
    }

    /**
     * Configure the map
     */
    protected void configureMap() {
        // Needed for static maps, we need to wait the end of the camera animation to take the snapshot
        mCameraAnimationCallback = new CancelableCallback() {

            @Override
            public void onFinish() {
                // Callback indicating that the map finish to load (after the animation) (for static case we wait to receive the map snapshot)
                if (!mMapConfiguration.isStaticMap()) {
                    mMapDataLoader.onMapCameraChange();
                }

                // After the animation, if we want a static map, we take a snapshot and display it
                // We put the flag static to true to disable all map features
                if (mMapConfiguration != null && mMap != null && mMapConfiguration.isStaticMap()) {

                    // We need to re-trigger the map loaded callback to wait for the map to completely load after the animation
                    mMap.setOnMapLoadedCallback(new OnMapLoadedCallback() {

                        @Override
                        public void onMapLoaded() {

                            mMap.snapshot(new SnapshotReadyCallback() {

                                @Override
                                public void onSnapshotReady(Bitmap arg0) {
                                    // Flag static to true
                                    mIsMapStatic = true;

                                    // Creating an imageview with the snapshot
                                    ImageView imageView = new ImageView(getActivity());
                                    imageView.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                                            LayoutParams.WRAP_CONTENT));
                                    imageView.setImageBitmap(arg0);

                                    // Removing all the views (dynamic map) and adding the imageview
                                    assert getView() != null;
                                    ((ViewGroup) getView()).removeAllViews();
                                    ((ViewGroup) getView()).addView(imageView);

                                    mMapDataLoader.onMapCameraChange();
                                }
                            });
                        }
                    });

                }
            }

            @Override
            public void onCancel() {
            }
        };

        // Configure the map
        // Map type
        int mapType = GoogleMap.MAP_TYPE_NORMAL;
        switch (mMapConfiguration.getViewType()) {
            case HYBRID:
                mapType = GoogleMap.MAP_TYPE_HYBRID;
                break;
            case NONE:
                mapType = GoogleMap.MAP_TYPE_NONE;
                break;
            case NORMAL:
                mapType = GoogleMap.MAP_TYPE_NORMAL;
                break;
            case SATELLITE:
                mapType = GoogleMap.MAP_TYPE_SATELLITE;
                break;
            case TERRAIN:
                mapType = GoogleMap.MAP_TYPE_TERRAIN;
                break;
            default:
                break;

        }
        mMap.setMapType(mapType);

        // Info window adapter
        mMap.setInfoWindowAdapter(new InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                if (mMarkerIdMapItem.containsKey(arg0.getId())) {
                    return mMapDataLoader.getMapItemViewWindow(mMarkerIdMapItem.get(arg0.getId()));
                }
                return null;
            }

            @Override
            public View getInfoContents(Marker arg0) {
                if (mMarkerIdMapItem.containsKey(arg0.getId())) {
                    return mMapDataLoader.getMapItemViewContent(mMarkerIdMapItem.get(arg0.getId()));
                }
                return null;
            }
        });

        // Info window on click
        mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (mMarkerIdMapItem.containsKey(marker.getId())) {
                    mMapDataLoader.onMapItemClick(mMarkerIdMapItem.get(marker.getId()));
                }
            }
        });

        // Zoom controls
        mMap.getUiSettings().setZoomControlsEnabled(mMapConfiguration.isZoomControls());

        // Device location
        mMap.setMyLocationEnabled(mMapConfiguration.isDeviceLocation());

        // Map animation after loaded
        mMap.setOnMapLoadedCallback(new OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mIsMapLoaded = true;
                mMapDataLoader.onMapLoaded();
            }
        });

    }

    /**
     * Update the camera's position
     */
    protected void updateCameraPosition() {
        if (!mIsMapStatic && mMap != null && mMapConfiguration != null && mIsMapLoaded) {
            updateCameraPosition(mMapConfiguration.getCameraPosition());
        }
    }

    /**
     * Update the camera's position according to the camera's position parameter
     *
     * @param cameraPosition Camera position
     */
    protected void updateCameraPosition(MapConfiguration.CameraPosition cameraPosition) {

        switch (cameraPosition) {

            // Center on the device location
            case DEFAULT:
            case CENTER_DEVICE_LOCATION:

                if (getDeviceLocation() != null) {
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(getDeviceLocation().getLatitude(),
                            getDeviceLocation().getLongitude()), mMapConfiguration.getZoomLevel()), mMapConfiguration.getAnimationSpeed(), mCameraAnimationCallback);
                } else if (mBoundsToFitMap != null) {
                    updateCameraPosition(MapConfiguration.CameraPosition.FITS_ALL_ITEMS);
                }

                break;

            case CENTER_FIRST_ITEM:

                if (mMarkerIdMapItem != null && !mMarkerIdMapItem.isEmpty()) {
                    MapItem mapItem = mMarkerIdMapItem.entrySet().iterator().next().getValue();
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mapItem.getLocation().latitude, mapItem.getLocation().longitude), mMapConfiguration.getZoomLevel()), mMapConfiguration.getAnimationSpeed(), mCameraAnimationCallback);
                } else if (mBoundsToFitMap != null) {
                    updateCameraPosition(MapConfiguration.CameraPosition.DEFAULT);
                }

                break;

            // Fits all items in the map
            case FITS_ALL_ITEMS:

                if (mBoundsToFitMap != null) {
                    mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(mBoundsToFitMap, mMapConfiguration.getPadding()), mMapConfiguration.getAnimationSpeed(), mCameraAnimationCallback);
                } else {
                    updateCameraPosition(MapConfiguration.CameraPosition.DEFAULT);
                }

                break;

            // Fits the device location + the nearest item
            case FITS_DEVICE_LOCATION_NEAREST_ITEM:

                if (getDeviceLocation() != null && mMarkerIdMapItem != null && !mMarkerIdMapItem.isEmpty()) {

                    float[] results = new float[1];

                    // Dummy distance as far as possible
                    float distance = 1000000000;

                    LatLng nearestItem = null;

                    // Calculating the nearest point from the list
                    for (Map.Entry<String, MapItem> mapItem : mMarkerIdMapItem.entrySet()) {

                        // First item initialization
                        if (nearestItem == null) {
                            nearestItem = new LatLng(mapItem.getValue().getLocation().latitude, mapItem.getValue().getLocation().longitude);
                        }

                        // Calculating the distance
                        Location.distanceBetween(getDeviceLocation().getLatitude(), getDeviceLocation().getLongitude(), mapItem.getValue().getLocation().latitude, mapItem.getValue().getLocation().longitude, results);

                        // If the item is closer than the previous one we save it
                        if (results[0] < distance) {
                            nearestItem = new LatLng(mapItem.getValue().getLocation().latitude, mapItem.getValue().getLocation().longitude);
                            distance = results[0];
                        }
                    }

                    // Bounds with the device location + the nearest item
                    LatLngBounds.Builder builder = new LatLngBounds.Builder();
                    builder.include(nearestItem != null ? nearestItem : null);
                    builder.include(new LatLng(getDeviceLocation().getLatitude(), getDeviceLocation().getLongitude()));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), mMapConfiguration.getPadding()), mMapConfiguration.getAnimationSpeed(), mCameraAnimationCallback);
                } else {
                    updateCameraPosition(MapConfiguration.CameraPosition.DEFAULT);
                }

                break;
        }
    }

    /**
     * Get a snapshot of the map
     *
     * @param mapDataCallback Map Data Call Back
     */
    public void getSnapshot(final MapDataCallbacks mapDataCallback) {
        if (mMap != null) {
            mMap.snapshot(new SnapshotReadyCallback() {

                @Override
                public void onSnapshotReady(Bitmap arg0) {
                    mapDataCallback.onSnapshotReady(arg0);
                }
            });
        }
    }

    @Override
    protected void onConnected() {
        initMapIfNeeded();

        if (mMapDataLoader != null) {
            mMapDataLoader.onConnected(getDeviceLocation());
        }
    }

    /**
     * Return the map
     *
     * @return
     */
    public GoogleMap getMap() {
        return mMap;
    }


    /**
     * Remove an item from the map
     *
     * @param itemId
     */
    public void removeItemFromMap(String itemId) {
        if (mMapItemIdMarker != null && mMapItemIdMarker.containsKey(itemId)) {
            mMapItemIdMarker.get(itemId).remove();
        }
    }

    /**
     * Clear the mapof all the items
     */
    public void clearMap() {
        if (mMap != null) {
            mMap.clear();
        }
    }

}
