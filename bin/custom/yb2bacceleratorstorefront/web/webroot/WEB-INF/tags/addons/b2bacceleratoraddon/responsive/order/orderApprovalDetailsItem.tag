<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="order" required="true" type="de.hybris.platform.commercefacades.order.data.AbstractOrderData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true"/>
<c:if test="${not empty order.b2bPermissionResult}">
	<div class="account-orderdetail well well-tertiary">
        <div class="well-headline">
            <spring:theme code="text.account.order.approval.title" />
        </div>
    </div>
    <div class="order-approval-list">
        <table class="orderListTable responsive-table">
        <thead>
            <tr class="responsive-table-head hidden-xs">
                <th><spring:theme code="text.account.order.permission.title" /></th>
                <th><spring:theme code="text.account.order.approver.title" /></th>
                <th><spring:theme code="text.account.order.status.title" /></th>
                <th><spring:theme code="text.account.order.permission.notes"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${order.b2bPermissionResult}" var="b2bPermissionResult">
                <tr class="responsive-table-item">
                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.order.permission.title" /></td>
                    <td class="responsive-table-cell">${fn:escapeXml(b2bPermissionResult.permissionTypeData.name)}</td>

                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.order.approver.title" /></td>
                    <td class="responsive-table-cell">${fn:escapeXml(b2bPermissionResult.approver)}</td>

                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.order.status.title" /></td>
                    <td class="responsive-table-cell">${fn:escapeXml(b2bPermissionResult.statusDisplay)}</td>

                    <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.order.permission.notes"/></td>
                    <td class="responsive-table-cell">
                    <c:choose>
                        <c:when test="${not empty b2bPermissionResult.approverNotes}">
                            ${fn:escapeXml(b2bPermissionResult.approverNotes)}
                        </c:when>
                        <c:otherwise>
                            <span><spring:theme code="text.notAvailable"/></span>
                        </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
    </div>
</c:if>