package com.hybris.mobile.app.commerce.fragment;

import android.app.Fragment;
import android.view.View;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.helper.CartHelperBase;
import com.hybris.mobile.app.commerce.listener.CartMergeListener;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import java.util.Arrays;
import java.util.Collections;

public class LoginFragment extends LoginFragmentBase {

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    private Cart mGuestCart;

    @Override
    protected void beforeLogin(final BeforeLoginCallback beforeLoginCallback) {

        // We get the current guest cart to merge it with user current cart
        CommerceApplication.getContentServiceHelper().getCart(new ResponseReceiver<Cart>() {
            @Override
            public void onResponse(Response<Cart> response) {
                mGuestCart = response.getData();
                beforeLoginCallback.success();
            }

            @Override
            public void onError(Response<ErrorList> response) {
                beforeLoginCallback.error(response);
            }
        }, mLoginRequestId, null, false, Arrays.asList((View) mLoginButton, mEmailEditText, mPasswordEditText), null);

    }

    @Override
    protected void afterLogin() {

        // We don' want to re-enable the authenticate button after authenticate
        mLoginButton.setEnabled(false);

        // We had a guest cart before authenticate
        if (mGuestCart != null) {
            CartHelperBase.mergeCartWithUserCart(mGuestCart, mLoginRequestId, new CartMergeListener() {
                @Override
                public void onError(Response<ErrorList> error) {
                }

                @Override
                public void onSuccess(Cart cart) {
                }
            }, Collections.singletonList((View) mLoginButton), new OnRequestListener() {
                @Override
                public void beforeRequest() {

                }

                @Override
                public void afterRequestBeforeResponse() {

                }

                @Override
                public void afterRequest(boolean isDataSynced) {
                    getActivity().finish();
                }
            });
        } else {
            getActivity().finish();
        }

    }

}
