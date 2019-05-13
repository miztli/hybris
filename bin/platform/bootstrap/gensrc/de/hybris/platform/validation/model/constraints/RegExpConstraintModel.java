/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 10, 2019 3:20:53 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.validation.model.constraints;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;

/**
 * Generated model class for type RegExpConstraint first defined at extension personalizationservices.
 * <p>
 * Constraint which checks if value is correct regular expression.
 */
@SuppressWarnings("all")
public class RegExpConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "RegExpConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>RegExpConstraint.notEmpty</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String NOTEMPTY = "notEmpty";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public RegExpConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public RegExpConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>RegExpConstraint</code> at extension <code>personalizationservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 */
	@Deprecated
	public RegExpConstraintModel(final Class _annotation, final String _id)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>RegExpConstraint</code> at extension <code>personalizationservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public RegExpConstraintModel(final Class _annotation, final String _id, final ItemModel _owner)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RegExpConstraint.notEmpty</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the notEmpty - Define if empty value is allowed
	 */
	@Accessor(qualifier = "notEmpty", type = Accessor.Type.GETTER)
	public boolean isNotEmpty()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(NOTEMPTY));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>RegExpConstraint.notEmpty</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the notEmpty - Define if empty value is allowed
	 */
	@Accessor(qualifier = "notEmpty", type = Accessor.Type.SETTER)
	public void setNotEmpty(final boolean value)
	{
		getPersistenceContext().setPropertyValue(NOTEMPTY, toObject(value));
	}
	
}
