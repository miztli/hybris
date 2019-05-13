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
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AbstractAuditTest;
import de.hybris.platform.audit.internal.config.AtomicAttribute;
import de.hybris.platform.audit.internal.config.AuditReportConfig;
import de.hybris.platform.audit.internal.config.ReferenceAttribute;
import de.hybris.platform.audit.internal.config.RelationAttribute;
import de.hybris.platform.audit.internal.config.Type;
import de.hybris.platform.audit.internal.config.VirtualAttribute;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.hybris.platform.audit.internal.config.XMLAuditReportConfigReader;
import de.hybris.platform.audit.internal.interceptors.AuditReportConfigValidateInterceptor;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.assertj.core.api.ThrowableAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;


@IntegrationTest
public class AuditReportConfigChangesAfterValidationTest extends AbstractAuditTest
{
	private static final String DISPLAY_NAME = "displayName";
	private static final String VALID = "valid";
	private static final String QUALIFIER = "qualifier";
	public static final String PRODUCT = "PRODUCT";

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
	public void shouldMarkAsInvalidVirtualAttributes()
	{
		//given & when
		final AuditReportConfig arc = loadConfigFromFile("audit.test/validation-wrong-virtual-type.xml", PRODUCT);
		//then
		final Type validType = checkIfTypeIsValid(arc, "User");

		final List<VirtualAttribute> virtualAttributes = validType.getAllVirtualAttributes();

		assertThat(virtualAttributes.stream())//
				.extracting(DISPLAY_NAME, VALID) //
				.containsExactlyInAnyOrder(//
						tuple("owned addresses", Boolean.valueOf(false)));

		final List<VirtualAttribute> validVirtualAttr = validType.getVirtualAttributes();
		assertThat(validVirtualAttr).isEmpty();

		checkIfTypeIsInvalid(arc, "AddressFail");
	}

