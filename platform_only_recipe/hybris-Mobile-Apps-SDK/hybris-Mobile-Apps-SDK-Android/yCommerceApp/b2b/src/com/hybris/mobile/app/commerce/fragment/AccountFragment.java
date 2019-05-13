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

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.AccountAddressAdapterBase;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.b2b.data.costcenter.CostCenter;
import com.hybris.mobile.lib.b2b.data.costcenter.CostCenters;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.storesession.Language;
import com.hybris.mobile.lib.commerce.data.storesession.LanguageList;
import com.hybris.mobile.lib.commerce.data.user.Address;
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

    private String mAccountRequestId = RequestUtils.generateUniqueRequestId();

    private User mUser;

    private EditText mAccountFirstNameEditText;
    private EditText mAccountLastNameEditText;

    private TextView mAccountEmailTextview;

    private Spinner mAccountUserTitleSpinner;
    private Spinner mAccountLanguageSpinner;
    private Spinner mAccountCostCenterSpinner;


    private ArrayAdapter<String> mAccountUserTitleAdapter;
    private List<Title> mTitleList;


    private ArrayAdapter<String> mAccountLanguageAdapter;
    private List<Language> mLanguageList;

    private ArrayAdapter<String> mAccountCostCenterAdapter;
    private List<CostCenter> mAccountCostCenterList;

    private AccountAddressAdapterBase mUserAddressAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAccountUserTitleSpinner = (Spinner) getView().findViewById(R.id.account_user_title_spinner);
        mAccountFirstNameEditText = (EditText) getView().findViewById(R.id.account_firstname_edittext);
        mAccountLastNameEditText = (EditText) getView().findViewById(R.id.account_lastname_edittext);
        mAccountEmailTextview = (TextView) getView().findViewById(R.id.account_email_textview);

        mAccountLanguageSpinner = (Spinner) getView().findViewById(R.id.account_language_spinner);

        mAccountCostCenterAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        mAccountUserTitleAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        mAccountLanguageAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());

        ListView mUserAddressListView = (ListView) getActivity().findViewById(R.id.user_address_list);
        mUserAddressAdapter = new AccountAddressAdapterBase(getActivity(), new ArrayList<Address>(), mAccountRequestId);
        mUserAddressListView.setAdapter(mUserAddressAdapter);

        // Getting the user
        CommerceApplication.getContentServiceHelper().getUserProfile(new ResponseReceiver<User>() {
            @Override
            public void onResponse(Response<User> response) {
                populateUser(response.getData());
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, mAccountRequestId, null, false, null, mOnRequestListener);


        mAccountFirstNameEditText.setOnFocusChangeListener(mOnFocusChangeListener);
        mAccountLastNameEditText.setOnFocusChangeListener(mOnFocusChangeListener);

        mAccountLanguageSpinner.setOnItemSelectedListener(mAccountSpinnerListener);
        mAccountUserTitleSpinner.setOnItemSelectedListener(mAccountSpinnerListener);

        mAccountFirstNameEditText.setOnEditorActionListener(mOnEditorActionListener);
        mAccountLastNameEditText.setOnEditorActionListener(mOnEditorActionListener);

    }

    public void updateUserAddressAdapter() {
        if (mAccountCostCenterList.get(mAccountCostCenterSpinner.getSelectedItemPosition()).getUnit().getAddresses() != null) {
            mUserAddressAdapter.clear();
            mUserAddressAdapter.addAll(mAccountCostCenterList.get(mAccountCostCenterSpinner.getSelectedItemPosition()).getUnit().getAddresses());
            mUserAddressAdapter.notifyDataSetChanged();
        }
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
            }, mAccountRequestId, false, null, null);

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
            }, mAccountRequestId, false, null, null);

            // Getting the cost centers and updating the cost centers list
            CommerceApplication.getContentServiceHelper().getCostCenters(new ResponseReceiver<CostCenters>() {
                @Override
                public void onResponse(Response<CostCenters> response) {
                    mAccountCostCenterList = response.getData().getCostCenters();
                    populateCostCenter();
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, getActivity());
                }
            }, mAccountRequestId, false, null, null);

            mAccountFirstNameEditText.setText(mUser.getFirstName());
            mAccountLastNameEditText.setText(mUser.getLastName());
            mAccountEmailTextview.setText(getString(R.string.account_email, mUser.getDisplayUid()));
        }
    }


    /**
     * Init the cost center spinner
     */
    private void initCostCenterSpinner() {
        mAccountCostCenterSpinner = (Spinner) getView().findViewById(R.id.account_cost_center_spinner);
        mAccountCostCenterSpinner.setAdapter(mAccountCostCenterAdapter);
        mAccountCostCenterSpinner.setOnItemSelectedListener(mAccountCostCenterSpinnerListener);
    }


    /**
     * Init the User Title spinner
     */
    private void initUserTitleSpinner(int position) {
        mAccountUserTitleSpinner = (Spinner) getView().findViewById(R.id.account_user_title_spinner);
        mAccountUserTitleSpinner.setAdapter(mAccountUserTitleAdapter);
        mAccountUserTitleSpinner.setSelection(position);

    }

    /**
     * Init the Language spinner
     */
    private void initLanguageSpinner(int position) {
        mAccountLanguageSpinner = (Spinner) getView().findViewById(R.id.account_language_spinner);
        mAccountLanguageSpinner.setAdapter(mAccountLanguageAdapter);
        mAccountLanguageSpinner.setSelection(position);
    }


    /**
     * Class to handle_anchor User interaction with cost center spinner
     */
    public AdapterView.OnItemSelectedListener mAccountCostCenterSpinnerListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            updateUserAddressAdapter();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };


    private void populateCostCenter() {
        if (mAccountCostCenterList != null && !mAccountCostCenterList.isEmpty()) {

            // We re-init the spinner, because we always want to trigger the selection change even the index didnt change
            initCostCenterSpinner();

            // Create cost Center List Name
            List<String> costCenterList = new ArrayList<>();
            for (CostCenter costCenter : mAccountCostCenterList) {
                costCenterList.add(costCenter.getName());
            }

            mAccountCostCenterAdapter.clear();
            mAccountCostCenterAdapter.addAll(costCenterList);
            mAccountCostCenterAdapter.notifyDataSetChanged();
        }
    }

    private void populateTitle() {

        int titleIndex = 0;
        int i = 0;
        if (mTitleList != null && !mTitleList.isEmpty()) {

            // Create Title List Name
            List<String> userTitleList = new ArrayList<>();
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
            List<String> languageList = new ArrayList<>();
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

    /**
     * Show ProgressBar when Request is send and Hide ProgressBar when Response is received
     */
    private OnRequestListener mOnRequestListener = new OnRequestListener() {

        @Override
        public void beforeRequest() { //hide when loading

            UIUtils.showLoadingActionBar(getActivity(), true);
            getView().setVisibility(View.INVISIBLE);
        }

        @Override
        public void afterRequestBeforeResponse() {

        }

        @Override
        public void afterRequest(boolean isDataSynced) {
            getView().setVisibility(View.VISIBLE);
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

    public AdapterView.OnItemSelectedListener mAccountSpinnerListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            saveUser();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void saveUser() {

        boolean update = !StringUtils.equals(mAccountFirstNameEditText.getText().toString(), mUser.getFirstName())
                || !StringUtils.equals(mAccountLastNameEditText.getText().toString(), mUser.getLastName());

        if (mAccountUserTitleSpinner != null && mTitleList != null
                && mTitleList.get(mAccountUserTitleSpinner.getSelectedItemPosition()) != null) {

            update = update || !StringUtils
                    .equals(mTitleList.get(mAccountUserTitleSpinner.getSelectedItemPosition()).getCode(), mUser.getTitleCode());

        }

        if (mAccountLanguageSpinner != null && mLanguageList != null && mUser.getLanguage() != null
                && mLanguageList.get(mAccountLanguageSpinner.getSelectedItemPosition()) != null) {

            update = update || !StringUtils.equals(mLanguageList.get(mAccountLanguageSpinner.getSelectedItemPosition()).getIsocode(),
                    mUser.getLanguage().getIsocode());

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
                        Alert.showSuccess(getActivity(), getActivity().getString(R.string.account_user_profile_updated_message));
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, mAccountRequestId, null, false, null, null);
            }

            @Override
            public void onError(Response<ErrorList> response) {
                Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, mAccountRequestId, queryUser, null, false, null, null);

    }

    private EditText.OnEditorActionListener mOnEditorActionListener = new EditText.OnEditorActionListener()
    {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
        {
            if (actionId == EditorInfo.IME_ACTION_DONE)
            {
                saveUser();
                return true;
            }
            return false;
        }
    };

}