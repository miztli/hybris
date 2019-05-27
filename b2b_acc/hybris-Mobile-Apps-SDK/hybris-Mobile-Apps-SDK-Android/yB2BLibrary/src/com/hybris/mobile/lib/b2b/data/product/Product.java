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

import com.hybris.mobile.lib.commerce.data.product.ProductBase;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Product extends ProductBase {

    private List<VariantMatrixElement> variantMatrix;
    private String firstVariantImage;
    private String firstVariantCode;

    public List<VariantMatrixElement> getVariantMatrix() {
        return variantMatrix;
    }

    public void setVariantMatrix(List<VariantMatrixElement> variantMatrix) {
        this.variantMatrix = variantMatrix;
    }

    public String getFirstVariantCode() {
        return firstVariantCode;
    }

    public void setFirstVariantCode(String firstVariantCode) {
        this.firstVariantCode = firstVariantCode;
    }

    public String getFirstVariantImage() {
        return firstVariantImage;
    }

    public void setFirstVariantImage(String firstVariantImage) {
        this.firstVariantImage = firstVariantImage;
    }

    public String getImageThumbnailUrl() {

        String thumbnail = super.getImageThumbnailUrl();

        if (StringUtils.isEmpty(thumbnail)) {
            thumbnail = getFirstVariantImage();
        }

        return thumbnail;

    }
}