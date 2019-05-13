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
package de.hybris.platform.order.impl

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.catalog.CatalogVersionService
import de.hybris.platform.catalog.model.CatalogVersionModel
import de.hybris.platform.core.Constants
import de.hybris.platform.core.HybrisEnumValue
import de.hybris.platform.core.PK
import de.hybris.platform.core.model.ItemModel
import de.hybris.platform.core.model.c2l.CountryModel
import de.hybris.platform.core.model.c2l.CurrencyModel
import de.hybris.platform.core.model.order.CartEntryModel
import de.hybris.platform.core.model.order.CartModel
import de.hybris.platform.core.model.order.price.DiscountModel
import de.hybris.platform.core.model.order.price.TaxModel
import de.hybris.platform.core.model.product.ProductModel
import de.hybris.platform.core.model.product.UnitModel
import de.hybris.platform.core.model.user.AddressModel
import de.hybris.platform.core.model.user.UserModel
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeModel
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeValueModel
import de.hybris.platform.deliveryzone.model.ZoneModel
import de.hybris.platform.europe1.enums.ProductDiscountGroup
import de.hybris.platform.europe1.enums.ProductPriceGroup
import de.hybris.platform.europe1.enums.ProductTaxGroup
import de.hybris.platform.europe1.enums.UserDiscountGroup
import de.hybris.platform.europe1.enums.UserPriceGroup
import de.hybris.platform.europe1.enums.UserTaxGroup
import de.hybris.platform.europe1.jalo.Europe1PriceFactory
import de.hybris.platform.europe1.jalo.Europe1TaxInformation
import de.hybris.platform.europe1.model.DiscountRowModel
import de.hybris.platform.europe1.model.PriceRowModel
import de.hybris.platform.europe1.model.TaxRowModel
import de.hybris.platform.jalo.order.price.DiscountInformation
import de.hybris.platform.jalo.order.price.PriceInformation
import de.hybris.platform.jalo.order.price.ProductPriceInformations
import de.hybris.platform.jalo.product.Unit
import de.hybris.platform.order.CalculationService
import de.hybris.platform.order.exceptions.CalculationException
import de.hybris.platform.paymentstandard.model.StandardPaymentModeModel
import de.hybris.platform.paymentstandard.model.StandardPaymentModeValueModel
import de.hybris.platform.product.PriceCriteria
import de.hybris.platform.product.PriceService
import de.hybris.platform.product.ProductService
import de.hybris.platform.product.UnitService
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import de.hybris.platform.servicelayer.i18n.CommonI18NService
import de.hybris.platform.servicelayer.model.ModelService
import de.hybris.platform.servicelayer.time.TimeService
import de.hybris.platform.servicelayer.type.TypeService
import de.hybris.platform.servicelayer.user.AddressService
import de.hybris.platform.servicelayer.user.UserNetCheckingStrategy
import de.hybris.platform.servicelayer.user.UserService
import de.hybris.platform.testframework.PropertyConfigSwitcher
import de.hybris.platform.util.Config
import org.junit.Test
import spock.lang.Shared
import spock.lang.Unroll

import javax.annotation.Resource

@IntegrationTest
class DefaultCalculationServiceTestSpec extends ServicelayerSpockSpecification {
	private static boolean debug = Config.getBoolean("debug.calculation.test", false)

	@Resource
	private ModelService modelService
	@Resource
	private CalculationService calculationService
	@Resource
	private TypeService typeService

	@Shared
	private TestCaseXmlHelper testCases

	private CurrencyModel currency, currency2
	private PriceRowModel priceGeneral1, priceGeneral2
	private UnitModel unit, unit2
	private Map<String, HybrisEnumValue> enumerations
	private CountryModel country
	private ProductModel product
	private AddressModel deliveryAddress
	private UserModel user
	private CatalogVersionModel catalogVersion

