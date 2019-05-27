<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="addonProduct" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/product" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/nav" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="addonFormElement" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/formElement" %>

<spring:htmlEscape defaultHtmlEscape="true"/>
<jsp:useBean id="additionalParams" class="java.util.HashMap"/>
<c:set target="${additionalParams}" property="searchResultType" value="${advancedSearchForm.searchResultType}"/>
<c:set target="${additionalParams}" property="isCreateOrderForm" value="${advancedSearchForm.createOrderForm}"/>
<c:set target="${additionalParams}" property="onlyProductIds" value="${advancedSearchForm.onlyProductIds}"/>

<template:page pageTitle="${pageTitle}">
    <jsp:body>
        <div class="span-24" id="orderFormContainer">
            <cms:pageSlot position="SideContent" var="feature" element="div"
                          class="span-4 side-content-slot cms_disp-img_slot">
                <cms:component component="${feature}"/>
            </cms:pageSlot>

            <div class="advancedSearch">
                <div class="headline border"><spring:theme code="search.advanced"/></div>
                <spring:url value="/search/advanced" var="advancedSearchUrl" htmlEscape="false"/>
                <form:form action="${advancedSearchUrl}" method="get" name="advancedSearchForm"
                           commandName="advancedSearchForm">
                    <div class="advanced-search-wrap">
                        <div class="row">
                            <div class="col-xs-12 col-md-8 col-lg-6">
                                <div class="searchInput">
                                    <formElement:formInputBox idKey="js-product-ids" labelKey="search.advanced.keyword"
                                                              path="keywords" inputCSS="" />
                                </div>

                                <div class="only-productId">
                                    <formElement:formCheckbox idKey="js-enable-product-ids"
                                                              labelKey="search.advanced.onlyproductids"
                                                              path="onlyProductIds"
                                                              inputCSS="" labelCSS="form-control-checkbox"
                                                              mandatory="false"/>
                                </div>

                                <div id="js-selected-product-ids" class="selected_product_ids clearfix"></div>

                                <div class="row">
                                    <div class="col-xs-6">
                                        <addonFormElement:formRadioBoxLeft idKey="search-order-form"
                                                                           labelKey="search.advanced.orderform"
                                                                           value="order-form" path="searchResultType"/>
                                    </div>
                                    <div class="col-xs-6">
                                        <addonFormElement:formRadioBoxLeft idKey="search-create-order-form"
                                                                           labelKey="search.advanced.createorderform"
                                                                           value="create-order-form"
                                                                           path="searchResultType"/>
                                    </div>
                                </div>

                                <c:set var="isCreateOrderForm" value="${form.createOrderForm}"/>
                                <c:if test="${empty isCreateOrderForm }">
                                    <c:set var="isCreateOrderForm" value="false"/>
                                </c:if>

                                <div class="searchButton">
                                    <input type="hidden" name="isCreateOrderForm" id="isCreateOrderForm"
                                           value="${fn:escapeXml(isCreateOrderForm)}"/>
                                    <button class="btn btn-block btn-primary positive adv_search_button" type="submit">
                                        <spring:theme code="search.advanced.search"/>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>

                <c:if test="${not empty advancedSearchForm.keywords}">
                    <nav:orderFormPagination top="true" supportShowPaged="${isShowPageAllowed}"
                                             supportShowAll="false"
                                             searchPageData="${searchPageData}"
                                             searchUrl="${paginateUrl}"
                                             numberPagesShown="${numberPagesShown}"
                                             additionalParams="${additionalParams}"/>
                </c:if>

                <c:if test="${not empty advancedSearchForm.keywords && advancedSearchForm.orderFormSearchResultType}">
                    <div class="product-action">
                        <div class="hidden-xs">
                            <spring:theme code="product.grid.items.selected"/>&nbsp;
                            <span class="js-total-items-count">0</span>
                        </div>
                        <div class="hidden-sm hidden-md hidden-lg">
                            <spring:theme code="product.grid.formDescription"/>
                        </div>
                        <ol>
                            <product:productFormAddToCartPanel product="${product}" showViewDetails="false" addToCartBtnId="js-add-to-cart-order-form-btn-top"/>
                        </ol>
                    </div>
                </c:if>


                <c:set var="skuIndex" scope="session" value="0"/>
                <spring:theme code="product.grid.confirmQtys.message" var="gridConfirmMessage"/>


                <c:if test="${not empty advancedSearchForm.keywords && advancedSearchForm.orderFormSearchResultType}">
                    <spring:url value="/cart/addGrid" var="addToCartGridUrl" htmlEscape="false" />
                    <form:form name="AddToCartOrderForm" id="AddToCartOrderForm"
                          action="${addToCartGridUrl}" method="post"
                          data-grid-confirm-message="${gridConfirmMessage}">
                         <addonProduct:productLister pageData="${searchPageData}" path="/search"
                                                    itemType="ORDERFORM"
                                                    isOnlyProductIds="${advancedSearchForm.onlyProductIds}"
                                                    filterSkus="${advancedSearchForm.filterSkus}"/>
                    </form:form>

                    <div id="skuIndexSavedValue" name="skuIndexSavedValue"
                         data-sku-index="${sessionScope.skuIndex}">
                        <%--  don't remove this div. This is used by the order form search --%></div>
                </c:if>

                <c:if test="${ not empty advancedSearchForm.keywords && advancedSearchForm.createOrderFormSearchResultType && searchPageData.pagination.totalNumberOfResults != 0}">
                    <form name="createOrderForm" id="createOrderForm" class="create-order-form"
                          data-grid-confirm-message="${gridConfirmMessage}">

                        <div class="create-order-form-button">
                            <button class="btn btn-primary js-create-order-form-button" type="button" disabled="disabled"><spring:theme
                                    code='search.advanced.createorderform'/></button>
                        </div>
                        <addonProduct:productLister pageData="${searchPageData}" path="/search"
                                                    itemType="FILTER"
                                                    isOnlyProductIds="false"
                                                    filterSkus="${advancedSearchForm.filterSkus}"/>

                        <div class="create-order-form-button bottom">
                            <button class="btn btn-primary js-create-order-form-button" type="button" disabled="disabled"><spring:theme
                                    code='search.advanced.createorderform'/></button>
                        </div>
                    </form>
                </c:if>

                <c:if test="${not empty advancedSearchForm.keywords && advancedSearchForm.orderFormSearchResultType}">
                    <div class="product-action bottom">
                        <div class="hidden-xs">
                            <spring:theme code="product.grid.items.selected"/>&nbsp;
                            <span class="js-total-items-count">0</span>
                        </div>
                        <div class="hidden-sm hidden-md hidden-lg">
                            <spring:theme code="product.grid.formDescription"/>
                        </div>
                        <ol>
                            <product:productFormAddToCartPanel product="${product}" showViewDetails="false" addToCartBtnId="js-add-to-cart-order-form-btn-bottom"/>
                        </ol>
                    </div>
                </c:if>

                <c:if test="${not empty advancedSearchForm.keywords}">
                    <nav:orderFormPagination top="false" supportShowPaged="${isShowPageAllowed}"
                                             supportShowAll="false"
                                             searchPageData="${searchPageData}"
                                             searchUrl="${paginateUrl}"
                                             numberPagesShown="${numberPagesShown}"
                                             additionalParams="${additionalParams}"/>
                </c:if>

                <script id="product-id-tag-box-template" type="text/x-jquery-tmpl">
                    <span class="product-id-tag-box js-remove-product-id" id="product-id-{{= productId }}">
                      <span class="product-id">{{= productId }}</span>
                      <span class="glyphicon glyphicon-remove">
                    </span>
                </script>

                <product:productOrderFormJQueryTemplates/>

                <cms:pageSlot position="BottomContent" var="comp" element="div"
                              class="span-20 cms_disp-img_slot right last">
                    <cms:component component="${comp}"/>
                </cms:pageSlot>
            </div>
        </div>

        <input id="searchByKeywordLabel" type="hidden" value='<spring:theme code="search.advanced.keyword"/>'/>
        <input id="searchByIdsLabel" type="hidden" value='<spring:theme code="search.advanced.productids"/>'/>
        <c:remove var="skuIndex" scope="session"/>
    </jsp:body>
</template:page>