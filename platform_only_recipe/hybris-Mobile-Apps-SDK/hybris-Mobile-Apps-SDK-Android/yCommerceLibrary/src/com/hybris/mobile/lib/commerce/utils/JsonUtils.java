/*******************************************************************************
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 ******************************************************************************/
package com.hybris.mobile.lib.commerce.utils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * Utility class for json conversion
 */
public class JsonUtils {

    private static final String MSG_TO_REPLACE = "MSG_TO_REPLACE";
    private static final String TYPE_TO_REPLACE = "TYPE_TO_REPLACE";
    private static final String ERROR_MESSAGE_JSON = "{\"errors\":[{\"message\":\"" + MSG_TO_REPLACE + "\", \"type\":\""
            + TYPE_TO_REPLACE + "\"}]}";

    /**
     * Build Message to inform about an malfunctioning, mistake, inconsistency or anomaly
     *
     * @param errorMessage String of character providing information about malfunctioning, mistake, inconsistency or anomaly
     * @param errorType    Kind of message
     * @return Message to inform about an malfunctioning, mistake, inconsistency or anomaly
     */
    public static String createErrorMessageFromOCC(String errorMessage, String errorType) {
        errorMessage = StringEscapeUtils.escapeEcmaScript(errorMessage);
        return ERROR_MESSAGE_JSON.replace(MSG_TO_REPLACE, StringUtils.isNotBlank(errorMessage) ? errorMessage : "").replace(
                TYPE_TO_REPLACE, StringUtils.isNotBlank(errorType) ? errorType : "");
    }
}
