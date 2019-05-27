<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<spring:url value="/my-company/organization-management/manage-permissions" var="cancelUrl" htmlEscape="false"/>
<spring:url value="/my-company/organization-management/manage-permissions/add/save" var="savePermissionDetailsUrl" htmlEscape="false"/>

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="back-link">
            <a href="${fn:escapeXml(cancelUrl)}">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <span class="label"><spring:theme code="text.company.managePermissions.create.permission.title"/></span>
        </div>
        <div class="account-section-content">
            <div id="addNewPermissionForm">
                <company:b2bPermissionForm cancelUrl="${cancelUrl}" saveUrl="${savePermissionDetailsUrl}" b2BPermissionForm="${b2BPermissionForm}"/>
            </div>
        </div>
    </div>
</template:page>