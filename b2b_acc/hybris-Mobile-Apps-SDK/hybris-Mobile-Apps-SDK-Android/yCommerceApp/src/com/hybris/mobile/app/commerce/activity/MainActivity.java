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
package com.hybris.mobile.app.commerce.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.adapter.MainMenuAdapter;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.HockeyAppUtils;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.scanner.callback.ScannerCallback;
import com.hybris.mobile.lib.scanner.data.BarcodeData;
import com.hybris.mobile.lib.ui.layout.DrawerPushLayout;
import com.hybris.mobile.lib.ui.layout.DrawerPushLayout.DrawerPushLayoutListener;
import com.hybris.mobile.lib.ui.view.Alert;
import com.hybris.mobile.lib.ui.view.Alert.Configuration;
import com.hybris.mobile.lib.ui.view.Alert.Configuration.Orientation;
import com.hybris.mobile.lib.ui.view.Alert.Configuration.Position;

import java.util.ArrayList;
import java.util.List;


/**
 * Global activity that uses a main menu drawer, the cart menu and an action bar
 */
public abstract class MainActivity extends ApplicationActivity implements ScannerCallback {
    private DrawerPushLayout mCartDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mContentViewId;
    private boolean mIsMainMenuSwipeEnabled = true;
    private boolean mOpenMainMenuByDefault = false;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Allow the system loading spinner icon
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        super.setContentView(mContentViewId);

        // Main menu drawer
        createMainMenuDrawer();

        // Action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayShowTitleEnabled(false);

        // Cart menu drawer
        mCartDrawer = (DrawerPushLayout) findViewById(R.id.cart_menu_drawer);

