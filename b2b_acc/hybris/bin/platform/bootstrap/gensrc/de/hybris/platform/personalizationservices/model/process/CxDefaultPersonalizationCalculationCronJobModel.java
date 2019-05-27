/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 27, 2019 5:14:19 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.personalizationservices.model.process;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type CxDefaultPersonalizationCalculationCronJob first defined at extension personalizationservices.
 */
@SuppressWarnings("all")
public class CxDefaultPersonalizationCalculationCronJobModel extends CronJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CxDefaultPersonalizationCalculationCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxDefaultPersonalizationCalculationCronJob.baseSites</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String BASESITES = "baseSites";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CxDefaultPersonalizationCalculationCronJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CxDefaultPersonalizationCalculationCronJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseSites initial attribute declared by type <code>CxDefaultPersonalizationCalculationCronJob</code> at extension <code>personalizationservices</code>
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 */
	@Deprecated
	public CxDefaultPersonalizationCalculationCronJobModel(final Set<BaseSiteModel> _baseSites, final JobModel _job)
	{
		super();
		setBaseSites(_baseSites);
		setJob(_job);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseSites initial attribute declared by type <code>CxDefaultPersonalizationCalculationCronJob</code> at extension <code>personalizationservices</code>
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public CxDefaultPersonalizationCalculationCronJobModel(final Set<BaseSiteModel> _baseSites, final JobModel _job, final ItemModel _owner)
	{
		super();
		setBaseSites(_baseSites);
		setJob(_job);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxDefaultPersonalizationCalculationCronJob.baseSites</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the baseSites - BaseSites that should be calculated and stored with default personalization
	 */
	@Accessor(qualifier = "baseSites", type = Accessor.Type.GETTER)
	public Set<BaseSiteModel> getBaseSites()
	{
		return getPersistenceContext().getPropertyValue(BASESITES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxDefaultPersonalizationCalculationCronJob.baseSites</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the baseSites - BaseSites that should be calculated and stored with default personalization
	 */
	@Accessor(qualifier = "baseSites", type = Accessor.Type.SETTER)
	public void setBaseSites(final Set<BaseSiteModel> value)
	{
		getPersistenceContext().setPropertyValue(BASESITES, value);
	}
	
}
