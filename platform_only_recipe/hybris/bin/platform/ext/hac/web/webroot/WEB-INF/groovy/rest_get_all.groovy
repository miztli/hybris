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
import de.hybris.platform.core.*
import de.hybris.platform.genericsearch.*


//return error message in case typecode does not exist
try 
{
	def composedTypeModel = typeService.getComposedTypeForCode(typecode)
}
catch (Exception e)
{
	result = [error:e.message]
	return
}

def query = new GenericQuery(typecode);
def searchQuery = new GenericSearchQuery(query)
def searchResult = genericSearchService.search(searchQuery)

def filteredItems = searchResult.result.collect { item ->
	println "${item}" + "*" * 80
	
	item.properties.each { key, value ->
			println "${key} -> ${value}"
		 
	
	}
}

result = [
				typecode:typecode,
				count: searchResult.count,
				total: searchResult.totalCount,
				offset: searchResult.requestedStart//,
				//items: filteredItems
			]