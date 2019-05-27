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

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.OrderConfirmationActivity;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.app.commerce.view.CartViewUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.order.DeliveryMode;
import com.hybris.mobile.lib.commerce.data.order.DeliveryModeList;
import com.hybris.mobile.lib.commerce.data.order.Order;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.query.QueryAddress;
import com.hybris.mobile.lib.commerce.query.QueryDeliveryMode;
import com.hybris.mobile.lib.commerce.query.QueryPlaceOrder;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.ToolTip;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Container that handle_anchor the details information for a specific product
 */
public abstract class CheckoutFragmentBase extends Fragment {

    private static final String SAVED_INSTANCE_DELIVERY_METHOD = "SAVED_INSTANCE_DELIVERY_METHOD";
    private static final String SAVED_INSTANCE_DELIVERY_ADDRESS = "SAVED_INSTANCE_DELIVERY_ADDRESS";
    /**
     * Tooltip message to inform user to set credit card on the storefront
     */
    public OnClickListener mTooltipListener = new OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.link_storefront)));
            getActivity().startActivity(intent);
        }
    };
    /**
     * Action when link in terms and conditions is clicked
     */
    public OnClickListener mTermsConditionsTextListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "Terms and Conditions", Toast.LENGTH_SHORT).show();
        }
    };
    protected String mCheckoutRequestId = RequestUtils.generateUniqueRequestId();
    protected Spinner mDeliveryAddressSpinner;
    protected Spinner mDeliveryMethodSpinner;
    protected Button mPlaceOrderButton;
    protected LinearLayout mTermsConditionsLayout;
    protected TextView mTermsConditionsText;
    protected CheckBox mTermsConditionsCheckbox;
    protected ToolTip mToolTip;
    protected ArrayAdapter<String> mDeliveryAddressAdapter;
    protected ArrayAdapter<String> mDeliveryMethodAdapter;
    protected LinearLayout mPlacingOrderErrorMsgLayout;
    protected LinearLayout mTermsConditionsErroMsgLayout;
    protected List<Address> mAddresses;
    protected List<DeliveryMode> mDeliveryModes;
    protected int indexSelectedDeliveryAddress = 0;
    protected int indexSelectedDeliveryMethod = 0;
    /**
     * Show ProgressBar when Request is send and Hide ProgressBar when Response is received
     */
    protected OnRequestListener mOnRequestListener = new OnRequestListener() {

        @Override
        public void beforeRequest() {
            UIUtils.showLoadingActionBar(getActivity(), true);
        }

        @Override
        public void afterRequestBeforeResponse() {

        }

        @Override
        public void afterRequest(boolean isDataSynced) {
            UIUtils.showLoadingActionBar(getActivity(), false);
        }
    };

    /**
     * Class to handle_anchor User interaction with delivery address spinner by sending request to update cart
     */
    public OnItemSelectedListener deliveryAddressSpinnerListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            QueryAddress queryAddress = new QueryAddress();
            queryAddress.setAddressId(mAddresses.get(position).getId());

            // Updating the delivery address for the cart
            CommerceApplication.getContentServiceHelper().updateCartDeliveryAddress(new ResponseReceiverEmpty() {

                @Override
                public void onResponse(Response<EmptyResponse> response) {
                    CommerceApplication.getContentServiceHelper().getCartDeliveryModes(new ResponseReceiver<DeliveryModeList>() {

                        @Override
                        public void onResponse(Response<DeliveryModeList> response) {
                            mDeliveryModes = response.getData().getDeliveryModes();
                            populateDeliveryModes();
                        }

                        @Override
                        public void onError(Response<ErrorList> response) {
                            UIUtils.showError(response, getActivity());
                        }
                    }, mCheckoutRequestId, null, false, null, mOnRequestListener);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mCheckoutRequestId, queryAddress, null, false, null, mOnRequestListener);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    /**
     * Class to handle_anchor User interaction with delivery method spinner by sending request to update cart
     */
    public OnItemSelectedListener deliveryMethodSpinnerListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            QueryDeliveryMode queryDeliveryMode = new QueryDeliveryMode();
            queryDeliveryMode.setDeliveryModeId(mDeliveryModes.get(position).getCode());

            // Updating the delivery mode for the cart
            CommerceApplication.getContentServiceHelper().updateCartDeliveryMode(new ResponseReceiverEmpty() {

                @Override
                public void onResponse(Response<EmptyResponse> response) {
                    SessionHelper.updateCart(getActivity(), mCheckoutRequestId, true);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mCheckoutRequestId, queryDeliveryMode, null, false, null, mOnRequestListener);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    /**
     * Define action when place order button is clicked to send REST call to create an order with current cart
     */
    public OnClickListener mPlaceOrderButtonListener = new OnClickListener() {

        @Override
        public void onClick(View v) {

            if (validateEntries()) {
                mPlacingOrderErrorMsgLayout.setVisibility(View.GONE);

                QueryPlaceOrder queryPlaceOrder = new QueryPlaceOrder();
                queryPlaceOrder.setTermsChecked(true);

                CommerceApplication.getContentServiceHelper().placeOrder(new ResponseReceiver<Order>() {
                    @Override
                    public void onResponse(Response<Order> response) {
                        Intent intent = new Intent(getActivity(), OrderConfirmationActivity.class);
                        intent.putExtra(IntentConstants.ORDER_CODE, response.getData().getCode());
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        UIUtils.showError(response, getActivity());
                    }
                }, mCheckoutRequestId, queryPlaceOrder, null, false, Collections.singletonList((View) mPlaceOrderButton), mOnRequestListener);

            } else {
                mPlacingOrderErrorMsgLayout.setVisibility(View.VISIBLE);
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_checkout_base, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPlaceOrderButton = (Button) view.findViewById(R.id.checkout_place_order_button);

        mTermsConditionsLayout = (LinearLayout) view.findViewById(R.id.checkout_terms_conditions_layout);
        mTermsConditionsText = (TextView) view.findViewById(R.id.checkout_terms_conditions_text);
        mTermsConditionsCheckbox = (CheckBox) view.findViewById(R.id.checkout_terms_conditions_checkbox);

        mToolTip = new ToolTip(getActivity(), getString(R.string.checkout_payment_number_button_description,
                getString(R.string.name_storefront)));

        mPlacingOrderErrorMsgLayout = (LinearLayout) view.findViewById(R.id.checkout_placing_order_error_msg_layout);
        mTermsConditionsErroMsgLayout = (LinearLayout) view.findViewById(R.id.checkout_terms_conditions_error_msg_layout);

        mDeliveryAddressAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        mDeliveryMethodAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        mDeliveryAddressSpinner = (Spinner) view.findViewById(R.id.checkout_delivery_address_spinner);
        mDeliveryMethodSpinner = (Spinner) view.findViewById(R.id.checkout_delivery_method_spinner);

        // Listeners
        mTermsConditionsText.setOnClickListener(mTermsConditionsTextListener);
        mToolTip.setOnClickListener(mTooltipListener);
        mPlaceOrderButton.setOnClickListener(mPlaceOrderButtonListener);

        initDeliveryAddressSpinner();
        initDeliveryMethodSpinner();

        // Disable all spinners except the payment type and cost center
        mDeliveryAddressSpinner.setClickable(false);
        mDeliveryMethodSpinner.setClickable(false);

        // Restore the current spinner selection
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(SAVED_INSTANCE_DELIVERY_METHOD)) {
                indexSelectedDeliveryMethod = savedInstanceState.getInt(SAVED_INSTANCE_DELIVERY_METHOD, 0);
            }
            if (savedInstanceState.containsKey(SAVED_INSTANCE_DELIVERY_ADDRESS)) {
                indexSelectedDeliveryAddress = savedInstanceState.getInt(SAVED_INSTANCE_DELIVERY_ADDRESS, 0);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVED_INSTANCE_DELIVERY_METHOD, mDeliveryMethodSpinner.getSelectedItemPosition());
        outState.putInt(SAVED_INSTANCE_DELIVERY_ADDRESS, mDeliveryAddressSpinner.getSelectedItemPosition());
        super.onSaveInstanceState(outState);
    }

    /**
     * Init the delivery address spinner
     */
    protected void initDeliveryAddressSpinner() {

        mDeliveryAddressSpinner.setAdapter(mDeliveryAddressAdapter);
        mDeliveryAddressSpinner.setOnItemSelectedListener(deliveryAddressSpinnerListener);
    }

    /**
     * Init the delivery method spinner
     */
    protected void initDeliveryMethodSpinner() {

        mDeliveryMethodSpinner.setAdapter(mDeliveryMethodAdapter);
        mDeliveryMethodSpinner.setOnItemSelectedListener(deliveryMethodSpinnerListener);
    }

    /**
     * Populate the delivery addresses
     *
     * @param initSpinnerAddresses
     */
    protected void populateDeliveryAddresses(boolean initSpinnerAddresses) {
        if (mAddresses != null && !mAddresses.isEmpty()) {
            // We re-init the spinner, because we always want to trigger the selection change even the index didnt change (But the cost center changed)
            if (initSpinnerAddresses) {
                initDeliveryAddressSpinner();
            }

            mDeliveryAddressSpinner.setClickable(true);

            // Create delivery address list
            List<String> deliveryAddressList = new ArrayList<>();
            for (Address address : mAddresses) {
                deliveryAddressList.add(address.getFormattedAddress());
            }

            mDeliveryAddressAdapter.clear();
            mDeliveryAddressAdapter.addAll(deliveryAddressList);
            mDeliveryAddressAdapter.notifyDataSetChanged();

            mDeliveryAddressSpinner.setSelection(indexSelectedDeliveryAddress);
        }
    }

    /**
     * Populate the delivery modes
     */
    protected void populateDeliveryModes() {
        if (mDeliveryModes != null && !mDeliveryModes.isEmpty()) {
            // We re-init the spinner, because we always want to trigger the selection change even the index didnt change (But the delivery address changed)
            initDeliveryMethodSpinner();

            mDeliveryMethodSpinner.setClickable(true);

            // Create delivery address list
            ArrayList<String> deliveryModeList = new ArrayList<>();
            for (DeliveryMode deliveryMode : mDeliveryModes) {
                if (StringUtils.isNotBlank(deliveryMode.getName()) && StringUtils.isNotBlank(deliveryMode.getDescription())
                        && deliveryMode.getDeliveryCost() != null
                        && StringUtils.isNotBlank(deliveryMode.getDeliveryCost().getFormattedValue())) {
                    deliveryModeList.add(deliveryMode.getName() + " - " + deliveryMode.getDescription() + " - "
                            + deliveryMode.getDeliveryCost().getFormattedValue());
                }
            }

            mDeliveryMethodAdapter.clear();
            mDeliveryMethodAdapter.addAll(deliveryModeList);
            mDeliveryMethodAdapter.notifyDataSetChanged();

            mDeliveryMethodSpinner.setSelection(indexSelectedDeliveryMethod);
        }
    }

    /**
     * Validate data in the checkout form
     *
     * @return
     */
    protected boolean validateEntries() {
        boolean valid = validateSelections();

        if (mDeliveryAddressSpinner.getSelectedItem() == null
                || StringUtils.isBlank(mDeliveryAddressSpinner.getSelectedItem().toString())) {
            mDeliveryAddressSpinner.setEnabled(false);
            valid = false;
        } else {
            mDeliveryAddressSpinner.setEnabled(true);
        }

        if (mDeliveryMethodSpinner.getSelectedItem() == null
                || StringUtils.isBlank(mDeliveryMethodSpinner.getSelectedItem().toString())) {
            mDeliveryMethodSpinner.setEnabled(false);
            valid = false;
        } else {
            mDeliveryMethodSpinner.setEnabled(true);
        }

        if (mTermsConditionsCheckbox.isChecked()) {
            mTermsConditionsErroMsgLayout.setVisibility(View.GONE);
            mTermsConditionsLayout.setEnabled(true);
        } else {
            mTermsConditionsErroMsgLayout.setVisibility(View.VISIBLE);

            mTermsConditionsLayout.setEnabled(false);
            valid = false;
        }

        return valid;
    }

    /**
     * Populate the order summary
     *
     * @param cart
     */
    public void populateCartSummary(Cart cart) {


        if (getView() != null) {
            //create views and populate them
            CartViewUtils.createCartSummary(getView(), cart, true);
        }
        if (cart.getEntries() != null && !cart.getEntries().isEmpty()) {
            mPlaceOrderButton.setEnabled(true);
        } else {
            mPlaceOrderButton.setEnabled(false);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mCheckoutRequestId);
    }

    public abstract void beginCheckOutFlow();

    protected abstract boolean validateSelections();
}
