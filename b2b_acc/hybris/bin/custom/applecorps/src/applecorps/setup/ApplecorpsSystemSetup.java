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
package applecorps.setup;

import static applecorps.constants.ApplecorpsConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import applecorps.constants.ApplecorpsConstants;
import applecorps.service.ApplecorpsService;


@SystemSetup(extension = ApplecorpsConstants.EXTENSIONNAME)
public class ApplecorpsSystemSetup
{
	private final ApplecorpsService applecorpsService;

	public ApplecorpsSystemSetup(final ApplecorpsService applecorpsService)
	{
		this.applecorpsService = applecorpsService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		applecorpsService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ApplecorpsSystemSetup.class.getResourceAsStream("/applecorps/sap-hybris-platform.png");
	}
}
