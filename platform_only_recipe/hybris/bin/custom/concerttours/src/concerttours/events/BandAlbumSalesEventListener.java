package concerttours.events;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import java.util.Date;
import concerttours.model.NewsModel;
 
public class BandAlbumSalesEventListener extends AbstractEventListener<BandAlbumSalesEvent>
{
    private static final String BAND_SALES_HEADLINE = "%s album sales exceed 50000";
    private static final String BAND_SALES_CONTENT = "%s album sales reported as %d";
    private ModelService modelService;
    public ModelService getModelService()
    {
        return modelService;
    }
    public void setModelService(final ModelService modelService)
    {
        this.modelService = modelService;
    }
    @Override
    protected void onEvent(final BandAlbumSalesEvent event)
    {
        if (event != null)
        {
            final String headline = String.format(BAND_SALES_HEADLINE, event.getName());
            final String content = String.format(BAND_SALES_CONTENT, event.getName(), event.getSales());
            final NewsModel news = modelService.create(NewsModel.class);
            news.setDate(new Date());
            news.setHeadline(headline);
            news.setContent(content);
            modelService.save(news);
        }
    }
}
