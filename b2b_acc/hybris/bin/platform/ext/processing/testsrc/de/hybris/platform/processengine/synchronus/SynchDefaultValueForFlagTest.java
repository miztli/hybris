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
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.definition.ProcessDefinition;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.definition.ProcessDefinitionId;
import de.hybris.platform.processengine.definition.ScriptActionNode;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.model.DynamicProcessDefinitionModel;

import java.util.Arrays;
import java.util.UUID;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;


@IntegrationTest
public class SynchDefaultValueForFlagTest extends AbstractProcessEngineIntegrationTest
{

	@Resource
	private BusinessProcessService businessProcessService;
	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;

	private BusinessProcessModel givenBusinessProcess(final String code, final String... lines)
	{
		final String content = Arrays.asList(lines).stream().sequential().reduce("", (acc, s) -> acc + s + "\n");

		final DynamicProcessDefinitionModel definition = modelService.create(DynamicProcessDefinitionModel.class);
		definition.setContent(content);
		definition.setCode(code);
		modelService.save(definition);

		return businessProcessService.createProcess(UUID.randomUUID().toString(), code);
	}

	BusinessProcessModel generateBusinessProcessModel(final String uniqueId)
	{
		final BusinessProcessModel process = givenBusinessProcess(uniqueId, //
				"<?xml version='1.0' encoding='utf-8'?>", //
				"<process xmlns='http://www.hybris.de/xsd/processdefinition' start='action0' name='" + uniqueId + "'>", //
				"	<scriptAction id='action0'>", //
				"		<script type='groovy'>return 'itworks';</script>", //
				"		<transition name='itworks' to='success'/>", //
				"	</scriptAction>", //
				"	<end id='success' state='SUCCEEDED'>Everything was fine</end>", //
				"</process>");

		return process;
	}

	@Test
	public void testIfNotSettedFlagIsSwitchedToTrue()
	{
		canJoinPreviousNodeDefaultValue.switchToValue("true");
		final BusinessProcessModel bpm = generateBusinessProcessModel(UUID.randomUUID().toString());
		final ProcessDefinition processDefinition = processDefinitionFactory.getProcessDefinition(ProcessDefinitionId.of(bpm));
		final ScriptActionNode startNode = (ScriptActionNode) processDefinition.getStartNode();
		Assertions.assertThat(startNode.isCanJoinPreviousNode()).isTrue();
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
	}


	@Test
	public void testIfNotSettedFlagIsSwitchedToFalse()
	{
		canJoinPreviousNodeDefaultValue.switchToValue("false");
		final BusinessProcessModel bpm = generateBusinessProcessModel(UUID.randomUUID().toString());
		final ProcessDefinition processDefinition = processDefinitionFactory.getProcessDefinition(ProcessDefinitionId.of(bpm));
		final ScriptActionNode startNode = (ScriptActionNode) processDefinition.getStartNode();
		Assertions.assertThat(startNode.isCanJoinPreviousNode()).isFalse();
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
	}
}
