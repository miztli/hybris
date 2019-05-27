/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.converters.config;


import de.hybris.platform.converters.ModifiableConfigurablePopulator;
import de.hybris.platform.converters.Populator;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Required;


/**
 * Spring Bean used to modify {@link ModifiableConfigurablePopulator} instances. Supports adding or removing a
 * populator.
 */
public class ConfigurablePopulatorModification<SOURCE, TARGET, OPTION>
{
	private ModifiableConfigurablePopulator<SOURCE, TARGET, OPTION> target;
	private String key;
	private Class keyType;
	private Populator<SOURCE, TARGET> add;
	private Populator<SOURCE, TARGET> remove;
	private Object resolvedKey;

	@PostConstruct
	public void initialize()
	{
		try
		{
			if (getKeyType() == null || String.class.equals(getKeyType()))
			{
				resolvedKey = key;
			}
			else if (Class.class.equals(getKeyType()))
			{
				resolvedKey = Class.forName(key);
			}
			else
			{
				final Method valueOf = getKeyType().getMethod("valueOf", String.class);
				resolvedKey = valueOf.invoke(null, key);
			}
		}
		catch (final ReflectiveOperationException e)
		{
			throw new BeanInitializationException("Could not create key [" + key + "] of type [" + getKeyType() + "].", e);
		}
	}

	public ModifiableConfigurablePopulator<SOURCE, TARGET, OPTION> getTarget()
	{
		return target;
	}

	@Required
	public void setTarget(final ModifiableConfigurablePopulator<SOURCE, TARGET, OPTION> target)
	{
		this.target = target;
	}

	public Object getResolvedKey()
	{
		return resolvedKey;
	}

	@Required
	public void setKey(final String key)
	{
		this.key = key;
	}

	protected Class getKeyType()
	{
		return keyType;
	}

	@Required
	public void setKeyType(final Class keyType)
	{
		this.keyType = keyType;
	}

	public Populator<SOURCE, TARGET> getAdd()
	{
		return add;
	}

	public void setAdd(final Populator<SOURCE, TARGET> add)
	{
		this.add = add;
	}

	public Populator<SOURCE, TARGET> getRemove()
	{
		return remove;
	}

	public void setRemove(final Populator<SOURCE, TARGET> remove)
	{
		this.remove = remove;
	}
}
