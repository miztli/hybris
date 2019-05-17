/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 17, 2019 3:23:33 PM                     ---
 * ----------------------------------------------------------------
 */
package concerttours.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.variants.jalo.VariantProduct;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type Concert.
 */
@SLDSafe
@SuppressWarnings({"unused","cast","PMD"})
public class Concert extends VariantProduct
{
	/** Qualifier of the <code>Concert.venue</code> attribute **/
	public static final String VENUE = "venue";
	/** Qualifier of the <code>Concert.date</code> attribute **/
	public static final String DATE = "date";
	/** Qualifier of the <code>Concert.concertType</code> attribute **/
	public static final String CONCERTTYPE = "concertType";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(VariantProduct.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(VENUE, AttributeMode.INITIAL);
		tmp.put(DATE, AttributeMode.INITIAL);
		tmp.put(CONCERTTYPE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.concertType</code> attribute.
	 * @return the concertType - type of concert (indoors or open air)
	 */
	public EnumerationValue getConcertType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, "concertType".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.concertType</code> attribute.
	 * @return the concertType - type of concert (indoors or open air)
	 */
	public EnumerationValue getConcertType()
	{
		return getConcertType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Concert.concertType</code> attribute. 
	 * @param value the concertType - type of concert (indoors or open air)
	 */
	public void setConcertType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, "concertType".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Concert.concertType</code> attribute. 
	 * @param value the concertType - type of concert (indoors or open air)
	 */
	public void setConcertType(final EnumerationValue value)
	{
		setConcertType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.date</code> attribute.
	 * @return the date - date of concert
	 */
	public Date getDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, "date".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.date</code> attribute.
	 * @return the date - date of concert
	 */
	public Date getDate()
	{
		return getDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Concert.date</code> attribute. 
	 * @param value the date - date of concert
	 */
	public void setDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, "date".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Concert.date</code> attribute. 
	 * @param value the date - date of concert
	 */
	public void setDate(final Date value)
	{
		setDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.venue</code> attribute.
	 * @return the venue - venue of concert
	 */
	public String getVenue(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "venue".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Concert.venue</code> attribute.
	 * @return the venue - venue of concert
	 */
	public String getVenue()
	{
		return getVenue( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Concert.venue</code> attribute. 
	 * @param value the venue - venue of concert
	 */
	public void setVenue(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "venue".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Concert.venue</code> attribute. 
	 * @param value the venue - venue of concert
	 */
	public void setVenue(final String value)
	{
		setVenue( getSession().getSessionContext(), value );
	}
	
}
