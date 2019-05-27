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
package de.hybris.platform.yacceleratorcore.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.yacceleratorcore.model.ApparelStyleVariantProductModel;
import java.util.Locale;

/**
 * Generated model class for type ApparelSizeVariantProduct first defined at extension yacceleratorcore.
 * <p>
 * Apparel size variant type that contains additional attribute describing variant size.
 */
@SuppressWarnings("all")
public class ApparelSizeVariantProductModel extends ApparelStyleVariantProductModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ApparelSizeVariantProduct";
	
	/** <i>Generated constant</i> - Attribute key of <code>ApparelSizeVariantProduct.size</code> attribute defined at extension <code>yacceleratorcore</code>. */
	public static final String SIZE = "size";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ApparelSizeVariantProductModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ApparelSizeVariantProductModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseProduct initial attribute declared by type <code>VariantProduct</code> at extension <code>catalog</code>
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 */
	@Deprecated
	public ApparelSizeVariantProductModel(final ProductModel _baseProduct, final CatalogVersionModel _catalogVersion, final String _code)
	{
		super();
		setBaseProduct(_baseProduct);
		setCatalogVersion(_catalogVersion);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseProduct initial attribute declared by type <code>VariantProduct</code> at extension <code>catalog</code>
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public ApparelSizeVariantProductModel(final ProductModel _baseProduct, final CatalogVersionModel _catalogVersion, final String _code, final ItemModel _owner)
	{
		super();
		setBaseProduct(_baseProduct);
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ApparelSizeVariantProduct.size</code> attribute defined at extension <code>yacceleratorcore</code>. 
	 * @return the size - Size of the product.
	 */
	@Accessor(qualifier = "size", type = Accessor.Type.GETTER)
	public String getSize()
	{
		return getSize(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ApparelSizeVariantProduct.size</code> attribute defined at extension <code>yacceleratorcore</code>. 
	 * @param loc the value localization key 
	 * @return the size - Size of the product.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "size", type = Accessor.Type.GETTER)
	public String getSize(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(SIZE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ApparelSizeVariantProduct.size</code> attribute defined at extension <code>yacceleratorcore</code>. 
	 *  
	 * @param value the size - Size of the product.
	 */
	@Accessor(qualifier = "size", type = Accessor.Type.SETTER)
	public void setSize(final String value)
	{
		setSize(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ApparelSizeVariantProduct.size</code> attribute defined at extension <code>yacceleratorcore</code>. 
	 *  
	 * @param value the size - Size of the product.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "size", type = Accessor.Type.SETTER)
	public void setSize(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(SIZE, loc, value);
	}
	
}
