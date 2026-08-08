package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoapuiWSISettingsTest {

    private SoapuiWSISettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiWSISettings();
    }

    @Test
    public void shouldHaveDefaultVerboseFalse() {
        assertFalse(settings.isVerbose());
    }

    @Test
    public void shouldSetAndGetVerbose() {
        settings.setVerbose(true);
        assertTrue(settings.isVerbose());
    }

    @Test
    public void shouldHaveDefaultProfileTypeBasicProfile10Tad() {
        assertEquals(SoapuiWSISettings.SoapuiProfileType.BASIC_PROFILE_10_TAD, settings.getProfileType());
    }

    @Test
    public void shouldSetAndGetProfileType() {
        settings.setProfileType(SoapuiWSISettings.SoapuiProfileType.BASICf_PROFILE_11_TAD);
        assertEquals(SoapuiWSISettings.SoapuiProfileType.BASICf_PROFILE_11_TAD, settings.getProfileType());
    }

    @Test
    public void shouldProfileTypeReturnCorrectValue() {
        assertNotNull(SoapuiWSISettings.SoapuiProfileType.BASIC_PROFILE_10_TAD.value());
        assertNotNull(SoapuiWSISettings.SoapuiProfileType.BASICf_PROFILE_11_TAD.value());
    }

    @Test
    public void shouldHaveDefaultCorrelationTypeEndpoint() {
        assertEquals(SoapuiWSISettings.SoapuiCorrelationType.ENDPOINT, settings.getCorrelationType());
    }

    @Test
    public void shouldSetAndGetCorrelationType() {
        settings.setCorrelationType(SoapuiWSISettings.SoapuiCorrelationType.NAMESPACE);
        assertEquals(SoapuiWSISettings.SoapuiCorrelationType.NAMESPACE, settings.getCorrelationType());
    }

    @Test
    public void shouldCorrelationTypeReturnCorrectValue() {
        assertNotNull(SoapuiWSISettings.SoapuiCorrelationType.ENDPOINT.value());
        assertNotNull(SoapuiWSISettings.SoapuiCorrelationType.NAMESPACE.value());
        assertNotNull(SoapuiWSISettings.SoapuiCorrelationType.OPERATION.value());
    }

    @Test
    public void shouldHaveDefaultMessageEntryFalse() {
        assertFalse(settings.isMessageEntry());
    }

    @Test
    public void shouldSetAndGetMessageEntry() {
        settings.setMessageEntry(true);
        assertTrue(settings.isMessageEntry());
    }

    @Test
    public void shouldHaveDefaultFailureMessageFalse() {
        assertFalse(settings.isFailureMessage());
    }

    @Test
    public void shouldSetAndGetFailureMessage() {
        settings.setFailureMessage(true);
        assertTrue(settings.isFailureMessage());
    }

    @Test
    public void shouldHaveDefaultAssertionDescriptionFalse() {
        assertFalse(settings.isAssertionDescription());
    }

    @Test
    public void shouldSetAndGetAssertionDescription() {
        settings.setAssertionDescription(true);
        assertTrue(settings.isAssertionDescription());
    }

    @Test
    public void shouldHaveNullLocationByDefault() {
        assertNull(settings.getLocation());
    }

    @Test
    public void shouldSetAndGetLocation() {
        settings.setLocation("/wsi-tools");
        assertEquals("/wsi-tools", settings.getLocation());
    }

    @Test
    public void shouldHaveDefaultShowLogFalse() {
        assertFalse(settings.isShowLog());
    }

    @Test
    public void shouldSetAndGetShowLog() {
        settings.setShowLog(true);
        assertTrue(settings.isShowLog());
    }

    @Test
    public void shouldHaveNullOutputFolderByDefault() {
        assertNull(settings.getOutputFolder());
    }

    @Test
    public void shouldSetAndGetOutputFolder() {
        settings.setOutputFolder("/output");
        assertEquals("/output", settings.getOutputFolder());
    }
}
