/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.commons.renderer.model;

import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.commons.model.renderer.RendererTemplateModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Required;


public class DefaultTemplateScriptAttributeHandler implements DynamicAttributeHandler<String, RendererTemplateModel>
{
	private static final String DEFAULT_TEMPLATE_SCRIPT_NAME = "{0}_defaultTemplateScript";
	private MediaService mediaService;
	private ModelService modelService;

	@Override
	public String get(final RendererTemplateModel templateModel)
	{
		final MediaModel defaultContent = templateModel.getDefaultContent();

		if (defaultContent == null || !mediaService.hasData(defaultContent))
		{
			return null;
		}

		try
		{
			return IOUtils.toString(mediaService.getStreamFromMedia(defaultContent), "UTF-8");
		}
		catch (final IOException e)
		{
			throw new SystemException(e);
		}
	}

	@Override
	public void set(final RendererTemplateModel templateModel, final String templateValue)
	{
		final MediaModel mediaContent = templateModel.getDefaultContent();
		if (StringUtils.isEmpty(templateValue))
		{
			removeExistingData(mediaContent);
		}
		else
		{
			createOrSetData(templateModel, templateValue, mediaContent);
		}
	}

	private void removeExistingData(final MediaModel mediaContent)
	{
		if (mediaContent != null)
		{
			mediaService.removeDataFromMedia(mediaContent);
		}
	}

	private void createOrSetData(final RendererTemplateModel templateModel, final String templateValue,
			final MediaModel mediaContent)
	{
		final InputStream is = IOUtils.toInputStream(templateValue, Charsets.toCharset("UTF-8"));
		try
		{
			if (mediaContent == null)
			{
				final MediaModel newMedia = createMedia(templateModel.getCode());
				mediaService.setStreamForMedia(newMedia, is);
				templateModel.setDefaultContent(newMedia);
			}
			else
			{
				mediaService.setStreamForMedia(mediaContent, is);
			}
		}
		finally
		{
			IOUtils.closeQuietly(is);
		}
	}

	private MediaModel createMedia(final String templateCode)
	{
		final String mediaCode = MessageFormat.format(DEFAULT_TEMPLATE_SCRIPT_NAME, templateCode);

		final CatalogUnawareMediaModel media = modelService.create(CatalogUnawareMediaModel.class);
		media.setCode(mediaCode);
		media.setRealFileName(mediaCode);
		media.setMime("plain/text");

		modelService.save(media);

		return media;
	}

	@Required
	public void setMediaService(final MediaService mediaService)
	{
		this.mediaService = mediaService;
	}

	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}
}
