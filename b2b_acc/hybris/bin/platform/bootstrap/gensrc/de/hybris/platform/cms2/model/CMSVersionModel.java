/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 27, 2019 5:14:19 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.cms2.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.processing.CMSVersionGCProcessModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.List;

/**
 * Generated model class for type CMSVersion first defined at extension cms2.
 */
@SuppressWarnings("all")
public class CMSVersionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CMSVersion";
	
	/**<i>Generated relation code constant for relation <code>CMSVersion2CMSVersion</code> defining source attribute <code>relatedParents</code> in extension <code>cms2</code>.</i>*/
	public static final String _CMSVERSION2CMSVERSION = "CMSVersion2CMSVersion";
	
	/**<i>Generated relation code constant for relation <code>CMSVersionGCProcess2CMSVersion</code> defining source attribute <code>cmsVersionGCProcesses</code> in extension <code>cms2</code>.</i>*/
	public static final String _CMSVERSIONGCPROCESS2CMSVERSION = "CMSVersionGCProcess2CMSVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.uid</code> attribute defined at extension <code>cms2</code>. */
	public static final String UID = "uid";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.transactionId</code> attribute defined at extension <code>cms2</code>. */
	public static final String TRANSACTIONID = "transactionId";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.itemUid</code> attribute defined at extension <code>cms2</code>. */
	public static final String ITEMUID = "itemUid";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.itemTypeCode</code> attribute defined at extension <code>cms2</code>. */
	public static final String ITEMTYPECODE = "itemTypeCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.itemCatalogVersion</code> attribute defined at extension <code>cms2</code>. */
	public static final String ITEMCATALOGVERSION = "itemCatalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.label</code> attribute defined at extension <code>cms2</code>. */
	public static final String LABEL = "label";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.description</code> attribute defined at extension <code>cms2</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.retain</code> attribute defined at extension <code>cms2</code>. */
	public static final String RETAIN = "retain";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.payload</code> attribute defined at extension <code>cms2</code>. */
	public static final String PAYLOAD = "payload";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.relatedParents</code> attribute defined at extension <code>cms2</code>. */
	public static final String RELATEDPARENTS = "relatedParents";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.relatedChildren</code> attribute defined at extension <code>cms2</code>. */
	public static final String RELATEDCHILDREN = "relatedChildren";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSVersion.cmsVersionGCProcesses</code> attribute defined at extension <code>cms2</code>. */
	public static final String CMSVERSIONGCPROCESSES = "cmsVersionGCProcesses";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CMSVersionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CMSVersionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _uid initial attribute declared by type <code>CMSVersion</code> at extension <code>cms2</code>
	 */
	@Deprecated
	public CMSVersionModel(final String _uid)
	{
		super();
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>CMSVersion</code> at extension <code>cms2</code>
	 */
	@Deprecated
	public CMSVersionModel(final ItemModel _owner, final String _uid)
	{
		super();
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.cmsVersionGCProcesses</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the cmsVersionGCProcesses
	 */
	@Accessor(qualifier = "cmsVersionGCProcesses", type = Accessor.Type.GETTER)
	public Collection<CMSVersionGCProcessModel> getCmsVersionGCProcesses()
	{
		return getPersistenceContext().getPropertyValue(CMSVERSIONGCPROCESSES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.description</code> attribute defined at extension <code>cms2</code>. 
	 * @return the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.itemCatalogVersion</code> attribute defined at extension <code>cms2</code>. 
	 * @return the itemCatalogVersion
	 */
	@Accessor(qualifier = "itemCatalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getItemCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(ITEMCATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.itemTypeCode</code> attribute defined at extension <code>cms2</code>. 
	 * @return the itemTypeCode
	 */
	@Accessor(qualifier = "itemTypeCode", type = Accessor.Type.GETTER)
	public String getItemTypeCode()
	{
		return getPersistenceContext().getPropertyValue(ITEMTYPECODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.itemUid</code> attribute defined at extension <code>cms2</code>. 
	 * @return the itemUid
	 */
	@Accessor(qualifier = "itemUid", type = Accessor.Type.GETTER)
	public String getItemUid()
	{
		return getPersistenceContext().getPropertyValue(ITEMUID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.label</code> attribute defined at extension <code>cms2</code>. 
	 * @return the label
	 */
	@Accessor(qualifier = "label", type = Accessor.Type.GETTER)
	public String getLabel()
	{
		return getPersistenceContext().getPropertyValue(LABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.payload</code> attribute defined at extension <code>cms2</code>. 
	 * @return the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.GETTER)
	public String getPayload()
	{
		return getPersistenceContext().getPropertyValue(PAYLOAD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.relatedChildren</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the relatedChildren
	 */
	@Accessor(qualifier = "relatedChildren", type = Accessor.Type.GETTER)
	public List<CMSVersionModel> getRelatedChildren()
	{
		return getPersistenceContext().getPropertyValue(RELATEDCHILDREN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.relatedParents</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the relatedParents
	 */
	@Accessor(qualifier = "relatedParents", type = Accessor.Type.GETTER)
	public Collection<CMSVersionModel> getRelatedParents()
	{
		return getPersistenceContext().getPropertyValue(RELATEDPARENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.retain</code> attribute defined at extension <code>cms2</code>. 
	 * @return the retain
	 */
	@Accessor(qualifier = "retain", type = Accessor.Type.GETTER)
	public Boolean getRetain()
	{
		return getPersistenceContext().getPropertyValue(RETAIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.transactionId</code> attribute defined at extension <code>cms2</code>. 
	 * @return the transactionId - Used internally to identify all the versions created in a single transaction
	 */
	@Accessor(qualifier = "transactionId", type = Accessor.Type.GETTER)
	public String getTransactionId()
	{
		return getPersistenceContext().getPropertyValue(TRANSACTIONID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSVersion.uid</code> attribute defined at extension <code>cms2</code>. 
	 * @return the uid - Used to uniquely identify a version across all items
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.GETTER)
	public String getUid()
	{
		return getPersistenceContext().getPropertyValue(UID);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.cmsVersionGCProcesses</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the cmsVersionGCProcesses
	 */
	@Accessor(qualifier = "cmsVersionGCProcesses", type = Accessor.Type.SETTER)
	public void setCmsVersionGCProcesses(final Collection<CMSVersionGCProcessModel> value)
	{
		getPersistenceContext().setPropertyValue(CMSVERSIONGCPROCESSES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.description</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.itemCatalogVersion</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the itemCatalogVersion
	 */
	@Accessor(qualifier = "itemCatalogVersion", type = Accessor.Type.SETTER)
	public void setItemCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(ITEMCATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.itemTypeCode</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the itemTypeCode
	 */
	@Accessor(qualifier = "itemTypeCode", type = Accessor.Type.SETTER)
	public void setItemTypeCode(final String value)
	{
		getPersistenceContext().setPropertyValue(ITEMTYPECODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.itemUid</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the itemUid
	 */
	@Accessor(qualifier = "itemUid", type = Accessor.Type.SETTER)
	public void setItemUid(final String value)
	{
		getPersistenceContext().setPropertyValue(ITEMUID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.label</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the label
	 */
	@Accessor(qualifier = "label", type = Accessor.Type.SETTER)
	public void setLabel(final String value)
	{
		getPersistenceContext().setPropertyValue(LABEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.payload</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.SETTER)
	public void setPayload(final String value)
	{
		getPersistenceContext().setPropertyValue(PAYLOAD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.relatedChildren</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the relatedChildren
	 */
	@Accessor(qualifier = "relatedChildren", type = Accessor.Type.SETTER)
	public void setRelatedChildren(final List<CMSVersionModel> value)
	{
		getPersistenceContext().setPropertyValue(RELATEDCHILDREN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.relatedParents</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the relatedParents
	 */
	@Accessor(qualifier = "relatedParents", type = Accessor.Type.SETTER)
	public void setRelatedParents(final Collection<CMSVersionModel> value)
	{
		getPersistenceContext().setPropertyValue(RELATEDPARENTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.retain</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the retain
	 */
	@Accessor(qualifier = "retain", type = Accessor.Type.SETTER)
	public void setRetain(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(RETAIN, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.transactionId</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the transactionId - Used internally to identify all the versions created in a single transaction
	 */
	@Accessor(qualifier = "transactionId", type = Accessor.Type.SETTER)
	public void setTransactionId(final String value)
	{
		getPersistenceContext().setPropertyValue(TRANSACTIONID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSVersion.uid</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the uid - Used to uniquely identify a version across all items
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.SETTER)
	public void setUid(final String value)
	{
		getPersistenceContext().setPropertyValue(UID, value);
	}
	
}
