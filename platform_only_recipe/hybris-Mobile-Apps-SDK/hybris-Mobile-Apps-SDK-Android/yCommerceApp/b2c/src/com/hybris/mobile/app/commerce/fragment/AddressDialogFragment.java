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
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.AddressListFragment.OnAddressSelectedListener;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.Country;
import com.hybris.mobile.lib.commerce.data.user.CountryList;
import com.hybris.mobile.lib.commerce.data.user.Title;
import com.hybris.mobile.lib.commerce.data.user.TitleList;
import com.hybris.mobile.lib.commerce.query.QueryAddress;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressDialogFragment extends Fragment {

    private static final String NESTED_FRAGMENT = "NESTED_FRAGMENT";
    private String mAddressRequestId = RequestUtils.generateUniqueRequestId();
    OnAddressSelectedListener mListener;

    private boolean mNestedFragment = true;

    private TextWatcher mTextWatcher;

    private Address mAddress;
    private EditText mAddressFirstNameEditText;
    private EditText mAddressLastNameEditText;
    private Spinner mAddressUserTitleSpinner;
    private Spinner mAddressCountrySpinner;
    private ArrayAdapter<String> mTitleAdapter;
    private List<Title> mTitleList;
    private ArrayAdapter<String> mCountryAdapter;
    private List<Country> mCountryList;
    private Button mAddressSaveButton;

    private EditText mAddressLine1Edittext;
    private EditText mAddressLine2Edittext;
    private EditText mAddressCityEdittext;
    private EditText mAddressPostalCodeEdittext;
    private EditText mAddressStateEdittext;

    private TextView mAddressTitle;


    public static AddressDialogFragment newInstance(boolean nestedFragment, TextWatcher textWatcher) {
        AddressDialogFragment addressDialogFragment = new AddressDialogFragment();
        Bundle args = new Bundle();
        args.putBoolean(NESTED_FRAGMENT, nestedFragment);
        addressDialogFragment.setArguments(args);
        addressDialogFragment.mTextWatcher = textWatcher;
        return addressDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNestedFragment = getArguments().getBoolean(NESTED_FRAGMENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_dialog, container, false);

        if (mNestedFragment) {
            view.findViewById(R.id.address_dialog_footer).setVisibility(View.GONE);
            view.setPadding(0, 0, 0, 0);
        }


        mAddressUserTitleSpinner = (Spinner) view.findViewById(R.id.address_user_title_spinner);
        mAddressSaveButton = (Button) view.findViewById(R.id.address_save_button);
        mAddressFirstNameEditText = (EditText) view.findViewById(R.id.address_firstname_edittext);
        mAddressLastNameEditText = (EditText) view.findViewById(R.id.address_lastname_edittext);
        mAddressCountrySpinner = (Spinner) view.findViewById(R.id.address_country_spinner);
        mAddressLine1Edittext = (EditText) view.findViewById(R.id.address_line1_edittext);
        mAddressLine2Edittext = (EditText) view.findViewById(R.id.address_line2_edittext);
        mAddressCityEdittext = (EditText) view.findViewById(R.id.address_city_edittext);
        mAddressPostalCodeEdittext = (EditText) view.findViewById(R.id.address_postal_code_edittext);
        mAddressStateEdittext = (EditText) view.findViewById(R.id.address_state_edittext);
        mAddressTitle = (TextView) view.findViewById(R.id.address_title);


        mTitleAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());


        mCountryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>());


        if (mAddress != null) {
            if (!mNestedFragment) {
                mAddressTitle.setText(R.string.address_book_title_edit);
                //getDialog().setTitle(R.string.address_book_title_edit);
            }

            mAddressFirstNameEditText.setText(mAddress.getFirstName());
            mAddressLastNameEditText.setText(mAddress.getLastName());
            mAddressLine1Edittext.setText(mAddress.getLine1());
            mAddressLine2Edittext.setText(mAddress.getLine2());
            mAddressCityEdittext.setText(mAddress.getTown());
            mAddressPostalCodeEdittext.setText(mAddress.getPostalCode());
            if (mAddress.getRegion() != null) {
                mAddressStateEdittext.setText(mAddress.getRegion().getIsocode());
            }

            mAddressSaveButton.setOnClickListener(mSaveAddressOnClickListener);

            populateTitle();
            populateCountry();

        } else {

            if (!mNestedFragment) {
                mAddressTitle.setText(R.string.address_book_title_new);
               // getDialog().setTitle(R.string.address_book_title_new);
            }

            mAddress = new Address();
            mAddressSaveButton.setText(getActivity().getString(R.string.address_dialog_done));
            mAddressSaveButton.setOnClickListener(mAddAddressOnClickListener);

            populateTitle();
            populateCountry();

        }

        mAddressUserTitleSpinner.setOnItemSelectedListener(mAddressDialogSpinnerListener);
        mAddressCountrySpinner.setOnItemSelectedListener(mAddressDialogSpinnerListener);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mTextWatcher != null) {
            setTextWatcherForFields();
        }
    }

    public void setAddress(Address address) {
        mAddress = address;

    }


    private void populateTitle() {

        // Getting the title and updating the title list
        CommerceApplication.getContentServiceHelper().getTitles(new ResponseReceiver<TitleList>() {

            @Override
            public void onResponse(Response<TitleList> response) {
                int titleIndex = 0;
                int i = 0;
                mTitleList = response.getData().getTitles();

                if (mTitleList != null && !mTitleList.isEmpty()) {

                    // Create Title List Name
                    List<String> userTitleList = new ArrayList<String>();
                    for (Title title : mTitleList) {
                        userTitleList.add(title.getName());

                        if (StringUtils.equals(title.getCode(), mAddress.getTitleCode())) {
                            titleIndex = i;
                        }
                        i++;
                    }

                    mAddressUserTitleSpinner.setAdapter(mTitleAdapter);
                    mAddressUserTitleSpinner.setSelection(titleIndex);

                    mTitleAdapter.clear();
                    mTitleAdapter.addAll(userTitleList);
                    mTitleAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, mAddressRequestId, false, null, null);

    }

    private void populateCountry() {

        // Getting the title and updating the title list
        CommerceApplication.getContentServiceHelper().getDeliveryCountries(new ResponseReceiver<CountryList>() {

            @Override
            public void onResponse(Response<CountryList> response) {
                int countryIndex = 0;
                int i = 0;
                mCountryList = response.getData().getCountries();

                if (mCountryList != null && !mCountryList.isEmpty()) {

                    // Create Title List Name
                    List<String> countryList = new ArrayList<String>();
                    for (Country country : mCountryList) {
                        countryList.add(country.getName());


                        if (mAddress.getCountry() != null && StringUtils.equals(country.getIsocode(), mAddress.getCountry().getIsocode())) {
                            countryIndex = i;
                        }
                        i++;
                    }

                    mAddressCountrySpinner.setAdapter(mCountryAdapter);
                    mAddressCountrySpinner.setSelection(countryIndex);

                    mCountryAdapter.clear();
                    mCountryAdapter.addAll(countryList);
                    mCountryAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Response<ErrorList> response) {
                UIUtils.showError(response, getActivity());
            }
        }, mAddressRequestId, false, null, null);

    }

    public AdapterView.OnItemSelectedListener mAddressDialogSpinnerListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (parent.getId()) {
                case R.id.address_user_title_spinner:
                    if (mTitleList != null && !mTitleList.isEmpty()) {
                        mAddress.setTitleCode(mTitleList.get(position).getCode());
                    }
                    break;
                case R.id.address_country_spinner:
                    if (mCountryList != null && !mCountryList.isEmpty()) {
                        mAddress.setCountry(mCountryList.get(position));
                    }
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    public View.OnClickListener mSaveAddressOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (isAddressValid()) {

                QueryAddress mQueryAddress = new QueryAddress();

                mQueryAddress.setAddressId(mAddress.getId());
                mQueryAddress.setTitleCode(mAddress.getTitleCode());
                mQueryAddress.setFirstName(mAddress.getFirstName());
                mQueryAddress.setLastName(mAddress.getLastName());
                mQueryAddress.setTown(mAddress.getTown());
                mQueryAddress.setPostalCode(mAddress.getPostalCode());
                mQueryAddress.setLine1(mAddress.getLine1());
                mQueryAddress.setLine2(mAddress.getLine2());
                mQueryAddress.setCountry(mAddress.getCountry());
                mQueryAddress.setCompanyName(mAddress.getCompanyName());
                mQueryAddress.setRegion(mAddress.getRegion());

                mQueryAddress.setVisibleInAddressBook(mAddress.getVisibleInAddressBook());
                mQueryAddress.setBillingAddress(mAddress.getShippingAddress());
                mQueryAddress.setShippingAddress(mAddress.getVisibleInAddressBook());
                CommerceApplication.getContentServiceHelper().replaceUserAddress(new ResponseReceiverEmpty() {
                    @Override
                    public void onResponse(Response<EmptyResponse> response) {

                        dismissFragment();
                        Alert.showSuccess(getActivity(), getActivity().getString(R.string.address_updated_message));


                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));

                    }
                }, mAddressRequestId, mQueryAddress, null, false, null, null);
            } else {
                Alert.showError(getActivity(), getActivity().getString(R.string.account_error_missing_fields_message));
            }
        }
    };

    public View.OnClickListener mAddAddressOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (isAddressValid()) {


                QueryAddress mQueryAddress = new QueryAddress();
                mQueryAddress.setTitleCode(mAddress.getTitleCode());
                mQueryAddress.setFirstName(mAddress.getFirstName());
                mQueryAddress.setLastName(mAddress.getLastName());
                mQueryAddress.setTown(mAddress.getTown());
                mQueryAddress.setPostalCode(mAddress.getPostalCode());
                mQueryAddress.setLine1(mAddress.getLine1());
                mQueryAddress.setLine2(mAddress.getLine2());
                mQueryAddress.setCountry(mAddress.getCountry());
                mQueryAddress.setCompanyName(mAddress.getCompanyName());
                mQueryAddress.setRegion(mAddress.getRegion());

                mQueryAddress.setVisibleInAddressBook(true);
                mQueryAddress.setBillingAddress(true);
                mQueryAddress.setShippingAddress(true);
                CommerceApplication.getContentServiceHelper().createUserAddress(new ResponseReceiver<Address>() {
                    @Override
                    public void onResponse(Response<Address> response) {
                        dismissFragment();

                        Alert.showSuccess(getActivity(), getActivity().getString(R.string.address_new_message));

                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
                    }
                }, mAddressRequestId, mQueryAddress, null, false, Arrays.asList((View) mAddressSaveButton), null);
            } else {
                Alert.showError(getActivity(), getActivity().getString(R.string.account_error_missing_fields_message));

            }
        }
    };


    public boolean isAddressValid() {

        if(mTitleList != null && !mTitleList.isEmpty()) {
            mAddress.setTitleCode(mTitleList.get(mAddressUserTitleSpinner.getSelectedItemPosition()).getCode());
            mAddress.setTitle(mTitleList.get(mAddressUserTitleSpinner.getSelectedItemPosition()).getName());
        }

        mAddress.setFirstName(mAddressFirstNameEditText.getText().toString());
        mAddress.setLastName(mAddressLastNameEditText.getText().toString());
        mAddress.setTown(mAddressCityEdittext.getText().toString());
        mAddress.setPostalCode(mAddressPostalCodeEdittext.getText().toString());
        mAddress.setLine1(mAddressLine1Edittext.getText().toString());
        mAddress.setLine2(mAddressLine2Edittext.getText().toString());

        if (mCountryList != null && !mCountryList.isEmpty()) {
            mAddress.setCountry(mCountryList.get(mAddressCountrySpinner.getSelectedItemPosition()));
        }
        return !(mAddress == null || StringUtils.isBlank(mAddress.getFirstName()) || StringUtils
                .isBlank(mAddress.getTitleCode()) || StringUtils.isBlank(mAddress.getLastName())
                || mAddress.getCountry() == null || StringUtils.isBlank(mAddress.getCountry().getIsocode()) || StringUtils
                .isBlank(mAddress.getTown()) || StringUtils.isBlank(mAddress.getLine1()));
    }


    private void dismissFragment() {

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }
        mListener = (OnAddressSelectedListener) getActivity();
        mListener.onAddressListRefreshed();
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mAddressRequestId);
    }

    public void setTextWatcherForFields() {
        mAddressFirstNameEditText.addTextChangedListener(mTextWatcher);
        mAddressLastNameEditText.addTextChangedListener(mTextWatcher);
        mAddressCityEdittext.addTextChangedListener(mTextWatcher);
        mAddressPostalCodeEdittext.addTextChangedListener(mTextWatcher);
        mAddressLine1Edittext.addTextChangedListener(mTextWatcher);
        mAddressLine2Edittext.addTextChangedListener(mTextWatcher);
    }

    public Address getAddress() {
        return mAddress;
    }

}
