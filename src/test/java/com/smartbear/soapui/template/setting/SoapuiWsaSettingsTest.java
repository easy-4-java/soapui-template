package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoapuiWsaSettingsTest {

    private SoapuiWsaSettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiWsaSettings();
    }

    @Test
    public void shouldHaveDefaultSoapActionOverridesWsaActionFalse() {
        assertFalse(settings.isSoapActionOverridesWsaAction());
    }

    @Test
    public void shouldSetAndGetSoapActionOverridesWsaAction() {
        settings.setSoapActionOverridesWsaAction(true);
        assertTrue(settings.isSoapActionOverridesWsaAction());
    }

    @Test
    public void shouldHaveDefaultUseDefaultRelationshipTypeTrue() {
        assertTrue(settings.isUseDefaultRelationshipType());
    }

    @Test
    public void shouldSetAndGetUseDefaultRelationshipType() {
        settings.setUseDefaultRelationshipType(false);
        assertFalse(settings.isUseDefaultRelationshipType());
    }

    @Test
    public void shouldHaveDefaultUseDefaultRelatesToTrue() {
        assertTrue(settings.isUseDefaultRelatesTo());
    }

    @Test
    public void shouldSetAndGetUseDefaultRelatesTo() {
        settings.setUseDefaultRelatesTo(false);
        assertFalse(settings.isUseDefaultRelatesTo());
    }

    @Test
    public void shouldHaveDefaultOverrideExistingHeadersFalse() {
        assertFalse(settings.isOverrideExistingHeaders());
    }

    @Test
    public void shouldSetAndGetOverrideExistingHeaders() {
        settings.setOverrideExistingHeaders(true);
        assertTrue(settings.isOverrideExistingHeaders());
    }

    @Test
    public void shouldHaveDefaultEnableForOptionalFalse() {
        assertFalse(settings.isEnableForOptional());
    }

    @Test
    public void shouldSetAndGetEnableForOptional() {
        settings.setEnableForOptional(true);
        assertTrue(settings.isEnableForOptional());
    }
}
