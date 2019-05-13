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
package de.hybris.platform.b2bacceleratoraddon.controllers.pages;


import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.SearchBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.util.MetaSanitizerUtil;
import de.hybris.platform.acceleratorstorefrontcommons.util.XSSFilterUtil;
import de.hybris.platform.b2bacceleratoraddon.forms.AdvancedSearchForm;
import de.hybris.platform.b2bacceleratorfacades.api.search.SearchFacade;
import de.hybris.platform.b2bacceleratorfacades.search.data.ProductSearchStateData;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.data.SearchQueryData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commerceservices.search.facetdata.FacetData;
import de.hybris.platform.commerceservices.search.facetdata.FacetValueData;
import de.hybris.platform.commerceservices.search.facetdata.ProductSearchPageData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.util.Config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;


@Controller
@RequestMapping("/search")
public class AdvanceSearchPageController extends AbstractSearchPageController
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(AdvanceSearchPageController.class);

	private static final String ADVANCED_FLEXIBLE_SEARCH_PAGE_SIZE_PARAM = "storefront.flexible.advance.search.pageSize";
	private static final String ADVANCED_SEARCH_PRODUCT_IDS_DELIMITER = "storefront.advancedsearch.delimiter";
	private static final String ADVANCED_SEARCH_PRODUCT_IDS_DELIMITER_DEFAULT = ",";
	private static final String ADVANCED_SEARCH_RESULT_TYPE_ORDER_FORM = "order-form";
	private static final String FUTURE_STOCK_ENABLED = "storefront.products.futurestock.enabled";
	private static final String NO_RESULTS_ADVANCED_PAGE_ID = "searchAdvancedEmpty";
	private static final Set<String> PAGINATION_PARAM_REMOVAL_LOOKUP_TABLE = new HashSet<>(Arrays.asList("PAGE", "SHOW", "SORT"));

	@Resource(name = "searchBreadcrumbBuilder")
	private SearchBreadcrumbBuilder searchBreadcrumbBuilder;

	@Resource(name = "b2bProductFlexibleSearchFacade")
	private SearchFacade<ProductData, SearchStateData> flexibleSearchProductSearchFacade;

	@Resource(name = "b2bSolrProductSearchFacade")
	private SearchFacade<ProductData, SearchStateData> b2bSolrProductSearchFacade;

	@RequestMapping(value = "/advanced", method = RequestMethod.GET)
	public String advanceSearchResults(
			@RequestParam(value = "keywords", required = false, defaultValue = StringUtils.EMPTY) final String keywords,
			@RequestParam(value = "searchResultType", required = false, defaultValue = ADVANCED_SEARCH_RESULT_TYPE_ORDER_FORM) final String searchResultType,
			@RequestParam(value = "q", defaultValue = StringUtils.EMPTY) final String searchQuery,
			@RequestParam(value = "onlyProductIds", required = false, defaultValue = "false") final boolean onlyProductIds,
			@RequestParam(value = "isCreateOrderForm", required = false, defaultValue = "false") final boolean isCreateOrderForm,
			@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		String searchTerm = keywords;
		if (StringUtils.isNotBlank(searchQuery))
		{
			searchTerm = StringUtils.split(searchQuery, ":")[0];
		}
		// check if it is order form (either order form was selected or "Create Order Form"
		final boolean useFlexibleSearch = isUseFlexibleSearch(onlyProductIds, isCreateOrderForm);
		final PageableData pageableData = createPageableData(page, getResultsCountForPagination(),sortCode, showMode);
		final SearchStateData searchState = createSearchStateData(request.getRequestURI(),searchTerm,
				isPopulateVariants(searchResultType, isCreateOrderForm));

		final SearchPageData<ProductData> searchPageData = performSearch(searchState, pageableData, useFlexibleSearch);
		populateModel(model, searchPageData, showMode);

		final AdvancedSearchForm form = new AdvancedSearchForm();
		form.setOnlyProductIds(Boolean.valueOf(onlyProductIds));
		form.setKeywords(searchTerm);
		form.setCreateOrderForm(isCreateOrderForm);
		if (isCreateOrderForm)
		{
			form.setSearchResultType(ADVANCED_SEARCH_RESULT_TYPE_ORDER_FORM);
			form.setFilterSkus(splitSkusAsList(searchTerm));
			form.setCreateOrderForm(Boolean.FALSE);
			form.setOnlyProductIds(Boolean.TRUE);
		}
		else
		{
			form.setSearchResultType(searchResultType);
		}

		final String breadcrumbText = getMessageSource().getMessage("search.advanced.meta.description.title", null, getCurrentLocale());
		final String metaInfoText = MetaSanitizerUtil.sanitizeDescription((StringUtils.isEmpty(searchTerm)) ? breadcrumbText : searchTerm);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, searchBreadcrumbBuilder.getBreadcrumbs(null, breadcrumbText, false));
		model.addAttribute("advancedSearchForm", form);
		model.addAttribute("futureStockEnabled", Boolean.valueOf(Config.getBoolean(FUTURE_STOCK_ENABLED, false)));
		model.addAttribute("paginateUrl",getPaginationUrlFromHttpRequest(request));
		storeCmsPageInModel(model, getContentPageForLabelOrId(NO_RESULTS_ADVANCED_PAGE_ID));
		addMetaData(model, "search.meta.description.results", metaInfoText, "search.meta.description.on", PageType.PRODUCTSEARCH,
				ThirdPartyConstants.SeoRobots.NOINDEX_FOLLOW);

		return getViewForPage(model);
	}


	protected ProductSearchStateData createSearchStateData(final String url,final String term, final boolean populateVariants)
	{

		final ProductSearchStateData searchState = new ProductSearchStateData();
		final SearchQueryData searchQueryData = new SearchQueryData();
		searchQueryData.setValue(XSSFilterUtil.filter(term));
		searchState.setQuery(searchQueryData);
		searchState.setPopulateVariants(populateVariants);
		searchState.setUrl(url);

		return searchState;
	}

	protected void addMetaData(final Model model, final String metaPrefixKey, final String searchText,
			final String metaPostfixKey, final PageType pageType, final String robotsBehaviour)
	{
		final String metaDescription = MetaSanitizerUtil.sanitizeDescription(getMessageSource().getMessage(metaPrefixKey, null,
				getCurrentLocale())
				+ " "
				+ searchText
				+ " "
				+ getMessageSource().getMessage(metaPostfixKey, null, getCurrentLocale())
				+ " "
				+ getSiteName());
		final String metaKeywords = MetaSanitizerUtil.sanitizeKeywords(searchText);
		setUpMetaData(model, metaKeywords, metaDescription);

		model.addAttribute("pageType", pageType.name());
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, robotsBehaviour);
	}

	protected List<String> splitSkusAsList(final String skus)
	{
		return Arrays.asList(StringUtils.split(skus,
				Config.getString(ADVANCED_SEARCH_PRODUCT_IDS_DELIMITER, ADVANCED_SEARCH_PRODUCT_IDS_DELIMITER_DEFAULT)));
	}

	protected Locale getCurrentLocale()
	{
		return getI18nService().getCurrentLocale();
	}

	protected boolean isUseFlexibleSearch(final boolean onlyProductIds, final boolean isCreateOrderForm)
	{
		return onlyProductIds || isCreateOrderForm;
	}

	protected boolean isPopulateVariants(final String searchResultType, final boolean isCreateOrderForm)
	{
		return (StringUtils.equals(searchResultType, ADVANCED_SEARCH_RESULT_TYPE_ORDER_FORM)) || isCreateOrderForm;
	}

	protected ProductSearchPageData<SearchStateData, ProductData> performSearch(final SearchStateData searchState,
			final PageableData pageableData, final boolean useFlexibleSearch)
	{

		ProductSearchPageData<SearchStateData, ProductData> searchResult = createEmptySearchPageData();

		if (StringUtils.isNotBlank(searchState.getQuery().getValue()))
		{
			if (useFlexibleSearch)
			{
				searchResult = (ProductSearchPageData<SearchStateData, ProductData>) flexibleSearchProductSearchFacade.search(
						searchState, pageableData);
			}
			else
			{
				// search using solr.
				searchResult = (ProductSearchPageData<SearchStateData, ProductData>) b2bSolrProductSearchFacade.search(searchState,
						pageableData);
			}

		}

		return encodeSearchPageData(searchResult);
	}

	protected ProductSearchPageData<SearchStateData, ProductData> createEmptySearchPageData()
	{
		final ProductSearchPageData productSearchPageData = new ProductSearchPageData();

		productSearchPageData.setResults(Lists.newArrayList());
		final PaginationData pagination = new PaginationData();
		pagination.setTotalNumberOfResults(0);
		productSearchPageData.setPagination(pagination);
		productSearchPageData.setSorts(Lists.newArrayList());

		return productSearchPageData;
	}

	@Override
	protected ProductSearchPageData<SearchStateData, ProductData> encodeSearchPageData(
			final ProductSearchPageData<SearchStateData, ProductData> searchPageData)
	{
		final SearchStateData currentQuery = searchPageData.getCurrentQuery();

		if (currentQuery != null)
		{
			final SearchQueryData query = currentQuery.getQuery();
			final String encodedQueryValue = StringEscapeUtils.escapeHtml(query.getValue());
			query.setValue(encodedQueryValue);
			currentQuery.setQuery(query);
			searchPageData.setCurrentQuery(currentQuery);

			final List<FacetData<SearchStateData>> facets = searchPageData.getFacets();
			if (CollectionUtils.isNotEmpty(facets))
			{
				for (final FacetData<SearchStateData> facetData : facets)
				{
					final List<FacetValueData<SearchStateData>> facetValueDatas = facetData.getValues();
					if (CollectionUtils.isNotEmpty(facetValueDatas))
					{
						for (final FacetValueData<SearchStateData> facetValueData : facetValueDatas)
						{
							final SearchStateData facetQuery = facetValueData.getQuery();
							final SearchQueryData queryData = facetQuery.getQuery();
							final String queryValue = queryData.getValue();
							if (StringUtils.isNotBlank(queryValue))
							{
								final String[] queryValues = queryValue.split(":");
								final StringBuilder queryValueBuilder = new StringBuilder();
								queryValueBuilder.append(StringEscapeUtils.escapeHtml(queryValues[0]));
								for (int i = 1; i < queryValues.length; i++)
								{
									queryValueBuilder.append(":").append(queryValues[i]);
								}
								queryData.setValue(queryValueBuilder.toString());
							}
						}
					}

					final List<FacetValueData<SearchStateData>> topFacetValueDatas = facetData.getTopValues();
					if (CollectionUtils.isNotEmpty(topFacetValueDatas))
					{
						for (final FacetValueData<SearchStateData> topFacetValueData : topFacetValueDatas)
						{
							final SearchStateData facetQuery = topFacetValueData.getQuery();
							final SearchQueryData queryData = facetQuery.getQuery();
							final String queryValue = queryData.getValue();
							if (StringUtils.isNotBlank(queryValue))
							{
								final String[] queryValues = queryValue.split(":");
								final StringBuilder queryValueBuilder = new StringBuilder();
								queryValueBuilder.append(StringEscapeUtils.escapeHtml(queryValues[0]));
								for (int i = 1; i < queryValues.length; i++)
								{
									queryValueBuilder.append(":").append(queryValues[i]);
								}
								queryData.setValue(queryValueBuilder.toString());
							}
						}
					}
				}
			}
		}
		return searchPageData;
	}

	protected int getResultsCountForPagination()
	{
		return getSiteConfigService().getInt(ADVANCED_FLEXIBLE_SEARCH_PAGE_SIZE_PARAM, 25);
	}

	protected String getPaginationUrlFromHttpRequest(final HttpServletRequest request)
	{
		final Map<String,String[]> requestParamMap = request.getParameterMap();
		final StringBuilder queryParamBuilder = new StringBuilder();
		final Predicate<Map.Entry<String,String[]>> predicate  = entry -> PAGINATION_PARAM_REMOVAL_LOOKUP_TABLE.contains(entry.getKey().trim().toUpperCase());
		if (MapUtils.isNotEmpty(requestParamMap))
		{
		queryParamBuilder.append("?");
		requestParamMap.entrySet()
						.stream()
						.filter(predicate.negate())
						.forEach(entry -> queryParamBuilder
								.append(((queryParamBuilder.length() > 1) ? "&" : "")
										+ entry.getKey() + "=" + entry.getValue()[0]));

		}
		return queryParamBuilder.toString();
	}

}
