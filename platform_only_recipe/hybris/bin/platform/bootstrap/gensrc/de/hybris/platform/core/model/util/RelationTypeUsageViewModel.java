/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 15, 2019 4:26:33 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.model.util;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.type.RelationMetaTypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type RelationTypeUsageView first defined at extension core.
 */
@SuppressWarnings("all")
public class RelationTypeUsageViewModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "RelationTypeUsageView";
	
	/** <i>Generated constant</i> - Attribute key of <code>RelationTypeUsageView.relationType</code> attribute defined at extension <code>core</code>. */
	public static final String RELATIONTYPE = "relationType";
	
	/** <i>Generated constant</i> - Attribute key of <code>RelationTypeUsageView.composedType</code> attribute defined at extension <code>core</code>. */
	public static final String COMPOSEDTYPE = "composedType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public RelationTypeUsageViewModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public RelationTypeUsageViewModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public RelationTypeUsageViewModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RelationTypeUsageView.composedType</code> attribute defined at extension <code>core</code>. 
	 * @return the composedType
	 */
	@Accessor(qualifier = "composedType", type = Accessor.Type.GETTER)
	public ComposedTypeModel getComposedType()
	{
		return getPersistenceContext().getPropertyValue(COMPOSEDTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RelationTypeUsageView.relationType</code> attribute defined at extension <code>core</code>. 
	 * @return the relationType
	 */
	@Accessor(qualifier = "relationType", type = Accessor.Type.GETTER)
	public RelationMetaTypeModel getRelationType()
	{
		return getPersistenceContext().getPropertyValue(RELATIONTYPE);
	}
	
}
