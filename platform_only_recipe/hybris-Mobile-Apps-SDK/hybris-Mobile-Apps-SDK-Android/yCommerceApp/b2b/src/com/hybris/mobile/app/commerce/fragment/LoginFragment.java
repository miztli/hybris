package com.hybris.mobile.app.commerce.fragment;


import android.content.Intent;

import com.hybris.mobile.app.commerce.activity.DashboardActivity;

public class LoginFragment extends LoginFragmentBase {

    @Override
    protected void beforeLogin(final BeforeLoginCallback beforeLoginCallback) {
        beforeLoginCallback.success();
    }

    @Override
    protected void afterLogin() {
        // Starting the dashboard activity
        startActivity(new Intent(getActivity(), DashboardActivity.class));
    }
}
