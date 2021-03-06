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
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.DeliveryModeWsDTO;
import java.util.List;

public  class DeliveryModeListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeliveryModeListWsDTO.deliveryModes</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<DeliveryModeWsDTO> deliveryModes;
	
	public DeliveryModeListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setDeliveryModes(final List<DeliveryModeWsDTO> deliveryModes)
	{
		this.deliveryModes = deliveryModes;
	}

		
	
	public List<DeliveryModeWsDTO> getDeliveryModes() 
	{
		return deliveryModes;
	}
	


}
