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
package de.hybris.platform.servicelayer;

import de.hybris.platform.core.Registry;
import de.hybris.platform.util.AppendSpringConfiguration;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ReflectionUtils;


/**
 * This class holds common logic used in Servicelayer Base Tests
 */
public class ServicelayerBaseTestLogic
{
	private static final Logger LOG = Logger.getLogger(ServicelayerBaseTestLogic.class);

	private ApplicationContext applicationContext;

	public void prepareApplicationContextAndSession(final Object test) throws Exception
	{
		final ApplicationContext parentContext = Registry.getApplicationContext();
		if (test.getClass().isAnnotationPresent(AppendSpringConfiguration.class))
		{
			final String[] springConfiguration = test.getClass().getAnnotation(AppendSpringConfiguration.class).value();
			applicationContext = new ClassPathXmlApplicationContext(springConfiguration, parentContext);
		}
		else
		{
			applicationContext = parentContext;
		}

		autowireProperties(applicationContext, test);
	}

	protected void autowireProperties(final ApplicationContext applicationContext, final Object test)
	{
		final AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
		final Set<String> missing = new LinkedHashSet<String>();

		ReflectionUtils.doWithFields(test.getClass(), new ReflectionUtils.FieldCallback()
		{
			@Override
			public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException
			{
				final Resource resource = field.getAnnotation(Resource.class);
				if (resource != null)
				{
					field.setAccessible(true);
					Object bean = ReflectionUtils.getField(field, test);
					if (bean == null)
					{
						final String beanName = getBeanName(resource, field);
						try
						{
							bean = beanFactory.getBean(beanName, field.getType());
							if (bean != null)
							{
								ReflectionUtils.setField(field, test, bean);
							}
						}
						catch (final BeansException e)
						{
							LOG.error("error fetching bean " + beanName + " : " + e.getMessage(), e);
						}
						if (bean == null)
						{
							missing.add(field.getName());
						}
					}
				}
			}
		});
		if (!missing.isEmpty())
		{
			throw new IllegalStateException(
					"test " + test.getClass().getSimpleName() + " is not properly initialized - missing bean references " + missing);
		}
	}

	protected String getBeanName(final Resource resource, final Field field)
	{
		if (resource.mappedName() != null && resource.mappedName().length() > 0)
		{
			return resource.mappedName();
		}
		else if (resource.name() != null && resource.name().length() > 0)
		{
			return resource.name();
		}
		else
		{
			return field.getName();
		}
	}

	public ApplicationContext getApplicationContext()
	{
		if (applicationContext != null)
		{
			return applicationContext;
		}
		return Registry.getApplicationContext();
	}

}
