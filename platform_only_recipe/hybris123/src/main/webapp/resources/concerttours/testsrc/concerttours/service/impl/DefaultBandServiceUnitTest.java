// Hybris123SnippetStart concerttours.service.impl.DefaultBandServiceUnitTest
/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package concerttours.service.impl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import de.hybris.bootstrap.annotations.UnitTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import concerttours.daos.BandDAO;
import concerttours.model.BandModel;
 
/**
 * This test file tests and demonstrates the behavior of the BandService's methods getAllBand, getBand and saveBand.
 *
 * We already have a separate file for testing the Band DAO, and we do not want this test to implicitly test that in
 * addition to the BandService. This test therefore mocks out the Band DAO leaving us to test the Service in isolation,
 * whose behavior should be simply to wraps calls to the DAO: forward calls to it, and passing on the results it
 * receives from it.
 */
@UnitTest
public class DefaultBandServiceUnitTest
{
    private DefaultBandService bandService;
    private BandDAO bandDAO;
    private BandModel bandModel;
    /** Name of test band. */
    private static final String BAND_CODE = "Ch00X";
    /** Name of test band. */
    private static final String BAND_NAME = "Singers All";
    /** History of test band. */
    private static final String BAND_HISTORY = "Medieval choir formed in 2001, based in Munich famous for authentic monastic chants";
    @Before
    public void setUp()
    {
        // We will be testing BandServiceImpl - an implementation of BandService
        bandService = new DefaultBandService();
        // So as not to implicitly also test the DAO, we will mock out the DAO using Mockito
        bandDAO = mock(BandDAO.class);
        // and inject this mocked DAO into the BandService
        bandService.setBandDAO(bandDAO);
        // This instance of a BandModel will be used by the tests
        bandModel = new BandModel();
        bandModel.setCode(BAND_CODE);
        bandModel.setName(BAND_NAME);
        bandModel.setAlbumSales(null);
        bandModel.setHistory(BAND_HISTORY);
    }
    /**
     * This test tests and demonstrates that the Service's getAllBands method calls the DAOs' getBands method and returns
     * the data it receives from it.
     */
    @Test
    public void testGetAllBands()
    {
        // We construct the data we would like the mocked out DAO to return when called
        final List<BandModel> bandModels = Arrays.asList(bandModel);
        //Use Mockito and compare results
        when(bandDAO.findBands()).thenReturn(bandModels);
        // Now we make the call to BandService's getBands() which we expect to call the DAOs' findBands() method
        final List<BandModel> result = bandService.getBands();
        // We then verify that the results returned from the service match those returned by the mocked-out DAO
        assertEquals("We should find one", 1, result.size());
        assertEquals("And should equals what the mock returned", bandModel, result.get(0));
    }
    @Test
    public void testGetBand()
    {
        // Tell Mockito we expect a call to the DAO's getBand(), and, if it occurs, Mockito should return BandModel instance
        when(bandDAO.findBandsByCode(BAND_CODE)).thenReturn(Collections.singletonList(bandModel));
        // We make the call to the Service's getBandForCode() which we expect to call the DAO's findBandsByCode()
        final BandModel result = bandService.getBandForCode(BAND_CODE);
        // We then verify that the result returned from the Service is the same as that returned from the DAO
        assertEquals("Band should equals() what the mock returned", bandModel, result);
    }
}
//Hybris123SnippetEnd