/*
 *  [y] hybris Platform
 *
 *  Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 *  This software is the confidential and proprietary information of SAP
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with SAP.
 */

package de.hybris.platform.processengine.adminapi;


import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@IntegrationTest
public class BusinessProcessControllerTest extends ServicelayerBaseTest
{

	private static final String SUCCEEDED = "Operation succeeded";
	private static final String CAN_T_BE_NULL = "event can't be null";
	private static final String TRIGGERED = "Event has been already triggered";
	private BusinessProcessController businessProcessController;

	@Resource
	private BusinessProcessService businessProcessService;

	@Before
	public void setUp()
	{
		this.businessProcessController = new BusinessProcessController(businessProcessService);
	}

	@Test
	public void triggerEventWithChoice()
	{
		final TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
		triggerEventRequest.setEvent("testEvent1");
		triggerEventRequest.setChoice("choice");
		final ResponseEntity<TriggerEventResponse> responseEntity = businessProcessController.triggerEvent(triggerEventRequest);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody().getMessage()).isEqualTo(SUCCEEDED);
	}

	@Test
	public void triggerEventWithoutChoice()
	{
		final TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
		triggerEventRequest.setEvent("testEvent2");
		final ResponseEntity<TriggerEventResponse> responseEntity = businessProcessController.triggerEvent(triggerEventRequest);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody().getMessage()).isEqualTo(SUCCEEDED);
	}


	@Test
	public void triggerAlreadyTriggeredEvent()
	{
		final TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
		triggerEventRequest.setEvent("testEvent3");
		triggerEventRequest.setChoice("chzoice");
		final ResponseEntity<TriggerEventResponse> responseEntity1 = businessProcessController.triggerEvent(triggerEventRequest);
		assertThat(responseEntity1.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity1.getBody().getMessage()).isEqualTo(SUCCEEDED);

		final ResponseEntity<TriggerEventResponse> responseEntity2 = businessProcessController.triggerEvent(triggerEventRequest);
		assertThat(responseEntity2.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		assertThat(responseEntity2.getBody().getMessage()).isEqualTo(TRIGGERED);
	}

	@Test
	public void triggerEventWithoutEventName()
	{
		final TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
		triggerEventRequest.setChoice("choice");
		final ResponseEntity<TriggerEventResponse> responseEntity = businessProcessController.triggerEvent(triggerEventRequest);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(responseEntity.getBody().getMessage()).isEqualTo(CAN_T_BE_NULL);
	}

	@Test
	public void triggerEventWithoutEventNameAndChoice()
	{
		final TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
		final ResponseEntity<TriggerEventResponse> responseEntity = businessProcessController.triggerEvent(triggerEventRequest);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(responseEntity.getBody().getMessage()).isEqualTo(CAN_T_BE_NULL);
	}

}
