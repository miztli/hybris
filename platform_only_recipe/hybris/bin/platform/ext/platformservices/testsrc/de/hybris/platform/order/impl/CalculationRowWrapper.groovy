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

import de.hybris.platform.util.Config

public class CalculationRowWrapper
{
	private static boolean debug = Config.getBoolean("debug.calculation.test", false)
	
	public ProductModel_unit
	public ProductModel_priceQuantity
	public ProductModel_ppg
	public ProductModel_ptg
	public ProductModel_pdg
	public PriceRowModel1_exists
	public PriceRowModel_currency
	public PriceRowModel_net
	public PriceRowModel_unit
	public PriceRowModel_value
	public PriceRowModel_unitFactor
	public PriceRowModel_giveAwayPrice
	public PriceRowModel2_exists
	public PriceRowModel2_value
	public PriceRowModel2_currency
	public PriceRowModel2_unit
	public PriceRowModel2_net
	public PriceRowModel2_unitFactor
	public PriceRowModel2_giveAwayPrice
	public OrderModel_currency
	public OrderModel_deliveryCost
	public OrderModel_paymentCost
	public OrderModel_net
	public UserModel_udg
	public UserModel_upg
	public UserModel_utg
	public TaxRowModel1_exists
	public TaxRowModel1_value
	public TaxRowModel1_currency
	public TaxRowModel1_TaxModel_value
	public TaxRowModel1_TaxModel_currency
	public TaxRowModel2_exists
	public TaxRowModel2_value
	public TaxRowModel2_currency
	public TaxRowModel2_TaxModel_value
	public TaxRowModel2_TaxModel_currency
	public DiscountModelToOrder1_exists
	public DiscountModelToOrder1_currency
	public DiscountModelToOrder1_value
	public DiscountModelToOrder1_global
	public DiscountModelToOrder2_exists
	public DiscountModelToOrder2_currency
	public DiscountModelToOrder2_value
	public DiscountModelToOrder2_global
	public DiscountRowModel1_exists
	public DiscountRowModel1_value
	public DiscountRowModel1_currency
	public DiscountRowModel1_asTargetPrice
	public DiscountRowModel1_pg
	public DiscountRowModel1_ug
	public DiscountRowModel2_exists
	public DiscountRowModel2_value
	public DiscountRowModel2_currency
	public DiscountRowModel2_asTargetPrice
	public DiscountRowModel2_pg
	public DiscountRowModel2_ug
	
	
	def prepareGiven(row) {
		ProductModel_unit = row.get("ProductModel.unit")
		ProductModel_priceQuantity = row.get("ProductModel.priceQuantity")
		ProductModel_ppg = row.get("ProductModel.ppg")
		ProductModel_ptg = row.get("ProductModel.ptg")
		ProductModel_pdg = row.get("ProductModel.pdg")
		
		PriceRowModel1_exists = row.get("PriceRowModel1.exists")
		PriceRowModel_currency = row.get("PriceRowModel1.params.currency")
		PriceRowModel_net = row.get("PriceRowModel1.params.net")
		PriceRowModel_unit = row.get("PriceRowModel1.params.unit")
		PriceRowModel_value = row.get("PriceRowModel1.params.value")
		PriceRowModel_unitFactor = row.get("PriceRowModel1.params.unitFactor")
		PriceRowModel_giveAwayPrice = row.get("PriceRowModel1.params.giveAwayPrice")
		
		PriceRowModel2_exists = row.get("PriceRowModel2.exists")
		PriceRowModel2_value = row.get("PriceRowModel2.params.value")
		PriceRowModel2_currency = row.get("PriceRowModel2.params.currency")
		PriceRowModel2_unit = row.get("PriceRowModel2.params.unit")
		PriceRowModel2_net = row.get("PriceRowModel2.params.net")
		PriceRowModel2_unitFactor = row.get("PriceRowModel2.params.unitFactor")
		PriceRowModel2_giveAwayPrice = row.get("PriceRowModel2.params.giveAwayPrice")
		
		OrderModel_currency = row.get("OrderModel.currency")
		OrderModel_deliveryCost = row.get("OrderModel.deliveryCost")
		OrderModel_paymentCost = row.get("OrderModel.paymentCost")
		OrderModel_net = row.get("OrderModel.net")
		
		UserModel_udg = row.get("UserModel.udg")
		UserModel_upg = row.get("UserModel.upg")
		UserModel_utg = row.get("UserModel.utg")
		
		TaxRowModel1_exists = row.get("TaxRowModel1.exists")
		TaxRowModel1_value = row.get("TaxRowModel1.params.value")
		TaxRowModel1_currency = row.get("TaxRowModel1.params.currency")
		
		TaxRowModel1_TaxModel_value = row.get("TaxRowModel1.params.TaxModel.value")
		TaxRowModel1_TaxModel_currency = row.get("TaxRowModel1.params.TaxModel.currency")
		
		TaxRowModel2_exists = row.get("TaxRowModel2.exists")
		TaxRowModel2_value = row.get("TaxRowModel2.params.value")
		TaxRowModel2_currency = row.get("TaxRowModel2.params.currency")
		
		TaxRowModel2_TaxModel_value = row.get("TaxRowModel2.params.TaxModel.value")
		TaxRowModel2_TaxModel_currency = row.get("TaxRowModel2.params.TaxModel.currency")
	
		DiscountModelToOrder1_exists = row.get("DiscountModelToOrder1.exists")
		DiscountModelToOrder1_currency = row.get("DiscountModelToOrder1.params.currency")
		DiscountModelToOrder1_value = row.get("DiscountModelToOrder1.params.value")
		DiscountModelToOrder1_global = row.get("DiscountModelToOrder1.params.global")
		
		DiscountModelToOrder2_exists = row.get("DiscountModelToOrder2.exists")
		DiscountModelToOrder2_currency = row.get("DiscountModelToOrder2.params.currency")
		DiscountModelToOrder2_value = row.get("DiscountModelToOrder2.params.value")
		DiscountModelToOrder2_global = row.get("DiscountModelToOrder2.params.global")
		
		DiscountRowModel1_exists = row.get("DiscountRowModel1.exists")
		DiscountRowModel1_value = row.get("DiscountRowModel1.params.value")
		DiscountRowModel1_currency = row.get("DiscountRowModel1.params.currency")
		DiscountRowModel1_asTargetPrice = row.get("DiscountRowModel1.params.asTargetPrice")
		DiscountRowModel1_pg = row.get("DiscountRowModel1.params.pg")
		DiscountRowModel1_ug = row.get("DiscountRowModel1.params.ug")
		
		DiscountRowModel2_exists = row.get("DiscountRowModel2.exists")
		DiscountRowModel2_value = row.get("DiscountRowModel2.params.value")
		DiscountRowModel2_currency = row.get("DiscountRowModel2.params.currency")
		DiscountRowModel2_asTargetPrice = row.get("DiscountRowModel2.params.asTargetPrice")
		DiscountRowModel2_pg = row.get("DiscountRowModel2.params.pg")
		DiscountRowModel2_ug = row.get("DiscountRowModel2.params.ug")
		
		ProductModel_priceQuantity = getIntegerValue(ProductModel_priceQuantity, 1)
		if (debug) println " > ProductModel_priceQuantity set to: " + ProductModel_priceQuantity

		PriceRowModel1_exists = getBooleanValue(PriceRowModel1_exists)
		if (debug) println " > PriceRowModel1_exists set to: " + PriceRowModel1_exists

		if (PriceRowModel1_exists) {
			PriceRowModel_value = getDoubleValue(PriceRowModel_value)
			if (debug) println " > PriceRowModel_value set to: " + PriceRowModel_value

			PriceRowModel_net = getBooleanValue(PriceRowModel_net)
			if (debug) println " > PriceRowModel_net set to: " + PriceRowModel_net

			PriceRowModel_unitFactor = getIntegerValue(PriceRowModel_unitFactor)
			if (debug) println " > PriceRowModel_unitFactor set to: " + PriceRowModel_unitFactor

			PriceRowModel_giveAwayPrice = getBooleanValue(PriceRowModel_giveAwayPrice)
			if (debug) println " > PriceRowModel_giveAwayPrice set to: " + PriceRowModel_giveAwayPrice
		}

		PriceRowModel2_exists = getBooleanValue(PriceRowModel2_exists)
		if (debug) println " > PriceRowModel2_exists set to: " + PriceRowModel2_exists

		if (PriceRowModel2_exists) {
			PriceRowModel2_value = getDoubleValue(PriceRowModel2_value)
			if (debug) println " > PriceRowModel2_value set to: " + PriceRowModel2_value
			
			PriceRowModel2_net = getBooleanValue(PriceRowModel2_net)
			if (debug) println " > PriceRowModel2_net set to: " + PriceRowModel2_net

			PriceRowModel2_unitFactor = getIntegerValue(PriceRowModel2_unitFactor)
			if (debug) println " > PriceRowModel2_unitFactor set to: " + PriceRowModel2_unitFactor

			PriceRowModel2_giveAwayPrice = getBooleanValue(PriceRowModel2_giveAwayPrice)
			if (debug) println " > PriceRowModel2_giveAwayPrice set to: " + PriceRowModel2_giveAwayPrice
		}

		OrderModel_deliveryCost = getDoubleValue(OrderModel_deliveryCost)
		if (debug) println " > OrderModel_deliveryCost set to: " + OrderModel_deliveryCost

		OrderModel_paymentCost = getDoubleValue(OrderModel_paymentCost)
		if (debug) println " > OrderModel_paymentCost set to: " + OrderModel_paymentCost

		OrderModel_net = getBooleanValue(OrderModel_net)
		if (debug) println " > OrderModel_net set to: " + OrderModel_net

		TaxRowModel1_exists = getBooleanValue(TaxRowModel1_exists)
		if (debug) println " > TaxRowModel1_exists set to: " + TaxRowModel1_exists

		if (TaxRowModel1_exists) {
			TaxRowModel1_value = getDoubleValue(TaxRowModel1_value)
			if (debug) println " > TaxRowModel1_value set to: " + TaxRowModel1_value

			TaxRowModel1_TaxModel_value = getDoubleValue(TaxRowModel1_TaxModel_value)
			if (debug) println " > TaxRowModel1_TaxModel_value set to: " + TaxRowModel1_TaxModel_value
		}

		TaxRowModel2_exists = getBooleanValue(TaxRowModel2_exists)
		if (debug) println " > TaxRowModel2_exists set to: " + TaxRowModel2_exists

		if (TaxRowModel2_exists) {
			TaxRowModel2_value = getDoubleValue(TaxRowModel2_value)
			if (debug) println " > TaxRowModel2_value set to: " + TaxRowModel2_value

			TaxRowModel2_TaxModel_value = getDoubleValue(TaxRowModel2_TaxModel_value)
			if (debug) println " > TaxRowModel2_TaxModel_value set to: " + TaxRowModel2_TaxModel_value
		}

		DiscountModelToOrder1_exists = getBooleanValue(DiscountModelToOrder1_exists)
		if (debug) println " > DiscountModelToOrder1_exists set to: " + DiscountModelToOrder1_exists

		if (DiscountModelToOrder1_exists) {
			DiscountModelToOrder1_value = getDoubleValue(DiscountModelToOrder1_value)
			if (debug) println " > DiscountModelToOrder1_value set to: " + DiscountModelToOrder1_value

			DiscountModelToOrder1_global = getBooleanValue(DiscountModelToOrder1_global)
			if (debug) println " > DiscountModelToOrder1_global set to: " + DiscountModelToOrder1_global
		}

		DiscountModelToOrder2_exists = getBooleanValue(DiscountModelToOrder2_exists)
		if (debug) println " > DiscountModelToOrder2_exists set to: " + DiscountModelToOrder2_exists

		if (DiscountModelToOrder2_exists) {
			DiscountModelToOrder2_value = getDoubleValue(DiscountModelToOrder2_value)
			if (debug) println " > DiscountModelToOrder2_value set to: " + DiscountModelToOrder2_value

			DiscountModelToOrder2_global = getBooleanValue(DiscountModelToOrder2_global)
			if (debug) println " > DiscountModelToOrder2_global set to: " + DiscountModelToOrder2_global
		}

		DiscountRowModel1_exists = getBooleanValue(DiscountRowModel1_exists)
		if (debug) println " > DiscountRowModel1_exists set to: " + DiscountRowModel1_exists

		if (DiscountRowModel1_exists) {
			DiscountRowModel1_value = getDoubleValue(DiscountRowModel1_value)
			if (debug) println " > DiscountRowModel1_value set to: " + DiscountRowModel1_value

			DiscountRowModel1_asTargetPrice = getBooleanValue(DiscountRowModel1_asTargetPrice)
			if (debug) println " > DiscountRowModel1_asTargetPrice set to: " + DiscountRowModel1_asTargetPrice
		}

		DiscountRowModel2_exists = getBooleanValue(DiscountRowModel2_exists)
		if (debug) println " > DiscountRowModel2_exists set to: " + DiscountRowModel2_exists

		if (DiscountRowModel2_exists) {
			DiscountRowModel2_value = getDoubleValue(DiscountRowModel2_value)
			if (debug) println " > DiscountRowModel2_value set to: " + DiscountRowModel2_value

			DiscountRowModel2_asTargetPrice = getBooleanValue(DiscountRowModel2_asTargetPrice)
			if (debug) println " > DiscountRowModel2_asTargetPrice set to: " + DiscountRowModel2_asTargetPrice
		}
	}
	
	def getBooleanValue(String name) {
		def value = false
		value = Boolean.parseBoolean(name)
		return value
	}
	
	def getIntegerValue(String name, Integer defaultValue = null) {
		def value = null
		try {
			value = Integer.parseInt(name)
		} catch (NumberFormatException | NullPointerException e) {
			value = defaultValue
		}
		return value
	}
	
	def getDoubleValue(String name, Double defaultValue = null) {
		def value = null
		try {
			value = Double.parseDouble(name)
		} catch (NumberFormatException | NullPointerException e) {
			value = defaultValue
		}
		return value
	}
}