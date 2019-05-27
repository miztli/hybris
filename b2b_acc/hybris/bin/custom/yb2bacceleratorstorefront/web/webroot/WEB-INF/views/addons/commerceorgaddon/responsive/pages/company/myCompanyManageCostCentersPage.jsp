<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-costcenters/add" var="addCostCenterDetailsUrl" htmlEscape="false"/>
<c:set var="searchUrl" value="/my-company/organization-management/manage-costcenters?sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}"/>

<template:page pageTitle="${pageTitle}">

    <div class="account-section">
        <div class="account-section-header">
            <spring:theme code="text.company.manage.costcenters.title"/>

            <div class="account-section-header-add pull-right">
                <a href="${fn:escapeXml(addCostCenterDetailsUrl)}" class="button add">
                    <spring:theme code="text.company.costCenter.addNew"/>
                </a>
            </div>
        </div>

        <div class="account-section-content">
            <div class="account-orderhistory-pagination">
                <nav:pagination top="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}"
                                searchPageData="${searchPageData}" searchUrl="${searchUrl}"
                                msgKey="text.company.costCenter.page" hideRefineButton="true"
                                numberPagesShown="${numberPagesShown}"/>
            </div>
            <div class="account-overview-table">
                <table class="responsive-table">
                    <tr class="responsive-table-head hidden-xs">
                        <th><spring:theme code="text.company.column.id.name"/></th>
                        <th><spring:theme code="text.company.column.name.name"/></th>
                        <th><spring:theme code="text.company.column.parentUnit.name"/></th>
                        <th><spring:theme code="text.company.costCenter.currency.title"/></th>
                        <th><spring:theme code="text.company.status.title"/></th>
                    </tr>
                    <c:forEach items="${searchPageData.results}" var="costCenter">
                        <spring:url value="/my-company/organization-management/manage-costcenters/view/"
                                    var="viewCostCenterDetailsUrl" htmlEscape="false">
                            <spring:param name="costCenterCode" value="${costCenter.code}"/>
                        </spring:url>
                        <spring:url value="/my-company/organization-management/manage-units/details/"
                                    var="viewUnitDetailsUrl" htmlEscape="false">
                            <spring:param name="unit" value="${costCenter.unit.uid}"/>
                        </spring:url>
                        <tr class="responsive-table-item">
                            <td class="hidden-sm hidden-md hidden-lg">
                                <spring:theme code="text.company.column.id.name"/>
                            </td>
                            <td class="responsive-table-cell">
                                <a href="${fn:escapeXml(viewCostCenterDetailsUrl)}" class="responsive-table-link">
                                    ${fn:escapeXml(costCenter.code)}
                                </a>
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg">
                                <spring:theme code="text.company.column.name.name"/>
                            </td>
                            <td class="responsive-table-cell">
                                ${fn:escapeXml(costCenter.name)}
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg">
                                <spring:theme code="text.company.column.parentUnit.name"/>
                            </td>
                            <td class="responsive-table-cell">
                                <a href="${fn:escapeXml(viewUnitDetailsUrl)}" class="responsive-table-link">
                                    ${fn:escapeXml(costCenter.unit.name)}
                                </a>
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg">
                                <spring:theme code="text.company.costCenter.currency.title"/>
                            </td>
                            <td class="responsive-table-cell">
                                ${fn:escapeXml(costCenter.currency.isocode)}
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg">
                                <spring:theme code="text.company.status.title"/>
                            </td>
                            <td class="responsive-table-cell">
                                <c:choose>
                                    <c:when test="${costCenter.active}">
                                        <span><spring:theme code="text.company.status.active.true"/></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="account-status-inactive"><spring:theme code="text.company.status.active.false"/></span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="account-orderhistory-pagination">
                <nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}"
                                searchPageData="${searchPageData}" searchUrl="${searchUrl}"
                                msgKey="text.company.costCenter.page" hideRefineButton="true"
                                numberPagesShown="${numberPagesShown}"/>
            </div>

            <c:if test="${empty searchPageData.results}">
                <p><spring:theme code="text.company.noentries"/></p>
            </c:if>

        </div>
    </div>
</template:page>