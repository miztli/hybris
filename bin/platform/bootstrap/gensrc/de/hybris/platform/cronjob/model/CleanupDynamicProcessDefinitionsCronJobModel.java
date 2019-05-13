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
package de.hybris.platform.cronjob.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CleanupDynamicProcessDefinitionsCronJob first defined at extension processing.
 */
@SuppressWarnings("all")
public class CleanupDynamicProcessDefinitionsCronJobModel extends CronJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CleanupDynamicProcessDefinitionsCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>CleanupDynamicProcessDefinitionsCronJob.timeThreshold</code> attribute defined at extension <code>processing</code>. */
	public static final String TIMETHRESHOLD = "timeThreshold";
	
	/** <i>Generated constant</i> - Attribute key of <code>CleanupDynamicProcessDefinitionsCronJob.versionThreshold</code> attribute defined at extension <code>processing</code>. */
	public static final String VERSIONTHRESHOLD = "versionThreshold";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CleanupDynamicProcessDefinitionsCronJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CleanupDynamicProcessDefinitionsCronJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 */
	@Deprecated
	public CleanupDynamicProcessDefinitionsCronJobModel(final JobModel _job)
	{
		super();
		setJob(_job);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public CleanupDynamicProcessDefinitionsCronJobModel(final JobModel _job, final ItemModel _owner)
	{
		super();
		setJob(_job);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CleanupDynamicProcessDefinitionsCronJob.timeThreshold</code> attribute defined at extension <code>processing</code>. 
	 * @return the timeThreshold
	 */
	@Accessor(qualifier = "timeThreshold", type = Accessor.Type.GETTER)
	public Integer getTimeThreshold()
	{
		return getPersistenceContext().getPropertyValue(TIMETHRESHOLD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CleanupDynamicProcessDefinitionsCronJob.versionThreshold</code> attribute defined at extension <code>processing</code>. 
	 * @return the versionThreshold
	 */
	@Accessor(qualifier = "versionThreshold", type = Accessor.Type.GETTER)
	public Integer getVersionThreshold()
	{
		return getPersistenceContext().getPropertyValue(VERSIONTHRESHOLD);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CleanupDynamicProcessDefinitionsCronJob.timeThreshold</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the timeThreshold
	 */
	@Accessor(qualifier = "timeThreshold", type = Accessor.Type.SETTER)
	public void setTimeThreshold(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TIMETHRESHOLD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CleanupDynamicProcessDefinitionsCronJob.versionThreshold</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the versionThreshold
	 */
	@Accessor(qualifier = "versionThreshold", type = Accessor.Type.SETTER)
	public void setVersionThreshold(final Integer value)
	{
		getPersistenceContext().setPropertyValue(VERSIONTHRESHOLD, value);
	}
	
}
