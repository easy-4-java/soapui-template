package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eviware.soapui.support.types.StringList;

public class SoapuiWsdlSettingsTest {

    private SoapuiWsdlSettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiWsdlSettings();
    }

    @Test
    public void shouldHaveDefaultCacheWsdlsTrue() {
        assertTrue(settings.isCacheWsdls());
    }

    @Test
    public void shouldSetAndGetCacheWsdls() {
        settings.setCacheWsdls(false);
        assertFalse(settings.isCacheWsdls());
    }

    @Test
    public void shouldHaveDefaultXmlGenerationTypeExampleValueFalse() {
        assertFalse(settings.isXmlGenerationTypeExampleValue());
    }

    @Test
    public void shouldSetAndGetXmlGenerationTypeExampleValue() {
        settings.setXmlGenerationTypeExampleValue(true);
        assertTrue(settings.isXmlGenerationTypeExampleValue());
    }

    @Test
    public void shouldHaveDefaultXmlGenerationTypeCommentValueFalse() {
        assertFalse(settings.isXmlGenerationTypeCommentValue());
    }

    @Test
    public void shouldSetAndGetXmlGenerationTypeCommentValue() {
        settings.setXmlGenerationTypeCommentValue(true);
        assertTrue(settings.isXmlGenerationTypeCommentValue());
    }

    @Test
    public void shouldHaveDefaultXmlGenerationAlwaysIncludeOptionalElementsTrue() {
        assertTrue(settings.isXmlGenerationAlwaysIncludeOptionalElements());
    }

    @Test
    public void shouldSetAndGetXmlGenerationAlwaysIncludeOptionalElements() {
        settings.setXmlGenerationAlwaysIncludeOptionalElements(false);
        assertFalse(settings.isXmlGenerationAlwaysIncludeOptionalElements());
    }

    @Test
    public void shouldHaveDefaultPrettyPrintResponseXmlTrue() {
        assertTrue(settings.isPrettyPrintResponseXml());
    }

    @Test
    public void shouldSetAndGetPrettyPrintResponseXml() {
        settings.setPrettyPrintResponseXml(false);
        assertFalse(settings.isPrettyPrintResponseXml());
    }

    @Test
    public void shouldHaveDefaultAttachmentPartsTrue() {
        assertTrue(settings.isAttachmentParts());
    }

    @Test
    public void shouldSetAndGetAttachmentParts() {
        settings.setAttachmentParts(false);
        assertFalse(settings.isAttachmentParts());
    }

    @Test
    public void shouldHaveDefaultAllowIncorrectContenttypeTrue() {
        assertTrue(settings.isAllowIncorrectContenttype());
    }

    @Test
    public void shouldSetAndGetAllowIncorrectContenttype() {
        settings.setAllowIncorrectContenttype(false);
        assertFalse(settings.isAllowIncorrectContenttype());
    }

    @Test
    public void shouldHaveDefaultEnableMtomFalse() {
        assertFalse(settings.isEnableMtom());
    }

    @Test
    public void shouldSetAndGetEnableMtom() {
        settings.setEnableMtom(true);
        assertTrue(settings.isEnableMtom());
    }

    @Test
    public void shouldHaveNullSchemaDirectoryByDefault() {
        assertNull(settings.getSchemaDirectory());
    }

    @Test
    public void shouldSetAndGetSchemaDirectory() {
        settings.setSchemaDirectory("/schemas");
        assertEquals("/schemas", settings.getSchemaDirectory());
    }

    @Test
    public void shouldHaveDefaultNameWithBindingTrue() {
        assertTrue(settings.isNameWithBinding());
    }

    @Test
    public void shouldSetAndGetNameWithBinding() {
        settings.setNameWithBinding(false);
        assertFalse(settings.isNameWithBinding());
    }

    @Test
    public void shouldHaveNullExcludedTypesByDefault() {
        assertNull(settings.getExcludedTypes());
    }

    @Test
    public void shouldSetAndGetExcludedTypes() {
        StringList types = new StringList();
        types.add("type1");
        settings.setExcludedTypes(types);
        assertEquals(1, settings.getExcludedTypes().size());
    }

    @Test
    public void shouldHaveNullStrictSchemaTypesByDefault() {
        assertNull(settings.getStrictSchemaTypes());
    }

    @Test
    public void shouldSetAndGetStrictSchemaTypes() {
        StringList types = new StringList();
        types.add("strict1");
        settings.setStrictSchemaTypes(types);
        assertEquals(1, settings.getStrictSchemaTypes().size());
    }

    @Test
    public void shouldHaveDefaultCompressionLimitZero() {
        assertEquals(0, settings.getCompressionLimit());
    }

    @Test
    public void shouldSetAndGetCompressionLimit() {
        settings.setCompressionLimit(1024);
        assertEquals(1024, settings.getCompressionLimit());
    }

    @Test
    public void shouldHaveDefaultPrettyPrintProjectFilesFalse() {
        assertFalse(settings.isPrettyPrintProjectFiles());
    }

    @Test
    public void shouldSetAndGetPrettyPrintProjectFiles() {
        settings.setPrettyPrintProjectFiles(true);
        assertTrue(settings.isPrettyPrintProjectFiles());
    }

    @Test
    public void shouldHaveDefaultXmlGenerationSkipCommentsFalse() {
        assertFalse(settings.isXmlGenerationSkipComments());
    }

    @Test
    public void shouldSetAndGetXmlGenerationSkipComments() {
        settings.setXmlGenerationSkipComments(true);
        assertTrue(settings.isXmlGenerationSkipComments());
    }

    @Test
    public void shouldHaveDefaultTrimWsdlFalse() {
        assertFalse(settings.isTrimWsdl());
    }

    @Test
    public void shouldSetAndGetTrimWsdl() {
        settings.setTrimWsdl(true);
        assertTrue(settings.isTrimWsdl());
    }
}
