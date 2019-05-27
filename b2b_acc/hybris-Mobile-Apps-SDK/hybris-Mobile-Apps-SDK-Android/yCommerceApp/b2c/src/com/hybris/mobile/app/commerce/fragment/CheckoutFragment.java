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
package com.hybris.mobile.app.commerce.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.LoginActivity;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetailsList;
import com.hybris.mobile.lib.commerce.data.user.AddressList;
import com.hybris.mobile.lib.commerce.query.QueryPayment;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.response.Response;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Container that handle_anchor the details information for a specific product
 */
public class CheckoutFragment extends CheckoutFragmentBase {

    private PaymentDialogFragment.CreatePaymentListener mListener;
    private View mAddPayment;
    private Spinner mPaymentSpinner;
    private ArrayAdapter<String> mPaymentAdapter;
    private List<PaymentDetails> mPaymentsDetails;
    /**
     * Class to handle_anchor User interaction with account payment spinner
     */
    private OnItemSelectedListener mPaymentSpinnerListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            QueryPayment queryPayment = new QueryPayment();
            queryPayment.setPaymentDetailsId(mPaymentsDetails.get(mPaymentSpinner.getSelectedItemPosition()).getId());

            // Updating the payment type
            CommerceApplication.getContentServiceHelper().updateCartPayment(new ResponseReceiverEmpty() {

                                                                                @Override
                                                                                public void onResponse(Response<EmptyResponse> response) {
                                                                                }

                                                                                @Override
                                                                                public void onError(Response<ErrorList> response) {
                                                                                    UIUtils.showError(response, getActivity());
                                                                                }
                                                                            }, mCheckoutRequestId,
                    queryPayment, null, false, null, mOnRequestListener
            );
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Make sure that the activity implements the callback interface
        try {
            mListener = (PaymentDialogFragment.CreatePaymentListener) activity;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Activity must implement CreatePaymentListener.");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPaymentsDetails = new ArrayList<>();
        mAddPayment = view.findViewById(R.id.checkout_add_payment);
        mPaymentSpinner = (Spinner) view.findViewById(R.id.checkout_account_payment_spinner);
        mPaymentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());
        mPaymentSpinner.setAdapter(mPaymentAdapter);
        mPaymentSpinner.setOnItemSelectedListener(mPaymentSpinnerListener);

        mAddPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreatePaymentView();
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    /**
     * Display the create payment view
     */
    private void showCreatePaymentView() {
        mListener.showCreatePayment();
    }

    @Override
    public void onResume() {
        checkIfUserLoggedIn();
        super.onResume();
    }

    @Override
    public void beginCheckOutFlow() {
        // Get the user payments
        CommerceApplication.getContentServiceHelper().getUserPaymentDetailsList(new ResponseReceiver<PaymentDetailsList>() {
                                                                                    @Override
                                                                                    public void onResponse(Response<PaymentDetailsList> response) {

                                                                                        if (response.getData() != null && response.getData().getPayments() != null && !response.getData().getPayments().isEmpty()) {
                                                                                            mPaymentsDetails = response.getData().getPayments();

                                                                                            mPaymentAdapter.clear();

                                                                                            List<String> payments = new ArrayList<String>();

                                                                                            for (PaymentDetails paymentDetails : mPaymentsDetails) {
                                                                                                payments.add(paymentDetails.getAccountHolderName() +" - "+
                                                                                                        paymentDetails.getCardType().getName() +" "+
                                                                                                        paymentDetails.getCardNumber() +" - "+
                                                                                                        paymentDetails.getExpiryYear()+"/"+ paymentDetails.getExpiryMonth());
                                                                                            }

                                                                                            mPaymentAdapter.addAll(payments);
                                                                                            mPaymentAdapter.notifyDataSetChanged();

                                                                                        } else {
                                                                                            // Only display the add payment option
                                                                                            mPaymentSpinner.setVisibility(View.GONE);
                                                                                        }

                                                                                    }

                                                                                    @Override
                                                                                    public void onError(Response<ErrorList> response) {
                                                                                        UIUtils.showError(response, getActivity());
                                                                                    }
                                                                                }, mCheckoutRequestId,
                null, null, false, null, mOnRequestListener);

        // Get The user addresses
        CommerceApplication.getContentServiceHelper().getUserAddresses(new ResponseReceiver<AddressList>() {
                                                                           @Override
                                                                           public void onResponse(Response<AddressList> response) {
                                                                               mAddresses = response.getData().getAddresses();
                                                                               populateDeliveryAddresses(false);
                                                                           }

                                                                           @Override
                                                                           public void onError(Response<ErrorList> response) {

                                                                           }
                                                                       }, mCheckoutRequestId,
                null, false, null, mOnRequestListener);

    }

    @Override
    protected boolean validateSelections() {
        boolean valid = true;

        if (mPaymentSpinner.getSelectedItem() == null || StringUtils.isBlank(mPaymentSpinner.getSelectedItem().toString())) {
            mPaymentSpinner.setEnabled(false);
            valid = false;
        } else {
            mPaymentSpinner.setEnabled(true);
        }

        return valid;
    }

    private void checkIfUserLoggedIn() {
        if (!SessionHelper.isUserLoggedIn()) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }
    }

    /**
     * Update and select the payment
     *
     * @param paymentDetails
     */
    public void updateAndSelectPayment(PaymentDetails paymentDetails) {
        mPaymentSpinner.setVisibility(View.VISIBLE);
        mPaymentsDetails.add(paymentDetails);
        mPaymentAdapter.add(paymentDetails.getCardNumber());
        mPaymentAdapter.notifyDataSetChanged();
        mPaymentSpinner.setSelection(mPaymentAdapter.getCount() - 1);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
