package com.smartbear.soapui.template;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.smartbear.soapui.template.property.EnvironmentProperty;
import com.smartbear.soapui.template.setting.SoapuiSettings;

public class SoapuiPropertiesTest {

    private SoapuiProperties properties;

    @Before
    public void setUp() {
        properties = new SoapuiProperties();
    }

    @Test
    public void shouldHaveDefaultSettingsFile() {
        assertEquals("soapui-settings.xml", properties.getSettingsFile());
    }

    @Test
    public void shouldSetAndGetSettingsFile() {
        properties.setSettingsFile("custom-settings.xml");
        assertEquals("custom-settings.xml", properties.getSettingsFile());
    }

    @Test
    public void shouldHaveDefaultCreateRequestsTrue() {
        assertTrue(properties.isCreateRequests());
    }

    @Test
    public void shouldSetAndGetCreateRequests() {
        properties.setCreateRequests(false);
        assertFalse(properties.isCreateRequests());
    }

    @Test
    public void shouldHaveDefaultTimeout30Seconds() {
        assertEquals(30000L, properties.getTimeout());
    }

    @Test
    public void shouldSetAndGetTimeout() {
        properties.setTimeout(5000L);
        assertEquals(5000L, properties.getTimeout());
    }

    @Test
    public void shouldHaveDefaultMaximumCacheSize100() {
        assertEquals(100L, properties.getMaximumCacheSize());
    }

    @Test
    public void shouldSetAndGetMaximumCacheSize() {
        properties.setMaximumCacheSize(200L);
        assertEquals(200L, properties.getMaximumCacheSize());
    }

    @Test
    public void shouldHaveDefaultCacheDuration60() {
        assertEquals(60L, properties.getCacheDuration());
    }

    @Test
    public void shouldSetAndGetCacheDuration() {
        properties.setCacheDuration(120L);
        assertEquals(120L, properties.getCacheDuration());
    }

    @Test
    public void shouldHaveDefaultEnvNotNull() {
        assertNotNull(properties.getEnv());
    }

    @Test
    public void shouldSetAndGetEnv() {
        EnvironmentProperty env = new EnvironmentProperty();
        env.setName("test-env");
        properties.setEnv(env);
        assertEquals("test-env", properties.getEnv().getName());
    }

    @Test
    public void shouldHaveDefaultSettingsNotNull() {
        assertNotNull(properties.getSettings());
    }

    @Test
    public void shouldSetAndGetSettings() {
        SoapuiSettings settings = new SoapuiSettings();
        properties.setSettings(settings);
        assertSame(settings, properties.getSettings());
    }

    @Test
    public void shouldHaveDefaultSettingsFileConstant() {
        assertEquals("soapui-settings.xml", SoapuiProperties.DEFAULT_SETTINGS_FILE);
    }
}
