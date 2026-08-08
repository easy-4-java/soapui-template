package com.smartbear.soapui.template.handler.def;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.types.StringToStringsMap;

public class SoapPlaintextResponseHandlerTest {

    @Test
    public void shouldReturnContentAsString() throws SoapUIException {
        Response response = new Response() {
            @Override public String getContentAsString() { return "plain text response"; }
            @Override public String getContentType() { return "text/plain"; }
            @Override public long getContentLength() { return 17; }
            @Override public Request getRequest() { return null; }
            @Override public String getRequestContent() { return null; }
            @Override public long getTimeTaken() { return 0; }
            @Override public Attachment[] getAttachments() { return new Attachment[0]; }
            @Override public Attachment[] getAttachmentsForPart(String partName) { return new Attachment[0]; }
            @Override public StringToStringsMap getRequestHeaders() { return new StringToStringsMap(); }
            @Override public StringToStringsMap getResponseHeaders() { return new StringToStringsMap(); }
            @Override public long getTimestamp() { return 0; }
            @Override public byte[] getRawRequestData() { return new byte[0]; }
            @Override public byte[] getRawResponseData() { return new byte[0]; }
            @Override public String getContentAsXml() { return null; }
            @Override public String getProperty(String name) { return null; }
            @Override public void setProperty(String name, String value) {}
            @Override public String[] getPropertyNames() { return new String[0]; }
        };

        SoapPlaintextResponseHandler handler = new SoapPlaintextResponseHandler();
        String result = handler.handleResponse(response, SoapVersion.Soap11);
        assertEquals("plain text response", result);
    }
}
