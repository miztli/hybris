/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 28, 2019 3:18:54 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.enums.B2BBookingLineStatus;
import de.hybris.platform.b2b.enums.BookingType;
import de.hybris.platform.b2b.model.B2BCostCenterModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Generated model class for type B2BBookingLineEntry first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BBookingLineEntryModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BBookingLineEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.bookingStatus</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BOOKINGSTATUS = "bookingStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.costCenter</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COSTCENTER = "costCenter";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.amount</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String AMOUNT = "amount";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.currency</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.product</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String PRODUCT = "product";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.quantity</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String QUANTITY = "quantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.orderID</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ORDERID = "orderID";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.orderEntryNr</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ORDERENTRYNR = "orderEntryNr";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.orderEntry</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ORDERENTRY = "orderEntry";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.bookingDate</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BOOKINGDATE = "bookingDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBookingLineEntry.bookingType</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BOOKINGTYPE = "bookingType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BBookingLineEntryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BBookingLineEntryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _amount initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _bookingDate initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _bookingStatus initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _costCenter initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _product initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _quantity initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BBookingLineEntryModel(final BigDecimal _amount, final Date _bookingDate, final B2BBookingLineStatus _bookingStatus, final B2BCostCenterModel _costCenter, final CurrencyModel _currency, final String _product, final Long _quantity)
	{
		super();
		setAmount(_amount);
		setBookingDate(_bookingDate);
		setBookingStatus(_bookingStatus);
		setCostCenter(_costCenter);
		setCurrency(_currency);
		setProduct(_product);
		setQuantity(_quantity);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _amount initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _bookingDate initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _bookingStatus initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _costCenter initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _product initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 * @param _quantity initial attribute declared by type <code>B2BBookingLineEntry</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BBookingLineEntryModel(final BigDecimal _amount, final Date _bookingDate, final B2BBookingLineStatus _bookingStatus, final B2BCostCenterModel _costCenter, final CurrencyModel _currency, final ItemModel _owner, final String _product, final Long _quantity)
	{
		super();
		setAmount(_amount);
		setBookingDate(_bookingDate);
		setBookingStatus(_bookingStatus);
		setCostCenter(_costCenter);
		setCurrency(_currency);
		setOwner(_owner);
		setProduct(_product);
		setQuantity(_quantity);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.amount</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the amount
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.GETTER)
	public BigDecimal getAmount()
	{
		return getPersistenceContext().getPropertyValue(AMOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.bookingDate</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the bookingDate
	 */
	@Accessor(qualifier = "bookingDate", type = Accessor.Type.GETTER)
	public Date getBookingDate()
	{
		return getPersistenceContext().getPropertyValue(BOOKINGDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.bookingStatus</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the bookingStatus
	 */
	@Accessor(qualifier = "bookingStatus", type = Accessor.Type.GETTER)
	public B2BBookingLineStatus getBookingStatus()
	{
		return getPersistenceContext().getPropertyValue(BOOKINGSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.bookingType</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the bookingType
	 */
	@Accessor(qualifier = "bookingType", type = Accessor.Type.GETTER)
	public BookingType getBookingType()
	{
		return getPersistenceContext().getPropertyValue(BOOKINGTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.costCenter</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the costCenter
	 */
	@Accessor(qualifier = "costCenter", type = Accessor.Type.GETTER)
	public B2BCostCenterModel getCostCenter()
	{
		return getPersistenceContext().getPropertyValue(COSTCENTER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.orderEntry</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the orderEntry
	 */
	@Accessor(qualifier = "orderEntry", type = Accessor.Type.GETTER)
	public OrderEntryModel getOrderEntry()
	{
		return getPersistenceContext().getPropertyValue(ORDERENTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.orderEntryNr</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the orderEntryNr
	 */
	@Accessor(qualifier = "orderEntryNr", type = Accessor.Type.GETTER)
	public Integer getOrderEntryNr()
	{
		return getPersistenceContext().getPropertyValue(ORDERENTRYNR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.orderID</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the orderID
	 */
	@Accessor(qualifier = "orderID", type = Accessor.Type.GETTER)
	public String getOrderID()
	{
		return getPersistenceContext().getPropertyValue(ORDERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.product</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.GETTER)
	public String getProduct()
	{
		return getPersistenceContext().getPropertyValue(PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBookingLineEntry.quantity</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the quantity
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.GETTER)
	public Long getQuantity()
	{
		return getPersistenceContext().getPropertyValue(QUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.amount</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the amount
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.SETTER)
	public void setAmount(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(AMOUNT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.bookingDate</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the bookingDate
	 */
	@Accessor(qualifier = "bookingDate", type = Accessor.Type.SETTER)
	public void setBookingDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(BOOKINGDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.bookingStatus</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the bookingStatus
	 */
	@Accessor(qualifier = "bookingStatus", type = Accessor.Type.SETTER)
	public void setBookingStatus(final B2BBookingLineStatus value)
	{
		getPersistenceContext().setPropertyValue(BOOKINGSTATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.bookingType</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the bookingType
	 */
	@Accessor(qualifier = "bookingType", type = Accessor.Type.SETTER)
	public void setBookingType(final BookingType value)
	{
		getPersistenceContext().setPropertyValue(BOOKINGTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.costCenter</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the costCenter
	 */
	@Accessor(qualifier = "costCenter", type = Accessor.Type.SETTER)
	public void setCostCenter(final B2BCostCenterModel value)
	{
		getPersistenceContext().setPropertyValue(COSTCENTER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.orderEntry</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the orderEntry
	 */
	@Accessor(qualifier = "orderEntry", type = Accessor.Type.SETTER)
	public void setOrderEntry(final OrderEntryModel value)
	{
		getPersistenceContext().setPropertyValue(ORDERENTRY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.orderEntryNr</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the orderEntryNr
	 */
	@Accessor(qualifier = "orderEntryNr", type = Accessor.Type.SETTER)
	public void setOrderEntryNr(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ORDERENTRYNR, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.orderID</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the orderID
	 */
	@Accessor(qualifier = "orderID", type = Accessor.Type.SETTER)
	public void setOrderID(final String value)
	{
		getPersistenceContext().setPropertyValue(ORDERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.product</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the product
	 */
	@Accessor(qualifier = "product", type = Accessor.Type.SETTER)
	public void setProduct(final String value)
	{
		getPersistenceContext().setPropertyValue(PRODUCT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBookingLineEntry.quantity</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the quantity
	 */
	@Accessor(qualifier = "quantity", type = Accessor.Type.SETTER)
	public void setQuantity(final Long value)
	{
		getPersistenceContext().setPropertyValue(QUANTITY, value);
	}
	
}
