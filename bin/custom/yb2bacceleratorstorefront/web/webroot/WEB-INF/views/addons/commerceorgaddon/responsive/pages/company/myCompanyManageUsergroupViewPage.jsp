<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="company" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/company"%>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-usergroups/" var="backToUserGroupsUrl" htmlEscape="false"/>
<spring:url value="/my-company/organization-management/manage-usergroups/permissions/" var="permissionsUrl" htmlEscape="false">
	<spring:param name="usergroup" value="${usergroup.uid}"/>
</spring:url>
<spring:url value="/my-company/organization-management/manage-usergroups/members/" var="membersUrl" htmlEscape="false">
	<spring:param name="usergroup" value="${usergroup.uid}"/>
</spring:url>

<c:if test="${empty editUrl}">
	<spring:url value="/my-company/organization-management/manage-usergroups/edit/" var="editUrl" htmlEscape="false">
		<spring:param name="usergroup" value="${usergroup.uid}"/>
	</spring:url>
</c:if>
<c:if test="${empty disableUrl}">
	<spring:url value="/my-company/organization-management/manage-usergroups/disable/" var="disableUrl" htmlEscape="false">
		<spring:param name="usergroup" value="${usergroup.uid}"/>
	</spring:url>
</c:if>
<c:if test="${empty removeUrl}">
	<spring:url value="/my-company/organization-management/manage-usergroups/remove/" var="deleteUrl" htmlEscape="false">
		<spring:param name="usergroup" value="${usergroup.uid}"/>
	</spring:url>
</c:if>

<c:set var="usersSelected" value="${(fn:length(usergroup.members) > 0) ? true : false}"/>

<template:page pageTitle="${pageTitle}">
	<div class="account-section">
		<div>
			<org-common:headline url="${backToUserGroupsUrl}" labelKey="text.company.manageUsergroups.detailsUserGroup.title"/>
		</div>
		<div class="account-section-content">
			<div class="well well-lg well-tertiary">
				<div class="row">
					<div class="col-sm-10 col-no-padding">
						<div class="row">
							<div class="col-sm-4">
								<div class="item-group">
									<span class="item-label">
										<spring:theme code="text.company.usergroup.id.title"/>
									</span>
									<span class="item-value">
											${fn:escapeXml(usergroup.uid)}
									</span>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="item-group">
									<span class="item-label">
										<spring:theme code="text.company.usergroup.name.title"/>
									</span>
									<span class="item-value">
											${fn:escapeXml(usergroup.name)}
									</span>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="item-group">
									<span class="item-label">
										<spring:theme code="text.company.usergroup.unit.title"/>
									</span>
									<span class="item-value">
											${fn:escapeXml(usergroup.unit.name)}
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="item-action">
							<a href="${fn:escapeXml(editUrl)}" class="button edit btn btn-block btn-primary">
								<spring:theme code="text.company.usergroup.edit.button"/>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="accountActions-link">
				<c:if test="${usersSelected}">
					<span class="js-action-confirmation-modal disable-link">
						<ycommerce:testId code="Usergroup_Disable_button">
							<a href="#" data-action-confirmation-modal-title="<spring:theme code="text.company.usergroup.disable.label"/>"
							   data-action-confirmation-modal-id="disable" class="">
								<spring:theme code="text.company.usergroup.disable.label"/>
							</a>
						</ycommerce:testId>
					</span>
				</c:if>
				<span class="js-action-confirmation-modal remove disable-link">
					<ycommerce:testId code="Usergroup_Remove_button">
						<a href="#" data-action-confirmation-modal-title="<spring:theme code="text.company.usergroup.delete.label"/>"
						   data-action-confirmation-modal-id="delete">
							<spring:theme code="text.company.usergroup.delete.label"/>
						</a>
					</ycommerce:testId>
				</span>
			</div>

			<company:actionConfirmationModal id="delete" targetUrl="${deleteUrl}"
				 messageKey="text.company.usergroup.delete.warning.message"
				 actionButtonLabelKey="text.company.delete.button"
				 actionButtonCSSClass="red"/>
			<company:actionConfirmationModal id="disable" targetUrl="${disableUrl}"
				 messageKey="text.company.usergroup.disable.warning.message"
				 messageArguments="${usergroup.uid}"/>

			<div class="account-list">
				<org-common:selectEntityHeadline url="${permissionsUrl}" labelKey="text.company.manageUser.permission.title"/>
				<c:if test="${not empty usergroup.permissions}">
					<div class="account-cards">
						<div class="row">
							<c:forEach items="${usergroup.permissions}" var="permission">
								<div class="col-xs-12 col-sm-6 col-md-4 card">
									<company:permissionCardDetails permission="${permission}" action="permission"/>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>

				<org-common:selectEntityHeadline url="${membersUrl}" labelKey="text.company.usergroup.members"/>
				<c:if test="${not empty usergroup.members}">
					<div class="account-cards">
						<div class="row">
							<c:forEach items="${usergroup.members}" var="user">
								<spring:url value="/my-company/organization-management/manage-users/details/"
											var="userDetailUrl" htmlEscape="false">
									<spring:param name="user" value="${user.uid}"/>
								</spring:url>

								<div class="col-xs-12 col-sm-6 col-md-4 card">
									<ul>
										<li>
											<ycommerce:testId code="member_name_link">
												<a href="${fn:escapeXml(userDetailUrl)}">${fn:escapeXml(user.name)}</a>
											</ycommerce:testId>
										</li>
										<li>
											<ycommerce:testId code="member_email_label">
												${fn:escapeXml(user.uid)}
											</ycommerce:testId>
										</li>
									</ul>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-5 col-md-4">
					<div class="accountActions-bottom">
						<org-common:back cancelUrl="${backToUserGroupsUrl}" displayTextMsgKey="text.company.usergroup.back.button"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</template:page>