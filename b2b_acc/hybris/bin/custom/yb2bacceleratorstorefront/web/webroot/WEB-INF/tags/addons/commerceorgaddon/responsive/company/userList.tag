<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="users" required="true" type="java.util.List" %>
<%@ attribute name="action" required="true" type="java.lang.String" %>
<%@ attribute name="createUrl" required="true" type="java.lang.String" %>
<%@ attribute name="editUrl" required="true" type="java.lang.String" %>
<%@ attribute name="role" required="true" type="java.lang.String" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="account-list-header">
	<spring:theme code="text.company.manage.units.header.${action}"/> (<span class="counter">${fn:length(users)}</span>)

    <div class="account-list-header-add pull-right">
        <div class="hidden-xs">
            <a href="${fn:escapeXml(editUrl)}" class="button edit">
                <spring:theme code="text.company.addExisting.button"/>
            </a>
            |
            <a href="${fn:escapeXml(createUrl)}&amp;role=${fn:escapeXml(ycommerce:encodeUrl(role))}" class="button create">
                <spring:theme code="text.company.manage.units.users.button.createnew"/>
            </a>
        </div>

        <div class="visible-xs">
            <div class="add-user-action-menu">
                <a href="#" class="add-user-action js-add-user-action">Add</a>
                <ul class="add-user-action-buttons js-add-user-action-buttons">
                    <li><a href="${fn:escapeXml(createUrl)}&amp;role=${fn:escapeXml(ycommerce:encodeUrl(role))}">
                        <button class="btn btn-primary btn-block">New</button>
                    </a></li>
                    <li><a href="${fn:escapeXml(editUrl)}">
                        <button class="btn btn-primary btn-block">Existing</button>
                    </a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="account-cards">
    <div class="row">
        <c:forEach items="${users}" var="user" varStatus="rows">
            <div class="col-xs-12 col-sm-6 col-md-4 card">
                <spring:url value="/my-company/organization-management/manage-units/viewuser/" var="viewUserUrl" htmlEscape="false">
                    <spring:param name="unit" value="${unit.uid}"/>
                    <spring:param name="user" value="${user.uid}"/>
                </spring:url>
                <spring:url value="/my-company/organization-management/manage-units/members/deselect" var="removeUserUrl" htmlEscape="false">
                    <spring:param name="user" value="${user.uid}"/>
                    <spring:param name="role" value="${role}"/>
                </spring:url>
                <ul id="id-${rows.index}" class="pull-left">
                    <li>
                        <a href="${fn:escapeXml(viewUserUrl)}">
                                ${fn:escapeXml(user.firstName)}&nbsp;${fn:escapeXml(user.lastName)}
                        </a>
                    </li>
                    <li>${fn:escapeXml(user.uid)}</li>
                </ul>
                <div class="account-cards-actions pull-left">
                    <a href="#" url="${fn:escapeXml(removeUserUrl)}" class="js-remove-user-from-unit remove-item" data-rowid="${rows.index}" title="<spring:theme code='text.company.manage.unit.user.remove'/>">
                        <span class="glyphicon glyphicon-remove"></span>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>