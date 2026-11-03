package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eviware.soapui.impl.settings.SettingsImpl;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.settings.HttpSettings;
import com.eviware.soapui.settings.ProjectSettings;
import com.eviware.soapui.settings.ProxySettings;
import com.eviware.soapui.settings.SSLSettings;
import com.eviware.soapui.settings.WSISettings;
import com.eviware.soapui.settings.WsaSettings;
import com.eviware.soapui.settings.WsdlSettings;

public class SoapuiSettingsImplTest {

    @Test
    public void shouldBeExtendsSettingsImpl() {
        assertTrue(SettingsImpl.class.isAssignableFrom(SoapuiSettingsImpl.class));
    }

    @Test
    public void shouldHaveDefaultConstructor() throws Exception {
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl();
        assertNotNull(impl);
    }

    @Test
    public void shouldHaveParentConstructor() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        assertNotNull(impl);
    }

    @Test
    public void shouldHaveSettingsAndParentConstructor() throws Exception {
        SoapuiSettings settings = new SoapuiSettings();
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(settings, parent);
        assertNotNull(impl);
    }

    @Test
    public void shouldHaveSetProjectSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setProjectSettings(new SoapuiProjectSettings());
    }

    @Test
    public void shouldHaveSetHttpSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setHttpSettings(new SoapuiHttpSettings());
    }

    @Test
    public void shouldHaveSetProxySettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setProxySettings(new SoapuiProxySettings());
    }

    @Test
    public void shouldHaveSetSslSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setSslSettings(new SoapuiSSLSettings());
    }

    @Test
    public void shouldHaveSetWsaSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setWsaSettings(new SoapuiWsaSettings());
    }

    @Test
    public void shouldHaveSetWsdlSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setWsdlSettings(new SoapuiWsdlSettings());
    }

    @Test
    public void shouldHaveSetWsiSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setWsiSettings(new SoapuiWSISettings());
    }

    @Test
    public void appliesDefaultsForAbsentSettingsAndNormalizesLegacyHttp() {
        SoapuiSettingsImpl settings = new SoapuiSettingsImpl();
        settings.setString(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_0_9);

        settings.setProjectSettings(null);
        settings.setHttpSettings(null);
        settings.setProxySettings(null);
        settings.setWsaSettings(null);
        settings.setWsdlSettings(null);
        settings.setWsiSettings(null);

        assertEquals(HttpSettings.HTTP_VERSION_1_1, settings.getString(HttpSettings.HTTP_VERSION, null));
        assertEquals(2000L, settings.getLong(HttpSettings.MAX_TOTAL_CONNECTIONS, -1));
        assertEquals(Project.SOAPUI_NATURE_ID, settings.getString(ProjectSettings.PROJECT_NATURE, null));
        assertFalse(settings.getBoolean(ProxySettings.AUTO_PROXY, true));
        assertFalse(settings.getBoolean(ProxySettings.ENABLE_PROXY, true));
        assertTrue(settings.getBoolean(WsaSettings.USE_DEFAULT_RELATES_TO, false));
        assertTrue(settings.getBoolean(WsdlSettings.CACHE_WSDLS, false));
        assertNotNull(settings.getString(WSISettings.WSI_LOCATION, null));
    }

    @Test
    public void copiesCompleteSslConfigurationWithoutOpeningStores() {
        SoapuiSettingsImpl settings = new SoapuiSettingsImpl();
        SoapuiSSLSettings ssl = new SoapuiSSLSettings();
        ssl.setNeedClientAuthentication(true);
        ssl.setKeyStore("client.p12");
        ssl.setKeyStorePassword("client-test-password");
        ssl.setEnableMockSSL(true);
        ssl.setMockPort(8443);
        ssl.setMockPassword("mock-test-password");
        ssl.setMockKeyStore("mock.p12");
        ssl.setMockKeyStorePassword("mock-store-password");
        ssl.setMockTrustStore("trust.p12");
        ssl.setMockTrustStorePassword("trust-store-password");

        settings.setSslSettings(ssl);

        assertTrue(settings.getBoolean(SSLSettings.CLIENT_AUTHENTICATION, false));
        assertEquals("client.p12", settings.getString(SSLSettings.KEYSTORE, null));
        assertEquals("client-test-password", settings.getString(SSLSettings.KEYSTORE_PASSWORD, null));
        assertTrue(settings.getBoolean(SSLSettings.ENABLE_MOCK_SSL, false));
        assertEquals(8443L, settings.getLong(SSLSettings.MOCK_PORT, -1));
        assertEquals("mock.p12", settings.getString(SSLSettings.MOCK_KEYSTORE, null));
        assertEquals("trust.p12", settings.getString(SSLSettings.MOCK_TRUSTSTORE, null));
    }
}
