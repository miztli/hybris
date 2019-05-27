package de.hybris.platform.audit.internal.conditional;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.order.CartService;
import de.hybris.platform.persistence.audit.AuditChangeFilter;
import de.hybris.platform.persistence.audit.gateway.AuditRecord;
import de.hybris.platform.persistence.audit.gateway.AuditSearchQuery;
import de.hybris.platform.persistence.audit.gateway.ReadAuditGateway;
import de.hybris.platform.persistence.audit.impl.DefaultAuditableSaver;
import de.hybris.platform.persistence.audit.internal.conditional.ConditionalAuditChangeFilter;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;


@IntegrationTest
public class ConditionalAuditCartTest extends ServicelayerTest
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
	private ProductModel product1;
	private ProductModel product2;

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		createDefaultCatalog();

		auditableSaver.setAuditChangeFilters(auditCartsAndEntriesWithNotNullStatusInfo());

		product0 = productService.getProductForCode("testProduct0");
		product1 = productService.getProductForCode("testProduct1");
		product2 = productService.getProductForCode("testProduct2");
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
	public void shouldRecordAuditWhenMatchingConfig()
	{
		cartService.removeSessionCart();
		final CartModel auditedCart = cartService.getSessionCart();
		final CartAuditRecorder recorder = new CartAuditRecorder(auditedCart);

		assertThat(recorder.newAuditRecorded()).isFalse();

		auditedCart.setStatusInfo("audited-cart");
		modelService.save(auditedCart);

		assertThat(recorder.newAuditRecorded()).isTrue();

		final CartEntryModel product0Entry = cartService.addNewEntry(auditedCart, product0, 2, null);
		modelService.saveAll();

		assertThat(recorder.newAuditRecorded()).isTrue();
		assertThat(recorder.newAuditRecorded()).isFalse();

		final CartEntryModel product1Entry = cartService.addNewEntry(auditedCart, product1, 1, null);
		cartService.addNewEntry(auditedCart, product2, 1, null);
		modelService.saveAll();

		product0Entry.setQuantity(10L);
		modelService.saveAll();

		assertThat(recorder.newAuditRecorded()).isTrue();

		modelService.remove(product1Entry);

		assertThat(recorder.newAuditRecorded()).isTrue();
		assertThat(recorder.noAuditRecorded()).isFalse();
	}

	@Test
	public void shouldNotRecordAuditWhenNotMatchingConfig()
	{
		cartService.removeSessionCart();
		final CartModel notAuditedCart = cartService.getSessionCart();

		final CartAuditRecorder recorder = new CartAuditRecorder(notAuditedCart);

		assertThat(recorder.newAuditRecorded()).isFalse();

		modelService.save(notAuditedCart);

		assertThat(recorder.newAuditRecorded()).isFalse();

		cartService.addNewEntry(notAuditedCart, product0, 2, null);
		modelService.saveAll();

		assertThat(recorder.newAuditRecorded()).isFalse();

		cartService.addNewEntry(notAuditedCart, product1, 1, null);
		cartService.addNewEntry(notAuditedCart, product2, 1, null);
		modelService.saveAll();

		assertThat(recorder.newAuditRecorded()).isFalse();
	}


	private static class CartAuditRecorder
	{
		private final CartModel cart;

		private final List<CartAudit> audits = new ArrayList<>();

		private CartAuditRecorder(final CartModel cart)
		{
			this.cart = cart;
		}

		public boolean newAuditRecorded()
		{
			final CartAudit currentAudits = getAuditRecordsForCart(cart);

			if (audits.isEmpty())
			{
				audits.add(currentAudits);
				return currentAudits.recordedAuditsNumber() > 0;
			}

			final CartAudit lastAudit = Iterables.getLast(audits);
			audits.add(currentAudits);

			return currentAudits.recordedAuditsNumber() > lastAudit.recordedAuditsNumber();
		}


		public boolean noAuditRecorded()
		{
			return audits.stream().allMatch(i -> i.noAuditRecorded());
		}

	}

	public static class CartAudit
	{
		List<AuditRecord> cartAudit;
		Map<ProductModel, List<AuditRecord>> productEntryAudit = new HashMap<>();

		boolean noAuditRecorded()
		{
			return !recordedAudit();
		}

		boolean recordedAudit()
		{
			if (cartAudit != null && !cartAudit.isEmpty())
			{
				return true;
			}

			return productEntryAudit.values().stream().anyMatch(i -> !i.isEmpty());
		}

		int recordedAuditsNumber()
		{
			int counter = cartAudit != null ? cartAudit.size() : 0;

			for (final List<AuditRecord> audits : productEntryAudit.values())
			{
				counter += audits.size();
			}

			return counter;
		}
	}


	public static CartAudit getAuditRecordsForCart(final CartModel cart)
	{
		final CartAudit result = new CartAudit();
		result.cartAudit = getAuditRecordsFor(CartModel._TYPECODE, cart.getPk());

		for (final AbstractOrderEntryModel entry : cart.getEntries())
		{
			final List<AuditRecord> entryAudit = getAuditRecordsFor(CartEntryModel._TYPECODE, entry.getPk());
			result.productEntryAudit.put(entry.getProduct(), entryAudit);
		}

		return result;
	}

	private static List<AuditRecord> getAuditRecordsFor(final String type, final PK pk)
	{
		final ReadAuditGateway readAuditGateway = Registry.getApplicationContext().getBean("readAuditGateway",
				ReadAuditGateway.class);
		return readAuditGateway.search(AuditSearchQuery.forType(type).withPkSearchRules(pk).build()).collect(toList());
	}

}
