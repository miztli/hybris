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
package com.hybris.mobile.lib.commerce.data.product;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

public class Product extends ProductBase {

    private List<VariantMatrixElement> variantMatrix;
    private String firstVariantImage;

    public String getFirstVariantImage() {
        return firstVariantImage;
    }

    public void setFirstVariantImage(String firstVariantImage) {
        this.firstVariantImage = firstVariantImage;
    }

    public String getImageThumbnailUrl() {

        String thumbnail = getFirstVariantImage();

        if (getImages() != null && !getImages().isEmpty()) {

            boolean imageFound = false;
            Iterator<Image> iterImages = getImages().iterator();

            while (iterImages.hasNext() && !imageFound) {
                Image image = iterImages.next();

                if (StringUtils.equals(image.getFormat(), "thumbnail")
                        && image.getImageType() == ImageDataType.PRIMARY) {
                    thumbnail = image.getUrl();
                    imageFound = true;
                }
            }

        }

        return thumbnail;

    }

}