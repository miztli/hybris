<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url value="${product.url}" var="productUrl"/>
<spring:htmlEscape defaultHtmlEscape="true" />

<li class="item__list--item">
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

    <%-- product name --%>
    <div class="item__info">
        <a href="${fn:escapeXml(productUrl)}" title="${fn:escapeXml(product.name)}">
            <div class="item-name">${ycommerce:sanitizeHTML(product.name)}</div>
        </a>
    </div>

    <%-- price --%>
    <div class="item__price">
        <span class="visible-xs visible-sm"><spring:theme code="basket.page.itemPrice"/>: </span>
        <product:productListerItemPrice product="${product}"/>
    </div>


    <div class="item-variants">
        <div class="item-id-checkbox">
            <c:set var="checkBoxClass" value="js-checkbox-sku-id"/>
            <c:if test="${not empty product.firstCategoryNameList or not empty product.variantMatrix}">
                <c:set var="checkBoxClass" value="js-checkbox-base-product"/>
            </c:if>
            <label class="form-control-checkbox">
                <input type="checkbox" value="${fn:escapeXml(product.code)}" class="${fn:escapeXml(checkBoxClass)}">
                <div class="form-control-label"><c:out value='${product.code}'/></div>
            </label>
        </div>

        <c:choose>
            <c:when test="${not empty product.firstCategoryNameList }">
                <div id="priority1Dimensions" class ="variant-checkboxes">
                    <div class="row">
                        <c:forEach var="firstDimension" items="${product.firstCategoryNameList}">
                            <div class="col-sm-6 col-md-4">
                                <label class="form-control-checkbox">
                                    <input class="js-checkbox-sku-id" type="checkbox" name="productIdsList" id="productIdsList"
                                                    base-product-code="${fn:escapeXml(product.code)}"
                                                    value="${fn:escapeXml(firstDimension.variantCode)}"> ${fn:escapeXml(firstDimension.categoryName)}
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="hasVariants" value="false"/>
                <c:forEach items="${product.variantMatrix}" var="variant">
                    <c:if test="${variant.variantOption.stock.stockLevel != 0}">
                        <c:set var="hasVariants" value="true"/>
                    </c:if>
                </c:forEach>
                <c:if test="${hasVariants}">
                    <div id="priority1Dimensions" class ="variant-checkboxes">
                        <div class="row">
                </c:if>
                            <c:forEach items="${product.variantMatrix}" var="variant">
                                <c:if test="${variant.variantOption.stock.stockLevel != 0}">
                                    <div class="col-sm-6 col-md-4">
                                        <label class="form-control-checkbox">
                                            <input class="js-checkbox-sku-id" type="checkbox" name="productIdsList" id="productIdsList"
                                                    base-product-code="${fn:escapeXml(product.code)}"
                                                    value="${fn:escapeXml(variant.variantOption.code)}"> ${fn:escapeXml(variant.variantValueCategory.name)}
                                        </label>
                                    </div>
                                </c:if>
                            </c:forEach>
                <c:if test="${hasVariants}">
                        </div>
                    </div>
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>
</li>
