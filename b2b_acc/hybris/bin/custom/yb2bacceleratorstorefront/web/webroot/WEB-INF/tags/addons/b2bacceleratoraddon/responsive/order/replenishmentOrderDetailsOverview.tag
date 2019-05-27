<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="scheduleData" required="true"
              type="de.hybris.platform.b2bacceleratorfacades.order.data.ScheduledCartData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<spring:htmlEscape defaultHtmlEscape="true"/>
<div class="row">
	<div class="col-sm-3 item-wrapper">
		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_overviewOrderID_label">
			<span class="item-label">
				<spring:theme code="text.account.replenishment.replenishmentNumber"/>
			</span>
			<span class="item-value">
				<c:out value="${scheduleData.jobCode}"/>
			</span>
			</ycommerce:testId>
		</div>

		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_overviewPurchaseOrderNumber_label">
			<span class="item-label">
				<spring:theme code="text.account.replenishment.purchaseOrderNumber"/>
			</span>
			<span class="item-value">
				<c:out value="${scheduleData.purchaseOrderNumber}"/>
			</span>
			</ycommerce:testId>
		</div>

		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_overviewPlacedBy_label">
			<span class="item-label">
				<spring:theme code="checkout.multi.summary.orderPlacedBy"/>
			</span>
			<span class="item-value">
				<spring:theme code="text.company.user.${scheduleData.b2bCustomerData.titleCode}.name"/>
				&nbsp;
				<c:out value="${scheduleData.b2bCustomerData.firstName}"/>
				&nbsp;
				<c:out value="${scheduleData.b2bCustomerData.lastName}"/>
			</span>
			</ycommerce:testId>
		</div>

	</div>

	<div class="col-sm-3 item-wrapper">
		<c:if test="${scheduleData.paymentType.code=='ACCOUNT'}">
			<div class="item-group">
				<ycommerce:testId code="replenishment_orderDetail_overviewParentBusinessUnit_label">
				<span class="item-label">
					<spring:theme code="text.account.orderApprovalDetails.parentBusinessUnit"/>
				</span>
				<span class="item-value">
					<c:out value="${scheduleData.costCenter.unit.uid}"/>
				</span>
				</ycommerce:testId>
			</div>
			<div class="item-group">
				<ycommerce:testId code="replenishment_orderDetail_overviewCostCenter_label">
				<span class="item-label">
					<spring:theme code="checkout.multi.costCenter.label"/>
				</span>
				<span class="item-value">
					<c:out value="${scheduleData.costCenter.name}"/>
				</span>
				</ycommerce:testId>
			</div>
		</c:if>
	</div>

	<div class="col-sm-3 item-wrapper">
		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_startDate_label">
			<span class="item-label">
				<spring:theme code="text.account.replenishment.startDate"/>
			</span>
			<span class="item-value">
				<fmt:formatDate value="${scheduleData.firstOrderDate}" dateStyle="medium"/>
			</span>
			</ycommerce:testId>
		</div>
		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_frequency_label">
			<span class="item-label">
				<spring:theme code="text.account.replenishment.frequency"/>
			</span>
			<span class="item-value">
				<c:out value="${scheduleData.triggerData.displayTimeTable}"/>
			</span>
			</ycommerce:testId>
		</div>
	</div>


	<div class="col-sm-3 item-wrapper">
		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_nextOrderDate_label">
			<span class="item-label">
				<spring:theme code="text.account.replenishment.nextOrderDate"/>
			</span>
			<span class="item-value">
				<c:choose>
					<c:when test="${scheduleData.active}">
						<fmt:formatDate value="${scheduleData.triggerData.activationTime}" dateStyle="medium"/>
					</c:when>
					<c:otherwise>
						<spring:theme code="text.account.replenishment.canceled"/>
					</c:otherwise>
				</c:choose>
			</span>
			</ycommerce:testId>
		</div>
		<div class="item-group">
			<ycommerce:testId code="replenishment_orderDetail_overviewOrderTotal_label">
			<span class="item-label">
				<spring:theme code="text.account.order.total"/>
			</span>
			<span class="item-value">
				<c:out value="${scheduleData.totalPrice.formattedValue}"/>
			</span>
			</ycommerce:testId>
		</div>
	</div>
</div>