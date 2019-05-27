/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.voucher;

import com.hybris.mobile.lib.commerce.data.voucher.Voucher;
import java.util.List;

public class VoucherList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>VoucherList.vouchers</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Voucher> vouchers;
		
	public VoucherList()
	{
		// default constructor
	}
	
		
	public void setVouchers(final List<Voucher> vouchers)
	{
		this.vouchers = vouchers;
	}
	
		
	public List<Voucher> getVouchers() 
	{
		return vouchers;
	}
		
	
}