	private TaxModel tax, tax2
	private TaxRowModel taxRow, taxRow2
	private PriceRowModel price, price2
	private CartModel order, order2
	private CartEntryModel orderEntry, orderEntry2
	private DiscountModel discountToOrder1, discountToOrder2, discount1, discount2
	private DiscountRowModel discountRow1, discountRow2
	private Date orderDate
	private StandardPaymentModeModel paymentModeModel
	private StandardPaymentModeValueModel paymentModeValue
	private ZoneModel zone1Model
	private ZoneDeliveryModeModel deliveryModeModel
	private ZoneDeliveryModeValueModel deliveryModeValue

	private PropertyConfigSwitcher pdtCalculationModeSwitcher
	private PropertyConfigSwitcher europe1CacheTaxes
	private Collection<ItemModel> all

	private Map<String, CurrencyModel> currencies
	private Map<String, UnitModel> units

	private CalculationRowWrapper rowWrapper

	@Resource
	TimeService timeService
	@Resource
	PriceService priceService
	@Resource
	UserNetCheckingStrategy userNetCheckingStrategy;
	@Resource
	CommonI18NService commonI18NService
	@Resource
	UnitService unitService
	@Resource
	ProductService productService
	@Resource
	CatalogVersionService catalogVersionService
	@Resource
	UserService userService
	@Resource
	AddressService addressService

	def setup() {
		createCoreData()
		createDefaultCatalog()
		createDefaultUsers()

		currency = commonI18NService.getCurrency("EUR")
		currency2 = commonI18NService.getCurrency("USD")
		country = commonI18NService.getCountry("DE")
		unit = unitService.getUnitForCode("kg")
		unit2 = unitService.getUnitForCode("l")
		product = productService.getProductForCode("testProduct0")
		catalogVersion = catalogVersionService.getCatalogVersion("testCatalog", "Online")
		user = userService.getUserForUID("hweaving")
		deliveryAddress = addressService.getAddressesForOwner(user).iterator().next()

		priceGeneral1 = createPriceRow(13, currency, unit)
		priceGeneral2 = createPriceRow(15, currency2, unit2)

		enumerations = new HashMap()

		enumerations.put("ppg1", ProductPriceGroup.valueOf("ppg1"))
		enumerations.put("ppg2", ProductPriceGroup.valueOf("ppg2"))
		enumerations.put("ptg1", ProductTaxGroup.valueOf("ptg1"))
		enumerations.put("ptg2", ProductTaxGroup.valueOf("ptg2"))
		enumerations.put("pdg1", ProductDiscountGroup.valueOf("pdg1"))
		enumerations.put("pdg2", ProductDiscountGroup.valueOf("pdg2"))

		enumerations.put("upg1", UserPriceGroup.valueOf("upg1"))
		enumerations.put("upg2", UserPriceGroup.valueOf("upg2"))
		enumerations.put("utg1", UserTaxGroup.valueOf("utg1"))
		enumerations.put("utg2", UserTaxGroup.valueOf("utg2"))
		enumerations.put("udg1", UserDiscountGroup.valueOf("udg1"))
		enumerations.put("udg2", UserDiscountGroup.valueOf("udg2"))

		enumerations.put("pg1", ProductDiscountGroup.valueOf("pg1"))
		enumerations.put("pg2", ProductDiscountGroup.valueOf("pg2"))
		enumerations.put("ug1", UserDiscountGroup.valueOf("ug1"))
		enumerations.put("ug2", UserDiscountGroup.valueOf("ug2"))

		modelService.saveAll(enumerations.values())

		tax = modelService.create(TaxModel.class)
		tax2 = modelService.create(TaxModel.class)
		taxRow = modelService.create(TaxRowModel.class)
		taxRow2 = modelService.create(TaxRowModel.class)
		price = modelService.create(PriceRowModel.class)
		price2 = modelService.create(PriceRowModel.class)
		order = modelService.create(CartModel.class)
		orderEntry = modelService.create(CartEntryModel.class)
		order2 = modelService.create(CartModel.class)
		orderEntry2 = modelService.create(CartEntryModel.class)
		discount1 = modelService.create(DiscountModel.class)
		discount2 = modelService.create(DiscountModel.class)
		discountToOrder1 = modelService.create(DiscountModel.class)
		discountToOrder2 = modelService.create(DiscountModel.class)
		discountRow1 = modelService.create(DiscountRowModel.class)
		discountRow2 = modelService.create(DiscountRowModel.class)
		orderDate = new Date(2018 - 1900, 6, 25)
		paymentModeModel = modelService.create(StandardPaymentModeModel.class)
		paymentModeValue = modelService.create(StandardPaymentModeValueModel.class)
		deliveryModeModel = modelService.create(ZoneDeliveryModeModel.class)
		deliveryModeValue = modelService.create(ZoneDeliveryModeValueModel.class)
		zone1Model = modelService.create(ZoneModel.class)

		pdtCalculationModeSwitcher = new PropertyConfigSwitcher("pdt.calculation.mode")
		europe1CacheTaxes = new PropertyConfigSwitcher("europe1.cache.taxes")

		order.setCode("order1")
		order.setDate(orderDate)
		order.setUser(user)

		order2.setCode("order2")
		order2.setDate(orderDate)
		order2.setUser(user)

		orderEntry.setProduct(product)
		orderEntry.setQuantity(1L)
		orderEntry.setOrder(order)

		orderEntry2.setProduct(product)
		orderEntry2.setQuantity(1L)
		orderEntry2.setOrder(order2)

		all = new ArrayList<>()
		Collections.addAll(all, orderEntry, order, orderEntry2, order2,
				paymentModeModel, paymentModeValue, deliveryModeModel)

		currencies = ["currency1": currency, "currency2": currency2]
		units = ["unit1": unit, "unit2": unit2]
	}

