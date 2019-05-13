package com.hybris.mobile.lib.scanner.scanner;

import android.app.Activity;
import android.content.Intent;

import com.hybris.mobile.lib.scanner.data.BarcodeData;

import java.io.Serializable;

/**
 * Interface for barcode scanner engines
 */
public interface BarcodeScanner extends Serializable {

    /**
     * Launches the scanner
     *
     * @param activity activity that launches the scanner
     */
    void launch(Activity activity);

    /**
     * Get the scanning results
     *
     * @param resultCode When the scanner was launched with an intent for a new activity, this Integer result code is the one returned by the child activity
     *                   through its setResult().
     * @param data       When the scanner was launched with an intent for a new activity, this Intent contains the data returned to the caller
     * @return the barcode data
     */
    BarcodeData getScanResults(int resultCode, Intent data);
}
