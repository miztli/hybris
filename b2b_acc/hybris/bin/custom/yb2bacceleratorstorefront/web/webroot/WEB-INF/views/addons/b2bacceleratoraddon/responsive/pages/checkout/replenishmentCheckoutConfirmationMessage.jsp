<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="checkout-success">
    <div class="checkout-success__body">
        <div class="checkout-success__body__headline checkout-replenishment-headline">
            <p><spring:theme code="order.replenishment.thankYou"/></p>
        </div>
        <p>
            <spring:theme code="order.replenishment.confirmation.number"/>
            <b> ${fn:escapeXml(orderData.jobCode)}</b>
        </p>
        <p>
            <spring:theme code="checkout.orderConfirmation.copySentToShort"/>
            <b> ${fn:escapeXml(orderData.b2bCustomerData.displayUid)}</b>
        </p>
    </div>
</div>

<div class="well well-tertiary well-single-headline">
    <div class="well-headline"><spring:theme code="checkout.multi.order.summary" /></div>
</div>