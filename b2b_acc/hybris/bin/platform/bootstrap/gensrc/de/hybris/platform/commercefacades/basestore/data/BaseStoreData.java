/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.commercefacades.basestore.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.DeliveryModesData;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;
import de.hybris.platform.commercefacades.storesession.data.CurrencyData;
import de.hybris.platform.commercefacades.storesession.data.LanguageData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import java.util.List;

public  class BaseStoreData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BaseStoreData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>BaseStoreData.externalTaxEnabled</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean externalTaxEnabled;

	/** <i>Generated property</i> for <code>BaseStoreData.paymentProvider</code> property defined at extension <code>commercefacades</code>. */
		
	private String paymentProvider;

	/** <i>Generated property</i> for <code>BaseStoreData.createReturnProcessCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String createReturnProcessCode;

	/** <i>Generated property</i> for <code>BaseStoreData.maxRadiusForPosSearch</code> property defined at extension <code>commercefacades</code>. */
		
	private Double maxRadiusForPosSearch;

	/** <i>Generated property</i> for <code>BaseStoreData.submitOrderProcessCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String submitOrderProcessCode;

	/** <i>Generated property</i> for <code>BaseStoreData.currencies</code> property defined at extension <code>commercefacades</code>. */
		
	private List<CurrencyData> currencies;

	/** <i>Generated property</i> for <code>BaseStoreData.defaultCurrency</code> property defined at extension <code>commercefacades</code>. */
		
	private CurrencyData defaultCurrency;

	/** <i>Generated property</i> for <code>BaseStoreData.defaultDeliveryOrigin</code> property defined at extension <code>commercefacades</code>. */
		
	private PointOfServiceData defaultDeliveryOrigin;

	/** <i>Generated property</i> for <code>BaseStoreData.defaultLanguage</code> property defined at extension <code>commercefacades</code>. */
		
	private LanguageData defaultLanguage;

	/** <i>Generated property</i> for <code>BaseStoreData.deliveryCountries</code> property defined at extension <code>commercefacades</code>. */
		
	private List<CountryData> deliveryCountries;

	/** <i>Generated property</i> for <code>BaseStoreData.deliveryModes</code> property defined at extension <code>commercefacades</code>. */
		
	private DeliveryModesData deliveryModes;

	/** <i>Generated property</i> for <code>BaseStoreData.languages</code> property defined at extension <code>commercefacades</code>. */
		
	private List<LanguageData> languages;

	/** <i>Generated property</i> for <code>BaseStoreData.pointsOfService</code> property defined at extension <code>commercefacades</code>. */
		
	private List<PointOfServiceData> pointsOfService;
	
	public BaseStoreData()
	{
		// default constructor
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setExternalTaxEnabled(final boolean externalTaxEnabled)
	{
		this.externalTaxEnabled = externalTaxEnabled;
	}

		
	
	public boolean isExternalTaxEnabled() 
	{
		return externalTaxEnabled;
	}
	
		
	
	public void setPaymentProvider(final String paymentProvider)
	{
		this.paymentProvider = paymentProvider;
	}

		
	
	public String getPaymentProvider() 
	{
		return paymentProvider;
	}
	
		
	
	public void setCreateReturnProcessCode(final String createReturnProcessCode)
	{
		this.createReturnProcessCode = createReturnProcessCode;
	}

		
	
	public String getCreateReturnProcessCode() 
	{
		return createReturnProcessCode;
	}
	
		
	
	public void setMaxRadiusForPosSearch(final Double maxRadiusForPosSearch)
	{
		this.maxRadiusForPosSearch = maxRadiusForPosSearch;
	}

		
	
	public Double getMaxRadiusForPosSearch() 
	{
		return maxRadiusForPosSearch;
	}
	
		
	
	public void setSubmitOrderProcessCode(final String submitOrderProcessCode)
	{
		this.submitOrderProcessCode = submitOrderProcessCode;
	}

		
	
	public String getSubmitOrderProcessCode() 
	{
		return submitOrderProcessCode;
	}
	
		
	
	public void setCurrencies(final List<CurrencyData> currencies)
	{
		this.currencies = currencies;
	}

		
	
	public List<CurrencyData> getCurrencies() 
	{
		return currencies;
	}
	
		
	
	public void setDefaultCurrency(final CurrencyData defaultCurrency)
	{
		this.defaultCurrency = defaultCurrency;
	}

		
	
	public CurrencyData getDefaultCurrency() 
	{
		return defaultCurrency;
	}
	
		
	
	public void setDefaultDeliveryOrigin(final PointOfServiceData defaultDeliveryOrigin)
	{
		this.defaultDeliveryOrigin = defaultDeliveryOrigin;
	}

		
	
	public PointOfServiceData getDefaultDeliveryOrigin() 
	{
		return defaultDeliveryOrigin;
	}
	
		
	
	public void setDefaultLanguage(final LanguageData defaultLanguage)
	{
		this.defaultLanguage = defaultLanguage;
	}

		
	
	public LanguageData getDefaultLanguage() 
	{
		return defaultLanguage;
	}
	
		
	
	public void setDeliveryCountries(final List<CountryData> deliveryCountries)
	{
		this.deliveryCountries = deliveryCountries;
	}

		
	
	public List<CountryData> getDeliveryCountries() 
	{
		return deliveryCountries;
	}
	
		
	
	public void setDeliveryModes(final DeliveryModesData deliveryModes)
	{
		this.deliveryModes = deliveryModes;
	}

		
	
	public DeliveryModesData getDeliveryModes() 
	{
		return deliveryModes;
	}
	
		
	
	public void setLanguages(final List<LanguageData> languages)
	{
		this.languages = languages;
	}

		
	
	public List<LanguageData> getLanguages() 
	{
		return languages;
	}
	
		
	
	public void setPointsOfService(final List<PointOfServiceData> pointsOfService)
	{
		this.pointsOfService = pointsOfService;
	}

		
	
	public List<PointOfServiceData> getPointsOfService() 
	{
		return pointsOfService;
	}
	


}
