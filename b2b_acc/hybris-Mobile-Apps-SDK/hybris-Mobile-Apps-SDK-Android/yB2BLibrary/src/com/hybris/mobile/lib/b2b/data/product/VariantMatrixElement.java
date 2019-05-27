/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 20-Mar-2015 11:58:41 AM
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
package com.hybris.mobile.lib.b2b.data.product;

import com.hybris.mobile.lib.commerce.data.product.VariantMatrixElementBase;
import java.util.List;

public class VariantMatrixElement extends VariantMatrixElementBase {

    private List<VariantMatrixElement> elements;
    private VariantValueCategory variantValueCategory;

    public List<VariantMatrixElement> getElements() {
        return elements;
    }

    public void setElements(List<VariantMatrixElement> elements) {
        this.elements = elements;
    }

    public VariantValueCategory getVariantValueCategory() {
        return variantValueCategory;
    }

    public void setVariantValueCategory(VariantValueCategory variantValueCategory) {
        this.variantValueCategory = variantValueCategory;
    }
}