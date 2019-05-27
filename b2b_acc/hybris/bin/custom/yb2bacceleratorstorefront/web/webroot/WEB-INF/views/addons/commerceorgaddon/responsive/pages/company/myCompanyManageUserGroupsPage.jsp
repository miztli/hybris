<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-usergroups/create" var="createUserGroupUrl" htmlEscape="false"/>
<c:set var="searchUrl" value="/my-company/organization-management/manage-usergroups?sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}"/>

<jsp:useBean id="additionalParams" class="java.util.HashMap"/>
<c:set target="${additionalParams}" property="user" value="${param.user}" />

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div>
            <org-common:listHeadline url="${createUserGroupUrl}" labelKey="text.company.${action}.title" urlTestId="Usergroup_createNew_button"/>
        </div>
        <c:choose>
            <c:when test="${not empty searchPageData.results}">
                <div class="account-section-content">
                    <div class="account-orderhistory-pagination">
                        <nav:pagination top="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
                                    hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.${action}.page"
                                    additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>
                    </div>

                    <div class="account-overview-table">
                        <table class="responsive-table">
                            <tr class="responsive-table-head hidden-xs">
                                <th id="header1"><spring:theme code="text.company.column.id.name"/></th>
                                <th id="header2"><spring:theme code="text.company.column.name.name"/></th>
                                <th id="header3"><spring:theme code="text.company.column.parentUnit.name"/></th>
                                <th id="header4"><spring:theme code="text.company.status.title"/></th>
                            </tr>
                            <c:forEach items="${searchPageData.results}" var="group">
                                <spring:url
                                        value="/my-company/organization-management/manage-usergroups/details/"
                                        var="viewUrl" htmlEscape="false">
                                    <spring:param name="usergroup" value="${group.uid}"/>
                                </spring:url>
                                <spring:url
                                        value="/my-company/organization-management/manage-units/details/"
                                        var="viewUnitUrl" htmlEscape="false">
                                    <spring:param name="unit" value="${group.unit.uid}"/>
                                </spring:url>

                                <tr class="responsive-table-item">
                                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.id.name"/></td>
                                    <td headers="header1" class="responsive-table-cell">
                                        <ycommerce:testId code="${action}_uid_link">
                                            <a href="${fn:escapeXml(viewUrl)}" class="responsive-table-link">${fn:escapeXml(group.uid)}</a>
                                        </ycommerce:testId>
                                    </td>
                                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.name.name"/></td>
                                    <td headers="header2" class="responsive-table-cell">
                                        <ycommerce:testId code="${action}_name_label">
                                            ${fn:escapeXml(group.name)}
                                        </ycommerce:testId>
                                    </td>
                                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.column.parentUnit.name"/></td>
                                    <td headers="header3" class="responsive-table-cell">
                                        <ycommerce:testId code="${action}_b2bunit_label">
                                            <a href="${fn:escapeXml(viewUnitUrl)}" class="responsive-table-link">${fn:escapeXml(group.unit.name)}</a>
                                        </ycommerce:testId>
                                    </td>
                                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.company.status.title"/></td>
                                    <td headers="header4" class="responsive-table-cell">
                                        <ycommerce:testId code="${action}_status_label">
                                            <c:choose>
                                                <c:when test="${fn:length(group.members)>0}">
                                                    <span><spring:theme code="text.company.status.active.true"/></span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="account-status-inactive"><spring:theme code="text.company.status.active.false"/></span>
                                                </c:otherwise>
                                            </c:choose>
                                        </ycommerce:testId>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                    <div class="account-orderhistory-pagination">
                        <nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
                                    hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.${action}.page"
                                    additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <div class="col-md-6 col-md-push-3">
                        <div class="account-section-content content-empty">
                            <spring:theme code="text.company.noentries"/>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</template:page>