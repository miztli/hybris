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

package com.hybris.mobile.app.commerce.preference;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.UrlSettingsActivity;


public class BackendUrlValuePreference extends Preference {

    public BackendUrlValuePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public BackendUrlValuePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackendUrlValuePreference(Context context) {
        super(context);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.fragment_backend_url_value, parent, false);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        TextView mTextViewServerUrl = (TextView) view.findViewById(R.id.app_options_server_url);
        mTextViewServerUrl.setText(CommerceApplication.getStringFromSharedPreferences(getContext().getString(R.string.preference_key_value_base_url, ""), ""));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), UrlSettingsActivity.class));
            }
        });

    }
}
