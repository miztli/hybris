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
package de.hybris.platform.processengine.synchronus;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.bootstrap.annotations.PerformanceTest;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.model.DynamicProcessDefinitionModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.tx.Transaction;

import java.io.StringReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
@PerformanceTest
public class PerformanceSynchTest extends ServicelayerBaseTest
{

	private static final long WAIT_TIMEOUT = TimeUnit.SECONDS.toMillis(5);
	private static final String CTX = "(" + PerformanceSynchTest.class.getName() + ".getContext())";
	private volatile static Context context = null;
	private static final int TOTAL_SIZE = 2000;

	public static Context getContext()
	{
		return context;
	}

	@Resource
	private ModelService modelService;

	@Resource
	private BusinessProcessService businessProcessService;

	@Before
	public void setUp()
	{
		context = new Context();
	}



	BusinessProcessModel generateBusinessProcessModel(final String uniqueId, final boolean synch)
	{
		final BusinessProcessModel process = givenBusinessProcess( //
				"<?xml version='1.0' encoding='utf-8'?>", //
				"<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='" + uniqueId + "'>", //
				"	<scriptAction id='action0'>", //
				"		<script type='groovy'>" + CTX + ".registerStartTime('" + uniqueId + "');  return 'itworks';</script>", //
				"		<transition name='itworks' to='2'/>", //
				"	</scriptAction>", //
				"  <scriptAction id='2' canJoinPreviousNode='" + synch + "'>", //
				"    <script type='groovy'> return 'ok';</script>", //
				"    <transition name='ok' to='3' />", //
				"  </scriptAction>", //
				"  <scriptAction id='3' canJoinPreviousNode='" + synch + "'>", //
				"    <script type='groovy'>return 'ok';</script>", //
				"    <transition name='ok' to='4' />", //
				"  </scriptAction>", //
				"  <scriptAction id='4' canJoinPreviousNode='" + synch + "'>", //
				"    <script type='groovy'>return 'ok';</script>", //
				"    <transition name='ok' to='5' />", //
				"  </scriptAction>", //

				"  <scriptAction id='5' canJoinPreviousNode='" + synch + "'>", //
				"    <script type='groovy'>" + CTX + ".registerStopTime('" + uniqueId + "'); return 'ok';</script>", //
				"    <transition name='ok' to='success' />", //
				"  </scriptAction>", //
				"	<end id='success' state='SUCCEEDED'>Everything was fine</end>", //
				"</process>");

		return process;
	}

	@Test
	public void performanceAsynch() throws InterruptedException, TimeoutException
	{
		System.err.println("PUBLIC " + CTX);
		generateAndRunBPM(false);

	}

	@Test
	public void performanceSynch() throws InterruptedException, TimeoutException
	{
		generateAndRunBPM(true);
	}

	private void generateAndRunBPM(final boolean canJoinPrivouseNode) throws InterruptedException
	{
		System.out.println("NEW TASKS");
		System.out.println("GENERATING TASKS canJoinPreviouseNode: " + canJoinPrivouseNode);
		final List<String> uniqueIds = new ArrayList<>();
		IntStream.range(0, TOTAL_SIZE).forEach(i -> uniqueIds.add(UUID.randomUUID().toString()));
		Transaction.current().begin();
		context.registerProcesses(uniqueIds, canJoinPrivouseNode);
		Transaction.current().commit();

		System.err.println("STARTING");

		final Instant startTime = Instant.now();

		Transaction.current().begin();
		uniqueIds.stream().forEach(i -> {
			final BusinessProcessModel bpm = context.getNextFreeUid(i);
			runBuissnessProcess(bpm);
		});
		Transaction.current().commit();


		context.waitForProcessStop();

		final LongSummaryStatistics stats = context.getTotalTimeMap().values().stream()
				.collect(Collectors.summarizingLong(Duration::toMillis));

		System.out.println("Count: " + stats.getCount());
		System.out.println("Min: " + DurationFormatUtils.formatDurationHMS(stats.getMin()));
		System.out.println("Avg: " + DurationFormatUtils.formatDurationHMS(Math.round(stats.getAverage())));
		System.out.println("Max: " + DurationFormatUtils.formatDurationHMS(stats.getMax()));

		System.out.println("TOTAL TIME " + Duration.between(startTime, Instant.now()));
		context.clear();
	}


