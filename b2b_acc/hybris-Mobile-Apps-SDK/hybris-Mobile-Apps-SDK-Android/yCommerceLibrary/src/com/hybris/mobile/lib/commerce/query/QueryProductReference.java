package com.hybris.mobile.lib.commerce.query;

import com.hybris.mobile.lib.commerce.data.product.ProductReferenceTypeEnum;

/**
 * Query object for product reference requests
 */
public class QueryProductReference extends QueryList {

    private String productCode;
    private ProductReferenceTypeEnum referenceType;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public ProductReferenceTypeEnum getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(ProductReferenceTypeEnum referenceType) {
        this.referenceType = referenceType;
    }
}
