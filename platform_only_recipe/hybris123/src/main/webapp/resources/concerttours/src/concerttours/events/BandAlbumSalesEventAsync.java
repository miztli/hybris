// Hybris123SnippetStart concerttours.events.BandAlbumSalesEventAsync
package concerttours.events;
import de.hybris.platform.servicelayer.event.ClusterAwareEvent;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;
 
public class BandAlbumSalesEvent extends AbstractEvent implements ClusterAwareEvent
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
    @Override
    public boolean publish(final int sourceNodeId, final int targetNodeId)
    {
        return (sourceNodeId == targetNodeId);
    }
}
//Hybris123SnippetEnd