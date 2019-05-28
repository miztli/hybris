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
package de.hybris.platform.apiregistryservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.model.AbstractDestinationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;

/**
 * Generated model class for type Endpoint first defined at extension apiregistryservices.
 */
@SuppressWarnings("all")
public class EndpointModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Endpoint";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.id</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.version</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String VERSION = "version";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.description</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.specUrl</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String SPECURL = "specUrl";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.specData</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String SPECDATA = "specData";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.extensionName</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String EXTENSIONNAME = "extensionName";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.name</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>Endpoint.destinations</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONS = "destinations";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public EndpointModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public EndpointModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>Endpoint</code> at extension <code>apiregistryservices</code>
	 * @param _name initial attribute declared by type <code>Endpoint</code> at extension <code>apiregistryservices</code>
	 * @param _version initial attribute declared by type <code>Endpoint</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public EndpointModel(final String _id, final String _name, final String _version)
	{
		super();
		setId(_id);
		setName(_name);
		setVersion(_version);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>Endpoint</code> at extension <code>apiregistryservices</code>
	 * @param _name initial attribute declared by type <code>Endpoint</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _version initial attribute declared by type <code>Endpoint</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public EndpointModel(final String _id, final String _name, final ItemModel _owner, final String _version)
	{
		super();
		setId(_id);
		setName(_name);
		setOwner(_owner);
		setVersion(_version);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.description</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.destinations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the destinations
	 */
	@Accessor(qualifier = "destinations", type = Accessor.Type.GETTER)
	public Collection<AbstractDestinationModel> getDestinations()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.extensionName</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the extensionName
	 */
	@Accessor(qualifier = "extensionName", type = Accessor.Type.GETTER)
	public String getExtensionName()
	{
		return getPersistenceContext().getPropertyValue(EXTENSIONNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.name</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.specData</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the specData
	 */
	@Accessor(qualifier = "specData", type = Accessor.Type.GETTER)
	public String getSpecData()
	{
		return getPersistenceContext().getPropertyValue(SPECDATA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.specUrl</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the specUrl
	 */
	@Accessor(qualifier = "specUrl", type = Accessor.Type.GETTER)
	public String getSpecUrl()
	{
		return getPersistenceContext().getPropertyValue(SPECURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Endpoint.version</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the version
	 */
	@Accessor(qualifier = "version", type = Accessor.Type.GETTER)
	public String getVersion()
	{
		return getPersistenceContext().getPropertyValue(VERSION);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Endpoint.description</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Endpoint.destinations</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the destinations
	 */
	@Accessor(qualifier = "destinations", type = Accessor.Type.SETTER)
	public void setDestinations(final Collection<AbstractDestinationModel> value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Endpoint.extensionName</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the extensionName
	 */
	@Accessor(qualifier = "extensionName", type = Accessor.Type.SETTER)
	public void setExtensionName(final String value)
	{
		getPersistenceContext().setPropertyValue(EXTENSIONNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Endpoint.id</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Endpoint.name</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Endpoint.specData</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the specData
	 */
	@Accessor(qualifier = "specData", type = Accessor.Type.SETTER)
	public void setSpecData(final String value)
	{
		getPersistenceContext().setPropertyValue(SPECDATA, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Endpoint.specUrl</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the specUrl
	 */
	@Accessor(qualifier = "specUrl", type = Accessor.Type.SETTER)
	public void setSpecUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(SPECURL, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>Endpoint.version</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the version
	 */
	@Accessor(qualifier = "version", type = Accessor.Type.SETTER)
	public void setVersion(final String value)
	{
		getPersistenceContext().setPropertyValue(VERSION, value);
	}
	
}
