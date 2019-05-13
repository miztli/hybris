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

package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for stores requests
 */
public class QueryStores extends QueryList {
    private String searchText;
    private QueryLocation location;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public QueryLocation getLocation() {
        return location;
    }

    public void setLocation(QueryLocation location) {
        this.location = location;
    }

}
