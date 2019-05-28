/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
import java.util.List;

public  class DocumentData<SEARCH_QUERY_TYPE, DOCUMENT_TYPE>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DocumentData<SEARCH_QUERY_TYPE, DOCUMENT_TYPE>.searchQuery</code> property defined at extension <code>commerceservices</code>. */
		
	private SEARCH_QUERY_TYPE searchQuery;

	/** <i>Generated property</i> for <code>DocumentData<SEARCH_QUERY_TYPE, DOCUMENT_TYPE>.document</code> property defined at extension <code>commerceservices</code>. */
		
	private DOCUMENT_TYPE document;

	/** <i>Generated property</i> for <code>DocumentData<SEARCH_QUERY_TYPE, DOCUMENT_TYPE>.variants</code> property defined at extension <code>commerceservices</code>. */
		
	private List<DOCUMENT_TYPE> variants;
	
	public DocumentData()
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
	
		
	
	public void setDocument(final DOCUMENT_TYPE document)
	{
		this.document = document;
	}

		
	
	public DOCUMENT_TYPE getDocument() 
	{
		return document;
	}
	
		
	
	public void setVariants(final List<DOCUMENT_TYPE> variants)
	{
		this.variants = variants;
	}

		
	
	public List<DOCUMENT_TYPE> getVariants() 
	{
		return variants;
	}
	


}
