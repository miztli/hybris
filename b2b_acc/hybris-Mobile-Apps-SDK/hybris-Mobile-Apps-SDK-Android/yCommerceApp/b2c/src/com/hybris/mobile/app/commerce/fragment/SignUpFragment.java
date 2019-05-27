package com.hybris.mobile.app.commerce.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.CartHelperBase;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.listener.CartMergeListener;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.user.Title;
import com.hybris.mobile.lib.commerce.data.user.TitleList;
import com.hybris.mobile.lib.commerce.query.QueryCreateUser;
import com.hybris.mobile.lib.commerce.query.QueryLogin;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignUpFragment extends Fragment {

    private String mSignUpRequestId = RequestUtils.generateUniqueRequestId();

    private List<Title> mTitleCodes;
    private EditText mFirstName;
    private TextView mFirstNameError;
    private EditText mLastName;
    private TextView mLastNameError;
    private EditText mEmail;
    private TextView mEmailError;
    private EditText mPassword;
    private TextView mPasswordError;
    private Spinner mTitleCode;
    private TextView mTitleCodeError;
    private ArrayAdapter<String> mTitleCodeAdapter;
    private View mSubmitButton;

    private TextWatcher mEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            activateSignUpButton();
        }

    };

    public static Fragment newInstance() {
        return new SignUpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mFirstName = (EditText) getView().findViewById(R.id.sign_up_first_name);
        mFirstNameError = (TextView) getView().findViewById(R.id.sign_up_first_name_error);
        mLastName = (EditText) getView().findViewById(R.id.sign_up_last_name);
        mLastNameError = (TextView) getView().findViewById(R.id.sign_up_last_name_error);
        mEmail = (EditText) getView().findViewById(R.id.sign_up_email);
        mEmailError = (TextView) getView().findViewById(R.id.sign_up_email_error);
        mPassword = (EditText) getView().findViewById(R.id.sign_up_password);
        mPasswordError = (TextView) getView().findViewById(R.id.sign_up_password_error);
        mTitleCode = (Spinner) getView().findViewById(R.id.sign_up_title_code);
        mTitleCodeError = (TextView) getView().findViewById(R.id.sign_up_title_code_error);
        mSubmitButton = getView().findViewById(R.id.sign_up_submit);
        mTitleCodeAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());
        mTitleCode.setAdapter(mTitleCodeAdapter);

        // Getting and filling the spinner with title codes
        CommerceApplication.getContentServiceHelper().getTitles(new ResponseReceiver<TitleList>() {
            @Override
            public void onResponse(Response<TitleList> response) {

                if (response.getData() != null && response.getData().getTitles() != null) {
                    mTitleCodes = response.getData().getTitles();

                    mTitleCodeAdapter.clear();

                    for (Title title : mTitleCodes) {
                        mTitleCodeAdapter.add(title.getName());
                    }

                    mTitleCodeAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, mSignUpRequestId, false, null, new OnRequestListener() {
            @Override
            public void beforeRequest() {
                UIUtils.showLoadingActionBar(getActivity(), true);
            }

            @Override
            public void afterRequestBeforeResponse() {

            }

            @Override
            public void afterRequest(boolean isDataSynced) {
                UIUtils.showLoadingActionBar(getActivity(), false);
            }
        });

        // Listner for edit texts
        mFirstName.addTextChangedListener(mEditTextWatcher);
        mLastName.addTextChangedListener(mEditTextWatcher);
        mEmail.addTextChangedListener(mEditTextWatcher);
        mPassword.addTextChangedListener(mEditTextWatcher);

        // Submit sign up
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {

                    // We get the current guest cart to merge it with user current cart after authenticate
                    CommerceApplication.getContentServiceHelper().getCart(new ResponseReceiver<Cart>() {
                        @Override
                        public void onResponse(final Response<Cart> guestCart) {

                            // Set trusted client role to the guest
                            CommerceApplication.getContentServiceHelper().setClientRoleForGuest(new ResponseReceiverEmpty() {
                                @Override
                                public void onResponse(Response<EmptyResponse> response) {
                                    final QueryCreateUser queryCreateUser = new QueryCreateUser();
                                    queryCreateUser.setFirstName(mFirstName.getText().toString());
                                    queryCreateUser.setLastName(mLastName.getText().toString());
                                    queryCreateUser.setLogin(mEmail.getText().toString());
                                    queryCreateUser.setPassword(mPassword.getText().toString());
                                    queryCreateUser.setTitleCode(mTitleCodes.get(mTitleCode.getSelectedItemPosition()).getCode());

                                    // Create the user
                                    CommerceApplication.getContentServiceHelper().registerUser(new ResponseReceiverEmpty() {
                                        @Override
                                        public void onResponse(Response<EmptyResponse> response) {

                                            final QueryLogin queryLogin = new QueryLogin();
                                            queryLogin.setUsername(queryCreateUser.getLogin());
                                            queryLogin.setPassword(queryCreateUser.getPassword());

                                            // Login the user
                                            CommerceApplication.getContentServiceHelper().authenticate(new ResponseReceiverEmpty() {
                                                @Override
                                                public void onResponse(Response<EmptyResponse> response) {

                                                    // We merge the guest cart with the user current cart
                                                    CartHelperBase.mergeCartWithUserCart(guestCart.getData(), mSignUpRequestId, new CartMergeListener() {
                                                        @Override
                                                        public void onError(Response<ErrorList> error) {
                                                            SessionHelper.afterLogin(getActivity(), mSignUpRequestId, queryLogin.getUsername());

                                                            // Finish the activity
                                                            getActivity().finish();
                                                        }

                                                        @Override
                                                        public void onSuccess(Cart cart) {
                                                            SessionHelper.afterLogin(getActivity(), mSignUpRequestId, queryLogin.getUsername());

                                                            // Finish the activity
                                                            getActivity().finish();
                                                        }
                                                    }, Collections.singletonList(mSubmitButton), new OnRequestListener() {
                                                        @Override
                                                        public void beforeRequest() {
                                                        }

                                                        @Override
                                                        public void afterRequestBeforeResponse() {

                                                        }

                                                        @Override
                                                        public void afterRequest(boolean isDataSynced) {
                                                            // Sign up, authenticate and cart merge finished
                                                            UIUtils.showLoadingActionBar(getActivity(), false);
                                                        }
                                                    });

                                                }

                                                @Override
                                                public void onError(Response<ErrorList> response) {
                                                    UIUtils.showError(response, getActivity());
                                                }
                                            }, mSignUpRequestId, queryLogin, false, Collections.singletonList(mSubmitButton), null);


                                        }

                                        @Override
                                        public void onError(Response<ErrorList> response) {
                                            UIUtils.showError(response, getActivity());
                                            UIUtils.showLoadingActionBar(getActivity(), false);
                                        }
                                    }, mSignUpRequestId, queryCreateUser, false, Collections.singletonList(mSubmitButton), new OnRequestListener() {
                                        @Override
                                        public void beforeRequest() {
                                            mSubmitButton.setEnabled(false);
                                        }

                                        @Override
                                        public void afterRequestBeforeResponse() {

                                        }

                                        @Override
                                        public void afterRequest(boolean isDataSynced) {

                                        }
                                    });
                                }

                                @Override
                                public void onError(Response<ErrorList> response) {
                                    UIUtils.showError(response, getActivity());
                                    UIUtils.showLoadingActionBar(getActivity(), false);
                                }
                            }, mSignUpRequestId, false, Collections.singletonList(mSubmitButton), null);


                        }

                        @Override
                        public void onError(Response<ErrorList> response) {
                            UIUtils.showError(response, getActivity());
                            UIUtils.showLoadingActionBar(getActivity(), false);
                        }
                    }, mSignUpRequestId, null, false, Collections.singletonList(mSubmitButton), new OnRequestListener() {
                        @Override
                        public void beforeRequest() {
                            UIUtils.showLoadingActionBar(getActivity(), true);
                        }

                        @Override
                        public void afterRequestBeforeResponse() {

                        }

                        @Override
                        public void afterRequest(boolean isDataSynced) {
                        }
                    });

                }

            }
        });

    }

    /**
     * Validate the form
     *
     * @return
     */
    private boolean validate() {

        boolean valid = true;

        if (mTitleCode.getSelectedItem() == null || StringUtils.isBlank(mTitleCode.getSelectedItem().toString())) {
            valid = false;
            mTitleCodeError.setVisibility(View.VISIBLE);
        } else {
            mTitleCodeError.setVisibility(View.GONE);
        }

        if (StringUtils.isBlank(mFirstName.getText())) {
            mFirstNameError.setVisibility(View.VISIBLE);
            valid = false;
        } else {
            mFirstNameError.setVisibility(View.GONE);
        }

        if (StringUtils.isBlank(mLastName.getText())) {
            mLastNameError.setVisibility(View.VISIBLE);
            valid = false;
        } else {
            mLastNameError.setVisibility(View.GONE);
        }

        if (StringUtils.isBlank(mEmail.getText())) {
            mEmailError.setVisibility(View.VISIBLE);
            valid = false;
        } else {
            mEmailError.setVisibility(View.GONE);
        }

        if (StringUtils.isBlank(mPassword.getText())) {
            mPasswordError.setVisibility(View.VISIBLE);
            valid = false;
        } else {
            mPasswordError.setVisibility(View.GONE);
        }

        return valid;
    }

    /**
     * Activate/deactivate the sign up button
     */
    private void activateSignUpButton() {
        mSubmitButton.setEnabled(StringUtils.isNotBlank(mFirstName.getText()) && StringUtils.isNotBlank(mLastName.getText()) && StringUtils.isNotBlank(mEmail.getText()) && StringUtils.isNotBlank(mPassword.getText()));
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mSignUpRequestId);
    }
}
