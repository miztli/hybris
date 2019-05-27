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

import android.graphics.Bitmap;


/**
 * Class for map icon configuration
 */
public class MapIconConfiguration {
    // Bitmap icon
    private Bitmap mIcon;

    // Icon resource id
    private int mIconResId = -1;

    // Image opacity
    private float mOpacity = -1;

    // Default pin image color
    private float mHueColor = -1;

    private MapIconConfiguration() {
    }

    public static MapIconConfiguration build() {
        return new MapIconConfiguration();
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public MapIconConfiguration setIcon(Bitmap icon) {
        mIcon = icon;
        return this;
    }

    public int getIconResId() {
        return mIconResId;
    }

    public MapIconConfiguration setIconResId(int iconResId) {
        mIconResId = iconResId;
        return this;
    }

    public float getOpacity() {
        return mOpacity;
    }

    public MapIconConfiguration setOpacity(float opacity) {
        mOpacity = opacity;
        return this;
    }

    public float getHueColor() {
        return mHueColor;
    }

    public MapIconConfiguration setHueColor(float hueColor) {
        mHueColor = hueColor;
        return this;
    }

}
