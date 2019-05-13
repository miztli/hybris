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

import de.hybris.platform.apiregistryservices.model.AbstractDestinationModel;
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel;
import de.hybris.platform.apiregistryservices.model.EndpointModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ConsumedDestination first defined at extension apiregistryservices.
 */
@SuppressWarnings("all")
public class ConsumedDestinationModel extends AbstractDestinationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ConsumedDestination";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConsumedDestinationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConsumedDestinationModel(final ItemModelContext ctx)
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
	public ConsumedDestinationModel(final DestinationTargetModel _destinationTarget, final EndpointModel _endpoint, final String _id, final String _url)
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
	public ConsumedDestinationModel(final DestinationTargetModel _destinationTarget, final EndpointModel _endpoint, final String _id, final ItemModel _owner, final String _url)
	{
		super();
		setDestinationTarget(_destinationTarget);
		setEndpoint(_endpoint);
		setId(_id);
		setOwner(_owner);
		setUrl(_url);
	}
	
	
}
