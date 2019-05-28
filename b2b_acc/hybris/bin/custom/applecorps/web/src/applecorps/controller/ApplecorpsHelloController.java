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
package applecorps.controller;

import applecorps.service.RecordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "/testCustomController")
public class ApplecorpsHelloController
{

	@Resource(name = "recordServiceImpl")
	private RecordsService recordsService;

	@RequestMapping(value = "/rest/{id}",
					method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> printWelcome(@PathVariable("id") final int id)
	{
		return getRecordsService().getRecordDetailsByName(id);
	}

	@RequestMapping(value = "/mvc/{id}",
			method = RequestMethod.GET)
	public String printWelcome(@PathVariable("id") final int id, final Model model)
	{
		model.addAttribute("recordDetails", getRecordsService().getRecordDetailsByName(id));

		return "records";
	}

	public RecordsService getRecordsService() {
		return recordsService;
	}

	public void setRecordsService(RecordsService recordsService) {
		this.recordsService = recordsService;
	}
}
