package de.hybris.platform.persistence.audit.internal.conditional;

import static de.hybris.platform.persistence.audit.internal.conditional.ConditionalAuditTestUtils.createDataContainer;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.persistence.audit.AuditableChange;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.ItemPropertyValue;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;


@IntegrationTest
public class ConditionEvaluatorTest extends ServicelayerBaseTest
{
	private static final PK itemPk = PK.createFixedUUIDPK(1, 1);

	@Resource
	private SLDDataContainerProvider sldDataContainerProvider;

	@Resource
	private ModelService modelService;

	@Resource
	private TypeService typeService;

	final PropertyConfigSwitcher testGroupEnabled = new PropertyConfigSwitcher("audit.conditional.test-group.enabled");

	@Before
	public void prepare()
	{
		testGroupEnabled.switchToValue("true");
	}

	@After
	public void cleanup()
	{
		testGroupEnabled.switchBackToDefault();
	}

	@Test
	public void shouldEvaluateAuditConditionForSingleNodeGroup()
	{
		// given
		final ConditionEvaluator evaluator = auditOnlyTitlesWithTitle("audit");

		// when
		final AuditableChange changeNotToBeIgnored = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "audit")));
		final boolean notToBeIgnoredEvaluateResult = evaluator.ignoreAudit(changeNotToBeIgnored);

		// then
		assertThat(notToBeIgnoredEvaluateResult).isFalse();

		// and when
		final AuditableChange changeToBeIgnored = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")));
		final boolean toBeIgnoredEvaluateResult = evaluator.ignoreAudit(changeToBeIgnored);

		// then
		assertThat(toBeIgnoredEvaluateResult).isTrue();
	}

	@Test
	public void shouldTriggerEvaluationForMatchingType()
	{
		// given
		final ConditionEvaluator evaluator = auditOnlyTitlesWithTitle("audit");

		// when
		final AuditableChange changeMatchingTypeIgnored = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")));

		final AuditableChange changeMatchingTypeAudited = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "audit")));

		// then
		assertThat(evaluator.ignoreAudit(changeMatchingTypeIgnored)).isTrue();
		assertThat(evaluator.ignoreAudit(changeMatchingTypeAudited)).isFalse();
	}

	@Test
	public void shouldNotTriggerEvaluationForNotMatchingType()
	{
		// given
		final ConditionEvaluator evaluator = auditOnlyTitlesWithTitle("audit");

		// when
		final AuditableChange changeNotMatchingForWrongType = new AuditableChange(null,
				createDataContainer("Order", itemPk, createMapOf("title", "no-audit")));

		final AuditableChange changeMatchingTypeForWrongType = new AuditableChange(null,
				createDataContainer("Order", itemPk, createMapOf("title", "audit")));

		final AuditableChange changeMatchingTypeForCorrectType = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "audit")));

		final AuditableChange changeNotMatchingTypeForCorrectType = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")));

		// then
		assertThat(evaluator.ignoreAudit(changeNotMatchingForWrongType)).isFalse();
		assertThat(evaluator.ignoreAudit(changeMatchingTypeForWrongType)).isFalse();
		assertThat(evaluator.ignoreAudit(changeMatchingTypeForCorrectType)).isFalse();
		assertThat(evaluator.ignoreAudit(changeNotMatchingTypeForCorrectType)).isTrue();
	}

	@Test
	public void shouldNotThrowExceptionForChangeWithNulls()
	{
		// given
		final ConditionEvaluator evaluator = auditOnlyTitlesWithTitle("audit");

		// when
		final AuditableChange changeMatchingType = new AuditableChange(null, null);

		// then
		assertThat(evaluator.ignoreAudit(changeMatchingType)).isFalse();
	}


	@Test
	public void shouldNotTriggerEvaluationForNotConditionalType()
	{
		// given
		final ConditionalAuditType root = new ConditionalAuditType("Title", false, false, "", Lists.newArrayList(), null);
		final ConditionalAuditGroup group = new ConditionalAuditGroup("test-group", "get('title') == 'audit'", root);

		final ConditionEvaluator evaluator = buildEvaluator(group);

		// when
		final AuditableChange changeForNoConditionalType = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")));

		// then
		assertThat(evaluator.ignoreAudit(changeForNoConditionalType)).isFalse();
	}

	@Test
	public void shouldTriggerEvaluationForSubtype()
	{
		final ConditionalAuditType root = new ConditionalAuditType("AbstractOrder", true, true, "", Lists.newArrayList(), null);
		final ConditionalAuditGroup group = new ConditionalAuditGroup("test-group", "get('code') == 'audit'", root);

		final ConditionEvaluator evaluator = buildEvaluator(group);

		final AuditableChange changeForNoConditionalType = new AuditableChange(null,
				createDataContainer("Order", itemPk, createMapOf("code", "no-audit")));

		final boolean b = evaluator.ignoreAudit(changeForNoConditionalType);

		assertThat(b).isTrue();
	}


	@Test
	public void shouldStillAuditRootTypeIfBeforeChangeMatchesCondition()
	{
		// given
		final ConditionEvaluator evaluator = auditOnlyTitlesWithTitle("audit");

		final AuditableChange auditableToNonAuditable = new AuditableChange(
				createDataContainer("Title", itemPk, createMapOf("title", "audit")),
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")));

		final AuditableChange auditableToNull = new AuditableChange(
				createDataContainer("Title", itemPk, createMapOf("title", "audit")), null);

		final AuditableChange nonAuditableToAuditable = new AuditableChange(
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")),
				createDataContainer("Title", itemPk, createMapOf("title", "audit")));

		final AuditableChange nullToAuditable = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "audit")));

		// when
		testGroupEnabled.switchToValue(null);

		// then
		assertThat(evaluator.ignoreAudit(auditableToNonAuditable)).isFalse();
		assertThat(evaluator.ignoreAudit(auditableToNull)).isFalse();
		assertThat(evaluator.ignoreAudit(nonAuditableToAuditable)).isFalse();
		assertThat(evaluator.ignoreAudit(nullToAuditable)).isFalse();
	}


	@Test
	public void shouldDisableConditionalGroupByProperty()
	{
		// given
		final ConditionEvaluator evaluator = auditOnlyTitlesWithTitle("audit");
		final AuditableChange changeToAudit = new AuditableChange(null,
				createDataContainer("Title", itemPk, createMapOf("title", "no-audit")));

		// when
		testGroupEnabled.switchToValue(null);

		// then
		assertThat(evaluator.ignoreAudit(changeToAudit)).isTrue();

		// and when
		testGroupEnabled.switchToValue("false");

		// then
		assertThat(evaluator.ignoreAudit(changeToAudit)).isFalse();

		// and when
		testGroupEnabled.switchToValue("true");

		// then
		assertThat(evaluator.ignoreAudit(changeToAudit)).isTrue();
	}


	@Test
	public void shouldEvaluateConditionOnRootType()
	{
		// given
		final ConditionalAuditType titleAudit = new ConditionalAuditType("Title", true, false, "", Lists.newArrayList(), null);
		final ConditionalAuditType addressAudit = new ConditionalAuditType("Address", true, false, "title", Lists.newArrayList(),
				titleAudit);
		titleAudit.getChildren().add(addressAudit);

		final ConditionalAuditGroup group = new ConditionalAuditGroup("title-address-group", "!get('code').endsWith('_noaudit')",
				titleAudit);
		final ConditionEvaluator evaluator = buildEvaluator(group);

		final TitleModel noAuditableTitle = modelService.create(TitleModel.class);
		noAuditableTitle.setCode(UUID.randomUUID().toString() + "_noaudit");
		noAuditableTitle.setName("title");

		final TitleModel auditableTitle = modelService.create(TitleModel.class);
		auditableTitle.setCode(UUID.randomUUID().toString());
		auditableTitle.setName("title");

		final AddressModel address = modelService.create(AddressModel.class);
		address.setOwner(noAuditableTitle);
		modelService.saveAll(noAuditableTitle, auditableTitle, address);

		// when
		final AuditableChange changeToBeIgnored = new AuditableChange(null, createDataContainer("Address", address.getPk(),
				createMapOf("name", "n", "title", new ItemPropertyValue(noAuditableTitle.getPk()))));

		final boolean toBeIgnoredEvaluateResult = evaluator.ignoreAudit(changeToBeIgnored);

		assertThat(toBeIgnoredEvaluateResult).isTrue();

		// and when
		final AuditableChange changeToBeAudited = new AuditableChange(null, createDataContainer("Address", address.getPk(),
				createMapOf("name", "n", "title", new ItemPropertyValue(auditableTitle.getPk()))));

		final boolean toBeAuditedEvaluateResult = evaluator.ignoreAudit(changeToBeAudited);

		assertThat(toBeAuditedEvaluateResult).isFalse();
	}

	private ConditionEvaluator auditOnlyTitlesWithTitle(final String title)
	{
		return buildConditionalAuditForTitle("test-group", String.format("get('title') == '%s'", title));
	}

	private ConditionEvaluator buildConditionalAuditForTitle(final String groupName, final String condition)
	{
		final ConditionalAuditType root = new ConditionalAuditType("Title", true, false, "", Lists.newArrayList(), null);
		final ConditionalAuditGroup group = new ConditionalAuditGroup(groupName, condition, root);
		return buildEvaluator(group);
	}


	private ConditionEvaluator buildEvaluator(final ConditionalAuditGroup group)
	{
		return new ConditionEvaluator(group, sldDataContainerProvider, typeService, Registry.getCurrentTenant().getConfig());
	}

	private Map<String, Object> createMapOf(final String key, final Object value)
	{
		final Map<String, Object> result = new HashMap<>();
		result.put(key, value);
		return result;
	}

	private Map<String, Object> createMapOf(final String key, final Object value, final String key2, final Object value2)
	{
		final Map<String, Object> result = new HashMap<>();
		result.put(key, value);
		result.put(key2, value2);
		return result;
	}

}
