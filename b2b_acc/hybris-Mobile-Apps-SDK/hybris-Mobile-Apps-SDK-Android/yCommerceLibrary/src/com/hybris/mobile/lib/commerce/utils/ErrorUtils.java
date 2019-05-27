package com.hybris.mobile.lib.commerce.utils;

import com.hybris.mobile.lib.commerce.data.error.Error;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;

public class ErrorUtils {

    public static String getFirstErrorMessage(ErrorList errorList) {
        Error firstError = errorList.getErrors() != null && !errorList.getErrors().isEmpty() ? errorList.getErrors().get(0) : null;

        return firstError != null ? firstError.getMessage() : "";
    }
}
