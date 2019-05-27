package com.hybris.mobile.app.commerce.listener;

import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.http.response.Response;

/**
 * Listener for cart merges
 */
public interface CartMergeListener {

    /**
     * Erro with the merge
     *
     * @param error
     */
    void onError(Response<ErrorList> error);

    /**
     * Success with the merge
     *
     * @param cart
     */
    void onSuccess(Cart cart);
}
