package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for exporting products requests
 */
public class QueryExportProducts extends QueryList {

    private String timestamp;
    private String catalog;
    private String version;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
