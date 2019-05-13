package de.hybris.platform.oauth2.services.impl.test;

import de.hybris.platform.oauth2.constants.OAuth2Constants;
import de.hybris.platform.oauth2.jwt.exceptions.KeyStoreProcessingException;
import de.hybris.platform.oauth2.jwt.util.RsaKeyStoreHelper;
import de.hybris.platform.oauth2.services.HybrisOpenIDTokenServices;
import de.hybris.platform.oauth2.services.OIDCService;
import de.hybris.platform.oauth2.services.impl.DefaultHybrisOpenIDTokenServices;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.webservicescommons.model.OAuthClientDetailsModel;
import de.hybris.platform.webservicescommons.model.OpenIDClientDetailsModel;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.annotation.RegEx;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultOIDCServiceIntegrationTest extends ServicelayerTransactionalTest{

    @Resource
    OIDCService oidcService;

    @Resource
    ModelService modelService;

    private static final String ALIAS = "test1";
    private static final String KEYSTORE_LOCATION = "/test/keystore.jks";
    private static final String PASSWORD = "nimda123";
    ClassPathResource resource;
    RsaKeyStoreHelper keyStoreHelper = new RsaKeyStoreHelper();

    @Test
    public void  testConfiguration()
    {
        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setScheme("https");
        request.setServerName("myserver.sap.corp");
        request.setServerPort(9002);

        final Map<String, Object> configuration = oidcService.getConfiguration(null, request);
        assertThat(configuration.get(OAuth2Constants.OID_TOKEN_SIGNING)).isEqualTo(Arrays.asList(OAuth2Constants.JWKS_VAL_RS256));
        assertThat(configuration.get(OAuth2Constants.OID_SCOPES_SUPPORTED)).isEqualTo(Arrays.asList("openid", "email", "groups"));
        assertThat(configuration.get(OAuth2Constants.OID_RESPONSE_TYPES)).isEqualTo(Arrays.asList("code", "code id_token", "id_token", "token id_token"));
        assertThat(configuration.get(OAuth2Constants.OID_SUBJECT_TYPES)).isEqualTo(Collections.singletonList("public"));
        assertThat(configuration.get(OAuth2Constants.OID_TOKEN_ENDPOINT_AUTH_METHODS)).isEqualTo(Arrays.asList("client_secret_post", "client_secret_basic"));
        assertThat(configuration.get(OAuth2Constants.OID_JWKS_URI)).isEqualTo("https://myserver.sap.corp:9002/authorizationserver/.well-known/jwks.json");
        assertThat(configuration.get(OAuth2Constants.OID_TOKEN_ENDPOINT)).isEqualTo("https://myserver.sap.corp:9002/authorizationserver/oauth/token");
        assertThat(configuration.get(OAuth2Constants.OID_AUTH_ENDPOINT)).isEqualTo("https://myserver.sap.corp:9002/authorizationserver/oauth/authorize");
        assertThat(configuration.get(OAuth2Constants.OID_ISSUER)).isEqualTo("https://myserver.sap.corp:9002/authorizationserver");
    }

    @Test
    public void  testJWKS()
    {
        final PropertyConfigSwitcher location = new PropertyConfigSwitcher("oauth2.test1.keystore.location");
        location.switchToValue(KEYSTORE_LOCATION);

        final PropertyConfigSwitcher pass = new PropertyConfigSwitcher("oauth2.test1.keystore.password");
        pass.switchToValue(PASSWORD);

        final PropertyConfigSwitcher kid = new PropertyConfigSwitcher("oauth2.test1.kid");
        kid.switchToValue(ALIAS);

        OpenIDClientDetailsModel model = modelService.create(OpenIDClientDetailsModel.class);

        model.setClientId(ALIAS);
        model.setIssuer("EC");
        modelService.save(model);

        final Map<String, List<Map<String, String>>> jwks = oidcService.getJWKS(null, null);

        RSAPublicKey publicKey = null;
        try (final InputStream resourceAsStream = HybrisOpenIDTokenServices.class.getResourceAsStream(KEYSTORE_LOCATION))
        {
            final KeyStore keystore = keyStoreHelper.getKeyStore(RsaKeyStoreHelper.DEFAULT_INSTANCE_TYPE, resourceAsStream,
                    PASSWORD);
            publicKey = keyStoreHelper.getPublicKey(keystore, ALIAS);
        }
        catch (final KeyStoreProcessingException e)
        {
            //nothing to do here
        }
        catch (final IOException e)
        {
            //nothing to do here
        }

        assertThat(jwks.get("keys").get(0).get("kty")).isEqualTo("RSA");
        assertThat(jwks.get("keys").get(0).get("use")).isEqualTo("sig");
        assertThat(jwks.get("keys").get(0).get("kid")).isEqualTo("test1");
        assertThat(jwks.get("keys").get(0).get("alg")).isEqualTo("RS256");
        assertThat(jwks.get("keys").get(0).get("n")).isEqualTo(org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(publicKey.getModulus().toByteArray()));
        assertThat(jwks.get("keys").get(0).get("e")).isEqualTo(org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(publicKey.getPublicExponent().toByteArray()));
    }

}
