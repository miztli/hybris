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
package de.hybris.platform.acceleratorservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;

/**
 * Generated model class for type UncollectedOrdersCronJob first defined at extension acceleratorservices.
 */
@SuppressWarnings("all")
public class UncollectedOrdersCronJobModel extends CronJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "UncollectedOrdersCronJob";
	
	/**<i>Generated relation code constant for relation <code>BaseSite2UncollectedOrdersCronJob</code> defining source attribute <code>sites</code> in extension <code>acceleratorservices</code>.</i>*/
	public static final String _BASESITE2UNCOLLECTEDORDERSCRONJOB = "BaseSite2UncollectedOrdersCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>UncollectedOrdersCronJob.sites</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String SITES = "sites";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public UncollectedOrdersCronJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public UncollectedOrdersCronJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 * @param _sites initial attribute declared by type <code>UncollectedOrdersCronJob</code> at extension <code>acceleratorservices</code>
	 */
	@Deprecated
	public UncollectedOrdersCronJobModel(final JobModel _job, final Collection<BaseSiteModel> _sites)
	{
		super();
		setJob(_job);
		setSites(_sites);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _sites initial attribute declared by type <code>UncollectedOrdersCronJob</code> at extension <code>acceleratorservices</code>
	 */
	@Deprecated
	public UncollectedOrdersCronJobModel(final JobModel _job, final ItemModel _owner, final Collection<BaseSiteModel> _sites)
	{
		super();
		setJob(_job);
		setOwner(_owner);
		setSites(_sites);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UncollectedOrdersCronJob.sites</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the sites
	 */
	@Accessor(qualifier = "sites", type = Accessor.Type.GETTER)
	public Collection<BaseSiteModel> getSites()
	{
		return getPersistenceContext().getPropertyValue(SITES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>UncollectedOrdersCronJob.sites</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the sites
	 */
	@Accessor(qualifier = "sites", type = Accessor.Type.SETTER)
	public void setSites(final Collection<BaseSiteModel> value)
	{
		getPersistenceContext().setPropertyValue(SITES, value);
	}
	
}
