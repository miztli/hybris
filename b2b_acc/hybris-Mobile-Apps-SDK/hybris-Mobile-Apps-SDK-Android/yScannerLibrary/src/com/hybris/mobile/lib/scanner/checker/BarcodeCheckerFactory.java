package com.hybris.mobile.lib.scanner.checker;

import com.hybris.mobile.lib.scanner.data.BarcodeData;

import java.io.Serializable;

/**
 * Interface for barcode checker factory
 */
public interface BarcodeCheckerFactory extends Serializable {

    /**
     * Returns the barcode checker associated with the barcode data
     *
     * @param barcodeData contains the barcode data
     * @return the barcode checker associated with the barcode data
     */
    BarcodeChecker getBarcodeChecker(BarcodeData barcodeData);
}
