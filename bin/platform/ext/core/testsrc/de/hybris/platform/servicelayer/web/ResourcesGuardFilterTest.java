package de.hybris.platform.servicelayer.web;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class ResourcesGuardFilterTest
{
	private static final String EXT_NAME = "foobar";
	private static final String REDIRECT_TO = "/404.jsp";
	private static final String WEB_APP_CTX = "/webapp";

	@Mock
	private ResourcesGuardService guardService;
	@Mock
	private HttpServletRequest httpRequest;
	@Mock
	private HttpServletResponse httpResponse;
	@Mock
	private FilterChain chain;
	@Mock
	private ServletContext servletContext;
	private ResourcesGuardFilter filter;

	@Before
	public void setUp() throws Exception
	{
		filter = new ResourcesGuardFilter();
		filter.setResourcesGuardService(guardService);
		filter.setExtensionName(EXT_NAME);
		given(httpRequest.getServletContext()).willReturn(servletContext);
		given(servletContext.getContextPath()).willReturn("/webapp");
	}

	@Test
	public void shouldProcessFilterChainWhenResourceIsEnabled() throws Exception
	{
		// given
		final String resource = "/foo/bar/baz";
		given(httpRequest.getRequestURI()).willReturn(WEB_APP_CTX + resource);
		given(guardService.isResourceEnabled(EXT_NAME, resource)).willReturn(Boolean.TRUE);

		// when
		filter.doFilter(httpRequest, httpResponse, chain);

		// then
		verify(httpResponse, times(0)).setStatus(HttpServletResponse.SC_NOT_FOUND);
		verify(httpResponse, times(0)).sendRedirect(REDIRECT_TO);
		verify(chain, times(1)).doFilter(httpRequest, httpResponse);
	}

	@Test
	public void shouldSendNotFoundCodeIfResourceIsDisabled() throws Exception
	{
		// given
		final String resource = "/foo/bar/baz";
		given(httpRequest.getRequestURI()).willReturn(WEB_APP_CTX + resource);
		given(guardService.isResourceEnabled(EXT_NAME, resource)).willReturn(Boolean.FALSE);

		// when
		filter.doFilter(httpRequest, httpResponse, chain);

		// then
		verify(httpResponse, times(1)).setStatus(HttpServletResponse.SC_NOT_FOUND);
		verify(httpResponse, times(0)).sendRedirect(REDIRECT_TO);
		verify(chain, times(0)).doFilter(httpRequest, httpResponse);
	}
	
	@Test
	public void shouldSendRedirectIfResourceIsDisabledAndFilterIsConfiguredForHandlingRedirects() throws Exception
	{
		// given
		filter.setReditectTo(REDIRECT_TO);
		final String resource = "/foo/bar/baz";
		given(httpRequest.getRequestURI()).willReturn(WEB_APP_CTX + resource);
		given(guardService.isResourceEnabled(EXT_NAME, resource)).willReturn(Boolean.FALSE);

		// when
		filter.doFilter(httpRequest, httpResponse, chain);

		// then
		verify(httpResponse, times(0)).setStatus(HttpServletResponse.SC_NOT_FOUND);
		verify(httpResponse, times(1)).sendRedirect(REDIRECT_TO);
		verify(chain, times(0)).doFilter(httpRequest, httpResponse);
	}
}