package de.hybris.platform.audit.internal.conditional;

import static de.hybris.platform.audit.internal.conditional.ConditionalAuditCartTest.getAuditRecordsForCart;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.order.CartService;
import de.hybris.platform.persistence.audit.AuditChangeFilter;
import de.hybris.platform.persistence.audit.impl.DefaultAuditableSaver;
import de.hybris.platform.persistence.audit.internal.conditional.ConditionalAuditChangeFilter;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.tx.Transaction;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class ConditionalAuditTxTest extends ServicelayerTest
{
	private static final String CONDITIONAL_AUDIT_CART_CONF = "audit.test/conditional-audit-cart-entry.xml";

	@Resource
	private ProductService productService;

	@Resource
	private CartService cartService;

	@Resource
	private DefaultAuditableSaver auditableSaver;

	@Resource
	private SLDDataContainerProvider sldDataContainerProvider;

	@Resource
	private TypeService typeService;

	@Resource
	private List<AuditChangeFilter> auditChangeFilters;

	@Resource
	private ModelService modelService;

	private ProductModel product0;

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		createDefaultCatalog();

		auditableSaver.setAuditChangeFilters(auditCartsAndEntriesWithNotNullStatusInfo());
		product0 = productService.getProductForCode("testProduct0");
	}

	private List<AuditChangeFilter> auditCartsAndEntriesWithNotNullStatusInfo()
	{
		final ConditionalAuditChangeFilter auditChangeFilter = new ConditionalAuditChangeFilter(CONDITIONAL_AUDIT_CART_CONF,
				sldDataContainerProvider, typeService, Registry.getCurrentTenant().getConfig());

		return Arrays.asList(auditChangeFilter);
	}

	@After
	public void restorePlatformAuditFilters()
	{
		auditableSaver.setAuditChangeFilters(auditChangeFilters);
	}


	@Test
	public void shouldAuditCartAndEntriesDuringSingleSaveInTx()
	{
		// given
		Transaction.current().begin();
		final CartModel cart = cartService.getSessionCart();
		cart.setStatusInfo("should-audit");

		cartService.addNewEntry(cart, product0, 2, null);
		modelService.saveAll();

		// when
		Transaction.current().commit();

		// then
		final ConditionalAuditCartTest.CartAudit auditRecordsForCart = getAuditRecordsForCart(cart);

		assertThat(auditRecordsForCart.cartAudit).hasSize(1);
		assertThat(auditRecordsForCart.productEntryAudit).hasSize(1);
		assertThat(auditRecordsForCart.productEntryAudit.get(product0)).hasSize(1);
	}
}
