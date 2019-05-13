<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="searchUrl" required="true" %>
<%@ attribute name="searchPageData" required="true" type="de.hybris.platform.commerceservices.search.pagedata.SearchPageData" %>
<%@ attribute name="top" required="true" type="java.lang.Boolean" %>
<%@ attribute name="supportShowAll" required="true" type="java.lang.Boolean" %>
<%@ attribute name="supportShowPaged" required="true" type="java.lang.Boolean" %>
<%@ attribute name="msgKey" required="false" %>
<%@ attribute name="numberPagesShown" required="false" type="java.lang.Integer" %>
<%@ attribute name="additionalParams" required="false" type="java.util.HashMap" %>
<%@ taglib prefix="pagination" tagdir="/WEB-INF/tags/responsive/nav/pagination" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="themeMsgKey" value="${not empty msgKey ? msgKey : 'search.page'}"/>
<c:if test="${searchPageData.pagination.totalNumberOfResults == 0 && top }">
	<div class="pagination-bar pagination-empty">
		<ycommerce:testId code="searchResults_productsFound_label">
			<div class="total-results"><spring:theme code="${themeMsgKey}.totalResults" arguments="${searchPageData.pagination.totalNumberOfResults}"/></div>
		</ycommerce:testId>
	</div>
</c:if>

<c:set var="paginationNoSorting" value=""/>
<c:if test="${empty searchPageData.sorts}">
    <c:set var="paginationNoSorting" value="pagination-no-sorting"/>
</c:if>

<c:set var="paginationPager" value=""/>
<c:if test="${searchPageData.pagination.numberOfPages > 1}">
    <c:set var="paginationPager" value="pagination-with-pager"/>
</c:if>

<c:if test="${searchPageData.pagination.totalNumberOfResults > 0}">
<c:set var="queryValueHtml" value="${searchPageData.currentQuery.query.value}"/>
<div class="pagination-bar ${(top)?"top":"bottom"} clearfix ${paginationNoSorting} ${paginationPager}">
    <div class="pagination-toolbar clearfix">
        <c:if test="${not empty searchPageData.sorts}">
            <div class="helper clearfix hidden-md hidden-lg"></div>
            <div class="sort-refine-bar">
                <div class="form-group">
                    <label class="control-label " for="sortForm${top ? '1' : '2'}">
                        <spring:theme code="${themeMsgKey}.sortTitle"/>
                    </label>
                    <form id="sortForm${top ? '1' : '2'}" name="sortForm${top ? '1' : '2'}" method="get"
                          action="#">
                        <select id="sortOptions${top ? '1' : '2'}" name="sort" class="form-control">
                            <option disabled><spring:theme code="${themeMsgKey}.sortTitle"/></option>
                            <c:forEach items="${searchPageData.sorts}" var="sort">
                                <option value="${fn:escapeXml(sort.code)}" ${sort.selected? 'selected="selected"' : ''}>
                                    <c:choose>
                                        <c:when test="${not empty sort.name}">
                                            ${fn:escapeXml(sort.name)}
                                        </c:when>
                                        <c:otherwise>
                                            <spring:theme code="${themeMsgKey}.sort.${sort.code}"/>
                                        </c:otherwise>
                                    </c:choose>
                                </option>
                            </c:forEach>
                        </select>
                        <c:if test="${not empty searchResultType}">
                            <input type="hidden" name="searchResultType" value="${fn:escapeXml(searchResultType)}"/>
                        </c:if>
                        <c:catch var="errorException">
                            <spring:eval expression="searchPageData.currentQuery.query" var="dummyVar"/><%-- This will throw an exception is it is not supported --%>
							<input type="hidden" name="q" value="${queryValueHtml}"/>
                        </c:catch>

                        <c:if test="${supportShowAll}">
                            <ycommerce:testId code="searchResults_showAll_link">
                                <input type="hidden" name="show" value="Page"/>
                            </ycommerce:testId>
                        </c:if>
                        <c:if test="${supportShowPaged}">
                            <ycommerce:testId code="searchResults_showPage_link">
                                <input type="hidden" name="show" value="All"/>
                            </ycommerce:testId>
                        </c:if>
                        <c:if test="${not empty additionalParams}">
                            <c:forEach items="${additionalParams}" var="entry">
                                <input type="hidden" name="${fn:escapeXml(entry.key)}" value="${fn:escapeXml(entry.value)}"/>
                            </c:forEach>
                        </c:if>
                    </form>
                </div>
            </div>
        </c:if>

        <ycommerce:testId code="searchResults_productsFound_label">
            <div class="total-results"><spring:theme code="${themeMsgKey}.totalResults" arguments="${searchPageData.pagination.totalNumberOfResults}"/></div>
        </ycommerce:testId>

        <c:if test="${searchPageData.pagination.numberOfPages > 1}">
            <div class="pagination-wrap">
                <pagination:pageSelectionPagination searchUrl="${searchUrl}" searchPageData="${searchPageData}"
                                                    numberPagesShown="${numberPagesShown}"
                                                    themeMsgKey="${themeMsgKey}"/>
            </div>
        </c:if>

        <div class="left">
            <c:if test="${supportShowPaged}">
                <spring:url value="${searchUrl}" var="showPageUrl" htmlEscape="false">
                    <spring:param name="show" value="Page" />
                </spring:url>
                <ycommerce:testId code="searchResults_showPage_link">
                    <a class="showPagination" href="${fn:escapeXml(showPageUrl)}"><spring:theme code="${themeMsgKey}.showPageResults" /></a>
                </ycommerce:testId>
            </c:if>

            <c:if test="${supportShowAll}">
                <spring:url value="${searchUrl}" var="showAllUrl" htmlEscape="false">
                    <spring:param name="show" value="All" />
                </spring:url>
                <ycommerce:testId code="searchResults_showAll_link">
                    <a class="showAll" href="${fn:escapeXml(showAllUrl)}"><spring:theme code="${themeMsgKey}.showAllResults" /></a>
                </ycommerce:testId>
            </c:if>
        </div>

    </div>
	
	<c:catch var="notFacetSearchPageDataInstance">
		<spring:eval expression="searchPageData.currentQuery" var="currentQuery"/>
	</c:catch>
	
	<c:if test="${empty searchPageData.sorts && empty notFacetSearchPageDataInstance && not empty searchPageData.currentQuery }">
		<div id="sort_form1">
			<input type="hidden" name="q" value="${queryValueHtml}"/>
		</div>
	</c:if>
</div>

</c:if>
