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

package com.hybris.mobile.lib.commerce.sync;

import android.accounts.Account;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.hybris.mobile.lib.commerce.Constants;
import com.hybris.mobile.lib.commerce.R;
import com.hybris.mobile.lib.commerce.data.catalog.CategoryHierarchy;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.VariantOption;
import com.hybris.mobile.lib.commerce.provider.CatalogContract;
import com.hybris.mobile.lib.commerce.provider.CatalogContract.SyncStatus;
import com.hybris.mobile.lib.commerce.query.QueryCatalog;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Sync adapter for the catalog
 */
public abstract class CatalogSyncAdapter extends AbstractThreadedSyncAdapter {

    private static final String TAG = CatalogSyncAdapter.class.getCanonicalName();
    private static String AUTHORITY;

    protected ContentServiceHelper mContentServiceHelper;
    private NotificationManager mNotifyManager;
    private Notification mNotification;
    private int mNotificationId = new Random().nextInt();
    private AtomicInteger mNbCalls;
    private CountDownLatch mBlockSync;
    // Used to know when the sync is done
    private OnRequestListener mOnRequestListenerEndOfSync = new OnRequestListener() {

        @Override
        public void beforeRequest() {
            mNbCalls.incrementAndGet();
        }

        @Override
        public void afterRequestBeforeResponse() {

        }

        @Override
        public void afterRequest(boolean isDataSynced) {
            if (mNbCalls.decrementAndGet() == 0) {
                showNotificationProgress(false);

                if (mBlockSync != null) {
                    mBlockSync.countDown();
                }
            }
        }
    };

    public CatalogSyncAdapter(Context context, boolean autoInitialize, ContentServiceHelper contentServiceHelper) {
        super(context, autoInitialize);
        mContentServiceHelper = contentServiceHelper;

        // Notification
        mNotifyManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(getContext());
        builder.setContentTitle(getContext().getString(R.string.sync_notification_title))
                .setContentText(getContext().getString(R.string.sync_notification_description)).setSmallIcon(R.drawable.ic_provider);
        builder.setProgress(0, 0, true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotification = builder.build();
        } else {
            mNotification = builder.getNotification();
        }

        // Authority & Account
        AUTHORITY = contentServiceHelper.getConfiguration().getCatalogAuthority();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider,
                              SyncResult syncResult) {

        Log.i(TAG, "Receiving a sync with bundle: " + extras.toString());

        // Get some optional parameters
        String categoryId = extras.getString(CatalogSyncConstants.SYNC_PARAM_GROUP_ID);
        String productId = extras.getString(CatalogSyncConstants.SYNC_PARAM_DATA_ID);
        boolean loadVariants = extras.getBoolean(CatalogSyncConstants.SYNC_PARAM_LOAD_VARIANTS);
        String contentServiceHelperUrl = extras.getString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_URL);
        boolean cancelAllRequests = extras.getBoolean(CatalogSyncConstants.SYNC_PARAM_CANCEL_ALL_REQUESTS);

