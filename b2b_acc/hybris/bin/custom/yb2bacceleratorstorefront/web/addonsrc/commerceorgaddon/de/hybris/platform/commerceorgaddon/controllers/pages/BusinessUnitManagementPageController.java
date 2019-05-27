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
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.util.AddressDataUtil;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitNodeData;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commerceorgaddon.controllers.ControllerConstants;
import de.hybris.platform.commerceorgaddon.forms.B2BCostCenterForm;
import de.hybris.platform.commerceorgaddon.forms.B2BUnitForm;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller defines routes to manage Business Units within My Company section.
 */
@Controller
@RequestMapping("/my-company/organization-management/manage-units")
public class BusinessUnitManagementPageController extends MyCompanyPageController
{
	private static final Logger LOG = Logger.getLogger(BusinessUnitManagementPageController.class);

	@Resource(name = "addressDataUtil")
	private AddressDataUtil addressDataUtil;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String manageUnits(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsBreadcrumbs();
		model.addAttribute("breadcrumbs", breadcrumbs);

		final B2BUnitNodeData rootNode = b2bUnitFacade.getParentUnitNode();
		model.addAttribute("rootNode", rootNode);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitsPage;
	}

	@Override
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	@RequireHardLogIn
	public String unitDetails(@RequestParam("unit") final String unit, final Model model) throws CMSItemNotFoundException
	{
		return super.unitDetails(unit, model);
	}

	@RequestMapping(value = "/addcostcenter", method = RequestMethod.GET)
	@RequireHardLogIn
	public String addCostCenterToUnit(@RequestParam("unit") final String unit, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		if (unitData == null)
		{
			GlobalMessages.addErrorMessage(model, "b2bunit.notfound");
			return addCostCenter(model);
		}
		else if (!model.containsAttribute("b2BCostCenterForm"))
		{
			final B2BCostCenterForm b2BCostCenterForm = new B2BCostCenterForm();
			b2BCostCenterForm.setParentB2BUnit(unitData.getUid());
			model.addAttribute(b2BCostCenterForm);
		}

		final String addCostCenterUrl = addCostCenter(model);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(
				String.format("/my-company/organization-management/manage-units/addcostcenter?unit=%s", urlEncode(unit)),
				getMessageSource().getMessage("text.company.manage.units.addCostCenter.breadcrumb", new Object[]
		{ unit }, "Create Cost Center for Unit: {0} ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("title", getMessageSource().getMessage("text.company.manage.units.create.costCenter.title", new Object[]
		{ unitData.getName() }, "Create Cost Center for Unit: {0}", getI18nService().getCurrentLocale()));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute("saveUrl", String.format("%s/my-company/organization-management/manage-units/addcostcenter?unit=%s",
				request.getContextPath(), urlEncode(unit)));
		return addCostCenterUrl;
	}

