package com.hybris.hybris123.runtime.helper;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hybris.hybris123.runtime.tests.Hybris123Tests;

public class FileHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(Hybris123Tests.class);
	
	private static boolean STATICVERSION = false;
	
	public  static String getPath(String file) {
		String s = new File(file).getAbsolutePath();
		if (s.lastIndexOf('/')!=-1)
			s = s.substring(0, s.lastIndexOf('/'));
		if (s.lastIndexOf('\\')!=-1)
			s = s.substring(0, s.lastIndexOf('\\'));
		return s;
	}
	public static String getContents(String file) throws IOException {
		if (STATICVERSION){
			if (file.equals("src/main/webapp/resources/impex/essentialdata-bands.impex"))
				return InPlaceContents.essentialdatabandsimpex;
			if (file.equals("src/main/webapp/resources/concerttours/resources/script/essentialdataJobs.impex"))
				return InPlaceContents.essentialdatajobsimpex;
			if (file.equals("src/main/webapp/resources/concerttours/resources/script/groovyjob.script"))
				return InPlaceContents.groovyjobscript.replaceAll("'", "\"");
		}
		String impex = new String(Files.readAllBytes(new File(file).toPath()), ("UTF-8"));		
		impex = impex.replace("\r", ""); 
		return impex;
	}	

	public static String getContentsExcludingPackageAndImports(String file) throws IOException {
		String s = Files.readAllLines(
				Paths.get(new File(file).toURI())).
				stream().
				filter(l -> l.indexOf("package") != 0 && l.indexOf("import") != 0 && l.indexOf("@ManagedBean") != 0).
				reduce("", (x, y) -> x.concat("\n").concat(y));
		
		
		
		// Remove copyright lines
		s = s.replaceAll(" \\* © 2017 SAP SE or an SAP affiliate company.(.*)\n", new File(file).getName());
		s = s.replaceAll(" \\* All rights reserved.(.*)\n",  "");
		s = s.replaceAll(" \\* Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and(.*)\n",  "");
		s = s.replaceAll(" \\* notices.(.*)\n",  "");
		return s;
	}	

	
	public static String getContents(URI fileURI) throws IOException {
		return Files.readAllLines(Paths.get(fileURI)).stream().reduce("", (x, y) -> x.concat("\n").concat(y));
	}
	

	public static boolean directoryExists(String path) {
		LOG.debug("CHECKING IF THIS Directory EXISTS {} {}", new File(path).getPath(), new File(path).exists());
		return new File(path).exists();
	}

	public static boolean fileExists(String f) {
		return fileExistsRecursive(Paths.get("."), f);
	}

	public static File lastModifiedLogFile() {
		String logPath = "./../hybris/log/tomcat";
		File logDir = new File(logPath);
		LOG.debug("lastModifiedLogFile logDir {}", logDir.getAbsolutePath());
		File[] files = logDir.listFiles(f -> f.isFile() && f.getName().startsWith("console")); 
		long lastMod = Long.MIN_VALUE;
		File choice = null;
		for (File file : files) {
			if (file.lastModified() > lastMod) {
				choice = file;
				lastMod = file.lastModified();
			}
		}
		LOG.debug("Reading log file {}", choice);
		return choice;
	}

	public static boolean fileExistsRecursive(Path path, String f) {

		if (f.contains("../")) {
			String right = f.substring(f.indexOf("../") + 3);
			return fileExistsRecursive(path.resolve("../"), right);
		} else if (f.contains("/")) {
			String left = f.substring(0, f.indexOf('/'));
			String right = f.substring(f.indexOf('/') + 1);
			FileFilter fileFilter = new WildcardFileFilter(left);
			File[] files = path.toFile().listFiles(fileFilter);
			boolean candidate = false;
			for (File file : files) {
				if (file.isDirectory())
					candidate = candidate || fileExistsRecursive(file.toPath(), right);
			}
			return candidate;
		} else {
			FileFilter fileFilter = new WildcardFileFilter(f);
			File[] files = path.toFile().listFiles(fileFilter);
			List<File> list = new ArrayList<>(Arrays.asList(files));
			return !list.isEmpty();
		}
	}

	public static boolean fileExistsAndContains(String f, String s) {
		String content;
		try {
			content = new String(Files.readAllBytes(Paths.get(f)));
		} catch (IOException e) {
			return false;
		}
		return content.contains(s);
	}
	

	public static boolean fileContains(String file, String... setOfStrings) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(file)));
		for (String s : setOfStrings) {
			if (!content.contains(s))
				return false;
		}
		return true;
	}
	
	public static String prepareForInsiderQuotes(String s) {
		return s.trim().replaceAll("\"","'").replaceAll("\n", "\\\\n");
	}

	
	public static boolean dirIsNotEmpty(String dir){
		return new File(dir).list().length > 0;

	}
	
	public static boolean dirIsEmpty(String dir){
		return new File(dir).list().length == 0;

	}

}
