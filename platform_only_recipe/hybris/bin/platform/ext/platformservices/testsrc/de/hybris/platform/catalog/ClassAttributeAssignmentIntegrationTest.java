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
package de.hybris.platform.catalog;

import static de.hybris.platform.catalog.enums.ClassificationAttributeTypeEnum.REFERENCE;
import static de.hybris.platform.catalog.enums.ClassificationAttributeTypeEnum.STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeModel;
import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemVersionModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.testframework.seed.ClassificationSystemTestDataCreator;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


public class ClassAttributeAssignmentIntegrationTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private TypeService typeService;
	private ClassificationClassModel classificationClass;
	private ClassificationAttributeModel classificationAttribute;
	private ClassificationSystemTestDataCreator creator;


	@Before
	public void setUp() throws Exception
	{
		creator = new ClassificationSystemTestDataCreator(modelService);
		final ClassificationSystemModel system = creator.createClassificationSystem("testClassificationSystem");
		final ClassificationSystemVersionModel systemVersion = creator.createClassificationSystemVersion("testVersion", system);
		classificationClass = creator.createClassificationClass("testClass", systemVersion);
		classificationAttribute = creator.createClassificationAttribute("testAttribute", systemVersion);
	}

	@Test
	public void shouldNotAllowToSaveReferenceAssignmentIfReferenceTypeIsNotSet()
	{
		// given
		final ClassAttributeAssignmentModel assignment = newAssignment();
		assignment.setAttributeType(REFERENCE);

		try
		{
			// when
			modelService.save(assignment);
			fail("Should throw ModelSavingException");
		}
		catch (final ModelSavingException e)
		{
			// then
			assertThat(e).hasCauseInstanceOf(InterceptorException.class);
		}
	}

	@Test
	public void shouldNotAllowToSaveReferenceAssignmentIfReferenceTypeIsExplictlySetToNull()
	{
		// given
		final ClassAttributeAssignmentModel assignment = newAssignment();
		assignment.setAttributeType(REFERENCE);
		assignment.setReferenceType(null);

		try
		{
			// when
			modelService.save(assignment);
			fail("Should throw ModelSavingException");
		}
		catch (final ModelSavingException e)
		{
			// then
			assertThat(e).hasCauseInstanceOf(InterceptorException.class);
		}
	}

	@Test
	public void shouldNotAllowToSaveNonReferenceAssignmentIfReferenceTypeIsSet()
	{
		// given
        final ClassAttributeAssignmentModel assignment = newAssignment();
        assignment.setAttributeType(STRING);
        assignment.setReferenceType(typeService.getComposedTypeForCode("Product"));

        try
        {
            // when
            modelService.save(assignment);
            fail("Should throw ModelSavingException");
        }
        catch (final ModelSavingException e)
        {
            // then
            assertThat(e).hasCauseInstanceOf(InterceptorException.class);
        }
	}

	private ClassAttributeAssignmentModel newAssignment()
	{
		final ClassAttributeAssignmentModel assignment = modelService.create(ClassAttributeAssignmentModel.class);
		assignment.setClassificationAttribute(classificationAttribute);
		assignment.setClassificationClass(classificationClass);

		return assignment;
	}


}
