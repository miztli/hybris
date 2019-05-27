<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="customFormElement" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/customFormElement" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${empty saveUrl}">
	<c:choose>
		<c:when test="${not empty b2BCustomerForm.uid}">
			<spring:url value="/my-company/organization-management/manage-users/edit" var="saveUrl" htmlEscape="false">
				<spring:param name="user" value="${b2BCustomerForm.uid}"/>
			</spring:url>
		</c:when>
		<c:otherwise>
			<spring:url value="/my-company/organization-management/manage-users/create" var="saveUrl" htmlEscape="false"/>
		</c:otherwise>
	</c:choose>
</c:if>

<c:if test="${empty cancelUrl}">
	<c:choose>
		<c:when test="${not empty b2BCustomerForm.uid}">
			<spring:url value="/my-company/organization-management/manage-users/details" var="cancelUrl" htmlEscape="false">
				<spring:param name="user" value="${b2BCustomerForm.uid}"/>
			</spring:url>
		</c:when>
		<c:otherwise>
			<spring:url value="/my-company/organization-management/manage-users" var="cancelUrl" htmlEscape="false"/>
		</c:otherwise>
	</c:choose>
</c:if>

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div>
            <c:choose>
                <c:when test="${not empty b2BCustomerForm.uid}">
                    <org-common:headline url="${cancelUrl}" labelKey="text.company.${action}.edit.title"
                                         labelArguments="${b2BCustomerForm.parentB2BUnit}"/>
                </c:when>
                <c:otherwise>
                    <org-common:headline url="${cancelUrl}" labelKey="text.company.${action}.users.new.title"
                                         labelArguments="${param.unit}"/>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="account-section-content">
            <form:form action="${saveUrl}" method="post" commandName="b2BCustomerForm">
                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <formElement:formSelectBox idKey="user.title" labelKey="user.title" path="titleCode"
                                                   mandatory="true"
                                                   skipBlank="false"
                                                   skipBlankMessageKey="form.select.empty"
                                                   selectCSSClass="form-control"
                                                   items="${titleData}"/>
                    </div>
                    <form:input type="hidden" name="uid" path="uid" id="uid"/>
                    <div class="col-xs-12 col-sm-6">
                        <formElement:formInputBox idKey="user.firstName" labelKey="user.firstName" path="firstName"
                                                  inputCSS="text" mandatory="true"/>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <formElement:formInputBox idKey="user.lastName" labelKey="user.lastName" path="lastName"
                                                  inputCSS="text" mandatory="true"/>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <formElement:formInputBox idKey="user.email" labelKey="user.email" path="email"
                                                  inputCSS="text" mandatory="true"/>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <formElement:formSelectBox idKey="text.company.user.unit.title" skipBlank="false"
                                                   labelKey="text.company.user.unit.title" path="parentB2BUnit" selectCSSClass="form-control"
                                                   mandatory="true" items="${b2bUnits}" disabled="${not empty param.unit and not empty param.role}"
                                                   skipBlankMessageKey="form.select.empty"/>
                    </div>
                    <div class="col-xs-12">
                        <customFormElement:formCheckboxes idKey="text.company.user.roles" labelKey="text.company.user.roles"
                                                          path="roles" items="${roles}" disabled="${not empty param.unit and not empty param.role}"/>
                    </div>
                    <div class="col-xs-12">
                        <div class="accountActions-bottom">
                            <div class="row">
                                <div class="col-sm-3 col-sm-push-9">
                                    <ycommerce:testId code="User_Save_button">
                                        <button type="submit" class="btn btn-block btn-primary save"><spring:theme code="text.company.save.button"/></button>
                                    </ycommerce:testId>
                                </div>
                                <div class="col-sm-3 col-sm-push-3">
                                    <ycommerce:testId code="User_Cancel_button">
                                        <a href="${fn:escapeXml(cancelUrl)}" class="cancel">
                                            <button type="button" class="btn btn-block btn-default"><spring:theme code="text.company.cancel.button"/></button>
                                        </a>
                                    </ycommerce:testId>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</template:page>