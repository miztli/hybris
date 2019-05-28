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
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BPermissionModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type B2BOrderThresholdPermission first defined at extension b2bapprovalprocess.
 */
@SuppressWarnings("all")
public class B2BOrderThresholdPermissionModel extends B2BPermissionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BOrderThresholdPermission";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BOrderThresholdPermission.threshold</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String THRESHOLD = "threshold";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BOrderThresholdPermission.currency</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String CURRENCY = "currency";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BOrderThresholdPermissionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BOrderThresholdPermissionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _code initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _currency initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _threshold initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 */
	@Deprecated
	public B2BOrderThresholdPermissionModel(final B2BUnitModel _Unit, final String _code, final CurrencyModel _currency, final Double _threshold)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setCurrency(_currency);
		setThreshold(_threshold);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _code initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _currency initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _threshold initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 */
	@Deprecated
	public B2BOrderThresholdPermissionModel(final B2BUnitModel _Unit, final String _code, final CurrencyModel _currency, final ItemModel _owner, final Double _threshold)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setCurrency(_currency);
		setOwner(_owner);
		setThreshold(_threshold);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BOrderThresholdPermission.currency</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BOrderThresholdPermission.threshold</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the threshold
	 */
	@Accessor(qualifier = "threshold", type = Accessor.Type.GETTER)
	public Double getThreshold()
	{
		return getPersistenceContext().getPropertyValue(THRESHOLD);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BOrderThresholdPermission.currency</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BOrderThresholdPermission.threshold</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the threshold
	 */
	@Accessor(qualifier = "threshold", type = Accessor.Type.SETTER)
	public void setThreshold(final Double value)
	{
		getPersistenceContext().setPropertyValue(THRESHOLD, value);
	}
	
}
