<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="url" required="true" type="java.lang.String"%>
<%@ attribute name="labelKey" required="true" type="java.lang.String"%>
<%@ attribute name="urlTestId" required="false" type="java.lang.String"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-section-header">
	<spring:theme code="${labelKey}"/>
	<div class="account-section-header-add pull-right">
		<ycommerce:testId code="${urlTestId}">
			<a href="${fn:escapeXml(url)}" class="button add"><spring:theme code="text.company.addNew.button"/></a>
		</ycommerce:testId>
	</div>
</div>