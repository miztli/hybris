// Hybris123SnippetStart concerttours.daos.NewsDAO
package concerttours.daos;
import java.util.Date;
import java.util.List;
import concerttours.model.NewsModel;
 
public interface NewsDAO
{
    List<NewsModel> getNewsOfTheDay(Date date);
}
//Hybris123SnippetEnd
