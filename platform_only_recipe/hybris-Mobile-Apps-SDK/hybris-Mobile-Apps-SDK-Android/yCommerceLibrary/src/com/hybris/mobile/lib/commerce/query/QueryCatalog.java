package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for catalog requests
 */
public class QueryCatalog extends QueryList {

    private String catalogId;
    private String catalogVersionId;
    private String catalogCategoryId;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogVersionId() {
        return catalogVersionId;
    }

    public void setCatalogVersionId(String catalogVersionId) {
        this.catalogVersionId = catalogVersionId;
    }

    public String getCatalogCategoryId() {
        return catalogCategoryId;
    }

    public void setCatalogCategoryId(String catalogCategoryId) {
        this.catalogCategoryId = catalogCategoryId;
    }
}
