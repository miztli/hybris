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
package com.hybris.mobile.app.commerce.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.LoginFragment;
import com.hybris.mobile.app.commerce.fragment.SignUpFragment;


/**
 * Content Login validation
 */
public class LoginActivity extends MainActivity {

    private Fragment mLoginFragment;
    private Fragment mSignUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);

        mLoginFragment = LoginFragment.newInstance();
        mSignUpFragment = SignUpFragment.newInstance();

        ViewPager loginPager = (ViewPager) findViewById(R.id.login_pager);
        loginPager.setAdapter(new PagerAdapter(getFragmentManager()));

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.login_pager_tabs);
        tabsStrip.setViewPager(loginPager);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mLoginFragment;
                case 1:
                    return mSignUpFragment;
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return getString(R.string.account_login_tab_title);
                case 1:
                    return getString(R.string.account_sign_up_tab_title);
                default:
                    return "";
            }

        }

    }

}
