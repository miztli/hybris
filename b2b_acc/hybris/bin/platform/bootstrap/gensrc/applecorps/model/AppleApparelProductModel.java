/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 28, 2019 3:18:54 PM                     ---
 * ----------------------------------------------------------------
 */
package applecorps.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.yacceleratorcore.model.ApparelProductModel;

/**
 * Generated model class for type AppleApparelProduct first defined at extension applecorps.
 */
@SuppressWarnings("all")
public class AppleApparelProductModel extends ApparelProductModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AppleApparelProduct";
	
	/** <i>Generated constant</i> - Attribute key of <code>AppleApparelProduct.customSummary</code> attribute defined at extension <code>applecorps</code>. */
	public static final String CUSTOMSUMMARY = "customSummary";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AppleApparelProductModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AppleApparelProductModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 */
	@Deprecated
	public AppleApparelProductModel(final CatalogVersionModel _catalogVersion, final String _code)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public AppleApparelProductModel(final CatalogVersionModel _catalogVersion, final String _code, final ItemModel _owner)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AppleApparelProduct.customSummary</code> attribute defined at extension <code>applecorps</code>. 
	 * @return the customSummary - Add a custom String Value
	 */
	@Accessor(qualifier = "customSummary", type = Accessor.Type.GETTER)
	public String getCustomSummary()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMSUMMARY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AppleApparelProduct.customSummary</code> attribute defined at extension <code>applecorps</code>. 
	 *  
	 * @param value the customSummary - Add a custom String Value
	 */
	@Accessor(qualifier = "customSummary", type = Accessor.Type.SETTER)
	public void setCustomSummary(final String value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMSUMMARY, value);
	}
	
}
