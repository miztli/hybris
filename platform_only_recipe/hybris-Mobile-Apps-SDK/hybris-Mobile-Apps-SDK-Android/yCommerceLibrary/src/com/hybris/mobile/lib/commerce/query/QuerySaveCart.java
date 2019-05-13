package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for saving cart requests
 */
public class QuerySaveCart {

    private String saveCartDescription;
    private String saveCartName;

    public String getSaveCartDescription() {
        return saveCartDescription;
    }

    public void setSaveCartDescription(String saveCartDescription) {
        this.saveCartDescription = saveCartDescription;
    }

    public String getSaveCartName() {
        return saveCartName;
    }

    public void setSaveCartName(String saveCartName) {
        this.saveCartName = saveCartName;
    }
}
