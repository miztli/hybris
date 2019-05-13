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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.Constants;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.OrderHistoryActivity;
import com.hybris.mobile.app.commerce.adapter.OrderProductListAdapter;
import com.hybris.mobile.app.commerce.helper.OrderHelper;
import com.hybris.mobile.app.commerce.utils.RegexUtils;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Order;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import com.hybris.mobile.lib.commerce.query.QueryOrder;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Container that handle the details information for a specific product
 */
public class OrderDetailFragment extends Fragment implements ResponseReceiver<Order> {
    private static final String TAG = OrderDetailFragment.class.getCanonicalName();

    private String mOrderRequestId = RequestUtils.generateUniqueRequestId();

    private TextView mOrderDetailNumber;
    private TextView mOrderDetailDatePlaced;
    private TextView mOrderDetailSatus;
    private OrderProductListAdapter mOrderProductListAdapter;
    private boolean mComingFromSearch = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mOrderDetailNumber = (TextView) getView().findViewById(R.id.order_detail_number_text);
        mOrderDetailDatePlaced = (TextView) getView().findViewById(R.id.order_detail_date_placed_text);
        mOrderDetailSatus = (TextView) getView().findViewById(R.id.order_detail_status_text);
        Button mCloseOrdertDetailButton = (Button) getView().findViewById(R.id.order_detail_exit);

        mCloseOrdertDetailButton.setOnClickListener(exitOrderDetailButtonListener);
        // Product list
        ListView productList = (ListView) getActivity().findViewById(R.id.order_products_list);
        mOrderProductListAdapter = new OrderProductListAdapter(getActivity(), new ArrayList<OrderEntry>());
        productList.setAdapter(mOrderProductListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        mComingFromSearch = getActivity().getIntent().getExtras() != null && getActivity().getIntent().getExtras().getBoolean(
                IntentConstants.ORDER_FROM_SEARCH);

        QueryOrder queryOrder = new QueryOrder();

        Intent intent = getActivity().getIntent();
        if (intent.hasExtra(IntentConstants.ORDER_CODE)) {
            queryOrder.setCode(getActivity().getIntent().getStringExtra(IntentConstants.ORDER_CODE));
        } else if (StringUtils.equals(intent.getAction(), Intent.ACTION_VIEW)) {
            queryOrder.setCode(RegexUtils.getOrderCode(intent.getDataString()));
        }

        // Getting the order
        CommerceApplication.getContentServiceHelper().getOrder(this, mOrderRequestId, queryOrder, null, false, null,
                new OnRequestListener() {

                    @Override
                    public void beforeRequest() { //hide when loading

                        UIUtils.showLoadingActionBar(getActivity(), true);
                        getView().setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void afterRequestBeforeResponse() {

                    }

                    @Override
                    public void afterRequest(boolean isDataSynced) {
                        getView().setVisibility(View.VISIBLE);
                        UIUtils.showLoadingActionBar(getActivity(), false);
                    }
                });
    }

    @Override
    public void onResponse(Response<Order> response) {
        getView().findViewById(R.id.order_detail_fragment).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.order_detail_not_found).setVisibility(View.GONE);
        populateOrder(response.getData());
    }

    private void populateOrder(Order order) {
        if (order != null) {


            mOrderDetailNumber.setText(getString(R.string.order_detail_number, order.getCode()));

            if (order.getCreated() != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_COMPLETE,
                        SimpleDateFormat.getAvailableLocales()[0]);

                mOrderDetailDatePlaced.setText(simpleDateFormat.format(order.getCreated()));
            }

            mOrderDetailSatus.setText(getString(R.string.order_detail_status, order.getStatusDisplay()));

            // fill Delivery info
            OrderHelper.createDeliverySummary(getActivity(), order);

            // fill order summary
            OrderHelper.createOrderSummary(getActivity(), order);

            mOrderProductListAdapter.clear();
            mOrderProductListAdapter.addAll(order.getDeliveryOrderGroups().get(0).getEntries());

            // Updating the list
            mOrderProductListAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Define Action when cross button is clicked and quit the current product detail activity
     */
    public OnClickListener exitOrderDetailButtonListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (mComingFromSearch) {
                startActivity(new Intent(getActivity(), OrderHistoryActivity.class));
            } else {
                getActivity().onBackPressed();
            }
        }
    };


    @Override
    public void onError(Response<ErrorList> response) {
        if (mComingFromSearch) {
            getView().findViewById(R.id.order_detail_fragment).setVisibility(View.GONE);
            getView().findViewById(R.id.order_detail_not_found).setVisibility(View.VISIBLE);
        } else {
            Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mOrderRequestId);
    }
}
