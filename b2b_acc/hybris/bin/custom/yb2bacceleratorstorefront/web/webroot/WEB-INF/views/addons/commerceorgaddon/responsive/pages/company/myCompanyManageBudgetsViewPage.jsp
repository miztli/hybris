<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-company/organization-management/manage-budgets/edit" var="editBudgetDetailsUrl" htmlEscape="false">
	<spring:param name="budgetCode" value="${budget.code}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-budgets/enable" var="enableUrl" htmlEscape="false">
	<spring:param name="budgetCode" value="${budget.code}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-budgets/disable" var="disableUrl" htmlEscape="false">
	<spring:param name="budgetCode" value="${budget.code}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-budgets/unitDetails" var="viewBudgetUnitUrl" htmlEscape="false">
	<spring:param name="budgetCode" value="${budget.code}"/>
	<spring:param name="unit" value="${budget.unit.uid}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-budgets" var="backUrl" htmlEscape="false">
</spring:url>

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div>
            <org-common:headline url="${backUrl}" labelKey="text.company.budget.viewPage.label"/>
        </div>

        <div class="account-section-content">
            <div class="well well-lg well-tertiary">
                <div class="row">
                    <div class="col-sm-10 col-no-padding">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.budgetId"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(budget.code)}
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.name"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(budget.name)}
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.unit"/>
                                    </span>
                                    <span class="item-value">
                                        <a href="${fn:escapeXml(viewBudgetUnitUrl)}">${fn:escapeXml(budget.unit.name)}</a>
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.startDate"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(budget.startDate)}
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.endDate"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(budget.endDate)}
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.amount"/>
                                    </span>
                                    <span class="item-value">
                                        <fmt:formatNumber value="${budget.budget}" maxFractionDigits="2" minFractionDigits="2"/> (${fn:escapeXml(budget.currency.isocode)})
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.budget.enabledDisabled"/>
                                    </span>
                                    <span class="item-value">
                                        <c:choose>
                                            <c:when test="${budget.active}">
                                                <spring:theme code="text.company.on"/>
                                            </c:when>
                                            <c:otherwise>
                                                <spring:theme code="text.company.off"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="item-action">
                            <a href="${fn:escapeXml(editBudgetDetailsUrl)}" id="EditBudget_button" class="button edit btn btn-block btn-primary">
                                <spring:theme code="text.company.costCenter.button.displayName"/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="accountActions-link">
                <c:choose>
                    <c:when test="${budget.active}">
                        <div class="js-action-confirmation-modal disable-link">
                            <a href="#" data-action-confirmation-modal-title="<spring:theme code="text.company.budget.disable.confirm"/>"
                               data-action-confirmation-modal-id="disable">
                                <spring:theme code="text.company.budget.disableButton.displayName"/>
                            </a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <a href="${fn:escapeXml(enableUrl)}" class="button enable-link">
                            <spring:theme code="text.company.budget.enableButton.displayName"/>
                        </a>
                    </c:otherwise>
                </c:choose>
                <company:actionConfirmationModal id="disable" targetUrl="${disableUrl}"
                                                 messageKey="text.company.budget.disable.confirm.message"/>
            </div>
            <div class="account-list">
                <div class="account-list-header">
                    <spring:theme code="text.company.budget.viewPage.costCenters" />
                </div>
                <div class="account-cards">
                    <div class="row">
                        <c:choose>
                            <c:when test="${not empty budget.costCenters}">
                                <c:forEach items="${budget.costCenters}"
                                           var="costCenter">
                                    <spring:url
                                            value="/my-company/organization-management/manage-costcenters/view"
                                            var="viewCostCenterUrl" htmlEscape="false">
                                        <spring:param name="costCenterCode" value="${costCenter.code}"/>
                                    </spring:url>
                                    <div class="col-xs-12 col-sm-6 col-md-4 card">
                                        <ul>
                                            <li>
                                                <a href="${fn:escapeXml(viewCostCenterUrl)}">${fn:escapeXml(costCenter.code)}</a>
                                            </li>
                                            <li>
                                                    <%--<spring:theme code="text.company.costCenter.name"/>--%>
                                                <c:out value="${costCenter.name}"/>
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="search-empty">
                                    <spring:theme code="text.company.budget.noCostCentersFound.message"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-5 col-md-4">
                    <div class="accountActions-bottom">
                        <org-common:back cancelUrl="${backUrl}" displayTextMsgKey="text.company.budget.viewPage.back"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template:page>