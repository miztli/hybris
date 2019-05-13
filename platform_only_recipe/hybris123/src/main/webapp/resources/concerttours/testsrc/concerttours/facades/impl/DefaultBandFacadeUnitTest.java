// Hybris123SnippetStart concerttours.facades.impl.DefaultBandFacadeUnitTest

package concerttours.facades.impl;
 
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import de.hybris.bootstrap.annotations.UnitTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import concerttours.data.BandData;
import concerttours.model.BandModel;
import concerttours.service.BandService;
 
@UnitTest
public class DefaultBandFacadeUnitTest 
{
    private DefaultBandFacade bandFacade;
    private BandService bandService;
    private static final String BAND_CODE = "ROCK-11";
    private static final String BAND_NAME = "Ladies of Rock";
    private static final Long ALBUMS_SOLD = Long.valueOf(42000l);
    private static final String BAND_HISTORY = "All female rock band formed in Munich in the late 1990s";
    // Convenience method for returning a list of Band
    private List<BandModel> dummyDataBandList()
    {
        final List<BandModel> bands = new ArrayList<BandModel>();
        final BandModel band = configTestBand();
        bands.add(band);
        return bands;
    }
    // Convenience method for returning the configured test band
    private BandModel configTestBand()
    {
        final BandModel band = new BandModel();
        band.setCode(BAND_CODE);
        band.setName(BAND_NAME);
        band.setAlbumSales(ALBUMS_SOLD);
        band.setHistory(BAND_HISTORY);
        return band;
    }
    @Before
    public void setUp()
    {
        // We will be testing the POJO DefaultBandFacade - the implementation of the BandFacade interface.
        bandFacade = new DefaultBandFacade();
        bandService = mock(BandService.class);
        // We then wire this service into the BandFacade implementation.
        bandFacade.setBandService(bandService);
    }
    /**
     * The aim of this test is to test that:
     *
     * 1) The facade's method getBands makes a call to the BandService's method getBands
     *
     * 2) The facade then correctly wraps BandModels that are returned to it from the BandService's getBands into Data
     * Transfer Objects of type BandData.
     */
    @Test
    public void testGetAllBands()
    {
        /**
         * We instantiate an object that we would like to be returned to BandFacade when the mocked out BandService's
         * method getBands is called. This will be a list of two BandModels.
         */
        final List<BandModel> bands = dummyDataBandList();
        // create test band for the assert comparison
        final BandModel band = configTestBand();
        // We tell Mockito we expect BandService's method getBands to be called, and that when it is, bands should be returned
        when(bandService.getBands()).thenReturn(bands);
        /**
         * We now make the call to BandFacade's getBands. If within this method a call is made to BandService's getBands,
         * Mockito will return the bands instance to it. Mockito will also remember that the call was made.
         */
        final List<BandData> dto = bandFacade.getBands();
        // We now check that dto is a DTO version of bands..
        Assert.assertNotNull(dto);
        Assert.assertEquals(bands.size(), dto.size());
        Assert.assertEquals(band.getCode(), dto.get(0).getId());
        Assert.assertEquals(band.getName(), dto.get(0).getName());
        Assert.assertEquals(band.getAlbumSales(), dto.get(0).getAlbumsSold());
        Assert.assertEquals(band.getHistory(), dto.get(0).getDescription());
    }
    @Test
    public void testGetBand()
    {
        // create test band
        final BandModel band = configTestBand();
        // We tell Mockito we expect BandService's method getBandForCode to be called, and that when it is, the test band should be returned
        when(bandService.getBandForCode(BAND_CODE)).thenReturn(band);
        final BandData dto = bandFacade.getBand(BAND_CODE);
        // We now check that band is a correct DTO representation of the test band model
        Assert.assertNotNull(dto);
        Assert.assertEquals(band.getCode(), dto.getId());
        Assert.assertEquals(band.getName(), dto.getName());
        Assert.assertEquals(band.getAlbumSales(), dto.getAlbumsSold());
        Assert.assertEquals(band.getHistory(), dto.getDescription());
    }
}
// Hybris123SnippetEnd