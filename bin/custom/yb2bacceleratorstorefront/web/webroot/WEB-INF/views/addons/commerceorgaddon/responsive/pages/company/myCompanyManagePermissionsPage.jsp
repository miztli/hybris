<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<spring:url value="/my-company/organization-management/manage-permissions/add" var="createUrl" htmlEscape="false"/>
<c:set var="searchUrl" value="/my-company/organization-management/manage-permissions?sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}"/>

<jsp:useBean id="additionalParams" class="java.util.HashMap"/>
<c:set target="${additionalParams}" property="user" value="${param.user}" />
<c:set target="${additionalParams}" property="permission" value="${param.permission}" />

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="account-section-header">
            <spring:theme code="text.company.${action}.title"/>

            <div class="account-section-header-add pull-right">
                <a href="${fn:escapeXml(createUrl)}" class="button add"><spring:theme code="text.company.managePermissions.addButton.displayName"/></a>
            </div>
        </div>

        <c:if test="${empty searchPageData.results}">
            <div class="col-md-6 col-md-push-3">
                <div class="account-section-content	content-empty">
                    <spring:theme code="text.company.noentries"/>
                </div>
            </div>
        </c:if>

        <c:if test="${not empty searchPageData.results}">
            <div class="account-section-content">
                <div class="account-orderhistory-pagination">
                    <nav:pagination top="true" supportShowPaged="${isShowPageAllowed}"
                                    supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
                                    searchUrl="${searchUrl}"
                                    msgKey="text.company.${action}.page"
                                    numberPagesShown="${numberPagesShown}"
                                    hideRefineButton="true" additionalParams="${additionalParams}"/>
                </div>
                <div class="account-overview-table">
                    <table class="responsive-table">
                        <tr class="account-orderhistory-table-head responsive-table-head hidden-xs">
                            <th>
                                <spring:theme code="text.company.column.id.name"/>
                            </th>
                            <th>
                                <spring:theme code="text.company.column.type"/>
                            </th>
                            <th>
                                <spring:theme code="text.company.column.parentUnit.name"/>
                            </th>
                            <th>
                                <spring:theme code="text.company.${action}.timespan.label"/>
                            </th>
                            <th>
                                <spring:theme code="text.company.${action}.value.title"/>
                            </th>
                            <th>
                                <spring:theme code="text.company.column.status.name"/>
                            </th>
                        </tr>
                        <c:forEach items="${searchPageData.results}" var="result">
                            <spring:url value="/my-company/organization-management/manage-permissions/view"
                                        var="viewPermissionDetailsUrl" htmlEscape="false">
                                <spring:param name="permissionCode" value="${result.code}"/>
                            </spring:url>
                            <tr class="responsive-table-item">
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.id.name"/></td>
                                <td class="responsive-table-cell">
                                    <a href="${fn:escapeXml(viewPermissionDetailsUrl)}">${fn:escapeXml(result.code)}</a>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.type"/></td>
                                <td class="responsive-table-cell">
                                        ${fn:escapeXml(result.b2BPermissionTypeData.name)}
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.parentUnit.name"/></td>
                                <td class="responsive-table-cell">
                                        ${fn:escapeXml(result.unit.uid)}
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.${action}.timespan.label"/></td>
                                <td class="responsive-table-cell">
                                    <company:permissionTimespan permission="${result}"/>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.${action}.value.title"/></td>
                                <td class="responsive-table-cell">
                                    <company:permissionAmount permission="${result}" displayBracketsAroundCurrency="false"/>
                                </td>
                                <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.status.name"/></td>
                                <td class="status">
                                    <c:choose>
                                        <c:when test="${result.active}">
                                            <spring:theme code="text.company.${action}.status.enabled"/>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="account-status-inactive"><spring:theme code="text.company.${action}.status.disabled"/></span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="account-orderhistory-pagination">
                    <nav:pagination top="false" supportShowPaged="${isShowPageAllowed}"
                                    supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
                                    searchUrl="${searchUrl}"
                                    msgKey="text.company.${action}.page"
                                    numberPagesShown="${numberPagesShown}"
                                    hideRefineButton="true" additionalParams="${additionalParams}"/>
                </div>
            </div>
        </c:if>
    </div>
</template:page>