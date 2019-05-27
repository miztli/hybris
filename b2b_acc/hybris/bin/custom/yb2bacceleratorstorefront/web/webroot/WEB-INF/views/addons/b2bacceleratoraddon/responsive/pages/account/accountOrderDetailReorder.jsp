<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="cancel-panel">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-2 col-lg-8 col-lg-offset-4">
            <div class="row">
                <div class="col-sm-6">
                    <ycommerce:testId code="orderDetails_backToOrderHistory_button">
                        <spring:url value="/my-account/orders" var="orderHistoryUrl"/>
                        <div class="orderBackBtn">
                            <button type="button" class="btn btn-default btn-block" data-back-to-orders="${fn:escapeXml(orderHistoryUrl)}">
                                <spring:theme code="text.account.orderDetails.backToOrderHistory"/>
                            </button>
                        </div>
                    </ycommerce:testId>
                </div>
                <div class="col-sm-6">
                    <c:set var="orderCode" value="${orderData.code}" scope="request"/>
                    <action:actions element="div" parentComponent="${component}"/>
                </div>
            </div>
        </div>
    </div>
</div>