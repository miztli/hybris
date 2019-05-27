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

/**
 * Query object for cart entry requests
 */
public class QueryCartEntry {

    private String entryNumber;
    private String pickupStore;

    public String getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(String entryNumber) {
        this.entryNumber = entryNumber;
    }

    public String getPickupStore() {
        return pickupStore;
    }

    public void setPickupStore(String pickupStore) {
        this.pickupStore = pickupStore;
    }
}
