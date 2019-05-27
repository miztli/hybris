<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.company.select.action.label" var="selectAction"/>
<spring:theme code="text.company.deselect.action.label" var="deselectAction"/>

<c:if test="${empty cancelUrl}">
	<c:url value="/my-company/organization-management/manage-usergroups" var="cancelUrl"/>
</c:if>

<c:set var="searchUrl" value="${baseUrl}/${ycommerce:encodeUrl(action)}?usergroup=${ycommerce:encodeUrl(param.usergroup)}&sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}"/>

<jsp:useBean id="additionalParams" class="java.util.HashMap"/>
<c:set target="${additionalParams}" property="user" value="${param.user}" />
<c:set target="${additionalParams}" property="usergroup" value="${param.usergroup}" />

<template:page pageTitle="${pageTitle}">

	<div class="account-section">
		<div class="row">
			<div class="col-xs-12 col-sm-7">
				<org-common:headline url="${cancelUrl}" labelKey="text.company.usergroups.${action}.title"/>
			</div>
			<div class="col-xs-12 col-sm-3 col-sm-push-2">
				<div class="account-header-done-btn">
					<org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
				</div>
			</div>
		</div>
		<div class="account-section-content">
			<nav:pagination top="true" showTopTotals="false" supportShowPaged="${isShowPageAllowed}"
							supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
							hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.${action}.page"
							additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}" showCurrentPageInfo="true"/>

			<c:choose>
				<c:when test="${not empty searchPageData.results}">
					<div class="account-list">
						<div class="account-cards card-select">
							<div class="row">
								<c:forEach items="${searchPageData.results}" var="result">
									<div id="row-${fn:escapeXml(ycommerce:normalizedCode(result.code))}" class="col-xs-12 col-sm-6 col-md-4 card <c:if test='${result.selected}'>selected</c:if>">
										<company:permissionCardDetails permission="${result}" action="${action}" listCSSClass="pull-left"/>
										<ycommerce:testId code="${action}_actions_label">
											<span id="span-${fn:escapeXml(ycommerce:normalizedCode(result.code))}" class="account-cards-actions pull-left">
												<spring:url value="${baseUrl}/{/action}/select/" var="selectUrl" htmlEscape="false">
													<spring:param name="usergroup" value="${param.usergroup}"/>
													<spring:param name="permission" value="${result.code}"/>
													<spring:param name="action" value="${action}" />
												</spring:url>
												<spring:url value="${baseUrl}/{/action}/deselect/" var="deselectUrl" htmlEscape="false">
													<spring:param name="usergroup" value="${param.usergroup}"/>
													<spring:param name="permission" value="${result.code}"/>
													<spring:param name="action" value="${action}" />
												</spring:url>

												<c:choose>
													<c:when test="${result.selected}">
														<a href="#" url="${fn:escapeXml(deselectUrl)}" class="action-links js-deselectLink">
															<span class="glyphicon glyphicon-ok"></span>
														</a>
													</c:when>
													<c:otherwise>
														<a href="#" url="${fn:escapeXml(selectUrl)}" class="action-links js-selectLink">
															<span class="glyphicon glyphicon-ok"></span>
														</a>
													</c:otherwise>
												</c:choose>
											</span>
										</ycommerce:testId>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<p><spring:theme code="text.company.noentries"/></p>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="accountActions-bottom hidden-sm hidden-md hidden-lg">
			<org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
		</div>
		<nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
						hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.${action}.page"
						additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>

    </div>


	<c:url value="${baseUrl}/${ycommerce:encodeUrl(action)}" var="actionLink" />
	<script id="enableDisableLinksTemplate" type="text/x-jquery-tmpl">
		{{if selected}}
			<a href="#" url="${fn:escapeXml(actionLink)}/deselect/?permission={{= encodeURIComponent(id)}}&amp;usergroup=${fn:escapeXml(ycommerce:encodeUrl(param.usergroup))}" class="action-links js-deselectLink"><span class="glyphicon glyphicon-ok"></span></a>
		{{else}}
			<a href="#" url="${fn:escapeXml(actionLink)}/select/?permission={{= encodeURIComponent(id)}}&amp;usergroup=${fn:escapeXml(ycommerce:encodeUrl(param.usergroup))}" class="action-links js-selectLink"><span class="glyphicon glyphicon-ok"></span></a>
		{{/if}}
	</script>

</template:page>