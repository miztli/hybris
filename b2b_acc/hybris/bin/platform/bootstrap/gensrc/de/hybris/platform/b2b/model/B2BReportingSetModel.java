/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 27, 2019 5:14:19 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type B2BReportingSet first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BReportingSetModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BReportingSet";
	
	/**<i>Generated relation code constant for relation <code>B2BReportingEntry</code> defining source attribute <code>ReportingEntries</code> in extension <code>b2bcommerce</code>.</i>*/
	public static final String _B2BREPORTINGENTRY = "B2BReportingEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BReportingSet.code</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BReportingSet.ReportingEntries</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String REPORTINGENTRIES = "ReportingEntries";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BReportingSetModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BReportingSetModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>B2BReportingSet</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BReportingSetModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>B2BReportingSet</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BReportingSetModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BReportingSet.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BReportingSet.ReportingEntries</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ReportingEntries
	 */
	@Accessor(qualifier = "ReportingEntries", type = Accessor.Type.GETTER)
	public Set<ItemModel> getReportingEntries()
	{
		return getPersistenceContext().getPropertyValue(REPORTINGENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BReportingSet.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BReportingSet.ReportingEntries</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the ReportingEntries
	 */
	@Accessor(qualifier = "ReportingEntries", type = Accessor.Type.SETTER)
	public void setReportingEntries(final Set<ItemModel> value)
	{
		getPersistenceContext().setPropertyValue(REPORTINGENTRIES, value);
	}
	
}
