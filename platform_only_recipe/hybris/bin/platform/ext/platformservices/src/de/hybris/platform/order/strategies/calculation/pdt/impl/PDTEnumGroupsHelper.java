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
package de.hybris.platform.order.strategies.calculation.pdt.impl;

import de.hybris.platform.core.HybrisEnumValue;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.enumeration.EnumerationValueModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductDiscountGroup;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.enums.UserDiscountGroup;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.europe1.enums.UserTaxGroup;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.servicelayer.internal.service.AbstractBusinessService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * An utility class for getting price/discount/tax enum values.
 */
public class PDTEnumGroupsHelper extends AbstractBusinessService
{
	private transient TypeService typeService;

	/**
	 * Gets the PK from Hybris Enum.
	 */
	public PK getPkFromEnum(final HybrisEnumValue enumValue)
	{
		final EnumerationValueModel value = typeService.getEnumerationValue(enumValue);
		return value.getPk();
	}

	/**
	 * Gets Products Tax Group for Order Entry.
	 */
	public ProductTaxGroup getPTG(final AbstractOrderEntryModel entry)
	{
		final ProductTaxGroup overridePTG = entry.getEurope1PriceFactory_PTG();
		return overridePTG == null ? getPTG(entry.getProduct()) : overridePTG;
	}

	/**
	 * Gets the Product Tax Group from the Product Model.
	 */
	public ProductTaxGroup getPTG(final ProductModel product)
	{
		return getEnumFromContextOrItem(product, ProductModel.EUROPE1PRICEFACTORY_PTG);
	}

	/**
	 * Gets the Product Price Group from the Product Model.
	 */
	public ProductPriceGroup getPPG(final ProductModel product)
	{
		return getEnumFromContextOrItem(product, ProductModel.EUROPE1PRICEFACTORY_PPG);
	}

	/**
	 * Gets Products Discount Group for Order Entry.
	 */
	public ProductDiscountGroup getPDG(final AbstractOrderEntryModel entry)
	{
		final ProductDiscountGroup overridePDG = entry.getEurope1PriceFactory_PDG();
		return overridePDG == null ? getPDG(entry.getProduct()) : overridePDG;
	}

	/**
	 * Gets the Product Discount Group from the Product Model.
	 */
	public ProductDiscountGroup getPDG(final ProductModel product)
	{
		return getEnumFromContextOrItem(product, ProductModel.EUROPE1PRICEFACTORY_PDG);
	}

	/**
	 * Gets User Tax Group for Order Entry.
	 */
	public UserTaxGroup getUTG(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getUTG(entry.getOrder());
	}

	/**
	 * Gets User Tax Group for Order.
	 */
	public UserTaxGroup getUTG(final AbstractOrderModel order) throws CalculationException
	{
		final UserTaxGroup overrideUTG = order.getEurope1PriceFactory_UTG();
		return overrideUTG == null ? getUTG(order.getUser()) : overrideUTG;
	}

	/**
	 * Gets the User Tax Group from the User Model.
	 */
	public UserTaxGroup getUTG(final UserModel user) throws CalculationException
	{
		final UserTaxGroup enumerationValue = getEnumFromContextOrItem(user, UserModel.EUROPE1PRICEFACTORY_UTG);
		return enumerationValue != null ? enumerationValue : getEnumFromGroups(user, UserGroupModel.USERTAXGROUP);
	}

	/**
	 * Gets User Discount Group for Order Entry.
	 */
	public UserDiscountGroup getUDG(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getUDG(entry.getOrder());
	}

	/**
	 * Gets User Discount Group for Order.
	 */
	public UserDiscountGroup getUDG(final AbstractOrderModel order) throws CalculationException
	{
		final UserDiscountGroup overrideUDG = order.getEurope1PriceFactory_UDG();
		return overrideUDG == null ? getUDG(order.getUser()) : overrideUDG;
	}

	/**
	 * Gets the User Discount Group from the User Model.
	 */
	public UserDiscountGroup getUDG(final UserModel user) throws CalculationException
	{
		final UserDiscountGroup enumerationValue = getEnumFromContextOrItem(user, UserModel.EUROPE1PRICEFACTORY_UDG);
		return enumerationValue != null ? enumerationValue : getEnumFromGroups(user, UserGroupModel.USERDISCOUNTGROUP);
	}

	/**
	 * Gets the UserPriceGroup from Order Entry.
	 *
	 * @param entry
	 *           the order entry
	 * @return the user price group
	 * @throws CalculationException
	 *            the calculation exception
	 */
	public UserPriceGroup getUPG(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getUPG(entry.getOrder());
	}

	protected UserPriceGroup getUPG(final AbstractOrderModel order) throws CalculationException
	{
		final UserPriceGroup overrideUPG = order.getEurope1PriceFactory_UPG();
		return overrideUPG == null ? getUPG(order.getUser()) : overrideUPG;
	}

	/**
	 * Gets the User Price Group from the User Model.
	 */
	public UserPriceGroup getUPG(final UserModel user) throws CalculationException
	{
		final UserPriceGroup enumerationValue = getEnumFromContextOrItem(user, UserModel.EUROPE1PRICEFACTORY_UPG);
		return enumerationValue != null ? enumerationValue : getEnumFromGroups(user, UserGroupModel.USERPRICEGROUP);
	}

	protected <T extends HybrisEnumValue> T getEnumFromContextOrItem(final ItemModel item, final String qualifier)
	{
		HybrisEnumValue enumerationValue = getSessionService().getAttribute(qualifier);
		if (enumerationValue == null)
		{
			enumerationValue = item != null ? item.getProperty(qualifier) : null;
		}
		return (T) enumerationValue;
	}

	/**
	 * Tries to find enums connected with User or its User Groups.
	 */
	protected <T extends HybrisEnumValue> T getEnumFromGroups(final UserModel user, final String attribute)
			throws CalculationException
	{
		HybrisEnumValue enumerationValue = null;
		final Set controlSet = new HashSet();
		Collection<PrincipalGroupModel> groups = user.getGroups();
		while (enumerationValue == null && !groups.isEmpty())
		{
			final Collection<PrincipalGroupModel> nextGroups = new HashSet();
			for (final PrincipalGroupModel userGroup : groups)
			{
				controlSet.add(userGroup);
				final HybrisEnumValue ugValue = userGroup.getProperty(attribute);
				if (ugValue != null)
				{
					enumerationValue = validateEnumerationValue(user, attribute, enumerationValue, groups, ugValue);
				}
				else if (enumerationValue == null) // fill up next group level if no value was found yet
				{
					nextGroups.addAll(userGroup.getGroups());
				}
			}
			// set next groups collection as current groups if no value was found yet
			if (enumerationValue == null)
			{
				nextGroups.removeAll(controlSet);
				groups = nextGroups;
			}
		}
		return (T) enumerationValue;
	}

	private static HybrisEnumValue validateEnumerationValue(final UserModel user, final String attribute,
			final HybrisEnumValue enumerationValue, final Collection<PrincipalGroupModel> groups, final HybrisEnumValue ugValue)
			throws CalculationException
	{
		// already found one within this level ?
		if (enumerationValue != null && !ugValue.equals(enumerationValue))
		{
			throw new CalculationException("multiple " + attribute + " values found for user " + user.getUid() + " from its groups "
					+ groups + " : " + enumerationValue.getCode() + " != " + ugValue.getCode());
		}
		return ugValue;
	}

	/**
	 * @param typeService
	 *           the typeService to set
	 */
	public void setTypeService(final TypeService typeService)
	{
		this.typeService = typeService;
	}
}
