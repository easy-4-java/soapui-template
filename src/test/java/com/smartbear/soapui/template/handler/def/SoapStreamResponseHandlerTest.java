package com.smartbear.soapui.template.handler.def;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.types.StringToStringsMap;

public class SoapStreamResponseHandlerTest {

    @Test
    public void shouldReturnByteArrayInputStream() throws SoapUIException {
        byte[] rawData = "<response>data</response>".getBytes();
        Response response = new Response() {
            @Override public String getContentAsString() { return null; }
            @Override public String getContentType() { return "text/xml"; }
            @Override public long getContentLength() { return rawData.length; }
            @Override public Request getRequest() { return null; }
            @Override public String getRequestContent() { return null; }
            @Override public long getTimeTaken() { return 0; }
            @Override public Attachment[] getAttachments() { return new Attachment[0]; }
            @Override public Attachment[] getAttachmentsForPart(String partName) { return new Attachment[0]; }
            @Override public StringToStringsMap getRequestHeaders() { return new StringToStringsMap(); }
            @Override public StringToStringsMap getResponseHeaders() { return new StringToStringsMap(); }
            @Override public long getTimestamp() { return 0; }
            @Override public byte[] getRawRequestData() { return new byte[0]; }
            @Override public byte[] getRawResponseData() { return rawData; }
            @Override public String getContentAsXml() { return null; }
            @Override public String getProperty(String name) { return null; }
            @Override public void setProperty(String name, String value) {}
            @Override public String[] getPropertyNames() { return new String[0]; }
        };

        SoapStreamResponseHandler handler = new SoapStreamResponseHandler();
        ByteArrayInputStream result = handler.handleResponse(response, SoapVersion.Soap11);
        assertNotNull(result);
        assertTrue(result.available() > 0);
    }
}
