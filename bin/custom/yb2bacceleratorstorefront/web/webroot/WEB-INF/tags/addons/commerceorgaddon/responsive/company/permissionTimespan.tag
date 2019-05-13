<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="permission" required="true" type="de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:choose>
    <c:when test="${permission.b2BPermissionTypeData.code eq 'B2BOrderThresholdTimespanPermission'}">
        ${fn:escapeXml(permission.timeSpan)}
    </c:when>
    <c:otherwise>
        <spring:theme code="text.company.not.applicable"/>
    </c:otherwise>
</c:choose>