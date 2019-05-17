/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 17, 2019 5:35:17 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.platformbackoffice.validation.model.constraints;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;

/**
 * Generated model class for type HybrisEnumValueCodeConstraint first defined at extension platformbackoffice.
 * <p>
 * HybrisEnumValueCode constraint definition.
 */
@SuppressWarnings("all")
public class HybrisEnumValueCodeConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "HybrisEnumValueCodeConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>HybrisEnumValueCodeConstraint.value</code> attribute defined at extension <code>platformbackoffice</code>. */
	public static final String VALUE = "value";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public HybrisEnumValueCodeConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public HybrisEnumValueCodeConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>HybrisEnumValueCodeConstraint</code> at extension <code>platformbackoffice</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _value initial attribute declared by type <code>HybrisEnumValueCodeConstraint</code> at extension <code>platformbackoffice</code>
	 */
	@Deprecated
	public HybrisEnumValueCodeConstraintModel(final Class _annotation, final String _id, final String _value)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setValue(_value);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>HybrisEnumValueCodeConstraint</code> at extension <code>platformbackoffice</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _value initial attribute declared by type <code>HybrisEnumValueCodeConstraint</code> at extension <code>platformbackoffice</code>
	 */
	@Deprecated
	public HybrisEnumValueCodeConstraintModel(final Class _annotation, final String _id, final ItemModel _owner, final String _value)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setOwner(_owner);
		setValue(_value);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisEnumValueCodeConstraint.value</code> attribute defined at extension <code>platformbackoffice</code>. 
	 * @return the value - HybrisEnumValue code to be checked by this constraint
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.GETTER)
	public String getValue()
	{
		return getPersistenceContext().getPropertyValue(VALUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>HybrisEnumValueCodeConstraint.value</code> attribute defined at extension <code>platformbackoffice</code>. 
	 *  
	 * @param value the value - HybrisEnumValue code to be checked by this constraint
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.SETTER)
	public void setValue(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUE, value);
	}
	
}
