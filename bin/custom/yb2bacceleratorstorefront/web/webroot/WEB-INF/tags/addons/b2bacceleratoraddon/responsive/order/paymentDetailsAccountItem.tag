<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="order" required="true" type="de.hybris.platform.commercefacades.order.data.AbstractOrderData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="label-order"><spring:theme code="text.paymentDetails" text="Payment Details"/></div>
<ul>
	<li><spring:theme code="checkout.multi.summary.orderPlacedBy"/>:&nbsp;<spring:theme code="text.company.user.${order.b2bCustomerData.titleCode}.name" text=""/>&nbsp;${fn:escapeXml(order.b2bCustomerData.firstName)}&nbsp;${fn:escapeXml(order.b2bCustomerData.lastName)}</li>
	<c:if test="${(not empty order.costCenter) and (not empty order.costCenter.code)}">
		<li><spring:theme code="checkout.multi.costCenter.label"/>:&nbsp;${fn:escapeXml(order.costCenter.name)}</li>
	</c:if>
	<c:choose>
		<c:when test="${not empty order.purchaseOrderNumber}">
			<li><spring:theme code="checkout.multi.purchaseOrderNumber.label"/>:&nbsp;${fn:escapeXml(order.purchaseOrderNumber)}</li>
		</c:when>
		<c:otherwise>
			<li><spring:theme code="checkout.multi.purchaseOrderNumber.label"/>:&nbsp;-</li>
		</c:otherwise>
	</c:choose>
</ul>

