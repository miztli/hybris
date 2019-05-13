<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/approval-dashboard" var="orderApprovalDashboardUrl" htmlEscape="false" />
<common:headline url="${orderApprovalDashboardUrl}" labelKey="text.account.orderApprovalDetails.label" />