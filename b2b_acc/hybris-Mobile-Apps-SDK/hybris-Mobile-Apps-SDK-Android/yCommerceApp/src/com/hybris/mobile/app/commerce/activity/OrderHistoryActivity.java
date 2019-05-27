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

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;

import org.apache.commons.lang3.StringUtils;


/**
 * Orders
 */
public class OrderHistoryActivity extends MainActivity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_order_history);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        // Search query, we redirect to the order details page
        if (intent != null && StringUtils.isNotBlank(intent.getStringExtra(SearchManager.QUERY))) {
            Intent newIntent = new Intent(this, OrderDetailActivity.class);
            newIntent.putExtra(IntentConstants.ORDER_CODE, intent.getStringExtra(SearchManager.QUERY));
            newIntent.putExtra(IntentConstants.ORDER_FROM_SEARCH, true);
            startActivity(newIntent);
        }

    }
}
