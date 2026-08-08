package com.smartbear.soapui.template.handler.def;

import static org.junit.Assert.*;

import org.junit.Test;

public class SoapRequestMapParamHandlerTest {

    @Test
    public void shouldImplementSoapRequestHandlerInterface() {
        SoapRequestMapParamHandler handler = new SoapRequestMapParamHandler();
        assertTrue(handler instanceof com.smartbear.soapui.template.handler.SoapRequestHandler);
    }
}
