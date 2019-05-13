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
package de.hybris.platform.personalizationservices.model.config;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.model.consent.ConsentTemplateModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.personalizationservices.enums.CxCatalogLookupType;
import de.hybris.platform.personalizationservices.model.config.CxPeriodicVoterConfigModel;
import de.hybris.platform.personalizationservices.model.config.CxUrlVoterConfigModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Generated model class for type CxConfig first defined at extension personalizationservices.
 */
@SuppressWarnings("all")
public class CxConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CxConfig";
	
	/**<i>Generated relation code constant for relation <code>BaseSiteToCxConfig</code> defining source attribute <code>baseSites</code> in extension <code>personalizationservices</code>.</i>*/
	public static final String _BASESITETOCXCONFIG = "BaseSiteToCxConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.code</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.minAffinity</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String MINAFFINITY = "minAffinity";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.actionResultMaxRepeat</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ACTIONRESULTMAXREPEAT = "actionResultMaxRepeat";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.userChangedActions</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String USERCHANGEDACTIONS = "userChangedActions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.consentGivenActions</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CONSENTGIVENACTIONS = "consentGivenActions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.calculationProcess</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CALCULATIONPROCESS = "calculationProcess";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.ignoreRecalcForAnonymous</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String IGNORERECALCFORANONYMOUS = "ignoreRecalcForAnonymous";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.anonymousUserDefaultActions</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ANONYMOUSUSERDEFAULTACTIONS = "anonymousUserDefaultActions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.anonymousUserActions</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ANONYMOUSUSERACTIONS = "anonymousUserActions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.anonymousUserMinRequestNumber</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ANONYMOUSUSERMINREQUESTNUMBER = "anonymousUserMinRequestNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.anonymousUserMinTime</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ANONYMOUSUSERMINTIME = "anonymousUserMinTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.anonymousUserIgnoreOtherActions</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ANONYMOUSUSERIGNOREOTHERACTIONS = "anonymousUserIgnoreOtherActions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.catalogLookup</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CATALOGLOOKUP = "catalogLookup";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.consentTemplates</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CONSENTTEMPLATES = "consentTemplates";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.userSegmentsStoreInSession</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String USERSEGMENTSSTOREINSESSION = "userSegmentsStoreInSession";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.occPersonalizationEnabled</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String OCCPERSONALIZATIONENABLED = "occPersonalizationEnabled";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.occTTL</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String OCCTTL = "occTTL";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.occPersonalizationIdCookieEnabled</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String OCCPERSONALIZATIONIDCOOKIEENABLED = "occPersonalizationIdCookieEnabled";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.urlVoterConfigs</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String URLVOTERCONFIGS = "urlVoterConfigs";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.baseSites</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String BASESITES = "baseSites";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.periodicVoterConfigs</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String PERIODICVOTERCONFIGS = "periodicVoterConfigs";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxConfig.containerCleanupEnabled</code> attribute defined at extension <code>personalizationcms</code>. */
	public static final String CONTAINERCLEANUPENABLED = "containerCleanupEnabled";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CxConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CxConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>CxConfig</code> at extension <code>personalizationservices</code>
	 */
	@Deprecated
	public CxConfigModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>CxConfig</code> at extension <code>personalizationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public CxConfigModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.actionResultMaxRepeat</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the actionResultMaxRepeat - Number of retires in case of action result load error caused by optimistic locking failure
	 */
	@Accessor(qualifier = "actionResultMaxRepeat", type = Accessor.Type.GETTER)
	public Integer getActionResultMaxRepeat()
	{
		return getPersistenceContext().getPropertyValue(ACTIONRESULTMAXREPEAT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.anonymousUserActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the anonymousUserActions - Set of actions which should be called when anonymous user makes subsequent request
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserActions", type = Accessor.Type.GETTER)
	public Set<String> getAnonymousUserActions()
	{
		return getPersistenceContext().getPropertyValue(ANONYMOUSUSERACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.anonymousUserDefaultActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the anonymousUserDefaultActions - Set of actions which should be called when anonymous user makes first request
	 */
	@Accessor(qualifier = "anonymousUserDefaultActions", type = Accessor.Type.GETTER)
	public Set<String> getAnonymousUserDefaultActions()
	{
		return getPersistenceContext().getPropertyValue(ANONYMOUSUSERDEFAULTACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.anonymousUserIgnoreOtherActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the anonymousUserIgnoreOtherActions - Defines other voters should be considered for anonymous user
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserIgnoreOtherActions", type = Accessor.Type.GETTER)
	public Boolean getAnonymousUserIgnoreOtherActions()
	{
		return getPersistenceContext().getPropertyValue(ANONYMOUSUSERIGNOREOTHERACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.anonymousUserMinRequestNumber</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the anonymousUserMinRequestNumber - Defines minimal number of requests between subsequent actions for anonymous user
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserMinRequestNumber", type = Accessor.Type.GETTER)
	public Integer getAnonymousUserMinRequestNumber()
	{
		return getPersistenceContext().getPropertyValue(ANONYMOUSUSERMINREQUESTNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.anonymousUserMinTime</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the anonymousUserMinTime - Defines minimal time [ms] between subsequent actions for anonymous user
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserMinTime", type = Accessor.Type.GETTER)
	public Long getAnonymousUserMinTime()
	{
		return getPersistenceContext().getPropertyValue(ANONYMOUSUSERMINTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.baseSites</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the baseSites
	 */
	@Accessor(qualifier = "baseSites", type = Accessor.Type.GETTER)
	public Set<BaseSiteModel> getBaseSites()
	{
		return getPersistenceContext().getPropertyValue(BASESITES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.calculationProcess</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the calculationProcess - Name of calculation process
	 */
	@Accessor(qualifier = "calculationProcess", type = Accessor.Type.GETTER)
	public String getCalculationProcess()
	{
		return getPersistenceContext().getPropertyValue(CALCULATIONPROCESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.catalogLookup</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the catalogLookup - Type of lookup strategy used
	 */
	@Accessor(qualifier = "catalogLookup", type = Accessor.Type.GETTER)
	public CxCatalogLookupType getCatalogLookup()
	{
		return getPersistenceContext().getPropertyValue(CATALOGLOOKUP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.code</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the code - Unique identifier
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.consentGivenActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the consentGivenActions - Set of actions which should be called after user gives all required consents for personalization
	 */
	@Accessor(qualifier = "consentGivenActions", type = Accessor.Type.GETTER)
	public Set<String> getConsentGivenActions()
	{
		return getPersistenceContext().getPropertyValue(CONSENTGIVENACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.consentTemplates</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the consentTemplates - Collection of ConsentTemplates
	 */
	@Accessor(qualifier = "consentTemplates", type = Accessor.Type.GETTER)
	public Set<ConsentTemplateModel> getConsentTemplates()
	{
		return getPersistenceContext().getPropertyValue(CONSENTTEMPLATES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.ignoreRecalcForAnonymous</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the ignoreRecalcForAnonymous - Defines if experience recalculation for anonymous user should be ignored or not
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "ignoreRecalcForAnonymous", type = Accessor.Type.GETTER)
	public Boolean getIgnoreRecalcForAnonymous()
	{
		return getPersistenceContext().getPropertyValue(IGNORERECALCFORANONYMOUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.minAffinity</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the minAffinity - Minimum affinity for user to segment relation
	 */
	@Accessor(qualifier = "minAffinity", type = Accessor.Type.GETTER)
	public BigDecimal getMinAffinity()
	{
		return getPersistenceContext().getPropertyValue(MINAFFINITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.occPersonalizationEnabled</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the occPersonalizationEnabled - Defines if personalization for Commerce Web Services is enabled
	 */
	@Accessor(qualifier = "occPersonalizationEnabled", type = Accessor.Type.GETTER)
	public Boolean getOccPersonalizationEnabled()
	{
		return getPersistenceContext().getPropertyValue(OCCPERSONALIZATIONENABLED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.occPersonalizationIdCookieEnabled</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the occPersonalizationIdCookieEnabled - Defines if personalization id cookie for Commerce Web Services is enabled
	 */
	@Accessor(qualifier = "occPersonalizationIdCookieEnabled", type = Accessor.Type.GETTER)
	public Boolean getOccPersonalizationIdCookieEnabled()
	{
		return getPersistenceContext().getPropertyValue(OCCPERSONALIZATIONIDCOOKIEENABLED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.occTTL</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the occTTL - Time (in miliseconds) for which personalization calculation is valid
	 */
	@Accessor(qualifier = "occTTL", type = Accessor.Type.GETTER)
	public Long getOccTTL()
	{
		return getPersistenceContext().getPropertyValue(OCCTTL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.periodicVoterConfigs</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the periodicVoterConfigs
	 */
	@Accessor(qualifier = "periodicVoterConfigs", type = Accessor.Type.GETTER)
	public Set<CxPeriodicVoterConfigModel> getPeriodicVoterConfigs()
	{
		return getPersistenceContext().getPropertyValue(PERIODICVOTERCONFIGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.urlVoterConfigs</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the urlVoterConfigs
	 */
	@Accessor(qualifier = "urlVoterConfigs", type = Accessor.Type.GETTER)
	public List<CxUrlVoterConfigModel> getUrlVoterConfigs()
	{
		return getPersistenceContext().getPropertyValue(URLVOTERCONFIGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.userChangedActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the userChangedActions - Set of actions which should be called after user changed event
	 */
	@Accessor(qualifier = "userChangedActions", type = Accessor.Type.GETTER)
	public Set<String> getUserChangedActions()
	{
		return getPersistenceContext().getPropertyValue(USERCHANGEDACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.userSegmentsStoreInSession</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the userSegmentsStoreInSession - Defines if segments for registered user should be stored in session and save to database after session ends
	 */
	@Accessor(qualifier = "userSegmentsStoreInSession", type = Accessor.Type.GETTER)
	public Boolean getUserSegmentsStoreInSession()
	{
		return getPersistenceContext().getPropertyValue(USERSEGMENTSSTOREINSESSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxConfig.containerCleanupEnabled</code> attribute defined at extension <code>personalizationcms</code>. 
	 * @return the containerCleanupEnabled - Attribute defining if cx container should be removed in case there is no actions related to it
	 */
	@Accessor(qualifier = "containerCleanupEnabled", type = Accessor.Type.GETTER)
	public boolean isContainerCleanupEnabled()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(CONTAINERCLEANUPENABLED));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.actionResultMaxRepeat</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the actionResultMaxRepeat - Number of retires in case of action result load error caused by optimistic locking failure
	 */
	@Accessor(qualifier = "actionResultMaxRepeat", type = Accessor.Type.SETTER)
	public void setActionResultMaxRepeat(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ACTIONRESULTMAXREPEAT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.anonymousUserActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the anonymousUserActions - Set of actions which should be called when anonymous user makes subsequent request
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserActions", type = Accessor.Type.SETTER)
	public void setAnonymousUserActions(final Set<String> value)
	{
		getPersistenceContext().setPropertyValue(ANONYMOUSUSERACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.anonymousUserDefaultActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the anonymousUserDefaultActions - Set of actions which should be called when anonymous user makes first request
	 */
	@Accessor(qualifier = "anonymousUserDefaultActions", type = Accessor.Type.SETTER)
	public void setAnonymousUserDefaultActions(final Set<String> value)
	{
		getPersistenceContext().setPropertyValue(ANONYMOUSUSERDEFAULTACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.anonymousUserIgnoreOtherActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the anonymousUserIgnoreOtherActions - Defines other voters should be considered for anonymous user
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserIgnoreOtherActions", type = Accessor.Type.SETTER)
	public void setAnonymousUserIgnoreOtherActions(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ANONYMOUSUSERIGNOREOTHERACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.anonymousUserMinRequestNumber</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the anonymousUserMinRequestNumber - Defines minimal number of requests between subsequent actions for anonymous user
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserMinRequestNumber", type = Accessor.Type.SETTER)
	public void setAnonymousUserMinRequestNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ANONYMOUSUSERMINREQUESTNUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.anonymousUserMinTime</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the anonymousUserMinTime - Defines minimal time [ms] between subsequent actions for anonymous user
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "anonymousUserMinTime", type = Accessor.Type.SETTER)
	public void setAnonymousUserMinTime(final Long value)
	{
		getPersistenceContext().setPropertyValue(ANONYMOUSUSERMINTIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.baseSites</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the baseSites
	 */
	@Accessor(qualifier = "baseSites", type = Accessor.Type.SETTER)
	public void setBaseSites(final Set<BaseSiteModel> value)
	{
		getPersistenceContext().setPropertyValue(BASESITES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.calculationProcess</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the calculationProcess - Name of calculation process
	 */
	@Accessor(qualifier = "calculationProcess", type = Accessor.Type.SETTER)
	public void setCalculationProcess(final String value)
	{
		getPersistenceContext().setPropertyValue(CALCULATIONPROCESS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.catalogLookup</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the catalogLookup - Type of lookup strategy used
	 */
	@Accessor(qualifier = "catalogLookup", type = Accessor.Type.SETTER)
	public void setCatalogLookup(final CxCatalogLookupType value)
	{
		getPersistenceContext().setPropertyValue(CATALOGLOOKUP, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>CxConfig.code</code> attribute defined at extension <code>personalizationservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the code - Unique identifier
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.consentGivenActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the consentGivenActions - Set of actions which should be called after user gives all required consents for personalization
	 */
	@Accessor(qualifier = "consentGivenActions", type = Accessor.Type.SETTER)
	public void setConsentGivenActions(final Set<String> value)
	{
		getPersistenceContext().setPropertyValue(CONSENTGIVENACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.consentTemplates</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the consentTemplates - Collection of ConsentTemplates
	 */
	@Accessor(qualifier = "consentTemplates", type = Accessor.Type.SETTER)
	public void setConsentTemplates(final Set<ConsentTemplateModel> value)
	{
		getPersistenceContext().setPropertyValue(CONSENTTEMPLATES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.containerCleanupEnabled</code> attribute defined at extension <code>personalizationcms</code>. 
	 *  
	 * @param value the containerCleanupEnabled - Attribute defining if cx container should be removed in case there is no actions related to it
	 */
	@Accessor(qualifier = "containerCleanupEnabled", type = Accessor.Type.SETTER)
	public void setContainerCleanupEnabled(final boolean value)
	{
		getPersistenceContext().setPropertyValue(CONTAINERCLEANUPENABLED, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.ignoreRecalcForAnonymous</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the ignoreRecalcForAnonymous - Defines if experience recalculation for anonymous user should be ignored or not
	 * @deprecated since 1808
	 */
	@Deprecated
	@Accessor(qualifier = "ignoreRecalcForAnonymous", type = Accessor.Type.SETTER)
	public void setIgnoreRecalcForAnonymous(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(IGNORERECALCFORANONYMOUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.minAffinity</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the minAffinity - Minimum affinity for user to segment relation
	 */
	@Accessor(qualifier = "minAffinity", type = Accessor.Type.SETTER)
	public void setMinAffinity(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(MINAFFINITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.occPersonalizationEnabled</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the occPersonalizationEnabled - Defines if personalization for Commerce Web Services is enabled
	 */
	@Accessor(qualifier = "occPersonalizationEnabled", type = Accessor.Type.SETTER)
	public void setOccPersonalizationEnabled(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(OCCPERSONALIZATIONENABLED, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.occPersonalizationIdCookieEnabled</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the occPersonalizationIdCookieEnabled - Defines if personalization id cookie for Commerce Web Services is enabled
	 */
	@Accessor(qualifier = "occPersonalizationIdCookieEnabled", type = Accessor.Type.SETTER)
	public void setOccPersonalizationIdCookieEnabled(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(OCCPERSONALIZATIONIDCOOKIEENABLED, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.occTTL</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the occTTL - Time (in miliseconds) for which personalization calculation is valid
	 */
	@Accessor(qualifier = "occTTL", type = Accessor.Type.SETTER)
	public void setOccTTL(final Long value)
	{
		getPersistenceContext().setPropertyValue(OCCTTL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.periodicVoterConfigs</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the periodicVoterConfigs
	 */
	@Accessor(qualifier = "periodicVoterConfigs", type = Accessor.Type.SETTER)
	public void setPeriodicVoterConfigs(final Set<CxPeriodicVoterConfigModel> value)
	{
		getPersistenceContext().setPropertyValue(PERIODICVOTERCONFIGS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.urlVoterConfigs</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the urlVoterConfigs
	 */
	@Accessor(qualifier = "urlVoterConfigs", type = Accessor.Type.SETTER)
	public void setUrlVoterConfigs(final List<CxUrlVoterConfigModel> value)
	{
		getPersistenceContext().setPropertyValue(URLVOTERCONFIGS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.userChangedActions</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the userChangedActions - Set of actions which should be called after user changed event
	 */
	@Accessor(qualifier = "userChangedActions", type = Accessor.Type.SETTER)
	public void setUserChangedActions(final Set<String> value)
	{
		getPersistenceContext().setPropertyValue(USERCHANGEDACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxConfig.userSegmentsStoreInSession</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the userSegmentsStoreInSession - Defines if segments for registered user should be stored in session and save to database after session ends
	 */
	@Accessor(qualifier = "userSegmentsStoreInSession", type = Accessor.Type.SETTER)
	public void setUserSegmentsStoreInSession(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(USERSEGMENTSSTOREINSESSION, value);
	}
	
}
