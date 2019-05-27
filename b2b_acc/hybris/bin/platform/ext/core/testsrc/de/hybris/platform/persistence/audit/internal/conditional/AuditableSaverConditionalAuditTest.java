package de.hybris.platform.persistence.audit.internal.conditional;

import static de.hybris.platform.persistence.audit.internal.conditional.ConditionalAuditTestUtils.auditTitlesNotEndingWithAudit1andAudit2;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AuditableTest;
import de.hybris.platform.audit.demo.AuditTestConfigManager;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.persistence.audit.AuditChangeFilter;
import de.hybris.platform.persistence.audit.gateway.AuditRecord;
import de.hybris.platform.persistence.audit.gateway.AuditSearchQuery;
import de.hybris.platform.persistence.audit.gateway.ReadAuditGateway;
import de.hybris.platform.persistence.audit.impl.DefaultAuditableSaver;
import de.hybris.platform.persistence.audit.internal.AuditEnablementService;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class AuditableSaverConditionalAuditTest extends ServicelayerBaseTest implements AuditableTest
{
	private static final String PRODUCT_NAME_EN_1 = "prod_en_1";
	private static final String PRODUCT_NAME_DE_1 = "prod_de_1";

	@Resource
	private ReadAuditGateway readAuditGateway;

	@Resource
	private ModelService modelService;

	private AuditTestConfigManager auditTestConfigManager;

	private CatalogModel catalog;
	private CatalogVersionModel catalogVersion;

	private ProductModel product;

	@Resource(name = "auditingEnablementService")
	private AuditEnablementService auditEnablementService;

	@Resource
	private DefaultAuditableSaver auditableSaver;

	@Resource
	private SLDDataContainerProvider sldDataContainerProvider;

	@Resource
	private TypeService typeService;

	@Resource
	private List<AuditChangeFilter> auditChangeFilters;

	@Before
	public void setUp() throws Exception
	{
		auditTestConfigManager = new AuditTestConfigManager(auditEnablementService);
		auditTestConfigManager.enableAuditingForTypes("Title");
		assumeAuditEnabled();

		getOrCreateLanguage("en");
		getOrCreateLanguage("de");

		createCatalogAndCatalogVersion();
	}

	@After
	public void cleanup()
	{
		auditTestConfigManager.resetAuditConfiguration();

		restorePlatformAuditFilters();
	}

	private void restorePlatformAuditFilters()
	{
		auditableSaver.setAuditChangeFilters(auditChangeFilters);
	}

	@Test
	public void shouldPerformConditionalAudit()
	{
		final AuditChangeFilter auditFilter = auditTitlesNotEndingWithAudit1andAudit2(sldDataContainerProvider, typeService);
		auditableSaver.setAuditChangeFilters(Arrays.asList(auditFilter));

		final TitleModel notAuditedTitle = modelService.create(TitleModel.class);
		notAuditedTitle.setCode("foo-audit1");
		modelService.save(notAuditedTitle);

		final List<AuditRecord> notAuditedTitleRecords = getAuditRecordsForType(TitleModel._TYPECODE, notAuditedTitle.getPk());

		final TitleModel title2 = modelService.create(TitleModel.class);
		title2.setCode("title2");
		modelService.save(title2);

		final List<AuditRecord> auditedTitleRecords = getAuditRecordsForType(TitleModel._TYPECODE, title2.getPk());

		assertThat(notAuditedTitleRecords).isEmpty();
		assertThat(auditedTitleRecords).hasSize(1);
	}

	private List<AuditRecord> getAuditRecordsForType(final String type, final PK pk)
	{
		return readAuditGateway.search(AuditSearchQuery.forType(type).withPkSearchRules(pk).build()).collect(toList());
	}


	private void createCatalogAndCatalogVersion()
	{
		catalog = modelService.create(CatalogModel.class);
		catalog.setId(UUID.randomUUID().toString());

		catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setVersion(UUID.randomUUID().toString());
		catalogVersion.setCatalog(catalog);

		product = modelService.create(ProductModel.class);
		product.setCode(UUID.randomUUID().toString());

		product.setName(PRODUCT_NAME_EN_1, Locale.ENGLISH);
		product.setName(PRODUCT_NAME_DE_1, Locale.GERMAN);

		product.setCatalogVersion(catalogVersion);


		modelService.saveAll();
	}

}
