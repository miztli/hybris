/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */
package de.hybris.platform.jobs;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.cronjob.model.ProcessTaskLogMaintenanceJobModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.datasetup.ServiceLayerDataSetup;
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.task.utils.NeedsTaskEngine;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
@NeedsTaskEngine
public class CleanUpProcessTaskLogPerformableEssentialDataIntegrationTest extends ServicelayerTransactionalTest
{
	@Resource
	private CleanUpProcessTaskLogPerformable cleanUpProcessTaskLogPerformable;

	@Resource
	private FlexibleSearchService flexibleSearchService;

	@Resource
	private ServiceLayerDataSetup serviceLayerDataSetup;

	@Before
	public void setUp() throws Exception
	{
		serviceLayerDataSetup.setup();
	}

	@Test
	public void shouldUseAvailableJobDefinitionToRunCronJob()
	{
		final String query = String.format("select {%s} from {%s} where {%s} = 'cleanUpProcessTaskLogPerformable'",
				ServicelayerJobModel.PK, ServicelayerJobModel._TYPECODE, ServicelayerJobModel.CODE);
		final SearchResult<JobModel> result = flexibleSearchService.search(query);
		final List<JobModel> jobModels = result.getResult();

		assertThat(jobModels).hasSize(1);

		final JobModel jobModel = jobModels.get(0);

		final CronJobModel cronJob = new CronJobModel();
		cronJob.setCode("blah");
		cronJob.setJob(jobModel);

		final PerformResult r = cleanUpProcessTaskLogPerformable.perform(cronJob);

		assertThat(r).isNotNull();
		assertThat(r.getStatus()).isEqualTo(CronJobStatus.FINISHED);
		assertThat(r.getResult()).isEqualTo(CronJobResult.SUCCESS);

	}

	@Test
	public void shouldHaveDefaultValuesWhenJobIsCreatedOnSystemSetup()
	{
		final String query = String.format("select {%s} from {%s} where {%s} = 'cleanUpProcessTaskLogPerformable'",
				ServicelayerJobModel.PK, ServicelayerJobModel._TYPECODE, ServicelayerJobModel.CODE);
		final SearchResult<JobModel> result = flexibleSearchService.search(query);
		final List<JobModel> jobModels = result.getResult();

		assertThat(jobModels).hasSize(1);

		final JobModel jobModel = jobModels.get(0);

		assertThat(jobModel).isInstanceOf(ProcessTaskLogMaintenanceJobModel.class);

		final ProcessTaskLogMaintenanceJobModel processTaskLogJobModel = (ProcessTaskLogMaintenanceJobModel) jobModel;
		assertThat(processTaskLogJobModel).extracting(ProcessTaskLogMaintenanceJobModel::getAge,
				ProcessTaskLogMaintenanceJobModel::getNumberOfLogs, ProcessTaskLogMaintenanceJobModel::getQueryCount)
				.containsExactly(50, 5, 500);
	}
}
