<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ attribute name="permission" required="true" type="de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData"%>
<%@ attribute name="listCSSClass" required="false" type="java.lang.Object"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-permissions/view/" var="permissionUrl" htmlEscape="false">
    <spring:param name="permissionCode" value="${permission.code}"/>
</spring:url>

<spring:url value="/my-company/organization-management/manage-units/details" var="unitUrl" htmlEscape="false">
    <spring:param name="unit" value="${permission.unit.uid}" />
</spring:url>

<ul <c:if test="${not empty listCSSClass}">class="${fn:escapeXml(listCSSClass)}"</c:if>>
    <li>
        <ycommerce:testId code="${action}_name_link">
            <a href="${fn:escapeXml(permissionUrl)}">${fn:escapeXml(permission.code)}</a>
        </ycommerce:testId>
    </li>
    <li>
        <ycommerce:testId code="${action}_type_label">
            ${fn:escapeXml(permission.b2BPermissionTypeData.name)}
        </ycommerce:testId>
    </li>

    <c:if test="${permission.b2BPermissionTypeData.code eq 'B2BOrderThresholdTimespanPermission'}">
        <li>
            <ycommerce:testId code="${action}_timespan_label">
                ${fn:escapeXml(permission.timeSpan)}
            </ycommerce:testId>
        </li>
    </c:if>

    <c:if test="${permission.b2BPermissionTypeData.code ne 'B2BBudgetExceededPermission'}">
        <li>
            <ycommerce:testId code="${action}_value_label">
                <fmt:formatNumber value="${permission.value}" maxFractionDigits="2" minFractionDigits="2"/>
            </ycommerce:testId>
            &nbsp;
            <ycommerce:testId code="${action}_currency_label">
                (${fn:escapeXml(permission.currency.name)})
            </ycommerce:testId>
        </li>
    </c:if>

    <li>
        <ycommerce:testId code="${action}_b2bunit_link">
            <a href="${fn:escapeXml(unitUrl)}">${fn:escapeXml(permission.unit.name)}</a>
        </ycommerce:testId>
    </li>
</ul>
