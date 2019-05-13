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

import android.content.Context;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.CartHelperBase;
import com.hybris.mobile.app.commerce.helper.ProductHelper;
import com.hybris.mobile.app.commerce.utils.ProductUtils;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.loader.ContentLoader;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.ui.listener.SubmitListener;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Adapter for the products of the catalog in a listview
 */
public abstract class ProductListAdapterBase extends ProductItemsAdapterBase {
    public static final String TAG = ProductListAdapterBase.class.getCanonicalName();

    protected int mCurrentSelectedPosition = -1;
    protected boolean mTriggerSpinnerOnChange = false;
    protected int mNbVariantLevels = 0;
    protected int mNbVariantLevelsInstantiated = 0;
    protected List<Spinner> mSpinnersVariants;

    public ProductListAdapterBase(Context context, Cursor c, int flags, ContentServiceHelper contentServiceHelper) {
        super(context, c, flags, contentServiceHelper);
    }

    @Override
    public void bindView(View rowView, final Context context, final Cursor cursor) {

        // When clicking outside a EditText, hide keyboard, remove focus and
        // reset to the default value
        // Clicking on the main view
        rowView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                UIUtils.hideKeyboard(getContext());
                v.performClick();
                return false;
            }
        });

        final ProductViewHolder productViewHolder = (ProductViewHolder) rowView.getTag();
        final ProductBase product = getData();

        if (mCurrentSelectedPosition == cursor.getPosition()) {
            //TODO when item is in scrapview, index changed and wrong item is opened
            //createExpandedView(mProductViewHolder, cursor.getPosition());
        } else {

            // Populate name and code for a product when row collapsed
            productViewHolder.productName.setText(product.getName());
            productViewHolder.productNo.setText(product.getCode());
            productViewHolder.quantityEditText.setText(getContext().getString(R.string.default_qty));
            String rangeFormattedPrice = product.getPriceRangeFormattedValue();

            if (product.getPriceRange().getMaxPrice() != null) {
                rangeFormattedPrice =
                        StringUtils.isNotBlank(product.getPriceRange().getMaxPrice().getFormattedValue()) && StringUtils.isNotBlank(
                                product.getPriceRange().getMinPrice().getFormattedValue()) ? product.getPriceRangeFormattedValue() : "";

                if (StringUtils.isBlank(rangeFormattedPrice)) {
                    if (product.getPriceRange().getMaxPrice().getValue() != null &&
                            product.getPriceRange().getMinPrice().getValue() != null) {

                        rangeFormattedPrice =
                                "$" + product.getPriceRange().getMinPrice().getValue() + ".00 - " + "$" + product.getPriceRange()
                                        .getMaxPrice().getValue() + ".00";
                    }
                }
            }
            productViewHolder.productPrice.setText(rangeFormattedPrice);


            //Rating
            if(product.getAverageRating() != null){
                productViewHolder.productItemRating.setVisibility(View.VISIBLE);
                productViewHolder.productItemRating.setRating(product.getAverageRating().floatValue());

                productViewHolder.productItemRatingExpanded.setVisibility(View.VISIBLE);
                productViewHolder.productItemRatingExpanded.setRating(product.getAverageRating().floatValue());
            }
            else{
                productViewHolder.productItemRating.setVisibility(View.GONE);
                productViewHolder.productItemRatingExpanded.setVisibility(View.GONE);
            }


            // Loading the product image
            loadProductImage(product.getImageThumbnailUrl(), productViewHolder.productImage,
                    productViewHolder.productImageLoading, product.getCode());
            productViewHolder.collapse();

            if (product.getMultidimensional() != null && product.getMultidimensional()) {
                // Show arrow down with variants
                productViewHolder.productPriceTotal.setVisibility(View.GONE);
                productViewHolder.productImageViewCartIcon.setVisibility(View.GONE);
                productViewHolder.productImageViewExpandIcon.setVisibility(View.VISIBLE);
                productViewHolder.productItemAddQuantityLayout.setVisibility(View.GONE);
                productViewHolder.quantityEditText.setVisibility(View.GONE);
                productViewHolder.productAvailability.setVisibility(View.GONE);
                productViewHolder.productItemInStock.setVisibility(View.GONE);

                productViewHolder.productImageLoadingExpanded.setVisibility(View.VISIBLE);
                productViewHolder.productItemStockLevelLoadingExpanded.setVisibility(View.VISIBLE);
                productViewHolder.productImageExpanded.setVisibility(View.GONE);
                productViewHolder.productAvailabilityExpanded.setVisibility(View.GONE);

                /**
                 * Gray out button
                 */
                productViewHolder.setAddCartButton(true);
            } else {
                // Show cart icon without variants
                productViewHolder.productItemAddQuantityLayout.setVisibility(View.VISIBLE);
                productViewHolder.productPriceTotal.setVisibility(View.VISIBLE);
                productViewHolder.productPriceTotal.setText(productViewHolder.setTotalPrice(product.getPrice(),
                        productViewHolder.quantityEditText.getText().toString()));
                productViewHolder.productImageViewCartIcon.setVisibility(View.VISIBLE);
                productViewHolder.productImageViewExpandIcon.setVisibility(View.GONE);
                productViewHolder.quantityEditText.setEnabled(true);
                productViewHolder.quantityEditText.setVisibility(View.VISIBLE);
                productViewHolder.productAvailability.setText(product.getStock().getStockLevel() + "");
                productViewHolder.productItemInStock.setVisibility(View.VISIBLE);

                productViewHolder.setAddCartButton(true);

                if (product.isLowStock() || product.isOutOfStock()) {
                    productViewHolder.productAvailability.setTextColor(getContext().getResources().getColor(
                            R.color.product_item_low_stock));
                    productViewHolder.productItemInStock.setTextColor(getContext().getResources().getColor(
                            R.color.product_item_low_stock));
                    productViewHolder.productAvailability.setContentDescription(getContext().getString(
                            R.string.product_item_low_stock));

                    if (product.isOutOfStock()) {
                        productViewHolder.quantityEditText.setEnabled(false);
                        productViewHolder.quantityEditText.setText("");

                    }

                }

                if (product.isInStock()) {
                    productViewHolder.productAvailability.setText("");
                    productViewHolder.productItemInStock.setTextColor(getContext().getResources().getColor(
                            R.color.product_item_in_stock));
                }

            }

        }

        /**
         * Product item row is collapsed and user click the arrow down icon to expand
         */
        productViewHolder.productImageViewExpandIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Expanded
                getContext().getLoaderManager().restartLoader(0, null, getProductLoaderExpandView(product, getContext(), CommerceApplication.getContentServiceHelper(), new OnRequestListener() {

                    @Override
                    public void beforeRequest() {
                        // Expanded
                        productViewHolder.productImageLoadingExpanded.setVisibility(View.VISIBLE);
                        productViewHolder.productItemStockLevelLoadingExpanded.setVisibility(View.VISIBLE);
                        productViewHolder.productImageExpanded.setVisibility(View.GONE);
                        productViewHolder.productAvailabilityExpanded.setVisibility(View.GONE);
                        UIUtils.showLoadingActionBar(getContext(), true);
                    }

                    @Override
                    public void afterRequestBeforeResponse() {
                        if (mCurrentSelectedViewHolder != null) {
                            mCurrentSelectedViewHolder.collapse();
                        }

                        mCurrentSelectedPosition = cursor.getPosition();
                        mCurrentSelectedViewHolder = productViewHolder;
                    }

                    @Override
                    public void afterRequest(boolean isDataSynced) {
                        productViewHolder.productImageLoadingExpanded.setVisibility(View.GONE);
                        productViewHolder.productItemStockLevelLoadingExpanded.setVisibility(View.GONE);
                        productViewHolder.productImageExpanded.setVisibility(View.VISIBLE);
                        productViewHolder.productAvailabilityExpanded.setVisibility(View.VISIBLE);
                        productViewHolder.productImageLoading.setVisibility(View.GONE);
                        UIUtils.showLoadingActionBar(getContext(), false);

                    }
                }, new OnProductLoaded() {
                    @Override
                    public void onProductLoaded(ProductBase productBase, String productCodeFirstVariant) {

                        if (productBase != null) {
                            createExpandedView(mCurrentSelectedViewHolder, productBase);

                            if (!mTriggerSpinnerOnChange) {
                                mNbVariantLevels = populateVariants(mSpinnersVariants, productBase);

                                if (StringUtils.isNotBlank(productCodeFirstVariant)) {
                                    selectVariant(productCodeFirstVariant);
                                }
                            }

                        }

                    }
                }));

            }
        });

        /**
         * Detect when text is changed
         */
        productViewHolder.quantityEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    if (cursor.getCount() > cursor.getPosition() && product != null) {
                        if (product.getPrice() != null) {
                            productViewHolder.productPriceTotal.setText(productViewHolder.setTotalPrice(product.getPrice(),
                                    productViewHolder.quantityEditText.getText().toString()));
                        }
                    }
                    productViewHolder.setAddCartButton(true);
                } catch (NumberFormatException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        /**
         * Detect when text is changed
         */
        productViewHolder.quantityEditTextExpanded.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    if (cursor.getCount() > cursor.getPosition() && product.getPrice() != null) {
                        productViewHolder.productPriceTotalExpanded.setText(productViewHolder.setTotalPrice(
                                product.getPrice(), productViewHolder.quantityEditTextExpanded.getText().toString()));
                    }
                    productViewHolder.setAddCartButton(true);
                } catch (NumberFormatException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        /**
         * Add to cart when user click on cartIcon in Product item collapsed row
         */
        productViewHolder.productImageViewCartIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(product.getCode(), productViewHolder.quantityEditText.getText().toString(), productViewHolder);
                productViewHolder.quantityEditText.setText(getContext().getString(R.string.default_qty));
            }
        });

        productViewHolder.quantityEditText.setOnEditorActionListener(new SubmitListener() {

            @Override
            public void onSubmitAction() {
                addToCart(product.getCode(), productViewHolder.quantityEditText.getText().toString(), productViewHolder);
                productViewHolder.quantityEditText.setText(getContext().getString(R.string.default_qty));
            }
        });


        /**
         * Product item row is expanded and user click the arrow up icon to collapse
         */
        productViewHolder.productItemButtonCollpaseLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // collapsed
                productViewHolder.collapse();
                mCurrentSelectedViewHolder.collapse();

            }
        });

        /**
         * Product item row is collapsed and user click on the main part of the row to navigate to the product detail page
         */
        productViewHolder.productItemClickableLayoutCollapsed.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductHelper.redirectToProductDetail(getContext(),
                        StringUtils.isNotBlank(getFirstVariantCode(product)) ? getFirstVariantCode(product) : product.getCode());
            }
        });

        /**
         * Product item row is collapsed and user click on the main part of the row to navigate to the product detail page
         */
        productViewHolder.productItemClickableLayoutExpanded.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductHelper.redirectToProductDetail(getContext(),
                        StringUtils.isNotBlank(getFirstVariantCode(product)) ? getFirstVariantCode(product) : product.getCode());
            }
        });

    }

    protected OnItemSelectedListener getProductDetailVariantSpinnerListener() {
        return new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position) != null && mTriggerSpinnerOnChange) {

                    Spinner spinnerToUpdate = null;

                    switch (parent.getId()) {
                        case R.id.product_item_variant_spinner_1:
                            spinnerToUpdate = mCurrentSelectedViewHolder.productItemVariantSpinner2;
                            break;

                        case R.id.product_item_variant_spinner_2:
                            spinnerToUpdate = mCurrentSelectedViewHolder.productItemVariantSpinner3;
                            break;

                        default:
                            break;
                    }

                    onItemSpinnerSelected(spinnerToUpdate, parent.getItemAtPosition(position));
                }

                // Workaround to activate the onchange listener only after having instantiated the latest spinner
                mNbVariantLevelsInstantiated++;
                if (mNbVariantLevelsInstantiated == mNbVariantLevels) {
                    mTriggerSpinnerOnChange = true;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    }

    /**
     * Show image Product from URL
     *
     * @param imageUrl    image url
     * @param imageView
     * @param progressBar
     * @param productCode product code to find
     */
    protected void loadProductImage(String imageUrl, final ImageView imageView, final ProgressBar progressBar, String productCode) {

        // Loading the product image
        if (CommerceApplication.isOnline()) {
            if (StringUtils.isNotBlank(imageUrl)) {
                CommerceApplication.getContentServiceHelper().loadImage(imageUrl, "product_list_image_" + productCode, imageView, 0, 0,
                        true, new OnRequestListener() {

                            @Override
                            public void beforeRequest() {
                                imageView.setImageResource(android.R.color.transparent);
                                imageView.setVisibility(View.GONE);
                                progressBar.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void afterRequestBeforeResponse() {

                            }

                            @Override
                            public void afterRequest(boolean isDataSynced) {
                                imageView.setVisibility(View.VISIBLE);
                            }
                        }, true);
            }
        } else {
            Log.i(TAG, "Application offline, displaying no image for product " + productCode);
            imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.no_image_product));
            imageView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * @param viewHolder
     * @param currentExpandedProduct
     */
    protected void createExpandedView(ProductViewHolder viewHolder, ProductBase currentExpandedProduct) {
        // By default the on change is not triggered on the variants spinner EXCEPT for the first one (prevent the call of onchange on each spinner)
        mTriggerSpinnerOnChange = false;
        mNbVariantLevelsInstantiated = 0;

        viewHolder.productNameExpanded.setText(currentExpandedProduct.getName());
        viewHolder.productNoExpanded.setText(currentExpandedProduct.getCode());

        viewHolder.productPriceExpanded.setText(currentExpandedProduct.getPriceRangeFormattedValue());

        viewHolder.productPriceTotalExpanded.setText(viewHolder.setTotalPrice(currentExpandedProduct.getPrice(),
                viewHolder.quantityEditTextExpanded.getText().toString()));

        if (currentExpandedProduct.isOutOfStock()) {

            viewHolder.quantityEditTextExpanded.setEnabled(false);
            viewHolder.quantityEditTextExpanded.setText("");
            viewHolder.productAvailabilityExpanded.setText(currentExpandedProduct.getStock().getStockLevel() + "");
        } else {
            viewHolder.quantityEditTextExpanded.setEnabled(true);
            viewHolder.productAvailabilityExpanded.setText(currentExpandedProduct.getStock().getStockLevel() + "");
        }

        // Loading the product image for expanded view
        loadProductImage(currentExpandedProduct.getImageThumbnailUrl(), viewHolder.productImageExpanded,
                viewHolder.productImageLoadingExpanded, currentExpandedProduct.getCode());

        // Populate the spinner
        mSpinnersVariants = new ArrayList<>();
        mSpinnersVariants.add(viewHolder.productItemVariantSpinner1);
        mSpinnersVariants.add(viewHolder.productItemVariantSpinner2);
        mSpinnersVariants.add(viewHolder.productItemVariantSpinner3);
        mNbVariantLevels = populateVariants(mSpinnersVariants, currentExpandedProduct);

        viewHolder.productItemVariantSpinner2.setOnItemSelectedListener(getProductDetailVariantSpinnerListener());
        viewHolder.productItemVariantSpinner3.setOnItemSelectedListener(getProductDetailVariantSpinnerListener());
        viewHolder.productItemVariantSpinner1.setOnItemSelectedListener(getProductDetailVariantSpinnerListener());

        viewHolder.setAddCartButton(true);
        populateProductExpanded(currentExpandedProduct);
        viewHolder.expand();
    }

    /**
     * Add to cart
     *
     * @param code : product code
     * @param qty  : quantity to added
     */
    protected void addToCart(String code, String qty, final ProductViewHolder productViewHolder) {
        try {
//          CartHelperBase.addToCart(getContext(), null, null, code, Integer.parseInt(qty), null, null);
            CartHelperBase.addToCart(getContext(), null, new CartHelperBase.OnAddToCart() {
//          To Disable add to cart button on list view
                @Override
                public void onAddToCart(CartModification productAdded) {

                    productViewHolder.setAddCartButton(!productAdded.isOutOfStock());
                }

                @Override
                public void onAddToCartError(boolean isOutOfStock) {

                }

            }, code, Integer.parseInt(qty), null, null);

        } catch (NumberFormatException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    /**
     * Populate the product
     *
     * @param product
     */
    protected void populateProductExpanded(final ProductBase product) {
        if (product != null) {
            /**
             * Populate the view with data from response and associate it to the right element in the view
             */
            mCurrentSelectedViewHolder.productNameExpanded.setText(product.getName());
            mCurrentSelectedViewHolder.productNoExpanded.setText(product.getCode());

            if (product.getStock() != null) {
                mCurrentSelectedViewHolder.productAvailabilityExpanded.setVisibility(View.VISIBLE);
                if (product.isLowStock() || product.isOutOfStock()) {
                    mCurrentSelectedViewHolder.productAvailabilityExpanded.setTextColor(getContext().getResources().getColor(
                            R.color.product_item_low_stock));
                    mCurrentSelectedViewHolder.productAvailabilityExpanded.setContentDescription(getContext().getString(
                            R.string.product_item_low_stock));

                    if (product.isOutOfStock()) {
                        mCurrentSelectedViewHolder.quantityEditTextExpanded.setEnabled(false);
                        mCurrentSelectedViewHolder.quantityEditTextExpanded.setText("");
                        mCurrentSelectedViewHolder.productAvailabilityExpanded.setText(product.getStock().getStockLevel() + "\n"
                                + getContext().getResources().getString(R.string.product_detail_in_stock));

                    }

                }

                if (product.isInStock()) {
                    mCurrentSelectedViewHolder.productAvailabilityExpanded.setText(product.getStock().getStockLevel() + "\n"
                            + getContext().getResources().getString(R.string.product_detail_in_stock));
                    mCurrentSelectedViewHolder.productAvailabilityExpanded.setTextColor(getContext().getResources().getColor(
                            R.color.product_item_in_stock));
                    mCurrentSelectedViewHolder.quantityEditTextExpanded.setEnabled(true);

                }


            } else {
                Log.d(TAG, "Stock is null");
            }


            mCurrentSelectedViewHolder.productPriceExpanded.setText((product.getVolumePrices() != null) ? product
                    .getPriceRangeFormattedValue() + " | " : product.getPriceRangeFormattedValue());

            // Set the price with the default total value
            mCurrentSelectedViewHolder.productPriceTotalExpanded.setText((StringUtils.substring(product.getPrice()
                    .getFormattedValue(), 0, 1) + ProductUtils.calculateQuantityPrice(
                    mCurrentSelectedViewHolder.quantityEditTextExpanded.getText().toString(),
                    (product.getVolumePrices() != null) ? ProductUtils.findVolumePrice(
                            mCurrentSelectedViewHolder.quantityEditTextExpanded.getText().toString(), product.getVolumePrices())
                            : product.getPrice())));

            // Loading the product image for expanded view
            loadProductImage(product.getImageThumbnailUrl(), mCurrentSelectedViewHolder.productImageExpanded,
                    mCurrentSelectedViewHolder.productImageLoadingExpanded, product.getCode());

            /**
             * Add to cart when user click on cartIcon in Product item expanded row
             */
            mCurrentSelectedViewHolder.productImageViewCartIconExpanded.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToCart(product.getCode(), mCurrentSelectedViewHolder.quantityEditTextExpanded.getText().toString(),mCurrentSelectedViewHolder);
                    mCurrentSelectedViewHolder.quantityEditTextExpanded.setText(getContext().getString(R.string.default_qty));
                }
            });

            mCurrentSelectedViewHolder.quantityEditTextExpanded.setOnEditorActionListener(new SubmitListener() {

                @Override
                public void onSubmitAction() {
                    // Perform action on key press
                    addToCart(product.getCode(), mCurrentSelectedViewHolder.quantityEditTextExpanded.getText().toString(), mCurrentSelectedViewHolder);
                    mCurrentSelectedViewHolder.quantityEditTextExpanded.setText(getContext().getString(R.string.default_qty));
                }
            });
        }
    }

    /**
     * Get variant from dropdown and display info in product details page
     *
     * @param productCode
     */
    protected void selectVariant(String productCode) {

        getContext().getLoaderManager().restartLoader(0, null, getProductLoaderSelectVariant(productCode, getContext(), CommerceApplication.getContentServiceHelper(), new OnRequestListener() {

            @Override
            public void beforeRequest() {
                // Expanded
                mCurrentSelectedViewHolder.productImageLoadingExpanded.setVisibility(View.VISIBLE);
                mCurrentSelectedViewHolder.productItemStockLevelLoadingExpanded.setVisibility(View.VISIBLE);
                mCurrentSelectedViewHolder.productImageExpanded.setVisibility(View.GONE);
                mCurrentSelectedViewHolder.productAvailabilityExpanded.setVisibility(View.GONE);
                UIUtils.showLoadingActionBar(getContext(), true);
            }

            @Override
            public void afterRequestBeforeResponse() {

            }

            @Override
            public void afterRequest(boolean isDataSynced) {
                mCurrentSelectedViewHolder.productImageLoadingExpanded.setVisibility(View.GONE);
                mCurrentSelectedViewHolder.productItemStockLevelLoadingExpanded.setVisibility(View.GONE);
                mCurrentSelectedViewHolder.productImageExpanded.setVisibility(View.VISIBLE);
                mCurrentSelectedViewHolder.productAvailabilityExpanded.setVisibility(View.VISIBLE);
                mCurrentSelectedViewHolder.productImageLoading.setVisibility(View.GONE);
                UIUtils.showLoadingActionBar(getContext(), false);
            }
        }, new OnProductLoaded() {
            @Override
            public void onProductLoaded(ProductBase productBase, String productCodeFirstVariant) {
                if (productBase != null) {
                    populateProductExpanded(productBase);
                }
            }
        }));

    }

    @Override
    public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
        View view = mInflater.inflate(R.layout.item_product_listview, arg2, false);
        view.setTag(new ProductViewHolder(view));
        return view;
    }

    protected abstract void onItemSpinnerSelected(Spinner spinner, Object matrixElement);

    protected abstract int populateVariants(List<Spinner> spinners, ProductBase product);

    protected abstract ContentLoader getProductLoaderExpandView(ProductBase product, Context context, ContentServiceHelper contentServiceHelper, OnRequestListener onRequestListener, OnProductLoaded onProductLoaded);

    protected abstract ContentLoader getProductLoaderSelectVariant(String productCode, Context context, ContentServiceHelper contentServiceHelper, OnRequestListener onRequestListener, OnProductLoaded onProductLoaded);

    public interface OnProductLoaded {
        void onProductLoaded(ProductBase productBase, String productCodeFirstVariant);
    }
}
