/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.catalog.enums.ProductInfoStatus;
import de.hybris.platform.commercefacades.comment.data.CommentData;
import de.hybris.platform.commercefacades.order.data.ConfigurationInfoData;
import de.hybris.platform.commercefacades.order.data.DeliveryModeData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public  class OrderEntryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderEntryData.entryNumber</code> property defined at extension <code>commercefacades</code>. */
		
	private Integer entryNumber;

	/** <i>Generated property</i> for <code>OrderEntryData.quantity</code> property defined at extension <code>commercefacades</code>. */
		
	private Long quantity;

	/** <i>Generated property</i> for <code>OrderEntryData.basePrice</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData basePrice;

	/** <i>Generated property</i> for <code>OrderEntryData.totalPrice</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalPrice;

	/** <i>Generated property</i> for <code>OrderEntryData.product</code> property defined at extension <code>commercefacades</code>. */
		
	private ProductData product;

	/** <i>Generated property</i> for <code>OrderEntryData.updateable</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean updateable;

	/** <i>Generated property</i> for <code>OrderEntryData.deliveryMode</code> property defined at extension <code>commercefacades</code>. */
		
	private DeliveryModeData deliveryMode;

	/** <i>Generated property</i> for <code>OrderEntryData.deliveryPointOfService</code> property defined at extension <code>commercefacades</code>. */
		
	private PointOfServiceData deliveryPointOfService;

	/** <i>Generated property</i> for <code>OrderEntryData.entries</code> property defined at extension <code>commercefacades</code>. */
		
	private List<OrderEntryData> entries;

	/** <i>Generated property</i> for <code>OrderEntryData.configurationInfos</code> property defined at extension <code>commercefacades</code>. */
		
	private List<ConfigurationInfoData> configurationInfos;

	/** <i>Generated property</i> for <code>OrderEntryData.statusSummaryMap</code> property defined at extension <code>commercefacades</code>. */
		
	private Map<ProductInfoStatus, Integer> statusSummaryMap;

	/** <i>Generated property</i> for <code>OrderEntryData.entryGroupNumbers</code> property defined at extension <code>commercefacades</code>. */
		
	private Collection<Integer> entryGroupNumbers;

	/** <i>Generated property</i> for <code>OrderEntryData.comments</code> property defined at extension <code>commercefacades</code>. */
		
	private List<CommentData> comments;

	/** <i>Generated property</i> for <code>OrderEntryData.url</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String url;

	/** <i>Generated property</i> for <code>OrderEntryData.cancellableQty</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private long cancellableQty;

	/** <i>Generated property</i> for <code>OrderEntryData.returnableQty</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private long returnableQty;

	/** <i>Generated property</i> for <code>OrderEntryData.cancelledItemsPrice</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PriceData cancelledItemsPrice;

	/** <i>Generated property</i> for <code>OrderEntryData.returnedItemsPrice</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PriceData returnedItemsPrice;

	/** <i>Generated property</i> for <code>OrderEntryData.supportedActions</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private Set<String> supportedActions;
	
	public OrderEntryData()
	{
		// default constructor
	}
	
		
	
	public void setEntryNumber(final Integer entryNumber)
	{
		this.entryNumber = entryNumber;
	}

		
	
	public Integer getEntryNumber() 
	{
		return entryNumber;
	}
	
		
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

		
	
	public Long getQuantity() 
	{
		return quantity;
	}
	
		
	
	public void setBasePrice(final PriceData basePrice)
	{
		this.basePrice = basePrice;
	}

		
	
	public PriceData getBasePrice() 
	{
		return basePrice;
	}
	
		
	
	public void setTotalPrice(final PriceData totalPrice)
	{
		this.totalPrice = totalPrice;
	}

		
	
	public PriceData getTotalPrice() 
	{
		return totalPrice;
	}
	
		
	
	public void setProduct(final ProductData product)
	{
		this.product = product;
	}

		
	
	public ProductData getProduct() 
	{
		return product;
	}
	
		
	
	public void setUpdateable(final boolean updateable)
	{
		this.updateable = updateable;
	}

		
	
	public boolean isUpdateable() 
	{
		return updateable;
	}
	
		
	
	public void setDeliveryMode(final DeliveryModeData deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}

		
	
	public DeliveryModeData getDeliveryMode() 
	{
		return deliveryMode;
	}
	
		
	
	public void setDeliveryPointOfService(final PointOfServiceData deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}

		
	
	public PointOfServiceData getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
	
		
	
	public void setEntries(final List<OrderEntryData> entries)
	{
		this.entries = entries;
	}

		
	
	public List<OrderEntryData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setConfigurationInfos(final List<ConfigurationInfoData> configurationInfos)
	{
		this.configurationInfos = configurationInfos;
	}

		
	
	public List<ConfigurationInfoData> getConfigurationInfos() 
	{
		return configurationInfos;
	}
	
		
	
	public void setStatusSummaryMap(final Map<ProductInfoStatus, Integer> statusSummaryMap)
	{
		this.statusSummaryMap = statusSummaryMap;
	}

		
	
	public Map<ProductInfoStatus, Integer> getStatusSummaryMap() 
	{
		return statusSummaryMap;
	}
	
		
	
	public void setEntryGroupNumbers(final Collection<Integer> entryGroupNumbers)
	{
		this.entryGroupNumbers = entryGroupNumbers;
	}

		
	
	public Collection<Integer> getEntryGroupNumbers() 
	{
		return entryGroupNumbers;
	}
	
		
	
	public void setComments(final List<CommentData> comments)
	{
		this.comments = comments;
	}

		
	
	public List<CommentData> getComments() 
	{
		return comments;
	}
	
		
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

		
	
	public String getUrl() 
	{
		return url;
	}
	
		
	
	public void setCancellableQty(final long cancellableQty)
	{
		this.cancellableQty = cancellableQty;
	}

		
	
	public long getCancellableQty() 
	{
		return cancellableQty;
	}
	
		
	
	public void setReturnableQty(final long returnableQty)
	{
		this.returnableQty = returnableQty;
	}

		
	
	public long getReturnableQty() 
	{
		return returnableQty;
	}
	
		
	
	public void setCancelledItemsPrice(final PriceData cancelledItemsPrice)
	{
		this.cancelledItemsPrice = cancelledItemsPrice;
	}

		
	
	public PriceData getCancelledItemsPrice() 
	{
		return cancelledItemsPrice;
	}
	
		
	
	public void setReturnedItemsPrice(final PriceData returnedItemsPrice)
	{
		this.returnedItemsPrice = returnedItemsPrice;
	}

		
	
	public PriceData getReturnedItemsPrice() 
	{
		return returnedItemsPrice;
	}
	
		
	
	public void setSupportedActions(final Set<String> supportedActions)
	{
		this.supportedActions = supportedActions;
	}

		
	
	public Set<String> getSupportedActions() 
	{
		return supportedActions;
	}
	


}
