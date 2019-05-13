/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.commerceorgaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.ProfileValidator;
import de.hybris.platform.b2b.constants.B2BConstants;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BSelectionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUserGroupData;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceorgaddon.controllers.ControllerConstants;
import de.hybris.platform.commerceorgaddon.forms.B2BCustomerForm;
import de.hybris.platform.commerceorgaddon.forms.B2BPermissionForm;
import de.hybris.platform.commerceorgaddon.forms.CustomerResetPasswordForm;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller defines routes to manage Users within My Company section.
 */
@Controller
@RequestMapping("/my-company/organization-management/manage-users")
public class UserManagementPageController extends MyCompanyPageController
{
	private static final Logger LOG = Logger.getLogger(UserManagementPageController.class);

	@Resource(name = "profileValidator")
	private ProfileValidator profileValidator;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String manageUsers(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = B2BCustomerModel.NAME) final String sortCode, final Model model)
			throws CMSItemNotFoundException
	{
		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bUserFacade.getPagedCustomers(pageableData);
		populateModel(model, searchPageData, showMode);

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.getBreadcrumbs(null);
		breadcrumbs.add(new Breadcrumb("/my-company/organization-management/manage-users", getMessageSource().getMessage(
                "text.company.manageUsers", null, getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUsersPage;
	}

	@Override
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	@RequireHardLogIn
	public String manageUserDetail(@RequestParam("user") final String user, final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("action", "manageUsers");
		return super.manageUserDetail(user, model);
	}

	@Override
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editUser(@RequestParam("user") final String user, final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("action", "manageUsers");
		return super.editUser(user, model);
	}

	@RequestMapping(value = "/approvers/remove", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeApproverFromCustomer(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		b2bApproverFacade.removeApproverFromCustomer(user, approver);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.approver.removed");
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@Override
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequireHardLogIn
	public String editUser(@RequestParam("user") final String user, @Valid final B2BCustomerForm b2BCustomerForm,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		profileValidator.validate(b2BCustomerForm, bindingResult);
		return super.editUser(user, b2BCustomerForm, bindingResult, model, redirectModel);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@RequireHardLogIn
	public String createUser(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("action", "manageUsers");
		return super.createUser(model);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@RequireHardLogIn
	public String createUser(@Valid final B2BCustomerForm b2BCustomerForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		profileValidator.validate(b2BCustomerForm, bindingResult);
		model.addAttribute("action", "manageUsers");
		return super.createUser(b2BCustomerForm, bindingResult, model, redirectModel);
	}

	@RequestMapping(value = "/disable", method = RequestMethod.GET)
	@RequireHardLogIn
	public String disableUserConfirmation(@RequestParam("user") final String user, final Model model)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/disable?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manage.units.disable.breadcrumb", new Object[]
		{ user }, "Disable {0} Customer", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		final CustomerData customerData = b2bUserFacade.getCustomerForUid(user);
		model.addAttribute("customerData", customerData);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserDisbaleConfirmPage;
	}

	@RequestMapping(value = "/disable", method = RequestMethod.POST)
	@RequireHardLogIn
	public String disableUser(@RequestParam("user") final String user, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/disable?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageusers.disable.breadcrumb", new Object[]
		{ user }, "Disable {0}  Customer ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		b2bUserFacade.disableCustomer(user);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.user.disable");

		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/enable", method = RequestMethod.POST)
	@RequireHardLogIn
	public String enableUser(@RequestParam("user") final String user, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		b2bUserFacade.enableCustomer(user);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.user.enable");
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	@RequireHardLogIn
	public String updatePassword(@RequestParam("user") final String user, final Model model) throws CMSItemNotFoundException
	{
		if (!model.containsAttribute("customerResetPasswordForm"))
		{
			final CustomerResetPasswordForm customerResetPasswordForm = new CustomerResetPasswordForm();
			customerResetPasswordForm.setUid(user);
			model.addAttribute("customerResetPasswordForm", customerResetPasswordForm);
		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/restpassword?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageusers.restpassword.breadcrumb", new Object[]
		{ user }, "Reset Password {0}  User ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserResetPasswordPage;
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updatePassword(@RequestParam("user") final String user,
			@Valid final CustomerResetPasswordForm customerResetPasswordForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute(customerResetPasswordForm);
			GlobalMessages.addErrorMessage(model, "form.global.error");
			return updatePassword(customerResetPasswordForm.getUid(), model);
		}

		if (customerResetPasswordForm.getNewPassword().equals(customerResetPasswordForm.getCheckNewPassword()))
		{

			b2bUserFacade.resetCustomerPassword(customerResetPasswordForm.getUid(), customerResetPasswordForm.getNewPassword());
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.password.updated");
		}
		else
		{
			model.addAttribute(customerResetPasswordForm);
			bindingResult.rejectValue("checkNewPassword", "validation.checkPwd.equals", new Object[] {},
					"validation.checkPwd.equals");
			GlobalMessages.addErrorMessage(model, "form.global.error");
			return updatePassword(customerResetPasswordForm.getUid(), model);
		}

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder
				.createManageUnitsDetailsBreadcrumbs(customerResetPasswordForm.getUid());
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/restpassword?user=%s",
				urlEncode(customerResetPasswordForm.getUid())), getMessageSource().getMessage(
				"text.company.manageusers.restpassword.breadcrumb", new Object[]
				{ customerResetPasswordForm.getUid() }, "Reset Password {0}  Customer ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(customerResetPasswordForm.getUid()));
	}

	@RequestMapping(value = "/approvers", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedApproversForCustomer(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("user") final String user, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/approvers?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageUsers.approvers.breadcrumb", new Object[]
		{ user }, "Customer {0} Approvers", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bApproverFacade.getPagedApproversForCustomer(pageableData, user);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "approvers");
		model.addAttribute("baseUrl", "/my-company/organization-management/manage-users");
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserCustomersPage;
	}

	@ResponseBody
	@RequestMapping(value = "/approvers/select", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData selectApproverForCustomer(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver) throws CMSItemNotFoundException
	{
		return populateDisplayNamesForRoles(b2bApproverFacade.addApproverForCustomer(user, approver));
	}

	@ResponseBody
	@RequestMapping(value = "/approvers/deselect", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData deselectApproverForCustomer(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver) throws CMSItemNotFoundException
	{
		return populateDisplayNamesForRoles(b2bApproverFacade.removeApproverFromCustomer(user, approver));
	}

	@RequestMapping(value = "/permissions", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedPermissionsForCustomer(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("user") final String user, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/permissions?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manage.units.permissions.breadcrumb", new Object[]
		{ user }, "Customer {0} Permissions", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<B2BPermissionData> searchPageData = b2bPermissionFacade.getPagedPermissionsForCustomer(pageableData,
				user);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "permissions");
		model.addAttribute("baseUrl", "/my-company/organization-management/manage-users");
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserPermissionsPage;
	}

	@ResponseBody
	@RequestMapping(value = "/permissions/select", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData selectPermissionForCustomer(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission) throws CMSItemNotFoundException
	{
		return b2bPermissionFacade.addPermissionToCustomer(user, permission);
	}

	@ResponseBody
	@RequestMapping(value = "/permissions/deselect", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData deselectPermissionForCustomer(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission) throws CMSItemNotFoundException
	{
		return b2bPermissionFacade.removePermissionFromCustomer(user, permission);
	}

	@RequestMapping(value = "/permissions/remove", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeCustomersPermission(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		b2bPermissionFacade.removePermissionFromCustomer(user, permission);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.permission.removed");
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/permissions/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemovePermissionFromUser(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage("text.company.users.remove.permission.confirmation",
				new Object[]
				{ permission }, "Remove Permission {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("arguments", String.format("%s, %s", permission, user));
		model.addAttribute("page", "users");
		model.addAttribute("role", "permission");
		model.addAttribute("disableUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-users/permissions/remove/?user=%s&permission=%s", urlEncode(user),
				urlEncode(permission)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@RequestMapping(value = "/approvers/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemoveApproverFromUser(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage(
				String.format("text.company.users.remove.%s.confirmation", B2BConstants.B2BAPPROVERGROUP), new Object[]
				{ approver }, "Remove B2B Approver {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("arguments", String.format("%s, %s", approver, user));
		model.addAttribute("page", "users");
		model.addAttribute("role", B2BConstants.B2BAPPROVERGROUP);
		model.addAttribute("disableUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-users/approvers/remove/?user=%s&approver=%s", urlEncode(user),
				urlEncode(approver)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@RequestMapping(value = "/usergroups", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedB2BUserGroupsForCustomer(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("user") final String user, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/usergroups?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageUsers.usergroups.breadcrumb", new Object[]
		{ user }, "Customer {0} User Groups", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<B2BUserGroupData> searchPageData = b2bUserFacade.getPagedB2BUserGroupsForCustomer(pageableData, user);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "usergroups");
		model.addAttribute("baseUrl", "/my-company/organization-management/manage-users");
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserB2BUserGroupsPage;
	}

	@ResponseBody
	@RequestMapping(value = "/usergroups/select", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData selectB2BUserGroupForCustomer(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup) throws CMSItemNotFoundException
	{
		return b2bUserFacade.addB2BUserGroupToCustomer(user, usergroup);
	}

	@ResponseBody
	@RequestMapping(value = "/usergroups/deselect", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData deselectB2BUserGroupForCustomer(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup) throws CMSItemNotFoundException
	{
		return b2bUserFacade.deselectB2BUserGroupFromCustomer(user, usergroup);
	}

	@RequestMapping(value = "/usergroups/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemoveUserGroupFromUser(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage("text.company.users.remove.usergroup.confirmation",
				new Object[]
				{ usergroup }, "Remove User group {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("arguments", String.format("%s, %s", user, usergroup));
		model.addAttribute("page", "users");
		model.addAttribute("role", "usergroup");
		model.addAttribute("disableUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-users/usergroups/remove/?user=%s&usergroup=%s", urlEncode(user),
				urlEncode(usergroup)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@RequestMapping(value = "/usergroups/remove", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeCustomersUserGroup(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		try
		{
			b2bUserFacade.removeB2BUserGroupFromCustomerGroups(user, usergroup);
			GlobalMessages
					.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.usergroup.removed");
		}
		catch (final UnknownIdentifierException e)
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug("can not remove b2b user '" + user + "' from group '" + usergroup + "' due to, " + e.getMessage(), e);
			}
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "usergroup.notfound");
		}
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/edit-permission", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editUsersPermission(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(
				"saveUrl",
				String.format("%s/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s",
						request.getContextPath(), urlEncode(user), urlEncode(permission)));

		final String editPermissionUrl = editPermission(permission, model);

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb(String.format(
				"/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s", urlEncode(user),
				urlEncode(permission)), getMessageSource().getMessage("text.company.manageusers.permission.edit", new Object[]
		{ permission }, "Edit Permission {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		return editPermissionUrl;
	}

	@RequestMapping(value = "/edit-permission", method = RequestMethod.POST)
	@RequireHardLogIn
	public String editUsersPermission(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, @Valid final B2BPermissionForm b2BPermissionForm,
			final BindingResult bindingResult, final Model model, final HttpServletRequest request,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException, ParseException
	{
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(
				"saveUrl",
				String.format("%s/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s",
						request.getContextPath(), urlEncode(user), urlEncode(permission)));

		final String editPermissionUrl = editPermission(b2BPermissionForm, bindingResult, model, redirectModel);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb(String.format(
				"/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s", urlEncode(user),
				urlEncode(permission)), getMessageSource().getMessage("text.company.manageusers.permission.edit", new Object[]
		{ permission }, "Edit Permission {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		if (bindingResult.hasErrors())
		{
			return editPermissionUrl;
		}
		else
		{
			return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
		}
	}
}
