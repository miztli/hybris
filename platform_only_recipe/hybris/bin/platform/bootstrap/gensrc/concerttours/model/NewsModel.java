/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 3:34:16 PM                     ---
 * ----------------------------------------------------------------
 */
package concerttours.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type News first defined at extension concerttours.
 */
@SuppressWarnings("all")
public class NewsModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "News";
	
	/** <i>Generated constant</i> - Attribute key of <code>News.date</code> attribute defined at extension <code>concerttours</code>. */
	public static final String DATE = "date";
	
	/** <i>Generated constant</i> - Attribute key of <code>News.headline</code> attribute defined at extension <code>concerttours</code>. */
	public static final String HEADLINE = "headline";
	
	/** <i>Generated constant</i> - Attribute key of <code>News.content</code> attribute defined at extension <code>concerttours</code>. */
	public static final String CONTENT = "content";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public NewsModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public NewsModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public NewsModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>News.content</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the content - fuller description of the news item
	 */
	@Accessor(qualifier = "content", type = Accessor.Type.GETTER)
	public String getContent()
	{
		return getPersistenceContext().getPropertyValue(CONTENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>News.date</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the date - date of news item
	 */
	@Accessor(qualifier = "date", type = Accessor.Type.GETTER)
	public Date getDate()
	{
		return getPersistenceContext().getPropertyValue(DATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>News.headline</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the headline - short headline for the news item
	 */
	@Accessor(qualifier = "headline", type = Accessor.Type.GETTER)
	public String getHeadline()
	{
		return getPersistenceContext().getPropertyValue(HEADLINE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>News.content</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the content - fuller description of the news item
	 */
	@Accessor(qualifier = "content", type = Accessor.Type.SETTER)
	public void setContent(final String value)
	{
		getPersistenceContext().setPropertyValue(CONTENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>News.date</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the date - date of news item
	 */
	@Accessor(qualifier = "date", type = Accessor.Type.SETTER)
	public void setDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(DATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>News.headline</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the headline - short headline for the news item
	 */
	@Accessor(qualifier = "headline", type = Accessor.Type.SETTER)
	public void setHeadline(final String value)
	{
		getPersistenceContext().setPropertyValue(HEADLINE, value);
	}
	
}
