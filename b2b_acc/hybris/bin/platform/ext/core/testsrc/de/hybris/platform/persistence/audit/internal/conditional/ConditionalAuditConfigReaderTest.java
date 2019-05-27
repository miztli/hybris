package de.hybris.platform.persistence.audit.internal.conditional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.Test;


@UnitTest
public class ConditionalAuditConfigReaderTest
{

	final ConditionalAuditConfigReader configReader = new ConditionalAuditConfigReader();

	@Test
	public void shouldReadConfigurationFile()
	{
		final ConditionalAuditConfig conditionalAuditConfig = configReader.fromClasspathXml("audit.test/conditional-audit-order-entry-user.xml");

		final ConditionalAuditGroup group = conditionalAuditConfig.getGroup("order-entry-user");

		assertThat(group.getName()).isEqualTo("order-entry-user");
		assertThat(group.getCondition()).isEqualTo("get('code').endsWith('_audit')");

		final ConditionalAuditType user = group.getRootType();

		assertThat(user.getCode()).isEqualTo("User");
		assertThat(user.isConditional()).isFalse();
		assertThat(user.isSubtypes()).isTrue();
		assertThat(user.getParent()).isNull();
		assertThat(user.getChildren()).hasSize(1);

		final ConditionalAuditType order = user.getChildren().get(0);

		assertThat(order.getCode()).isEqualTo("Order");
		assertThat(order.isConditional()).isTrue();
		assertThat(order.isSubtypes()).isFalse();
		assertThat(order.getParent()).isEqualTo(user);
		assertThat(order.getChildren()).hasSize(1);

		final ConditionalAuditType orderEntry = order.getChildren().get(0);

		assertThat(orderEntry.getCode()).isEqualTo("OrderEntry");
		assertThat(orderEntry.isConditional()).isTrue();
		assertThat(orderEntry.isSubtypes()).isFalse();
		assertThat(orderEntry.getParent()).isEqualTo(order);
		assertThat(orderEntry.getChildren()).isEmpty();
	}

	@Test
	public void shouldReadTypeWithTwoChildren()
	{
		final ConditionalAuditConfig conditionalAuditConfig = configReader.fromClasspathXml("audit.test/conditional-audit-order-entry-user.xml");

		final ConditionalAuditGroup group = conditionalAuditConfig.getGroup("user-cart-order");

		assertThat(group.getName()).isEqualTo("user-cart-order");
		assertThat(group.getCondition()).isEqualTo("get('savetime') != null");

		final ConditionalAuditType user = group.getRootType();
		assertThat(user.getChildren()).hasSize(2);

		assertThat(user.getChildren()) //
				.extracting(i -> i.getCode(), i -> i.getAttribute()) //
				.contains(tuple("Cart", "order"), tuple("Order", "order"));
	}


	@Test
	public void shouldGetTypeByName()
	{
		final ConditionalAuditConfig conditionalAuditConfig = configReader.fromClasspathXml("audit.test/conditional-audit-order-entry-user.xml");
		final ConditionalAuditGroup cartGroup = conditionalAuditConfig.getGroup("user-cart-order");

		assertThat(cartGroup.getConfigForType("Cart").getCode()).isEqualTo("Cart");
		assertThat(cartGroup.getConfigForType("Order").getCode()).isEqualTo("Order");
		assertThat(cartGroup.getConfigForType("User").getCode()).isEqualTo("User");

		final ConditionalAuditGroup orderGroup = conditionalAuditConfig.getGroup("order-entry-user");

		assertThat(orderGroup.getConfigForType("OrderEntry").getCode()).isEqualTo("OrderEntry");
		assertThat(orderGroup.getConfigForType("Order").getCode()).isEqualTo("Order");
		assertThat(orderGroup.getConfigForType("User").getCode()).isEqualTo("User");
	}
}
