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

package de.hybris.platform.order.strategies.calculation.pdt.query.impl;

import de.hybris.platform.core.PK;
import de.hybris.platform.europe1.jalo.PDTRowsQueryBuilder;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.impl.PDTEnumGroupsHelper;
import de.hybris.platform.order.strategies.calculation.pdt.query.PDTQueryProvider;

import org.springframework.beans.factory.annotation.Required;


public class DefaultTaxQueryProvider implements PDTQueryProvider<TaxValueInfoCriteria>
{
	private PDTEnumGroupsHelper pdtEnumGroupsHelper;

	@Override
	public PDTRowsQueryBuilder.QueryWithParams query(final TaxValueInfoCriteria criteria)
	{
		final PK productPk = criteria.getProduct() == null ? null : criteria.getProduct().getPk();
		final PK productGroupPk = criteria.getProductGroup() == null ? null
				: pdtEnumGroupsHelper.getPkFromEnum(criteria.getProductGroup());
		final PK userPk = criteria.getUser() == null ? null : criteria.getUser().getPk();

		final PK userGroupPk = criteria.getUserGroup() == null ? null : pdtEnumGroupsHelper.getPkFromEnum(criteria.getUserGroup());
		final String productId = criteria.getProduct() == null ? null : criteria.getProduct().getCode();

		final PDTRowsQueryBuilder builder = PDTRowsQueryBuilder.defaultBuilder(TaxRowModel._TYPECODE);

		return builder.withAnyProduct().withAnyUser().withProduct(productPk).withProductGroup(productGroupPk)
				.withProductId(productId).withUser(userPk).withUserGroup(userGroupPk).build();
	}

	@Required
	public void setPdtEnumGroupsHelper(final PDTEnumGroupsHelper pdtEnumGroupsHelper)
	{
		this.pdtEnumGroupsHelper = pdtEnumGroupsHelper;
	}
}