        // Update the content service helper url
        if (StringUtils.isNotBlank(contentServiceHelperUrl)) {
            String catalog = extras.getString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_CATALOG);
            String catalogId = extras.getString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_CATALOG_ID);
            String catalogVersionId = extras.getString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_CATALOG_VERSION_ID);
            String catalogMainCategoryId = extras.getString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_MAIN_CATEGORY_ID);
            updateContentServiceHelperUrlConfiguration(contentServiceHelperUrl, catalog, catalogId, catalogVersionId, catalogMainCategoryId);
        }
        // Cancelling all the requests
        else if (cancelAllRequests) {
            cancelAllRequests();
        }
        // Sync a category
        else if (StringUtils.isNotBlank(categoryId)) {
            Log.i(TAG, "Syncing the category " + categoryId);

            int currentPage = 0;
            int pageSize = 0;

            if (extras.containsKey(CatalogSyncConstants.SYNC_PARAM_CURRENT_PAGE)
                    && extras.containsKey(CatalogSyncConstants.SYNC_PARAM_PAGE_SIZE)) {
                currentPage = extras.getInt(CatalogSyncConstants.SYNC_PARAM_CURRENT_PAGE);
                pageSize = extras.getInt(CatalogSyncConstants.SYNC_PARAM_PAGE_SIZE);
            }

            syncCategory(categoryId, currentPage, pageSize);

        }
        // Sync a product
        else if (StringUtils.isNotBlank(productId)) {
            Log.i(TAG, "Syncing the product " + productId);

            loadProduct(productId, categoryId, null, false, loadVariants);
        }
        // Sync all the catalog
        else {
            Log.i(TAG, "Syncing the catalog");

            // Init nb calls counter and blocker
            mNbCalls = new AtomicInteger();
            mBlockSync = new CountDownLatch(1);

            String categories = extras.getString(CatalogSyncConstants.SYNC_PARAM_GROUP_ID_LIST);

            try {
                String[] categoryList = null;

                if (StringUtils.isNotBlank(categories)) {
                    categoryList = categories.split(CatalogSyncConstants.SYNC_PARAM_GROUP_ID_LIST_SEPARATOR);
                }

                syncCatalog(categoryList);

                // Save the date
                mContentServiceHelper.saveCatalogLastSyncDate(new Date().getTime());

                // Showing the notification
                showNotificationProgress(true);

                // Wait for the end of the sync
                mBlockSync.await(getContext().getResources().getInteger(R.integer.sync_timeout_in_min), TimeUnit.MINUTES);

            } catch (InterruptedException e) {
                Log.e(TAG, "Error syncing the catalog");
            }
        }
    }

    /**
     * Sync a specific category
     *
     * @param categoryId  Unique Identifier for a specific Category of product
     * @param currentPage Page Number to be received in response
     * @param pageSize    Amount of product per page
     * @throws InterruptedException
     */
    private void syncCategory(final String categoryId, int currentPage, int pageSize) {
        Log.i(TAG, "Syncing the category " + categoryId + ", page " + currentPage + " and page size " + pageSize);

        QueryProducts queryProducts = new QueryProducts();
        queryProducts.setIdCategory(categoryId);

        if (currentPage != 0) {
            queryProducts.setCurrentPage(currentPage);
        }

        if (pageSize != 0) {
            queryProducts.setPageSize(pageSize);
        }


        getProducts(queryProducts, false, null, new Callback() {
            @Override
            public void onProductsLoadedSuccess(List<DataSync> products, Long total) {

                Log.i(TAG, "Response received after syncing the category " + categoryId);

                List<String> listCategory = new ArrayList<>();
                listCategory.add(categoryId);

                // Saving all the products
                if (products != null && !products.isEmpty()) {
                    for (DataSync product : products) {
                        saveProduct(product, listCategory, false);
                    }
                }

                // Update the sync status for the category
                ContentValues contentValues = new ContentValues();
                contentValues.put(CatalogContract.DataBaseSyncStatusGroup.ATT_GROUP_ID, categoryId);
                contentValues.put(CatalogContract.DataBaseSyncStatusGroup.ATT_STATUS, SyncStatus.UPTODATE.getValue());
                getContext().getContentResolver().update(Uri.withAppendedPath(CatalogContract.Provider.getUriSyncGroup(AUTHORITY), categoryId),
                        contentValues, null, null);

                // Notify the content provider
                Uri uriToNotify = Uri.withAppendedPath(CatalogContract.Provider.getUriGroup(AUTHORITY), categoryId);

                Log.i(TAG, "Notify category changes for " + uriToNotify);
                getContext().getContentResolver().notifyChange(uriToNotify, null);

            }

            @Override
            public void onProductsLoadedError() {

            }
        });
    }

    /**
     * Sync the catalog
     *
     * @param categoryList List of categories
     * @throws InterruptedException
     */
    private void syncCatalog(final String[] categoryList) {
        Log.i(TAG, "Syncing the catalog for categories " + Arrays.toString(categoryList));

        QueryCatalog queryCatalog = new QueryCatalog();
        queryCatalog.setCatalogId(mContentServiceHelper.getConfiguration().getCatalogId());
        queryCatalog.setCatalogVersionId(mContentServiceHelper.getConfiguration().getCatalogVersionId());
        queryCatalog.setCatalogCategoryId(mContentServiceHelper.getConfiguration().getCatalogIdMainCategory());

        // Getting all the catalog with the cache parameter to true
        mContentServiceHelper.getCatalogCategory(new ResponseReceiver<CategoryHierarchy>() {

            @Override
            public void onResponse(Response<CategoryHierarchy> response) {
                Log.i(TAG, "Response received after syncing the catalog");

                // Because we cache this call - see the parameter true - we get first the cached data
                // We do the work only with the synced data
                if (response.isSync()) {

                    // Create the links with the parent for all the categories
                    if (response.getData() != null && response.getData().getSubcategories() != null) {
                        for (CategoryHierarchy categoryHierarchy : response.getData().getSubcategories()) {
                            categoryHierarchy.setParent(response.getData());
                        }
                    }

                    // We loop specific categories
                    if (categoryList != null && categoryList.length > 0) {
                        Log.i(TAG, "Syncing the categories: " + Arrays.toString(categoryList));

                        for (final String aCategoryList : categoryList) {
                            if (StringUtils.isNotBlank(aCategoryList)) {
                                // Finding the category that matches the id
                                CategoryHierarchy categoryHierarchy = getCategory(response.getData(), aCategoryList);

                                if (categoryHierarchy != null) {
                                    // Deleting the product-category links first
                                    getContext().getContentResolver().delete(Uri.withAppendedPath(
                                            CatalogContract.Provider.getUriGroup(AUTHORITY), categoryHierarchy.getId()), null, null);

                                    Log.i(TAG, "Syncing the category " + categoryHierarchy.getId());
                                    loopCategory(categoryHierarchy, 0, false, true);
                                }
                            }
                        }
                    }
                    // We loop through all the categories
                    else {
                        // Deleting all the product-category links first
                        getContext().getContentResolver().delete(CatalogContract.Provider.getUriGroup(AUTHORITY), null, null);

                        Log.i(TAG, "Syncing the entire catalog");
                        loopCategory(response.getData(), 0, true, true);
                    }

                    // We send a message to update the cache on the app
                    LocalBroadcastManager.getInstance(getContext()).sendBroadcast(
                            new Intent(getContext().getString(R.string.intent_action_update_cache)));
                }
            }

            @Override
            public void onError(Response<ErrorList> response) {
                Log.e(TAG, ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, null, queryCatalog, true, null, null);
    }

    /**
     * Find in the category and subcategories, the category that matches the id
     *
     * @param categoryHierarchy Category to be searched
     * @param categoryId        Unique Identifier for a specific Category of product
     * @return Category found
     */
    private CategoryHierarchy getCategory(CategoryHierarchy categoryHierarchy, String categoryId) {

        if (StringUtils.equals(categoryHierarchy.getId(), categoryId)) {
            return categoryHierarchy;
        } else if (categoryHierarchy.getSubcategories() != null) {
            CategoryHierarchy categoryHierarchyToFind = null;
            int i = 0;

            while (categoryHierarchyToFind == null && i < categoryHierarchy.getSubcategories().size()) {
                categoryHierarchyToFind = getCategory(categoryHierarchy.getSubcategories().get(i), categoryId);
                i++;
            }

            return categoryHierarchyToFind;
        }

        return null;
    }

    /**
     * Loop and save the products and sub-categories of a specific category
     *
     * @param categoryHierarchy Category to be searched
     * @param currentPage       Page Number to be received in response
     * @param loopSubCategories Subcategory to be searched
     * @param loadVariants      True Load variant else false
     */
    private void loopCategory(final CategoryHierarchy categoryHierarchy, final int currentPage, final boolean loopSubCategories, final boolean loadVariants) {
        Log.i(TAG, "Syncing the products of the category " + categoryHierarchy.getId() + " for page " + currentPage + " to "
                + Constants.CATALOG_MAX_PAGE_SIZE);

        final QueryProducts queryProducts = new QueryProducts();
        queryProducts.setIdCategory(categoryHierarchy.getId());
        queryProducts.setCurrentPage(currentPage);
        queryProducts.setPageSize(Constants.CATALOG_MAX_PAGE_SIZE);

        getProducts(queryProducts, false, mOnRequestListenerEndOfSync, new Callback() {
            @Override
            public void onProductsLoadedSuccess(List<DataSync> products, Long total) {
                Log.i(TAG, "Response received after syncing the products of the category " + categoryHierarchy.getId());

                // Construct the list of the parent category ids
                List<String> parentCategoriesId = getParentsCategoriesIds(categoryHierarchy, new ArrayList<String>());

                // Loading the products
                if (products != null) {
                    for (DataSync product : products) {
                        loadProduct(product.getId(), categoryHierarchy.getId(), parentCategoriesId, true, loadVariants);
                    }
                }

                // Loading the next pages of products and subcategories
                if (currentPage == 0) {

                    int nbPages = (int) Math.ceil(total.intValue() / queryProducts.getPageSize());

                    // Get the next pages of the category
                    for (int i = 1; i < nbPages; i++) {
                        loopCategory(categoryHierarchy, i, loopSubCategories, loadVariants);
                    }

                    // Get the subcategories
                    if (loopSubCategories && categoryHierarchy.getSubcategories() != null) {
                        for (CategoryHierarchy subCategoryHierarchy : categoryHierarchy.getSubcategories()) {
                            loopCategory(subCategoryHierarchy, 0, loopSubCategories, loadVariants);
                        }
                    }

                }
            }

            @Override
            public void onProductsLoadedError() {

            }
        });

    }

    /**
     * Load a product
     *
     * @param productCode              Unique Product Identifier
     * @param categoryId               Unique Identifier for a specific Category of product
     * @param parentCategoriesIds      List of Parent Category Identifier in String format
     * @param hideProgressNotification @throws InterruptedException
     * @param loadVariants             True Load variant else false
     */
    private void loadProduct(final String productCode, final String categoryId, final List<String> parentCategoriesIds, final boolean hideProgressNotification, final boolean loadVariants) {
        Log.i(TAG, "Syncing the product " + productCode + " for category " + categoryId);

        QueryProduct queryProduct = new QueryProduct();
        queryProduct.setCode(productCode);

        OnRequestListener onRequestListener = null;

        // Hide the progress notification when no more products need to be loaded
        if (hideProgressNotification) {
            onRequestListener = mOnRequestListenerEndOfSync;
        }

        mContentServiceHelper.getProduct(new ResponseReceiver<Product>() {

            @Override
            public void onResponse(Response<Product> response) {

                Log.i(TAG, "Response received after syncing the product " + productCode);

                List<String> listCategory = new ArrayList<>();
                listCategory.add(categoryId);

                if (parentCategoriesIds != null && !parentCategoriesIds.isEmpty()) {
                    listCategory.addAll(parentCategoriesIds);
                }

                Product product = response.getData();

                // Saving the products
                try {
                    saveProduct(new DataSync(product.getCode(), mContentServiceHelper.getDataConverter().convertTo(product)), listCategory, true);
                } catch (DataConverterException e) {
                    Log.e(TAG, "Error converting the product to a data String. Error: " + e.getLocalizedMessage());
                }

                // Loading the variants
                if (loadVariants && product.getVariantOptions() != null && !product.getVariantOptions().isEmpty()) {
                    Log.i(TAG, "Syncing the variants for the product " + productCode);

                    for (VariantOption variantOption : product.getVariantOptions()) {

                        // The variants are not linked to any category
                        loadProduct(variantOption.getCode(), null, null, hideProgressNotification, false);
                    }
                }

            }

            @Override
            public void onError(Response<ErrorList> response) {
                Log.e(TAG, ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, null, queryProduct, false, null, onRequestListener);
    }

    /**
     * Save the product by calling the content provider
     *
     * @param product     Product to be saved
     * @param categoryIds List of Category Identifier in String format
     * @param isDetails   true if product detail call else false for product with less info
     */
    private void saveProduct(DataSync product, List<String> categoryIds, boolean isDetails) {
        Log.i(TAG, "Saving the product " + product.getId() + " for category " + categoryIds);

        // Saving the link product - categories
        for (String idCategory : categoryIds) {
            Log.i(TAG, "Saving the link category " + idCategory + " - product" + product.getId());
            ContentValues contentValues = new ContentValues();
            contentValues.put(CatalogContract.DataBaseDataLinkGroup.ATT_GROUP_ID, idCategory);
            contentValues.put(CatalogContract.DataBaseDataLinkGroup.ATT_DATA_ID, product.getId());
            getContext().getContentResolver().insert(Uri.withAppendedPath(CatalogContract.Provider.getUriGroup(AUTHORITY), product.getId()),
                    contentValues);
        }

        // Saving the product
        ContentValues contentValues = new ContentValues();
        contentValues.put(CatalogContract.DataBaseData.ATT_DATA_ID, product.getId());
        contentValues.put(CatalogContract.DataBaseData.ATT_DATA, product.getData());
        contentValues.put(CatalogContract.DataBaseData.ATT_STATUS, SyncStatus.UPTODATE.getValue());

        getContext().getContentResolver().insert(Uri.withAppendedPath(CatalogContract.Provider.getUriData(AUTHORITY), product.getId()),
                contentValues);

        if (isDetails) {
            getContext().getContentResolver().insert(Uri.withAppendedPath(CatalogContract.Provider.getUriDataDetails(AUTHORITY), product.getId()),
                    contentValues);
        }
    }

    /**
     * This method update the url configuration of the content service helper
     *
     * @param url                   the new url
     * @param catalog               the catalog
     * @param catalogId             the catalog id
     * @param catalogVersionId      the catalog version id
     * @param catalogMainCategoryId the main category id of the catalo
     */
    public void updateContentServiceHelperUrlConfiguration(String url, String catalog, String catalogId, String catalogVersionId, String catalogMainCategoryId) {
        mContentServiceHelper.updateConfiguration(url, catalog, catalogId, catalogVersionId, catalogMainCategoryId);
    }

    /**
     * Cancel all the current requests to the content service helper
     */
    public void cancelAllRequests() {
        mContentServiceHelper.cancelAll();
    }

    /**
     * Show the notification download progress
     *
     * @param show True notification will be displayed else hidden
     */
    private void showNotificationProgress(boolean show) {
        // Showing the notification
        if (show) {
            mNotifyManager.notify(mNotificationId, mNotification);
        } else {
            mNotifyManager.cancel(mNotificationId);
        }
    }

    /**
     * Return the list of the parent's categories ids of the category
     *
     * @param categoryHierarchy Category where parent id will be searched
     * @param results           List of parent Id
     * @return list of the parent's categories ids of the category
     */
    private List<String> getParentsCategoriesIds(CategoryHierarchy categoryHierarchy, List<String> results) {

        if (results == null) {
            results = new ArrayList<>();
        }

        if (categoryHierarchy.getParent() != null) {
            results.add(categoryHierarchy.getParent().getId());
            return getParentsCategoriesIds(categoryHierarchy.getParent(), results);
        }

        return results;
    }

    public abstract void getProducts(QueryProducts queryProducts, boolean shouldUseCache, OnRequestListener onRequestListener, Callback callback);

    public interface Callback {
        void onProductsLoadedSuccess(List<DataSync> products, Long total);

        void onProductsLoadedError();
    }
}
