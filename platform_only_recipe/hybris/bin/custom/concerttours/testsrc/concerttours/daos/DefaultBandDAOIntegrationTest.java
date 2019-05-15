package concerttours.daos.impl;
import static org.junit.Assert.assertTrue;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import concerttours.daos.BandDAO;
import concerttours.model.BandModel;
 
/**
 * The purpose of this test is to illustrate DAO best practices and behaviour.
 *
 * The DAO logic is factored into a separate POJO. Stepping into these will illustrate how to write and execute
 * FlexibleSearchQueries - the basis on which most hybris DAOs operate.
 */
@IntegrationTest
public class DefaultBandDAOIntegrationTest extends ServicelayerTransactionalTest
{
    /** As this is an integration test, the class (object) being tested gets injected here. */
    @Resource
    private BandDAO bandDAO;
    /** Platform's ModelService used for creation of test data. */
    @Resource
    private ModelService modelService;
    /** Name of test band. */
    private static final String BAND_CODE = "ROCK-11";
    /** Name of test band. */
    private static final String BAND_NAME = "Ladies of Rock";
    /** History of test band. */
    private static final String BAND_HISTORY = "All female rock band formed in Munich in the late 1990s";
    /** Albums sold */
    private static final Long ALBUMS_SOLD = Long.valueOf(1000L);
    @Test
    public void bandDAOTest()
    {
        // check that our test band is not already present in the database
        List<BandModel> bandsByCode = bandDAO.findBandsByCode(BAND_CODE);
        assertTrue("No Band should be returned", bandsByCode.isEmpty());
        // retrieve all bands currently in the database
        List<BandModel> allBands = bandDAO.findBands();
        final int size = allBands.size();
        // add our test band to the database
        final BandModel bandModel = modelService.create(BandModel.class); 
        
        bandModel.setCode(BAND_CODE);
        bandModel.setName(BAND_NAME);
        bandModel.setHistory(BAND_HISTORY);
        bandModel.setAlbumSales(ALBUMS_SOLD);
        modelService.save(bandModel);
        // check we now get one more band back than previously and our test band is in the list
        allBands = bandDAO.findBands();
        Assert.assertEquals(size + 1, allBands.size());
        Assert.assertTrue("band not found", allBands.contains(bandModel));
        // check we can locate our test band by its code
        bandsByCode = bandDAO.findBandsByCode(BAND_CODE);
        Assert.assertEquals("Did not find the Band we just saved", 1, bandsByCode.size());
        Assert.assertEquals("Retrieved Band's code attribute incorrect", BAND_CODE, bandsByCode.get(0).getCode());
        Assert.assertEquals("Retrieved Band's name attribute incorrect", BAND_NAME, bandsByCode.get(0).getName());
        Assert.assertEquals("Retrieved Band's albumSales attribute incorrect", ALBUMS_SOLD, bandsByCode.get(0).getAlbumSales());
        Assert.assertEquals("Retrieved Band's history attribute incorrect", BAND_HISTORY, bandsByCode.get(0).getHistory());
    }
    @Test
    public void testFindBands_EmptyStringParam()
    {
        //calling findBandsByCode() with an empty String - returns no results
        final List<BandModel> bands = bandDAO.findBandsByCode("");
        Assert.assertTrue("No Band should be returned", bands.isEmpty());
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testfindBands_NullParam()
    {
        //calling findBandByCode with null should throw an IllegalArgumentException
        bandDAO.findBandsByCode(null); //method's return value not captured
    }
}
