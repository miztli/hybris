/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.order.strategies.calculation.pdt.impl;

import de.hybris.platform.cache.Cache;
import de.hybris.platform.cache.InvalidationListener;
import de.hybris.platform.cache.InvalidationManager;
import de.hybris.platform.cache.InvalidationTarget;
import de.hybris.platform.cache.InvalidationTopic;
import de.hybris.platform.cache.RemoteInvalidationSource;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.constants.Europe1Constants;
import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.enums.UserTaxGroup;
import de.hybris.platform.europe1.jalo.Europe1TaxInformation;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.processor.impl.DefaultPDTProcessor;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.DateRange;
import de.hybris.platform.util.TaxValue;
import de.hybris.platform.util.collections.fast.YLongToObjectMap;
import de.hybris.platform.util.typesystem.PlatformStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Required;


public class CachingFindTaxValueInfoStrategy implements FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria>
{
	private FlexibleSearchService flexibleSearchService;
	private CommonI18NService commonI18NService;

	private PDTEnumGroupsHelper pdtEnumGroupsHelper;

	//private cache - entries are catalog version aware
	private final YLongToObjectMap<Collection<CatalogVersionAwareCachedTax>> catalogAwareCachedTaxes = new YLongToObjectMap<Collection<CatalogVersionAwareCachedTax>>();
	private volatile Boolean cachesTaxes = null;

	public static final long MATCH_ANY = PK.NULL_PK.getLongValue();
	public static final long MATCH_BY_PRODUCT_ID = MATCH_ANY - 1;

	private static final long[] ANY_COLLECTION = new long[]
	{ MATCH_ANY };

	private final InvalidationListener invalidationListener = new InvalidationListener()
	{
		public final String taxRowTypeCode = PlatformStringUtils.valueOf(1054);
		public final String taxTypeCode = PlatformStringUtils.valueOf(47);

		@Override
		public void keyInvalidated(final Object[] key, final int invalidationType, final InvalidationTarget target,
				final RemoteInvalidationSource remoteSrc)
		{
			if (taxRowTypeCode.equals(key[2]) || taxTypeCode.equals(key[2]))
			{
				invalidateTaxCache();
			}
		}
	};

	synchronized void invalidateTaxCache()
	{
		cachesTaxes = null;
	}


	private void registerInvalidationListener()
	{
		final InvalidationTopic topic = InvalidationManager.getInstance().getInvalidationTopic(new String[]
		{ Cache.CACHEKEY_HJMP, Cache.CACHEKEY_ENTITY });
		topic.addInvalidationListener(invalidationListener);
	}


	@PostConstruct
	public void init()
	{
		registerInvalidationListener();
	}

	public static boolean isCachingEnabled()
	{
		return Config.getBoolean(Europe1Constants.KEY_CACHE_TAXES, true);
	}

	@Override
	public List<TaxValue> getPDTValues(final TaxValueInfoCriteria criteria)
	{
		if (!isCachingEnabled())
		{
			return DefaultPDTProcessor.NO_RESULT;
		}
		return new ArrayList<>(getTaxValues(criteria));
	}

	@Override
	public List<TaxInformation> getPDTInformation(final TaxValueInfoCriteria criteria)
	{
		if (!isCachingEnabled())
		{
			return DefaultPDTProcessor.NO_RESULT;
		}

		final Collection<CachedTaxValue> taxValues = getTaxValues(criteria);
		final List<TaxInformation> taxInformations = new ArrayList<>();

		for (final CachedTaxValue v : taxValues)
		{
			taxInformations.add(new Europe1TaxInformation(v, v.getTaxRowPK()));
		}

		return taxInformations;
	}


	protected Collection<CachedTaxValue> getTaxValues(final TaxValueInfoCriteria criteria)
	{
		final Collection<CachedTaxValue> taxes = getCachedTaxes(//
				criteria.getProduct(), //
				criteria.getProductGroup(), //
				criteria.getUser(), //
				criteria.getUserGroup(), //
				criteria.getDate());

		if (taxes.isEmpty())
		{
			return Collections.emptyList();
		}
		else
		{
			final List<CachedTaxValue> ret = new ArrayList<>(taxes.size());
			final CurrencyModel reqCurr = criteria.getCurrency();
			final String isoCode = reqCurr.getIsocode();
			for (final CachedTaxValue tv : taxes)
			{
				if (criteria.getPDTCriteriaTarget() == PDTCriteria.PDTCriteriaTarget.VALUE)
				{
					final CachedTaxValue toAdd = getCachedTaxValue(reqCurr, isoCode, tv);
					ret.add(toAdd);
				}
				else
				{
					ret.add(tv);
				}
			}
			return ret;
		}
	}

