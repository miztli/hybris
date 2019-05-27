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

package com.hybris.mobile.app.commerce.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.LoginActivity;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetails;
import com.hybris.mobile.lib.commerce.data.order.PaymentDetailsList;
import com.hybris.mobile.lib.commerce.data.storesession.Language;
import com.hybris.mobile.lib.commerce.data.storesession.LanguageList;
import com.hybris.mobile.lib.commerce.data.user.Title;
import com.hybris.mobile.lib.commerce.data.user.TitleList;
import com.hybris.mobile.lib.commerce.data.user.User;
import com.hybris.mobile.lib.commerce.query.QueryUser;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class AccountFragment extends Fragment {
    private static final String TAG = AccountFragment.class.getCanonicalName();

    private String mAccountRequestId = RequestUtils.generateUniqueRequestId();

    private User mUser;
    private EditText mAccountFirstNameEditText;
    private EditText mAccountLastNameEditText;
    private TextView mAccountEmailTextview;
    private Spinner mAccountUserTitleSpinner;
    private Spinner mAccountLanguageSpinner;
    private ArrayAdapter<String> mAccountUserTitleAdapter;
    private List<Title> mTitleList;
    private ArrayAdapter<String> mAccountLanguageAdapter;
    private List<Language> mLanguageList;
    private List<PaymentDetails> mCreditCardList;
    private TextView mAccountDefaultShippingAddressContact;
    private TextView mAccountDefaultShippingAddressDetails;
    private LinearLayout mAccountShippingAddressLayout;

    private TextView accountDefaultPaymentCardholderName;
    private TextView accountDefaultCardDetails;
    private TextView accountDefaultBillingAddress;
    private LinearLayout mAccountPaymentLayout;

    OnAccountEditedListener mActivity;

    public interface OnAccountEditedListener {
        void onAddressListEditButtonClicked();

        void onPaymentListEditButtonClicked();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mActivity = (OnAccountEditedListener) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

    }

    /**
     * Show ProgressBar when Request is send and Hide ProgressBar when Response is received
     */
    private OnRequestListener mOnRequestListener = new OnRequestListener() {

        @Override
        public void beforeRequest() { //hide when loading

            UIUtils.showLoadingActionBar(getActivity(), true);
        }

        @Override
        public void afterRequestBeforeResponse() {

        }

        @Override
        public void afterRequest(boolean isDataSynced) {
            UIUtils.showLoadingActionBar(getActivity(), false);
        }
    };
    private View.OnFocusChangeListener mOnFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                saveUser();
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        mAccountEmailTextview = (TextView) view.findViewById(R.id.account_email_textview);
        mAccountFirstNameEditText = (EditText) view.findViewById(R.id.account_firstname_edittext);
        mAccountLastNameEditText = (EditText) view.findViewById(R.id.account_lastname_edittext);

        mAccountDefaultShippingAddressContact = (TextView) view.findViewById(R.id.account_default_shipping_address_contact);
        mAccountDefaultShippingAddressDetails = (TextView) view.findViewById(R.id.account_default_shipping_address_details);
        mAccountShippingAddressLayout = (LinearLayout) view.findViewById(R.id.account_shipping_address_layout);

        accountDefaultPaymentCardholderName = (TextView) view.findViewById(R.id.account_default_payment_cardholder_name);
        accountDefaultBillingAddress = (TextView) view.findViewById(R.id.account_default_billing_address);
        accountDefaultCardDetails = (TextView) view.findViewById(R.id.account_default_card_details);
        mAccountPaymentLayout = (LinearLayout) view.findViewById(R.id.account_payment_layout);


        mAccountUserTitleSpinner = (Spinner) view.findViewById(R.id.account_user_title_spinner);
        mAccountLanguageSpinner = (Spinner) view.findViewById(R.id.account_language_spinner);


        mAccountUserTitleAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        mAccountLanguageAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        mAccountFirstNameEditText.setOnFocusChangeListener(mOnFocusChangeListener);
        mAccountLastNameEditText.setOnFocusChangeListener(mOnFocusChangeListener);

        mAccountLanguageSpinner.setOnItemSelectedListener(mAccountSpinnerListener);
        mAccountUserTitleSpinner.setOnItemSelectedListener(mAccountSpinnerListener);

        mAccountShippingAddressLayout.setOnClickListener(mAccountDefaultAddressOnClickListener);
        mAccountPaymentLayout.setOnClickListener(mAccountDefaultPaymentOnClickListener);


        mAccountFirstNameEditText.setOnEditorActionListener(mOnEditorActionListener);
        mAccountLastNameEditText.setOnEditorActionListener(mOnEditorActionListener);

        return view;
    }


    @Override
    public void onResume() {
        checkIfUserLoggedIn();
        super.onResume();
    }

    private void populateUser(User user) {

        if (user != null) {
            mUser = user;

            // Getting the title and updating the title list
            CommerceApplication.getContentServiceHelper().getTitles(new ResponseReceiver<TitleList>() {

                @Override
                public void onResponse(Response<TitleList> response) {
                    mTitleList = response.getData().getTitles();
                    populateTitle();
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mAccountRequestId, false, null, mOnRequestListener);

            // Getting the languages and updating the languages list
            CommerceApplication.getContentServiceHelper().getLanguages(new ResponseReceiver<LanguageList>() {

                @Override
                public void onResponse(Response<LanguageList> response) {
                    mLanguageList = response.getData().getLanguages();
                    populateLanguage();
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mAccountRequestId, false, null, mOnRequestListener);

            CommerceApplication.getContentServiceHelper().getUserPaymentDetailsList(new ResponseReceiver<PaymentDetailsList>() {
                @Override
                public void onResponse(Response<PaymentDetailsList> response) {
                    mCreditCardList = response.getData().getPayments();
                    populateDefaultPayment();
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());

                }
            }, mAccountRequestId, null, null, false, null, mOnRequestListener);


            populateDefaultAddress();

            mAccountFirstNameEditText.setText(mUser.getFirstName());
            mAccountLastNameEditText.setText(mUser.getLastName());
            mAccountEmailTextview.setText(getString(R.string.account_email, mUser.getDisplayUid()));
        }
    }

    /**
     * Init the User Title spinner
     */
    private void initUserTitleSpinner(int position) {
        mAccountUserTitleSpinner.setAdapter(mAccountUserTitleAdapter);
        mAccountUserTitleSpinner.setSelection(position);
    }

    /**
     * Init the Language spinner
     */
    private void initLanguageSpinner(int position) {
        mAccountLanguageSpinner.setAdapter(mAccountLanguageAdapter);
        mAccountLanguageSpinner.setSelection(position);
    }

    private void populateTitle() {

        int titleIndex = 0;
        int i = 0;
        if (mTitleList != null && !mTitleList.isEmpty()) {

            // Create Title List Name
            List<String> userTitleList = new ArrayList<String>();
            for (Title title : mTitleList) {
                userTitleList.add(title.getName());

                if (StringUtils.equals(title.getCode(), mUser.getTitleCode())) {
                    titleIndex = i;
                }
                i++;
            }

            // We re-init the spinner, because we always want to trigger the selection change even the index didnt change
            initUserTitleSpinner(titleIndex);

            mAccountUserTitleAdapter.clear();
            mAccountUserTitleAdapter.addAll(userTitleList);
            mAccountUserTitleAdapter.notifyDataSetChanged();
        }
    }

    private void populateLanguage() {
        int languageIndex = 0;
        int i = 0;
        if (mLanguageList != null && !mLanguageList.isEmpty()) {

            // Create Language List Name
            List<String> languageList = new ArrayList<String>();
            for (Language language : mLanguageList) {
                languageList.add(language.getName());

                if (mUser.getLanguage() != null) {
                    if (StringUtils.equals(language.getIsocode(), mUser.getLanguage().getIsocode())) {
                        languageIndex = i;
                    }
                    i++;
                }
            }

            // We re-init the spinner, because we always want to trigger the selection change even the index didnt change
            initLanguageSpinner(languageIndex);

            mAccountLanguageAdapter.clear();
            mAccountLanguageAdapter.addAll(languageList);
            mAccountLanguageAdapter.notifyDataSetChanged();

        }
    }

    private void populateDefaultPayment() {
        //TODO : to implement when occ ready
        int defaultPosition = 0;//findDefaultPayment(mCreditCardList);

        if (mCreditCardList != null && !mCreditCardList.isEmpty() && mCreditCardList.get(defaultPosition) != null) {

            accountDefaultPaymentCardholderName.setText(StringUtils.isNotBlank(mCreditCardList.get(defaultPosition).getAccountHolderName())?mCreditCardList.get(defaultPosition).getAccountHolderName():getString(R.string.payment_add_new));
            accountDefaultCardDetails.setText(mCreditCardList.get(defaultPosition).getCardType().getName() + "\n" + mCreditCardList.get(defaultPosition).getCardNumber() + "\n" + mCreditCardList.get(defaultPosition).getExpiryMonth() + "/" + mCreditCardList.get(defaultPosition).getExpiryYear());

            if (mCreditCardList.get(defaultPosition).getBillingAddress() != null) {

                accountDefaultBillingAddress.setText(StringUtils.isNotBlank(mCreditCardList.get(defaultPosition).getBillingAddress().getFormattedAddress()) ? mCreditCardList.get(defaultPosition).getBillingAddress().getFormattedAddress() : mCreditCardList.get(defaultPosition).getBillingAddress().getLine1() + " " + mCreditCardList.get(defaultPosition).getBillingAddress().getLine2() + ",\n " + mCreditCardList.get(defaultPosition).getBillingAddress().getTown() + " " + mCreditCardList.get(defaultPosition).getBillingAddress().getPostalCode());

            }
        } else {
            accountDefaultPaymentCardholderName.setText(getString(R.string.payment_add_new));
            accountDefaultCardDetails.setText("");
            accountDefaultBillingAddress.setText("");
        }
    }

    private void populateDefaultAddress() {

        if (mUser.getDefaultAddress() != null) {

            String contactDetails = "";
            String addressDetails = "";

            if (mUser.getDefaultAddress().getTitle() != null) {
                contactDetails += mUser.getDefaultAddress().getTitle() + " ";
            }
            contactDetails += mUser.getDefaultAddress().getFirstName() + " ";
            contactDetails += mUser.getDefaultAddress().getLastName();

            addressDetails = StringUtils.isNotBlank(mUser.getDefaultAddress().getFormattedAddress()) ? mUser.getDefaultAddress().getFormattedAddress() : mUser.getDefaultAddress().getLine1() +
                    " " + mUser.getDefaultAddress().getLine2() + " " + mUser.getDefaultAddress().getPostalCode() + ", " + mUser.getDefaultAddress().getTown();


            mAccountDefaultShippingAddressDetails.setText(addressDetails);
            mAccountDefaultShippingAddressContact.setText(contactDetails);

        }

    }

    private void saveUser() {

        boolean update = !StringUtils.equals(mAccountFirstNameEditText.getText().toString(), mUser.getFirstName())
                || !StringUtils.equals(mAccountLastNameEditText.getText().toString(), mUser.getLastName());

        if (mAccountUserTitleSpinner != null && mTitleList != null
                && mTitleList.get(mAccountUserTitleSpinner.getSelectedItemPosition()) != null) {

            update = update || !StringUtils
                    .equals(mTitleList.get(mAccountUserTitleSpinner.getSelectedItemPosition()).getCode(), mUser.getTitleCode());

        } else {
            update = update || false;
        }

        if (mAccountLanguageSpinner != null && mLanguageList != null && mUser.getLanguage() != null
                && mLanguageList.get(mAccountLanguageSpinner.getSelectedItemPosition()) != null) {

            update = update || !StringUtils.equals(mLanguageList.get(mAccountLanguageSpinner.getSelectedItemPosition()).getIsocode(),
                    mUser.getLanguage().getIsocode());

        } else {
            update = update || false;
        }

        if (update) {
            mUser.setTitleCode(mTitleList.get(mAccountUserTitleSpinner.getSelectedItemPosition()).getCode());
            mUser.setFirstName(mAccountFirstNameEditText.getText().toString());
            mUser.setLastName(mAccountLastNameEditText.getText().toString());
            mUser.setLanguage(mLanguageList.get(mAccountLanguageSpinner.getSelectedItemPosition()));
            updateUserProfile(mUser);
        }
    }

    private void updateUserProfile(User modifiedUser) {
        QueryUser queryUser = new QueryUser();
        queryUser.setFirstName(modifiedUser.getFirstName());
        queryUser.setLastName(modifiedUser.getLastName());
        queryUser.setTitleCode(modifiedUser.getTitleCode());//TODO : remove lowercase for real code
        queryUser.setCurrency(modifiedUser.getCurrency().getIsocode());
        queryUser.setLanguage(modifiedUser.getLanguage().getIsocode());


        CommerceApplication.getContentServiceHelper().replaceUserProfile(new ResponseReceiverEmpty() {
            @Override
            public void onResponse(Response<EmptyResponse> response) {

                // Getting the user
                CommerceApplication.getContentServiceHelper().getUserProfile(new ResponseReceiver<User>() {
                    @Override
                    public void onResponse(Response<User> response) {
                        populateUser(response.getData());
                        Alert.showSuccess(getActivity(), getActivity().getString(R.string.account_user_profile_updated_message));

                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, mAccountRequestId, null, false, null, mOnRequestListener);
            }

            @Override
            public void onError(Response<ErrorList> response) {
                Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, mAccountRequestId, queryUser, null, false, null, mOnRequestListener);

    }

    private void checkIfUserLoggedIn() {
        if (!SessionHelper.isUserLoggedIn()) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }
        else {

            // Getting the user
            if(mUser == null) {
                CommerceApplication.getContentServiceHelper().getUserProfile(new ResponseReceiver<User>() {
                    @Override
                    public void onResponse(Response<User> response) {
                        populateUser(response.getData());
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        // UIUtils.showError(response, getActivity());
                    }
                }, mAccountRequestId, null, false, null, mOnRequestListener);
            }
        }
    }

    public AdapterView.OnItemSelectedListener mAccountSpinnerListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            saveUser();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    public View.OnClickListener mAccountDefaultAddressOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mActivity.onAddressListEditButtonClicked();
        }
    };
    public View.OnClickListener mAccountDefaultPaymentOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mActivity.onPaymentListEditButtonClicked();
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mAccountRequestId);
    }

    private EditText.OnEditorActionListener mOnEditorActionListener = new EditText.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveUser();
                return true;
            }
            return false;
        }
    };
}
