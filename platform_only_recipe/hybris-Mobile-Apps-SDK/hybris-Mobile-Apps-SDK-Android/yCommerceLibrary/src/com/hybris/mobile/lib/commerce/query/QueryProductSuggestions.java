package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for product suggestions requests
 */
public class QueryProductSuggestions {

    private String max;
    private String term;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
