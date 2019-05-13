<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="b2bOrder" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/order" %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<div class="well-lg well well-tertiary">
    <c:choose>
        <c:when test="${empty orderData}">
            <spring:theme code="text.account.replenishment.noOrdersFound"/>
        </c:when>
        <c:otherwise>
            <ycommerce:testId code="replenishment_orderDetail_overview_section">
                <b2bOrder:replenishmentOrderDetailsOverview scheduleData="${orderData}"/>
            </ycommerce:testId>
        </c:otherwise>
    </c:choose>
</div>