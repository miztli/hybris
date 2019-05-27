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
import android.os.Bundle;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.CartFragment.OnCartLoadedListener;
import com.hybris.mobile.app.commerce.fragment.CheckoutFragment;
import com.hybris.mobile.app.commerce.fragment.CheckoutFragmentBase;
import com.hybris.mobile.lib.commerce.data.order.Cart;


/**
 * Checkout
 */
public class CheckoutActivityBase extends MainActivity implements OnCartLoadedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_checkout);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCartLoaded() {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.checkout_fragment);

        if (fragment != null && fragment instanceof CheckoutFragmentBase) {
            ((CheckoutFragmentBase) fragment).beginCheckOutFlow();
        }
    }

    @Override
    public void onCartSummaryLoaded(Cart cart) {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.checkout_fragment);

        if (fragment != null && fragment instanceof CheckoutFragment) {
            ((CheckoutFragment) fragment).populateCartSummary(cart);
        }
    }

}
