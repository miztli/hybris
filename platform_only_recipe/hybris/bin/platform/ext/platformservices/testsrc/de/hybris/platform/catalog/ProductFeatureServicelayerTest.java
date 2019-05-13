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

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.enums.ClassificationAttributeTypeEnum;
import de.hybris.platform.catalog.jalo.ProductFeature;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.ProductFeatureModel;
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeModel;
import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemVersionModel;
import de.hybris.platform.core.enums.TestEnum;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import de.hybris.platform.testframework.PropertyConfigSwitcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


@IntegrationTest
public class ProductFeatureServicelayerTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private UserService userService;
	@Resource
	private TypeService typeService;

	private final PropertyConfigSwitcher persistenceLegacyMode = new PropertyConfigSwitcher("persistence.legacy.mode");

	private ProductModel productModel;
	private ClassAttributeAssignmentModel caam;
	private ClassAttributeAssignmentModel refAssignment;
	private ClassAttributeAssignmentModel refAssignmentWithSubtypes;

	@Before
	public void prepare() throws ConsistencyCheckException
	{
		final CatalogModel cm1 = modelService.create(CatalogModel.class);
		cm1.setId("sl_a");
		modelService.save(cm1);

		final CatalogVersionModel cmv1 = modelService.create(CatalogVersionModel.class);
		cmv1.setCatalog(cm1);
		cmv1.setVersion("v1.0");
		modelService.save(cmv1);

		productModel = modelService.create(ProductModel.class);
		productModel.setCatalogVersion(cmv1);
		productModel.setCode("someFooCode");
		modelService.save(productModel);

		final ClassificationSystemModel csmDef;

		final ClassificationSystemVersionModel catalogDef;

		csmDef = modelService.create(ClassificationSystemModel.class);
		csmDef.setId("classFoo_a");

		catalogDef = modelService.create(ClassificationSystemVersionModel.class);
		catalogDef.setCatalog(csmDef);
		catalogDef.setVersion("ver def");
		csmDef.setDefaultCatalog(Boolean.TRUE);

		modelService.save(catalogDef);

		final ClassificationSystemModel csm = modelService.create(ClassificationSystemModel.class);
		csm.setId("modelSystemFoo_a");

		final ClassificationSystemVersionModel cvm = modelService.create(ClassificationSystemVersionModel.class);
		cvm.setCatalog(csm);
		cvm.setVersion("ver1.0");

		final ClassificationClassModel ccm = modelService.create(ClassificationClassModel.class);
		ccm.setCatalogVersion(cvm);
		ccm.setCode("ver1.0");

		modelService.save(ccm);

		final ClassificationAttributeModel cam1 = modelService.create(ClassificationAttributeModel.class);
		cam1.setCode("attrModelFoo_a");
		cam1.setSystemVersion(cvm);
		modelService.save(cam1);

		final ClassificationAttributeModel cam2 = modelService.create(ClassificationAttributeModel.class);
		cam2.setCode("attrModelFoo_b");
		cam2.setSystemVersion(cvm);
		modelService.save(cam2);

		final ClassificationAttributeModel cam3 = modelService.create(ClassificationAttributeModel.class);
		cam3.setCode("attrModelFoo_c");
		cam3.setSystemVersion(cvm);
		modelService.save(cam3);

		caam = modelService.create(ClassAttributeAssignmentModel.class);
		caam.setClassificationAttribute(cam1);
		caam.setClassificationClass(ccm);
		modelService.save(caam);

		refAssignment = modelService.create(ClassAttributeAssignmentModel.class);
		refAssignment.setClassificationAttribute(cam2);
		refAssignment.setClassificationClass(ccm);
		refAssignment.setReferenceType(typeService.getComposedTypeForCode("User"));
		refAssignment.setAttributeType(ClassificationAttributeTypeEnum.REFERENCE);
		refAssignment.setReferenceIncludesSubTypes(Boolean.FALSE);
		modelService.save(refAssignment);

		refAssignmentWithSubtypes = modelService.create(ClassAttributeAssignmentModel.class);
		refAssignmentWithSubtypes.setClassificationAttribute(cam3);
		refAssignmentWithSubtypes.setAttributeType(ClassificationAttributeTypeEnum.REFERENCE);
		refAssignmentWithSubtypes.setClassificationClass(ccm);
		refAssignmentWithSubtypes.setReferenceType(typeService.getComposedTypeForCode("User"));
		modelService.save(refAssignmentWithSubtypes);
	}

	@After
	public void tearDown() throws Exception
	{
		persistenceLegacyMode.switchBackToDefault();
	}

	@Test
	public void shouldCreateProductFeatureWithReferenceValue_SLD() throws Exception
	{
	    persistenceLegacyMode.switchToValue("false");
        shouldCreateProductFeatureWithReferenceValue();
	}

	@Test
	public void shouldCreateProductFeatureWithReferenceValue_JALO() throws Exception
	{
	    persistenceLegacyMode.switchToValue("true");
        shouldCreateProductFeatureWithReferenceValue();
	}

	private void shouldCreateProductFeatureWithReferenceValue() throws Exception
	{
        // given
        final TitleModel title = modelService.create(TitleModel.class);
        title.setCode("testTitle");
        modelService.save(title);

        caam.setAttributeType(ClassificationAttributeTypeEnum.REFERENCE);
        caam.setReferenceType(typeService.getComposedTypeForCode("Title"));
        caam.setReferenceIncludesSubTypes(Boolean.FALSE);

        final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
        feature.setClassificationAttributeAssignment(caam);
        feature.setValue(title);
        feature.setProduct(productModel);

        // when
        modelService.save(feature);

        // then
        assertThat(feature.getValue()).isEqualTo(title);
	}

    @Test
	public void shouldCreateProductFeatureWithReferenceValueWhichIsSubtypeOfConfiguredOne_SLD() throws Exception
    {
        persistenceLegacyMode.switchToValue("false");
        shouldCreateProductFeatureWithReferenceValueWhichIsSubtypeOfConfiguredOne();
    }

    @Test
	public void shouldCreateProductFeatureWithReferenceValueWhichIsSubtypeOfConfiguredOne_JALO() throws Exception
    {
        persistenceLegacyMode.switchToValue("true");
        shouldCreateProductFeatureWithReferenceValueWhichIsSubtypeOfConfiguredOne();
    }

	private void shouldCreateProductFeatureWithReferenceValueWhichIsSubtypeOfConfiguredOne() throws Exception
	{
        // given
        final EmployeeModel adminUser = userService.getAdminUser();
        final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
        caam.setAttributeType(ClassificationAttributeTypeEnum.REFERENCE);
        caam.setReferenceType(typeService.getComposedTypeForCode("User"));
        feature.setClassificationAttributeAssignment(caam);
        feature.setValue(adminUser);
        feature.setProduct(productModel);

        // when
        modelService.save(feature);

        // then
        assertThat(feature.getValue()).isEqualTo(adminUser);
	}

	@Resource
	private EnumerationService enumerationService;

	@Test
	public void shouldCreateProductFeatureWithEnumerationValueAsAModel()
	{
		// given
        final TestEnum enumerationValue = enumerationService.getEnumerationValue(TestEnum.class, "testValue1");
        final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
        feature.setClassificationAttributeAssignment(caam);
        feature.setValue(typeService.getEnumerationValue(enumerationValue));
        feature.setProduct(productModel);

		// when
        modelService.save(feature);

		// then
        assertThat(feature.getValue()).isEqualTo(enumerationValue);
	}

	@Test
	public void shouldCreateProductFeatureWithEnumerationValue()
	{
		// given
        final TestEnum enumerationValue = enumerationService.getEnumerationValue(TestEnum.class, "testValue1");
        final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
        feature.setClassificationAttributeAssignment(caam);
        feature.setValue(enumerationValue);
        feature.setProduct(productModel);

		// when
        modelService.save(feature);

		// then
        assertThat(feature.getValue()).isEqualTo(enumerationValue);
	}

	@Test
    public void shouldNotCreateProductFeatureIfProductNotSet_SLD()
    {
        persistenceLegacyMode.switchToValue("false");
        shouldNotCreateProductFeatureIfProductNotSet();
    }

    @Test
    public void shouldNotCreateProductFeatureIfProductNotSet_JALO()
    {
        persistenceLegacyMode.switchToValue("true");
        shouldNotCreateProductFeatureIfProductNotSet();
    }

	private void shouldNotCreateProductFeatureIfProductNotSet()
	{
		final ProductFeatureModel modelItem = modelService.create(ProductFeatureModel.class);
		modelItem.setValue("someFooValue");
		modelItem.setClassificationAttributeAssignment(caam);

		try
		{
			modelService.save(modelItem);
			fail("Exception was expected (due to missing Product attribute) but not thrown");
		}
		catch (final Exception e)
		{
			assertThat(e).isInstanceOf(ModelSavingException.class);
		}
	}

    @Test
    public void shouldNotCreateProductFeatureIfValueNotSet_SLD()
    {
        persistenceLegacyMode.switchToValue("false");
        shouldNotCreateProductFeatureIfValueNotSet();
    }

    @Test
    public void shouldNotCreateProductFeatureIfValueNotSet_JALO()
    {
        persistenceLegacyMode.switchToValue("true");
        shouldNotCreateProductFeatureIfValueNotSet();
    }

	private void shouldNotCreateProductFeatureIfValueNotSet()
	{
		final ProductFeatureModel modelItem = modelService.create(ProductFeatureModel.class);
		modelItem.setProduct(productModel);
		modelItem.setClassificationAttributeAssignment(caam);

		try
		{
			modelService.save(modelItem);
			fail("Exception was expected (due to missing Value attribute) but not thrown");
		}
		catch (final Exception e)
		{
			assertThat(e).isInstanceOf(ModelSavingException.class);
		}
	}

    @Test
    public void shouldNotCreateProductFeatureIfAssignmentIsSetToHandleReferenceAndTypeDoesntMatch_SLD() throws Exception
    {
        persistenceLegacyMode.switchToValue("false");
        shouldNotCreateProductFeatureIfAssignmentIsSetToHandleReferenceAndTypeDoesntMatch();
    }

    @Test
    public void shouldNotCreateProductFeatureIfAssignmentIsSetToHandleReferenceAndTypeDoesntMatch_JALO() throws Exception
    {
        persistenceLegacyMode.switchToValue("true");
        shouldNotCreateProductFeatureIfAssignmentIsSetToHandleReferenceAndTypeDoesntMatch();
    }

	private void shouldNotCreateProductFeatureIfAssignmentIsSetToHandleReferenceAndTypeDoesntMatch() throws Exception
	{
		// given
		final TitleModel title = modelService.create(TitleModel.class);
		title.setCode("testTitle");
		modelService.save(title);

		final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
		feature.setProduct(productModel);
		feature.setClassificationAttributeAssignment(refAssignment);
		feature.setValue(title);

		try
		{
			// when
            modelService.save(feature);
            fail("Excpected ModelSavingException");
		}
		catch (final ModelSavingException e)
		{
			// then fine
		}
	}

    @Test
    public void shouldCreateProductFeatureWithClassAttributeAssignment_SLD() throws Exception
    {
        persistenceLegacyMode.switchToValue("false");
        shouldCreateProductFeatureWithClassAttributeAssignment();
    }

    @Test
    public void shouldCreateProductFeatureWithClassAttributeAssignment_JALO() throws Exception
    {
        persistenceLegacyMode.switchToValue("true");
        shouldCreateProductFeatureWithClassAttributeAssignment();
    }

	private void shouldCreateProductFeatureWithClassAttributeAssignment() throws Exception
	{
		final Map attrs = new HashMap();
		attrs.put(ProductFeature.PRODUCT, modelService.getSource(productModel));
		attrs.put(ProductFeature.VALUE, "someJaloValue");
		attrs.put(ProductFeature.CLASSIFICATIONATTRIBUTEASSIGNMENT, modelService.getSource(caam));
		attrs.put(ProductFeature.VALUEPOSITION, Integer.valueOf(0));

		final ComposedType type = JaloSession.getCurrentSession().getTenant().getJaloConnection().getTypeManager()
				.getComposedType(ProductFeature.class);
		final ProductFeature jaloFeature = (ProductFeature) type.newInstance(jaloSession.getSessionContext(), attrs);

		final ProductFeatureModel modelItem = modelService.create(ProductFeatureModel.class);
		modelItem.setProduct(productModel);
		modelItem.setValue("someFooValue");
		modelItem.setClassificationAttributeAssignment(caam);
		modelItem.setValuePosition(Integer.valueOf(1));

		modelService.save(modelItem);

		Assert.assertEquals(jaloFeature.getQualifier(), modelItem.getQualifier());
	}

    @Test
    public void shouldCreateProductFeatureWithQualifierExplicitlySet_SLD()
    {
        persistenceLegacyMode.switchToValue("false");
        shouldCreateProductFeatureWithQualifierExplicitlySet();
    }

    @Test
    public void shouldCreateProductFeatureWithQualifierExplicitlySet_JALO()
    {
        persistenceLegacyMode.switchToValue("true");
        shouldCreateProductFeatureWithQualifierExplicitlySet();
    }

	private void shouldCreateProductFeatureWithQualifierExplicitlySet()
	{
		final ProductFeatureModel modelItem = modelService.create(ProductFeatureModel.class);
		modelItem.setProduct(productModel);
		modelItem.setValue("someFooValue");
		modelItem.setClassificationAttributeAssignment(caam);
		modelItem.setQualifier("someBarQual");

		modelService.save(modelItem);

		Assert.assertEquals("someBarQual", modelItem.getQualifier());
	}
}
