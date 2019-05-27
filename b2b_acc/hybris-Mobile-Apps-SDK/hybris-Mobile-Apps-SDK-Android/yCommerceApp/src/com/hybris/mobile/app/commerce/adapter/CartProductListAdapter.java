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
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.CartHelperBase;
import com.hybris.mobile.app.commerce.helper.CartHelperBase.OnAddToCart;
import com.hybris.mobile.app.commerce.helper.ProductHelper;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import com.hybris.mobile.lib.commerce.query.QueryCartEntry;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.ui.view.Alert;
import com.hybris.mobile.lib.ui.view.ListViewSwipeable;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;


/**
 * Adapter for the products of the cart
 */
public class CartProductListAdapter extends ArrayAdapter<OrderEntry> {
    private static final String TAG = CartProductListAdapter.class.getCanonicalName();
    private List<OrderEntry> mProducts;
    private CurrentQuantity mSelectedQuantity;
    private ListViewSwipeable mListViewSwipeable;
    private String mRequestId;

    public CartProductListAdapter(Activity context, List<OrderEntry> values, ListViewSwipeable listViewSwipeable,
                                  String requestId) {
        super(context, R.layout.item_cart_product, values);
        this.mProducts = values;
        this.mListViewSwipeable = listViewSwipeable;
        this.mRequestId = requestId;
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView;
        final OrderEntry orderEntry = mProducts.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_cart_product, parent, false);

