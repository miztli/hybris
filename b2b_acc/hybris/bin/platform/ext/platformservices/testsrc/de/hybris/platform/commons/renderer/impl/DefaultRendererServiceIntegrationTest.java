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
package de.hybris.platform.commons.renderer.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import de.hybris.platform.commons.enums.RendererTypeEnum;
import de.hybris.platform.commons.model.renderer.RendererTemplateModel;
import de.hybris.platform.commons.renderer.RendererService;
import de.hybris.platform.commons.renderer.exceptions.RendererException;
import de.hybris.platform.core.systemsetup.datacreator.impl.C2LDataCreator;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionExecutionBody;
import de.hybris.platform.servicelayer.session.SessionService;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class DefaultRendererServiceIntegrationTest extends ServicelayerBaseTest
{
	private static final String CONTENT_PL = "suma: ${ctx.sum}, średnia: ${ctx.avg}";
	private static final String CONTENT_DE = "Summe: ${ctx.sum}, Durchschnitt: ${ctx.avg}";
	private static final String DEFAULT_CONTENT = "sum: ${ctx.sum}, average: ${ctx.avg}";

	@Resource
	private ModelService modelService;
	@Resource
	private RendererService rendererService;
	@Resource
	private I18NService i18NService;
	@Resource
	private C2LDataCreator c2lDataCreator;
	@Resource
	private SessionService sessionService;

	@Before
	public void setUp() throws Exception
	{
		c2lDataCreator.createOrGetLanguage("pl", true);
		c2lDataCreator.createOrGetLanguage("de", true);
	}

	@Test
	public void shouldStoreContentByDefaultInCurrentSessionLanguageAndRenderTemplateInCurrentSessionLanguage()
	{
		// given
		i18NService.setCurrentLocale(new Locale("pl"));
		final RendererTemplateModel templateModel = templateBuilder().withContent(CONTENT_PL).build();
		final StringWriter rendererOutput = new StringWriter();

		// when
		rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), rendererOutput);

		// then
		assertThat(rendererOutput.toString()).isEqualTo("suma: 10, średnia: 5");
	}

	@Test
	public void shouldThrowRendererExceptionWhenTemplateDoesNotHaveContentForCurrentSessionLanguageAndDefaultContentIsNotSet()
	{
		try
		{
			// given
			i18NService.setCurrentLocale(new Locale("pl"));
			final RendererTemplateModel templateModel = templateBuilder().withContent(CONTENT_PL, Locale.ENGLISH).build();
			final StringWriter rendererOutput = new StringWriter();

			// when
			rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), rendererOutput);
			fail("Should throw RendererException");
		}
		catch (final RendererException e)
		{
			// then fine
		}
	}

	@Test
	public void shouldStoreContentByDefaultInCurrentSessionLanguageAndRenderTemplateInCurrentSessionLanguageAsWellAsInDifferentLanguageUsingDefaultTemplate()
	{
		// given
		i18NService.setCurrentLocale(new Locale("pl"));
		final RendererTemplateModel templateModel = templateBuilder().withContent(CONTENT_PL).withDefaultContent(DEFAULT_CONTENT)
				.build();
		final StringWriter englishOutput = new StringWriter();
		final StringWriter polishOutput = new StringWriter();

		// when
		rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), polishOutput);
		sessionService.executeInLocalView(new SessionExecutionBody()
		{
			@Override
			public void executeWithoutResult()
			{
				i18NService.setCurrentLocale(Locale.ENGLISH);
				rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), englishOutput);
			}
		});


		// then
		assertThat(polishOutput.toString()).isEqualTo("suma: 10, średnia: 5");
		assertThat(englishOutput.toString()).isEqualTo("sum: 10, average: 5");
	}

	@Test
	public void shouldRenderInLanguageFromSessionAsWellAsUsingDefaultContentWhenThereIsNoContentForCurrentLanguage()
	{
		// given
		final RendererTemplateModel templateModel = templateBuilder().withContent(CONTENT_PL, new Locale("pl"))
				.withContent(CONTENT_DE, Locale.GERMAN).withDefaultContent(DEFAULT_CONTENT).build();
        final StringWriter englishOutput = new StringWriter();
        final StringWriter polishOutput = new StringWriter();
        final StringWriter germanOutput = new StringWriter();

		// when
        rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), englishOutput);
        sessionService.executeInLocalView(new SessionExecutionBody()
        {
            @Override
            public void executeWithoutResult()
            {
                i18NService.setCurrentLocale(new Locale("pl"));
                rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), polishOutput);
            }
        });
        sessionService.executeInLocalView(new SessionExecutionBody()
        {
            @Override
            public void executeWithoutResult()
            {
                i18NService.setCurrentLocale(new Locale("de"));
                rendererService.render(templateModel, ImmutableMap.of("sum", "10", "avg", "5"), germanOutput);
            }
        });


		// then
        assertThat(polishOutput.toString()).isEqualTo("suma: 10, średnia: 5");
        assertThat(englishOutput.toString()).isEqualTo("sum: 10, average: 5");
        assertThat(germanOutput.toString()).isEqualTo("Summe: 10, Durchschnitt: 5");
	}

	private RendererTemplateBuilder templateBuilder()
	{
		return new RendererTemplateBuilder(modelService);
	}

	public static final class RendererTemplateBuilder
	{
		private final ModelService modelService;
		private String defaultContent;
		private final Map<Locale, String> content;

		public RendererTemplateBuilder(final ModelService modelService)
		{
			this.modelService = modelService;
			this.content = new HashMap<>();
		}

		public RendererTemplateBuilder withContent(final String content)
		{
			this.content.put(null, content);
			return this;
		}

		public RendererTemplateBuilder withContent(final String content, final Locale locale)
		{
			this.content.put(locale, content);
			return this;
		}

		public RendererTemplateBuilder withDefaultContent(final String defaultContent)
		{
			this.defaultContent = defaultContent;
			return this;
		}

		public RendererTemplateModel build()
		{
			final RendererTemplateModel template = modelService.create(RendererTemplateModel.class);
			template.setCode(UUID.randomUUID().toString());
			template.setRendererType(RendererTypeEnum.VELOCITY);
			template.setContextClass("java.util.Map");

			content.forEach((locale, content) -> {
				if (locale == null)
				{
					template.setTemplateScript(content);
				}
				else
				{
					template.setTemplateScript(content, locale);
				}
			});

			template.setDefaultTemplateScript(defaultContent);
			modelService.save(template);

			return template;
		}
	}

}
