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
package de.hybris.platform.odata2webservicesfeaturetests.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.test.TestItemType2Model;
import de.hybris.platform.odata2webservicesfeaturetests.model.TestIntegrationItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type TestIntegrationItemDetail first defined at extension odata2webservicesfeaturetests.
 * <p>
 * An item type to simulate various kinds of relationships, i.e. one-to-many (master/detail), one-to-one, etc.,
 * 				between the TestIntegrationItem and TestIntegrationItemDetail.
 */
@SuppressWarnings("all")
public class TestIntegrationItemDetailModel extends TestItemType2Model
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "TestIntegrationItemDetail";
	
	/**<i>Generated relation code constant for relation <code>TestIntItem2testIntItemDetail</code> defining source attribute <code>master</code> in extension <code>odata2webservicesfeaturetests</code>.</i>*/
	public static final String _TESTINTITEM2TESTINTITEMDETAIL = "TestIntItem2testIntItemDetail";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItemDetail.code</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItemDetail.item</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String ITEM = "item";
	
	/** <i>Generated constant</i> - Attribute key of <code>TestIntegrationItemDetail.master</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. */
	public static final String MASTER = "master";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public TestIntegrationItemDetailModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public TestIntegrationItemDetailModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>TestIntegrationItemDetail</code> at extension <code>odata2webservicesfeaturetests</code>
	 */
	@Deprecated
	public TestIntegrationItemDetailModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>TestIntegrationItemDetail</code> at extension <code>odata2webservicesfeaturetests</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public TestIntegrationItemDetailModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItemDetail.code</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * @return the code - Unique identifier of this detail item.
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItemDetail.item</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * @return the item - Defines optional one-to-one association between this detail and a TestIntegrationItem.
	 */
	@Accessor(qualifier = "item", type = Accessor.Type.GETTER)
	public TestIntegrationItemModel getItem()
	{
		return getPersistenceContext().getPropertyValue(ITEM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TestIntegrationItemDetail.master</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 * @return the master
	 */
	@Accessor(qualifier = "master", type = Accessor.Type.GETTER)
	public TestIntegrationItemModel getMaster()
	{
		return getPersistenceContext().getPropertyValue(MASTER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItemDetail.code</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the code - Unique identifier of this detail item.
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItemDetail.item</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the item - Defines optional one-to-one association between this detail and a TestIntegrationItem.
	 */
	@Accessor(qualifier = "item", type = Accessor.Type.SETTER)
	public void setItem(final TestIntegrationItemModel value)
	{
		getPersistenceContext().setPropertyValue(ITEM, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TestIntegrationItemDetail.master</code> attribute defined at extension <code>odata2webservicesfeaturetests</code>. 
	 *  
	 * @param value the master
	 */
	@Accessor(qualifier = "master", type = Accessor.Type.SETTER)
	public void setMaster(final TestIntegrationItemModel value)
	{
		getPersistenceContext().setPropertyValue(MASTER, value);
	}
	
}
