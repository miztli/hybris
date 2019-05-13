// Hybris123SnippetStart concerttours.events.BandAlbumSalesEvent
package concerttours.events;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;
 
public class BandAlbumSalesEvent extends AbstractEvent
{
    private final String code;
    private final String name;
    private final Long sales;
    public BandAlbumSalesEvent(final String code, final String name, final Long sales)
    {
        super();
        this.code = code;
        this.name = name;
        this.sales = sales;
    }
    public String getCode()
    {
        return code;
    }
    public String getName()
    {
        return name;
    }
    public Long getSales()
    {
        return sales;
    }
    @Override
    public String toString()
    {
        return this.name;
    }
}
//Hybris123SnippetEnd