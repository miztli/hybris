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
package de.hybris.platform.acceleratorcms.model.components;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.acceleratorcms.model.components.SimpleBannerComponentModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.contents.components.SimpleCMSComponentModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type LogoComponent first defined at extension acceleratorcms.
 * <p>
 * It represents header logo.
 */
@SuppressWarnings("all")
public class LogoComponentModel extends SimpleCMSComponentModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "LogoComponent";
	
	/** <i>Generated constant</i> - Attribute key of <code>LogoComponent.logo</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String LOGO = "logo";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public LogoComponentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public LogoComponentModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated
	public LogoComponentModel(final CatalogVersionModel _catalogVersion, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated
	public LogoComponentModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LogoComponent.logo</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the logo - It is a banner component to be displayed.
	 */
	@Accessor(qualifier = "logo", type = Accessor.Type.GETTER)
	public SimpleBannerComponentModel getLogo()
	{
		return getPersistenceContext().getPropertyValue(LOGO);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>LogoComponent.logo</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the logo - It is a banner component to be displayed.
	 */
	@Accessor(qualifier = "logo", type = Accessor.Type.SETTER)
	public void setLogo(final SimpleBannerComponentModel value)
	{
		getPersistenceContext().setPropertyValue(LOGO, value);
	}
	
}
