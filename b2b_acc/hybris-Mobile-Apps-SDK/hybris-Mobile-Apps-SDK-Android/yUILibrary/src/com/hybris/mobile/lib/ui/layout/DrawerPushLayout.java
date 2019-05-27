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
package com.hybris.mobile.lib.ui.layout;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;


/**
 * Drawer that pushes the content instead of overlapping it
 */
public class DrawerPushLayout extends DrawerLayout {
    private boolean mHandleTouchEvent = true;
    private DrawerPushLayoutListener mDrawerPushLayoutListener;

    public DrawerPushLayout(Context context) {
        super(context);
        init();
    }

    public DrawerPushLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DrawerPushLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init();
    }

    /**
     * Init the drawer layout
     */
    protected void init() {
        setDrawerListener(new DrawerListener() {

            @Override
            public void onDrawerStateChanged(int arg0) {
            }

            @Override
            public void onDrawerSlide(View arg0, float slideOffset) {
                // Calculation of the x coordinates to slide to
                float toX = arg0.getWidth() * slideOffset;

                // If the drawer is positioned on the right, we push the content to the left
                if (isDrawerVisible(Gravity.END)) {
                    toX = -toX;
                }

                getChildAt(0).setX(toX);
            }

            @Override
            public void onDrawerOpened(View arg0) {
                if (mDrawerPushLayoutListener != null) {
                    mDrawerPushLayoutListener.onDrawerOpened();
                }
            }

            @Override
            public void onDrawerClosed(View arg0) {
                if (mDrawerPushLayoutListener != null) {
                    mDrawerPushLayoutListener.onDrawerClosed();
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        performClick();

        return mHandleTouchEvent && super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return mHandleTouchEvent && super.onInterceptTouchEvent(arg0);
    }

    /**
     * Disable touch events
     */
    public void disableTouchEvent() {
        mHandleTouchEvent = false;
    }

    /**
     * Enable touch events
     */
    public void enableTouchEvent() {
        mHandleTouchEvent = true;
    }

    /**
     * Register the DrawerPushLayoutListener
     *
     * @param drawerPushLayoutListener Listener for drawer actions
     */
    public void setDrawerPushLayoutListener(DrawerPushLayoutListener drawerPushLayoutListener) {
        this.mDrawerPushLayoutListener = drawerPushLayoutListener;
    }

    /**
     * Listener for drawer actions
     */
    public interface DrawerPushLayoutListener {
        /**
         * Called when the drawer opens
         */
        void onDrawerOpened();

        /**
         * Called when the drawer closes
         */
        void onDrawerClosed();
    }

}
