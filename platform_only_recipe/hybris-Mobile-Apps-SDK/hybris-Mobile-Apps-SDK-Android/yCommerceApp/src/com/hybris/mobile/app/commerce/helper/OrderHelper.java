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
package com.hybris.mobile.app.commerce.helper;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.commerce.data.order.Order;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import com.hybris.mobile.lib.commerce.data.order.PromotionOrderEntryConsumed;
import com.hybris.mobile.lib.commerce.data.product.PromotionResult;

import org.apache.commons.lang3.StringUtils;


/**
 * Helper for carts
 */
public class OrderHelper {

    /**
     * Populate the order summary
     *
     * @param order
     */
    public static void createOrderSummary(Activity activity, Order order) {

        LinearLayout mOrderSummaryItemsLayout;
        TextView mOrderSummaryItems;
        TextView mOrderSummarySubtotal;
        TextView mOrderSummarySavings;
        TextView mOrderSummaryTax;
        TextView mOrderSummaryShipping;
        TextView mOrderSummaryTotal;
        TextView mOrderSummaryPromotion;
        TableRow mOrderSummarySavingsRow;

        // order summary
        mOrderSummaryItemsLayout = (LinearLayout) activity.findViewById(R.id.order_summary_items_layout);
        mOrderSummaryItems = (TextView) activity.findViewById(R.id.order_summary_items);
        mOrderSummarySubtotal = (TextView) activity.findViewById(R.id.order_summary_subtotal);
        mOrderSummarySavings = (TextView) activity.findViewById(R.id.order_summary_savings);
        mOrderSummaryTax = (TextView) activity.findViewById(R.id.order_summary_tax);
        mOrderSummaryShipping = (TextView) activity.findViewById(R.id.order_summary_shipping);
        mOrderSummaryTotal = (TextView) activity.findViewById(R.id.order_summary_total);
        mOrderSummaryPromotion = (TextView) activity.findViewById(R.id.order_summary_promotion);
        mOrderSummarySavingsRow = (TableRow) activity.findViewById(R.id.order_summary_savings_row);


        if (order != null) {

            populatePromotions(order);

            // Display total price
            if (order.getTotalPrice() != null) {
                mOrderSummaryTotal.setText(order.getTotalPrice().getFormattedValue());
            }

            // Display subtotal price
            if (order.getSubTotal() != null) {
                mOrderSummarySubtotal.setText(order.getSubTotal().getFormattedValue());
            }

            // Display tax price
            if (order.getTotalTax() != null) {
                mOrderSummaryTax.setText(order.getTotalTax().getFormattedValue());
            }

            // Display delivery method cost
            if (order.getDeliveryCost() != null) {
                mOrderSummaryShipping.setText(order.getDeliveryCost().getFormattedValue());
            }

            if (order.getAppliedOrderPromotions() != null && !order.getAppliedOrderPromotions().isEmpty()) {
                if (StringUtils.isNotBlank(order.getOrderDiscounts().getFormattedValue())) {
                    mOrderSummarySavingsRow.setVisibility(View.VISIBLE);
                    mOrderSummarySavings.setText(order.getOrderDiscounts().getFormattedValue());
                }
            }


            if (order.getAppliedOrderPromotions() != null || order.getAppliedProductPromotions() != null) {
                if (order.getAppliedProductPromotions() != null && !order.getAppliedProductPromotions().isEmpty()) {
                    mOrderSummaryPromotion.setVisibility(View.VISIBLE);
                    // Nb order Promotion
                    StringBuffer promotion = new StringBuffer();

                    if (order.getAppliedOrderPromotions() != null && !order.getAppliedOrderPromotions().isEmpty()) {
                        for (PromotionResult orderPromotion : order.getAppliedOrderPromotions()) {
                            promotion.append(orderPromotion.getDescription()).append("\n");
                        }
                    }

                    mOrderSummaryPromotion.setText(promotion);
                } else {
                    mOrderSummaryPromotion.setVisibility(View.GONE);
                }
            } else {
                mOrderSummaryPromotion.setVisibility(View.GONE);
                mOrderSummarySavingsRow.setVisibility(View.GONE);
            }

            // Nb items
            mOrderSummaryItemsLayout.setVisibility(View.VISIBLE);
            mOrderSummaryItems.setText(activity.getString(R.string.order_summary_items, order.getDeliveryItemsQuantity()));
        }
    }


    private static void populatePromotions(Order order) {
        if (order.getAppliedProductPromotions() != null && !order.getAppliedProductPromotions().isEmpty()) {
            for (PromotionResult productPromotion : order.getAppliedProductPromotions()) {
                if (productPromotion.getConsumedEntries() != null && !productPromotion.getConsumedEntries().isEmpty()) {
                    for (PromotionOrderEntryConsumed promotionEntry : productPromotion.getConsumedEntries()) {
                        for (OrderEntry orderProduct : order.getDeliveryOrderGroups().get(0).getEntries()) {
                            if (promotionEntry.getOrderEntryNumber().equals(orderProduct.getEntryNumber())) {
                                if (StringUtils.isNotBlank(productPromotion.getDescription())) {
                                    orderProduct.setPromotionResult(productPromotion);
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public static void createDeliverySummary(Activity activity, Order order) {

        TextView mOrderConfirmDeliveryAddress;
        TextView mOrderConfirmDeliveryMode;

        mOrderConfirmDeliveryAddress = (TextView) activity.findViewById(R.id.order_delivery_address_text);
        mOrderConfirmDeliveryMode = (TextView) activity.findViewById(R.id.order_delivery_method_text);


        if (order != null) {
            if (order.getDeliveryAddress() != null && StringUtils.isNotBlank(order.getDeliveryAddress().getFormattedAddress())) {
                mOrderConfirmDeliveryAddress.setText(order.getDeliveryAddress().getFormattedAddress());
            }

            // Display delivery method
            if (order.getDeliveryMode() != null) {

                mOrderConfirmDeliveryMode.setText(order.getDeliveryMode().getName() + " - "
                        + order.getDeliveryMode().getDescription() + " - "
                        + order.getDeliveryMode().getDeliveryCost().getFormattedValue());
            }
        }
    }


}
