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
package de.hybris.platform.ruleengine.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type DroolsKIEModuleMedia first defined at extension ruleengine.
 */
@SuppressWarnings("all")
public class DroolsKIEModuleMediaModel extends MediaModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "DroolsKIEModuleMedia";
	
	/** <i>Generated constant</i> - Attribute key of <code>DroolsKIEModuleMedia.kieModuleName</code> attribute defined at extension <code>ruleengine</code>. */
	public static final String KIEMODULENAME = "kieModuleName";
	
	/** <i>Generated constant</i> - Attribute key of <code>DroolsKIEModuleMedia.releaseId</code> attribute defined at extension <code>ruleengine</code>. */
	public static final String RELEASEID = "releaseId";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public DroolsKIEModuleMediaModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public DroolsKIEModuleMediaModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>DroolsKIEModuleMedia</code> at extension <code>ruleengine</code>
	 * @param _code initial attribute declared by type <code>Media</code> at extension <code>core</code>
	 * @param _kieModuleName initial attribute declared by type <code>DroolsKIEModuleMedia</code> at extension <code>ruleengine</code>
	 * @param _releaseId initial attribute declared by type <code>DroolsKIEModuleMedia</code> at extension <code>ruleengine</code>
	 */
	@Deprecated
	public DroolsKIEModuleMediaModel(final CatalogVersionModel _catalogVersion, final String _code, final String _kieModuleName, final String _releaseId)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setKieModuleName(_kieModuleName);
		setReleaseId(_releaseId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>DroolsKIEModuleMedia</code> at extension <code>ruleengine</code>
	 * @param _code initial attribute declared by type <code>Media</code> at extension <code>core</code>
	 * @param _kieModuleName initial attribute declared by type <code>DroolsKIEModuleMedia</code> at extension <code>ruleengine</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _releaseId initial attribute declared by type <code>DroolsKIEModuleMedia</code> at extension <code>ruleengine</code>
	 */
	@Deprecated
	public DroolsKIEModuleMediaModel(final CatalogVersionModel _catalogVersion, final String _code, final String _kieModuleName, final ItemModel _owner, final String _releaseId)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setKieModuleName(_kieModuleName);
		setOwner(_owner);
		setReleaseId(_releaseId);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DroolsKIEModuleMedia.kieModuleName</code> attribute defined at extension <code>ruleengine</code>. 
	 * @return the kieModuleName
	 */
	@Accessor(qualifier = "kieModuleName", type = Accessor.Type.GETTER)
	public String getKieModuleName()
	{
		return getPersistenceContext().getPropertyValue(KIEMODULENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DroolsKIEModuleMedia.releaseId</code> attribute defined at extension <code>ruleengine</code>. 
	 * @return the releaseId
	 */
	@Accessor(qualifier = "releaseId", type = Accessor.Type.GETTER)
	public String getReleaseId()
	{
		return getPersistenceContext().getPropertyValue(RELEASEID);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DroolsKIEModuleMedia.kieModuleName</code> attribute defined at extension <code>ruleengine</code>. 
	 *  
	 * @param value the kieModuleName
	 */
	@Accessor(qualifier = "kieModuleName", type = Accessor.Type.SETTER)
	public void setKieModuleName(final String value)
	{
		getPersistenceContext().setPropertyValue(KIEMODULENAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DroolsKIEModuleMedia.releaseId</code> attribute defined at extension <code>ruleengine</code>. 
	 *  
	 * @param value the releaseId
	 */
	@Accessor(qualifier = "releaseId", type = Accessor.Type.SETTER)
	public void setReleaseId(final String value)
	{
		getPersistenceContext().setPropertyValue(RELEASEID, value);
	}
	
}
