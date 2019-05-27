<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${empty saveUrl}">
	<spring:url value="/my-company/organization-management/manage-units/create" var="saveUrl" htmlEscape="false"/>
</c:if>

<c:if test="${empty cancelUrl}">
	<spring:url value="/my-company/organization-management/manage-units/" var="cancelUrl" htmlEscape="false"/>
</c:if>

<template:page pageTitle="${pageTitle}">
	<div class="account-section">
		<div>
			<org-common:headline url="${cancelUrl}" labelKey="text.company.manage.units.createNewUnit" />
		</div>
		<company:b2bUnitForm formUrl="${saveUrl}" b2BUnitForm="${b2BUnitForm}" cancelUrl="${cancelUrl}"/>
	</div>
</template:page>