<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-budgets/view" var="cancelUrl" htmlEscape="false">
	<spring:param name="budgetCode" value="${b2BBudgetForm.originalCode}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-budgets/update" var="saveUrl" htmlEscape="false">
	<spring:param name="budgetCode" value="${b2BBudgetForm.originalCode}"/>
</spring:url>

<template:page pageTitle="${pageTitle}">
	<div class="account-section">
		<div>
			<org-common:headline url="${cancelUrl}" labelKey="text.company.budget.edit.title.label" />
		</div>
		<company:b2bBudgetForm cancelUrl="${cancelUrl}" saveUrl="${saveUrl}" b2BBudgetForm="${b2BBudgetForm}"/>
	</div>
</template:page>
