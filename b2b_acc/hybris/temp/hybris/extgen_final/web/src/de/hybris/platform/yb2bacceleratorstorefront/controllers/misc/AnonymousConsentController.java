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
package de.hybris.platform.yb2bacceleratorstorefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.consent.data.ConsentCookieData;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Controller for managing Anonymous Consent Cookie
 *
 */
@Controller
@RequestMapping("/anonymous-consent")
public class AnonymousConsentController extends AbstractPageController
{
	private static final String TEXT_ACCOUNT_CONSENT_TEMPLATE_NOT_FOUND = "text.account.consent.template.notFound";
	private static final Logger LOGGER = Logger.getLogger(AnonymousConsentController.class);
	private static final ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/{consentTemplateId}", method = RequestMethod.POST)
	public ResponseEntity giveConsent(@PathVariable final String consentTemplateId, @RequestParam final String consentState,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		final Cookie anonymousConsentCookie = WebUtils.getCookie(request, WebConstants.ANONYMOUS_CONSENT_COOKIE);

		try
		{
			final List<ConsentCookieData> consentCookieDataList = new ArrayList(Arrays
					.asList(mapper.readValue(URLDecoder.decode(anonymousConsentCookie.getValue(), UTF_8), ConsentCookieData[].class)));
			final List<ConsentCookieData> updatedList = consentCookieDataList.stream().map(consentCookieData -> {
				if (consentCookieData.getTemplateCode().equals(consentTemplateId))
				{
					consentCookieData.setConsentState(consentState);
				}
				return consentCookieData;
			}).collect(Collectors.toList());

			final String cookieValue = mapper.writeValueAsString(updatedList);
			final Cookie updatedAnonymousConsentCookie = new Cookie(WebConstants.ANONYMOUS_CONSENT_COOKIE,
					URLEncoder.encode(cookieValue, UTF_8));
			updatedAnonymousConsentCookie.setPath("/");
			updatedAnonymousConsentCookie.setSecure(true);
			updatedAnonymousConsentCookie.setHttpOnly(true);
			updatedAnonymousConsentCookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(365));
			response.addCookie(updatedAnonymousConsentCookie);
		}
		catch (final UnsupportedEncodingException e)
		{
			LOGGER.error("UnsupportedEncodingException occurred while decoding the Anonymous Consent Cookie", e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		catch (final IOException e)
		{
			LOGGER.error("IOException occured while reading the Anonymous Consent Cookie", e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

}
