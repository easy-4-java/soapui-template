package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoapuiProxySettingsTest {

    private SoapuiProxySettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiProxySettings();
    }

    @Test
    public void shouldHaveDefaultAutoProxyFalse() {
        assertFalse(settings.isAutoProxy());
    }

    @Test
    public void shouldSetAndGetAutoProxy() {
        settings.setAutoProxy(true);
        assertTrue(settings.isAutoProxy());
    }

    @Test
    public void shouldHaveDefaultEnableProxyFalse() {
        assertFalse(settings.isEnableProxy());
    }

    @Test
    public void shouldSetAndGetEnableProxy() {
        settings.setEnableProxy(true);
        assertTrue(settings.isEnableProxy());
    }

    @Test
    public void shouldHaveNullHostByDefault() {
        assertNull(settings.getHost());
    }

    @Test
    public void shouldSetAndGetHost() {
        settings.setHost("proxy.example.com");
        assertEquals("proxy.example.com", settings.getHost());
    }

    @Test
    public void shouldHaveDefaultPortZero() {
        assertEquals(0, settings.getPort());
    }

    @Test
    public void shouldSetAndGetPort() {
        settings.setPort(8080);
        assertEquals(8080, settings.getPort());
    }

    @Test
    public void shouldHaveNullUsernameByDefault() {
        assertNull(settings.getUsername());
    }

    @Test
    public void shouldSetAndGetUsername() {
        settings.setUsername("user");
        assertEquals("user", settings.getUsername());
    }

    @Test
    public void shouldHaveNullPasswordByDefault() {
        assertNull(settings.getPassword());
    }

    @Test
    public void shouldSetAndGetPassword() {
        settings.setPassword("pass");
        assertEquals("pass", settings.getPassword());
    }

    @Test
    public void shouldHaveNullExcludesByDefault() {
        assertNull(settings.getExcludes());
    }

    @Test
    public void shouldSetAndGetExcludes() {
        settings.setExcludes("localhost,127.0.0.1");
        assertEquals("localhost,127.0.0.1", settings.getExcludes());
    }
}
