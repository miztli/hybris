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
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.ExpressionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Negation expression
 */
@ApiModel(value="negationExpression", description="Negation expression")
public  class NegationExpressionData extends ExpressionData 
{

 

	/** Expression to negate<br/><br/><i>Generated property</i> for <code>NegationExpressionData.element</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="element", value="Expression to negate") 	
	private ExpressionData element;
	
	public NegationExpressionData()
	{
		// default constructor
	}
	
		
	
	public void setElement(final ExpressionData element)
	{
		this.element = element;
	}

		
	
	public ExpressionData getElement() 
	{
		return element;
	}
	


}
