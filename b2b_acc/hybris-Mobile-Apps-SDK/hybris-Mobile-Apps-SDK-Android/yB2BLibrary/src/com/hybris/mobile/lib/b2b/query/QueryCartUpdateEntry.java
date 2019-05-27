package com.hybris.mobile.lib.b2b.query;

import com.hybris.mobile.lib.commerce.query.QueryCartEntry;

/**
 * Query object for updating cart entry requests
 */
public class QueryCartUpdateEntry extends QueryCartEntry {

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