	def cleanup() {
		pdtCalculationModeSwitcher.switchBackToDefault()
		europe1CacheTaxes.switchBackToDefault()
	}

	def setupSpec() {
		URL itemsXmlUrl = getClass().getClassLoader().getResource("platformservices/test/defaultCalculationServiceTestCasesEnhanced.xml")
		testCases = new TestCaseXmlHelper(new File(itemsXmlUrl.toURI()))
	}

	def createPriceRow(value, currency, unit) {

		PriceRowModel priceRow = modelService.create(PriceRowModel.class)
		priceRow.setPrice(value)
		priceRow.setCurrency(currency)
		priceRow.setUnit(unit)
		priceRow.setNet(false)
		priceRow.setMinqtd(1L)
		priceRow.setUnitFactor(1)
		priceRow.setGiveAwayPrice(false)
		modelService.save(priceRow)

		return priceRow
	}

	@Test
	@Unroll
	def "Calculation test"() {
		given:
		rowWrapper = new CalculationRowWrapper()
		rowWrapper.prepareGiven(row)

		when:
		try {
			prepareWhen()
		} catch (Exception e) {
			println "Got exception " + e.getMessage()
		}

		boolean expectedException = false
		boolean actualException = false
		String expectedExceptionMessage
		String actualExceptionMessage

		try {
			pdtCalculationModeSwitcher.switchToValue("jalo")
			calculationService.calculate(order)
		} catch (CalculationException e) {
			expectedException = true
			expectedExceptionMessage = e.getMessage()
		}

		List<ProductPriceInformations> productPriceInformations = getProductPriceInformationsInAllWays(product, user)

		try {
			pdtCalculationModeSwitcher.switchToValue("sl")
			calculationService.calculate(order2)
		} catch (CalculationException e) {
			actualException = true
			actualExceptionMessage = e.getMessage()
		}

		Double totalJalo = order.getTotalPrice()
		Double subtotalJalo = order.getSubtotal()
		Double paymentJalo = order.getPaymentCost()
		Double deliveryJalo = order.getDeliveryCost()
		Double taxJalo = order.getTotalTax()
		Double discountsJalo = order.getTotalDiscounts()

		Double totalFree = order2.getTotalPrice()
		Double subtotalFree = order2.getSubtotal()
		Double paymentFree = order2.getPaymentCost()
		Double deliveryFree = order2.getDeliveryCost()
		Double taxFree = order2.getTotalTax()
		Double discountsFree = order2.getTotalDiscounts()

		println "*******\nCalculation results:" +//
				"\n totalJalo=\t $totalJalo \ttotalFree=\t $totalFree (prices $rowWrapper.PriceRowModel_value, $rowWrapper.PriceRowModel2_value)" +//
				"\n subtoJalo=\t $subtotalJalo \tsubtoFree=\t $subtotalFree" + //
				"\n paymJalo=\t $paymentJalo \tpaymFree=\t $paymentFree (paymentCost $rowWrapper.OrderModel_paymentCost)" +//
				"\n delivJalo=\t $deliveryJalo \tdelivFree=\t $deliveryFree (deliveryCost $rowWrapper.OrderModel_deliveryCost)" +//
				"\n taxesJalo=\t $taxJalo \ttaxesFree=\t $taxFree" + //
				"\n discJalo=\t $discountsJalo \tdiscFree=\t $discountsFree"
		println "Got jalo exception: $expectedException with message: $expectedExceptionMessage"
		println "Got sl exception: $actualException with message: $actualExceptionMessage"
		println "*******"

		then:
		expectedException == actualException
		totalJalo == totalFree || expectedException
		subtotalJalo == subtotalFree || expectedException
		paymentJalo == paymentFree
		deliveryJalo == deliveryFree
		taxJalo == taxFree
		discountsJalo == discountsFree

		sameProductPriceInformationInAllWays(productPriceInformations)

		where:
		row << testCases
	}

