/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 11:53:56 AM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.model.product;

import concerttours.model.BandModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.enums.ArticleApprovalStatus;
import de.hybris.platform.catalog.enums.ArticleStatus;
import de.hybris.platform.catalog.enums.IDType;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.KeywordModel;
import de.hybris.platform.catalog.model.ProductFeatureModel;
import de.hybris.platform.catalog.model.ProductReferenceModel;
import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.enums.ProductDiscountGroup;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.model.DiscountRowModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.variants.model.VariantProductModel;
import de.hybris.platform.variants.model.VariantTypeModel;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Generated model class for type Product first defined at extension core.
 */
@SuppressWarnings("all")
public class ProductModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Product";
	
	/**<i>Generated relation code constant for relation <code>Product2KeywordRelation</code> defining source attribute <code>keywords</code> in extension <code>catalog</code>.</i>*/
	public static final String _PRODUCT2KEYWORDRELATION = "Product2KeywordRelation";
	
	/**<i>Generated relation code constant for relation <code>CategoryProductRelation</code> defining source attribute <code>supercategories</code> in extension <code>catalog</code>.</i>*/
	public static final String _CATEGORYPRODUCTRELATION = "CategoryProductRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.code</code> attribute defined at extension <code>core</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.name</code> attribute defined at extension <code>core</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.unit</code> attribute defined at extension <code>core</code>. */
	public static final String UNIT = "unit";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.description</code> attribute defined at extension <code>core</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.thumbnail</code> attribute defined at extension <code>core</code>. */
	public static final String THUMBNAIL = "thumbnail";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.picture</code> attribute defined at extension <code>core</code>. */
	public static final String PICTURE = "picture";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.catalog</code> attribute defined at extension <code>catalog</code>. */
	public static final String CATALOG = "catalog";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.catalogVersion</code> attribute defined at extension <code>catalog</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.onlineDate</code> attribute defined at extension <code>catalog</code>. */
	public static final String ONLINEDATE = "onlineDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.offlineDate</code> attribute defined at extension <code>catalog</code>. */
	public static final String OFFLINEDATE = "offlineDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.ean</code> attribute defined at extension <code>catalog</code>. */
	public static final String EAN = "ean";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.supplierAlternativeAID</code> attribute defined at extension <code>catalog</code>. */
	public static final String SUPPLIERALTERNATIVEAID = "supplierAlternativeAID";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.buyerIDS</code> attribute defined at extension <code>catalog</code>. */
	public static final String BUYERIDS = "buyerIDS";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.manufacturerAID</code> attribute defined at extension <code>catalog</code>. */
	public static final String MANUFACTURERAID = "manufacturerAID";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.manufacturerName</code> attribute defined at extension <code>catalog</code>. */
	public static final String MANUFACTURERNAME = "manufacturerName";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.manufacturerTypeDescription</code> attribute defined at extension <code>catalog</code>. */
	public static final String MANUFACTURERTYPEDESCRIPTION = "manufacturerTypeDescription";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.erpGroupBuyer</code> attribute defined at extension <code>catalog</code>. */
	public static final String ERPGROUPBUYER = "erpGroupBuyer";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.erpGroupSupplier</code> attribute defined at extension <code>catalog</code>. */
	public static final String ERPGROUPSUPPLIER = "erpGroupSupplier";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.deliveryTime</code> attribute defined at extension <code>catalog</code>. */
	public static final String DELIVERYTIME = "deliveryTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.specialTreatmentClasses</code> attribute defined at extension <code>catalog</code>. */
	public static final String SPECIALTREATMENTCLASSES = "specialTreatmentClasses";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.remarks</code> attribute defined at extension <code>catalog</code>. */
	public static final String REMARKS = "remarks";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.segment</code> attribute defined at extension <code>catalog</code>. */
	public static final String SEGMENT = "segment";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.order</code> attribute defined at extension <code>catalog</code>. */
	public static final String ORDER = "order";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.articleStatus</code> attribute defined at extension <code>catalog</code>. */
	public static final String ARTICLESTATUS = "articleStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.approvalStatus</code> attribute defined at extension <code>catalog</code>. */
	public static final String APPROVALSTATUS = "approvalStatus";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.contentUnit</code> attribute defined at extension <code>catalog</code>. */
	public static final String CONTENTUNIT = "contentUnit";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.numberContentUnits</code> attribute defined at extension <code>catalog</code>. */
	public static final String NUMBERCONTENTUNITS = "numberContentUnits";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.minOrderQuantity</code> attribute defined at extension <code>catalog</code>. */
	public static final String MINORDERQUANTITY = "minOrderQuantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.maxOrderQuantity</code> attribute defined at extension <code>catalog</code>. */
	public static final String MAXORDERQUANTITY = "maxOrderQuantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.orderQuantityInterval</code> attribute defined at extension <code>catalog</code>. */
	public static final String ORDERQUANTITYINTERVAL = "orderQuantityInterval";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.priceQuantity</code> attribute defined at extension <code>catalog</code>. */
	public static final String PRICEQUANTITY = "priceQuantity";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.normal</code> attribute defined at extension <code>catalog</code>. */
	public static final String NORMAL = "normal";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.thumbnails</code> attribute defined at extension <code>catalog</code>. */
	public static final String THUMBNAILS = "thumbnails";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.detail</code> attribute defined at extension <code>catalog</code>. */
	public static final String DETAIL = "detail";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.logo</code> attribute defined at extension <code>catalog</code>. */
	public static final String LOGO = "logo";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.data_sheet</code> attribute defined at extension <code>catalog</code>. */
	public static final String DATA_SHEET = "data_sheet";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.others</code> attribute defined at extension <code>catalog</code>. */
	public static final String OTHERS = "others";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.untypedFeatures</code> attribute defined at extension <code>catalog</code>. */
	public static final String UNTYPEDFEATURES = "untypedFeatures";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.classificationClasses</code> attribute defined at extension <code>catalog</code>. */
	public static final String CLASSIFICATIONCLASSES = "classificationClasses";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.startLineNumber</code> attribute defined at extension <code>catalog</code>. */
	public static final String STARTLINENUMBER = "startLineNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.endLineNumber</code> attribute defined at extension <code>catalog</code>. */
	public static final String ENDLINENUMBER = "endLineNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.xmlcontent</code> attribute defined at extension <code>catalog</code>. */
	public static final String XMLCONTENT = "xmlcontent";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.variantType</code> attribute defined at extension <code>catalog</code>. */
	public static final String VARIANTTYPE = "variantType";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.keywords</code> attribute defined at extension <code>catalog</code>. */
	public static final String KEYWORDS = "keywords";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.features</code> attribute defined at extension <code>catalog</code>. */
	public static final String FEATURES = "features";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.variants</code> attribute defined at extension <code>catalog</code>. */
	public static final String VARIANTS = "variants";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.productReferences</code> attribute defined at extension <code>catalog</code>. */
	public static final String PRODUCTREFERENCES = "productReferences";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.supercategories</code> attribute defined at extension <code>catalog</code>. */
	public static final String SUPERCATEGORIES = "supercategories";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.Europe1PriceFactory_PPG</code> attribute defined at extension <code>europe1</code>. */
	public static final String EUROPE1PRICEFACTORY_PPG = "Europe1PriceFactory_PPG";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.Europe1PriceFactory_PTG</code> attribute defined at extension <code>europe1</code>. */
	public static final String EUROPE1PRICEFACTORY_PTG = "Europe1PriceFactory_PTG";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.Europe1PriceFactory_PDG</code> attribute defined at extension <code>europe1</code>. */
	public static final String EUROPE1PRICEFACTORY_PDG = "Europe1PriceFactory_PDG";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.europe1Prices</code> attribute defined at extension <code>europe1</code>. */
	public static final String EUROPE1PRICES = "europe1Prices";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.europe1Taxes</code> attribute defined at extension <code>europe1</code>. */
	public static final String EUROPE1TAXES = "europe1Taxes";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.europe1Discounts</code> attribute defined at extension <code>europe1</code>. */
	public static final String EUROPE1DISCOUNTS = "europe1Discounts";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.ownEurope1Discounts</code> attribute defined at extension <code>europe1</code>. */
	public static final String OWNEUROPE1DISCOUNTS = "ownEurope1Discounts";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.ownEurope1Prices</code> attribute defined at extension <code>europe1</code>. */
	public static final String OWNEUROPE1PRICES = "ownEurope1Prices";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.ownEurope1Taxes</code> attribute defined at extension <code>europe1</code>. */
	public static final String OWNEUROPE1TAXES = "ownEurope1Taxes";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.hashtag</code> attribute defined at extension <code>concerttours</code>. */
	public static final String HASHTAG = "hashtag";
	
	/** <i>Generated constant</i> - Attribute key of <code>Product.band</code> attribute defined at extension <code>concerttours</code>. */
	public static final String BAND = "band";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 */
	@Deprecated
	public ProductModel(final CatalogVersionModel _catalogVersion, final String _code)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public ProductModel(final CatalogVersionModel _catalogVersion, final String _code, final ItemModel _owner)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.approvalStatus</code> attribute defined at extension <code>catalog</code>. 
	 * @return the approvalStatus
	 */
	@Accessor(qualifier = "approvalStatus", type = Accessor.Type.GETTER)
	public ArticleApprovalStatus getApprovalStatus()
	{
		return getPersistenceContext().getPropertyValue(APPROVALSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleStatus</code> attribute defined at extension <code>catalog</code>. 
	 * @return the articleStatus
	 */
	@Accessor(qualifier = "articleStatus", type = Accessor.Type.GETTER)
	public Map<ArticleStatus,String> getArticleStatus()
	{
		return getArticleStatus(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleStatus</code> attribute defined at extension <code>catalog</code>. 
	 * @param loc the value localization key 
	 * @return the articleStatus
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "articleStatus", type = Accessor.Type.GETTER)
	public Map<ArticleStatus,String> getArticleStatus(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(ARTICLESTATUS, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.band</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the band
	 */
	@Accessor(qualifier = "band", type = Accessor.Type.GETTER)
	public BandModel getBand()
	{
		return getPersistenceContext().getPropertyValue(BAND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.buyerIDS</code> attribute defined at extension <code>catalog</code>. 
	 * @return the buyerIDS
	 */
	@Accessor(qualifier = "buyerIDS", type = Accessor.Type.GETTER)
	public Map<IDType,String> getBuyerIDS()
	{
		return getPersistenceContext().getPropertyValue(BUYERIDS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.catalogVersion</code> attribute defined at extension <code>catalog</code>. 
	 * @return the catalogVersion
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.classificationClasses</code> dynamic attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the classificationClasses
	 */
	@Accessor(qualifier = "classificationClasses", type = Accessor.Type.GETTER)
	public List<ClassificationClassModel> getClassificationClasses()
	{
		return getPersistenceContext().getDynamicValue(this,CLASSIFICATIONCLASSES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.code</code> attribute defined at extension <code>core</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.contentUnit</code> attribute defined at extension <code>catalog</code>. 
	 * @return the contentUnit
	 */
	@Accessor(qualifier = "contentUnit", type = Accessor.Type.GETTER)
	public UnitModel getContentUnit()
	{
		return getPersistenceContext().getPropertyValue(CONTENTUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.data_sheet</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the data_sheet
	 */
	@Accessor(qualifier = "data_sheet", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getData_sheet()
	{
		return getPersistenceContext().getPropertyValue(DATA_SHEET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deliveryTime</code> attribute defined at extension <code>catalog</code>. 
	 * @return the deliveryTime
	 */
	@Accessor(qualifier = "deliveryTime", type = Accessor.Type.GETTER)
	public Double getDeliveryTime()
	{
		return getPersistenceContext().getPropertyValue(DELIVERYTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.description</code> attribute defined at extension <code>core</code>. 
	 * @return the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getDescription(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.description</code> attribute defined at extension <code>core</code>. 
	 * @param loc the value localization key 
	 * @return the description
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(DESCRIPTION, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.detail</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the detail
	 */
	@Accessor(qualifier = "detail", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getDetail()
	{
		return getPersistenceContext().getPropertyValue(DETAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ean</code> attribute defined at extension <code>catalog</code>. 
	 * @return the ean
	 */
	@Accessor(qualifier = "ean", type = Accessor.Type.GETTER)
	public String getEan()
	{
		return getPersistenceContext().getPropertyValue(EAN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.endLineNumber</code> attribute defined at extension <code>catalog</code>. 
	 * @return the endLineNumber
	 */
	@Accessor(qualifier = "endLineNumber", type = Accessor.Type.GETTER)
	public Integer getEndLineNumber()
	{
		return getPersistenceContext().getPropertyValue(ENDLINENUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.erpGroupBuyer</code> attribute defined at extension <code>catalog</code>. 
	 * @return the erpGroupBuyer
	 */
	@Accessor(qualifier = "erpGroupBuyer", type = Accessor.Type.GETTER)
	public String getErpGroupBuyer()
	{
		return getPersistenceContext().getPropertyValue(ERPGROUPBUYER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.erpGroupSupplier</code> attribute defined at extension <code>catalog</code>. 
	 * @return the erpGroupSupplier
	 */
	@Accessor(qualifier = "erpGroupSupplier", type = Accessor.Type.GETTER)
	public String getErpGroupSupplier()
	{
		return getPersistenceContext().getPropertyValue(ERPGROUPSUPPLIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.europe1Discounts</code> dynamic attribute defined at extension <code>europe1</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the europe1Discounts
	 */
	@Accessor(qualifier = "europe1Discounts", type = Accessor.Type.GETTER)
	public Collection<DiscountRowModel> getEurope1Discounts()
	{
		return getPersistenceContext().getDynamicValue(this,EUROPE1DISCOUNTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.Europe1PriceFactory_PDG</code> attribute defined at extension <code>europe1</code>. 
	 * @return the Europe1PriceFactory_PDG
	 */
	@Accessor(qualifier = "Europe1PriceFactory_PDG", type = Accessor.Type.GETTER)
	public ProductDiscountGroup getEurope1PriceFactory_PDG()
	{
		return getPersistenceContext().getPropertyValue(EUROPE1PRICEFACTORY_PDG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.Europe1PriceFactory_PPG</code> attribute defined at extension <code>europe1</code>. 
	 * @return the Europe1PriceFactory_PPG
	 */
	@Accessor(qualifier = "Europe1PriceFactory_PPG", type = Accessor.Type.GETTER)
	public ProductPriceGroup getEurope1PriceFactory_PPG()
	{
		return getPersistenceContext().getPropertyValue(EUROPE1PRICEFACTORY_PPG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.Europe1PriceFactory_PTG</code> attribute defined at extension <code>europe1</code>. 
	 * @return the Europe1PriceFactory_PTG
	 */
	@Accessor(qualifier = "Europe1PriceFactory_PTG", type = Accessor.Type.GETTER)
	public ProductTaxGroup getEurope1PriceFactory_PTG()
	{
		return getPersistenceContext().getPropertyValue(EUROPE1PRICEFACTORY_PTG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.europe1Prices</code> dynamic attribute defined at extension <code>europe1</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the europe1Prices
	 */
	@Accessor(qualifier = "europe1Prices", type = Accessor.Type.GETTER)
	public Collection<PriceRowModel> getEurope1Prices()
	{
		return getPersistenceContext().getDynamicValue(this,EUROPE1PRICES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.europe1Taxes</code> dynamic attribute defined at extension <code>europe1</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the europe1Taxes
	 */
	@Accessor(qualifier = "europe1Taxes", type = Accessor.Type.GETTER)
	public Collection<TaxRowModel> getEurope1Taxes()
	{
		return getPersistenceContext().getDynamicValue(this,EUROPE1TAXES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.features</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the features
	 */
	@Accessor(qualifier = "features", type = Accessor.Type.GETTER)
	public List<ProductFeatureModel> getFeatures()
	{
		return getPersistenceContext().getPropertyValue(FEATURES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.hashtag</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the hashtag - hashtag of concert tour for social media
	 */
	@Accessor(qualifier = "hashtag", type = Accessor.Type.GETTER)
	public String getHashtag()
	{
		return getPersistenceContext().getPropertyValue(HASHTAG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.keywords</code> attribute defined at extension <code>catalog</code>. 
	 * @return the keywords - Keywords
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.GETTER)
	public List<KeywordModel> getKeywords()
	{
		return getKeywords(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.keywords</code> attribute defined at extension <code>catalog</code>. 
	 * @param loc the value localization key 
	 * @return the keywords - Keywords
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.GETTER)
	public List<KeywordModel> getKeywords(final Locale loc)
	{
		return getPersistenceContext().getLocalizedRelationValue(KEYWORDS, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.logo</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the logo
	 */
	@Accessor(qualifier = "logo", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getLogo()
	{
		return getPersistenceContext().getPropertyValue(LOGO);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerAID</code> attribute defined at extension <code>catalog</code>. 
	 * @return the manufacturerAID
	 */
	@Accessor(qualifier = "manufacturerAID", type = Accessor.Type.GETTER)
	public String getManufacturerAID()
	{
		return getPersistenceContext().getPropertyValue(MANUFACTURERAID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerName</code> attribute defined at extension <code>catalog</code>. 
	 * @return the manufacturerName
	 */
	@Accessor(qualifier = "manufacturerName", type = Accessor.Type.GETTER)
	public String getManufacturerName()
	{
		return getPersistenceContext().getPropertyValue(MANUFACTURERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerTypeDescription</code> attribute defined at extension <code>catalog</code>. 
	 * @return the manufacturerTypeDescription
	 */
	@Accessor(qualifier = "manufacturerTypeDescription", type = Accessor.Type.GETTER)
	public String getManufacturerTypeDescription()
	{
		return getManufacturerTypeDescription(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerTypeDescription</code> attribute defined at extension <code>catalog</code>. 
	 * @param loc the value localization key 
	 * @return the manufacturerTypeDescription
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "manufacturerTypeDescription", type = Accessor.Type.GETTER)
	public String getManufacturerTypeDescription(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(MANUFACTURERTYPEDESCRIPTION, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.maxOrderQuantity</code> attribute defined at extension <code>catalog</code>. 
	 * @return the maxOrderQuantity
	 */
	@Accessor(qualifier = "maxOrderQuantity", type = Accessor.Type.GETTER)
	public Integer getMaxOrderQuantity()
	{
		return getPersistenceContext().getPropertyValue(MAXORDERQUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.minOrderQuantity</code> attribute defined at extension <code>catalog</code>. 
	 * @return the minOrderQuantity
	 */
	@Accessor(qualifier = "minOrderQuantity", type = Accessor.Type.GETTER)
	public Integer getMinOrderQuantity()
	{
		return getPersistenceContext().getPropertyValue(MINORDERQUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.name</code> attribute defined at extension <code>core</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.name</code> attribute defined at extension <code>core</code>. 
	 * @param loc the value localization key 
	 * @return the name
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.normal</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the normal
	 */
	@Accessor(qualifier = "normal", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getNormal()
	{
		return getPersistenceContext().getPropertyValue(NORMAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.numberContentUnits</code> attribute defined at extension <code>catalog</code>. 
	 * @return the numberContentUnits
	 */
	@Accessor(qualifier = "numberContentUnits", type = Accessor.Type.GETTER)
	public Double getNumberContentUnits()
	{
		return getPersistenceContext().getPropertyValue(NUMBERCONTENTUNITS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.offlineDate</code> attribute defined at extension <code>catalog</code>. 
	 * @return the offlineDate
	 */
	@Accessor(qualifier = "offlineDate", type = Accessor.Type.GETTER)
	public Date getOfflineDate()
	{
		return getPersistenceContext().getPropertyValue(OFFLINEDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.onlineDate</code> attribute defined at extension <code>catalog</code>. 
	 * @return the onlineDate
	 */
	@Accessor(qualifier = "onlineDate", type = Accessor.Type.GETTER)
	public Date getOnlineDate()
	{
		return getPersistenceContext().getPropertyValue(ONLINEDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.order</code> attribute defined at extension <code>catalog</code>. 
	 * @return the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.GETTER)
	public Integer getOrder()
	{
		return getPersistenceContext().getPropertyValue(ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.orderQuantityInterval</code> attribute defined at extension <code>catalog</code>. 
	 * @return the orderQuantityInterval
	 */
	@Accessor(qualifier = "orderQuantityInterval", type = Accessor.Type.GETTER)
	public Integer getOrderQuantityInterval()
	{
		return getPersistenceContext().getPropertyValue(ORDERQUANTITYINTERVAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.others</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the others
	 */
	@Accessor(qualifier = "others", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getOthers()
	{
		return getPersistenceContext().getPropertyValue(OTHERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ownEurope1Discounts</code> attribute defined at extension <code>europe1</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ownEurope1Discounts
	 */
	@Accessor(qualifier = "ownEurope1Discounts", type = Accessor.Type.GETTER)
	public Collection<DiscountRowModel> getOwnEurope1Discounts()
	{
		return getPersistenceContext().getPropertyValue(OWNEUROPE1DISCOUNTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ownEurope1Prices</code> attribute defined at extension <code>europe1</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ownEurope1Prices
	 */
	@Accessor(qualifier = "ownEurope1Prices", type = Accessor.Type.GETTER)
	public Collection<PriceRowModel> getOwnEurope1Prices()
	{
		return getPersistenceContext().getPropertyValue(OWNEUROPE1PRICES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ownEurope1Taxes</code> attribute defined at extension <code>europe1</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ownEurope1Taxes
	 */
	@Accessor(qualifier = "ownEurope1Taxes", type = Accessor.Type.GETTER)
	public Collection<TaxRowModel> getOwnEurope1Taxes()
	{
		return getPersistenceContext().getPropertyValue(OWNEUROPE1TAXES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.picture</code> attribute defined at extension <code>core</code>. 
	 * @return the picture
	 */
	@Accessor(qualifier = "picture", type = Accessor.Type.GETTER)
	public MediaModel getPicture()
	{
		return getPersistenceContext().getPropertyValue(PICTURE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.priceQuantity</code> attribute defined at extension <code>catalog</code>. 
	 * @return the priceQuantity
	 */
	@Accessor(qualifier = "priceQuantity", type = Accessor.Type.GETTER)
	public Double getPriceQuantity()
	{
		return getPersistenceContext().getPropertyValue(PRICEQUANTITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productReferences</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the productReferences
	 */
	@Accessor(qualifier = "productReferences", type = Accessor.Type.GETTER)
	public Collection<ProductReferenceModel> getProductReferences()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTREFERENCES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.remarks</code> attribute defined at extension <code>catalog</code>. 
	 * @return the remarks
	 */
	@Accessor(qualifier = "remarks", type = Accessor.Type.GETTER)
	public String getRemarks()
	{
		return getRemarks(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.remarks</code> attribute defined at extension <code>catalog</code>. 
	 * @param loc the value localization key 
	 * @return the remarks
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "remarks", type = Accessor.Type.GETTER)
	public String getRemarks(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(REMARKS, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.segment</code> attribute defined at extension <code>catalog</code>. 
	 * @return the segment
	 */
	@Accessor(qualifier = "segment", type = Accessor.Type.GETTER)
	public String getSegment()
	{
		return getSegment(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.segment</code> attribute defined at extension <code>catalog</code>. 
	 * @param loc the value localization key 
	 * @return the segment
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "segment", type = Accessor.Type.GETTER)
	public String getSegment(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(SEGMENT, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.specialTreatmentClasses</code> attribute defined at extension <code>catalog</code>. 
	 * @return the specialTreatmentClasses
	 */
	@Accessor(qualifier = "specialTreatmentClasses", type = Accessor.Type.GETTER)
	public Map<String,String> getSpecialTreatmentClasses()
	{
		return getPersistenceContext().getPropertyValue(SPECIALTREATMENTCLASSES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.startLineNumber</code> attribute defined at extension <code>catalog</code>. 
	 * @return the startLineNumber
	 */
	@Accessor(qualifier = "startLineNumber", type = Accessor.Type.GETTER)
	public Integer getStartLineNumber()
	{
		return getPersistenceContext().getPropertyValue(STARTLINENUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.supercategories</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the supercategories - Super Categories
	 */
	@Accessor(qualifier = "supercategories", type = Accessor.Type.GETTER)
	public Collection<CategoryModel> getSupercategories()
	{
		return getPersistenceContext().getPropertyValue(SUPERCATEGORIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.supplierAlternativeAID</code> attribute defined at extension <code>catalog</code>. 
	 * @return the supplierAlternativeAID
	 */
	@Accessor(qualifier = "supplierAlternativeAID", type = Accessor.Type.GETTER)
	public String getSupplierAlternativeAID()
	{
		return getPersistenceContext().getPropertyValue(SUPPLIERALTERNATIVEAID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.thumbnail</code> attribute defined at extension <code>core</code>. 
	 * @return the thumbnail
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.GETTER)
	public MediaModel getThumbnail()
	{
		return getPersistenceContext().getPropertyValue(THUMBNAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.thumbnails</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the thumbnails
	 */
	@Accessor(qualifier = "thumbnails", type = Accessor.Type.GETTER)
	public Collection<MediaModel> getThumbnails()
	{
		return getPersistenceContext().getPropertyValue(THUMBNAILS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.unit</code> attribute defined at extension <code>core</code>. 
	 * @return the unit
	 */
	@Accessor(qualifier = "unit", type = Accessor.Type.GETTER)
	public UnitModel getUnit()
	{
		return getPersistenceContext().getPropertyValue(UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.untypedFeatures</code> dynamic attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the untypedFeatures
	 */
	@Accessor(qualifier = "untypedFeatures", type = Accessor.Type.GETTER)
	public List<ProductFeatureModel> getUntypedFeatures()
	{
		return getPersistenceContext().getDynamicValue(this,UNTYPEDFEATURES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.variants</code> attribute defined at extension <code>catalog</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the variants
	 */
	@Accessor(qualifier = "variants", type = Accessor.Type.GETTER)
	public Collection<VariantProductModel> getVariants()
	{
		return getPersistenceContext().getPropertyValue(VARIANTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.variantType</code> attribute defined at extension <code>catalog</code>. 
	 * @return the variantType
	 */
	@Accessor(qualifier = "variantType", type = Accessor.Type.GETTER)
	public VariantTypeModel getVariantType()
	{
		return getPersistenceContext().getPropertyValue(VARIANTTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.xmlcontent</code> attribute defined at extension <code>catalog</code>. 
	 * @return the xmlcontent
	 */
	@Accessor(qualifier = "xmlcontent", type = Accessor.Type.GETTER)
	public String getXmlcontent()
	{
		return getPersistenceContext().getPropertyValue(XMLCONTENT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.approvalStatus</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the approvalStatus
	 */
	@Accessor(qualifier = "approvalStatus", type = Accessor.Type.SETTER)
	public void setApprovalStatus(final ArticleApprovalStatus value)
	{
		getPersistenceContext().setPropertyValue(APPROVALSTATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.articleStatus</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the articleStatus
	 */
	@Accessor(qualifier = "articleStatus", type = Accessor.Type.SETTER)
	public void setArticleStatus(final Map<ArticleStatus,String> value)
	{
		setArticleStatus(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.articleStatus</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the articleStatus
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "articleStatus", type = Accessor.Type.SETTER)
	public void setArticleStatus(final Map<ArticleStatus,String> value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(ARTICLESTATUS, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.band</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the band
	 */
	@Accessor(qualifier = "band", type = Accessor.Type.SETTER)
	public void setBand(final BandModel value)
	{
		getPersistenceContext().setPropertyValue(BAND, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.buyerIDS</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the buyerIDS
	 */
	@Accessor(qualifier = "buyerIDS", type = Accessor.Type.SETTER)
	public void setBuyerIDS(final Map<IDType,String> value)
	{
		getPersistenceContext().setPropertyValue(BUYERIDS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.catalogVersion</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the catalogVersion
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.code</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.contentUnit</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the contentUnit
	 */
	@Accessor(qualifier = "contentUnit", type = Accessor.Type.SETTER)
	public void setContentUnit(final UnitModel value)
	{
		getPersistenceContext().setPropertyValue(CONTENTUNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.data_sheet</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the data_sheet
	 */
	@Accessor(qualifier = "data_sheet", type = Accessor.Type.SETTER)
	public void setData_sheet(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(DATA_SHEET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.deliveryTime</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the deliveryTime
	 */
	@Accessor(qualifier = "deliveryTime", type = Accessor.Type.SETTER)
	public void setDeliveryTime(final Double value)
	{
		getPersistenceContext().setPropertyValue(DELIVERYTIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.description</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		setDescription(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.description</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the description
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(DESCRIPTION, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.detail</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the detail
	 */
	@Accessor(qualifier = "detail", type = Accessor.Type.SETTER)
	public void setDetail(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(DETAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.ean</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the ean
	 */
	@Accessor(qualifier = "ean", type = Accessor.Type.SETTER)
	public void setEan(final String value)
	{
		getPersistenceContext().setPropertyValue(EAN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.endLineNumber</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the endLineNumber
	 */
	@Accessor(qualifier = "endLineNumber", type = Accessor.Type.SETTER)
	public void setEndLineNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ENDLINENUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.erpGroupBuyer</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the erpGroupBuyer
	 */
	@Accessor(qualifier = "erpGroupBuyer", type = Accessor.Type.SETTER)
	public void setErpGroupBuyer(final String value)
	{
		getPersistenceContext().setPropertyValue(ERPGROUPBUYER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.erpGroupSupplier</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the erpGroupSupplier
	 */
	@Accessor(qualifier = "erpGroupSupplier", type = Accessor.Type.SETTER)
	public void setErpGroupSupplier(final String value)
	{
		getPersistenceContext().setPropertyValue(ERPGROUPSUPPLIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.europe1Discounts</code> dynamic attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the europe1Discounts
	 */
	@Accessor(qualifier = "europe1Discounts", type = Accessor.Type.SETTER)
	public void setEurope1Discounts(final Collection<DiscountRowModel> value)
	{
		getPersistenceContext().setDynamicValue(this,EUROPE1DISCOUNTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.Europe1PriceFactory_PDG</code> attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the Europe1PriceFactory_PDG
	 */
	@Accessor(qualifier = "Europe1PriceFactory_PDG", type = Accessor.Type.SETTER)
	public void setEurope1PriceFactory_PDG(final ProductDiscountGroup value)
	{
		getPersistenceContext().setPropertyValue(EUROPE1PRICEFACTORY_PDG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.Europe1PriceFactory_PPG</code> attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the Europe1PriceFactory_PPG
	 */
	@Accessor(qualifier = "Europe1PriceFactory_PPG", type = Accessor.Type.SETTER)
	public void setEurope1PriceFactory_PPG(final ProductPriceGroup value)
	{
		getPersistenceContext().setPropertyValue(EUROPE1PRICEFACTORY_PPG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.Europe1PriceFactory_PTG</code> attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the Europe1PriceFactory_PTG
	 */
	@Accessor(qualifier = "Europe1PriceFactory_PTG", type = Accessor.Type.SETTER)
	public void setEurope1PriceFactory_PTG(final ProductTaxGroup value)
	{
		getPersistenceContext().setPropertyValue(EUROPE1PRICEFACTORY_PTG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.europe1Prices</code> dynamic attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the europe1Prices
	 */
	@Accessor(qualifier = "europe1Prices", type = Accessor.Type.SETTER)
	public void setEurope1Prices(final Collection<PriceRowModel> value)
	{
		getPersistenceContext().setDynamicValue(this,EUROPE1PRICES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.europe1Taxes</code> dynamic attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the europe1Taxes
	 */
	@Accessor(qualifier = "europe1Taxes", type = Accessor.Type.SETTER)
	public void setEurope1Taxes(final Collection<TaxRowModel> value)
	{
		getPersistenceContext().setDynamicValue(this,EUROPE1TAXES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.features</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the features
	 */
	@Accessor(qualifier = "features", type = Accessor.Type.SETTER)
	public void setFeatures(final List<ProductFeatureModel> value)
	{
		getPersistenceContext().setPropertyValue(FEATURES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.hashtag</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the hashtag - hashtag of concert tour for social media
	 */
	@Accessor(qualifier = "hashtag", type = Accessor.Type.SETTER)
	public void setHashtag(final String value)
	{
		getPersistenceContext().setPropertyValue(HASHTAG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.keywords</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the keywords - Keywords
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.SETTER)
	public void setKeywords(final List<KeywordModel> value)
	{
		setKeywords(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.keywords</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the keywords - Keywords
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.SETTER)
	public void setKeywords(final List<KeywordModel> value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(KEYWORDS, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.logo</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the logo
	 */
	@Accessor(qualifier = "logo", type = Accessor.Type.SETTER)
	public void setLogo(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(LOGO, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.manufacturerAID</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the manufacturerAID
	 */
	@Accessor(qualifier = "manufacturerAID", type = Accessor.Type.SETTER)
	public void setManufacturerAID(final String value)
	{
		getPersistenceContext().setPropertyValue(MANUFACTURERAID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.manufacturerName</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the manufacturerName
	 */
	@Accessor(qualifier = "manufacturerName", type = Accessor.Type.SETTER)
	public void setManufacturerName(final String value)
	{
		getPersistenceContext().setPropertyValue(MANUFACTURERNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.manufacturerTypeDescription</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the manufacturerTypeDescription
	 */
	@Accessor(qualifier = "manufacturerTypeDescription", type = Accessor.Type.SETTER)
	public void setManufacturerTypeDescription(final String value)
	{
		setManufacturerTypeDescription(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.manufacturerTypeDescription</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the manufacturerTypeDescription
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "manufacturerTypeDescription", type = Accessor.Type.SETTER)
	public void setManufacturerTypeDescription(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(MANUFACTURERTYPEDESCRIPTION, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.maxOrderQuantity</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the maxOrderQuantity
	 */
	@Accessor(qualifier = "maxOrderQuantity", type = Accessor.Type.SETTER)
	public void setMaxOrderQuantity(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXORDERQUANTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.minOrderQuantity</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the minOrderQuantity
	 */
	@Accessor(qualifier = "minOrderQuantity", type = Accessor.Type.SETTER)
	public void setMinOrderQuantity(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MINORDERQUANTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.name</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.name</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the name
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.normal</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the normal
	 */
	@Accessor(qualifier = "normal", type = Accessor.Type.SETTER)
	public void setNormal(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(NORMAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.numberContentUnits</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the numberContentUnits
	 */
	@Accessor(qualifier = "numberContentUnits", type = Accessor.Type.SETTER)
	public void setNumberContentUnits(final Double value)
	{
		getPersistenceContext().setPropertyValue(NUMBERCONTENTUNITS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.offlineDate</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the offlineDate
	 */
	@Accessor(qualifier = "offlineDate", type = Accessor.Type.SETTER)
	public void setOfflineDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(OFFLINEDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.onlineDate</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the onlineDate
	 */
	@Accessor(qualifier = "onlineDate", type = Accessor.Type.SETTER)
	public void setOnlineDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(ONLINEDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.order</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.SETTER)
	public void setOrder(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ORDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.orderQuantityInterval</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the orderQuantityInterval
	 */
	@Accessor(qualifier = "orderQuantityInterval", type = Accessor.Type.SETTER)
	public void setOrderQuantityInterval(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ORDERQUANTITYINTERVAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.others</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the others
	 */
	@Accessor(qualifier = "others", type = Accessor.Type.SETTER)
	public void setOthers(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(OTHERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.ownEurope1Discounts</code> attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the ownEurope1Discounts
	 */
	@Accessor(qualifier = "ownEurope1Discounts", type = Accessor.Type.SETTER)
	public void setOwnEurope1Discounts(final Collection<DiscountRowModel> value)
	{
		getPersistenceContext().setPropertyValue(OWNEUROPE1DISCOUNTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.ownEurope1Prices</code> attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the ownEurope1Prices
	 */
	@Accessor(qualifier = "ownEurope1Prices", type = Accessor.Type.SETTER)
	public void setOwnEurope1Prices(final Collection<PriceRowModel> value)
	{
		getPersistenceContext().setPropertyValue(OWNEUROPE1PRICES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.ownEurope1Taxes</code> attribute defined at extension <code>europe1</code>. 
	 *  
	 * @param value the ownEurope1Taxes
	 */
	@Accessor(qualifier = "ownEurope1Taxes", type = Accessor.Type.SETTER)
	public void setOwnEurope1Taxes(final Collection<TaxRowModel> value)
	{
		getPersistenceContext().setPropertyValue(OWNEUROPE1TAXES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.picture</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the picture
	 */
	@Accessor(qualifier = "picture", type = Accessor.Type.SETTER)
	public void setPicture(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(PICTURE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.priceQuantity</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the priceQuantity
	 */
	@Accessor(qualifier = "priceQuantity", type = Accessor.Type.SETTER)
	public void setPriceQuantity(final Double value)
	{
		getPersistenceContext().setPropertyValue(PRICEQUANTITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.productReferences</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the productReferences
	 */
	@Accessor(qualifier = "productReferences", type = Accessor.Type.SETTER)
	public void setProductReferences(final Collection<ProductReferenceModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTREFERENCES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.remarks</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the remarks
	 */
	@Accessor(qualifier = "remarks", type = Accessor.Type.SETTER)
	public void setRemarks(final String value)
	{
		setRemarks(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.remarks</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the remarks
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "remarks", type = Accessor.Type.SETTER)
	public void setRemarks(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(REMARKS, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.segment</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the segment
	 */
	@Accessor(qualifier = "segment", type = Accessor.Type.SETTER)
	public void setSegment(final String value)
	{
		setSegment(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Product.segment</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the segment
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "segment", type = Accessor.Type.SETTER)
	public void setSegment(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(SEGMENT, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.specialTreatmentClasses</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the specialTreatmentClasses
	 */
	@Accessor(qualifier = "specialTreatmentClasses", type = Accessor.Type.SETTER)
	public void setSpecialTreatmentClasses(final Map<String,String> value)
	{
		getPersistenceContext().setPropertyValue(SPECIALTREATMENTCLASSES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.startLineNumber</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the startLineNumber
	 */
	@Accessor(qualifier = "startLineNumber", type = Accessor.Type.SETTER)
	public void setStartLineNumber(final Integer value)
	{
		getPersistenceContext().setPropertyValue(STARTLINENUMBER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.supercategories</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the supercategories - Super Categories
	 */
	@Accessor(qualifier = "supercategories", type = Accessor.Type.SETTER)
	public void setSupercategories(final Collection<CategoryModel> value)
	{
		getPersistenceContext().setPropertyValue(SUPERCATEGORIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.supplierAlternativeAID</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the supplierAlternativeAID
	 */
	@Accessor(qualifier = "supplierAlternativeAID", type = Accessor.Type.SETTER)
	public void setSupplierAlternativeAID(final String value)
	{
		getPersistenceContext().setPropertyValue(SUPPLIERALTERNATIVEAID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.thumbnail</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the thumbnail
	 */
	@Accessor(qualifier = "thumbnail", type = Accessor.Type.SETTER)
	public void setThumbnail(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(THUMBNAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.thumbnails</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the thumbnails
	 */
	@Accessor(qualifier = "thumbnails", type = Accessor.Type.SETTER)
	public void setThumbnails(final Collection<MediaModel> value)
	{
		getPersistenceContext().setPropertyValue(THUMBNAILS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.unit</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the unit
	 */
	@Accessor(qualifier = "unit", type = Accessor.Type.SETTER)
	public void setUnit(final UnitModel value)
	{
		getPersistenceContext().setPropertyValue(UNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.untypedFeatures</code> dynamic attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the untypedFeatures
	 */
	@Accessor(qualifier = "untypedFeatures", type = Accessor.Type.SETTER)
	public void setUntypedFeatures(final List<ProductFeatureModel> value)
	{
		getPersistenceContext().setDynamicValue(this,UNTYPEDFEATURES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.variants</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the variants
	 */
	@Accessor(qualifier = "variants", type = Accessor.Type.SETTER)
	public void setVariants(final Collection<VariantProductModel> value)
	{
		getPersistenceContext().setPropertyValue(VARIANTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.variantType</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the variantType
	 */
	@Accessor(qualifier = "variantType", type = Accessor.Type.SETTER)
	public void setVariantType(final VariantTypeModel value)
	{
		getPersistenceContext().setPropertyValue(VARIANTTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Product.xmlcontent</code> attribute defined at extension <code>catalog</code>. 
	 *  
	 * @param value the xmlcontent
	 */
	@Accessor(qualifier = "xmlcontent", type = Accessor.Type.SETTER)
	public void setXmlcontent(final String value)
	{
		getPersistenceContext().setPropertyValue(XMLCONTENT, value);
	}
	
}
