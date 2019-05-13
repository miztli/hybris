<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="saveUrl" required="true" type="java.lang.String"%>
<%@ attribute name="cancelUrl" required="true" type="java.lang.String"%>
<%@ attribute name="b2BBudgetForm" required="true" type="de.hybris.platform.commerceorgaddon.forms.B2BBudgetForm"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:theme code="text.store.dateformat.datepicker.selection" text="mm/dd/yy" var="dateFormatForDatePicker" />
<spring:theme code="text.store.dateformat.datepicker.selection.hint" text="mm/dd/yyyy" var="dateFormatHint"/>
<div class="account-section-content">
	<form:form action="${saveUrl}" id="editB2bBudgetform" data-date-format-for-date-picker="${dateFormatForDatePicker}" data-date-format-hint="${dateFormatHint}" commandName="b2BBudgetForm"
				   method="POST">
		<div class="row">
			<form:input type="hidden" name="originalCode" path="originalCode" id="originalCode" />
			<div class="col-xs-12 col-sm-6">
				<formElement:formInputBox idKey="text.company.budget.budgetId" labelKey="text.company.budget.budgetId" path="code" inputCSS="text" mandatory="true" />
			</div>
			<div class="col-xs-12 col-sm-6">
				<formElement:formInputBox idKey="text.company.budget.name" labelKey="text.company.budget.name" path="name" inputCSS="text" mandatory="true" />
			</div>
			<div class="col-xs-12 col-sm-6">
				<formElement:formSelectBox idKey="text.company.budget.unit" skipBlankMessageKey="text.company.costCenter.selectBox.unit" labelKey="text.company.costCenter.unit.title"
										   path="parentB2BUnit" mandatory="true" selectCSSClass="form-control" items="${b2bUnits}" />
			</div>
			<div class="col-xs-12 col-sm-6">
				<formElement:formInputBox idKey="text.company.budget.amount" labelKey="text.company.budget.amount" path="budget" inputCSS="text" mandatory="true" placeholder="00.00"/>
			</div>
			<div class="col-xs-12 col-sm-6">
				<formElement:formSelectBox idKey="text.company.budget.currency" skipBlankMessageKey="text.company.costCenter.selectBox.currency" labelKey="text.company.costCenter.currency.title"
										   path="currency" mandatory="true" selectCSSClass="form-control" items="${b2bCostCenterCurrencies}" />
			</div>

			<div class="col-xs-12 col-sm-6">
				<div class="form-element-icon datepicker">
					<formElement:formInputBox idKey="budgetStartDate" labelKey="text.company.budget.startDate" path="startDate" inputCSS="date text" mandatory="true" placeholder="${dateFormatHint}" />
					<i class="glyphicon glyphicon-calendar js-open-datepicker-budgetStartDate"></i>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6">
				<div class="form-element-icon datepicker">
					<formElement:formInputBox idKey="budgetEndDate" labelKey="text.company.budget.endDate" path="endDate" inputCSS="date text" mandatory="true" placeholder="${dateFormatHint}" />
					<i class="glyphicon glyphicon-calendar js-open-datepicker-budgetEndDate"></i>
				</div>
			</div>

			<div class="col-xs-12">
				<div class="row accountActions-bottom">
					<div class="col-sm-3 col-sm-push-9">
						<ycommerce:testId code="Budget_Save_button">
							<button type="submit" class="confirm btn btn-block btn-primary" id="SubmitBudget_button"><spring:theme code="text.company.budget.saveButton.displayName"/></button>
						</ycommerce:testId>
					</div>
					<div class="col-sm-3 col-sm-push-3">
						<ycommerce:testId code="Budget_Cancel_button">
							<a href="${fn:escapeXml(cancelUrl)}" class="form btn-default btn btn-block"><spring:theme code="text.company.budget.cancelButton.displayName"/></a>
						</ycommerce:testId>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>