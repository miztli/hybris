package concerttours.attributehandlers;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import concerttours.model.ConcertModel;
 
@IntegrationTest
public class ConcertDaysUntilAttributeHandlerIntegrationTest extends ServicelayerTransactionalTest
{
    @Resource
    private ModelService modelService;
    @Test
    public void testGetFutureConcertDate() throws Exception
    {
        final ConcertModel concert = modelService.create(ConcertModel.class);
        final Date futureDate = new Date(new Date().getTime() + 49 * 60 * 60 * 1000);
        concert.setDate(futureDate);
        Assert.assertEquals("Wrong value for concert in the future: " + concert.getDaysUntil().longValue(), 2L, concert.getDaysUntil().longValue());
    }
    @Test
    public void testGetNullConcertDate()
    {
        final ConcertModel concert = modelService.create(ConcertModel.class);
        Assert.assertNull("No concert date does not return null: "+ concert.getDaysUntil(), concert.getDaysUntil());
    }
    @Test
    public void testGetPastConcertDate() throws Exception
    {
        final ConcertModel concert = modelService.create(ConcertModel.class);
        final Date pastDate = new Date(new Date().getTime() - 24 * 60 * 60 * 1000);
        concert.setDate(pastDate);
        Assert.assertEquals("Wrong value for concert in the past: "+concert.getDaysUntil().longValue(), 0L, concert.getDaysUntil().longValue());
    }
}
