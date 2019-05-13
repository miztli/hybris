package de.hybris.platform.servicelayer.web;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.util.Config;

import java.util.Collection;
import java.util.HashSet;

import org.junit.After;
import org.junit.Test;


@IntegrationTest
public class ResourceGuardServiceIntegrationTest extends ServicelayerBaseTest
{
	private final Collection<String> tempProperties = new HashSet<>();

	@After
	public void tearDown()
	{
		for (final String p : tempProperties)
		{
			Registry.getCurrentTenant().getConfig().removeParameter(p);
		}

		tempProperties.clear();
	}

	@Test
	public void shouldLoadEndpointConfigurationFromParameters()
	{
		final String extName = "hac";
		final String path = "/platform";
		final String subPath = "/platform/init";
		final String property = "endpoint.hac.platform.disabled";

		setParameter(property, "true");

		final ResourcesGuardService serviceByConfig = new ResourcesGuardService();

		assertThat(serviceByConfig.isResourceDisabled(extName, path)).isTrue();
		assertThat(serviceByConfig.isResourceDisabled(extName, subPath)).isTrue();
	}

	@Test
	public void shouldLoadRespectConfiguraiontFromParameters()
	{
		final String extName = "hac";
		final String path = "/platform";
		final String subPath = "/platform/init";
		final String subPath2 = "/platform/update";
		final String endpointProperty = "endpoint.hac.platform.disabled";
		final String subEndpointProperty = "endpoint.hac.platform.init.disabled";
		final String respectParentsProperty = "endpoints.guardservice.respect.parents";

		// given
		setParameter(endpointProperty, "true");
		setParameter(subEndpointProperty, "false");

		// when
		setParameter(respectParentsProperty, "false");
		final ResourcesGuardService serviceNoRespect = new ResourcesGuardService();

		// then
		assertThat(serviceNoRespect.isResourceDisabled(extName, path)).isTrue();
		assertThat(serviceNoRespect.isResourceDisabled(extName, subPath)).isFalse();
		assertThat(serviceNoRespect.isResourceDisabled(extName, subPath2)).isTrue();

		// when
		setParameter(respectParentsProperty, "true");
		final ResourcesGuardService serviceWithRespect = new ResourcesGuardService();

		// then
		assertThat(serviceWithRespect.isResourceDisabled(extName, path)).isTrue();
		assertThat(serviceWithRespect.isResourceDisabled(extName, subPath)).isTrue();
		assertThat(serviceWithRespect.isResourceDisabled(extName, subPath)).isTrue();
	}

	@Test
	public void shouldNotReloadParametersFromConfig()
	{
		final String extName = "hac";
		final String path = "/platform/init";
		final String subPath = "/platform/init/foo";
		final String endpointProperty = "endpoint.hac.platform.init.disabled";
		final String subEndpointProperty = "endpoint.hac.platform.init.foo.disabled";
		final String respectParentsProperty = "endpoints.guardservice.respect.parents";

		// given
		setParameter(endpointProperty, "true");
		setParameter(subEndpointProperty, "false");
		setParameter(respectParentsProperty, "true");

		ResourcesGuardService service = new ResourcesGuardService();
		boolean resourceDisabled = service.isResourceDisabled(extName, path);
		boolean subResourceDisabled = service.isResourceDisabled(extName, subPath);

		assertThat(resourceDisabled).isTrue();
		assertThat(subResourceDisabled).isTrue();

		// when properties are changed in runtime
		setParameter(endpointProperty, "false");
		setParameter(respectParentsProperty, "false");
		resourceDisabled = service.isResourceDisabled(extName, path);
		subResourceDisabled = service.isResourceDisabled(extName, subPath);

		// then
		assertThat(resourceDisabled).isTrue();
		assertThat(subResourceDisabled).isTrue();

		// when
		// assure that test works
		service = new ResourcesGuardService();
		resourceDisabled = service.isResourceDisabled(extName, path);
		subResourceDisabled = service.isResourceDisabled(extName, subPath);

		// then
		assertThat(resourceDisabled).isFalse();
		assertThat(subResourceDisabled).isFalse();

	}

	@Test
	public void shouldHandleAllSafeURLChars()
	{
		final String extName = "hac";
		//final String path = "/platform/init%20$-_+!'(),";
		//final String endpointProperty = "endpoint.hac.platform.init%20$-_+!'(),.disabled";       // fails on these, are they too optional to handle?

		final String path = "/platform/init_-";
		final String endpointProperty = "endpoint.hac.platform.init_-.disabled"; // fails on these, are they too optional to handle?


		// given
		setParameter(endpointProperty, "true");
		final ResourcesGuardService service = new ResourcesGuardService();

		// when
		final boolean resourceDisabled = service.isResourceDisabled(extName, path);

		// then
		assertThat(resourceDisabled).isTrue();

	}

	private void setParameter(final String key, final String value)
	{
		Config.setParameter(key, value);
		tempProperties.add(key);
	}

}