	List<ProductPriceInformations> getProductPriceInformationsInAllWays(ProductModel product, UserModel user) {
		List<ProductPriceInformations> informations = []

		europe1CacheTaxes.switchToValue("true")
		informations.addAll(getProductPriceInformationsViaSLAndJalo(product, user))

		europe1CacheTaxes.switchToValue("false")
		informations.addAll(getProductPriceInformationsViaSLAndJalo(product, user))

		europe1CacheTaxes.switchBackToDefault()

		return informations
	}

	List<ProductPriceInformations> getProductPriceInformationsViaSLAndJalo(ProductModel product, UserModel user) {
		def isNetUser = userNetCheckingStrategy.isNetUser(user)
		def currentTime = timeService.getCurrentTime()
		def productJalo = modelService.getSource(product)

		final PriceCriteria.DefaultPriceCriteria criteria = PriceCriteria.DefaultPriceCriteria.forProduct(product)
				.forDate(currentTime).withNetPrice(isNetUser)

		List<ProductPriceInformations> informations = []
		pdtCalculationModeSwitcher.switchToValue("jalo")
		informations.add(priceService.getAllPriceInformation(criteria))

		pdtCalculationModeSwitcher.switchToValue("sl")
		informations.add(priceService.getAllPriceInformation(criteria))

		informations.add(Europe1PriceFactory.getInstance().getAllPriceInformations(productJalo, currentTime, isNetUser))

		return informations
	}


	boolean sameProductPriceInformationInAllWays(List<ProductPriceInformations> productPriceInformations)
	{
		return productPriceInformations.size() == 6 &&
				sameProductPriceInformations(productPriceInformations[0], productPriceInformations[1]) &&
				sameProductPriceInformations(productPriceInformations[0], productPriceInformations[2]) &&
				sameProductPriceInformations(productPriceInformations[3], productPriceInformations[4]) &&
				sameProductPriceInformations(productPriceInformations[4], productPriceInformations[5]) &&
				sameProductPriceInformations(productPriceInformations[0], productPriceInformations[3])
	}


