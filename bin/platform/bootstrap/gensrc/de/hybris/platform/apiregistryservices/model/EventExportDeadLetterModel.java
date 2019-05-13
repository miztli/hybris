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
package de.hybris.platform.apiregistryservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.enums.DestinationChannel;
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type EventExportDeadLetter first defined at extension apiregistryservices.
 */
@SuppressWarnings("all")
public class EventExportDeadLetterModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "EventExportDeadLetter";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.id</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.eventType</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EVENTTYPE = "eventType";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONTARGET = "destinationTarget";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.destinationChannel</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONCHANNEL = "destinationChannel";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.timestamp</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String TIMESTAMP = "timestamp";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.payload</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String PAYLOAD = "payload";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventExportDeadLetter.error</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ERROR = "error";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public EventExportDeadLetterModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public EventExportDeadLetterModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationChannel initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _destinationTarget initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _error initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _eventType initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _payload initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _timestamp initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public EventExportDeadLetterModel(final DestinationChannel _destinationChannel, final DestinationTargetModel _destinationTarget, final String _error, final String _eventType, final String _id, final String _payload, final Date _timestamp)
	{
		super();
		setDestinationChannel(_destinationChannel);
		setDestinationTarget(_destinationTarget);
		setError(_error);
		setEventType(_eventType);
		setId(_id);
		setPayload(_payload);
		setTimestamp(_timestamp);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationChannel initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _destinationTarget initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _error initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _eventType initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _payload initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 * @param _timestamp initial attribute declared by type <code>EventExportDeadLetter</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public EventExportDeadLetterModel(final DestinationChannel _destinationChannel, final DestinationTargetModel _destinationTarget, final String _error, final String _eventType, final String _id, final ItemModel _owner, final String _payload, final Date _timestamp)
	{
		super();
		setDestinationChannel(_destinationChannel);
		setDestinationTarget(_destinationTarget);
		setError(_error);
		setEventType(_eventType);
		setId(_id);
		setOwner(_owner);
		setPayload(_payload);
		setTimestamp(_timestamp);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.destinationChannel</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the destinationChannel
	 */
	@Accessor(qualifier = "destinationChannel", type = Accessor.Type.GETTER)
	public DestinationChannel getDestinationChannel()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONCHANNEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the destinationTarget
	 */
	@Accessor(qualifier = "destinationTarget", type = Accessor.Type.GETTER)
	public DestinationTargetModel getDestinationTarget()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONTARGET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.error</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the error
	 */
	@Accessor(qualifier = "error", type = Accessor.Type.GETTER)
	public String getError()
	{
		return getPersistenceContext().getPropertyValue(ERROR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.eventType</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the eventType
	 */
	@Accessor(qualifier = "eventType", type = Accessor.Type.GETTER)
	public String getEventType()
	{
		return getPersistenceContext().getPropertyValue(EVENTTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.payload</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.GETTER)
	public String getPayload()
	{
		return getPersistenceContext().getPropertyValue(PAYLOAD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventExportDeadLetter.timestamp</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the timestamp
	 */
	@Accessor(qualifier = "timestamp", type = Accessor.Type.GETTER)
	public Date getTimestamp()
	{
		return getPersistenceContext().getPropertyValue(TIMESTAMP);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventExportDeadLetter.destinationChannel</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the destinationChannel
	 */
	@Accessor(qualifier = "destinationChannel", type = Accessor.Type.SETTER)
	public void setDestinationChannel(final DestinationChannel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONCHANNEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventExportDeadLetter.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the destinationTarget
	 */
	@Accessor(qualifier = "destinationTarget", type = Accessor.Type.SETTER)
	public void setDestinationTarget(final DestinationTargetModel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONTARGET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventExportDeadLetter.error</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the error
	 */
	@Accessor(qualifier = "error", type = Accessor.Type.SETTER)
	public void setError(final String value)
	{
		getPersistenceContext().setPropertyValue(ERROR, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventExportDeadLetter.eventType</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the eventType
	 */
	@Accessor(qualifier = "eventType", type = Accessor.Type.SETTER)
	public void setEventType(final String value)
	{
		getPersistenceContext().setPropertyValue(EVENTTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>EventExportDeadLetter.id</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventExportDeadLetter.payload</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.SETTER)
	public void setPayload(final String value)
	{
		getPersistenceContext().setPropertyValue(PAYLOAD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventExportDeadLetter.timestamp</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the timestamp
	 */
	@Accessor(qualifier = "timestamp", type = Accessor.Type.SETTER)
	public void setTimestamp(final Date value)
	{
		getPersistenceContext().setPropertyValue(TIMESTAMP, value);
	}
	
}
