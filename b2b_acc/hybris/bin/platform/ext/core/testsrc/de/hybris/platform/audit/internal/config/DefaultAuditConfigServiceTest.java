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
package de.hybris.platform.audit.internal.config;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import de.hybris.platform.audit.AbstractAuditTest;
import de.hybris.platform.audit.internal.config.validation.AuditConfigValidationException;
import de.hybris.platform.audit.internal.config.validation.AuditReportConfigValidatorTest;
import de.hybris.platform.audit.internal.interceptors.AuditReportConfigValidateInterceptor;
import de.hybris.platform.core.model.audit.AuditReportConfigModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;


public class DefaultAuditConfigServiceTest extends AbstractAuditTest
{
	@Resource
	private DefaultAuditConfigService auditConfigService;

	@Resource
	private XMLAuditReportConfigReader xmlAuditReportConfigReader;

	private final PropertyConfigSwitcher auditReportProductionMode = new PropertyConfigSwitcher(
			AuditReportConfigValidateInterceptor.AUDIT_VALIDATOR_MODE_PRODUCTION);

	@Before
	public void disableProductionMode()
	{
		auditReportProductionMode.switchToValue("false");
	}

	@After
	public void revertProperty()
	{
		auditReportProductionMode.switchBackToDefault();
	}

	@Test
	public void shouldStoreConfig() throws Exception
	{
		// given
		final String xml = auditConfigService.toXml(testAuditReportConfig);

		// when
		final AuditReportConfigModel testConfig = auditConfigService.storeConfiguration("testConfig", xml);

		// then
		assertThat(testConfig).isNotNull();
		assertThat(modelService.isNew(testConfig)).isFalse();
		assertThat(testConfig.getActive()).isTrue();
		assertThat(testConfig.getCode()).isEqualTo("testConfig");
		assertThat(testConfig.getContent()).isEqualTo(xml);
	}

	@Test
	public void shouldFailIfConfigNameDoesNotMatchAuditReportConfigModelCode() throws Exception
	{
		// given
		final String xmlContent = auditConfigService.toXml(testAuditReportConfig);
		final String configName = "testConfig";

		// when
		final AuditReportConfigModel testConfig = modelService.create(AuditReportConfigModel.class);
		testConfig.setContent(xmlContent);
		testConfig.setCode("CodeDifferenThanConfigName");
		testConfig.setActive(Boolean.TRUE);

		try
		{
			modelService.save(testConfig);
			fail("Exception is expected but not thrown ...");
		}
		catch (final Exception exc)
		{
			assertThat(exc).hasCauseInstanceOf(AuditConfigValidationException.class)
					.hasMessageContaining("AuditReportConfigModel.code (" + testConfig.getCode()
							+ ") must match the given config name(" + configName + ")!");
		}

		testConfig.setCode(configName);
		modelService.save(testConfig);

		final AuditReportConfig unmarshalledConfigFromDb = auditConfigService.getConfigForName(configName);

		// then
		assertThat(unmarshalledConfigFromDb).isNotNull();
		assertThat(testConfig.getCode()).isEqualTo(unmarshalledConfigFromDb.getName());
		assertThat(testConfig.getContent()).isEqualTo(xmlContent);


	}

