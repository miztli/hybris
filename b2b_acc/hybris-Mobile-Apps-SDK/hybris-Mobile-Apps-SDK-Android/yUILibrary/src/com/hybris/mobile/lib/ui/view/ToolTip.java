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
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hybris.mobile.lib.ui.R;


/**
 * Text in a bubble layout
 */
public class ToolTip extends PopupWindow {
    private TextView mHelpTextView;
    private ImageView mUpImageView;
    private ImageView mDownImageView;

    public ToolTip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ToolTip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToolTip(Context context) {
        super(context);
    }

    public ToolTip(Context context, String text) {
        createToolTip(context, R.layout.tooltip, text);
    }

    /**
     * Create tooltip and position it
     *
     * @param context      : the context where tooltip belong
     * @param viewResource : anchorId
     * @param text         : message to display
     */
    private void createToolTip(Context context, int viewResource, String text) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setContentView(layoutInflater.inflate(viewResource, null));

        mHelpTextView = (TextView) getContentView().findViewById(R.id.text);
        mHelpTextView.setText(text);
        mUpImageView = (ImageView) getContentView().findViewById(R.id.arrow_up);
        mDownImageView = (ImageView) getContentView().findViewById(R.id.arrow_down);

        mHelpTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        mHelpTextView.setSelected(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.tooltip_transparent, null));
        } else {
            setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.tooltip_transparent));
        }

        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(true);
    }

    /**
     * Displays the tooltip
     *
     * @param anchor : view where the tooltip should be displayed
     * @param onTop  : on top of the view otherwise at bottom
     */
    public void show(View anchor, boolean onTop) {
        int[] location = new int[2];
        int rootHeight;
        int rootWidth;
        Rect anchorRect;
        Point screen = new Point();
        int arrowPositionY;
        int arrowPositionX;
        int tooltipArrow;
        int requestedX;
        View arrowToDisplay;
        View arrowToHide;
        int arrowWidth;

        //get screen info and measurement
        anchor.getLocationOnScreen(location);
        anchorRect = new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1] + anchor.getHeight());
        getContentView().measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        ((WindowManager) getContentView().getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getSize(screen);
        rootHeight = getContentView().getMeasuredHeight();
        rootWidth = getContentView().getMeasuredWidth();


        // Create arrow position and arrow parameters
        arrowPositionY = ((onTop) ? (anchorRect.top - rootHeight - anchor.getHeight()) : anchorRect.bottom);
        tooltipArrow = ((onTop) ? R.id.arrow_down : R.id.arrow_up);
        requestedX = anchorRect.centerX();
        arrowToDisplay = tooltipArrow == R.id.arrow_up ? mUpImageView : mDownImageView;
        arrowToHide = tooltipArrow == R.id.arrow_up ? mDownImageView : mUpImageView;
        arrowWidth = arrowToDisplay.getMeasuredWidth();
        arrowToDisplay.setVisibility(View.VISIBLE);
        ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams) arrowToDisplay.getLayoutParams();
        arrowToHide.setVisibility(View.INVISIBLE);


        // extreme right click
        if (anchorRect.left + rootWidth > screen.x) {
            arrowPositionX = (screen.x - rootWidth);
        }
        // extreme left click
        else if (anchorRect.left - (rootWidth / 2) < 0) {
            arrowPositionX = anchorRect.left;
        }
        // in between
        else {
            arrowPositionX = (anchorRect.centerX() - (rootWidth / 2));
        }

        param.leftMargin = (requestedX - arrowPositionX) - (arrowWidth / 2);

        //arrow is on top or not of the anchor view
        if (onTop) {
            mHelpTextView.setMaxHeight(anchorRect.top - anchorRect.height());

        } else {
            mHelpTextView.setMaxHeight(screen.y - arrowPositionY);
        }

        showAtLocation(anchor, Gravity.NO_GRAVITY, arrowPositionX, arrowPositionY);

    }

    /**
     * Listener on tooltip is clicked event
     *
     * @param onClickListener Callback to be invoked when a view is clicked.
     */
    public void setOnClickListener(OnClickListener onClickListener) {
        mHelpTextView.setOnClickListener(onClickListener);
    }

}
