/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 1, 2015 2:19:46 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.b2b.data.search.facetdata;

import com.hybris.mobile.lib.commerce.data.search.facetdata.ProductSearchPageBase;

import com.hybris.mobile.lib.b2b.data.product.Product;

import java.util.List;

/**
 * POJO containing the result page for product search.
 */
public class ProductSearchPage extends ProductSearchPageBase {

    private List<Product> products;

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

}