package concerttours.attributehandlers;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import concerttours.model.ConcertModel;
import de.hybris.bootstrap.annotations.UnitTest;

@UnitTest
public class ConcertDaysUntilAttributeHandlerUnitTest
{
    @Test
    public void testGetFutureConcertDate() throws Exception
    {
        final ConcertModel concert = new ConcertModel();
        final ConcertDaysUntilAttributeHandler handler = new ConcertDaysUntilAttributeHandler();
        final Date futureDate = new Date(new Date().getTime() + 49 * 60 * 60 * 1000);
        concert.setDate(futureDate);
        Assert.assertEquals("Wrong value for concert in the future", 2L, handler.get(concert).longValue());
    }
    @Test
    public void testGetNullConcertDate()
    {
        final ConcertModel concert = new ConcertModel();
        final ConcertDaysUntilAttributeHandler handler = new ConcertDaysUntilAttributeHandler();
        Assert.assertNull(handler.get(concert));
    }
    @Test
    public void testGetPastConcertDate() throws Exception
    {
        final ConcertModel concert = new ConcertModel();
        final ConcertDaysUntilAttributeHandler handler = new ConcertDaysUntilAttributeHandler();
        final Date futureDate = new Date(new Date().getTime() - 24 * 60 * 60 * 1000);
        concert.setDate(futureDate);
        Assert.assertEquals("Wrong value for concert in the past", 0L, handler.get(concert).longValue());
    }
}