	boolean sameProductPriceInformations(ProductPriceInformations expected, ProductPriceInformations actual) {
		return sameCollections(expected.prices, actual.prices, this.&samePriceInfo) && sameCollections(expected.taxes, actual.taxes, this.&sameTaxInfo) &&
				sameCollections(expected.discounts, actual.discounts, this.&sameDiscountInfo)
	}

	boolean sameCollections(Collection expected, Collection actual, Closure compare) {
		for (e in expected) {
			def found = actual.find { compare(e, it) }

			if (found == null) {
				if (debug) println "FAILED >> Expected ${e.getClass().simpleName}: ${e.value}"
				actual.each {
					println ">>> ${it.value}"
				}

				return false
			} else {
				if (debug) println "Expected ${e.getClass().simpleName}: ${e.value}, actual: ${found.value}"
			}
		}
		return true
	}

	boolean samePriceInfo(PriceInformation p1, PriceInformation p2) {
		if (p1.getValue().value != p2.getValue().value) {
			return false
		}
		if (p1.getValue().net != p2.getValue().net) {
			return false
		}
		if (p1.getValue().currencyIso != p2.getValue().currencyIso) {
			return false
		}

		return getUnitPK(p1) == getUnitPK(p2)
	}

	PK getUnitPK(PriceInformation pi) {
		def u = pi.getQualifierValue("unit")

		if (u instanceof Unit) {
			return u.getPK()
		} else if (u instanceof UnitModel) {
			return u.getPk()
		}

		throw new UnsupportedOperationException()
	}

	boolean sameTaxInfo(Europe1TaxInformation t1, Europe1TaxInformation t2) {
		return t1.getValue() == t2.getValue() && t1.getTaxRow() == t2.getTaxRow()
	}

	boolean sameDiscountInfo(DiscountInformation d1, DiscountInformation d2) {
		return d1.getValue() == d2.getValue()
	}


