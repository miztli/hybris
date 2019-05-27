package com.hybris.mobile.lib.scanner.callback;

import com.hybris.mobile.lib.scanner.data.BarcodeData;

/**
 * Interface for scan callbacks
 */
public interface ScannerCallback {

    /**
     * Scan result
     *
     * @param barcodeData the barcode data
     */
    void onScan(BarcodeData barcodeData);

    /**
     * Cancelling scan
     */
    void onCancelScan();
}
