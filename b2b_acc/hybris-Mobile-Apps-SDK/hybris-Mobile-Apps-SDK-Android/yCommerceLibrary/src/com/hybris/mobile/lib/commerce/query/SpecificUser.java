package com.hybris.mobile.lib.commerce.query;

/**
 * Defines a specific user
 */
public class SpecificUser {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public enum UserId {
        ANONYMOUS("anonymous"), CURRENT("current");
        private String value;

        UserId(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
