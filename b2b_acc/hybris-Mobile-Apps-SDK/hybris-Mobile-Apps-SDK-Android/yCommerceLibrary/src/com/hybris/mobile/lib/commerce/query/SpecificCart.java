package com.hybris.mobile.lib.commerce.query;

/**
 * Defines a specific cart and user
 */
public class SpecificCart extends SpecificUser {
    private String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public enum CartId {
        CURRENT("current");

        private String value;

        CartId(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
}
