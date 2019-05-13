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
package de.hybris.platform.commerceservices.search.solrfacetsearch.data;

import java.io.Serializable;

public  class SolrDocumentData<SEARCH_QUERY_TYPE, SOLR_DOCUMENT_TYPE>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SolrDocumentData<SEARCH_QUERY_TYPE, SOLR_DOCUMENT_TYPE>.searchQuery</code> property defined at extension <code>commerceservices</code>. */
		
	private SEARCH_QUERY_TYPE searchQuery;

	/** <i>Generated property</i> for <code>SolrDocumentData<SEARCH_QUERY_TYPE, SOLR_DOCUMENT_TYPE>.solrDocument</code> property defined at extension <code>commerceservices</code>. */
		
	private SOLR_DOCUMENT_TYPE solrDocument;
	
	public SolrDocumentData()
	{
		// default constructor
	}
	
		
	
	public void setSearchQuery(final SEARCH_QUERY_TYPE searchQuery)
	{
		this.searchQuery = searchQuery;
	}

		
	
	public SEARCH_QUERY_TYPE getSearchQuery() 
	{
		return searchQuery;
	}
	
		
	
	public void setSolrDocument(final SOLR_DOCUMENT_TYPE solrDocument)
	{
		this.solrDocument = solrDocument;
	}

		
	
	public SOLR_DOCUMENT_TYPE getSolrDocument() 
	{
		return solrDocument;
	}
	


}