            rowView.setTag(new CartViewHolder(rowView, position));
        } else {
            rowView = convertView;
        }

        final CartViewHolder cartViewHolder = (CartViewHolder) rowView.getTag();

        if (orderEntry != null) {
            // Redirecting to the product detail page when clicking on the image
            cartViewHolder.cartProductItemClickable.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    ProductHelper.redirectToProductDetail(getContext(), orderEntry.getProduct().getCode());
                }
            });

            // Loading the product image
            if (StringUtils.isNotBlank(orderEntry.getProduct().getImageThumbnailUrl())) {
                CommerceApplication.getContentServiceHelper().loadImage(orderEntry.getProduct().getImageThumbnailUrl(), null,
                        cartViewHolder.productImageView, 0, 0, true, null, true);

            }

            // Name
            cartViewHolder.productNameTextView.setText(orderEntry.getProduct().getName());

            // Price
            if (orderEntry.getBasePrice() != null) {
                cartViewHolder.productPrice.setText(orderEntry.getBasePrice().getFormattedValue());
            }

            // Promotion
            if (orderEntry.getPromotionResult() != null) {
                cartViewHolder.productPromotion.setText(orderEntry.getPromotionResult().getDescription());
                cartViewHolder.productPromotion.setVisibility(View.VISIBLE);
            } else {
                cartViewHolder.productPromotion.setVisibility(View.GONE);

            }

            // Variants
            if (orderEntry.getProduct().getBaseOptions() != null && !orderEntry.getProduct().getBaseOptions().isEmpty()) {
                cartViewHolder.linearLayoutVariants.setVisibility(View.VISIBLE);
                cartViewHolder.linearLayoutVariants.removeAllViews();
            }

            // Quantity
            cartViewHolder.quantityEditText.setText(orderEntry.getQuantity() + "");

            // Reset the style after text changed in case of error
            cartViewHolder.quantityEditText.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    cartViewHolder.quantityEditText.setBackgroundResource(R.drawable.quantity_editext);
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

            });

            //  Update quantity to the cart
            cartViewHolder.quantityEditText.setOnEditorActionListener(new OnEditorActionListener() {

                @Override
                public boolean onEditorAction(final TextView v, int actionId, KeyEvent event) {

                    try {
                        int quantity = Integer.parseInt(v.getText().toString());

                        if (quantity == 0) {
                            showDeleteItemDialog(position);
                        } else {
                            CartHelperBase.updateCart(getContext(), mRequestId, new OnAddToCart() {

                                @Override
                                public void onAddToCart(CartModification productAdded) {
                                    // We remove the reference to the selected edittext
                                    mSelectedQuantity = null;
                                }

                                @Override
                                public void onAddToCartError(boolean isOutOfStock) {
                                    // Set the error for the field
                                    v.setBackgroundResource(R.drawable.quantity_editext_invalid);
                                }
                            }, orderEntry.getEntryNumber(), quantity, Collections.singletonList((View) cartViewHolder.quantityEditText), null);
                        }
                    } catch (NumberFormatException e) {
                        Log.e(TAG, e.getLocalizedMessage());
                    }

                    return false;

                }
            });

            // Total price
            if (orderEntry.getTotalPrice() != null) {
                cartViewHolder.productTotalPrice.setText(orderEntry.getTotalPrice().getFormattedValue());
            }

            // Delete /Cancel item buttons
            cartViewHolder.cancelButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    mListViewSwipeable.resetLastSwipedItemPosition(true);
                }
            });

            cartViewHolder.deleteButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    QueryCartEntry queryCartEntry = new QueryCartEntry();
                    queryCartEntry.setEntryNumber(position + "");
                    CommerceApplication.getContentServiceHelper().deleteCartEntry(new ResponseReceiver<CartModification>() {
                        @Override
                        public void onResponse(Response<CartModification> response) {
                            updateCart();
                        }

                        @Override
                        public void onError(Response<ErrorList> response) {
                            UIUtils.showError(response, getContext());

                            // Update the cart
                            SessionHelper.updateCart(getContext(), mRequestId, false);

                        }
                    }, mRequestId, queryCartEntry, null, false, null, mOnRequestListener);
                }
            });

            // When save the quantity field reference in order to reset the default value when clicking outside the box
            cartViewHolder.quantityEditText.setOnFocusChangeListener(new OnFocusChangeListener() {

                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mSelectedQuantity = new CurrentQuantity((EditText) v, orderEntry.getQuantity().intValue());
                }
            });
        }
        return rowView;
    }

    /**
     * Update cart
     */
    private void updateCart() {

        Alert.showSuccess(getContext(), getContext().getString(R.string.cart_delete_item_confirm_message));

        // We remove the reference to the selected edittext in case we click outside the box
        mSelectedQuantity = null;

        // Updating the cart on session
        SessionHelper.updateCart(getContext(), mRequestId, false);
    }

    /**
     * Get a reference to the current selected quantity
     *
     * @return
     */
    public CurrentQuantity getSelectedQuantity() {
        return mSelectedQuantity;
    }

    /**
     * Class for the quantity field of each product
     */
    public static class CurrentQuantity {
        private EditText editText;
        private int defaultValue;

        public CurrentQuantity(EditText editText, int defaultValue) {
            super();
            this.editText = editText;
            this.defaultValue = defaultValue;
        }

        public EditText getEditText() {
            return editText;
        }

        public void setEditText(EditText editText) {
            this.editText = editText;
        }

        public int getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(int defaultValue) {
            this.defaultValue = defaultValue;
        }

    }

    /**
     * Display the delete item dialog
     *
     * @param positionToDelete
     */
    private void showDeleteItemDialog(final int positionToDelete) {

        // Creating the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
        builder.setMessage(R.string.cart_menu_delete_item_confirmation_title)
                .setPositiveButton(R.string.cart_menu_delete_item_remove_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        QueryCartEntry queryCartEntry = new QueryCartEntry();
                        queryCartEntry.setEntryNumber(positionToDelete + "");

                        CommerceApplication.getContentServiceHelper().deleteCartEntry(new ResponseReceiver<CartModification>() {
                            @Override
                            public void onResponse(Response<CartModification> response) {
                                updateCart();
                            }

                            @Override
                            public void onError(Response<ErrorList> response) {
                                UIUtils.showError(response, getContext());

                                // Update the cart
                                SessionHelper.updateCart(getContext(), mRequestId, false);
                            }
                        }, mRequestId, queryCartEntry, null, false, null, mOnRequestListener);
                    }
                }).setNegativeButton(R.string.cancel, null);

        AlertDialog alert = builder.create();

        // The dialog is cancelable by 3 ways: cancel button, click outside the dialog, click on the back button
        alert.setCancelable(true);
        alert.setCanceledOnTouchOutside(true);
        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
                // We revert to the default quantity when we dismiss the dialog
                if (mSelectedQuantity != null) {
                    mSelectedQuantity.getEditText().clearFocus();
                    mSelectedQuantity.getEditText().setText(mSelectedQuantity.getDefaultValue() + "");
                }
            }
        });

        alert.show();
    }

    @Override
    public Activity getContext() {
        return (Activity) super.getContext();
    }

    /**
     * Contains all UI elements for Cart to improve view display while scrolling
     */
    static class CartViewHolder {
        private ImageView productImageView;
        private LinearLayout cartProductItemClickable;
        private TextView productNameTextView;
        private TextView productPrice;
        private TextView productPromotion;
        private LinearLayout linearLayoutVariants;
        private EditText quantityEditText;
        private TextView productTotalPrice;
        private LinearLayout cancelButton;
        private LinearLayout deleteButton;


        public CartViewHolder(View view, int position) {

            productImageView = (ImageView) view.findViewById(R.id.cart_product_item_image);
            cartProductItemClickable = (LinearLayout) view.findViewById(R.id.cart_product_item_clickable);
            productNameTextView = ((TextView) view.findViewById(R.id.cart_product_item_name));
            productPrice = (TextView) view.findViewById(R.id.cart_product_item_price);
            productPromotion = (TextView) view.findViewById(R.id.cart_product_item_promotion);
            linearLayoutVariants = (LinearLayout) view.findViewById(R.id.cart_product_item_variants);
            quantityEditText = ((EditText) view.findViewById(R.id.cart_product_item_quantity));
            productTotalPrice = (TextView) view.findViewById(R.id.cart_product_item_price_total);
            cancelButton = (LinearLayout) view.findViewById(R.id.cart_product_item_delete_cancel);
            deleteButton = (LinearLayout) view.findViewById(R.id.cart_product_item_delete_confirm);

            //Set contentDescription for Calabash
            view.setContentDescription("cart_product_item_" + position);
            productImageView.setContentDescription("cart_product_item_image_" + position);
            productNameTextView.setContentDescription("cart_product_item_name_" + position);
            productPrice.setContentDescription("cart_product_item_price_" + position);
            productPromotion.setContentDescription("cart_product_item_promotion" + position);
            quantityEditText.setContentDescription("cart_product_item_quantity_" + position);
            productTotalPrice.setContentDescription("cart_product_item_price_total_" + position);
            cancelButton.setContentDescription("cart_product_item_delete_cancel_" + position);
            deleteButton.setContentDescription("cart_product_item_delete_confirm_" + position);
        }
    }

    /**
     * Show ProgressBar when Request is send and Hide ProgressBar when Response is received
     */
    private OnRequestListener mOnRequestListener = new OnRequestListener() {

        @Override
        public void beforeRequest() {
            UIUtils.showLoadingActionBar(getContext(), true);
        }

        @Override
        public void afterRequestBeforeResponse() {

        }

        @Override
        public void afterRequest(boolean isDataSynced) {
            UIUtils.showLoadingActionBar(getContext(), false);
        }
    };

}
