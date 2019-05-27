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

package com.hybris.mobile.lib.location.map;


/**
 * Class for map configuration
 */
public class MapConfiguration {
    // Activate the device location
    private boolean mDeviceLocation = true;

    // Activate the zoom controls
    private boolean mZoomControls = true;

    // Zoom level
    private int mZoomLevel = 0;

    // View type of the map
    private ViewType mViewType = ViewType.NORMAL;

    // If true the map stay static (image)
    private boolean mStaticMap = false;

    // Camera's position
    private CameraPosition mCameraPosition = CameraPosition.CENTER_DEVICE_LOCATION;

    // Padding for the points on the maps
    private int mPadding;

    // Animation speed
    private int mAnimationSpeed = 500;

    public enum ViewType {
        NONE, NORMAL, HYBRID, SATELLITE, TERRAIN
    }

    public enum CameraPosition {
        DEFAULT, CENTER_DEVICE_LOCATION, CENTER_FIRST_ITEM, FITS_ALL_ITEMS, FITS_DEVICE_LOCATION_NEAREST_ITEM
    }

    private MapConfiguration() {
    }

    public static MapConfiguration build() {
        return new MapConfiguration();
    }

    public int getAnimationSpeed() {
        return mAnimationSpeed;
    }

    public MapConfiguration setAnimationSpeed(int animationSpeed) {
        this.mAnimationSpeed = animationSpeed;
        return this;
    }

    public int getPadding() {
        return mPadding;
    }

    public MapConfiguration setPadding(int padding) {
        this.mPadding = padding;
        return this;
    }

    public boolean isZoomControls() {
        return mZoomControls;
    }

    public MapConfiguration setZoomControls(boolean zoomControls) {
        this.mZoomControls = zoomControls;
        return this;
    }

    public int getZoomLevel() {
        return mZoomLevel;
    }

    public MapConfiguration setZoomLevel(int zoomLevel) {
        this.mZoomLevel = zoomLevel;
        return this;
    }

    public ViewType getViewType() {
        return mViewType;
    }

    public MapConfiguration setViewType(ViewType viewType) {
        this.mViewType = viewType;
        return this;
    }

    public CameraPosition getCameraPosition() {
        return mCameraPosition;
    }

    public MapConfiguration setCameraPosition(CameraPosition cameraPosition) {
        this.mCameraPosition = cameraPosition;
        return this;
    }

    public boolean isDeviceLocation() {
        return mDeviceLocation;
    }

    public MapConfiguration setDeviceLocation(boolean deviceLocation) {
        this.mDeviceLocation = deviceLocation;
        return this;
    }

    public boolean isStaticMap() {
        return mStaticMap;
    }

    public MapConfiguration setStaticMap(boolean staticMap) {
        mStaticMap = staticMap;
        return this;
    }

}
