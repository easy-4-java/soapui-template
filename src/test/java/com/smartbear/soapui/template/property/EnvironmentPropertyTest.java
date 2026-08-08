package com.smartbear.soapui.template.property;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class EnvironmentPropertyTest {

    private EnvironmentProperty envProperty;

    @Before
    public void setUp() {
        envProperty = new EnvironmentProperty();
    }

    @Test
    public void shouldHaveNullNameByDefault() {
        assertNull(envProperty.getName());
    }

    @Test
    public void shouldSetAndGetName() {
        envProperty.setName("production");
        assertEquals("production", envProperty.getName());
    }

    @Test
    public void shouldHaveDefaultSettingsNotNull() {
        assertNotNull(envProperty.getSettings());
        assertTrue(envProperty.getSettings().isEmpty());
    }

    @Test
    public void shouldSetAndGetSettings() {
        Properties props = new Properties();
        props.setProperty("key1", "value1");
        envProperty.setSettings(props);
        assertEquals("value1", envProperty.getSettings().getProperty("key1"));
    }

    @Test
    public void shouldReplaceSettings() {
        Properties props1 = new Properties();
        props1.setProperty("a", "1");
        envProperty.setSettings(props1);

        Properties props2 = new Properties();
        props2.setProperty("b", "2");
        envProperty.setSettings(props2);

        assertNull(envProperty.getSettings().getProperty("a"));
        assertEquals("2", envProperty.getSettings().getProperty("b"));
    }
}
