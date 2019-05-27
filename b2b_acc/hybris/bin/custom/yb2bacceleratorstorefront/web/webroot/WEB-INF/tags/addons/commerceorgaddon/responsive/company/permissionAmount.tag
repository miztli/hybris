<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="permission" required="true" type="de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData"%>
<%@ attribute name="displayBracketsAroundCurrency" required="true" type="java.lang.Boolean"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:choose>
    <c:when test="${permission.b2BPermissionTypeData.code ne 'B2BBudgetExceededPermission' }">
        <fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${permission.value}"/>
        <c:choose>
            <c:when test="${displayBracketsAroundCurrency}">
                (${fn:escapeXml(permission.currency.isocode)})
            </c:when>
            <c:otherwise>
                &nbsp;${fn:escapeXml(permission.currency.isocode)}
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <spring:theme code="text.company.not.applicable"/>
    </c:otherwise>
</c:choose>