<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<c:set var="searchUrl" value="/my-account/approval-dashboard?sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}" />

<div class="account-section-header">
	<spring:theme code="text.account.orderApprovalDashboard" />
</div>

<c:if test="${empty searchPageData.results}">
	<div class="row">
		<div class="col-md-6 col-md-push-3">
			<div class="account-section-content content-empty">
				<ycommerce:testId code="orderHistory_noOrders_label">
					<spring:theme code="text.account.orderHistory.noOrders" />
				</ycommerce:testId>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${not empty searchPageData.results}">
	<div class="account-section-content	">
		<div class="account-orderhistory">
			<div class="account-orderhistory-pagination">
				<nav:pagination top="true" msgKey="text.account.orderHistory.page" showCurrentPageInfo="true" hideRefineButton="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${searchUrl}" numberPagesShown="${numberPagesShown}" />
			</div>

			<div class="responsive-table">
				<table id="order_history" class="responsive-table">
					<thead>
						<tr class="responsive-table-head hidden-xs">
							<th><spring:theme code="text.account.orderApprovalDashBoard.orderNumber" /></th>
							<th><spring:theme code="text.account.orderApprovalDashBoard.purchaseOrderNumber" /></th>
							<th><spring:theme code="text.account.orderApprovalDashBoard.orderStatus" /></th>
							<th><spring:theme code="text.account.orderApprovalDetails.orderPlacedBy" /></th>
							<th><spring:theme code="text.account.orderHistory.datePlaced" /></th>
							<th><spring:theme code="text.account.order.total" /></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchPageData.results}" var="order">
						<tr class="responsive-table-item">
							<td class="hidden-sm hidden-md hidden-lg"><spring:theme code='text.account.orderApprovalDashBoard.orderNumber'/></td>
							<td class="responsive-table-cell">
								<ycommerce:testId code="orderApprovalDashboard_orderNumber_link">
								    <spring:url value="/my-account/orderApprovalDetails/{/workflowActionModelCode}" var="orderApprovalDetailsUrl" htmlEscape="false">
								        <spring:param name="workflowActionModelCode" value="${order.workflowActionModelCode}" />
                                     </spring:url>
									<a href="${fn:escapeXml(orderApprovalDetailsUrl)}" class="responsive-table-link">${fn:escapeXml(order.b2bOrderData.code)}</a>
								</ycommerce:testId>
							</td>
							<td class="hidden-sm hidden-md hidden-lg"><spring:theme code='text.account.orderApprovalDashBoard.purchaseOrderNumber'/></td>
							<td class="responsive-table-cell">
								<ycommerce:testId code="orderApprovalDashboard_purchaseOrderNumber_label">
									<c:choose>
										<c:when test="${empty order.b2bOrderData.purchaseOrderNumber}">
											&nbsp;
										</c:when>
										<c:otherwise>
											${fn:escapeXml(order.b2bOrderData.purchaseOrderNumber)}
										</c:otherwise>
									</c:choose>
								</ycommerce:testId>
							</td>
							<td class="hidden-sm hidden-md hidden-lg"><spring:theme code='text.account.orderApprovalDashBoard.orderStatus'/></td>
							<td class="status">
								<ycommerce:testId code="orderApprovalDashboard_orderStatus_label">
									<spring:theme code="text.account.order.status.display.${order.b2bOrderData.statusDisplay}" />
								</ycommerce:testId>
							</td>
							<td class="hidden-sm hidden-md hidden-lg"><spring:theme code="text.account.orderApprovalDetails.orderPlacedBy" /></td>
							<td class="responsive-table-cell">
								<ycommerce:testId code="orderApprovalDashboard_orderpurchaser_link">
									${fn:escapeXml(order.b2bOrderData.b2bCustomerData.name)}
								</ycommerce:testId>
							</td>
							<td class="hidden-sm hidden-md hidden-lg"><spring:theme code='text.account.orderHistory.datePlaced'/></td>
							<td class="responsive-table-cell">
								<fmt:formatDate value="${order.b2bOrderData.created}" dateStyle="medium" timeStyle="short" type="both" />
							</td>
							<td class="hidden-sm hidden-md hidden-lg responsive-table-cell-bold"><spring:theme code='text.account.order.total'/></td>
							<td class="responsive-table-cell responsive-table-cell-bold">
								${fn:escapeXml(order.b2bOrderData.totalPrice.formattedValue)}
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="account-orderhistory-pagination">
				<nav:pagination top="false" msgKey="text.account.orderHistory.page" showCurrentPageInfo="true" hideRefineButton="true" supportShowPaged="${isShowPageAllowed}" supportShowAll="false" searchPageData="${searchPageData}" searchUrl="${searchUrl}" numberPagesShown="${numberPagesShown}" />
			</div>
		</div>
	</div>
</c:if>