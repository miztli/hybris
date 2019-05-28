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
package de.hybris.platform.apiregistryservices.model.constraints;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.validation.enums.RegexpFlag;
import de.hybris.platform.validation.model.constraints.TypeConstraintModel;
import java.util.Set;

/**
 * Generated model class for type EventMappingConstraint first defined at extension apiregistryservices.
 * <p>
 * Custom constraint which checks if the MappingType and mappingConfiguration/converterBean of EventConfiguration are valid.
 */
@SuppressWarnings("all")
public class EventMappingConstraintModel extends TypeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "EventMappingConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventMappingConstraint.keyRegexp</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String KEYREGEXP = "keyRegexp";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventMappingConstraint.keyFlags</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String KEYFLAGS = "keyFlags";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventMappingConstraint.valueRegexp</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String VALUEREGEXP = "valueRegexp";
	
	/** <i>Generated constant</i> - Attribute key of <code>EventMappingConstraint.valueFlags</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String VALUEFLAGS = "valueFlags";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public EventMappingConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public EventMappingConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _keyFlags initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _keyRegexp initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _valueFlags initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _valueRegexp initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public EventMappingConstraintModel(final Class _annotation, final String _id, final Set<RegexpFlag> _keyFlags, final String _keyRegexp, final Set<RegexpFlag> _valueFlags, final String _valueRegexp)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setKeyFlags(_keyFlags);
		setKeyRegexp(_keyRegexp);
		setValueFlags(_valueFlags);
		setValueRegexp(_valueRegexp);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _keyFlags initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _keyRegexp initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _valueFlags initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 * @param _valueRegexp initial attribute declared by type <code>EventMappingConstraint</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated
	public EventMappingConstraintModel(final Class _annotation, final String _id, final Set<RegexpFlag> _keyFlags, final String _keyRegexp, final ItemModel _owner, final Set<RegexpFlag> _valueFlags, final String _valueRegexp)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setKeyFlags(_keyFlags);
		setKeyRegexp(_keyRegexp);
		setOwner(_owner);
		setValueFlags(_valueFlags);
		setValueRegexp(_valueRegexp);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventMappingConstraint.keyFlags</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the keyFlags - Regular expression for constraint
	 */
	@Accessor(qualifier = "keyFlags", type = Accessor.Type.GETTER)
	public Set<RegexpFlag> getKeyFlags()
	{
		return getPersistenceContext().getPropertyValue(KEYFLAGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventMappingConstraint.keyRegexp</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the keyRegexp - Regular expression of toString() Map key representation
	 */
	@Accessor(qualifier = "keyRegexp", type = Accessor.Type.GETTER)
	public String getKeyRegexp()
	{
		return getPersistenceContext().getPropertyValue(KEYREGEXP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventMappingConstraint.valueFlags</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the valueFlags - Regular expression for constraint
	 */
	@Accessor(qualifier = "valueFlags", type = Accessor.Type.GETTER)
	public Set<RegexpFlag> getValueFlags()
	{
		return getPersistenceContext().getPropertyValue(VALUEFLAGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EventMappingConstraint.valueRegexp</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the valueRegexp - Regular expression of toString() Map value representation
	 */
	@Accessor(qualifier = "valueRegexp", type = Accessor.Type.GETTER)
	public String getValueRegexp()
	{
		return getPersistenceContext().getPropertyValue(VALUEREGEXP);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventMappingConstraint.keyFlags</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the keyFlags - Regular expression for constraint
	 */
	@Accessor(qualifier = "keyFlags", type = Accessor.Type.SETTER)
	public void setKeyFlags(final Set<RegexpFlag> value)
	{
		getPersistenceContext().setPropertyValue(KEYFLAGS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventMappingConstraint.keyRegexp</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the keyRegexp - Regular expression of toString() Map key representation
	 */
	@Accessor(qualifier = "keyRegexp", type = Accessor.Type.SETTER)
	public void setKeyRegexp(final String value)
	{
		getPersistenceContext().setPropertyValue(KEYREGEXP, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventMappingConstraint.valueFlags</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the valueFlags - Regular expression for constraint
	 */
	@Accessor(qualifier = "valueFlags", type = Accessor.Type.SETTER)
	public void setValueFlags(final Set<RegexpFlag> value)
	{
		getPersistenceContext().setPropertyValue(VALUEFLAGS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>EventMappingConstraint.valueRegexp</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the valueRegexp - Regular expression of toString() Map value representation
	 */
	@Accessor(qualifier = "valueRegexp", type = Accessor.Type.SETTER)
	public void setValueRegexp(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUEREGEXP, value);
	}
	
}
