package com.hybris.mobile.lib.commerce.helper;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public interface SSLHelper {

    SSLSocketFactory getSSLSocketFactory();

    HostnameVerifier getHostnameVerifier();
}
