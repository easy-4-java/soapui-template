package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoapuiSSLSettingsTest {

    private SoapuiSSLSettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiSSLSettings();
    }

    @Test
    public void shouldHaveNullKeyStoreByDefault() {
        assertNull(settings.getKeyStore());
    }

    @Test
    public void shouldSetAndGetKeyStore() {
        settings.setKeyStore("/path/to/keystore");
        assertEquals("/path/to/keystore", settings.getKeyStore());
    }

    @Test
    public void shouldHaveNullKeyStorePasswordByDefault() {
        assertNull(settings.getKeyStorePassword());
    }

    @Test
    public void shouldSetAndGetKeyStorePassword() {
        settings.setKeyStorePassword("ks-pass");
        assertEquals("ks-pass", settings.getKeyStorePassword());
    }

    @Test
    public void shouldHaveDefaultEnableMockSSLFalse() {
        assertFalse(settings.isEnableMockSSL());
    }

    @Test
    public void shouldSetAndGetEnableMockSSL() {
        settings.setEnableMockSSL(true);
        assertTrue(settings.isEnableMockSSL());
    }

    @Test
    public void shouldHaveDefaultMockPortZero() {
        assertEquals(0, settings.getMockPort());
    }

    @Test
    public void shouldSetAndGetMockPort() {
        settings.setMockPort(8443);
        assertEquals(8443, settings.getMockPort());
    }

    @Test
    public void shouldHaveNullMockKeyStoreByDefault() {
        assertNull(settings.getMockKeyStore());
    }

    @Test
    public void shouldSetAndGetMockKeyStore() {
        settings.setMockKeyStore("/mock/keystore");
        assertEquals("/mock/keystore", settings.getMockKeyStore());
    }

    @Test
    public void shouldHaveNullMockPasswordByDefault() {
        assertNull(settings.getMockPassword());
    }

    @Test
    public void shouldSetAndGetMockPassword() {
        settings.setMockPassword("mock-pass");
        assertEquals("mock-pass", settings.getMockPassword());
    }

    @Test
    public void shouldHaveNullMockKeyStorePasswordByDefault() {
        assertNull(settings.getMockKeyStorePassword());
    }

    @Test
    public void shouldSetAndGetMockKeyStorePassword() {
        settings.setMockKeyStorePassword("mock-ks-pass");
        assertEquals("mock-ks-pass", settings.getMockKeyStorePassword());
    }

    @Test
    public void shouldHaveNullMockTrustStoreByDefault() {
        assertNull(settings.getMockTrustStore());
    }

    @Test
    public void shouldSetAndGetMockTrustStore() {
        settings.setMockTrustStore("/mock/truststore");
        assertEquals("/mock/truststore", settings.getMockTrustStore());
    }

    @Test
    public void shouldHaveNullMockTrustStorePasswordByDefault() {
        assertNull(settings.getMockTrustStorePassword());
    }

    @Test
    public void shouldSetAndGetMockTrustStorePassword() {
        settings.setMockTrustStorePassword("mock-ts-pass");
        assertEquals("mock-ts-pass", settings.getMockTrustStorePassword());
    }

    @Test
    public void shouldHaveDefaultNeedClientAuthenticationFalse() {
        assertFalse(settings.isNeedClientAuthentication());
    }

    @Test
    public void shouldSetAndGetNeedClientAuthentication() {
        settings.setNeedClientAuthentication(true);
        assertTrue(settings.isNeedClientAuthentication());
    }
}
