package concerttours.events;
import de.hybris.platform.servicelayer.event.events.AfterItemCreationEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import java.util.Date;
import concerttours.model.BandModel;
import concerttours.model.NewsModel;
 
public class NewBandEventListener extends AbstractEventListener<AfterItemCreationEvent>
{
    private static final String NEW_BAND_HEADLINE = "New band, %s";
    private static final String NEW_BAND_CONTENT = "There is a new band in town called, %s. Tour news to be announced soon.";
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
    protected void onEvent(final AfterItemCreationEvent event)
    {
        if (event != null && event.getSource() != null)
        {
            final Object object = modelService.get(event.getSource());
            if (object instanceof BandModel)
            {
                final BandModel band = (BandModel) object;
                final String headline = String.format(NEW_BAND_HEADLINE, band.getName());
                final String content = String.format(NEW_BAND_CONTENT, band.getName());
                final NewsModel news = modelService.create(NewsModel.class);
                news.setDate(new Date());
                news.setHeadline(headline);
                news.setContent(content);
                modelService.save(news);
            }
        }
    }
}
