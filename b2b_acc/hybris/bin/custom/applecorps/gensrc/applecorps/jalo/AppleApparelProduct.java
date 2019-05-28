/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 28, 2019 3:18:54 PM                     ---
 * ----------------------------------------------------------------
 */
package applecorps.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.yacceleratorcore.jalo.ApparelProduct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type AppleApparelProduct.
 */
@SLDSafe
@SuppressWarnings({"unused","cast","PMD"})
public class AppleApparelProduct extends ApparelProduct
{
	/** Qualifier of the <code>AppleApparelProduct.customSummary</code> attribute **/
	public static final String CUSTOMSUMMARY = "customSummary";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(ApparelProduct.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CUSTOMSUMMARY, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AppleApparelProduct.customSummary</code> attribute.
	 * @return the customSummary - Add a custom String Value
	 */
	public String getCustomSummary(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "customSummary".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AppleApparelProduct.customSummary</code> attribute.
	 * @return the customSummary - Add a custom String Value
	 */
	public String getCustomSummary()
	{
		return getCustomSummary( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AppleApparelProduct.customSummary</code> attribute. 
	 * @param value the customSummary - Add a custom String Value
	 */
	public void setCustomSummary(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "customSummary".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AppleApparelProduct.customSummary</code> attribute. 
	 * @param value the customSummary - Add a custom String Value
	 */
	public void setCustomSummary(final String value)
	{
		setCustomSummary( getSession().getSessionContext(), value );
	}
	
}
