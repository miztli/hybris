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
package de.hybris.platform.acceleratorcms.model.components;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.enums.ProductReferenceTypeEnum;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.contents.components.SimpleCMSComponentModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type ProductReferencesComponent first defined at extension acceleratorcms.
 * <p>
 * It represents product references component, that is the component that displays configured references to the specified product.
 */
@SuppressWarnings("all")
public class ProductReferencesComponentModel extends SimpleCMSComponentModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProductReferencesComponent";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductReferencesComponent.title</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String TITLE = "title";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductReferencesComponent.productReferenceTypes</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String PRODUCTREFERENCETYPES = "productReferenceTypes";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductReferencesComponent.maximumNumberProducts</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String MAXIMUMNUMBERPRODUCTS = "maximumNumberProducts";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductReferencesComponent.displayProductTitles</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String DISPLAYPRODUCTTITLES = "displayProductTitles";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductReferencesComponent.displayProductPrices</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String DISPLAYPRODUCTPRICES = "displayProductPrices";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductReferencesComponentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductReferencesComponentModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated
	public ProductReferencesComponentModel(final CatalogVersionModel _catalogVersion, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated
	public ProductReferencesComponentModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesComponent.maximumNumberProducts</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the maximumNumberProducts - Maximum number of the product references that are displayed in the component.
	 */
	@Accessor(qualifier = "maximumNumberProducts", type = Accessor.Type.GETTER)
	public Integer getMaximumNumberProducts()
	{
		return getPersistenceContext().getPropertyValue(MAXIMUMNUMBERPRODUCTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesComponent.productReferenceTypes</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the productReferenceTypes - Product reference type that is displayed in this component.
	 */
	@Accessor(qualifier = "productReferenceTypes", type = Accessor.Type.GETTER)
	public List<ProductReferenceTypeEnum> getProductReferenceTypes()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTREFERENCETYPES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesComponent.title</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the title - Title of the component.
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.GETTER)
	public String getTitle()
	{
		return getTitle(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesComponent.title</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @param loc the value localization key 
	 * @return the title - Title of the component.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.GETTER)
	public String getTitle(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(TITLE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesComponent.displayProductPrices</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the displayProductPrices - Determines if product prices are shown.
	 */
	@Accessor(qualifier = "displayProductPrices", type = Accessor.Type.GETTER)
	public boolean isDisplayProductPrices()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(DISPLAYPRODUCTPRICES));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesComponent.displayProductTitles</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the displayProductTitles - Determines if product titles are shown.
	 */
	@Accessor(qualifier = "displayProductTitles", type = Accessor.Type.GETTER)
	public boolean isDisplayProductTitles()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(DISPLAYPRODUCTTITLES));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductReferencesComponent.displayProductPrices</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the displayProductPrices - Determines if product prices are shown.
	 */
	@Accessor(qualifier = "displayProductPrices", type = Accessor.Type.SETTER)
	public void setDisplayProductPrices(final boolean value)
	{
		getPersistenceContext().setPropertyValue(DISPLAYPRODUCTPRICES, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductReferencesComponent.displayProductTitles</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the displayProductTitles - Determines if product titles are shown.
	 */
	@Accessor(qualifier = "displayProductTitles", type = Accessor.Type.SETTER)
	public void setDisplayProductTitles(final boolean value)
	{
		getPersistenceContext().setPropertyValue(DISPLAYPRODUCTTITLES, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductReferencesComponent.maximumNumberProducts</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the maximumNumberProducts - Maximum number of the product references that are displayed in the component.
	 */
	@Accessor(qualifier = "maximumNumberProducts", type = Accessor.Type.SETTER)
	public void setMaximumNumberProducts(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXIMUMNUMBERPRODUCTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductReferencesComponent.productReferenceTypes</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the productReferenceTypes - Product reference type that is displayed in this component.
	 */
	@Accessor(qualifier = "productReferenceTypes", type = Accessor.Type.SETTER)
	public void setProductReferenceTypes(final List<ProductReferenceTypeEnum> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTREFERENCETYPES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductReferencesComponent.title</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the title - Title of the component.
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.SETTER)
	public void setTitle(final String value)
	{
		setTitle(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ProductReferencesComponent.title</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the title - Title of the component.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.SETTER)
	public void setTitle(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(TITLE, loc, value);
	}
	
}
