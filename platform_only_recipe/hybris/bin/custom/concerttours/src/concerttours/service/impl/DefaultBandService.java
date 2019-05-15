package concerttours.service.impl;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import concerttours.daos.BandDAO;
import concerttours.model.BandModel;
import concerttours.service.BandService;
 
public class DefaultBandService implements BandService
{
    private BandDAO bandDAO;
    /**
     * Gets all bands by delegating to {@link BandDAO#findBands()}.
     */
    @Override
    public List<BandModel> getBands()
    {
        return bandDAO.findBands();
    }
    /**
     * Gets all bands for given code by delegating to {@link BandDAO#findBandsByCode(String)} and then assuring
     * uniqueness of result.
     */
    @Override
    public BandModel getBandForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
    {
        final List<BandModel> result = bandDAO.findBandsByCode(code);
        if (result.isEmpty())
        {
            throw new UnknownIdentifierException("Band with code '" + code + "' not found!");
        }
        else if (result.size() > 1)
        {
            throw new AmbiguousIdentifierException("Band code '" + code + "' is not unique, " + result.size() + " bands found!");
        }
        return result.get(0);
    }
    @Required
    public void setBandDAO(final BandDAO bandDAO)
    {
        this.bandDAO = bandDAO;
    }
}

