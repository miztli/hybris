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
package de.hybris.platform.ycommercewebservices.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.CardTypeData;
import java.util.List;

public  class CardTypeDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CardTypeDataList.cardTypes</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private List<CardTypeData> cardTypes;
	
	public CardTypeDataList()
	{
		// default constructor
	}
	
		
	
	public void setCardTypes(final List<CardTypeData> cardTypes)
	{
		this.cardTypes = cardTypes;
	}

		
	
	public List<CardTypeData> getCardTypes() 
	{
		return cardTypes;
	}
	


}
