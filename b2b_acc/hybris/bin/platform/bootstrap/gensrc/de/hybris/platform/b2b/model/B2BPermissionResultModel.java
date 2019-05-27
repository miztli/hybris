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
import de.hybris.platform.b2b.enums.PermissionStatus;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BPermissionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type B2BPermissionResult first defined at extension b2bapprovalprocess.
 */
@SuppressWarnings("all")
public class B2BPermissionResultModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BPermissionResult";
	
	/**<i>Generated relation code constant for relation <code>AbstractOrder2B2BPermissionResults</code> defining source attribute <code>Order</code> in extension <code>b2bapprovalprocess</code>.</i>*/
	public static final String _ABSTRACTORDER2B2BPERMISSIONRESULTS = "AbstractOrder2B2BPermissionResults";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.permission</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String PERMISSION = "permission";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.permissionTypeCode</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String PERMISSIONTYPECODE = "permissionTypeCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.status</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.approver</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String APPROVER = "approver";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.note</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String NOTE = "note";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.statusDisplay</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String STATUSDISPLAY = "statusDisplay";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.OrderPOS</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String ORDERPOS = "OrderPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermissionResult.Order</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String ORDER = "Order";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BPermissionResultModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BPermissionResultModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BPermissionResultModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.approver</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the approver
	 */
	@Accessor(qualifier = "approver", type = Accessor.Type.GETTER)
	public B2BCustomerModel getApprover()
	{
		return getPersistenceContext().getPropertyValue(APPROVER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.note</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the note
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.GETTER)
	public String getNote()
	{
		return getNote(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.note</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @param loc the value localization key 
	 * @return the note
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.GETTER)
	public String getNote(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NOTE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.Order</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the Order
	 */
	@Accessor(qualifier = "Order", type = Accessor.Type.GETTER)
	public AbstractOrderModel getOrder()
	{
		return getPersistenceContext().getPropertyValue(ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.permission</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the permission
	 */
	@Accessor(qualifier = "permission", type = Accessor.Type.GETTER)
	public B2BPermissionModel getPermission()
	{
		return getPersistenceContext().getPropertyValue(PERMISSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.permissionTypeCode</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the permissionTypeCode - the item type code for the permission the result is
	 * 						holding
	 * 						as defined in items.xml
	 */
	@Accessor(qualifier = "permissionTypeCode", type = Accessor.Type.GETTER)
	public String getPermissionTypeCode()
	{
		return getPersistenceContext().getPropertyValue(PERMISSIONTYPECODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.status</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public PermissionStatus getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermissionResult.statusDisplay</code> dynamic attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the statusDisplay
	 */
	@Accessor(qualifier = "statusDisplay", type = Accessor.Type.GETTER)
	public String getStatusDisplay()
	{
		return getPersistenceContext().getDynamicValue(this,STATUSDISPLAY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.approver</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the approver
	 */
	@Accessor(qualifier = "approver", type = Accessor.Type.SETTER)
	public void setApprover(final B2BCustomerModel value)
	{
		getPersistenceContext().setPropertyValue(APPROVER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.note</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the note
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.SETTER)
	public void setNote(final String value)
	{
		setNote(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.note</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the note
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.SETTER)
	public void setNote(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NOTE, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.Order</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Order
	 */
	@Accessor(qualifier = "Order", type = Accessor.Type.SETTER)
	public void setOrder(final AbstractOrderModel value)
	{
		getPersistenceContext().setPropertyValue(ORDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.permission</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the permission
	 */
	@Accessor(qualifier = "permission", type = Accessor.Type.SETTER)
	public void setPermission(final B2BPermissionModel value)
	{
		getPersistenceContext().setPropertyValue(PERMISSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.permissionTypeCode</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the permissionTypeCode - the item type code for the permission the result is
	 * 						holding
	 * 						as defined in items.xml
	 */
	@Accessor(qualifier = "permissionTypeCode", type = Accessor.Type.SETTER)
	public void setPermissionTypeCode(final String value)
	{
		getPersistenceContext().setPropertyValue(PERMISSIONTYPECODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermissionResult.status</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final PermissionStatus value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
}
