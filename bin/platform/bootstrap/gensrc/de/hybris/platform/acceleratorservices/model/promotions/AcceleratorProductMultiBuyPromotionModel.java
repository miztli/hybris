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
package de.hybris.platform.acceleratorservices.model.promotions;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.ProductMultiBuyPromotionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AcceleratorProductMultiBuyPromotion first defined at extension acceleratorservices.
 * <p>
 * Replacement for ProductMultiBuyPromotion. Fire only once for a entry rather firing for each set of qualifying count.
 */
@SuppressWarnings("all")
public class AcceleratorProductMultiBuyPromotionModel extends ProductMultiBuyPromotionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AcceleratorProductMultiBuyPromotion";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AcceleratorProductMultiBuyPromotionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AcceleratorProductMultiBuyPromotionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 */
	@Deprecated
	public AcceleratorProductMultiBuyPromotionModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public AcceleratorProductMultiBuyPromotionModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
}