        if (mCartDrawer != null) {
            mCartDrawer.setScrimColor(Color.TRANSPARENT);
            mCartDrawer.setDrawerPushLayoutListener(new DrawerPushLayoutListener() {
                @Override
                public void onDrawerOpened() {
                    // When the cart is open, we disable the opening by swipe on the main menu
                    mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

                    UIUtils.hideKeyboard(MainActivity.this);
                }

                @Override
                public void onDrawerClosed() {
                    // When the drawer is closed, we enable opening by swipe on the main menu if the opening by swipe is enabled
                    if (mIsMainMenuSwipeEnabled) {
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                    }

                    UIUtils.hideKeyboard(MainActivity.this);
                }
            });
        }
    }

    /**
     * Create the main menu drawer
     */
    private void createMainMenuDrawer() {
        // Drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_menu_drawer);
        final ListView drawerListView = (ListView) findViewById(R.id.main_menu_list_elements);

        // Drawer items
        List<MainMenuAdapter.MenuItem<? extends Activity>> drawerItemsList = new ArrayList<>();
        drawerItemsList.add(new MainMenuAdapter.MenuItem<>(R.string.main_menu_item_dashboard,
                R.drawable.b2b_icon_dashboard, DashboardActivity.class));
        drawerItemsList.add(new MainMenuAdapter.MenuItem<>(R.string.main_menu_item_orders,
                R.drawable.b2b_icon_orders, OrderHistoryActivity.class));
        drawerItemsList.add(new MainMenuAdapter.MenuItem<>(R.string.main_menu_item_catalog,
                R.drawable.b2b_icon_catalog, CatalogActivity.class));
        drawerItemsList.add(new MainMenuAdapter.MenuItem<>(R.string.main_menu_item_account,
                R.drawable.b2b_icon_account, AccountActivity.class));
        drawerItemsList.add(new MainMenuAdapter.MenuItem<>(R.string.main_menu_item_store_locator,
                R.drawable.b2b_icon_stores, StoreLocatorActivity.class));

        // Set the adapter for the drawer
        drawerListView.setAdapter(new MainMenuAdapter(this, drawerItemsList));

        // Item click
        drawerListView.setOnItemClickListener(new OnItemClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainMenuAdapter.MenuItem<? extends Activity> drawerItem = (MainMenuAdapter.MenuItem<? extends Activity>)
                        drawerListView
                                .getAdapter().getItem(position);

                startActivity(new Intent(MainActivity.this, drawerItem.getActivityClassName()));
            }
        });

        // Drawer toggle associated with action bar elements
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.main_menu_open,
                R.string.main_menu_close) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Swipe disabled
        if (!mIsMainMenuSwipeEnabled) {
            // Open with click on the menu only
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

        // Drawer shadow
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
    }

    /**
     * Set the main content view id
     */
    public void setContentView(int viewId) {
        mContentViewId = viewId;
    }

    /**
     * Disable the open with swipe on the main menu drawer
     */
    public void disableMainMenuSwipe() {
        mIsMainMenuSwipeEnabled = false;
    }

    /**
     * Enable/disable the default behavior for the main menu opening
     *
     * @param mOpenMainMenuByDefault if true Open Main Menu else close
     */
    public void setOpenMainMenuByDefault(boolean mOpenMainMenuByDefault) {
        this.mOpenMainMenuByDefault = mOpenMainMenuByDefault;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);

        // HockeyApp feedback
        menu.findItem(R.id.menu_feedback).setOnMenuItemClickListener(new OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                HockeyAppUtils.showFeedbackActivity(MainActivity.this);
                return true;
            }
        });

        // Sync Settings
        menu.findItem(R.id.menu_settings).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            }
        });

        // Barcode scanner
        menu.findItem(R.id.menu_scanner).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CommerceApplication.getScannerHelper().launch(MainActivity.this, MainActivity.this);
                return true;
            }
        });

        // Cart items
        MenuItem item = menu.findItem(R.id.b2b_icon_cart);

        if (mCartDrawer != null) {

            // Onclick to open/hide cart menu
            item.getActionView().setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (mDrawerLayout != null) {
                        mDrawerLayout.closeDrawers();
                    }
                    if (mCartDrawer.isDrawerOpen(mCartDrawer.getChildAt(1))) {
                        mCartDrawer.closeDrawer(mCartDrawer.getChildAt(1));
                    } else {
                        mCartDrawer.openDrawer(mCartDrawer.getChildAt(1));
                    }
                }
            });
        } else {
            menu.removeItem(R.id.b2b_icon_cart);
        }

        // Search component
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.b2b_icon_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);

        return true;
    }

    @Override
    public void onScan(BarcodeData barcodeData) {
        Alert.showSuccess(this, barcodeData.getData() + " - " + barcodeData.getFormat());
    }

    @Override
    public void onCancelScan() {
        Alert.showSuccess(this, "Scan cancelled");
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.b2b_icon_cart);

        if (item != null) {
            final TextView totalItems = (TextView) item.getActionView().findViewById(R.id.cart_total_unit_text);

            totalItems.setVisibility(View.VISIBLE);
            totalItems.setText(SessionHelper.getCartTotalUnitCount() + "");

            // Updating cart item numbers OR resetting the view with the item numbers
            if (SessionHelper.getCartTotalUnitCount() != SessionHelper.getCartTotalUnitCountPrevious()) {

                // Animate the view by a scaleIn / scaleOut
                totalItems.animate().scaleYBy(UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_FACTOR).setDuration(
                        UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION).setListener(null);
                totalItems.animate().scaleXBy(UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_FACTOR).setDuration(
                        UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION).setListener(new AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        // We scale out at the original size
                        if (SessionHelper.getCartTotalUnitCount() > 0) {
                            SessionHelper.syncCartTotalUnitCountPrevious();

                            totalItems.animate().scaleXBy(-UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_FACTOR).setDuration(
                                    UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION).setListener(null);
                            totalItems.animate().scaleYBy(-UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_FACTOR).setDuration(
                                    UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION).setListener(null);
                        }
                        // Or if we just empty the cart, we scale out completely and hide the view
                        else if (SessionHelper.getCartTotalUnitCountPrevious() != 0) {
                            SessionHelper.resetCartTotalUnitCountPrevious();

                            totalItems.animate().scaleXBy(-1.5f).setDuration(UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION)
                                    .setListener(null);
                            totalItems.animate().scaleYBy(-1.5f).setDuration(UIUtils.CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION)
                                    .setListener(new AnimatorListener() {

                                        @Override
                                        public void onAnimationStart(Animator animation) {
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animator animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            totalItems.setVisibility(View.GONE);
                                        }

                                        @Override
                                        public void onAnimationCancel(Animator animation) {
                                        }
                                    });
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }
                });
            } else if (SessionHelper.getCartTotalUnitCount() == 0) {
                totalItems.setVisibility(View.GONE);
            }
        }

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Submit crash to HockeyApp
        HockeyAppUtils.checkForCrashes(this);

        // Open the main menu by default
        if (mOpenMainMenuByDefault) {
            mDrawerLayout.openDrawer(mDrawerLayout.getChildAt(1));
        }

        Configuration configuration = new Configuration();
        configuration.setOrientation(Orientation.TOP);
        configuration.setOverlayContent(false);

        // Display the offline top notification
        if (!CommerceApplication.isOnline()) {
            configuration.setColorBackgroundResId(getResources().getColor(R.color.background_offline_status_top_nav));
            configuration.setColorTextResId(getResources().getColor(R.color.text_offline_status_top_nav));
            configuration.setCloseable(false);
            configuration.setIconResId(android.R.drawable.stat_sys_warning);
            configuration.setIconPosition(Position.LEFT_TEXT);

            Alert.show(this, configuration, getString(R.string.offline_status_top_nav, CommerceApplication.getCatalogLastSyncDate()),
                    true);
        }
        // Hide the offline top notification
        else {
            Alert.hide(this, configuration);
        }

        invalidateOptionsMenu();

        // Login / logout views
        View login = findViewById(R.id.main_menu_login);
        View logout = findViewById(R.id.main_menu_logout);

        // Logout
        if (SessionHelper.isUserLoggedIn()) {
            login.setVisibility(View.GONE);
            login.setOnClickListener(null);
            logout.setVisibility(View.VISIBLE);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SessionHelper.logout(MainActivity.this, true);
                }
            });
        }
        // Login
        else {
            logout.setVisibility(View.GONE);
            logout.setOnClickListener(null);
            login.setVisibility(View.VISIBLE);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            });
        }
    }
}
