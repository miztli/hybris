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
package de.hybris.platform.promotions.model;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.PromotionOrderEntryAdjustActionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CachedPromotionOrderEntryAdjustAction first defined at extension promotions.
 */
@SuppressWarnings("all")
public class CachedPromotionOrderEntryAdjustActionModel extends PromotionOrderEntryAdjustActionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CachedPromotionOrderEntryAdjustAction";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CachedPromotionOrderEntryAdjustActionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CachedPromotionOrderEntryAdjustActionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public CachedPromotionOrderEntryAdjustActionModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
}