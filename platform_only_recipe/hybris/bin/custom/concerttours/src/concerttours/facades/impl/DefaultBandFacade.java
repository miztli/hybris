package concerttours.facades.impl;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.media.MediaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import concerttours.data.BandData;
import concerttours.data.TourSummaryData;
import concerttours.enums.MusicType;
import concerttours.facades.BandFacade;
import concerttours.model.BandModel;
import concerttours.service.BandService;
import java.util.Locale;

public class DefaultBandFacade implements BandFacade
{
    private BandService bandService;
    private MediaService mediaService;
    @Override
    public List<BandData> getBands()
    {
        final List<BandModel> bandModels = bandService.getBands();
        final List<BandData> bandFacadeData = new ArrayList<>();
        final MediaFormatModel format = mediaService.getFormat("bandList");
        for (final BandModel sm : bandModels)
        {
            final BandData sfd = new BandData();
            sfd.setId(sm.getCode());
            sfd.setName(sm.getName());
            sfd.setDescription(sm.getHistory(Locale.ENGLISH));
            sfd.setAlbumsSold(sm.getAlbumSales());
            sfd.setImageURL(getImageURL(sm, format));
            bandFacadeData.add(sfd);
        }
        return bandFacadeData;
    }
    @Override
    public BandData getBand(final String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Band name cannot be null");
        }
        final BandModel band = bandService.getBandForCode(name);
        if (band == null)
        {
            return null;
        }
        // Create a list of genres
        final List<String> genres = new ArrayList<>();
        if (band.getTypes() != null)
        {
            for (final MusicType musicType : band.getTypes())
            {
                genres.add(musicType.getCode());
            }
        }
        // Create a list of TourSummaryData from the matches
        final List<TourSummaryData> tourHistory = new ArrayList<>();
        if (band.getTours() != null)
        {
            for (final ProductModel tour : band.getTours())
            {
                final TourSummaryData summary = new TourSummaryData();
                summary.setId(tour.getCode());
                summary.setTourName(tour.getName(Locale.ENGLISH));
                // making the big assumption that all variants are concerts and ignore product catalogs
                summary.setNumberOfConcerts(Integer.toString(tour.getVariants().size()));
                tourHistory.add(summary);
            }
        }
        // Now we can create the BandData transfer object
        final MediaFormatModel format = mediaService.getFormat("bandDetail");
        final BandData bandData = new BandData();
        bandData.setId(band.getCode());
        bandData.setName(band.getName());
        bandData.setAlbumsSold(band.getAlbumSales());
        bandData.setImageURL(getImageURL(band, format));
        bandData.setDescription(band.getHistory(Locale.ENGLISH));
        bandData.setGenres(genres);
        bandData.setTours(tourHistory);
        return bandData;
    }
    protected String getImageURL(final BandModel sm, final MediaFormatModel format)
    {
        final MediaContainerModel container = sm.getImage();
        if (container != null)
        {
            return mediaService.getMediaByFormat(container, format).getDownloadURL();
        }
        return null;
    }
    @Required
    public void setBandService(final BandService bandService)
    {
        this.bandService = bandService;
    }
    @Required
    public void setMediaService(final MediaService mediaService)
    {
        this.mediaService = mediaService;
    }
}
