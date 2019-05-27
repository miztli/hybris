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
package de.hybris.platform.cms2.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.cms2.model.CMSPageTypeModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;

/**
 * Generated model class for type RestrictionType first defined at extension cms2.
 */
@SuppressWarnings("all")
public class RestrictionTypeModel extends ComposedTypeModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "RestrictionType";
	
	/** <i>Generated constant</i> - Attribute key of <code>RestrictionType.pageTypes</code> attribute defined at extension <code>cms2</code>. */
	public static final String PAGETYPES = "pageTypes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public RestrictionTypeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public RestrictionTypeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogItemType initial attribute declared by type <code>ComposedType</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Type</code> at extension <code>core</code>
	 * @param _generate initial attribute declared by type <code>TypeManagerManaged</code> at extension <code>core</code>
	 * @param _singleton initial attribute declared by type <code>ComposedType</code> at extension <code>core</code>
	 * @param _superType initial attribute declared by type <code>ComposedType</code> at extension <code>core</code>
	 */
	@Deprecated
	public RestrictionTypeModel(final Boolean _catalogItemType, final String _code, final Boolean _generate, final Boolean _singleton, final ComposedTypeModel _superType)
	{
		super();
		setCatalogItemType(_catalogItemType);
		setCode(_code);
		setGenerate(_generate);
		setSingleton(_singleton);
		setSuperType(_superType);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogItemType initial attribute declared by type <code>ComposedType</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Type</code> at extension <code>core</code>
	 * @param _generate initial attribute declared by type <code>TypeManagerManaged</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _singleton initial attribute declared by type <code>ComposedType</code> at extension <code>core</code>
	 * @param _superType initial attribute declared by type <code>ComposedType</code> at extension <code>core</code>
	 */
	@Deprecated
	public RestrictionTypeModel(final Boolean _catalogItemType, final String _code, final Boolean _generate, final ItemModel _owner, final Boolean _singleton, final ComposedTypeModel _superType)
	{
		super();
		setCatalogItemType(_catalogItemType);
		setCode(_code);
		setGenerate(_generate);
		setOwner(_owner);
		setSingleton(_singleton);
		setSuperType(_superType);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RestrictionType.pageTypes</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the pageTypes
	 */
	@Accessor(qualifier = "pageTypes", type = Accessor.Type.GETTER)
	public Collection<CMSPageTypeModel> getPageTypes()
	{
		return getPersistenceContext().getPropertyValue(PAGETYPES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>RestrictionType.pageTypes</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the pageTypes
	 */
	@Accessor(qualifier = "pageTypes", type = Accessor.Type.SETTER)
	public void setPageTypes(final Collection<CMSPageTypeModel> value)
	{
		getPersistenceContext().setPropertyValue(PAGETYPES, value);
	}
	
}
