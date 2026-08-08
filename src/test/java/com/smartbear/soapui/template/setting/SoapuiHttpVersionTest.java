package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SoapuiHttpVersionTest {

    @Test
    public void shouldReturnCorrectVersionString() {
        assertEquals("0.9", SoapuiHttpVersion.HTTP_VERSION_0_9.version());
        assertEquals("1.0", SoapuiHttpVersion.HTTP_VERSION_1_0.version());
        assertEquals("1.1", SoapuiHttpVersion.HTTP_VERSION_1_1.version());
    }

    @Test
    public void shouldContainThreeValues() {
        SoapuiHttpVersion[] values = SoapuiHttpVersion.values();
        assertEquals(3, values.length);
    }

    @Test
    public void shouldResolveFromName() {
        assertEquals(SoapuiHttpVersion.HTTP_VERSION_0_9, SoapuiHttpVersion.valueOf("HTTP_VERSION_0_9"));
        assertEquals(SoapuiHttpVersion.HTTP_VERSION_1_0, SoapuiHttpVersion.valueOf("HTTP_VERSION_1_0"));
        assertEquals(SoapuiHttpVersion.HTTP_VERSION_1_1, SoapuiHttpVersion.valueOf("HTTP_VERSION_1_1"));
    }
}
