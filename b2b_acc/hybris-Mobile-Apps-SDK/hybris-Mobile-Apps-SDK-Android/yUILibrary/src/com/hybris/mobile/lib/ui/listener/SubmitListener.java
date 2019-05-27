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
package com.hybris.mobile.lib.ui.listener;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


/* Set a special listener to be called when an action is performed
 * on the text view.  This will be called when the enter key is pressed,
 * or when an action triggered by the user.
 */
public abstract class SubmitListener implements OnEditorActionListener {

    /**
     * Allows user performed on specific action
     */
    public abstract void onSubmitAction();

    private int mId;
    private boolean mWithId = false;


    public SubmitListener(int id) {
        this.mId = id;
        this.mWithId = true;
    }

    public SubmitListener() {
        this.mWithId = false;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (this.mWithId) {
            if (actionId == this.mId || actionId == EditorInfo.IME_NULL) {
                onSubmitAction();
                return true;
            }
        } else {
            if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                onSubmitAction();
                return true;
            }

        }
        return false;
    }


}
