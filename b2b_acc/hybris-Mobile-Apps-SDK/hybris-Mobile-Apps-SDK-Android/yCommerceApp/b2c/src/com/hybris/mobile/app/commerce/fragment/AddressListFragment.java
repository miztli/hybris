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
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.AccountAddressAdapter;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.AddressList;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.http.utils.RequestUtils;
import com.hybris.mobile.lib.ui.view.Alert;

import java.util.ArrayList;
import java.util.List;

public class AddressListFragment extends ListFragment {
    private static final String TAG = AddressListFragment.class.getCanonicalName();
    private String mAddressBookRequestId = RequestUtils.generateUniqueRequestId();
    private Button newAddressListFragment;

    OnAddressSelectedListener mActivity;

    // Container Activity must implement this interface
    public interface OnAddressSelectedListener {
        void onAddressSelected(Address address);

        void onAddressListRefreshed();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mActivity = (OnAddressSelectedListener) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

    }

    public static AddressListFragment newInstance() {
        AddressListFragment addressListFragment = new AddressListFragment();
        return addressListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
               View view = inflater.inflate(R.layout.fragment_address_list, container, false);
        newAddressListFragment = (Button) view.findViewById(R.id.address_list_new_button);

        newAddressListFragment.setOnClickListener(newAddressListFragmentButtonListener);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        CommerceApplication.getContentServiceHelper().getUserAddresses(new ResponseReceiver<AddressList>() {
            @Override
            public void onResponse(Response<AddressList> response) {

                AccountAddressAdapter addressAdapter = new AccountAddressAdapter(getActivity(), new ArrayList<Address>(), mAddressBookRequestId);
                List<Address> listAddresses = new ArrayList<>();
                setListAdapter(addressAdapter);

                if(response.getData().getAddresses() != null){
                    listAddresses = response.getData().getAddresses();
                }

                addressAdapter.clear();
                addressAdapter.addAll(listAddresses);
                addressAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError(Response<ErrorList> response) {
                Alert.showError(getActivity(), ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, mAddressBookRequestId, null, false, null, null);
    }


    /**
     * Define Action when cross button is clicked and quit the current product detail activity
     */
    protected View.OnClickListener newAddressListFragmentButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mActivity.onAddressSelected(null);

        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        CommerceApplication.getContentServiceHelper().cancel(mAddressBookRequestId);
    }

}