	@Test
	public void shouldThrowExceptionWhenSavingReportWithWarningsInProductionMode() throws Exception
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-atomic-attribute.xml"))
		{
			// given
			auditReportProductionMode.switchToValue("true");

			// when
			final Throwable actual = ThrowableAssert
					.catchThrowable(() -> auditConfigService.storeConfiguration("PRODUCT", IOUtils.toString(resourceAsStream, UTF_8)));

			// then
			assertThat(actual).isInstanceOf(ModelSavingException.class);
			assertThat(actual.getCause()).isInstanceOf(AuditConfigValidationException.class);
			assertThat(actual.getCause().getMessage()).contains(
					"Atomic attribute notexist1 configured for type Product is not defined in the model and will be ignored");
			assertThat(actual.getCause().getMessage()).contains(
					"Atomic attribute notexist2 configured for type Product is not defined in the model and will be ignored");
		}
	}


	@Test
	public void shouldSaveReportWithWarningsInDevelopmentMode() throws Exception
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-atomic-attribute.xml"))
		{
			auditReportProductionMode.switchToValue("false");

			// when
			final AuditReportConfigModel testConfig = auditConfigService.storeConfiguration("PRODUCT",
					IOUtils.toString(resourceAsStream, UTF_8));

			// then
			assertThat(testConfig).isNotNull();
			assertThat(modelService.isNew(testConfig)).isFalse();
			assertThat(testConfig.getActive()).isTrue();
			assertThat(testConfig.getCode()).isEqualTo("PRODUCT");
		}
	}

	@Test
	public void shouldUnmarshallConfig() throws Exception
	{
		// given
		final String xml = auditConfigService.toXml(testAuditReportConfig);

		// when
		final AuditReportConfig config = xmlAuditReportConfigReader.fromXml(new ByteArrayInputStream(xml.getBytes(UTF_8)));

		// then
		verifyTestConfig(config);
	}

	@Test
	public void shouldFindExistingConfig() throws Exception
	{
		// given
		final String xml = auditConfigService.toXml(testAuditReportConfig);
		auditConfigService.storeConfiguration("testConfig", xml);

		// when
		final AuditReportConfig testConfig = auditConfigService.getConfigForName("testConfig");

		// then
		verifyTestConfig(testConfig);
	}

	private void verifyTestConfig(final AuditReportConfig config)
	{
		assertThat(config).isNotNull();
		assertThat(config.getName()).isEqualTo("testConfig");
		assertThat(config.getGivenRootType()).isNotNull();
		assertThat(config.getTypes()).hasSize(3);

		final Type userType = config.getType("User");
		final Type addressType = config.getType("Address");
		final Type titleType = config.getType("Title");

		AuditConfigTypeAssert.assertThat(userType).hasCode("User");
		AuditConfigTypeAssert.assertThat(userType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfReferenceAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfVirtualAttributes(1);
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyAtomicAttributes("name", "uid");
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyReferenceAttributes("defaultPaymentAddress",
				"defaultShipmentAddress");

		AuditConfigTypeAssert.assertThat(addressType).hasCode("Address");
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfReferenceAttributes(1);
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(addressType).cointainsOnlyAtomicAttributes("town", "streetname");
		AuditConfigTypeAssert.assertThat(addressType).cointainsOnlyReferenceAttributes("title");

		AuditConfigTypeAssert.assertThat(titleType).hasCode("Title");
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfReferenceAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).cointainsOnlyAtomicAttributes("code", "name");
	}

	@Test
	public void shouldMergeTwoConfigurations_defaultModeAppend() throws Exception
	{
		// given
		final Type address = Type.builder() //
				.withCode("Address") //
				.withAtomicAttributes(AtomicAttribute.builder().withQualifier("pobox").withDisplayKey("address.pobox").build()) //
				.build();
		final AuditReportConfig additionalReportConfig = AuditReportConfig.builder().withName("testConfig").withTypes(address)
				.build();

		// when
		final AuditReportConfig mergedConfiguration = auditConfigService.mergeConfigurations(testAuditReportConfig,
				additionalReportConfig);

		// then
		verifyMergedConfiguration(mergedConfiguration);
	}


	@Test
	public void shouldMergeTwoConfigurations_declaredModeAppend() throws Exception
	{
		// given
		final Type address = Type.builder() //
				.withCode("Address") //
				.withAtomicAttributes(AtomicAttribute.builder().withQualifier("pobox").withDisplayKey("address.pobox").build()) //
				.withCombineMode("append").build();
		final AuditReportConfig additionalReportConfig = AuditReportConfig.builder().withName("testConfig").withTypes(address)
				.build();

		// when
		final AuditReportConfig mergedConfiguration = auditConfigService.mergeConfigurations(testAuditReportConfig,
				additionalReportConfig);

		// then
		verifyMergedConfiguration(mergedConfiguration);
	}

	private void verifyMergedConfiguration(final AuditReportConfig config)
	{
		assertThat(config).isNotNull();
		assertThat(config.getName()).isEqualTo("testConfig");
		assertThat(config.getGivenRootType()).isNotNull();
		assertThat(config.getTypes()).hasSize(3);

		final Type userType = config.getType("User");
		final Type addressType = config.getType("Address");
		final Type titleType = config.getType("Title");

		AuditConfigTypeAssert.assertThat(userType).hasCode("User");
		AuditConfigTypeAssert.assertThat(userType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfReferenceAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfVirtualAttributes(1);
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyAtomicAttributes("name", "uid");
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyReferenceAttributes("defaultPaymentAddress",
				"defaultShipmentAddress");

		AuditConfigTypeAssert.assertThat(addressType).hasCode("Address");
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfAtomicAttributes(3);
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfReferenceAttributes(1);
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(addressType).cointainsOnlyAtomicAttributes("town", "streetname", "pobox");
		AuditConfigTypeAssert.assertThat(addressType).cointainsOnlyReferenceAttributes("title");

		AuditConfigTypeAssert.assertThat(titleType).hasCode("Title");
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfReferenceAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).cointainsOnlyAtomicAttributes("code", "name");
	}

	@Test
	public void shouldMergeTwoConfigurations_declaredModeReplace() throws Exception
	{
		// given
		final Type address = Type.builder() //
				.withCode("Address") //
				.withAtomicAttributes(AtomicAttribute.builder().withQualifier("pobox").withDisplayKey("address.pobox").build()) //
				.withCombineMode("replace").build();
		final AuditReportConfig additionalReportConfig = AuditReportConfig.builder().withName("testConfig").withTypes(address)
				.build();

		// when
		final AuditReportConfig mergedConfiguration = auditConfigService.mergeConfigurations(testAuditReportConfig,
				additionalReportConfig);

		// then
		assertThat(mergedConfiguration).isNotNull();
		assertThat(mergedConfiguration.getName()).isEqualTo("testConfig");
		assertThat(mergedConfiguration.getGivenRootType()).isNotNull();
		assertThat(mergedConfiguration.getTypes()).hasSize(3);

		final Type userType = mergedConfiguration.getType("User");
		final Type addressType = mergedConfiguration.getType("Address");
		final Type titleType = mergedConfiguration.getType("Title");

		AuditConfigTypeAssert.assertThat(userType).hasCode("User");
		AuditConfigTypeAssert.assertThat(userType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfReferenceAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfVirtualAttributes(1);
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyAtomicAttributes("name", "uid");
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyReferenceAttributes("defaultPaymentAddress",
				"defaultShipmentAddress");

		AuditConfigTypeAssert.assertThat(addressType).hasCode("Address");
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfAtomicAttributes(1);
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfReferenceAttributes(0);
		AuditConfigTypeAssert.assertThat(addressType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(addressType).cointainsOnlyAtomicAttributes("pobox");

		AuditConfigTypeAssert.assertThat(titleType).hasCode("Title");
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfReferenceAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).cointainsOnlyAtomicAttributes("code", "name");
	}

	@Test
	public void shouldMergeTwoConfigurations_declaredModeRemove() throws Exception
	{
		// given
		final Type address = Type.builder() //
				.withCode("Address").withCombineMode("remove").build();
		final AuditReportConfig additionalReportConfig = AuditReportConfig.builder().withName("testConfig").withTypes(address)
				.build();

		// when
		final AuditReportConfig mergedConfiguration = auditConfigService.mergeConfigurations(testAuditReportConfig,
				additionalReportConfig);

		// then
		assertThat(mergedConfiguration).isNotNull();
		assertThat(mergedConfiguration.getName()).isEqualTo("testConfig");
		assertThat(mergedConfiguration.getGivenRootType()).isNotNull();
		assertThat(mergedConfiguration.getTypes()).hasSize(2);
		assertThat(mergedConfiguration.getType("Address")).isNull();

		final Type userType = mergedConfiguration.getType("User");
		final Type titleType = mergedConfiguration.getType("Title");

		AuditConfigTypeAssert.assertThat(userType).hasCode("User");
		AuditConfigTypeAssert.assertThat(userType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfReferenceAttributes(2);
		AuditConfigTypeAssert.assertThat(userType).hasNumOfVirtualAttributes(1);
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyAtomicAttributes("name", "uid");
		AuditConfigTypeAssert.assertThat(userType).cointainsOnlyReferenceAttributes("defaultPaymentAddress",
				"defaultShipmentAddress");

		AuditConfigTypeAssert.assertThat(titleType).hasCode("Title");
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfAtomicAttributes(2);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfReferenceAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).hasNumOfVirtualAttributes(0);
		AuditConfigTypeAssert.assertThat(titleType).cointainsOnlyAtomicAttributes("code", "name");
	}

	@Test
	public void shouldGetAllConfigsForRootType()
	{
		// given
		createReportConfiguration("address-1-config", "Address", "firstname");
		createReportConfiguration("address-2-config", "Address", "firstname");
		createReportConfiguration("user-config", "User", "uid");

		// when
		final List<AuditReportConfig> addressConfigurations = auditConfigService.getConfigsForRootType("Address");
		final List<AuditReportConfig> userConfigurations = auditConfigService.getConfigsForRootType("User");

		// then
		assertThat(addressConfigurations).hasSize(2);
		assertThat(addressConfigurations.stream()).extracting("name").containsExactlyInAnyOrder("address-1-config",
				"address-2-config");

		assertThat(userConfigurations).hasSize(1);
		assertThat(userConfigurations.get(0).getName()).isEqualTo("user-config");
	}

	@Test
	public void shouldGetAllConfigsForExtendedType()
	{
		// given
		createReportConfiguration("user-config", "User", "uid");

		// when
		final List<AuditReportConfig> userConfigsForCustomer = auditConfigService.getConfigsForRootType(CustomerModel._TYPECODE);
		final List<AuditReportConfig> userConfigsForPrincipal = auditConfigService.getConfigsForRootType(PrincipalModel._TYPECODE);
		final List<AuditReportConfig> userConfigurationsForEmployee = auditConfigService
				.getConfigsForRootType(EmployeeModel._TYPECODE);

		// then
		assertThat(userConfigsForCustomer).hasSize(1);
		assertThat(userConfigsForCustomer.get(0).getName()).isEqualTo("user-config");

		assertThat(userConfigurationsForEmployee).hasSize(1);
		assertThat(userConfigurationsForEmployee.get(0).getName()).isEqualTo("user-config");

		assertThat(userConfigsForPrincipal).hasSize(0);
	}

	@Test
	public void shouldReturnEmptyCollectionForNonExistingRootType()
	{
		// given
		createReportConfiguration("address-1-config", "Address", "firstname");

		// when
		final List<AuditReportConfig> userConfigurations = auditConfigService.getConfigsForRootType("User222");

		// then
		assertThat(userConfigurations).isEmpty();
	}

	@Test
	public void shouldNotReturnInactiveConfiguration()
	{
		// given
		final AuditReportConfigModel reportConfiguration = createReportConfiguration("address-1-config", "Address", "firstname");
		reportConfiguration.setContent(getAuditReportXml("address-1-config", "Address", "email"));
		modelService.save(reportConfiguration);

		// when
		final List<AuditReportConfig> userConfigurations = auditConfigService.getConfigsForRootType("Address");

		// then
		assertThat(userConfigurations).hasSize(1);
		assertThat(userConfigurations.get(0).getName()).isEqualTo("address-1-config");
	}

	@Test
	public void shouldMergeRelationAttributesForTwoConfigurations() throws Exception
	{
		// given
		final InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/merge-origin.xml");
		final AuditReportConfigModel cfg1 = auditConfigService.storeConfiguration("merge-origin",
				IOUtils.toString(resourceAsStream, UTF_8));
		final AuditReportConfig mergeOriginConfig = xmlAuditReportConfigReader.fromXml(cfg1);

		final InputStream resourceAsStream2 = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/merge-append.xml");
		final AuditReportConfigModel cfg2 = auditConfigService.storeConfiguration("merge-append",
				IOUtils.toString(resourceAsStream2, UTF_8));
		final AuditReportConfig mergeAppendConfig = xmlAuditReportConfigReader.fromXml(cfg2);

		//when
		final AuditReportConfig mergedResult = auditConfigService.mergeConfigurations(mergeOriginConfig, mergeAppendConfig);

		//then
		final Type userType = mergedResult.getType("User");

		assertThat(userType.getRelationAttributes()).hasSize(1);
		assertThat(userType.getAtomicAttributes()).hasSize(2);
		assertThat(userType.getVirtualAttributes()).hasSize(1);
		assertThat(userType.getReferenceAttributes()).hasSize(2);

	}

	private AuditReportConfigModel createReportConfiguration(final String configuration, final String type, final String qualifier)
	{
		return auditConfigService.storeConfiguration(configuration, getAuditReportXml(configuration, type, qualifier));
	}

	private String getAuditReportXml(final String configuration, final String type, final String qualifier)
	{
		final Type typeConfiguration = Type.builder().withCode(type)
				.withAtomicAttributes(AtomicAttribute.builder().withQualifier(qualifier).build()).build();

		final AuditReportConfig auditReportConfig = AuditReportConfig.builder().withName(configuration)
				.withGivenRootType(typeConfiguration).withTypes(typeConfiguration).build();
		return auditConfigService.toXml(auditReportConfig);
	}

	static class AuditConfigTypeAssert extends AbstractAssert<AuditConfigTypeAssert, Type>
	{
		public AuditConfigTypeAssert(final Type actual)
		{
			super(actual, AuditConfigTypeAssert.class);
		}

		public static AuditConfigTypeAssert assertThat(final Type type)
		{
			return new AuditConfigTypeAssert(type);
		}

		public AuditConfigTypeAssert hasCode(final String code)
		{
			Assertions.assertThat(actual.getCode()).isNotNull().isEqualTo(code);
			return this;
		}

		public AuditConfigTypeAssert hasNumOfReferenceAttributes(final int num)
		{
			Assertions.assertThat(actual.getReferenceAttributes()).hasSize(num);
			return this;
		}

		public AuditConfigTypeAssert hasNumOfVirtualAttributes(final int num)
		{
			Assertions.assertThat(actual.getVirtualAttributes()).hasSize(num);
			return this;
		}


		public AuditConfigTypeAssert hasNumOfAtomicAttributes(final int num)
		{
			Assertions.assertThat(actual.getAtomicAttributes()).hasSize(num);
			return this;
		}

		public AuditConfigTypeAssert cointainsOnlyAtomicAttributes(final String... qualifiers)
		{
			final List<String> foundQualifiers = actual.getAtomicAttributes().stream().map(AtomicAttribute::getQualifier)
					.collect(Collectors.toList());
			Assertions.assertThat(foundQualifiers).containsOnly(toLowerCase(qualifiers));
			return this;
		}

		public AuditConfigTypeAssert cointainsOnlyReferenceAttributes(final String... qualifiers)
		{
			final List<String> foundQualifiers = actual.getReferenceAttributes().stream().map(ReferenceAttribute::getQualifier)
					.collect(Collectors.toList());
			Assertions.assertThat(foundQualifiers).containsOnly(toLowerCase(qualifiers));
			return this;
		}

		public AuditConfigTypeAssert cointainsOnlyVirtualAttributes(final String... expressions)
		{
			final List<String> foundExpressions = actual.getVirtualAttributes().stream().map(VirtualAttribute::getExpression)
					.collect(Collectors.toList());
			Assertions.assertThat(foundExpressions).containsOnly(toLowerCase(expressions));
			return this;
		}

		private String[] toLowerCase(final String... qualifiers)
		{
			final List<String> result = Arrays.stream(qualifiers).map(String::toLowerCase).collect(Collectors.toList());
			return Iterables.toArray(result, String.class);
		}
	}

}
