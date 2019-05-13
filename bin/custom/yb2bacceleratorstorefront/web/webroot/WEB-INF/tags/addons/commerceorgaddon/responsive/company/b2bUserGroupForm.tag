<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="b2BUserGroupForm" required="true"
			  type="de.hybris.platform.commerceorgaddon.forms.B2BUserGroupForm" %>
<%@ attribute name="formUrl" required="true"
			  type="java.lang.String" %>
<%@ attribute name="cancelUrl" required="true"
			  type="java.lang.String" %>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="account-section-content">
	<form:form action="${formUrl}" method="post" commandName="b2BUserGroupForm">
		<div class="row">
			<form:input type="hidden" name="originalUid" path="originalUid" id="originalUid"/>

			<div class="col-xs-12 col-sm-6">
				<formElement:formInputBox idKey="b2busergroup.id" labelKey="b2busergroup.id"
										  path="uid" inputCSS="text" mandatory="true"/>
			</div>
			<div class="col-xs-12 col-sm-6">
				<formElement:formInputBox idKey="b2busergroup.name" labelKey="b2busergroup.name"
										  path="name" inputCSS="text" mandatory="true"/>
			</div>
			<div class="col-xs-12 col-sm-6">
				<formElement:formSelectBox idKey="b2busergroup.parent" labelKey="b2busergroup.parent"
										   path="parentUnit"
										   mandatory="false" selectCSSClass="form-control" skipBlank="false"
										   skipBlankMessageKey="form.select.empty"
										   items="${branchSelectOptions}"/>
			</div>
			<div class="col-xs-12">
				<div class="accountActions-bottom row">
					<div class="col-sm-3 col-sm-push-9">
						<ycommerce:testId code="UserGroup_SaveChange_button">
							<button type="submit" class="confirm btn btn-block btn-primary"><spring:theme code="text.company.save.button"/></button>
						</ycommerce:testId>
					</div>
					<div class="col-sm-3 col-sm-push-3">
						<a href="${fn:escapeXml(cancelUrl)}" class="back_button">
							<button id="backButton" class="form btn-default btn btn-block" type="button">
								<spring:theme code="b2busergroup.cancel"/>
							</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>