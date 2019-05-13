/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.customersupportbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;

public  class CsCreateAddressForm  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.owner</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CustomerModel owner;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.title</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private TitleModel title;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.firstName</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String firstName;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.lastName</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String lastName;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.addressLine1</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String addressLine1;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.addressLine2</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String addressLine2;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.town</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String town;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.country</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CountryModel country;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.region</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private RegionModel region;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.postalcode</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String postalcode;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.phone1</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String phone1;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.shippingAddress</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private Boolean shippingAddress;

	/** <i>Generated property</i> for <code>CsCreateAddressForm.billingAddress</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private Boolean billingAddress;
	
	public CsCreateAddressForm()
	{
		// default constructor
	}
	
		
	
	public void setOwner(final CustomerModel owner)
	{
		this.owner = owner;
	}

		
	
	public CustomerModel getOwner() 
	{
		return owner;
	}
	
		
	
	public void setTitle(final TitleModel title)
	{
		this.title = title;
	}

		
	
	public TitleModel getTitle() 
	{
		return title;
	}
	
		
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

		
	
	public String getFirstName() 
	{
		return firstName;
	}
	
		
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

		
	
	public String getLastName() 
	{
		return lastName;
	}
	
		
	
	public void setAddressLine1(final String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

		
	
	public String getAddressLine1() 
	{
		return addressLine1;
	}
	
		
	
	public void setAddressLine2(final String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

		
	
	public String getAddressLine2() 
	{
		return addressLine2;
	}
	
		
	
	public void setTown(final String town)
	{
		this.town = town;
	}

		
	
	public String getTown() 
	{
		return town;
	}
	
		
	
	public void setCountry(final CountryModel country)
	{
		this.country = country;
	}

		
	
	public CountryModel getCountry() 
	{
		return country;
	}
	
		
	
	public void setRegion(final RegionModel region)
	{
		this.region = region;
	}

		
	
	public RegionModel getRegion() 
	{
		return region;
	}
	
		
	
	public void setPostalcode(final String postalcode)
	{
		this.postalcode = postalcode;
	}

		
	
	public String getPostalcode() 
	{
		return postalcode;
	}
	
		
	
	public void setPhone1(final String phone1)
	{
		this.phone1 = phone1;
	}

		
	
	public String getPhone1() 
	{
		return phone1;
	}
	
		
	
	public void setShippingAddress(final Boolean shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

		
	
	public Boolean getShippingAddress() 
	{
		return shippingAddress;
	}
	
		
	
	public void setBillingAddress(final Boolean billingAddress)
	{
		this.billingAddress = billingAddress;
	}

		
	
	public Boolean getBillingAddress() 
	{
		return billingAddress;
	}
	


}
