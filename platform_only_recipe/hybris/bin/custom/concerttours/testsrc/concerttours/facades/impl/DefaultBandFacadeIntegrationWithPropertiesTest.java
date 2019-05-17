package concerttours.facades.impl;
import static org.junit.Assert.assertTrue;
import java.util.List;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import javax.annotation.Resource;
import org.junit.Test;
import concerttours.data.BandData;
import concerttours.facades.BandFacade;

@IntegrationTest
public class DefaultBandFacadeIntegrationWithPropertiesTest extends ServicelayerTransactionalTest
{
  @Resource
  private BandFacade bandFacade;
    
    @Test
    public void testProperties() throws Exception
    {
        createCoreData();
        importCsv("/impex/essentialdata-mediaformats.impex", "UTF-8");
        importCsv("/impex/concerttours-bands.impex", "utf-8");
        importCsv("/impex/concerttours-yBandTour.impex", "utf-8");

      List<BandData> bands = bandFacade.getBands();
      assertTrue(bands.size() > 0); 
      assertTrue( DefaultBandFacade.BAND_LIST_FORMAT.equals("band.list.format.name"));
    }
}
