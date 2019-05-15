package concerttours.facades.impl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import concerttours.data.BandData;
import concerttours.facades.BandFacade;
import concerttours.model.BandModel;
 
/**
 * This test file tests and demonstrates the behavior of the BandFacade's methods getAllBands and getBand.
 */
@IntegrationTest
public class DefaultBandFacadeIntegrationTest extends ServicelayerTransactionalTest
{
    @Resource
    private BandFacade bandFacade;
    @Resource
    private ModelService modelService;
    /** Test band */
    private BandModel bandModel;
    /** Name of test band. */
    private static final String BAND_CODE = "101-JAZ";
    /** Name of test band. */
    private static final String BAND_NAME = "Tight Notes";
    /** History of test band. */
    private static final String BAND_HISTORY = "New contemporary, 7-piece Jaz unit from London, formed in 2015";
    /** Albums sold by test band. */
    private static final Long ALBUMS_SOLD = Long.valueOf(10L);
    @Before
    public void setUp()
    {
        // This instance of a BandModel will be used by the tests
        bandModel = modelService.create(BandModel.class); 
        bandModel.setCode(BAND_CODE);
        bandModel.setName(BAND_NAME);      
        
        bandModel.setHistory(BAND_HISTORY);
        bandModel.setAlbumSales(ALBUMS_SOLD);
    }
    /**
     * Tests exception behavior by getting a band which doesn't exist
     */
    @Test(expected = UnknownIdentifierException.class)
    public void testInvalidParameter()
    {
        bandFacade.getBand(BAND_NAME);
    }
    /**
     * Tests exception behavior by passing in a null parameter
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullParameter()
    {
        bandFacade.getBand(null);
    }
    /**
     * Tests and demonstrates the Facade's methods
     */
    @Test
    public void testBandFacade()
    {
        List<BandData> bandListData = bandFacade.getBands();
        assertNotNull(bandListData);
        final int size = bandListData.size();
        modelService.save(bandModel);
        bandListData = bandFacade.getBands();
        assertNotNull(bandListData);
        assertEquals(size + 1, bandListData.size());
        assertEquals(BAND_CODE, bandListData.get(size).getId());
        assertEquals(BAND_NAME, bandListData.get(size).getName());
        assertEquals(ALBUMS_SOLD, bandListData.get(size).getAlbumsSold());
        assertEquals(BAND_HISTORY, bandListData.get(size).getDescription());
        final BandData persistedBandData = bandFacade.getBand(BAND_CODE);
        assertNotNull(persistedBandData);
        assertEquals(BAND_CODE, persistedBandData.getId());
        assertEquals(BAND_NAME, persistedBandData.getName());
        assertEquals(ALBUMS_SOLD, persistedBandData.getAlbumsSold());
        assertEquals(BAND_HISTORY, persistedBandData.getDescription());
    }
}
