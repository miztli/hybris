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
package de.hybris.platform.spring.security;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.user.CookieBasedLoginToken;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


@IntegrationTest
public class CoreRememberMeServiceTest extends ServicelayerTransactionalBaseTest
{
	public static final String EN_ISO_CODE = "en";
	public static final String TOKEN_LANGUAGE_ISO_CODE = "ab";
	public static final String USER_DETAILS_LANGUAGE_ISO_CODE = "cd";
	public static final String REQUEST_LANGUAGE_ISO_CODE = "ko-KR";

	@Mock
	private CookieBasedLoginToken token;
	@Mock
	private Language tokenLanguage;
	@Mock
	private UserDetailsService userDetailsService;
	@Mock
	private CoreUserDetails userDetails;
	@Mock
	private HttpServletRequest httpServletRequest;

	@Spy
	private CoreRememberMeService rememberMeService;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		final User user = JaloSession.getCurrentSession().getUser();
		doReturn(userDetailsService).when(rememberMeService).lookupUserDetailsService();

		when(token.getUser()).thenReturn(user);
		when(userDetailsService.loadUserByUsername(any(String.class))).thenReturn(userDetails);
		when(userDetails.getLanguageISO()).thenReturn(USER_DETAILS_LANGUAGE_ISO_CODE);

		when(token.getLanguage()).thenReturn(tokenLanguage);
		when(tokenLanguage.getIsocode()).thenReturn(TOKEN_LANGUAGE_ISO_CODE);

		when(httpServletRequest.getLocale()).thenReturn(Locale.KOREA);
	}

	@Test
	public void processAutoLoginCookieShouldReturnUserDetails()
	{
		//when
		when(token.getLanguage()).thenReturn(tokenLanguage);
		when(tokenLanguage.getIsocode()).thenReturn(EN_ISO_CODE);

		//when
		final UserDetails result = rememberMeService.processAutoLoginCookie(token, null, null);

		//then
		assertThat(result).isNotNull();
	}

	@Test
	public void shouldReturnTokenLanguage()
	{
		//when
		final String result = rememberMeService.getLanguageIsoCode(userDetails, token, null);

		//then
		assertThat(result).isEqualTo(TOKEN_LANGUAGE_ISO_CODE);
	}

	@Test
	public void shouldReturnUserDetailsLanguage()
	{
		//when
		final String result = rememberMeService.getLanguageIsoCode(userDetails, null, null);

		//then
		assertThat(result).isEqualTo(USER_DETAILS_LANGUAGE_ISO_CODE);
	}

	@Test
	public void shouldReturnHttpRequestLanguage()
	{
		//given
		when(userDetails.getLanguageISO()).thenReturn(null);
		when(token.getLanguage()).thenReturn(null);

		//when
		final String result = rememberMeService.getLanguageIsoCode(userDetails, token, httpServletRequest);

		//then
		assertThat(result).isEqualTo(REQUEST_LANGUAGE_ISO_CODE);
	}

	@Test
	public void shouldReturnTenantDefaultLanguage()
	{
		//given
		when(userDetails.getLanguageISO()).thenReturn(null);
		when(token.getLanguage()).thenReturn(null);
		when(httpServletRequest.getLocale()).thenReturn(null);
		final Language expectedLanguage = C2LManager.getInstance().getDefaultLanguageForTenant(Registry.getCurrentTenant());

		//when
		final String result = rememberMeService.getLanguageIsoCode(userDetails, token, httpServletRequest);

		//then
		assertThat(result).isEqualTo(expectedLanguage.getIsocode());
	}
}