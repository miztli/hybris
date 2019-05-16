/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 12:43:01 PM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.validation.model.constraints.jsr303;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;
import java.math.BigDecimal;

/**
 * Generated model class for type DecimalMaxConstraint first defined at extension validation.
 * <p>
 * Decimal maximal JSR 303 compatible constraint class.
 */
@SuppressWarnings("all")
public class DecimalMaxConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "DecimalMaxConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>DecimalMaxConstraint.value</code> attribute defined at extension <code>validation</code>. */
	public static final String VALUE = "value";
	
	/** <i>Generated constant</i> - Attribute key of <code>DecimalMaxConstraint.inclusive</code> attribute defined at extension <code>validation</code>. */
	public static final String INCLUSIVE = "inclusive";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public DecimalMaxConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public DecimalMaxConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>DecimalMaxConstraint</code> at extension <code>validation</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _value initial attribute declared by type <code>DecimalMaxConstraint</code> at extension <code>validation</code>
	 */
	@Deprecated
	public DecimalMaxConstraintModel(final Class _annotation, final String _id, final BigDecimal _value)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setValue(_value);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>DecimalMaxConstraint</code> at extension <code>validation</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _value initial attribute declared by type <code>DecimalMaxConstraint</code> at extension <code>validation</code>
	 */
	@Deprecated
	public DecimalMaxConstraintModel(final Class _annotation, final String _id, final ItemModel _owner, final BigDecimal _value)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setOwner(_owner);
		setValue(_value);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DecimalMaxConstraint.inclusive</code> attribute defined at extension <code>validation</code>. 
	 * @return the inclusive - Inclusive
	 */
	@Accessor(qualifier = "inclusive", type = Accessor.Type.GETTER)
	public Boolean getInclusive()
	{
		return getPersistenceContext().getPropertyValue(INCLUSIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DecimalMaxConstraint.value</code> attribute defined at extension <code>validation</code>. 
	 * @return the value - Maximal value
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.GETTER)
	public BigDecimal getValue()
	{
		return getPersistenceContext().getPropertyValue(VALUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DecimalMaxConstraint.inclusive</code> attribute defined at extension <code>validation</code>. 
	 *  
	 * @param value the inclusive - Inclusive
	 */
	@Accessor(qualifier = "inclusive", type = Accessor.Type.SETTER)
	public void setInclusive(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(INCLUSIVE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>DecimalMaxConstraint.value</code> attribute defined at extension <code>validation</code>. 
	 *  
	 * @param value the value - Maximal value
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.SETTER)
	public void setValue(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(VALUE, value);
	}
	
}
