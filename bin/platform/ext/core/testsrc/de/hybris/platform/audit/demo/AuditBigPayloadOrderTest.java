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
package de.hybris.platform.audit.demo;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.PerformanceTest;
import de.hybris.platform.audit.AuditTestHelper;
import de.hybris.platform.audit.AuditableTest;
import de.hybris.platform.audit.TypeAuditReportConfig;
import de.hybris.platform.audit.internal.config.AuditConfigService;
import de.hybris.platform.audit.internal.config.AuditReportConfig;
import de.hybris.platform.audit.view.AuditViewService;
import de.hybris.platform.audit.view.impl.ReportView;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.persistence.audit.gateway.AuditRecord;
import de.hybris.platform.persistence.audit.gateway.AuditSearchQuery;
import de.hybris.platform.persistence.audit.gateway.ReadAuditGateway;
import de.hybris.platform.persistence.audit.internal.AuditEnablementService;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@PerformanceTest
public class AuditBigPayloadOrderTest extends ServicelayerBaseTest implements AuditableTest
{
	private static final Logger LOG = Logger.getLogger(AuditBigPayloadOrderTest.class);

	@Resource
	private ModelService modelService;
	@Resource
	private AuditConfigService auditConfigService;
	@Resource
	private AuditViewService auditViewService;
	@Resource
	protected ReadAuditGateway readAuditGateway;

	private AuditTestConfigManager auditTestConfigManager;
	private AuditTestHelper auditTestHelper;

	@Resource(name = "auditingEnablementService")
	private AuditEnablementService auditEnablementService;


	@Before
	public void setUp() throws Exception
	{
		auditTestHelper = new AuditTestHelper();
		auditTestConfigManager = new AuditTestConfigManager(auditEnablementService);
		auditTestConfigManager.enableAuditingForTypes("Product", "Order", "OrderEntry", "Unit", "Currency");
		assumeAuditEnabled();
	}

	@After
	public void cleanup()
	{
		auditTestConfigManager.resetAuditConfiguration();
	}

	@Test
	public void userOrdersTest()
	{
		final int payloadSize = 10000;
		final String name = "name_1";

		final long startTime = System.currentTimeMillis();
		LOG.info("Creating data");

		final CustomerModel customer = createUserWithOrders(name, payloadSize);

		LOG.info("Operation took (ms) " + (System.currentTimeMillis() - startTime));

		final List<AuditRecord> unsortedRecords = readAuditGateway
				.search(AuditSearchQuery.forType("User").withPkSearchRules(customer.getPk()).build()).collect(toList());
		assertThat(unsortedRecords).size().isGreaterThan(0);
		LOG.info("UnsortedRecords size: " + unsortedRecords.size());

		final List<AuditRecord> user = AuditTestHelper.sortRecords(unsortedRecords);
		LOG.info("Sorted, curent time (ms) " + (System.currentTimeMillis() - startTime));
		assertThat(AuditTestHelper.getAuditRecordsAttributes(user.get(0)).get("name")).isEqualTo(name);

		final AuditReportConfig testConfig = loadConfigFromFile("audit.test/audit-config.xml", "PersonalDataReport");

		final TypeAuditReportConfig config = TypeAuditReportConfig.builder().withConfig(testConfig).withRootTypePk(customer.getPk())
				.withFullReport().build();

		LOG.info("Starting auditViewService.getViewOn");
		final Stream<ReportView> reportViewStream = auditViewService.getViewOn(config);
		LOG.info("Done, current time (ms) " + (System.currentTimeMillis() - startTime));

		LOG.info("reportViewStream.count: " + reportViewStream.count());
		LOG.info("Final time (ms) " + (System.currentTimeMillis() - startTime));
	}

	private CustomerModel createUserWithOrders(final String name, final int noOfOrders)
	{
		final CustomerModel customer = modelService.create(CustomerModel.class);
		customer.setUid("user1");
		customer.setName(name);
		customer.setDescription("description_1");
		customer.setCustomerID("customerId_1");
		modelService.save(customer);

		final CurrencyModel currency = modelService.create(CurrencyModel.class);
		currency.setIsocode("cur1");
		currency.setSymbol("CUR1");
		modelService.save(currency);

		for (int i = 0; i < noOfOrders; i++)
		{
			final OrderModel order = modelService.create(OrderModel.class);
			order.setCode(UUID.randomUUID().toString());
			order.setDate(new Date());
			order.setNet(Boolean.FALSE);
			order.setCurrency(currency);
			order.setUser(customer);
			modelService.save(order);
		}
		return customer;
	}

	private AuditReportConfig loadConfigFromFile(final String file, final String configName)
	{
		return auditTestHelper.loadConfigFromFile(file, configName);
	}
}
