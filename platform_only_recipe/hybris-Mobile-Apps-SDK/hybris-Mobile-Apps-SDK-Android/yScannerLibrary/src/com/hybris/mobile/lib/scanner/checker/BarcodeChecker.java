/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.lib.scanner.checker;

import android.app.Activity;
import android.content.Intent;

import com.hybris.mobile.lib.scanner.callback.AfterScanCallback;

/**
 * Interface for barcode checkers
 */
public interface BarcodeChecker {

    /**
     * Action launched after the scanner scan a barcode
     *
     * @param afterScanCallback callbacks to return to the scanner
     */
    void doAfterScan(AfterScanCallback afterScanCallback);

    /**
     * Return the intent that will launch the barcode checker associated activity
     *
     * @param activity the source activity
     * @return the intent to launch
     */
    Intent getIntent(Activity activity);
}
