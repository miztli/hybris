/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.order.strategies.calculation.pdt;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.channel.strategies.RetrieveChannelStrategy;
import de.hybris.platform.europe1.enums.PriceRowChannel;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationManager;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultPriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.repository.PDTRowRepository;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.PriceValue;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DefaultFindPriceValuesServiceIntegrationTest extends ServicelayerBaseTest
{
	@Resource
	private PDTRowRepository<PriceValueInfoCriteria, PriceRowModel> defaultPriceRowRepository;
	@Resource
	private FindPDTValueInfoStrategy<PriceValue, PriceInformation, PriceValueInfoCriteria> findPriceValueInfoStrategy;

	@Resource
	private ModelService modelService;
	@Resource
	private CommonI18NService commonI18NService;
	@Resource
	private UserService userService;
	@Resource
	private RetrieveChannelStrategy retrieveChannelStrategy;

	private static final String TEST_PRODUCT = "TEST_PRODUCT";
	private static final String TEST_USER = "TEST_USER";
	private static final String TEST_USER_GROUP = "TEST_USER_GROUP";
	private static final String TEST_PRODUCT_GROUP = "TEST_PRODUCT_GROUP";

	private UnitModel unitModel;
	private CurrencyModel currencyModel;

	private PriceRowModel any_anyM;
	private PriceRowModel any_givenM;
	private PriceRowModel any_groupM;
	private PriceRowModel given_anyM;
	private PriceRowModel given_givenM;
	private PriceRowModel given_groupM;
	private PriceRowModel group_anyM;
	private PriceRowModel group_givenM;
	private PriceRowModel group_groupM;
	private PriceRowModel id_anyM;
	private PriceRowModel id_givenM;
	private PriceRowModel id_groupM;
	private ProductModel anyProductM;
	private ProductModel givenProductM;

	private UserModel anyUser;
	private UserModel givenUserM;
	private ProductPriceGroup givenProductGroupM;
	private UserPriceGroup givenUserGroupM;

	@Before
	public void setUp() throws Exception
	{
		unitModel = modelService.create(UnitModel.class);
		unitModel.setCode("pieces");
		unitModel.setUnitType("pieces");
		modelService.save(unitModel);

		try
		{
			currencyModel = modelService.create(CurrencyModel.class);
			currencyModel.setIsocode("EUR");
			modelService.save(currencyModel);
		}
		catch (final Exception e)
		{
			currencyModel = commonI18NService.getCurrency("EUR");
		}

		anyUser = null;
		anyProductM = null;

		givenProductM = productM(TEST_PRODUCT);
		givenUserM = userM(TEST_USER);
		givenUserGroupM = UserPriceGroup.valueOf(TEST_USER_GROUP);
		modelService.save(givenUserGroupM);
		any_anyM = createPrice(anyProductM, anyUser);
		any_givenM = createPrice(null, userM(TEST_USER));
		any_groupM = createPrice(null, givenUserGroupM);
		given_anyM = createPrice(givenProductM, anyUser);
		givenProductGroupM = ProductPriceGroup.valueOf(TEST_PRODUCT_GROUP);
		modelService.save(givenProductGroupM);
		given_givenM = createPrice(givenProductM, givenUserM);
		given_groupM = createPrice(givenProductM, givenUserGroupM);
		group_anyM = createPrice(givenProductGroupM, anyUser);
		group_givenM = createPrice(givenProductGroupM, givenUserM);
		group_groupM = createPrice(givenProductGroupM, givenUserGroupM);
		id_anyM = createPrice(TEST_PRODUCT, anyUser);
		id_givenM = createPrice(TEST_PRODUCT, givenUserM);
		id_groupM = createPrice(TEST_PRODUCT, givenUserGroupM);
	}

	@Test
	public void shouldQueryPricesForAnyProductAndAnyUser()
	{
		final Collection<PriceRowModel> prices = queryForPrices(anyProductM, anyUser);
		assertThat(prices).containsOnly(any_anyM);
	}

	@Test
	public void shouldQueryPricesForAnyProductAndGivenUser()
	{
		final Collection<PriceRowModel> prices = queryForPrices(anyProductM, givenUserM);
		assertThat(prices).containsOnly(any_anyM, any_givenM);
	}

	@Test
	public void shouldQueryPricesForAnyProductAndGivenUserGroup()
	{
		final Collection<PriceRowModel> prices = queryForPrices(anyProductM, givenUserGroupM);
		assertThat(prices).containsOnly(any_anyM, any_groupM);
	}

	@Test
	public void shouldQueryPricesForGivenProductAndAnyUser()
	{
		final Collection<PriceRowModel> prices = queryForPrices(givenProductM, anyUser);
		assertThat(prices).containsOnly(any_anyM, given_anyM, id_anyM);
	}

	@Test
	public void shouldQueryPricesForGivenProductAndGivenUser()
	{
		final Collection<PriceRowModel> prices = queryForPrices(givenProductM, givenUserM);
		assertThat(prices).containsOnly(any_anyM, any_givenM, given_anyM, given_givenM, id_anyM, id_givenM);
	}

	@Test
	public void shouldQueryPricesForGivenProductAndGivenUserGroup()
	{
		final Collection<PriceRowModel> prices = queryForPrices(givenProductM, givenUserGroupM);
		assertThat(prices).containsOnly(any_anyM, any_groupM, given_anyM, given_groupM, id_anyM, id_groupM);
	}

	@Test
	public void shouldQueryPricesForGivenProductGroupAndAnyUser()
	{
		final Collection<PriceRowModel> prices = queryForPrices(givenProductGroupM, anyUser);
		assertThat(prices).containsOnly(any_anyM, group_anyM);
	}

	@Test
	public void shouldQueryPricesForGivenProductGroupAndGivenUser()
	{
		final Collection<PriceRowModel> prices = queryForPrices(givenProductGroupM, givenUserM);
		assertThat(prices).containsOnly(any_anyM, any_givenM, group_anyM, group_givenM);
	}

	@Test
	public void shouldQueryPricesForGivenProductGroupAndGivenUserGroup()
	{
		final Collection<PriceRowModel> prices = queryForPrices(givenProductGroupM, givenUserGroupM);
		assertThat(prices).containsOnly(any_anyM, any_groupM, group_anyM, group_groupM);
	}

	@Test
	public void shouldMatchPriceForPrice()
	{
		try
		{
			final PriceValue prm = matchPriceRowForPrice(givenProductM, givenUserM);
			assertThat(prm).isNotNull();
		}
		catch (final CalculationException e)
		{
			Assert.fail();
		}
	}

	public PriceValue matchPriceRowForPrice(final Object product, final Object user) throws CalculationException
	{
		final ProductModel prod = (product instanceof ProductModel) ? (ProductModel) product : null;
		final ProductPriceGroup prodGroup = (product instanceof ProductPriceGroup) ? (ProductPriceGroup) product : null;
		final UserModel usr = (user instanceof UserModel) ? (UserModel) user : null;
		final UserPriceGroup usrGroup = (user instanceof UserPriceGroup) ? (UserPriceGroup) user : null;
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();
		final String DETECTED_UI_EXPERIENCE_LEVEL = "UiExperienceService-Detected-Level";
		final String CHANNEL = "channel";

		final EnumerationValue desktopEnumUIExpLevel = EnumerationManager.getInstance()
				.getEnumerationValue(PriceRowChannel._TYPECODE, "desktop");
		ctx.setAttribute(DETECTED_UI_EXPERIENCE_LEVEL, desktopEnumUIExpLevel);
		ctx.setAttribute(CHANNEL, PriceRowChannel.DESKTOP);


		final PriceValueInfoCriteria params = DefaultPriceValueInfoCriteria.buildForValue() //
				.withProduct(prod) //
				.withProductPriceGroup(prodGroup) //
				.withUser(usr) //
				.withUserPriceGroup(usrGroup) //
				.withQuantity(2l) //
				.withUnit(unitModel) //
				.withCurrency(currencyModel) //
				.withDate(new Date()) //
				.withNet(false) //
				.withGiveAwayMode(false) //
				.build();

		return findPriceValueInfoStrategy.getPDTValues(params).get(0);
	}

	private Collection<PriceRowModel> queryForPrices(final Object product, final Object user)
	{
		final ProductModel prod = (product instanceof ProductModel) ? (ProductModel) product : null;
		final ProductPriceGroup prodGroup = (product instanceof ProductPriceGroup) ? (ProductPriceGroup) product : null;
		final UserModel usr = (user instanceof UserModel) ? (UserModel) user : null;
		final UserPriceGroup usrGroup = (user instanceof UserPriceGroup) ? (UserPriceGroup) user : null;



		final PriceValueInfoCriteria params = DefaultPriceValueInfoCriteria.buildForValue() //
				.withProduct(prod) //
				.withProductPriceGroup(prodGroup) //
				.withUser(usr) //
				.withUserPriceGroup(usrGroup) //
				.withCurrency(currencyModel) //
				.withGiveAwayMode(false) //
				.build();

		return defaultPriceRowRepository.findRows(params);
	}

	private PriceRowModel createPrice(final Object product, final Object user) throws Exception
	{
		final ProductModel prod = (product instanceof ProductModel) ? (ProductModel) product : null;
		final ProductPriceGroup prodGroup = (product instanceof ProductPriceGroup) ? (ProductPriceGroup) product : null;
		final UserModel usr = (user instanceof UserModel) ? (UserModel) user : null;
		final UserPriceGroup usrGroup = (user instanceof UserPriceGroup) ? (UserPriceGroup) user : null;
		final String productCode = (product instanceof String) ? (String) product : null;

		return createPriceRow(prod, prodGroup, usr, usrGroup, productCode);
	}

	private PriceRowModel createPriceRow(final ProductModel product, final ProductPriceGroup productGroup, final UserModel user,
			final UserPriceGroup userGroup, final String productCode)
	{
		final PriceRowModel priceRowModel = modelService.create(PriceRowModel.class);
		priceRowModel.setProduct(product);
		priceRowModel.setPg(productGroup);
		priceRowModel.setUser(user);
		priceRowModel.setUg(userGroup);
		priceRowModel.setMinqtd(2l);
		priceRowModel.setUnitFactor(1);
		priceRowModel.setNet(true);
		priceRowModel.setPrice(123.45);
		priceRowModel.setUnit(unitModel);
		priceRowModel.setCurrency(currencyModel);
		priceRowModel.setProductId(productCode);
		modelService.save(priceRowModel);

		return priceRowModel;
	}

	private UserModel userM(final String login)
	{
		if (login == null)
		{
			return null;
		}

		try
		{
			final UserModel userModel = modelService.create(UserModel.class);
			userModel.setUid(login);
			modelService.save(userModel);
			return userModel;
		}
		catch (final Exception e)
		{
			return userService.getUserForUID(login);
		}
	}


	private ProductModel productM(final String code)
	{
		if (code == null)
		{
			return null;
		}

		final CatalogModel testCatalog = modelService.create(CatalogModel.class);
		testCatalog.setId("testCatalog2");
		modelService.save(testCatalog);

		final CatalogVersionModel testCatalogVersion = modelService.create(CatalogVersionModel.class);
		testCatalogVersion.setCatalog(testCatalog);
		testCatalogVersion.setVersion("online");
		modelService.save(testCatalogVersion);

		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode(code);
		product.setCatalogVersion(testCatalogVersion);
		modelService.save(product);
		return product;
	}
}
