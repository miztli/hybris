package com.hybris.mobile.lib.scanner.scanner;

import android.app.Activity;
import android.content.Intent;

import com.google.zxing.integration.android.IntentIntegrator;
import com.hybris.mobile.lib.scanner.data.BarcodeData;

/**
 * ZXing scanner implementation
 */
public class ZXingScanner implements BarcodeScanner {

    private static final String SCAN_RESULT = "SCAN_RESULT";
    private static final String SCAN_RESULT_FORMAT = "SCAN_RESULT_FORMAT";

    public ZXingScanner() {
    }

    @Override
    public void launch(Activity activity) {
        new IntentIntegrator(activity).initiateScan();
    }

    @Override
    public BarcodeData getScanResults(int resultCode, Intent data) {

        BarcodeData barcodeData = new BarcodeData();

        if (resultCode == Activity.RESULT_OK) {
            barcodeData.setData(data.getStringExtra(SCAN_RESULT));
            barcodeData.setFormat(data.getStringExtra(SCAN_RESULT_FORMAT));
        } else if (resultCode == Activity.RESULT_CANCELED) {
            barcodeData = null;
        }

        return barcodeData;
    }
}
