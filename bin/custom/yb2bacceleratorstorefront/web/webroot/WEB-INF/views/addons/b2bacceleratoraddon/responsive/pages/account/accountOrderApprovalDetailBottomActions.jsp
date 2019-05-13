<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="b2b-order" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/order"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action" %>

<div class="row">
    <div class="col-xs-12 col-sm-4 col-md-4 pull-right">
        <action:actions element="div" parentComponent="${component}"/>
    </div>
</div>

<div class="disable-link">
    <spring:url value="/my-account/order/approvalDecision" var="orderApprovalDecisionURL" htmlEscape="false" />

    <b2b-order:rejectOrderAction />
</div>
