<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-company/organization-management/manage-users/resetpassword" var="resetpasswordUrl">
    <spring:param name="user" value="${customerResetPasswordForm.uid}" />
</spring:url>
<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="account-section-header">
            <div class="row">
                <div class="container-lg col-md-6">
                    <spring:theme code="text.account.profile.updatePasswordForm" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="container-lg col-md-6">
                <div class="account-section-content">
                    <div class="account-section-form">
                        <form:form action="${resetpasswordUrl}" method="post" commandName="customerResetPasswordForm" autocomplete="off">
                            <form:input type="hidden" name="uid" path="uid" id="uid" />
                            <formElement:formPasswordBox idKey="profile-newPassword" labelKey="profile.newPassword" labelCSS="control-label" path="newPassword" inputCSS="form-control text password strength" mandatory="true" />
                            <formElement:formPasswordBox idKey="profile.checkNewPassword" labelKey="profile.checkNewPassword" labelCSS="control-label" path="checkNewPassword" inputCSS="form-control text password" mandatory="true" />
                            <div class="accountActions">
                                <button class="btn btn-primary btn-block">
                                    <spring:theme code="text.account.profile.updatePasswordForm" />
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template:page>