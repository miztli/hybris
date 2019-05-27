<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${empty cancelUrl}">
    <c:url value="/my-company/organization-management/manage-costcenters" var="cancelUrl"/>
</c:if>

<jsp:useBean id="additionalParams" class="java.util.HashMap"/>
<c:set target="${additionalParams}" property="costCenterCode" value="${param.costCenterCode}" />

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="row">
            <div class="col-xs-12 col-sm-7">
                <div class="back-link">
                    <a href="${fn:escapeXml(cancelUrl)}">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <span class="label">
                        <spring:theme code="text.company.select.budgets"/>
                    </span>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3 col-sm-push-2">
                <div class="account-header-done-btn">
                    <org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
                </div>
            </div>
        </div>
        <c:set var="searchUrl" value="/my-company/organization-management/manage-costcenters/selectBudget?costCenterCode=${ycommerce:encodeUrl(param.costCenterCode)}&sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}"/>

        <div class="account-section-content">
            <nav:pagination top="true" showTopTotals="false" supportShowPaged="${isShowPageAllowed}"
                            supportShowAll="${isShowAllAllowed}"
                            searchPageData="${searchPageData}"
                            hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.budget.page"
                            additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>

            <c:choose>
                <c:when test="${not empty searchPageData.results}">
                <div class="account-list">
                    <div class="account-cards card-select">
                        <div class="row">
                            <c:forEach items="${searchPageData.results}" var="b2bBudget">
                                <div id="card-${fn:escapeXml(ycommerce:normalizedCode(b2bBudget.code))}" class="col-xs-12 col-sm-6 col-md-4 card <c:if test='${b2bBudget.selected}'>selected</c:if>">
                                    <ul class="card-${fn:escapeXml(ycommerce:normalizedCode(b2bBudget.code))} pull-left">
                                        <spring:url
                                                value="/my-company/organization-management/manage-budgets/view"
                                                var="viewBudgetUrl" htmlEscape="false">
                                            <spring:param name="budgetCode" value="${b2bBudget.code}"/>
                                        </spring:url>
                                        <li><a href="${fn:escapeXml(viewBudgetUrl)}">${fn:escapeXml(b2bBudget.code)}</a></li>
                                        <li>${fn:escapeXml(b2bBudget.name)}</li>
                                        <li>${fn:escapeXml(b2bBudget.unit.name)}</li>
                                    </ul>
                                    <span id="span-${fn:escapeXml(ycommerce:normalizedCode(b2bBudget.code))}" class="account-cards-actions pull-left">
                                        <spring:url value="${baseUrl}/budgets/deselect/"
                                                    var="deselectUrl" htmlEscape="false">
                                            <spring:param name="costCenterCode" value="${param.costCenterCode}"/>
                                            <spring:param name="budgetCode" value="${b2bBudget.code}"/>
                                        </spring:url>
                                        <spring:url value="${baseUrl}/budgets/select/"
                                                    var="selectUrl" htmlEscape="false">
                                            <spring:param name="costCenterCode"
                                                          value="${param.costCenterCode}"/>
                                            <spring:param name="budgetCode" value="${b2bBudget.code}"/>
                                        </spring:url>
                                        <c:choose>
                                            <c:when test="${b2bBudget.selected}">
                                                <a href="#" url="${fn:escapeXml(deselectUrl)}" class="action-links js-deselectBudget">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </a>
                                            </c:when>
                                            <c:when test="${b2bBudget.active }">
                                                <a href="#" url="${fn:escapeXml(selectUrl)}" class="action-links js-selectBudget">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </a>
                                            </c:when>
                                        </c:choose>
                                    </span>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                </c:when>
                <c:otherwise>
                    <p><spring:theme code="text.company.noentries"/></p>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="accountActions-bottom hidden-sm hidden-md hidden-lg">
            <org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
        </div>

        <nav:pagination top="false" supportShowPaged="${isShowPageAllowed}"
                        supportShowAll="${isShowAllAllowed}"
                        searchPageData="${searchPageData}"
                        searchUrl="${searchUrl}"
                        msgKey="text.company.budget.page" hideRefineButton="true"
                        additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>
    </div>

    <c:url value="${baseUrl}/budgets" var="budgetsActionLink"/>

    <script id="enableDisableLinksTemplate" type="text/x-jquery-tmpl">

    {{if active}}
		{{if selected}}
			<a href="#" url="${fn:escapeXml(budgetsActionLink)}/deselect/?budgetCode={{= encodeURIComponent(id)}}&amp;costCenterCode=${fn:escapeXml(ycommerce:encodeUrl(param.costCenterCode))}" class="action-links js-deselectBudget"><span class="glyphicon glyphicon-ok"></span></a>
		{{else}}
			<a href="#" url="${fn:escapeXml(budgetsActionLink)}/select/?budgetCode={{= encodeURIComponent(id)}}&amp;costCenterCode=${fn:escapeXml(ycommerce:encodeUrl(param.costCenterCode))}" class="action-links js-selectBudget"><span class="glyphicon glyphicon-ok"></span></a>
		{{/if}}
		{{else}}
	{{/if}}
    </script>
</template:page>