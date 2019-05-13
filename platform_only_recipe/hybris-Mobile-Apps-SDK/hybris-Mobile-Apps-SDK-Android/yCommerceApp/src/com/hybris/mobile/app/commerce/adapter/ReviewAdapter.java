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
package com.hybris.mobile.app.commerce.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.Constants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.commerce.data.product.Review;
import com.hybris.mobile.lib.http.utils.RequestUtils;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Adapter for the products of the order
 */
public class ReviewAdapter extends ArrayAdapter<Review> {
    protected static final String TAG = ReviewAdapter.class.getCanonicalName();

    protected List<Review> mReviews;
    protected String mRequestId = RequestUtils.generateUniqueRequestId();

    public ReviewAdapter(Activity context, List<Review> values, String requestId) {
        super(context, R.layout.item_review, values);
        this.mReviews = values;
        this.mRequestId = requestId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_review, parent, false);
            rowView.setTag(new ReviewViewHolder(rowView, position));
        } else {
            rowView = convertView;
        }

        ReviewViewHolder mReviewViewHolder = (ReviewViewHolder) rowView.getTag();

        final Review review = getItem(position);

        if (review != null) {
            mReviewViewHolder.reviewName.setText(review.getPrincipal().getName());

            mReviewViewHolder.reviewComment.setText(review.getComment());
            mReviewViewHolder.reviewHeadline.setText(review.getHeadline());

            // Date reviewed
            if (review.getDate() != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_COMPLETE,
                        SimpleDateFormat.getAvailableLocales()[0]);

                mReviewViewHolder.reviewDate.setText(simpleDateFormat.format(review.getDate()));
            }

            if (review.getRating() != null) {
                mReviewViewHolder.reviewRating.setRating(review.getRating().floatValue());
            }
        }


        return rowView;
    }

    @Override
    public int getCount() {
        return mReviews.size();
    }

    @Override
    public Activity getContext() {
        return (Activity) super.getContext();
    }

    /**
     * Contains all UI elements for Order to improve view display while scrolling
     */
    static class ReviewViewHolder {

        TextView reviewName;
        TextView reviewHeadline;
        TextView reviewComment;
        RatingBar reviewRating;
        TextView reviewDate;

        public ReviewViewHolder(View view, int position) {


            reviewName = (TextView) view.findViewById(R.id.review_name);
            reviewHeadline = (TextView) view.findViewById(R.id.review_headline);
            reviewComment = (TextView) view.findViewById(R.id.review_comment);
            reviewRating = (RatingBar) view.findViewById(R.id.review_rating);
            reviewDate = (TextView) view.findViewById(R.id.review_date);

            reviewName.setContentDescription("review_name" + position);
            reviewHeadline.setContentDescription("review_headline" + position);
            reviewComment.setContentDescription("review_comment" + position);
            reviewRating.setContentDescription("review_rating" + position);
            reviewDate.setContentDescription("review_date" + position);
        }
    }
}
