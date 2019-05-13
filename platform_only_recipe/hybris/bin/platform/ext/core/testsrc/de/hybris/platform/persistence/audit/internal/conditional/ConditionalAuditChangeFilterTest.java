package de.hybris.platform.persistence.audit.internal.conditional;


import static de.hybris.platform.persistence.audit.internal.conditional.ConditionalAuditTestUtils.auditTitlesNotEndingWithAudit1andAudit2;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.directpersistence.cache.SLDDataContainer;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.persistence.audit.AuditChangeFilter;
import de.hybris.platform.persistence.audit.AuditableChange;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;


@IntegrationTest
public class ConditionalAuditChangeFilterTest extends ServicelayerBaseTest
{
	private static final PK itemPk = PK.createFixedUUIDPK(1, 1);

	@Resource
	private SLDDataContainerProvider sldDataContainerProvider;

	@Resource
	private TypeService typeService;

	@Test
	public void shouldEvaluateAllGroupsInOrder()
	{
		final AuditChangeFilter auditFilter = auditTitlesNotEndingWithAudit1andAudit2(sldDataContainerProvider, typeService);

		final boolean matchedByFirstRule = auditFilter.ignoreAudit(newTitleAuditableChange("foo_audit1"));
		assertThat(matchedByFirstRule).isTrue();

		final boolean matchedBySecondRule = auditFilter.ignoreAudit(newTitleAuditableChange("foo_audit2"));
		assertThat(matchedBySecondRule).isTrue();

		final boolean notMatched = auditFilter.ignoreAudit(newTitleAuditableChange("foo3"));
		assertThat(notMatched).isFalse();
	}

	private AuditableChange newTitleAuditableChange(final String newCode)
	{
		final SLDDataContainer dataContainer = ConditionalAuditTestUtils.createDataContainer("Title", itemPk,
				createMapOf("code", newCode));
		return new AuditableChange(null, dataContainer);
	}

	private Map<String, Object> createMapOf(final String key, final Object value)
	{
		final Map<String, Object> result = new HashMap<>();
		result.put(key, value);
		return result;
	}
}
