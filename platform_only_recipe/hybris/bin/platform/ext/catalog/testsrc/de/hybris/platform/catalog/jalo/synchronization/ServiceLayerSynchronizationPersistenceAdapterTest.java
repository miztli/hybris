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
package de.hybris.platform.catalog.jalo.synchronization;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.common.collect.Maps;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.synchronization.ServiceLayerSynchronizationPersistenceAdapter;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.user.Title;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


/**
 * Created by t0mus on 24.06.14.
 */

@IntegrationTest
public class ServiceLayerSynchronizationPersistenceAdapterTest extends ServicelayerBaseTest
{
	public static final String TEST_TITLE = "testTitle";

	private ServiceLayerSynchronizationPersistenceAdapter persistenceAdapter;

	@Resource
	private TypeService typeService;

	@Resource
	private ModelService modelService;

	@Before
	public void setUp()
	{
		persistenceAdapter = new ServiceLayerSynchronizationPersistenceAdapter(null);
	}

	@Test
	public void shouldNotFailOnAnEmptyMapPassedToLocalizedAttribute()
	{
		final Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(Title.CODE, TEST_TITLE);
		attributes.put(Title.NAME, Collections.emptyMap());
		try
		{
			final Title title = (Title) persistenceAdapter
					.create((ComposedType) modelService.getSource(typeService.getComposedType(TitleModel._TYPECODE)), attributes);
			assertEquals(TEST_TITLE, title.getCode());
			assertEquals(Collections.emptyMap(), title.getAllName());
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			fail("Should not fail on an Collections.EmptyMap passed to localized attribute.");
		}
	}

	@Test
	public void shouldNotFailOnNullPassedToLocalizedAttribute()
	{
		final Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(Title.CODE, TEST_TITLE);
		attributes.put(Title.NAME, null);
		try
		{
			final Title title = (Title) persistenceAdapter
					.create((ComposedType) modelService.getSource(typeService.getComposedType(TitleModel._TYPECODE)), attributes);
			assertEquals(TEST_TITLE, title.getCode());
			assertEquals(Collections.emptyMap(), title.getAllName());
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			fail("Should not fail on null passed to localized attribute.");
		}
	}

	@Test
	public void shouldCorrectlyHandleDynamicAttribute()
	{
		final String name = "someNAME";
		final String uid = UUID.randomUUID().toString();

		final Set attributes = new HashSet();
		attributes.add(User.UID);
		attributes.add(User.DISPLAYNAME);
		attributes.add(User.NAME);
		try
		{
			final UserModel user = modelService.create(UserModel.class);
			user.setUid(uid);
			user.setName(name);
			modelService.save(user);
			final Map read = persistenceAdapter.read(modelService.getSource(user), attributes);

			assertEquals(uid, read.get(User.UID));
			assertEquals("Should correctly read 'displayName' dynamic attribute with UserDisplayNameLocalizedAttributeHandler", name,
					read.get(User.DISPLAYNAME));
			assertEquals(name, read.get(User.NAME));
		}
		catch (final Exception e)
		{
			fail("Should not fail on reading 'displayName' dynamic attribute with UserDisplayNameLocalizedAttributeHandler");
		}
	}

	@Test
	public void shouldSkipEurope1PricesDynamicAttributesWhenUpdate()
	{
		final ModelService spiedModelService = createDataAndUpdateAttribute(ProductModel.EUROPE1PRICES);

		verify(spiedModelService, times(0)).setAttributeValue(anyObject(), anyString(), anyObject());
	}

	@Test
	public void shouldSkipEurope1DiscountsDynamicAttributesWhenUpdate()
	{
		final ModelService spiedModelService = createDataAndUpdateAttribute(ProductModel.EUROPE1DISCOUNTS);

		verify(spiedModelService, times(0)).setAttributeValue(anyObject(), anyString(), anyObject());
	}

	@Test
	public void shouldSkipEurope1TaxesDynamicAttributesWhenUpdate()
	{
		final ModelService spiedModelService = createDataAndUpdateAttribute(ProductModel.EUROPE1TAXES);

		verify(spiedModelService, times(0)).setAttributeValue(anyObject(), anyString(), anyObject());
	}

	@Test
	public void shouldNotSkipOwnEurope1DiscountsAttributesWhenUpdate()
	{
		final ModelService spiedModelService = createDataAndUpdateAttribute(ProductModel.OWNEUROPE1DISCOUNTS);

		verify(spiedModelService).setAttributeValue(any(Object.class), eq(ProductModel.OWNEUROPE1DISCOUNTS), any(Object.class));
	}

	@Test
	public void shouldNotSkipOwnEurope1TaxesAttributesWhenUpdate()
	{
		final ModelService spiedModelService = createDataAndUpdateAttribute(ProductModel.OWNEUROPE1TAXES);

		verify(spiedModelService).setAttributeValue(any(Object.class), eq(ProductModel.OWNEUROPE1TAXES), any(Object.class));
	}

	@Test
	public void shouldNotSkipCodeAttributeWhenUpdate()
	{
		final ModelService spiedModelService = createDataAndUpdateAttribute(ProductModel.CODE);

		verify(spiedModelService).setAttributeValue(any(Object.class), eq(ProductModel.CODE), any(Object.class));
	}

	private ModelService createDataAndUpdateAttribute(final String attributeKey)
	{
		final ModelService spiedModelService = Mockito.spy(ModelService.class);
		doNothing().when(spiedModelService).setAttributeValue(any(Object.class), any(String.class), any(Object.class));
		persistenceAdapter.setModelService(spiedModelService);
		MockitoAnnotations.initMocks(persistenceAdapter);

		final String name = "someName";
		final String code = "someCode";


		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId("someCatalogID");
		modelService.save(catalog);

		final CatalogVersionModel catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setVersion("someVersion");
		catalogVersion.setCatalog(catalog);
		modelService.save(catalogVersion);

		final ProductModel model = modelService.create(ProductModel.class);
		model.setCode(code);
		model.setName(name);
		model.setCatalogVersion(catalogVersion);
		modelService.save(model);
		final Product source = modelService.getSource(model);

		final Map.Entry<String, Object> attribute = Maps.immutableEntry(attributeKey, 42);
		persistenceAdapter.update(source, attribute);
		return spiedModelService;
	}
}
