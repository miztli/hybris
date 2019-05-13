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
package de.hybris.platform.webservicescommons.oauth2.token.provider;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;
import de.hybris.platform.webservicescommons.oauth2.token.provider.HybrisOAuthTokenStoreTest.MockAuthentication;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import com.google.common.collect.Sets;



@IntegrationTest
public class TokenServicesTest extends ServicelayerTransactionalTest
{
	private static final String ADMIN_USER = "admin";
	private static final String TEST_SCOPE = "test_scope";
	private static final String CLIENT_ID = "test_client";

	private static final int ACCESS_TOKEN_VALIDITY_SECONDS = 100;

	@Resource
	private AuthorizationServerTokenServices oauthTokenServices;

	@Resource
	private ModelService modelService;

	@Before
	public void setup()
	{
		final OAuthClientDetailsModel client = new OAuthClientDetailsModel();
		client.setClientId(CLIENT_ID);
		client.setAccessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS);
		modelService.save(client);
	}

	@Test
	public void testCreateAccessToken()
	{
		final OAuth2AccessToken token = oauthTokenServices.createAccessToken(createAuthentication());

		assertThat(token).isNotNull();
		assertThat(token.getExpiresIn()).isLessThanOrEqualTo(ACCESS_TOKEN_VALIDITY_SECONDS);
		assertThat(token.getScope().size()).isEqualTo(1);
		assertThat(token.getScope()).contains(TEST_SCOPE);
	}

	protected OAuth2Authentication createAuthentication()
	{
		final Authentication authentication = new MockAuthentication(ADMIN_USER, false);

		final OAuth2Authentication oauthAuthentication = new OAuth2Authentication(
				new OAuth2Request(null, CLIENT_ID, null, true, Sets.newHashSet(TEST_SCOPE), null, null, null, null), authentication);

		return oauthAuthentication;
	}
}
