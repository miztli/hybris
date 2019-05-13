<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/responsive/order" %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<c:if test="${not empty orderData}">
    <div class="account-orderdetail account-consignment">
        <ycommerce:testId code="replenishment_orderDetail_itemHeader_section">
            <div class="well well-quinary well-xs">
                <div class="well-headline">
                    <spring:theme code="text.account.replenishment.shipToItems"/>
                </div>

                <c:set var="hasShippedItems" value="${orderData.deliveryItemsQuantity > 0}"/>
                <div class="well-content">
                    <div class="row">
                        <div class="col-sm-12 col-md-9">
                            <c:choose>
                                <c:when test="${hasShippedItems}">
                                    <div class="row">
                                        <div class="col-sm-6 col-md-4 order-ship-to">
                                            <div class="label-order">
                                                <spring:theme code="text.account.order.shipto"/>
                                            </div>
                                            <div class="value-order">
                                                <order:addressItem address="${orderData.deliveryAddress}"/>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-4 order-shipping-method">
                                            <ycommerce:testId code="replenishment_orderDetail_deliveryMethod_section">
                                                <order:deliveryMethodItem order="${orderData}"/>
                                            </ycommerce:testId>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="label-order">
                                        <spring:theme code="checkout.pickup.no.delivery.required"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </ycommerce:testId>

        <ul class="item__list">
            <li class="hidden-xs hidden-sm">
                <ul class="item__list--header">
                    <li class="item__toggle"></li>
                    <li class="item__image"></li>
                    <li class="item__info"><spring:theme code="basket.page.item"/></li>
                    <li class="item__price"><spring:theme code="basket.page.price"/></li>
                    <li class="item__quantity"><spring:theme code="basket.page.qty"/></li>
                    <li class="item__total--column"><spring:theme code="basket.page.total"/></li>
                </ul>
            </li>
            <ycommerce:testId code="replenishment_orderDetail_itemBody_section">
                <c:forEach items="${orderData.entries}" var="entry" varStatus="loop">
					<spring:url value="/my-account/my-replenishment/{/jobCode}/getReadOnlyProductVariantMatrix"
						var="getProductVariantMatrixUrl" htmlEscape="false">
						<spring:param name="jobCode" value="${orderData.jobCode}"/>
					</spring:url>
                    <order:orderEntryDetails orderEntry="${entry}" order="${orderData}" itemIndex="${loop.index}" 
                    	targetUrl="${getProductVariantMatrixUrl}" showViewConfigurationInfos="false"/>
                </c:forEach>
            </ycommerce:testId>
        </ul>
    </div>
</c:if>