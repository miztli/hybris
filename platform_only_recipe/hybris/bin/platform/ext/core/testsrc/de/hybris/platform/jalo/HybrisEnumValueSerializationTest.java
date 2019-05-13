/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.jalo;

import com.google.common.collect.Lists;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.enums.GroupType;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.order.EntryGroup;
import de.hybris.platform.jalo.order.Cart;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@IntegrationTest
public class HybrisEnumValueSerializationTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private UserService userService;
	@Resource
	private CommonI18NService commonI18NService;
	public static final String ENUM_VALUE = "ENUM_VALUE";

	@Test
	public void saveAndReadCartShouldDeserializeEnumsProperly()
	{
		//given
		final EntryGroup entryGroup = new EntryGroup();
		final GroupType groupType = GroupType.valueOf(ENUM_VALUE);
		entryGroup.setGroupType(groupType);
		final List<EntryGroup> entryGroups = Lists.newArrayList(entryGroup);
		final CartModel cart = modelService.create(CartModel.class);
		cart.setEntryGroups(entryGroups);
		cart.setCurrency(commonI18NService.getBaseCurrency());
		cart.setDate(new Date());
		cart.setUser(userService.getCurrentUser());

		//when
		modelService.save(cart);

		//then
		final List<Cart> carts = JaloSession.getCurrentSession().getFlexibleSearch()
				.search(//
						"SELECT {" + "pk" + "} " + //
								"FROM {Cart} ",
						Cart.class //
				).getResult();

		assertThat(carts.size()).isEqualTo(1);
		final GroupType deserializedGroupType = carts.get(0).getEntryGroups().get(0).getGroupType();
		assertThat(deserializedGroupType).isEqualTo(groupType);
		assertThat(deserializedGroupType == groupType).isTrue();
	}
}
