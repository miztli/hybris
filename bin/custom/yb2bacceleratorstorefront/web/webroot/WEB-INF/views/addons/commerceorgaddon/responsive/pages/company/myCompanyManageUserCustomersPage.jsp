<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:theme code="text.company.select.action.label" var="selectAction" />
<spring:theme code="text.company.deselect.action.label" var="deselectAction" />
<c:if test="${empty cancelUrl}">
    <c:url value="/my-company/organization-management/manage-users" var="cancelUrl" />
</c:if>
<c:set var="searchUrl" value="${baseUrl}/${ycommerce:encodeUrl(action)}?user=${ycommerce:encodeUrl(param.user)}&sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}" />
<jsp:useBean id="sortQueryParams" class="java.util.HashMap" />
<c:set target="${sortQueryParams}" property="user" value="${param.user}" />
<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="row">
            <div class="col-xs-12 col-sm-7">
                <org-common:headline url="${cancelUrl}" labelKey="text.myCompany.manageUsers.${action}.title" />
            </div>
            <div class="col-xs-12 col-sm-3 col-sm-push-2">
                <div class="account-header-done-btn">
                    <org-common:done url="${cancelUrl}" labelKey="text.company.done.button" />
                </div>
            </div>
        </div>

        <div class="account-section-content">
            <nav:pagination top="true" showTopTotals="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchUrl}" additionalParams="${sortQueryParams}" msgKey="text.company.${action}.page" numberPagesShown="${numberPagesShown}" hideRefineButton="true"/>
            <c:choose>
                <c:when test="${not empty searchPageData.results}">
                    <div class="account-list">
                        <div class="account-cards card-select">
                            <div class="row">
                                <c:forEach items="${searchPageData.results}" var="user">
                                    <spring:url value="/my-company/organization-management/manage-users/details" var="viewUrl" htmlEscape="false">
                                        <spring:param name="user" value="${user.uid}" />
                                    </spring:url>
                                    <div id="row-${fn:escapeXml(ycommerce:normalizedCode(user.normalizedUid))}" class="col-xs-12 col-sm-6 col-md-4 card <c:if test='${user.selected}'>selected</c:if>">
                                        <ul class="pull-left">
                                            <li>
                                                <ycommerce:testId code="${action}_name_link">
                                                    <a href="${fn:escapeXml(viewUrl)}">${fn:escapeXml(user.name)}</a>
                                                </ycommerce:testId>
                                            </li>
                                            <li>
                                                <ycommerce:testId code="${action}_b2bunit_label">
                                                    ${fn:escapeXml(user.unit.name)}
                                                </ycommerce:testId>
                                            </li>
                                            <li class="roles-wrapper clearfix">
                                                <b><spring:theme code="text.company.roles.all.label"/></b>
                                                <ycommerce:testId code="${action}_roles_label">
                                                    <ul id="roles-${fn:escapeXml(ycommerce:normalizedCode(user.normalizedUid))}">
                                                        <c:forEach items="${user.roles}" var="role">
                                                            <li><spring:theme code="b2busergroup.${role}.name" /></li>
                                                        </c:forEach>
                                                    </ul>
                                                </ycommerce:testId>
                                            </li>
                                        </ul>
                                        <ycommerce:testId code="${action}_actions_label">
                                            <spring:url value="${baseUrl}/{/action}/select/" var="selectUrl" htmlEscape="false">
                                                 <spring:param name="action" value="${action}" />
                                                <spring:param name="approver" value="${user.uid}" />
                                                <spring:param name="user" value="${param.user}" />
                                            </spring:url>
                                            <spring:url value="${baseUrl}/{/action}/deselect/" var="deselectUrl" htmlEscape="false">
                                                <spring:param name="action" value="${action}" />
                                                <spring:param name="approver" value="${user.uid}" />
                                                <spring:param name="user" value="${param.user}" />
                                            </spring:url>
                                            <c:choose>
                                                <c:when test="${user.active}">
                                                    <span id="selection-${fn:escapeXml(ycommerce:normalizedCode(user.normalizedUid))}" class="account-cards-actions pull-left">
                                                        <c:choose>
                                                            <c:when test="${user.selected}">
                                                                <a href="#" url="${fn:escapeXml(deselectUrl)}" class="action-links js-deselectUser">
                                                                    <span class="glyphicon glyphicon-ok"></span>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="#" url="${fn:escapeXml(selectUrl)}" class="action-links js-selectUser">
                                                                    <span class="glyphicon glyphicon-ok"></span>
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </span>
                                                </c:when>
                                                <c:otherwise>
                                                    <spring:theme code="text.user.disabled" />
                                                </c:otherwise>
                                            </c:choose>
                                        </ycommerce:testId>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <spring:theme code="text.company.noentries" />
                </c:otherwise>
            </c:choose>
        </div>

        <div class="accountActions-bottom hidden-sm hidden-md hidden-lg">
            <org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
        </div>
        <nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
                        searchUrl="${searchUrl}" additionalParams="${sortQueryParams}" msgKey="text.company.${action}.page" numberPagesShown="${numberPagesShown}" hideRefineButton="true"/>

    </div>
    <c:url value="${baseUrl}/${ycommerce:encodeUrl(action)}" var="actionLink" />
    <script id="userRolesTemplate" type="text/x-jquery-tmpl">
        {{each displayRoles}}
        	{{= $value}}
        {{/each}}
    </script>
    <script id="enableDisableLinksTemplate" type="text/x-jquery-tmpl">
        {{if selected}}
        <a href="#" url="${fn:escapeXml(actionLink)}/deselect/?approver={{= encodeURIComponent(id)}}&amp;user=${fn:escapeXml(ycommerce:encodeUrl(param.user))}" class="action-links js-deselectUser"><span class="glyphicon glyphicon-ok"></span></a>
        {{else}}
        <a href="#" url="${fn:escapeXml(actionLink)}/select/?approver={{= encodeURIComponent(id)}}&amp;user=${fn:escapeXml(ycommerce:encodeUrl(param.user))}" class="action-links js-selectUser"><span class="glyphicon glyphicon-ok"></span></a>
        {{/if}}
    </script>
</template:page>