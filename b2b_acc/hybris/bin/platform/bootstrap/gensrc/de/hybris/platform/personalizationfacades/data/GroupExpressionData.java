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
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.ExpressionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Group expression
 */
@ApiModel(value="groupExpression", description="Group expression")
public  class GroupExpressionData extends ExpressionData 
{

 

	/** Expressions building the group expression<br/><br/><i>Generated property</i> for <code>GroupExpressionData.elements</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="elements", value="Expressions building the group expression") 	
	private List<ExpressionData> elements;

	/** Operator joining the expressions<br/><br/><i>Generated property</i> for <code>GroupExpressionData.operator</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="operator", value="Operator joining the expressions", allowableValues="AND,OR") 	
	private String operator;
	
	public GroupExpressionData()
	{
		// default constructor
	}
	
		
	
	public void setElements(final List<ExpressionData> elements)
	{
		this.elements = elements;
	}

		
	
	public List<ExpressionData> getElements() 
	{
		return elements;
	}
	
		
	
	public void setOperator(final String operator)
	{
		this.operator = operator;
	}

		
	
	public String getOperator() 
	{
		return operator;
	}
	


}
