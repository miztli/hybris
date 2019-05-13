<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="searchUrl" required="true" type="String" %>
<%@ attribute name="messageKey" required="true" type="String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<c:if test="${empty searchPageData.results}">
    <div class="row">
        <div class="col-md-6 col-md-push-3">
            <div class="account-section-content content-empty">
                <ycommerce:testId code="orderHistory_noOrders_label">
                    <spring:theme code="text.account.orderHistory.noOrders"/>
                </ycommerce:testId>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty searchPageData.results}">
    <div class="account-section-content">
        <div class="account-orderhistory">
            <div class="account-orderhistory-pagination">
                <nav:pagination top="true" msgKey="${messageKey}" showCurrentPageInfo="true" hideRefineButton="true"
                                supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}"
                                searchPageData="${searchPageData}" searchUrl="${searchUrl}"
                                numberPagesShown="${numberPagesShown}"/>
            </div>
            <div class="responsive-table">
                <table class="responsive-table">
                    <thead>
                    <tr class="responsive-table-head hidden-xs">
                        <th id="header1"><spring:theme code="text.account.orderHistory.orderNumber"/></th>
                        <th id="header2"><spring:theme code="text.account.orderHistory.purchaseOrderNumber"/></th>
                        <th id="header3"><spring:theme code="text.account.orderHistory.orderStatus"/></th>
                        <th id="header4"><spring:theme code="text.account.orderHistory.datePlaced"/></th>
                        <th id="header5"><spring:theme code="text.account.orderHistory.total"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${searchPageData.results}" var="order">
                        <tr class="responsive-table-item">
                            <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.orderHistory.orderNumber"/></td>
                            <td headers="header1" class="responsive-table-cell">
                                <ycommerce:testId code="orderHistoryItem_orderDetails_link">
                                    <spring:url value="/my-account/order/{/orderCode}" var="orderDetailsUrl" htmlEscape="false">
                                        <spring:param name="orderCode" value="${order.code}" />
                                    </spring:url>
                                    <a href="${fn:escapeXml(orderDetailsUrl)}" class="responsive-table-link">
                                    	${fn:escapeXml(order.code)}
                                    </a>
                                </ycommerce:testId>
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.orderHistory.purchaseOrderNumber"/></td>
                            <td headers="header2" class="responsive-table-cell">
                                    ${fn:escapeXml(order.purchaseOrderNumber)}
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.orderHistory.orderStatus"/></td>
                            <td headers="header3" class="responsive-table-cell">
                                <spring:theme code="text.account.order.status.display.${order.statusDisplay}"/>
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg"><spring:theme
                                    code="text.account.orderHistory.datePlaced"/></td>
                            <td headers="header4" class="responsive-table-cell">
                                <fmt:formatDate value="${order.placed}" dateStyle="medium" timeStyle="short" type="both"/>
                            </td>
                            <td class="hidden-sm hidden-md hidden-lg responsive-table-cell-bold"><spring:theme code="text.account.orderHistory.total"/></td>
                            <td headers="header5" class="responsive-table-cell responsive-table-cell-bold">
                                <div>${fn:escapeXml(order.total.formattedValue)}</div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="account-orderhistory-pagination">
            <nav:pagination top="false" msgKey="${messageKey}" showCurrentPageInfo="true" hideRefineButton="true"
                            supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}"
                            searchPageData="${searchPageData}" searchUrl="${searchUrl}"
                            numberPagesShown="${numberPagesShown}"/>
        </div>
    </div>
</c:if>
