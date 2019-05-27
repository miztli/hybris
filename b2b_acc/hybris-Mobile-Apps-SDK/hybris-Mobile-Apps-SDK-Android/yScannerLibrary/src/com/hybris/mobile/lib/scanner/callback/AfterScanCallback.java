package com.hybris.mobile.lib.scanner.callback;

/**
 * Callbacks for after scanning
 */
public interface AfterScanCallback {

    /**
     * Calling this method indicate the scanning process to continue
     */
    void onSuccess();

    /**
     * Calling this method indicate the scanning process to stop and display an error message
     *
     * @param resMsgId resource id for the message
     * @param values   values to replace on the message
     */
    void onError(int resMsgId, String... values);

    /**
     * Calling this method indicate the scanning process to stop and display an error message
     *
     * @param message error message
     */
    void onError(String message);

}
