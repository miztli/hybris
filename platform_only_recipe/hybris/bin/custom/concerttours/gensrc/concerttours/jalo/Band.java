/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 15, 2019 4:48:58 PM                     ---
 * ----------------------------------------------------------------
 */
package concerttours.jalo;

import concerttours.constants.ConcerttoursConstants;
import de.hybris.platform.constants.CoreConstants;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.util.OneToManyHandler;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type Band.
 */
@SLDSafe
@SuppressWarnings({"unused","cast","PMD"})
public class Band extends GenericItem
{
	/** Qualifier of the <code>Band.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Band.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>Band.history</code> attribute **/
	public static final String HISTORY = "history";
	/** Qualifier of the <code>Band.albumSales</code> attribute **/
	public static final String ALBUMSALES = "albumSales";
	/** Qualifier of the <code>Band.tours</code> attribute **/
	public static final String TOURS = "tours";
	/** Qualifier of the <code>Band.types</code> attribute **/
	public static final String TYPES = "types";
	/** Relation ordering override parameter constants for Band2MusicType from ((concerttours))*/
	protected static String BAND2MUSICTYPE_SRC_ORDERED = "relation.Band2MusicType.source.ordered";
	protected static String BAND2MUSICTYPE_TGT_ORDERED = "relation.Band2MusicType.target.ordered";
	/** Relation disable markmodifed parameter constants for Band2MusicType from ((concerttours))*/
	protected static String BAND2MUSICTYPE_MARKMODIFIED = "relation.Band2MusicType.markmodified";
	/**
	* {@link OneToManyHandler} for handling 1:n TOURS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<Product> TOURSHANDLER = new OneToManyHandler<Product>(
	CoreConstants.TC.PRODUCT,
	false,
	"band",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(HISTORY, AttributeMode.INITIAL);
		tmp.put(ALBUMSALES, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.albumSales</code> attribute.
	 * @return the albumSales - official global album sales
	 */
	public Long getAlbumSales(final SessionContext ctx)
	{
		return (Long)getProperty( ctx, "albumSales".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.albumSales</code> attribute.
	 * @return the albumSales - official global album sales
	 */
	public Long getAlbumSales()
	{
		return getAlbumSales( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.albumSales</code> attribute. 
	 * @return the albumSales - official global album sales
	 */
	public long getAlbumSalesAsPrimitive(final SessionContext ctx)
	{
		Long value = getAlbumSales( ctx );
		return value != null ? value.longValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.albumSales</code> attribute. 
	 * @return the albumSales - official global album sales
	 */
	public long getAlbumSalesAsPrimitive()
	{
		return getAlbumSalesAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.albumSales</code> attribute. 
	 * @param value the albumSales - official global album sales
	 */
	public void setAlbumSales(final SessionContext ctx, final Long value)
	{
		setProperty(ctx, "albumSales".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.albumSales</code> attribute. 
	 * @param value the albumSales - official global album sales
	 */
	public void setAlbumSales(final Long value)
	{
		setAlbumSales( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.albumSales</code> attribute. 
	 * @param value the albumSales - official global album sales
	 */
	public void setAlbumSales(final SessionContext ctx, final long value)
	{
		setAlbumSales( ctx,Long.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.albumSales</code> attribute. 
	 * @param value the albumSales - official global album sales
	 */
	public void setAlbumSales(final long value)
	{
		setAlbumSales( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.code</code> attribute.
	 * @return the code - short unique code of band
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "code".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.code</code> attribute.
	 * @return the code - short unique code of band
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.code</code> attribute. 
	 * @param value the code - short unique code of band
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "code".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.code</code> attribute. 
	 * @param value the code - short unique code of band
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.history</code> attribute.
	 * @return the history - history of band
	 */
	public String getHistory(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "history".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.history</code> attribute.
	 * @return the history - history of band
	 */
	public String getHistory()
	{
		return getHistory( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.history</code> attribute. 
	 * @param value the history - history of band
	 */
	public void setHistory(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "history".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.history</code> attribute. 
	 * @param value the history - history of band
	 */
	public void setHistory(final String value)
	{
		setHistory( getSession().getSessionContext(), value );
	}
	
	@Override
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("MusicType");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.name</code> attribute.
	 * @return the name - name of band
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "name".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.name</code> attribute.
	 * @return the name - name of band
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.name</code> attribute. 
	 * @param value the name - name of band
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "name".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.name</code> attribute. 
	 * @param value the name - name of band
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.tours</code> attribute.
	 * @return the tours
	 */
	public Set<Product> getTours(final SessionContext ctx)
	{
		return (Set<Product>)TOURSHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.tours</code> attribute.
	 * @return the tours
	 */
	public Set<Product> getTours()
	{
		return getTours( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.tours</code> attribute. 
	 * @param value the tours
	 */
	public void setTours(final SessionContext ctx, final Set<Product> value)
	{
		TOURSHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.tours</code> attribute. 
	 * @param value the tours
	 */
	public void setTours(final Set<Product> value)
	{
		setTours( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to tours. 
	 * @param value the item to add to tours
	 */
	public void addToTours(final SessionContext ctx, final Product value)
	{
		TOURSHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to tours. 
	 * @param value the item to add to tours
	 */
	public void addToTours(final Product value)
	{
		addToTours( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from tours. 
	 * @param value the item to remove from tours
	 */
	public void removeFromTours(final SessionContext ctx, final Product value)
	{
		TOURSHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from tours. 
	 * @param value the item to remove from tours
	 */
	public void removeFromTours(final Product value)
	{
		removeFromTours( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.types</code> attribute.
	 * @return the types
	 */
	public Collection<EnumerationValue> getTypes(final SessionContext ctx)
	{
		final List<EnumerationValue> items = getLinkedItems( 
			ctx,
			true,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			"MusicType",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Band.types</code> attribute.
	 * @return the types
	 */
	public Collection<EnumerationValue> getTypes()
	{
		return getTypes( getSession().getSessionContext() );
	}
	
	public long getTypesCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			"MusicType",
			null
		);
	}
	
	public long getTypesCount()
	{
		return getTypesCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.types</code> attribute. 
	 * @param value the types
	 */
	public void setTypes(final SessionContext ctx, final Collection<EnumerationValue> value)
	{
		setLinkedItems( 
			ctx,
			true,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Band.types</code> attribute. 
	 * @param value the types
	 */
	public void setTypes(final Collection<EnumerationValue> value)
	{
		setTypes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to types. 
	 * @param value the item to add to types
	 */
	public void addToTypes(final SessionContext ctx, final EnumerationValue value)
	{
		addLinkedItems( 
			ctx,
			true,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to types. 
	 * @param value the item to add to types
	 */
	public void addToTypes(final EnumerationValue value)
	{
		addToTypes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from types. 
	 * @param value the item to remove from types
	 */
	public void removeFromTypes(final SessionContext ctx, final EnumerationValue value)
	{
		removeLinkedItems( 
			ctx,
			true,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from types. 
	 * @param value the item to remove from types
	 */
	public void removeFromTypes(final EnumerationValue value)
	{
		removeFromTypes( getSession().getSessionContext(), value );
	}
	
}
