package concerttours.service;
import java.util.List;
import concerttours.model.BandModel;

public interface BandService
{
   /**
    * Gets all bands in the system.
    *
    * @return all bands in the system
    */
   List<BandModel> getBands();
   /**
    * Gets the band for the given code.
    *
    * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException
    *            in case more then one band is found for the given code
    * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException
    *            in case no band for the given code can be found
    */
   BandModel getBandForCode(String code);
}
