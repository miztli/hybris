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
import de.hybris.platform.b2bcommercefacades.company.data.B2BSelectionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceorgaddon.controllers.ControllerConstants;
import de.hybris.platform.commerceorgaddon.forms.B2BCustomerForm;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.user.UserModel;

import java.util.Collections;
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
 * Controller defines routes to manage Business Units within My Company section.
 */
@Controller
@RequestMapping(value = "/my-company/organization-management/manage-units")
public class BusinessUnitUserManagementPageController extends MyCompanyPageController
{
	private static final Logger LOG = Logger.getLogger(BusinessUnitUserManagementPageController.class);

	@Resource(name = "profileValidator")
	private ProfileValidator profileValidator;

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	@RequireHardLogIn
	public String createCustomerOfUnit(@RequestParam("unit") final String unit, @RequestParam("role") final String role,
			final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		final String url = createUser(model);
		final B2BCustomerForm b2bCustomerForm = (B2BCustomerForm) model.asMap().get("b2BCustomerForm");
		b2bCustomerForm.setParentB2BUnit(unit);
		b2bCustomerForm.setRoles(Collections.singleton(role));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(
				String.format("/my-company/organization-management/manage-units/createuser/?unit=%s&role=%s", urlEncode(unit),
						urlEncode(role)),
				getMessageSource().getMessage("text.company.manage.units.createuser.breadcrumb", null,
						getI18nService().getCurrentLocale()),
				null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("action", "manage.units");
		model.addAttribute("saveUrl",
				String.format(
						request.getContextPath() + "/my-company/organization-management/manage-units/createuser?unit=%s&role=%s",
						urlEncode(unit), urlEncode(role)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		return url;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	@RequireHardLogIn
	public String createCustomerOfUnit(@RequestParam("unit") final String unit, @RequestParam("role") final String role,
			@Valid final B2BCustomerForm b2bCustomerForm, final BindingResult bindingResult, final Model model,
			final HttpServletRequest request, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		model.addAttribute("saveUrl",
				String.format(
						request.getContextPath() + "/my-company/organization-management/manage-units/createuser?unit=%s&role=%s",
						urlEncode(unit), urlEncode(role)));
		model.addAttribute("cancelUrl",
				String.format(request.getContextPath() + "/my-company/organization-management/manage-units/details?unit=%s&role=%s",
						urlEncode(unit), urlEncode(role)));
		b2bCustomerForm.setParentB2BUnit(unit);
		b2bCustomerForm.setRoles(Collections.singleton(role));
		profileValidator.validate(b2bCustomerForm, bindingResult);
		final String url = createUser(b2bCustomerForm, bindingResult, model, redirectModel);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(
						String.format("/my-company/organization-management/manage-units/createuser?unit=%s&role=%s", urlEncode(unit),
								urlEncode(role)),
						getMessageSource().getMessage("text.company.manage.units.createuser.breadcrumb", new Object[]
		{ b2bCustomerForm.getUid() }, "Create Customer {0} ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("action", "manage.units");
		if (bindingResult.hasErrors())
		{
			return url;
		}
		else
		{
			if (role.contentEquals(B2BConstants.B2BAPPROVERGROUP))
			{
				b2bApproverFacade.addApproverToUnit(unit, b2bCustomerForm.getEmail());
			}

			return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
		}
	}

	@RequestMapping(value = "/viewuser", method = RequestMethod.GET)
	@RequireHardLogIn
	public String viewCustomerOfUnit(@RequestParam("unit") final String unit, @RequestParam("user") final String user,
			final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{
		final String url = manageUserDetail(user, model);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/viewuser?unit=%s&user=%s",
				urlEncode(unit), urlEncode(user)), getMessageSource().getMessage("text.company.manage.units.viewcustomer.breadcrumb",
				new Object[]
				{ user }, "View Customer {0} ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("saveUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-units/edit?unit=%s&user=%s", urlEncode(unit), urlEncode(user)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute("action", "manage.units");
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return url;
	}


	@RequestMapping(value = "/approvers", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedApproversForUnit(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("unit") final String unit, final Model model, final HttpServletRequest request)
					throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(
				new Breadcrumb(String.format("/my-company/organization-management/manage-units/approvers/?unit=%s", urlEncode(unit)),
						getMessageSource().getMessage("text.company.manage.units.approvers", new Object[]
		{ unit }, "Business Unit {0} Approvers", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		model.addAttribute("unit", unitData);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bApproverFacade.getPagedApproversForUnit(pageableData, unit);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "approvers");
		model.addAttribute("baseUrl", MANAGE_UNITS_BASE_URL);
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitApproverListPage;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedCustomersForUnit(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("unit") final String unit, @RequestParam("role") final String role, final Model model,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/customers?unit=%s&role=%s",
				urlEncode(unit), urlEncode(role)), getMessageSource().getMessage("text.company.manage.units.customers", new Object[]
		{ unit }, "Business Unit {0} Customers", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		model.addAttribute("unit", unitData);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bUnitFacade.getPagedCustomersForUnit(pageableData, unit);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "customers");
		model.addAttribute("baseUrl", MANAGE_UNITS_BASE_URL);
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitUserListPage;
	}

	@RequestMapping(value = "/administrators", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedAdministratorsForUnit(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("unit") final String unit, @RequestParam("role") final String role, final Model model,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(
						String.format("/my-company/organization-management/manage-units/administrators?unit=%s&role=%s",
								urlEncode(unit), urlEncode(role)),
						getMessageSource().getMessage("text.company.manage.units.administrators", new Object[]
		{ unit }, "Business Unit {0} Administrators", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		model.addAttribute("unit", unitData);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bUnitFacade.getPagedAdministratorsForUnit(pageableData, unit);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "administrators");
		model.addAttribute("baseUrl", MANAGE_UNITS_BASE_URL);
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitUserListPage;
	}

	@RequestMapping(value = "/managers", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedManagersForUnit(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("unit") final String unit, @RequestParam("role") final String role, final Model model,
			final HttpServletRequest request) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/managers?unit=%s&role=%s",
				urlEncode(unit), urlEncode(role)), getMessageSource().getMessage("text.company.manage.units.managers", new Object[]
		{ unit }, "Business Unit {0} Managers", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		model.addAttribute("unit", unitData);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bUnitFacade.getPagedManagersForUnit(pageableData, unit);
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "managers");
		model.addAttribute("baseUrl", MANAGE_UNITS_BASE_URL);
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitUserListPage;
	}

	@ResponseBody
	@RequestMapping(value = "/approvers/select", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData selectApprover(@RequestParam("unit") final String unit, @RequestParam("user") final String user)
			throws CMSItemNotFoundException
	{
		return populateDisplayNamesForRoles(b2bApproverFacade.addApproverToUnit(unit, user));
	}

	@ResponseBody
	@RequestMapping(value = "/approvers/deselect", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData deselectApprover(@RequestParam("unit") final String unit, @RequestParam("user") final String user)
			throws CMSItemNotFoundException
	{
		return populateDisplayNamesForRoles(b2bApproverFacade.removeApproverFromUnit(unit, user));
	}

	@RequestMapping(value = "/approvers/remove", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeApproverFromUnit(@RequestParam("unit") final String unit, @RequestParam("user") final String user,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		b2bApproverFacade.removeApproverFromUnit(unit, user);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "success.remove.user.from.unit",
				new Object[]
		{ user, unit });
		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	@RequestMapping(value = "/approvers/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemoveApproverFromUnit(@RequestParam("unit") final String unit, @RequestParam("user") final String user,
			@RequestParam("role") final String role, final Model model, final HttpServletRequest request)
					throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb("#",
				getMessageSource().getMessage(String.format("text.company.units.remove.%s.confirmation", role), new Object[]
		{ user, unit }, "Remove {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		model.addAttribute("arguments", String.format("%s, %s", user, unit));
		model.addAttribute("page", "units");
		model.addAttribute("role", role);
		model.addAttribute("disableUrl",
				String.format(
						request.getContextPath() + "/my-company/organization-management/manage-units/approvers/remove/?unit=%s&user=%s",
						urlEncode(unit), urlEncode(user)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@RequestMapping(value = "/members/remove", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeMemberFromUnit(@RequestParam("unit") final String unit, @RequestParam("user") final String user,
			@RequestParam("role") final String role, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		b2bUserFacade.removeUserRole(user, role);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "success.remove.user.from.unit",
				new Object[]
		{ user, unit });
		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	@RequestMapping(value = "/members/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemoveMemberFromUnit(@RequestParam("unit") final String unit, @RequestParam("user") final String user,
			@RequestParam("role") final String role, final Model model, final HttpServletRequest request)
					throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb("#",
				getMessageSource().getMessage(String.format("text.company.units.remove.%s.confirmation", role), new Object[]
		{ user, unit }, "Remove {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		model.addAttribute("arguments", String.format("%s, %s", user, unit));
		model.addAttribute("page", "units");
		model.addAttribute("role", role);
		model.addAttribute("disableUrl",
				String.format(
						request.getContextPath()
								+ "/my-company/organization-management/manage-units/members/remove/?unit=%s&user=%s&role=%s",
						urlEncode(unit), urlEncode(user), urlEncode(role)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;

	}

	@ResponseBody
	@RequestMapping(value = "/members/select", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData selectCustomer(@RequestParam("user") final String user, @RequestParam("role") final String role)
			throws CMSItemNotFoundException
	{
		return populateDisplayNamesForRoles(b2bUserFacade.addUserRole(user, role));
	}

	@ResponseBody
	@RequestMapping(value = "/members/deselect", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public B2BSelectionData deselectCustomer(@RequestParam("user") final String user, @RequestParam("role") final String role)
			throws CMSItemNotFoundException
	{
		return populateDisplayNamesForRoles(b2bUserFacade.removeUserRole(user, role));
	}

}
