<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="saveUrl" required="true" type="java.lang.String" %>
<%@ attribute name="cancelUrl" required="true" type="java.lang.String" %>
<%@ attribute name="b2BCostCenterForm" required="true"
              type="de.hybris.platform.commerceorgaddon.forms.B2BCostCenterForm" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-section-content">
    <form:form action="${saveUrl}" id="b2BCostCenterform"
           commandName="b2BCostCenterForm" method="POST">
        <div class="row">
            <form:input type="hidden" name="originalCode" path="originalCode"
                        id="originalCode"/>
            <div class="col-xs-12 col-sm-6">
                <formElement:formInputBox idKey="text.company.costCenter.id.title"
                                          labelKey="text.company.costCenter.id.title" path="code"
                                          inputCSS="text" mandatory="true"/>
            </div>
            <div class="col-xs-12 col-sm-6">
                <formElement:formInputBox idKey="text.company.costCenter.name.title"
                                          labelKey="text.company.costCenter.name.title" path="name"
                                          inputCSS="text" mandatory="true"/>
            </div>
            <div class="col-xs-12 col-sm-6">
                <formElement:formSelectBox idKey="text.company.costCenter.unit.title"
                                           skipBlank="true" labelKey="text.company.costCenter.unit.title"
                                           path="parentB2BUnit" mandatory="true" selectCSSClass="form-control" items="${b2bUnits}"/>
            </div>
            <div class="col-xs-12 col-sm-6">
                <formElement:formSelectBox idKey="text.company.costCenter.currency.title"
                                           skipBlank="true" labelKey="text.company.costCenter.currency.title"
                                           path="currency" mandatory="true" selectCSSClass="form-control" items="${b2bCostCenterCurrencies}"/>
            </div>
            <div class="col-xs-12">
                <div class="row accountActions-bottom">
                    <div class="col-sm-3 col-sm-push-9">
                        <button type="submit" class="button confirm btn btn-block btn-primary">
                            <spring:theme code="text.company.costCenter.saveButton.displayName"/>
                        </button>
                    </div>
                    <div class="col-sm-3 col-sm-push-3">
                        <a href="${fn:escapeXml(cancelUrl)}" class="back_button">
                            <button id="backButton" class="form btn-default btn btn-block" type="button">
                                <spring:theme code="text.company.costCenter.cancelButton.displayName"/>
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>