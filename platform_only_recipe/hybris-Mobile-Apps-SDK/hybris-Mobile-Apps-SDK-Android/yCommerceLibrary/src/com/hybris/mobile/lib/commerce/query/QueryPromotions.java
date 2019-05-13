package com.hybris.mobile.lib.commerce.query;

/**
 * Query object for product promotions requests
 */
public class QueryPromotions {

    private String promotionGroup;
    private String type;

    public String getPromotionGroup() {
        return promotionGroup;
    }

    public void setPromotionGroup(String promotionGroup) {
        this.promotionGroup = promotionGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
