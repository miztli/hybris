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

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.CartHelperBase;
import com.hybris.mobile.app.commerce.helper.CartHelperBase.OnAddToCart;
import com.hybris.mobile.app.commerce.utils.ProductUtils;
import com.hybris.mobile.app.commerce.utils.RegexUtils;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.data.product.Image;
import com.hybris.mobile.lib.commerce.data.product.Price;
import com.hybris.mobile.lib.commerce.data.product.ProductBase;
import com.hybris.mobile.lib.commerce.loader.ContentLoader;
import com.hybris.mobile.lib.commerce.loader.ProductLoaderBase;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.listener.SubmitListener;
import com.hybris.mobile.lib.ui.view.ZoomImageView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Container that handle_anchor the details information for a specific product
 */
public abstract class ProductDetailFragmentBase extends Fragment {
    protected static final String TAG = ProductDetailFragmentBase.class.getCanonicalName();

    private static final String SAVED_INSTANCE_PRODUCT_CODE = "SAVED_INSTANCE_PRODUCT_CODE";
    /**
     * Define action when add to cart button is clicked then put the current product in the cart with price, quantity and
     * update the availability
     */
    public OnClickListener addToCartButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            addToCart();

        }
    };
    protected String mProductDetailRequestId = RequestUtils.generateUniqueRequestId();
    protected ProductBase mProduct;
    /**
     * Detect when text is changed
     */
    protected TextWatcher quantityEditTextTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mProduct != null) {
                mTotalPriceText
                        .setText((StringUtils.substring(mProduct.getPrice().getFormattedValue(), 0, 1) + ProductUtils
                                .calculateQuantityPrice(
                                        mQuantityEditText.getText().toString(),
                                        (mProduct.getVolumePrices() != null) ? ProductUtils.findVolumePrice(mQuantityEditText
                                                .getText().toString(), mProduct.getVolumePrices()) : mProduct.getPrice())));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            setClickableAddToCartButton();
            mQuantityEditText.setBackgroundResource(R.drawable.quantity_editext_selector);
        }

    };
    protected ImageButton mCloseProductDetailButton;
    protected TextView mProductDetaiNameText;
    protected ImageButton mOrderFormButton;
    protected View mNoImage;
    protected ViewPager mViewPager;
    protected ImagePagerAdapter mImageAdapter;
    protected LinearLayout mLayoutIndicator;
    protected TextView mProductPrice;
    protected Button mVolumePricingExpandableButton;
    protected TableLayout mVolumePricingExpandableLayout;
    protected RatingBar mRatingBar;
    protected TextView mReviews;

    protected OnReviewClickListener mActivity;

    public interface OnReviewClickListener {

        void onReviewListButtonClicked(String productCode);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mActivity = (OnReviewClickListener) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

    }



    /**
     * Define action when Volume Pricing is clicked
     */
    protected OnClickListener expandableLayoutListener = new OnClickListener() {

        @Override
        public void onClick(View v) {

            if (mVolumePricingExpandableLayout.getVisibility() == View.GONE) {
                UIUtils.expandLayout(getActivity(), mVolumePricingExpandableLayout);

                createVolumePricingTable(mVolumePricingExpandableLayout);

                mVolumePricingExpandableLayout.setVisibility(View.VISIBLE);
                mVolumePricingExpandableButton.setBackgroundColor(getResources().getColor(
                        R.color.product_detail_expandable_background));
                mVolumePricingExpandableLayout.setBackgroundColor(getResources().getColor(
                        R.color.product_detail_expandable_background));
                mProductPrice.setBackgroundColor(getResources().getColor(R.color.product_detail_expandable_background));
            } else {
                mVolumePricingExpandableLayout.removeAllViews();
                UIUtils.collapseLayout(getActivity(), mVolumePricingExpandableLayout);
                mVolumePricingExpandableButton.setBackgroundColor(Color.WHITE);
                mVolumePricingExpandableLayout.setBackgroundColor(Color.WHITE);

                mProductPrice.setBackgroundColor(Color.WHITE);
                mVolumePricingExpandableLayout.setVisibility(View.GONE);
            }
        }
    };
    protected TextView mProductShortDescription;
    protected EditText mQuantityEditText;
    protected TextView mStocklevelText;
    protected TextView mTotalPriceText;
    protected LinearLayout mAddToCartButton;
    protected TextView mProductDetailAddToCartText;
    protected Button mProductDetailExpandableButton;
    protected TextView mProductDetailExpandableText;
    protected Button mDeliveryExpandableButton;
    protected TextView mDeliveryExpandableText;
    protected LinearLayout mProductDetailDescriptionLayout;
    protected Spinner mProductDetailVariantSpinner1;
    protected Spinner mProductDetailVariantSpinner2;
    protected Spinner mProductDetailVariantSpinner3;
    protected List<Spinner> mSpinnersVariants;
    protected ProgressBar mStocklevelTextLoading;
    // Zoomed UI
    protected ScrollView mProductDetailScrollView;
    protected LinearLayout mScrollViewLayout;
    protected LinearLayout mImageLayout;
    protected LinearLayout mMiddleSection;
    protected LinearLayout mBottomSection;
    protected View mViewDivider;
    protected int mCurrentIndicator = 0;
    /**
     * Prepare and create user interaction element from view
     */
    protected OnPageChangeListener imageViewPagerOnPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrollStateChanged(int position) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {

            mCurrentIndicator = position;

            for (int i = 0; i < mImageAdapter.getCount(); i++) {

                if (mCurrentIndicator == i) {
                    mLayoutIndicator.findViewById(i).setEnabled(false);
                } else {
                    if (mLayoutIndicator.findViewById(i) != null) {
                        mLayoutIndicator.findViewById(i).setEnabled(true);
                    }
                }
            }
        }

    };
    protected ContentLoader mProductLoader;
    protected QueryProduct mQueryProduct;
    protected boolean mVariantPopulated = false;
    protected int mNbVariantLevels = 0;
    protected int mNbVariantLevelsInstantiated = 0;

    /**
     * Define Action when cross button is clicked and quit the current product detail activity
     */
    protected OnClickListener exitProductDetailButtonListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            getActivity().onBackPressed();
        }
    };
    /**
     * Define Action when cross button is clicked and go back to product detail of the current zoomed product
     */
    protected OnClickListener quitZoomButtonListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            zoomImage(false);
            updateImageViewPagerIndicator(mProduct.getImagesGallery());
            mCloseProductDetailButton.setOnClickListener(exitProductDetailButtonListener);
        }
    };
    /**
     * Display the order form
     */
    protected OnClickListener orderFormButtonListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "Order Form", Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Define action when image view pager is touched
     */
    protected OnTouchListener imageViewPagerOnTouchListener = new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v.getParent().requestDisallowInterceptTouchEvent(true);
            v.performClick();
            return false;
        }
    };
    /**
     * Define action when add to cart button is focused then set quantity to add to cart and update current availability
     * and closed the keyboard
     */
    protected OnFocusChangeListener quantityEditTextListener = new OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!mQuantityEditText.hasFocus()) {
                UIUtils.hideKeyboard(getActivity());
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);


        // Initialize View by linking and giving instance to xml element in the
        // layout
        mCloseProductDetailButton = (ImageButton) view.findViewById(R.id.product_detail_exit);
        mProductDetaiNameText = (TextView) view.findViewById(R.id.product_detail_name);
        mOrderFormButton = (ImageButton) view.findViewById(R.id.product_detail_order_form);
        mViewPager = (ViewPager) view.findViewById(R.id.product_detail_view_pager);
        mImageAdapter = new ImagePagerAdapter(new ArrayList<Image>());
        mLayoutIndicator = (LinearLayout) view.findViewById(R.id.product_detail_view_pager_indicator_bar);
        mProductPrice = (TextView) view.findViewById(R.id.product_detail_volume_price);
        mVolumePricingExpandableButton = (Button) view.findViewById(R.id.product_detail_volume_pricing_button);
        mVolumePricingExpandableLayout = (TableLayout) view.findViewById(R.id.product_detail_volume_pricing_table_layout);
        mProductDetailDescriptionLayout = (LinearLayout) view.findViewById(R.id.product_detail_description_layout);
        mProductShortDescription = (TextView) view.findViewById(R.id.product_detail_short_description);
        mStocklevelText = (TextView) view.findViewById(R.id.product_detail_stocklevel_text);
        mTotalPriceText = (TextView) view.findViewById(R.id.product_detail_total_price_text);
        mQuantityEditText = (EditText) view.findViewById(R.id.product_detail_quantity_editText);
        mAddToCartButton = (LinearLayout) view.findViewById(R.id.product_detail_add_to_cart_layout_button);
        mProductDetailAddToCartText = (TextView) view.findViewById(R.id.product_detail_add_to_cart_text);
        mProductDetailExpandableButton = (Button) view.findViewById(R.id.product_detail_expandable_button);
        mProductDetailExpandableText = (TextView) view.findViewById(R.id.product_detail_expandable_text);
        mDeliveryExpandableButton = (Button) view.findViewById(R.id.product_detail_delivery_expandable_button);
        mDeliveryExpandableText = (TextView) view.findViewById(R.id.product_detail_delivery_expandable_text);
        mProductDetailVariantSpinner1 = (Spinner) view.findViewById(R.id.product_detail_variant_spinner_1);
        mProductDetailVariantSpinner2 = (Spinner) view.findViewById(R.id.product_detail_variant_spinner_2);
        mProductDetailVariantSpinner3 = (Spinner) view.findViewById(R.id.product_detail_variant_spinner_3);
        mStocklevelTextLoading = (ProgressBar) view.findViewById(R.id.product_detail_stocklevel_text_loading);
        mNoImage = view.findViewById(R.id.product_item_no_image);
        mRatingBar = (RatingBar)view.findViewById(R.id.product_detail_rating);
        mReviews = (TextView)view.findViewById(R.id.product_detail_reviews);

        mReviews.setOnClickListener(mReviewOnClickListener);

        // Zoom UI
        mProductDetailScrollView = (ScrollView) view.findViewById(R.id.product_detail_scrollView);
        mScrollViewLayout = (LinearLayout) view.findViewById(R.id.product_detail_scrollView_layout);
        mImageLayout = (LinearLayout) view.findViewById(R.id.product_detail_image_layout);
        mMiddleSection = (LinearLayout) view.findViewById(R.id.product_detail_middle_section);
        mBottomSection = (LinearLayout) view.findViewById(R.id.product_detail_bottom_section);
        mViewDivider = view.findViewById(R.id.product_detail_middle_divider);

        // Only show description when not blank
        mProductDetailDescriptionLayout.setVisibility(View.GONE);

        // Listener
        mCloseProductDetailButton.setOnClickListener(exitProductDetailButtonListener);
        mOrderFormButton.setOnClickListener(orderFormButtonListener);
        mViewPager.setOnTouchListener(imageViewPagerOnTouchListener);
        mViewPager.addOnPageChangeListener(imageViewPagerOnPageChangeListener);
        mVolumePricingExpandableButton.setOnClickListener(expandableLayoutListener);
        mProductDetailExpandableButton.setOnClickListener(new ExpandablePanelListener(mProductDetailExpandableButton,
                mProductDetailExpandableText));
        mDeliveryExpandableButton
                .setOnClickListener(new ExpandablePanelListener(mDeliveryExpandableButton, mDeliveryExpandableText));
        mQuantityEditText.setOnFocusChangeListener(quantityEditTextListener);
        mAddToCartButton.setOnClickListener(addToCartButtonListener);

        mProductDetailVariantSpinner1.setOnItemSelectedListener(getVariantSpinnerListener());
        mProductDetailVariantSpinner2.setOnItemSelectedListener(getVariantSpinnerListener());
        mProductDetailVariantSpinner3.setOnItemSelectedListener(getVariantSpinnerListener());

        mSpinnersVariants = new ArrayList<>();
        mSpinnersVariants.add(mProductDetailVariantSpinner1);
        mSpinnersVariants.add(mProductDetailVariantSpinner2);
        mSpinnersVariants.add(mProductDetailVariantSpinner3);

        mQuantityEditText.addTextChangedListener(quantityEditTextTextWatcher);
        mQuantityEditText.setOnEditorActionListener(new SubmitListener() {
            @Override
            public void onSubmitAction() {
                addToCart();
            }
        });

        // When clicking outside a EditText, hide keyboard, remove focus and
        // reset to the default value
        // Clicking on the main view
        view.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                UIUtils.hideKeyboard(getActivity());
                mQuantityEditText.clearFocus();
                v.performClick();
                return false;
            }
        });

        Intent intentCaller = getActivity().getIntent();

        // Query object to get the products details
        mQueryProduct = new QueryProduct();

        if (intentCaller.hasExtra(IntentConstants.PRODUCT_CODE)) {
            mQueryProduct.setCode(getActivity().getIntent().getStringExtra(IntentConstants.PRODUCT_CODE));
        } else if (StringUtils.equals(intentCaller.getAction(), Intent.ACTION_VIEW)) {
            mQueryProduct.setCode(RegexUtils.getProductCode(intentCaller.getDataString()));
        }

        // Restore the current spinner selection
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(SAVED_INSTANCE_PRODUCT_CODE)) {
                mQueryProduct.setCode(savedInstanceState.getString(SAVED_INSTANCE_PRODUCT_CODE, null));
            }
        }

        mProductLoader = getProductLoader(getActivity(), CommerceApplication.getContentServiceHelper(), mQueryProduct, new OnRequestListener() {

            @Override
            public void beforeRequest() {
                afterBeforeRequest(true);
            }

            @Override
            public void afterRequestBeforeResponse() {

            }

            @Override
            public void afterRequest(boolean isDataSynced) {
                afterBeforeRequest(false);
            }
        });


        return view;
    }

    protected abstract ContentLoader getProductLoader(Context context, ContentServiceHelper contentServiceHelper, QueryProduct queryProduct, OnRequestListener onRequestListener);

    protected abstract OnItemSelectedListener getVariantSpinnerListener();

    @Override
    public void onResume() {
        super.onResume();

        // Start the loader
        getLoaderManager().restartLoader(0, null, mProductLoader);

        if (CommerceApplication.isOnline()) {
            mNoImage.setVisibility(View.GONE);
            mImageLayout.setVisibility(View.VISIBLE);
        } else {
            mNoImage.setVisibility(View.VISIBLE);
            mImageLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mProduct != null) {
            outState.putString(SAVED_INSTANCE_PRODUCT_CODE, mProduct.getCode());
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Before/After requests actions
     *
     * @param isBefore
     */
    protected void afterBeforeRequest(boolean isBefore) {
        if (mProduct != null) {
            mStocklevelTextLoading.setVisibility(isBefore ? View.VISIBLE : View.INVISIBLE);
            mStocklevelText.setVisibility(isBefore ? View.INVISIBLE : View.VISIBLE);
        }

        // Before the request we disable the edit text for the quantity and the add to cart button
        if (isBefore) {
            mQuantityEditText.setText("");
            setClickableAddToCartButton();
        }

        UIUtils.showLoadingActionBar(getActivity(), isBefore);
    }

    /**
     * Get variant from dropdown and display info in product details page
     *
     * @param productCode
     */
    protected void selectVariant(String productCode) {
        if (StringUtils.isNotBlank(productCode)) {
            QueryProduct queryProduct = new QueryProduct();
            queryProduct.setCode(productCode);

            ((ProductLoaderBase) mProductLoader).setQuery(queryProduct);
            getLoaderManager().restartLoader(0, null, mProductLoader);
        }
    }

    /**
     * Populate the product
     *
     * @param product
     */
    protected void populateProduct(ProductBase product) {
        if (product != null) {

            mProduct = product;

            /**
             * Populate the view with data from response and associate it to the right element in the view
             */
            mProductDetaiNameText.setText(product.getName() + " (" + product.getCode() + ")");

            if (StringUtils.isNotBlank(product.getDescription())) {

                mProductDetailExpandableText.setText(Html.fromHtml(product.getDescription()));
            }

            if (StringUtils.isNotBlank(product.getSummary())) {
                mProductDetailDescriptionLayout.setVisibility(View.VISIBLE);
                mProductShortDescription.setText(Html.fromHtml(product.getSummary()));
            }

            if (product.getStock() != null) {

                boolean resetAddToCart = true;

                mStocklevelText.setVisibility(View.VISIBLE);
                if (product.isLowStock() || product.isOutOfStock()) {
                    mStocklevelText.setTextColor(getResources().getColor(R.color.product_item_low_stock));
                    mStocklevelText.setContentDescription(getString(R.string.product_item_low_stock));

                    if (product.isOutOfStock()) {
                        resetAddToCart = false;
                        mQuantityEditText.setEnabled(false);
                        mQuantityEditText.setText("");
                        mStocklevelText
                                .setText(product.getStock().getStockLevel() + "\n" + getString(R.string.product_detail_in_stock));
                    }
                }

                if (product.isInStock()) {
                    mStocklevelText.setText(product.getStock().getStockLevel() + "\n" + getString(R.string.product_detail_in_stock));
                    mStocklevelText.setTextColor(getResources().getColor(R.color.product_item_in_stock));
                }

                if (resetAddToCart) {
                    mQuantityEditText.setEnabled(true);
                    mQuantityEditText.setText(getString(R.string.default_qty));
                }

            } else {
                Log.d(TAG, "Stock is null");
            }

            if (product.getPrice() != null) {
                // to show pipe
                mProductPrice.setText((product.getVolumePrices() != null) ? product.getPriceRangeFormattedValue() + " | " : product
                        .getPriceRangeFormattedValue());

                // Set the price with the default total value with currency sign
                mTotalPriceText.setText((StringUtils.substring(product.getPrice().getFormattedValue(), 0, 1) + ProductUtils
                        .calculateQuantityPrice(
                                mQuantityEditText.getText().toString(),
                                (product.getVolumePrices() != null) ? ProductUtils.findVolumePrice(
                                        mQuantityEditText.getText().toString(), product.getVolumePrices()) : product.getPrice())));
            } else {
                Log.d(TAG, "Price is null");
            }

            if (product.getVolumePrices() != null) {
                mVolumePricingExpandableButton.setVisibility(View.VISIBLE);

            }

            //Rating
            if(product.getAverageRating() != null){
                mRatingBar.setVisibility(View.VISIBLE);
                mRatingBar.setRating(product.getAverageRating().floatValue());
            }
            else{
                mRatingBar.setVisibility(View.GONE);
            }

            //Reviews
            if(product.getReviews() != null && !product.getReviews().isEmpty()){
                mReviews.setVisibility(View.VISIBLE);
                mReviews.setText(getString(R.string.product_detail_reviews, product.getNumberOfReviews()));
            }
            else{
                mReviews.setVisibility(View.GONE);
            }

            setClickableAddToCartButton();

            // Updating images
            updateImageViewPagerIndicator(product.getImagesGallery());

        }
    }

    /**
     * Update the view pager for the images
     */
    protected void updateImageViewPagerIndicator(List<Image> images) {
        mImageAdapter.clear();
        mImageAdapter.addAll(images);
        mViewPager.setAdapter(mImageAdapter);
        mViewPager.setCurrentItem(mCurrentIndicator);
        mImageAdapter.notifyDataSetChanged();

        // for each image we create a matched indicator button with its listener
        for (int i = 0; i < mImageAdapter.getCount(); i++) {
            Button indicatorBtn = (Button) LayoutInflater.from(this.getActivity()).inflate(R.layout.viewpager_indicator_button,
                    mLayoutIndicator, false);
            if (mLayoutIndicator.findViewById(i) == null) {

                indicatorBtn.setId(i);

                indicatorBtn.setContentDescription("product_detail_image_indicator" + i);
                mLayoutIndicator.addView(indicatorBtn);

                mLayoutIndicator.findViewById(i).setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        mViewPager.setCurrentItem(v.getId());
                        v.performClick();
                        return false;
                    }
                });
            }
        }


        if (mLayoutIndicator.findViewById(mViewPager.getCurrentItem()) != null) {
            mLayoutIndicator.findViewById(mViewPager.getCurrentItem()).setEnabled(false);
        }

    }

    /**
     * Create table to show data in a table
     *
     * @param volumePricingTable : Table which contains from volume pricing for the current product
     */
    protected void createVolumePricingTable(TableLayout volumePricingTable) {
        if (mProduct.getVolumePrices() != null) {
            TableRow headerRow = new TableRow(getActivity());

            TextView header1 = new TextView(getActivity());
            header1.setText(getString(R.string.product_detail_volume_qty));
            header1.setTypeface(null, Typeface.BOLD);
            headerRow.addView(header1);

            TextView header2 = new TextView(getActivity());
            header2.setText(getString(R.string.product_detail_volume_price));
            header2.setTypeface(null, Typeface.BOLD);
            headerRow.addView(header2);

            if (mProduct.getVolumePrices().size() > 5) {
                TextView header3 = new TextView(getActivity());
                header3.setText(getString(R.string.product_detail_volume_qty));
                header3.setTypeface(null, Typeface.BOLD);
                headerRow.addView(header3);

                TextView header4 = new TextView(getActivity());
                header4.setText(getString(R.string.product_detail_volume_price));
                header4.setTypeface(null, Typeface.BOLD);
                headerRow.addView(header4);
            }
            volumePricingTable.addView(headerRow);

            for (Price volumePrice : mProduct.getVolumePrices()) {
                TableRow contentRow = new TableRow(getActivity());

                if (volumePrice != null) {
                    TextView content1 = new TextView(getActivity());
                    content1.setText(volumePrice.getMinQuantity() + " - " + volumePrice.getMaxQuantity());
                    contentRow.addView(content1);

                    TextView content2 = new TextView(getActivity());
                    content2.setText(volumePrice.getFormattedValue());
                    contentRow.addView(content2);

                    if (mProduct.getVolumePrices().size() > 5) {
                        TextView content3 = new TextView(getActivity());
                        content3.setText(volumePrice.getMinQuantity() + " - " + volumePrice.getMaxQuantity());
                        contentRow.addView(content3);

                        TextView content4 = new TextView(getActivity());
                        content4.setText(volumePrice.getFormattedValue());
                        contentRow.addView(content4);
                    }
                } else {
                    Log.d(TAG, "Price or Stock is null");
                }

                volumePricingTable.addView(contentRow);
            }
        }

    }

    /**
     * Enable Add to cart button when text is entered in quantity field
     */
    protected void setClickableAddToCartButton() {
        boolean enable = false;

        if (CommerceApplication.isOnline()) {
            try {
                enable = (mQuantityEditText.getText() != null && !mQuantityEditText.getText().toString().isEmpty()
                        && StringUtils.isNotBlank(mQuantityEditText.getText().toString()) && Integer.parseInt(mQuantityEditText.getText()
                        .toString()) > 0) && mProduct != null && !mProduct.isOutOfStock();
            } catch (NumberFormatException e) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
        // Offline we disable the add to cart and the quantity
        else {
            mQuantityEditText.setEnabled(false);
            enable = false;
        }

        enableAddToCartButton(enable);
    }

    /**
     * Enable / disable the add to cart button
     *
     * @param enable
     */
    protected void enableAddToCartButton(boolean enable) {
        mAddToCartButton.setEnabled(enable);
        mAddToCartButton.setClickable(enable);
        mProductDetailAddToCartText.setEnabled(enable);
    }

    /**
     * Hide UI element to only display Image ViewPager to allow interaction with the ImageView
     *
     * @param isZoomed Zoom to ImageView other wise reset image
     */
    protected void zoomImage(boolean isZoomed) {
        final ZoomImageView zoomImageView = new ZoomImageView(getActivity());
        zoomImageView.setScaleType(ZoomImageView.ScaleType.CENTER_INSIDE);
        zoomImageView.setClickable(true);
        zoomImageView.setFocusableInTouchMode(true);
        zoomImageView.setVisibility(View.GONE);
        zoomImageView.setContentDescription("product_detail_zoom_image_view");

        if (!mProduct.getImagesGallery().isEmpty() && mCurrentIndicator < mProduct.getImagesGallery().size()
                && StringUtils.isNotBlank(mProduct.getImagesGallery().get(mCurrentIndicator).getUrl())) {
            CommerceApplication.getContentServiceHelper().loadImage(
                    mProduct.getImagesGallery().get(mCurrentIndicator).getUrl(), null, zoomImageView, 0, 0, true, null,
                    false);
        }

        if (isZoomed) {
            getActivity().getActionBar().hide();

            mProductDetailScrollView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            mScrollViewLayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            mImageLayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            mImageLayout.setGravity(Gravity.CENTER);

            zoomImageView.setVisibility(View.VISIBLE);
            mLayoutIndicator.setVisibility(View.GONE);
            mImageLayout.addView(zoomImageView);
            mViewPager.setVisibility(View.GONE);
            mMiddleSection.setVisibility(View.GONE);
            mBottomSection.setVisibility(View.GONE);
            mViewDivider.setVisibility(View.GONE);
        } else {
            getActivity().getActionBar().show();

            mProductDetailScrollView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            mScrollViewLayout.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            mImageLayout.getLayoutParams().height = (int) getResources().getDimension(R.dimen.product_detail_viewpager_height);

            mImageLayout.removeAllViewsInLayout();
            mImageLayout.addView(mViewPager);
            mImageLayout.addView(mLayoutIndicator);
            mLayoutIndicator.setVisibility(View.VISIBLE);
            mViewPager.setVisibility(View.VISIBLE);
            mMiddleSection.setVisibility(View.VISIBLE);
            mBottomSection.setVisibility(View.VISIBLE);
            mViewDivider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mProductDetailRequestId);
    }

    protected void addToCart() {
        try {
            int quantity = Integer.parseInt(mQuantityEditText.getText().toString());

            CartHelperBase.addToCart(getActivity(), mProductDetailRequestId, new OnAddToCart() {

                @Override
                public void onAddToCart(CartModification productAdded) {

                    if (productAdded.isOutOfStock()) {
                        enableAddToCartButton(false);
                    } else if (productAdded.isQuantityAddedNotFulfilled()) {
                        mQuantityEditText.setText(productAdded.getQuantityAdded() + "");
                    } else {
                        mQuantityEditText.setText(getString(R.string.default_qty));
                    }

                    UIUtils.hideKeyboard(getActivity());

                }

                @Override
                public void onAddToCartError(boolean isOutOfStock) {
                    mQuantityEditText.setBackgroundResource(R.drawable.quantity_editext_invalid);
                    enableAddToCartButton(!isOutOfStock);
                    UIUtils.hideKeyboard(getActivity());
                }

            }, mProduct.getCode(), quantity, Arrays.asList(mAddToCartButton, mProductDetailAddToCartText), null);

        } catch (NumberFormatException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    /**
     * Display an image in a view pager style and show tab indicator for this selected image
     */
    protected class ImagePagerAdapter extends PagerAdapter {
        protected List<Image> imagesUrl;

        public ImagePagerAdapter(List<Image> imagesUrl) {
            this.imagesUrl = imagesUrl;
        }

        public void clear() {
            imagesUrl.clear();
        }

        public void addAll(List<Image> listToAdd) {
            imagesUrl.addAll(listToAdd);
        }

        @Override
        public int getCount() {
            return imagesUrl.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            if (!imagesUrl.isEmpty() && position < imagesUrl.size() && StringUtils.isNotBlank(imagesUrl.get(position).getUrl())) {
                CommerceApplication.getContentServiceHelper().loadImage(imagesUrl.get(position).getUrl(), null, imageView, 0, 0, true,
                        null, false);
                imageView.setContentDescription("product_detail_image_viewer" + position);
            }

            mViewPager.addView(imageView, 0);

            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    zoomImage(true);
                    mCloseProductDetailButton.setOnClickListener(quitZoomButtonListener);
                }
            });

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            mViewPager.removeView((ImageView) object);
        }
    }

    /**
     * Handle user interaction to collapse or handle_anchor expandable panel
     */
    protected class ExpandablePanelListener implements OnClickListener {
        Button expandableButton;
        TextView expandableTextView;

        public ExpandablePanelListener(Button expandableButton, TextView expandableTextView) {
            this.expandableButton = expandableButton;
            this.expandableTextView = expandableTextView;
        }

        @Override
        public void onClick(View v) {
            if (mProduct != null) {
                if (this.expandableTextView.getVisibility() == View.GONE) {
                    UIUtils.expandLayout(getActivity(), expandableTextView);
                    this.expandableButton.setBackgroundColor(Color.WHITE);
                    Drawable icon = getActivity().getResources().getDrawable(R.drawable.minus_icon);
                    this.expandableButton.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null);
                    this.expandableTextView.setVisibility(View.VISIBLE);
                } else {
                    UIUtils.collapseLayout(getActivity(), expandableTextView);

                    this.expandableButton.setBackgroundColor(getResources().getColor(R.color.product_detail_expandable_background));
                    Drawable icon = getActivity().getResources().getDrawable(R.drawable.plus_icon);
                    this.expandableButton.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null);
                    this.expandableTextView.setVisibility(View.GONE);
                }
            }
        }
    }


    public View.OnClickListener mReviewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mImageLayout.setVisibility(View.GONE);
            mActivity.onReviewListButtonClicked(mProduct.getCode());
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }


}
