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

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.ReviewAdapter;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.product.Review;
import com.hybris.mobile.lib.commerce.data.product.ReviewList;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import java.util.ArrayList;
import java.util.List;


public class ReviewListFragment extends ListFragment {
    private static final String TAG = ReviewListFragment.class.getCanonicalName();
    private String mReviewListRequestId = RequestUtils.generateUniqueRequestId();
    public static final String REVIEWS_PRODUCT_CODE = "REVIEWS_PRODUCT_CODE";

    private List<Review> mListReview;
    private ReviewAdapter mReviewAdapter;

    public static ReviewListFragment newInstance() {
        return new ReviewListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_review_list, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        QueryProduct queryProduct = new QueryProduct();
        queryProduct.setCode(bundle.getString(REVIEWS_PRODUCT_CODE));

        CommerceApplication.getContentServiceHelper().getProductReviews(new ResponseReceiver<ReviewList>() {

            @Override
            public void onResponse(Response<ReviewList> response) {
                mReviewAdapter = new ReviewAdapter(getActivity(), new ArrayList<Review>(), mReviewListRequestId);
                mListReview = new ArrayList<>();
                setListAdapter(mReviewAdapter);

                if (response.getData().getReviews() != null) {
                    mListReview = response.getData().getReviews();
                }

                mReviewAdapter.clear();
                mReviewAdapter.addAll(mListReview);
                mReviewAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError(Response<ErrorList> response) {
                Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));

            }
        }, null, queryProduct, false, null, null);
    }


    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mReviewListRequestId);
    }

}
