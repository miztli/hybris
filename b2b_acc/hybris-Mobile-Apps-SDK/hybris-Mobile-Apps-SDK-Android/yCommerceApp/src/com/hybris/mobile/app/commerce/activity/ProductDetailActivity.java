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
package com.hybris.mobile.app.commerce.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.ProductDetailFragmentBase.OnReviewClickListener;
import com.hybris.mobile.app.commerce.fragment.ReviewListFragment;


/**
 * Show more information for a specific product from the product list
 */
public class ProductDetailActivity extends MainActivity implements OnReviewClickListener {

    FragmentTransaction mFragmentTransaction;
    ReviewListFragment mReviewListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_product_detail);
        super.onCreate(savedInstanceState);
        mReviewListFragment = ReviewListFragment.newInstance();
    }


    @Override
    public void onReviewListButtonClicked(String productCode) {
        Bundle bundle = new Bundle();
        bundle.putString(ReviewListFragment.REVIEWS_PRODUCT_CODE, productCode );
        mReviewListFragment.setArguments(bundle);

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.review_layout, mReviewListFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }
}
