/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */


package de.hybris.platform.order.strategies.calculation.pdt.impl;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.HybrisEnumValue;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.enums.UserDiscountGroup;
import de.hybris.platform.europe1.enums.UserTaxGroup;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationManager;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.order.price.JaloPriceFactoryException;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.impl.PDTEnumGroupsHelper;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.testframework.seed.TestDataCreator;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class PDTEnumGroupsHelperTest extends ServicelayerTransactionalTest
{

	@Resource
	private PDTEnumGroupsHelper pdtEnumGroupsHelper;

	@Resource
	private ModelService modelService;

	@Resource
	private SessionService sessionService;

	private ProductModel productModel;

	private UserModel userModel;
	private UserModel userModel2;

	private UserGroupModel userDiscountGroup;
	private UserGroupModel userTaxGroup;

	private ProductTaxGroup testProductTaxGroup1;
	private UserTaxGroup testUserTaxGroup1;
	private UserDiscountGroup testUserDiscountGroup1;

	private ProductTaxGroup testProductTaxGroup2;
	private UserTaxGroup testUserTaxGroup2;
	private UserDiscountGroup testUserDiscountGroup2;

	private static final String VALUEOFDISCOUNTGROUP = "54321";
	private static final String VALUEOFTAXGROUP = "12345";


	@Before
	public void setUp() throws Exception
	{
		final TestDataCreator testDataCreator = new TestDataCreator(modelService);
		final CatalogModel catalog = testDataCreator.createCatalog();
		final CatalogVersionModel catalogVersion = testDataCreator.createCatalogVersion("testVersion", catalog);

		productModel = testDataCreator.createProduct(catalogVersion);

		testProductTaxGroup1 = ProductTaxGroup.valueOf("testProductTaxGroup1");
		testUserTaxGroup1 = UserTaxGroup.valueOf("testUserTaxGroup1");
		testUserDiscountGroup1 = UserDiscountGroup.valueOf("testUserDiscountGroup1");

		testProductTaxGroup2 = ProductTaxGroup.valueOf("testProductTaxGroup2");
		testUserTaxGroup2 = UserTaxGroup.valueOf("testUserTaxGroup2");
		testUserDiscountGroup2 = UserDiscountGroup.valueOf("testUserDiscountGroup2");

		modelService.saveAll(testProductTaxGroup1, testUserDiscountGroup1, testUserTaxGroup1, testProductTaxGroup2,
				testUserDiscountGroup2, testUserTaxGroup2);

		userDiscountGroup = modelService.create(UserGroupModel.class);
		userDiscountGroup.setUid("testUID");
		userDiscountGroup.setProperty(UserGroupModel.USERDISCOUNTGROUP, UserDiscountGroup.valueOf(VALUEOFDISCOUNTGROUP));
		modelService.save(userDiscountGroup);

		userTaxGroup = modelService.create(UserGroupModel.class);
		userTaxGroup.setUid("testUID2");
		userDiscountGroup.setProperty(UserGroupModel.USERTAXGROUP, UserTaxGroup.valueOf(VALUEOFTAXGROUP));
		modelService.save(userTaxGroup);


		final Set<PrincipalGroupModel> groupModels = new HashSet<>();
		groupModels.add(userDiscountGroup);
		groupModels.add(userTaxGroup);

		userModel = modelService.create(UserModel.class);
		userModel.setUid("testUser");
		userModel.setGroups(groupModels);
		modelService.save(userModel);

		userModel2 = modelService.create(UserModel.class);
		userModel2.setUid("testUser2");
		modelService.save(userModel2);
	}

	@After
	public void tearDown()
	{
		modelService.remove(userDiscountGroup);
		modelService.remove(userTaxGroup);
		modelService.remove(userModel);
		modelService.remove(userModel2);

		sessionService.removeAttribute(ProductModel.EUROPE1PRICEFACTORY_PTG);
		sessionService.removeAttribute(UserModel.EUROPE1PRICEFACTORY_UTG);
		sessionService.removeAttribute(UserModel.EUROPE1PRICEFACTORY_UDG);
	}


	@Test
	public void getEnumDiscountFromGroups() throws CalculationException
	{
		final HybrisEnumValue userDG = pdtEnumGroupsHelper.getUDG(userModel);
		Assert.assertTrue("getUDG should return instance of UserDiscountGroup", userDG instanceof UserDiscountGroup);
		Assert.assertEquals("getUDG should return proper code of discount group", VALUEOFDISCOUNTGROUP, userDG.getCode());
		final HybrisEnumValue userDiscountGroup2 = pdtEnumGroupsHelper.getUDG(userModel2);
		Assert.assertNull("getUDG should not return UserDiscountGroup", userDiscountGroup2);
	}

	@Test
	public void getEnumTaxFromGroups() throws CalculationException
	{
		final HybrisEnumValue userTG = pdtEnumGroupsHelper.getUTG(userModel);
		Assert.assertTrue("getUTG should return instance of UserDiscountGroup", userTG instanceof UserTaxGroup);
		Assert.assertEquals("getUTG should return proper code of discount group", VALUEOFTAXGROUP, userTG.getCode());
		final HybrisEnumValue userTaxGroup2 = pdtEnumGroupsHelper.getUTG(userModel2);
		Assert.assertNull("getUTG should not return UserTaxGroup", userTaxGroup2);
	}

	@Test
	public void getPtgFromProduct() throws CalculationException, JaloPriceFactoryException
	{
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();

		final EnumerationValue enumerationValue = EnumerationManager.getInstance()
				.getEnumerationValue(de.hybris.platform.europe1.enums.ProductTaxGroup._TYPECODE, "testProductTaxGroup1");

		ctx.setAttribute(ProductModel.EUROPE1PRICEFACTORY_PTG, enumerationValue);

		ProductTaxGroup productTaxGroupFromPDTEnumGroupsHelper = pdtEnumGroupsHelper.getPTG(productModel);
		assertThat(testProductTaxGroup1).isEqualTo(productTaxGroupFromPDTEnumGroupsHelper);

		sessionService.setAttribute(ProductModel.EUROPE1PRICEFACTORY_PTG, testProductTaxGroup2);

		productTaxGroupFromPDTEnumGroupsHelper = pdtEnumGroupsHelper.getPTG(productModel);
		assertThat(testProductTaxGroup2).isEqualTo(productTaxGroupFromPDTEnumGroupsHelper);
	}

	@Test
	public void getUtgFromUser() throws CalculationException, JaloPriceFactoryException
	{
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();

		final EnumerationValue enumerationValue = EnumerationManager.getInstance()
				.getEnumerationValue(de.hybris.platform.europe1.enums.UserTaxGroup._TYPECODE, "testUserTaxGroup1");

		ctx.setAttribute(UserModel.EUROPE1PRICEFACTORY_UTG, enumerationValue);

		UserTaxGroup userTaxGroupFromPDTEnumGroupsHelper = pdtEnumGroupsHelper.getUTG(userModel);
		assertThat(testUserTaxGroup1).isEqualTo(userTaxGroupFromPDTEnumGroupsHelper);

		sessionService.setAttribute(UserModel.EUROPE1PRICEFACTORY_UTG, testUserTaxGroup2);

		userTaxGroupFromPDTEnumGroupsHelper = pdtEnumGroupsHelper.getUTG(userModel);
		assertThat(testUserTaxGroup2).isEqualTo(userTaxGroupFromPDTEnumGroupsHelper);
	}

	@Test
	public void getUdgFromUser() throws CalculationException, JaloPriceFactoryException
	{
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();

		final EnumerationValue enumerationValue = EnumerationManager.getInstance()
				.getEnumerationValue(de.hybris.platform.europe1.enums.UserDiscountGroup._TYPECODE, "testUserDiscountGroup1");

		ctx.setAttribute(UserModel.EUROPE1PRICEFACTORY_UDG, enumerationValue);

		UserDiscountGroup userDiscountGroupFromPDTEnumGroupsHelper = pdtEnumGroupsHelper.getUDG(userModel);
		assertThat(testUserDiscountGroup1).isEqualTo(userDiscountGroupFromPDTEnumGroupsHelper);

		sessionService.setAttribute(UserModel.EUROPE1PRICEFACTORY_UDG, testUserDiscountGroup2);

		userDiscountGroupFromPDTEnumGroupsHelper = pdtEnumGroupsHelper.getUDG(userModel);
		assertThat(testUserDiscountGroup2).isEqualTo(userDiscountGroupFromPDTEnumGroupsHelper);
	}
}

