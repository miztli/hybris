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
package de.hybris.platform.catalog.daos;

import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.Collection;


/**
 * The {@link CatalogModel} DAO.
 * 
 * @spring.bean catalogDao
 */
public interface CatalogDao extends GenericDao<CatalogModel>
{
	/**
	 * Returns {@link CatalogModel} with the given id.
	 * 
	 * @param id
	 *           catalog id
	 * @return Matching {@link CatalogModel}
	 * @throws IllegalArgumentException
	 *            if id was null.
	 * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException
	 *            if no {@link CatalogModel} with the given id could be found.
	 */
	CatalogModel findCatalogById(String id);

	/**
	 * Return all {@link CatalogModel}s sorted in ascending order by {@link CatalogModel#ID}.
	 * 
	 * 
	 * @return {@link Collection} of {@link CatalogModel}s or empty collection.
	 */
	Collection<CatalogModel> findAllCatalogs();

	/**
	 * Returns a collection of {@link CatalogModel}s with the current default {@link CatalogModel} of the system (one
	 * element).
	 * 
	 * @return an empty collection if no default catalog is set in the system.
	 */
	Collection<CatalogModel> findDefaultCatalogs();



}