	def prepareWhen() {
		rowWrapper.ProductModel_unit = units.get(rowWrapper.ProductModel_unit)
		if (debug) println " > ProductModel_unit set to: $rowWrapper.ProductModel_unit"

		rowWrapper.OrderModel_currency = currencies.get(rowWrapper.OrderModel_currency)
		if (debug) println " > OrderModel_currency set to: $rowWrapper.OrderModel_currency"

		rowWrapper.PriceRowModel_unit = units.get(rowWrapper.PriceRowModel_unit)
		if (debug) println " > PriceRowModel_unit set to: $rowWrapper.PriceRowModel_unit"

		rowWrapper.PriceRowModel_currency = currencies.get(rowWrapper.PriceRowModel_currency)
		if (debug) println " > PriceRowModel_currency set to: $rowWrapper.PriceRowModel_currency"

		rowWrapper.PriceRowModel2_unit = units.get(rowWrapper.PriceRowModel2_unit)
		if (debug) println " > PriceRowModel2_unit set to: $rowWrapper.PriceRowModel2_unit"

		rowWrapper.PriceRowModel2_currency = currencies.get(rowWrapper.PriceRowModel2_currency)
		if (debug) println " > PriceRowModel2_currency set to: $rowWrapper.PriceRowModel2_currency"

		rowWrapper.TaxRowModel1_currency = currencies.get(rowWrapper.TaxRowModel1_currency)
		if (debug) println " > TaxRowModel1_currency set to: $rowWrapper.TaxRowModel1_currency"

		rowWrapper.TaxRowModel1_TaxModel_currency = currencies.get(rowWrapper.TaxRowModel1_TaxModel_currency)
		if (debug) println " > TaxRowModel1_TaxModel_currency set to: $rowWrapper.TaxRowModel1_TaxModel_currency"

		rowWrapper.TaxRowModel2_currency = currencies.get(rowWrapper.TaxRowModel2_currency)
		if (debug) println " > TaxRowModel2_currency set to: $rowWrapper.TaxRowModel2_currency"

		rowWrapper.TaxRowModel2_TaxModel_currency = currencies.get(rowWrapper.TaxRowModel2_TaxModel_currency)
		if (debug) println " > TaxRowModel2_TaxModel_currency set to: $rowWrapper.TaxRowModel2_TaxModel_currency"

		rowWrapper.DiscountModelToOrder1_currency = currencies.get(rowWrapper.DiscountModelToOrder1_currency)
		if (debug) println " > DiscountModelToOrder1_currency set to: $rowWrapper.DiscountModelToOrder1_currency"

		rowWrapper.DiscountModelToOrder2_currency = currencies.get(rowWrapper.DiscountModelToOrder2_currency)
		if (debug) println " > DiscountModelToOrder2_currency set to: $rowWrapper.DiscountModelToOrder2_currency"

		rowWrapper.DiscountRowModel1_currency = currencies.get(rowWrapper.DiscountRowModel1_currency)
		if (debug) println " > DiscountRowModel1_currency set to: $rowWrapper.DiscountRowModel1_currency"

		rowWrapper.DiscountRowModel1_pg = enumerations.get(rowWrapper.DiscountRowModel1_pg)
		if (debug) println " > DiscountRowModel1_pg set to: $rowWrapper.DiscountRowModel1_pg"

		rowWrapper.DiscountRowModel1_ug = enumerations.get(rowWrapper.DiscountRowModel1_ug)
		if (debug) println " > DiscountRowModel1_ug set to: $rowWrapper.DiscountRowModel1_ug"

		rowWrapper.DiscountRowModel2_currency = currencies.get(rowWrapper.DiscountRowModel2_currency)
		if (debug) println " > DiscountRowModel2_currency set to: $rowWrapper.DiscountRowModel2_currency"

		rowWrapper.DiscountRowModel2_pg = enumerations.get(rowWrapper.DiscountRowModel2_pg)
		if (debug) println " > DiscountRowModel2_pg set to: $rowWrapper.DiscountRowModel2_pg"

		rowWrapper.DiscountRowModel2_ug = enumerations.get(rowWrapper.DiscountRowModel2_ug)
		if (debug) println " > DiscountRowModel2_ug set to: $rowWrapper.DiscountRowModel2_ug"

		if (debug) println "---------- adding orders -------------"

		orderEntry.setUnit(rowWrapper.ProductModel_unit)
		orderEntry2.setUnit(rowWrapper.ProductModel_unit)

		order.setCurrency(rowWrapper.OrderModel_currency)
		order.setNet(rowWrapper.OrderModel_net)

		order2.setCurrency(rowWrapper.OrderModel_currency)
		order2.setNet(rowWrapper.OrderModel_net)

		if (rowWrapper.OrderModel_paymentCost != null) {
			if (debug) println "---------- adding payment cost -------------"

			paymentModeValue.setCurrency(rowWrapper.OrderModel_currency)
			paymentModeValue.setValue(rowWrapper.OrderModel_paymentCost)
			paymentModeValue.setPaymentMode(paymentModeModel)
			paymentModeModel.setPaymentModeValues(Arrays.asList(paymentModeValue))
			paymentModeModel.setActive(true)
			paymentModeModel.setCode("PaymentMode")
			paymentModeModel.setPaymentInfoType(typeService.getComposedTypeForCode(Constants.TYPES.CreditCardTypeType))

			order.setPaymentMode(paymentModeModel)
			order2.setPaymentMode(paymentModeModel)

			all.addAll(paymentModeValue, paymentModeModel)
		}

		if (rowWrapper.OrderModel_deliveryCost != null) {
			if (debug) println "---------- adding delivery cost $rowWrapper.OrderModel_deliveryCost "

			zone1Model.setCode("zone1")
			zone1Model.setCountries([country] as Set)

			deliveryModeValue.setCurrency(rowWrapper.OrderModel_currency)
			deliveryModeValue.setMinimum(0.0)
			deliveryModeValue.setValue(rowWrapper.OrderModel_deliveryCost)
			deliveryModeValue.setZone(zone1Model)
			deliveryModeValue.setDeliveryMode(deliveryModeModel)

			deliveryModeModel.setCode("zoneDM1")
			deliveryModeModel.setNet(Boolean.TRUE)

			order.setDeliveryMode(deliveryModeModel)
			order.setDeliveryAddress(deliveryAddress)
			order2.setDeliveryMode(deliveryModeModel)
			order2.setDeliveryAddress(deliveryAddress)

			modelService.save(zone1Model)
			modelService.save(deliveryModeModel)
			modelService.save(deliveryModeValue)
		}

		List discountsToOrder = new ArrayList()

		if (rowWrapper.DiscountModelToOrder1_exists) {
			if (debug) println "---------- adding discount1 " + rowWrapper.DiscountModelToOrder1_value

			discountToOrder1.setCode("discountToOrder1")
			discountToOrder1.setCurrency(rowWrapper.DiscountModelToOrder1_currency)
			discountToOrder1.setValue(rowWrapper.DiscountModelToOrder1_value)
			discountToOrder1.setGlobal(rowWrapper.DiscountModelToOrder1_global)
			discountsToOrder.add(discountToOrder1)

			all.add(discountToOrder1)
		}

		if (rowWrapper.DiscountModelToOrder2_exists) {
			if (debug) println "---------- adding discount2 " + rowWrapper.DiscountModelToOrder2_value

			discountToOrder2.setCode("discountToOrder2")
			discountToOrder2.setCurrency(rowWrapper.DiscountModelToOrder2_currency)
			discountToOrder2.setValue(rowWrapper.DiscountModelToOrder2_value)
			discountToOrder2.setGlobal(rowWrapper.DiscountModelToOrder2_global)
			discountsToOrder.add(discountToOrder1)

			all.add(discountToOrder2)
		}

		order.setDiscounts(discountsToOrder)
		order2.setDiscounts(discountsToOrder)

		if (debug) println "---------- adding prices -------------"

		if (rowWrapper.PriceRowModel1_exists) {
			if (debug) println "---------- adding price1 -------------"

			price.setPrice(rowWrapper.PriceRowModel_value)
			price.setCurrency(rowWrapper.PriceRowModel_currency)
			price.setUnit(rowWrapper.PriceRowModel_unit)
			price.setProduct(product)
			price.setNet(rowWrapper.PriceRowModel_net)
			price.setMinqtd(1L)
			price.setUnitFactor(rowWrapper.PriceRowModel_unitFactor)
			price.setGiveAwayPrice(rowWrapper.PriceRowModel_giveAwayPrice)

			all.add(price)
		}

		if (rowWrapper.PriceRowModel2_exists) {
			if (debug) println "---------- adding price2 -------------"

			price2.setPrice(rowWrapper.PriceRowModel2_value)
			price2.setCurrency(rowWrapper.PriceRowModel2_currency)
			price2.setUnit(rowWrapper.PriceRowModel2_unit)
			price2.setProduct(product)
			price2.setNet(rowWrapper.PriceRowModel2_net)
			price2.setMinqtd(1L)
			price2.setUnitFactor(rowWrapper.PriceRowModel2_unitFactor)
			price2.setGiveAwayPrice(rowWrapper.PriceRowModel2_giveAwayPrice)

			all.add(price2)
		}

		product.setPriceQuantity(rowWrapper.ProductModel_priceQuantity)

		if (rowWrapper.TaxRowModel1_exists) {
			if (debug) println "---------- adding tax1 -------------"

			tax.setValue(rowWrapper.TaxRowModel1_TaxModel_value)
			tax.setCurrency(rowWrapper.TaxRowModel1_TaxModel_currency)
			tax.setCode("VAT Tax")
			taxRow.setTax(tax)
			taxRow.setValue(rowWrapper.TaxRowModel1_value)
			taxRow.setCurrency(rowWrapper.TaxRowModel1_currency)
			taxRow.setProduct(product)
			taxRow.setCatalogVersion(catalogVersion)
			all.addAll(tax, taxRow)
		}

		if (rowWrapper.TaxRowModel2_exists) {
			if (debug) println "---------- adding tax2 -------------"

			tax2.setValue(rowWrapper.TaxRowModel2_TaxModel_value)
			tax2.setCurrency(rowWrapper.TaxRowModel2_TaxModel_currency)
			tax2.setCode("VAT Tax2")
			taxRow2.setTax(tax2)
			taxRow2.setValue(rowWrapper.TaxRowModel2_value)
			taxRow2.setCurrency(rowWrapper.TaxRowModel2_currency)
			taxRow2.setProduct(product)
			taxRow2.setCatalogVersion(catalogVersion)
			all.addAll(tax2, taxRow2)
		}

		if (rowWrapper.DiscountRowModel1_exists) {
			if (debug) println "---------- adding Discount1 " + rowWrapper.DiscountRowModel1_value

			discount1.setCode("Discount1")
			discountRow1.setDiscount(discount1)
			discountRow1.setCatalogVersion(catalogVersion)
			discountRow1.setValue(rowWrapper.DiscountRowModel1_value)
			discountRow1.setCurrency(rowWrapper.DiscountRowModel1_currency)
			discountRow1.setAsTargetPrice(rowWrapper.DiscountRowModel1_asTargetPrice)
			discountRow1.setPg(rowWrapper.DiscountRowModel1_pg)
			discountRow1.setUg(rowWrapper.DiscountRowModel1_ug)
			all.addAll(discount1, discountRow1)
		}

		if (rowWrapper.DiscountRowModel2_exists) {
			if (debug) println "---------- adding discountRow2 " + rowWrapper.DiscountRowModel2_value

			discount2.setCode("Discount2")
			discountRow2.setDiscount(discount2)
			discountRow2.setCatalogVersion(catalogVersion)
			discountRow2.setValue(rowWrapper.DiscountRowModel2_value)
			discountRow2.setCurrency(rowWrapper.DiscountRowModel2_currency)
			discountRow2.setAsTargetPrice(rowWrapper.DiscountRowModel2_asTargetPrice)
			discountRow2.setPg(rowWrapper.DiscountRowModel2_pg)
			discountRow2.setUg(rowWrapper.DiscountRowModel2_ug)
			all.addAll(discount2, discountRow2)
		}

		if (debug) println "---------- adding ppg " + rowWrapper.ProductModel_ppg
		ProductPriceGroup ppg = enumerations.get(rowWrapper.ProductModel_ppg)
		product.setEurope1PriceFactory_PPG(ppg)

		if (debug) println "---------- adding ptg " + rowWrapper.ProductModel_ptg
		ProductTaxGroup ptg = enumerations.get(rowWrapper.ProductModel_ptg)
		product.setEurope1PriceFactory_PTG(ptg)

		if (debug) println "---------- adding pdg " + rowWrapper.ProductModel_pdg
		ProductDiscountGroup pdg = enumerations.get(rowWrapper.ProductModel_pdg)
		product.setEurope1PriceFactory_PDG(pdg)

		if (debug) println "---------- adding udg " + rowWrapper.UserModel_udg
		UserDiscountGroup udg = enumerations.get(rowWrapper.UserModel_udg)
		user.setEurope1PriceFactory_UDG(udg)

		if (debug) println "---------- adding upg " + rowWrapper.UserModel_upg
		UserPriceGroup upg = enumerations.get(rowWrapper.UserModel_upg)
		user.setEurope1PriceFactory_UPG(upg)

		if (debug) println "---------- adding utg " + rowWrapper.UserModel_utg
		UserTaxGroup utg = enumerations.get(rowWrapper.UserModel_utg)
		user.setEurope1PriceFactory_UTG(utg)

		modelService.saveAll(all)
	}
}