	private CachedTaxValue getCachedTaxValue(final CurrencyModel reqCurr, final String isoCode, CachedTaxValue taxValue)
	{
		final boolean abs = taxValue.isAbsolute();
		if (abs)
		{
			final String rowCurr = taxValue.getCurrencyIsoCode();
			if (rowCurr != null && !rowCurr.equals(isoCode))
			{
				taxValue = new CachedTaxValue(taxValue.getTaxRowPK(), taxValue.getCode(),
						commonI18NService.convertAndRoundCurrency(commonI18NService.getCurrency(rowCurr).getConversion().doubleValue(),
								reqCurr.getConversion().doubleValue(), reqCurr.getDigits().intValue(), taxValue.getValue()),
						true, isoCode);
			}
		}
		return taxValue;
	}

	/**
	 * Reads the private cache of catalog version aware tax entries.
	 */
	private Collection<CachedTaxValue> getCachedTaxes(final ProductModel product, final ProductTaxGroup productTaxGroup,
			final UserModel user, final UserTaxGroup userTaxGroup, final Date date)
	{
		if (isNotCachingTaxes())
		{
			return Collections.emptySet();
		}

		final long pPK = product != null ? product.getPk().getLongValue() : MATCH_ANY;
		final long ptgPK = productTaxGroup != null ? pdtEnumGroupsHelper.getPkFromEnum(productTaxGroup).getLongValue() : MATCH_ANY;
		final long uPK = user != null ? user.getPk().getLongValue() : MATCH_ANY;
		final long utgPK = userTaxGroup != null ? pdtEnumGroupsHelper.getPkFromEnum(userTaxGroup).getLongValue() : MATCH_ANY;

		//additionally need to match by product's catalog version
		final CatalogVersionModel catalogVersion = product != null ? product.getCatalogVersion() : null;
		final long[] productCatalogVersionPK = catalogVersion == null ? ANY_COLLECTION : new long[]
		{ catalogVersion.getPk().getLongValue() };

		final Collection<CachedTaxValue> ret = new ArrayList<>();
		final Set<CachedTax> processed = new HashSet<>();
		final CatalogVersionMatchParams paramsToMatch = new CatalogVersionMatchParams(date, pPK, ptgPK, uPK, utgPK,
				productCatalogVersionPK);

		Collection<CatalogVersionAwareCachedTax> matches = catalogAwareCachedTaxes.get(pPK);
		addCachedTaxes(paramsToMatch, ret, processed, matches);

		// match by product group
		matches = catalogAwareCachedTaxes.get(ptgPK);
		addCachedTaxes(paramsToMatch, ret, processed, matches);

		// match by user
		matches = catalogAwareCachedTaxes.get(uPK);
		addCachedTaxes(paramsToMatch, ret, processed, matches);

		// match by user group
		matches = catalogAwareCachedTaxes.get(utgPK);
		addCachedTaxes(paramsToMatch, ret, processed, matches);

		// match by *
		if (isNotMatchAny(pPK, ptgPK, utgPK))
		{
			matches = catalogAwareCachedTaxes.get(MATCH_ANY);
			addCachedTaxes(paramsToMatch, ret, processed, matches);
		}
		return ret;
	}

	private static boolean isNotMatchAny(final long pPK, final long ptgPK, final long utgPK)
	{
		return utgPK != MATCH_ANY && pPK != MATCH_ANY && ptgPK != MATCH_ANY;
	}


	private static Collection<CachedTaxValue> addCachedTaxes(final CatalogVersionMatchParams parameterObject,
			final Collection<CachedTaxValue> ret, final Set<CachedTax> processed,
			final Collection<CatalogVersionAwareCachedTax> matches)
	{
		if (matches != null)
		{
			for (final CatalogVersionAwareCachedTax ct : matches)
			{
				if (processed.add(ct) && ct.matches(parameterObject.getpPK(), parameterObject.getPtgPK(), parameterObject.getuPK(),
						parameterObject.getUtgPK(), parameterObject.getDate(), parameterObject.getProductCatalogVersionPKs()))
				{
					ret.add(ct.getValue());
				}
			}
		}
		return ret;
	}

