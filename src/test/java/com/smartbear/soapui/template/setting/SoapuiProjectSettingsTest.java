package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject.ProjectEncryptionStatus;
import com.eviware.soapui.model.testsuite.TestSuite.TestSuiteRunType;

public class SoapuiProjectSettingsTest {

    private SoapuiProjectSettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiProjectSettings();
    }

    @Test
    public void shouldHaveDefaultAbortOnErrorFalse() {
        assertFalse(settings.isAbortOnError());
    }

    @Test
    public void shouldSetAndGetAbortOnError() {
        settings.setAbortOnError(true);
        assertTrue(settings.isAbortOnError());
    }

    @Test
    public void shouldHaveDefaultCacheDefinitionsFalse() {
        assertFalse(settings.isCacheDefinitions());
    }

    @Test
    public void shouldSetAndGetCacheDefinitions() {
        settings.setCacheDefinitions(true);
        assertTrue(settings.isCacheDefinitions());
    }

    @Test
    public void shouldHaveDefaultName() {
        assertEquals("default-project", settings.getName());
    }

    @Test
    public void shouldSetAndGetName() {
        settings.setName("my-project");
        assertEquals("my-project", settings.getName());
    }

    @Test
    public void shouldHaveNullDescriptionByDefault() {
        assertNull(settings.getDescription());
    }

    @Test
    public void shouldSetAndGetDescription() {
        settings.setDescription("A test project");
        assertEquals("A test project", settings.getDescription());
    }

    @Test
    public void shouldHaveDefaultEncryptionStatusNotEncrypted() {
        assertEquals(ProjectEncryptionStatus.NOT_ENCRYPTED, settings.getEncryptionStatus());
    }

    @Test
    public void shouldSetAndGetEncryptionStatus() {
        settings.setEncryptionStatus(ProjectEncryptionStatus.ENCRYPTED_GOOD_PASSWORD);
        assertEquals(ProjectEncryptionStatus.ENCRYPTED_GOOD_PASSWORD, settings.getEncryptionStatus());
    }

    @Test
    public void shouldHaveDefaultPropertiesNotNull() {
        assertNotNull(settings.getProperties());
        assertTrue(settings.getProperties().isEmpty());
    }

    @Test
    public void shouldSetAndGetProperties() {
        Properties props = new Properties();
        props.setProperty("key", "value");
        settings.setProperties(props);
        assertEquals("value", settings.getProperties().getProperty("key"));
    }

    @Test
    public void shouldHaveNullResourceRootByDefault() {
        assertNull(settings.getResourceRoot());
    }

    @Test
    public void shouldSetAndGetResourceRoot() {
        settings.setResourceRoot("/resources");
        assertEquals("/resources", settings.getResourceRoot());
    }

    @Test
    public void shouldHaveDefaultRunTypeParallel() {
        assertEquals(TestSuiteRunType.PARALLEL, settings.getRunType());
    }

    @Test
    public void shouldSetAndGetRunType() {
        settings.setRunType(TestSuiteRunType.SEQUENTIAL);
        assertEquals(TestSuiteRunType.SEQUENTIAL, settings.getRunType());
    }

    @Test
    public void shouldHaveNullPasswordByDefault() {
        assertNull(settings.getPassword());
    }

    @Test
    public void shouldSetAndGetPassword() {
        settings.setPassword("secret");
        assertEquals("secret", settings.getPassword());
    }

    @Test
    public void shouldHaveNullProjectRootByDefault() {
        assertNull(settings.getProjectRoot());
    }

    @Test
    public void shouldSetAndGetProjectRoot() {
        settings.setProjectRoot("/project");
        assertEquals("/project", settings.getProjectRoot());
    }

    @Test
    public void shouldHaveDefaultProjectNature() {
        assertNotNull(settings.getProjectNature());
    }

    @Test
    public void shouldSetAndGetProjectNature() {
        settings.setProjectNature("custom-nature");
        assertEquals("custom-nature", settings.getProjectNature());
    }

    @Test
    public void shouldHaveDefaultShadowPasswordFalse() {
        assertFalse(settings.isShadowPassword());
    }

    @Test
    public void shouldSetAndGetShadowPassword() {
        settings.setShadowPassword(true);
        assertTrue(settings.isShadowPassword());
    }

    @Test
    public void shouldHaveNullHermesConfigPathByDefault() {
        assertNull(settings.getHermesConfigPath());
    }

    @Test
    public void shouldSetAndGetHermesConfigPath() {
        settings.setHermesConfigPath("/hermes");
        assertEquals("/hermes", settings.getHermesConfigPath());
    }

    @Test
    public void shouldHaveDefaultScriptLanguageGroovy() {
        assertEquals(SoapuiProjectSettings.ScriptLanguage.GROOVY, settings.getScriptLanguage());
    }

    @Test
    public void shouldSetAndGetScriptLanguage() {
        settings.setScriptLanguage(SoapuiProjectSettings.ScriptLanguage.JAVASCRIPT);
        assertEquals(SoapuiProjectSettings.ScriptLanguage.JAVASCRIPT, settings.getScriptLanguage());
    }

    @Test
    public void shouldScriptLanguageEnumReturnCorrectName() {
        assertEquals("Groovy", SoapuiProjectSettings.ScriptLanguage.GROOVY.getName());
        assertEquals("Javascript", SoapuiProjectSettings.ScriptLanguage.JAVASCRIPT.getName());
    }

    @Test
    public void shouldHaveNullScriptAfterLoadByDefault() {
        assertNull(settings.getScriptAfterLoad());
    }

    @Test
    public void shouldSetAndGetScriptAfterLoad() {
        settings.setScriptAfterLoad("println('loaded')");
        assertEquals("println('loaded')", settings.getScriptAfterLoad());
    }

    @Test
    public void shouldHaveNullScriptAfterRunByDefault() {
        assertNull(settings.getScriptAfterRun());
    }

    @Test
    public void shouldSetAndGetScriptAfterRun() {
        settings.setScriptAfterRun("println('after')");
        assertEquals("println('after')", settings.getScriptAfterRun());
    }

    @Test
    public void shouldHaveNullScriptBeforeRunByDefault() {
        assertNull(settings.getScriptBeforeRun());
    }

    @Test
    public void shouldSetAndGetScriptBeforeRun() {
        settings.setScriptBeforeRun("println('before')");
        assertEquals("println('before')", settings.getScriptBeforeRun());
    }

    @Test
    public void shouldHaveNullScriptBeforeSaveByDefault() {
        assertNull(settings.getScriptBeforeSave());
    }

    @Test
    public void shouldSetAndGetScriptBeforeSave() {
        settings.setScriptBeforeSave("println('save')");
        assertEquals("println('save')", settings.getScriptBeforeSave());
    }
}
