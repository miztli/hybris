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
package com.hybris.mobile.app.commerce.activity;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.CheckoutFragment;
import com.hybris.mobile.app.commerce.fragment.PaymentDialogFragment;
import com.hybris.mobile.app.commerce.fragment.PaymentListFragment;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;


/**
 * Checkout
 */
public class CheckoutActivity extends CheckoutActivityBase implements PaymentDialogFragment.CreatePaymentListener, PaymentListFragment.OnPaymentSelectedListener {

    @Override
    public void onPaymentCreated(PaymentDetails paymentDetails) {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.checkout_fragment);

        if (fragment != null && fragment instanceof CheckoutFragment) {
            ((CheckoutFragment) fragment).updateAndSelectPayment(paymentDetails);
        }
    }

    @Override
    public void showCreatePayment() {


        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();

        Fragment createPaymentFragment  = PaymentDialogFragment.newInstance();

        mFragmentTransaction.replace(R.id.checkout_layout, createPaymentFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public void onPaymentSelected(PaymentDetails paymentDetails) {

    }

    @Override
    public void onPaymentListRefreshed() {

    }
}
