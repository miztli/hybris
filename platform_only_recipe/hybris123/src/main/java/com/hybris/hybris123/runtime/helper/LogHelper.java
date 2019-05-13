package com.hybris.hybris123.runtime.helper;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class LogHelper {
	private static final Logger LOG = LoggerFactory.getLogger(LogHelper.class);

	// TODO do not initialise msSinceLastLogLine with -1
	public static long getMSSinceThisWasLogged(String entry) throws Exception {
		// At present searches the log files - could to better with Mbeans?
		// Search for "Sending news mails"
		// INFO | jvm 1 | main | 2017/05/22 12:15:32.809 | [32mINFO
		// [sendNewsCronJob::de.hybris.platform.servicelayer.internal.jalo.ServicelayerJob]
		// (sendNewsCronJob) [SendNewsJob] Sending news mails
		// Try a few times as it can take time for the log to update		

		int nTries = 5;
		long msSinceLastLogLine = -1;
		for (int i = 0; i < nTries; i++) {	
			File logFile = FileHelper.lastModifiedLogFile();		
			try (Stream<String> stream = Files.lines(logFile.toPath())) {
				msSinceLastLogLine = stream.filter(line -> line.contains(entry))
						.map(LogHelper::getMSSinceGivenDate).reduce((first, second) -> second).orElse(-1L);
				
				LOG.debug("In getMSSinceThisWasLogged {} ms: {}", entry, msSinceLastLogLine);
				if (msSinceLastLogLine != -1)
					 return msSinceLastLogLine; 
			} catch (IOException e) {
				LOG.debug("In getMSSinceThisWasLogged {} IOExn thrown: {}", entry, e.getMessage());
			} catch (Exception e) {
				LOG.debug("In getMSSinceThisWasLogged {} Exn thrown: {}", entry, e.getMessage());
			}
			Thread.sleep(5000);
		}

		return msSinceLastLogLine;
	}
	public static long getMSSinceLastNewsMailsLogged() throws Exception {
		return getMSSinceThisWasLogged("Sending news mails");
	}

	private static long getMSSinceGivenDate(String line) {
		try {
			String time = StringUtils.tokenizeToStringArray(line, "|")[3].trim();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.S");
			Date d1 = formatter.parse(time);
			return new Date().getTime() - d1.getTime();
		} catch (Exception e) {
			return -1;
		}
	}
}
