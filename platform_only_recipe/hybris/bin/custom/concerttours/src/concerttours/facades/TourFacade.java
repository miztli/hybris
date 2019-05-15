package concerttours.facades;
import concerttours.data.TourData;
 
public interface TourFacade
{
    TourData getTourDetails(final String tourId);
}