	private boolean isNotCachingTaxes()
	{
		return !isCachingTaxes();
	}

	protected boolean isCachingTaxes()
	{
		Boolean localCaches = cachesTaxes;
		if (localCaches == null)
		{
			synchronized (this)
			{
				localCaches = cachesTaxes;
				if (localCaches == null)
				{
					if (Config.getBoolean(Europe1Constants.KEY_CACHE_TAXES, true))
					{
						fillTaxCache();
						localCaches = Boolean.TRUE;
					}
					else
					{
						localCaches = Boolean.FALSE;
					}
					cachesTaxes = localCaches;
				}
			}
		}
		return localCaches.booleanValue();
	}

	/**
	 * Fills private cache with catalog version aware tax entries
	 */
	private void fillTaxCache()
	{
		SessionContext ctx = null;
		try
		{
			ctx = JaloSession.getCurrentSession().createLocalSessionContext();
			ctx.setAttribute("disableRestrictions", Boolean.TRUE);

			final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery("SELECT {PK} FROM {" + Europe1Constants.TC.TAXROW + "}");
			searchQuery.setResultClassList(Arrays.asList(TaxRowModel.class));

			final SearchResult<TaxRowModel> taxRowsResult = flexibleSearchService.search(searchQuery);
			final List<TaxRowModel> taxRows = taxRowsResult.getResult();
			catalogAwareCachedTaxes.clear();
			for (final TaxRowModel tr : taxRows)
			{
				if (tr == null)
				{
					continue;
				}
				final CatalogVersionAwareCachedTax catalogVersionAwareCachedTax = new CatalogVersionAwareCachedTax(tr);
				// link by product qualifier
				Collection<CatalogVersionAwareCachedTax> coll = catalogAwareCachedTaxes
						.get(catalogVersionAwareCachedTax.getProductMatchQualifier());
				if (coll == null)
				{
					coll = new ArrayList<>();
					catalogAwareCachedTaxes.put(catalogVersionAwareCachedTax.getProductMatchQualifier(), coll);
				}
				coll.add(catalogVersionAwareCachedTax);
				// link by user qualifier
				coll = catalogAwareCachedTaxes.get(catalogVersionAwareCachedTax.getUserMatchQualifier());
				if (coll == null)
				{
					coll = new ArrayList<>();
					catalogAwareCachedTaxes.put(catalogVersionAwareCachedTax.getUserMatchQualifier(), coll);
				}
				coll.add(catalogVersionAwareCachedTax);
			}
		}
		finally
		{
			if (ctx != null)
			{
				JaloSession.getCurrentSession().removeLocalSessionContext();
			}
		}
	}

	protected static class CachedTax
	{
		protected static final long ANY = PK.NULL_PK.getLongValue();

		protected final long productMatchQualifier;
		protected final long userMatchQualifier;
		protected final PK rowPK;
		protected final DateRange dateRange;
		protected final CachedTaxValue value;

		protected CachedTax(final TaxRowModel row)
		{
			this.productMatchQualifier = row.getProductMatchQualifier();
			this.userMatchQualifier = row.getUserMatchQualifier();
			this.rowPK = row.getPk();
			this.dateRange = row.getDateRange();

			final TaxModel tax = row.getTax();
			if (row.getValue() != null)
			{
				this.value = new CachedTaxValue(this.rowPK, tax.getCode(), row.getValue(), row.getAbsolute(),
						row.getAbsolute() ? row.getCurrency().getIsocode() : null);
			}
			else
			{
				this.value = new CachedTaxValue(this.rowPK, tax.getCode(), tax.getValue().doubleValue(), tax.getAbsolute(),
						tax.getAbsolute() ? tax.getCurrency().getIsocode() : null);
			}
		}

		protected boolean matches(final long pPK, final long ptgPK, final long uPK, final long utgPK, final Date date)
		{
			return isProductMatchQualifier(pPK, ptgPK) && isUserMatchQualifier(uPK, utgPK)
					&& (dateRange == null || dateRange.encloses(date));
		}

		private boolean isUserMatchQualifier(final long uPK, final long utgPK)
		{
			return userMatchQualifier == ANY || uPK == userMatchQualifier || utgPK == userMatchQualifier;
		}

		private boolean isProductMatchQualifier(final long pPK, final long ptgPK)
		{
			return productMatchQualifier == ANY || pPK == productMatchQualifier || ptgPK == productMatchQualifier;
		}

		@Override
		public int hashCode()
		{
			return rowPK.hashCode();
		}

