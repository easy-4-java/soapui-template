package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eviware.soapui.impl.settings.SettingsImpl;
import com.eviware.soapui.model.settings.Settings;

public class SoapuiSettingsImplTest {

    @Test
    public void shouldBeExtendsSettingsImpl() {
        assertTrue(SettingsImpl.class.isAssignableFrom(SoapuiSettingsImpl.class));
    }

    @Test
    public void shouldHaveDefaultConstructor() throws Exception {
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl();
        assertNotNull(impl);
    }

    @Test
    public void shouldHaveParentConstructor() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        assertNotNull(impl);
    }

    @Test
    public void shouldHaveSettingsAndParentConstructor() throws Exception {
        SoapuiSettings settings = new SoapuiSettings();
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(settings, parent);
        assertNotNull(impl);
    }

    @Test
    public void shouldHaveSetProjectSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setProjectSettings(new SoapuiProjectSettings());
    }

    @Test
    public void shouldHaveSetHttpSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setHttpSettings(new SoapuiHttpSettings());
    }

    @Test
    public void shouldHaveSetProxySettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setProxySettings(new SoapuiProxySettings());
    }

    @Test
    public void shouldHaveSetSslSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setSslSettings(new SoapuiSSLSettings());
    }

    @Test
    public void shouldHaveSetWsaSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setWsaSettings(new SoapuiWsaSettings());
    }

    @Test
    public void shouldHaveSetWsdlSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setWsdlSettings(new SoapuiWsdlSettings());
    }

    @Test
    public void shouldHaveSetWsiSettingsMethod() throws Exception {
        Settings parent = new SettingsImpl();
        SoapuiSettingsImpl impl = new SoapuiSettingsImpl(parent);
        impl.setWsiSettings(new SoapuiWSISettings());
    }
}
