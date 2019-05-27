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
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.StoreDetailsActivity;
import com.hybris.mobile.app.commerce.fragment.StoreListFragment;
import com.hybris.mobile.app.commerce.listener.DeviceLocation;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;
import com.hybris.mobile.lib.location.LocationUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StoreListAdapter extends ArrayAdapter<PointOfService> {

    private static final String TAG = StoreListAdapter.class.getCanonicalName();

    private DeviceLocation mDeviceLocation;
    private StoreListFragment.MapActions mMapActions;

    public StoreListAdapter(Activity context, DeviceLocation deviceLocation, StoreListFragment.MapActions mapActions, List<PointOfService> values) {
        super(context, R.layout.item_store_locator, values);
        mDeviceLocation = deviceLocation;
        mMapActions = mapActions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_store_locator, parent, false);
            rowView.setTag(new ViewHolder(rowView));
        } else {
            rowView = convertView;
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        // Content description
        viewHolder.storePosition.setContentDescription("storePosition_" + position);
        viewHolder.name.setContentDescription("name_" + position);
        viewHolder.description.setContentDescription("description_" + position);
        viewHolder.tel.setContentDescription("tel_" + position);
        viewHolder.directions.setContentDescription("directions_" + position);
        viewHolder.distance.setContentDescription("distance_" + position);

        final PointOfService store = getItem(position);

        // Setting the values
        viewHolder.storePosition.setText(position + 1 + ". ");
        viewHolder.name.setText(store.getName());
        viewHolder.description.setText(store.getAddress().getFormattedAddress());
        viewHolder.tel.setText(store.getAddress().getPhone());
        viewHolder.distance.setText(store.getFormattedDistance());

        // Distance intent
        viewHolder.directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDeviceLocation != null && mDeviceLocation.getDeviceLocation() != null) {
                    LocationUtils.sendDirectionsIntent(getContext(), new LatLng(mDeviceLocation.getDeviceLocation().getLatitude(), mDeviceLocation.getDeviceLocation().getLongitude()), new LatLng(store.getGeoPoint().getLatitude(), store.getGeoPoint().getLongitude()));
                } else {
                    LocationUtils.sendDirectionsIntent(getContext(), null, new LatLng(store.getGeoPoint().getLatitude(), store.getGeoPoint().getLongitude()));
                }
            }
        });

        // Center map when clicking on the name and description
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                centerMap(store);
            }
        });

        viewHolder.description
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        centerMap(store);
                    }
                });

        return rowView;
    }

    private void centerMap(PointOfService store) {
        if (mMapActions != null) {
            mMapActions.centerMap(new LatLng(store.getGeoPoint().getLatitude(), store.getGeoPoint().getLongitude()));
        }
    }

    static class ViewHolder {
        private TextView storePosition;
        private TextView name;
        private TextView description;
        private TextView tel;
        private TextView directions;
        private TextView distance;

        public ViewHolder(View view) {
            storePosition = (TextView) view.findViewById(R.id.store_list_position);
            name = (TextView) view.findViewById(R.id.store_list_name);
            description = (TextView) view.findViewById(R.id.store_list_description);
            tel = (TextView) view.findViewById(R.id.store_list_tel);
            description = (TextView) view.findViewById(R.id.store_list_description);
            directions = (TextView) view.findViewById(R.id.store_list_directions);
            distance = (TextView) view.findViewById(R.id.store_list_distance);

            tel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (StringUtils.isNotBlank(tel.getText())) {
                        try {
                            v.getContext().startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel.getText().toString().replaceAll("[^\\d.]", ""))));
                        } catch (ActivityNotFoundException e) {
                            Log.e(TAG, e.getLocalizedMessage());
                        }
                    }
                }
            });

            distance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), StoreDetailsActivity.class);
                    intent.putExtra(IntentConstants.STORE_NAME, name.getText());
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
