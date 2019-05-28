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
package de.hybris.platform.odata2webservicesfeaturetests.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.test.TestItemType2Model;
import de.hybris.platform.odata2webservicesfeaturetests.model.TestIntegrationItemDetailModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type TestIntegrationItem first defined at extension odata2webservicesfeaturetests.
 * <p>
 * An item type for testing different scenarios around integration objects. This type has attributes of numerous types
 * 				available in the type system and enables conditions, which otherwise would be possible only by picking hard-to-find
 * 				modeling scenarios available in multiple types across possibly multiple *-items.xml.
 */
@SuppressWarnings("all")
public class TestIntegrationItemModel extends TestItemType2Model
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "TestIntegrationItem";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItem.code</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItem.otherItem</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String OTHERITEM = "otherItem";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItem.detail</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String DETAIL = "detail";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItem.details</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String DETAILS = "details";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public TestIntegrationItemModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public TestIntegrationItemModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>TestIntegrationItem</code> at extension <code>odata2webservicesfeaturetests</code>
	 */
	@Deprecated
	public TestIntegrationItemModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>TestIntegrationItem</code> at extension <code>odata2webservicesfeaturetests</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public TestIntegrationItemModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItem.code</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * @return the code - Unique identifier of the item because TestItemType2 does not have a unique identifier.
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItem.detail</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * @return the detail - Defines optional one-to-one association between this item and a TestIntegrationItemDetail.
	 */
	@Accessor(qualifier = "detail", type = Accessor.Type.GETTER)
	public TestIntegrationItemDetailModel getDetail()
	{
		return getPersistenceContext().getPropertyValue(DETAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItem.details</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the details
	 */
	@Accessor(qualifier = "details", type = Accessor.Type.GETTER)
	public Set<TestIntegrationItemDetailModel> getDetails()
	{
		return getPersistenceContext().getPropertyValue(DETAILS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItem.otherItem</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * @return the otherItem - Reference to another TestIntegrationItem, which can be used for testing conditions when the integration
	 * 						object references itself (same instance) or another item (different instance).
	 */
	@Accessor(qualifier = "otherItem", type = Accessor.Type.GETTER)
	public TestIntegrationItemModel getOtherItem()
	{
		return getPersistenceContext().getPropertyValue(OTHERITEM);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItem.code</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the code - Unique identifier of the item because TestItemType2 does not have a unique identifier.
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItem.detail</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the detail - Defines optional one-to-one association between this item and a TestIntegrationItemDetail.
	 */
	@Accessor(qualifier = "detail", type = Accessor.Type.SETTER)
	public void setDetail(final TestIntegrationItemDetailModel value)
	{
		getPersistenceContext().setPropertyValue(DETAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItem.details</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the details
	 */
	@Accessor(qualifier = "details", type = Accessor.Type.SETTER)
	public void setDetails(final Set<TestIntegrationItemDetailModel> value)
	{
		getPersistenceContext().setPropertyValue(DETAILS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItem.otherItem</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the otherItem - Reference to another TestIntegrationItem, which can be used for testing conditions when the integration
	 * 						object references itself (same instance) or another item (different instance).
	 */
	@Accessor(qualifier = "otherItem", type = Accessor.Type.SETTER)
	public void setOtherItem(final TestIntegrationItemModel value)
	{
		getPersistenceContext().setPropertyValue(OTHERITEM, value);
	}
	
}