	private void runBuissnessProcess(final BusinessProcessModel process)
	{
		businessProcessService.startProcess(process);
	}

	private String givenUniqueId()
	{
		return UUID.randomUUID().toString();
	}


	private BusinessProcessModel givenBusinessProcess(final String... lines)
	{
		final String content = Arrays.asList(lines).stream().sequential().reduce("", (acc, s) -> acc + s + "\n");
		final String code = extractCodeFromContent(content);

		final DynamicProcessDefinitionModel definition = modelService.create(DynamicProcessDefinitionModel.class);
		definition.setContent(content);
		definition.setCode(code);
		modelService.save(definition);

		return businessProcessService.createProcess(UUID.randomUUID().toString(), code);
	}

	private String extractCodeFromContent(final String content)
	{
		try
		{
			final XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new StringReader(content));
			while (reader.hasNext())
			{
				final XMLEvent tag = reader.nextEvent();
				if (tag.isStartElement())
				{
					final StartElement element = tag.asStartElement();
					if ("process".equalsIgnoreCase(element.getName().getLocalPart()))
					{
						final Attribute name = element.getAttributeByName(QName.valueOf("name"));
						if (name != null)
						{
							return name.getValue();
						}
					}
				}
			}
		}
		catch (XMLStreamException | FactoryConfigurationError e)
		{
			throw new RuntimeException(e);
		}
		throw new RuntimeException("BROKEN TEST");
	}

	private void waitFor(final BusinessProcessModel model) throws InterruptedException, TimeoutException
	{
		waitForCondition(r -> {
			modelService.refresh(model);
			return Boolean.valueOf(model.getState() != ProcessState.RUNNING);
		});
	}

	private void waitForCondition(final Function<Long, Boolean> condition) throws TimeoutException, InterruptedException
	{
		final long start = System.currentTimeMillis();
		long round = 1;
		while (!condition.apply(Long.valueOf(round)).booleanValue())
		{
			if (System.currentTimeMillis() - start > WAIT_TIMEOUT)
			{
				throw new TimeoutException();
			}
			round++;
			Thread.sleep(Math.min(100, WAIT_TIMEOUT / 100));
		}
	}

	private class Context
	{

		private volatile ConcurrentMap<String, Instant> startMap = new ConcurrentHashMap<>();
		private volatile ConcurrentMap<String, Duration> totalTimeMap = new ConcurrentHashMap<>();
		private volatile CountDownLatch totalCuntDown = new CountDownLatch(TOTAL_SIZE);
		private volatile ConcurrentMap<String, BusinessProcessModel> businessProcessMap = new ConcurrentHashMap<>();

		private void clear()
		{
			startMap.clear();
			totalTimeMap.clear();
			totalCuntDown = new CountDownLatch(TOTAL_SIZE);
			businessProcessMap.clear();
		}

		private void registerProcesses(final List<String> processIds, final boolean synch)
		{
			processIds.forEach(id -> createProcess(id, synch));
		}

		private void createProcess(final String processId, final boolean synch)
		{
			businessProcessMap.put(processId, generateBusinessProcessModel(processId, synch));
		}

		public BusinessProcessModel getNextFreeUid(final String key)
		{

			return businessProcessMap.get(key);
		}

		private void registerStartTime(final String uid)
		{
			startMap.put(uid, Instant.now());
		}

		private void registerStopTime(final String uid)
		{
			if (startMap.containsKey(uid))
			{
				final Instant startTime = startMap.get(uid);

				final Duration time = Duration.between(startTime, Instant.now());
				totalTimeMap.put(uid, time);
				totalCuntDown.countDown();
			}
		}


		public ConcurrentMap<String, Duration> getTotalTimeMap()
		{
			return totalTimeMap;
		}


		public void waitForProcessStop() throws InterruptedException
		{
			totalCuntDown.await();
		}


		public void test(final String sender)
		{
			System.err.println("HELLO FROM " + sender);
		}

	}




}