	@Test
	public void shouldValidateInvalidVirtualAttributes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-virtual-type.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).extracting(AuditConfigViolation::getLevel).containsOnly(AuditConfigViolation.ViolationLevel.WARNING);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getMessage)
					.contains("Attribute: owner (defined by User type) is incorrect and will be ignored",
							"Type AddressFail is not defined in the system and its configuration will be ignored");
		}
	}

	@Test
	public void shouldMarkAsInvalidRelationAttributes()
	{
		//given & when
		final AuditReportConfig arc = loadConfigFromFile("audit.test/validation-wrong-relation-type.xml", PRODUCT);
		//then
		final Type validType = checkIfTypeIsValid(arc, "User");

		final List<RelationAttribute> virtualAttributes = validType.getAllRelationAttributes();

		assertThat(virtualAttributes.stream())//
				.extracting(DISPLAY_NAME, VALID) //
				.containsExactlyInAnyOrder(//
						tuple("groups", Boolean.valueOf(false)));

		final List<RelationAttribute> validVirtualAttr = validType.getRelationAttributes();
		assertThat(validVirtualAttr).isEmpty();

		checkIfTypeIsInvalid(arc, "UserGroupFail");
	}

	@Test
	public void shouldValidateInvalidRelationAttributes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-relation-type.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).extracting(AuditConfigViolation::getLevel).containsOnly(AuditConfigViolation.ViolationLevel.WARNING);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getMessage)
					.contains("Attribute: principalGroupRelation (defined by User type) is incorrect and will be ignored",
							"Type UserGroupFail is not defined in the system and its configuration will be ignored");
		}
	}

	@Test
	public void shouldMarkAsInvalidReferenceAttributes()
	{
		//given & when
		final AuditReportConfig arc = loadConfigFromFile("audit.test/validation-wrong-reference-type.xml", PRODUCT);

		//then
		final Type validType = checkIfTypeIsValid(arc, "User");

		final List<AtomicAttribute> atomicAttrs = validType.getAllAtomicAttributes();

		assertThat(atomicAttrs.stream())//
				.extracting(QUALIFIER, VALID) //
				.containsExactlyInAnyOrder(//
						tuple("uid", Boolean.valueOf(true)), //
						tuple("name", Boolean.valueOf(true)), //
						tuple("description", Boolean.valueOf(true)));

		checkIfAttributesAreValid(3, validType.getAtomicAttributes());


		final List<ReferenceAttribute> refAttrs = validType.getAllReferenceAttributes();
		assertThat(refAttrs.stream())//
				.extracting(DISPLAY_NAME, VALID) //
				.containsExactlyInAnyOrder(//
						tuple("groups", Boolean.valueOf(false)));

		final List<ReferenceAttribute> validRefAttr = validType.getReferenceAttributes();
		assertThat(validRefAttr).isEmpty();

		checkIfTypeIsInvalid(arc, "UserGroupFail");
	}

	@Test
	public void shouldValidateInvalidReferenceAttributes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-reference-type.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).extracting(AuditConfigViolation::getLevel).containsOnly(AuditConfigViolation.ViolationLevel.WARNING);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getMessage)
					.contains("Reference attribute: groups (defined by User type) is incorrect and will be ignored",
							"Type UserGroupFail is not defined in the system and its configuration will be ignored");
		}
	}


	@Test
	public void shouldMarkAsInvalidAtomicAttributes()
	{
		//given & when
		final AuditReportConfig arc = loadConfigFromFile("audit.test/validation-wrong-atomic-attribute.xml", PRODUCT);

		//then
		final Type validType = checkIfTypeIsValid(arc, "Product");

		final List<AtomicAttribute> atomicAttrs = validType.getAllAtomicAttributes();

		assertThat(atomicAttrs.stream())//
				.extracting(QUALIFIER, VALID) //
				.containsExactlyInAnyOrder(//
						tuple("notexist1", Boolean.valueOf(false)), //
						tuple("code", Boolean.valueOf(true)), //
						tuple("notexist2", Boolean.valueOf(false)));

		checkIfAttributesAreValid(1, validType.getAtomicAttributes());

	}

	@Test
	public void shouldValidateAtomicAttributes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-atomic-attribute.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).extracting(AuditConfigViolation::getLevel).containsOnly(AuditConfigViolation.ViolationLevel.WARNING);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getMessage)
					.contains("Atomic attribute notexist1 configured for type Product is not defined in the model and will be ignored",
							"Atomic attribute notexist2 configured for type Product is not defined in the model and will be ignored");
		}
	}

	@Test
	public void shouldInvalidateReferenceAttributes()
	{
		//given & when
		final AuditReportConfig arc = loadConfigFromFile("audit.test/validation-wrong-attribute.xml", PRODUCT);

		//then
		Type validType = checkIfTypeIsValid(arc, "Product");

		final List<ReferenceAttribute> referenceAttributes = validType.getAllReferenceAttributes();

		assertThat(referenceAttributes.stream())//
				.extracting(QUALIFIER, VALID) //
				.containsExactlyInAnyOrder(//
						tuple("notexist", Boolean.valueOf(false)) //
		);

		validType = checkIfTypeIsValid(arc, "Unit");
		checkIfAttributesAreValid(1, validType.getAtomicAttributes());
	}

	@Test
	public void shouldValidateReferenceAttributes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-attribute.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).hasSize(1);
			assertThat(auditReportViolations.get(0).getLevel()).isEqualTo(AuditConfigViolation.ViolationLevel.WARNING);
			assertThat(auditReportViolations.get(0).getMessage())
					.contains("Reference attribute: notexist (defined by Product type) incorrect and will be ignored");
		}
	}

	@Test
	public void shouldMarkAsInvalidSubTypes()
	{
		//given & when
		final AuditReportConfig arc = loadConfigFromFile("audit.test/validation-wrong-sub-type.xml", PRODUCT);
		//then
		assertThat(arc.getAllTypes().size()).isEqualTo(2);
		assertThat(arc.getTypeInAll("UserFail").isValid()).isEqualTo(false);
		assertThat(arc.getTypeInAll("User").isValid()).isEqualTo(true);
	}

	@Test
	public void shouldValidateSubTypes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-wrong-sub-type.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).hasSize(1);
			assertThat(auditReportViolations.get(0).getLevel()).isEqualTo(AuditConfigViolation.ViolationLevel.WARNING);
			assertThat(auditReportViolations.get(0).getMessage())
					.contains("Type UserFail is not defined in the system and its configuration will be ignored");
		}
	}

	@Test
	public void shouldThrowExceptionForMisspelledType()
	{
		//given & when
		final Throwable actual = ThrowableAssert
				.catchThrowable(() -> loadConfigFromFile("audit.test/validation-misspelledType.xml", PRODUCT));
		//then
		assertTrue(ExceptionUtils.indexOfThrowable(actual, AuditConfigValidationException.class) >= 0);

	}

	@Test
	public void shouldValidateMisspelledTypes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-misspelledType.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).hasSize(2);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getLevel).containsOnly(AuditConfigViolation.ViolationLevel.WARNING,
					AuditConfigViolation.ViolationLevel.ERROR);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getMessage).containsOnly(
					"Reference attribute: groups (defined by User type) target type is not configured or is configured incorrectly",
					"Type UserGroupFailB is not defined in the system and its configuration will be ignored");
		}
	}

	@Test
	public void shouldTrowExceptionWhenUsingDynamicAttribute()
	{
		final Throwable actual = ThrowableAssert
				.catchThrowable(() -> loadConfigFromFile("audit.test/validation-dynamic-attribute.xml", PRODUCT));

		assertThat(actual.getCause()).isInstanceOf(AuditConfigValidationException.class);

		final AuditConfigValidationException ex = (AuditConfigValidationException) actual.getCause();
		assertThat(ex.getViolations()).hasSize(1);

		assertThat(ex.getViolations().get(0).getLevel()).isEqualTo(AuditConfigViolation.ViolationLevel.ERROR);
		assertThat(ex.getViolations().get(0).getMessage()).isEqualTo(
				"Atomic attribute displayName configured for type User is a dynamic attribute");
	}


	@Test
	public void shouldValidateDynamicAttributes() throws IOException
	{
		try (InputStream resourceAsStream = AuditReportConfigValidatorTest.class.getClassLoader()
				.getResourceAsStream("audit.test/validation-dynamic-attribute.xml"))
		{
			final AuditReportConfig auditReportConfig = xmlAuditReportConfigReader.fromXmlWithoutValidation(resourceAsStream);
			final List<AuditConfigViolation> auditReportViolations = auditReportConfigValidator.validate(auditReportConfig,
					AuditConfigViolation.ViolationLevel.WARNING);

			assertThat(auditReportViolations).extracting(AuditConfigViolation::getLevel).containsOnly(AuditConfigViolation.ViolationLevel.ERROR);
			assertThat(auditReportViolations).extracting(AuditConfigViolation::getMessage)
					.contains(
							"Atomic attribute displayName configured for type User is a dynamic attribute");
		}
	}

	private void checkIfAttributesAreValid(final int sizeAttr, final List<AtomicAttribute> validAtomicAttrs)
	{
		assertThat(validAtomicAttrs.size()).isEqualTo(sizeAttr);
		validAtomicAttrs.stream().forEach(attr -> assertThat(attr.isValid()).isEqualTo(true));
	}

	private void checkIfTypeIsInvalid(final AuditReportConfig arc, final String typeName)
	{
		final Type invalidType = arc.getTypeInAll(typeName);
		assertThat(invalidType.isValid()).isEqualTo(false);
		assertThat(arc.getType(typeName)).isNull();
	}

	private Type checkIfTypeIsValid(final AuditReportConfig arc, final String typeName)
	{
		final Type validType = arc.getTypeInAll(typeName);
		assertThat(validType.isValid()).isEqualTo(true);
		assertThat(arc.getType(typeName)).isEqualTo(validType);
		return validType;
	}



}
