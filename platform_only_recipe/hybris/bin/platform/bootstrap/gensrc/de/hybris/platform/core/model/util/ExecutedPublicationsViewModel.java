/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 10:32:52 AM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.model.util;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.SyncItemCronJobModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type ExecutedPublicationsView first defined at extension catalog.
 */
@SuppressWarnings("all")
public class ExecutedPublicationsViewModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ExecutedPublicationsView";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.sourceVersion</code> attribute defined at extension <code>catalog</code>. */
	public static final String SOURCEVERSION = "sourceVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.targetVersion</code> attribute defined at extension <code>catalog</code>. */
	public static final String TARGETVERSION = "targetVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.code</code> attribute defined at extension <code>catalog</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.sicjpk</code> attribute defined at extension <code>catalog</code>. */
	public static final String SICJPK = "sicjpk";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.result</code> attribute defined at extension <code>catalog</code>. */
	public static final String RESULT = "result";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.startTime</code> attribute defined at extension <code>catalog</code>. */
	public static final String STARTTIME = "startTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>ExecutedPublicationsView.endTime</code> attribute defined at extension <code>catalog</code>. */
	public static final String ENDTIME = "endTime";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ExecutedPublicationsViewModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ExecutedPublicationsViewModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public ExecutedPublicationsViewModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.code</code> attribute defined at extension <code>catalog</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.endTime</code> attribute defined at extension <code>catalog</code>. 
	 * @return the endTime
	 */
	@Accessor(qualifier = "endTime", type = Accessor.Type.GETTER)
	public Date getEndTime()
	{
		return getPersistenceContext().getPropertyValue(ENDTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.result</code> attribute defined at extension <code>catalog</code>. 
	 * @return the result
	 */
	@Accessor(qualifier = "result", type = Accessor.Type.GETTER)
	public CronJobResult getResult()
	{
		return getPersistenceContext().getPropertyValue(RESULT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.sicjpk</code> attribute defined at extension <code>catalog</code>. 
	 * @return the sicjpk
	 */
	@Accessor(qualifier = "sicjpk", type = Accessor.Type.GETTER)
	public SyncItemCronJobModel getSicjpk()
	{
		return getPersistenceContext().getPropertyValue(SICJPK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.sourceVersion</code> attribute defined at extension <code>catalog</code>. 
	 * @return the sourceVersion
	 */
	@Accessor(qualifier = "sourceVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getSourceVersion()
	{
		return getPersistenceContext().getPropertyValue(SOURCEVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.startTime</code> attribute defined at extension <code>catalog</code>. 
	 * @return the startTime
	 */
	@Accessor(qualifier = "startTime", type = Accessor.Type.GETTER)
	public Date getStartTime()
	{
		return getPersistenceContext().getPropertyValue(STARTTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ExecutedPublicationsView.targetVersion</code> attribute defined at extension <code>catalog</code>. 
	 * @return the targetVersion
	 */
	@Accessor(qualifier = "targetVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getTargetVersion()
	{
		return getPersistenceContext().getPropertyValue(TARGETVERSION);
	}
	
}
