package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for cart creation requests
 */
public class QueryCartCreate {

    private String oldCartId;
    private String toMergeCartGuid;

    public String getOldCartId() {
        return oldCartId;
    }

    public void setOldCartId(String oldCartId) {
        this.oldCartId = oldCartId;
    }

    public String getToMergeCartGuid() {
        return toMergeCartGuid;
    }

    public void setToMergeCartGuid(String toMergeCartGuid) {
        this.toMergeCartGuid = toMergeCartGuid;
    }
}
