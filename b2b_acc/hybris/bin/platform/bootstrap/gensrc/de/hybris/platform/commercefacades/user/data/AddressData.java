/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.commercefacades.user.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.RegionData;

public  class AddressData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressData.id</code> property defined at extension <code>commercefacades</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>AddressData.title</code> property defined at extension <code>commercefacades</code>. */
		
	private String title;

	/** <i>Generated property</i> for <code>AddressData.titleCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String titleCode;

	/** <i>Generated property</i> for <code>AddressData.firstName</code> property defined at extension <code>commercefacades</code>. */
		
	private String firstName;

	/** <i>Generated property</i> for <code>AddressData.lastName</code> property defined at extension <code>commercefacades</code>. */
		
	private String lastName;

	/** <i>Generated property</i> for <code>AddressData.companyName</code> property defined at extension <code>commercefacades</code>. */
		
	private String companyName;

	/** <i>Generated property</i> for <code>AddressData.line1</code> property defined at extension <code>commercefacades</code>. */
		
	private String line1;

	/** <i>Generated property</i> for <code>AddressData.line2</code> property defined at extension <code>commercefacades</code>. */
		
	private String line2;

	/** <i>Generated property</i> for <code>AddressData.town</code> property defined at extension <code>commercefacades</code>. */
		
	private String town;

	/** <i>Generated property</i> for <code>AddressData.region</code> property defined at extension <code>commercefacades</code>. */
		
	private RegionData region;

	/** <i>Generated property</i> for <code>AddressData.postalCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String postalCode;

	/** <i>Generated property</i> for <code>AddressData.phone</code> property defined at extension <code>commercefacades</code>. */
		
	private String phone;

	/** <i>Generated property</i> for <code>AddressData.email</code> property defined at extension <code>commercefacades</code>. */
		
	private String email;

	/** <i>Generated property</i> for <code>AddressData.country</code> property defined at extension <code>commercefacades</code>. */
		
	private CountryData country;

	/** <i>Generated property</i> for <code>AddressData.shippingAddress</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean shippingAddress;

	/** <i>Generated property</i> for <code>AddressData.billingAddress</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean billingAddress;

	/** <i>Generated property</i> for <code>AddressData.defaultAddress</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean defaultAddress;

	/** <i>Generated property</i> for <code>AddressData.visibleInAddressBook</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean visibleInAddressBook;

	/** <i>Generated property</i> for <code>AddressData.formattedAddress</code> property defined at extension <code>commercefacades</code>. */
		
	private String formattedAddress;

	/** <i>Generated property</i> for <code>AddressData.editable</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean editable;
	
	public AddressData()
	{
		// default constructor
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

		
	
	public String getTitle() 
	{
		return title;
	}
	
		
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

		
	
	public String getTitleCode() 
	{
		return titleCode;
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
	
		
	
	public void setCompanyName(final String companyName)
	{
		this.companyName = companyName;
	}

		
	
	public String getCompanyName() 
	{
		return companyName;
	}
	
		
	
	public void setLine1(final String line1)
	{
		this.line1 = line1;
	}

		
	
	public String getLine1() 
	{
		return line1;
	}
	
		
	
	public void setLine2(final String line2)
	{
		this.line2 = line2;
	}

		
	
	public String getLine2() 
	{
		return line2;
	}
	
		
	
	public void setTown(final String town)
	{
		this.town = town;
	}

		
	
	public String getTown() 
	{
		return town;
	}
	
		
	
	public void setRegion(final RegionData region)
	{
		this.region = region;
	}

		
	
	public RegionData getRegion() 
	{
		return region;
	}
	
		
	
	public void setPostalCode(final String postalCode)
	{
		this.postalCode = postalCode;
	}

		
	
	public String getPostalCode() 
	{
		return postalCode;
	}
	
		
	
	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

		
	
	public String getPhone() 
	{
		return phone;
	}
	
		
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

		
	
	public String getEmail() 
	{
		return email;
	}
	
		
	
	public void setCountry(final CountryData country)
	{
		this.country = country;
	}

		
	
	public CountryData getCountry() 
	{
		return country;
	}
	
		
	
	public void setShippingAddress(final boolean shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

		
	
	public boolean isShippingAddress() 
	{
		return shippingAddress;
	}
	
		
	
	public void setBillingAddress(final boolean billingAddress)
	{
		this.billingAddress = billingAddress;
	}

		
	
	public boolean isBillingAddress() 
	{
		return billingAddress;
	}
	
		
	
	public void setDefaultAddress(final boolean defaultAddress)
	{
		this.defaultAddress = defaultAddress;
	}

		
	
	public boolean isDefaultAddress() 
	{
		return defaultAddress;
	}
	
		
	
	public void setVisibleInAddressBook(final boolean visibleInAddressBook)
	{
		this.visibleInAddressBook = visibleInAddressBook;
	}

		
	
	public boolean isVisibleInAddressBook() 
	{
		return visibleInAddressBook;
	}
	
		
	
	public void setFormattedAddress(final String formattedAddress)
	{
		this.formattedAddress = formattedAddress;
	}

		
	
	public String getFormattedAddress() 
	{
		return formattedAddress;
	}
	
		
	
	public void setEditable(final boolean editable)
	{
		this.editable = editable;
	}

		
	
	public boolean isEditable() 
	{
		return editable;
	}
	


}
