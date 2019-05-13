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
import de.hybris.platform.apiregistryservices.model.AbstractCredentialModel;
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel;
import de.hybris.platform.apiregistryservices.model.EndpointModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Map;

/**
 * Generated model class for type AbstractDestination first defined at extension apiregistryservices.
 */
@SuppressWarnings("all")
public class AbstractDestinationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractDestination";
	
	/**<i>Generated relation code constant for relation <code>Endpoint2AbstractDestination</code> defining source attribute <code>endpoint</code> in extension <code>apiregistryservices</code>.</i>*/
	public static final String _ENDPOINT2ABSTRACTDESTINATION = "Endpoint2AbstractDestination";
	
	/**<i>Generated relation code constant for relation <code>DestinationTarget2Destination</code> defining source attribute <code>destinationTarget</code> in extension <code>apiregistryservices</code>.</i>*/
	public static final String _DESTINATIONTARGET2DESTINATION = "DestinationTarget2Destination";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.id</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.url</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String URL = "url";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.active</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ACTIVE = "active";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.additionalProperties</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ADDITIONALPROPERTIES = "additionalProperties";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.credential</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String CREDENTIAL = "credential";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.endpoint</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ENDPOINT = "endpoint";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractDestination.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String DESTINATIONTARGET = "destinationTarget";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractDestinationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractDestinationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationTarget initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 * @param _endpoint initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 * @param _url initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public AbstractDestinationModel(final DestinationTargetModel _destinationTarget, final EndpointModel _endpoint, final String _id, final String _url)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEndpoint(_endpoint);
		setId(_id);
		setUrl(_url);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destinationTarget initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 * @param _endpoint initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _url initial attribute declared by type <code>AbstractDestination</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public AbstractDestinationModel(final DestinationTargetModel _destinationTarget, final EndpointModel _endpoint, final String _id, final ItemModel _owner, final String _url)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEndpoint(_endpoint);
		setId(_id);
		setOwner(_owner);
		setUrl(_url);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.additionalProperties</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the additionalProperties
	 */
	@Accessor(qualifier = "additionalProperties", type = Accessor.Type.GETTER)
	public Map<String,String> getAdditionalProperties()
	{
		return getPersistenceContext().getPropertyValue(ADDITIONALPROPERTIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.credential</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the credential
	 */
	@Accessor(qualifier = "credential", type = Accessor.Type.GETTER)
	public AbstractCredentialModel getCredential()
	{
		return getPersistenceContext().getPropertyValue(CREDENTIAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the destinationTarget
	 */
	@Accessor(qualifier = "destinationTarget", type = Accessor.Type.GETTER)
	public DestinationTargetModel getDestinationTarget()
	{
		return getPersistenceContext().getPropertyValue(DESTINATIONTARGET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.endpoint</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the endpoint
	 */
	@Accessor(qualifier = "endpoint", type = Accessor.Type.GETTER)
	public EndpointModel getEndpoint()
	{
		return getPersistenceContext().getPropertyValue(ENDPOINT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.url</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the url
	 */
	@Accessor(qualifier = "url", type = Accessor.Type.GETTER)
	public String getUrl()
	{
		return getPersistenceContext().getPropertyValue(URL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractDestination.active</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.GETTER)
	public boolean isActive()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ACTIVE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractDestination.active</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.SETTER)
	public void setActive(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ACTIVE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractDestination.additionalProperties</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the additionalProperties
	 */
	@Accessor(qualifier = "additionalProperties", type = Accessor.Type.SETTER)
	public void setAdditionalProperties(final Map<String,String> value)
	{
		getPersistenceContext().setPropertyValue(ADDITIONALPROPERTIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractDestination.credential</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the credential
	 */
	@Accessor(qualifier = "credential", type = Accessor.Type.SETTER)
	public void setCredential(final AbstractCredentialModel value)
	{
		getPersistenceContext().setPropertyValue(CREDENTIAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AbstractDestination.destinationTarget</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the destinationTarget
	 */
	@Accessor(qualifier = "destinationTarget", type = Accessor.Type.SETTER)
	public void setDestinationTarget(final DestinationTargetModel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATIONTARGET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractDestination.endpoint</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the endpoint
	 */
	@Accessor(qualifier = "endpoint", type = Accessor.Type.SETTER)
	public void setEndpoint(final EndpointModel value)
	{
		getPersistenceContext().setPropertyValue(ENDPOINT, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AbstractDestination.id</code> attribute defined at extension <code>apiregistryservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractDestination.url</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the url
	 */
	@Accessor(qualifier = "url", type = Accessor.Type.SETTER)
	public void setUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(URL, value);
	}
	
}
