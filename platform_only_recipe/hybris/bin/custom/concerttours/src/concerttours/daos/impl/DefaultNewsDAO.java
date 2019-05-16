package concerttours.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import concerttours.daos.NewsDAO;
import concerttours.model.NewsModel;

@Component(value = "newsDAO")
public class DefaultNewsDAO implements NewsDAO
{
   private static final String SQL_DATE_FORMAT = "yyyy-MM-dd";
   @Autowired
   private FlexibleSearchService flexibleSearchService;
   @Override
   public List<NewsModel> getNewsOfTheDay(final Date date)
   {
       if (date == null)
       {
           return Collections.emptyList();
       }
       final String theDay = new SimpleDateFormat(SQL_DATE_FORMAT).format(date);
       final String theNextDay = new SimpleDateFormat(SQL_DATE_FORMAT).format(oneDayAfter(date));
       final String queryString = //
               "SELECT {p:" + NewsModel.PK + "} "//
                       + "FROM {" + NewsModel._TYPECODE + " AS p} " //
                       + "WHERE {date} >= DATE \'" + theDay + "\' "//
                       + "AND {date} <= DATE \'" + theNextDay + "\'";
       final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
       return flexibleSearchService.<NewsModel> search(query).getResult();
   }
   private Date oneDayAfter(final Date date)
   {
       final Calendar cal = Calendar.getInstance();
       cal.setTime(date);
       cal.add(Calendar.DATE, 1);
       return cal.getTime();
   }
}
