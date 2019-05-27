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

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.CheckoutActivity;
import com.hybris.mobile.app.commerce.adapter.CartProductListAdapter;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.app.commerce.view.CartViewUtils;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import com.hybris.mobile.lib.commerce.data.order.PromotionOrderEntryConsumed;
import com.hybris.mobile.lib.commerce.data.product.PromotionResult;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.layout.DrawerPushLayout;
import com.hybris.mobile.lib.ui.view.ListViewSwipeable;
import com.hybris.mobile.lib.ui.view.ListViewSwipeable.ListViewSwipeableListener;

import java.util.ArrayList;


/**
 * Fragment for the cart
 */
public class CartFragment extends Fragment implements ListViewSwipeableListener {
    public String mCartRequestId = RequestUtils.generateUniqueRequestId();
    private View mPriceBlock;
    private View mCartEmpty;
    private CartProductListAdapter mCartProductListAdapter;
    private LinearLayout mCartHeaderCheckout;
    private TextView mCartHeaderCheckoutText;
    private TextView mCartCardIdText;
    private ListViewSwipeable mProductList;
    private DrawerPushLayout mCartDrawer;
    private OnCartLoadedListener mActivity;

    /**
     * Interface for activity communication
     */
    public interface OnCartLoadedListener {
        void onCartLoaded();

        void onCartSummaryLoaded(Cart cart);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnCartLoadedListener) {
            mActivity = (OnCartLoadedListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Keep focus for EditText (item quantities) on the ListView
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        return inflater.inflate(R.layout.fragment_cart_menu, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Top elements
        mPriceBlock = getView().findViewById(R.id.cart_menu_price);
        mCartEmpty = getView().findViewById(R.id.cart_menu_empty);
        mCartHeaderCheckoutText = (TextView) getView().findViewById(R.id.cart_menu_header_checkout_text);
        mCartHeaderCheckout = (LinearLayout) getView().findViewById(R.id.cart_menu_header_checkout);
        mCartHeaderCheckout.setOnClickListener(mCartHeaderCheckoutListener);
        mCartCardIdText = (TextView) getView().findViewById(R.id.cart_menu_cart_id);

        // Product list
        mProductList = (ListViewSwipeable) getView().findViewById(R.id.cart_menu_products_list);
        mCartProductListAdapter = new CartProductListAdapter(getActivity(), new ArrayList<OrderEntry>(), mProductList,
                mCartRequestId);
        mProductList.setAdapter(mCartProductListAdapter);
        mProductList.setListViewSwipeableActions(this);

        // Drawer
        mCartDrawer = (DrawerPushLayout) getActivity().findViewById(R.id.cart_menu_drawer);

        // Close the cart menu when click on "Continue Shopping" button
        getActivity().findViewById(R.id.cart_menu_header_continue_shop).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Close the cart menu
                mCartDrawer.closeDrawer(mCartDrawer.getChildAt(1));
            }
        });

        // When clicking outside a EditText, hide keyboard, remove focus and
        // reset to the default value
        // Clicking on the main view
        getView().setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                resetCurrentQuantityToDefaultValue();
                mProductList.resetLastSwipedItemPosition(true);
                v.performClick();
                return false;
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        // Enable/disable checkout
        activateCartCheckout(SessionHelper.getCartTotalUnitCount() > 0);
        SessionHelper.updateCart(getActivity(), mCartRequestId, true);
    }

    /**
     * Populate the cart content
     *
     * @param cart
     */
    public void populateCartContent(Cart cart) {
        // We reset the last swipped item position
        mProductList.resetLastSwipedItemPosition(false);

        if (cart != null) {
            mCartCardIdText.setText(getString(R.string.cart_menu_shopping_cart_id, cart.getCode()));

            if (cart.getEntries() != null && !cart.getEntries().isEmpty()) {

                mCartEmpty.setVisibility(View.GONE);
                mPriceBlock.setVisibility(View.VISIBLE);

                // get all product Promotion
                if (cart.getAppliedProductPromotions() != null) {
                    for (PromotionResult productPromotion : cart.getAppliedProductPromotions()) {
                        if (productPromotion.getConsumedEntries() != null) {
                            for (PromotionOrderEntryConsumed promotionEntry : productPromotion.getConsumedEntries()) {
                                for (int i = 0; i < cart.getEntries().size(); i++) {
                                    if (promotionEntry.getOrderEntryNumber().equals(cart.getEntries().get(i).getEntryNumber())) {
                                        cart.getEntries().get(i).setPromotionResult(productPromotion);
                                    }
                                }
                            }
                        }
                    }
                }

            } else {
                mCartEmpty.setVisibility(View.VISIBLE);
                mPriceBlock.setVisibility(View.GONE);
            }

            // Update
            SessionHelper.updateCartItemCount(cart.getTotalUnitCount(), getActivity());

            // Enable/disable checkout
            this.activateCartCheckout(cart.getTotalUnitCount() > 0);

            // Set list of entries
            mCartProductListAdapter.clear();

            if (cart.getEntries() != null) {
                mCartProductListAdapter.addAll(cart.getEntries());
            }

            // Updating the list
            mCartProductListAdapter.notifyDataSetChanged();

            // create views and populate them
            populateCartSummary(cart);

            if (mActivity != null) {
                mActivity.onCartLoaded();
            }
        }
    }

    /**
     * Populate the cart summary
     *
     * @param cart
     */
    public void populateCartSummary(Cart cart) {
        CartViewUtils.createCartSummary(getView(), cart, false);

        if (mActivity != null) {
            mActivity.onCartSummaryLoaded(cart);
        }
    }

    /**
     * Reset the current edited quantity to the default value, hide the keyboard and remove the focus from the EditText
     */
    private void resetCurrentQuantityToDefaultValue() {

        if (mCartProductListAdapter.getSelectedQuantity() != null
                && mCartProductListAdapter.getSelectedQuantity().getEditText() != null
                && mCartProductListAdapter.getSelectedQuantity().getEditText().hasFocus()) {
            mCartProductListAdapter.getSelectedQuantity().getEditText().clearFocus();
            mCartProductListAdapter.getSelectedQuantity().getEditText()
                    .setText(mCartProductListAdapter.getSelectedQuantity().getDefaultValue() + "");
            UIUtils.hideKeyboard(getActivity());
        }

    }

    /**
     * Enable/disable checkout
     *
     * @param activate
     */
    private void activateCartCheckout(boolean activate) {
        // Cart content
        if (activate) {
            getView().findViewById(R.id.cart_menu_products_header).setVisibility(View.VISIBLE);
            getView().findViewById(R.id.cart_menu_products_header_swipe_hint).setVisibility(View.VISIBLE);
        } else {
            getView().findViewById(R.id.cart_menu_products_header).setVisibility(View.GONE);
            getView().findViewById(R.id.cart_menu_products_header_swipe_hint).setVisibility(View.GONE);
        }

        // Checkout button
        mCartHeaderCheckout.setEnabled(activate);
        mCartHeaderCheckout.setClickable(activate);
        mCartHeaderCheckoutText.setTextColor(getResources().getColor(
                activate ? R.color.signin_text_button_enabled : R.color.signin_text_button_disabled));
    }

    /**
     * Navigate to checkout page
     */
    public OnClickListener mCartHeaderCheckoutListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CheckoutActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public void onBeginSwipe() {
        mCartDrawer.disableTouchEvent();
    }

    @Override
    public void onFinishSwipe() {
        mCartDrawer.enableTouchEvent();
    }

    @Override
    public void onTouch() {
        resetCurrentQuantityToDefaultValue();
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mCartRequestId);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
}
