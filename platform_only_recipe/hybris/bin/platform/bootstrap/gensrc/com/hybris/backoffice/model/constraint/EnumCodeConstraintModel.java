/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 4:37:40 PM                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.backoffice.model.constraint;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;

/**
 * Generated model class for type EnumCodeConstraint first defined at extension backoffice.
 * <p>
 * Custom constraint which checks if the approval status matches.
 */
@SuppressWarnings("all")
public class EnumCodeConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "EnumCodeConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>EnumCodeConstraint.code</code> attribute defined at extension <code>backoffice</code>. */
	public static final String CODE = "code";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public EnumCodeConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public EnumCodeConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>EnumCodeConstraint</code> at extension <code>backoffice</code>
	 * @param _code initial attribute declared by type <code>EnumCodeConstraint</code> at extension <code>backoffice</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 */
	@Deprecated
	public EnumCodeConstraintModel(final Class _annotation, final String _code, final String _id)
	{
		super();
		setAnnotation(_annotation);
		setCode(_code);
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>EnumCodeConstraint</code> at extension <code>backoffice</code>
	 * @param _code initial attribute declared by type <code>EnumCodeConstraint</code> at extension <code>backoffice</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public EnumCodeConstraintModel(final Class _annotation, final String _code, final String _id, final ItemModel _owner)
	{
		super();
		setAnnotation(_annotation);
		setCode(_code);
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EnumCodeConstraint.code</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the code - Status to match
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EnumCodeConstraint.code</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the code - Status to match
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
}
