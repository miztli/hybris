
/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hybris.platform.orchestration.OrchestratorException;
import de.hybris.platform.orchestration.http.HttpClientFactory;
import de.hybris.platform.orchestration.http.InMemoryCookieJar;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccInteractionSession {
	private static final Logger logger = LoggerFactory.getLogger(AccInteractionSession.class);

	private final OkHttpClient client;
	private final String rootUrl;
	private final String username;
	private final String password;
	private final String site;
	private final String language;
	private final InMemoryCookieJar cookieJar = new InMemoryCookieJar();

	public AccInteractionSession(final String rootUrl, final String site, final String language, final String username,
			final String password) {
		this.rootUrl = rootUrl;
		this.client = HttpClientFactory.build(cookieJar);
		this.site = site;
		this.language = language;
		this.username = username;
		this.password = password;
	}

	public void logIn() {
		final Response loginPage = getLoginPage();
		final String csrfToken = extractCsrfTokenFromResponse(loginPage);
		final Response loginResponse = sendLogInForm(username, password, csrfToken);
		if (!loginResponse.isSuccessful()) {
			throw new OrchestratorException("Login was not successful!");
		}
	}
	
	public String getCookie(final String cookieId, String path) {
		final List<Cookie> cookies = cookieJar.getCookies();
		if (cookies == null) {
			throw new OrchestratorException("No cookie is set");
		}

		return cookies.stream() //
				.filter(cookie -> cookie.name().equals(cookieId) && cookie.path().equals(path)) //
				.map(cookie -> cookie.value()) //
				.findFirst() //
				.orElseThrow(() -> new OrchestratorException("No cookie with name: " + cookieId));
	}

	public String getNodeNameFromCookie(String path) {
		String jSessionId = getCookie("JSESSIONID", path);
		return StringUtils.substringAfterLast(jSessionId, ".");
	}

	public static AccInteractionSession forUrl(final String rootUrl, final String site, final String language, final String username,
			final String password) {
		return new AccInteractionSession(rootUrl, site, language, username, password);
	}

	public Response getLoginPage() {
		final Request request = new Request.Builder().url(rootUrl + "/" + site + "/" + language + "/" + "login" + "?site=" + site)
				.build();
		try {
			return client.newCall(request).execute();
		} catch (final IOException e) {
			throw new OrchestratorException(e);
		}
	}
	
	public Response getSubPage(String subPageUrl) {
		final Request request = new Request.Builder().url(rootUrl + "/" + site + "/" + language + "/" + subPageUrl + "?site=" + site)
			.build();
		try {
			return client.newCall(request).execute();
		} catch (final IOException e) {
			throw new OrchestratorException(e);
		}		
	}

	public Response sendLogInForm(final String username, final String password, final String csrfToken) {
		final FormBody form = new FormBody.Builder() //
				.add("j_username", username) //
				.add("j_password", password) //
				.add("CSRFToken", csrfToken).build();

		final Request request2 = new Request.Builder().url(rootUrl + "/" + site + "/" + language + "/j_spring_security_check") //
				.post(form) //
				.build();

		try {
			return client.newCall(request2).execute();

		} catch (final IOException e) {
			throw new OrchestratorException(e);
		}
	}

	public String extractCsrfTokenFromResponse(final Response loginPageResponse) {
		final String responseBody;
		try {
			responseBody = loginPageResponse.body().string();
		} catch (final IOException e) {
			throw new OrchestratorException(e);
		}
		return getCsrfToken(responseBody);
	}

	private String getCsrfToken(final String loginPageHtml) {
		final Pattern pattern = Pattern.compile("CSRFToken = \\s*\"([a-z0-9-]*)\"");
		final Matcher matcher = pattern.matcher(loginPageHtml);

		return matcher.find() ? matcher.group(1) : "";
	}
}
