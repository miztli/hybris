<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="node" required="true" type="de.hybris.platform.b2bcommercefacades.company.data.B2BUnitNodeData" %>
<%@ attribute name="loopIndex" required="false" type="java.lang.Integer"%>
			  
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-units/details" var="unitDetailUrl" htmlEscape="false">
	<spring:param name="unit" value="${node.id}"/>
</spring:url>

<c:set var="collapsed" value="collapsed"/>
<c:set var="collapseIn" value=""/>


<div class="panel panel-default">
	<div class="panel-heading">
		<c:if test="${empty loopIndex}">
			<c:set var="collapsed" value=""/>
			<c:set var="collapseIn" value="in"/>
		</c:if>
		<c:choose>
			<c:when test="${fn:length(node.children) > 0}">
				<span data-toggle="collapse" data-parent="#accordion${loopIndex}" href="#collapse${loopIndex}" class="accordion-toggle ${collapsed}"></span>
			</c:when>
			<c:otherwise>
				<c:set var="noSubs" value="no-subs"/>
			</c:otherwise>
		</c:choose>
		<a href="${fn:escapeXml(unitDetailUrl)}"  class="accordion-lnk ${fn:escapeXml(noSubs)} ${node.active? '' : ' disabled'}">
			${fn:escapeXml(node.name)}<c:if test="${!node.active}"> (<spring:theme code="text.company.manage.units.disabled.label"/>)</c:if>
		</a>
	</div>
	<c:if test="${fn:length(node.children) > 0}">
		<div id="collapse${loopIndex}" class="panel-collapse collapse ${collapseIn}">
			<div class="panel-body">
				<c:forEach var="node" items="${node.children}" varStatus="loop">
					<div id="accordion${loopIndex}${loop.index}" class="panel-group accordion">
						<company:unitTree node="${node}" loopIndex="${loopIndex}${loop.index}"/>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:if>
</div>