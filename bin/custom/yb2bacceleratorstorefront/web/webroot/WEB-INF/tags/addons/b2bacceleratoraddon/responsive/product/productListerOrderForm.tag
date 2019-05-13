<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ attribute name="filterSkus" required="false" type="java.util.List" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="addonProduct" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/cart/addGrid" var="addToCartGridUrl" htmlEscape="false"/>
<li class="item__list--item js-item-list-item">
	<addonProduct:productListerItemDetails product="${product}" />
</li>
<div class="js-order-form-grid-wrapper add-to-cart-order-form-wrap">
    <div class="scrollContent" id="cartOrderGridForm">
        <product:productOrderFormGrid product="${product}" showName="false" filterSkus="${filterSkus}" isOrderForm="true" />
        <div class="order-form-scroll right hidden-xs"><span class="glyphicon glyphicon-chevron-right"></span></div>
        <div class="order-form-scroll left hidden-xs"><span class="glyphicon glyphicon-chevron-left"></span></div>
        <div class="order-form-scroll up hidden-xs"><span class="glyphicon glyphicon-chevron-up"></span></div>
        <div class="order-form-scroll down hidden-xs"><span class="glyphicon glyphicon-chevron-down"></span></div>
    </div>
</div>
