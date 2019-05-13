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

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;

import com.hybris.mobile.lib.ui.R;


/**
 * EditText extension that allows the keyboard to move the content above a view identified by a view ID in the XML.
 */
public class EditTextPushContent extends EditText {
    private static int anchorId;

    /**
     * Move the content on top of the keyboard
     *
     * @param context Application-specific resources
     * @param attrs   Properties of the view
     */
    public EditTextPushContent(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (attrs == null) {
            throw new IllegalArgumentException();
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditTextPushContent);
        final int anchorIdEditText = typedArray.getResourceId(R.styleable.EditTextPushContent_anchorId, -1);
        typedArray.recycle();

        if (anchorIdEditText == -1) {
            throw new IllegalArgumentException();
        }

        // Move up/down the main content in order to be able to view the view identified by the anchor id when the keyboard is displayed
        final View mainView = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        mainView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {

                Rect rectMainView = new Rect();
                mainView.getWindowVisibleDisplayFrame(rectMainView);

                // Retrieve the difference between the height of the viewable view and the global view
                int heightDiff = mainView.getRootView().getHeight() - (rectMainView.bottom - rectMainView.top);

                // We assume that a soft keyboard occupy at least 100px on the screen
                if (heightDiff > 100) {

                    // Getting the location of the anchor id view
                    View anchorView = mainView.findViewById(anchorId);

                    if (anchorView != null) {
                        int[] location = new int[2];
                        anchorView.getLocationOnScreen(location);
                        int anchorY = location[1];

                        // Calculating the translation
                        //						int translation = (anchorY + anchorView.getHeight()) - rectMainView.bottom;
                        EditTextPushContent.this.getLocationOnScreen(location);
                        int translation = (anchorY + anchorView.getHeight()) - location[1];

                        // Sometimes after the view was translated, we keep getting a translation of 1-2 so we put this error margin of 5 to translate
                        if (translation > 5) {
                            // We translate the main view to be able to view the anchor id view
                            mainView.animate().translationY(-(translation));
                        }
                    }

                }
                // Otherwise we revert back the main view position
                else {
                    mainView.animate().translationY(0);
                }

            }
        });

        // On click we change the global anchor id as the OnGlobalLayout is for all the edittext in the current screen
        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditTextPushContent.anchorId = anchorIdEditText;
                mainView.getViewTreeObserver().dispatchOnGlobalLayout();
            }
        });

    }
}
