<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<c:url var="reorderUrl" value="${url}" scope="page"/>

<form:form action="${reorderUrl}" id="reorderForm" commandName="reorderForm">
	<button type="submit" class="btn btn-primary btn-block re-order" id="reorderButton">
		<spring:theme code="text.order.reorderbutton"/>
	</button>
	<div>	
		<input type="hidden" name="orderCode" value="${fn:escapeXml(orderCode)}" />
	</div>
</form:form>