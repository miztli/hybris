/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
package de.hybris.platform.commercewebservicescommons.dto.basestore;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.DeliveryModeListWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.store.PointOfServiceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.LanguageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.CountryWsDTO;
import java.util.List;

public  class BaseStoreWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.externalTaxEnabled</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Boolean externalTaxEnabled;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.paymentProvider</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String paymentProvider;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.createReturnProcessCode</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String createReturnProcessCode;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.maxRadiusForPosSearch</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Double maxRadiusForPosSearch;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.submitOrderProcessCode</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String submitOrderProcessCode;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.currencies</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<CurrencyWsDTO> currencies;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.defaultCurrency</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private CurrencyWsDTO defaultCurrency;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.defaultDeliveryOrigin</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private PointOfServiceWsDTO defaultDeliveryOrigin;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.defaultLanguage</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private LanguageWsDTO defaultLanguage;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.deliveryCountries</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<CountryWsDTO> deliveryCountries;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.deliveryModes</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private DeliveryModeListWsDTO deliveryModes;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.languages</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<LanguageWsDTO> languages;

	/** <i>Generated property</i> for <code>BaseStoreWsDTO.pointsOfService</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<PointOfServiceWsDTO> pointsOfService;
	
	public BaseStoreWsDTO()
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
	
		
	
	public void setExternalTaxEnabled(final Boolean externalTaxEnabled)
	{
		this.externalTaxEnabled = externalTaxEnabled;
	}

		
	
	public Boolean getExternalTaxEnabled() 
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
	
		
	
	public void setCurrencies(final List<CurrencyWsDTO> currencies)
	{
		this.currencies = currencies;
	}

		
	
	public List<CurrencyWsDTO> getCurrencies() 
	{
		return currencies;
	}
	
		
	
	public void setDefaultCurrency(final CurrencyWsDTO defaultCurrency)
	{
		this.defaultCurrency = defaultCurrency;
	}

		
	
	public CurrencyWsDTO getDefaultCurrency() 
	{
		return defaultCurrency;
	}
	
		
	
	public void setDefaultDeliveryOrigin(final PointOfServiceWsDTO defaultDeliveryOrigin)
	{
		this.defaultDeliveryOrigin = defaultDeliveryOrigin;
	}

		
	
	public PointOfServiceWsDTO getDefaultDeliveryOrigin() 
	{
		return defaultDeliveryOrigin;
	}
	
		
	
	public void setDefaultLanguage(final LanguageWsDTO defaultLanguage)
	{
		this.defaultLanguage = defaultLanguage;
	}

		
	
	public LanguageWsDTO getDefaultLanguage() 
	{
		return defaultLanguage;
	}
	
		
	
	public void setDeliveryCountries(final List<CountryWsDTO> deliveryCountries)
	{
		this.deliveryCountries = deliveryCountries;
	}

		
	
	public List<CountryWsDTO> getDeliveryCountries() 
	{
		return deliveryCountries;
	}
	
		
	
	public void setDeliveryModes(final DeliveryModeListWsDTO deliveryModes)
	{
		this.deliveryModes = deliveryModes;
	}

		
	
	public DeliveryModeListWsDTO getDeliveryModes() 
	{
		return deliveryModes;
	}
	
		
	
	public void setLanguages(final List<LanguageWsDTO> languages)
	{
		this.languages = languages;
	}

		
	
	public List<LanguageWsDTO> getLanguages() 
	{
		return languages;
	}
	
		
	
	public void setPointsOfService(final List<PointOfServiceWsDTO> pointsOfService)
	{
		this.pointsOfService = pointsOfService;
	}

		
	
	public List<PointOfServiceWsDTO> getPointsOfService() 
	{
		return pointsOfService;
	}
	


}
