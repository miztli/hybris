/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 10, 2019 3:20:53 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.returns.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.enums.ReturnFulfillmentStatus;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type ReturnOrder first defined at extension basecommerce.
 */
@SuppressWarnings("all")
public class ReturnOrderModel extends OrderModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ReturnOrder";
	
	/** <i>Generated constant</i> - Attribute key of <code>ReturnOrder.fulfilmentStatus</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String FULFILMENTSTATUS = "fulfilmentStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>ReturnOrder.notes</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String NOTES = "notes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ReturnOrderModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ReturnOrderModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _date initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _fulfilmentStatus initial attribute declared by type <code>ReturnOrder</code> at extension <code>basecommerce</code>
	 * @param _user initial attribute declared by type <code>Order</code> at extension <code>core</code>
	 */
	@Deprecated
	public ReturnOrderModel(final CurrencyModel _currency, final Date _date, final ReturnFulfillmentStatus _fulfilmentStatus, final UserModel _user)
	{
		super();
		setCurrency(_currency);
		setDate(_date);
		setFulfilmentStatus(_fulfilmentStatus);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _date initial attribute declared by type <code>AbstractOrder</code> at extension <code>core</code>
	 * @param _fulfilmentStatus initial attribute declared by type <code>ReturnOrder</code> at extension <code>basecommerce</code>
	 * @param _originalVersion initial attribute declared by type <code>Order</code> at extension <code>basecommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>Order</code> at extension <code>core</code>
	 * @param _versionID initial attribute declared by type <code>Order</code> at extension <code>basecommerce</code>
	 */
	@Deprecated
	public ReturnOrderModel(final CurrencyModel _currency, final Date _date, final ReturnFulfillmentStatus _fulfilmentStatus, final OrderModel _originalVersion, final ItemModel _owner, final UserModel _user, final String _versionID)
	{
		super();
		setCurrency(_currency);
		setDate(_date);
		setFulfilmentStatus(_fulfilmentStatus);
		setOriginalVersion(_originalVersion);
		setOwner(_owner);
		setUser(_user);
		setVersionID(_versionID);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReturnOrder.fulfilmentStatus</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the fulfilmentStatus
	 */
	@Accessor(qualifier = "fulfilmentStatus", type = Accessor.Type.GETTER)
	public ReturnFulfillmentStatus getFulfilmentStatus()
	{
		return getPersistenceContext().getPropertyValue(FULFILMENTSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReturnOrder.notes</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the notes
	 */
	@Accessor(qualifier = "notes", type = Accessor.Type.GETTER)
	public String getNotes()
	{
		return getPersistenceContext().getPropertyValue(NOTES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ReturnOrder.fulfilmentStatus</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the fulfilmentStatus
	 */
	@Accessor(qualifier = "fulfilmentStatus", type = Accessor.Type.SETTER)
	public void setFulfilmentStatus(final ReturnFulfillmentStatus value)
	{
		getPersistenceContext().setPropertyValue(FULFILMENTSTATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ReturnOrder.notes</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the notes
	 */
	@Accessor(qualifier = "notes", type = Accessor.Type.SETTER)
	public void setNotes(final String value)
	{
		getPersistenceContext().setPropertyValue(NOTES, value);
	}
	
}