		@Override
		public boolean equals(final Object obj)
		{
			return obj instanceof CachedTax && rowPK.equals(((CachedTax) obj).rowPK);
		}

		@Override
		public String toString()
		{
			return "CachedTax [productMatchQualifier=" + productMatchQualifier + ", userMatchQualifier=" + userMatchQualifier
					+ ", rowPK=" + rowPK + ", dateRange=" + dateRange + ", value=" + value + "]";
		}
	}

	private static class CatalogVersionAwareCachedTax extends CachedTax
	{
		protected final long catalogVersionMatchQualifier;

		CatalogVersionAwareCachedTax(final TaxRowModel row)
		{
			super(row);
			final CatalogVersionModel catalogVersion = row.getCatalogVersion();
			catalogVersionMatchQualifier = catalogVersion != null ? catalogVersion.getPk().getLongValue() : ANY;
		}

		protected boolean matches(final long pPK, final long ptgPK, final long uPK, final long utgPK, final Date date,
				final long[] cvPK)
		{
			return super.matches(pPK, ptgPK, uPK, utgPK, date) && matchesCatalogVersion(cvPK);
		}

		protected boolean matchesCatalogVersion(final long[] cvPK)
		{
			//match if either tax row has no catalog version defined or there are is no session catalog version set
			if (catalogVersionMatchQualifier == ANY || cvPK == ANY_COLLECTION)
			{
				return true;
			}
			for (final long cv : cvPK)
			{
				if (catalogVersionMatchQualifier == cv)
				{
					return true;
				}
			}
			return false;
		}

		public long getProductMatchQualifier()
		{
			return productMatchQualifier;
		}

		public long getUserMatchQualifier()
		{
			return userMatchQualifier;
		}

		public CachedTaxValue getValue()
		{
			return value;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (int) (catalogVersionMatchQualifier ^ (catalogVersionMatchQualifier >>> 32));
			return result;
		}

		@Override
		public boolean equals(final Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (!super.equals(obj))
			{
				return false;
			}
			if (getClass() != obj.getClass())
			{
				return false;
			}
			final CatalogVersionAwareCachedTax other = (CatalogVersionAwareCachedTax) obj;
			return (catalogVersionMatchQualifier == other.catalogVersionMatchQualifier);
		}
	}

	protected static class CachedTaxValue extends TaxValue
	{
		private final PK taxRowPK;

		public CachedTaxValue(final PK taxRowPK, final String code, final double value, final boolean absolute,
				final String currencyIsoCode)
		{
			super(code, value, absolute, currencyIsoCode);
			this.taxRowPK = taxRowPK;
		}

		PK getTaxRowPK()
		{
			return taxRowPK;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((taxRowPK == null) ? 0 : taxRowPK.hashCode());
			return result;
		}

		@Override
		public boolean equals(final Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (!super.equals(obj))
			{
				return false;
			}
			if (getClass() != obj.getClass())
			{
				return false;
			}

			final CachedTaxValue other = (CachedTaxValue) obj;
			if (taxRowPK == null)
			{
				return other.taxRowPK == null;
			}
			else
			{
				return taxRowPK.equals(other.taxRowPK);
			}
		}
	}


	private static class CatalogVersionMatchParams
	{

		private final Date date;
		private final long pPK;
		private final long ptgPK;
		private final long uPK;
		private final long utgPK;
		private final long[] productCatalogVersionPKs;

		public CatalogVersionMatchParams(final Date date, final long pPK, final long ptgPK, final long uPK, final long utgPK,
				final long[] productCatalogVersionPKs)
		{
			this.date = date;
			this.pPK = pPK;
			this.ptgPK = ptgPK;
			this.uPK = uPK;
			this.utgPK = utgPK;
			this.productCatalogVersionPKs = productCatalogVersionPKs;
		}

		public Date getDate()
		{
			return date;
		}

		public long getpPK()
		{
			return pPK;
		}

		public long getPtgPK()
		{
			return ptgPK;
		}

		public long getuPK()
		{
			return uPK;
		}

		public long getUtgPK()
		{
			return utgPK;
		}

		public long[] getProductCatalogVersionPKs()
		{
			return productCatalogVersionPKs;
		}
	}

	@Required
	public void setPdtEnumGroupsHelper(final PDTEnumGroupsHelper pdtEnumGroupsHelper)
	{
		this.pdtEnumGroupsHelper = pdtEnumGroupsHelper;
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}
}
