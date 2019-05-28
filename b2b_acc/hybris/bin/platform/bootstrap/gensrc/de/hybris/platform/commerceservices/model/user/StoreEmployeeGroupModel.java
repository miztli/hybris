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
package de.hybris.platform.commerceservices.model.user;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

/**
 * Generated model class for type StoreEmployeeGroup first defined at extension commerceservices.
 * <p>
 * Group of Employees working in a particular store.
 */
@SuppressWarnings("all")
public class StoreEmployeeGroupModel extends UserGroupModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "StoreEmployeeGroup";
	
	/** <i>Generated constant</i> - Attribute key of <code>StoreEmployeeGroup.store</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String STORE = "store";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public StoreEmployeeGroupModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public StoreEmployeeGroupModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public StoreEmployeeGroupModel(final String _uid)
	{
		super();
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public StoreEmployeeGroupModel(final ItemModel _owner, final String _uid)
	{
		super();
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreEmployeeGroup.store</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the store
	 */
	@Accessor(qualifier = "store", type = Accessor.Type.GETTER)
	public PointOfServiceModel getStore()
	{
		return getPersistenceContext().getPropertyValue(STORE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>StoreEmployeeGroup.store</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the store
	 */
	@Accessor(qualifier = "store", type = Accessor.Type.SETTER)
	public void setStore(final PointOfServiceModel value)
	{
		getPersistenceContext().setPropertyValue(STORE, value);
	}
	
}
