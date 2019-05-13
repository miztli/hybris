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
package de.hybris.platform.order.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Test;


/**
 * Tests for XML helper
 */
public class TestCaseXmlHelperTest
{
	final private String inputXMLThreeColumn = "<?xml version=\"1.0\"?>\n" + "<TestCases>\n" + "<Function>\n"
			+ "<TestCase id=\"0\">\n" + "<Input>" + "<Var name=\"column1\" value=\"1\"/>\n" + "<Var name=\"column2\" value=\"2\"/>\n"
			+ "<Var name=\"column3\" value=\"3\"/>\n" + "</Input>" + "</TestCase>\n" + "</Function>\n" + "</TestCases>";

	final private String inputXMLOneColumn = "<?xml version=\"1.0\"?>\n" + "<TestCases>\n" + "<Function>\n"
			+ "<TestCase id=\"0\">\n" + "<Input>" + "<Var name=\"column1\" value=\"1\"/>\n" + "</Input>" + "</TestCase>\n"
			+ "</Function>\n" + "</TestCases>";

	private InputStream inputStream;
	private TestCaseXmlHelper helper;

	public void setup(final String xml)
	{
		inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
		try
		{
			helper = new TestCaseXmlHelper(inputStream);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

	}

	@After
	public void tearDown()
	{
		IOUtils.closeQuietly(inputStream);
	}


	@Test
	public void shouldKeepCsvColumnOrderSameAsInput()
	{
		setup(inputXMLThreeColumn);
		assertThat(helper.getCSVHeader()).isEqualTo("column1\tcolumn2\tcolumn3");
	}

	@Test
	public void shouldKeepDataOrderingSameAsHeaders()
	{
		setup(inputXMLThreeColumn);
		assertThat(helper.getCSVRow(0, helper.getAllParameters())).isEqualTo("1\t2\t3");
	}

	@Test
	public void shouldReturnTestCasesCount()
	{
		setup(inputXMLOneColumn);
		assertThat(helper.getAllParameters().size()).isEqualTo(1);
	}

	@Test
	public void shouldHandleOneColumnAndReturnHeader()
	{
		setup(inputXMLOneColumn);
		assertThat(helper.getAllParameters().get(0)).isEqualTo("column1");
	}

	@Test
	public void shouldHandleOneColumnAndReturnValue()
	{
		setup(inputXMLOneColumn);
		assertThat(helper.getCSVRow(0, helper.getAllParameters())).isEqualTo("1");
		assertThat(helper.getTestCase(0).get("column1")).isEqualTo("1");
		assertThat(helper.getVar(0, "column1")).isEqualTo("1");
	}

	@Test
	public void shouldHandleThreeColumnsAndReturnValues()
	{
		setup(inputXMLThreeColumn);
		assertThat(helper.getTestCase(0).get("column1")).isEqualTo("1");
		assertThat(helper.getTestCase(0).get("column2")).isEqualTo("2");
		assertThat(helper.getTestCase(0).get("column3")).isEqualTo("3");
		assertThat(helper.getVar(0, "column1")).isEqualTo("1");
		assertThat(helper.getVar(0, "column2")).isEqualTo("2");
		assertThat(helper.getVar(0, "column3")).isEqualTo("3");
	}

	@Test
	public void shouldReturnCSVRowWithHeadersGivenAsArray()
	{
		setup(inputXMLThreeColumn);
		assertThat(helper.getCSVRow(0, "column2")).isEqualTo("2");
		assertThat(helper.getCSVRow(0, "column2", "column1")).isEqualTo("2\t1");
		assertThat(helper.getCSVRow(0, "column2", "column3", "column1")).isEqualTo("2\t3\t1");
		assertThat(helper.getCSVRow(0)).isEmpty();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowOutOfBoundsWhenTooLargeRownumber()
	{
		setup(inputXMLThreeColumn);
		helper.getTestCase(1);
	}

	@Test
	public void shouldImplementIterator()
	{
		setup(inputXMLThreeColumn);
		assertThat(helper.iterator().hasNext()).isTrue();
		helper.forEach(x -> assertThat(x).isInstanceOf(Map.class));
		for (final Iterator<Map<String, String>> i = helper.iterator(); i.hasNext();)
		{
			assertThat(i.next()).isInstanceOf(Map.class);
		}
	}

}
