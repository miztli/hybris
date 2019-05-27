<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<c:if test="${empty cancelUrl}">
    <spring:url value="/my-company/organization-management/manage-permissions/view" var="cancelUrl" htmlEscape="false">
        <spring:param name="permissionCode" value="${b2BPermissionForm.originalCode}"/>
    </spring:url>
</c:if>
<c:if test="${empty saveUrl}">
    <spring:url value="/my-company/organization-management/manage-permissions/edit" var="saveUrl" htmlEscape="false">
        <spring:param name="permissionCode" value="${b2BPermissionForm.originalCode}"/>
    </spring:url>
</c:if>
<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="back-link">
            <a href="${fn:escapeXml(cancelUrl)}">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <span class="label"><spring:theme code="text.company.managePermissions.edit.page.title"/></span>
        </div>
        <company:b2bPermissionForm cancelUrl="${cancelUrl}" saveUrl="${saveUrl}" b2BPermissionForm="${b2BPermissionForm}"/>
    </div>
</template:page>
