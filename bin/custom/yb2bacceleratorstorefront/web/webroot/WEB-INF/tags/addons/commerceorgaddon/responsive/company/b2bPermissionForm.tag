<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="saveUrl" required="true" type="java.lang.String"%>
<%@ attribute name="cancelUrl" required="true" type="java.lang.String"%>
<%@ attribute name="isSelectBoxForPermission" required="false" type="java.lang.Boolean"%>
<%@ attribute name="b2BPermissionForm" required="true" type="de.hybris.platform.commerceorgaddon.forms.B2BPermissionForm"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-section-content">
    <form:form action="${saveUrl}" id="b2BPermissionForm" commandName="b2BPermissionForm" method="POST">
        <div class="row">
            <form:input type="hidden" name="originalCode" path="originalCode" id="originalCode" />
            <form:input type="hidden" name="permissionType" path="permissionType" id="permissionType" />
            <form:input type="hidden" name="b2BPermissionTypeData.code" path="b2BPermissionTypeData.code" id="b2BPermissionTypeData.code" />
            <form:input type="hidden" name="b2BPermissionTypeData.name" path="b2BPermissionTypeData.name" id="b2BPermissionTypeData.name" />
            <div class="col-xs-12 col-sm-6">
                <c:choose>
                    <c:when test="${isSelectBoxForPermission}">

                        <formElement:formSelectBox idKey="selectNewPermissionType"
                                                   labelKey="text.company.managePermissions.create.type.label"
                                                   skipBlankMessageKey="text.company.managePermissions.selectBox.permissionType"
                                                   mandatory="true" path="permissionType" selectCSSClass="form-control" items="${b2bPermissionTypes}" />
                    </c:when>
                    <c:otherwise>
                        <label>
                            <spring:theme code="text.company.managePermissions.type.label"/>
                        </label>
                    <span class="label-value">
                            ${fn:escapeXml(b2BPermissionForm.b2BPermissionTypeData.name)}
                    </span>

                    </c:otherwise>
                </c:choose>
            </div>

            <div class="col-xs-12 col-sm-6">
                <formElement:formInputBox
                        idKey="text.company.managePermissions.name.label"
                        labelKey="text.company.managePermissions.name.label" path="code"
                        inputCSS="text"/>
            </div>

            <div class="col-xs-12 col-sm-6">
                <formElement:formSelectBox
                        idKey="text.company.managePermissions.unit.label"
                        skipBlankMessageKey="text.company.costCenter.selectBox.unit"
                        labelKey="text.company.managePermissions.unit.label"
                        path="parentUnitName" mandatory="true" selectCSSClass="form-control" items="${b2bUnits}" />
            </div>

            <c:if test="${b2BPermissionForm.b2BPermissionTypeData.code ne 'B2BBudgetExceededPermission' }">

                <div class="col-xs-12 col-sm-6">
                    <c:if test="${b2BPermissionForm.b2BPermissionTypeData.code eq 'B2BOrderThresholdTimespanPermission'}">

                        <formElement:formSelectBox
                                idKey="text.company.managePermissions.timespan.label"
                                skipBlankMessageKey="text.company.managePermissions.selectBox.timespan"
                                labelKey="text.company.managePermissions.timespan.label"
                                path="timeSpan" mandatory="true" selectCSSClass="form-control" items="${b2bPeriodRanges}" />

                    </c:if>
                </div>

                <div class="col-xs-12 col-sm-6">
                    <formElement:formInputBox
                            idKey="text.company.managePermissions.value.label"
                            labelKey="text.company.managePermissions.value.label" path="value"
                            inputCSS="text" mandatory="true" />
                </div>

                <div class="col-xs-12 col-sm-6">
                    <formElement:formSelectBox
                            idKey="text.company.managePermissions.currency.label"
                            skipBlankMessageKey="text.company.costCenter.selectBox.currency"
                            labelKey="text.company.managePermissions.currency.label"
                            path="currency" mandatory="true" selectCSSClass="form-control" items="${b2bCostCenterCurrencies}" />
                </div>
            </c:if>

            <div class="col-xs-12">
                <div class="accountActions-bottom row">
                    <div class="col-sm-3 col-sm-push-9">
                        <button type="submit" class="confirm btn btn-block btn-primary">
                            <spring:theme code="text.company.managePermissions.edit.saveButton"/>
                        </button>
                    </div>
                    <div class="col-sm-3 col-sm-push-3">
                        <org-common:back cancelUrl="${cancelUrl}" displayTextMsgKey="text.company.managePermissions.edit.cancelButton"/>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
