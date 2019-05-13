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
package de.hybris.platform.ordermanagementfacades.fraud.data;

import java.io.Serializable;

public  class FraudSymptomScoringsData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FraudSymptomScoringsData.explanation</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String explanation;

	/** <i>Generated property</i> for <code>FraudSymptomScoringsData.name</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>FraudSymptomScoringsData.score</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Double score;
	
	public FraudSymptomScoringsData()
	{
		// default constructor
	}
	
		
	
	public void setExplanation(final String explanation)
	{
		this.explanation = explanation;
	}

		
	
	public String getExplanation() 
	{
		return explanation;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setScore(final Double score)
	{
		this.score = score;
	}

		
	
	public Double getScore() 
	{
		return score;
	}
	


}
