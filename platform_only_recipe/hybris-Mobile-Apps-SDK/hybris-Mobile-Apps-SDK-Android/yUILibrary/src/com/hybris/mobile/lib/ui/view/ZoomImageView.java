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
package com.hybris.mobile.lib.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.ImageView;


/**
 * UI element that allows ImageView to be zoomable with different gestures
 */
public class ZoomImageView extends ImageView {
    private static final float MIN_ZOOM = 1.0f;
    private static final float MAX_ZOOM = 3.0f;

    private final ScaleGestureDetector scaleDetector;
    private final GestureDetector doubleTapDetector;

    public ZoomImageView(Context context) {
        super(context);
        scaleDetector = new ScaleGestureDetector(context, pinchListener);
        doubleTapDetector = new GestureDetector(context, doubleTapListener);
    }

    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        scaleDetector = new ScaleGestureDetector(context, pinchListener);
        doubleTapDetector = new GestureDetector(context, doubleTapListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performClick();
        scaleDetector.onTouchEvent(event);
        doubleTapDetector.onTouchEvent(event);
        invalidate();
        return super.onTouchEvent(event);
    }

    /**
     * Listener for double tap gesture
     */
    private final SimpleOnGestureListener doubleTapListener = new SimpleOnGestureListener() {
        private boolean isZoomMax = false;

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (!isZoomMax) {
                setScaleX(MAX_ZOOM);
                setScaleY(MAX_ZOOM);
                isZoomMax = true;
            } else {
                setScaleX(MIN_ZOOM);
                setScaleY(MIN_ZOOM);
                isZoomMax = false;
            }
            invalidate();
            return true;
        }
    };

    /**
     * Listener for pinch gesture
     */
    private final SimpleOnScaleGestureListener pinchListener = new SimpleOnScaleGestureListener() {
        private float scaleFactor = MIN_ZOOM;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(MIN_ZOOM, Math.min(scaleFactor, MAX_ZOOM));

            setScaleX(scaleFactor);
            setScaleY(scaleFactor);
            invalidate();
            return super.onScale(detector);
        }
    };
}
