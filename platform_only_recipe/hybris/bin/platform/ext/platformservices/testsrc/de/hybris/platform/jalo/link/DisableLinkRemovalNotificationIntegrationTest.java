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
package de.hybris.platform.jalo.link;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.deliveryzone.model.ZoneModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
public class DisableLinkRemovalNotificationIntegrationTest extends ServicelayerBaseTest
{
    @Resource
    private SessionService sessionService;

    @Resource
    private ModelService modelService;

    @Test
    public void shouldDisableLinkRemovalNotifications() {

        //given
        sessionService.setAttribute(LinkManager.DISABLE_LINK_REMOVAL_NOTIFICATION,Boolean.TRUE);
        final UserModel user = modelService.create(UserModel.class);
        user.setUid(UUID.randomUUID().toString());
        modelService.save(user);

        final PrincipalGroupModel group = modelService.create(UserGroupModel.class);
        group.setUid(UUID.randomUUID().toString());
        modelService.save(group);
        final Set<PrincipalGroupModel> groups = new HashSet<>();
        groups.add(group);
        user.setGroups(groups);
        modelService.save(user);
        modelService.refresh(group);
        final Date modificationTimeBefore = group.getModifiedtime();

        //when
        modelService.remove(user);
        modelService.refresh(group);

        //then
        assertThat(modificationTimeBefore).isEqualTo(group.getModifiedtime());
    }

    @Test
    public void shouldEnableLinkRemovalNotifications() {

        //given
        sessionService.setAttribute(LinkManager.DISABLE_LINK_REMOVAL_NOTIFICATION,Boolean.FALSE);
        final UserModel user = modelService.create(UserModel.class);
        user.setUid(UUID.randomUUID().toString());
        modelService.save(user);

        final PrincipalGroupModel group = modelService.create(UserGroupModel.class);
        group.setUid(UUID.randomUUID().toString());
        modelService.save(group);
        final Set<PrincipalGroupModel> groups = new HashSet<>();
        groups.add(group);
        user.setGroups(groups);
        modelService.save(user);
        modelService.refresh(group);
        final Date modificationTimeBefore = group.getModifiedtime();

        //when
        modelService.remove(user);
        modelService.refresh(group);

        //then
        assertThat(modificationTimeBefore).isBefore(group.getModifiedtime());
    }
}
