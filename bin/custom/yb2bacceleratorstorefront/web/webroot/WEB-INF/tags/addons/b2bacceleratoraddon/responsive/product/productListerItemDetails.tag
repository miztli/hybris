<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="${product.url}" var="searchUrl" htmlEscape="false"/>

    <%-- chevron for multi-d products --%>
    <div class="hidden-xs hidden-sm item__toggle">
        <div class="js-show-order-form-grid-wrapper">
            <ycommerce:testId code="cart_product_updateQuantity">
                <span class="glyphicon glyphicon-chevron-down"></span>
            </ycommerce:testId>
        </div>
    </div>

    <%-- product image --%>
    <div class="item__image">
        <c:if test="${not empty product.averageRating}">
                <span class="stars large" style="display: inherit;">
                <span style="width: <fmt:formatNumber maxFractionDigits="0"
                                                      value="${product.averageRating * 24}"/>px;"></span>
            </span>
        </c:if>

        <a href="${fn:escapeXml(productUrl)}" title="${fn:escapeXml(product.name)}">
            <product:productPrimaryImage product="${product}" format="thumbnail"/>
        </a>
    </div>

    <%-- product name, code, promotions --%>
    <div class="item__info">
        <ycommerce:testId code="searchPage_productName_link_${product.code}">
            <a href="${fn:escapeXml(searchUrl)}" title="${fn:escapeXml(product.name)}">
                <div class="item-name">${ycommerce:sanitizeHTML(product.name)}</div>
            </a>
        </ycommerce:testId>

        <div class="item__code">${fn:escapeXml(product.code)}</div>
    </div>

    <%-- price --%>
    <div class="item__price">
        <span class="visible-xs visible-sm"><spring:theme code="basket.page.itemPrice"/>: </span>
        <product:productListerItemPrice product="${product}"/>
    </div>

    <%-- description --%>
    <div class="item__description">
        <product:productListerClassifications product="${product}"/>
    </div>

    <div class="item__quantity__total col-xs-12 visible-xs visible-sm">
        <div class="details js-show-order-form-grid-wrapper">
            <div class="qty">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </div>
        </div>
    </div>