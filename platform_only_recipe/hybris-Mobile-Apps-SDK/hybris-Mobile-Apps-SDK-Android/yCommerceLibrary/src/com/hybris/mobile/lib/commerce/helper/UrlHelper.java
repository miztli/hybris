/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.lib.commerce.helper;

import android.content.Context;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.R;

import org.apache.commons.lang3.StringUtils;


/**
 * Helper for url operations
 */
public class UrlHelper {

    /**
     * Return the webservice Http Address that take into account the catalog + the method path to call
     *
     * @param context               Application-specific resources
     * @param configuration         URL settings
     * @param pathUrlStringResource Webservice path
     * @param formatArgs            Values to replace on the final returned String   @return Formatted String Url for WebService
     */
    public static String getWebserviceCatalogUrl(Context context, Configuration configuration, int pathUrlStringResource,
                                                 Object... formatArgs) {
        if (configuration == null || StringUtils.isBlank(configuration.getBackendUrl())) {
            throw new IllegalArgumentException();
        }

        return buildWebserviceUrl(context, configuration, pathUrlStringResource, formatArgs);
    }

    /**
     * Return the webservice Http Address for token calls
     *
     * @param context Application-specific resources
     * @return Formatted String Url for WebService
     */
    public static String getWebserviceTokenUrl(Context context, Configuration configuration) {
        if (configuration == null || StringUtils.isBlank(configuration.getBackendUrl())) {
            throw new IllegalArgumentException();
        }

        return configuration.getBackendUrl() + context.getString(R.string.path_token);
    }

    /**
     * Build the webservice Http Address
     *
     * @param context               Application-specific resources
     * @param configuration         URL settings
     * @param pathUrlStringResource Webservice path
     * @param formatArgs            Values to replace on the final returned String
     * @return Formatted String Url for WebService
     */
    private static String buildWebserviceUrl(Context context, Configuration configuration, int pathUrlStringResource, Object... formatArgs) {
        if (configuration == null || StringUtils.isBlank(configuration.getBackendUrl()) || StringUtils.isBlank(configuration.getCatalog())) {
            throw new IllegalArgumentException();
        }

        String url = configuration.getBackendUrl() + context.getString(R.string.path_webservice) + configuration.getCatalog();

        if (formatArgs != null && formatArgs.length > 0) {
            return url + context.getString(pathUrlStringResource, formatArgs);
        } else {
            return url + context.getString(pathUrlStringResource);
        }
    }

    /**
     * Return the image Http Address
     *
     * @param configuration URL settings
     * @param pathUrl       Url path of the image  @return Formatted String Url for Image
     */
    public static String getImageUrl(Configuration configuration, String pathUrl) {
        if (configuration == null || StringUtils.isBlank(configuration.getBackendUrl())) {
            throw new IllegalArgumentException();
        }

        return configuration.getBackendUrl() + pathUrl;
    }
}
