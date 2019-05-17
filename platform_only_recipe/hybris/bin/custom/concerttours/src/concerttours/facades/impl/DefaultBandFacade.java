package concerttours.facades.impl;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
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
   public  static final String BAND_LIST_FORMAT = "band.list.format.name";
   private static final String BAND_DETAIL_FORMAT = "band.detail.format.name";
   private BandService bandService;
   private MediaService mediaService;
   private ConfigurationService configService;
   @Override
   public List<BandData> getBands()
   {
      final List<BandModel> bandModels = bandService.getBands();
      final List<BandData> bandFacadeData = new ArrayList<>();
      if (bandModels!=null && !bandModels.isEmpty()) //6.2
      {
         final String mediaFormatName = configService.getConfiguration().getString(BAND_LIST_FORMAT);
        System.out.println("mediaFormatName:"+mediaFormatName);
        final MediaFormatModel format = mediaService.getFormat(mediaFormatName);
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
      // Create a list of TourSummaryData
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
      final String mediaFormatName = configService.getConfiguration().getString(BAND_DETAIL_FORMAT);
      final MediaFormatModel format = mediaService.getFormat(mediaFormatName);
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
 
   @Required
   public void setConfigurationService(final ConfigurationService configService)
   {
      this.configService = configService;
   }
}
