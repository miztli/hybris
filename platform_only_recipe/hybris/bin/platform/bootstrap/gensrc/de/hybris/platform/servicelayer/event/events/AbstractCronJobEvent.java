/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 17, 2019 3:23:34 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.servicelayer.event.events;

import java.io.Serializable;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import de.hybris.platform.core.PK;

public abstract  class AbstractCronJobEvent  extends AbstractEvent {


	/** <i>Generated property</i> for <code>AbstractCronJobEvent.cronJobPK</code> property defined at extension <code>processing</code>. */
		
	private PK cronJobPK;

	/** <i>Generated property</i> for <code>AbstractCronJobEvent.cronJob</code> property defined at extension <code>processing</code>. */
		
	private String cronJob;

	/** <i>Generated property</i> for <code>AbstractCronJobEvent.cronJobType</code> property defined at extension <code>processing</code>. */
		
	private String cronJobType;

	/** <i>Generated property</i> for <code>AbstractCronJobEvent.job</code> property defined at extension <code>processing</code>. */
		
	private String job;

	/** <i>Generated property</i> for <code>AbstractCronJobEvent.jobType</code> property defined at extension <code>processing</code>. */
		
	private String jobType;
	
	public AbstractCronJobEvent()
	{
		super();
	}

	public AbstractCronJobEvent(final Serializable source)
	{
		super(source);
	}
	
	
	
	public void setCronJobPK(final PK cronJobPK)
	{
		this.cronJobPK = cronJobPK;
	}
	
	
	
	public PK getCronJobPK() 
	{
		return cronJobPK;
	}
	
	
	
	public void setCronJob(final String cronJob)
	{
		this.cronJob = cronJob;
	}
	
	
	
	public String getCronJob() 
	{
		return cronJob;
	}
	
	
	
	public void setCronJobType(final String cronJobType)
	{
		this.cronJobType = cronJobType;
	}
	
	
	
	public String getCronJobType() 
	{
		return cronJobType;
	}
	
	
	
	public void setJob(final String job)
	{
		this.job = job;
	}
	
	
	
	public String getJob() 
	{
		return job;
	}
	
	
	
	public void setJobType(final String jobType)
	{
		this.jobType = jobType;
	}
	
	
	
	public String getJobType() 
	{
		return jobType;
	}
	


}
