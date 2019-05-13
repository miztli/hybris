/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 1, 2015 2:19:47 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.store;

import com.hybris.mobile.lib.commerce.data.Entry;
import com.hybris.mobile.lib.commerce.data.product.Image;
import com.hybris.mobile.lib.commerce.data.user.Address;

import java.util.Collection;

public class PointOfService implements java.io.Serializable {

	/**
	 * <i>Generated property</i> for <code>PointOfService.address</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Address address;
	/**
	 * <i>Generated property</i> for <code>PointOfService.displayName</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String displayName;
	/**
	 * <i>Generated property</i> for <code>PointOfService.description</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String description;
	/**
	 * <i>Generated property</i> for <code>PointOfService.formattedDistance</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String formattedDistance;
	/**
	 * <i>Generated property</i> for <code>PointOfService.distanceKm</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Double distanceKm;
	/**
	 * <i>Generated property</i> for <code>PointOfService.geoPoint</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private GeoPoint geoPoint;
	/**
	 * <i>Generated property</i> for <code>PointOfService.url</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String url;
	/**
	 * <i>Generated property</i> for <code>PointOfService.mapIcon</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Image mapIcon;
	/**
	 * <i>Generated property</i> for <code>PointOfService.features</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Entry features;
	/**
	 * <i>Generated property</i> for <code>PointOfService.storeImages</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Collection<Image> storeImages;
	/**
	 * <i>Generated property</i> for <code>PointOfService.name</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String name;
	/**
	 * <i>Generated property</i> for <code>PointOfService.openingHours</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private OpeningSchedule openingHours;
	/**
	 * <i>Generated property</i> for <code>PointOfService.storeContent</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String storeContent;

	public PointOfService() {
		// default constructor
	}


	public void setAddress(final Address address) {
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}


	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDescription(final String description) {
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	public void setFormattedDistance(final String formattedDistance) {
		this.formattedDistance = formattedDistance;
	}


	public String getFormattedDistance() {
		return formattedDistance;
	}


	public void setDistanceKm(final Double distanceKm) {
		this.distanceKm = distanceKm;
	}


	public Double getDistanceKm() {
		return distanceKm;
	}


	public void setGeoPoint(final GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}


	public GeoPoint getGeoPoint() {
		return geoPoint;
	}


	public void setUrl(final String url) {
		this.url = url;
	}


	public String getUrl() {
		return url;
	}


	public void setMapIcon(final Image mapIcon) {
		this.mapIcon = mapIcon;
	}


	public Image getMapIcon() {
		return mapIcon;
	}


	public void setFeatures(final Entry features) {
		this.features = features;
	}


	public Entry getFeatures() {
		return features;
	}


	public void setStoreImages(final Collection<Image> storeImages) {
		this.storeImages = storeImages;
	}


	public Collection<Image> getStoreImages() {
		return storeImages;
	}


	public void setName(final String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setOpeningHours(final OpeningSchedule openingHours) {
		this.openingHours = openingHours;
	}


	public OpeningSchedule getOpeningHours() {
		return openingHours;
	}


	public void setStoreContent(final String storeContent) {
		this.storeContent = storeContent;
	}


	public String getStoreContent() {
		return storeContent;
	}


}