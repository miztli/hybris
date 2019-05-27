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
package com.hybris.mobile.app.commerce.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.AddressListFragment.OnAddressSelectedListener;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.query.QueryAddress;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.ui.view.Alert;

import java.util.List;


/**
 * Adapter for the products of the order
 */
public class AccountAddressAdapter extends AccountAddressAdapterBase {

    private String mRequestId;

    public AccountAddressAdapter(Activity context, List<Address> values, String requestId) {
        super(context, values, requestId);
        this.mAddresses = values;
        this.mRequestId = requestId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_account_address, parent, false);
            rowView.setTag(new AddressViewHolder(rowView, position));
        } else {
            rowView = convertView;
        }

        AddressViewHolder mAddressViewHolder = (AddressViewHolder) rowView.getTag();

        final Address address = getItem(position);

        if (address != null) {
            mAddressViewHolder.addressContactDetails.setText(
                    address.getTitle() + " " + address.getFirstName() + " " + address.getLastName());
            mAddressViewHolder.addressDetails.setText(address.getFormattedAddress());

            mAddressViewHolder.addressDefaultImageView.setVisibility(position == 0 ? View.VISIBLE : View.INVISIBLE);
            mAddressViewHolder.addressSetDefaultButton.setVisibility(position == 0 ? View.INVISIBLE : View.VISIBLE);
            mAddressViewHolder.addressDeleteButton.setVisibility(View.VISIBLE);

            mAddressViewHolder.addressSetDefaultButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    setDefaultAddress(address);
                    Alert.showSuccess(getContext(), getContext().getString(R.string.account_user_default_address_updated_message));


                }
            });

            mAddressViewHolder.addressDetailsLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ((OnAddressSelectedListener) getContext()).onAddressSelected(address);

                }
            });

            mAddressViewHolder.addressDeleteButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    AlertDialog dialog;
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage(R.string.address_delete_message)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    final QueryAddress queryAddress = new QueryAddress();
                                    queryAddress.setAddressId(address.getId());


                                    CommerceApplication.getContentServiceHelper().deleteUserAddress(new ResponseReceiverEmpty() {
                                        @Override
                                        public void onResponse(Response<EmptyResponse> response) {
                                            Alert.showSuccess(getContext(), getContext().getString(R.string.address_delete_success_message));

                                            if (position < mAddresses.size()) {
                                                mAddresses.remove(position);
                                            }
                                            ((OnAddressSelectedListener) getContext()).onAddressListRefreshed();

                                            //Default is the first but if deleted select the next one as default
                                            if (mAddresses != null && !mAddresses.isEmpty() && position == 0) {
                                                setDefaultAddress(mAddresses.get(0));
                                            }
                                        }

                                        @Override
                                        public void onError(Response<ErrorList> response) {

                                        }
                                    }, mRequestId, queryAddress, null, false, null, null);

                                    dialog.dismiss();

                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    dialog = builder.create();
                    dialog.show();
                }
            });

        }
        return rowView;
    }

    private void setDefaultAddress(Address address) {

        if (address != null) {
            QueryAddress queryAddress = new QueryAddress();

            queryAddress.setAddressId(address.getId());
            queryAddress.setLastName(address.getLastName());
            queryAddress.setCountry(address.getCountry());
            queryAddress.setTown(address.getTown());
            queryAddress.setPostalCode(address.getPostalCode());
            queryAddress.setTitleCode(address.getTitleCode());
            queryAddress.setFirstName(address.getFirstName());
            queryAddress.setRegion(address.getRegion());
            queryAddress.setLine2(address.getLine2());
            queryAddress.setLine1(address.getLine1());
            queryAddress.setBillingAddress(true);
            queryAddress.setVisibleInAddressBook(true);
            queryAddress.setShippingAddress(true);
            queryAddress.setCompanyName(address.getCompanyName());

            queryAddress.setDefaultAddress(true);

            CommerceApplication.getContentServiceHelper().replaceUserAddress(new ResponseReceiverEmpty() {
                @Override
                public void onResponse(Response<EmptyResponse> response) {

                    ((OnAddressSelectedListener) getContext()).onAddressListRefreshed();
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    Alert.showError(getContext(), ErrorUtils.getFirstErrorMessage(response.getData()));

                }
            }, mRequestId, queryAddress, null, false, null, null);
        }
    }
}
