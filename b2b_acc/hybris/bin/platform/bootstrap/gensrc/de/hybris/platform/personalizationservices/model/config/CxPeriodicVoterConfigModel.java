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
package de.hybris.platform.personalizationservices.model.config;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.personalizationservices.model.config.CxAbstractCalcConfigModel;
import de.hybris.platform.personalizationservices.model.config.CxConfigModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type CxPeriodicVoterConfig first defined at extension personalizationservices.
 */
@SuppressWarnings("all")
public class CxPeriodicVoterConfigModel extends CxAbstractCalcConfigModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CxPeriodicVoterConfig";
	
	/**<i>Generated relation code constant for relation <code>CxConfigToCxPeriodicVoterConfig</code> defining source attribute <code>cxConfig</code> in extension <code>personalizationservices</code>.</i>*/
	public static final String _CXCONFIGTOCXPERIODICVOTERCONFIG = "CxConfigToCxPeriodicVoterConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxPeriodicVoterConfig.userMinTime</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String USERMINTIME = "userMinTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxPeriodicVoterConfig.userMinRequestNumber</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String USERMINREQUESTNUMBER = "userMinRequestNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxPeriodicVoterConfig.cxConfig</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CXCONFIG = "cxConfig";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CxPeriodicVoterConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CxPeriodicVoterConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _actions initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _code initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _cxConfig initial attribute declared by type <code>CxPeriodicVoterConfig</code> at extension <code>personalizationservices</code>
	 * @param _userMinRequestNumber initial attribute declared by type <code>CxPeriodicVoterConfig</code> at extension <code>personalizationservices</code>
	 * @param _userMinTime initial attribute declared by type <code>CxPeriodicVoterConfig</code> at extension <code>personalizationservices</code>
	 */
	@Deprecated
	public CxPeriodicVoterConfigModel(final Set<String> _actions, final String _code, final CxConfigModel _cxConfig, final Integer _userMinRequestNumber, final Long _userMinTime)
	{
		super();
		setActions(_actions);
		setCode(_code);
		setCxConfig(_cxConfig);
		setUserMinRequestNumber(_userMinRequestNumber);
		setUserMinTime(_userMinTime);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _actions initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _code initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _cxConfig initial attribute declared by type <code>CxPeriodicVoterConfig</code> at extension <code>personalizationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _userMinRequestNumber initial attribute declared by type <code>CxPeriodicVoterConfig</code> at extension <code>personalizationservices</code>
	 * @param _userMinTime initial attribute declared by type <code>CxPeriodicVoterConfig</code> at extension <code>personalizationservices</code>
	 */
	@Deprecated
	public CxPeriodicVoterConfigModel(final Set<String> _actions, final String _code, final CxConfigModel _cxConfig, final ItemModel _owner, final Integer _userMinRequestNumber, final Long _userMinTime)
	{
		super();
		setActions(_actions);
		setCode(_code);
		setCxConfig(_cxConfig);
		setOwner(_owner);
		setUserMinRequestNumber(_userMinRequestNumber);
		setUserMinTime(_userMinTime);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxPeriodicVoterConfig.cxConfig</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the cxConfig
	 */
	@Accessor(qualifier = "cxConfig", type = Accessor.Type.GETTER)
	public CxConfigModel getCxConfig()
	{
		return getPersistenceContext().getPropertyValue(CXCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxPeriodicVoterConfig.userMinRequestNumber</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the userMinRequestNumber - Actions requiring request number
	 */
	@Accessor(qualifier = "userMinRequestNumber", type = Accessor.Type.GETTER)
	public Integer getUserMinRequestNumber()
	{
		return getPersistenceContext().getPropertyValue(USERMINREQUESTNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxPeriodicVoterConfig.userMinTime</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the userMinTime - Actions interval
	 */
	@Accessor(qualifier = "userMinTime", type = Accessor.Type.GETTER)
	public Long getUserMinTime()
	{
		return getPersistenceContext().getPropertyValue(USERMINTIME);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxPeriodicVoterConfig.cxConfig</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the cxConfig
	 */
	@Accessor(qualifier = "cxConfig", type = Accessor.Type.SETTER)
	public void setCxConfig(final CxConfigModel value)
	{
		getPersistenceContext().setPropertyValue(CXCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxPeriodicVoterConfig.userMinRequestNumber</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the userMinRequestNumber - Actions requiring request number
	 */
	@Accessor(qualifier = "userMinRequestNumber", type = Accessor.Type.SETTER)
	public void setUserMinRequestNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(USERMINREQUESTNUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxPeriodicVoterConfig.userMinTime</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the userMinTime - Actions interval
	 */
	@Accessor(qualifier = "userMinTime", type = Accessor.Type.SETTER)
	public void setUserMinTime(final Long value)
	{
		getPersistenceContext().setPropertyValue(USERMINTIME, value);
	}
	
}
