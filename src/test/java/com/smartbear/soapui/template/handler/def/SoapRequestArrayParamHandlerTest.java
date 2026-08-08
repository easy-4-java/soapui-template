package com.smartbear.soapui.template.handler.def;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.support.SoapUIException;

public class SoapRequestArrayParamHandlerTest {

    @Test
    public void shouldImplementSoapRequestHandlerInterface() {
        SoapRequestArrayParamHandler handler = new SoapRequestArrayParamHandler();
        assertTrue(handler instanceof com.smartbear.soapui.template.handler.SoapRequestHandler);
    }
}
