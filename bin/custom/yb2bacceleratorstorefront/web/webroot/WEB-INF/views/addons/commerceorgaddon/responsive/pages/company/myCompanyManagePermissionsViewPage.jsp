<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<spring:url value="/my-company/organization-management/manage-permissions/edit" var="editPermissionDetailsUrl" htmlEscape="false">
    <spring:param name="permissionCode" value="${permissionData.code}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-permissions/enable" var="enableUrl" htmlEscape="false">
    <spring:param name="permissionCode" value="${permissionData.code}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-units/details" var="unitDetailsUrl" htmlEscape="false">
    <spring:param name="unit" value="${permissionData.unit.uid}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-permissions/disable" var="confirmDisableUrl" htmlEscape="false">
    <spring:param name="permissionCode" value="${permissionData.code}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-permissions" var="backUrl" htmlEscape="false"/>

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div>
            <org-common:headline url="${backUrl}" labelKey="text.company.managePermissions.viewDetails.page.title"/>
        </div>

        <div class="account-section-content">
            <div class="well well-lg well-tertiary">
                <div class="row">
                    <div class="col-sm-10 col-no-padding">
                        <div class="row">
                            <div class="col-sm-4 item-wrapper">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.managePermissions.name.label"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(permissionData.code)}
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.managePermissions.unit.label"/>
                                    </span>
                                    <span class="item-value">
                                        <a href="${fn:escapeXml(unitDetailsUrl)}">${fn:escapeXml(permissionData.unit.name)}</a>
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.permissions.type.label"/>
                                    </span>
                                    <span class="item-value">
                                            ${fn:escapeXml(permissionData.b2BPermissionTypeData.name)}
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-4 item-wrapper">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.managePermissions.timespan.label"/>
                                    </span>
                                    <span class="item-value">
                                        <company:permissionTimespan permission="${permissionData}"/>
                                    </span>
                                </div>
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.managePermissions.value.label"/>
                                    </span>
                                    <span class="item-value">
                                        <company:permissionAmount permission="${permissionData}" displayBracketsAroundCurrency="true"/>
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-4 item-wrapper">
                                <div class="item-group">
                                    <span class="item-label">
                                        <spring:theme code="text.company.column.status.name"/>
                                    </span>
                                    <span class="item-value">
                                        <c:choose>
                                            <c:when test="${permissionData.active}">
                                                <spring:theme code="text.company.managePermissions.status.enabled"/>
                                            </c:when>
                                            <c:otherwise>
                                                <spring:theme code="text.company.managePermissions.status.disabled"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="item-action">
                            <a href="${fn:escapeXml(editPermissionDetailsUrl)}" class="button edit btn btn-block btn-primary">
                                <spring:theme code="text.company.costCenter.button.displayName"/>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
            <div class="accountActions-link">
                <c:choose>
                    <c:when test="${permissionData.active}">
                        <div class="js-action-confirmation-modal disable-link">
                            <a href="#" data-action-confirmation-modal-title="<spring:theme code="text.company.permission.disable.confirm"/>"
                               data-action-confirmation-modal-id="disable">
                                <spring:theme code="text.company.permission.disable.confirm"/>
                            </a>
                        </div>
                        <company:actionConfirmationModal id="disable" targetUrl="${confirmDisableUrl}"
                                                         messageKey="text.company.permission.disable.confirm.message"/>
                    </c:when>
                    <c:otherwise>
                        <a href="${fn:escapeXml(enableUrl)}" class="button enable-link">
                            <spring:theme code="text.company.permission.enable.confirm"/>
                        </a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</template:page>