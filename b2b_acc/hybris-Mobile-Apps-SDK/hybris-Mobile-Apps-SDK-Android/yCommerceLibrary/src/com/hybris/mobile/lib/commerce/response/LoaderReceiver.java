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

package com.hybris.mobile.lib.commerce.response;

import com.hybris.mobile.lib.http.response.ResponseCallback;


/**
 * Interface for receiving a Response callback result
 *
 * @param <T>
 */
public interface LoaderReceiver<T> extends ResponseCallback<T, com.hybris.mobile.lib.commerce.data.error.Error> {

}
