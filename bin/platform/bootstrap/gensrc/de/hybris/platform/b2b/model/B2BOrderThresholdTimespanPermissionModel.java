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
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.enums.B2BPeriodRange;
import de.hybris.platform.b2b.model.B2BOrderThresholdPermissionModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type B2BOrderThresholdTimespanPermission first defined at extension b2bapprovalprocess.
 */
@SuppressWarnings("all")
public class B2BOrderThresholdTimespanPermissionModel extends B2BOrderThresholdPermissionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BOrderThresholdTimespanPermission";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BOrderThresholdTimespanPermission.range</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String RANGE = "range";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BOrderThresholdTimespanPermissionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BOrderThresholdTimespanPermissionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _code initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _currency initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _range initial attribute declared by type <code>B2BOrderThresholdTimespanPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _threshold initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 */
	@Deprecated
	public B2BOrderThresholdTimespanPermissionModel(final B2BUnitModel _Unit, final String _code, final CurrencyModel _currency, final B2BPeriodRange _range, final Double _threshold)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setCurrency(_currency);
		setRange(_range);
		setThreshold(_threshold);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _code initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _currency initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _range initial attribute declared by type <code>B2BOrderThresholdTimespanPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _threshold initial attribute declared by type <code>B2BOrderThresholdPermission</code> at extension <code>b2bapprovalprocess</code>
	 */
	@Deprecated
	public B2BOrderThresholdTimespanPermissionModel(final B2BUnitModel _Unit, final String _code, final CurrencyModel _currency, final ItemModel _owner, final B2BPeriodRange _range, final Double _threshold)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setCurrency(_currency);
		setOwner(_owner);
		setRange(_range);
		setThreshold(_threshold);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BOrderThresholdTimespanPermission.range</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the range
	 */
	@Accessor(qualifier = "range", type = Accessor.Type.GETTER)
	public B2BPeriodRange getRange()
	{
		return getPersistenceContext().getPropertyValue(RANGE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BOrderThresholdTimespanPermission.range</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the range
	 */
	@Accessor(qualifier = "range", type = Accessor.Type.SETTER)
	public void setRange(final B2BPeriodRange value)
	{
		getPersistenceContext().setPropertyValue(RANGE, value);
	}
	
}
