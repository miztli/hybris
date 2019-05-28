/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 28, 2019 3:18:54 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.cms2.model.processing;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.cms2.model.CMSVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type CMSVersionGCProcess first defined at extension cms2.
 */
@SuppressWarnings("all")
public class CMSVersionGCProcessModel extends BusinessProcessModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CMSVersionGCProcess";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersionGCProcess.maxAgeDays</code> attribute defined at extension <code>cms2</code>. */
	public static final String MAXAGEDAYS = "maxAgeDays";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersionGCProcess.maxNumberVersions</code> attribute defined at extension <code>cms2</code>. */
	public static final String MAXNUMBERVERSIONS = "maxNumberVersions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersionGCProcess.retainableVersions</code> attribute defined at extension <code>cms2</code>. */
	public static final String RETAINABLEVERSIONS = "retainableVersions";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CMSVersionGCProcessModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CMSVersionGCProcessModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 * @param _processDefinitionName initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 */
	@Deprecated
	public CMSVersionGCProcessModel(final String _code, final String _processDefinitionName)
	{
		super();
		setCode(_code);
		setProcessDefinitionName(_processDefinitionName);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _processDefinitionName initial attribute declared by type <code>BusinessProcess</code> at extension <code>processing</code>
	 */
	@Deprecated
	public CMSVersionGCProcessModel(final String _code, final ItemModel _owner, final String _processDefinitionName)
	{
		super();
		setCode(_code);
		setOwner(_owner);
		setProcessDefinitionName(_processDefinitionName);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersionGCProcess.maxAgeDays</code> attribute defined at extension <code>cms2</code>. 
	 * @return the maxAgeDays - The maximum age in days before a cms version is removed
	 */
	@Accessor(qualifier = "maxAgeDays", type = Accessor.Type.GETTER)
	public Integer getMaxAgeDays()
	{
		return getPersistenceContext().getPropertyValue(MAXAGEDAYS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersionGCProcess.maxNumberVersions</code> attribute defined at extension <code>cms2</code>. 
	 * @return the maxNumberVersions - The maximum number of versions to keep for an item
	 */
	@Accessor(qualifier = "maxNumberVersions", type = Accessor.Type.GETTER)
	public Integer getMaxNumberVersions()
	{
		return getPersistenceContext().getPropertyValue(MAXNUMBERVERSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersionGCProcess.retainableVersions</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the retainableVersions
	 */
	@Accessor(qualifier = "retainableVersions", type = Accessor.Type.GETTER)
	public Set<CMSVersionModel> getRetainableVersions()
	{
		return getPersistenceContext().getPropertyValue(RETAINABLEVERSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersionGCProcess.maxAgeDays</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the maxAgeDays - The maximum age in days before a cms version is removed
	 */
	@Accessor(qualifier = "maxAgeDays", type = Accessor.Type.SETTER)
	public void setMaxAgeDays(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXAGEDAYS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersionGCProcess.maxNumberVersions</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the maxNumberVersions - The maximum number of versions to keep for an item
	 */
	@Accessor(qualifier = "maxNumberVersions", type = Accessor.Type.SETTER)
	public void setMaxNumberVersions(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXNUMBERVERSIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersionGCProcess.retainableVersions</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the retainableVersions
	 */
	@Accessor(qualifier = "retainableVersions", type = Accessor.Type.SETTER)
	public void setRetainableVersions(final Set<CMSVersionModel> value)
	{
		getPersistenceContext().setPropertyValue(RETAINABLEVERSIONS, value);
	}
	
}
