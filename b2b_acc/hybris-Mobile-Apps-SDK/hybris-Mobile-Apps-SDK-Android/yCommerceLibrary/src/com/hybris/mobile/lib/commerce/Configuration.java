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

package com.hybris.mobile.lib.commerce;

/**
 * Settings to define builds with different package name, backend url, Authority and path
 */
public class Configuration {

    private String backendUrl;
    private String catalog;
    private String catalogId;
    private String catalogVersionId;
    private String catalogAuthority;
    private String catalogIdMainCategory;

    public String getBackendUrl() {
        return backendUrl;
    }

    public void setBackendUrl(String backendUrl) {
        this.backendUrl = backendUrl;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

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

    public String getCatalogAuthority() {
        return catalogAuthority;
    }

    public void setCatalogAuthority(String catalogAuthority) {
        this.catalogAuthority = catalogAuthority;
    }

    public String getCatalogIdMainCategory() {
        return catalogIdMainCategory;
    }

    public void setCatalogIdMainCategory(String catalogIdMainCategory) {
        this.catalogIdMainCategory = catalogIdMainCategory;
    }

}
