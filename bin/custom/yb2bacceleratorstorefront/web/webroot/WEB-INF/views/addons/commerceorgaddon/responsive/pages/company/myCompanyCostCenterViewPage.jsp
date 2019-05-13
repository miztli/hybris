<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${empty editUrl}">
    <spring:url
            value="/my-company/organization-management/manage-costcenters/edit"
            var="editUrl" htmlEscape="false">
        <spring:param name="costCenterCode" value="${b2bCostCenter.code}"/>
    </spring:url>
</c:if>
<spring:url
        value="/my-company/organization-management/manage-costcenters/selectBudget"
        var="selectBudgetsForCostcenterUrl" htmlEscape="false">
    <spring:param name="costCenterCode" value="${b2bCostCenter.code}"/>
</spring:url>
<spring:url
        value="/my-company/organization-management/manage-costcenters/enable"
        var="enableCostCenterUrl" htmlEscape="false">
    <spring:param name="costCenterCode" value="${b2bCostCenter.code}"/>
</spring:url>
<spring:url
        value="/my-company/organization-management/manage-costcenters/unitDetails"
        var="viewCostCenterUnitUrl" htmlEscape="false">
    <spring:param name="costCenterCode" value="${b2bCostCenter.code}"/>
    <spring:param name="unit" value="${b2bCostCenter.unit.uid}"/>
</spring:url>
<spring:url
        value="/my-company/organization-management/manage-costcenters"
        var="backToManageCostCenterUrl" htmlEscape="false">
</spring:url>
<spring:url
        value="/my-company/organization-management/manage-costcenters/disable"
        var="disableCostCenterUrl" htmlEscape="false">
    <spring:param name="costCenterCode" value="${b2bCostCenter.code}"/>
</spring:url>


<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div>
            <org-common:headline url="${backToManageCostCenterUrl}" labelKey="text.company.costCenter.viewDetails.label"/>
        </div>
        <div class="account-section-content">
            <div class="well well-lg well-tertiary">
                <div class="row">
                    <div class="col-sm-10 col-no-padding">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.costCenter.id.title"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(b2bCostCenter.code)}
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.costCenter.name.title"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(b2bCostCenter.name)}
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.costCenter.unit.title"/>
                                    </span>
                                    <span class="item-value">
                                        <a href="${fn:escapeXml(viewCostCenterUnitUrl)}">
                                                ${fn:escapeXml(b2bCostCenter.unit.uid)}
                                        </a>
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.costCenter.currency.title"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(b2bCostCenter.currency.isocode)}
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="item-group">
                                <span class="item-label">
                                    <spring:theme code="text.company.costCenter.state.title"/>
                                </span>
                                <span class="item-value">
                                    <c:choose>
                                        <c:when test="${b2bCostCenter.active}">
                                            <spring:theme code="text.company.costCenter.state.active"/>
                                        </c:when>
                                        <c:otherwise>
                                            <spring:theme code="text.company.costCenter.state.inactive"/>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="item-action">
                            <a href="${fn:escapeXml(editUrl)}" class="button edit btn btn-block btn-primary">
                                <spring:theme code="text.company.costCenter.button.displayName"/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="accountActions-link">
                <c:choose>
                    <c:when test="${b2bCostCenter.active && empty accErrorMsgs}">
                        <div class="js-action-confirmation-modal disable-link">
                            <a href="#" data-action-confirmation-modal-title="<spring:theme code="text.company.costCenter.disable.confirm"/>"
                               data-action-confirmation-modal-id="disable">
                                <spring:theme code="text.company.costCenter.disable.button"/>
                            </a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <a href="${fn:escapeXml(enableCostCenterUrl)}" class="button enable-link">
                            <spring:theme code="text.company.costCenter.enable.button"/>
                        </a>
                    </c:otherwise>
                </c:choose>
                <company:actionConfirmationModal id="disable" targetUrl="${disableCostCenterUrl}"
                                                 messageKey="text.company.costCenter.disable.warning.message"/>
            </div>
            <div class="account-list">
                <org-common:selectEntityHeadline url="${selectBudgetsForCostcenterUrl}" labelKey="text.company.manage.costcenter.budget.title"/>
                <div class="account-cards">
                    <div class="row">
                        <c:choose>
                            <c:when test="${not empty b2bCostCenter.b2bBudgetData}">
                                <c:forEach items="${b2bCostCenter.b2bBudgetData}"
                                           var="b2bBudget">
                                    <spring:url
                                            value="/my-company/organization-management/manage-budgets/view"
                                            var="viewBudgetUrl" htmlEscape="false">
                                        <spring:param name="budgetCode" value="${b2bBudget.code}"/>
                                    </spring:url>
                                    <div class="col-xs-12 col-sm-6 col-md-4 card">
                                        <ul>
                                            <li>
                                                <a href="${fn:escapeXml(viewBudgetUrl)}">${fn:escapeXml(b2bBudget.code)}</a>
                                            </li>
                                            <li>
                                                    ${fn:escapeXml(b2bBudget.name)}
                                            </li>
                                            <li>
                                                <fmt:formatDate value="${b2bBudget.startDate}"/>
                                            </li>
                                            <li>
                                                <fmt:formatNumber value="${b2bBudget.budget}" maxFractionDigits="2" minFractionDigits="2"/>
                                                (${fn:escapeXml(b2bBudget.currency.isocode)})
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="search-empty">
                                    <spring:theme code="text.company.budget.noBudgetMessage"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-5 col-md-4">
                    <div class="accountActions-bottom">
                        <org-common:back cancelUrl="${backToManageCostCenterUrl}" displayTextMsgKey="text.company.costCenter.back"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template:page>