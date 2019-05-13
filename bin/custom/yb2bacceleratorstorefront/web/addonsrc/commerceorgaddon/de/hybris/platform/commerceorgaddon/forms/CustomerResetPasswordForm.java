/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.commerceorgaddon.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Pojo for 'customer rest password' form.
 */
public class CustomerResetPasswordForm
{
	private String uid;
	private String newPassword;
	private String checkNewPassword;

	public String getUid()
	{
		return uid;
	}

	public void setUid(final String uid)
	{
		this.uid = uid;
	}


	@NotNull(message = "{profile.newPassword.invalid}")
	@Size(min = 6, max = 255, message = "{updatePwd.pwd.invalid}")
	public String getNewPassword()
	{
		return newPassword;
	}

	public void setNewPassword(final String newPassword)
	{
		this.newPassword = newPassword;
	}

	@NotNull(message = "{profile.checkNewPassword.invalid}")
	public String getCheckNewPassword()
	{
		return checkNewPassword;
	}

	public void setCheckNewPassword(final String checkNewPassword)
	{
		this.checkNewPassword = checkNewPassword;
	}
}