	@RequestMapping(value = "/addcostcenter", method = RequestMethod.POST)
	@RequireHardLogIn
	public String addCostCenterToUnit(@RequestParam("unit") final String unit, @Valid final B2BCostCenterForm b2BCostCenterForm,
			final BindingResult bindingResult, final Model model, final HttpServletRequest request,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		final String url = saveCostCenter(b2BCostCenterForm, bindingResult, model, redirectModel);

		if (unitData == null)
		{
			GlobalMessages.addErrorMessage(model, "b2bunit.notfound");
			return url;
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/addcostcenter?unit=%s", unit),
						getMessageSource().getMessage("text.company.manage.units.addCostCenter.breadcrumb", new Object[]
		{ unit }, "Add Cost Center to {0} Business Unit ", getI18nService().getCurrentLocale()), null));

		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("title", getMessageSource().getMessage("text.company.manage.units.create.costCenter.title", new Object[]
		{ unitData.getName() }, "Create Cost Center for Unit: {0}", getI18nService().getCurrentLocale()));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute("saveUrl", String.format("%s/my-company/organization-management/manage-units/addcostcenter?unit=%s",
				request.getContextPath(), urlEncode(unit)));
		if (bindingResult.hasErrors())
		{
			return url;
		}
		else
		{
			return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
		}
	}

	@RequestMapping(value = "/editcostcenter", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editCostCenterToUnit(@RequestParam("unit") final String unit,
			@RequestParam("costCenterCode") final String costCenterCode, final Model model, final HttpServletRequest request)
					throws CMSItemNotFoundException
	{
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		if (unitData == null)
		{
			GlobalMessages.addErrorMessage(model, "b2bunit.notfound");
		}

		final String url = editCostCenterDetails(costCenterCode, model);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(
				String.format("/my-company/organization-management/manage-units/details/editcostcenter/?unit=%s&costCenterCode=%s",
						urlEncode(unit), urlEncode(costCenterCode)),
				getMessageSource().getMessage("text.company.manage.units.editCostCenter.breadcrumb", new Object[]
		{ unit }, "Edit Cost Center for Unit: {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute("saveUrl",
				String.format("%s/my-company/organization-management/manage-units/editcostcenter/?unit=%s&costCenterCode=%s",
						request.getContextPath(), urlEncode(unit), urlEncode(costCenterCode)));
		return url;
	}

	@RequestMapping(value = "/editcostcenter", method = RequestMethod.POST)
	@RequireHardLogIn
	public String editCostCenterToUnit(@RequestParam("unit") final String unit,
			@RequestParam("costCenterCode") final String costCenterCode, @Valid final B2BCostCenterForm b2BCostCenterForm,
			final BindingResult bindingResult, final Model model, final HttpServletRequest request,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		if (unitData == null)
		{
			GlobalMessages.addErrorMessage(model, "b2bunit.notfound");
		}

		final String url = updateCostCenterDetails(b2BCostCenterForm, bindingResult, model, redirectModel);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(
				String.format("/my-company/organization-management/manage-units/?unit=%s&costCenterCode=%s", urlEncode(unit),
						urlEncode(costCenterCode)),
				getMessageSource().getMessage("text.company.manage.units.editCostCenter.breadcrumb", new Object[]
		{ unit }, "Edit Cost Center for Unit: {0}", getI18nService().getCurrentLocale()), null));

		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		model.addAttribute("saveUrl",
				String.format("%s/my-company/organization-management/manage-units/details/editcostcenter/?unit=%s&costCenterCode=%s",
						request.getContextPath(), urlEncode(unit), urlEncode(costCenterCode)));
		if (bindingResult.hasErrors())
		{
			return url;
		}
		else
		{
			return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
		}
	}

	@RequestMapping(value = "/disable", method = RequestMethod.GET)
	@RequireHardLogIn
	public String disableUnitConfirmation(@RequestParam("unit") final String unit, final Model model)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(
				new Breadcrumb(String.format("/my-company/organization-management/manage-units/disable?unit=%s", urlEncode(unit)),
						getMessageSource().getMessage("text.company.manage.units.disable.breadcrumb", new Object[]
		{ unit }, "Disable {0} Business Unit ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		model.addAttribute("unit", unitData);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitDisablePage;
	}

	@RequestMapping(value = "/disable", method = RequestMethod.POST)
	@RequireHardLogIn
	public String disableUnit(@RequestParam("unit") final String unit, final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(
				new Breadcrumb(String.format("/my-company/organization-management/manage-units/disable?unit=%s", urlEncode(unit)),
						getMessageSource().getMessage("text.company.manage.units.disable.breadcrumb", new Object[]
		{ unit }, "Disable {0} Business Unit ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		b2bUnitFacade.disableUnit(unit);

		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	@RequestMapping(value = "/enable", method = RequestMethod.GET)
	@RequireHardLogIn
	public String enableUnit(@RequestParam("unit") final String unit, final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/enable?unit=%s", urlEncode(unit)),
						getMessageSource().getMessage("text.company.manage.units.enable.breadcrumb", new Object[]
		{ unit }, "Enable {0} Business Unit ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		b2bUnitFacade.enableUnit(unit);
		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editUnit(@RequestParam("unit") final String unit, final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/edit?unit=%s", urlEncode(unit)),
						getMessageSource().getMessage("text.company.manage.units.editUnit.breadcrumb", new Object[]
		{ unit }, "Edit Unit: {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		if (!model.containsAttribute("b2BUnitForm"))
		{
			final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);

			final B2BUnitForm b2BUnitForm = new B2BUnitForm();
			b2BUnitForm.setOriginalUid(unitData.getUid());
			if (unitData.getUnit() != null)
			{
				b2BUnitForm.setParentUnit(unitData.getUnit().getUid());
			}
			b2BUnitForm.setApprovalProcessCode(unitData.getApprovalProcessCode());
			b2BUnitForm.setUid(unitData.getUid());
			b2BUnitForm.setName(unitData.getName());
			model.addAttribute(b2BUnitForm);
		}
		model.addAttribute("branchSelectOptions", getBranchSelectOptions(b2bUnitFacade.getAllowedParentUnits(unit)));
		model.addAttribute("action", "edit");
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("businessProcesses", getBusinessProcesses());
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitEditPage;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequireHardLogIn
	public String editUnit(@RequestParam("unit") final String unit, @Valid final B2BUnitForm unitForm,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectModel)
					throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(String.format("/my-company/organization-management/manage-units/edit?unit=%s", urlEncode(unit)),
						getMessageSource().getMessage("text.company.manage.units.editUnit.breadcrumb", new Object[]
		{ unit }, "Edit {0} Business Unit ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, "form.global.error");
			model.addAttribute(unitForm);
			return editUnit(unit, model);

		}
		if (!unitForm.getUid().equals(unit) && b2bUnitFacade.getUnitForUid(unitForm.getUid()) != null)
		{
			// a unit uid is not unique
			GlobalMessages.addErrorMessage(model, "form.global.error");
			bindingResult.rejectValue("uid", "form.b2bunit.notunique");
			model.addAttribute(unitForm);
			return editUnit(unit, model);
		}

		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);

		if (unitData.getUnit() == null && StringUtils.isBlank(unitForm.getApprovalProcessCode()))
		{
			// approval process is required for root unit
			GlobalMessages.addErrorMessage(model, "form.global.error");
			bindingResult.rejectValue("approvalProcessCode", "form.b2bunit.approvalProcessCode.required");
			model.addAttribute(unitForm);
			return editUnit(unit, model);
		}

		unitData.setUid(unitForm.getUid());
		unitData.setName(unitForm.getName());
		unitData.setApprovalProcessCode(unitForm.getApprovalProcessCode());
		if (StringUtils.isNotBlank(unitForm.getParentUnit()))
		{
			unitData.setUnit(b2bUnitFacade.getUnitForUid(unitForm.getParentUnit()));
		}

		try
		{
			b2bUnitFacade.updateOrCreateBusinessUnit(unit, unitData);
		}
		catch (final ModelSavingException e)
		{
			LOG.error(String.format("Failed to save unit. Possibly non-unique id (original id: [%s] new id: [%s]).",
					unit, unitData.getUid()), e);
			GlobalMessages.addErrorMessage(model, "form.global.error");
			bindingResult.rejectValue("uid", "form.b2bunit.notunique");
			return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitEditPage;
		}
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "form.b2bunit.success");

		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unitForm.getUid()));
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@RequireHardLogIn
	public String createUnit(@RequestParam("unit") final String unit, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs;
		final B2BUnitData unitData;
		String parentUnit = "";
		if (StringUtils.isNotBlank(unit))
		{
			unitData = b2bUnitFacade.getUnitForUid(unit);
			breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
			model.addAttribute("cancelUrl", getCancelUrl(MANAGE_UNIT_DETAILS_URL, request.getContextPath(), unit));
		}
		else
		{
			breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsBreadcrumbs();
			unitData = b2bUnitFacade.getParentUnit();
			parentUnit = unitData == null ? "" : unitData.getName();
		}
		breadcrumbs.add(new Breadcrumb("/my-company/organization-management/manage-units/create?unit=",
				getMessageSource().getMessage("text.company.manage.units.createUnit.breadcrumb", new Object[]
		{ StringUtils.isEmpty(parentUnit) ? unit : parentUnit }, "Create Child Unit for Unit: {0}",
						getI18nService().getCurrentLocale()),
				null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("unitName", (unitData == null ? "" : unitData.getName()));

		if (!model.containsAttribute("b2BUnitForm"))
		{
			final B2BUnitForm b2BUnitForm = new B2BUnitForm();
			b2BUnitForm.setParentUnit((unitData == null ? "" : unitData.getUid()));
			model.addAttribute(b2BUnitForm);
		}
		model.addAttribute("branchSelectOptions", getBranchSelectOptions(b2bUnitFacade.getBranchNodes()));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		model.addAttribute("businessProcesses", getBusinessProcesses());
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitCreatePage;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@RequireHardLogIn
	public String createUnit(@Valid final B2BUnitForm unitForm, final BindingResult bindingResult, final Model model,
			final HttpServletRequest request, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unitForm.getUid());
		breadcrumbs.add(new Breadcrumb("/my-company/organization-management/manage-units/create?unit=",
				getMessageSource().getMessage("text.company.manage.units.createUnit.breadcrumb", new Object[]
		{ unitForm.getUid() }, "Create Child Unit for Unit: {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, "form.global.error");
			model.addAttribute(unitForm);
			return createUnit(unitForm.getParentUnit(), model, request);
		}
		if (b2bUnitFacade.getUnitForUid(unitForm.getUid()) != null)
		{
			// a unit uid is not unique
			GlobalMessages.addErrorMessage(model, "form.global.error");
			bindingResult.rejectValue("uid", "form.b2bunit.notunique");
			model.addAttribute(unitForm);
			return createUnit(unitForm.getUid(), model, request);
		}

		final B2BUnitData unitData = new B2BUnitData();
		unitData.setUid(unitForm.getUid());
		unitData.setName(unitForm.getName());
		unitData.setApprovalProcessCode(unitForm.getApprovalProcessCode());
		if (StringUtils.isNotBlank(unitForm.getParentUnit()))
		{
			unitData.setUnit(b2bUnitFacade.getUnitForUid(unitForm.getParentUnit()));
		}

		try
		{
			b2bUnitFacade.updateOrCreateBusinessUnit(unitData.getUid(), unitData);
		}
		catch (final ModelSavingException e)
		{
			LOG.error("Failed to create unit. Possibly non-unique id. Id: " + unitData.getUid(), e);
			GlobalMessages.addErrorMessage(model, "form.global.error");
			bindingResult.rejectValue("uid", "form.b2bunit.notunique");
			return createUnit(unitForm.getUid(), model, request);
		}

		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "form.b2bunit.success");
		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unitForm.getUid()));
	}

	@RequestMapping(value = "/costcenter", method = RequestMethod.GET)
	@RequireHardLogIn
	public String viewCostCenterForUnit(@RequestParam("unit") final String unit,
			@RequestParam("costCenterCode") final String costCenterCode, final Model model, final HttpServletRequest request)
					throws CMSItemNotFoundException
	{
		final String url = viewCostCenterDetails(costCenterCode, model);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(
				String.format("/my-company/organization-management/manage-units/costcenter/?unit=%s&costCenterCode=%s",
						urlEncode(unit), urlEncode(costCenterCode)),
				getMessageSource().getMessage("text.company.manage.units.viewcostcenter.breadcrumb", new Object[]
		{ costCenterCode }, "View Cost Center {0} ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("editUrl",
				String.format(
						request.getContextPath()
								+ "/my-company/organization-management/manage-units/editcostcenter/?unit=%s&costCenterCode=%s",
						urlEncode(unit), urlEncode(costCenterCode)));
		return url;
	}


	@RequestMapping(value = "/add-address", method = RequestMethod.GET)
	@RequireHardLogIn
	public String addAddress(@RequestParam("unit") final String unit, final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("countryData", checkoutFacade.getDeliveryCountries());
		model.addAttribute("titleData", getUserFacade().getTitles());
		model.addAttribute("addressForm", new AddressForm());

		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs.add(new Breadcrumb(
				String.format("/my-company/organization-management/manage-units/add-address/?unit=%s", urlEncode(unit)),
				getMessageSource().getMessage("text.company.manage.units.addAddress", new Object[]
		{ unit }, "Add Address for {0} Business Unit ", getI18nService().getCurrentLocale()), null));
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		if (unitData != null)
		{
			model.addAttribute("unitName", unitData.getName());
		}
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("uid", unit);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitAddAddressPage;
	}

	@RequestMapping(value = "/add-address", method = RequestMethod.POST)
	@RequireHardLogIn
	public String addAddress(@RequestParam("unit") final String unit, @Valid final AddressForm addressForm,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectModel)
					throws CMSItemNotFoundException
	{
		if (bindingResult.hasErrors())
		{
			final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
			breadcrumbs.add(new Breadcrumb(
					String.format("/my-company/organization-management/manage-units/add-address/?unit=%s", urlEncode(unit)),
					getMessageSource().getMessage("text.company.manage.units.addAddress", new Object[]
			{ unit }, "Add Address to {0} Business Unit ", getI18nService().getCurrentLocale()), null));
			model.addAttribute("breadcrumbs", breadcrumbs);
			GlobalMessages.addErrorMessage(model, "form.global.error");
			storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
			model.addAttribute("countryData", checkoutFacade.getDeliveryCountries());
			model.addAttribute("titleData", getUserFacade().getTitles());
			model.addAttribute("uid", unit);
			final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
			if (unitData != null)
			{
				model.addAttribute("unitName", unitData.getName());
			}
			return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitAddAddressPage;
		}

		final AddressData newAddress = addressDataUtil.convertToAddressData(addressForm);

		try
		{
			b2bUnitFacade.addAddressToUnit(newAddress, unit);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.added");
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage(), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "form.global.error");
		}

		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	@RequestMapping(value = "/remove-address", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@RequireHardLogIn
	public String removeAddress(@RequestParam("unit") final String unit, @RequestParam("addressId") final String addressId,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		try
		{
			b2bUnitFacade.removeAddressFromUnit(unit, addressId);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
					"account.confirmation.address.removed");
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage(), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "form.global.error");
		}

		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	@RequestMapping(value = "/edit-address", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String editAddress(@RequestParam("unit") final String unit, @RequestParam("addressId") final String addressId,
			final Model model, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final AddressForm addressForm = new AddressForm();
		model.addAttribute("countryData", checkoutFacade.getDeliveryCountries());
		model.addAttribute("titleData", getUserFacade().getTitles());
		model.addAttribute("addressForm", addressForm);
		final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
		if (unit != null)
		{
			for (final AddressData addressData : unitData.getAddresses())
			{
				if (addressData.getId() != null && addressData.getId().equals(addressId))
				{
					model.addAttribute("addressData", addressData);
					addressDataUtil.convertBasic(addressData, addressForm);
					break;
				}
			}
		}
		else
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "b2bunit.notfound");
		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
		breadcrumbs
				.add(new Breadcrumb(
						String.format("/my-company/organization-management/manage-units/edit-address/?unit=%s&addressId=%s",
								urlEncode(unit), urlEncode(addressId)),
						getMessageSource().getMessage("text.company.manage.units.editAddress", new Object[]
		{ unit }, "Edit Address for {0} Business Unit ", getI18nService().getCurrentLocale()), null));

		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("uid", unit);
		model.addAttribute("unitName", unitData.getName());
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitAddAddressPage;
	}

	@RequestMapping(value = "/edit-address", method =
	{ RequestMethod.POST })
	@RequireHardLogIn
	public String editAddress(@RequestParam("unit") final String unit, @RequestParam("addressId") final String addressId,
			@Valid final AddressForm addressForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		if (bindingResult.hasErrors())
		{
			final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(unit);
			breadcrumbs.add(new Breadcrumb(
					String.format("/my-company/organization-management/manage-units/edit-address/?unit=%s&addressId=%s",
							urlEncode(unit), urlEncode(addressId)),
					getMessageSource().getMessage("text.company.manage.units.editAddress.breadcrumb", new Object[]
			{ unit }, "Edit Address of {0} Business Unit ", getI18nService().getCurrentLocale()), null));

			GlobalMessages.addErrorMessage(model, "form.global.error");
			storeCmsPageInModel(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
			setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MANAGE_UNITS_CMS_PAGE));
			model.addAttribute("countryData", checkoutFacade.getDeliveryCountries());
			model.addAttribute("titleData", getUserFacade().getTitles());
			model.addAttribute("uid", unit);
			final B2BUnitData unitData = b2bUnitFacade.getUnitForUid(unit);
			if (unitData != null)
			{
				for (final AddressData addressData : unitData.getAddresses())
				{
					if (addressData.getId() != null && addressData.getId().equals(addressId))
					{
						model.addAttribute("addressData", addressData);
					}
				}
				model.addAttribute("unitName", unitData.getName());
			}
			return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUnitAddAddressPage;
		}

		final AddressData newAddress = addressDataUtil.convertToAddressData(addressForm);

		try
		{
			b2bUnitFacade.editAddressOfUnit(newAddress, unit);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
					"account.confirmation.address.updated");
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage(), e);
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "form.global.error");
		}

		return String.format(REDIRECT_TO_UNIT_DETAILS, urlEncode(unit));
	}

	protected List<SelectOption> getBusinessProcesses()
	{
		final List<SelectOption> selectOptions = new ArrayList<SelectOption>();
		final Map<String, String> procecess = this.b2bApprovalProcessFacade.getProcesses();
		for (final Map.Entry<String, String> entry : procecess.entrySet())
		{
			selectOptions.add(new SelectOption(entry.getKey(), entry.getValue()));
		}
		return selectOptions;
	}

}
