/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 15, 2019 3:21:40 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.model.c2l;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.C2LItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type Language first defined at extension core.
 */
@SuppressWarnings("all")
public class LanguageModel extends C2LItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Language";
	
	/**<i>Generated relation code constant for relation <code>SyncJob2LangRel</code> defining source attribute <code>syncJobs</code> in extension <code>catalog</code>.</i>*/
	public static final String _SYNCJOB2LANGREL = "SyncJob2LangRel";
	
	/** <i>Generated constant</i> - Attribute key of <code>Language.fallbackLanguages</code> attribute defined at extension <code>core</code>. */
	public static final String FALLBACKLANGUAGES = "fallbackLanguages";
	
	/** <i>Generated constant</i> - Attribute key of <code>Language.syncJobs</code> attribute defined at extension <code>catalog</code>. */
	public static final String SYNCJOBS = "syncJobs";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public LanguageModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public LanguageModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>Language</code> at extension <code>core</code>
	 */
	@Deprecated
	public LanguageModel(final String _isocode)
	{
		super();
		setIsocode(_isocode);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>Language</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public LanguageModel(final String _isocode, final ItemModel _owner)
	{
		super();
		setIsocode(_isocode);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Language.fallbackLanguages</code> attribute defined at extension <code>core</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the fallbackLanguages
	 */
	@Accessor(qualifier = "fallbackLanguages", type = Accessor.Type.GETTER)
	public List<LanguageModel> getFallbackLanguages()
	{
		final List<LanguageModel> value = getPersistenceContext().getPropertyValue(FALLBACKLANGUAGES);
		return value != null ? value : java.util.Collections.emptyList();
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Language.fallbackLanguages</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the fallbackLanguages
	 */
	@Accessor(qualifier = "fallbackLanguages", type = Accessor.Type.SETTER)
	public void setFallbackLanguages(final List<LanguageModel> value)
	{
		getPersistenceContext().setPropertyValue(FALLBACKLANGUAGES, value);
	}
	
}
