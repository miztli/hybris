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
import de.hybris.platform.apiregistryservices.model.AbstractDestinationModel;
import de.hybris.platform.apiregistryservices.model.events.EventConfigurationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;

/**
 * Generated model class for type DestinationTarget first defined at extension apiregistryservices.
 */
@SuppressWarnings("all")
public class DestinationTargetModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "DestinationTarget";
	
	/** <i>Generated constant</i> - Attribute key of <code>DestinationTarget.id</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>DestinationTarget.destinationChannel</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONCHANNEL = "destinationChannel";
	
	/** <i>Generated constant</i> - Attribute key of <code>DestinationTarget.eventConfigurations</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EVENTCONFIGURATIONS = "eventConfigurations";
	
	/** <i>Generated constant</i> - Attribute key of <code>DestinationTarget.destinations</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONS = "destinations";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public DestinationTargetModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public DestinationTargetModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>DestinationTarget</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public DestinationTargetModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>DestinationTarget</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public DestinationTargetModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DestinationTarget.destinationChannel</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the destinationChannel
	 */
	@Accessor(qualifier = "destinationChannel", type = Accessor.Type.GETTER)
	public DestinationChannel getDestinationChannel()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONCHANNEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DestinationTarget.destinations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the destinations
	 */
	@Accessor(qualifier = "destinations", type = Accessor.Type.GETTER)
	public Collection<AbstractDestinationModel> getDestinations()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DestinationTarget.eventConfigurations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the eventConfigurations
	 */
	@Accessor(qualifier = "eventConfigurations", type = Accessor.Type.GETTER)
	public Collection<EventConfigurationModel> getEventConfigurations()
	{
		return getPersistenceContext().getPropertyValue(EVENTCONFIGURATIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DestinationTarget.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DestinationTarget.destinationChannel</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the destinationChannel
	 */
	@Accessor(qualifier = "destinationChannel", type = Accessor.Type.SETTER)
	public void setDestinationChannel(final DestinationChannel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONCHANNEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DestinationTarget.destinations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the destinations
	 */
	@Accessor(qualifier = "destinations", type = Accessor.Type.SETTER)
	public void setDestinations(final Collection<AbstractDestinationModel> value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DestinationTarget.eventConfigurations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the eventConfigurations
	 */
	@Accessor(qualifier = "eventConfigurations", type = Accessor.Type.SETTER)
	public void setEventConfigurations(final Collection<EventConfigurationModel> value)
	{
		getPersistenceContext().setPropertyValue(EVENTCONFIGURATIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DestinationTarget.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
}
