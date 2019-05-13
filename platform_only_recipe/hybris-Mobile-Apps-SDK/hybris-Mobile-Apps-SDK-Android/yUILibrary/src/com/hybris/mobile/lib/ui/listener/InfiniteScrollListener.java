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
package com.hybris.mobile.lib.ui.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.hybris.mobile.lib.ui.R;


/**
 * Listener for infinite scroll view
 */
public abstract class InfiniteScrollListener implements OnScrollListener {
    private int currentPage = 1;
    private int previousTotalItemCount = 0;
    private boolean loading = true;

    /**
     * Request new items after the list or grid has been scrolled to the end
     *
     * @param page Page number to be loaded
     */
    public abstract void loadNextItems(int page);

    /**
     * Status changed when the list or grid
     * has been scrolled
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    /**
     * Action to be invoked when the list or grid
     * has been scrolled
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        // We don't load when there is just the footer view in the list view
        boolean loadNextItems = !(view instanceof ListView && ((ListView) view).getFooterViewsCount() == totalItemCount);

        if (loadNextItems) {
            // We update the page once we finished loading the dataset
            if (totalItemCount > previousTotalItemCount && loading) {
                loading = false;
                previousTotalItemCount = totalItemCount;
            }

            // Getting the next results
            if ((totalItemCount - visibleItemCount) <= (firstVisibleItem + view.getContext().getResources()
                    .getInteger(R.integer.infinite_scroll_threshold))
                    && !loading) {
                loading = true;
                loadNextItems(currentPage++);
            }
        }

    }

    /**
     * Reset the listener status
     */
    public void reset() {
        loading = true;
        currentPage = 1;
        previousTotalItemCount = 0;
    }

}
