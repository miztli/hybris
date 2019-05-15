package concerttours.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum ConcertType declared at extension concerttours.
 */
@SuppressWarnings("PMD")
public enum ConcertType implements HybrisEnumValue
{
	/**
	 * Generated enum value for ConcertType.openair declared at extension concerttours.
	 */
	OPENAIR("openair"),
	/**
	 * Generated enum value for ConcertType.indoor declared at extension concerttours.
	 */
	INDOOR("indoor");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "ConcertType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "ConcertType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private ConcertType(final String code)
	{
		this.code = code.intern();
	}
	
	
	/**
	 * Gets the code of this enum value.
	 *  
	 * @return code of value
	 */
	@Override
	public String getCode()
	{
		return this.code;
	}
	
	/**
	 * Gets the type this enum value belongs to.
	 *  
	 * @return code of type
	 */
	@Override
	public String getType()
	{
		return SIMPLE_CLASSNAME;
	}
	
}
