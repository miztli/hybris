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
package de.hybris.platform.audit.internal.config.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AbstractAuditTest;

import javax.annotation.Resource;
import javax.xml.bind.UnmarshalException;

import de.hybris.platform.audit.internal.config.AuditReportConfig;
import de.hybris.platform.audit.internal.config.XMLAuditReportConfigReader;
import de.hybris.platform.audit.internal.interceptors.AuditReportConfigValidateInterceptor;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.assertj.core.api.ThrowableAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@IntegrationTest
public class AuditReportConfigValidatorTest extends AbstractAuditTest
{
	@Resource
	private AuditReportConfigValidator auditReportConfigValidator;

	@Resource
	private XMLAuditReportConfigReader xmlAuditReportConfigReader;


	private final PropertyConfigSwitcher auditReportProductionMode = new PropertyConfigSwitcher(
			AuditReportConfigValidateInterceptor.AUDIT_VALIDATOR_MODE_PRODUCTION);

	@Before
	public void disableAuditReportProductionMode()
	{
		auditReportProductionMode.switchToValue("false");
	}

	@After
	public void revertAuditReportProductionModeProperty()
	{
		auditReportProductionMode.switchBackToDefault();
	}

	@Test
	public void shouldFailForGivenRootType()
	{
		//given & when
		final Throwable actual = ThrowableAssert
				.catchThrowable(() -> loadConfigFromFile("audit.test/validation-wrong-given-root-type.xml", "PRODUCT"));
		//then
		assertThat(actual.getCause()).isInstanceOf(AuditConfigValidationException.class);
		assertThat(actual.getCause().getMessage()).contains("No correct root type");
	}

	@Test
	public void shouldValidateIncorrectGivenRootType() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-given-root-type.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).hasSize(1);
			assertThat(auditReportViolations.get(0).getLevel()).isEqualTo(AuditConfigViolation.ViolationLevel.ERROR);
			assertThat(auditReportViolations.get(0).getMessage()).contains("No correct root type");
		}
	}

	@Test
	public void shouldValidateResolvesByWithoutExpressionForVirtualAttributeAsTheErrorLevel() throws Exception
	{
        try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
                .getResourceAsStream("audit.test/validation-wrong-custom-resolver-for-virtual-attribute.xml"))
        {
            final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
            final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
                    AuditConfigViolation.ViolationLevel.WARNING);

            assertThat(auditReportViolations).hasSize(1);
            assertThat(auditReportViolations.get(0).getLevel()).isEqualTo(AuditConfigViolation.ViolationLevel.ERROR);
            assertThat(auditReportViolations.get(0).getMessage()).contains("Required resolves-by definition for type User and virtual-attribute");
        }
	}


	@Test
	public void shouldFailForInvalidXml()
	{
		//given & when
		final Throwable actual = ThrowableAssert.catchThrowable(() -> loadConfigFromFile("audit.test/validation-invalidxml.xml", "PRODUCT"));
		//then
		assertTrue(ExceptionUtils.indexOfThrowable(actual, UnmarshalException.class) >= 0);
	}


	@Test
	public void shouldFailForRepeatedReferenceAttributesXml()
	{
		//given & when
		final Throwable actual = ThrowableAssert
				.catchThrowable(() -> loadConfigFromFile("audit.test/validation-duplicated-ref-attrs.xml", "GDPR"));
		//then
		assertTrue(ExceptionUtils.indexOfThrowable(actual, UnmarshalException.class) >= 0);
	}

	@Test
	public void shouldNotFailForAtomicAttributeInSubType()
	{
		//given & when
		final Throwable actual = ThrowableAssert
				.catchThrowable(() -> loadConfigFromFile("audit.test/validation-correct-atomic-attribute.xml", "PRODUCT"));
		//then
		assertThat(actual).isNull();
	}

	@Test
	public void shouldValidateAndNotFailForAtomicAttributeInSubType() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-correct-atomic-attribute.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).isEmpty();
		}
	}
}
