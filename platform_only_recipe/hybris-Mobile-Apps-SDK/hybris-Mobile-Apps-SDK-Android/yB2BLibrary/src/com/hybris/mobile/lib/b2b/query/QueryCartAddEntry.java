package com.hybris.mobile.lib.b2b.query;

import com.hybris.mobile.lib.commerce.query.QueryCartEntry;

/**
 * Query object for adding cart entry requests
 */
public class QueryCartAddEntry extends QueryCartEntry {

    private String product;
    private int quantity;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
