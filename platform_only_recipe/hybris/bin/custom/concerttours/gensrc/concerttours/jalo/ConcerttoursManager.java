/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 3:34:16 PM                     ---
 * ----------------------------------------------------------------
 */
package concerttours.jalo;

import concerttours.constants.ConcerttoursConstants;
import concerttours.jalo.Band;
import concerttours.jalo.Concert;
import concerttours.jalo.News;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type <code>ConcerttoursManager</code>.
 */
@SuppressWarnings({"unused","cast","PMD"})
@SLDSafe
public class ConcerttoursManager extends Extension
{
	/** Relation ordering override parameter constants for Band2MusicType from ((concerttours))*/
	protected static String BAND2MUSICTYPE_SRC_ORDERED = "relation.Band2MusicType.source.ordered";
	protected static String BAND2MUSICTYPE_TGT_ORDERED = "relation.Band2MusicType.target.ordered";
	/** Relation disable markmodifed parameter constants for Band2MusicType from ((concerttours))*/
	protected static String BAND2MUSICTYPE_MARKMODIFIED = "relation.Band2MusicType.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("hashtag", AttributeMode.INITIAL);
		tmp.put("band", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.band</code> attribute.
	 * @return the band
	 */
	public Band getBand(final SessionContext ctx, final Product item)
	{
		return (Band)item.getProperty( ctx, ConcerttoursConstants.Attributes.Product.BAND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.band</code> attribute.
	 * @return the band
	 */
	public Band getBand(final Product item)
	{
		return getBand( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.band</code> attribute. 
	 * @param value the band
	 */
	public void setBand(final SessionContext ctx, final Product item, final Band value)
	{
		item.setProperty(ctx, ConcerttoursConstants.Attributes.Product.BAND,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.band</code> attribute. 
	 * @param value the band
	 */
	public void setBand(final Product item, final Band value)
	{
		setBand( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MusicType.bands</code> attribute.
	 * @return the bands
	 */
	public Set<Band> getBands(final SessionContext ctx, final EnumerationValue item)
	{
		final List<Band> items = item.getLinkedItems( 
			ctx,
			false,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			"Band",
			null,
			false,
			false
		);
		return new LinkedHashSet<Band>(items);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MusicType.bands</code> attribute.
	 * @return the bands
	 */
	public Set<Band> getBands(final EnumerationValue item)
	{
		return getBands( getSession().getSessionContext(), item );
	}
	
	public long getBandsCount(final SessionContext ctx, final EnumerationValue item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			"Band",
			null
		);
	}
	
	public long getBandsCount(final EnumerationValue item)
	{
		return getBandsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MusicType.bands</code> attribute. 
	 * @param value the bands
	 */
	public void setBands(final SessionContext ctx, final EnumerationValue item, final Set<Band> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MusicType.bands</code> attribute. 
	 * @param value the bands
	 */
	public void setBands(final EnumerationValue item, final Set<Band> value)
	{
		setBands( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to bands. 
	 * @param value the item to add to bands
	 */
	public void addToBands(final SessionContext ctx, final EnumerationValue item, final Band value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to bands. 
	 * @param value the item to add to bands
	 */
	public void addToBands(final EnumerationValue item, final Band value)
	{
		addToBands( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from bands. 
	 * @param value the item to remove from bands
	 */
	public void removeFromBands(final SessionContext ctx, final EnumerationValue item, final Band value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			ConcerttoursConstants.Relations.BAND2MUSICTYPE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(BAND2MUSICTYPE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from bands. 
	 * @param value the item to remove from bands
	 */
	public void removeFromBands(final EnumerationValue item, final Band value)
	{
		removeFromBands( getSession().getSessionContext(), item, value );
	}
	
	public Band createBand(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("Band");
			return (Band)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Band : "+e.getMessage(), 0 );
		}
	}
	
	public Band createBand(final Map attributeValues)
	{
		return createBand( getSession().getSessionContext(), attributeValues );
	}
	
	public Concert createConcert(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("Concert");
			return (Concert)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Concert : "+e.getMessage(), 0 );
		}
	}
	
	public Concert createConcert(final Map attributeValues)
	{
		return createConcert( getSession().getSessionContext(), attributeValues );
	}
	
	public News createNews(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("News");
			return (News)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating News : "+e.getMessage(), 0 );
		}
	}
	
	public News createNews(final Map attributeValues)
	{
		return createNews( getSession().getSessionContext(), attributeValues );
	}
	
	public static final ConcerttoursManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ConcerttoursManager) em.getExtension(ConcerttoursConstants.EXTENSIONNAME);
	}
	
	@Override
	public String getName()
	{
		return ConcerttoursConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.hashtag</code> attribute.
	 * @return the hashtag - hashtag of concert tour for social media
	 */
	public String getHashtag(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, ConcerttoursConstants.Attributes.Product.HASHTAG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.hashtag</code> attribute.
	 * @return the hashtag - hashtag of concert tour for social media
	 */
	public String getHashtag(final Product item)
	{
		return getHashtag( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.hashtag</code> attribute. 
	 * @param value the hashtag - hashtag of concert tour for social media
	 */
	public void setHashtag(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, ConcerttoursConstants.Attributes.Product.HASHTAG,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.hashtag</code> attribute. 
	 * @param value the hashtag - hashtag of concert tour for social media
	 */
	public void setHashtag(final Product item, final String value)
	{
		setHashtag( getSession().getSessionContext(), item, value );
	}
	
}
