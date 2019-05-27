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
import android.widget.ImageView;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.R;

import java.util.List;


/**
 * Adapter for main menu items
 */
public class MainMenuAdapter extends ArrayAdapter<MainMenuAdapter.MenuItem<? extends Activity>> {

    List<MenuItem<? extends Activity>> drawerItemList;

    public MainMenuAdapter(Context context, List<MenuItem<? extends Activity>> listItems) {
        super(context, R.layout.drawer_listview_item, listItems);
        this.drawerItemList = listItems;
    }

    @Override
    public int getCount() {
        return drawerItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        MenuItem<? extends Activity> drawerItem = this.drawerItemList.get(position);

        if (convertView == null) {
            view = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
                    R.layout.drawer_listview_item, parent, false);
        } else {
            view = convertView;
        }

        // Set the title and icon
        ((TextView) view.findViewById(R.id.main_menu_item_title)).setText(drawerItem.getTitle());
        ((ImageView) view.findViewById(R.id.main_menu_item_icon)).setImageDrawable(view.getResources().getDrawable(
                drawerItem.getIcon()));

        return view;
    }

    /**
     * Object for Drawer
     *
     * @param <T>
     */
    public static class MenuItem<T> {

        private int title;
        private int icon;
        private Class<T> activityClassName;

        public MenuItem(int title, int icon, Class<T> activityClassName) {
            super();
            this.title = title;
            this.icon = icon;
            this.activityClassName = activityClassName;
        }

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public Class<T> getActivityClassName() {
            return activityClassName;
        }

        public void setActivityClassName(Class<T> activityClassName) {
            this.activityClassName = activityClassName;
        }

    }

}
