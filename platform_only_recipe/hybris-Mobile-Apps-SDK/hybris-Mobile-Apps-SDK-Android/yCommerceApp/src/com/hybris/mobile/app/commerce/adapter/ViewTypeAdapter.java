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
package com.hybris.mobile.app.commerce.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.view.ViewTypeItem;

import java.util.List;


/**
 * Adapter for the Item View Type located in the Catalog Header page
 */
public class ViewTypeAdapter extends ArrayAdapter<ViewTypeItem> {
    private List<ViewTypeItem> mViewTypes;

    public ViewTypeAdapter(Activity context, List<ViewTypeItem> values) {
        super(context, R.layout.item_view_type, values);
        this.mViewTypes = values;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return mViewTypes.size();
    }

    /**
     * Create the view for spinner item
     *
     * @param position    index of the item in the spinner
     * @param convertView View
     * @param parent
     * @return
     */
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_view_type, parent, false);
        } else {
            rowView = convertView;
        }

        ViewTypeItem viewTypeItem = mViewTypes.get(position);

        TextView viewTypeName = (TextView) rowView.findViewById(R.id.view_type_name);

        viewTypeName.setText(viewTypeItem.getName());
        viewTypeName.setCompoundDrawablesWithIntrinsicBounds(viewTypeItem.getImage(), 0, 0, 0);

        return rowView;
    }
}
