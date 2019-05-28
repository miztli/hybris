/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.personalizationservices.voters;

import java.io.Serializable;
import de.hybris.platform.personalizationservices.RecalculateAction;
import java.util.Set;

/**
 * Vote used for defining what should be done with given request.
 */
public  class Vote  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>Vote.recalculateActions</code> property defined at extension <code>personalizationservices</code>. */
		
	private Set<RecalculateAction> recalculateActions;

	/** <i>Generated property</i> for <code>Vote.conclusive</code> property defined at extension <code>personalizationservices</code>. */
		
	private boolean conclusive;
	
	public Vote()
	{
		// default constructor
	}
	
		
	
	public void setRecalculateActions(final Set<RecalculateAction> recalculateActions)
	{
		this.recalculateActions = recalculateActions;
	}

		
	
	public Set<RecalculateAction> getRecalculateActions() 
	{
		return recalculateActions;
	}
	
		
	
	public void setConclusive(final boolean conclusive)
	{
		this.conclusive = conclusive;
	}

		
	
	public boolean isConclusive() 
	{
		return conclusive;
	}
	


}
