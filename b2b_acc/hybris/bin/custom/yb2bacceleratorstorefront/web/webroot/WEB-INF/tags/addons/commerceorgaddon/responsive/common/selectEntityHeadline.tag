<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="url" required="true" type="java.lang.String"%>
<%@ attribute name="labelKey" required="true" type="java.lang.String"%>
<%@ attribute name="count" required="false" type="java.lang.String"%>
<%@ attribute name="addNew" required="false" type="java.lang.Boolean"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-list-header">
    <spring:theme code="${labelKey}"/><c:if test="${not empty count}"> (${fn:escapeXml(count)})</c:if>
	<div class="account-list-header-add pull-right">
		<a href="${fn:escapeXml(url)}" class="button edit">
			<span class="visible-xs"><spring:theme code="text.company.add.button"/></span>
			<span class="hidden-xs">
				<c:choose>
					<c:when test="${addNew}">						
						<spring:theme code="text.company.addNew.button"/>
					</c:when>
					<c:otherwise>
						<spring:theme code="text.company.addExisting.button"/>
					</c:otherwise>
				</c:choose>
			</span>
		</a>
    </div>
</div>