<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-units/create" var="createUnitUrl" htmlEscape="false">
	<spring:param name="unit" value=""/>
</spring:url>

<template:page pageTitle="${pageTitle}">
	<div class="account-section">
		<div class="account-section-header no-border">
			<spring:theme code="text.company.manage.units.label"/>
			<div class="account-section-header-add pull-right">
				<ycommerce:testId code="unit_createNewUnit_button">
					<a href="${fn:escapeXml(createUnitUrl)}" class="button add">
						<spring:theme code="text.company.manage.units.newUnitButton"/>
					</a>
				</ycommerce:testId>
			</div>
		</div>
		<div id="unittree" class="panel-group accordion">
			<company:unitTree node="${rootNode}"/>
		</div>
	</div>
</template:page>
