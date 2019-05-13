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
package com.hybris.mobile.app.commerce.barcode;

import com.hybris.mobile.app.commerce.Constants;
import com.hybris.mobile.app.commerce.utils.RegexUtils;
import com.hybris.mobile.lib.scanner.checker.BarcodeChecker;
import com.hybris.mobile.lib.scanner.checker.BarcodeCheckerFactory;
import com.hybris.mobile.lib.scanner.data.BarcodeData;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


public class CommerceBarcodeCheckerFactory implements BarcodeCheckerFactory {

    public CommerceBarcodeCheckerFactory() {
    }

    @Override
    public BarcodeChecker getBarcodeChecker(BarcodeData barcodeData) {

        BarcodeChecker barcodeChecker = null;

        // Identifying a product code
        String productCode = getProductCode(barcodeData.getData(), barcodeData.getFormat());

        if (StringUtils.isNotEmpty(productCode)) {
            barcodeChecker = new ProductDetailsBarcodeChecker(productCode);
        } else {

            List<String> addToCart = RegexUtils.getAddToCart(barcodeData.getData());

            if (addToCart != null && !addToCart.isEmpty()) {

                int quantity = 1;

                if (addToCart.size() == 2 && StringUtils.isNotBlank(addToCart.get(1))) {
                    quantity = Integer.parseInt(addToCart.get(1));
                }

                barcodeChecker = new AddToCartBarcodeChecker(addToCart.get(0), quantity);
            } else {
                // Identifying a order id
                String orderCode = RegexUtils.getOrderCode(barcodeData.getData());

                if (StringUtils.isNotEmpty(orderCode)) {
                    barcodeChecker = new OrderDetailsBarcodeChecker(orderCode);
                }

            }

        }

        return barcodeChecker;
    }

    /**
     * Return the product value if the barcode value matches one of the pre-configured regular expression
     *
     * @param barcodeValue
     * @param barcodeSymbology
     * @return
     */
    private static String getProductCode(String barcodeValue, String barcodeSymbology) {

        // For product codes, we have to remove the leading/trailing 0 of specific barcode symbologies

        // These barcodes have leading '0's and a trailing '0' that needs to be accounted for (stripped out).
        if (StringUtils.equals(barcodeSymbology, Constants.BarCodeSymbology.EAN_13.getCodeSymbology())) {
            barcodeValue = StringUtils.stripStart(barcodeValue, "0");
            barcodeValue = StringUtils.removeEnd(barcodeValue, "0");
        }
        // These barcodes have leading '0's that needs to be accounted for (stripped out).
        else if (StringUtils.equals(barcodeSymbology, Constants.BarCodeSymbology.ITF.getCodeSymbology())) {
            barcodeValue = StringUtils.stripStart(barcodeValue, "0");
        }
        // These barcodes have a trailing '0' that needs to be accounted for (stripped out).
        else if (StringUtils.equals(barcodeSymbology, Constants.BarCodeSymbology.EAN_8.getCodeSymbology())) {
            barcodeValue = StringUtils.removeEnd(barcodeValue, "0");
        }

        // Trying to get a product code from the barcode value
        return RegexUtils.getProductCode(barcodeValue);

    }

}
