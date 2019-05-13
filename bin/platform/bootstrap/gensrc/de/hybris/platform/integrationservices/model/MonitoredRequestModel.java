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
package de.hybris.platform.integrationservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.enums.IntegrationRequestStatus;
import de.hybris.platform.integrationservices.model.IntegrationApiMediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type MonitoredRequest first defined at extension integrationservices.
 */
@SuppressWarnings("all")
public class MonitoredRequestModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MonitoredRequest";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.status</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.integrationKey</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONKEY = "integrationKey";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.type</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.payload</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String PAYLOAD = "payload";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.messageId</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String MESSAGEID = "messageId";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MonitoredRequestModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MonitoredRequestModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _status initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 */
	@Deprecated
	public MonitoredRequestModel(final IntegrationRequestStatus _status, final String _type)
	{
		super();
		setStatus(_status);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _status initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 */
	@Deprecated
	public MonitoredRequestModel(final ItemModel _owner, final IntegrationRequestStatus _status, final String _type)
	{
		super();
		setOwner(_owner);
		setStatus(_status);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.integrationKey</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationKey
	 */
	@Accessor(qualifier = "integrationKey", type = Accessor.Type.GETTER)
	public String getIntegrationKey()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONKEY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.messageId</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the messageId
	 */
	@Accessor(qualifier = "messageId", type = Accessor.Type.GETTER)
	public String getMessageId()
	{
		return getPersistenceContext().getPropertyValue(MESSAGEID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.payload</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.GETTER)
	public IntegrationApiMediaModel getPayload()
	{
		return getPersistenceContext().getPropertyValue(PAYLOAD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.status</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public IntegrationRequestStatus getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.type</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public String getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.integrationKey</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationKey
	 */
	@Accessor(qualifier = "integrationKey", type = Accessor.Type.SETTER)
	public void setIntegrationKey(final String value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONKEY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.messageId</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the messageId
	 */
	@Accessor(qualifier = "messageId", type = Accessor.Type.SETTER)
	public void setMessageId(final String value)
	{
		getPersistenceContext().setPropertyValue(MESSAGEID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.payload</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.SETTER)
	public void setPayload(final IntegrationApiMediaModel value)
	{
		getPersistenceContext().setPropertyValue(PAYLOAD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.status</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final IntegrationRequestStatus value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.type</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final String value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
}
