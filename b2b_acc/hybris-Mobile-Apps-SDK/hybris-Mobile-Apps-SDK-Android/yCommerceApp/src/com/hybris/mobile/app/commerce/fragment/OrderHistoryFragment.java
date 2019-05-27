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
package com.hybris.mobile.app.commerce.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.OrderHistoryAdapter;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.OrderHistory;
import com.hybris.mobile.lib.commerce.data.order.OrderHistoryList;
import com.hybris.mobile.lib.commerce.query.QueryOrders;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.listener.InfiniteScrollListener;
import com.hybris.mobile.lib.ui.view.Alert;

import java.util.ArrayList;
import java.util.List;


/**
 * Container that handle the details information for a specific order
 */
public class OrderHistoryFragment extends Fragment implements ResponseReceiver<OrderHistoryList> {
    private static final String TAG = OrderHistoryFragment.class.getCanonicalName();

    private String mOrderHistoryRequestId = RequestUtils.generateUniqueRequestId();
    private OrderHistoryAdapter mOrderHistoryAdapter;
    private ListView mOrderHistoryListView;
    private View mFooterLoadingListView;
    private LinearLayout mOrderHistoryHeader;

    private int mCurrentPage;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_history, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        // Order History list
        mOrderHistoryListView = (ListView) getActivity().findViewById(R.id.order_history_list);
        mOrderHistoryHeader = (LinearLayout) getActivity().findViewById(R.id.order_history_header);

        mFooterLoadingListView = getActivity().getLayoutInflater().inflate(R.layout.loading_spinner, mOrderHistoryListView,
                false);
        mOrderHistoryListView.addFooterView(mFooterLoadingListView, null, false);

        mOrderHistoryAdapter = new OrderHistoryAdapter(getActivity(), new ArrayList<OrderHistory>());
        mOrderHistoryListView.setAdapter(mOrderHistoryAdapter);


        // Infinite scroll listener for the list view
        InfiniteScrollListener mInfiniteScrollListener = new InfiniteScrollListener() {

            @Override
            public void loadNextItems(int page) {
                mCurrentPage = page;
                updateOrderHistory();
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                super.onScrollStateChanged(view, scrollState);

                if (scrollState == SCROLL_STATE_IDLE) {
                    CommerceApplication.getContentServiceHelper().start();
                } else {
                    CommerceApplication.getContentServiceHelper().pause();
                }
            }
        };

        mOrderHistoryListView.setOnScrollListener(mInfiniteScrollListener);

    }

    @Override
    public void onResume() {
        super.onResume();

        if (CommerceApplication.isOnline()) {
            updateOrderHistory();
            mOrderHistoryHeader.setVisibility(View.VISIBLE);
            mOrderHistoryListView.setVisibility(View.VISIBLE);
        } else {
            showLoading(false);
            mOrderHistoryHeader.setVisibility(View.INVISIBLE);
            mOrderHistoryListView.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Call to update the product list from a category
     */
    private void updateOrderHistory() {
        QueryOrders queryOrders = new QueryOrders();
        queryOrders.setCurrentPage(mCurrentPage);
        queryOrders.setPageSize(CommerceApplication.getConfiguration().getDefaultPageSize());

        // Getting the order
        CommerceApplication.getContentServiceHelper().getOrders(this, mOrderHistoryRequestId, queryOrders, null, false, null,
                new OnRequestListener() {

                    @Override
                    public void beforeRequest() {
                        showLoading(true);
                    }

                    @Override
                    public void afterRequestBeforeResponse() {

                    }

                    @Override
                    public void afterRequest(boolean isDataSynced) {
                        showLoading(false);
                    }
                });
    }

    @Override
    public void onResponse(Response<OrderHistoryList> response) {
        if (response.getData() != null && response.getData().getOrders() != null) {

            List<OrderHistory> mOrderHistory = response.getData().getOrders();
            mOrderHistoryAdapter.addAll(mOrderHistory);
            mOrderHistoryAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(Response<ErrorList> response) {
        Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mOrderHistoryRequestId);
    }

    /**
     * Show the loading spinner
     *
     * @param show
     */
    private void showLoading(boolean show) {
        // Adding the loading view for the list view

        if (show) {
            if (mOrderHistoryListView.getFooterViewsCount() == 0) {
                mOrderHistoryListView.addFooterView(mFooterLoadingListView, null, false);
            }
        } else {
            mOrderHistoryListView.removeFooterView(mFooterLoadingListView);
        }
    }
}