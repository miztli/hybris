package com.hybris.mobile.lib.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

import com.hybris.mobile.lib.scanner.activity.BarCodeScannerActivity;
import com.hybris.mobile.lib.scanner.callback.ScannerCallback;
import com.hybris.mobile.lib.scanner.checker.BarcodeCheckerFactory;
import com.hybris.mobile.lib.scanner.data.BarcodeData;
import com.hybris.mobile.lib.scanner.scanner.BarcodeScanner;
import com.hybris.mobile.lib.scanner.scanner.ZXingScanner;

/**
 * Helper for the barcode scanner
 */
public class ScannerHelper {

    public static final String EXTRA_RESULT_RECEIVER_BARCODE = "extra_result_receiver_barcode";
    public static final String EXTRA_BARCODE_SCANNER = "extra_barcode_scanner";
    public static final String EXTRA_BARCODE_FACTORY = "extra_barcode_factory";
    private BarcodeScanner mBarcodeScanner;
    private BarcodeCheckerFactory mBarcodeCheckerFactory;

    /**
     * Default constructor
     *
     * @param barcodeScanner        the barcode scanner to use
     * @param barcodeCheckerFactory a barcode factory to use after scanning
     */
    public ScannerHelper(BarcodeScanner barcodeScanner, BarcodeCheckerFactory barcodeCheckerFactory) {
        this.mBarcodeScanner = barcodeScanner;
        this.mBarcodeCheckerFactory = barcodeCheckerFactory;
    }

    /**
     * Constructor using ZXing as the scanner engine
     *
     * @param barcodeCheckerFactory a barcode factory to use after scanning
     */
    public ScannerHelper(BarcodeCheckerFactory barcodeCheckerFactory) {
        this.mBarcodeScanner = new ZXingScanner();
        this.mBarcodeCheckerFactory = barcodeCheckerFactory;
    }

    /**
     * Constructor using ZXing as the scanner engine
     */
    public ScannerHelper() {
        this.mBarcodeScanner = new ZXingScanner();
    }

    /**
     * Launch the scanning process
     *
     * @param activity        activity that launches the scanner
     * @param scannerCallback callback for scanning results
     */
    public void launch(Activity activity, final ScannerCallback scannerCallback) {

        // Result Receiver for barcode
        ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);

                BarcodeData barcodeData = resultData.getParcelable(EXTRA_RESULT_RECEIVER_BARCODE);

                // Success
                if (barcodeData != null) {
                    scannerCallback.onScan((BarcodeData) resultData.getParcelable(EXTRA_RESULT_RECEIVER_BARCODE));
                }
                // Cancel
                else {
                    scannerCallback.onCancelScan();
                }

            }
        };

        // Starting the scanning activity
        Intent intentBarcode = new Intent(activity, BarCodeScannerActivity.class);
        intentBarcode.putExtra(EXTRA_RESULT_RECEIVER_BARCODE, resultReceiver);
        intentBarcode.putExtra(EXTRA_BARCODE_SCANNER, mBarcodeScanner);
        intentBarcode.putExtra(EXTRA_BARCODE_FACTORY, mBarcodeCheckerFactory);

        activity.startActivity(intentBarcode);
    }

}
