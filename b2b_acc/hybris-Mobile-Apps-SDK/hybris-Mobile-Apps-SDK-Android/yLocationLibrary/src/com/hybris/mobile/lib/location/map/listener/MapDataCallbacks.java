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

package com.hybris.mobile.lib.location.map.listener;

import android.graphics.Bitmap;


/**
 * Interface for map callbacks
 */
public interface MapDataCallbacks {

    /**
     * Called when the snapshot image is ready
     *
     * @param bitmap Bit array
     */
    void onSnapshotReady(Bitmap bitmap);

}
