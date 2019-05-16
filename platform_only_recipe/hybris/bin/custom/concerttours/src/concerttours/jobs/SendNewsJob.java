package concerttours.jobs;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.mail.MailUtils;
import java.util.Date;
import java.util.List;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import concerttours.model.NewsModel;
import concerttours.service.NewsService;
 
public class SendNewsJob extends AbstractJobPerformable<CronJobModel>
{
    private static final Logger LOG = Logger.getLogger(SendNewsJob.class);
    private NewsService newsService;
    public void setNewsService(final NewsService newsService)
    {
        this.newsService = newsService;
    }
    @Override
    public PerformResult perform(final CronJobModel cronJob)
    {
        LOG.info("Sending news mails. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.");
        final List<NewsModel> newsItems = newsService.getNewsOfTheDay(new Date());
        if (newsItems.isEmpty())
        {
            LOG.info("No news items for today, skipping send of ranking mails");
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        }
        final StringBuilder mailContentBuilder = new StringBuilder(2000);
        int index = 1;
        mailContentBuilder.append("Todays news summary:\n\n");
        for (final NewsModel news : newsItems)
        {
            mailContentBuilder.append(index++);
            mailContentBuilder.append(". ");
            mailContentBuilder.append(news.getHeadline());
            mailContentBuilder.append("\n");
            mailContentBuilder.append(news.getContent());
            mailContentBuilder.append("\n\n");
        }
        try
        {
            sendEmail(mailContentBuilder.toString());
        }
        catch (final EmailException e)
        {
            LOG.error("Problem sending new email. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.)");
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
    private void sendEmail(final String message) throws EmailException
    {
        final String subject = "Daily News Summary";
        // get mail service configuration
        final Email email = MailUtils.getPreConfiguredEmail();
        //send message
        email.addTo(Config.getString("news_summary_mailing_address", null));
        email.setSubject(subject);
        email.setMsg(message);
        email.setTLS(true);
        email.send();
        LOG.info(subject);
        LOG.info(message);
    }
}
