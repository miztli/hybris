/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 15, 2019 12:54:02 PM                    ---
 * ----------------------------------------------------------------
 */
package concerttours.model;

import concerttours.enums.ConcertType;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.variants.model.VariantProductModel;
import java.util.Date;

/**
 * Generated model class for type Concert first defined at extension concerttours.
 */
@SuppressWarnings("all")
public class ConcertModel extends VariantProductModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Concert";
	
	/** <i>Generated constant</i> - Attribute key of <code>Concert.venue</code> attribute defined at extension <code>concerttours</code>. */
	public static final String VENUE = "venue";
	
	/** <i>Generated constant</i> - Attribute key of <code>Concert.date</code> attribute defined at extension <code>concerttours</code>. */
	public static final String DATE = "date";
	
	/** <i>Generated constant</i> - Attribute key of <code>Concert.concertType</code> attribute defined at extension <code>concerttours</code>. */
	public static final String CONCERTTYPE = "concertType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConcertModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConcertModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseProduct initial attribute declared by type <code>VariantProduct</code> at extension <code>catalog</code>
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 */
	@Deprecated
	public ConcertModel(final ProductModel _baseProduct, final CatalogVersionModel _catalogVersion, final String _code)
	{
		super();
		setBaseProduct(_baseProduct);
		setCatalogVersion(_catalogVersion);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseProduct initial attribute declared by type <code>VariantProduct</code> at extension <code>catalog</code>
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public ConcertModel(final ProductModel _baseProduct, final CatalogVersionModel _catalogVersion, final String _code, final ItemModel _owner)
	{
		super();
		setBaseProduct(_baseProduct);
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.concertType</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the concertType - type of concert (indoors or open air)
	 */
	@Accessor(qualifier = "concertType", type = Accessor.Type.GETTER)
	public ConcertType getConcertType()
	{
		return getPersistenceContext().getPropertyValue(CONCERTTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.date</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the date - date of concert
	 */
	@Accessor(qualifier = "date", type = Accessor.Type.GETTER)
	public Date getDate()
	{
		return getPersistenceContext().getPropertyValue(DATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.venue</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the venue - venue of concert
	 */
	@Accessor(qualifier = "venue", type = Accessor.Type.GETTER)
	public String getVenue()
	{
		return getPersistenceContext().getPropertyValue(VENUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Concert.concertType</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the concertType - type of concert (indoors or open air)
	 */
	@Accessor(qualifier = "concertType", type = Accessor.Type.SETTER)
	public void setConcertType(final ConcertType value)
	{
		getPersistenceContext().setPropertyValue(CONCERTTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Concert.date</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the date - date of concert
	 */
	@Accessor(qualifier = "date", type = Accessor.Type.SETTER)
	public void setDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(DATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Concert.venue</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the venue - venue of concert
	 */
	@Accessor(qualifier = "venue", type = Accessor.Type.SETTER)
	public void setVenue(final String value)
	{
		getPersistenceContext().setPropertyValue(VENUE, value);
	}
	
}
