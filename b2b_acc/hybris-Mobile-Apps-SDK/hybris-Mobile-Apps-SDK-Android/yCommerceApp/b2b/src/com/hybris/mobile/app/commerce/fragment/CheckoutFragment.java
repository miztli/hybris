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

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.b2b.data.costcenter.CostCenter;
import com.hybris.mobile.lib.b2b.data.costcenter.CostCenters;
import com.hybris.mobile.lib.b2b.query.QueryCostCenter;
import com.hybris.mobile.lib.b2b.query.QueryPaymentType;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.response.Response;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Container that handle_anchor the details information for a specific product
 */
public class CheckoutFragment extends CheckoutFragmentBase {
    private static final String SAVED_INSTANCE_COST_CENTER = "SAVED_INSTANCE_COST_CENTER";

    private EditText mPaymentNumberEditText;
    private Spinner mCostCenterSpinner;
    private ArrayAdapter<String> mPaymentTypeAdapter;
    private ArrayAdapter<String> mCostCenterAdapter;
    private List<CostCenter> mCostCenters;
    private int indexSelectedCostCenter = 0;
    /**
     * Class to handle_anchor User interaction with account payment spinner
     */
    private OnItemSelectedListener mPaymentTypeSpinnerListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // Setting the color to grey because this is the only choice
            ((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);

            QueryPaymentType queryPaymentType = new QueryPaymentType();
            queryPaymentType.setPaymentType(getResources().getString(R.string.payment_type_account_name));

            // Updating the payment type
            CommerceApplication.getContentServiceHelper().updateCartPaymentType(new ResponseReceiver<Cart>() {

                                                                                    @Override
                                                                                    public void onResponse(Response<Cart> response) {
                                                                                        // Getting the cost centers and updating the cost centers list
                                                                                        CommerceApplication.getContentServiceHelper()
                                                                                                .getCostCenters(
                                                                                                        new ResponseReceiver<CostCenters>() {

                                                                                                            @Override
                                                                                                            public void onResponse(
                                                                                                                    Response<CostCenters> response) {
                                                                                                                mCostCenters = response.getData().getCostCenters();
                                                                                                                populateCostCenter();
                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onError(
                                                                                                                    Response<ErrorList> response) {
                                                                                                                UIUtils.showError(response,
                                                                                                                        getActivity());
                                                                                                            }
                                                                                                        }, mCheckoutRequestId, false, null,
                                                                                                        mOnRequestListener);
                                                                                    }

                                                                                    @Override
                                                                                    public void onError(Response<ErrorList> response) {
                                                                                        UIUtils.showError(response, getActivity());
                                                                                    }
                                                                                }, mCheckoutRequestId,
                    queryPaymentType, null, false, null, mOnRequestListener
            );
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    /**
     * Class to handle_anchor User interaction with cost center spinner
     */
    private OnItemSelectedListener mCostCenterSpinnerListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            QueryCostCenter queryCostCenter = new QueryCostCenter();
            queryCostCenter.setCostCenterId(mCostCenters.get(position).getCode());

            // Updating the cost center for the cart
            CommerceApplication.getContentServiceHelper().updateCartCostCenter(new ResponseReceiver<Cart>() {

                @Override
                public void onResponse(Response<Cart> response) {
                    mAddresses = mCostCenters.get(mCostCenterSpinner.getSelectedItemPosition()).getUnit().getAddresses();
                    populateDeliveryAddresses(true);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mCheckoutRequestId, queryCostCenter, null, false, null, mOnRequestListener);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }

    };

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Tooltip
        getView().findViewById(R.id.tooltip_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mToolTip.show(v, true);
                UIUtils.hideKeyboard(getActivity());
            }
        });

        mPaymentNumberEditText = (EditText) getView().findViewById(R.id.checkout_payment_number_edittext);

        Spinner mPaymentTypeSpinner = (Spinner) getView().findViewById(R.id.checkout_account_payment_spinner);
        mPaymentTypeAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());
        mPaymentTypeSpinner.setAdapter(mPaymentTypeAdapter);
        mPaymentTypeSpinner.setOnItemSelectedListener(mPaymentTypeSpinnerListener);

        mCostCenterAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());
        initCostCenterSpinner();

        // When clicking on the view, hide keyboard and remove focus
        getView().setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                UIUtils.hideKeyboard(getActivity());
                mPaymentNumberEditText.clearFocus();
                v.performClick();
                return false;
            }
        });

        // Restore the current spinner selection
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(SAVED_INSTANCE_COST_CENTER)) {
                indexSelectedCostCenter = savedInstanceState.getInt(SAVED_INSTANCE_COST_CENTER, 0);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVED_INSTANCE_COST_CENTER, mCostCenterSpinner.getSelectedItemPosition());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void beginCheckOutFlow() {
        // We populate first the payment type
        mPaymentTypeAdapter.clear();
        mPaymentTypeAdapter.addAll(Collections.singletonList(getResources().getString(R.string.payment_type_account_name)));
        mPaymentTypeAdapter.notifyDataSetChanged();
    }

    @Override
    protected boolean validateSelections() {
        boolean valid = true;

        if (mCostCenterSpinner.getSelectedItem() == null || StringUtils.isBlank(mCostCenterSpinner.getSelectedItem().toString())) {
            mCostCenterSpinner.setEnabled(false);
            valid = false;
        } else {
            mCostCenterSpinner.setEnabled(true);
        }

        return valid;
    }

    private void initCostCenterSpinner() {
        mCostCenterSpinner = (Spinner) getView().findViewById(R.id.checkout_cost_center_spinner);
        mCostCenterSpinner.setAdapter(mCostCenterAdapter);
        mCostCenterSpinner.setOnItemSelectedListener(mCostCenterSpinnerListener);
    }

    /**
     * Populate the cost centers
     */
    private void populateCostCenter() {
        if (mCostCenters != null && !mCostCenters.isEmpty()) {

            // We re-init the spinner, because we always want to trigger the selection change even the index didnt change
            initCostCenterSpinner();

            // Create cost Center List Name
            List<String> costCenterList = new ArrayList<>();
            for (CostCenter costCenter : mCostCenters) {
                costCenterList.add(costCenter.getName());
            }

            mCostCenterAdapter.clear();
            mCostCenterAdapter.addAll(costCenterList);
            mCostCenterAdapter.notifyDataSetChanged();

            mCostCenterSpinner.setSelection(indexSelectedCostCenter);
        }
    }

}
