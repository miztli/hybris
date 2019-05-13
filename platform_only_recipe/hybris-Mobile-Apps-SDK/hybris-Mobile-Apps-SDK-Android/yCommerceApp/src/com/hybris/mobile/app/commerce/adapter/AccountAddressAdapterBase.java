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
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.commerce.data.user.Address;

import java.util.List;


/**
 * Adapter for the products of the order
 */
public class AccountAddressAdapterBase extends ArrayAdapter<Address> {

    protected List<Address> mAddresses;

    public AccountAddressAdapterBase(Activity context, List<Address> values, String requestId) {
        super(context, R.layout.item_account_address, values);
        this.mAddresses = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

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

            mAddressViewHolder.addressDefaultImageView.setVisibility(View.GONE);
            mAddressViewHolder.addressSetDefaultButton.setVisibility(View.INVISIBLE);

        }


        return rowView;
    }

    @Override
    public int getCount() {
        return mAddresses.size();
    }

    @Override
    public Activity getContext() {
        return (Activity) super.getContext();
    }

    /**
     * Contains all UI elements for Order to improve view display while scrolling
     */
    static class AddressViewHolder {

        LinearLayout addressDetailsLayout;
        Button addressDeleteButton;
        TextView addressContactDetails;
        TextView addressDetails;
        Button addressSetDefaultButton;
        ImageView addressDefaultImageView;

        public AddressViewHolder(View view, int position) {

            addressDetailsLayout = (LinearLayout) view.findViewById(R.id.address_details_layout);
            addressContactDetails = (TextView) view.findViewById(R.id.address_contact_details);
            addressDetails = (TextView) view.findViewById(R.id.address_details);
            addressDefaultImageView = (ImageView) view.findViewById(R.id.default_shipping_address_checked_image);
            addressSetDefaultButton = (Button) view.findViewById(R.id.address_set_default_button);
            addressDeleteButton = (Button) view.findViewById(R.id.address_delete_button);

            addressDetailsLayout.setContentDescription("address_details_layout" + position);
            addressContactDetails.setContentDescription("address_contact_details" + position);
            addressDetails.setContentDescription("address_details" + position);
            addressDefaultImageView.setContentDescription("default_shipping_address_checked_image" + position);
            addressSetDefaultButton.setContentDescription("address_set_default_button" + position);
            addressDeleteButton.setContentDescription("address_delete_button" + position);
        }
    }
}
