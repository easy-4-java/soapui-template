package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoapuiSettingsTest {

    private SoapuiSettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiSettings();
    }

    @Test
    public void shouldHaveDefaultProjectSettingsNotNull() {
        assertNotNull(settings.getProject());
    }

    @Test
    public void shouldSetAndGetProject() {
        SoapuiProjectSettings project = new SoapuiProjectSettings();
        project.setName("test");
        settings.setProject(project);
        assertEquals("test", settings.getProject().getName());
    }

    @Test
    public void shouldHaveDefaultHttpSettingsNotNull() {
        assertNotNull(settings.getHttp());
    }

    @Test
    public void shouldSetAndGetHttp() {
        SoapuiHttpSettings http = new SoapuiHttpSettings();
        http.setSocketTimeout(5000);
        settings.setHttp(http);
        assertEquals(5000, settings.getHttp().getSocketTimeout());
    }

    @Test
    public void shouldHaveDefaultProxySettingsNotNull() {
        assertNotNull(settings.getProxy());
    }

    @Test
    public void shouldSetAndGetProxy() {
        SoapuiProxySettings proxy = new SoapuiProxySettings();
        proxy.setHost("proxy.local");
        settings.setProxy(proxy);
        assertEquals("proxy.local", settings.getProxy().getHost());
    }

    @Test
    public void shouldHaveDefaultSslSettingsNotNull() {
        assertNotNull(settings.getSsl());
    }

    @Test
    public void shouldSetAndGetSsl() {
        SoapuiSSLSettings ssl = new SoapuiSSLSettings();
        ssl.setMockPort(8443);
        settings.setSsl(ssl);
        assertEquals(8443, settings.getSsl().getMockPort());
    }

    @Test
    public void shouldHaveDefaultWsaSettingsNotNull() {
        assertNotNull(settings.getWsa());
    }

    @Test
    public void shouldSetAndGetWsa() {
        SoapuiWsaSettings wsa = new SoapuiWsaSettings();
        wsa.setEnableForOptional(true);
        settings.setWsa(wsa);
        assertTrue(settings.getWsa().isEnableForOptional());
    }

    @Test
    public void shouldHaveDefaultWsdlSettingsNotNull() {
        assertNotNull(settings.getWsdl());
    }

    @Test
    public void shouldSetAndGetWsdl() {
        SoapuiWsdlSettings wsdl = new SoapuiWsdlSettings();
        wsdl.setCacheWsdls(false);
        settings.setWsdl(wsdl);
        assertFalse(settings.getWsdl().isCacheWsdls());
    }

    @Test
    public void shouldHaveDefaultWsiSettingsNotNull() {
        assertNotNull(settings.getWsi());
    }

    @Test
    public void shouldSetAndGetWsi() {
        SoapuiWSISettings wsi = new SoapuiWSISettings();
        wsi.setVerbose(true);
        settings.setWsi(wsi);
        assertTrue(settings.getWsi().isVerbose());
    }
}
