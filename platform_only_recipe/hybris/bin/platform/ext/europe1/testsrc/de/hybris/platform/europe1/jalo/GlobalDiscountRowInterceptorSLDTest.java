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
package de.hybris.platform.europe1.jalo;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.model.GlobalDiscountRowModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;


@IntegrationTest
public class GlobalDiscountRowInterceptorSLDTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;

	private final PropertyConfigSwitcher persistenceLegacyModeSwitcher = new PropertyConfigSwitcher("persistence.legacy.mode");

	private UserGroupModel userGroup;
	private UserModel user;
	private CurrencyModel currency;
	private DiscountModel discount;

	@After
	public void tearDown()
	{
		persistenceLegacyModeSwitcher.switchBackToDefault();
	}

	@Before
	public void doBefore()
	{
		userGroup = modelService.create(UserGroupModel.class);
		userGroup.setUid(UUID.randomUUID().toString());
		modelService.save(userGroup);

		user = modelService.create(UserModel.class);
		user.setUid(UUID.randomUUID().toString());
		user.setGroups(Sets.newHashSet(userGroup));
		modelService.save(user);

		currency = modelService.create(CurrencyModel.class);
		currency.setIsocode("USD");
		modelService.save(currency);

		discount = modelService.create(DiscountModel.class);
		discount.setCode(UUID.randomUUID().toString());
		modelService.save(discount);
	}

	@Test
	public void testProductMatchQualifierForNullProductId()
	{
		persistenceLegacyModeSwitcher.switchToValue("false");

		final GlobalDiscountRowModel ret = modelService.create(GlobalDiscountRowModel.class);
		ret.setUser(user);
		ret.setCurrency(currency);
		ret.setValue(Double.valueOf(12.3));
		ret.setDiscount(discount);

		modelService.save(ret);

		assertThat(ret.getProductMatchQualifier()).isEqualTo(Europe1PriceFactory.MATCH_ANY);
	}

	@Test
	public void testProductMatchQualifierForNotNullProductId()
	{
		persistenceLegacyModeSwitcher.switchToValue("false");

		final GlobalDiscountRowModel ret = modelService.create(GlobalDiscountRowModel.class);
		ret.setUser(user);
		ret.setCurrency(currency);
		ret.setValue(Double.valueOf(12.3));
		ret.setDiscount(discount);
		ret.setProductId("prodId");

		modelService.save(ret);

		assertThat(ret.getProductMatchQualifier()).isEqualTo(Europe1PriceFactory.MATCH_BY_PRODUCT_ID);
	}
}
