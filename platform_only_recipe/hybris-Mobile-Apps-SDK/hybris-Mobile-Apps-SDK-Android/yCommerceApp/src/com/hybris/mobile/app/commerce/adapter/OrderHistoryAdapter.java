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
package com.hybris.mobile.app.commerce.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.Constants;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.OrderDetailActivity;
import com.hybris.mobile.lib.commerce.data.order.OrderHistory;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Adapter for the products of the order
 */
public class OrderHistoryAdapter extends ArrayAdapter<OrderHistory> {
    private static final String TAG = OrderHistoryAdapter.class.getCanonicalName();

    public OrderHistoryAdapter(Activity context, List<OrderHistory> values) {
        super(context, R.layout.item_order_history, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_order_history, parent, false);
            rowView.setTag(new OrderHistoryViewHolder(rowView, position));
        } else {
            rowView = convertView;
        }

        OrderHistoryViewHolder orderHistoryViewHolder = (OrderHistoryViewHolder) rowView.getTag();

        final OrderHistory order = getItem(position);

        if (order != null) {
            // Order Code
            if (StringUtils.isNotBlank(order.getCode())) {
                orderHistoryViewHolder.orderNumberTextView.setText(order.getCode());
            }

            // Date placed / created
            if (order.getPlaced() != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_COMPLETE,
                        SimpleDateFormat.getAvailableLocales()[0]);

                orderHistoryViewHolder.orderDatePlacedTextView.setText(simpleDateFormat.format(order.getPlaced()));
            }

            // Status

            if (StringUtils.isNotBlank(order.getStatusDisplay())) {
                orderHistoryViewHolder.orderStatusTextView.setText(order.getStatusDisplay());
            }

            // Total price
            if (order.getTotal() != null) {
                orderHistoryViewHolder.orderTotalTextView.setText(order.getTotal().getFormattedValue());
            }

            // Redirecting to the order detail page when clicking on the item
            orderHistoryViewHolder.orderHistoryLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentOrderDetail = new Intent(getContext(), OrderDetailActivity.class);
                    intentOrderDetail.putExtra(IntentConstants.ORDER_CODE, order.getCode());
                    getContext().startActivity(intentOrderDetail);
                }
            });

        }
        return rowView;
    }


    /**
     * Contains all UI elements for Order to improve view display while scrolling
     */
    static class OrderHistoryViewHolder {
        private LinearLayout orderHistoryLayout;
        private TextView orderNumberTextView;
        private TextView orderDatePlacedTextView;
        private TextView orderStatusTextView;
        private TextView orderTotalTextView;

        public OrderHistoryViewHolder(View view, int position) {

            orderHistoryLayout = ((LinearLayout) view.findViewById(R.id.order_history_item));
            orderNumberTextView = ((TextView) view.findViewById(R.id.order_number));
            orderDatePlacedTextView = (TextView) view.findViewById(R.id.order_date_placed);
            orderStatusTextView = (TextView) view.findViewById(R.id.order_status);
            orderTotalTextView = ((TextView) view.findViewById(R.id.order_total));

            orderHistoryLayout.setContentDescription("order_history_item" + position);
            orderNumberTextView.setContentDescription("order_number" + position);
            orderDatePlacedTextView.setContentDescription("order_date_placed" + position);
            orderStatusTextView.setContentDescription("order_status" + position);
            orderTotalTextView.setContentDescription("order_total" + position);

        }
    }
}
