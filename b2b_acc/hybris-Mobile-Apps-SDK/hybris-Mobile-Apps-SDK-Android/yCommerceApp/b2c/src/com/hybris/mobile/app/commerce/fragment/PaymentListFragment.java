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
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.AccountPaymentAdapter;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetailsList;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import java.util.ArrayList;
import java.util.List;

public class PaymentListFragment extends ListFragment {
    private static final String TAG = PaymentListFragment.class.getCanonicalName();
    private String mPaymentListRequestId = RequestUtils.generateUniqueRequestId();
    private Button newPaymentListFragment;
    private OnPaymentSelectedListener mActivity;

    // Container Activity must implement this interface
    public interface OnPaymentSelectedListener {
        void onPaymentSelected(PaymentDetails paymentDetails);

        void onPaymentListRefreshed();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mActivity = (OnPaymentSelectedListener) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

    }


    public static PaymentListFragment newInstance() {
        PaymentListFragment paymentListFragment = new PaymentListFragment();
        return paymentListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_list, container, false);
        newPaymentListFragment = (Button) view.findViewById(R.id.payment_list_new_button);

        newPaymentListFragment.setOnClickListener(newPaymentButtonListener);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        CommerceApplication.getContentServiceHelper().getUserPaymentDetailsList(new ResponseReceiver<PaymentDetailsList>() {
            @Override
            public void onResponse(Response<PaymentDetailsList> response) {

                AccountPaymentAdapter paymentAdapter = new AccountPaymentAdapter(getActivity(), new ArrayList<PaymentDetails>(), mPaymentListRequestId, mActivity);
                List<PaymentDetails> paymentDetailsList = new ArrayList<>();
                setListAdapter(paymentAdapter);

                if (response.getData().getPayments() != null) {
                    paymentDetailsList = response.getData().getPayments();
                }

                paymentAdapter.clear();
                paymentAdapter.addAll(paymentDetailsList);
                paymentAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError(Response<ErrorList> response) {
                Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, mPaymentListRequestId, null, null, false, null, null);
    }

    /**
     * Define Action when cross button is clicked and quit the current product detail activity
     */
    protected View.OnClickListener newPaymentButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ((PaymentDialogFragment.CreatePaymentListener) getActivity()).showCreatePayment();
        }
    };


    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;

    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mPaymentListRequestId);
    }

}
