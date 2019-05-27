<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="b2BUnitForm" required="true" type="de.hybris.platform.commerceorgaddon.forms.B2BUnitForm" %>
<%@ attribute name="formUrl" required="true" type="java.lang.String" %>
<%@ attribute name="cancelUrl" required="true" type="java.lang.String" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-section-content">
    <form:form action="${formUrl}" method="post" commandName="b2BUnitForm">
        <div class="row">
            <form:input type="hidden" name="originalUid" path="originalUid" id="originalUid"/>

            <div class="col-xs-12 col-sm-6">
                <formElement:formInputBox idKey="b2bunit.id" labelKey="b2bunit.id" path="uid" inputCSS="text" mandatory="true"/>
            </div>
            <div class="col-xs-12 col-sm-6">
                <formElement:formInputBox idKey="b2bunit.name" labelKey="b2bunit.name" path="name" inputCSS="text" mandatory="true"/>
            </div>
            <div class="col-xs-12 col-sm-6">
                <formElement:formSelectBox idKey="b2bunit.parent" labelKey="b2bunit.parent" path="parentUnit" selectCSSClass="form-control"
                                           mandatory="false" skipBlank="false" skipBlankMessageKey="form.select.empty" items="${branchSelectOptions}"/>
            </div>
            <div class="col-xs-12 col-sm-6">
                <formElement:formSelectBox idKey="b2bunit.approvalProcess" labelKey="b2bunit.approvalProcess" selectCSSClass="form-control"
                                           path="approvalProcessCode" mandatory="false" skipBlank="false"
                                           skipBlankMessageKey="form.select.empty" items="${businessProcesses}"/>
            </div>
            <div class="col-xs-12">
                <div class="accountActions-bottom row">
                    <div class="col-sm-3 col-sm-push-9">
                        <ycommerce:testId code="unit_saveChange_button">
                            <button type="submit" class="confirm btn btn-primary btn-block">
                                <spring:theme code="b2bunit.save"/>
                            </button>
                        </ycommerce:testId>
                    </div>
                    <div class="col-sm-3 col-sm-push-3">
                        <ycommerce:testId code="unit_cancel_button">
                            <a href="${fn:escapeXml(cancelUrl)}" class="no-confirm btn btn-default btn-block">
                                <spring:theme code="b2bunit.cancel"/>
                            </a>
                        </ycommerce:testId>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
