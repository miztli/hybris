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
package com.hybris.mobile.app.commerce.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.product.PromotionResult;

import org.apache.commons.lang3.StringUtils;


/**
 * Helper for carts
 */
public class CartViewUtils {

    /**
     * Populate the cart summary
     *
     * @param cart
     */
    public static void createCartSummary(View view, Cart cart, boolean enableItems) {

        // Cart summary
        LinearLayout mCartSummaryItemsLayout;
        TextView mCartSummaryItems;
        TextView mCartSummarySubtotal;
        TextView mCartSummarySavings;
        TextView mCartSummaryTax;
        TextView mCartSummaryShipping;
        TextView mCartSummaryTotal;
        TextView mCartSummaryPromotion;
        TableRow mCartSummarySavingsRow;
        TableRow mCartSummaryTaxRow;
        TextView mCartSummaryNoTax;
        TableRow mCartSummaryShippingRow;
        TextView mCartSummaryEmpty;
        LinearLayout mCartSummaryDetailsLayout;

        // cart summary
        mCartSummaryItemsLayout = (LinearLayout) view.findViewById(R.id.cart_summary_items_layout);
        mCartSummaryItems = (TextView) view.findViewById(R.id.cart_summary_items);
        mCartSummarySubtotal = (TextView) view.findViewById(R.id.cart_summary_subtotal);
        mCartSummarySavings = (TextView) view.findViewById(R.id.cart_summary_savings);
        mCartSummaryTax = (TextView) view.findViewById(R.id.cart_summary_tax);
        mCartSummaryShipping = (TextView) view.findViewById(R.id.cart_summary_shipping);
        mCartSummaryTotal = (TextView) view.findViewById(R.id.cart_summary_total);
        mCartSummaryPromotion = (TextView) view.findViewById(R.id.cart_summary_promotion);
        mCartSummarySavingsRow = (TableRow) view.findViewById(R.id.cart_summary_savings_row);
        mCartSummaryTaxRow = (TableRow) view.findViewById(R.id.cart_summary_tax_row);
        mCartSummaryNoTax = (TextView) view.findViewById(R.id.cart_summary_no_taxes);
        mCartSummaryShippingRow = (TableRow) view.findViewById(R.id.cart_summary_shipping_row);
        mCartSummaryEmpty = (TextView) view.findViewById(R.id.cart_summary_empty);
        mCartSummaryDetailsLayout = (LinearLayout) view.findViewById(R.id.cart_summary_details_layout);

        if (cart != null) {
            if (cart.getEntries() != null && !cart.getEntries().isEmpty()) {
                // Display total price
                if (cart.getTotalPrice() != null) {
                    mCartSummaryTotal.setText(cart.getTotalPrice().getFormattedValue());
                }

                // Display subtotal price
                if (cart.getSubTotal() != null) {
                    mCartSummarySubtotal.setText(cart.getSubTotal().getFormattedValue());
                }

                // Display tax price
                if (cart.getTotalTax() != null && cart.getTotalTax().getValue().intValue() > 0) {
                    mCartSummaryTax.setText(cart.getTotalTax().getFormattedValue());
                    mCartSummaryTaxRow.setVisibility(View.VISIBLE);
                    mCartSummaryNoTax.setVisibility(View.GONE);
                } else {
                    mCartSummaryTaxRow.setVisibility(View.GONE);
                    mCartSummaryNoTax.setVisibility(View.VISIBLE);
                }

                // Display delivery method cost
                if (cart.getDeliveryCost() != null) {
                    mCartSummaryShipping.setText(cart.getDeliveryCost().getFormattedValue());
                    mCartSummaryShippingRow.setVisibility(View.VISIBLE);
                } else {
                    mCartSummaryShippingRow.setVisibility(View.GONE);
                }

                if (cart.getAppliedOrderPromotions() != null && !cart.getAppliedOrderPromotions().isEmpty()) {
                    if (StringUtils.isNotBlank(cart.getOrderDiscounts().getFormattedValue())) {
                        mCartSummarySavingsRow.setVisibility(View.VISIBLE);
                        mCartSummarySavings.setText(cart.getOrderDiscounts().getFormattedValue());
                    }
                }

                if (cart.getTotalDiscounts() != null && cart.getTotalDiscounts().getValue().doubleValue() > 0) {
                    if (cart.getAppliedOrderPromotions() != null && !cart.getAppliedOrderPromotions().isEmpty()) {
                        mCartSummaryPromotion.setVisibility(View.VISIBLE);
                        // Nb order Promotion
                        StringBuffer promotion = new StringBuffer();
                        for (PromotionResult orderPromotion : cart.getAppliedOrderPromotions()) {
                            promotion.append(orderPromotion.getDescription()).append("\n");
                        }
                        mCartSummaryPromotion.setText(promotion);
                    } else {
                        mCartSummaryPromotion.setVisibility(View.GONE);
                    }
                } else {
                    mCartSummaryPromotion.setVisibility(View.GONE);
                    mCartSummarySavingsRow.setVisibility(View.GONE);
                }

                // Nb items
                mCartSummaryItemsLayout.setVisibility(enableItems ? View.VISIBLE : View.GONE);
                mCartSummaryItems.setText(CommerceApplication.getContext()
                        .getString(R.string.cart_summary_items, cart.getTotalUnitCount()));

                //Cart is used
                mCartSummaryEmpty.setVisibility(View.GONE);
                mCartSummaryDetailsLayout.setVisibility(View.VISIBLE);
            } else {
                //Cart Empty show messages & Cart Empty remove all summary views
                mCartSummaryEmpty.setVisibility(View.VISIBLE);
                mCartSummaryDetailsLayout.setVisibility(View.GONE);
                mCartSummaryPromotion.setVisibility(View.GONE);

            }
        }
    }
}
