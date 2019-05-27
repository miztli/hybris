/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 1, 2015 2:19:46 PM
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
package com.hybris.mobile.lib.commerce.data.product;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProductBase implements java.io.Serializable {

	/**
	 * <i>Generated property</i> for <code>Product.availableForPickup</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Boolean availableForPickup;
	/**
	 * <i>Generated property</i> for <code>Product.volumePricesFlag</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Boolean volumePricesFlag;
	/**
	 * <i>Generated property</i> for <code>Product.purchasable</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Boolean purchasable;
	/**
	 * <i>Generated property</i> for <code>Product.code</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String code;
	/**
	 * <i>Generated property</i> for <code>Product.numberOfReviews</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Integer numberOfReviews;
	/**
	 * <i>Generated property</i> for <code>Product.description</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String description;
	/**
	 * <i>Generated property</i> for <code>Product.manufacturer</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String manufacturer;
	/**
	 * <i>Generated property</i> for <code>Product.variantType</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String variantType;
	/**
	 * <i>Generated property</i> for <code>Product.reviews</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Collection<Review> reviews;
	/**
	 * <i>Generated property</i> for <code>Product.variantOptions</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private List<VariantOption> variantOptions;
	/**
	 * <i>Generated property</i> for <code>Product.price</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Price price;
	/**
	 * <i>Generated property</i> for <code>Product.averageRating</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Double averageRating;
	/**
	 * <i>Generated property</i> for <code>Product.categories</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Collection<Category> categories;
	/**
	 * <i>Generated property</i> for <code>Product.potentialPromotions</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Collection<Promotion> potentialPromotions;
	/**
	 * <i>Generated property</i> for <code>Product.stock</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Stock stock;
	/**
	 * <i>Generated property</i> for <code>Product.summary</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String summary;
	/**
	 * <i>Generated property</i> for <code>Product.images</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Collection<Image> images;
	/**
	 * <i>Generated property</i> for <code>Product.baseProduct</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String baseProduct;
	/**
	 * <i>Generated property</i> for <code>Product.url</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String url;
	/**
	 * <i>Generated property</i> for <code>Product.futureStocks</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private List<FutureStock> futureStocks;
	/**
	 * <i>Generated property</i> for <code>Product.classifications</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Collection<Classification> classifications;
	/**
	 * <i>Generated property</i> for <code>Product.productReferences</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private List<ProductReference> productReferences;
	/**
	 * <i>Generated property</i> for <code>Product.name</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private String name;
	/**
	 * <i>Generated property</i> for <code>Product.volumePrices</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private List<Price> volumePrices;
	/**
	 * <i>Generated property</i> for <code>Product.priceRange</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private PriceRange priceRange;
	/**
	 * <i>Generated property</i> for <code>Product.multidimensional</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Boolean multidimensional;
	/**
	 * <i>Generated property</i> for <code>Product.baseOptions</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private List<BaseOption> baseOptions;

	public ProductBase() {
		// default constructor
	}


	public void setAvailableForPickup(final Boolean availableForPickup) {
		this.availableForPickup = availableForPickup;
	}


	public Boolean getAvailableForPickup() {
		return availableForPickup;
	}


	public void setVolumePricesFlag(final Boolean volumePricesFlag) {
		this.volumePricesFlag = volumePricesFlag;
	}


	public Boolean getVolumePricesFlag() {
		return volumePricesFlag;
	}


	public void setPurchasable(final Boolean purchasable) {
		this.purchasable = purchasable;
	}


	public Boolean getPurchasable() {
		return purchasable;
	}


	public void setCode(final String code) {
		this.code = code;
	}


	public String getCode() {
		return code;
	}


	public void setNumberOfReviews(final Integer numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}


	public Integer getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setDescription(final String description) {
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	public void setManufacturer(final String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setVariantType(final String variantType) {
		this.variantType = variantType;
	}


	public String getVariantType() {
		return variantType;
	}


	public void setReviews(final Collection<Review> reviews) {
		this.reviews = reviews;
	}


	public Collection<Review> getReviews() {
		return reviews;
	}


	public void setVariantOptions(final List<VariantOption> variantOptions) {
		this.variantOptions = variantOptions;
	}


	public List<VariantOption> getVariantOptions() {
		return variantOptions;
	}


	public void setPrice(final Price price) {
		this.price = price;
	}


	public Price getPrice() {
		return price;
	}


	public void setAverageRating(final Double averageRating) {
		this.averageRating = averageRating;
	}


	public Double getAverageRating() {
		return averageRating;
	}


	public void setCategories(final Collection<Category> categories) {
		this.categories = categories;
	}


	public Collection<Category> getCategories() {
		return categories;
	}


	public void setPotentialPromotions(final Collection<Promotion> potentialPromotions) {
		this.potentialPromotions = potentialPromotions;
	}


	public Collection<Promotion> getPotentialPromotions() {
		return potentialPromotions;
	}


	public void setStock(final Stock stock) {
		this.stock = stock;
	}


	public Stock getStock() {
		return stock;
	}


	public void setSummary(final String summary) {
		this.summary = summary;
	}


	public String getSummary() {
		return summary;
	}


	public void setImages(final Collection<Image> images) {
		this.images = images;
	}


	public Collection<Image> getImages() {
		return images;
	}


	public void setBaseProduct(final String baseProduct) {
		this.baseProduct = baseProduct;
	}


	public String getBaseProduct() {
		return baseProduct;
	}


	public void setUrl(final String url) {
		this.url = url;
	}


	public String getUrl() {
		return url;
	}


	public void setFutureStocks(final List<FutureStock> futureStocks) {
		this.futureStocks = futureStocks;
	}


	public List<FutureStock> getFutureStocks() {
		return futureStocks;
	}


	public void setClassifications(final Collection<Classification> classifications) {
		this.classifications = classifications;
	}


	public Collection<Classification> getClassifications() {
		return classifications;
	}


	public void setProductReferences(final List<ProductReference> productReferences) {
		this.productReferences = productReferences;
	}


	public List<ProductReference> getProductReferences() {
		return productReferences;
	}


	public void setName(final String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setVolumePrices(final List<Price> volumePrices) {
		this.volumePrices = volumePrices;
	}


	public List<Price> getVolumePrices() {
		return volumePrices;
	}


	public void setPriceRange(final PriceRange priceRange) {
		this.priceRange = priceRange;
	}


	public PriceRange getPriceRange() {
		return priceRange;
	}


	public void setMultidimensional(final Boolean multidimensional) {
		this.multidimensional = multidimensional;
	}


	public Boolean getMultidimensional() {
		return multidimensional;
	}


	public void setBaseOptions(final List<BaseOption> baseOptions) {
		this.baseOptions = baseOptions;
	}


	public List<BaseOption> getBaseOptions() {
		return baseOptions;
	}

	private enum StockLevelEnum {

		OUT_OF_STOCK("outOfStock"), LOW_STOCK("lowstock"), IN_STOCK("inStock");

		private final String status;

		StockLevelEnum(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

	}

	public boolean isOutOfStock() {
		return stock != null && stock.getStockLevelStatus() != null
				&& StringUtils.equalsIgnoreCase(stock.getStockLevelStatus(), StockLevelEnum.OUT_OF_STOCK.getStatus());
	}

	public boolean isLowStock() {
		return stock != null && stock.getStockLevelStatus() != null
				&& StringUtils.equalsIgnoreCase(stock.getStockLevelStatus(), StockLevelEnum.LOW_STOCK.getStatus());
	}

	public boolean isInStock() {
		return stock != null && stock.getStockLevelStatus() != null
				&& StringUtils.equalsIgnoreCase(stock.getStockLevelStatus(), StockLevelEnum.IN_STOCK.getStatus());
	}

	public String getPriceRangeFormattedValue() {
		String formattedValue = StringUtils.isNotBlank(price.getFormattedValue()) ? price.getFormattedValue() : "";

		if (priceRange.getMaxPrice() != null) {
			if (StringUtils.isNotBlank(priceRange.getMaxPrice().getFormattedValue())
					&& StringUtils.isNotBlank(priceRange.getMinPrice().getFormattedValue())) {
				//if priceMax equals to priceMin show real price
				formattedValue = StringUtils.equals(priceRange.getMinPrice().getFormattedValue(), priceRange.getMaxPrice()
						.getFormattedValue()) ? formattedValue : priceRange.getMinPrice().getFormattedValue() + " - "
						+ priceRange.getMaxPrice().getFormattedValue();
			}
		}
		return formattedValue;
	}

	public List<Image> getImagesGallery() {
		List<Image> returnList = new ArrayList<>();

		if (images != null) {

			for (Image image : images) {
				if (image.getImageType() == ImageDataType.GALLERY) {
					returnList.add(image);
				}
			}

		}

		return returnList;
	}

	public String getImageThumbnailUrl() {

		String thumbnail = "";

		if (images != null && !images.isEmpty()) {

			boolean imageFound = false;
			Iterator<Image> iterImages = images.iterator();

			while (iterImages.hasNext() && !imageFound) {
				Image image = iterImages.next();

				if (StringUtils.equals(image.getFormat(), "thumbnail")
						&& image.getImageType() == ImageDataType.PRIMARY) {
					thumbnail = image.getUrl();
					imageFound = true;
				}
			}

		}

		return thumbnail;

	}

}