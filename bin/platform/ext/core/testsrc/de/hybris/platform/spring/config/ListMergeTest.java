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
package de.hybris.platform.spring.config;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test/MergeDirectives-test-spring.xml")
@UnitTest
public class ListMergeTest
{
	private static final String ITEM0 = "aaa";
	private static final String ITEM1 = "bbb";
	private static final String ITEM5 = "zzz";
	private static final String ITEM2 = "ccc";
	private static final String ITEM3 = "ddd";
	private static final String ITEM4 = "eee";

	private static final BigDecimal DECIMAL0 = new BigDecimal("1");
	private static final BigDecimal DECIMAL1 = new BigDecimal("2.0");
	private static final BigDecimal DECIMAL5 = new BigDecimal("987");
	private static final BigDecimal DECIMAL2 = new BigDecimal("3.01");
	private static final BigDecimal DECIMAL3 = new BigDecimal("40.002");
	private static final BigDecimal DECIMAL4 = new BigDecimal("500.003");



	private static final String OBJECT0 = new String("aaa");
	private static final BigInteger OBJECT1 = new BigInteger("2");
	private static final Long OBJECT5 = new Long("2");
	private static final Character OBJECT2 = Character.valueOf('d');
	private static final Integer OBJECT3 = Integer.valueOf(555);
	private static final BigDecimal OBJECT4 = new BigDecimal("1.0");

	@Autowired
	@Qualifier("mergeTestBean")
	private MergeTestBean externalBean;

	@Autowired
	@Qualifier("mergeFieldTestBean")
	private MergeTestBean fieldBean;

	@Test
	public void testExternalBeanNotNull()
	{
		assertListsNotNull(externalBean);
	}

	@Test
	public void testFieldBeanNotNull()
	{
		assertListsNotNull(fieldBean);
	}

	//----- values ----

	@Test
	public void testExternalBeanStringListContent()
	{
		assertStringListContent(externalBean);
	}

	@Test
	public void testFieldBeanStringListContent()
	{
		assertStringListContent(fieldBean);
	}

	@Test
	public void testExternaBeanStringListAddEnd()
	{
		assertStringListAddEnd(externalBean);
	}

	@Test
	public void testFieldBeanStringListAddEnd()
	{
		assertStringListAddEnd(fieldBean);
	}

	@Test
	public void testExternaBeanStringListAddBefore()
	{
		assertStringListAddBefore(externalBean);
	}

	@Test
	public void testFieldBeanStringListAddBefore()
	{
		assertStringListAddBefore(fieldBean);
	}

	@Test
	public void testExternaBeanStringListAddAfter()
	{
		assertStringListAddAfter(externalBean);
	}

	@Test
	public void testFieldBeanStringListAddAfter()
	{
		assertStringListAddAfter(fieldBean);
	}

	@Test
	public void testExternalBeanStringListBetween()
	{
		assertStringListBetween(externalBean);
	}

	@Test
	public void testFieldBeanStringListBetween()
	{
		assertStringListBetween(fieldBean);
	}

	//----- spring beans -----

	@Test
	public void testExternalBeanDecimalListContent()
	{
		assertDecimalListContent(externalBean);
	}

	@Test
	public void testFieldBeanDecimalListContent()
	{
		assertDecimalListContent(fieldBean);
	}

	@Test
	public void testExternaBeanDecimalListAddEnd()
	{
		assertDecimalListAddEnd(externalBean);
	}

	@Test
	public void testFieldBeanDecimalListAddEnd()
	{
		assertDecimalListAddEnd(fieldBean);
	}

	@Test
	public void testExternaBeanDecimalListAddBefore()
	{
		assertDecimalListAddBefore(externalBean);
	}

	@Test
	public void testFieldBeanDecimalListAddBefore()
	{
		assertDecimalListAddBefore(fieldBean);
	}

	@Test
	public void testExternaBeanDecimalListAddAfter()
	{
		assertDecimalListAddAfter(externalBean);
	}

	@Test
	public void testFieldBeanDecimalListAddAfter()
	{
		assertDecimalListAddAfter(fieldBean);
	}

	@Test
	public void testExternalBeanDecimalListBetween()
	{
		assertDecimalListBetween(externalBean);
	}

	@Test
	public void testFieldBeanDecimalListBetween()
	{
		assertDecimalListBetween(fieldBean);
	}

	//----- class -----

	@Test
	public void testExternalBeanObjectListContent()
	{
		assertObjectListContent(externalBean);
	}

	@Test
	public void testFieldBeanObjectListContent()
	{
		assertObjectListContent(fieldBean);
	}

	@Test
	public void testExternaBeanObjectListAddEnd()
	{
		assertObjectListAddEnd(externalBean);
	}

	@Test
	public void testFieldBeanObjectListAddEnd()
	{
		assertObjectListAddEnd(fieldBean);
	}

	@Test
	public void testExternaBeanObjectListAddBefore()
	{
		assertObjectListAddBefore(externalBean);
	}

	@Test
	public void testFieldBeanObjectListAddBefore()
	{
		assertObjectListAddBefore(fieldBean);
	}

	@Test
	public void testExternaBeanObjectListAddAfter()
	{
		assertObjectListAddAfter(externalBean);
	}

	@Test
	public void testFieldBeanObjectListAddAfter()
	{
		assertObjectListAddAfter(fieldBean);
	}

	@Test
	public void testExternalBeanObjectListBetween()
	{
		assertObjectListBetween(externalBean);
	}

