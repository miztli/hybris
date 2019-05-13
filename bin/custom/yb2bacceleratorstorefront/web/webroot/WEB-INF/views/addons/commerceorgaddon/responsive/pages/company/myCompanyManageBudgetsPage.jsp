<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-company/organization-management/manage-budgets/add" var="addBudgetUrl" htmlEscape="false"/>

<c:set var="searchUrl" value="/my-company/organization-management/manage-budgets?sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}" />

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
		<div class="account-section-header">
			<spring:theme code="text.company.manage.budget.title"/>
			<div class="account-section-header-add pull-right">
				<a href="${fn:escapeXml(addBudgetUrl)}" class="button add" ><spring:theme code="text.company.budget.createButton.displayName" /></a>
			</div>
		</div>

		<c:if test="${empty searchPageData.results}">
            <div class="row">
                <div class="col-md-6 col-md-push-3">
                    <div class="account-section-content content-empty">
                        <spring:theme code="text.company.noentries" />
                    </div>
                </div>
            </div>
		</c:if>
		<c:if test="${not empty searchPageData.results}">
			<div class="account-section-content">
                <div class="account-orderhistory-pagination">
                    <nav:pagination top="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchUrl}" msgKey="text.company.budget.page" numberPagesShown="${numberPagesShown}" hideRefineButton="true"/>
                </div>
                <div class="account-overview-table">
                    <table class="responsive-table">
                        <tr class="responsive-table-head hidden-xs">
                            <th><spring:theme code="text.company.column.id.name"/></th>
                            <th><spring:theme code="text.company.column.name.name"/></th>
                            <th><spring:theme code="text.company.column.parentUnit.name"/></th>
                            <th><spring:theme code="text.company.manage.units.costCenters"/></th>
                            <th><spring:theme code="text.company.budget.amount"/></th>
                            <th><spring:theme code="text.company.budget.start"/></th>
                            <th><spring:theme code="text.company.budget.end"/></th>
                            <th><spring:theme code="text.company.column.status.name"/></th>
                        </tr>

                        <c:forEach items="${searchPageData.results}" var="b2bBudget">
                            <spring:url value="/my-company/organization-management/manage-budgets/view/" var="viewBudgetDetailsUrl" htmlEscape="false">
                                <spring:param name="budgetCode" value="${b2bBudget.code}"/>
                            </spring:url>
                            <spring:url value="/my-company/organization-management/manage-units/details/" var="unitDetailsUrl" htmlEscape="false">
                                <spring:param name="unit" value="${b2bBudget.unit.name}"/>
                            </spring:url>

                            <tr class="responsive-table-item">
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.id.name"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_id_link">
                                        <a href="${fn:escapeXml(viewBudgetDetailsUrl)}" class="responsive-table-link">${fn:escapeXml(b2bBudget.code)}</a>
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.name.name"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_name_link">
                                        ${fn:escapeXml(b2bBudget.name)}
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.parentUnit.name"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_unit_label">
                                        <a href="${fn:escapeXml(unitDetailsUrl)}" class="responsive-table-link">${fn:escapeXml(b2bBudget.unit.name)}</a>
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.manage.units.costCenters"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_unit_label">
                                        <c:forEach items="${b2bBudget.costCenterNames}" var="costCenter">
                                            ${fn:escapeXml(costCenter)}<br/>
                                        </c:forEach>
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.budget.amount"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_amount_label">
                                        <fmt:formatNumber value="${b2bBudget.budget}" maxFractionDigits="2" minFractionDigits="2"/> (${fn:escapeXml(b2bBudget.currency.isocode)})
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.budget.start"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_startDate_label">
                                        <fmt:formatDate value="${b2bBudget.startDate}" />
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.budget.end"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_endDate_label">
                                        <fmt:formatDate value="${b2bBudget.endDate}" />
                                    </ycommerce:testId>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.status.name"/></td>
                                <td class="responsive-table-cell">
                                    <ycommerce:testId code="budget_status_label">
                                        <c:choose>
                                            <c:when test="${b2bBudget.active}">
                                                <span><spring:theme code="text.company.budget.status.active"/></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="account-status-inactive"><spring:theme code="text.company.budget.status.disabled"/></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </ycommerce:testId>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="account-orderhistory-pagination">
                    <nav:pagination top="false"  supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchUrl}" msgKey="text.company.budget.page" numberPagesShown="${numberPagesShown}" hideRefineButton="true"/>
                </div>
			</div>
		</c:if>
	</div>
</template:page>
