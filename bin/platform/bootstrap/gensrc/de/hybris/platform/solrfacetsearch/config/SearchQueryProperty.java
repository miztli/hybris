/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.solrfacetsearch.config;

import java.io.Serializable;
import de.hybris.platform.solrfacetsearch.config.FacetType;
import de.hybris.platform.solrfacetsearch.config.WildcardType;

public  class SearchQueryProperty  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchQueryProperty.indexedProperty</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String indexedProperty;

	/** <i>Generated property</i> for <code>SearchQueryProperty.facet</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean facet;

	/** <i>Generated property</i> for <code>SearchQueryProperty.facetType</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private FacetType facetType;

	/** <i>Generated property</i> for <code>SearchQueryProperty.priority</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>SearchQueryProperty.includeInResponse</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean includeInResponse;

	/** <i>Generated property</i> for <code>SearchQueryProperty.highlight</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean highlight;

	/** <i>Generated property</i> for <code>SearchQueryProperty.facetDisplayNameProvider</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String facetDisplayNameProvider;

	/** <i>Generated property</i> for <code>SearchQueryProperty.facetSortProvider</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String facetSortProvider;

	/** <i>Generated property</i> for <code>SearchQueryProperty.facetTopValuesProvider</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String facetTopValuesProvider;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsQuery</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean ftsQuery;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsQueryMinTermLength</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer ftsQueryMinTermLength;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsQueryBoost</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Float ftsQueryBoost;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsFuzzyQuery</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean ftsFuzzyQuery;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsFuzzyQueryMinTermLength</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer ftsFuzzyQueryMinTermLength;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsFuzzyQueryFuzziness</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer ftsFuzzyQueryFuzziness;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsFuzzyQueryBoost</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Float ftsFuzzyQueryBoost;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsWildcardQuery</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean ftsWildcardQuery;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsWildcardQueryMinTermLength</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer ftsWildcardQueryMinTermLength;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsWildcardQueryType</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private WildcardType ftsWildcardQueryType;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsWildcardQueryBoost</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Float ftsWildcardQueryBoost;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsPhraseQuery</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean ftsPhraseQuery;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsPhraseQuerySlop</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Float ftsPhraseQuerySlop;

	/** <i>Generated property</i> for <code>SearchQueryProperty.ftsPhraseQueryBoost</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Float ftsPhraseQueryBoost;
	
	public SearchQueryProperty()
	{
		// default constructor
	}
	
		
	
	public void setIndexedProperty(final String indexedProperty)
	{
		this.indexedProperty = indexedProperty;
	}

		
	
	public String getIndexedProperty() 
	{
		return indexedProperty;
	}
	
		
	
	public void setFacet(final boolean facet)
	{
		this.facet = facet;
	}

		
	
	public boolean isFacet() 
	{
		return facet;
	}
	
		
	
	public void setFacetType(final FacetType facetType)
	{
		this.facetType = facetType;
	}

		
	
	public FacetType getFacetType() 
	{
		return facetType;
	}
	
		
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

		
	
	public Integer getPriority() 
	{
		return priority;
	}
	
		
	
	public void setIncludeInResponse(final boolean includeInResponse)
	{
		this.includeInResponse = includeInResponse;
	}

		
	
	public boolean isIncludeInResponse() 
	{
		return includeInResponse;
	}
	
		
	
	public void setHighlight(final boolean highlight)
	{
		this.highlight = highlight;
	}

		
	
	public boolean isHighlight() 
	{
		return highlight;
	}
	
		
	
	public void setFacetDisplayNameProvider(final String facetDisplayNameProvider)
	{
		this.facetDisplayNameProvider = facetDisplayNameProvider;
	}

		
	
	public String getFacetDisplayNameProvider() 
	{
		return facetDisplayNameProvider;
	}
	
		
	
	public void setFacetSortProvider(final String facetSortProvider)
	{
		this.facetSortProvider = facetSortProvider;
	}

		
	
	public String getFacetSortProvider() 
	{
		return facetSortProvider;
	}
	
		
	
	public void setFacetTopValuesProvider(final String facetTopValuesProvider)
	{
		this.facetTopValuesProvider = facetTopValuesProvider;
	}

		
	
	public String getFacetTopValuesProvider() 
	{
		return facetTopValuesProvider;
	}
	
		
	
	public void setFtsQuery(final boolean ftsQuery)
	{
		this.ftsQuery = ftsQuery;
	}

		
	
	public boolean isFtsQuery() 
	{
		return ftsQuery;
	}
	
		
	
	public void setFtsQueryMinTermLength(final Integer ftsQueryMinTermLength)
	{
		this.ftsQueryMinTermLength = ftsQueryMinTermLength;
	}

		
	
	public Integer getFtsQueryMinTermLength() 
	{
		return ftsQueryMinTermLength;
	}
	
		
	
	public void setFtsQueryBoost(final Float ftsQueryBoost)
	{
		this.ftsQueryBoost = ftsQueryBoost;
	}

		
	
	public Float getFtsQueryBoost() 
	{
		return ftsQueryBoost;
	}
	
		
	
	public void setFtsFuzzyQuery(final boolean ftsFuzzyQuery)
	{
		this.ftsFuzzyQuery = ftsFuzzyQuery;
	}

		
	
	public boolean isFtsFuzzyQuery() 
	{
		return ftsFuzzyQuery;
	}
	
		
	
	public void setFtsFuzzyQueryMinTermLength(final Integer ftsFuzzyQueryMinTermLength)
	{
		this.ftsFuzzyQueryMinTermLength = ftsFuzzyQueryMinTermLength;
	}

		
	
	public Integer getFtsFuzzyQueryMinTermLength() 
	{
		return ftsFuzzyQueryMinTermLength;
	}
	
		
	
	public void setFtsFuzzyQueryFuzziness(final Integer ftsFuzzyQueryFuzziness)
	{
		this.ftsFuzzyQueryFuzziness = ftsFuzzyQueryFuzziness;
	}

		
	
	public Integer getFtsFuzzyQueryFuzziness() 
	{
		return ftsFuzzyQueryFuzziness;
	}
	
		
	
	public void setFtsFuzzyQueryBoost(final Float ftsFuzzyQueryBoost)
	{
		this.ftsFuzzyQueryBoost = ftsFuzzyQueryBoost;
	}

		
	
	public Float getFtsFuzzyQueryBoost() 
	{
		return ftsFuzzyQueryBoost;
	}
	
		
	
	public void setFtsWildcardQuery(final boolean ftsWildcardQuery)
	{
		this.ftsWildcardQuery = ftsWildcardQuery;
	}

		
	
	public boolean isFtsWildcardQuery() 
	{
		return ftsWildcardQuery;
	}
	
		
	
	public void setFtsWildcardQueryMinTermLength(final Integer ftsWildcardQueryMinTermLength)
	{
		this.ftsWildcardQueryMinTermLength = ftsWildcardQueryMinTermLength;
	}

		
	
	public Integer getFtsWildcardQueryMinTermLength() 
	{
		return ftsWildcardQueryMinTermLength;
	}
	
		
	
	public void setFtsWildcardQueryType(final WildcardType ftsWildcardQueryType)
	{
		this.ftsWildcardQueryType = ftsWildcardQueryType;
	}

		
	
	public WildcardType getFtsWildcardQueryType() 
	{
		return ftsWildcardQueryType;
	}
	
		
	
	public void setFtsWildcardQueryBoost(final Float ftsWildcardQueryBoost)
	{
		this.ftsWildcardQueryBoost = ftsWildcardQueryBoost;
	}

		
	
	public Float getFtsWildcardQueryBoost() 
	{
		return ftsWildcardQueryBoost;
	}
	
		
	
	public void setFtsPhraseQuery(final boolean ftsPhraseQuery)
	{
		this.ftsPhraseQuery = ftsPhraseQuery;
	}

		
	
	public boolean isFtsPhraseQuery() 
	{
		return ftsPhraseQuery;
	}
	
		
	
	public void setFtsPhraseQuerySlop(final Float ftsPhraseQuerySlop)
	{
		this.ftsPhraseQuerySlop = ftsPhraseQuerySlop;
	}

		
	
	public Float getFtsPhraseQuerySlop() 
	{
		return ftsPhraseQuerySlop;
	}
	
		
	
	public void setFtsPhraseQueryBoost(final Float ftsPhraseQueryBoost)
	{
		this.ftsPhraseQueryBoost = ftsPhraseQueryBoost;
	}

		
	
	public Float getFtsPhraseQueryBoost() 
	{
		return ftsPhraseQueryBoost;
	}
	


}
