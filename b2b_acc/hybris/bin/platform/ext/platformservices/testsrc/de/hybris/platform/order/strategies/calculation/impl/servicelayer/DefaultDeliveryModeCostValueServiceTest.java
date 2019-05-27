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
package de.hybris.platform.order.strategies.calculation.impl.servicelayer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.deliveryzone.jalo.Zone;
import de.hybris.platform.deliveryzone.jalo.ZoneDeliveryMode;
import de.hybris.platform.deliveryzone.jalo.ZoneDeliveryModeManager;
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeModel;
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeValueModel;
import de.hybris.platform.deliveryzone.model.ZoneModel;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Currency;
import de.hybris.platform.jalo.order.OrderManager;
import de.hybris.platform.order.CartService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.AbstractItemModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DefaultDeliveryModeCostValueServiceTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;

	@Resource
	private CommonI18NService commonI18NService;

	@Resource
	private CartService cartService;

	@Resource
	private DefaultSLFindDeliveryCostStrategy defaultSLFindDeliveryCostStrategy;

	C2LManager c2lManager;
	ZoneDeliveryModeManager zdm;
	OrderManager orderManager;

	Currency cu1, cu2;
	Zone zone1, zone2;
	ZoneDeliveryMode deliveryMode;

	TaxModel taxModel;
	ZoneDeliveryModeModel deliveryModeModel;
	CurrencyModel cu1Model, cu2Model, oldBaseModel;
	CountryModel co1Model, co2Model, co3Model;
	ZoneModel zone1Model, zone2Model;
	UserModel userModel;
	AddressModel addrModel;
	ProductModel productModel;
	UnitModel unitModel;
	CartModel cart1Model, cart2Model;

	@Before
	public void setUp() throws Exception
	{
		// create some currencies
		oldBaseModel = commonI18NService.getBaseCurrency();

		cu1Model = modelService.create(CurrencyModel.class);
		cu1Model.setIsocode("cu1");
		cu1Model.setConversion(2.0);
		cu1Model.setSymbol("cu1");
		modelService.save(cu1Model);

		cu2Model = modelService.create(CurrencyModel.class);
		cu2Model.setIsocode("cu2");
		cu2Model.setConversion(1.0);
		cu2Model.setSymbol("cu2");
		cu2Model.setBase(Boolean.TRUE);
		modelService.save(cu2Model);

		c2lManager = C2LManager.getInstance();
		cu1 = c2lManager.getCurrencyByIsoCode("cu1");
		cu2 = c2lManager.getCurrencyByIsoCode("cu2");

		// create some countries
		co1Model = modelService.create(CountryModel.class);
		co1Model.setIsocode("co1");
		modelService.save(co1Model);
		co2Model = modelService.create(CountryModel.class);
		co2Model.setIsocode("co2");
		modelService.save(co2Model);
		co3Model = modelService.create(CountryModel.class);
		co3Model.setIsocode("co3");
		modelService.save(co3Model);

		// create DM
		deliveryModeModel = modelService.create(ZoneDeliveryModeModel.class);
		deliveryModeModel.setCode("zoneDM1");
		deliveryModeModel.setPropertyName(ProductModel.NUMBERCONTENTUNITS);
		deliveryModeModel.setNet(Boolean.TRUE);
		modelService.save(deliveryModeModel);

		orderManager = OrderManager.getInstance();
		deliveryMode = (ZoneDeliveryMode) orderManager.getDeliveryModeByCode("zoneDM1");

		// create tax
		taxModel = modelService.create(TaxModel.class);
		taxModel.setCode("tax");
		taxModel.setValue(16.0);
		modelService.save(taxModel);

		// create some zones
		// z1 = { co1, co2 } , z2 = { co3 }
		zone1Model = modelService.create(ZoneModel.class);
		zone1Model.setCode("zone1");
		zone2Model = modelService.create(ZoneModel.class);
		zone2Model.setCode("zone2");
		// add countries to zones
		zone1Model.setCountries(new LinkedHashSet(Arrays.asList(new CountryModel[]
		{ co1Model, co2Model })));
		zone2Model.setCountries(new LinkedHashSet(Arrays.asList(new CountryModel[]
		{ co3Model })));
		modelService.save(zone1Model);
		modelService.save(zone2Model);

		zdm = ZoneDeliveryModeManager.getInstance();
		zone1 = zdm.getZone("zone1");
		zone2 = zdm.getZone("zone2");

		// set some prices
		// z1 -> cu1 -> { 0 => 10.00 , 5 => 8.00 , 10 => 5.00 }
		//    -> cu2 -> { 0 => 100.00 , 100 => 77.00 }
		// z2 -> cu2 -> { 0 => 50.0 10 => 20.00 }
		ZoneDeliveryModeValueModel deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu1Model);
		deliveryModeValue.setMinimum(0.0);
		deliveryModeValue.setValue(10.0);
		deliveryModeValue.setZone(zone1Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu1Model);
		deliveryModeValue.setMinimum(5.0);
		deliveryModeValue.setValue(8.0);
		deliveryModeValue.setZone(zone1Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu1Model);
		deliveryModeValue.setMinimum(10.0);
		deliveryModeValue.setValue(5.0);
		deliveryModeValue.setZone(zone1Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu2Model);
		deliveryModeValue.setMinimum(0.0);
		deliveryModeValue.setValue(100.0);
		deliveryModeValue.setZone(zone1Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu2Model);
		deliveryModeValue.setMinimum(100.0);
		deliveryModeValue.setValue(77.0);
		deliveryModeValue.setZone(zone1Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu2Model);
		deliveryModeValue.setMinimum(0.0);
		deliveryModeValue.setValue(50.0);
		deliveryModeValue.setZone(zone2Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class);
		deliveryModeValue.setCurrency(cu2Model);
		deliveryModeValue.setMinimum(10.0);
		deliveryModeValue.setValue(20.0);
		deliveryModeValue.setZone(zone2Model);
		deliveryModeValue.setDeliveryMode(deliveryModeModel);
		modelService.save(deliveryModeValue);

		// create user
		userModel = modelService.create(CustomerModel.class);
		userModel.setUid("c");
		modelService.save(userModel);

		// create address
		addrModel = modelService.create(AddressModel.class);
		addrModel.setCountry(co1Model);
		addrModel.setOwner(userModel);
		modelService.save(addrModel);

		// create unit
		unitModel = modelService.create(UnitModel.class);
		unitModel.setCode("test_kg");
		unitModel.setUnitType(ProductModel.NUMBERCONTENTUNITS);
		modelService.save(unitModel);

		// create product
		final CatalogModel testCatalog = modelService.create(CatalogModel.class);
		testCatalog.setId("testCatalog2");
		modelService.save(testCatalog);

		final CatalogVersionModel testCatalogVersion = modelService.create(CatalogVersionModel.class);
		testCatalogVersion.setCatalog(testCatalog);
		testCatalogVersion.setVersion("online");

		// create product
		productModel = modelService.create(ProductModel.class);
		productModel.setCode("p2");
		((AbstractItemModel) productModel).setProperty(ProductModel.NUMBERCONTENTUNITS, new Double(1.0));
		productModel.setUnit(unitModel);
		productModel.setCatalogVersion(testCatalogVersion);
		modelService.save(productModel);

		// create an order
		cart1Model = modelService.create(CartModel.class);
		cart1Model.setCode("order1");
		cart1Model.setUser(userModel);
		cart1Model.setCurrency(cu1Model);
		cart1Model.setDate(new Date());
		cart1Model.setNet(Boolean.FALSE);
		cart1Model.setDeliveryAddress(addrModel);
		modelService.save(cart1Model);

		cart2Model = modelService.create(CartModel.class);
		cart2Model.setCode("order2");
		cart2Model.setUser(userModel);
		cart2Model.setCurrency(cu1Model);
		cart2Model.setDate(new Date());
		cart2Model.setNet(Boolean.FALSE);
		cart2Model.setDeliveryAddress(addrModel);
		modelService.save(cart2Model);
	}

	@Test
	public void testDeliveryCostCalculation() throws Exception
	{
		// check property name
		assertTrue("property name was not '" + ProductModel.NUMBERCONTENTUNITS + "' but " + deliveryModeModel.getPropertyName(),
				deliveryModeModel.getPropertyName().equals(ProductModel.NUMBERCONTENTUNITS));
		// check zones
		Collection coll = zone1Model.getCountries();
		assertTrue("expected [ co1, co2 ] but got " + coll,
				coll != null && coll.size() == 2 && coll.contains(co1Model) && coll.contains(co2Model));
		coll = zone2Model.getCountries();
		assertTrue("expected [ co3 ] but got " + coll, coll != null && coll.size() == 1 && coll.contains(co3Model));
		// z1, cu1, 1kg -> 10.0
		// add entry to order
		cart1Model.setDeliveryMode(deliveryModeModel);
		cartService.addNewEntry(cart1Model, productModel, 1, unitModel);
		//		System.out.println("numberContentUnits: " + product.getAttribute("numberContentUnits"));
		double costs = defaultSLFindDeliveryCostStrategy.getDeliveryCost(cart1Model).getValue();
		assertTrue("expected 10.0 as cost but got " + costs, costs == 10.0);
		// z1, cu1 11kg -> 5.0
		cartService.addNewEntry(cart1Model, productModel, 10, unitModel);
		//		System.out.println("numberContentUnits: " + product.getProperty("weight"));
		costs = defaultSLFindDeliveryCostStrategy.getDeliveryCost(cart1Model).getValue();
		assertTrue("expected 5.0 as cost but got " + costs, costs == 5.0);
		// z2 , cu1 , 100 kg -> ( 20.0 * 2/1 [conversion] ) 40.0
		cart2Model.setDeliveryMode(deliveryModeModel);
		cart2Model.getDeliveryAddress().setCountry(co3Model); // for getting z2 !!!
		cartService.addNewEntry(cart2Model, productModel, 100, unitModel);
		costs = defaultSLFindDeliveryCostStrategy.getDeliveryCost(cart2Model).getValue();
		assertTrue("expected 40.0 as cost but got " + costs, costs == 40.0);
	}

	@Test
	public void testEmptyAddress()
	{
		final CartModel cartModel = modelService.clone(cart1Model);
		cartModel.setDeliveryAddress(null);
		cartModel.setDeliveryMode(deliveryModeModel);

		try
		{
			defaultSLFindDeliveryCostStrategy.getDeliveryCostValue(cartModel);

			fail("CalculationException expected");
		}
		catch (final CalculationException e)
		{
			//			ok
		}
	}

	@Test
	public void testEmptyCountryAddress()
	{
		final CartModel cartModel = modelService.clone(cart1Model);
		final AddressModel addressModel = modelService.clone(cartModel.getDeliveryAddress());
		addressModel.setCountry(null);
		cartModel.setDeliveryAddress(addressModel);
		cartModel.setDeliveryMode(deliveryModeModel);

		try
		{
			defaultSLFindDeliveryCostStrategy.getDeliveryCostValue(cartModel);

			fail("CalculationException expected");
		}
		catch (final CalculationException e)
		{
			//			ok
		}
	}

	@Test
	public void testEmptyCurrency()
	{
		final CartModel cartModel = modelService.clone(cart1Model);
		cartModel.setCurrency(null);

		try
		{
			defaultSLFindDeliveryCostStrategy.getDeliveryCostValue(cartModel);

			fail("CalculationException expected");
		}
		catch (final CalculationException e)
		{
			//			ok
		}
	}

	@After
	public void tearDown() throws Exception
	{
		if (oldBaseModel != null)
		{
			oldBaseModel.setBase(Boolean.TRUE);
		}
	}
}
