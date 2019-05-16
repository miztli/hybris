package concerttours.setup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@SystemSetup(extension = "concerttours")
public class ConcerttoursCustomSetup
{
    private static final Logger LOG = LoggerFactory.getLogger(ConcerttoursCustomSetup.class);
    private ImportService importService;
    public ImportService getImportService()
    {
        return importService;
    }
    public void setImportService(final ImportService importService)
    {
        this.importService = importService;
    }
    @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
    public boolean putInMyEssentialData()
    {
        LOG.info("Starting custom essential data loading for the Concerttours extension");
        LOG.info("Custom essential data loading for the Concerttours extension completed.");
        return true;
    }
    @SystemSetup(type = SystemSetup.Type.PROJECT)
    public boolean addMyProjectData()
    {
      LOG.info("Starting custom project data loading for the Concerttours extension");      
      impexImport("/impex/concerttours-bands.impex");
      impexImport("/impex/concerttours-bands-en.impex");
      impexImport("/impex/concerttours-bands-de.impex");
      impexImport("/impex/concerttours-yBandTour.impex");
      LOG.info("Custom project data loading for the Concerttours extension completed.");
      return true;
    }    
    protected boolean impexImport(final String filename)
    {
        final String message = "Concerttours impexing [" + filename + "]...";
        try
        {
            LOG.info(message);
            final InputStream resourceAsStream = getClass().getResourceAsStream(filename);
            final ImportConfig importConfig = new ImportConfig();
            importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
            importConfig.setLegacyMode(Boolean.FALSE);
            final ImportResult importResult = getImportService().importData(importConfig);
            if (importResult.isError())
            {
                LOG.error(message + " FAILED");
                return false;
            }
        }
        catch (final Exception e)
        {
            LOG.error(message + " FAILED", e);
            return false;
        }
        return true;
    }
}
