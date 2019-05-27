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
package com.hybris.mobile.lib.commerce.query;

public class QueryPlaceOrder {
    private String securityCode;
    private boolean termsChecked;

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public boolean isTermsChecked() {
        return termsChecked;
    }

    public void setTermsChecked(boolean termsChecked) {
        this.termsChecked = termsChecked;
    }
}
