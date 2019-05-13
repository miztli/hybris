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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.ProductHelper;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Adapter for the products of the order
 */
public class OrderProductListAdapter extends ArrayAdapter<OrderEntry> {
    private List<OrderEntry> mProducts;

    public OrderProductListAdapter(Activity context, List<OrderEntry> values) {
        super(context, R.layout.item_order_product, values);
        this.mProducts = values;
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_order_product, parent, false);
            rowView.setTag(new OrderViewHolder(rowView, position));
        } else {
            rowView = convertView;
        }

        final OrderViewHolder orderViewHolder = (OrderViewHolder) rowView.getTag();

        final OrderEntry orderProduct = mProducts.get(position);
        if (orderProduct != null) {
            // Name
            orderViewHolder.productNameTextView.setText(orderProduct.getProduct().getName());

            // Price
            if (orderProduct.getBasePrice() != null) {
                orderViewHolder.productPrice.setText(orderProduct.getBasePrice().getFormattedValue());
            }

            // Promotion
            if (orderProduct.getPromotionResult() != null) {
                if (StringUtils.isNotBlank(orderProduct.getPromotionResult().getDescription())) {
                    orderViewHolder.productPromotion.setText(orderProduct.getPromotionResult().getDescription());
                }

                orderViewHolder.productPromotion.setVisibility(View.VISIBLE);
            } else {
                orderViewHolder.productPromotion.setVisibility(View.GONE);

            }

            // Variants
            if (orderProduct.getProduct().getBaseOptions() != null && !orderProduct.getProduct().getBaseOptions().isEmpty()) {
                orderViewHolder.linearLayoutVariants.setVisibility(View.VISIBLE);
                orderViewHolder.linearLayoutVariants.removeAllViews();
            }

            // Redirecting to the product detail page when clicking on the image
            orderViewHolder.orderItemClickableLyout.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    ProductHelper.redirectToProductDetail(getContext(), orderProduct.getProduct().getCode());
                }
            });

            // Loading the product image
            if (StringUtils.isNotBlank(orderProduct.getProduct().getImageThumbnailUrl())) {
                CommerceApplication.getContentServiceHelper().loadImage(orderProduct.getProduct().getImageThumbnailUrl(), null,
                        orderViewHolder.productImageView, 0, 0, true, null, true);
            }

            // Quantity
            orderViewHolder.quantityTextView.setText(getContext().getString(R.string.order_confirmation_qty,
                    orderProduct.getQuantity()));

            // Total price
            if (orderProduct.getTotalPrice() != null) {
                orderViewHolder.productTotalPrice.setText(orderProduct.getTotalPrice().getFormattedValue());
            }

        }
        return rowView;
    }

    /**
     * Contains all UI elements for Order to improve view display while scrolling
     */
    static class OrderViewHolder {
        private ImageView productImageView;
        private LinearLayout orderItemClickableLyout;
        private TextView productNameTextView;
        private TextView productPrice;
        private TextView productPromotion;
        private LinearLayout linearLayoutVariants;
        private TextView quantityTextView;
        private TextView productTotalPrice;

        public OrderViewHolder(View view, int position) {

            productImageView = (ImageView) view.findViewById(R.id.order_product_item_image);
            orderItemClickableLyout = (LinearLayout) view.findViewById(R.id.order_product_item);
            productNameTextView = ((TextView) view.findViewById(R.id.order_product_item_name));
            productPrice = (TextView) view.findViewById(R.id.order_product_item_price);
            productPromotion = (TextView) view.findViewById(R.id.order_product_item_promotion);
            linearLayoutVariants = (LinearLayout) view.findViewById(R.id.order_product_item_variants);
            quantityTextView = ((TextView) view.findViewById(R.id.order_product_item_quantity));
            productTotalPrice = (TextView) view.findViewById(R.id.order_product_item_price_total);

            view.setContentDescription("order_product_item_" + position);
            productImageView.setContentDescription("order_product_item_image_" + position);
            productNameTextView.setContentDescription("order_product_item_name_" + position);
            productPrice.setContentDescription("order_product_item_price_" + position);
            productPromotion.setContentDescription("order_product_item_promotion" + position);
            quantityTextView.setContentDescription("order_product_item_quantity_" + position);
            productTotalPrice.setContentDescription("order_product_item_price_total_" + position);

        }
    }
}
