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

import android.app.Fragment;
import android.os.Bundle;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.CatalogContentFragment;
import com.hybris.mobile.app.commerce.fragment.CatalogMenuFragment.OnCategorySelectedListener;
import com.hybris.mobile.lib.commerce.data.catalog.CategoryHierarchy;


/**
 * Activity for the catalog section
 */
public class CatalogActivity extends MainActivity implements OnCategorySelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        disableMainMenuSwipe();
        setContentView(R.layout.activity_catalog);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCategorySelected(CategoryHierarchy category) {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.catalog_content_fragment);

        if (fragment != null && fragment instanceof CatalogContentFragment) {
            // Send the category id to the content fragment
            ((CatalogContentFragment) fragment).onCategorySelected(category);
        }
    }

}
