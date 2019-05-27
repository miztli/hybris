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
import android.content.Intent;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.CatalogContentFragmentBase;
import com.hybris.mobile.app.commerce.fragment.CatalogMenuFragment;


/**
 * Activity to search on the catalog - same as CatalogActivity but in singleTop launch mode
 */
public class SearchCatalogActivity extends CatalogActivity implements CatalogContentFragmentBase.OnSearchRequestListener {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public void onSearchRequest() {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.catalog_menu_fragment);

        if (fragment != null && fragment instanceof CatalogMenuFragment) {
            // We disable the open by default when we come from a search request
            ((CatalogMenuFragment) fragment).disableDefaultOpening();

            // Trigger the search request event on the catalog menu
            ((CatalogMenuFragment) fragment).onSearchRequest();
        }
    }

}
