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
package de.hybris.platform.acceleratorservices.orderprocessing.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.ordermodify.model.OrderModificationRecordEntryModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OrderModificationProcess first defined at extension acceleratorservices.
 */
@SuppressWarnings("all")
public class OrderModificationProcessModel extends OrderProcessModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OrderModificationProcess";
	
	/** <i>Generated constant</i> - Attribute key of <code>OrderModificationProcess.orderModificationRecordEntry</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String ORDERMODIFICATIONRECORDENTRY = "orderModificationRecordEntry";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OrderModificationProcessModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OrderModificationProcessModel(final ItemModelContext ctx)
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
	public OrderModificationProcessModel(final String _code, final String _processDefinitionName)
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
	public OrderModificationProcessModel(final String _code, final ItemModel _owner, final String _processDefinitionName)
	{
		super();
		setCode(_code);
		setOwner(_owner);
		setProcessDefinitionName(_processDefinitionName);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OrderModificationProcess.orderModificationRecordEntry</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the orderModificationRecordEntry - Object storing order modification details.
	 */
	@Accessor(qualifier = "orderModificationRecordEntry", type = Accessor.Type.GETTER)
	public OrderModificationRecordEntryModel getOrderModificationRecordEntry()
	{
		return getPersistenceContext().getPropertyValue(ORDERMODIFICATIONRECORDENTRY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OrderModificationProcess.orderModificationRecordEntry</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the orderModificationRecordEntry - Object storing order modification details.
	 */
	@Accessor(qualifier = "orderModificationRecordEntry", type = Accessor.Type.SETTER)
	public void setOrderModificationRecordEntry(final OrderModificationRecordEntryModel value)
	{
		getPersistenceContext().setPropertyValue(ORDERMODIFICATIONRECORDENTRY, value);
	}
	
}
