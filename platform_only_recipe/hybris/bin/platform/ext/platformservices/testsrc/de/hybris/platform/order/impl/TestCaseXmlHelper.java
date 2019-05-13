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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.logging.log4j.util.Strings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Class for loading XML with generated test cases, being output from 'tcases' external tool. <br/>
 * Assumes that each test case consists of same parameters.
 * Can output content in following formats:
 * <ul>
 * <li>CSV</li>
 * <li>Map&lt;String,String&gt;</li>
 * <li>iterator</li>
 * </ul>
 */
public class TestCaseXmlHelper implements Iterable
{
	public static final char CSV_SEPARATOR = '\t';
	private final List<Map<String, String>> testCases;

	public TestCaseXmlHelper(final File sourceXmlFile)
			throws ParserConfigurationException, SAXException, XPathExpressionException, IOException
	{
		testCases = new ArrayList<>();
		readXML(new FileInputStream(sourceXmlFile));
	}

	public TestCaseXmlHelper(final InputStream sourceXmlStream)
			throws ParserConfigurationException, IOException, SAXException, XPathExpressionException
	{
		testCases = new ArrayList<>();
		readXML(sourceXmlStream);
	}


	public String getVar(final int testCaseNumber, final String variableName)
	{
		return testCases.get(testCaseNumber).get(variableName);
	}

	public String getCSVRow(final int rowNumber, final String... headers)
	{
		final List<String> headersList = new ArrayList<>();
		for (final String h : headers)
		{
			headersList.add(h);
		}

		return getCSVRow(rowNumber, headersList);
	}

	/**
	 * Get a test case (a "row") as a CSV row separated by {@link #CSV_SEPARATOR CSV_SEPARATOR}={@value #CSV_SEPARATOR}.
	 *
	 * @param rowNumber
	 *           Test case number
	 * @param parameters
	 *           Provide a list of parameters ({@link #getAllParameters() getAllParameters}) to get specific ordering. <br />
	 *           Acts as a CSV header.
	 * @return
	 * 			 A String, single CSV row with specific ordering and separators.
	 */
	public String getCSVRow(final int rowNumber, final List<String> parameters)
	{
		if (rowNumber >= getRowCount())
		{
			throw new IndexOutOfBoundsException("Test case count exceeded");
		}

		final List<String> values = new ArrayList<>();
		parameters.forEach(h -> values.add(testCases.get(rowNumber).get(h)));
		return Strings.join(values, CSV_SEPARATOR);
	}

	public int getRowCount()
	{
		return testCases.size();
	}

	/**
	 * Get all parameter names as ordered List&lt;String&gt;. Use this to keep same parameter order when selecting rows.
	 *
	 * @return
	 * 			Ordered list of parameter names.
	 */
	public List<String> getAllParameters()
	{
		final List<String> parameterNames = new ArrayList<>();
		testCases.get(0).forEach((k, v) -> parameterNames.add(k));
		return parameterNames;
	}

	/**
	 * Get all parameters as CSV string separated by {@link #CSV_SEPARATOR CSV_SEPARATOR}={@value #CSV_SEPARATOR}.
	 *
	 * @return
	 * 			CSV header with all test case parameters and default separator.
	 */
	public String getCSVHeader()
	{
		return Strings.join(getAllParameters(), CSV_SEPARATOR);
	}

	/**
	 * Get test case ("a row") as a Map&lt;String,String&gt;
	 *
	 * @param index
	 * 					Requested test case number.
	 * @return
	 * 					Map of parameters for a given test case number.
	 */
	public Map<String, String> getTestCase(final int index)
	{
		return testCases.get(index);
	}

	/**
	 * Get all test cases as an {@link Iterator Iterator&lt;String&gt;}
	 *
	 * @return
	 * 			Iterator of test cases.
	 */
	public Iterator<Map<String, String>> iterator()
	{
		return new TestCaseIterator(this);
	}


	private class TestCaseIterator implements Iterator<Map<String, String>>
	{
		private final TestCaseXmlHelper testCases;
		private int counter;

		private TestCaseIterator(final TestCaseXmlHelper tc)
		{
			testCases = tc;
			counter = 0;
			if (testCases == null || testCases.getRowCount() == 0)
			{
				throw new NullPointerException("No test cases have been provided");
			}
		}

		@Override
		public boolean hasNext()
		{
			return (counter < testCases.getRowCount());
		}

		@Override
		public Map<String, String> next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			return testCases.getTestCase(counter++);
		}
	}

	private void readXML(final InputStream inputXML)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException
	{
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		final DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
		final Document doc = documentBuilder.parse(inputXML);
		doc.getDocumentElement().normalize();
		final XPath xPath = XPathFactory.newInstance().newXPath();

		// count test cases
		final String casesExpression = "//TestCase";
		final NodeList testCasesNodeList = (NodeList) xPath.compile(casesExpression).evaluate(doc, XPathConstants.NODESET);

		Map<String, String> parsedTestCase;

		for (int x = 0; x < testCasesNodeList.getLength(); x++)
		{
			parsedTestCase = new LinkedHashMap<>();
			final String expression = "//TestCase[@id=\"" + x + "\"]/Input/Var";

			final NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++)
			{
				final Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					final Element element = (Element) node;
					parsedTestCase.put(element.getAttribute("name"), getRealStringOrNull(element.getAttribute("value")));
				}
			}

			testCases.add(parsedTestCase);
		}
	}

	private static String getRealStringOrNull(final String string)
	{
		return (string == null || "null".equals(string)) ? null : string;
	}
}

