package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for carts requests
 */
public class QueryCarts extends QueryList {

    private boolean savedCartsOnly;

    public boolean isSavedCartsOnly() {
        return savedCartsOnly;
    }

    public void setSavedCartsOnly(boolean savedCartsOnly) {
        this.savedCartsOnly = savedCartsOnly;
    }
}


