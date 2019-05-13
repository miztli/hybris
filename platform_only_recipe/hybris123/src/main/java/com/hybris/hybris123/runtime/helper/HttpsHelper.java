package com.hybris.hybris123.runtime.helper;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.net.CookieHandler;
import java.net.CookieManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpsHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(HttpsHelper.class);

	public static void allowHttps() {
		try {
		// Create a context that doesn't check certificates.
		SSLContext ssl_ctx = SSLContext.getInstance("TLS");
		TrustManager[] trust_mgr = get_trust_mgr();
		ssl_ctx.init(null, // key manager
				trust_mgr, // trust manager
				new SecureRandom()); // random number generator
		HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
		
		CookieHandler.setDefault(new CookieManager(null, null));
		} catch(Exception e) {
			LOG.error(e.getMessage());
		}

	}

	public static TrustManager[] get_trust_mgr() {
		TrustManager[] certs = new TrustManager[] { new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] certs, String t) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] certs, String t) {
			}
		} };
		return certs;
	}
}
