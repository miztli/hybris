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
import android.os.Bundle;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.AccountFragment.OnAccountEditedListener;
import com.hybris.mobile.app.commerce.fragment.AddressDialogFragment;
import com.hybris.mobile.app.commerce.fragment.AddressListFragment;
import com.hybris.mobile.app.commerce.fragment.AddressListFragment.OnAddressSelectedListener;
import com.hybris.mobile.app.commerce.fragment.PaymentDialogFragment;
import com.hybris.mobile.app.commerce.fragment.PaymentDialogFragment.CreatePaymentListener;
import com.hybris.mobile.app.commerce.fragment.PaymentListFragment.OnPaymentSelectedListener;
import com.hybris.mobile.app.commerce.fragment.PaymentListFragment;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.user.Address;


/**
 * Account
 */
public class AccountActivity extends AccountActivityBase implements OnAddressSelectedListener, OnAccountEditedListener, CreatePaymentListener, OnPaymentSelectedListener {
    FragmentTransaction mFragmentTransaction;
    AddressListFragment addressListFragment;
    PaymentListFragment paymentListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addressListFragment = AddressListFragment.newInstance();
        paymentListFragment = PaymentListFragment.newInstance();

    }

    @Override
    public void onAddressSelected(Address address) {

        AddressDialogFragment fragment = AddressDialogFragment.newInstance(false, null);

        if (address != null) {

            fragment.setAddress(address);
        }else{
            fragment.setAddress(null);
        }

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.account_layout, fragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();

    }


    @Override
    public void onAddressListRefreshed() {
        addressListFragment.onResume();
    }

    @Override
    public void onAddressListEditButtonClicked() {

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.account_layout, addressListFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public void onPaymentListEditButtonClicked() {

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.account_layout, paymentListFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public void onPaymentCreated(PaymentDetails paymentDetails) {
        paymentListFragment.onResume();

    }

    @Override
    public void showCreatePayment() {

        Fragment fragment = PaymentDialogFragment.newInstance();

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.account_layout, fragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public void onPaymentSelected(PaymentDetails paymentDetails) {

        PaymentDialogFragment fragment = PaymentDialogFragment.newInstance();

        fragment.setPaymentDetails(paymentDetails);

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.account_layout, fragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public void onPaymentListRefreshed() {
        paymentListFragment.onResume();
    }

}
