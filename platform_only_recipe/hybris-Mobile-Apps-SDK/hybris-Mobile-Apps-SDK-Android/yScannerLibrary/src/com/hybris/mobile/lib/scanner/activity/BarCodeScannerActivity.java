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
package com.hybris.mobile.lib.scanner.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.widget.Toast;

import com.hybris.mobile.lib.scanner.R;
import com.hybris.mobile.lib.scanner.ScannerHelper;
import com.hybris.mobile.lib.scanner.callback.AfterScanCallback;
import com.hybris.mobile.lib.scanner.checker.BarcodeChecker;
import com.hybris.mobile.lib.scanner.checker.BarcodeCheckerFactory;
import com.hybris.mobile.lib.scanner.data.BarcodeData;
import com.hybris.mobile.lib.scanner.scanner.BarcodeScanner;

/**
 * Activity for the barcode scanner
 */
public class BarCodeScannerActivity extends Activity implements Handler.Callback {

    private static final int MSG_DATA_ERROR = -1;
    private static final int MSG_DATA_SUCCESS = 1;
    private BarcodeScanner mBarcodeScanner;
    private ResultReceiver mResultReceiver;
    private BarcodeCheckerFactory mBarcodeCheckerFactory;
    private BarcodeChecker mBarcodeChecker;
    private Handler mHandler;

    // We keep a static boolean indicating whether or not the scanner is running
    private boolean mIsScannerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
        getActionBar().hide();
        mHandler = new Handler(this);
        mBarcodeScanner = (BarcodeScanner) getIntent().getSerializableExtra(ScannerHelper.EXTRA_BARCODE_SCANNER);
        mResultReceiver = getIntent().getParcelableExtra(ScannerHelper.EXTRA_RESULT_RECEIVER_BARCODE);
        mBarcodeCheckerFactory = (BarcodeCheckerFactory) getIntent().getSerializableExtra(ScannerHelper.EXTRA_BARCODE_FACTORY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        launchScanner();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Getting scanning data
        BarcodeData barcodeData = mBarcodeScanner.getScanResults(resultCode, data);

        // Barcode factory to redirect the user after scanning
        boolean redirectBarcode = barcodeData != null && mBarcodeCheckerFactory != null;

        // We run the task to check the format and data availability of the barcode scanned
        if (redirectBarcode) {
            new CheckBarcodeAsyncTask().execute(barcodeData);
        }
        // Returning the result to the caller
        else {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ScannerHelper.EXTRA_RESULT_RECEIVER_BARCODE, barcodeData);

            // Sending back the result
            mResultReceiver.send(Activity.RESULT_OK, bundle);

            // Finishing the activity
            finish();
        }

    }

    /**
     * Launch the scanner
     */
    private void launchScanner() {
        if (!mIsScannerRunning) {
            mIsScannerRunning = true;
            mBarcodeScanner.launch(this);
        }
    }

    /**
     * Show an error message
     *
     * @param errorMessage the message to show
     */
    private void showErrorMessage(String errorMessage) {
        // We resume the scanning activity before
        launchScanner();

        // Displaying the error message
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * This asynchronous task is ran after scanning if the user wants to automatically redirects to an activity
     */
    private class CheckBarcodeAsyncTask extends AsyncTask<BarcodeData, Void, Void> {

        @Override
        protected Void doInBackground(BarcodeData... params) {

            // Getting the BarcodeChecker implementation
            mBarcodeChecker = mBarcodeCheckerFactory.getBarcodeChecker(params[0]);

            // The barcode is recognized by the barcode checker
            if (mBarcodeChecker != null) {
                // Checking the data
                mBarcodeChecker.doAfterScan(new AfterScanCallback() {
                    @Override
                    public void onSuccess() {
                        Message msg = new Message();
                        msg.what = BarCodeScannerActivity.MSG_DATA_SUCCESS;
                        mHandler.sendMessage(msg);
                    }

                    @Override
                    public void onError(int resMsgId, String... values) {
                        Message msg = new Message();
                        msg.what = BarCodeScannerActivity.MSG_DATA_ERROR;

                        if (values != null) {
                            msg.obj = getString(resMsgId, (Object[]) values);
                        } else {
                            msg.obj = getString(resMsgId);
                        }

                        mHandler.sendMessage(msg);
                    }

                    @Override
                    public void onError(String message) {
                        Message msg = new Message();
                        msg.what = BarCodeScannerActivity.MSG_DATA_ERROR;
                        msg.obj = message;
                        mHandler.sendMessage(msg);
                    }
                });
            }
            // The barcode is not recognized
            else {
                Message msg = new Message();
                msg.what = BarCodeScannerActivity.MSG_DATA_ERROR;
                msg.obj = getString(R.string.error_barcode_no_action, params[0].getData());
                mHandler.sendMessage(msg);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

    }

    @Override
    public boolean handleMessage(Message msg) {

        mIsScannerRunning = false;

        switch (msg.what) {

            // Error with the data
            case MSG_DATA_ERROR:
                showErrorMessage((String) msg.obj);
                break;

            // Data success, start the intent
            case MSG_DATA_SUCCESS:
                this.startActivity(mBarcodeChecker.getIntent(this));
                break;

        }
        return false;
    }

}
