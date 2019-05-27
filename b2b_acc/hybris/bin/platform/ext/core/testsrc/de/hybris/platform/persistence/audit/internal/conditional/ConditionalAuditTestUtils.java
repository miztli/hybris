package de.hybris.platform.persistence.audit.internal.conditional;

import static org.mockito.BDDMockito.given;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.directpersistence.cache.SLDDataContainer;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.persistence.audit.AuditChangeFilter;
import de.hybris.platform.persistence.property.TypeInfoMap;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mockito.Mockito;

import com.google.common.collect.Lists;

public class ConditionalAuditTestUtils
{
	private static final PK typePk = PK.createFixedUUIDPK(2, 2);


	public static AuditChangeFilter auditTitlesNotEndingWithAudit1andAudit2(
			final SLDDataContainerProvider sldDataContainerProvider, final TypeService typeService)
	{
		return new ConditionalAuditChangeFilter(
				"audit.test/conditional-audit-address-title.xml", sldDataContainerProvider, typeService,
				Registry.getCurrentTenant().getConfig());
	}

	public static SLDDataContainer createDataContainer(final String typeCode, final PK pk, final Map<String, Object> attributes)
	{
		final TypeInfoMap typeInfoMap = Mockito.mock(TypeInfoMap.class);
		given(typeInfoMap.getCode()).willReturn(typeCode);

		final List<SLDDataContainer.AttributeValue> containerAttributes = attributes.entrySet().stream() //
		                                                                            .map(i -> newAttribute(i.getKey(),
				                                                                            i.getValue())) //
		                                                                            .collect(Collectors.toList());


		final SLDDataContainer container = SLDDataContainer.builder() //
		                                                   .withPk(pk) //
		                                                   .withTypePk(typePk) //
		                                                   .withTypeInfoMap(typeInfoMap) //
		                                                   .withAttributes(Lists.newArrayList(containerAttributes)) //
		                                                   .withVersion(Long.valueOf(1)).build();

		return container;
	}

	private static SLDDataContainer.AttributeValue newAttribute(final String attr, final Object value)
	{
		return new SLDDataContainer.AttributeValue(attr, value);
	}
}
