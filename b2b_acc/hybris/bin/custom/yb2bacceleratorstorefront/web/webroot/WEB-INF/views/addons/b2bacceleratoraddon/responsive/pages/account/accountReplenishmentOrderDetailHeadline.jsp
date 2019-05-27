<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/my-replenishment" var="replenishmentOrderHistoryUrl" htmlEscape="false"/>
<common:headline url="${replenishmentOrderHistoryUrl}" labelKey="text.account.replenishmentOrderDetails.title" />
