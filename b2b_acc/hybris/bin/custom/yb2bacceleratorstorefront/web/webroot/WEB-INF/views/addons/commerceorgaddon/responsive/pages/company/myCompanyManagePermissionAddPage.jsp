<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common"%>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-permissions" var="cancelUrl" htmlEscape="false"/>
<spring:url value="/my-company/organization-management/manage-permissions/add/save" var="savePermissionDetailsUrl" htmlEscape="false"/>

<company:b2bPermissionForm cancelUrl="${cancelUrl}" saveUrl="${savePermissionDetailsUrl}" b2BPermissionForm="${b2BPermissionForm}" isSelectBoxForPermission="true"/>