	@Test
	public void testFieldBeanObjectListBetween()
	{
		assertObjectListBetween(fieldBean);
	}

	private void assertListsNotNull(final MergeTestBean bean)
	{
		assertNotNull(bean);
		assertNotNull(bean.getStringList());
		assertNotNull(bean.getObjectList());
		assertNotNull(bean.getDecimalList());
	}

	//----- string asserts -----

	private void assertStringListContent(final MergeTestBean bean)
	{
		final List<String> list = bean.getStringList();

		assertTrue("missing " + ITEM0, list.contains(ITEM0));
		assertTrue("missing " + ITEM1, list.contains(ITEM1));
		assertTrue("missing " + ITEM2, list.contains(ITEM2));
		assertTrue("missing " + ITEM3, list.contains(ITEM3));
		assertTrue("missing " + ITEM4, list.contains(ITEM4));
		assertTrue("missing " + ITEM5, list.contains(ITEM5));
	}

	private void assertStringListAddEnd(final MergeTestBean bean)
	{
		assertAfterPosition(bean.getStringList(), ITEM3, ITEM4);
	}

	private void assertStringListAddAfter(final MergeTestBean bean)
	{
		assertAfterPosition(bean.getStringList(), ITEM0, ITEM1);
	}

	private void assertStringListAddBefore(final MergeTestBean bean)
	{
		assertBeforePosition(bean.getStringList(), ITEM3, ITEM2);
	}

	private void assertStringListBetween(final MergeTestBean bean)
	{
		assertBetween(bean.getStringList(), ITEM0, ITEM5, ITEM3);
	}

	//----- decimal asserts -----

	private void assertObjectListContent(final MergeTestBean bean)
	{
		final List<Object> list = bean.getObjectList();

		assertTrue("missing " + OBJECT0, list.contains(OBJECT0));
		assertTrue("missing " + OBJECT1, list.contains(OBJECT1));
		assertTrue("missing " + OBJECT2, list.contains(OBJECT2));
		assertTrue("missing " + OBJECT3, list.contains(OBJECT3));
		assertTrue("missing " + OBJECT4, list.contains(OBJECT4));
		assertTrue("missing " + OBJECT5, list.contains(OBJECT5));
	}

	private void assertObjectListAddEnd(final MergeTestBean bean)
	{
		assertAfterPosition(bean.getObjectList(), OBJECT3, OBJECT4);
	}

	private void assertObjectListAddAfter(final MergeTestBean bean)
	{
		assertAfterPosition(bean.getObjectList(), OBJECT0, OBJECT1);
	}

	private void assertObjectListAddBefore(final MergeTestBean bean)
	{
		assertBeforePosition(bean.getObjectList(), OBJECT3, OBJECT2);
	}

	private void assertObjectListBetween(final MergeTestBean bean)
	{
		assertBetween(bean.getObjectList(), OBJECT0, OBJECT5, OBJECT3);
	}

	//----- object asserts -----

	private void assertDecimalListContent(final MergeTestBean bean)
	{
		final List<BigDecimal> list = bean.getDecimalList();

		assertTrue("missing " + DECIMAL0, list.contains(DECIMAL0));
		assertTrue("missing " + DECIMAL1, list.contains(DECIMAL1));
		assertTrue("missing " + DECIMAL2, list.contains(DECIMAL2));
		assertTrue("missing " + DECIMAL3, list.contains(DECIMAL3));
		assertTrue("missing " + DECIMAL4, list.contains(DECIMAL4));
		assertTrue("missing " + DECIMAL5, list.contains(DECIMAL5));
	}

	private void assertDecimalListAddEnd(final MergeTestBean bean)
	{
		assertAfterPosition(bean.getDecimalList(), DECIMAL3, DECIMAL4);
	}

	private void assertDecimalListAddAfter(final MergeTestBean bean)
	{
		assertAfterPosition(bean.getDecimalList(), DECIMAL0, DECIMAL1);
	}

	private void assertDecimalListAddBefore(final MergeTestBean bean)
	{
		assertBeforePosition(bean.getDecimalList(), DECIMAL3, DECIMAL2);
	}

	private void assertDecimalListBetween(final MergeTestBean bean)
	{
		assertBetween(bean.getDecimalList(), DECIMAL0, DECIMAL5, DECIMAL3);
	}

	//----- generic asserts -----
	private void assertAfterPosition(final List list, final Object marker, final Object added)
	{
		final int markerPos = list.indexOf(marker);
		final int addedPos = list.indexOf(added);
		assertTrue("Position of " + added + " (" + addedPos + ") should be bigger than position of " + marker + " (" + markerPos
				+ ")", markerPos < addedPos);
	}

	private void assertBeforePosition(final List list, final Object marker, final Object added)
	{
		final int markerPos = list.indexOf(marker);
		final int addedPos = list.indexOf(added);
		assertTrue("Position of " + added + " (" + addedPos + ") should be smaller than position of " + marker + " (" + markerPos
				+ ")", markerPos > addedPos);
	}

	private void assertBetween(final List list, final Object before, final Object actual, final Object after)
	{
		final int x = list.indexOf(before);
		final int y = list.indexOf(actual);
		final int z = list.indexOf(after);

		assertTrue(
				"Item " + actual + " (" + y + ") should be between items " + before + "(" + x + ") and " + after + "(" + z + ")",
				x < y && y < z);
	}
}
